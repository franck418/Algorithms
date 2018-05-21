package com.franck.Algorithms.sorting;

/**
 * Created by Franck on 2018/5/4.
 *
 * 归并排序实现代码
 */
public class Merge {


    private static Comparable[] aux;//需要一个辅助的数组


    public static void sort(Comparable[] a){

        aux = new Comparable[a.length];

        sort(a,0,a.length-1);


    }

    //将数组a[lo...hi]排序
    public static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo){
            return ;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a,lo,mid);//将左半边排序
        sort(a,mid+1,hi);//将右半边排序

        merge(a,lo,mid,hi);
    }



    public static void merge(Comparable[] a, int lo ,int mid , int hi){

        int i = lo;
        int j = mid + 1 ;

        aux = aux == null ? new Comparable[a.length] : aux;

        for(int k=lo; k <= hi; k++){
            aux[k] = a[k];
        }

        for(int k = lo ; k<= hi ; k++){

            if(i > mid){
                a[k] = aux[j++];

            }else if( j > hi ){
                a[k] = aux[i++];

            }else if( less(aux[j],aux[i]) ){
                a[k] = aux[j++];

            }else{
                a[k] = aux[i++];
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

    private static boolean isSorted(Comparable[] a){

        for(int i=0;i<a.length-1;i++){

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
