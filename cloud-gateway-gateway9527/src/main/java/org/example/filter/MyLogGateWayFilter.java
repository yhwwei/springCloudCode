package org.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

/**
 * @author yhw
 * @version 1.0
 **/
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    /*
     * 自定义过滤器  和web里面的servlet过滤器一样 有个链，一级一级过滤下去，然后在按原路返回
     * */

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null) {
            log.info("请先登录账号");
            //设置response
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    //定义过滤器的优先级   越小优先级也越高
    @Override
    public int getOrder() {
        return 0;
    }
}
