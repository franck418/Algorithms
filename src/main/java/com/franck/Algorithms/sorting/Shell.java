package com.franck.Algorithms.sorting;

/**
 * Created by Franck on 2018/4/25.
 * 希尔排序实现算法
 * 希尔排序是基于选择排序的
 *
 */
public class Shell {


    public static void sort(Comparable[] a){

        int N = a.length;
        int h = 1;

        while(h<N/3){
            h = 3 * h + 1;
        }

        while (h >= 1){

            for(int i=h; i < N ; i++){
                for(int j = i; j>= h ; j-=h){
                    if( less(a[j],a[j-h]) ){
                        exch(a,j,j-h);
                    }
                }

            }
            h = h/3;
        }
    }



    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){

        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private static boolean isSorted(Comparable[] a){

        for(int i=0;i<a.length;i++){

            if(less(a[i+1],a[i]))
                return false;
        }
        return true;
    }

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(" "+ a[i]);

        System.out.println();
    }

    public static void main(String[] args) {

//        Integer[] a = {3,4,7,9,10,2,5,11};
        String[] a = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};
        sort(a);
        show(a);

    }


}
