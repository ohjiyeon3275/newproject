package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    // 둘다 가능쓰
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    // GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

    @Test
    @DisplayName("빈 메타정보")
    void findApplicationBean() {

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            /**
             * 여기서 빈 메타정보를 찍어볼수있는데
             * 이걸 기반으로 인스턴스를 생성
             * -> 직접 생성해서 스프링컨테이너에 등록도 가능 but 직접 정의할 일은 거의없음
             * Bean Definition으로 추상화가능
             */
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("bean definition name" + beanDefinitionName);
                System.out.println("bean definition" + beanDefinition);
                System.out.println(" >>>> ");
            }
        }
    }

}
