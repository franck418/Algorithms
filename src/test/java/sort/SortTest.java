package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Franck on 2018/5/15.
 */
public class SortTest {

    Integer[] a = {3,4,7,9,10,2,5,11,3,45,652,-1,-50};
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
    }



    /***
     * 最好 n
     * 最坏 n^2
     * 平均 n^2
     * 空间复杂度O(1)
     * 稳定
     */
    public void insertSort(Comparable[] a) {

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
