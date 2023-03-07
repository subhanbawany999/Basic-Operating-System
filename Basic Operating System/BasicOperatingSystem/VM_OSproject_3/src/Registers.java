
import java.util.HashMap;
import java.util.*;

public class Registers {
    static short[] GPR= new short[16];
    static short[] SPR= new short[16];
    static BitSet FlagRegister = new BitSet(16); 
    
//        public Registers(){
//        /*for(int i=0; i<15; i++){
//            GPR[i]= ;
//        }*/
//        //GPR[0]= 1;
//        //GPR[1]= 3;
//        SPR[0] = 50; // Index of memory from where we want to load code
//        //SPR[0]= Memory.memory[50]; //CodeBase Initialized
//        SPR[2]=SPR[0]; //CodeCOunter initialized to CodeBase
//        //SPR[8]=Memory.memory[50]; //PC pointing to CodeBase
//        SPR[8]=SPR[0]; //PC pointing to CodeBase
//        // Initializing all General Purpose Registers to null
// 
// 
//        Registers.FlagRegister.set(0, false);
//        Registers.FlagRegister.set(1, false);
//        Registers.FlagRegister.set(2, false);
//        Registers.FlagRegister.set(3, false);
//        Registers.FlagRegister.set(4, false);
//        Registers.FlagRegister.set(5, false);
//        Registers.FlagRegister.set(6, false);
//        Registers.FlagRegister.set(7, false);
//        Registers.FlagRegister.set(8, false);
//        Registers.FlagRegister.set(9, false);
//        Registers.FlagRegister.set(10, false);
//        Registers.FlagRegister.set(11, false);
//        Registers.FlagRegister.set(12, false);
//        Registers.FlagRegister.set(13, false);
//        Registers.FlagRegister.set(14, false);
//        Registers.FlagRegister.set(15, false);      
//    }
    
    public static void RegistersInitialize(){
        /*for(int i=0; i<15; i++){
            GPR[i]= ;
        }*/
        //GPR[0]= 1;
        //GPR[1]= 3;
        SPR[0] = 50; // Index of memory from where we want to load code
        //SPR[0]= Memory.memory[50]; //CodeBase Initialized
        SPR[2]=SPR[0]; //CodeCOunter initialized to CodeBase
        //SPR[8]=Memory.memory[50]; //PC pointing to CodeBase
        SPR[8]=SPR[0]; //PC pointing to CodeBase
        // Initializing all General Purpose Registers to null
 
 
        Registers.FlagRegister.set(0, false);
        Registers.FlagRegister.set(1, false);
        Registers.FlagRegister.set(2, false);
        Registers.FlagRegister.set(3, false);
        Registers.FlagRegister.set(4, false);
        Registers.FlagRegister.set(5, false);
        Registers.FlagRegister.set(6, false);
        Registers.FlagRegister.set(7, false);
        Registers.FlagRegister.set(8, false);
        Registers.FlagRegister.set(9, false);
        Registers.FlagRegister.set(10, false);
        Registers.FlagRegister.set(11, false);
        Registers.FlagRegister.set(12, false);
        Registers.FlagRegister.set(13, false);
        Registers.FlagRegister.set(14, false);
        Registers.FlagRegister.set(15, false);      
    }
}
    

    
