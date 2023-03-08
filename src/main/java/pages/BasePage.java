package pages;

import com.microsoft.playwright.Page;

import data.Constants.Url;

/**
 * This page contains methods and locators relating to all pages across hudl
 */
public class BasePage
{
    protected Page page;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Pass the page through to allow Playwright's methods to be used
     * <p>
     * @param page The page to interact with
     */
    public BasePage(Page page)
    {
        this.page = page;
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Navigate to the correct URL
     */
    public void launchUrl()
    {
        page.navigate(System.getProperty("url", Url.ENVIRONMENT));
    }
}