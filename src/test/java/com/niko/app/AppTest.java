import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testAlgorithms(){
        Comparator c = new Comparator();
        SortingAlg[] algs = {new Quicksort(), new Bubblesort(), new Mergesort(), new Heapsort()};
        
        for(int i = 0; i < algs.length; i++){
            assertEquals(true, c.testSortingAlg(algs[i], 1000));
        }
    }
}
