public class LoginPage {
    private WebDriver driver;
    private By username = By.id("txtUsername");
    private By password = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String username, String password) {
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

public class OrangeHRMTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup Selenium webdriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void testLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/index.php/dashboard", "Login failed");
    }
    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
