package jp.ac.tuis.edu.taco.cloud.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

//@EnableFeignClients
/* 当存在其它异常时，可能会被hostname解析异常掩盖。移除该注释。
        return WebClient.builder();     */
@Configuration
public class ClientConfiguration {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {

        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient));
    }
}
