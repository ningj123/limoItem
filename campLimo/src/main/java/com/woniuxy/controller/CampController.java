package com.woniuxy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("limo/camp")
public class CampController {
    @GetMapping("selectCamps")
    public String test() {
        return "测试";
    }
}
