package com.curaesoft.qa.selenium.CommonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AdmissionPage {

    public static WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/md-content/div/section/div[8]/button")
    public static WebElement Operation;

    @FindBy(how = How.XPATH, using = "//*[@id='password']")
    public static WebElement Admission;

    public AdmissionPage(WebDriver driver) {
        this.driver = driver;
    }

	public void navitage() throws Exception {
        Operation.click();
        Admission.click();
    }

    public void tabs(String tab) throws Exception {

	    if(tab.equals("")){

        }else
        Operation.click();
        Admission.click();
    }

}
