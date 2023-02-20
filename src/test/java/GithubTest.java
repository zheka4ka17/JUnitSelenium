
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class GithubTest {
    private static WebDriver driver;
    private static final String baseURL = "https://www.github.com/";


    @BeforeAll
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\gk\\IdeaProjects\\JUnitSelenium\\src\\main\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

    }



    @Test
    @Order(2)
    public void checkTitle(){
        Assertions.assertEquals(true, driver.getTitle().toUpperCase().contains("Github".toUpperCase()));
    }

    @Test
    @Order(3)
    public void find(){
       driver.get(baseURL+ "login");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("sign in".toUpperCase()));
    }

    @Test
    @Order(4)
    public void singIn(){
       WebElement login = driver.findElement(By.id("login_field"));
       WebElement password = driver.findElement(By.id("password"));
       login.sendKeys("zheka4ka17@gmail.com");
       password.sendKeys("272690Demon");
       WebElement button = driver.findElement(By.xpath("//input[@name='commit']"));
       button.click();

    }



    @AfterAll
    public static void close(){
        //driver.close();
    }

}