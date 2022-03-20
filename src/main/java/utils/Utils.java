package utils;

import static factory.DriverFactory.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

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
}
