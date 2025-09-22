package reflection2;

public class Testscript2 {
    public static void createCustomer(){
        System.out.println("Customer created successful");
    }

    public static void modifyCustomer(){
        System.out.println("Customer Modified successful");
    }

    public static void deleteCustomer(){
        System.out.println("Customer Delete successful");
    }

    static {
        createCustomer();
        modifyCustomer();
        deleteCustomer();
    }
}
