/* MyLine
 * By: Deon Hua
 * Date: 11 February 2014
 * Description: MyLine class. This class extends MyShape. 
 */

// Import classes.
import java.awt.Color; 
import java.awt.Graphics; 

public class MyLine extends MyShape
{   
    // Default constructor, calls the superclass's constructor that sets it to default values. 
    public MyLine ()
    {
        super();
    }
    
    // Constructor given input. Takes in integers x1, x2, y1, y2, and Color object color.
    public MyLine (int x1, int x2, int y1, int y2, Color color)
    {
        super(x1, x2, y1, y2, color);
    }
    
    // Draws the line given a Graphics object, g. Returns nothing. 
    public void draw (Graphics g)
    {
        g.setColor( getColor() ); 
        g.drawLine( getX1(), getY1(), getX2(), getY2() ); 
    }
}


