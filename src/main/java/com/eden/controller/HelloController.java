package com.eden.controller;

import com.eden.service.mq.HelloSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @date 2018/11/1
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    public HelloSend helloSend;

    @RequestMapping("/send")
    public void send(){
        helloSend.send();
    }
}
