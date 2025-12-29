import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class StudentIO{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         // ---------- WRITE PART ----------
        try{
            FileWriter writer = new FileWriter("student.txt",true);
            System.out.print("How many student do you want to add ?");
            int count = sc.nextInt();
            sc.nextLine();  // clear buffer

            for(int i =1; i<= count;i++){
                System.out.println("Enter details for Student"+i);
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                // Combine into ONE record
                String record = id+","+name+","+age+"\n";
                writer.write(record);
            }
            writer.close();
            System.out.println("Students saved successfully.");
        } catch (IOException e){
            System.out.println("Error writing to file");
        }

        // ---------- READ PART ----------
        try{
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            String line;
            System.out.println("-------Student Records-------");
            while((line = reader.readLine())!=null){
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name= parts[1];
                int age = Integer.parseInt(parts[2]);
                System.out.println("ID: "+id+", Name: "+name+", Age: "+age);
            }
            reader.close();
        }catch(IOException e){
            System.out.println("Error reading file!");
        }
        sc.close();
    }
    
}