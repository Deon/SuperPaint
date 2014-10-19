/* MyShape
 * By: Deon Hua
 * Date: 9 February 2014
 * Description: TestDraw - this "tests" the DrawPanel class, and runs the entire program. 
 * Input from the user is taken here.
 */

// Import classes.
import javax.swing.JFrame; 


public class TestDraw 
{ 
    //Main method. 
    public static void main( String args[] ) 
    {  
        //Instantiates objects.

        DrawFrame application = new DrawFrame();         
        
        //Sets up the window. 
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
        application.setSize( 500, 500 ); 
        application.setVisible( true ); 
    } // end main     
}
