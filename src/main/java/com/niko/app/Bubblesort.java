

class Bubblesort implements SortingAlg{
  
  private int c;
    
  public Bubblesort(){
    c = 0;
  }
  
  public String getName(){
    return "Bubble sort";
  }
  
  public String getDescription(){
    return "WARNING! VERY SLOW ON LONGER ARRAYS (+10000)! Best: n, average: n^2, worst: n^2. Memory: 1. Stable: yes.";
  }
  
  public int sort(Integer[] a){
    bubblesort(a);
    return c;
  }
  
  private void bubblesort(Integer[] a){
    int n = a.length;
    c++;
    for(int i = 0; i < n-1; i++){
      c = c + 2;
      for(int j = 0; j < n-i-1; j++){
        c = c + 3;
        if(a[j] > a[j+1]){ //compare element to next of
          int temp = a[j]; //change if it is bigger
          a[j] = a[j+1];
          a[j+1] = temp;
          c = c + 3;
        }
      }
    }
  }
}