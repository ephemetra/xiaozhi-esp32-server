package com.ephemetra.server.config;

import com.ephemetra.server.client.ManageApiClient;
import com.ephemetra.server.model.pojo.Result;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class ManageApiAutoConfiguration {

    @Bean
    @ConditionalOnProperty("manager-api.url")
    @ConditionalOnMissingBean
    public ManageApiClient manageApiClient(ApplicationContext applicationContext, MainConfig config) {
        return new FeignClientBuilder(applicationContext)
                .forType(ManageApiClient.class, "manager-api")
                .url(config.managerApi.url)
                .customize(builder -> {
                    builder.options(new Request.Options(2, TimeUnit.SECONDS, 5, TimeUnit.SECONDS, false));
                    builder.retryer(new Retryer.Default(500, 3000, 6));
                    builder.requestInterceptor(template -> {
                        template.header("Authorization", "Bearer " + config.managerApi.secret);
                    });
                    builder.decoder((response, type) -> {
                        ObjectMapper mapper = new ObjectMapper();
                        JavaType resultType = mapper.getTypeFactory().constructParametricType(Result.class, mapper.constructType(type));
                        Result<?> result = mapper.readValue(response.body().asInputStream(), resultType);
                        if (result.getCode() != 0) {
                            // 建议在这里打印一条日志，否则线上出问题了你完全不知道为什么返回 null
                            log.warn("ManageApiClient 返回错误, code: {}, msg: {}", result.getCode(), result.getMsg());
                            return null;
                        }
                        return result.getData();
                    });
                })
                .build();
    }
}