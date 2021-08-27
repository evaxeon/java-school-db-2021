package real_spring;

import my_spring.InjectRandomNameAnnotationObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InjectRandomNameAnnotationBeanPostProcessor implements BeanPostProcessor {

    private InjectRandomNameAnnotationObjectConfigurator configurator = new InjectRandomNameAnnotationObjectConfigurator();
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        configurator.configure(bean);
        return bean;
    }
}
