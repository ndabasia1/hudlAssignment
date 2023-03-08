package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * This page contains methods and locators relating to the Login Page
 */
public class LoginPage extends BasePage
{
    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Use the constructor set within Base Page
     * <p>
     * @param page The page to interact with
     */
    public LoginPage(Page page)
    {
        super(page);
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Get the logo element
     * <p>
     * @return the logo element
     */
    public Locator getLogo()
    {
        return page.locator("svg[data-qa-id=hudl-logo]");
    }
    
    /**
     * Get the message element
     * <p>
     * @return the message element
     */
    public Locator getMessage()
    {
        return page.locator("p[data-qa-id=error-display]");
    }
    
    /**
     * Get the section name element
     * <p>
     * @return the section name element
     */
    public Locator getSectionName()
    {
        return page.locator("h2");
    }

    /**
     * Enter a value into a field
     * <p>
     * @param fieldName The field to enter the value into
     * @param fieldValue Value to enter
     */
    public void enterValueIntoField(String fieldName, String fieldValue)
    {
        page.locator("//label[text()='" + fieldName + "']/following-sibling::*").fill(fieldValue);
    }
    
    /**
     * Click a button
     * <p>
     * @param buttonName The name of the button to click
     */
    public void clickButton(String buttonName)
    {
        page.locator("//button[text()='" + buttonName + "']").click();
    }
    
    /**
     * Click the logo
     */
    public void clickLogo()
    {
        getLogo().click();
    }
    
    /**
     * Click the Need help? link
     */
    public void clickNeedHelp()
    {
        page.locator("a[data-qa-id=need-help-link]").click();
    }
}