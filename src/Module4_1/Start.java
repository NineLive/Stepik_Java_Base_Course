package Module4_1;

import java.util.Arrays;

public class Start {
    public static void start() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stack = new Exception().getStackTrace();
        System.out.println(Arrays.toString(stack));
        if (stack.length > 2) {
            String nameMethod = stack[2].getMethodName();
            String nameClass = stack[2].getClassName();
            return nameClass + "#" + nameMethod;
        }
        return null;
    }

}
