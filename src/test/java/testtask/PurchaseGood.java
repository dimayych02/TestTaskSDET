package testtask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseGood {
    public WebDriver driver;

    public PurchaseGood(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath="//button[text()='Add to cart'][1]")
    private WebElement AddGood;

    @FindBy(css ="a[class=\"shopping_cart_link\"]")
    private WebElement ShoppingCartButton;

    @FindBy(id ="checkout")
    private WebElement CheckoutButton;

    @FindBy(id="first-name")
    private WebElement FillFirstName;

    @FindBy(css="input[id=\"last-name\"]")
    private WebElement FillLastName;

    @FindBy(xpath="//input[@id=\"postal-code\"]")
    private WebElement FillPostalCode;

    @FindBy(name = "continue")
    private WebElement ButtonContinue;

    @FindBy(xpath ="//button[text()='Finish']")
    private WebElement ButtonFinish;

    @FindBy(className = "complete-header")
    private WebElement TextAssert;



    public void AddingGood(){

        AddGood.click();

        ShoppingCartButton.click();

        CheckoutButton.click();

    }

    public void FillForm(String firstname,String lastname,String postalCode){

       FillFirstName.sendKeys(firstname);

       FillLastName.sendKeys(lastname);

       FillPostalCode.sendKeys(postalCode);

       ButtonContinue.click();

       ButtonFinish.click();

    }

    public String CheckText(){

       return TextAssert.getText();
    }
    public String CheckCurrentUrl(){

        return driver.getCurrentUrl();

    }
}
