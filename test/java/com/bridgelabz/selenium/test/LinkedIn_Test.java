/*
 *Purpose : Class is implemented for testing all those methods written for respective
 *          operations on application.
 *
 * @author Vaishnavi Satish Birle
 * @version 1.0
 * @since 25-06-2021
 */

package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.pages.Home_Page;
import com.bridgelabz.selenium.pages.Login_Page;
import com.bridgelabz.selenium.utility.listener.CustomListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

/*@Desc- @Test annotation used for testing the application
*@Listener annotation for taking screenshots on failing and succeeding of test cases
* @Test1 for logging into application
* @Test2 for viewing profile page
* @Test3 for searching on particular application
* @Test4 for posting what we feel
* @Test5 for posting media like photo,video on application
* @Test6 for logging out from application*/

@Listeners(CustomListener.class)
public class LinkedIn_Test extends BaseClass {
    @Test
    public void login() throws InterruptedException{
        Login_Page login = new Login_Page(driver);
        String actualTitle = login.login();
        String expectedTitle = "Feed | LinkedIn";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Login Successfull..!");
    }

    @Test
    public void profilePage() throws InterruptedException {
        Login_Page login = new Login_Page(driver);
        login.login();
        Home_Page home = new Home_Page();
        String actualTitle = home.profile_page();
        String expectedTitle = "Vaishnavi Birle | LinkedIn";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Open profile page successfull!!");

    }

    @Test
    public void searchTest() throws InterruptedException {
        Login_Page login = new Login_Page(driver);
        login.login();
        Home_Page page = new Home_Page();
        String actualTitle = page.search_in_page();
        String expectedTitle = "Brillio: Overview | LinkedIn";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Search is done successfully!!");

    }

    @Test
    public void postTest() throws InterruptedException, AWTException {
        Login_Page login = new Login_Page(driver);
        login.login();
        Home_Page post = new Home_Page();
        post.sharePost();
        String actualTitle = post.sharePost();
        String expectedTitle = "Feed | LinkedIn";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Post is shared successfully!!");
    }

    @Test
    public void  photoTest() throws InterruptedException, AWTException {
        Login_Page login = new Login_Page(driver);
        login.login();
        Home_Page imgPost = new Home_Page();
        String actualTitle = imgPost.sharePhoto();
        String expectedTitle = "Feed | LinkedIn";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Photo is posted successfully!!");
    }

    @Test
    public void logoutTest() throws InterruptedException {
        Login_Page login = new Login_Page(driver);
        login.login();
        Login_Page logOut = new Login_Page(driver);
        String actualTitle = logOut.logout();
        String expectedTitle = "LinkedIn: Log In or Sign Up";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("You are logout from application.");

    }
}
