package sumofints;

public class SumOfInts {

    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
        int[] a = { 10, 20, 30, 40, 50, 60 };
        int[] b = new int[a.length];
        for (int x = 0; x < a.length; x++ ) {
            b[x] = a[x];
        }
        b[1] = 2112;
        System.out.println(a[1] + " " + b[1]);
    }
}
