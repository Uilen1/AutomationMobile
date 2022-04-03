package utils;

import static factory.DriverFactory.*;
import static io.appium.java_client.touch.WaitOptions.*;
import static io.appium.java_client.touch.offset.PointOption.*;

import constants.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class Utils implements Constants {

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy HH_mm_sss");

    /**
     * Take a screenShoot the screen of the device
     *
     * */
    public void screenShot() throws Exception {
        try {
            File screenShot = getDriver().getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot,new File("evidencias/screenShots/"+ sdf.format(date)+".png"));
        }catch (Exception e){
            throw  new Exception("Não foi possível tirar o screeShot da tela");
        }
    }
    /**
     * Method to get properties from file setup.properties in root path
     * */
    public static Properties getProp() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream(
                    "setup.properties");
            props.load(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        return props;
    }


/**
 * Change the context of the application between Native_app and WebView.
 *
 * */
    public void changeContext (String contextToChoice){
        Set<String> contextChoiced = getDriver().getContextHandles();
        getDriver().context(
                contextChoiced
                .stream()
                .filter(c -> c.contains(contextToChoice.toUpperCase(Locale.ROOT)))
                .collect(Collectors.toList())
                .get(0)
        );
    }
/**
 * This method is used to verify if the element is to present in the DOM
 * */
    public boolean elementIsPresent(By by) {
           List<MobileElement> elements = getDriver().findElements(by);
           return elements.size() > 0;
    }

    public void waitElementeDisapearOfScreen(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitElement(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitVisibilityOfElement(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitVisibilityOfElement(MobileElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scroll (double start,double end){
        Dimension dimension = getDriver().manage().window().getSize();
        int x = dimension.width/2;

        int start_y = (int) (dimension.height*start);
        int end_y = (int) (dimension.height*end);

        new TouchAction(getDriver())
                .press(point(x,start_y))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .moveTo(point(x,end_y))
                .release()
                .perform()
        ;
    }
    public void scrollDownToElement (By element){
        Dimension dimension = getDriver().manage().window().getSize();
        int count = 0;
        int x = dimension.width/2;
        int start_y = (int) (dimension.height*0.9);
        int end_y = (int) (dimension.height*0.1);

        while (!elementIsPresent(element) && count<10){
            new TouchAction(getDriver())
                    .press(point(x,start_y))
                    .waitAction(waitOptions(Duration.ofMillis(500)))
                    .moveTo(point(x,end_y))
                    .release()
                    .perform()
            ;
            count++;
        }
    }
    public void scrollUpToElement (By by){
        Dimension dimension = getDriver().manage().window().getSize();
        int count =0;
        int x = dimension.width/2;
        int start_y = (int) (dimension.height*0.1);
        int end_y = (int) (dimension.height*0.9);

        while (!elementIsPresent(by) && count<10){
            new TouchAction(getDriver())
                    .press(point(x,start_y))
                    .waitAction(waitOptions(Duration.ofMillis(500)))
                    .moveTo(point(x,end_y))
                    .release()
                    .perform()
            ;
            count++;
        }
    }

    public void swipe (double start,double end){
        Dimension dimension = getDriver().manage().window().getSize();
        int y = dimension.height/2;

        int start_x = (int) (dimension.width*start);
        int end_x = (int) (dimension.width*end);

        new TouchAction(getDriver())
                .press(point(start_x,y))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .moveTo(point(end_x,y))
                .release()
                .perform()
        ;
    }
    public void swipeRigthToElement (By by){
        Dimension dimension = getDriver().manage().window().getSize();
        int count =0;
        int y = dimension.height/2;
        int start_x = (int) (dimension.width*0.9);
        int end_x = (int) (dimension.width*0.1);

        while (!elementIsPresent(by) && count<10){
            new TouchAction(getDriver())
                    .press(point(start_x,y))
                    .waitAction(waitOptions(Duration.ofMillis(500)))
                    .moveTo(point(end_x,y))
                    .release()
                    .perform()
            ;
            count++;
        }
    }
    public void swipeLeftToElement (By by){
        Dimension dimension = getDriver().manage().window().getSize();
        int count =0;
        int y = dimension.height/2;
        int start_x = (int) (dimension.width*0.1);
        int end_x = (int) (dimension.width*0.9);

        while (!elementIsPresent(by) && count<10){
            new TouchAction(getDriver())
                    .press(point(start_x,y))
                    .waitAction(waitOptions(Duration.ofMillis(500)))
                    .moveTo(point(end_x,y))
                    .release()
                    .perform()
            ;
            count++;
        }
    }
}
