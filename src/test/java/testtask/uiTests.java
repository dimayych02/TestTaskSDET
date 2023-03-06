package testtask;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;


public class uiTests extends browserConfiguration {

    @Test
    public void testCase1(){

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElements(By.xpath("//button[text()='Add to cart']")).get(0).click();

        driver.findElement(By.cssSelector("a[class=\"shopping_cart_link\"]")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("test");

        driver.findElement(By.cssSelector("input[id=\"last-name\"]")).sendKeys("test");

        driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("test");

        driver.findElement(By.name("continue")).click();

        JavascriptExecutor javascriptExecutor =(JavascriptExecutor) driver; //скроллинг страницы вниз

        javascriptExecutor.executeScript("window.scrollBy(0,600)");

        driver.findElement(By.xpath("//button[text()='Finish']")).click();


        String actualResult  = driver.findElement(By.className("complete-header")).getText();


        String CurrentUrl = driver.getCurrentUrl();

        softAssert.get().assertEquals(CurrentUrl,"https://www.saucedemo.com/checkout-complete.html"); // мягкая проверка на текущий URL

        softAssert.get().assertEquals(actualResult,"Thank you for your order!"); // мягкая проверка на  соответствие текста

        softAssert.get().assertAll();



    }
    @Test
    public void testCase2(){

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("test");

        driver.findElement(By.id("password")).sendKeys("test");

        driver.findElement(By.xpath("//input[@type='submit']")).click();


        String ErrorMessage = driver.findElement(By.cssSelector("h3[data-test=\"error\"]")).getText();

        softAssert.get().assertEquals(ErrorMessage,"Epic sadface: Username and password do not match any user in this service");

        //мягкая проверка на соответствие текста

        softAssert.get().assertAll();
    }

}
