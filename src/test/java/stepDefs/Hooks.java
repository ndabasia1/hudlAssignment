package stepDefs;

import utilities.TestContext;

import io.cucumber.java.Before;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

/**
 * Sets up parameters to be run before and after a test
 */
public class Hooks
{
    private TestContext testContext;
    private Page page;
    public static Scenario scenario;

    /**
     * Initialise test context so that the page is created
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise the page
     */
    public Hooks(TestContext context)
    {
        testContext = context;
        page = testContext.getBrowserUtilities().getPage();
    }

    /**
     * Prepare the steps to be run before each test
     */
    @Before
    public void BeforeSteps(Scenario scenario)
    {
        Hooks.scenario = scenario;
        page.setDefaultTimeout(60000);
        PlaywrightAssertions.setDefaultAssertionTimeout(45_000);
    }

    /**
     * Checks to see if a scenario fails or not, if it does, it takes a screenshot. Page is then closed.
     * <p>
     * @param scenario The scenario to check whether it passes or not
     */
    @After
    public void close(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            scenario.attach(page.screenshot(), "image/png", "screenshot");
        }
        testContext.getBrowserUtilities().cleanUp();
    }
}