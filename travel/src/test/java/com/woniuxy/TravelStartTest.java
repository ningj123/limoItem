package com.woniuxy;

import static org.junit.Assert.assertTrue;

import com.woniuxy.controller.LimoBannerController;
import com.woniuxy.service.LimoBannerService;
import com.woniuxy.util.JSONResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TravelStartTest.class)
public class TravelStartTest {
    @Autowired
    private LimoBannerService limoBannerService;
    @Test
    public void shouldAnswerWithTrue() {

        Object obj=limoBannerService.queryBannerList(2, 2, 0);

        System.out.println(obj.toString());
    }
}
