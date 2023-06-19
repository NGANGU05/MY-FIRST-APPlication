package harvey1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test1 {
    TASKANDREPORT my;
    public Test1() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        my = new TASKANDREPORT  ();
    }
    
    @AfterEach
    public void tearDown() {
        my=null;
    }

    @Test
    public void testTaskNum() {
        boolean n = my.equals(true);
        assertEquals(true,n);
    }

    @Test
    public void testTaskMaker() {
        String l="ffff";
        
        assertEquals(l,0);
    }
    
   
}