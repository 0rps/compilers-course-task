// Generated from decaf.g4 by ANTLR 4.5.1
package com.company;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.omg.CORBA.portable.ValueInputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides an empty implementation of {@link decafListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class decafBaseListener implements decafListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	public static Storage storage;

	public decafBaseListener()
	{
		storage = new Storage();
	}

	private boolean checkExprTypeSilent(decafParser.ExprContext _ctx, String _type)
	{
		String text = _ctx.getText();

		if (_ctx.id() != null)
		{
			String id = _ctx.id().getText();
			Variable var = storage.getVariable(id);

			if(var == null)
			{
				//System.out.println("There is no such var: " + var + ", expr:" + text);
				return false;
			}

			if (var.type.equals(_type))
			{
				if (var.isArray && _ctx.expr() != null)
				{
					return checkExprType(_ctx.expr(0), "int");
				}
				return true;
			} else
			{
				//System.out.println("Expression has wrong type, var " + var.name + " must be " + _type + " at: " + text);
				return false;
			}

		} else if (_ctx.method_call() != null)
		{
			Function f = storage.getFunction(_ctx.method_call().id().getText());
			if (f == null)
			{
				//System.out.println("Expression: " + text + ". No such function: " + _ctx.method_call().id().getText());
				return false;
			}

			if (false == f.type.equals(_type))
			{
				//System.out.println("Expression: " + text + ". Function returns wrong type: " + f.type);
				return false;
			}

			return true;
		} else if (_ctx.constant() != null)
		{
			if (_type.equals("string"))
			{
				if (_ctx.constant().char_constant() == null)
				{
					//System.out.println("Expr:" + text + ". Wrong type");
					return false;
				}
			} else if (_type.equals("int")) {
				if (_ctx.constant().int_constant() == null)
				{
					//System.out.println("Expr:" + text + ". Wrong type");
					return false;
				}
			} else if (_type.equals("bool"))
			{
				if (_ctx.constant().bool_constant() == null)
				{
					//System.out.println("Expr:" + text + ". Wrong type");
					return false;
				}
			} else {
				//System.out.println("Expr:" + text + ". Wrong type");
				return false;
			}
			return true;
		} else if (_ctx.binary_op() != null)
		{
			if (_ctx.binary_op().arithmetic_op() != null)
			{
				if (false == _type.equals("int"))
				{
					//System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprType(e0, _type))
					return checkExprType(e1,_type);
				else
					return false;

			} else if (_ctx.binary_op().eq_op() != null)
			{
				if (_type.equals("bool"))
				{
					//System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprTypeSilent(e0, "int") && checkExprTypeSilent(e1,"int") )
					return true;
				else if (checkExprTypeSilent(e0, "bool") && checkExprTypeSilent(e1,"bool"))
					return true;
				else if (checkExprTypeSilent(e0, "char") && checkExprTypeSilent(e1,"char"))
					return true;
				else
					return false;

			} else if (_ctx.binary_op().relation_op() != null )
			{
				if (_type.equals("bool"))
				{
					//System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprType(e0, "int"))
					return checkExprType(e1,"int");
				else
					return false;
			}
			else if ( _ctx.binary_op().condition_op() != null)
			{
				if (_type.equals("bool"))
				{
					//System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprType(e0, "bool"))
					return checkExprType(e1,"bool");
				else
					return false;
			}
		} else if (_ctx.getText().charAt(0) == '!') {
			if (false == _type.equals("bool")) {
				//System.out.println("Expression has wrong type: " + text + ", must be " + _type);
				return false;
			}
		}

		return checkExprType(_ctx.expr(0), _type);
	}

	private boolean checkExprType(decafParser.ExprContext _ctx, String _type)
	{
		String text = _ctx.getText();

		if (_ctx.id() != null)
		{
			String id = _ctx.id().getText();
			Variable var = storage.getVariable(id);

			if(var == null)
			{
				System.out.println("There is no such var: " + var + ", expr:" + text);
				return false;
			}

			if (var.type.equals(_type))
			{
				if (var.isArray && _ctx.expr() != null)
				{
					return checkExprType(_ctx.expr(0), "int");
				}
				return true;
			} else
			{
				System.out.println("Expression has wrong type, var " + var.name + " must be " + _type + " at: " + text);
				return false;
			}

		} else if (_ctx.method_call() != null)
		{
			Function f = storage.getFunction(_ctx.method_call().id().getText());
			if (f == null)
			{
				System.out.println("Expression: " + text + ". No such function: " + _ctx.method_call().id().getText());
				return false;
			}

			if (false == f.type.equals(_type))
			{
				System.out.println("Expression: " + text + ". Function returns wrong type: " + f.type);
				return false;
			}

			return true;
		} else if (_ctx.constant() != null)
		{
			if (_type.equals("string"))
			{
				if (_ctx.constant().char_constant() == null)
				{
					System.out.println("Expr:" + text + ". Wrong type");
					return false;
				}
			} else if (_type.equals("int")) {
				if (_ctx.constant().int_constant() == null)
				{
					System.out.println("Expr:" + text + ". Wrong type");
					return false;
				}
			} else if (_type.equals("bool"))
			{
				if (_ctx.constant().bool_constant() == null)
				{
					System.out.println("Expr:" + text + ". Wrong type");
					return false;
				}
			} else {
				System.out.println("Expr:" + text + ". Wrong type");
				return false;
			}
			return true;
		} else if (_ctx.binary_op() != null)
		{
			if (_ctx.binary_op().arithmetic_op() != null)
			{
				if (false == _type.equals("int"))
				{
					System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprType(e0, _type))
					return checkExprType(e1,_type);
				else
					return false;

			} else if (_ctx.binary_op().eq_op() != null)
			{
				if (_type.equals("bool") == false)
				{
					System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprTypeSilent(e0, "int") && checkExprTypeSilent(e1,"int") )
					return true;
				else if (checkExprTypeSilent(e0, "bool") && checkExprTypeSilent(e1,"bool"))
					return true;
				else if (checkExprTypeSilent(e0, "char") && checkExprTypeSilent(e1,"char"))
					return true;
				else
				{
					System.out.println("Wrong expression: " + text);
					return false;
				}

			} else if (_ctx.binary_op().relation_op() != null )
			{
				if (_type.equals("bool") == false)
				{
					System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprType(e0, "int"))
					return checkExprType(e1,"int");
				else
					return false;
			}
			else if ( _ctx.binary_op().condition_op() != null)
			{
				if (_type.equals("bool") == false)
				{
					System.out.println("Expression has wrong type: " + text + ", must be " + _type);
					return false;
				}

				decafParser.ExprContext e0 = _ctx.expr().get(0);
				decafParser.ExprContext e1 = _ctx.expr().get(1);

				if (checkExprType(e0, "bool"))
					return checkExprType(e1,"bool");
				else
					return false;
			}
		} else if (_ctx.getText().charAt(0) == '!') {
			if (false == _type.equals("bool")) {
				System.out.println("Expression has wrong type: " + text + ", must be " + _type);
				return false;
			}
		}

		return checkExprType(_ctx.expr(0), _type);
	}

	private boolean checkFunction(ParserRuleContext ctx, String name, List<decafParser.Method_argContext> args)
	{
		Function f = storage.getFunction(name);
		if (f == null)
		{
			System.out.println("No such function: " + ctx.getText());
			return false;
		}

		if (args.size() != f.params.size())
		{
			System.out.println("Wrong params count: " + ctx.getText());
			return false;
		}

		for(int i = 0; i < args.size(); i++)
		{
			if (args.get(i).expr() != null)
			{
				if (checkExprType( args.get(i).expr(),f.params.get(i)) ) {
					System.out.println("Wrong param type, need " + f.params.get(i) + ":" + ctx.getText());
					return false;
				}
			} else
			{
				if (false == f.params.get(i).equals("string")) {
					System.out.println("Wrong param type, need string:" + ctx.getText());
					return false;
				}
			}
		}

		return true;

	}

	private boolean checkVarExistance(ParserRuleContext ctx, String _varname, boolean _isArray)
	{
		Variable var = storage.getVariable(_varname);
		if (var == null)
		{
			System.out.println("problem, there is no var: " + _varname + ". At " + ctx.getText());
			return false;
		}

		if (var.isArray != _isArray)
		{
			System.out.println("problem, there is no var: " + _varname +". At " + ctx.getText());
			return false;
		}

		return true;
	}

	@Override public void enterProgram(decafParser.ProgramContext ctx) {
		List<decafParser.Method_declarationContext> methods = ctx.method_declaration();
		for (int i = 0; i < methods.size(); i++)
		{
			decafParser.Method_declarationContext methodCtx = methods.get(i);
			Function func = new Function();
			func.type = methodCtx.method_type().getText();
			func.name = methodCtx.id().getText();

			decafParser.Method_declaration_argumentsContext argCtx = methodCtx.method_declaration_arguments();
			if (argCtx != null)
			{
				List<decafParser.TypeContext> typeList = argCtx.type();

				for (int j = 0; j < typeList.size(); j++)
				{
					func.params.add(typeList.get(j).getText());
				}
			}
			storage.addFunction(func);
		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProgram(decafParser.ProgramContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExtern_defs(decafParser.Extern_defsContext ctx) {

		Function func = new Function();
		func.type = ctx.method_type().getText();
		func.name = ctx.id().getText();

		ArrayList<String> params = new ArrayList<>();
		for (decafParser.Extern_typeContext param: ctx.extern_type_list().extern_type())
		{
			params.add(param.getText());
		}

		func.params = params;

		storage.addFunction(func);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExtern_defs(decafParser.Extern_defsContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExtern_type_list(decafParser.Extern_type_listContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExtern_type_list(decafParser.Extern_type_listContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExtern_type(decafParser.Extern_typeContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExtern_type(decafParser.Extern_typeContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterField_declaration(decafParser.Field_declarationContext ctx) {
		if (ctx.var_or_array_declaration_list() == null)
		{
			Variable var = new Variable();
			var.type = ctx.type().getText();
			var.name = ctx.id().getText();
			if (false == storage.addVariable(var))
			{
				System.out.println(ctx.getText());
				System.out.println();
			}

		} else
		{
			decafParser.Var_or_array_declaration_listContext preDeclList = ctx.var_or_array_declaration_list();
			String type = preDeclList.type().getText();
			List<decafParser.Var_or_array_declarationContext> declList = preDeclList.var_or_array_declaration();
			for (int i = 0; i < declList.size(); i++)
			{
				Variable var = new Variable();
				var.type = type;
				if (declList.get(i).array_declaration() == null)
				{
					var.name = declList.get(i).id().getText();
				} else
				{
					var.isArray = true;
					var.name = declList.get(i).array_declaration().id().getText();
				}

				if (false == storage.addVariable(var))
				{
					System.out.println(ctx.getText());
					System.out.println();
				}
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitField_declaration(decafParser.Field_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVar_or_array_declaration_list(decafParser.Var_or_array_declaration_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVar_or_array_declaration_list(decafParser.Var_or_array_declaration_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVar_or_array_declaration(decafParser.Var_or_array_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVar_or_array_declaration(decafParser.Var_or_array_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArray_declaration(decafParser.Array_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArray_declaration(decafParser.Array_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethod_declaration(decafParser.Method_declarationContext ctx) {
		storage.pushBlock();
		storage.blocks.lastElement().isFunctionBlock = true;
		storage.blocks.lastElement().function = ctx.id().getText();
		decafParser.Method_declaration_argumentsContext argCtx = ctx.method_declaration_arguments();
		if (argCtx != null)
		{
			List<decafParser.IdContext> idList = argCtx.id();
			List<decafParser.TypeContext> typeList = argCtx.type();
			for (int i = 0; i  < idList.size(); i++)
			{
				Variable var = new Variable();
				var.name = idList.get(i).getText();
				var.type = typeList.get(i).getText();

				if (false == storage.addVariable(var))
				{
					System.out.println(ctx.getText());
					System.out.println();
				}
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethod_declaration(decafParser.Method_declarationContext ctx) {
		storage.popBlock();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethod_declaration_arguments(decafParser.Method_declaration_argumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethod_declaration_arguments(decafParser.Method_declaration_argumentsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlock(decafParser.BlockContext ctx)
	{
		storage.pushBlock();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlock(decafParser.BlockContext ctx)
	{
		storage.popBlock();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVar_declaration(decafParser.Var_declarationContext ctx)
	{
		String type = ctx.type().getText();
		for(decafParser.IdContext id: ctx.id())
		{
			Variable var = new Variable();
			var.type = type;
			var.name = id.getText();
			if (false == storage.addVariable(var))
			{
				System.out.println(ctx.getText());
				System.out.println();
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVar_declaration(decafParser.Var_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethod_type(decafParser.Method_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethod_type(decafParser.Method_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(decafParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitType(decafParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(decafParser.StatementContext ctx) {
		if (ctx.assign() != null)
			return;

		if (ctx.method_call() != null)
			return;

		if (ctx.for_body() != null)
		{
			checkExprType(ctx.for_body().expr(), "bool");
			return;
		}

		if (ctx.getText().startsWith("if") || ctx.getText().startsWith("while"))
		{
			checkExprType(ctx.expr(), "bool");
		}

		if (ctx.getText().startsWith("return"))
		{
			Function f = storage.getCurrentFunctionBlock();
			if (f.type == "void") {
				if (ctx.expr() != null) {
					System.out.println("statement: " + ctx.expr() + " must be void");
					return;
				}
			} else
			{
				if (ctx.expr() == null)
				{
					System.out.println("statement: " + ctx.expr() + " can't return void");
					return;
				} else
					checkExprType(ctx.expr(), f.type);
			}
		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(decafParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFor_body(decafParser.For_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFor_body(decafParser.For_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssign(decafParser.AssignContext ctx)
	{
		String varname = ctx.l_value().id().getText();
		boolean isArray = false;
		if (ctx.l_value().expr() != null)
		{
			if (checkExprType(ctx.l_value().expr(), "int") == false)
				return;

			if (checkVarExistance(ctx, varname, true) == false)
				return;

			isArray = true;
		}

		Variable var = storage.getVariable(varname);
		checkExprType(ctx.expr(), var.type);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssign(decafParser.AssignContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethod_call(decafParser.Method_callContext ctx)
	{
		String name = ctx.id().getText();
		Function f = storage.getFunction(name);
		if (f == null)
		{
			System.out.println("Method call: " + ctx.getText() + ". No such function");
			return;
		}

		int argCount = ctx.method_args().method_arg().size();
		if (argCount != f.params.size())
		{
			System.out.println("Method call: " + ctx.getText() + ". Wrong params count");
			return;
		}

		for (int i =0 ; i < ctx.method_args().method_arg().size(); i++ )
		{
			decafParser.Method_argContext arg = ctx.method_args().method_arg(i);
			if (arg.string_constant() != null)
			{
				if (f.params.get(i).equals("string") == false)
					System.out.println("Method call: " + ctx.getText() + ". Wrong type of " + arg.getText());
			}else
			{
				if ( false == checkExprType(arg.expr(), f.params.get(i)))
				{
					System.out.println("Method call error: " + ctx.getText() );
					System.out.println();
				}
			}
		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethod_call(decafParser.Method_callContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethod_args(decafParser.Method_argsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethod_args(decafParser.Method_argsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethod_arg(decafParser.Method_argContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethod_arg(decafParser.Method_argContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterL_value(decafParser.L_valueContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitL_value(decafParser.L_valueContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr(decafParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr(decafParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterId(decafParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitId(decafParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBinary_op(decafParser.Binary_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBinary_op(decafParser.Binary_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArithmetic_op(decafParser.Arithmetic_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArithmetic_op(decafParser.Arithmetic_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRelation_op(decafParser.Relation_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRelation_op(decafParser.Relation_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEq_op(decafParser.Eq_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEq_op(decafParser.Eq_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCondition_op(decafParser.Condition_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCondition_op(decafParser.Condition_opContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConstant(decafParser.ConstantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConstant(decafParser.ConstantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterChar_constant(decafParser.Char_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitChar_constant(decafParser.Char_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterString_constant(decafParser.String_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitString_constant(decafParser.String_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBool_constant(decafParser.Bool_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBool_constant(decafParser.Bool_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInt_constant(decafParser.Int_constantContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInt_constant(decafParser.Int_constantContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}