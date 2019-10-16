package com.alex.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationCareerFormInputs {



    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void startWebDriver() {
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.jobs.net/jobs/intrasoft-intl/en-us/");
        driver.findElement(By.id("JoinWidgetSubmitButton")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("cb-secure-joinform");
    }

    //email input
    public void emailFieldInput(String email) {
        driver.findElement(By.xpath("//*[@id='MxDOTalentNetworkMember" +
                "Info_EmailAddress']")).sendKeys(email);
    }


    //location input
    public void locationFieldInput(String location){
        driver.findElement(By.xpath("//*[@id='ContentPlaceHolder__ctl0__ctl0_ucJoin" +
                "Form_ucJoinQuestionListV2_rptRequired__ctl1__ctl0_txtLocation']")).sendKeys(location);
    }

    //Desired Job Title input
    public void desiredJobFieldInput(String desiredJobTitle){
        driver.findElement(By.xpath("//*[@id='ContentPlaceHolder__ctl0__ctl0_ucJoin" +
                "Form_ucJoinQuestionListV2_rptRequired__ctl2_JQKD1LF6KC0D4P3VVNRV']")).sendKeys(desiredJobTitle);
    }

    //Policy and Terms checkbox
    public void policyTermsCheckboxInput(){
        driver.findElement(By.xpath("//*[@id=\"accept-privacy-policy-and-terms-checkbox\"]")).click();
    }

    // upload pdf file
    public void uploadDocumentInput(final String PATH)  {
        WebElement element =   driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder__ctl0__ctl0_ucJoinForm_ucJoin" +
                "QuestionListV2_rpt" +
                "Required__ctl3_resume-upload-control_MxDOTalentNetworkMemberInfo_ResumeWordDoc\"]"));
        element.sendKeys(PATH);
    }


    //Submit form button
    public void joinSubmitButtonClick() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"Submit2\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);  //scroll to button
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"Submit2\"]")).click();
    }


    public void closeConnection() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
