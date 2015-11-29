package com.company;

import java.util.Vector;

/**
 * Created by tuxrp_000 on 02.09.2015.
 */
public class Block
{
    public Vector<Variable> variables;
    public String function;
    public boolean isFunctionBlock;

    public Block()
    {
        variables = new Vector<>();
        isFunctionBlock = false;
    }

    public void addVariable(Variable _var)
    {
        if ( getVariable(_var.name) != null )
        {
            System.out.println("Variable " + _var.name + " already has declaration");
            return;
        }
        variables.add(_var);
    }

    public Variable getVariable(String name)
    {
        for (Variable var: variables)
        {
            if ( var.name.equals(name) )
                return var;
        }

        return null;
    }
}