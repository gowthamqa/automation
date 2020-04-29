package test.apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Test1 {

    private static Logger log = Logger.getLogger(Test1.class);

    @Test
    public void test1(){
        String quoteId = null;
        SoftAssert softAssert = new SoftAssert();
        Response res = RestAssured.given().when().log().all()
                .get("https://reqres.in/api/users?page=2").then().contentType(ContentType.JSON).extract().response();
        res.then().log().body();

       //RestAssured.given().multiPart()


    }

    @Test
    public void test2(){
        Response res = given()
                .get("https://reqres.in/api/users?delay=3");
        System.out.println(res.asString());
        //Assert.assertEquals(res.thenReturn().body().jsonPath().getString("total"), "12", "Success");
        JsonPath jsonPath = JsonPath.from(res.getBody().asString());
        System.out.println(jsonPath.getString("total"));
        //Assert.assertFalse(false, "False result");
        //Assert.assertFalse(true, "true");
        //System.out.println(res.thenReturn().body().jsonPath().getBoolean("_rb.isError"));
    }

    public static void main(String[] args) {
        Response res = given()
                .get("https://reqres.in/api/users?delay=3");
        System.out.println(res.asString());
        JSONObject jsonBody=new JSONObject(res.getHeaders().get("Content-Type"));
    }

    @Test
    public void imageCreate() throws IOException {
        int width = 250;
        int height = 250;

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.black);
        g2d.fillOval(0, 0, width, height);

        g2d.setColor(Color.yellow);
        g2d.drawString("Sample Image", 50,   120);

        g2d.dispose();

        File file = new File("myimage.png");
        ImageIO.write(bufferedImage, "png", file);

        File file1 = new File("myimage.jpg");
        ImageIO.write(bufferedImage, "jpg", file1);
    }

    @Test
    public void upload(){
        RequestSpecification specification = given();

        File testUploadFile = new File("/Users/gowthamr/selinumtest/myimage.png");

        Response response = RestAssured.given()
                .headers("Authorization", "Bearer 246b_-c290b266-d777-4520-98d2-fde85cd7f7ba")
                .params("attributes", "{\"lookupId\":\"146764\",\"sharing\":{\"entities\":[]}}")
                .params("context", "{\"id\":2947343,\"type\":\"SHIPMENT\"}")
                .params("fullResponse", true)
                .multiPart("file", testUploadFile)
                .when()
                .log().all()
                .post("https://rehearsal-app-bravo.turvo.com/api/documents");

        //Response response = ApiRestExecutor.execute(definition);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        response.then().log().all();
        //Assert.assertEquals(response.thenReturn().body().jsonPath().getString("respMsg"), "SUCCESS_SAVE", "SUCCESS_SAVE");
    }
}
