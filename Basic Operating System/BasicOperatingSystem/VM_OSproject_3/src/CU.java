 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CU {
    ALU alu;
    Stack stack;
    //Register-Register Instruction:
    public void MOV(int index, int index1){
        Registers.GPR[index]=(short)(Registers.GPR[index1]);
        Registers.SPR[8]+=3; // Incrementing PC to point to next instruction
    }
    //Register-Immediate Instructions:
    public void MOVI(int index, int value){
       // reg.GPR[index]=(short)(value);
        //reg.SPR[8]+=4; // Incrementing PC to point to next instruction
        /*Registers.GPR[index]=(short)(Registers.GPR[index] << 8) ;
        Registers.GPR[index]=(short)(Registers.GPR[index] & value);*/
        Registers.GPR[index] = (short) value;
        Registers.SPR[8] += 4;   
    }
    public void ADDI(int index, int value){
        Registers.GPR[index]=(short)(Registers.GPR[index]+ value);
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void SUBI(int index, int value){
        Registers.GPR[index]=(short)(Registers.GPR[index]- value);
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void MULI(int index, int value){
        Registers.GPR[index]=(short)(Registers.GPR[index]* value);
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void DIVI(int index, int value){
        Registers.GPR[index]=(short)(Registers.GPR[index]/value);
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void ANDI(int index, int value){
        Registers.GPR[index] = (short) (Registers.GPR[index] & (short)Memory.memory[value]);
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void ORI(int index, int value){
        Registers.GPR[index] = (short) (Registers.GPR[index] | (short)value);
        Registers.SPR[8]+=4; // Incrementing PC to point to next instruction
        //19773
        //overflow bit
        if (Registers.GPR[index] >= 32768 || Registers.GPR[index] <= -32768) {
            Registers.FlagRegister.set(3, true);
        }
        //zero bit
        if (Registers.GPR[index] == 0) {
            Registers.FlagRegister.set(1, true);
        }
        //sign bit
         if (Registers.GPR[index] < 0) {
            Registers.FlagRegister.set(2, true);
        }
    }
    public void NOOP(){
        Registers.SPR[8] = (short) (Registers.SPR[8]+ 1 );
        System.out.println("NO OPERATION!");
        Registers.SPR[8]+=1; // Incrementing PC to point to next instruction
    }
    public void END(){
        Registers.SPR[8] = Registers.SPR[2];
        
        System.out.println("End");
        //PC does not need to be updated here
        
    }
    // HUSSAIN 
    public void CALL (byte r1, byte r2) throws Exception {
        stack.Push(r1, r2);
        short codeBase = this.ByteToShort(r1, r2);
        short PC = (short) (codeBase + 8);
//        Registers.SPR[9][1] = (byte) (PC & 0xFF);
//        Registers.SPR[9][0] = (byte) ((PC >> 8) & 0xFF);
        alu.JMP((short)8);
    }
    
    public void PUSH (int index, int index1) throws Exception {
        stack.Push((byte)Registers.GPR[index], (byte)Registers.GPR[index1]);
    }
    
    public void POP (int index, int index1) throws Exception {
        short value = stack.Pop();
        Registers.GPR[index] = (byte) (value & 0xFF);
        Registers.GPR[index1] = (byte) ((value >> 8) & 0xFF);
    }
    
    public void RETURN() throws Exception{
        stack.Pop();
    }
    public short ByteToShort(byte MSB, byte LSB) {
        //short value = (short) ((byte) ((MSB << 8) & 0xFF) + (byte) (LSB));
        short value1 = (short) (Byte.toUnsignedInt(MSB) << 8);
        short value = (short) (value1 + Byte.toUnsignedInt(LSB));
        return value;
    }
}
