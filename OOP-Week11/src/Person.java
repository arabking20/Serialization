//FileOutputStream fout = new FileOutputStream("G:\\address.ser");
//ObjectOutputStream oos = new ObjectOutputStream(fout);
//oos.writeObject(MyClassList);
//Assuming, of course, that MyClassList is an ArrayList or LinkedList, or another Serializable collection.
import java.util.*;
import java.io.*;


//following class implements a Perrson class
public class Person implements Serializable
{
  //instance variables
  private static int count = 0;	//keeps counting of the persons objects
  private int id;		//stores a unique id of the person
  private String name;		//stores name of the Person
  private String phoneNum;	//stores phone number of the Person            
  private String dob;		//stores date of birth of the Person
  private String email;		//stores e mail address of the person


  //constructor
  public Person (String name, String phoneNum, String dob, String email)
  {
    this.id = count + 1;
    this.name = name;
    this.phoneNum = phoneNum;
    this.dob = dob;
    this.email = email;


    count++;
  }				//End of constructor




  //getters 


  //returns id of the Person


  public int getId ()
  {
    return id;
  }				//End of method getId()


  //returns name of the Person
  public String getName ()
  {
    return name;
  }


  //returns phone number of the Person
  public String getPhoneNum ()
  {
    return phoneNum;
  }


  //returns date of Birth of the Person
  public String getDob ()
  {
    return dob;
  }


  //returns e mail id of the person
  public String getEmail ()
  {
    return email;
  }


  //setters
  //sets name of the person
  public void setName (String name)
  {
    this.name = name;
  }


  //sets phone number of the Person
  public void setPhoneNum (String phoneNum)
  {
    this.phoneNum = phoneNum;
  }


  //sets date of Birth of the Person
  public void setDob (String dob)
  {
    this.dob = dob;
  }


  //sets e mail id of the person
  public void setEmail (String email)
  {
    this.email = email;
  }


  //following method returns the object in the form of a String
  public String toString ()
  {
    return "Name: " + name + ", Phone Number : " + phoneNum +
      ", Date of Birth: " + dob + ", email: " + email;
  }				//End of method toString()
}				//End of class Person
