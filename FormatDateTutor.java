import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FormatDateTutor extends Tutor {

    /**
     * Returns date in format dd.mm.yy
     * Use Formatter
     */
    public String getDateByFormatter(Date date) {
        return null;
    }

    /**
     * Returns date in format "10 of April, 2013"
     * Use Formatter
     */
    public String getDateString(Date date) {
        return null;
    }

    /**
     * Returns date in format "10.04.13"
     * Use SimpleDateFormat
     */
    public String getDateBySimpleDateFormat(Date date) {
        return null;
    }

    /**
     * Returns date of type Date, converted from the line in format dd.mm.yy
     * Use SimpleDateFormat, method parse()
     */
    public Date parseDDMMYY(String s) {
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
