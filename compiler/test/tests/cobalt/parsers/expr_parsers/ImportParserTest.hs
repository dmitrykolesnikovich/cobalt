module ImportParserTest where

import Test.HUnit

import Text.Megaparsec

import Block

import BaseParser
import ExprParser
import Parser

testSingleImport :: Test
testSingleImport = do
  let code = "import x"
  TestCase $ assertEqual code
    (Import ["x"])
    (case (parse importParser "" code) of
      Left  e -> Error
      Right x -> x)

testEmptyImportFail :: Test
testEmptyImportFail = do
  let code = "import "
  TestCase $ assertEqual code
    Error
    (case (parse importParser "" code) of
      Left  e -> Error
      Right x -> x)

testTwoImport :: Test
testTwoImport = do
  let code = "import x.y"
  TestCase $ assertEqual code
    (Import ["x", "y"])
    (case (parse importParser "" code) of
      Left  e -> Error
      Right x -> x)

testMultiImport :: Test
testMultiImport = do
  let code = "import x.y.z.a.b.c"
  TestCase $ assertEqual code
    (Import ["x", "y", "z", "a", "b", "c"])
    (case (parse importParser "" code) of
      Left  e -> Error
      Right x -> x)
