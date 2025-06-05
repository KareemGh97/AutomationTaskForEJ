package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductsPage {

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return title.isDisplayed();
    }

    public void addProductToCart(int index) {
        inventoryItems.get(index).findElement(By.tagName("button")).click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}