package sem3_codes.design;

import java.util.HashMap;

class StudentInfo{
    int Sr_no;
    String name;
    String Roll_no;

    StudentInfo(int Sr_no,String name , String roll_no){
        this.Sr_no = Sr_no;
        this.Roll_no = roll_no;
        this.name = name;
    }
    public void display(){
        System.out.println("Sr_No\n"+Sr_no+"\nName\n"+name+"\nRollNo\n"+Roll_no);
    }
}

public class Student {
    public static void main(String[] args) {
//        HashMap<StudentInfo>
    }
}
