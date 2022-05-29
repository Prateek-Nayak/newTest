package com.company;
//consider integer primitive types assuming that autoboxing is not supported, call a method which accepts only objects as parameters and
// return value of the method is a primitive type
public class autoBoxing {
    public static void main(String[] args) {
        int i = 25;
        Integer I = new Integer(i);
        Integer autoSquare = autoSquare(I);
        System.out.println("With autoboxing: " + autoSquare);
        int square = square(I);
        System.out.println("Without autoboxing: " + square);

    }
    static Integer autoSquare(Integer I){
        int i1 = I.intValue();
        i1 = i1 * i1;
        Integer i2 = new Integer(i1);
        return i2;
    }
    static int square(Integer I){
        return I * I;
    }

}
