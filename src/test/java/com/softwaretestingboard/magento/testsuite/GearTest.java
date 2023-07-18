package com.softwaretestingboard.magento.testsuite;

import com.softwaretestingboard.magento.customlisteners.CustomListeners;
import com.softwaretestingboard.magento.pages.GearPage;
import com.softwaretestingboard.magento.pages.HomePage;
import com.softwaretestingboard.magento.pages.OvernightDuffle;
import com.softwaretestingboard.magento.pages.ShoppingCartPage;
import com.softwaretestingboard.magento.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {

    HomePage homePage ;
    GearPage gearPage ;
    OvernightDuffle overNightDuffle ;
    ShoppingCartPage shoppingCartPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        gearPage = new GearPage();
        overNightDuffle = new OvernightDuffle();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test(groups = {"sanity","regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException

    {
        Thread.sleep(2000);
        homePage.mouseHoverOnGearMenu();
        homePage.clickOnBags();
        gearPage.clickOnProductGear();
        Assert.assertEquals(overNightDuffle.getOverNightDuffelText(),"Overnight Duffle");
        overNightDuffle.changeQuantityTo3("3");
        overNightDuffle.clickOnAddToCart();
        Assert.assertEquals(overNightDuffle.getAddToCartText(),"You added Overnight Duffle to your shopping cart.");
        overNightDuffle.clickOnShoppingCart();
        Assert.assertEquals(shoppingCartPage.getOverNightDuffeleText(),"Overnight Duffle");
        Assert.assertEquals(shoppingCartPage.getQty(),"3");
        Assert.assertEquals(shoppingCartPage.getProductPrice(),"$135.00");
        shoppingCartPage.changeQtyOfOverNightDuffle("5");
        shoppingCartPage.clickOnUpdateShoppingCart();
        Assert.assertEquals(shoppingCartPage.getUpdatedProductPrice(),"$225.00");



    }

}
