package com.franck.Algorithms.sorting;

/**
 * Created by Franck on 2018/5/7.
 */
public class Quick {



    private static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo ,int hi){
        if(hi <= lo){
            return ;
        }

        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }


    private static int partition(Comparable[] a,int lo,int hi){

        int i = lo;
        int j = hi+1;

        Comparable v = a[lo];

        while(true){

            while( less(a[++i],v) ){
                if(i == hi)
                    break;
            }

            while(less(v,a[--j])){
                if(j == lo)
                    break;
            }

            if(i >= j)
                break;

            exch(a,i,j);

        }

        exch(a,lo,j);
        return j;
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

        Integer[] a = {4,1,7,9,10,2,5,11};
//        String[] a = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};
        sort(a);
        show(a);

//        Integer[] a = {4,3,1};

//        merge(a,0,1,1);


    }


}
