package com.ephemetra.server.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FFmpegUtils {

    /**
     * 检查当前环境中是否已正确安装并可执行 ffmpeg。
     *
     * @return true 如果 ffmpeg 正常可用
     * @throws IllegalArgumentException 当检测到 ffmpeg 未安装或依赖缺失时，抛出详细的提示信息
     */
    public static boolean checkFFmpegInstalled() {
        ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-version");
        // 将标准错误流合并到标准输出流，方便统一读取
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            
            // 读取输出内容
            String output;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                output = reader.lines().collect(Collectors.joining("\n")).toLowerCase();
            }

            // 等待进程结束并获取退出状态码
            int exitCode = process.waitFor();

            if (exitCode == 0 && output.contains("ffmpeg version")) {
                return true;
            }

            throw new IllegalArgumentException("未检测到有效的 ffmpeg 版本输出。");

        } catch (IOException | InterruptedException e) {
            String stderrOutput = e.getMessage();
            
            // 构建错误提示
            List<String> errorMsg = new ArrayList<>();
            errorMsg.add("❌ 检测到 ffmpeg 无法正常运行。");
            errorMsg.add("建议您：");
            errorMsg.add("1. 确认已正确激活 conda 环境；");
            errorMsg.add("2. 查阅项目安装文档，了解如何在 conda 环境中安装 ffmpeg。\n");

            // 针对具体错误信息提供额外提示
            if (stderrOutput.contains("libiconv.so.2")) {
                errorMsg.add("⚠️ 发现缺少依赖库：libiconv.so.2");
                errorMsg.add("解决方法：在当前 conda 环境中执行：");
                errorMsg.add("   conda install -c conda-forge libiconv\n");
            } else if (stderrOutput.contains("No such file or directory") || e instanceof IOException) {
                // Java 中找不到文件通常会直接抛出 IOException: Cannot run program "ffmpeg"
                errorMsg.add("⚠️ 系统未找到 ffmpeg 可执行文件。");
                errorMsg.add("解决方法：在当前 conda 环境中执行：");
                errorMsg.add("   conda install -c conda-forge ffmpeg\n");
            } else {
                errorMsg.add("错误详情：");
                errorMsg.add(stderrOutput != null ? stderrOutput : "未知错误。");
            }

            throw new IllegalArgumentException(String.join("\n", errorMsg), e);
        }
    }
}