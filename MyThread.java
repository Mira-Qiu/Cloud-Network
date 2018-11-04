

public class MyThead extends Thread {

  private int threadNumber;
  private int[] result;
  private int[] arr;
  private int startIndex;
  private int endIndex;

  public MyThead(int threadNumber, int[] result, int[] arr, int startIndex, int endIndex) {
    this.threadNumber = threadNumber;
    this.result = result;
    this.arr = arr;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  public void run(){
    result[threadNumber] = arr[startIndex];
    for (int i = startIndex; i <= endIndex; i++) {
      if (arr[i] > result[threadNumber]) {
        result[threadNumber] = arr[i];
      }
    }
  }
}
