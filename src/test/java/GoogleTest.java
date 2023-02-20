
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


class GoogleTest {
    private static WebDriver driver;
    private static long time;


    @BeforeAll
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\gk\\IdeaProjects\\JUnitSelenium\\src\\main\\resources\\chromedriver.exe");
        driver= new ChromeDriver();
        long start= System.currentTimeMillis();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        long end= System.currentTimeMillis();
        time= end -start;

    }

    @Test
    @Order(1)
    public void timeOfLoad(){
        Assertions.assertTrue(time<5000, "Time is "+time+ " ms");

    }

    @Test
    @Order(2)
    public void checkTitle(){
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @Test
    @Order(3)
    public void find(){
        WebElement input = driver.findElement(By.xpath("//input[@title='Поиск']"));
        String text ="Text";
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.google.com/search?q="));
    }



    @AfterAll
    public static void close(){
        //driver.close();
    }

}