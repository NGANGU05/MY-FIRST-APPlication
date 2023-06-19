/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package harvey1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 
 */
public class testtaskTest {
    testtask my;
  
    
    public testtaskTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        my = new testtask();
    }
    
    @AfterEach
    public void tearDown() {
        my = null;
    }

    @Test
    public void testData1() {
        String n= "Mike Smith";
        my.data1(n);
  assertEquals("Mike Smith",n);
    }

    @Test
    public void testData2() {
        String n ="Edward Harrison";
        my.data2(n);
        assertEquals("Edward Harrison",n);
    }

    @Test
    public void testData3() {
        String n ="Samantha Paulson";
        my.data2(n);
        assertEquals("Samantha Paulson",n);
    }

    @Test
    public void testData4() {
        String n ="Glenda Oberholzer";
        my.data2(n);
        assertEquals("Glenda Oberholzer",n);
    }

    @Test
    public void testData5() {
        String Developer ="Glenda Oberholzer 11"; 
        my.data5(Developer);
        assertEquals("Glenda Oberholzer 11",Developer);
    }

    @Test
    public void testData6() {
       String Developer ="Mike Smith";   
       String TaskName ="Create Login";
       my.data6(TaskName);
       String ss= Developer + TaskName; 
       assertEquals(ss,ss);
    }

    @Test
    public void testData7() {
        String Developer ="Samantha Paulson";   
        String TaskName ="Create Report";
        my.data7(TaskName);
        String dd= Developer + TaskName;
assertEquals(dd,dd);
    }

    @Test
    public void testData8() {
         String TaskName ="Create Report";
         String DeleteTask= "succefully deleted";
         my.data8(TaskName);
         assertEquals(DeleteTask,DeleteTask);
         
    }

    @Test
    public void testData9() {
        String DisplayReport=""; 
        my.data9(DisplayReport);
        assertEquals(DisplayReport,DisplayReport);
    }
    

}