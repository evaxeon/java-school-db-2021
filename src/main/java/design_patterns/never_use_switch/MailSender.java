package design_patterns.never_use_switch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class MailSender {
    private static final Map<Integer, Command> actions = new HashMap<>();
    static {
        actions.put(1, new Command() {
            @Override
            public void send(MailInfo mailInfo) {
                //50 lines of code which send welcome mail
                System.out.println("Welcome mail was sent "+mailInfo.getContext());
            }
        });

        actions.put(2, new Command() {
            @Override
            public void send(MailInfo mailInfo) {
                System.out.println("Happy Birthday mail was sent "+mailInfo.getContext());
            }
        });

    }

    public void send(MailInfo mailInfo) {
        Command command = actions.get(mailInfo.getMailType());
        if (command == null) {
            throw new IllegalArgumentException("Invalid mail type=" + mailInfo.getMailType());
        }
        command.send(mailInfo);
    }
}
