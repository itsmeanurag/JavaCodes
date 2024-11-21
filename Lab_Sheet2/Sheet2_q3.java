package Lab_Sheet2;

import java.util.Scanner;

class Employee{
    String name;
    String last_name;
    double salary;
    Employee(String name,String last_name,double salary){
        this.name = name;
        this.last_name = last_name;
        this.salary = salary;
    }
    void Employee(){
        System.out.println(name);
        System.out.println(last_name);
        System.out.println(salary);
    }
}

public class Sheet2_q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee[] one = new Employee[2];
        for(int i = 0;i<2;i++){
            System.out.println("enter the first name of employee:");
            String name = input.nextLine();
            System.out.println("enter the last name of employee:");
            String last_name = input.nextLine();
            System.out.println("enter the salary of employee:");
            double salary = input.nextDouble();
            one[i] = new Employee(name,last_name,salary);

        }
    }
}
