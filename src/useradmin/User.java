package useradmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
 Scanner in=new Scanner(System.in);
 private int id;
 private String name;
 private String password;
 int deletUser;

 ArrayList<User>users=new ArrayList<>();

  public User(){

  }

 public void viewUserList(){
  System.out.println("Her is the user list");
  System.out.println();
  for (int i=0; i<users.size();i++){
   System.out.println("ID: " + users.get(i).id);
   System.out.println("Name: " + users.get(i).name);
   System.out.println("Password: " + users.get(i).password);
   System.out.println();
  }

 }
 public int readInt(){
   while (true){
    if(in.hasNextInt()){
     return in.nextInt();
    }else{
     System.out.println("You entered something wrong");
     in.nextLine();

    }
   }
 }

 public void creatNewUser() {
  System.out.println("Hi Welcome to user Admin.");
  System.out.println("Type your id: ");
  int id=readInt();
  System.out.println("Type your name:");
  String name=in.next();
  System.out.println("type your password");
  String password=in.next();
  users.add(new User(id,name,password));

  for (User u : users){
   System.out.println(u);
  }
   addUsers();

 }
 public void deletUser(){

   System.out.println();
   System.out.println("Choice the user want to delete");
   int userToDelete = readInt();
    System.out.println();
    try {
     User deletedUser = users.remove(userToDelete);
     System.out.println("This user is delete");
     System.out.println("ID "+deletedUser.id);
     System.out.println("Name "+deletedUser.name);
     System.out.println("Password "+deletedUser.password);

     addUsers();

    }catch (IndexOutOfBoundsException e){
     System.out.println("You entered something an invalid  to delet");
    }

 }

 public void addUsers(){
   // reset users file
   try {
    File file = new File("users.txt");
    file.delete();
    file.createNewFile();
   } catch (IOException e) {
   }

  try (PrintStream ps= new PrintStream("users.txt")) {
   for (User user : users) {
    ps.println("id: " + user.getId() + " name: " + user.getName() +
            " password: " + user.password);
   }
  }catch (FileNotFoundException e) {

  }
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
   return"Info:--------------" +"\nID:"+ id+"\n"+"Name:"+getName()+"\nPassword: "+getPassword();
   }
 }
