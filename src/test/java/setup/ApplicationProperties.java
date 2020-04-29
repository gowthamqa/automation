package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationProperties {

    private WebDriver driver;
    private AppiumDriver<?> m_driver;

    private static ApplicationProperties s_uniqueInstance;
    private static Map<Long, ApplicationProperties> s_instanceMap = Collections.synchronizedMap(new HashMap<>());

    String app_url;
    String username;
    String password;

    Properties properties = new Properties();

    private ApplicationProperties() {

        try {
            properties.load(new FileInputStream(new File("application.properties")));
            //properties.load(getPropertiesFile());
            app_url = getSetting("url","https://localhost:448/opencart");
            username = getSetting("username","user");
            password = getSetting("password","user123");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + "application properties" + " from classpath", e);
        }

    }



    InputStream getPropertiesFile() {
        File file = new File("application.properties");
        FileInputStream propFile = null;
        try {
            propFile = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return propFile;
    }

    /**
     * First attempt to read the setting from system property. if not found, read from properties file, and both attempts fail, use default
     *
     * @param settingName
     * @param defaultValue
     *
     */
    public String getSetting(String settingName, String defaultValue) {
        String value = System.getProperty(settingName);
        if (value == null) {
            value = properties.getProperty(settingName, defaultValue);
        }

        return value;
    }



    /**
     * Get a static instance of Application Properties. We only want to read the properties file once per run.
     *
     * @return instance of this class.
     */
    public synchronized static ApplicationProperties getInstance() {
        return getInstance(false);
    }

    public synchronized static ApplicationProperties getInstance(boolean forceNew) {
        long threadId = Thread.currentThread().getId();
        if (forceNew || s_instanceMap.get(threadId) == null) {
            s_uniqueInstance = new ApplicationProperties();
            s_instanceMap.put(threadId, s_uniqueInstance);
        }
        return s_instanceMap.get(threadId);
    }

    public WebDriver createAndGetDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver8");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        return driver;
    }

    public AppiumDriver<?> createAndGetAppiumDriver() {
        DesiredCapabilities dcapabilities = new DesiredCapabilities();
        dcapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        dcapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        dcapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dcapabilities.setCapability(MobileCapabilityType.APP, "//Users//gowthamr//Desktop//UICatalog.app");

        try {
            m_driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dcapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        m_driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        return m_driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
