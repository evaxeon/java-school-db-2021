package radio;

public class RadioAlarm implements Alarm, Transmitable {
    @Override
    public void ring() {
        System.out.println("This method makes the alarm ring");
    }

    @Override
    public void snooze() {
        System.out.println("This method snoozes the alarm");
    }

    @Override
    public void receive() {
        System.out.println("This method receives the radio signal");
    }

    @Override
    public void transmit() {
        System.out.println("This method transmits the signal");
    }
}
