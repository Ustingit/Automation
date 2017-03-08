package com.curaesoft.qa.selenium.Config;

import java.util.Date;
import java.util.HashMap;

public class Constant {
	public static final String webURL = "http://104.198.15.201:9999/#/login";
	public static final String browserType = "*chrome";
	public static final String File_TestData = "resources/Testdata.xlsx";
	public static final String excelSheetName = "FirstSet";
	// Roles
	public static final String QA_ROLE = "qa";
	public static final String CLINICIAN_ROLE = "clinician";
	public static final String MANAGER_ROLE = "manager";
	public static final String INTAKE_ROLE = "Intake";

	public static final HashMap<String,String> edata = new HashMap<String, String>();

	public static String map (String val){
		edata.put("firstname","p382017");
		edata.put("lastname","u1231");
		edata.put("date","03-08-2017");


		return edata.get(val);
	}
}
