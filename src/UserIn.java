import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.elephant.data.Expression;
public class UserIn {
	
	String userinput = "";
	Expression myexpression=new Expression();
	
	public void userinput()
	{
		Scanner in = new Scanner(System.in);
		userinput = in.nextLine();
	}
	
	
	//ƥ���û���������
	public void match()
	{
		String monomial = "(\\s*)(\\d+|[a-zA-Z]+(\\^\\d+)?)(\\s*)((\\*(\\s*)(\\d+|[a-zA-Z]+(\\^\\d+)?)(\\s*))*)";
		
		Pattern expressionP = Pattern.compile("(("+monomial+"){1}?)(((\\+|\\-)"+monomial+")*)");
		Matcher expressionM = expressionP.matcher(userinput);
		
		Pattern simplifyP = Pattern.compile("!simplify((\\s*)([a-zA-Z]+=\\d+))*");
		Matcher simplifyM = simplifyP.matcher(userinput);
		
		Pattern derivativeP = Pattern.compile("!d/d(\\s*)[a-zA-Z]+");
		Matcher derivativeM = derivativeP.matcher(userinput);
		
		if(expressionM.matches())
		{
			myexpression.getExpression(userinput);
			
        }
		else if(simplifyM.matches())
		{
			myexpression.simplify(userinput);
		}
		else if(derivativeM.matches())
		{
			myexpression.derivative(userinput);
		}
		else
		{
			System.out.println("input error!");
		}
		
		
	}
	
	
	//������ں���
	public static void  main(String[] args)
	{
		UserIn myuser = new UserIn();
		while(!myuser.userinput.equals("exit"))//����exit�������˳�
		{
			
			myuser.userinput();
			myuser.match();
		}
		
    }
}
//�޸�1

//ʵ�鳡��2����֧����.5