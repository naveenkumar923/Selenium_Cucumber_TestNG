package org.naveen;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String b="hello World!Today is a good day";
        HashMap<Character,Integer> map = new HashMap<>();
//        Set<Character> indChar=new HashSet<>();
//        for(int i=0;i<b.length();i++){
//            indChar.add(b.charAt(i));
//        }
//        Iterator iterator = indChar.iterator();
//        for(Character c:indChar){
//            System.out.println(iterator.next());
//        }

        for(Character c:b.toCharArray()){

                map.put(c,map.getOrDefault(c,0)+1);



        }


     Set<Map.Entry<Character,Integer>> entrySet=map.entrySet();
        Object[] entries=entrySet.toArray();

       StringBuilder s=new StringBuilder();
       String ns="Today is a sunday!";

       for(int i=0;i<ns.length();i++){
           s.append(ns.charAt(i));
       }
       Set fruit=new HashSet();
       Set fruits=map.entrySet();

//       System.out.println(fruits.toArray()[2]);


        for(int i=0;i<entries.length;i++){
            System.out.println(entries[i]+"\t"+entries[i].getClass().getName());

        }





    }
}
