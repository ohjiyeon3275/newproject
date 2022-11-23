package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈")
    void findAllBean() {

        String [] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String beanName : beanDefinitionNames) {
            Object bean = ac.getBean(beanName);
            System.out.println("name = " + beanName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리 빈")
    void findAppBean() {

        String [] beanDefinitionNames = ac.getBeanDefinitionNames();

        for(String beanName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

            /**
             * ROLE_APPLICATION : 사용자 정의
             * ROLE_INFRASTRUCTURE : 스프링 내부
             */
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanName);
                System.out.println("name = " + beanName + " object = " + bean);
            }
        }
    }
}
