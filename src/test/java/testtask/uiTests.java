package testtask;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class uiTests  {

    public SoftAssert softAssert;

    public static LoginPage loginPage;
    public static PurchaseGood purchaseGood;
    public static WebDriver driver;

    @BeforeMethod
    public void Configuration(){

        softAssert = new SoftAssert();

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);

        purchaseGood = new PurchaseGood(driver);

    }

    @Test
    public void testCase1() {

        driver.get("https://www.saucedemo.com/");

        loginPage.Authorization("standard_user","secret_sauce");

        purchaseGood.AddingGood();

        purchaseGood.FillForm("test","test","test");

        softAssert.assertEquals(purchaseGood.CheckText(),"Thank you for your order!");

        softAssert.assertEquals(purchaseGood.CheckCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");

        softAssert.assertAll();



    }

    @Test
    public void testCase2() {

        driver.get("https://www.saucedemo.com/");

        loginPage.Authorization("test","test");

        softAssert.assertEquals(loginPage.getInvalidMessage(),"Epic sadface: Username and password do not match any user in this service");

        softAssert.assertAll();




    }
    @AfterMethod
    public void tearDown(){

        softAssert = null;

        if(driver!=null){  //закрытие браузера после каждого теста

            driver.close();

            driver=null;
        }


    }

}