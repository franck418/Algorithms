package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

/**
 * Created by Franck on 2018/5/15.
 */
public class SortTest {

    Integer[] a = {3,4,7,9,10,2,5,11,3};
    String[] b = {"S","H","E","L","L","S","O","R","T","E","X","A","M","P","L","E"};

    @Test
    public void selectSortTest(){
        selectSort(a);
        show(a);
        Assert.assertTrue(isSorted(a));
    }


    @Test
    public void insertSortTest(){
        insertSort(a);
        show(a);
        Assert.assertTrue(isSorted(a));

    }

    @Test
    public void mergeSortTest(){
        mergeSort(a);
        show(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void quickSortTest(){
        quickSort(a);
        show(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void shellSortTest(){
        shellSort(a);
        show(a);
        Assert.assertTrue(isSorted(a));
    }

    @Test
    public void heapSortTest(){
        heapSort(a);
        show(a);
        Assert.assertTrue(isSorted(a));
    }


    /***
     * 最好 n^2
     * 最坏 n^2
     * 平均 n^2
     * 空间复杂度O(1)
     * 稳定
     */
    public void selectSort(Comparable[] a){
        int N = a.length ;
        for (int i = 0 ; i < N ; i++) {
            int min = i ;
            for (int j = i + 1; j < N ; j++) {
                if (less(a[j],a[min])) {
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }

    /***
     * 最好 n
     * 最坏 n^2
     * 平均 n^2
     * 空间复杂度O(1)
     * 稳定
     */
    public void insertSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1 ; i < N ; i++) {
            for (int j = i ; j > 0 && less(a[j],a[j-1]) ; j--) {
                exch(a,j,j-1);
            }
        }
    }

    /***
     * 不用的序列效率不同
     * 最好 NlogN
     * 最坏 N^6/5
     * 平均 nlogn ~ n^2
     * 空间复杂度O(1)
     * 不稳定
     */
    public static void shellSort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N / 3) { h = 3 * h + 1 ; }

        while (h >= 1) {

            for (int i = h ; i < N ; i++) {
                for (int j = i ; j >=h && less(a[j],a[j-h]) ; j -= h) {
                    exch(a,j,j - h);
                }
            }
            h = h / 3;
        }



    }

    /***
     * 快排
     * 最好
     * 最坏
     * 平均 NlogN
     * 空间复杂度logN
     * 不稳定
     */
    public void quickSort(Comparable[] a){
        quickSort(a,0,a.length-1);
    }

    private void quickSort(Comparable[] a,int lo ,int hi) {
        if (lo >= hi ) {return;}

        int j = parition(a,lo,hi);

        quickSort(a,lo,j - 1);
        quickSort(a,j + 1 , hi);
    }

    private int parition(Comparable[] a, int lo , int hi) {

        int i = lo , j = hi + 1;

        Comparable v = a[lo];

        while (true) {

            while (less(a[++i],v)) {
                if (i >= hi) {break; }
            }

            while (less(v,a[--j])) {
                if (j <= lo) {break;}
            }

            if (i >= j) {
                break;
            }
            exch(a,i,j);

        }
        exch(a,lo,j);
        return j;
    }











    /***
     * 下沉式堆排
     * 最好
     * 最坏
     * 平均 NlogN
     * 空间复杂度 1
     * 不稳定
     */

    public void heapSort(Comparable[] a){
        int N = a.length - 1;
        a[0]  = 0;

        for (int i = N / 2; i >= 1 ; i--) {
            sink(a,i,N);
        }

        while (N > 1) {
            exch(a,1,N--);
            sink(a,1,N);
        }

    }

    private void sink(Comparable[] a, int i ,int len) {

        while (2 * i <= len) {
            int j = 2 * i ;

            if (j < len && less(a[j],a[j+1])) {
                j++;
            }

            if (less(a[j],a[i])) {
                break;
            }

            exch(a,i,j);

            i = j;
        }

    }







    /***
     *  归并排序
     *  最好
     *  最坏
     *  平均NlogN
     *  空间复杂度 N
     *  稳定
     */
    public void mergeSort(Comparable[] a) {
        mergeSort(a,0,a.length - 1);
    }

    private void mergeSort(Comparable[] a, int lo , int hi) {

        if (lo >= hi) {return; }

        int mid = lo + (hi - lo) / 2;

        mergeSort(a,lo,mid);
        mergeSort(a,mid+1,hi);

        merge(a,lo,mid,hi);
    }

    Comparable[] aux = new Comparable[a.length];
    private void merge(Comparable[] a, int lo , int mid , int hi) {

        int i = lo ,j = mid + 1;

        for (int k = lo ; k <= hi ; k++) {
            aux[k] = a[k];
        }

        for (int k = lo ; k <= hi ; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j],aux[i])) {
                a[k] = aux [j++];
            } else {
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

}
