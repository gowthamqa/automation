package test.factorytest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

public class TestNGFactory {

    @Factory(dataProvider = "getData")
    public Object[] testing(String user, String pass){
        Object[] ar = new Object[1];
        ar[0] = new TestClass(user, pass);
        return ar;
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "user1";
        data[0][1] = "pwd1";

        data[1][0] = "user2";
        data[1][1] = "pwd2";

        data[2][0] = "user3";
        data[2][1] = "pwd3";

        return data;
    }
}
