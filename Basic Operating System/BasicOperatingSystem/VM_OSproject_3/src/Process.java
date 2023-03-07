//
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
public class Process
{
   //  Memory mem1; // SHARED MEMORY BY STATIC MEMORY DATA MEMBERS
   int codeSize=1;             // Every time MEMORY new object is declared so it will use share Memory
    PCB pcb;
    static int p=0;
    
//    priorityQueue readyQueue1 = new priorityQueue(); // ready queue level 1
//    Queue readyQueue2 = new Queue(); // ready queue level 2
    Queue runningQueue = new Queue(); // running queue
    public byte[] code_array;
    byte code[];
    byte data[];

Process() { //constructor
   pcb = new PCB();
  // mem1 = new Memory();
}

    void LoadProcess(String filename) throws Exception { //process file is loaded
    
    pcb.setpfilename(filename);
 

     File file = new File(filename);
     FileInputStream fis = new FileInputStream(file);
     System.out.println("reading process file");
     
     
     pcb.p_priority =(byte) fis.read(); //priority is read
     
     
     byte Fbyte = (byte) fis.read();  // 1st byte of process id is read
     byte Sbyte = (byte) fis.read(); // 2nd byte of process id is read
     pcb.setp_id(Concatenate(Fbyte,Sbyte));
     
     System.out.println("Process ID: "+pcb.p_id+"\n Priority: "+pcb.p_priority);
     
     Fbyte = (byte) fis.read();  // 1st byte of data size is read
     Sbyte = (byte) fis.read(); // 2nd byte of data size is read
     pcb.setp_size_d(Concatenate(Fbyte,Sbyte));
    
    //ignoring bytes     
     for(int i=1 ; i<=3;i++)
     {
         fis.read();
     }
     
      //array for code bytes
     data = new byte[pcb.getdatasize()]; //array for data bytes


     for(int j = 0;j< pcb.getdatasize() ; j++) { //data bytes are read
//         data[i+1] = (byte) fis.read();
         data[j] = (byte) fis.read();
//         i++;
        }
//     for(int i = 0;i< pcb.getcodesize() ; i++) { //code bytes are read
//         code[i] = (byte) fis.read();
//        }
    
     while((fis.read())!=-1)
     {
         codeSize++;
     }
     pcb.setpsizec(codeSize);
     code = new byte[pcb.getcodesize()];
     FileInputStream fis1 = new FileInputStream(filename);					
     ByteBuffer bytes = ByteBuffer.allocateDirect(codeSize);
     fis.getChannel().position((byte)(8+pcb.getdatasize()));
        for (int i = 0; i < pcb.getcodesize(); i++) {
            code[i] = (byte) fis.read();
            //System.out.println(code[i]);
        }
        pcb.set_code_array(code);
      //pcb.p_code=Arrays.copyOf(code, code.length);
//        for (int i = 0; i<codeSize; i++){
//            System.out.println(pcb.p_code[i]);
//        }
        pcb.get_code_array(pcb.p_code);
   // code_array = Arrays.copyOf(code, code.length); // JA
     
     //loaded
     
     // Paged Segmentation is done Here
//     int no_of_code_pages = pcb.getcodesize() / 128;
//     int no_of_data_pages = pcb.getdatasize() / 128;
//     int temp = no_of_code_pages;
//     byte pagechunk[] = new byte[128];
//     int i;
//     int curpageno=0;
//     pcb.set_cpt_size(no_of_code_pages);// setting code page table size with number of code pages of a process
//     
//     
//     // Entering Code
//     while(temp > 0) {
//        for(i=0; ((128 * curpageno) + i) < pcb.getcodesize() && i<128 ; i++){
//            pagechunk[i] = code[i +(128 * curpageno)];
//
//         }
//      int frame = mem1.cload(pagechunk, 128);
//      pcb.codept.setf(frame, curpageno);
//      ++curpageno;
//      temp--;
//      }
//
//     //Entering Data
//     temp= no_of_data_pages;
//     pcb.set_dpt_size(no_of_data_pages);// setting data page table size with number of data pages of a process
//       i=0;
//       curpageno=0;
//     while(temp > 0) {
//        for(i=0;(i +(128 * curpageno)) < pcb.getdatasize() && i<128 ; i++){
//            pagechunk[i] = data[i +(128 * curpageno)];
//         }
//      int frame = mem1.cload(pagechunk, 128);
//      pcb.datapt.setf(frame, curpageno);
//      curpageno++;
//      temp--;
//      }
//       code = null;
//       data = null;
// System.out.println("read!!");
//        //pcb.set_cpt(curpageno, curpageno);
 // Processes being assigned to Ready Queues on the basis of priority
 
 //TEMPORAY CHANGE OF PRIORITY QUEUE 12/25/2021
//        if(pcb.p_priority>=0 && pcb.p_priority<=15){
//            readyQueue1.enqueue(pcb);
//            
//        }
//        else if(pcb.p_priority>=16 && pcb.p_priority<=31){
//            readyQueue2.enqueue(pcb);
//        }
//        else{
//            System.out.println("Invalid Priority");
//        }
//
}
            // Method to print the LinkedList.
    public void printPriorityQueue(priorityQueue list)
    {
        Node currNode = list.head;
    
        System.out.print("Priority Queue: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
    
            // Go to next node
            currNode = currNode.next;
        }
    }
            // Method to print the LinkedList.
    public void printQueue(Queue list)
    {
        Node currNode = list.head;
    
        System.out.print("Ready Queue Level 2: ");
    
        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
    
            // Go to next node
            currNode = currNode.next;
        }
    }

  byte getFbyte(short value) { //get first 8 bytes of short value
    byte temp = (byte)(value >> 8);
    return temp;
}

byte getSbyte(short value) { //get last 8 bytes of short value
    byte temp = (byte) value;
    return temp;
}


public short Concatenate(byte Fbyte,byte Sbyte)
     { //concat two bytes into short
        short temp = (short) (Fbyte * 256);
        temp = (short) (temp + Sbyte);
        return temp;
     }
}