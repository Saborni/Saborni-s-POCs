package org;

import org.junit.jupiter.api.*;

public class TestMathUtils {

    private MathUtils mathUtils;

    @BeforeAll
    public static void beforeallinit(){
        System.out.println("...Runs before all...");
    }

    @BeforeEach
    public void init(){
        mathUtils = new MathUtils();
    }

    @AfterEach
    public void clear(){
        System.out.println("...clearing...");
    }

    @AfterAll
    public static void afterallinit(){
        System.out.println("...Runs after all...");
    }

    @Test
    public void testadd() {
        Assertions.assertEquals(23,mathUtils.add(11,12),"It should add two nums..");
    }

    @Test
    public void testcomputeCircleArea() {
        Assertions.assertEquals(314.0,mathUtils.computeCircleArea(10), "value of radius::");
    }

    @Test
    public void testdivide() {
        Assertions.assertThrows(ArithmeticException.class,()-> mathUtils.divide(1,0), "ArithmeticException as div by 0");
    }


    @Test
    @DisplayName("A failure test case")
    public void displaynamedemo(){
        Assertions.fail("This will fail");
    }

    @Test
    @Disabled
    public void disabledtestcase(){
        Assertions.fail("This is disabled");
    }
}