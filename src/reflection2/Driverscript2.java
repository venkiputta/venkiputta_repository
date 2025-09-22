package reflection2;

public class Driverscript2 {
    public static void main(String[] args) {
        try{
            Class.forName("reflection2.Testscript2");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
