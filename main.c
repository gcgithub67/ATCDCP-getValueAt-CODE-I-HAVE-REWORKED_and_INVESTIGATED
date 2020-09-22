

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int info;
} DATA;

typedef struct Node{
    DATA data;
    struct Node *prev;
    struct Node *next;
    struct subNode *subnode;
    
}NODE;

typedef struct subNode{
    DATA dataS;
    struct subNode *prevS;
    struct subNode *nextS;
    struct subNode *verticalPrev;
    struct subNode *verticalNext;
    struct subsubNode *subsubnode;
 }NodeInner;
 
 typedef struct subsubNode{
    DATA dataSS;
    struct subsubNode *prevSS;
    struct subsubNode *nextSS;
    struct subsubNode *verticalPrevS;
    struct subsubNode *verticalNextS; 
 }NodeSubInner;
 

 
 insert(NODE *pointer, DATA data) {
    NODE *start = pointer;
    NODE *save = pointer;
    /*Iterate through the list till we encounter the last node.*/
    while (pointer->next != start) {
        save = pointer;
        pointer = pointer -> next;
        
    }
    /* Allocate memory for the new node and put data in it.*/
    pointer->next = (NODE *) malloc(sizeof (NODE));
    pointer = pointer->next;
    pointer->data = data;
    pointer->next = start;
    pointer->prev = save;
   
}
 
 NODE* find(NODE *pointer, DATA key) {
    NODE *start = pointer;
    pointer = pointer -> next; //First node is dummy node.
    /*Iterate through the entire linked list and search for the key. */
    while (pointer != start) {
        if (pointer->data.info == key.info) { //key is found.
            return pointer;
            //return 1;
        }
        pointer = pointer -> next; //Search in the next node.
    }
    return NULL; /*Key is not found */
}
 
 void insertsubNode( NodeInner *pointer, DATA data) {
   NodeInner *start = pointer;
    NodeInner *save = pointer;
    /*Iterate through the list till we encounter the last node.*/
    while (pointer->nextS != start) {
        save = pointer;
        pointer = pointer -> nextS;
        
    }
    /* Allocate memory for the new node and put data in it.*/
    pointer->nextS = (NodeInner *) malloc(sizeof (NodeInner));
    pointer = pointer->nextS;
    pointer->dataS = data;
    pointer->nextS = start;
    pointer->prevS = save;
      
}
 
 void insertsubsubNode(NodeSubInner *pointer, DATA data) {
 NodeSubInner *start = pointer;
    NodeSubInner *save = pointer;
    /*Iterate through the list till we encounter the last node.*/
    while (pointer->nextSS != start) {
        save = pointer;
        pointer = pointer -> nextSS;
        
    }
    /* Allocate memory for the new node and put data in it.*/
    pointer->nextSS = (NodeSubInner *) malloc(sizeof (NodeSubInner));
    pointer = pointer->nextSS;
    pointer->dataSS = data;
    pointer->nextSS = start;
    pointer->prevSS = save;
  
}

 void delete(NODE *pointer, DATA data) {
    NODE *temp;
    NODE *start = pointer;
    /*Go to the node for which the node next to it has to be deleted */
    while (pointer->next != start &&
            (pointer->next)->data.info != data.info) {
        pointer = pointer -> next;
    }
    if (pointer->next == start) {
        printf("Element %d is not present in the list\n", data.info);
        return;
    }
    /* Now pointer points to a node and the node next to it has to be removed */
    temp = pointer -> next;
    /*temp points to the node which has to be removed*/
    pointer->next = temp->next;
    temp->prev = pointer;
    /*We removed the node which is next to the pointer (which is also temp) */
    free(temp);
    /* Beacuse we deleted the node, we no longer require the memory used for it .  free() will deallocate the memory.*/
    return;
}
 
 void print(NODE *start, NODE *pointer) {
    if (pointer == start) {
        return;
    }
    printf("\n%d ", pointer->data.info);
    print(start , pointer->next);
}



//int main(int argc, char** argv) {
    
    int main() {
    int i, j, k, status;
    DATA data;
    /* start always points to the first node of the linked list.
     * temp is used to point to the last node of the linked list.*/
    NODE *start, *temp;
    start = (NODE *) malloc(sizeof (NODE));
    temp = start;
    temp -> next = start;
    /* Here in this code, we take the first node as a dummy node.
     * The first node does not contain data, but it used because to avoid 
     * handling special cases in insert and delete functions.*/
    NodeInner *innerstart, *innertemp;
    innerstart = (NodeInner *) malloc(sizeof (NodeInner));
    innertemp = innerstart;
    innertemp->nextS = innertemp;
    
    NodeSubInner *subinnerstart, *subinnertemp;
    subinnerstart = (NodeSubInner *) malloc(sizeof (NodeSubInner));
    subinnertemp = subinnerstart;
    subinnertemp->nextSS = subinnertemp;
      
    for (i = 0; i < 16; i++) {  //Add
        data.info = i;
        insert(start, data);
        for (j = 0; j < 16; j++) {  //Add
        data.info = j;
        insertsubNode(innerstart, data);
        for (k = 0; k < 17; k++) {  //Add
        data.info = k;
        insertsubsubNode(subinnerstart, data);
        
    }
        }
    }
   
    
    
    
    
    
    
    do {
        printf("What would you like to do ?\n");
        printf("\t1 - Delete a node\n");
        printf("\t2 - Print the list\n");
        printf("\t3 - Search in the list\n");
        printf("\t4 - Quit\n");
        scanf("%d", &i);
        switch (i) {
            case 1: // DELETE
                printf("\nEnter data to delete:\n");
                scanf("%d", &data.info);
                delete(start, data);
                break;
            case 2: //print
                printf("The list is ");
                print(start, start->next);
                printf("\n");
                break;
            case 3: //find
                printf("\nEnter data to find:\n");
                scanf("%d", &data.info);
               // status = find(start, data);
                if (status) {
                    printf("Element Found\n");
                } else {
                    printf("Element Not Found\n");
                }
        }
    } while (i < 4);

    return EXIT_SUCCESS;
}


//    return (EXIT_SUCCESS);
//}

