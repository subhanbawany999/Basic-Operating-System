import java.util.*;
public class ALU {
    //Runner run = new Runner();
    //Registers reg= new Registers();
    //Register-Register Instructions:
    //Opcode 17 - ADD Instruction

    public void ADD(int index, int index1){
        //PC value is  pointing index of memory whose value is the register that will be used
        /*short a= Memory.memory[index]; 
        short b= Memory.memory[index1];
                */
        //Registers.GPR[index]=(short)(Registers.GPR[index]+Registers.GPR[index1]);
        int temp= (Registers.GPR[index]+Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void SUB(int index, int index1){
       // Registers.GPR[index]=(short)(Registers.GPR[index]-Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        
        int temp= (Registers.GPR[index]-Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
        //19773
        //overflow bit
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void MUL(int index, int index1){
        //Registers.GPR[index]=(short)((short)Registers.GPR[index]*(short)Registers.GPR[index1]);
        int temp= Registers.GPR[index]*(short)Registers.GPR[index1];
        Registers.GPR[index]=(short)(temp);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//            System.out.println("OF");
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void DIV(int index, int index1){
        //Registers.GPR[index]=(short)(Registers.GPR[index]/Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        //19773
        //sherry and subhan divided by zero error check
        if(Registers.GPR[index1] == 0) {
            System.out.println("Denominator is zero");
        }
        int temp= (Registers.GPR[index]/Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
        //overflow bit
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void AND(int index, int index1){
        //index = (short)index + (short) 1;
        //String up_key= reg.RegisterCases(reg.GPR.get(index));
        //String up_key1= reg.RegisterCases(index1);
        //reg.GPR.get(index) = reg.GPR.get(index) + reg.GPR.get(index1);
        //reg.GPR.put(index, (short)(reg.GPR.get(index) + reg.GPR.get(index1)));
        //reg.GPR[reg.GPR_Ref.get(index)]=(short)(reg.GPR[reg.GPR_Ref.get(index)]+reg.GPR[reg.GPR_Ref.get(index1)]);
                    
                   // int value1 = Byte.toUnsignedInt(reg.GPR[index]);
                    //int value2 = Byte.toUnsignedInt(reg.GPR[index1));
        //Registers.GPR[index] = (short) (Registers.GPR[index] & Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        
        int temp= (Registers.GPR[index] & Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
        //19773
        //overflow bit
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void OR(int index, int index1){
        //Registers.GPR[index] = (short) (Registers.GPR[index] | Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        //19773
        
        int temp= (Registers.GPR[index] | Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
        //overflow bit
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    // Single-Operand Instructions:
    public void INC(int index){
       // Registers.GPR[index] = (short) (Registers.GPR[index] + 1);
        Registers.SPR[8]+=2; // Incrementing PC to point to next instruction
        //19773
        
        int temp= (Registers.GPR[index]+1);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
        //overflow bit
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void DEC(int index){
        //Registers.GPR[index] = (short) (Registers.GPR[index] - 1);
        Registers.SPR[8]+=2; // Incrementing PC to point to next instruction
        //19773
        
        int temp= (Registers.GPR[index]- 1);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
        Registers.GPR[index]=(short)(temp);
        //19773
        //overflow bit
        if (temp >= 32768 || temp <= -32768) {
            Registers.FlagRegister.set(3, true);
            System.out.println("OF");
        }
        //overflow bit
//        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
//            Registers.FlagRegister.set(3, true);
//        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void SHL(int index){
        boolean test = carryFinder((short) index);
        Registers.GPR[index] = (short)(Registers.GPR[index]<<1);
        Registers.SPR[8]+=2; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //carry bit
        if (test == true) {
            Registers.FlagRegister.set(0, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void SHR(int index){
        boolean test = carryFinder((short) index);
        Registers.GPR[index] = (short)(Registers.GPR[index]>>1);
        Registers.SPR[8]+=2; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //carry bit
        if (test == true) {
            Registers.FlagRegister.set(0, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void RTL(int index, int value){
        boolean test = carryFinder((short) index);
        Registers.GPR[index] = (short)(Registers.GPR[index]<<value);
        Registers.SPR[8]+=2; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //carry bit
        if (test == true) {
            Registers.FlagRegister.set(0, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void RTR(int index, int value){
        boolean test = carryFinder((short) index);
        Registers.GPR[index] = (short)(Registers.GPR[index]>>value);
        Registers.SPR[8]+=2; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //carry bit
        if (test == true) {
            Registers.FlagRegister.set(0, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    
    //Branch If zero
    public void BZ(int num) {
        if(Registers.FlagRegister.get(1) == true){
            JMP((short)num);
        }
        else {
            Registers.SPR[8] = (short) (Registers.SPR[8]+ 2);
        }
    }
    
    //Branch if not equal to zero
    public void BNZ(int num) {
        if(Registers.FlagRegister.get(1) == false){
            JMP((short)num);
        }
        else {
            Registers.SPR[8] = (short) (Registers.SPR[8]+ 2);
        }
    }
    
    //Branch if carry - Implement Carry
    public void BC(int num) {
        if(Registers.FlagRegister.get(0) == true){
            JMP((short)num);
        }
        else {
            Registers.SPR[8] = (short) (Registers.SPR[8]+ 2);
        }
    }
    
    //Branch if sign
    public void BS(int num) {
        if(Registers.FlagRegister.get(2) == true){
            JMP((short)num);
        }
        else {
            Registers.SPR[8] = (short) (Registers.SPR[8]+ 2);
        }
    }
    
    //Register-Immediate Instructions
    public void JMP(short offset){
        if (Registers.SPR[8]+ offset > Registers.SPR[2]) {
            System.out.println("Jumping outside the allocated space");// Sherry anD Subhan Jump error 
        }
        Registers.SPR[8] = (short) (Memory.memory[Registers.SPR[8]]+ offset);
        System.out.println("Test"); // Error araha hai dekhlo isay!
        //Registers.SPR[8]+=offset; // Incrementing PC to point to next instruction
    }
    //Memory Instructions:
    public void MOVL(int index, int offset){
        //byte mem_loc = Memory.memory[offset];
        Registers.GPR[index] = (short)(offset);
        System.out.println("Register Value: "+Registers.GPR[index]);
        System.out.println("Hum yahan hain!");
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //run.Fetch();
    }
    public void MOVS(int index, int offset){
        Memory.memory[offset] = (byte)Registers.GPR[index];
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
    }
    
    public static boolean carryFinder(short num){
        String bin = Integer.toBinaryString(0x10000 | num).substring(1);
        if(bin.charAt(0) == 49){
            return true;
        }
        else{
            return false;       
        }
    } 
}
