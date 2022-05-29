package com.company;

public class boxing {
    public static void main(String[] args) {
        //The process of encapsulating the value is called as boxing.
        //Type wrappers are classes that encapsulate the primitive type within an object.
        //The process of extracting the primitive type is called as unboxing. it can be done using value().
        //The primitive type can be extracted from a wrapper type using xvalue() method.
        //Autoboxing/unboxing takes place with methods parameters and return values.
        //It is not advisable unless it is essential to use autoboxing and unboxing feature due to the complexity involved in converting each primitive type to object and object back to the primitive type.
        //Autoboxing

        int in = 10;
        float flc = 10.25f;
        double dou = 11.55;
        char ch = 'a';

        Integer i = new Integer(in);
        Integer i1 = new Integer("25");

        System.out.println("Value of in: " + in);
        System.out.println("Value of i using constructor: " + i);
        System.out.println("Value of i1 using constructor with string: " + i1);

        Float f = new Float(flc);
        Float f1 = new Float("55.35f");
        System.out.println("Value of flc: " + flc);
        System.out.println("Value of f using constructor: " + f);
        System.out.println("Value of f1 using constructor with string: " + f1);







    }
}
