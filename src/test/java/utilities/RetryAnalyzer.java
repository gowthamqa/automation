package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static Logger logger = Logger.getLogger(String.valueOf(RetryAnalyzer.class));
    public  String max_retries = System.getProperty("max_retries");
    public  int retryCount = 0;
    public  int MAX_RETRIES;

    @Override
    public boolean retry( ITestResult result ) {
        if(max_retries==null){
            MAX_RETRIES=0;
        }else{
            MAX_RETRIES = Integer.parseInt(max_retries);
            logger.info( "Running retry for " + result.getMethod() );
        }

        boolean retryFunction = false;
        if ( retryCount < MAX_RETRIES ) {
            retryCount++;
            retryFunction = true;
        }

        return retryFunction;
    }
}
