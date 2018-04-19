// Generated from E:/MyCode/urule/urule-core/dsl\RuleParser.g4 by ANTLR 4.5.3
package com.bstek.urule.dsl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RuleParserParser}.
 */
public interface RuleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void enterRuleSet(RuleParserParser.RuleSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#ruleSet}.
	 * @param ctx the parse tree
	 */
	void exitRuleSet(RuleParserParser.RuleSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#ruleSetHeader}.
	 * @param ctx the parse tree
	 */
	void enterRuleSetHeader(RuleParserParser.RuleSetHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#ruleSetHeader}.
	 * @param ctx the parse tree
	 */
	void exitRuleSetHeader(RuleParserParser.RuleSetHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#ruleSetBody}.
	 * @param ctx the parse tree
	 */
	void enterRuleSetBody(RuleParserParser.RuleSetBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#ruleSetBody}.
	 * @param ctx the parse tree
	 */
	void exitRuleSetBody(RuleParserParser.RuleSetBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(RuleParserParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(RuleParserParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#functionImport}.
	 * @param ctx the parse tree
	 */
	void enterFunctionImport(RuleParserParser.FunctionImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#functionImport}.
	 * @param ctx the parse tree
	 */
	void exitFunctionImport(RuleParserParser.FunctionImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#packageDef}.
	 * @param ctx the parse tree
	 */
	void enterPackageDef(RuleParserParser.PackageDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#packageDef}.
	 * @param ctx the parse tree
	 */
	void exitPackageDef(RuleParserParser.PackageDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(RuleParserParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(RuleParserParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#importParameterLibrary}.
	 * @param ctx the parse tree
	 */
	void enterImportParameterLibrary(RuleParserParser.ImportParameterLibraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#importParameterLibrary}.
	 * @param ctx the parse tree
	 */
	void exitImportParameterLibrary(RuleParserParser.ImportParameterLibraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#importVariableLibrary}.
	 * @param ctx the parse tree
	 */
	void enterImportVariableLibrary(RuleParserParser.ImportVariableLibraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#importVariableLibrary}.
	 * @param ctx the parse tree
	 */
	void exitImportVariableLibrary(RuleParserParser.ImportVariableLibraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#importConstantLibrary}.
	 * @param ctx the parse tree
	 */
	void enterImportConstantLibrary(RuleParserParser.ImportConstantLibraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#importConstantLibrary}.
	 * @param ctx the parse tree
	 */
	void exitImportConstantLibrary(RuleParserParser.ImportConstantLibraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#importActionLibrary}.
	 * @param ctx the parse tree
	 */
	void enterImportActionLibrary(RuleParserParser.ImportActionLibraryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#importActionLibrary}.
	 * @param ctx the parse tree
	 */
	void exitImportActionLibrary(RuleParserParser.ImportActionLibraryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(RuleParserParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(RuleParserParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(RuleParserParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(RuleParserParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameter(RuleParserParser.FunctionParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#functionParameter}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameter(RuleParserParser.FunctionParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#ruleDef}.
	 * @param ctx the parse tree
	 */
	void enterRuleDef(RuleParserParser.RuleDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#ruleDef}.
	 * @param ctx the parse tree
	 */
	void exitRuleDef(RuleParserParser.RuleDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#loopRuleDef}.
	 * @param ctx the parse tree
	 */
	void enterLoopRuleDef(RuleParserParser.LoopRuleDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#loopRuleDef}.
	 * @param ctx the parse tree
	 */
	void exitLoopRuleDef(RuleParserParser.LoopRuleDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#loopTarget}.
	 * @param ctx the parse tree
	 */
	void enterLoopTarget(RuleParserParser.LoopTargetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#loopTarget}.
	 * @param ctx the parse tree
	 */
	void exitLoopTarget(RuleParserParser.LoopTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#loopStart}.
	 * @param ctx the parse tree
	 */
	void enterLoopStart(RuleParserParser.LoopStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#loopStart}.
	 * @param ctx the parse tree
	 */
	void exitLoopStart(RuleParserParser.LoopStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#loopEnd}.
	 * @param ctx the parse tree
	 */
	void enterLoopEnd(RuleParserParser.LoopEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#loopEnd}.
	 * @param ctx the parse tree
	 */
	void exitLoopEnd(RuleParserParser.LoopEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(RuleParserParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(RuleParserParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#loopAttribute}.
	 * @param ctx the parse tree
	 */
	void enterLoopAttribute(RuleParserParser.LoopAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#loopAttribute}.
	 * @param ctx the parse tree
	 */
	void exitLoopAttribute(RuleParserParser.LoopAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#salienceAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSalienceAttribute(RuleParserParser.SalienceAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#salienceAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSalienceAttribute(RuleParserParser.SalienceAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#effectiveDateAttribute}.
	 * @param ctx the parse tree
	 */
	void enterEffectiveDateAttribute(RuleParserParser.EffectiveDateAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#effectiveDateAttribute}.
	 * @param ctx the parse tree
	 */
	void exitEffectiveDateAttribute(RuleParserParser.EffectiveDateAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#expiresDateAttribute}.
	 * @param ctx the parse tree
	 */
	void enterExpiresDateAttribute(RuleParserParser.ExpiresDateAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#expiresDateAttribute}.
	 * @param ctx the parse tree
	 */
	void exitExpiresDateAttribute(RuleParserParser.ExpiresDateAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#enabledAttribute}.
	 * @param ctx the parse tree
	 */
	void enterEnabledAttribute(RuleParserParser.EnabledAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#enabledAttribute}.
	 * @param ctx the parse tree
	 */
	void exitEnabledAttribute(RuleParserParser.EnabledAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#debugAttribute}.
	 * @param ctx the parse tree
	 */
	void enterDebugAttribute(RuleParserParser.DebugAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#debugAttribute}.
	 * @param ctx the parse tree
	 */
	void exitDebugAttribute(RuleParserParser.DebugAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#activationGroupAttribute}.
	 * @param ctx the parse tree
	 */
	void enterActivationGroupAttribute(RuleParserParser.ActivationGroupAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#activationGroupAttribute}.
	 * @param ctx the parse tree
	 */
	void exitActivationGroupAttribute(RuleParserParser.ActivationGroupAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#agendaGroupAttribute}.
	 * @param ctx the parse tree
	 */
	void enterAgendaGroupAttribute(RuleParserParser.AgendaGroupAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#agendaGroupAttribute}.
	 * @param ctx the parse tree
	 */
	void exitAgendaGroupAttribute(RuleParserParser.AgendaGroupAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#autoFocusAttribute}.
	 * @param ctx the parse tree
	 */
	void enterAutoFocusAttribute(RuleParserParser.AutoFocusAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#autoFocusAttribute}.
	 * @param ctx the parse tree
	 */
	void exitAutoFocusAttribute(RuleParserParser.AutoFocusAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#ruleflowGroupAttribute}.
	 * @param ctx the parse tree
	 */
	void enterRuleflowGroupAttribute(RuleParserParser.RuleflowGroupAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#ruleflowGroupAttribute}.
	 * @param ctx the parse tree
	 */
	void exitRuleflowGroupAttribute(RuleParserParser.RuleflowGroupAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#left}.
	 * @param ctx the parse tree
	 */
	void enterLeft(RuleParserParser.LeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#left}.
	 * @param ctx the parse tree
	 */
	void exitLeft(RuleParserParser.LeftContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenConditions}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterParenConditions(RuleParserParser.ParenConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenConditions}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitParenConditions(RuleParserParser.ParenConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiConditions}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterMultiConditions(RuleParserParser.MultiConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiConditions}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitMultiConditions(RuleParserParser.MultiConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleCondition}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterSingleCondition(RuleParserParser.SingleConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleCondition}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitSingleCondition(RuleParserParser.SingleConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleNamedConditionSet}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterSingleNamedConditionSet(RuleParserParser.SingleNamedConditionSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleNamedConditionSet}
	 * labeled alternative in {@link RuleParserParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitSingleNamedConditionSet(RuleParserParser.SingleNamedConditionSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#namedConditionSet}.
	 * @param ctx the parse tree
	 */
	void enterNamedConditionSet(RuleParserParser.NamedConditionSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#namedConditionSet}.
	 * @param ctx the parse tree
	 */
	void exitNamedConditionSet(RuleParserParser.NamedConditionSetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenNamedConditions}
	 * labeled alternative in {@link RuleParserParser#namedCondition}.
	 * @param ctx the parse tree
	 */
	void enterParenNamedConditions(RuleParserParser.ParenNamedConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenNamedConditions}
	 * labeled alternative in {@link RuleParserParser#namedCondition}.
	 * @param ctx the parse tree
	 */
	void exitParenNamedConditions(RuleParserParser.ParenNamedConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiNamedConditions}
	 * labeled alternative in {@link RuleParserParser#namedCondition}.
	 * @param ctx the parse tree
	 */
	void enterMultiNamedConditions(RuleParserParser.MultiNamedConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiNamedConditions}
	 * labeled alternative in {@link RuleParserParser#namedCondition}.
	 * @param ctx the parse tree
	 */
	void exitMultiNamedConditions(RuleParserParser.MultiNamedConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleNamedConditions}
	 * labeled alternative in {@link RuleParserParser#namedCondition}.
	 * @param ctx the parse tree
	 */
	void enterSingleNamedConditions(RuleParserParser.SingleNamedConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleNamedConditions}
	 * labeled alternative in {@link RuleParserParser#namedCondition}.
	 * @param ctx the parse tree
	 */
	void exitSingleNamedConditions(RuleParserParser.SingleNamedConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleCellCondition}
	 * labeled alternative in {@link RuleParserParser#decisionTableCellCondition}.
	 * @param ctx the parse tree
	 */
	void enterSingleCellCondition(RuleParserParser.SingleCellConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleCellCondition}
	 * labeled alternative in {@link RuleParserParser#decisionTableCellCondition}.
	 * @param ctx the parse tree
	 */
	void exitSingleCellCondition(RuleParserParser.SingleCellConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiCellConditions}
	 * labeled alternative in {@link RuleParserParser#decisionTableCellCondition}.
	 * @param ctx the parse tree
	 */
	void enterMultiCellConditions(RuleParserParser.MultiCellConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiCellConditions}
	 * labeled alternative in {@link RuleParserParser#decisionTableCellCondition}.
	 * @param ctx the parse tree
	 */
	void exitMultiCellConditions(RuleParserParser.MultiCellConditionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenCellConditions}
	 * labeled alternative in {@link RuleParserParser#decisionTableCellCondition}.
	 * @param ctx the parse tree
	 */
	void enterParenCellConditions(RuleParserParser.ParenCellConditionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenCellConditions}
	 * labeled alternative in {@link RuleParserParser#decisionTableCellCondition}.
	 * @param ctx the parse tree
	 */
	void exitParenCellConditions(RuleParserParser.ParenCellConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#refName}.
	 * @param ctx the parse tree
	 */
	void enterRefName(RuleParserParser.RefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#refName}.
	 * @param ctx the parse tree
	 */
	void exitRefName(RuleParserParser.RefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#refObject}.
	 * @param ctx the parse tree
	 */
	void enterRefObject(RuleParserParser.RefObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#refObject}.
	 * @param ctx the parse tree
	 */
	void exitRefObject(RuleParserParser.RefObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(RuleParserParser.NullValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#nullValue}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(RuleParserParser.NullValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#conditionLeft}.
	 * @param ctx the parse tree
	 */
	void enterConditionLeft(RuleParserParser.ConditionLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#conditionLeft}.
	 * @param ctx the parse tree
	 */
	void exitConditionLeft(RuleParserParser.ConditionLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#expEval}.
	 * @param ctx the parse tree
	 */
	void enterExpEval(RuleParserParser.ExpEvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#expEval}.
	 * @param ctx the parse tree
	 */
	void exitExpEval(RuleParserParser.ExpEvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#expAll}.
	 * @param ctx the parse tree
	 */
	void enterExpAll(RuleParserParser.ExpAllContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#expAll}.
	 * @param ctx the parse tree
	 */
	void exitExpAll(RuleParserParser.ExpAllContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#expExists}.
	 * @param ctx the parse tree
	 */
	void enterExpExists(RuleParserParser.ExpExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#expExists}.
	 * @param ctx the parse tree
	 */
	void exitExpExists(RuleParserParser.ExpExistsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#expCollect}.
	 * @param ctx the parse tree
	 */
	void enterExpCollect(RuleParserParser.ExpCollectContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#expCollect}.
	 * @param ctx the parse tree
	 */
	void exitExpCollect(RuleParserParser.ExpCollectContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#commonFunction}.
	 * @param ctx the parse tree
	 */
	void enterCommonFunction(RuleParserParser.CommonFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#commonFunction}.
	 * @param ctx the parse tree
	 */
	void exitCommonFunction(RuleParserParser.CommonFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#exprCondition}.
	 * @param ctx the parse tree
	 */
	void enterExprCondition(RuleParserParser.ExprConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#exprCondition}.
	 * @param ctx the parse tree
	 */
	void exitExprCondition(RuleParserParser.ExprConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#expressionBody}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBody(RuleParserParser.ExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#expressionBody}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBody(RuleParserParser.ExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#percent}.
	 * @param ctx the parse tree
	 */
	void enterPercent(RuleParserParser.PercentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#percent}.
	 * @param ctx the parse tree
	 */
	void exitPercent(RuleParserParser.PercentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#leftParen}.
	 * @param ctx the parse tree
	 */
	void enterLeftParen(RuleParserParser.LeftParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#leftParen}.
	 * @param ctx the parse tree
	 */
	void exitLeftParen(RuleParserParser.LeftParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#rightParen}.
	 * @param ctx the parse tree
	 */
	void enterRightParen(RuleParserParser.RightParenContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#rightParen}.
	 * @param ctx the parse tree
	 */
	void exitRightParen(RuleParserParser.RightParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#colon}.
	 * @param ctx the parse tree
	 */
	void enterColon(RuleParserParser.ColonContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#colon}.
	 * @param ctx the parse tree
	 */
	void exitColon(RuleParserParser.ColonContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(RuleParserParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(RuleParserParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#right}.
	 * @param ctx the parse tree
	 */
	void enterRight(RuleParserParser.RightContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#right}.
	 * @param ctx the parse tree
	 */
	void exitRight(RuleParserParser.RightContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#other}.
	 * @param ctx the parse tree
	 */
	void enterOther(RuleParserParser.OtherContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#other}.
	 * @param ctx the parse tree
	 */
	void exitOther(RuleParserParser.OtherContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#actions}.
	 * @param ctx the parse tree
	 */
	void enterActions(RuleParserParser.ActionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#actions}.
	 * @param ctx the parse tree
	 */
	void exitActions(RuleParserParser.ActionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(RuleParserParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(RuleParserParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#assignAction}.
	 * @param ctx the parse tree
	 */
	void enterAssignAction(RuleParserParser.AssignActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#assignAction}.
	 * @param ctx the parse tree
	 */
	void exitAssignAction(RuleParserParser.AssignActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#outAction}.
	 * @param ctx the parse tree
	 */
	void enterOutAction(RuleParserParser.OutActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#outAction}.
	 * @param ctx the parse tree
	 */
	void exitOutAction(RuleParserParser.OutActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#methodInvoke}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvoke(RuleParserParser.MethodInvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#methodInvoke}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvoke(RuleParserParser.MethodInvokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#functionInvoke}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvoke(RuleParserParser.FunctionInvokeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#functionInvoke}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvoke(RuleParserParser.FunctionInvokeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#actionParameters}.
	 * @param ctx the parse tree
	 */
	void enterActionParameters(RuleParserParser.ActionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#actionParameters}.
	 * @param ctx the parse tree
	 */
	void exitActionParameters(RuleParserParser.ActionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#beanMethod}.
	 * @param ctx the parse tree
	 */
	void enterBeanMethod(RuleParserParser.BeanMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#beanMethod}.
	 * @param ctx the parse tree
	 */
	void exitBeanMethod(RuleParserParser.BeanMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#complexValue}.
	 * @param ctx the parse tree
	 */
	void enterComplexValue(RuleParserParser.ComplexValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#complexValue}.
	 * @param ctx the parse tree
	 */
	void exitComplexValue(RuleParserParser.ComplexValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(RuleParserParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(RuleParserParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void enterParameterName(RuleParserParser.ParameterNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#parameterName}.
	 * @param ctx the parse tree
	 */
	void exitParameterName(RuleParserParser.ParameterNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(RuleParserParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(RuleParserParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(RuleParserParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(RuleParserParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#namedVariable}.
	 * @param ctx the parse tree
	 */
	void enterNamedVariable(RuleParserParser.NamedVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#namedVariable}.
	 * @param ctx the parse tree
	 */
	void exitNamedVariable(RuleParserParser.NamedVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(RuleParserParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(RuleParserParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#variableCategory}.
	 * @param ctx the parse tree
	 */
	void enterVariableCategory(RuleParserParser.VariableCategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#variableCategory}.
	 * @param ctx the parse tree
	 */
	void exitVariableCategory(RuleParserParser.VariableCategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#namedVariableCategory}.
	 * @param ctx the parse tree
	 */
	void enterNamedVariableCategory(RuleParserParser.NamedVariableCategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#namedVariableCategory}.
	 * @param ctx the parse tree
	 */
	void exitNamedVariableCategory(RuleParserParser.NamedVariableCategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#constantCategory}.
	 * @param ctx the parse tree
	 */
	void enterConstantCategory(RuleParserParser.ConstantCategoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#constantCategory}.
	 * @param ctx the parse tree
	 */
	void exitConstantCategory(RuleParserParser.ConstantCategoryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(RuleParserParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(RuleParserParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleParserParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(RuleParserParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleParserParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(RuleParserParser.OpContext ctx);
}