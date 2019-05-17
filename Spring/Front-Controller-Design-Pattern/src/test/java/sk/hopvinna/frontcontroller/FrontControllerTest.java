package sk.hopvinna.frontcontroller;


import org.junit.Test;

public class FrontControllerTest {

    @Test
    public void testFrontController() {
    	 FrontController frontController = new FrontController(); 
         frontController.dispatchRequest("Teacher"); 
         frontController.dispatchRequest("Student"); 
    }
}