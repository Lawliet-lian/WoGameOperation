import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class test {
    public WebDriver driver;
    List<WebElement> menu2List;

    /**
     * 初始化driver，并且打开地址
     * */
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://oms.wogame-test.com/login");
        sleep(2000L);
    }

    public void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        InitDriver();
        driver.findElement(By.name("account")).clear();
        driver.findElement(By.name("account")).sendKeys("11425");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.className("el-button")).click();
    }

    @Test
    public void menu(){
        login();
        sleep(2000L);
        WebElement element = driver.findElement(By.className("el-menu"));
        List<WebElement> menu1List = element.findElements(By.className("el-submenu"));

        for(int i = 0; i < menu1List.size(); i++){
            menu1List.get(i).click();
            sleep(1000L);
            menu2List = menu1List.get(i).findElements(By.className("el-menu-item"));
            for(int j = 0; j < menu2List.size(); j++){
                menu2List.get(j).click();
            }

        }

    }


}




