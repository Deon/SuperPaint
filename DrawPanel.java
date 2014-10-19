/* DrawPanel
 * By: Deon Hua
 * Date: 11 February 2014
 * Description: DrawPanel. All of the images are compiled here.
 */

// Import classes.
import java.awt.Color; 
import java.awt.Graphics; 
import java.util.ArrayList;
import javax.swing.JPanel; 
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;


public class DrawPanel extends JPanel 
{ 
    // Instance variables.
    private ArrayList<MyShape> shapeObjects;
    private int currentShapeType;
    private MyShape currentShapeObject;
    private MyShape oldShape;
    private Color currentShapeColor;
    private boolean currentShapeFilled;
    private JLabel statusLabel;
    
    // Constructor
    public DrawPanel(JLabel label){
        statusLabel = label;
        shapeObjects = new ArrayList<MyShape>();
        currentShapeType = 0;
        currentShapeColor = Color.BLACK;
        setBackground(Color.WHITE);
        
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }
    
    // Draws components on the screen.
    public void paintComponent(Graphics g)
    {
        super.paintComponent( g );               
        
        for (int element = 0; element < shapeObjects.size(); element++){
            shapeObjects.get(element).draw(g);
        }
        if (currentShapeObject != null){            
            currentShapeObject.draw(g);
        }
        
    }
    
    // Set the shape's type.
    public void setCurrentShapeType(int shape){
        currentShapeType = shape;
    }
    
    // Sets the shape's colour.
    public void setCurrentShapeColor(Color currentShapeColor){
        this.currentShapeColor = currentShapeColor;
    }
    
    // Sets if the shape will be filled.
    public void setCurrentShapeFilled(boolean currentShapeFilled){
        this.currentShapeFilled = currentShapeFilled;
    }
    
    // Clears shape.
    public void clearLastShape(){ 
        if (shapeObjects.size() != 0){
            oldShape = shapeObjects.get(shapeObjects.size() - 1);
            shapeObjects.remove(shapeObjects.size()-1);
            repaint();
        }
    }
    
    public void redoLastShape(){
        if (oldShape != null){
            shapeObjects.add(oldShape);
        }
        repaint();
    }    
    
    public void clearDrawing(){
        oldShape = null;
        shapeObjects.clear();
        repaint();        
    }
    
    //Handles mouse events. 
    private class MouseHandler extends MouseAdapter  
    {
        // If the mouse is pressed down.
        public void mousePressed(MouseEvent event)
        {
            int x1 = event.getX();
            int y1 = event.getY();
            
            // If line.
            if (currentShapeType == 0){
                currentShapeObject = new MyLine (x1, x1, y1, y1, currentShapeColor);
                
            }
            // If oval.
            else if (currentShapeType == 1){
                currentShapeObject = new MyOval (x1, x1, y1, y1, currentShapeColor, currentShapeFilled);
                
            }
            // If rectangle.
            else if (currentShapeType == 2){
                currentShapeObject = new MyRectangle (x1, x1, y1, y1, currentShapeColor, currentShapeFilled);
                
            }    
        }
        
        // If the mouse is released.
        public void mouseReleased(MouseEvent event)
        {
            try {
                int x2 = event.getX();
                int y2 = event.getY();
                
                currentShapeObject.setX2(x2);
                currentShapeObject.setY2(y2);
                
                shapeObjects.add(currentShapeObject);
                currentShapeObject = null;
                repaint();
            }
            
            //Handles code if both mouse buttons are pressed/released.
            catch (NullPointerException ex){
            }
                
        }
        
        // If the mouse is moved, when no buttons are pressed down.
        public void mouseMoved(MouseEvent event)
        {
            String display = String.format("(%d, %d)", event.getX(), event.getY());
            statusLabel.setText(display);
        }
        
        // If the mouse is moved when the left mouse button is pressed down.
        public void mouseDragged(MouseEvent event)
        {
            try {
                
                int x2 = event.getX();
                int y2 = event.getY();
                currentShapeObject.setX2(x2);
                currentShapeObject.setY2(y2);
                
                String display = String.format("(%d, %d)", event.getX(), event.getY());
                statusLabel.setText(display);
                repaint();         
            }
            //Handles if you click both mouse buttons at the same time.
            catch (NullPointerException ex){
            }
        }
        
    }

}



