package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import api.models.Order;
import utils.ConfigReader;

public class SimpleBooksAPI {
    private static final String BASE_URL = ConfigReader.getApiBaseUrl();

    public static Response getAllBooks() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .get("/books");
    }

    public static String getAuthToken() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body("{\"clientName\":\"Test\",\"clientEmail\":\"test@example.com\"}")
                .post("/api-clients/")
                .then()
                .extract()
                .path("accessToken");
    }

    public static Response createOrder(Order order, String token) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(order)
                .post("/orders");
    }

    public static Response getOrder(String orderId, String token) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .get("/orders/" + orderId);
    }

    public static Response deleteOrder(String orderId, String token) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .delete("/orders/" + orderId);
    }
}