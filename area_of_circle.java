public class file {
    static double areatri(double h, double b, double r)
    {

        // area of triangle'
        double s;
        double area;
        s=(h+b+r);
        area=Math.sqrt(s*(s-h)*(s-b)*(s-r));
        return area;
    }
    static double circle(double r)
    {

        // area of a circle
        return (3.14 * (r*r));
    }
    static double rectangle(double h,double m){




        // area of a rectangle
        return (h * m);
    }


    public static void main(String[] args)
    {

        double h = 10;
        double r = 5;


        double b = 5;



        System.out.println("Area of the triangle: "
                + areatri(h, b,r));
        System.out.println("Area of circle is: "+circle(r));
        System.out.println("Area of rectangle is: "+rectangle(h,b));
    }
}
