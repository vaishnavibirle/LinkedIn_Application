package com.bridgelabz.selenium.utility.listener;

import com.bridgelabz.selenium.base.BaseClass;
import com.bridgelabz.selenium.utility.CaptureScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListener extends BaseClass implements ITestListener {

    CaptureScreenshot captureScreenshot = new CaptureScreenshot();

    //onTestFailure method is used when test is failed it will take screenshot automatically
    public void onTestFailure(ITestResult result) {
        System.out.println("Method failed " + result.getName());
        try {
            captureScreenshot.captureScreenshot(result.getName(), "failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }



    @Override
    public void onStart(ITestContext context) {


    }

    @Override
    public void onFinish(ITestContext context) {


    }


    public void onTestStart(ITestResult result) {


    }

    //onTestSuccess method is used when test is passed it will take screenshot automatically
    public void onTestSuccess(ITestResult result) {
        System.out.println("Method passed " + result.getName());
        try {
            captureScreenshot.captureScreenshot(result.getName(), "success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
