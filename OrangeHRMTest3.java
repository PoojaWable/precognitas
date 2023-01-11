public class OrangeHRMTest3 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup Selenium webdriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchEmployee() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("Admin", "admin123");
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/index.php/dashboard", "Login failed");
        EmployeePage employeePage = new EmployeePage(driver);
        employeePage.searchForEmployee("Ronaldo");
        String searchResult = employeePage.getSearchResult();
        Assert.assertTrue(searchResult.contains("Ronaldo Nazario"), "Search result not found");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
