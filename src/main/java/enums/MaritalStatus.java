package enums;

import lombok.Getter;

/**
 * @author Evgeny Borisov
 */

@Getter
public enum MaritalStatus  {

    SINGLE(1, "холостое"), MARRIED(2,"замужнее"), DIVORCED(7, "разведено");

    private final String russianDesc;
    private final int dbCode;


    MaritalStatus(int dbCode, String russianDesc) {
        System.out.println(dbCode);
        this.russianDesc = russianDesc;
        this.dbCode = dbCode;
    }




    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus[] statuses = values();
        for (MaritalStatus status : statuses) {
            if (status.dbCode == dbCode) {
                return status;
            }
        }
        throw new IllegalStateException(dbCode+" not supported");

    }


    @Override
    public String toString() {

        return super.toString()+ getRussianDesc();
    }
}



