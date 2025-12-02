package com.boobCoder.blog.javaPracticeCode;

public class GenericsPractice<T> {
    public void printType(String s){
        System.out.println(s.getClass().getName() + " : " + s);
    }

    public <T> void printGenericType(T obj){
        System.out.println(obj.getClass().getName() + " : " + obj);
    }

    <T> T returnSame(T obj){
        return obj;
    }

    static <T> String getName(T obj){
        return obj.getClass().getName();
    }

    public static void main(String[] args) {
        GenericsPractice gp = new GenericsPractice();
//        gp.printType("Hello");
//
//        gp.printGenericType("Hello");
//        gp.printGenericType(5);
//        gp.printGenericType(5.01);
//
//        System.out.println(gp.returnSame("World"));
//        System.out.println(gp.returnSame(10));

        System.out.println(gp.getName("Hooo hooo"));
        if(gp.getName(2.25).equals("java.lang.Double")){
            System.out.println("Yes it is double");
        }
    }
}
