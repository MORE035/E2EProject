package ItestListners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
   System.out.println(result.getMethod());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
result.isSuccess()	;
System.out.println(result.isSuccess());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		result.getThrowable();
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		result.getInstanceName();
		System.out.println(result.getInstanceName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
