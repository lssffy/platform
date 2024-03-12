package com.sp.demo;


/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/12 9:14
 */
public class Apples {
    public static void main(String[] args) {
        int[] num = new int[]{3,3,5,1,-7,4,9,-6,8,10,4};
        int[] list = Apples.quick_sort(num,0,11);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        int[] lists = Apples.bubble_sort(num,10);
        for (int i = 0; i < lists.length; i++) {
            System.out.print(lists[i] + " ");
        }

    }

    public static int[] quick_sort(int[] num,int l,int r){
        int first = l,last = r-1,key = num[first];
        while (first<last){
            while (first<last && num[last]>=key){
                --last;
            }
            num[first] = num[last];
            while(first<last && num[first]<key){
                ++first;
            }
            num[last] = num[first];
        }
        num[first] = key;
        if(first>l){
            num = quick_sort(num, l, first);
        }
        if(first+1<r){
            num = quick_sort(num,first+1,r);
        }
        return num;
    }

    public static int[] bubble_sort(int[] num,int r){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <r-i-1; j++){
                if(num[j]>num[j+1]){
                    int temp;
                    temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }

    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
}
