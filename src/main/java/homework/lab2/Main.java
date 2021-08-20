package homework.lab2;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        //Client client = new Client(12, 14, "Vasya", 100);

        Client client = new Client.ClientBuilder()
                .debt(12)
                .bonus(14)
                .name("Vasya")
                .salary(100)
                .builder();
    }
}

