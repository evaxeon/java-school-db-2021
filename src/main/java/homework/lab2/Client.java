package homework.lab2;

import lombok.ToString;

/**
 * @author Evgeny Borisov
 */
@ToString
public class Client {
    private final int debt; //todo you can't remove final
    private final int bonus;
    private final String name;
    private final int salary;

    public Client(int debt, int bonus, String name, int salary) {
        this.debt = debt;
        this.bonus = bonus;
        this.name = name;
        this.salary = salary;
    }

    public static class ClientBuilder {
        private int debt = ClientConstants.DEFAULT_DEBT;
        private int bonus = ClientConstants.DEFAULT_BONUS;
        private String name = ClientConstants.DEFAULT_NAME;
        private int salary = ClientConstants.DEFAULT_SALARY;

        public ClientBuilder debt(int debt) {
            this.debt = debt;
            return this;
        }

        public ClientBuilder bonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Client builder() {
            if (debt == ClientConstants.DEFAULT_DEBT || bonus == ClientConstants.DEFAULT_BONUS ||
                    name.equals(ClientConstants.DEFAULT_NAME) || salary == ClientConstants.DEFAULT_SALARY) {
                throw new IllegalArgumentException("One of the arguments was not set!");
            }
            return new Client(debt, bonus, name, salary);
        }
    }
}
