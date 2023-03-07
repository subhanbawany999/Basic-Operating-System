
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Muhammad Jaffar Abbas - 19666
 * Syed Hussain Imam - 19773
 * Subhan Bawany - 19686
 * Shaheryar Raza - 19681
 */
public class Runner {
    
    Process process = new Process();
    PCB pcb;
    
    Memory obj = new Memory();
 // static priorityQueue readyQueue1 = new priorityQueue(); // ready queue level 1
//    Queue readyQueue2 = new Queue(); // ready queue level 2
//    Queue runningQueue = new Queue(); // running queue
   // PCB process = new PCB();
    Node head;
    
    public void Fetch(){
            //obj.Read();
        try {
            process.LoadProcess("E:\\IBA\\Operating System\\VM_OSproject_3 - jaffar\\VM_OSproject_3\\src\\p5");
            System.out.println("Process Loaded");
            
        } catch (Exception ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            process.LoadProcess("E:\\IBA\\Operating System\\VM_OSproject_3 - jaffar\\VM_OSproject_3\\src\\sfull");
            System.out.println("Process Loaded");
        } catch (Exception ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            process.LoadProcess("E:\\IBA\\Operating System\\VM_OSproject_3 - jaffar\\VM_OSproject_3\\src\\power");
            System.out.println("Process Loaded");
        } catch (Exception ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            process.LoadProcess("E:\\IBA\\Operating System\\VM_OSproject_3 - jaffar\\VM_OSproject_3\\src\\noop");
            System.out.println("Process Loaded");
        } catch (Exception ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            process.LoadProcess("E:\\IBA\\Operating System\\VM_OSproject_3 - jaffar\\VM_OSproject_3\\src\\large0");
            System.out.println("Process Loaded");
        } catch (Exception ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            process.LoadProcess("E:\\IBA\\Operating System\\VM_OSproject_3 - jaffar\\VM_OSproject_3\\src\\flags");
            System.out.println("Process Loaded");
        } catch (Exception ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Initial Process in Priority Queue: ");
        process.printPriorityQueue(pcb.readyQueue1);
        System.out.println();
//        System.out.println("Initial Process in Normal Queue: "); // Implementing Round Robin Here
//        process.printQueue(process.readyQueue2);
//        while(process.readyQueue1!=null){
        obj.Read(pcb.readyQueue1.dequeue());
        //obj.Read(process.readyQueue1);
        
        //obj.Read(process);
        do {
            String execution = null;
            if(Memory.memory[Registers.SPR[8]]<0){
                Registers.SPR[9] = (short)(Memory.memory[Registers.SPR[8]] & 0xff);
            }
            else{
            Registers.SPR[9]= Memory.memory[Registers.SPR[8]]; // IR being assigned the value of memory at which PC is pointing
                //System.out.println("IR: "+Registers.SPR[9]);
                //System.out.println("PC: "+Registers.SPR[8]);
            }
            obj.cases(obj.DecimalToHex(Registers.SPR[9]));
            //System.out.println("PC: "+Registers.SPR[8]);
            //System.out.println("CC: "+Registers.SPR[2]);
            //Registers.SPR[8]+=3;
        }
            while(Registers.SPR[8]<Registers.SPR[2]);//Due to this condition the code outside allocated space will not be accessed (shehry subhan)
            //Instruction Register pointing to Program Counter
            if(pcb.readyQueue1 != null){
                process.printPriorityQueue(pcb.readyQueue1);
                //Printing Processes in Ready Queue 1 - Priorirty Queue
            }
            else {
                System.out.println("PRIORITY QUEUE IS NULL");
            }
            process.printQueue(process.pcb.readyQueue2);
        
        System.out.println("*******************");
        System.out.println("Round Robin's Magic starts here: ");
        System.out.println("Initial Process in Normal Queue: "); // Implementing Round Robin Here
        process.printQueue(process.pcb.readyQueue2);
        while(process.pcb.readyQueue2!=null){
        obj.Read(process.pcb.readyQueue2.dequeue());
            do {
            String execution = null;
            if(Memory.memory[Registers.SPR[8]]<0){
                Registers.SPR[9] = (short)(Memory.memory[Registers.SPR[8]] & 0xff);
            }
            else{
            Registers.SPR[9]= Memory.memory[Registers.SPR[8]]; // IR being assigned the value of memory at which PC is pointing
                //System.out.println("IR: "+Registers.SPR[9]);
                //System.out.println("PC: "+Registers.SPR[8]);
            }
            obj.cases(obj.DecimalToHex(Registers.SPR[9]));
            //System.out.println("PC: "+Registers.SPR[8]);
            //System.out.println("CC: "+Registers.SPR[2]);
            //Registers.SPR[8]+=3;
            
        }
            while(Registers.SPR[8]<Registers.SPR[2]);//Due to this condition the code outside allocated space will not be accessed (shehry subhan)
            //Instruction Register pointing to Program Counter
            //process.printPriorityQueue(process.readyQueue1);
            process.printQueue(process.pcb.readyQueue2); // Printing processes in Ready Queue 2 - Normal Queue 
        }
    }

    public static void main(String[] args) throws IOException{
        Runner run = new Runner();
        run.Fetch();



//        System.out.println("Memory");
//        for (int i = 0; i < 201; i++) {
//            System.out.print(Memory.memory[i]+" ");
//        }
//        System.out.println("");
//        System.out.println("GPR");
//        System.out.print("[");
//        for(int i=0; i<16; i++){
//            System.out.print(""+Registers.GPR[i]+",");
//        }
//        System.out.print("]");
//        System.out.println();
//        
//        System.out.println("SPR");
//        System.out.print("[");
//        for(int i=0; i<16; i++){
//            System.out.print(Registers.SPR[i]+" ");
//        }
//        System.out.print("]");
//        System.out.println();
//        System.out.println("Flag Register's High Bit Index: "+Registers.FlagRegister);
//        //System.out.println(Registers.FlagRegister);
//        System.out.println("Code Counter: "+Registers.SPR[2]);
//        System.out.println("Program Counter: "+Registers.SPR[8]);
//        System.out.println("Instruction Register: "+Registers.SPR[9]);
//        
//        int val = 50000;
//        String bin = Integer.toBinaryString(0x10000 | val).substring(1);
//        System.out.println(bin);
//        System.out.println(ALU.carryFinder((short) val));   
    }
}
