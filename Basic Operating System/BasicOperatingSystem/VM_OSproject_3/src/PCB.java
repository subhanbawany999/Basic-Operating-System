
import java.nio.file.Path;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User 1
 */
public class PCB {

    short p_id;
    byte p_priority;
    int p_size_c;
    short p_size_d;
    byte p_size_s = 50;
    String p_file_name;
    Registers reg = new Registers();
    PageTable datapt;
    PageTable codept;
    // hussain
    priorityQueue readyQueue1 = new priorityQueue(); 
    Queue readyQueue2 = new Queue();
    PCB pcb;
    int current_pc; // current pc


    PCB() { //constructor
        reg.RegistersInitialize();
        current_pc = 0;

        if (p_priority >= 0 && p_priority <= 15) {
            readyQueue1.enqueue(pcb);

        } else if (p_priority >= 16 && p_priority <= 31) {
            readyQueue2.enqueue(pcb);
        } else {
            System.out.println("Invalid Priority");
        }
    }
    //Shehry and Subhan priority error

    void priority_check(byte priority) {
        if (priority < 0 || priority > 31) {
            System.out.println("Invalid Priority");
        }
    }

    int get_pc() { //getter for current pc
        return current_pc;
    }

    void set_pc(int count) {//setter for current count
        current_pc = count;
    }

    int getp_id() //getter for pid
    {
        return p_id;
    }

    byte getp_priority() //getter for priority
    {
        return p_priority;
    }

    byte[] get_code_array(byte[] array) {
//          for(int i=0; i<array.length;i++){
//              System.out.println("Code Array: "+array[i]);
//          }
        return array;
    }

    void set_code_array(byte[] array) {
        p_code = Arrays.copyOf(array, array.length);
    }

    void setp_id(short pi) //setter for pid
    {
        p_id = pi;
    }

    void setp_priority(byte pri) //setter for priority
    {
        p_priority = pri;
    }

    void setpsizec(int szc) //setterprocess code size
    {
        p_size_c = szc;
    }

    void setp_size_d(short szd) // setter for data size
    {
        p_size_d = szd;
    }

    String getp_file_name() //getter for file name
    {
        return p_file_name;
    }

    void setpfilename(String pp) //setter for filename
    {
        p_file_name = pp;
    }

    int getcodesize() {
        return p_size_c;
    } //getter for code size

    short getdatasize() {
        return p_size_d;
    } //getter for data size

    PCB(byte priority, byte id, String filename, byte sized, byte sizec) { //constructor
        p_id = id;
        p_priority = priority;
        p_file_name = filename;
        p_size_c = sizec;
        p_size_d = sized;

    }
    byte[] p_code; // code_array

    void set_cpt_size(int c_page_no) { //setter for code page table
        codept = new PageTable(c_page_no);
    }

    void set_dpt_size(int d_page_no) { //setter for code page table
        datapt = new PageTable(d_page_no);
    }

    int get_cpt_size() { //setter for code page table
        // codept = new PageTable(c_page_no);
        return codept.size;
    }

//      void set_dpt_size(int d_page_no){ //setter for code page table
//      datapt = new PageTable(d_page_no);
//      }
    void set_cpt(int frameno, int pageno) { //setter for code page table
        codept.setf(frameno, pageno);
    }

    void set_dpt(int frameno, int pageno) { //setter for data page table
        datapt.setf(frameno, pageno);
    }

    int get_cpt(int pageno) { //getter for code page table
        return codept.getf(pageno);
    }

    int get_dpt(int pageno) { //getter for data page table
        return datapt.getf(pageno);
    }

    void printt() { //print data & code page table
        datapt.print_table();
        System.out.println("     ");
        codept.print_table();
    }

}
