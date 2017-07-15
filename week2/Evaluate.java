/**
 * Created by caingmico on 06/07/2017.
 */
public class Evaluate
{
    /** implement function evaluate using two stack mechanism.
     *  the function may have parenthesis
     */

    public void main(String[] args)
    {
        Stack<Double> vals = new Stack<Double>();
        Stack<String> ops = new Stack<String>();
        while(!StdIn.isEmpty())
        {
            String s = Stdin.readString();
            if      (s.equals("("))           ;
            else if (s.equals("+")) ops.push();
            else if (s.equals("*")) ops.push();
            else if (s.equals(")"))
            {
               String op = ops.pop();
               if      (op.equals("+"))
               { vals.push(vals.pop() + vals.pop()); }
               else if (op.equals("*"))
               { vals.push(vals.pop() * vals.pop()); }
            }
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
