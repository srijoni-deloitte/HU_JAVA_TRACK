import java.io.*;
import java.util.*;

class negative_subarray{ 
public static void printSubsequences(int[] arr, int index,
                                    ArrayList<Integer> path)
{

    if (index == arr.length)
    {
        if (path.size() > 1){
            int sum = 0;
            for(int d : path){
                sum += d;
            }
            if (sum<0){
                System.out.println(path);}
        }
        
    }
    else
    {
        printSubsequences(arr, index + 1, path);
        
        path.add(arr[index]);
        printSubsequences(arr, index + 1, path);
        path.remove(path.size() - 1);
    }
    return;
}

public static void main(String[] args)
{
    int n;  
    Scanner sc=new Scanner(System.in);  
    System.out.print("Enter the number of elements you want to store: ");  

    n=sc.nextInt();  

    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");  
    for(int i=0; i<n; i++)  
    {   
    arr[i]=sc.nextInt();  
    } 
    System.out.println("All subarrays with negative sum "); 
    ArrayList<Integer> path = new ArrayList<>();
    printSubsequences(arr, 0, path);
}
}
