package com.curaesoft.qa.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.curaesoft.qa.selenium.Config.Constant;



public class ExcelUtils {
	private static FileInputStream ExcelFile;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;



	static int error ;

	static int[] inputError  = new int[2];
	static int[] clickError  = new int[2];
	static int[] visibleError  = new int[2];
	static int[] getTextError  = new int[2];
	static int[] controlError  = new int[2];
	static int[] enableError  = new int[2]
			;
	static int[] getValueError  = new int[2];
	static int[] matchTextError  = new int[2];
	static int[] matchValueError  = new int[2];
	static int[] urlError  = new int[2];


	static String[] account = new String[2];
	static String srcfile;
	int timeout = 10;
	int close_delay = 3;
	ExcelUtils util;

	public void reader(WebDriver driver, String excel_link)throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("resources/"+excel_link));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int num_rows = firstSheet.getLastRowNum();

		srcfile = excel_link;

		for(int i = 1; i <= num_rows; i++) {
			Row rows = firstSheet.getRow(i);
			this.action(
					driver,
					sformat(rows,0),
					sformat(rows,1),
					sformat(rows,2),
					sformat(rows,3),
					iformat(rows,4),
					iformat(rows,5),
					iformat(rows,6),
					sformat(rows,7),
					iformat(rows,8),
					i
			);

		}
//        System.out.printf("\n--------------------------------------------------");
//        System.out.printf("\n Execute Input: %s/%s", (inputError[0]-inputError[1]) , inputError[0]);
//        System.out.printf("\n Execute Click: %s/%s", (clickError[0]-clickError[1]) , clickError[0]);
//        System.out.printf("\n Execute Get Text: %s/%s", (getTextError[0]-getTextError[1]) , getTextError[0]);
//        System.out.printf("\n Execute Get Value: %s/%s", (getValueError[0]-getValueError[1]) , getValueError[0]);
//        System.out.printf("\n Execute Send Keys: %s/%s", (controlError[0]-controlError[1]) , controlError[0]);
//        System.out.printf("\n Execute Match Text: %s/%s", (matchTextError[0]-matchTextError[1]) , matchTextError[0]);
//        System.out.printf("\n Execute Match Value: %s/%s", (matchValueError[0]-matchValueError[1]) , matchValueError[0]);
//        System.out.printf("\n Execute Match URL: %s/%s", (urlError[0]-urlError[1]) , urlError[0]);
//        System.out.printf("\n Visibility Field Checked: %s/%s", (visibleError[0]-visibleError[1]) , visibleError[0]);
//        System.out.printf("\n Enable Field Checked: %s/%s", (enableError[0]-enableError[1]) , enableError[0]);
//        System.out.printf("\n Execute Action : %s/%s", (num_rows-error) ,num_rows);
//        System.out.printf("\n--------------------------------------------------");
		workbook.close();
		inputStream.close();

	}
	public void action(WebDriver driver, String field, String xpath, String action, String value, int clicks, int delay_b , int delay_a, String deflt,int skip ,int rownum) throws Exception {
		util = new ExcelUtils();
		try {
			Thread.sleep(1000 * delay_b);

			if(action.equals("input")){
				Constant con = new Constant();
				if(!deflt.equals("")){
					this.input(driver,field,xpath,con.map(deflt));

				}else{
					this.input(driver,field,xpath,value);
				}
			}else if(action.equals("click")){
				this.click(driver,field,xpath,value,clicks);

			}else if(action.equals("checked")){
				this.checked(driver,field,xpath,value);

			}else if(action.equals("visible")){
				this.visible(driver,field,xpath);

			}else if(action.equals("get_text")){
				this.get_text(driver,field,xpath);

			}else if(action.equals("control")){
				this.control(driver,field,xpath,value,clicks);

			}else if(action.equals("enable")){
				this.enable(driver,field,xpath);

			}else if(action.equals("get_value")){
				this.get_value(driver,field,xpath);

			}else if(action.equals("match_text")){
				this.match_text(driver,field,xpath,value);

			}else if(action.equals("match_value")){
				this.match_value(driver,field,xpath,value);

			}else if(action.equals("validate_url")){
				this.validate_url(driver,field,value);

			}else if(action.equals("refresh")){
				this.refresh(driver);

			}else{
				System.out.printf("\n Action is not registered.", field);
			}


			Thread.sleep(1000 * delay_a);
		} catch (Exception e) {
//			error++;

			if(skip == 0){

				Assert.fail("Fail to locate xpath on row number "+(rownum+1)+" in "+ srcfile + "\n\n"+e);
				throw e;
			}else{
				System.out.println(e);
			}

		}


	}


	public void input( WebDriver driver,String field, String xpath, String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			element.clear();
			element.sendKeys(value);
//            System.out.printf("\n Input text %s to %s.",value, field);
		}else {
			inputError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		inputError[0]++;
	}

	public void click(WebDriver driver, String field, String xpath, String value , int clicks) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			for (int x = 0; x < clicks; x++) {
				try{
					int tdelay = value.equals("") ? 0 : Integer.parseInt(value);
					Thread.sleep(1000 * tdelay);
				}catch (Exception e){System.out.println(e);};
				element.click();
			}
//            System.out.printf("\n Element %s has been clicked.", field);
		}else {
			clickError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		clickError[0]++;
	}

	public void checked(WebDriver driver, String field, String xpath, String value ) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		if(eCheck(element)){
			String result = element.getAttribute("aria-checked");
			if(result.equals("false")){
				try{
					int tdelay = value.equals("") ? 0 : Integer.parseInt(value);
					Thread.sleep(1000 * tdelay);
				}catch (Exception e){System.out.println(e);};
				element.click();
			}

		}else {
			System.out.printf("\n Element %s does not exist.", field);
		}

	}

	public void visible(WebDriver driver, String field, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
//            System.out.printf("\n Element %s is visible.", field);
		}else {
			visibleError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		visibleError[0]++;
	}

	public void get_text(WebDriver driver, String field, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
//            System.out.printf("\n %s = %s", field, element.getText());
		}else {
			getTextError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		getTextError[0]++;
	}

	public void match_text(WebDriver driver, String field, String xpath , String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			if(value.equals(element.getText())){
//                System.out.printf("\n %s (%s : %s)(Success) ", field, value , element.getText());
			}else {
				matchTextError[1]++;
//                System.out.printf("\n %s (%s : %s)(Fail)", field, value , element.getText());
			}

		}else {
			matchTextError[1]++;
//            System.out.printf("\n Element %s does not exist.", field);
		}
		matchTextError[0]++;
	}
	public void match_value(WebDriver driver, String field, String xpath , String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			if(value.equals(element.getText())){
//                System.out.printf("\n %s (%s : %s)(Success)", field, value, element.getAttribute("value"));
			}else {
				matchValueError[1]++;
//                System.out.printf("\n %s (%s : %s)(Fail)", field, value, element.getAttribute("value"));
			}

		}else {
			matchValueError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		matchValueError[0]++;
	}
	public void validate_url(WebDriver driver, String field, String value) {

		String weburl = driver.getCurrentUrl();
		if(weburl != null){
			if(weburl.equals(value)){
				System.out.printf("\n URL Matched : %s", value);
			}else {
				urlError[1]++;
				System.out.printf("\n URL does not match.",value);
			}

		}else {
			urlError[1]++;
			System.out.printf("\n Fail to get url.", field);
		}
		urlError[0]++;
	}
	public void get_value(WebDriver driver, String field, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
//            System.out.printf("\n %s = %s", field, element.getAttribute("value"));
		}else {
			getValueError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		getValueError[0]++;
	}

	public void enable(WebDriver driver, String field, String xpath) {
		WebElement element =driver.findElement(By.xpath(xpath));
		boolean result = element.isEnabled();
		if(result){
//            System.out.printf("\n %s is enable.", field, element.getAttribute("value"));
		}else {
			enableError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		enableError[0]++;
	}

	public void control(WebDriver driver,String field, String xpath, String value, int clicks) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			for (int x = 0; x < clicks; x++) {
				if(value=="escape"){
					element.sendKeys(Keys.ESCAPE);
//                    System.out.printf("\n Key press escape.", field);
				}else if(value=="enter"){
					element.sendKeys(Keys.ENTER);
//                    System.out.printf("\n Key press enter.", field);
				}else if(value=="up"){
					element.sendKeys(Keys.ARROW_UP);
//                    System.out.printf("\n Key press up.", field);
				}else if(value=="down"){
					element.sendKeys(Keys.ARROW_DOWN);
//                    System.out.printf("\n Key press down.", field);
				}else{
//                    System.out.printf("\n Key is not registered.", field);
				}
			}
		}else {
			controlError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		controlError[0]++;

	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
//        System.out.printf("\n Page Refresh.");
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

	public boolean eCheck(WebElement element){
		if(element.isDisplayed() && element != null){
			return true;
		}else{
			return  false;
		}
	}

	public void execute(WebDriver driver, String excelPath) {
		util = new ExcelUtils();

		try {
			this.reader(driver,excelPath);
		} catch (Exception e) {
			e.printStackTrace();
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


	// This Method get the Email and password from excel file.

	public String[] getRole(String Path, String SheetName, String Role) throws Exception  {
		try{
			setExcelFile(Path,SheetName);
			int num_rows = ExcelWSheet.getLastRowNum();
			for(int i = 1; i <= num_rows; i++) {
				Row rows = ExcelWSheet.getRow(i);
				String qRole= sformat(rows, 2);
				if(qRole.equals(Role)){

					account[0] = sformat(rows, 0);
					account[1] = sformat(rows, 1);
				}

			}
			closeExcelStream();
		}catch (Exception e){
			throw (e);
		}

		return account;
	}




	// This method is to set the File path and to open the Excel file,
	// Pass Excel Path and Sheet name as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void closeExcelStream() throws Exception {
		try {

			ExcelWBook.close();
			ExcelFile.close();
		} catch (Exception e) {
			throw (e);
		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			throw (e);

		}
	}
}
