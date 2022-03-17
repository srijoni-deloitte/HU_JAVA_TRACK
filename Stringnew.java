import java.util.Scanner;
public class Stringnew {
    public static boolean stringshuffle(String s1,String s2,String s3) {
        int j=0,k=0;
        boolean bool = true;
        for(int i=0;i<s3.length();i++)
        {
            if(j<s1.length() && s3.charAt(i) == s1.charAt(j))
            {
                j++;
            }
            else if(k<s2.length() && s3.charAt(i) == s2.charAt(k))
            {
                k++;
            }
            else
            {
                bool = false;
                break;
            }
        }
        return bool;
    }
    public static void main(String[] args)
    {
        String str1,str2,str3;

        Scanner sc=new Scanner(System.in);
        System.out.print("enter String 1: ");
        str1=sc.nextLine();
        System.out.print("enter String 2: ");
        str2=sc.nextLine();
        System.out.print("enter String 3: ");
        str3=sc.nextLine();




        if (stringshuffle(str1,str2,str3))
            System.out.println("Valid Shuffle");
        else
            System.out.println("Invalid Shuffle");
    }
}

