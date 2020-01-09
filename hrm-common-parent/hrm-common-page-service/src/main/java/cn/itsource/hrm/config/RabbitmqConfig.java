package cn.itsource.hrm.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Date: 2020/1/6 00:05
 * @Author: yjz
 * @Version:1.0
 */
@Configuration
public class RabbitmqConfig {
    public static final String EXCHANGE_TOPICS_INFORM = "exchange_direct_inform";

    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM() {
        return ExchangeBuilder.directExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
    }
}
