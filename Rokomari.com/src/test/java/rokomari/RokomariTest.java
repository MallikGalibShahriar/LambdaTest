package rokomari;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
public class RokomariTest{
    public String username = "mgalibshahriar";
    public String accesskey = "s2lsaC0eoB1ehDwQORWRUBKvCeM4P76SIMIps02McH5lB0zc1Z";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    @BeforeClass
    public void setUp() throws Exception {
       DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "Rokomari.com");
        capabilities.setCapability("name", "Rokomari.com");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testRokomari() throws Exception {
      driver.get("https://www.rokomari.com/book");
      driver.findElement(By.linkText("Sign in")).click();
      driver.get("https://www.rokomari.com/login");
      driver.findElement(By.id("j_username")).clear();
      driver.findElement(By.id("j_username")).sendKeys("abcd@gmail.com");
      driver.findElement(By.id("j_password")).click();
      driver.findElement(By.id("j_password")).clear();
      driver.findElement(By.id("j_password")).sendKeys("hello1234");
      driver.findElement(By.xpath("//form[@id='loginForm']/div[2]/div/div[2]/span/i")).click();
      driver.findElement(By.xpath("//form[@id='loginForm']/div[2]/div/div[2]/span/i")).click();
      driver.findElement(By.xpath("//form[@id='loginForm']/button")).click();
      driver.findElement(By.xpath("//div[@id='login-registration']/div/section/div[2]/div/p[2]")).click();
      driver.findElement(By.xpath("//div[@id='login-registration']/div/section/div[2]/div/p")).click();
      driver.findElement(By.xpath("//form[@id='loginForm']/div[3]/div/div/label")).click();
      driver.findElement(By.xpath("//form[@id='loginForm']/div[3]/div/div")).click();
      driver.findElement(By.linkText("Sign Up Now!")).click();
      driver.findElement(By.id("nm")).click();
      driver.findElement(By.id("nm")).clear();
      driver.findElement(By.id("nm")).sendKeys("ABCD");
      driver.findElement(By.id("js-email")).click();
      driver.findElement(By.id("js-email")).clear();
      driver.findElement(By.id("js-email")).sendKeys("abcd@gmail.com");
      driver.findElement(By.id("pwd")).click();
      driver.findElement(By.id("pwd")).clear();
      driver.findElement(By.id("pwd")).sendKeys("QtGdHXC9CS#gUmR");
      driver.findElement(By.id("js-phone")).click();
      driver.findElement(By.id("js-phone")).clear();
      driver.findElement(By.id("js-phone")).sendKeys("521436184");
      //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=2 | ]]
      driver.findElement(By.xpath("//span[@id='recaptcha-anchor']/div")).click();
      //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
      driver.findElement(By.xpath("//form[@id='accountForm']/button")).click();
    }

    @AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}