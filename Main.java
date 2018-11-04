
import java.util.Random;

public class main {

  public static void main(String[] args) throws InterruptedException {

    Random r = new Random(System.currentTimeMillis());
    int n = 400;
    int numberOfThreads = Math.abs(r.nextInt()) % 9 + 4;
    int[] result = new int[numberOfThreads];
    while(n % numberOfThreads != 0)
    	n++;
    int[] arr = new int[n];
    for(int i = 0; i < n; i++)
        arr[i] = r.nextInt();
    int segment = arr.length / numberOfThreads;
    int biggest = arr[0];
    for(int i = 0; i < n; i++)
      if(arr[i] > biggest)
        biggest = arr[i];
    System.out.println("The biggest number of the entire array before creating threads is: " + biggest);
    int currThreadNumber = 0;
    int currStartIndex = 0;
    Thread[] allThreads = new Thread[numberOfThreads];
    for (int i = 0; i < numberOfThreads; i++) {
      allThreads[currThreadNumber] = new MyThead(currThreadNumber, result, arr, currStartIndex, currStartIndex + segment - 1);
      allThreads[currThreadNumber].start();
      currStartIndex += segment;
      currThreadNumber++;
    }
    for (Thread t: allThreads) {
      t.join();
    }
    biggest = result[0];
    for (int i = 0; i < numberOfThreads; i++) {
      if (result[i] > biggest) {
        biggest = result[i];
      }
    }

    System.out.println("The biggest number of these using " + numberOfThreads +
      " threads is: " + biggest);
  }
}
