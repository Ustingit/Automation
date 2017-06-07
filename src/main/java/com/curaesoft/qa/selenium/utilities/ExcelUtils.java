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
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import com.curaesoft.qa.selenium.Config.Constant;
import com.curaesoft.qa.selenium.CommonPages.LoginPage;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
	static String sheetn;
	static int grownumber =0;
	int timeout = 10;
	int close_delay = 3;
	ExcelUtils util;

	public void reader(WebDriver driver, String excel_link, String Sheetname)throws Exception {

		FileInputStream inputStream = new FileInputStream(new File("resources/"+excel_link));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheet(Sheetname);
		int num_rows = firstSheet.getLastRowNum();

		srcfile = excel_link;
		sheetn = Sheetname;
		for(int i = 1; i <= num_rows; i++) {
			Row rows = firstSheet.getRow(i);
			grownumber = i+1;
			this.action(
					driver,
					sformat(rows,0),	// Element name or attribute name(only for match_custom)
					sformat(rows,1),	//xpath
					sformat(rows,2),	//action
					sformat(rows,3),	//value
					iformat(rows,4),	//click
					iformat(rows,5),	//delay before click second
					iformat(rows,6),	//delay after click second
					sformat(rows,7),	//custom_value
					iformat(rows,8),	//Skip on error
					sformat(rows,9),	//error notice
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
	public void action(WebDriver driver, String field, String xpath, String action, String value, int clicks, int delay_b , int delay_a, String deflt,int skip ,String error_notice ,int rownum) throws Exception {
		util = new ExcelUtils();
		try {
			Thread.sleep(1000 * delay_b);

			if(xpath.contains("%1$2s")){
				if(!deflt.equals("")){
					xpath = String.format(xpath,Constant.map(deflt));
				}else{
					xpath = String.format(xpath,value);
				}
			}




			if(action.equals("input")){
				Constant con = new Constant();
				if(!deflt.equals("")){
					this.input(driver,field,xpath,con.map(deflt));

				}else{
					this.input(driver,field,xpath,value);
				}
			}else if(action.equals("click")){
				this.click(driver,field,xpath,value,clicks);

			}else if(action.equals("dragY")){
				this.dragY(driver,xpath,value);

			}else if(action.equals("click_custom")){
				this.click_custom(driver,field,xpath,value,clicks);

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
				Constant con = new Constant();
				if(!deflt.equals("")){
					this.match_text(driver,field,xpath,con.map(deflt));
				}else{
					this.match_text(driver,field,xpath,value);
				}

			}else if(action.equals("match_value")){
				Constant con = new Constant();
				if(!deflt.equals("")){
					this.match_value(driver,field,xpath,con.map(deflt));
				}else{
					this.match_value(driver,field,xpath,value);
				}
			}else if(action.equals("match_custom")){
				Constant con = new Constant();
				if(!deflt.equals("")){
					this.match_custom(driver,field,xpath,con.map(deflt));
				}else{
					this.match_custom(driver,field,xpath,value);
				}
			}else if(action.equals("setAttribute")){
				this.setAttribute(driver,field,xpath,value);

			}else if(action.equals("refresh")){
				this.refresh(driver);

			}else if(action.equals("function")){
				this.function(driver,xpath,value);

			}else if(action.equals("focus")){
				this.focus(driver,xpath,value);

			}else if(action.equals("hover")){
				this.hover(driver,xpath);

			}else if(action.equals("signature")){
				this.signature(driver,xpath);

			}else{
				System.out.printf("\n"+(rownum+1)+": Action is not registered.", field);
			}


			Thread.sleep(1000 * delay_a);
		} catch (Exception e) {

			Constant.Success = false;
			if(skip == 0){
				if(error_notice.equals("")){
					Assert.fail("Fail to locate xpath on row number "+(rownum+1)+" in "+ srcfile +"("+ sheetn+")"+"\n\n"+e);
				}else{
					Assert.fail(srcfile +"("+ sheetn+") "+(rownum+1)+":"+error_notice);
				}

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
		}
	}
	public void focus( WebDriver driver, String xpath, String value) {

		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}
	public void click(WebDriver driver, String field, String xpath, String value , int clicks) {

		WebElement element = isExisting(driver,xpath);
		if(eCheck(element)){
			for (int x = 0; x < clicks; x++) {
				try{
					int tdelay = value.equals("") ? 0 : Integer.parseInt(value);
					Thread.sleep(1000 * tdelay);
				}catch (Exception e){System.out.println(e);};
				element.click();
			}
		}
	}
	public void signature(WebDriver driver, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			Actions builder = new Actions(driver);
			builder.moveToElement(element,100,100) //start points x axis and y axis.
					.clickAndHold()
					.moveByOffset(50,0)
					.moveByOffset(0,50)
					.moveByOffset(-50,0)
					.moveByOffset(0,-50)
					.release()
					.build().perform();
		}
	}
	public void dragY(WebDriver driver, String xpath, String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			Actions move = new Actions(driver);
			move.dragAndDropBy(element, 0,Integer.parseInt(value)).build().perform();
		}
	}
	public void hover(WebDriver driver, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}

	}
	public void click_custom(WebDriver driver, String field, String xpath, String value , int clicks) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			for (int x = 0; x < clicks; x++) {
				try{
					int tdelay = value.equals("") ? 0 : Integer.parseInt(value);
					Thread.sleep(1000 * tdelay);
				}catch (Exception e){System.out.println(e);};
				element.click();
			}
		}
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
		}
	}

	public void visible(WebDriver driver, String field, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		if(!eCheck(element)){
			Assert.fail(grownumber+": Element Not Visible");
		}
	}

	public void get_text(WebDriver driver, String field, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){

		}
	}

	public void match_text(WebDriver driver, String field, String xpath , String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		if(!value.equals(element.getText())){
			Assert.fail("Text did not matched on the given value in row "+grownumber+" in "+ srcfile );
		}
		if (Constant.Debugging == true){
			System.out.println(grownumber+" : Element value is "+element.getText());
		}
	}
	public void match_value(WebDriver driver, String field, String xpath , String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		if(!value.equals(element.getAttribute("value"))){
			Assert.fail("Value did not matched on the given value in row "+grownumber+" in "+ srcfile );
		}
		if (Constant.Debugging == true){
			System.out.println(grownumber+" : Element value is "+element.getAttribute("value"));
		}
	}
	public void match_custom(WebDriver driver, String field, String xpath , String value) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		if(!value.equals(element.getAttribute(field))){
			Assert.fail("Value did not matched on the given value in row "+grownumber+" in "+ srcfile );
		}
		if (Constant.Debugging == true){
			System.out.println(grownumber+" : Element "+field+" value is "+element.getAttribute(value));
		}
	}
	public void validate_url(WebDriver driver, String field, String value) {

		String weburl = driver.getCurrentUrl();
		if(weburl != null){
			if(weburl.equals(value)){
				System.out.printf("\n URL Matched : %s", value);
			}

		}
		if (Constant.Debugging == true){
			System.out.println(grownumber+" : Current url is "+weburl);
		}
	}
	public void get_value(WebDriver driver, String field, String xpath) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			System.out.println(grownumber+" : Element value is "+element.getAttribute("value"));
		}
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
	public void setAttribute(WebDriver driver, String field, String xpath , String value)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].setAttribute('"+field+"', '"+value+"')",element);

	}
	public void control(WebDriver driver,String field, String xpath, String value, int clicks) {

		WebElement element = (new WebDriverWait(driver, timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		if(eCheck(element)){
			for (int x = 0; x < clicks; x++) {
				if(value.equals("escape")){
					element.sendKeys(Keys.ESCAPE);
				}else if(value.equals("enter")){
					element.sendKeys(Keys.ENTER);
				}else if(value.equals("up")){
					element.sendKeys(Keys.ARROW_UP);
				}else if(value.equals("down")){
					element.sendKeys(Keys.ARROW_DOWN);
				}else{
					element.sendKeys(Keys.chord(value));
				}
			}
		}else {
			controlError[1]++;
			System.out.printf("\n Element %s does not exist.", field);
		}
		controlError[0]++;

	}

	public void account() {
		Constant con = new Constant();
		System.out.println("Firstname:"+con.map("firstname"));
		System.out.println("Lastname:"+con.map("lastname"));
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void function(WebDriver driver,String field,String value) {
		LoginPage lp = new LoginPage(driver);

		if(field.equals("login")){
			lp.login(value);
		}else if(field.equals("logout")){
			lp.logout();
		}
	}

	public String sformat(Row row,int column){
		try{
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(row.getCell(column));
			if(val.equals("") || val == null){
				return  "";
			}else{
				return val;
			}
		}catch (Exception e){

			e.printStackTrace();
			System.out.println(grownumber);
			return  "";
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
			System.out.println(grownumber);
			return 0;
		}

	}

	public boolean eCheck(WebElement element){
		if(element != null && element.isDisplayed()){
			return true;
		}else{
			return  false;
		}
	}


	public void execute(WebDriver driver, String excelPath, String Sheet) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		util = new ExcelUtils();

		try {
			this.reader(driver,excelPath,Sheet);
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

	public WebElement isExisting(WebDriver driver, String xpath) {
		try {
			List<WebElement> count = driver.findElements(By.xpath(xpath));
			if(count.size() > 0){
				return count.get(0);
			}else {
				return null;
			}
		} catch (Exception e) {
			return null;
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
