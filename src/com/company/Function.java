package com.company;

import java.util.ArrayList;

/**
 * Created by tuxrp_000 on 02.09.2015.
 */
public class Function
{
    public Function()
    {
        params = new ArrayList<>();
    }

    public void printFunction()
    {
        String vars = "";
        for(String var: params)
        {
            vars += var + ",";
        }
        if (vars.length() > 0)
        {
            vars = vars.substring(0, vars.length()-1);
        }
        System.out.println("Function: " + type + " " + name + "(" + vars +  ")");
    }

    public String type;
    public String name;
    public ArrayList<String> params;
}
