package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.WomenJacketsPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class WomenJacketsTest extends BaseTest {


    HomePage homepage;
    WomenJacketsPage womenpage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homepage = new HomePage();
        womenpage = new WomenJacketsPage();

    }


    @Test(groups = {"sanity", "regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(2000);
        homepage.mouseHoverOnWomenMenu();
        Thread.sleep(2000);
        homepage.mouseHoverOnTops();
        Thread.sleep(2000);
        homepage.clickOnJackets();
        womenpage.selectProductNameFilter("Product Name");

        Assert.assertEquals(womenpage.getProductList1(), womenpage.getProductList2());
        womenpage.selectProductNameFilter("Price");
        Assert.assertEquals(womenpage.getProductPriceList1(), womenpage.getProductPriceList2());
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        homepage.mouseHoverOnWomenMenu();
        Thread.sleep(2000);
        homepage.mouseHoverOnTops();
        Thread.sleep(2000);
        homepage.clickOnJackets();
        womenpage.selectProductNameFilter("Price");
        Assert.assertEquals(womenpage.getProductPriceList1(), womenpage.getProductPriceList2());

    }


}
