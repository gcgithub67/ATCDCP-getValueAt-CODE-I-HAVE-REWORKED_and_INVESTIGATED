
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
       DefaultTableModel model2 = new  DefaultTableModel();
        int rowCount=0;
     ArrayList<ArrayList<ArrayList<Object>>> tempArrayListFull = new ArrayList<ArrayList<ArrayList<Object>>>();
    
    
    public AtcDcp() {
     
       
    Object [][]array2;
          
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
            
     Vector <Object>columnName= new Vector<Object>();
     columnName.add("CheckBox");
     columnName.add("Value1");
     columnName.add("Value2");
     columnName.add("Value3");
     columnName.add("Value4");
     
     
     model2.setDataVector(vlist, columnName); 
     System.out.println(model2.getRowCount());
     rowCount=model2.getRowCount();
     
      ArrayList<ArrayList<Object>> tempArrayList = new ArrayList<ArrayList<Object>>();
            tempArrayList.clear();
                      
            for(int i=0; i<rowCount; i++){
                for(int j=0; j<1; j++){
                     ArrayList <Object>subArrayList = new ArrayList<Object>();
                     subArrayList.clear();
                     subArrayList.add(i);           
                     subArrayList.add(model2.getValueAt(i, 0)); 
                    tempArrayList.add(subArrayList);
                    }
                
                }
                        
            ArrayList<ArrayList<Object>> tempArrayList2 = new ArrayList<ArrayList<Object>>();
            tempArrayList2.clear();
            
            for(int i=0; i<rowCount; i++){
                for(int j=0; j<1; j++){
                    ArrayList <Object>subArrayList2 = new ArrayList<Object>();
                    subArrayList2.clear();
                    subArrayList2.add(i);
                    subArrayList2.add(model2.getValueAt(i, 0));
                    tempArrayList2.add(subArrayList2);
                }
            }
            
           
                tempArrayListFull.add(0, tempArrayList);  //Existed
                tempArrayListFull.add(1, tempArrayList2); //Existed Copy
                
                Object aVal =(Object)Boolean.FALSE;
                Object aVal2 =(Object)Boolean.TRUE;
                
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
                        editList.set(1, aVal2);
                        editList2.set(1, aVal);
                        }else{
                        editList.set(1, aVal);
                        editList2.set(1, aVal2);
                        }
                       }
                }

        ArrayList<ArrayList<Object>> ExistedArrayList = new ArrayList<ArrayList<Object>>();    
        ArrayList<ArrayList<Object>> InvertedArrayList = new ArrayList<ArrayList<Object>>();
        ExistedArrayList.clear();
        InvertedArrayList.clear();
        ExistedArrayList = tempArrayListFull.get(0);
        InvertedArrayList = tempArrayListFull.get(1);
        
        ArrayList<Object> ForEditingInvertedModelList = new ArrayList<Object>();
        ForEditingInvertedModelList.clear();
        ArrayList <Object>boolArrayListI = new <Object>ArrayList();
        boolArrayListI.clear();
        ArrayList <Object>boolArrayListIEcho = new <Object>ArrayList();
        boolArrayListIEcho.clear();
        ArrayList <Object>boolArrayListIEchoR = new <Object>ArrayList();
        boolArrayListIEchoR.clear();
       
        for(int i=0; i<rowCount; i++){
            
            ForEditingInvertedModelList = InvertedArrayList.get(i);
            Object boolValue=ForEditingInvertedModelList.get(1);
              boolArrayListI.add(boolValue); 
              boolArrayListIEcho.add(boolValue);
              boolArrayListIEchoR.add(boolValue);
              }
        
        ArrayList<Object> ForEditingExistedModelList = new ArrayList<Object>();
        ForEditingExistedModelList.clear();
        ArrayList <Object>boolArrayListE = new <Object>ArrayList();
        boolArrayListE.clear();
        ArrayList <Object>boolArrayListEEcho = new <Object>ArrayList();
        boolArrayListEEcho.clear();
        ArrayList <Object>boolArrayListEEchoR = new <Object>ArrayList();
        boolArrayListEEchoR.clear();
        
        for(int i=0; i<rowCount; i++){
            
            ForEditingExistedModelList = ExistedArrayList.get(i);
            Object boolValue=ForEditingExistedModelList.get(1);
              boolArrayListE.add(boolValue); 
              boolArrayListEEcho.add(boolValue);
              boolArrayListEEchoR.add(boolValue);
              }
   
        for(int i = 0, j = boolArrayListIEchoR.size() - 1; i < j; i++) { //Reversing Inverted_Echo
        boolArrayListIEchoR.add(i, boolArrayListIEchoR.remove(j));
    }
        for(int i = 0, j = boolArrayListEEchoR.size() - 1; i < j; i++) { //Reversing Existed_Echo
        boolArrayListEEchoR.add(i, boolArrayListEEchoR.remove(j));
    }    
     
     JTable table = new JTable();
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
            
            int j=0;
            int i2=0;
            int j2=0;
            Object aValue2=(Object)aVal;
/******/for(int i =rowCount; i>0; i--){
            j=rowCount-i;
                     
           Object aValueExisted = boolArrayListE.get(i-1); 
           Object aValueInverted = boolArrayListI.get(i-1); 
           Object aValueInvertedEchoBecomesExist = boolArrayListIEchoR.get(j); 
           Object aValueExistedEchoBecomesInvert = boolArrayListEEchoR.get(j); 
           
           j2=i;
           i2=j;
           
           Object aValueExistedn = boolArrayListE.get(i2); 
           Object aValueInvertedn = boolArrayListI.get(i2); 
           Object aValueInvertedEchoBecomesExistn = boolArrayListIEchoR.get(j2-1); 
           Object aValueExistedEchoBecomesInvertn = boolArrayListEEchoR.get(j2-1); 
        
          
           if(aValueExisted.equals(aValueExistedEchoBecomesInvert) &&            
                aValueInverted.equals(aValueInvertedEchoBecomesExist)&&
                aValueExistedEchoBecomesInvertn.equals(aValueExistedn)&&
                aValueInvertedEchoBecomesExistn.equals(aValueInvertedn) &&           
                
                 
                aValueExistedEchoBecomesInvert.equals(aValueExisted) &&           
                aValueInvertedEchoBecomesExist.equals(aValueInverted)&&  
                aValueExistedn.equals(aValueExistedEchoBecomesInvertn) && 
                aValueInvertedn.equals(aValueInvertedEchoBecomesExistn)
                )            
           
                {          
                 setValueAt(aValueInverted, i-1, 0);                       
                 setValueAt(aValueExistedEchoBecomesInvert, j, 0);                                         
                 setValueAt(aValueInvertedEchoBecomesExistn, j2-1, 0); 
                 setValueAt(aValueExistedn, i2, 0);
                    
                 setValueAt(aValueInvertedEchoBecomesExist, j, 0);                                       
                 setValueAt(aValueExisted, i-1, 0);                         
                 setValueAt(aValueInvertedn, i2, 0);                         
                 setValueAt(aValueExistedEchoBecomesInvertn, j2-1, 0); 
                                    
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
     JPanel panel = new JPanel();   
     panel.add(table); 
     JFrame frame = new JFrame();
     frame.add(panel);
     frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
     frame.setBounds(1050, 350, 500, 400);
     frame.pack();
     frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                 new AtcDcp();
                                  
            }
        });
    }
}

    

