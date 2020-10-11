import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;

public class HelloPolyglot {

	static String JS_CODE = "( function myFun(param){console.log('hello ' + param); return param * 10;  }  ) ";

	public static void main(String[] args){

		System.out.println("Hello Java from Graamlvm");

		try(Context context = Context.create()){

			Value value = context.eval("js", JS_CODE);
			System.out.println("Results from myFun : " + value.execute(args[0]));

		}
	}
}