import java.util.Scanner;
public class array12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        take new variable
//using two loops structure calculate the sum..corresponding to every index,,till how much it can be included
//now whenever sum would come to 0 increment the count
        int n = sc.nextInt();
        int a[] = new int[n];
        int i,j,sum = 0;
        for(i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        int count=0;
        for(i=0;i<n;i++)
        {
            sum = 0;
            for(j=i;j<n;j++)
            {
                sum = sum + a[j];
                if(sum<0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
