package cn.t.extension.springboot.starters.mybatis;

import cn.t.common.mybatis.keygenerator.RedisIdGenInterceptor;
import cn.t.common.mybatis.keygenerator.RedisKeyGenerator;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author yj
 * @since 2020-05-08 13:14
 **/

@EnableConfigurationProperties(MybatisExtensionProperties.class)
@Configuration
public class MybatisExtensionConfiguration {

    private final MybatisExtensionProperties mybatisExtensionProperties;

    @Bean
    public RedisIdGenInterceptor redisIdGenInterceptor(ValueOperations<String, String> valueOperations) {
        return new RedisIdGenInterceptor(redisKeyGenerator(valueOperations));
    }

    @Bean
    public RedisKeyGenerator redisKeyGenerator(ValueOperations<String, String> valueOperations) {
        return new RedisKeyGenerator(valueOperations);
    }

    public MybatisExtensionConfiguration(MybatisExtensionProperties mybatisExtensionProperties) {
        this.mybatisExtensionProperties = mybatisExtensionProperties;
    }
}
