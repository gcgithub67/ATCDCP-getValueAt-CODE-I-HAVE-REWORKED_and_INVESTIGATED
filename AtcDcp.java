
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atcdcp;



import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.lang.Boolean.FALSE;
import java.util.ArrayList;

import java.util.Vector;
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
     * @param args the command line arguments
     */
    public class AtcDcp extends JPanel {
        
    public static JTable table;
    public static JPanel panel;
    public static JFrame frame;
   
    Object aVal =(Object)Boolean.FALSE;
    Object aVal2 =(Object)Boolean.TRUE;
    
    Object [][]array2;
  
    
    DefaultTableModel model2 = new  DefaultTableModel();
      
    ArrayList<ArrayList<ArrayList<Object>>> tempArrayListFull = new ArrayList<ArrayList<ArrayList<Object>>>();
    int rowCount=0;
    
    public AtcDcp() {
        super();
     
       panel = new JPanel();
       frame = new JFrame();
       
     array2 = new Object [][]{
                
                {Boolean.FALSE, 1, 2, 3, 4},
                {Boolean.FALSE, 2, 1, 3, 5},
                {Boolean.FALSE, 3, 2, 1, 6},
                {Boolean.TRUE, 3, 1, 2, 7},
                {Boolean.FALSE, 1, 2, 3, 8},
                {Boolean.TRUE, 2, 1, 3, 9},
                {Boolean.TRUE, 3, 2, 1, 10},
                {Boolean.FALSE, 3, 1, 2, 11},
                {Boolean.FALSE, 3, 1, 2, 12},
                
         };
     
     
        //VECTOR OF VECTORS            
            Vector<Vector<Object>> vlist =  new Vector<Vector<Object>>(); 
            for(int i=0;i<array2.length;i++){
                Vector tempVector = new Vector();
                for (int j=0; j<array2[j].length;j++){
                  tempVector.add(array2[i][j]);  
                }
                vlist.add(tempVector);
            }
   
            
            
     Vector columnName= new Vector();
     columnName.add("CheckBox");
     columnName.add("Value1");
     columnName.add("Value2");
     columnName.add("Value3");
     columnName.add("Value4");
      
    model2.setDataVector(vlist, columnName); 
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
                ArrayList <Object>subArrayList = new ArrayList<Object>();
                for(int j=0; j<1; j++){
                    subArrayList.add(i);
                    subArrayList.add(model2.getValueAt(i, 0));
                    tempArrayList.add(subArrayList);
                }
            }
            ArrayList<ArrayList<Object>> tempArrayList2 = new ArrayList<ArrayList<Object>>();
            for(int i=0; i<rowCount; i++){
                ArrayList <Object>subArrayList = new ArrayList<Object>();
                for(int j=0; j<1; j++){
                    subArrayList.add(i);
                    subArrayList.add(model2.getValueAt(i, 0));
                    tempArrayList2.add(subArrayList);
                }
            }
            
                tempArrayListFull.add(0, tempArrayList);
                tempArrayListFull.add(1, tempArrayList2);
                
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
                        editList2.set(1, aVal2);
                        }else{
                        editList.set(1, aVal2);
                        editList2.set(1, aVal);
                        }
                       }
                }
        ArrayList<ArrayList<Object>> InvertedArrayList = new ArrayList<ArrayList<Object>>();    
        ArrayList<ArrayList<Object>> InvertedArrayList2 = new ArrayList<ArrayList<Object>>();
        InvertedArrayList = tempArrayListFull.get(0);
        InvertedArrayList2 = tempArrayListFull.get(1);
        
        ArrayList<Object> ForEditingModelList = new ArrayList<Object>();
        ArrayList <Object>boolArrayListI = new <Object>ArrayList();
        ArrayList <Object>boolArrayListIEcho = new <Object>ArrayList();
        ArrayList <Object>boolArrayListIEchoM = new <Object>ArrayList();
        for(int i=0; i<rowCount; i++){
            ForEditingModelList.clear();
            ForEditingModelList = InvertedArrayList.get(i);
            Object boolValue=ForEditingModelList.get(1);
              boolArrayListI.add(boolValue); 
              boolArrayListIEcho.add(boolValue);
              boolArrayListIEchoM.add(boolValue);
              }
        
        ArrayList<Object> ForEditingModelList2 = new ArrayList<Object>();
        ArrayList <Object>boolArrayListE = new <Object>ArrayList();
        ArrayList <Object>boolArrayListEEcho = new <Object>ArrayList();
        ArrayList <Object>boolArrayListEEchoM = new <Object>ArrayList();
        
        for(int i=0; i<rowCount; i++){
            ForEditingModelList2.clear();
            ForEditingModelList2 = InvertedArrayList2.get(i);
            Object boolValue=ForEditingModelList2.get(1);
              boolArrayListE.add(boolValue); 
              boolArrayListEEcho.add(boolValue);
              boolArrayListEEchoM.add(boolValue);
              }
   
        for(int i = 0, j = boolArrayListIEchoM.size() - 1; i < j; i++) {
        boolArrayListIEchoM.add(i, boolArrayListIEchoM.remove(j));
    }
        for(int i = 0, j = boolArrayListEEchoM.size() - 1; i < j; i++) {
        boolArrayListEEchoM.add(i, boolArrayListEEchoM.remove(j));
    }
         
            int j=0;
            int i2=0;
            int j2=0;
            
            Object aValue2=(Object)aVal;
/******/for(int i =rowCount; i>0; i--){
            j=rowCount-i;
            
                     
           Object aValueExisted = boolArrayListE.get(i-1); 
           Object aValueInverted = boolArrayListI.get(i-1);
           Object aValueInvertedEchoBecomesExist = boolArrayListIEchoM.get(j); 
           Object aValueExistedEchoBecomesInvert = boolArrayListEEchoM.get(j);
            j2=i;
            i2=j;
           Object aValueExistedn = boolArrayListE.get(i2); 
           Object aValueInvertedn = boolArrayListI.get(i2);
           Object aValueInvertedEchoBecomesExistn = boolArrayListIEchoM.get(j2-1); 
           Object aValueExistedEchoBecomesInvertn = boolArrayListEEchoM.get(j2-1);
           
                //if not equal
            if( aValueExisted.equals(aValueInvertedEchoBecomesExist) &&            
                aValueInverted.equals(aValueExistedEchoBecomesInvert)&&
                aValueInvertedEchoBecomesExistn.equals(aValueExistedn)&&
                aValueExistedEchoBecomesInvertn.equals(aValueInvertedn) &&           
                
                aValueExistedEchoBecomesInvert.equals(aValueInverted)&&
                aValueInvertedEchoBecomesExist.equals(aValueExisted) &&           
                aValueInvertedn.equals(aValueExistedEchoBecomesInvertn) && 
                aValueExistedn.equals(aValueInvertedEchoBecomesExistn)&&
                    
                aValueExistedn.equals(aValueInvertedEchoBecomesExistn)&&
                aValueInvertedn.equals(aValueExistedEchoBecomesInvertn) &&           
                aValueInvertedEchoBecomesExist.equals(aValueExisted) && 
                aValueExistedEchoBecomesInvert.equals(aValueInverted)&&
                    
                aValueExistedEchoBecomesInvertn.equals(aValueInvertedn) &&            
                aValueInvertedEchoBecomesExistn.equals(aValueExistedn)&&
                aValueInverted.equals(aValueExistedEchoBecomesInvert)&&
                aValueExisted.equals(aValueInvertedEchoBecomesExist)&&
                /////// if equal   
                aValueExisted.equals(aValueExistedEchoBecomesInvert) &&            
                aValueInverted.equals(aValueInvertedEchoBecomesExist)&&
                aValueInvertedEchoBecomesExistn.equals(aValueInvertedn)&&
                aValueExistedEchoBecomesInvertn.equals(aValueExistedn) &&           
                
                aValueExistedEchoBecomesInvert.equals(aValueExisted)&&
                aValueInvertedEchoBecomesExist.equals(aValueInverted) &&           
                aValueInvertedn.equals(aValueInvertedEchoBecomesExistn) && 
                aValueExistedn.equals(aValueExistedEchoBecomesInvertn)&&
                    
                aValueExistedn.equals(aValueExistedEchoBecomesInvertn)&&
                aValueInvertedn.equals(aValueInvertedEchoBecomesExistn) &&           
                aValueInvertedEchoBecomesExist.equals(aValueInverted) && 
                aValueExistedEchoBecomesInvert.equals(aValueExisted)&&
                    
                aValueExistedEchoBecomesInvertn.equals(aValueExistedn) &&            
                aValueInvertedEchoBecomesExistn.equals(aValueInvertedn)&&
                aValueInverted.equals(aValueInvertedEchoBecomesExist)&&
                aValueExisted.equals(aValueExistedEchoBecomesInvert)    
                )
                      
                { 
                 // if not equal   
                 setValueAt(aValueInverted, i-1, 0);                       
                 setValueAt(aValueInvertedEchoBecomesExist, j, 0);                                         
                 setValueAt(aValueExistedEchoBecomesInvertn, j2-1, 0); 
                 setValueAt(aValueExistedn, i2, 0);
                               
                 setValueAt(aValueInvertedEchoBecomesExist, j, 0);
                 setValueAt(aValueInverted, i-1, 0);                                       
                 setValueAt(aValueExistedn, i2, 0);                         
                 setValueAt(aValueExistedEchoBecomesInvertn, j2-1, 0);
                 
                 setValueAt(aValueInvertedn, i2, 0);                       
                 setValueAt(aValueInvertedEchoBecomesExistn, j2-1, 0);                                         
                 setValueAt(aValueExistedEchoBecomesInvert, j, 0); 
                 setValueAt(aValueExisted, i-1, 0);
                               
                 setValueAt(aValueInvertedEchoBecomesExistn, j, 0);
                 setValueAt(aValueInvertedn, i2, 0);                                       
                 setValueAt(aValueExisted, i-1, 0);                         
                 setValueAt(aValueExistedEchoBecomesInvert, j, 0);
                 
                 ////////////if equal
                 
                 setValueAt(aValueInverted, i-1, 0);                       
                 setValueAt(aValueExistedEchoBecomesInvert, j, 0);                                         
                 setValueAt(aValueExistedEchoBecomesInvertn, j2-1, 0); 
                 setValueAt(aValueInvertedn, i2, 0);
                               
                 setValueAt(aValueInvertedEchoBecomesExist, j, 0);
                 setValueAt(aValueExisted, i-1, 0);                                       
                 setValueAt(aValueExistedn, i2, 0);                         
                 setValueAt(aValueInvertedEchoBecomesExistn, j2-1, 0);
                 
                 setValueAt(aValueInvertedn, i2, 0);                       
                 setValueAt(aValueExistedEchoBecomesInvertn, j2-1, 0);                                         
                 setValueAt(aValueExistedEchoBecomesInvert, j, 0); 
                 setValueAt(aValueInverted, i-1, 0);
                               
                 setValueAt(aValueInvertedEchoBecomesExistn, j, 0);
                 setValueAt(aValueExistedn, i2, 0);                                       
                 setValueAt(aValueExisted, i-1, 0);                         
                 setValueAt(aValueInvertedEchoBecomesExist, j2-1, 0);          
                
                 j++; 
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
                AtcDcp atcdcp2 = new AtcDcp();
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

    

