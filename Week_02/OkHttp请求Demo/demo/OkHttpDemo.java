package com.test.bsecond.year2021.month_01.day0122;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * OkHttp请求示例
 */
@Slf4j
public class OkHttpDemo {


    public static void main(String[] args) {

        OkHttpClient httpClient = new OkHttpClient();
        HttpUrl httpUrl = HttpUrl.parse("http://localhost:8080").newBuilder().build();
        // .addQueryParameter("param", param).build();
        Request request = new Request.Builder().url(httpUrl.toString()).build();
        try (Response response = httpClient.newCall(request).execute()) {
            ResponseBody body = response.body();
            if (response.isSuccessful()) {
                String result = null;
                log.info("success:{}", body == null ? "" : (result = body.string()));
                JSONObject jsonObject = JSONObject.parseObject(result);
                Integer code = jsonObject.getInteger("code");
                if (code == null) {
                    return;
                }
                log.info("code:{}", code);
            } else {
                log.error("error,statusCode={},body={}", response.code(), body == null ? "" : body.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
