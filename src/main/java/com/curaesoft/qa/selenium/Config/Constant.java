package com.curaesoft.qa.selenium.Config;

import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
public class Constant {

	//QA Site
	//public static final String webURL = "https://104.198.15.201";
	//Dev Site
	//public static final String webURL = "http://104.199.117.46:9999/#/login";
	//Dev Site secure
	//public static final String webURL = "https://104.199.117.46/#/login";

	public static final String webURL = "https://35.185.205.136";

	public static final String browserType = "*chrome";
	public static final String File_TestData = "resources/Testdata.xlsx";
	public static final String excelSheetName = "FirstSet";
	// Roles
	public static final String QA_ROLE = "qa";
	public static final String CLINICIAN_ROLE = "clinician";
	public static final String MANAGER_ROLE = "manager";
	public static final String INTAKE_ROLE = "Intake";

	public static final int width = 1440;
	public static final int height = 900;

	public static final HashMap<String,String> edata = new HashMap<String, String>();

	public static final boolean Debugging  = false;
	public static boolean Success= true;

	public static final String lname = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
	//public static final String lname ="20170316082058";

	public static String map (String val){

		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

		edata.put("firstname","Test");
		edata.put("lastname",lname);
		edata.put("clinician","");
		//edata.put("lastname","20170518052949");

		edata.put("date",new SimpleDateFormat("MM-dd-yyyy").format(tomorrow).toString());


		return edata.get(val);
	}



}
