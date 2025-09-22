package groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsDemo {
    @Test(groups = "SMOKE")
    public void testScript1(){
        System.out.println("The TestScript1() test case executed successful");
    }

    @Test(groups = "SMOKE")
    public void testScript2(){
        System.out.println("The testScript2() test case executed successful");
    }

    @Test(groups = "SMOKE")
    public void testScript3(){
        System.out.println("The testScript3() test case executed successful");
    }

    @Test(groups = "REGRESSION")
    public void testScript4(){
        System.out.println("The testScript4() test case executed successful");
    }

    @Test(groups = "REGRESSION")
    public void testScript5(){
        System.out.println("The testScript5() test case executed successful");
    }

    @Test(groups = "REGRESSION")
    public void testScript6(){
        System.out.println("The testScript6() test case executed successful");
    }

    @Test(groups = {"SMOKE","REGRESSION"})
    public void testScript7(){
        System.out.println("The testScript7() test case executed successful");
    }
    @BeforeGroups(value = "SMOKE")
    public void beforeGroupDemoForSmoke(){
        System.out.println("SMOKE's @BeforeGroups Example");
    }

    @AfterGroups(value = "SMOKE")
    public void afterGroupDemoForSmoke(){
        System.out.println("SMOKE's @AfterGroups Example");
    }


    @BeforeGroups(value = "REGRESSION")
    public void beforeGroupDemoForRegression(){
        System.out.println("REGRESSION's @BeforeGroups Example");
    }

    @AfterGroups(value = "REGRESSION")
    public void afterGroupDemoForRegression(){
        System.out.println("REGRESSION's @AfterGroups Example");
    }
}
