package com.example.admin.server.aop;

import com.example.admin.aop.demo.MainConfigAop;
import com.example.admin.aop.demo.MathCalculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AopTest {

    @Test
    public  void test01(){

        AnnotationConfigApplicationContext  ctx=new AnnotationConfigApplicationContext(MainConfigAop.class);
        MathCalculator mathCalculator = ctx.getBean(MathCalculator.class);
        int result = mathCalculator.div(10, 2);
        log.info("+++++++++++++++result:{}",result);

    }

}
