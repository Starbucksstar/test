package com.star.test.util;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static final HttpClient httpClient = new HttpClient();

    public static String sendData(String url, String data) throws IOException {

        PostMethod postMethod = new PostMethod(url);
        int returnCode = 0;
        try {
            postMethod.setRequestEntity(new StringRequestEntity(data, "application/json;charset=UTF-8", "utf-8"));
            returnCode = httpClient.executeMethod(postMethod);
        } catch (UnsupportedEncodingException e) {
            logger.error("编码格式不支持，异常信息={}",e.getMessage(),e);
            return "ERROR";
        } catch (IOException e) {
            logger.error("发送请求异常，异常信息={}",e.getMessage(),e);
            return "ERROR";
        }
        if(returnCode== HttpStatus.SC_OK){
            return StreamUtils.copyToString(postMethod.getResponseBodyAsStream(), Charset.forName("utf-8"));
        }else{
            return String.valueOf(returnCode);
        }

    }


}
