package com.example.indicatordemo.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/23 15:06
 * @Version 1.0
 **/
@Component
public class Custom implements HealthIndicator {

    @Override
    public Health health() {
        Health health;
        // 状态判断 比如一些库存数量的判断  其他重要资源的判断
        if (true) {
            health = Health.up()
                    .withDetail("自定义健康数据", "aaa")
                    .withDetail("自定义健康状态", "健康")
                    .build();
        } else {
            health = Health.down()
                    .withDetail("自定义健康数据", "000")
                    .withDetail("自定义健康状态", "错误")
                    .build();
        }

        return health;
    }
}
