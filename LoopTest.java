/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package looptest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import static javafx.scene.input.KeyCode.K;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author gaurav67
 */
public class LoopTest extends JPanel {
    
    /**
     * @param args the command line arguments
     */
        public static JTable table;
    public static JPanel panel;
    public static JFrame frame;
   
    Object aVal =(Object)Boolean.FALSE;
    Object aVal2 =(Object)Boolean.TRUE;

    //VECTOR OF VECTORS
    Object [][]array2;
        Vector<Vector<?>> vlist2 =  new Vector<Vector<?>>();
        Vector tempVector1 = new Vector();
        Vector tempVector2 = new Vector();
        Vector tempVector3 = new Vector();
        Vector tempVector4 = new Vector();
        Vector tempVector5 = new Vector();
        Vector tempVector6 = new Vector();
        Vector tempVector7 = new Vector();
        Vector tempVector8 = new Vector();
        Vector tempVector9 = new Vector();
    DefaultTableModel model2 = new  DefaultTableModel();
      
    ArrayList<ArrayList<ArrayList<Object>>> tempArrayListFull = new ArrayList<ArrayList<ArrayList<Object>>>();
    int rowCount=0;
    
    public LoopTest() {
        super();
     
       panel = new JPanel();
       frame = new JFrame();
       
     array2 = new Object [][]{
                
                {Boolean.FALSE, 1, 2, 3, 4},
                {Boolean.FALSE, 2, 1, 3, 5},
                {Boolean.TRUE, 3, 2, 1, 6},
                {Boolean.FALSE, 3, 1, 2, 7},
                {Boolean.FALSE, 1, 2, 3, 8},
                {Boolean.TRUE, 2, 1, 3, 9},
                {Boolean.TRUE, 3, 2, 1, 10},
                {Boolean.FALSE, 3, 1, 2, 11},
                {Boolean.FALSE, 3, 1, 2, 12},
             
         };
   
            for (int j = 0; j < array2[j].length; j++){
              tempVector1.add(array2[0][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector2.add(array2[1][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector3.add(array2[2][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector4.add(array2[3][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector5.add(array2[4][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector6.add(array2[5][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector7.add(array2[6][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector8.add(array2[7][j]);
     }
            for (int j = 0; j < array2[j].length; j++){
              tempVector9.add(array2[8][j]);
     }
            vlist2.clear();
            vlist2.add(tempVector1);
            vlist2.add(tempVector2);
            vlist2.add(tempVector3);
            vlist2.add(tempVector4);
            vlist2.add(tempVector5);
            vlist2.add(tempVector6);
            vlist2.add(tempVector7);
            vlist2.add(tempVector8);
            vlist2.add(tempVector9);
            
     Vector columnName= new Vector();
     columnName.add("CheckBox");
     columnName.add("Value1");
     columnName.add("Value2");
     columnName.add("Value3");
     columnName.add("Value4");
      
     model2.setDataVector(vlist2, columnName); 
     System.out.println(model2.getRowCount());
     rowCount=model2.getRowCount();
    

     table = new JTable(model2) {
                  
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                       
                        return Boolean.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return Integer.class;
                    case 3:
                        return Integer.class;
                    case 4:
                        return Integer.class;
                    default:
                        return Boolean.class;
                }
                
            }
             
        @Override
        public  Object  getValueAt( int row, int column){
        
            ArrayList<ArrayList<Object>> tempArrayList = new ArrayList<ArrayList<Object>>();
            for(int i=0; i<rowCount; i++){
                ArrayList subArrayList = new ArrayList();
                for(int j=0; j<1; j++){
                    subArrayList.add(i);
                    subArrayList.add(model2.getValueAt(i, 0));
                    tempArrayList.add(subArrayList);
                }
            }
            ArrayList<ArrayList<Object>> tempArrayList2 = new ArrayList<ArrayList<Object>>();
            for(int i=0; i<rowCount; i++){
                ArrayList subArrayList = new ArrayList();
                for(int j=0; j<1; j++){
                    subArrayList.add(i);
                    subArrayList.add(model2.getValueAt(i, 0));
                    tempArrayList2.add(subArrayList);
                }
            }
            
                tempArrayListFull.add(0, tempArrayList);
                tempArrayListFull.add(1, tempArrayList2);
                
            ArrayList <Object>boolArrayList = new <Object>ArrayList();
            for (int i=0; i<rowCount; i++){
                boolArrayList.add(model2.getValueAt(i, 0));
            }
            ArrayList <Object>boolArrayList2 = new <Object>ArrayList();
            for (int i=0; i<rowCount; i++){
                boolArrayList.add(model2.getValueAt(i, 0));
            }
             
            ArrayList<ArrayList<Object>> editArrayList = new ArrayList<ArrayList<Object>>();  
            ArrayList<ArrayList<Object>> editArrayList2 = new ArrayList<ArrayList<Object>>();
            for(int i=0; i<1; i++){
                editArrayList = tempArrayListFull.get(i);
                editArrayList2 = tempArrayListFull.get(i+1);
                for(int j=0; j<editArrayList.size(); j++){
                   ArrayList <Object>editList = new <Object>ArrayList();
                   ArrayList <Object>editList2 = new <Object>ArrayList();
                   editList = (ArrayList<Object>) editArrayList.get(j);
                   editList2 = (ArrayList<Object>) editArrayList2.get(j);
                    if(editList.get(1).equals(Boolean.TRUE) && editList2.get(1).equals(Boolean.TRUE) 
                       ){
                        editList.set(1, aVal);
                        editList2.set(1, aVal);
                        }else{
                        editList.set(1, aVal2);
                        editList2.set(1, aVal2);
                        }
                       }
                }
        ArrayList<ArrayList<Object>> InvertedArrayList = new ArrayList<ArrayList<Object>>();       
        InvertedArrayList = tempArrayListFull.get(0);
        for(int i=0; i<InvertedArrayList.size(); i++){
         ArrayList<Object> InvertedArraySubList = new ArrayList<Object>();
         InvertedArraySubList = InvertedArrayList.get(i);
         if(i<row) {
         model2.setValueAt(InvertedArraySubList.get(1), i,0);
         
         }else if(i>row ){
         model2.setValueAt(InvertedArraySubList.get(1), i,0);      
         }else if(i==row && i==i-rowCount){
             model2.setValueAt(InvertedArraySubList.get(1), i,0);
         }else if(i==row && i==i-1){
             model2.setValueAt(InvertedArraySubList.get(1), i,0);
         }
         
        }
            
           return model2.getValueAt(row,column);
            }
         
        
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) { 
  
        return true;           
        }      
};
        panel.add(table); 
       
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                LoopTest atcdcp2 = new LoopTest();
                atcdcp2.add(panel);
                frame.add(atcdcp2);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
               
                                
                frame.setBounds(1050, 350, 500, 400);
                
                 frame.pack();
               frame.setVisible(true);
                     
            }
        });
    }
}

    
    
    
    
    
    

    

