package sem3_codes;
import java.io.File;
import java.io.IOException;

public class FileMethod {
    public static void main(String[] args) {
        try
        {
            File f1= new File("D:\\sample.txt"); // exists() : public boolean exists();
            boolean status =f1.exists();
            System.out.println("Befor status "+status); //createNewFile : public boolean createNewFile()
            f1.createNewFile();
            boolean status1 =f1.exists();
            System.out.println("After status "+status1); //getName () : public String getName()
            String name = f1.getName();
            System.out.println(name);
            System.out.println("File Delete Status :"+f1.delete());
            System.out.println(f1.exists());

            File f2= f1.getAbsoluteFile();
            System.out.println(f2); //f2.toString()
            System.out.println("Absolute Path"+f1.getAbsolutePath());
            System.out.println("Read only"+f1.canRead());
            System.out.println("Write only"+f1.canWrite());

            File f3 = new File("D:\\A\\B"); //System.out.println(f3.mkdir());
            System.out.println(f3.mkdirs());

            File f4 = new File(f3,"sample.png");
            f4.createNewFile();
            System.out.println(f4.isFile());
            System.out.println(f4.isDirectory());
            System.out.println(f4.isHidden());
            System.out.println("Length :"+f4.length());

            File f5 = new File("D:\\");
            String all[]= f5.list(); for(String file1 : all )
        {
            System.out.println(file1);
        }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
