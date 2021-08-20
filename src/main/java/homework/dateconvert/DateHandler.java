package homework.dateconvert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {
    String pattern = "yyyy***MM***dd";
    final SimpleDateFormat sdf;

    public DateHandler() {
        sdf = new SimpleDateFormat(pattern);
    }

    Date convertStringToDate(String s) {
        try {
            Date res = sdf.parse(s);
            return res;
        } catch (ParseException e) {
            System.out.println("Parse exception!");
        }
        return null;
    }

    String convertDateToString(Date d) {
        return sdf.format(d);
    }

    public static void main(String[] args) {
        DateHandler dh = new DateHandler();

    }
}
