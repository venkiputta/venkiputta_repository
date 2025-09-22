package reflection;

import java.lang.reflect.Method;

public class Driverscript1 {
    public static void main(String[] args) {
        Testscript1 test = null;
        try{
            test = new Testscript1();
            Method[] scripts = test.getClass().getMethods();
            for(int i=0; i<scripts.length; i++){
                if(scripts[i].getName().contains("User")){
                    scripts[i].invoke(test);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
