package stepDefs;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import data.Constants.Labels;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.ScenarioContext;
import utilities.TestContext;

/**
 * Steps relating to the login page are stored here
 */
public class LoginStepDef
{
    private LoginPage loginPage;
    private HomePage homePage;
    private ScenarioContext scenarioContext;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Initialise page classes into objects
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise the page
     */
    public LoginStepDef(TestContext testContext)
    {
        loginPage = testContext.getPageObjectManager().getLoginPage();
        homePage = testContext.getPageObjectManager().getHomePage();
        scenarioContext = testContext.getScenarioContext();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Navigate to the correct URL
     */
    @Given("^I have navigated to the correct URL$")
    public void navigateToUrl()
    {
        loginPage.launchUrl();
        assertThat(loginPage.getLogo()).isVisible();
    }
    
    /**
     * Enter a value into a field
     * <p>
     * @param fieldValue Value to enter
     * @param fieldName The field to enter the value into
     */
    @When("^I enter (.*) as the (.*)$")
    public void enterValueIntoField(String fieldValue, String fieldName)
    {
        loginPage.enterValueIntoField(fieldName, fieldValue);
        if (fieldName.contentEquals(Labels.EMAIL))
        {
            scenarioContext.setContext(ScenarioContext.Context.USERS.EMAIL, fieldValue);
        }
    }
    
    /**
     * Click a button
     * <p>
     * @param buttonName The name of the button to click
     */
    @When("^I click the (.*) button$")
    public void clickButton(String buttonName)
    {
        loginPage.clickButton(buttonName);
    }
    
    /**
     * Click the logo icon
     */
    @When("^I click the logo icon$")
    public void clickLogo()
    {
        loginPage.clickLogo();
    }
    
    /**
     * Click the Need help? link
     */
    @When("^I click the Need help link$")
    public void clickNeedHelp()
    {
        loginPage.clickNeedHelp();
    }
    
    /**
     * Check your email is present on the user home page
     */
    @Then("^my email will be present in the user home page$")
    public void checkEmailOnHomePage()
    {
        assertThat(homePage.getUserEmail()).hasText(scenarioContext.getScenarioContextAsString(ScenarioContext.Context.USERS.EMAIL));
    }
    
    /**
     * Check the correct error message is displayed
     * <p>
     * @param errorMessage The error message to check for
     */
    @Then("^I will get the (.*) error message$")
    public void checkErrorMessage(String errorMessage)
    {
        assertThat(loginPage.getMessage()).containsText(errorMessage);
    }
    
    /**
     * Check you are on the site home page
     */
    @Then("^I will be redirected to the Site Home Page$")
    public void checkSiteHomePage()
    {
        assertThat(homePage.getLogo()).isVisible();
    }
    
    /**
     * Check you are take to the correct section
     * <p>
     * @param sectionName The name of the section
     */
    @Then("^I will be taken to the (.*) section$")
    public void checkSectionName(String sectionName)
    {
        assertThat(loginPage.getSectionName()).containsText(sectionName);
    }
}