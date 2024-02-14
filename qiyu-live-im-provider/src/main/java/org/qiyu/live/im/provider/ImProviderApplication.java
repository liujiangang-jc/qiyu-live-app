package org.qiyu.live.im.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author idea
 * @Date: Created in 21:02 2023/7/9
 * @Description
 */
@SpringBootApplication
@EnableDubbo
public class ImProviderApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ImProviderApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
        new Thread(
                ()->{
                    synchronized (ImProviderApplication.class){
                        try {
                            ImProviderApplication.class.wait();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

}
