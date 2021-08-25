package my_spring;

import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        Field[] declaredFields = type.getDeclaredFields();
        for(Field field : declaredFields) {
            if(field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.setAccessible(true);
                field.setInt(t, ObjectUtils.randomIntInRange(annotation.min(), annotation.max()));
            }
        }

        return t;
    }

}
