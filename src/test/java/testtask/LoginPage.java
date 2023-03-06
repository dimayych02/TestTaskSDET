package testtask;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy(css = "input[id='user-name']")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement SubmitButton;

    @FindBy(css="h3[data-test=\"error\"]")
    private WebElement errorMessage;


    public void Authorization(String login,String password){

        loginField.sendKeys(login);

        passwordField.sendKeys(password);

        SubmitButton.click();
    }

    public String getInvalidMessage(){

        String InvalidMessage = errorMessage.getText();

        return InvalidMessage;
    }

}
