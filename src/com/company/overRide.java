package com.company;
//java enables us to embed supplemental information into the source file. This information is called as annotation.
//It doesn't change the action of the program. this information can be used by various tools during both development and deployment
//Built-in annotations
// @Override: It assures that the subclass method is overriding the method that belong to the parent class.
// @SuppressWarnings:
// @Deprecated: Marks that this method is deprecated, so the compiler prints warning.
//              It informs user that it may be removed in the future versions so it is better not to use such methods.

//Built-in java annotation that can be applied on other annotations
// @Target
// @Retention
// @Inherited
// @Documented:
// By default annotations are inherited. To make an annotation inherited @Inherited can be used
//Retention policy: It determines at what point an annotation is discarded. Java defines three such situations i.e. CLASS, SOURCE and RUNTIME. The default policy is CLASS.
// Annotations consists of only method declaration but method body will not be defined. Java implements the methods.
//All annotations automatically extends annotation interface, hence an annotation cannot use an extends clause.
//


class polygon {
    int length = 10;
    void area(){
        System.out.println("Area of polygon: ");
    }
}
class square extends polygon{

    int breadth = 25;
    void area(){
        System.out.println("Area of square: " + length * breadth);
    }
}
public class overRide{
    public static void main(String[] args) {
        polygon p1 = new polygon();
        p1.area();
        square p2 = new square();
        p2.area();
    }
}