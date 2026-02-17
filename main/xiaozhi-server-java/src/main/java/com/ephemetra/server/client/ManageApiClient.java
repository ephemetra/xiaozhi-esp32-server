package com.ephemetra.server.client;

/**
 * 用于请求manage-api的客户端
 */
@FeignClient(name = "user-service", url = "http://localhost:8081")
public interface ManageApiClient {


}
