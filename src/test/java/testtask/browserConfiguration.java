package testtask;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class browserConfiguration {
protected WebDriver driver;

ThreadLocal<SoftAssert> softAssert = new ThreadLocal<SoftAssert>(); //local variable


    @BeforeMethod
    public void setUp(){   //инициализация браузера и мягкой проверки

        softAssert.set(new SoftAssert());

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();



    }


    @AfterMethod
    public void ExitBrowser(){

        if(driver!=null){  //закрытие браузера после каждого теста
            driver.close();
            driver=null;
        }
    }


}
