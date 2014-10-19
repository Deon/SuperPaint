/* DrawFrame
 * By: Deon Hua
 * Date: 21 April 2014
 * Description: The DrawFrame class for the SuperPaint application
 */

// Importing
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class DrawFrame extends JFrame
{
    private BorderLayout layout;
    private JPanel buttonPanel;
    
    private JButton undo;
    private JButton redo;
    private JButton clear;
    
    private String[] colors = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
        "Pink", "Red", "White", "Yellow"};
    private String[] shapes = {"Line", "Oval", "Rectangle"};
    
    private JComboBox colorChooser;
    private JComboBox shapeChooser;
    private JCheckBox fillChooser;
    
    private JLabel label;
    private DrawPanel panel;
    
    // Constructors. 
    public DrawFrame(){
        super("SuperPaint");
        layout = new BorderLayout(3,1);
        setLayout(layout);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        label = new JLabel();
        panel = new DrawPanel(label);
        
        undo = new JButton ("Undo");
        redo = new JButton ("Redo");
        clear = new JButton ("Clear");
        
        
        colorChooser = new JComboBox(colors);
        shapeChooser = new JComboBox(shapes);
        
        fillChooser = new JCheckBox ("Filled");
        
        buttonPanel.add(undo);
        buttonPanel.add(redo);
        buttonPanel.add(clear);
        buttonPanel.add(colorChooser);
        buttonPanel.add(shapeChooser);
        buttonPanel.add(fillChooser);
        
        add(buttonPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH); 
        
        ButtonHandler buttonHandler = new ButtonHandler();
        CheckBoxHandler checkHandler = new CheckBoxHandler();
        ComboBoxHandler comboHandler = new ComboBoxHandler();
        undo.addActionListener(buttonHandler);
        redo.addActionListener(buttonHandler);
        clear.addActionListener(buttonHandler);
        fillChooser.addItemListener(checkHandler);
        colorChooser.addItemListener(comboHandler);
        shapeChooser.addItemListener(comboHandler);
    }
    
    // Handles events for buttons.
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed (ActionEvent event){
            if (event.getSource() == undo){
                panel.clearLastShape();
            }                
            else if (event.getSource() == redo){
                panel.redoLastShape();
            }
            else {
                panel.clearDrawing();
            }               
            
        }
        
    }
    
    //Handles events for the check box. 
    private class CheckBoxHandler implements ItemListener
    {
        public void itemStateChanged (ItemEvent event){
            if (event.getStateChange() == 1){
                panel.setCurrentShapeFilled(true);
            }
            else {
                panel.setCurrentShapeFilled(false);
            }
        }
        
    }
    
    // Handles drop-down boxes.
    private class ComboBoxHandler implements ItemListener
    {
        public void itemStateChanged (ItemEvent event){
            if (event.getSource() == colorChooser){
                System.out.print(colorChooser.getSelectedIndex());
                switch(colorChooser.getSelectedIndex()){
                    case 0: panel.setCurrentShapeColor(Color.BLACK);                                   
                    break;
                    case 1: panel.setCurrentShapeColor(Color.BLUE);    
                    break;
                    case 2: panel.setCurrentShapeColor(Color.CYAN);                    
                    break;
                    case 3: panel.setCurrentShapeColor(Color.DARK_GRAY);
                    break;
                    case 4: panel.setCurrentShapeColor(Color.GRAY);
                    break;
                    case 5: panel.setCurrentShapeColor(Color.GREEN);
                    break;
                    case 6: panel.setCurrentShapeColor(Color.LIGHT_GRAY);
                    break;
                    case 7: panel.setCurrentShapeColor(Color.MAGENTA);
                    break;
                    case 8: panel.setCurrentShapeColor(Color.ORANGE);
                    break;
                    case 9: panel.setCurrentShapeColor(Color.PINK);
                    break;
                    case 10: panel.setCurrentShapeColor(Color.RED);
                    break;
                    case 11: panel.setCurrentShapeColor(Color.WHITE);
                    break;
                    case 12: panel.setCurrentShapeColor(Color.YELLOW);
                    break;
                }                 
                
                
            }
            

            else {
                panel.setCurrentShapeType(shapeChooser.getSelectedIndex());
                
            
            }
        }
        
    }
    
}       

