// Generated from decaf.g4 by ANTLR 4.5.1
package com.company;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link decafParser}.
 */
public interface decafListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link decafParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(decafParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(decafParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#extern_defs}.
	 * @param ctx the parse tree
	 */
	void enterExtern_defs(decafParser.Extern_defsContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#extern_defs}.
	 * @param ctx the parse tree
	 */
	void exitExtern_defs(decafParser.Extern_defsContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#extern_type_list}.
	 * @param ctx the parse tree
	 */
	void enterExtern_type_list(decafParser.Extern_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#extern_type_list}.
	 * @param ctx the parse tree
	 */
	void exitExtern_type_list(decafParser.Extern_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#extern_type}.
	 * @param ctx the parse tree
	 */
	void enterExtern_type(decafParser.Extern_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#extern_type}.
	 * @param ctx the parse tree
	 */
	void exitExtern_type(decafParser.Extern_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#field_declaration}.
	 * @param ctx the parse tree
	 */
	void enterField_declaration(decafParser.Field_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#field_declaration}.
	 * @param ctx the parse tree
	 */
	void exitField_declaration(decafParser.Field_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#var_or_array_declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterVar_or_array_declaration_list(decafParser.Var_or_array_declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#var_or_array_declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitVar_or_array_declaration_list(decafParser.Var_or_array_declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#var_or_array_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_or_array_declaration(decafParser.Var_or_array_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#var_or_array_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_or_array_declaration(decafParser.Var_or_array_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#array_declaration}.
	 * @param ctx the parse tree
	 */
	void enterArray_declaration(decafParser.Array_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#array_declaration}.
	 * @param ctx the parse tree
	 */
	void exitArray_declaration(decafParser.Array_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMethod_declaration(decafParser.Method_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMethod_declaration(decafParser.Method_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#method_declaration_arguments}.
	 * @param ctx the parse tree
	 */
	void enterMethod_declaration_arguments(decafParser.Method_declaration_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#method_declaration_arguments}.
	 * @param ctx the parse tree
	 */
	void exitMethod_declaration_arguments(decafParser.Method_declaration_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(decafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(decafParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVar_declaration(decafParser.Var_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#var_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVar_declaration(decafParser.Var_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMethod_type(decafParser.Method_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMethod_type(decafParser.Method_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(decafParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(decafParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(decafParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(decafParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#for_body}.
	 * @param ctx the parse tree
	 */
	void enterFor_body(decafParser.For_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#for_body}.
	 * @param ctx the parse tree
	 */
	void exitFor_body(decafParser.For_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(decafParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(decafParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call(decafParser.Method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call(decafParser.Method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#method_args}.
	 * @param ctx the parse tree
	 */
	void enterMethod_args(decafParser.Method_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#method_args}.
	 * @param ctx the parse tree
	 */
	void exitMethod_args(decafParser.Method_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#method_arg}.
	 * @param ctx the parse tree
	 */
	void enterMethod_arg(decafParser.Method_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#method_arg}.
	 * @param ctx the parse tree
	 */
	void exitMethod_arg(decafParser.Method_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#l_value}.
	 * @param ctx the parse tree
	 */
	void enterL_value(decafParser.L_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#l_value}.
	 * @param ctx the parse tree
	 */
	void exitL_value(decafParser.L_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(decafParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(decafParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(decafParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(decafParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterBinary_op(decafParser.Binary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitBinary_op(decafParser.Binary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#arithmetic_op}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_op(decafParser.Arithmetic_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#arithmetic_op}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_op(decafParser.Arithmetic_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#relation_op}.
	 * @param ctx the parse tree
	 */
	void enterRelation_op(decafParser.Relation_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#relation_op}.
	 * @param ctx the parse tree
	 */
	void exitRelation_op(decafParser.Relation_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(decafParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(decafParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#condition_op}.
	 * @param ctx the parse tree
	 */
	void enterCondition_op(decafParser.Condition_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#condition_op}.
	 * @param ctx the parse tree
	 */
	void exitCondition_op(decafParser.Condition_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(decafParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(decafParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#char_constant}.
	 * @param ctx the parse tree
	 */
	void enterChar_constant(decafParser.Char_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#char_constant}.
	 * @param ctx the parse tree
	 */
	void exitChar_constant(decafParser.Char_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#string_constant}.
	 * @param ctx the parse tree
	 */
	void enterString_constant(decafParser.String_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#string_constant}.
	 * @param ctx the parse tree
	 */
	void exitString_constant(decafParser.String_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#bool_constant}.
	 * @param ctx the parse tree
	 */
	void enterBool_constant(decafParser.Bool_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#bool_constant}.
	 * @param ctx the parse tree
	 */
	void exitBool_constant(decafParser.Bool_constantContext ctx);
	/**
	 * Enter a parse tree produced by {@link decafParser#int_constant}.
	 * @param ctx the parse tree
	 */
	void enterInt_constant(decafParser.Int_constantContext ctx);
	/**
	 * Exit a parse tree produced by {@link decafParser#int_constant}.
	 * @param ctx the parse tree
	 */
	void exitInt_constant(decafParser.Int_constantContext ctx);
}