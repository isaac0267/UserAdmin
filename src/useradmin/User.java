package useradmin;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
 private int id;
 private String name;
 private String password;
 ArrayList<User>usersList=new ArrayList<>();
 ArrayList<User>users=new ArrayList<>();
 ArrayList<User>deleteUser=new ArrayList<>();
 ArrayList<User>viewUser=new ArrayList<>();

 String stringId=String.valueOf("id"); // this method is convert the  integer to String.
  private final String  stringConstant="user.txt";

  public User(){

  }

 public void viewUserList(){
  System.out.println("Her is the user list");
  System.out.println();
  for (int i=0; i<usersList.size();i++){
   System.out.println("ID: " + usersList.get(i).id);
   System.out.println("Name: " + usersList.get(i).name);
   System.out.println("Password: " + usersList.get(i).password);
   System.out.println();

  }

 }




 public void creatNewUser() {
  System.out.println("Hi Welcome to user Admin.");
  System.out.println("Type your id");
  Scanner scanner=new Scanner(System.in);
  int id=scanner.nextInt();
  System.out.println("Type your name:");
  String name=scanner.next();
  System.out.println("type your password");
  String password=scanner.next();
  users.add(new User(id,name,password));
  usersList.add(new User(id, name, password));
  deleteUser.add(new User(id,name,password));
  for (User u : users){
   System.out.println(u);
  }
   addUsers();
 }
 public void deletUser(){
   System.out.println();
   System.out.println("Delte user");
  System.out.println();
   for (int i=0; i<deleteUser.size();i++){
    System.out.println("This user is delete");
    System.out.println("ID "+usersList.get(i)+id);
    System.out.println("Name "+usersList.get(i)+name);
    System.out.println("Password "+usersList.get(i).password);
   }

 }
 public void saveFile(){
  System.out.println();
  System.out.println("this is the users info");
  System.out.println();
  for (int i=0; i<viewUser.size();i++){
   System.out.println("This is the list of the users");
   System.out.println("ID"+viewUser.get(i)+id);
   System.out.println("Name:"+viewUser.get(i)+name);
   System.out.println("Password"+viewUser.get(i)+password);
  }
 }
 public String readFil(){
   try {
    PrintStream printStream=new PrintStream(new PrintStream("word.txt"));
     for (int i=0; i<usersList.size();i++){
      System.out.println("Id:"+usersList.get(i)+getId()+"Name:"+usersList.get(i)+getName()+""+
              "Password:"+usersList.get(i)+getPassword());
     }

   }catch ( FileNotFoundException e){

   }
   return " ID "+id+" name"+name+" password"+password;

 }


 public void addUsers(){
  try {
   PrintStream ps= new PrintStream(new PrintStream("users.txt"));
   for (int i=0; i<users.size();i++){
    ps.println("id: "+users.get(i).getId()+" name: "+users.get(i).getName()+
            " password: "+users.get(i).password);
   }
  }catch (FileNotFoundException e) {

  }
  //return id+" "+name+" "+password;
 }





 // constructor that take the ID.

  public User(int id){
  this.id=id;

  }
  // make the other constructor that take the name and password.
   public User(int id,String name, String password){
   this.id=id;
   this.name=name;
   this.password=password;
   }
   // getter.
    public int getId(){
    return id;
    }
    public String getName(){
    return name;
    }
    public String getPassword(){
    return password;
    }
    // setter.
    public void setId(int id){
    this.id=id;
   }
   public void setName(String name){
   this.name=name;
   }
   public void setPassword(String password){
   this.password=password;
   }
   // to string.
   @Override
   public String toString(){
   return "ID:"+ id+" "+"Name:\n"+getName()+" Password:\n "+getPassword();
   }
 }
