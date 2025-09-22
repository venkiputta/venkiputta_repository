package reflection3;

import java.lang.reflect.Method;

public class DriverClass3 {
    public static void main(String[] args) {
        String filePath = null;
        Class cls = null;
        Object obj = null;
        Method script = null;
        try{
            filePath = System.getProperty("user.dir")+"\\Runner\\RunController.xlsx";
            int rowCount = Datatable.getRowCount(filePath, "Runner");
            for(int i=0; i<=rowCount; i++){
                String scriptName = Datatable.getCellData(filePath, "Runner", "TestScript", i);
                String packageName = Datatable.getCellData(filePath, "Runner", "packageName", i);
                String executeTest = Datatable.getCellData(filePath, "Runner", "ExecuteTest", i);

                if(executeTest.equalsIgnoreCase("Yes")){
                    cls = Class.forName(packageName);
                    obj = cls.getDeclaredConstructor().newInstance();
                    script = obj.getClass().getMethod(scriptName);
                    script.invoke(obj);
                }
            }
        }catch(Exception e){
            System.out.println("Exception in main method: "+e);
        }
    }

}
