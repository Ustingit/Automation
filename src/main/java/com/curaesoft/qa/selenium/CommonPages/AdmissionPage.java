package com.curaesoft.qa.selenium.CommonPages;

import com.curaesoft.qa.selenium.Config.Constant;
import com.curaesoft.qa.selenium.lib.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class AdmissionPage {


	public static void main(String[] args) {
        Utility xcel = new Utility();

        Constant data= new Constant();
        String exePath = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(data.webURL);

        try {
            xcel.reader(driver,"resources/admission.xlsx");
        } catch (Exception e) {
            xcel.close(driver);
            e.printStackTrace();
        }


    }
}
