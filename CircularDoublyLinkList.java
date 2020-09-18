/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularDoublyLinkList;

import java.util.*; 
   
public class CircularDoublyLinkList{  
    static Node head; 
    static subNode midhead;
    static subNode last;
    // Doubly linked list node definition
    static class Node{  
        int data; //to be removed
        
        Node next;
        Node prev;
        subNode subnode;
       
        
    };  
    
    static class subNode{  
        int data2; 
        subNode nextS;
        subNode prevS;  
    };  
   // Function to insert node in the list 
    static void addNode(int value) {  
        // List is empty so create a single node furst 
        if (head == null) {  
            Node new_node = new Node();  
            new_node.data = value;  
            new_node.next = new_node.prev = new_node;  
            head = new_node;  
            return;  
        }  
   
        // find last node in the list if list is not empty
          Node last = (head).prev;    //previous of head is the last node
   
        // create a new node  
        Node new_node = new Node();  
        new_node.data = value;  
   
        // next of new_node will point to head since list is circular  
        new_node.next = head;  
   
        // similarly previous of head will be new_node
        (head).prev = new_node;  
   
        // change new_node=>prev to last  
        new_node.prev = last;  
   
        // Make new node next of old last  
        last.next = new_node;  
    }  
    
    static void addSubNode( int value2) {
         if (midhead == null){
      subNode new_node2 = new subNode();
      new_node2.data2 = value2;  
      new_node2.prevS=new_node2.nextS=new_node2;
      midhead=new_node2;
          return;
         }
         // find last node in the list if list is not empty
          last = midhead.prevS;    //previous of head is the last node
   
        // create a new node  
        subNode new_node3 = new subNode();  
        new_node3.data2 = value2;  
   
        // next of new_node will point to head since list is circular  
        new_node3.nextS = midhead;  
   
        // similarly previous of head will be new_node
        midhead.prevS = new_node3;  
   
        // change new_node=>prev to last  
        new_node3.prevS = last;  
   
        // Make new node next of old last  
        last.nextS = new_node3;   
         
    }
   
static void printNodes()   {  
        Node temp = head;  
        subNode subtemp = midhead;
        //traverse in forward direction starting from head to print the list
        while (temp.next != head)  
        {  
            System.out.printf("%d ", temp.data);  
            temp = temp.next;  
        
        
           while (subtemp.nextS != midhead)  
        {  
            System.out.printf("%d ", subtemp.data2);  
            subtemp = subtemp.nextS; 
            if(subtemp.nextS == last){
            System.out.printf("%d ", subtemp.data2); 
            }
        } 
           
        }    
        System.out.printf("%d ", temp.data); 
        
        
          
        //traverse in forward direction starting from head to print the list
        
   
        //traverse in backward direction starting from last node 
        System.out.printf("\nCircular doubly linked list travesed backward: \n");  
        Node last = head.prev;  
        temp = last;  
        while (temp.prev != last)  
        {  
            System.out.printf("%d ", temp.data);  
            temp = temp.prev;  
        }  
        System.out.printf("%d ", temp.data);  
    }  
   
    public static void main(String[] args)  
    {  
        //the empty list 
        //Node l_list = null;  
   
        // add nodes to the list  
        addNode(40);  
        addNode(50);  
        addNode(60);  
        addNode(70);  
        addNode(80); 
        
        addSubNode(30);  
        addSubNode(300);  
        addSubNode(3000);  
        addSubNode(30000);  
        addSubNode(300000);
   
        //print the list
        System.out.printf("Circular doubly linked list: ");  
        printNodes();  
    }  
}  


