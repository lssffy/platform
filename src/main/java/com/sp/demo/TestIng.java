package com.sp.demo;

import java.io.*;


/**
 * @author : lssffy
 * @Description :
 * @date : 2024/1/28 16:25
 */

public class TestIng {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=br.readLine())!= null) {
           char[] chars = input.toCharArray();
           char[] result = new char[chars.length];
           int flag = 65,j=0;
           while(flag<=90){
               for(int i=0;i<chars.length;i++){
                   if((chars[i]>=65 && chars[i]<=90)||(chars[i]>=97 && chars[i]<=122)){
                       if(chars[i]==flag || chars[i]==flag + 32){
                           result[j] = chars[i];
                           j++;
                       }
                   }
               }
               flag++;
           }
           j = 0;
            for (int i = 0; i < chars.length; i++) {
                if((chars[i]>=65 && chars[i]<=90)||(chars[i]>=97 && chars[i]<=122)){
                    chars[i] = result[j];
                    j++;
                }
            }
            System.out.println(String.valueOf(chars));
        }
    }

}



