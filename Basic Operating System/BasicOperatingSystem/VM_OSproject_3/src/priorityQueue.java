/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaffar Abbas
 */
public class priorityQueue {
    Node head;
    public void enqueue(PCB process) {
        if (head == null || head.data.p_priority > process.p_priority) {
            Node temp = new Node(process);
            temp.next = head;
            head = temp;
        } 
        else{
            Node present = head;
            Node temp = new Node(process);
                while(present.next != null && present.next.data.p_priority < temp.data.p_priority){
                    present = present.next;
                }
                temp.next = present.next;
                present.next = temp;
        }
    
}
    public PCB dequeue(){
        if (head == null) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            return temp.data;
        }
    }

//    static void queueDisplay()   
//    {   
//        int i;   
//        if (front == rear) {   
//            System.out.printf("Queue is Empty\n");   
//            return;   
//        }     
//        // traverse front to rear and print elements   
//        for (i = front; i < rear; i++) {   
//            System.out.printf(" %d , ", queue[i]);   
//        }   
//        return;   
//    }
}

