package my_spring;

import homework.lab3.utils.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectRandomNameAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        for (Field field : type.getDeclaredFields()) {
            InjectRandomName annotation = field.getAnnotation(InjectRandomName.class);
            if(annotation!=null) {
                field.setAccessible(true);
                field.set(t, RandomUtil.randomName());
            }
        }

    }
}
