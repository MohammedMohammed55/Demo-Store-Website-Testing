import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestCases {
    @org.testng.annotations.Test
    public void testing() {
        //Chrome options and driver setup
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        opt.addArguments("disable-popup-blocking");
        opt.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mcwga\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://www.demoblaze.com/");

        //signin test with a wrong submission of inputs and a correct one + assertion at the end
        WebElement signinwindow = driver.findElement(By.id("signin2"));
        signinwindow.click();

        WebElement signusernameInput = driver.findElement(By.id("sign-username"));
        WebElement signpasswordInput = driver.findElement(By.id("sign-password"));

        signusernameInput.sendKeys("QWERTUY1235");
        signpasswordInput.sendKeys("123");

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        signusernameInput.clear();

        signusernameInput.sendKeys("QWERTUY1235610");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        WebElement loginwindow = driver.findElement(By.id("login2"));
        Assert.assertTrue(loginwindow.isDisplayed());

        //login test that checks the logout btn to assert
        loginwindow.click();

        WebElement loginusernameInput = driver.findElement(By.id("loginusername"));
        WebElement loginpasswordInput = driver.findElement(By.id("loginpassword"));

        loginusernameInput.sendKeys("QWERTUY1235610");
        loginpasswordInput.sendKeys("123");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        WebElement logoutBtn = driver.findElement(By.id("logout2"));

        Assert.assertTrue(logoutBtn.isDisplayed());

        //searching for item test
        WebElement nextBtn = driver.findElement(By.id("next2"));
        nextBtn.click();

        WebElement wanteditem = driver.findElement(By.linkText("ASUS Full HD"));
        wanteditem.click();

        //adding items to cart test
        WebElement addCart = driver.findElement(By.cssSelector(".btn.btn-success.btn-lg"));
        addCart.click();
        addCart.click();

        //purchasing and item removal tests
        WebElement cartPage = driver.findElement(By.id("cartur"));
        cartPage.click();

        driver.findElement(By.linkText("Delete")).click();

        WebElement submitBtn = driver.findElement(By.cssSelector(".btn.btn-success"));
        submitBtn.click();

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement countryInput = driver.findElement(By.id("country"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement cardInput = driver.findElement(By.id("card"));
        WebElement monthInput = driver.findElement(By.id("month"));
        WebElement yearInput = driver.findElement(By.id("year"));

        countryInput.sendKeys("Turkey");
        cityInput.sendKeys("Istanbul");
        cardInput.sendKeys("083933834829");
        monthInput.sendKeys("October");
        yearInput.sendKeys("2023");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        nameInput.sendKeys("Mohammed");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        WebElement okBtn = driver.findElement(By.xpath("//button[text()='OK']"));
        Assert.assertTrue(okBtn.isDisplayed());
        okBtn.click();

        //contact test
        driver.findElement(By.cssSelector("[data-target='#exampleModal']")).click();

        WebElement remail = driver.findElement(By.id("recipient-email"));
        WebElement rname = driver.findElement(By.id("recipient-name"));
        WebElement message = driver.findElement(By.id("message-text"));

        remail.sendKeys("mohammed@gmail.com");
        rname.sendKeys("mohammed");
        message.sendKeys("i want a refund");

        driver.findElement(By.xpath("//button[text()='Send message']")).click();

        //turn off driver
        driver.quit();
    }
}
