package utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to assist in sharing states between step definitions
 */
public class ScenarioContext
{
    private Map<Context, Object> scenarioContext;

    /**
     * Container to which scenario context data is stored
     */
    public interface Context
    {
        /**
         * Context relating to the types of Users
         */
        enum USERS implements Context
        {
            EMAIL
        }
    }

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Hash map the scenario context
     */
    public ScenarioContext()
    {
        scenarioContext = new HashMap<>();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Maps a value of type Object to a context key of type String
     * <p>
     * @param key Context enum of type String
     * @param value Object type
     */
    public void setContext(Context key, Object value)
    {
        scenarioContext.put(key, value);
    }

    /**
     * Used to get the context of the enum context
     * <p>
     * @param key Takes key context enum as a parameter
     * @return the object which matches the key
     */
    public Object getContext(Context key)
    {
        return scenarioContext.get(key);
    }
    
    /**
     * Gets the scenario context as a String
     * <p>
     * @param key Takes key context enum as a parameter
     * @return the Scenario context as a String
     */
    public String getScenarioContextAsString(Context key)
    {
        return (String) this.getContext(key);
    }
}