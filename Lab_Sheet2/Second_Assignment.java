package Lab_Sheet2;

import java.util.Scanner;

class application{
    static float total_cost(float a, float b){
        return (a*b);
    }
    static float toll_cost(float a){
        return (30f*a);

    }
}
class final_amount    extends application {
    static float t_cost(float t_cost,float toll_cost){
        float day_cost = t_cost+toll_cost;
        return day_cost;
    }
}

public class Second_Assignment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float arr[] = new float[7];
        System.out.println("cost per gallon of gasoline");
        System.out.println("cost of one toll is $30");
        float cost = input.nextFloat();
        for(int i =0;i<7;i++){
            System.out.println("enter the total miles driven per day");
            float t_drive = input.nextFloat();
            System.out.println("enter the tolls per day");
            float tolls = input.nextFloat();
            float cost1 = application.total_cost(t_drive,cost);
            float cost2 = application.toll_cost(tolls);
            System.out.println("total cost of driving per day\n:"+(cost1+cost2));

            arr [i] = final_amount.t_cost(cost1,cost2);
        }
        for(int i = 0;i<7;i++){
            System.out.print(" "+arr[i]);
        }
        float sum = 0;
        for(int i =0;i<7;i++){
            sum = sum+arr[i];
        }
        System.out.println("\navg:\n"+(sum/7));
    }
}

