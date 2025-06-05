package tests.api;


import api.SimpleBooksAPI;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.models.Order;

public class SimpleBooksAPITests {

    @Test
    public void testGetAllBooks() {
        Response response = SimpleBooksAPI.getAllBooks();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("").size() > 0);
    }

    @Test
    public void testCreateAndDeleteOrder() {
        // Get auth token
        String token = SimpleBooksAPI.getAuthToken();

        // Create order
        Order order = new Order("1", "John Doe");
        Response createResponse = SimpleBooksAPI.createOrder(order, token);
        Assert.assertEquals(createResponse.getStatusCode(), 201);
        String orderId = createResponse.jsonPath().getString("orderId");

        // Get order
        Response getResponse = SimpleBooksAPI.getOrder(orderId, token);
        Assert.assertEquals(getResponse.getStatusCode(), 200);
        Assert.assertEquals(getResponse.jsonPath().getString("customerName"), "John Doe");

        // Delete order
        Response deleteResponse = SimpleBooksAPI.deleteOrder(orderId, token);
        Assert.assertEquals(deleteResponse.getStatusCode(), 204);
    }
}