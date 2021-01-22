package com.test.bsecond.year2021.month_01.day0122.httpUtil;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * okhttp工具类
 * 原文地址: https://blog.csdn.net/qq_34553724/article/details/108837394
 */
public class OkHttp3Util {

    //JSON
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    //标准格式
    private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    
    /**
     * 发送GET
     * @param url 地址
     * @param params 参数
     * @return
     */
    public static String sendGet(String url,Map<String, String> params) {
        OkHttpClient client = new OkHttpClient();
        StringBuilder content = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            content.append(entry.getKey()).append("=").append(entry.getValue());
            if (iterator.hasNext()) {
                content.append("&");
            }
        }
        Request request = new Request.Builder().url(url + ((content.length() > 0) ? "?" + content.toString() : "")).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送POST-JSON
     * @param url 地址
     * @param params 参数
     * @return
     */
    public static String sendPostJSON(String url,Map<String, String> params){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, JSONObject.toJSONString(params));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 发送POST  key-value 
     * @param url
     * @param params
     * @return
     */
    public static String sendPost(String url,Map<String, String> params){
        OkHttpClient client = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            builder.add(key,entry.getValue());
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}