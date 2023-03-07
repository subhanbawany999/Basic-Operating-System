/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaffar Abbas
 */
public class Scheduler {
    priorityQueue readyQueue1 = new priorityQueue(); // ready queue level 1
    Queue readyQueue2 = new Queue(); // ready queue level 2
    Queue runningQueue = new Queue(); // running queue
    PCB process = new PCB();
    Node head;
    
    
//    public void priorityScheduler(Queue readyQueue1){
//        if(process.p_pri)
//    }
    

    public void dispatacher(){ // Maybe this whole method needs to be placed where we are loading process. Ask Subhan and Sherry
        if(process.p_priority>=0 && process.p_priority<=15){
            readyQueue1.enqueue(process);
        }
        else if(process.p_priority>=16 && process.p_priority<=31){
            readyQueue2.enqueue(process);
        }
        else{
            System.out.println("Invalid Priority");
        }
        //RoundRobin(readyQueue2);
    }
}
