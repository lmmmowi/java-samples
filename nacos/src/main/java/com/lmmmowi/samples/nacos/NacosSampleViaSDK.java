package com.lmmmowi.samples.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class NacosSampleViaSDK implements ApplicationListener<ContextRefreshedEvent>, Listener {

    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddress;

    @Value("${spring.application.name}.properties")
    private String dataId;

    private String group = "DEFAULT_GROUP";

    @Override
    public void onApplicationEvent(@Nonnull ContextRefreshedEvent event) {
        this.init();
    }

    private void init() {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddress);
            ConfigService configService = NacosFactory.createConfigService(properties);

            String content = configService.getConfig(dataId, group, 5000);
            log.info("Fetch config from nacos: {}", content);

            configService.addListener(dataId, group, this);
        } catch (NacosException e) {
            log.info("Fail to fetch config from nacos", e);
        }
    }

    @Override
    public Executor getExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Override
    public void receiveConfigInfo(String s) {
        log.info("Receive config change from nacos: {}", s);
    }
}
