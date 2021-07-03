/*
 *Purpose : Class is implemented [pom] model to find the url of particular application.
 *
 * @author Vaishnavi Satish Birle
 * @version 1.0
 * @since 25-06-2021
 */

package com.bridgelabz.selenium.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/*@Description - Created BaseClass
* used setUp method for setting up browser url
* used @BeforeTest and @AfterTest annotation */

public class BaseClass {

    public  static WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
