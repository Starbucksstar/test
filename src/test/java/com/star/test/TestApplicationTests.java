package com.star.test;

import com.alibaba.fastjson.JSONObject;
import com.star.test.service.InetService;
import com.star.test.util.HttpClientUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

    @Autowired
    private InetService inetService;

    @Test
    public void testIP() {
        Assert.assertEquals("192.168.6.100",inetService.getInetInfo());
    }

    @Test
    public void testEsAdd(){
        Random random = new Random();
        double lat = 40.081145;
        double lan = 113.317359;
        for(int i=0;i<1000;i++){
            if(i%5==0){
                lat=lat-0.01;
                lan = lan-0.01;
            }else{
                lat=lat-0.01;
                lan = lan-0.01;
            }

            JSONObject index = new JSONObject();
            index.put("index","tw");
            JSONObject value = new JSONObject();
            value.put("id",i+123);
            value.put("name","star"+i);
            value.put("sex", random.nextInt(2));
            value.put("age",random.nextInt(100));
            value.put("hometown", String.valueOf(lat).concat(",").concat(String.valueOf(lan)));
            value.put("address","湖北武汉");
            value.put("create_time","1557217266000");
            value.put("update_time","1557217266000");
            index.put("value",value);
            try {
                String data = HttpClientUtil.sendData("http://localhost:8089/es/addData",index.toJSONString());
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
