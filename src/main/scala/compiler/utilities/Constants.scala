/*
 * Cobalt Programming Language Compiler
 * Copyright (C) 2017  Cobalt
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

package compiler.utilities

import compiler.structure.parsers.Parser
import compiler.structure.parsers.constants._
import compiler.structure.parsers.exceptions.{CatchParser, FinallyParser, TryParser}
import compiler.structure.parsers.ifs.{ElseParser, IfParser, SwitchParser}
import compiler.structure.parsers.imports.ImportParser
import compiler.structure.parsers.loops.{ForParser, WhileParser}
import compiler.structure.parsers.modifiers.ModifierParser
import compiler.structure.parsers.operators._
import compiler.structure.parsers.operators.assignment._
import compiler.structure.parsers.operators.assignment.bit._
import compiler.structure.parsers.operators.bit._
import compiler.structure.parsers.packages.PackageParser
import compiler.structure.parsers.prints.{PrintParser, PrintlnParser}
import compiler.structure.parsers.structures.kinds.{ClassParser, ObjectParser}
import compiler.structure.parsers.structures.methods.MethodParser
import compiler.structure.parsers.structures.{MethodCallParser, ObjectDefinitionParser, ObjectMethodCallParser}
import compiler.structure.parsers.syntax.ColonParser
import compiler.structure.parsers.variable.{DefineVariableParser, VariableParser}

object Constants {

  /* All available parsers */
  val parsers: List[Parser[_]] = List(


    /* if, else */
    new IfParser,
    new ElseParser,

    /* try, catch, finally */
    new TryParser,
    new CatchParser,
    new FinallyParser,

    /* printing */
    new PrintParser,
    new PrintlnParser,

    /* loops */
    new ForParser,

    new ObjectDefinitionParser,
    new ObjectMethodCallParser,
    new SwitchParser,
    new ModifierParser,
    new MethodParser,
    new MethodCallParser,
    new ImportParser,
    new WhileParser,

    new PackageParser,
    new ObjectParser,
    new ClassParser,

    /* bit assignments */
    new AndAssignOpParser,
    new ExclOrAssignOpParser,
    new InclOrAssignOpParser,
    new LeftShiftAssignOpParser,
    new RightShiftAssignOpParser,

    /* assignments */
    new AddAssignOpParser,
    new ModulusAssignOpParser,
    new MultiplyAssignOpParser,
    new SubtractAssignOpParser,

    /* bit */
    new ZeroRightFillShiftOpParser,
    new BitwiseAndOpParser,
    new BitwiseOrOpParser,
    new BitwiseXorOpParser,
    new LeftShiftOpParser,
    new RightShiftOpParser,


    /* operators */
    new OpeningBracketOpParser,
    new ClosingBracketOpParser,
    new PowerOfOpParser,
    new AndOpParser,
    new OrOpParser,
    new NotOpParser,
    new EqualsOpParser,
    new SmallerThanOpParser,
    new AddOpParser,
    new DivideOpParser,
    new MultiplyOpParser,
    new SubtractOpParser,
    new ModulusOpParser,
    new ColonParser,


    new AssignmentOpParser,
    new DefineVariableParser,

    new BooleanConstantParser,
    new CharConstantParser,
    new StringConstantParser,
    new FloatConstantParser,
    new DoubleConstantParser,
    new ShortConstantParser,
    new ByteConstantParser,
    new LongConstantParser,
    new IntConstantParser,

    new VariableParser
  )

}