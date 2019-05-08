package com.star.test.controller;

import com.alibaba.fastjson.JSON;
import com.star.test.model.InputDTO;
import com.star.test.service.InetService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private InetService inetService;

    @ApiOperation(value = "hello world", notes = "测试swagger2")
    @RequestMapping(value = "/star", method = RequestMethod.GET)
    public Object tt(@RequestBody @Valid InputDTO inputDTO) {
        System.out.println("请求进入" + inputDTO.getName() + "," + inputDTO.getId());
        return JSON.toJSONString("hellow " + inputDTO.getName());
    }

    @ApiOperation(value = "info", notes = "测试swagger2")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object tt1() throws UnknownHostException {
       return JSON.toJSONString(InetAddress.getLocalHost());
    }

}
