package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void wait(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchWindowWithTitle(String targetTitle, WebDriver driver){
        Set<String> whdSeti = driver.getWindowHandles();
        for (String eachWhd : whdSeti) {
            driver.switchTo().window(eachWhd);
            String oldugumuzSayfaTitle = driver.getTitle();
            if (oldugumuzSayfaTitle.equals(targetTitle)){
                break;
            }
        }
    }

    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", element);
        scrollPageCertainAmount(0, -200);
        // burada 200 pixel yukarı kaydırma yapılmasının sebebi bazı durumlarda  JavascriptExecutor'ın yaptığı kaydırma
        // işlemi sonrasında elementin sayfada gözükmeyecek şekilde yukarıda kalması ve böylece
        // ElementClickInterceptedException atması durumunun önüne geçmektir.
    }

    public static void scrollPageCertainAmount(int horizontal, int vertical) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");
    }

}



