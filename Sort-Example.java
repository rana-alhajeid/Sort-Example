//


import java.util.*;
/* this class implementation two sorting algorithim 
1.quickSort
2. mergeSort */
public class SortExample 
{
 public static void main(String[] args) 
 {
 // This is unsorted array
 int[] array1 = { 12, 13, 24, 10, 3, 6, 90, 70 };
 int[] array2 = { 2, 6, 3, 5, 1 };
 // Let's sort using quick sort
 quickSort( array1 , 0 , array1.length - 1 );
 // Verify sorted array
 System.out.println("Quick Sort Result : "+ Arrays.toString(array1));
 mergeSort(array2 , 0 , array2.length - 1 );
 // Verify sorted array
 System.out.println(" Merge Sort Result : " Arrays.toString(array2));
 //verify that arrays are sorted 
 System.out.println("array1 is sorted ? "+ isSorted(array1));
  System.out.println("array2 is sorted ? "+ isSorted(array2));

 }
 /* quickSort algorithim method 
  arr : array sorted 
  low start index 
  high end index */

 public static void quickSort(int[] arr, int low, int high) 
 {
 //check for empty or null array
 if (arr == null || arr.length == 0){
 return;
 }
 if (low >= high){
 return;
 }
 //Get the pivot element from the middle of the list
 int middle = low + (high - low) / 2;
 int pivot = arr[middle];
 // make left < pivot and right > pivot
 int i = low, j = high;
 while (i <= j) 
 {
 //Check until all values on left side array are lower than pivot
 while (arr[i] < pivot) 
 {
    i++;
 }
 //Check until all values on left side array are greater than pivot
 while (arr[j] > pivot) 
 {
    j--;
 }
 //Now compare values from both side of lists to see if they need swapping 
 //After swapping move the iterator on both lists
 if (i <= j) 
   {
     swap (arr, i, j);
     i++;
     j--;
   }
 }
 //Do same operation as above recursively to sort two sub arrays
 if (low < j){
 quickSort(arr, low, j);
 }
 if (high > i)
    {
     quickSort(arr, i, high);

    }
 }
 /*arr : array to swap
 i: index  first element 
 j : index  second element */
 public static void swap (int arr[], int i, int j)
 {
 int temp = arr[i];
 arr[i] = arr[j];
 arr[j] = temp;
 }
 //mergeSort algorithim method
 

public static void mergeSort(int[] arr, int length) {
 if (length < 2) {
 return;
 }
 //find middle point of array 
 int mid = length / 2;
 //create two arrays of two half 
 int[] l = new int[mid]; //l : left subarray
 int[] r = new int[length - mid];// r: right subarray
 for (int i = 0; i < mid; i++) {
 l[i] = arr[i];
 }
 for (int i = mid; i < length; i++) {
 r[i - mid] = arr[i];
 }
 mergeSort(l, mid);
 mergeSort(r, length - mid);
 merge(arr, l, r, mid, length - mid);
}// merge from both array l , r 
public static void merge(
 int[] arr, int[] l, int[] r, int left, int right) //left :left length of left subarray ,right :right length of right subarray
 {
 int i = 0, j = 0, k = 0;
 // compare element subarrayand merge 
 while (i < left && j < right) {
 if (l[i] <= r[j]) {
 arr[k++] = l[i++];
 }
 else {
 arr[k++] = r[j++];
 }
 }
 //compare element left subarray
 while (i < left) {
 arr[k++] = l[i++];
 }
  //compare element right subarray
 
 while (j < right) {
 arr[k++] = r[j++];
 }
}
// x : array to check 

private static boolean isSorted(int[] x)
 {
 for (int i = 0; i < x.length - 1; i++)
 if (x[i] > x[i + 1])
 return false;
 return true;
 }
}