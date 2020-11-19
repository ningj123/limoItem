//package com.woniuxy.handler;
//
//import com.alibaba.fastjson.JSONObject;
//import com.woniuxy.util.JSONResult;
//import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @ClassName ErrorHandler
// * @Author shadow
// * @Date 2020/11/17 9:33
// * @Description TODO
// **/
////@Component
//public class ErrorHandler implements ErrorWebExceptionHandler {
//    @Override
//    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
//        if(exchange.getResponse().isCommitted()) {
//            return Mono.error(ex);
//        }
//        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
//        JSONResult result=new JSONResult("200", ex.getMessage(), null, null);
//        String json = JSONObject.toJSONString(result);
//        return exchange.getResponse().writeWith(Mono.fromSupplier(() -> {
//            return exchange.getResponse().bufferFactory().wrap(json.getBytes());
//        }));
//    }
//}
