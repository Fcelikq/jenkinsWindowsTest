package com;

import Pages.CalculatePage;
import Utilities.BaseTest;
import org.testng.annotations.*;
public class CalculatorTest extends BaseTest {

    CalculatePage calculatePage;
    @Test
    public void TestPlus() throws InterruptedException {
        calculatePage=new CalculatePage(driver);
       calculatePage.TestLogin(configurationGet.getEmail(), configurationGet.getPassword());
    }

}
