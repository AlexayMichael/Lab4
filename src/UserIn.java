
import com.elephant.data.Expression;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserIn {

  String userinput = "";
  Expression myexpression = new Expression();

  public void userinput() {
    Scanner theNowPoly = new Scanner(System.in);
    userinput = theNowPoly.nextLine();
  }


  /**
   *  匹配用户输入数据 .
   */
  public void match() {
	  
    String monomial = "(\\s*)(\\d+|[a-zA-Z]+(\\^\\d+)?)(\\s*)((\\*(\\s*)(\\d+|[a-zA-Z]"
        + "+(\\^\\d+)?)(\\s*))*)";

    Pattern expressionP = Pattern.compile("((" + monomial + "){1}?)(((\\+|\\-)" + monomial + ")*)");
    Matcher expressionM = expressionP.matcher(userinput);

    Pattern simplifyP = Pattern.compile("!simplify((\\s*)([a-zA-Z]+=\\d+))*");
    //此处不能匹配形如 !simplify y = 2 这样等号两边有空格的情况，修改正则表达式后仍然有问题，
    //发现是用了字符数组中的元素的位置来确定变量的值，为了不做大的改动，这里没有修改
    final Matcher simplifyM = simplifyP.matcher(userinput);

    Pattern derivativeP = Pattern.compile("!d/d(\\s*)[a-zA-Z]+");
    final Matcher derivativeM = derivativeP.matcher(userinput);

    if (expressionM.matches()) {
      myexpression.getExpression(userinput);
    } else if (simplifyM.matches()) {
      myexpression.simplify(userinput);
    } else if (derivativeM.matches()) {
      myexpression.derivative(userinput);
    } else {
      System.out.println("input error!");
    }
    
    
  }


  /**
   * 程序入口函数.
   * @param args 字符数组
   */
  public static void  main(String[] args) {
    final UserIn myuser = new UserIn();
    while (!myuser.userinput.equals("exit"))  { //输入exit，程序退出
      myuser.userinput();
      myuser.match();
    }

  }
}
//修改1
