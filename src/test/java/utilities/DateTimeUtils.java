package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {
    private static final String DEFAULT_TIMEZONE = "GMT";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String RESPONSE_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss z";
    public static final String DATETIME_Z_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String DATETIME_Z_FORMAT_ZERO_TIME = "yyyy-MM-dd'T'00:00:00'Z'";
    public static final String DATETIME_Z_FORMAT_END_TIME = "yyyy-MM-dd'T'23:59:59'Z'";
    public static final String DATETIME_MILESTONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * Get system current date
     * @return string date
     */
    public static String getTodaysDate(){
        Date dt = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(dt);
    }

    /**
     * Add x days to current DEFAULT_TIMEZONE date
     * @param days days to add
     * @return DATE_FORMAT string date
     */
    public static String addXdaysToTodaysDate(int days){
        return addXdaysToTodaysDate(days, DATE_FORMAT);
    }

    /**
     * Add x days to current DEFAULT_TIMEZONE date
     * @param days days to add
     * @param format output date format
     * @return format string date
     */
    public static String addXdaysToTodaysDate(int days, String format){
        Calendar calendar = new GregorianCalendar(/* remember about timezone! */);
        calendar.add(Calendar.DATE, days);
        Date dt = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIMEZONE));
        return formatter.format(dt);
    }

    /**
     * Add x seconds to current datetime
     * @param seconds to add/subtract from datetime
     * @return Date
     */
    public static Date addXSecondsToTodaysDate(int seconds){
        Calendar calendar = new GregorianCalendar(/* remember about timezone! */);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    /**
     *
     * @param days to add/subtract from current system time
     * @param timezone for which the time needed e.g PST, IST, GMT
     * @return DATETIME_FORMAT string
     */
    public static String daystoAdd(int days, String timezone) {
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        SimpleDateFormat Formatter = new SimpleDateFormat(DATETIME_FORMAT, Locale.US);
        Calendar cal = new GregorianCalendar(timeZone);
        cal.add(Calendar.DATE, days);
        Formatter.setTimeZone(timeZone);
        ZoneOffset offset = timeZone.toZoneId().getRules().getOffset(LocalDateTime.now());
        return Formatter.format(cal.getTime())+offset.toString();
    }

    /**
     *
     * @param minutes to add/subtract from current system time
     * @param timezone for which the time needed e.g PST, IST, GMT
     * @return DATETIME_FORMAT string
     */
    public static String minutesToAdd(int minutes, String timezone) {
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        SimpleDateFormat Formatter = new SimpleDateFormat(DATETIME_FORMAT, Locale.US);
        Calendar cal = new GregorianCalendar(timeZone);
        cal.add(Calendar.MINUTE, minutes);
        Formatter.setTimeZone(timeZone);
        ZoneOffset offset = timeZone.toZoneId().getRules().getOffset(LocalDateTime.now());
        return Formatter.format(cal.getTime())+offset.toString();
    }

    /**
     *
     * @param seconds to add/subtract from current system time
     * @param timezone for which the time needed e.g PST, IST, GMT
     * @return DATETIME_FORMAT string
     */
    public static String secondsToAdd(int seconds, String timezone) {
        TimeZone timeZone = TimeZone.getTimeZone(timezone);
        SimpleDateFormat Formatter = new SimpleDateFormat(DATETIME_FORMAT, Locale.US);
        Calendar cal = new GregorianCalendar(timeZone);
        cal.add(Calendar.SECOND, seconds);
        Formatter.setTimeZone(timeZone);
        ZoneOffset offset = timeZone.toZoneId().getRules().getOffset(LocalDateTime.now());
        return Formatter.format(cal.getTime())+offset.toString();
    }

    /**
     * Add x seconds to date
     * @param seconds to add/subtract from date
     * @param dateTime input date
     * @param oldFormat input date format
     * @param newFormat output date format
     * @return string date
     */
    public static String addXSecondsToDate(int seconds, String dateTime, String oldFormat, String newFormat) {
        LocalDateTime localDateTime = addXToDate(seconds, dateTime, ChronoUnit.SECONDS, oldFormat);
        return formatDateToRequiredFormat(localDateTime, newFormat);
    }

    /**
     * Add x days to date
     * @param days to add/subtract from date
     * @param dateTime input date
     * @param oldFormat input date format
     * @param newFormat output date format
     * @return string date
     */
    public static String addXDaysToDate(int days, String dateTime, String oldFormat, String newFormat) {
        LocalDateTime localDateTime = addXToDate(days, dateTime, ChronoUnit.DAYS, oldFormat);
        return formatDateToRequiredFormat(localDateTime, newFormat);
    }

    /**
     * Add x days to date
     * @param days to add/subtract from date
     * @param dateTime input date
     * @param dateFormat dates format
     * @return string date
     */
    public static String addXDaysToDate(int days, String dateTime, String dateFormat) {
        LocalDateTime localDateTime = addXToDate(days, dateTime, ChronoUnit.DAYS, dateFormat);
        return formatDateToRequiredFormat(localDateTime, dateFormat);
    }

    /**
     * Add x months to date
     * @param months to add/subtract from date
     * @param dateTime input date
     * @param dateFormat dates format
     * @return string date
     */
    public static String addXMonthsToDate(int months, String dateTime, String dateFormat) {
        LocalDateTime localDateTime = addXToDate(months, dateTime, ChronoUnit.MONTHS, dateFormat);
        return formatDateToRequiredFormat(localDateTime, dateFormat);
    }

    /**
     * Get date format string from LocalDateTime object
     * @param dateTime input date
     * @param newFormat output date format
     * @return string date
     */
    private static String formatDateToRequiredFormat(LocalDateTime dateTime, String newFormat) {
        return dateTime.format(DateTimeFormatter.ofPattern(newFormat));
    }

    /**
     * Add value to date
     * @param value to add/subtract from date
     * @param dateTime input date
     * @param unit add/subtract value unit (days, seconds...)
     * @param format input date format
     * @return LocalDateTime object
     */
    private static LocalDateTime addXToDate(int value, String dateTime, ChronoUnit unit, String format) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(format)).plus(value, unit);
    }

    /**
     * Get format date string
     * @param date input date
     * @param format input/output date format
     * @return string date
     */
    public static String formatDateToRequiredFormat(String date, String format)  {
        return formatDateToRequiredFormat(date, format, format);
    }

    /**
     * Get format date string
     * @param date input date
     * @param oldFormat input date format
     * @param newFormat output date format
     * @return format date string
     */
    public static String formatDateToRequiredFormat(String date, String oldFormat, String newFormat)  {
        Date dt = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
            sdf.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIMEZONE));
            dt = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(newFormat);
        formatter.setTimeZone(TimeZone.getTimeZone(DEFAULT_TIMEZONE));
        return formatter.format(dt);
    }

    /**
     * Calculate the difference between end date and start date
     * @param startDate date 'yyyy-MM-dd' format
     * @param endDate date 'yyyy-MM-dd' format
     * @return days between two dates
     */
    public static int getDateRange(String startDate, String endDate){
        int diff=0;
        try {
            Date date1 = new SimpleDateFormat(DATE_FORMAT).parse(startDate);
            Date date2 = new SimpleDateFormat(DATE_FORMAT).parse(endDate);
            diff = (int) (TimeUnit.MILLISECONDS.toDays(date2.getTime())-TimeUnit.MILLISECONDS.toDays(date1.getTime()));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return diff;
    }

    /**
     * Check that date in range between two dates
     * @param startDate start range date
     * @param endDate date range date
     * @param inRangeDate date for check
     * @param dateFormat all dates format
     * @return true if date in range or false if not
     */
    public static boolean isDateBetweenDates(String startDate, String endDate, String inRangeDate, String dateFormat) {
        boolean diff = false;
        try {
            Date dateStart = new SimpleDateFormat(dateFormat).parse(startDate);
            Date dateEnd = new SimpleDateFormat(dateFormat).parse(endDate);
            Date dateInRange = new SimpleDateFormat(dateFormat).parse(inRangeDate);
            diff = dateStart.before(dateInRange) && dateEnd.after(dateInRange);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }
}
