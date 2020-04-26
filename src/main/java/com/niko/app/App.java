

import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

class App{
  
  public static void main(String[] args){
    Quicksort qs = new Quicksort();
    Bubblesort bs = new Bubblesort();
    Mergesort ms = new Mergesort();
    Heapsort hs = new Heapsort();
    Comparator c = new Comparator();
    SortingAlg[] algs = {qs, ms, hs, bs};
    Boolean[] checked = new Boolean[algs.length]; //which algorithms user wants to compare
    for(int i = 0; i < checked.length; i++){
      checked[i] = false;
    }
    
    Scanner sc = new Scanner(System.in);
    int arrayLength = 1000; //default randomized array length
    
    while(true){ //only stops when user writes exit
      System.out.println("Array length: " + arrayLength); //print array length
      for(int i = 0; i < checked.length; i++){ //[ ] algorithm not checked [x] algorithm checked
        if(checked[i] == true){
          System.out.print(i + "[X] ");
        }
        else{
          System.out.print(i + "[ ] ");
        }
        System.out.print(algs[i].getName() + ". " + algs[i].getDescription() + "\n"); //names with descriptions
      }
      
      System.out.println("\nType number to check/uncheck. Type L{length} to change length (L1000). Run to compare. Exit for exit.");
      
      String userCmd = sc.nextLine().toLowerCase(); //conver user command to lowercase
      
      if(userCmd.equals("exit")){
        break;
      }
      else if(userCmd.equals("run")){ //run the comparison
        int checkCount = 0;
        for(int i = 0; i < checked.length; i++){
          if(checked[i] == true){
            checkCount++;
          }
        }
            
        ArrayList<SortingAlg> sa = new ArrayList<SortingAlg>(); //which alogirthms to compare
        
        for(int i = 0; i < checked.length; i++){ //add algorithms based on if they are checked or not
          if(checked[i] == true){
            sa.add(algs[i]);
          }
        }
          
        c.compare(sa.toArray(new SortingAlg[checkCount]), arrayLength); //compare algortihms
      }
      else if(userCmd.matches("\\d+")){ //user command is numeric
        int numb = Integer.parseInt(userCmd); //make user command into int
        if(numb < checked.length && numb >= 0){ //number is valid
          if(checked[numb] == true){ //if it is checked, uncheck and vice versa
            checked[numb] = false;
          }
          else{
            checked[numb] = true;
          }
        }
      }
      else if(userCmd.charAt(0) == 'L' || userCmd.charAt(0) == 'l'){ //change array length
        if(userCmd.substring(1,userCmd.length()).matches("\\d+")){
          if(Integer.parseInt(userCmd.substring(1,userCmd.length())) > 0){
               arrayLength = Integer.parseInt(userCmd.substring(1,userCmd.length()));
          }
          else{
            System.out.println("The array length must be larger than 0");
          }
        }
        else{
          System.out.println("Must type L{valid number}");
        }
      }
      else{
        System.out.println("Unknown command");
      }
      System.out.println("");
    }
    
    //System.out.println(c.testSortingAlg(hs, 20));
    
    
  }
}