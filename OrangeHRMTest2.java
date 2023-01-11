import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTest2 {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void testSearchEmployee() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement usernameElement = driver.findElement(By.id("txtUsername"));
        WebElement passwordElement = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        usernameElement.sendKeys("Admin");
        passwordElement.sendKeys("admin123");
        loginButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/index.php/dashboard", "Login failed");
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Ronaldo");
        driver.findElement(By.id("searchBtn")).click();
        String searchResult = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]")).getText();
        Assert.assertEquals(searchResult, "Ronaldo Nazario","Employee Not Found");
    }
    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
