package com.ds.utils;

import com.alibaba.fastjson.JSONObject;
import com.ds.constants.Constants;
import com.ds.domain.DsMessage;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoshengzhen
 * @date 2025-02-26 11:14
 * @desc:
 **/
public class DeepSeekUtils {
@Value("${ds.url}")
private String url;
@Value("${ds.token}")
private String token;
    public static Response sendToDS() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n  \"messages\": [\n    {\n      \"content\": \"You are a helpful assistant\",\n      \"role\": \"system\"\n    },\n    {\n      \"content\": \"Hi\",\n      \"role\": \"user\"\n    }\n  ],\n  \"model\": \"deepseek-chat\",\n  \"frequency_penalty\": 0,\n  \"max_tokens\": 2048,\n  \"presence_penalty\": 0,\n  \"response_format\": {\n    \"type\": \"text\"\n  },\n  \"stop\": null,\n  \"stream\": false,\n  \"stream_options\": null,\n  \"temperature\": 1,\n  \"top_p\": 1,\n  \"tools\": null,\n  \"tool_choice\": \"none\",\n  \"logprobs\": false,\n  \"top_logprobs\": null\n}");
        Request request = new Request.Builder()
                .url("https://api.deepseek.com/chat/completions")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer sk-5f4e77c3ca4b45c1b23406a060439c1d")
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }


    /**
     * 封装DeepSeek消息体
     * @param dsMessage
     * @return
     */
    public static String dsInit(List<DsMessage> dsMessage){
        String body = null;
        Map map = new HashMap();
        map.put("messages",dsMessage);
        map.put("model", Constants.model);
        map.put("frequency_penalty", Constants.frequency_penalty);
        map.put("max_tokens", Constants.max_tokens);
        map.put("presence_penalty", Constants.presence_penalty);
        //response_format
        Map response_format = new HashMap();
        response_format.put("type","text");
        map.put("response_format",response_format);
        map.put("stop", Constants.stop);
        map.put("stream", Constants.stream);
        map.put("temperature", Constants.temperature);
        map.put("top_p", Constants.top_p);
        map.put("tools", Constants.tools);
        map.put("tool_choice", Constants.tool_choice);
        map.put("logprobs", Constants.logprobs);
        map.put("top_logprobs", Constants.top_logprobs);
        body = JSONObject.toJSONString(map);
        System.out.println("ds请求参数："+body);
        return body;
    }

    /**
     * 向DeepSeek发送请求
     * @param msg
     * @return
     * @throws IOException
     */
    public static Response sendToDS(String msg,String url,String token) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, msg);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer sk-5f4e77c3ca4b45c1b23406a060439c1d")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        return response;
    }




}
