package com.ds.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * @author zhaoshengzhen
 * @date 2025-02-26 14:06
 * @desc:
 **/
@Slf4j
public class test {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"max_tokens\":4096,\"presence_penalty\":0.0,\"logprobs\":false,\"top_p\":1,\"frequency_penalty\":0.0,\"response_format\":{\"type\":\"text\"},\"stream\":false,\"temperature\":1,\"messages\":[{\"content\":\"如何私有化部署DeepSeek\",\"role\":\"user\"}],\"tool_choice\":\"none\",\"model\":\"deepseek-chat\"}");
        Request request = new Request.Builder()
                .url("https://api.deepseek.com/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer sk-5f4e77c3ca4b45c1b23406a060439c1d")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
