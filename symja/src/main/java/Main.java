import com.sun.javafx.fxml.expression.ExpressionValue;
import org.matheclipse.core.convert.AST2Expr;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.eval.MathMLContentUtilities;
import org.matheclipse.core.eval.MathMLUtilities;
import org.matheclipse.core.expression.AST;
import org.matheclipse.core.form.mathml.MathMLContentTestCase;
import org.matheclipse.core.form.mathml.MathMLFormFactory;
import org.matheclipse.core.form.mathml.MathMLPresentationTestCase;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.patternmatching.PatternMatcherAndEvaluator;
import org.matheclipse.parser.client.Parser;
import org.matheclipse.parser.client.ast.ASTNode;
import org.matheclipse.parser.client.eval.DoubleEvaluator;
import org.matheclipse.parser.client.eval.DoubleVariable;
import org.matheclipse.parser.client.eval.IDoubleValue;

import javax.script.ScriptEngine;
import java.io.StringWriter;

/**
 * @author: bq
 * @create: 2020-11-24 14:23
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        Parser parser = new Parser();
//        ASTNode ast1 = parser.parse("a+b+c=b+d");
//        ASTNode ast2 = parser.parse("b+a+c=b+d");
//
//        AST2Expr ast2Expr = new AST2Expr();
//        IExpr expr1 = ast2Expr.convert(ast1);
//        IExpr expr2 = ast2Expr.convert(ast2);
//        IExpr expr = expr1.minus(expr2);
//
//        EvalEngine evalEngine = new EvalEngine();
//        evalEngine.evaluate("a+b-b-a");
//
//        System.out.println(ast1.toString());
//        System.out.println(ast2.toString());

        EvalEngine engine = new EvalEngine();
        MathMLContentUtilities mathUtil = new MathMLContentUtilities(engine);

        StringWriter stw = new StringWriter();
//        mathUtil.toJava("<math mathvariant='italic' display='inline'>    <mfrac>        <mn>1</mn>        <mn>2</mn>    </mfrac>    <mo>&le;</mo>    <mi>x</mi>    <mo>&le;</mo>    <mfrac>        <mn>5</mn>        <mn>2</mn>    </mfrac></math>",
//                stw, true);
//        System.out.println(stw.toString());
        mathUtil.toMathML("a*b", stw);
        System.out.println(stw.toString());
    }
}
