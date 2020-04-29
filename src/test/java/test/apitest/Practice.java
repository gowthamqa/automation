package test.apitest;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.util.Optional;

public class Practice {

    private static Optional<String> getSystemNonBlankProperty(String key) {
        String value = System.getProperty(key);
        return Optional.ofNullable(StringUtils.isNotBlank(value) ? value : null);
    }

    @Test
    public void test() {
        String env = getSystemNonBlankProperty("env")
              .orElseThrow(()-> new IllegalStateException("System property env is missing or empty."))
             .toLowerCase();

        System.out.println(env);
    }
}
