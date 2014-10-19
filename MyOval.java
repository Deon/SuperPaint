/* MyOval
 * By: Deon Hua
 * Date: 11 February 2014
 * Description: MyOval Class. This class inherits from MyNoundedShape which inherits from MyShape.
 */

// Import classes.
import java.awt.Color; 
import java.awt.Graphics; 

public class MyOval extends MyBoundedShape
{   
    // Default constructor, calls the superclass's constructor that sets it to default values. 
    public MyOval ()
    {
        super();
    }
    
    // Constructor given input. Takes in integers x1, x2, y1, y2, Color object color, and boolean filled.
    public MyOval (int x1, int x2, int y1, int y2, Color color, boolean filled)
    {
        super(x1, x2, y1, y2, color, filled);
    }    
    
    // Draws the oval given a Graphics object, g. Returns nothing. 
    public void draw (Graphics g)
    {
        g.setColor( getColor() ); 
        
        if (getFilled()){            
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else{
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }
}
