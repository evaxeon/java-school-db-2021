package my_spring;

import com.db.model.Person;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        RobotFactory robotFactory = new RobotFactory(ObjectFactory.getInstance());
        robotFactory.createRobot(IRobot.class).cleanRoom();
    }
}
