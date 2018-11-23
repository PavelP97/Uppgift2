

package bestgym;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Methodes {
    private String date;
    public Methodes(){}
    
    public int days(String a){
        String dateStart = a;
        String dateStop = LocalDate.now().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1;
	Date d2;
        int s =0;
	try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
            long diff = d2.getTime() - d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            s = (int) diffDays;
        }
        catch(Exception e){
            e.printStackTrace();
        }
      return s;  
    }
}
