import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class reverse
{
//     reverse a string in Java using `Collections.reverse()`
    public static String reverse1(String str)
    {
//  base case given if it is none or empty
        if (str == null || str.equals("")) {
            return str;
        }

//        empty list of characters
        List<Character> list = new ArrayList<Character>();
//        push every characters here

        for (char c: str.toCharArray()) {
            list.add(c);
        }

//        reverse those letters using collection
        Collections.reverse(list);

        // convert `ArrayList` into string and return it
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args)
    {
        String str = "anything we want to reverse";


        str = reverse1(str);
//   we are printing the data
        System.out.println("The reversed string is " + str);
    }
}