package test;

import general.SeleniumTest;
import org.junit.jupiter.api.Test;
import steps.FirstPageSteps;
import steps.GeneralSteps;

public class FirstPageTest extends SeleniumTest {
    private GeneralSteps generalSteps;
    private FirstPageSteps firstPageSteps;

    public void initialize(){
        generalSteps = new GeneralSteps(driver);
        firstPageSteps = new FirstPageSteps(driver);

        generalSteps.getTestedPage();
    }

    @Test
    public void testFirstPage(){
        initialize();

        firstPageSteps.clickOnPlaceholder();
        firstPageSteps.getPlaceholderText();
        firstPageSteps.verifyPlaceholderText("Toto je placeholder pre prvy assert", "Expected placeholder");
    }
}
