package utils;


import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Reports {

	SoftAssert sa = new SoftAssert();
	private static final String EXPECTEDSTR = "Expected ";
	private static final String ACTUALSTR = "Actual ";

   /*...Extent Report Methods...*/
	public void extentInfo(String info) {
		Markup m = MarkupHelper.createCodeBlock(info);
		ExtentCucumberAdapter.getCurrentStep().info(m);
	}

	public void  extentInfo(String expResult,String actResult) {
		Markup m = MarkupHelper.createCodeBlock(EXPECTEDSTR+expResult, ACTUALSTR+actResult);
		ExtentCucumberAdapter.getCurrentStep().info(m);
	}
//	public void extentScreenshots(ExtentTest test,String message, String screenshotPath) {
//		Markup m = MarkupHelper.createLabel(message, "INFO");
//		try {
//			// Attach the screenshot to the test
//			test.info((Throwable) m, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public void  extentPass(String actResult) {
		Markup m = MarkupHelper.createCodeBlock(ACTUALSTR+actResult);
		ExtentCucumberAdapter.getCurrentStep().pass(m);
		softAssertTrue(true);
	}

	public void extentPass(String expResult,String actResult) {
		Markup m = MarkupHelper.createCodeBlock(EXPECTEDSTR+expResult, ACTUALSTR+actResult);
		ExtentCucumberAdapter.getCurrentStep().pass(m);
		softAssertTrue(true);
	}

	public void  extentFail(String actResult) {
		Markup m = MarkupHelper.createCodeBlock(ACTUALSTR+actResult);
		ExtentCucumberAdapter.getCurrentStep().fail(m);
		softAssertFail(actResult);
	}

	public void extentFail(String expResult,String actResult) {
		Markup m = MarkupHelper.createCodeBlock(EXPECTEDSTR+expResult, ACTUALSTR+actResult);
		ExtentCucumberAdapter.getCurrentStep().fail(m);
		softAssertFail(actResult);
	}


    /*...Assertions Methods...*/

	public void softAssertEquals(String actual,String expected) {
		sa.assertEquals(actual, expected);
	}

	public void softAssertTrue(boolean condition) {
		sa.assertTrue(condition);
	}

	public void softAssertEquals(int actual,int expected) {
		sa.assertEquals(actual, expected);
	}
	public void softAssertFail() {
		sa.fail();
	}

	public void softAssertFail(String message) {
		sa.fail(message);
	}

	public void softAssertAll() {
		sa.assertAll();
	}

	public void hardFail(String message) {
		Assert.fail(message);
	}
	public void addScreenshotToReportForPass(String screenshotPath, String description) {
		try {             // Create a media entity combining the screenshot with the description
			  ExtentCucumberAdapter.getCurrentStep().pass(description,
					  MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			// Handle any exceptions, such as IOException
			System.err.println("Error occurred while adding screenshot to report: " + e.getMessage());
			e.printStackTrace();
		}

	}
}

