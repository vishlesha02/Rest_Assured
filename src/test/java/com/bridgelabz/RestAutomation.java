package com.bridgelabz;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestAutomation {
    @Test
    public void createUser()
    {
        Response respone= given()
                .header("accept","application/json")
                .header("Content-Type"," application/json")
                .body("{\n" +
                        "  \"id\": 101,\n" +
                        "  \"username\": \"Vishlesha\",\n" +
                        "  \"firstName\": \"Vishlesha\",\n" +
                        "  \"lastName\": \"Mortale\",\n" +
                        "  \"email\": \"vishlesha@gmail.com\",\n" +
                        "  \"password\": \"Vishlesha\",\n" +
                        "  \"phone\": \"789456\",\n" +
                        "  \"userStatus\": 123\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");

        respone.prettyPrint();
        respone.then().assertThat().statusCode(200);
    }

    @Test
    public void LoginUser()
    {
        Response response=given()
                .header("accept","application/json")
                .header("Content-Type"," application/json")
/*
                .pathParam("username","Vishlesha")
                .pathParam("password","Vishlesha")
*/
                .queryParam("username","Vishlesha")
                .queryParam("password","Vishlesha")

                .when()
                .get("https://petstore.swagger.io/v2/user/login");
        response.prettyPrint();
        String msg=response.path("message");
        System.out.println(msg);

    }

    @Test
    public void UpdateUser()
    {
        Response response=given()
                .header("accept","application/json")
                .header("Content-Type"," application/json")
                .body("{\n" +
                        "  \"id\": 102,\n" +
                        "  \"username\": \"Vishlesha\",\n" +
                        "  \"firstName\": \"Simrita\",\n" +
                        "  \"lastName\": \"Mortale\",\n" +
                        "  \"email\": \"simrita@gmail.com\",\n" +
                        "  \"password\": \"Vishlesha\",\n" +
                        "  \"phone\": \"852369\",\n" +
                        "  \"userStatus\": 133\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/Vishlesha");
        response.prettyPrint();
    }

    @Test
    public void deleteUser()
    {
        Response response=given()
                .header("accept","application/json")

                .when()
                .delete("https://petstore.swagger.io/v2/user/Vishlesha");
        response.prettyPrint();
Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void uploadImage()
    {
        File file=new File("C:\\Users\\DELL\\Postman\\files\\sddefault.JPG");
        Response response=given()
                .header("accept","application/json")
                .header("Content-Type","multipart/form-data")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/852/uploadImage");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);


    }

    @Test
    public void getPet()
    {
        Response response=given()
                .header("accept"," application/json")

                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test

    public void postNewPet()
    {
        Response response=given()
                .header("accept"," application/json")
                .header("Content-Type"," application/json")

                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }




    @Test
    public void getPetById()
    {
        Response response=given()
                .header("accept"," application/json")

                .when()
                .get("https://petstore.swagger.io/v2/pet/9222968140497180000");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }


    @Test
    public void postInStore()
    {
        Response response=given()
                .header("accept", "application/json")
                .header("Content-Type"," application/json")

                .when()
                .post("https://petstore.swagger.io/v2/store/order");

                response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
