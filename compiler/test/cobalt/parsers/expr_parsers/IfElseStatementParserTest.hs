module IfElseStatementParserTest where

import Test.HUnit

import Text.Megaparsec

import Block

import BaseParser
import ExprParser
import Parser

testIfStmtParserBooleanTrue :: Test
testIfStmtParserBooleanTrue = do
  let code = unlines [
        "if(True)",
        "  println(\"Test\")"
        ]
  TestCase $ assertEqual code
    (If (Argument $ BooleanExpr (BoolConst True)) [Print (Argument $ StringLiteral "Test")])
    (case (parse (ifStmtParser) "" code) of
      Left  e -> Error
      Right x -> x)

testIfStmtParserBooleanFalse :: Test
testIfStmtParserBooleanFalse = do
  let code = unlines [
        "if(True)",
        "  println(\"Test\")"
        ]
  TestCase $ assertEqual code
    (If (Argument $ BooleanExpr (BoolConst True)) [Print (Argument $ StringLiteral "Test")])
    (case (parse (ifStmtParser) "" code) of
      Left  e -> Error
      Right x -> x)

testIfStmtParserObjectVar :: Test
testIfStmtParserObjectVar = do
  let code = unlines [
        "if(objName.varName)",
        "  println(\"Test\")"
        ]
  TestCase $ assertEqual code
    (If (Argument $ BooleanExpr (BoolConst True)) [Print (Argument $ ClassVariable "objName" "varName")])
    (case (parse (ifStmtParser) "" code) of
      Left  e -> Error
      Right x -> x)