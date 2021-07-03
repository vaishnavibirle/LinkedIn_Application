/*
 *Purpose : Class is implemented with page factory model to find the webElements
 *          by using locators in Login Page and implemented login method for logging into
 *          application.
 *
 * @author Vaishnavi Satish Birle
 * @version 1.0
 * @since 25-06-2021
 */

package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*@Description-Created Login_Page Class for logging in the application
* */

public class Login_Page extends BaseClass {

    @FindBy(className = "nav__button-secondary")
    WebElement Sign_In;
    @FindBy(id = "username")
    WebElement email_or_username;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(className = "login__form_action_container")
    WebElement signin_btn;


    public  Login_Page(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String login() throws InterruptedException {
        Sign_In.click();
        Thread.sleep(1000);
        email_or_username.sendKeys("vaishnavibirle1133@gmail.com");
        Password.sendKeys("vaishnavi@123");
        signin_btn.click();
        Thread.sleep(2000);
        return driver.getTitle();
    }
}
