package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * This page contains methods and locators relating to the Home Page
 */
public class HomePage extends BasePage
{
    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Use the constructor set within Base Page
     * <p>
     * @param page The page to interact with
     */
    public HomePage(Page page)
    {
        super(page);
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Get the user email element
     * <p>
     * @return the user email element
     */
    public Locator getUserEmail()
    {
        return page.locator(".hui-globaluseritem__email");
    }
    
    /**
     * Get the logo element
     * <p>
     * @return the logo element
     */
    public Locator getLogo()
    {
        return page.locator("a[data-qa-id=site-logo]");
    }
}