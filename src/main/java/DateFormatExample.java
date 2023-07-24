import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        String s = "12:01:00 PM";
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
        SimpleDateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        String outPut = null;
        try {
            date = dateFormat.parse(s);
            outPut = outputformat.format(date);
            System.out.println(outPut);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
