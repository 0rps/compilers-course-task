package com.company;

/**
 * Created by tuxrp_000 on 02.09.2015.
 */
public class Variable
{
    public Variable()
    {
        isArray = false;
    }

    public void printVariable()
    {
        String add = "";
        if (isArray)
            add = "[]";
        System.out.println("var: " + type + " , name=" + name + add);
    }

    public String name;
    public String type;
    public boolean isArray;
}