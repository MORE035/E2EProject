package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import E2EProject.BrowseOpen;


public class ITestListners extends BrowseOpen  implements ITestListener{

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test case Started");

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case passed");
	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			getScreenShot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
