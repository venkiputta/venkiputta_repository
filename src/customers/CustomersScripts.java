package customers;

import org.testng.annotations.Test;

public class CustomersScripts {
    @Test
    public static void createCustomer(){
        System.out.println("Customer created successful");
    }
    @Test
    public static void modifyCustomer(){
        System.out.println("Customer Modified successful");
    }
    @Test
    public static void deleteCustomer(){
        System.out.println("Customer Delete successful");
    }
}
