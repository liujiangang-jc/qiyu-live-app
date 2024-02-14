package org.qiyu.live.account.provider;

import jakarta.annotation.Resource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.qiyu.live.account.provider.service.IAccountTokenService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author idea
 * @Date: Created in 10:13 2023/6/20
 * @Description
 */
@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class AccountProviderApplication implements CommandLineRunner {
    @Resource
    private IAccountTokenService iAccountTokenService;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(AccountProviderApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        new Thread(
                ()->{
                    synchronized (AccountProviderApplication.class){
                        try {
                            AccountProviderApplication.class.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    @Override
    public void run(String... args) throws Exception {
        Long userId = 1234567L;
        String token = iAccountTokenService.createAndSaveLoginToken(userId);
        System.out.println("token is:" +token);
        Long matchUserId = iAccountTokenService.getUserIdByToken(token);
        System.out.println("matchUserId is :" + matchUserId);

    }
}
