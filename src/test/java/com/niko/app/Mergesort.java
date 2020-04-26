

class Mergesort implements SortingAlg{
  
  private int c;
  
  public Mergesort(){
    c = 0;
  }
  
  public String getName(){
    return "Merge sort";
  }
  
  public String getDescription(){
    return "Best: n log n, average: n log n, worst: n log n. Memory: n. Stable: yes.";
  }
  
  public int sort(Integer[] a){
    mergesort(a, 0, a.length-1);
    return c;
  }
  
  private void mergesort(Integer[] a, int begin, int end){
    c++;
    //create sublists
    if(begin < end){
      int m = (begin+end)/2; //middle of list
      c++;
      
      mergesort(a, begin, m); //new sublist from beginning to middle
      mergesort(a, m+1, end); //new sublist from m+1 to end
      
      merge(a, begin, m, end); //merge sublist
    }
  } 
  
  private void merge(Integer[] a, int l, int m, int r){
    int n1 = m - l + 1; //size of subarray 1
    int n2 = r - m; //sinze of subarray 2
    
    Integer[] temp1 = new Integer[n1];
    Integer[] temp2 = new Integer[n2];
    
    c = c+4;
    
    for(int i = 0; i < n1; i++){ //copy data to temp1
      temp1[i] = a[l + i]; 
      c = c + 3;
    }
    for(int j = 0; j < n2; j++){ //copy data to temp2
      temp2[j] = a[m + 1 + j];
      c = c + 3;
    }
    
    int i = 0;
    int j = 0;
    
    int k = l;
    
    c = c + 3;
    
    while (i < n1 && j < n2){ //copy from temp arrays back into array
      c = c + 3;
      if (temp1[i] <= temp2[j]){ 
        a[k] = temp1[i]; 
        i++;
        c = c + 2;
      }
      else{ 
        a[k] = temp2[j]; 
        j++;
        c = c + 2;
      }
      k++;
      c++;
    }
    c++;
    
    while (i < n1){ //copying remaining elements if any
      a[k] = temp1[i]; 
      i++; 
      k++;
      c = c + 4;
    }
    c++;
  
    while (j < n2){ //copying remaining elements if any
      a[k] = temp2[j]; 
      j++; 
      k++;
      c = c + 4;
    }
    c++;
  }
}