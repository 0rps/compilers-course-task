package com.company;

import java.util.Vector;

/**
 * Created by tuxrp_000 on 02.09.2015.
 */
public class Storage {
    public Vector<Function> functions;
    public Vector<Block> blocks;

    public void printStorage() {
        for (Function f : functions) {
            f.printFunction();
        }

        for (Block block: blocks)
        {
            System.out.println("---------------");
            for (Variable var: block.variables)
            {
                var.printVariable();
            }
        }
    }

    public Function getCurrentFunctionBlock()
    {
        for (Block b: blocks)
        {
            if (b.isFunctionBlock)
                return getFunction(b.function);
        }
        return  null;
    }

    public Storage() {
        functions = new Vector<>();
        blocks = new Vector<>();
        pushBlock();
    }

    public boolean addFunction(Function _func) {
        if (getFunction(_func.name) != null) {
            System.out.println("Function " + _func.name + " already has declaration");
            return false;
        }

        functions.add(_func);
        return true;
    }

    public Function getFunction(String _name) {

        for (Function func : functions) {
            if (func.name.equals(_name))
                return func;
        }
        return null;

    }

    public boolean addVariable(Variable _var)
    {
        if ( getVariable(_var.name) != null )
        {
            System.out.println("Variable " + _var.name + " already has declaration");
            return false;
        }

        blocks.lastElement().addVariable(_var);
        return true;
    }

    public Variable getVariable(String _name)
    {
        for (Block block : blocks)
        {
            Variable var = block.getVariable(_name);
            if (var != null)
                return var;
        }

        return null;
    }

    public void pushBlock() {
        blocks.add( new Block() );
    }

    public void popBlock()
    {
        blocks.remove(blocks.size() - 1);
    }

}