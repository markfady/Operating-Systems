
package fcfs;

import java.util.Scanner;
public class Fcfs {
public static void main(String[] args) {
    //int[] process = new int[]{1,2,3};//to show how many process    
    int size;
    Scanner scan=new Scanner(System.in);
       System.out.print("Enter The Size of array :");
    size=scan.nextInt();//set size of the array
    int[] waitingval = new int [size]; // set the size of array that carry waiting time of each process
    waitingval[0]=0;//to keep the first waiting time 0
    int waiting=0;//set intial value for waiting
    int [] BurstTime = new int [size];//array that carry burst time
    int totalwaiting=0;//set intial value for total waiting
    float avg;
      System.out.print("Enter The values of Burst time :");
for(int i=0;i<size;i++){//for loop to get burst time
BurstTime[i]=scan.nextInt();


}    
for( int i=1;i<BurstTime.length;i++){ //inside the array store the waiting of each process
    waiting=waiting+BurstTime[i-1];//to calculate waiting time from the birst time of first element(0)
    waitingval[i]=waiting;
}
for(int j=0;j<BurstTime.length;j++){  //Excution of arrary items
    System.out.println("Waiting values are:"+waitingval[j]); //show the array that carry the waiting time
    totalwaiting=totalwaiting+waitingval[j];//calculate total waiting time
}

System.out.println("total waiting is "+totalwaiting);//show total waiting time
avg=totalwaiting/BurstTime.length;//calculate average
System.out.println("average waiting is "+avg);//show average 
}
}
