package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestNonValidEmailAddressTC6 {

    RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();

    //email validation error
    public void testEmailAcceptance() {
        boolean displayed =false;
        String errorMsg = rcfi.getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder__ctl0__ctl0_ucJoin" +
                "Form_ucJoinQuestionListV2_rptRequired__ctl0_formGroupDiv']/div/div[2]")).getText();

       displayed = rcfi.getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder__ctl0__ctl0_ucJoin" +
                "Form_ucJoinQuestionListV2_rptRequired__ctl0_formGroupDiv']/div/div[2]")).isDisplayed();
        System.out.println(errorMsg);
        Assert.assertTrue("Error: email format looks good", displayed);
    }

    @Test
    public void testNonValidEmailInput() throws InterruptedException {
        rcfi.startWebDriver();

        rcfi.emailFieldInput("testgmail.com");      //non valid email address
        Thread.sleep(3000);

        rcfi.locationFieldInput("12241");
        Thread.sleep(1000);

        rcfi.desiredJobFieldInput("Software Engineer");
        Thread.sleep(1000);

        rcfi.policyTermsCheckboxInput();
        Thread.sleep(1000);

        rcfi.uploadDocumentInput(CONSTANTS.PATHTOPDFFILE);
        Thread.sleep(1000);

        testEmailAcceptance();

//        rcfi.joinSubmitButtonClick();
//        Thread.sleep(1000);

    }
}
