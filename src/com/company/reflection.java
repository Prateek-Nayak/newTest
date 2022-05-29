//package com.company;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//
//@Retention(RetentionPolicy.RUNTIME)
//// reflection is the feature that enables information about a class to be obtained at run time.
//// the reflection API is contained in the java.lang.reflect
//// if the retention policy of RUNTIME, then they can be queried at run time by java program
//
//// Steps for using reflection
//// First step is to obtain a CLASS OBJECT that represents the class whose annotation you want to obtain. Class is one of Java's built-in classes and is defined
//// To obtain the annotations associated with a specific item declared within a class, you must first obtain object that represents that item.
//@interface Myanno1{
//    String st();
//    int i();
//}
//public class reflection {
//    @Myanno1(st="this is my custom annotation", i=25)
//    public static void meth(){
////        Anno obj = new Anno();
//        try{
//            System.out.println("Accessing annotation1");
//            Class c1 = obj.getClass();
//            Method m1 = c1.getMethod("meth");
//            Myanno1 annoobject = m1.getAnnotation(Myanno1);
//
//        }
//        catch(Exception e){
//
//        }
//    }
//}
