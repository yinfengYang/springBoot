package com.yyf.firstSpringBootdemo.config;

import com.yyf.firstSpringBootdemo.domain.User;
import com.yyf.firstSpringBootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;


/**
 * 路由函数
 */

@Configuration
public class RouterFunctionConfiguration {
    /**
     * Mono是0-1个对象集合
     * Flux是0-n个对象集合
     * Reactive中的Flux或者Mono是异步处理非阻塞
     * 集合对象基本上是同步处理阻塞
     * 不管是Mono好事Flux都是一个发布者Publisher
     * @param userRepository
     * @return
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return   RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    //获取用户所有对象
                    Collection<User> users = userRepository.findAll();
                    //集合转换成Flux对象
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return  ServerResponse.ok().body(userFlux,User.class);

                });

    }
}
