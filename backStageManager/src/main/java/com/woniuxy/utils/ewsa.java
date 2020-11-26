package com.woniuxy.utils;

import com.woniuxy.service.LimoAppointService;
import com.woniuxy.service.impl.LimoAppointServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zhuyuli
 * @description: Administrator
 * @date: 2020/11/25 20:05
 */
public class ewsa {


    public static void main(String[] args) throws Exception {
        LimoAppointService service = new LimoAppointServiceImpl();
        List list = service.qurty("2020-11-26 18:00:00", "2020-11-27 14:00:00");

    }
}
