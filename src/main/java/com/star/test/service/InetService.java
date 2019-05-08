package com.star.test.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class InetService {

    /**
     * 获取ip地址
     * @return
     */
    public String getInetInfo(){
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            return JSON.toJSONString("Error");
        }
        return inetAddress.getHostAddress();
    }

    /**
     * 判断ip
     * @param ip
     * @return
     */
    public boolean judgeIpAddress(String ip){
        return true;
    }
}
