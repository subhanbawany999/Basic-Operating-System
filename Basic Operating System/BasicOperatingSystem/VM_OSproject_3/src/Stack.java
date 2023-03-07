/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jaffar Abbas
 */
public class Stack {
    byte[][] stackList;
    int top;

    Stack() {
        stackList = new byte[50][2];
        top = -1;
    }

    public void Push(byte MSB, byte LSB) throws Exception {
        if (!isFull()) {
            top++;
            stackList[top][0] = MSB;
            stackList[top][1] = LSB;
        } else {
            //System.exit(0);
            throw new Exception("Stack overflow");
        }
    }

    public short ByteToShort(byte MSB, byte LSB) {
        //short value = (short) ((byte) ((MSB << 8) & 0xFF) + (byte) (LSB));
        short value1 = (short) (Byte.toUnsignedInt(MSB) << 8);
        short value = (short) (value1 + Byte.toUnsignedInt(LSB));
        return value;
    }

    public short Pop() throws Exception {

        if (!isEmpty()) {
            top--;
            return ByteToShort(stackList[top + 1][0], stackList[top + 1][1]);
        } else {
            //System.exit(0);
            //return 0;
            throw new Exception("Stack underflow");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stackList.length - 1;
    }
    }
