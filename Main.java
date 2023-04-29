/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hello_world;
import java.util.Scanner;
/**
 *
 * @author Yeyian PC
 */
public class Main {
    public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      boolean[] chptList = new boolean[16]; // Valid chapters are 1-15. 1 means include, 0 exclude. Element 0 unused. 
      int includeChpt;
      int i, j;
      
      // Get the chapter selections
      for (i = 1; i <= 15; ++i) {
         includeChpt = scnr.nextInt(); 
         if (includeChpt==1) {
            chptList[i] = true;
         }
         else {
            chptList[i] = false;
         }
      }
      
      /* Type your code here. */
      boolean repeatStreakOnJP = false;
      int lowestRepeatJP = 0, highestRepeatJP = 0;
      boolean firstPrintJP = false;
      for (int q = 0; q<chptList.length; q++) {
         if (chptList[q] == true && repeatStreakOnJP == false) {
            repeatStreakOnJP = true;
            lowestRepeatJP = q;
            highestRepeatJP = q;
         } else if (chptList[q] == true && repeatStreakOnJP == true) {
            highestRepeatJP = q;
         } else if (chptList[q] == false) {
            if ((lowestRepeatJP+2) <= highestRepeatJP) {
               if (firstPrintJP == false) {
                  firstPrintJP = true;
                  System.out.print(lowestRepeatJP+"-"+highestRepeatJP);
               } else {
                  System.out.print(" "+lowestRepeatJP+"-"+highestRepeatJP);
               }
               repeatStreakOnJP = false;
               lowestRepeatJP = 0;
               highestRepeatJP = 0;
            } else if (lowestRepeatJP == highestRepeatJP && lowestRepeatJP>0) {
               if (firstPrintJP == false) {
                  firstPrintJP = true;
                  System.out.print(lowestRepeatJP);
               } else {
                  System.out.print(" "+lowestRepeatJP);
               }
               repeatStreakOnJP = false;
               lowestRepeatJP = 0;
               highestRepeatJP = 0;
            } else if (lowestRepeatJP>0 && !(lowestRepeatJP == highestRepeatJP)) {
               if (firstPrintJP == false) {
                  firstPrintJP = true;
                  System.out.print(lowestRepeatJP+" "+highestRepeatJP);
               } else {
                  System.out.print(" "+lowestRepeatJP+" "+highestRepeatJP);
               }
               repeatStreakOnJP = false;
               lowestRepeatJP = 0;
               highestRepeatJP = 0;
            }
            
            
         }
      }
      
      boolean allFalseJP = false;
      for (int v = 0; v<15; v++) {
         if (chptList[v] == true) {
            allFalseJP = true;
         }
      }
      
      if (chptList[15] == true && highestRepeatJP != 0 && highestRepeatJP!=lowestRepeatJP) {
         System.out.println(lowestRepeatJP+"-"+highestRepeatJP+" ");
      } else if (chptList[15] == true && firstPrintJP == true) {
         System.out.println(" 15"+" ");  
      } else if (chptList[15] == true && firstPrintJP == false) {
         System.out.println("15"+" ");
      } else if (allFalseJP == false) {
         System.out.println("None ");
      } else {
         System.out.println(" ");  
      }
   }
}
