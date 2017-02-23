/*
 * Cobalt Programming Language Compiler
 * Copyright (C) 2017  Michael Haywood
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package compiler.parser.loops

import compiler.block.Block
import compiler.block.loops.ForBlock
import compiler.parser.Parser
import compiler.tokenizer.{Token, Tokenizer}

/*
need to make parameter single variable names instead as cant define a variable in an ifs...
 */
class ForParser extends Parser[ForBlock] {

  def shouldParse(line: String): Boolean = line.matches("for \\([a-zA-Z][a-zA-Z0-9]* [a-zA-Z][a-zA-Z0-9]* = [0-9]+([.][0-9]*)?; [a-zA-Z][a-zA-Z0-9]* [<|>|<=|>=|==] [0-9]+([.][0-9]*)?; [a-zA-Z][a-zA-Z0-9]*\\+\\+\\):")
  
  def parse(superBlock: Block, tokenizer: Tokenizer): ForBlock = {
    tokenizer.nextToken //skip "for"
    tokenizer.nextToken // skip "("
    val first: Token = tokenizer.nextToken
    return new ForBlock(superBlock, first.token)
  }

}
