package com.franck.Algorithms.sorting;

/**
 * Created by Franck on 2018/5/4.
 *
 * 归并排序实现代码
 */
public class HeapSort {




    public static void sort(Comparable[] a){

        int N = a.length-1;
        for (int k = N/2 ; k >= 1;k--)
            sink(a,k,N);

        while (N>1){
            exch(a,1,N--);
            sink(a,1,N);
        }


    }





    public static void sink(Comparable[] a, int k, int N){

        while ( 2 * k <= N){

            int j = 2 * k ;
            if( j< N && less(a[j],a[j+1])) j++;
            if( (!less(a[k],a[j]))) break;

            exch(a,k,j);
            k = j;

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

        Integer[] a = {0,4,1,7,9,10,2,5,11,99,-2};
//        String[] a = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};
        sort(a);
        show(a);

//        Integer[] a = {4,3,1};

//        merge(a,0,1,1);


    }

}
