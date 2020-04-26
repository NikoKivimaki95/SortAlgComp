

import java.util.Random;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

class Comparator{
  
  public Comparator(){

  }
  
  public boolean testSortingAlg(SortingAlg alg, int length){ //tests if the sorting alg is working
    Integer[] a = createArray(length);
    Integer[] b = new Integer[length];
    for(int i = 0; i < length; i++){
      b[i] = i;
    }
    alg.sort(a);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    if(Arrays.equals(a, b)){
      return true;
    }
    else{
      return false;
    }
  }
  
  public void compare(SortingAlg[] sorts, int length){ //compare sorting algs
    System.out.println("Time might not be reliable for shorter arrays.\n");
    Integer[] operations = new Integer[sorts.length];
    Long[] times = new Long[sorts.length]; //used to measure time
    for(int i = 0; i < sorts.length; i++){ //for each algorithm in sorts
      String name = sorts[i].getName();
      System.out.println("Starting "+name);
      Integer[] a = createArray(length); //create randomized array
      long startTime = System.nanoTime(); //start time measurement
      System.out.println(name+ " ended with "+sorts[i].sort(a)+" performed operations."); //sort it
      long endTime = System.nanoTime(); //stop time measurement
      System.out.println("Time elapsed: " + ((endTime - startTime) / 1000000) + 
                         " milliseconds. " + (endTime - startTime) + " in nanoseconds.\n");
      //calculate time and print operation count
    }
  }
  
  private Integer[] createArray(int length){ //creates randomized array
    Random r = new Random();
    Integer[] a = new Integer[length];
    for(int i = 0; i < length; i++){
      a[i] = i;
    }
    List<Integer> list = Arrays.asList(a);
    Collections.shuffle(list);
    list.toArray(a);
    
    return a;
  }
}