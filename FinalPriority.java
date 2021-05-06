/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.priority;

import java.util.Scanner;


public class FinalPriority {
  int ProcessNumber;
    String []ProcessID;
    int []BurstTime;
    int []ArrivalTime;
    int []Priority;
    //Each process got ( Arrival time , Burst Time , Prioirty) 
    void getData(Scanner input){
        System.out.print("Enter Number of process");
        int Numberofprocess=input.nextInt(); //User will  write number of process
        ProcessNumber=Numberofprocess;       //Global variable so i can call process Number next classes
        BurstTime=new int[Numberofprocess];
        ArrivalTime=new int[Numberofprocess];
        Priority=new int[Numberofprocess];
        ProcessID=new String[Numberofprocess];
        String concate="P";
        for(int i=0;i<Numberofprocess;i++){
        ProcessID[i]=concate.concat(Integer.toString(i));  //Merge process Number enterd from user to every single next data will be taken .
        System.out.print("Enter the value of BurstTime for process "+(i)); //(i) = number of process that will be written by the user
        BurstTime[i]=input.nextInt(); //Data of process 1 = burst time (written by user)
        System.out.print("Enter the value of ArrivalTime for process"+(i)); //Save Arrival time value for the same process
        ArrivalTime[i]=input.nextInt();//user will write value of ArrivalTime
        System.out.print("Enter the value of Priority"+(i));//Save Prioirty value for the same process
        Priority[i]=input.nextInt();//user will write value of Priority
       
        //Now Each process got Arrival &Burst time and priority 
        //same process number for each input data 
        //data will be taken from user 
      
    }
    }
    //Starting of sorting 
    //Sorting of arrival time and priority
    
        void sortArrivalTimeAndPriority(int[] at, int[] bt, int[] prt, String[] pid)      //at = Arrival time        //bt=Burst time          //prt=Priority
        {             
int temp;
String stemp;
  for (int i = 0; i < ProcessNumber; i++) {            //Calling processNumber which refers to NumberofProcess
        
        for (int j = 0; j <ProcessNumber - i - 1; j++) {
            //Sorting of Arrival Time                                Sorting Process Number 1
             if(prt[j]>prt[j+1]){
                 
             temp=prt[j]; //Save data of index 0 of array at in temp so we can swap  biggest one
             prt[j]=prt[j+1]; //Now the lowest value will come in first place  smallest one
             prt[j+1]=temp; //the Highest value will be stored at last 
             
             //End sorting of Arrival Time
             
             //Sorting of Burst Time                                Sorting Process Number  2 
             temp=bt[j];   //Biggest value will be in temp        ... so this place is empty now
             bt[j]=bt[j+1]; // Save the lowest value in the empty place of array ( first place) 
             bt[j+1]=temp;  //Put the Biggest value from temp after sorting thee lowest 
             
                   stemp = pid[j];             //String temp as it carries the process names 
                        pid[j] = pid[j + 1];
                        pid[j + 1] = stemp;
                        
                        
                        
                        
                       temp=at[j]; //Save data of index 0 of array at in temp so we can swap  biggest one
             at[j]=at[j+1]; //Now the lowest value will come in first place  smallest one
             at[j+1]=temp; //the Highest value will be stored at last 
             
             
             
             
             
             
             }}}}
                      void waiting(){ 
                    
                    int bt[]=BurstTime.clone(); //initializes all bt field with exactly the contents of the data taken from user in Burst Time 
                    int at[] =ArrivalTime.clone();  //initializes all at field with exactly the contents of the data taken from user in Arrival Time 
                    int waitingTime[] = new int[ProcessNumber];
                    int prt[] = Priority.clone();       //Intializes all priority values taken from user in first class in prt 
                    String pid[]= ProcessID.clone(); //Carry The Number of process taken from user in first class
 int []wt= new int[ProcessNumber];// array that carry waiting time of process
      int waiting=0;//store the value of 1 process waiting to be used to get the waiting time of next one
      int totalwaiting=0;//store the value of total waiting
       wt[0]=0;//always make the waiting time of first element 0
       int i;//used in loops
       int j;//used in loops
       float average;
        

                   
        
      sortArrivalTimeAndPriority(at,bt,prt,pid);
      for(  i=1;i<ProcessNumber;i++){ //inside the array store the waiting of each process
    waiting=waiting+bt[i-1];//to calculate waiting time from the birst time of first element(0)
    wt[i]=waiting;
    }
    System.out.println("waiting time of each process");//loop that shows the waiting time of each process
    for(i=0;i<ProcessNumber;i++){
        System.out.println("proces  " +  pid[i] + wt[i]);
    }   
    for(i=0;i<ProcessNumber;i++){//loop to get the sum of waiting
        totalwaiting=totalwaiting+wt[i];
    }
    System.out.println("total waiting is :"+totalwaiting);
    average=totalwaiting/ProcessNumber;//calculate average 
    System.out.println("average is : "+average);
 
   
      
        
        
        
        
        
 System.out.println("Priority Scheduling Algorithm : ");
 System.out.print( "    " );
System.out.println("ProcessId"+"   " + "BurstTime"+ "    " + "ArrivalTime"+"    " + "Priority");
        for (i = 0; i < ProcessNumber; i++) { //Stop when i is bigger than process Number
               System.out.println("      "+ pid[i] + "                " + bt[i]+ "              "  + at[i]+ "            "  + prt[i]); //Sorting every process with assending order
        }
        System.out.println("Average"+ average);
                                  
                      }
        
        
     
         
    public static void main(String[] args) {


          Scanner input = new Scanner(System.in);
        FinalPriority obj = new FinalPriority();
        obj.getData(input);     //Excute get data to the user to fill the data
        obj.waiting ();        //Calling Fuctions in void waiting to excute
        
        
    }
    
}
