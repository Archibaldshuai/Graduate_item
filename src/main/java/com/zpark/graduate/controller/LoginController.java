package com.zpark.graduate.controller;

import com.zpark.graduate.common.BaseResult;
import com.zpark.graduate.model.User;
import com.zpark.graduate.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller

public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public  String log(){
        System.out.println("......log");
        return "log.html";

    }

    @RequestMapping("/login.json")
    @ResponseBody  //用于将Controller的方法返回的对象
    public BaseResult recieveDate(@RequestBody Map<String, Object> loginData) {
//        Map<String, Object> map = new HashMap<>();
//        String loginName = loginData.get("loginName").toString();
//        System.out.println(".......controller");
//        return map;

        BaseResult baseResult = new BaseResult();
        String loginName = loginData.get("loginName").toString();
        String loginPwd = loginData.get("loginPwd").toString();
        if (loginName != null) {
            User user = userService.selByName(loginName);
            System.out.println("..........from mysql............" + user);
            if (user.getPassWord().equals(loginPwd)) {
                baseResult.setSuccess(true);
            } else {
                baseResult.setSuccess(false);
            }
        }

        return baseResult;
    }


    @RequestMapping(value = "/admin.html")
    public String test() {
        System.out.println("......admin");
        return "admin.html";
    }

    @RequestMapping(value = "/register.html")
    public String register() {
        System.out.println("......register");
        return "register.html";
    }
    @RequestMapping(value = "/login.html")
    public String login() {
        System.out.println("......login");
        return "login.html";
    }

    @RequestMapping(value = "/index.html")
    public String index() {
        System.out.println("......index");
        return "index.html";
    }
}
