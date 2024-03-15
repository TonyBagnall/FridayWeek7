package uk.ac.soton.comp1206;

public class DebuggerExample {

    static int aFunction(String str){
        String res= anotherFunction(str, 49);
        System.out.println(res);
        return 33;
    }
    static String anotherFunction(String str, int a){
        return str+a;

    }
    public static void main(String[] args) {
        String str = "hello";
        int x = aFunction("AFC");
        System.out.println(x);
    }
}
