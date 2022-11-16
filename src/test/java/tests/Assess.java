package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.URISyntaxException;


import static org.testng.Assert.*;

public class Assess {
    WebDriverWait wait;
    WebDriver driver;
    PageBase pgBase;

    @BeforeMethod
    public void beforeMethod() throws URISyntaxException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get(WebDriverFactory.getFile("index.html"));
        pgBase = PageFactory.initElements(driver, PageBase.class);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void afterTest(){driver.quit();}

    @Test
    public void test1(){
        assertTrue(pgBase.emailBox.isDisplayed());
        assertTrue(pgBase.passwordInput.isDisplayed());
        assertTrue(pgBase.signInBtn.isDisplayed());
        pgBase.testOneLogin("javid.mammadli@gmail.com","12345");
    }

    @Test
    public void test2() {
        assertEquals(pgBase.testTwoListGroup.size(), 3);
        String secondListItem = "List Item 2";
        assertTrue(pgBase.testTwoListGroup.get(1).getText().contains(secondListItem));
        String secondBadgeValue = pgBase.testTwoListGroup.get(1).findElement(By.cssSelector("span")).getText();
        assertEquals(secondBadgeValue, "6");
    }

    @Test
    public void test3() {
        assertEquals(pgBase.defaultValueInTestThreeDropdown.getText().trim(),"Option 1");
        pgBase.dropdownBtn.click();
        WebElement lastItemInDropdown = pgBase.dropdownOptions.get(pgBase.dropdownOptions.size() - 1);
        lastItemInDropdown.click();
    }

    @Test
    public void test4() {
        assertTrue(pgBase.testFourBtns.get(0).isEnabled());
        assertFalse(pgBase.testFourBtns.get(1).isEnabled());
    }

    @Test
    public void test5() {
        wait.until(ExpectedConditions.visibilityOf(pgBase.testFiveBtn));
        pgBase.testFiveBtn.click();
        assertEquals(pgBase.successMsg.getText(), "You clicked a button!");
        assertFalse(pgBase.testFiveBtn.isEnabled());
    }

    @Test
    public void test6() {
        String word = pgBase.testSixTable(2,2);
        assertEquals(word, "Ventosanzap");
    }
}