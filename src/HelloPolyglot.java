import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;

import java.util.Arrays;

public class HelloPolyglot {

    static String JS_CODE = "( function myFun(message, myVal){console.log('Java calling JS : hello ' + message);  return myVal * 10 }  ) ";

    public static void main(String[] args) {
        log("Hello Java from Graamlvm");
        log(" Java args received : " + Arrays.asList(args));
        if (args.length > 1 && "once".equalsIgnoreCase(args[0])) {
            callNode(args[1], Integer.valueOf(args[2]));
        } else {
            new Thread(() -> {
                while (true) {
                    try {
                        callNode(args[1],Integer.valueOf(args[2]));
                        Thread.sleep(1000l);
                        log("Running in the background");
                    } catch (InterruptedException ee) {
                    }
                }
            }).start();
        }
    }

    public static Object callNode(String message, Integer myVal) {
        try (Context context = Context.create()) {
            Value value = context.eval("js", JS_CODE);
            //value.execute(message, myVal);
			Object returnValFromJs = value.execute(message, myVal);
            log("Results from myFun : " + returnValFromJs);
            return returnValFromJs;
        }
    }

    public static void updateEmployee(Employee emp) {
        log(emp);
        try (Context context = Context.create()) {
            Value value = context.eval("js", JS_CODE);
            //value.execute(message, myVal);
            Object returnValFromJs = value.execute(emp.getFirstName() + " " + emp.getLastName() , emp.getAge());
            log("Updating Age with new value : " + returnValFromJs);
            emp.setAge(Integer.parseInt(returnValFromJs.toString()));
        }
        log(emp);
    }

    private static void log(Object message){
        System.out.println("Java: " + message);
    }
}