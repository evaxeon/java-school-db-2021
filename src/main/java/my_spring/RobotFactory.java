package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class RobotFactory {
    private final ObjectFactory objectFactory;

    public RobotFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }
    @SneakyThrows
    public <T> T createRobot(Class<T> clazz) {
        T robot = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(robot, objectFactory.createObject(field.getType()));
            }
        }
        return robot;
    }
}
