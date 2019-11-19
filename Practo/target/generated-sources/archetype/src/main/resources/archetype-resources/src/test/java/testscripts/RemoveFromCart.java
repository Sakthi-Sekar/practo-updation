#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import ${package}.pages.PageActions;
import ${package}.utils.Validate${artifactId};

public class RemoveFromCart extends AddToCart {
	Validate${artifactId} practo = new Validate${artifactId}();

	// Remove CBC Test from the cart
	@Test(priority = 3)
	public void cartAfterRemovalOfSample() throws Exception {
		Xpath = read.readPropertiesFile("loc.removecbcfromcart.xpath");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageActions.clickOnElement(driver, Xpath);
		Thread.sleep(5000);
		log.info("CBC Test sample removed...");
	}

	// Validation after removing one sample test from the cart

//	@Test(priority = 4)
//	public void validateCartAfterRemoval() {
//		practo.validateRemainingSampleNames();
//		practo.validateNumberOfTestCount();
//		practo.validatePriceAfterRemoval();
//		practo.validatePickupChargeAfterRemoval();
//		practo.validateFinalPrice();
//
//	}
}