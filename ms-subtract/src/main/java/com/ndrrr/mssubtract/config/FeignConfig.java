package com.ndrrr.mssubtract.config;

import com.ndrrr.mssubtract.client.SumClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = SumClient.class)
public class FeignConfig {
}
