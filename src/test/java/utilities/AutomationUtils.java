package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.SecureRandom;

public class AutomationUtils {

    private final static String SPACE = " ";
    private final static String ENGLISH = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
    private final static String SPECIAL_CHARS = "+-$@!`~{}[]|\'\";:.><,?/#%^*()_=&";
    //final static Logger logger = LogManager.getLogger(AutomationUtils.class);

    public static String getInputString(int length, boolean includeSpecialChars, boolean includeSpace) {
        String extraChars = (includeSpecialChars) ? SPECIAL_CHARS : "";
        extraChars += (includeSpace) ? SPACE : "";
        return RandomStringUtils.random(length, ENGLISH + extraChars).trim().replaceAll("(\\s)+", SPACE);
    }

    public static String getInputString(int length, boolean includeSpecialChars) {
        return getInputString(length, includeSpecialChars, false);
    }

    public static String getInputString(int length) {
        return getInputString(length, false);
    }

    /**
     * A helper function, Returns a random number between a range
     *
     * @param floor
     *            lowest number in range
     * @param ceiling
     *            highest number in range
     */

    public static int getRandomInt(int floor, int ceiling) {
        SecureRandom rnd = new SecureRandom();
        return rnd.nextInt(ceiling - floor) + floor;
    }

    /**
     * A helper function, Returns a random number of length
     *
     * @param length
     *
     * @return
     */

    public static int getRandomInt(int length) {
        long timeSeed = System.nanoTime(); // to get the current date time value
        double randSeed = Math.random() * 1000; // random number generation
        long midSeed = (long) (timeSeed * randSeed); // mixing up the time and rand number.

        String s = midSeed + "";
        String subStr = s.substring(0, length);

        return Integer.parseInt(subStr);
    }

    public static void selectByVisableText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element,String text){
        Select select = new Select(element);
        select.selectByValue(text);
    }

}
