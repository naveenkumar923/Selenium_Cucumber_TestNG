package org.naveen;

public class StringManip {
    public static void main(String[] args) {
        String s="naveen munaganuri";

        String[] arr=s.split(" ");
//        arr[0]=arr[0].substring(0).toUpperCase();

        for(String string:arr){
            char upperChar=Character.toUpperCase(s.charAt(0));
          s=s.substring(1);
        }

        for(int i=0;i<arr.length;i++){
            char u=Character.toUpperCase(arr[i].charAt(0));
            arr[i]=u+arr[i].substring(1);
        }


       System.out.println(arr[0]+" "+arr[1]);

    }

}
