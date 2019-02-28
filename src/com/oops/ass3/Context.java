//Context.java
package com.oops.ass3;

import java.util.HashMap;

//POJO class for expression values
public class Context {

    HashMap<String,String> values = new HashMap<>();

    public String getValue(String variableName)
    {
        return values.get(variableName);
    }

    public void setValues(String variableName, String value)
    {
        values.put(variableName, value);
    }

}

