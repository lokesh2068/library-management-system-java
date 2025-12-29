import java.util.HashMap;
import java.util.Scanner;
/* ===================== Book Class =====================*/
class Book{
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // default: available
    }
    public int getID() {
        return id;
    }
    public String getTitle(){
        return title;
    }
     // getter (read-only access)
    public boolean isBorrowed(){ 
        return isBorrowed;
    }
    // state-changing methods
    public void borrow(){
        isBorrowed = true;
    }
    public void returnBook(){
        isBorrowed = false;
    }
    public void display(){
        System.out.println("ID: "+id+", Title: "+title+", Author: "+author+", Status: "+(isBorrowed? "Borrowed":"Available"));
    }

}
public class LibraryManagementSystem{
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Book> library = new HashMap<>();
        int choice;
        do{
            System.out.println("=======Library Management System=========");
            System.out.println("1. Add Books");
            System.out.println("2. Show All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
              /* -------- Add Book -------- */
              if(choice == 1){
                System.out.print("Enter Book ID: ");
                int id = input.nextInt();
                input.nextLine(); // clear newLine
                if (library.containsKey(id)){
                    System.out.println("Book with this ID already exists1!");
                    continue;
                }
                System.out.print("Enter Title: ");
                String title = input.nextLine();

                System.out.print("Enter Author: ");
                String author = input.nextLine();

                library.put(id,new Book(id,title,author));
                System.out.println("Book added successfully!");

              }
               /* -------- Show All Books -------- */
               else if (choice == 2) {
                  if (library.isEmpty()){
                    System.out.println("No Books in library.");
                  } else {
                    System.out.println("-----ALL Books-----");
                     for (Book b:library.values()){
                    b.display();
                  }
                }
               }

                /* -------- Search Book -------- */
                else if (choice ==3){
                    System.out.print("Enter Book ID to search: ");
                    int id = input.nextInt();

                    Book b = library.get(id);
                    if(b== null){
                        System.out.println("Book not fount!");
                    }else{
                        System.out.println("Book found: ");
                        b.display();
                    }
                }
                /* -------- Borrow Book -------- */
                else if (choice == 4){
                    System.out.println("Enter Book ID to borrow: ");
                    int id = input.nextInt();
                    Book b = library.get(id);
                    if(b== null){
                        System.out.println("Book not found!");
                    } else if (b.isBorrowed()){
                        System.out.println("Book is already borrowed.");
                    } else{
                        b.borrow();
                        System.out.println("Borrowed successfully");
                    }
                }
                 /* -------- Return Book -------- */
                 else if(choice == 5){
                    System.out.println("Enter Book ID to return: ");
                    int id = input.nextInt();

                    Book b = library.get(id);
                    if (b==null){
                        System.out.println("Book not found!");
                    }else if (!b.isBorrowed()){
                        System.out.println("This book was not borrowed.");
                    }else {
                        b.returnBook();
                        System.out.println("Returend successfully!");
                    }
                 }
                  /* -------- Remove Book -------- */
                  else if (choice == 6){
                    System.out.println("Enter Book ID to remove");
                    int id = input.nextInt();

                    if(library.containsKey(id)){
                        library.remove(id);
                        System.out.println("Book removed.");
                    } else{
                        System.out.println("Book not found!");
                    }
                  }
                  /* -------- Exit -------- */
                  else if (choice == 7){
                    System.out.println("Existing..........Goobye!");
                  } else {
                    System.out.println("Invalid choice....Try agian..");
                  }
        } while  (choice != 7);
        input.close();

    }
}