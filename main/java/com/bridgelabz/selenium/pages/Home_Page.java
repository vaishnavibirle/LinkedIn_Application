/*
 *Purpose : Class is implemented with page factory model to find the webElements
 *          by using locators in Home Page and implemented different methods for
 *          viewing profile page , searching, for posting what wr feel, for posting
 *          media like photos , videos , etc on the application..
 *
 * @author Vaishnavi Satish Birle
 * @version 1.0
 * @since 25-06-2021
 */

package com.bridgelabz.selenium.pages;

import com.bridgelabz.selenium.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Home_Page extends BaseClass {

    /*Used FindBy Annotation for finding elements using locators*/
    @FindBy(linkText = "Vaishnavi Birle")
    WebElement profile;

    @FindBy(xpath = "//a[@href='/in/vaishnavi-birle-915429178/edit/intro/']")
    WebElement pencil;

    @FindBy(xpath = "//div[@class='pe-form-footer__actions display-flex justify-space-between']")
    WebElement save;

    @FindBy(xpath ="//input[@placeholder='Search']")
    WebElement search;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/brillio/']")
    WebElement name;

    @FindBy(xpath = "//div[@class = 'display-flex align-items-center mt2 mr4 ml4']")
    WebElement post;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]")
    WebElement element;

    @FindBy(className = "share-box_actions")
    WebElement share;

    @FindBy(xpath = "//li-icon[@type='image-icon']//*[local-name()='svg']")
    WebElement photo;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]/span[1]")
    WebElement done;

    /*Used parameterized  constructor
     * with page factory model*/

    public Home_Page() {
        PageFactory.initElements(driver,this);
    }

    /*Created method for operating operations on profile page*/

    public String profile_page() throws InterruptedException {
        profile.click();
        Thread.sleep(4000);
        pencil.click();
        Thread.sleep(3000);
        save.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }

    /*@Desc - Created method for searching anything on the page
     * Used action class for performing search box operation*/

    public String search_in_page() throws InterruptedException {
        Actions actions = new Actions (driver);
        actions.sendKeys(search,"Brillio").build().perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        name.click();
        Thread.sleep(3000);
        return driver.getTitle();
    }

    /*@Desc-Called method setPost for using all the elements to be done
     * with operations.
     * Used Action class for moving elements and sending keys
     * And also for uploading media*/

    public String sharePost() throws InterruptedException {

        Actions post_action = new Actions(driver);

        post_action.moveToElement(post).click().perform();
        Thread.sleep(4000);

        post_action.sendKeys(element,"Hello All..!!").build().perform();
        Thread.sleep(4000);

        post_action.moveToElement(share).click().perform();
        Thread.sleep(3000);

        return driver.getTitle();
    }

    /*@Desc - Added Robot Class
     * Performed robot for uploading media
     * Here copied the media address using setClipboardData
     * used robot key events for operating operations*/

    public String sharePhoto() throws InterruptedException, AWTException {
        Robot robot = new Robot();

        post.click();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        photo.click();
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        setClipboardData("C:\\Users\\irg\\OneDrive\\Pictures\\tree-276014__340.jpg");
        Thread.sleep(2000);

        done.click();
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        share.click();
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        return driver.getTitle();
    }

    /*Setting the path of particular media which u wanna post
    * used robot class for copy and pasting the path*/

    public void setClipboardData(String string) throws InterruptedException, AWTException {
        Robot robot = new Robot();

        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(3000);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);

        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
