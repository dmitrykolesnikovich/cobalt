module TestUtil.TestUtil where

import System.Process

generatedDirectory :: String
generatedDirectory = "test_classes/"

executeBytecode :: FilePath -> IO String
executeBytecode filePath = do
  results <- readProcess "java" ["-cp", generatedDirectory, filePath] ""
  return results