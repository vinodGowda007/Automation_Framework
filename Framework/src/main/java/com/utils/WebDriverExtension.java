//package com.utils;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.Listeners.ExtentReportListeners;
//
//
//
//public class WebDriverExtension  {
//
//	// Navigate to URL
//	public void NavigateToTestEnvironment() {
//		try {
//			launchBrowser();
//			driver.navigate().to(ConfigFileReader.readDataFromPropertyFile("url"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static boolean WaitAndclick(By by) {
//		try {
//
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
//			return true;
//		} catch (AssertionError | Exception e) {
//			
//			ExtentReportListeners.testStepHandle("FAIL", driver, null, e);
//			return false;
//		}
//	}
//
////	public static String getScreenshot() {
////		
////		TakesScreenshot screenshot = (TakesScreenshot)driver;
////		File file = screenshot.getScreenshotAs(OutputType.FILE);
////		String Filepath = "./Report/Screenshot/"+"image";
////		try {
////			FileUtils.copyFile(file, new File(Filepath));
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
//////			e.printStackTrace();
////		}
////		return Filepath;	
////
////	}
////
////	public static String getScreenshotAsBase64() throws IOException 
////	{
////		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
////		String path = System.getProperty("user.dir")+"/Report/Screenshots/image.png";
////		FileUtils.copyFile(source, new File(path));
////		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
////		return Base64.getEncoder().encodeToString(imageBytes);
////	}
//
//}
