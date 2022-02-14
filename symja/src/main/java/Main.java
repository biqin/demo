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
import org.redisson.Redisson;
import org.redisson.api.RPriorityBlockingQueue;
import org.redisson.api.RPriorityQueue;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;

import javax.script.ScriptEngine;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

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

//        RedissonClient redisson = Redisson.create();
//        RScoredSortedSet zset = redisson.getScoredSortedSet("dd");
//        RPriorityQueue queue1 = redisson.getPriorityQueue("anyQueue");
//        PriorityBlockingQueue queue2 = new PriorityBlockingQueue();


        EvalEngine engine = new EvalEngine();
        MathMLContentUtilities mathUtil = new MathMLContentUtilities(engine);

        StringWriter stw = new StringWriter();
//        mathUtil.toJava("<math mathvariant='italic' display='inline'>    <mfrac>        <mn>1</mn>        <mn>2</mn>    </mfrac>    <mo>&le;</mo>    <mi>x</mi>    <mo>&le;</mo>    <mfrac>        <mn>5</mn>        <mn>2</mn>    </mfrac></math>",
//                stw, true);
//        System.out.println(stw.toString());
        mathUtil.toMathML("a*b", stw);
        System.out.println(stw.toString());

        float a = -23.2222f;
        System.out.printf("Fees: %10.2f-\n", -a);
    }

    private void showAmount(String topic, float amount) {
        String format = (amount < 0) ? "%s: %10.2f-\n" : "%s: %10.2f\n";
        showAmountWithFormat(topic, amount, format);
    }

    private void showAmountWithFormat(String topic, float amount, String format) {
        String topicAmount = String.format(format, topic, amount);
        System.out.println(topicAmount);
    }

    private void printLineSeparator() {
        System.out.println("----\n");
    }


}
