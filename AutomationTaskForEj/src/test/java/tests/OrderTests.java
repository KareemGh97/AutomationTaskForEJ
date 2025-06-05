package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class OrderTests extends BaseTest {

    @Test (description = "Test Complete Order Flow")
    public void testCompleteOrderFlow() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add product to cart
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart(0);
        productsPage.goToCart();

        // Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // Fill checkout info
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutInfo("John", "Doe", "12345");
        checkoutPage.clickFinishButton();

        // Verify order complete
        CompletePage completePage = new CompletePage(driver);
        Assert.assertEquals(completePage.getCompleteMessage(), "Thank you for your order!");
    }
}