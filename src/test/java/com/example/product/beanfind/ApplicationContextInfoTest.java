package com.example.product.beanfind;

import com.example.product.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames(); // 정의된 bean의 이름들을 String[]로 리턴

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);  // 스프링 빈 조회(조회할 스프링 빈의 이름을 대입)
            System.out.println("bean = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames(); // 정의된 bean의 이름들을 String[]로 리턴

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);   // 해당 빈의 정의를 리턴

            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // ROLW_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole()== BeanDefinition.ROLE_APPLICATION){
                Object bean = applicationContext.getBean(beanDefinitionName);   // 객체의 타입이 없기 때문에 Object형
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }

}
