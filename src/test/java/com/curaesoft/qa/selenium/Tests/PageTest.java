package com.curaesoft.qa.selenium.Tests;
import com.curaesoft.qa.selenium.CommonPages.LoginPage;
import org.junit.Test;
import com.curaesoft.qa.selenium.CommonPages.AdmissionPage;
public class PageTest {

    @Test
    public void aLoginPageTest() {
        LoginPage page = new LoginPage();
        page.execute();
    }

    @Test
    public void bAdmissionPageTest() {
        AdmissionPage page = new AdmissionPage();
        page.execute();
    }


}
