package com.franck.Algorithms.sorting;

/**
 * Created by Franck on 2018/4/23.
 */
public class Selection {

    //将数组 a 升序排序
    public static void sort(Comparable[] a){
        int N = a.length;

        for(int i=0;i<N;i++){

            int min = i;
            for(int j=i+1; j<N ; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a,min,i);

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

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(" "+ a[i]);
    }


    public static void main(String[] args) {

        String[] a = {"f","g","q","v","a","y"};
        sort(a);

        show(a);
    }
}
