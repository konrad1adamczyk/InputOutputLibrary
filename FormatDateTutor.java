import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FormatDateTutor extends Tutor {

    /**
     * Returns date in format dd.mm.yy
     * Use Formatter
     */
    public String getDateByFormatter(Date date) {
        return String.format("%td.%tm.%ty",date,date,date);
    }

    /**
     * Returns date in format "10 of April, 2013"
     * Use Formatter
     */
    public String getDateString(Date date) {

        return String.format("%td of %tB, %tY",date,date,date);
    }

    /**
     * Returns date in format "10.04.13"
     * Use SimpleDateFormat
     */
    public String getDateBySimpleDateFormat(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        return sdf.format(date);
    }

    /**
     * Returns date of type Date, converted from the line in format dd.mm.yy
     * Use SimpleDateFormat, method parse()
     */
    public Date parseDDMMYY(String s) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        Date d;
        try{
            d = sdf.parse(s);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void testFormatDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 4, 1); // 1st of May, 2013
        Date date = cal.getTime();

        String dateByFormatter = getDateByFormatter(date);
        log("dateByFormatter:"+dateByFormatter);
        assertEquals(dateByFormatter, "01.05.13");

        String dateBySimpleDateFormat = getDateBySimpleDateFormat(date);
        log("dateBySimpleDateFormat:"+dateBySimpleDateFormat);
        assertEquals(dateBySimpleDateFormat, "01.05.13");

        System.out.println(getDateString(new Date()));
        //formatNumber();
    }

    @Test
    public void testParseDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, 4, 1, 0, 0, 0); // 1st of May, 2013
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        Date d = parseDDMMYY("01.05.13");
        assertEquals(date, d);
    }
}
