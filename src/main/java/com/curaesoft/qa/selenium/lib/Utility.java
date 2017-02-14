package com.curaesoft.qa.selenium.lib;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utility {


    static int error ;
    static int match_error;
    static int match_total;
    int timeout = 10;
    int close_delay = 3;
    Utility util;

    public void reader(WebDriver driver, String excel_link)throws Exception {
        util = new Utility();
        FileInputStream inputStream = new FileInputStream(new File(excel_link));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        int num_rows = firstSheet.getLastRowNum();


        for(int i = 1; i <= num_rows; i++) {
            Row rows = firstSheet.getRow(i);
            util.action(
                    driver,
                    sformat(rows,0),
                    sformat(rows,1),
                    sformat(rows,2),
                    sformat(rows,3),
                    iformat(rows,4),
                    iformat(rows,5),
                    iformat(rows,6)
            );

        }
        System.out.printf("\n--------------------------------");
        System.out.printf("\n Success Field Checked : %s/%s", (match_total-match_error) , match_total);
        System.out.printf("\n Success Execution : %s/%s", (num_rows-error) ,num_rows);
        System.out.printf("\n--------------------------------");
        workbook.close();
        inputStream.close();

        util.close(driver);
    }
    public void action(WebDriver driver, String field, String xpath, String action, String value, int clicks, int delay_b , int delay_a) {
        util = new Utility();
        try {
            Thread.sleep(1000 * delay_b);

                if(action.equals("input")){
                    util.input(driver,field,xpath,value);

                }else if(action.equals("click")){
                    util.click(driver,field,xpath,value,clicks);

                }else if(action.equals("visible")){
                    util.visible(driver,field,xpath);

                }else if(action.equals("get_text")){
                    util.get_text(driver,field,xpath);

                }else if(action.equals("control")){
                    util.control(driver,field,xpath,value,clicks);

                }else if(action.equals("enable")){
                    util.enable(driver,field,xpath);

                }else if(action.equals("get_value")){
                    util.get_value(driver,field,xpath);

                }else if(action.equals("match_text")){
                    util.match_text(driver,field,xpath,value);

                }else if(action.equals("match_value")){
                    util.match_value(driver,field,xpath,value);

                }else if(action.equals("validate_url")){
                    util.validate_url(driver,field,value);

                }else{
                    System.out.printf("\n Action is not registered.", field);
                }

            Thread.sleep(1000 * delay_a);
        } catch (Exception e) {
            error++;
            e.printStackTrace();
        }


    }


    public void input( WebDriver driver,String field, String xpath, String value) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        if(element != null){
            element.sendKeys(value);
            System.out.printf("\n Input text %s to %s.",value, field);
        }else {
            System.out.printf("\n Element %s does not exist.", field);
        }
    }

    public void click(WebDriver driver, String field, String xpath, String value , int clicks) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if(element != null){
            for (int x = 0; x < clicks; x++) {

                try{
                    int tdelay = value.equals("") ? 0 : Integer.parseInt(value);
                    Thread.sleep(1000 * tdelay);
                }catch (Exception e){System.out.println(e);};
                element.click();
            }
            System.out.printf("\n Element %s has been clicked.", field);
        }else {
            System.out.printf("\n Element %s does not exist.", field);
        }
    }

    public void visible(WebDriver driver, String field, String xpath) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if(element != null){
            System.out.printf("\n Element %s is visible.", field);
        }else {
            System.out.printf("\n Element %s does not exist.", field);
        }
    }

    public void get_text(WebDriver driver, String field, String xpath) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if(element != null){
            System.out.printf("\n %s = %s", field, element.getText());
        }else {
            System.out.printf("\n Element %s does not exist.", field);
        }
    }

    public void match_text(WebDriver driver, String field, String xpath , String value) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if(element != null){
            if(value.equals(element.getText())){
                System.out.printf("\n %s (%s : %s)(Success) ", field, value , element.getText());
            }else {
                match_error++;
                System.out.printf("\n %s (%s : %s)(Fail)", field, value , element.getText());
            }

        }else {
            match_error++;
            System.out.printf("\n Element %s does not exist.", field);
        }
        match_total++;
    }
    public void match_value(WebDriver driver, String field, String xpath , String value) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if(element != null){
            if(value.equals(element.getText())){
                System.out.printf("\n %s (%s : %s)(Success)", field, value, element.getAttribute("value"));
            }else {
                match_error++;
                System.out.printf("\n %s (%s : %s)(Fail)", field, value, element.getAttribute("value"));
            }

        }else {
            match_error++;
            System.out.printf("\n Element %s does not exist.", field);
        }
        match_total++;
    }
    public void validate_url(WebDriver driver, String field, String value) {

        String weburl = driver.getCurrentUrl();
        if(weburl != null){
            if(weburl.equals(value)){
                System.out.printf("\n URL Matched : %s", value);
            }else {
                match_error++;
                System.out.printf("\n URL does not match.",value);
            }

        }else {
            match_error++;
            System.out.printf("\n Fail to get url.", field);
        }
        match_total++;
    }
    public void get_value(WebDriver driver, String field, String xpath) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if(element != null){
            System.out.printf("\n %s = %s", field, element.getAttribute("value"));
        }else {
            System.out.printf("\n Element %s does not exist.", field);
        }
    }

    public void enable(WebDriver driver, String field, String xpath) {
        WebElement element =driver.findElement(By.xpath(xpath));
        boolean result = element.isEnabled();
        if(result){
            System.out.printf("\n %s is enable.", field, element.getAttribute("value"));
        }else {
            System.out.printf("\n Element %s does not exist.", field);
        }
    }

    public void control(WebDriver driver,String field, String xpath, String value, int clicks) {

        WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        for (int x = 0; x < clicks; x++) {
            if(value=="escape"){
                element.sendKeys(Keys.ESCAPE);
                System.out.printf("\n Key press escape.", field);
            }else if(value=="enter"){
                element.sendKeys(Keys.ENTER);
                System.out.printf("\n Key press enter.", field);
            }else if(value=="up"){
                element.sendKeys(Keys.ARROW_UP);
                System.out.printf("\n Key press up.", field);
            }else if(value=="down"){
                element.sendKeys(Keys.ARROW_DOWN);
                System.out.printf("\n Key press down.", field);
            }else{
                System.out.printf("\n Key is not registered.", field);
            }
        }


    }

    public String sformat(Row row,int column){

        DataFormatter formatter = new DataFormatter();
        String val = formatter.formatCellValue(row.getCell(column));
        if(val.equals("") || val == null){
            return  "";
        }else{
            return val;
        }
    }
    public Integer iformat(Row row,int column){

        try{
            DataFormatter formatter = new DataFormatter();
            String val =formatter.formatCellValue(row.getCell(column));
            if(val.equals("") || val == null){
                return  0;
            }else{
                return  Integer.parseInt(val);
            }
        }catch (Exception e){

            e.printStackTrace();
            System.out.printf("\n diri nag error.");
            return 0;
        }

    }


    //close browser with delay
    public void close(WebDriver driver) {
        try {
            Thread.sleep(1000 * close_delay);
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
