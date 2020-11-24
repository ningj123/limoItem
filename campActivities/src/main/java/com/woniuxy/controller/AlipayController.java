package com.woniuxy.controller;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.factory.Factory.Payment;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.woniuxy.config.ZhiFuBaoConfig;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

//@RestController
//@Api(tags = "支付宝沙箱接口")
public class AlipayController {
    @RequestMapping(value = "/pay",produces = "text/html; charset=UTF-8",method= RequestMethod.GET)
    public void pay(int totalAmount, HttpServletResponse response){
        Factory.setOptions(ZhiFuBaoConfig.getOptions());
        String body = null;
        try {
            String totalAmounts = totalAmount+"";
            AlipayTradePagePayResponse pay = Payment.Page().pay("...", UUID.randomUUID().toString(), totalAmounts, ZhiFuBaoConfig.return_url);
            System.out.println(UUID.randomUUID().toString()+"--------------");
            body = pay.getBody();
            PrintWriter writer = response.getWriter();
            String head = "<html><head><meta http-equiv='Content-Type' content='text/html;charset=UTF-8'></head><body>";
            String bottom = "</body></html>";
            response.setContentType("text/html;charset=UTF-8");
            writer.write(head + body + bottom);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return body;
    }

    @PostMapping("notify_url")
    public void Notify(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
            //乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");

            System.out.println(params);
            //调用SDK验证签名
            Boolean signVerified = Payment.Common().verifyNotify(params);
            //验证签名通过
            if(signVerified){
                // 商户订单号
                String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
                // 支付宝交易号
                String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
                // 付款金额
                String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
                String trade_status = new String(request.getParameter("trade_status").getBytes("UTF-8"));
                System.out.println("商户订单号="+out_trade_no);
                System.out.println("支付宝交易号="+trade_no);
                System.out.println("付款金额="+total_amount);
                if (trade_status.equals("TRADE_SUCCESS")){
                    System.out.println("success");
                }
            }
    }

}
