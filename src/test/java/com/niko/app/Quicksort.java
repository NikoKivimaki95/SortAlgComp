

class Quicksort implements SortingAlg{
  
  private int c;   //calculate comparisons and changes
  
  public Quicksort(){
    c = 0;
  }
  
  public String getName(){
    return "Quicksort";
  }
  
  public String getDescription(){
    return "Best: n log n, average: n log n, worst: n^2. Memory: log n. Stable: no.";
  }
  
  public int sort(Integer[] a){
    quicksort(a, 0, a.length-1);
    return c;
  }
  
  public void quicksort(Integer[] a, int low, int high){
    c++;
    if(low < high){
      int p = partition(a, low, high);
      quicksort(a, low, p - 1);
      quicksort(a, p + 1, high);
    }
  }
  
  //last item as pivot, places into correct position. Smaller elements on left, larger ones on right
  private int partition(Integer[] a, int low, int high){
    int pivot = a[high];
    int i = low;
    c = c + 2;
    for(int j = i; j < high; j++){
      c = c + 2;
      if(a[j] < pivot){ //smaller than pivot, swap a[i] and a[j]
        int k = a[i];
        a[i] = a[j];
        a[j] = k;
        i++;
        c = c + 4;
      }
    }
    int k = a[i]; //swap a[i+1] and pivot
    a[i] = a[high];
    a[high] = k;
    c = c + 3;
    return i;
  }
}