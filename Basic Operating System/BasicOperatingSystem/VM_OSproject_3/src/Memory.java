
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Memory {
    static byte[] memory= new byte[64000];
    ALU alu = new ALU();
    CU cu = new CU();
    Stack stack = new Stack();
    //static priorityQueue pq = new priorityQueue(); extra priority queue
    //Process process = new Process();
   //Process process;
    PageTable free_page_table = new PageTable(64); 
    
    public Memory(){
        
        //Registers mem_reg = new Registers(); JA
        Registers.RegistersInitialize();
//        process = this.process;
    }
    String hex_num;
    short remainder;
   public String DecimalToHex(short num){
       hex_num = "";
       char[] hex_char = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
       while(num>0){
           remainder = (short)(num % 16);
           hex_num = hex_char[remainder]+hex_num;
           num = (short)(num / 16);
       }
       return hex_num;
   }
    
    public void Read(PCB process1){
      //byte[] byte_instr = {(byte) 48, (byte) 2, (byte) 0, (byte) 3 , (byte) 48, (byte) 1, (byte) 0,(byte) 3, (byte) 48, (byte) 3, (byte) 0, (byte) 3, (byte) 27, (byte) 2, (byte) 1, (byte) 2};
      //byte[] byte_instr = {(byte)48, (byte)1, (byte)0, (byte)1, (byte)48, (byte)2, (byte)127, (byte)255, (byte)25,(byte)1, (byte)2, (byte) 243};
      //byte[] byte_instr = Arrays.copyOf(process.code_array, process.code_array.length);
        int i=50;
        System.out.println("Process Priority: "+process1.p_priority);
        System.out.println("Process Priority: "+process1.getp_priority());//p
        
       // process.get_code_array(process.p_code);
        System.out.println(process1.p_code[3]);
      for(int j =0;j< process1.getcodesize();j++){
          
          memory[i]=process1.p_code[j]; //p
          //System.out.println("byte array");
          //System.out.println(process1.p_code[j]); //p
          //System.out.println("memory");
          //System.out.println(memory[j+50]);
          Registers.SPR[2]=(short)i; //Code Counter getting incremented
          i++;
          
      }
        System.out.println("Process ID: "+process1.p_id+" is executed successfully");
    }
    public void cases(String execution){
    switch (execution) {
    case "16":
        cu.MOV(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "17":
        System.out.println("I reached Add");
        alu.ADD(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "18":
        alu.SUB(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "19":
        alu.MUL(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "1A":
        alu.DIV(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "1B":
        alu.AND(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "1C":
        alu.OR(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "30":
        cu.MOVI(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3])); //value = when PC reads immediate instruction,
        //it will ignore next index'value and read the other two index's value because those values will be used for MOVI instruction.
        break;
    case "31":
        cu.ADDI(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        break;
    case "32":
        cu.SUBI(Registers.SPR[8]+1, memory[Registers.SPR[8]+2]+memory[Registers.SPR[8]+3]);
        break;
    case "33":
        cu.MULI(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        break;
    case "34":
        cu.DIVI(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        break;
    case "35":
        cu.ANDI(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        break;
    case "36":
        cu.ORI(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        break;
    case "37":
        alu.BZ((short)(memory[Registers.SPR[8]+1]));
        break;
    case "38":
        alu.BNZ((short)(memory[Registers.SPR[8]+1]+memory[Registers.SPR[8]+2]));
        break;
    case "39":
        alu.BC((short)(memory[Registers.SPR[8]+1]+memory[Registers.SPR[8]+2]));
        break;
    case "3A":
        alu.BS((short)(memory[Registers.SPR[8]+1]+memory[Registers.SPR[8]+2]));
        break;
    case "3B":
        alu.JMP((short)(memory[Registers.SPR[8]+1]));
        break;
    case "3C":
    {
        try {
            cu.CALL(memory[Registers.SPR[8]], memory[Registers.SPR[8]+1]);
        } catch (Exception ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    case "51":
        //System.out.println("I reached Move");
        alu.MOVL(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        //Registers.SPR[8]+=4; 
        //System.out.println("Executed Move and PC = "+Registers.SPR[8]);
        break;
    case "52":
        alu.MOVS(memory[Registers.SPR[8]+1], (memory[Registers.SPR[8]+2]<<8) + (memory[Registers.SPR[8]+3]));
        break;
    case "71":
        alu.SHL(memory[Registers.SPR[8]+1]);
        break;
    case "72":
        alu.SHR(memory[Registers.SPR[8]+1]);
        break;
    case "73":
        alu.RTL(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "74":
        alu.RTR(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        break;
    case "75":
        alu.INC(memory[Registers.SPR[8]+1]);
        break;
    case "76":
        alu.DEC(memory[Registers.SPR[8]+1]);
        break;
    case "77":
        //alu.DEC(memory[Registers.SPR[8]+1]);
        System.out.println("PUSH");
    {
        try {
            cu.PUSH(memory[Registers.SPR[8]+1],memory[Registers.SPR[8]+2]);
        } catch (Exception ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        break;
    case "78":
        //alu.DEC(memory[Registers.SPR[8]+1]);
        System.out.println("POP");
    {
        try {
            cu.POP(memory[Registers.SPR[8]+1], memory[Registers.SPR[8]+2]);
        } catch (Exception ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        break;
    case "F1":
    {
        try {
            cu.RETURN();
        } catch (Exception ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        break;
    case "F2":
        cu.NOOP();
        break;
    case "F3":
        cu.END();
        break;
    default:
        System.out.println("Invalid Opcode error");//sherry and subhan opcode error check
        cu.END();
        //System.exit("Exit due to error");
        break;
    }
    
    
    }
    
    // Segmentation
    
//    int cload(byte carray[], int csize ){ //load code into memory
//
//    int i = search();
//
//    if(i == -1) { System.out.println("Memory full");}
//    else
//    {
//       // System.out.prinln
//        free_page_table.setf(1, i);
//        int j=0;
//    for(j= 0; j<csize ; j++) {
//       // System.out.println("i :" + i);
//        int memind =  i*128+j;
//        memory[ memind ] = carray[j];
//       // System.out.println("mem2[" + memind + "] = " + carray[j]);
//      }
//    }
//    return i;
//}
//    
//    int search() { //chk for empty frames in memory
//    int i=0;
//    for(i=0;(free_page_table.getf(i) == 1) && (i< free_page_table.size) ; i++);
//     if(free_page_table.getf(i) == 0)
//         return i;
//     else return -1;
// }
    byte getFbyte(short value) { //get first 8 bytes of short value
    byte temp = (byte)(value >> 8);
    return temp;
}

byte getSbyte(short value) { //get last 8 bytes of short value
    byte temp = (byte) value;
    return temp;
}

short Concatenate(byte Fbyte,byte Sbyte) {  //concat two bytes into short
    short temp = (short) (Fbyte * 256);
    temp = (short) (temp + Sbyte);
    return temp;
}
    }

//memtable is changed to free_page_table