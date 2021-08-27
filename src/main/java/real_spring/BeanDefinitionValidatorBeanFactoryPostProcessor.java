package real_spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Objects;

/**
 * @author Evgeny Borisov
 */
public class BeanDefinitionValidatorBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
            if(Objects.equals(beanDefinition.getScope(), "prototype") && !Objects.equals(beanDefinition.getDestroyMethodName(), "")) {
                System.out.println("Все очень плохо");
            }
        }
    }
}
