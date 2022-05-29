package com.company;
enum Season { WINTER, SPRING, SUMMER, FALL } ;
class EnumExample1{
    public static void main(String[] args) {
        for (Season s : Season.values())
            System.out.println(s);
        Season s = Season.valueOf("WINTER");
        System.out.println("S contains " + s);
    }
}