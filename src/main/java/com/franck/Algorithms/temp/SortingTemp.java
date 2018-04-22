package com.franck.Algorithms.temp;

/**
 * Created by GlacialDrift on 2017/7/24.
 *
 * 排序算法的模板
 */
public class SortingTemp {

    private void sort(Comparable[] a){

        for(int i=0;i<a.length;i++){

            int MIN=i;
            for(int j=i+1;j<a.length;j++){

                if(less(a[j],a[MIN]))
                    MIN=j;

            }

            exch(a,MIN,i);

        }


    }


    private boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private void exch(Comparable[] a,int i,int j){

        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }

    private boolean isSorted(Comparable[] a){

        for(int i=0;i<a.length;i++){

            if(less(a[i+1],a[i]))
                return false;


        }
        return true;
    }

    private void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(" "+ i);
    }


    public static void main(String[] args) {




    }

}
