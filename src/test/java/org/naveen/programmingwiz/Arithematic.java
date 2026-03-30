package org.naveen.programmingwiz;

import java.util.Random;

public class Arithematic {

    public static void main(String[] args) {

//        division();
//        swap(new Random().nextInt(100,34325),new Random().nextInt(200,634821));
//unary();
        arraysWithIncrements();
    }

    private static void arraysWithIncrements() {

        int[] num=new int[]{1,2,3,4,5,6};

        for(int i=0;i<num.length;i++){
            System.out.print(i);;
            System.out.print(num[i]);
            System.out.print("\t");;
        }

        System.out.print("\n");

        for(int i=0;i<num.length;++i){
            System.out.print(i);;
            System.out.print(num[i]);
            System.out.print("\t");;
        }
    }

    public static void division(){
        Random random = new Random();
        int a=random.nextInt(0,100000);
        int b= random.nextInt(0,a-1000);
        double q=(double)a/b;
        int remainder=a%b;
        System.out.printf("The result of "+a+" divided by "+b+" is %.2f",q);
        System.out.println("");
        System.out.printf("The remainder of %d when divided by %d is %d",a,b,remainder);
    }
    public static void swap(int a, int b){
        int c=a,d=b;
        c=c+d;
        d=c-d;//a+b-b
        c=c-d;//

        System.out.println("Given Numbers "+a+" and "+b+" after swapping is "+c+" and "+d);



    }

    public static void unary(){
        int a=new Random().nextInt();
        System.out.println(a);
        int b=a++;
        System.out.println(b);
        int c=++a;
        System.out.println(c);
    }
}
