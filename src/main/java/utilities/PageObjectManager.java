package utilities;

import com.microsoft.playwright.Page;

import pages.HomePage;
import pages.LoginPage;

/**
 * Allows all the page objects to be declared here
 */
public class PageObjectManager
{
    private Page page;
    private LoginPage loginPage;
    private HomePage homePage;

    /**
     * Allows the page to be set
     * <p>
     * @param page The page to set
     */
    public PageObjectManager(Page page)
    {
        this.page = page;
    }

    /**
     * Allow usage of Login Page's methods
     */
    public LoginPage getLoginPage()
    {
        return (loginPage == null) ? loginPage = new LoginPage(page) : loginPage;
    }
    
    /**
     * Allow usage of Home Page's methods
     */
    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(page) : homePage;
    }
}