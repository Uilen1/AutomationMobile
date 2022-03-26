package utils;

import static factory.DriverFactory.*;

import constants.Constants;
import factory.DriverFactory;
import io.appium.java_client.MobileElement;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils implements Constants {

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy HH_mm_sss");
    public void screenShot() throws Exception {
        try {
            File screenShot = getDriver().getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot,new File("evidencias/screenShots/"+ sdf.format(date)+".png"));
        }catch (Exception e){
            throw  new Exception("Não foi possível tirar o screeShot da tela");
        }
    }

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

}
