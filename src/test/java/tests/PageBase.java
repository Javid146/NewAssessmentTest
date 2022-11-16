package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PageBase {
 WebDriver driver;

      public PageBase(WebDriver driver) {this.driver = driver;}

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(css = "#inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInBtn;

    @FindBy(xpath = "//li[contains(@class,'list-group-item')]")
    public List<WebElement> testTwoListGroup;

    @FindBy(xpath = "//button[@id='dropdownMenuButton']")
    public WebElement dropdownBtn;

    @FindBy(xpath = "//button[contains(text(),'Option 1')]")
    public WebElement defaultValueInTestThreeDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    public List<WebElement> dropdownOptions;

    @FindBy(css = "#test-4-div>button")
    public List<WebElement> testFourBtns;

    @FindBy(css = "button#test5-button")
    public WebElement testFiveBtn;

    @FindBy(css = "#test5-alert")
    public WebElement successMsg;


    public void testOneLogin(String username, String password) {
        emailBox.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtn.click();
 }

    public String testSixTable(int row, int cell) {
        WebElement table = driver.findElement(By.xpath("//tr[" + (row + 1) + "]/td[" + (cell + 1) + "]"));
        return table.getText();
    }
}
