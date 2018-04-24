package com.franck.Algorithms.sorting;

/**
 * Created by Franck on 2018/4/24.
 * 插入排序算法
 */
public class Insertion {

    //将数组 a 升序排序
    public static void sort(Comparable[] a){
        int N = a.length;

        for(int i=1;i<N;i++){
            for(int j=i; j>0 && less(a[j],a[j-1]); j--){
                exch(a,j,j-1);
            }

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

        /*String[] a = {"f","g","q","v","a","y"};*/
        Integer[] a = {3,4,7,9,10,2,5,11};
        sort(a);
        show(a);
    }
}
