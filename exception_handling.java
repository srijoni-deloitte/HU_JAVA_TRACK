public class exception_handling {
    public static void main(String args[]){
        try{
            int a=30,b=0;
            int result=a/b;
            System.out.println("result is"+result);


        }

        catch(ArithmeticException e){
            System.out.println("Thank you");

        }
    }
}
