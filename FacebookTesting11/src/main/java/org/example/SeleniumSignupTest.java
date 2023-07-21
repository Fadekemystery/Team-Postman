package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class SeleniumSignupTest{
    //import the selenium webdriver
    private WebDriver driver;

    public SeleniumSignupTest() {

    }
    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. open your chrome browser
        driver = new ChromeDriver();
        //2. input your selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        //Test 1. verify that user input the right URL on the webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("correct webpage");
        else
            //fail
        System.out.println("wrong webpage");
        Thread.sleep(5000);
        //3.maximise the browser
        driver.manage().window().maximize();
        //4. click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void positiveSignup() throws InterruptedException {
        //5. input your username on the username field
        //Test 7.  Verify that user is successfully signed up when valid details are inputted
        driver.findElement(By.id("user_username")).sendKeys("fadekemi234");
        //6. input your email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("fadekemititilayo89@yahoo.com");
        //7. input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Revelation0102");
        //click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void clickUserItem() throws InterruptedException {
        //9. click on User1 item on listpage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test 2.  Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedUrl = "https://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. search for an item(using Python with Selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        //Test 2.  Verify that when user clicks on the signup button, the user is directed to the signup page
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("correct User1Page");
        else
            //fail
            System.out.println("wrong User1Page");
        Thread.sleep(5000);
    }

        @Test(priority = 3)
                public void logoutSuccessfully(){
        //11. click on log out
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10. . Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle))
            //pass
            System.out.println("correct webpage");
        else
            //fail
            System.out.println("wrong webpage");
    }

    @Test(priority = 4)
    public void negativeSignup() throws InterruptedException{
        //click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test 3. Verify that user cannot signup with username less than 3 characters
        //input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("fa");
        //6. input your email address on the email field
        driver.findElement(By.id("user_email")).sendKeys("fadekemititilayo125@yahoo.com");
        //7. input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("Revelation0102");
        //click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }


    @AfterTest
    public void closeBrower(){
        //Quit the browser
        driver.quit();
    }
}





