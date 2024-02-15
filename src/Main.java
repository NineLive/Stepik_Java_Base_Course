import Module4_1.Start;

import static Module4_1.Start.getCallerClassAndMethodName;

public class Main {

    public static void main(String[] args) {
//        Task4_3_2 task432 = new Task4_3_2();
//        task432.start();

        Start.start();
        System.out.println(getCallerClassAndMethodName());
        try{
            throw new Exception();
        } catch (Exception e){
            e.getStackTrace();
        }

    }
}




