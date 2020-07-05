package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Api {

    @Test()
    public void tetsApi() {
        RestAssured.baseURI ="https://www.linkedin.com";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/feed/");
        System.out.println(response.getCookies());
    }
}
