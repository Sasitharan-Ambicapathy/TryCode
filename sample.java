import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class sample {

    static HomePage home;
    public static void main(String args[])
    {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        home=new HomePage();
        Launch(driver);
        clickMyProfile(driver);
        clickRequestOTP(driver);
    }

    public static void Launch(WebDriver driver)
    {
        driver.get("https://www.flipkart.com");
        clickElement(driver,home.closeButton);
    }

    public static void clickMyProfile(WebDriver driver)
    {
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(home.login)).build().perform();
        waitForElementPresence(driver,By.xpath("//a//div[text()='My Profile']"));
        clickElement(driver,By.xpath("//a//div[text()='My Profile']"));
    }

    public static void clickRequestOTP(WebDriver driver)
    {
        waitForElementPresence(driver,By.xpath("//button[text()='Request OTP']"));
        clickElement(driver,By.xpath("//button[text()='Request OTP']"));
    }

    public static void waitForElementPresence(WebDriver driver, By element)
    {
        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    public static void clickElement(WebDriver driver, By element)
    {
        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

}
