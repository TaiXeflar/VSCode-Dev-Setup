
public class test
{

    public static void main(String[] args)
    {
        int sum = add(1, 2, 3);
        System.out.println("Hello world");
        System.out.println("Sum 1~3 = " +sum);
    }

    public static int add(int... numbers)
    {
        int sum = 0;
        for (int num : numbers)
        {
            sum +=num;
        }
        return sum;
    }
}