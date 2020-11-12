package com.woniuxy.config;

import java.io.FileWriter;
import com.alipay.easysdk.kernel.Config;

public class ZhiFuBaoConfig {
    /** 商户appid **/
//    public static String APPID = "2016110100783557";
    /** 私钥 pkcs8格式的 **/
//    public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYYlGdIUAzPPPak3k11Bf8LPbPzzzoENcZuXyeoI7gJzN6GiKMRimU17LDr+fTPTrapb+ooFMh+RQoBMDkOAdhice8G+KsxXHMtvUTpalip6ThHzJsuQd9pNJP09ITcyylmJZ227jj7OBx6jcP+cT2vO26X8UCfcq8B5arveS1ZHP9CObcUjoYxzqeRjFYyYTDn9M9TtRW+OIoddLY8xRb1N4KiFNZPdPLUmZrVbvOfRI1cMIxMlGxf/Lv5rB9uX4Mu5SjH0tFChAMjUqyoumxcUuGDIj6DNTMsw2Nl+ZpMLTjuDAPLogtM7wVCK7wOcgIIeB+XKF3pundA6UWiD/1AgMBAAECggEAHW/AvE3UDRHVOYALhi52g6xb8UDjTyERrFJ8lFgHwZ1RAGFUEyzqk2onik3Mxq2pVNt37qcp6AIptqFUccGxC1KGVvw8CYwKs7UUGruBwSEJZMOWBhKoM8lHJ0yP5Fn3YfXb+xHu4Xi80sSf5mIlflR4x+wALr8GDtSYcoy4RaHZm8A3l19InGOhidYcvZYedjkl+yw8qBY8KhgA12zo+9zvavig/l3cABt9KOax901ALFcP8qXQzyx7Oks4bZbVavoI+O/jGUx0qDKDtBs1ejhb5blxKyo6H9/ZKHp9vZ7Cyxk++hdSZaKjfsCu9oqri9Nte1DLBZuRT0lOIWwdcQKBgQDTHqgKerxne9VZuBh6+TSb6DJkVFiT8ScyhR3ny0BkbJzX7/YN0tcN8B2CanpViCUMpdtj1Umbx5tU9hdjhy59XR2OvbNu1YvpuiwK5ujGm1dQ6jb+H2txFeTGbRINEAqSEAhNIVm69nfxZ16vINIHvA9mq4qYjaDHSm5293+Y1wKBgQC4xzVbs7S4kyckfTKDbA+cVVQcuYTGF/MWHL942xwSWv/S0yY12otyV/DsAMdxo56lCIWCZiVN4D3dfrwTcAvz81QtJWI8LdLL4Sh4XLHGHvYvYmECjRMBo61WPvFMxLcnZlSGkndJ/99wYgiEzN1laccQnjMMlhgdA8S2MepYEwKBgA07wrTFdMHX1UvGamJq9I1BRMddMiAz4Y0dIv7Aksy4siwm8nlzWd+ZyX+/ROPPoOLmEpZzbCXDoUz2EAlBE/zvtUaZRYIRCLAh51jXmIe6fQKpa8EKHyX7hVeaxqLi+oalUp/jE0jQ4jvTiu/XUtMBSsXYwttFJWrYk4wJf4oJAoGAH9ZTH0XLcbIJIIRh27sWxXz+TSS599fQjpLNeull4NPFGHJBNy48sKruW/uWYcIrZ4wcVOd8rfphLnTTuxWnOZVHf6/dSTksBOz6qCJwjw5upKNyy5m7GKE3EJEvymZqmGNNVRKPczSfLyH1DcyuqPac0gQwD48dAILRtgLLufkCgYEAkY/lWMYh/6kFJE72MBdPIeHqc7NKSWLOkyzxUevGVlhyevr5+ZhGLEpVhUUoMYKGu/gvq+ArqHa+EDv8gRybmOu5pdidNLSTwTzHW9BH4/+SjLVZCD2YRNadsUIQQ2b9Yw5lbzOe9iaSBMfDDnXQ/i61TXUpZizHthdWz1l5iKQ=";

    /** 支付宝公钥 **/
//    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhyd3z2iLF9KeTXb+IRuk9zPRNvdP9h0TfChVvn/LYLgS7v2lD9e52oD2PxLBAhfXrAw+KwvaPYKhGc36/h03/fx+FX0RQvo+mgvyO/MbEMTSogFBTCVs42Rr0PjvH/2coaYsGhxKqcE7U1qs3XBxaSqzUUibZ38YH2zzacWeIOVC6d9zUR5mUj27cU2V7LhCvytNIakA05V45huDtso3Rtdahsr+6oib9ERJQ33aSjEnTRwFh1xmrOro/vfPK+SXrhvNrXYaLtagjB9PapuxsVJ2m+eZKQL0ZlIsSxgxvRL6bg2c/wCP01jvdV+vj6HPIp5KuNXDfeOnXbfjt1yZ7QIDAQAB";

   /** 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 **/
//    public static String notify_url = "http://3k540070x7.wicp.vip/alipay_trade_wap_pay_java_utf_8_war_exploded/notify_url.jsp";

    /** 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址 **/
    public static String return_url = "http://3k540070x7.wicp.vip/index.html";

    /** 请求网关地址 **/
//    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    /** 编码 **/
//    public static String CHARSET = "UTF-8";
    /** 返回格式 **/
//    public static String FORMAT = "json";
    /** 日志记录目录 **/
//    public static String log_path = "/log";
    /** RSA2 **/
//    public static String SIGNTYPE = "RSA2";


    public static  Config getOptions(){
        Config config = new Config();
        config.protocol = "https";
        config.appId = "2016110100783557";
        config.signType = "RSA2";
        config.gatewayHost = "openapi.alipaydev.com";
        config.alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhyd3z2iLF9KeTXb+IRuk9zPRNvdP9h0TfChVvn/LYLgS7v2lD9e52oD2PxLBAhfXrAw+KwvaPYKhGc36/h03/fx+FX0RQvo+mgvyO/MbEMTSogFBTCVs42Rr0PjvH/2coaYsGhxKqcE7U1qs3XBxaSqzUUibZ38YH2zzacWeIOVC6d9zUR5mUj27cU2V7LhCvytNIakA05V45huDtso3Rtdahsr+6oib9ERJQ33aSjEnTRwFh1xmrOro/vfPK+SXrhvNrXYaLtagjB9PapuxsVJ2m+eZKQL0ZlIsSxgxvRL6bg2c/wCP01jvdV+vj6HPIp5KuNXDfeOnXbfjt1yZ7QIDAQAB";
        config.notifyUrl = "http://3k540070x7.wicp.vip/notify_url";
        config.merchantPrivateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYYlGdIUAzPPPak3k11Bf8LPbPzzzoENcZuXyeoI7gJzN6GiKMRimU17LDr+fTPTrapb+ooFMh+RQoBMDkOAdhice8G+KsxXHMtvUTpalip6ThHzJsuQd9pNJP09ITcyylmJZ227jj7OBx6jcP+cT2vO26X8UCfcq8B5arveS1ZHP9CObcUjoYxzqeRjFYyYTDn9M9TtRW+OIoddLY8xRb1N4KiFNZPdPLUmZrVbvOfRI1cMIxMlGxf/Lv5rB9uX4Mu5SjH0tFChAMjUqyoumxcUuGDIj6DNTMsw2Nl+ZpMLTjuDAPLogtM7wVCK7wOcgIIeB+XKF3pundA6UWiD/1AgMBAAECggEAHW/AvE3UDRHVOYALhi52g6xb8UDjTyERrFJ8lFgHwZ1RAGFUEyzqk2onik3Mxq2pVNt37qcp6AIptqFUccGxC1KGVvw8CYwKs7UUGruBwSEJZMOWBhKoM8lHJ0yP5Fn3YfXb+xHu4Xi80sSf5mIlflR4x+wALr8GDtSYcoy4RaHZm8A3l19InGOhidYcvZYedjkl+yw8qBY8KhgA12zo+9zvavig/l3cABt9KOax901ALFcP8qXQzyx7Oks4bZbVavoI+O/jGUx0qDKDtBs1ejhb5blxKyo6H9/ZKHp9vZ7Cyxk++hdSZaKjfsCu9oqri9Nte1DLBZuRT0lOIWwdcQKBgQDTHqgKerxne9VZuBh6+TSb6DJkVFiT8ScyhR3ny0BkbJzX7/YN0tcN8B2CanpViCUMpdtj1Umbx5tU9hdjhy59XR2OvbNu1YvpuiwK5ujGm1dQ6jb+H2txFeTGbRINEAqSEAhNIVm69nfxZ16vINIHvA9mq4qYjaDHSm5293+Y1wKBgQC4xzVbs7S4kyckfTKDbA+cVVQcuYTGF/MWHL942xwSWv/S0yY12otyV/DsAMdxo56lCIWCZiVN4D3dfrwTcAvz81QtJWI8LdLL4Sh4XLHGHvYvYmECjRMBo61WPvFMxLcnZlSGkndJ/99wYgiEzN1laccQnjMMlhgdA8S2MepYEwKBgA07wrTFdMHX1UvGamJq9I1BRMddMiAz4Y0dIv7Aksy4siwm8nlzWd+ZyX+/ROPPoOLmEpZzbCXDoUz2EAlBE/zvtUaZRYIRCLAh51jXmIe6fQKpa8EKHyX7hVeaxqLi+oalUp/jE0jQ4jvTiu/XUtMBSsXYwttFJWrYk4wJf4oJAoGAH9ZTH0XLcbIJIIRh27sWxXz+TSS599fQjpLNeull4NPFGHJBNy48sKruW/uWYcIrZ4wcVOd8rfphLnTTuxWnOZVHf6/dSTksBOz6qCJwjw5upKNyy5m7GKE3EJEvymZqmGNNVRKPczSfLyH1DcyuqPac0gQwD48dAILRtgLLufkCgYEAkY/lWMYh/6kFJE72MBdPIeHqc7NKSWLOkyzxUevGVlhyevr5+ZhGLEpVhUUoMYKGu/gvq+ArqHa+EDv8gRybmOu5pdidNLSTwTzHW9BH4/+SjLVZCD2YRNadsUIQQ2b9Yw5lbzOe9iaSBMfDDnXQ/i61TXUpZizHthdWz1l5iKQ=";
        return config;
    }
}
