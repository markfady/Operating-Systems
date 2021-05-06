/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.Scanner;

public class JavaApplication7 {

   public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      int num;//number of process
      int temp;//temporary
      int i;//used in loops
      int j;//used in loops
      float average;
      System.out.println("enter number of process :");
      num=scan.nextInt();
      int []pn= new int[num];// array that carry number of process
      int []bt= new int[num];// array that carry burst time of process
      int []wt= new int[num];// array that carry waiting time of process
      int waiting=0;//store the value of 1 process waiting to be used to get the waiting time of next one
      int totalwaiting=0;//store the value of total waiting
      wt[0]=0;//always make the waiting time of first element 0
      System.out.println("enter process numbers");
    for(i=0;i<num;i++){//loop to enter process
        pn[i]=scan.nextInt();//store values in pn[]
    }
    System.out.println("enter burst time");
    for(i=0;i<num;i++ ){//loop to enter burst time of the process
        bt[i]=scan.nextInt();//store the values in bt[]
    }
    //buble sort technique to arrange the two arrays
    //two loops is a must in order to arrange both arrays simultaneously if we removed
    //any one the sorting will be done as the two arrays are 1 
    for(i=0;i<num;i++){
        for(j=0;j<num-i-1;j++){
            if(bt[j]>bt[j+1]){
               //arrange burst time array  
                temp=bt[j];
                bt[j]=bt[j+1];
                bt[j+1]=temp;
               //arrange process array 
                temp=pn[j];
                pn[j]=pn[j+1];
                pn[j+1]=temp;
            }
        }
    }
    System.out.println("after arange");//after arranging process according to waiting time
     for(i=0;i<num;i++){System.out.println("proces  "+pn[i]+"   "+bt[i]);}  
 
    for(  i=1;i<num;i++){ //inside the array store the waiting of each process
    waiting=waiting+bt[i-1];//to calculate waiting time from the birst time of first element(0)
    wt[i]=waiting;
    }
    System.out.println("waiting time of each process");//loop that shows the waiting time of each process
    for(i=0;i<num;i++){
        System.out.println("proces  "+pn[i]+"   "+wt[i]);
    }   
    for(i=0;i<num;i++){//loop to get the sum of waiting
        totalwaiting=totalwaiting+wt[i];
    }
    System.out.println("total waiting is :"+totalwaiting);
    average=totalwaiting/num;//calculate average 
    System.out.println("average is : "+average);
 
    }
    }
    

