package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class KongaInvalidCardPage {
    private WebDriver driver;

    public KongaInvalidCardPage() {

    }
    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //open your chrome Browser
        driver = new ChromeDriver();
        //input the Konga Url(https://www.konga.com)
        driver.get("https://www.konga.com");
        //verify that user input the right URL on the webpage
        if(driver.getCurrentUrl().contains("https://www.konga.com"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
        //maximise the browser
        driver.manage().window().maximize();
        //click on the signin button to open the signin page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);
    }
        @Test(priority = 0)
        public void PositiveLogin() throws InterruptedException {
            //input valid email on the email field
            driver.findElement(By.id("username")).sendKeys("username");
            //input user password on the password field
            driver.findElement(By.id("password")).sendKeys("userpassword");
            //click on the login button
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(5000);
        }
        @Test(priority = 1)
        public void findComputersandAccessories() throws InterruptedException {
            //click on find Computers and Accessories on the HomePage
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 2)
         public void LaptopsSubcategory() throws InterruptedException{
             //click on laptops
             driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
         Thread.sleep(5000);
    }

         @Test(priority = 3)
         public void clickonAppleMacBook() throws InterruptedException{
            //click on Apple MacBook
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 4)
        public void clickaddItemtoCart() throws InterruptedException {
            //click on add to cart
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[11]/div/div/div[2]/form/div[3]/button")).click();
            //click on my cart to view item on cart overview
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
            Thread.sleep(5000);
            //confirm item count is 1
            driver.findElement(By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[2]/div[1]/form/div/div/div"));
            //click on check out
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
            Thread.sleep(5000);
        }

        @Test(priority = 5)
        public void clickaddDeliveryAddress() throws InterruptedException{
            //click on change
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
            //click on add delivery address
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
            Thread.sleep(5000);
            //click on populated address on the address book
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
            Thread.sleep(5000);
            //click on use this address
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
            Thread.sleep(5000);
            }

        @Test(priority = 6)
         public void clickPaymentOption() throws InterruptedException {
            //scroll down and click on pay now
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
            Thread.sleep(5000);
            //click on continue to payment
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
            Thread.sleep(10000);
            //Switch to iframe
            By locIframe = By.xpath("//*[@id=\"kpg-frame-component\"]");
            driver.switchTo().frame(driver.findElement(locIframe));
            Thread.sleep(8000);
            //select payment method by card
            driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
            Thread.sleep(8000);
            //input invalid card details
            driver.findElement(By.xpath("//*[@id=\"card-exists--false\"]/div[1]")).click();
            //proceed to pay now
            driver.findElement(By.xpath("//*[@id=\"validateCardForm\"]")).click();
            Thread.sleep(5000);
            //print out error message: invalid card number
            driver.findElement(By.xpath("//*[@id=\"card-number\"]")).click();
            //Close the iFrame that displays the input card Modal
            driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
            Thread.sleep(5000);

    }
    @AfterTest
    public void closeBrowser(){
    //Quit browser
    driver.quit();

    }

}



