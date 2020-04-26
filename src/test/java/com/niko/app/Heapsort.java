

class Heapsort implements SortingAlg{
  
  private int c;
  
  public Heapsort(){
    this.c = 0;
  }
  
  public String getName(){
    return "Heapsort";
  }
  
  public String getDescription(){
    return "Best: n log n, average: n log n, worst: n log n. Memory: 1. Stable: no.";
  }
  
  public int sort(Integer[] a){
    heapsort(a);
    return c;
  }
  
  public void heapsort(Integer[] a) 
  { 
    int n = a.length;
    c++;
    
    for (int i = n / 2 - 1; i >= 0; i--){
      c = c + 2;
      heapify(a, n, i);
    }
    
    for (int i = n - 1; i > 0; i--){
      int temp = a[0]; 
      a[0] = a[i]; 
      a[i] = temp;
      
      c = c + 5;
      
      heapify(a, i, 0);
    } 
  } 
  
  private void heapify(Integer[] a, int n, int i){
    int largest = i; // largest = root 
    int l = 2*i + 1; // left
    int r = 2*i + 2; // right
    c = c + 3;
    
    // left > root
    c = c + 2;
    if (l < n && a[l] > a[largest]){
      largest = l;
      c++;
    }
    
    // right = largest
    c = c + 2;
    if (r < n && a[r] > a[largest]){
      largest = r;
      c++;
    }
    
    // largest != root
    c++;
    if (largest != i){
      int swap = a[i];
      a[i] = a[largest];
      a[largest] = swap;
      
      c = c + 3;
      
      heapify(a, n, largest); 
    } 
  }
}