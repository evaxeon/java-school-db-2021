package real_spring;

import lombok.Setter;
import my_spring.InjectRandomName;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TalkingRobot {

    @InjectRandomName  //todo make it do something
    private String name;

    @Setter
    private List<Quoter> quoters;

    @PostConstruct
    public void talk(){
        System.out.println("My name is " + name + " and I say:");
        quoters.forEach(Quoter::sayQuote);
    }
}
