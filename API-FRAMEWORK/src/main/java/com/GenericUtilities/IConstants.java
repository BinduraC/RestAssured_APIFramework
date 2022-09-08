package com.GenericUtilities;

/**
 * 
 * @author Bindura
 *
 *Interface storing Common data used by multiple files 
 */
public interface IConstants {
     String filepath = "./src/test/resources/common.properties";
     
     String excelpath = "./src/test/resources/commonExcel.xlsx";
     String ddexcelpath = "./src/test/resources/DataProvider.xlsx";
         
     String chromekey = "webdriver.chrome.driver";
     String chromeValue = "./src/main/resources/chromedriver.exe";
     
     String DBurl = "jdbc:mysql://localhost:3306/";
     String DBusername = "root";
     String DBpassword = "root";
     
     String appUserName = "rmgyantra";
     String appPassword = "rmgy@9999";
     
     int implicitlywaitDuration = 10;
     int explicitlywaitDuration = 10;
    
     String screenShotsPath = "./photo/";
}
