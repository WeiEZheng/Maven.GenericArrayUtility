package com.zipcodewilmington.arrayutility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] arr;

    public ArrayUtility(T[] inputArray){
        this.arr=inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        arr = merge(arr, arrayToMerge);
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T[] merge(T[] arr, T[] arrayToMerge) {
        T[] result=Arrays.copyOf(arr,arrayToMerge.length+arr.length);
        System.arraycopy(arrayToMerge,0,result,arr.length,arrayToMerge.length);
        return result;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        arr = merge(arr, arrayToMerge);
        int[] count= new int[arr.length];
        int mostCommonIndex=0;
        for (int i=0;i<arr.length;i++){
            count[i]=getNumberOfOccurrences(arr[i]);
        }
        T mostCommon = arr[0];
        for (int i=1;i< arr.length;i++) {
            if (count[mostCommonIndex]<count[i]){
                mostCommonIndex=i;
                mostCommon=arr[i];
            }
        }
        return mostCommon;
    }

    public T[] removeValue(T valueToRemove) {
        int index=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(valueToRemove)) {
                for (int j=i;j<arr.length-1;j++) {
                    arr[j] = arr[j+1];
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals(valueToRemove)) {
                index = i;
                break;
            }
        }
        arr = Arrays.copyOfRange(arr,0,index);
        return arr;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count=0;
        for (T s: arr){
            if (s.equals(valueToEvaluate))
                count++;
        }
        return count;
    }
}