package com.bridgelabz;

public class JsonServer {
        @Test
        public void addPost(){
            Response response = given()
                    .header("Content-Type","application/json")
                    .body(
                            "{\n" +
                                    "    \"id\": 10,\n" +
                                    "    \"name\": \"Sakesh\",\n" +
                                    "    \"location\": \"Bangalore\"\n" +
                                    "  }"
                    )
                    .when()
                    .post("  http://localhost:3000/posts");
            response.prettyPrint();
        }
        @Test
        public void updatePost(){
            Response response = given()
                    .header("Content-Type","application/json")
                    .body(
                            "{\n" +
                                    "    \"id\": 10,\n" +
                                    "    \"name\": \"Sunil\",\n" +
                                    "    \"location\": \"Bangalore\"\n" +
                                    "  }"
                    )
                    .when()
                    .put("http://localhost:3000/posts/10");
            response.prettyPrint();
        }
        @Test
        public void getPostsRecords(){
            Response response = given()
                    .header("accept","application/json")
                    .get("http://localhost:3000/posts");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);
        }
        //Comments
        @Test
        public void addComment(){
            Response response = given()
                    .header("Content-Type","application/json")
                    .body(
                            "{\n" +
                                    "        \"name\": \"Subhakar\",\n" +
                                    "        \"id\": 10\n" +
                                    "    }"
                    )
                    .when()
                    .post("http://localhost:3000/comments");
            response.prettyPrint();
        }
        @Test
        public void getCommentRecords(){
            Response response = given()
                    .header("accept","application/json")
                    .get("http://localhost:3000/comments");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);
        }
        @Test
        public  void updateComments(){
            Response response = given()
                    .header("Content-Type","application/json")
                    .body(
                            "{\n" +
                                    "        \"name\": \"Sumesh\",\n" +
                                    "        \"id\": 10\n" +
                                    "    }"
                    )
                    .when()
                    .put("http://localhost:3000/comments/10");
            response.prettyPrint();
        }
        //Profiles
        @Test
        public void addProfiles(){
            Response response = given()
                    .header("Content-Type","application/json")
                    .body(
                            "{\n" +
                                    "        \"name\": \"Rohan\",\n" +
                                    "        \"id\": 10\n" +
                                    "    }"
                    )
                    .when()
                    .post("http://localhost:3000/profile");
            response.prettyPrint();
        }
        @Test
        public void getProfileRecords(){
            Response response = given()
                    .header("accept","application/json")
                    .get("http://localhost:3000/profile");
            response.prettyPrint();
            response.then().assertThat().statusCode(200);
        }
}
