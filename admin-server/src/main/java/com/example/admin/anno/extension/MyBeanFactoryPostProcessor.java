package com.example.admin.anno.extension;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *
 * Modify the application context's internal bean factory after its standard
 * 	 * initialization. All bean definitions will have been loaded, but no beans
 * 	 * will have been instantiated yet.
 * 	 Bean被加载好，但还没有初始化阶段。
 *
 *22:57:15.791 [main] INFO com.example.admin.anno.extension.MyBeanFactoryPostProcessor - definitioCount，9
 * 22:57:15.902 [main] INFO com.example.admin.anno.extension.MyBeanFactoryPostProcessor -
 * definitionNames，["
 * org.springframework.context.annotation.internalConfigurationAnnotationProcessor","
 * org.springframework.context.annotation.internalAutowiredAnnotationProcessor","
 * org.springframework.context.annotation.internalRequiredAnnotationProcessor","
 * org.springframework.context.annotation.internalCommonAnnotationProcessor","
 * org.springframework.context.event.internalEventListenerProcessor","
 * org.springframework.context.event.internalEventListenerFactory","
 * extensionConfig","
 * myBeanFactoryPostProcessor","
 * car"]
 *
 *abstract class AbstractApplicationContext.refresh()
 *
 	// Invoke factory processors registered as beans in the context.
    invokeBeanFactoryPostProcessors(beanFactory);



 *
 *
 */

@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                log.info("start MyBeanFactoryPostProcessor......");
        int definitioCount = beanFactory.getBeanDefinitionCount();
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        log.info("definitioCount，{}",definitioCount);
        log.info("definitionNames，{}", JSON.toJSONString(definitionNames));
    }
}
