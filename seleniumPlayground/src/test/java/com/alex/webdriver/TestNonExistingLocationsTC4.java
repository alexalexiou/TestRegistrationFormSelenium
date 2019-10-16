package com.alex.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestNonExistingLocationsTC4 {

   RegistrationCareerFormInputs rcfi = new RegistrationCareerFormInputs();


   public void nonExistingLocation(){
       boolean enabled = false;
       enabled = rcfi.getDriver().findElement(By.xpath("//*[@id=\"ContentPlace" +
               "Holder__ctl0__ctl0_ucJoinForm_phErrors\"]")).isDisplayed();
       String msg = rcfi.getDriver().findElement(By.xpath("//*[@id=\"ContentPlace" +
               "Holder__ctl0__ctl0_ucJoinForm_phErrors\"]")).getText();
       System.out.println(msg);
       Assert.assertTrue("False: Location is valid",enabled );
   }


   @Test
   public void testNonValidLocation() throws InterruptedException {


       rcfi.startWebDriver();

       rcfi.emailFieldInput("aasaad@gmail.com");
       Thread.sleep(3000);

       rcfi.locationFieldInput("12");               //invalid area code
       Thread.sleep(1000);

       rcfi.desiredJobFieldInput("Software Engineer");
       Thread.sleep(1000);

       rcfi.policyTermsCheckboxInput();
       Thread.sleep(1000);

       rcfi.uploadDocumentInput(CONSTANTS.PATHTOPDFFILE);
       Thread.sleep(1000);

       rcfi.joinSubmitButtonClick();
       nonExistingLocation();

       Thread.sleep(1000);

      // base.testRegistrationConfirmation();


   }
}
