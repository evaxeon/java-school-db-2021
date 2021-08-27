package my_spring;

import object_casting.Animal;

import java.rmi.dgc.DGC;

/**
 * @author Evgeny Borisov
 */
public class IRobot {
    //todo make support for @InjectByType
    @Inject
    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    @Inject
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);

    public void cleanRoom(){
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
