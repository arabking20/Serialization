import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//Driver code
class Main
{


  //instance variables
  private static ArrayList < Person > persons = new ArrayList < Person > ();
  private static Scanner reader = new Scanner (System.in);
  private static String fileName = "persons.ser";


  //following method adds information of a person to the file
  public static void addInfo ()
  {


    int id;			//stores id of the person
    String name;		//stores name of the Person
    String phoneNum;		//stores phone number of the Person
    String dob;			//stores date of birth of the Person
    String email;		//stores e mail address of the person


      System.out.print ("Please enter name: ");
      name = reader.nextLine ();


      System.out.print ("Please enter phone number: ");
      phoneNum = reader.nextLine ();


      System.out.print ("Please enter date of birth: ");
      dob = reader.nextLine ();


      System.out.print ("Please enter e-mail address: ");
      email = reader.nextLine ();


    //constructing the Person object
    Person p = new Person (name, phoneNum, dob, email);


      persons.add (p);		//adding the person to the ArrayList persons


      try
    {
      //Writing the the ArrayList object to the file
      FileOutputStream file_o_stream = new FileOutputStream (fileName);
      ObjectOutputStream object_o_stream =
	new ObjectOutputStream (file_o_stream);
        object_o_stream.writeObject (persons);
        object_o_stream.close ();
        file_o_stream.close ();
        System.out.println ("data inserted successfully......");
    }
    catch (Exception exp)
    {
      System.out.println ("Error caught! " + exp);
    }
  }				//End of method addInfo()




  //following method displays information of all person from the file
  public static void display ()
  {
    try
    {
      //reading the the ArrayList object from the file
      FileInputStream file_i_stream = new FileInputStream (fileName);
      ObjectInputStream object_i_stream =
	new ObjectInputStream (file_i_stream);
      ArrayList < Person > persons =
	(ArrayList < Person >) object_i_stream.readObject ();
      object_i_stream.close ();
      file_i_stream.close ();


      //displaying the Person objects
      System.out.printf ("%5s|%20s|%15s|%10s|%20s|\n", "ID", "Name",
			 "Phone Num", "DOB", "E mail");
      int i = 0;
    for (Person p:persons)
	{
	  System.out.printf ("%5d|%20s|%15s|%10s|%20s|\n", p.getId (),
			     p.getName (), p.getPhoneNum (), p.getDob (),
			     p.getEmail ());
	  i++;
	}
    }
    catch (Exception exp)
    {
      System.out.println ("Error caught! " + exp);
    }
  }				//End of method display()




  //following method delets information of a person from the file
  public static void deleteInfo ()
  {
    display ();


    System.out.print ("Please enter ID of person to delete..");
    int id = reader.nextInt ();
    reader.nextLine ();


    int index = 0;
    for (index = 0; index < persons.size (); index++)
      {
	if (persons.get (index).getId () == id)
	  {
	    //delete the object from the ArrayList
	    persons.remove (index);
	    break;
	  }


      }
    if (index == persons.size ())
      {
	System.out.println (id + " does not exists");
	return;
      }


    System.out.println (id + " updated successfully......");


    //writing the resultant arrayList to file.
    try
    {
      //Writing the the ArrayList object to the file
      FileOutputStream file_o_stream = new FileOutputStream (fileName);
      ObjectOutputStream object_o_stream =
	new ObjectOutputStream (file_o_stream);
      object_o_stream.writeObject (persons);
      object_o_stream.close ();
      file_o_stream.close ();
    }
    catch (Exception exp)
    {
      System.out.println ("Error caught! " + exp);
    }


    try
    {
      System.out.println ("Contents of file after deletion: ");


      System.out.printf ("%5s|%20s|%15s|%10s|%20s|\n", "ID", "Name",
			 "Phone Num", "DOB", "E mail");
      int i = 0;
    for (Person p:persons)
	{
	  System.out.printf ("%5d|%20s|%15s|%10s|%20s|\n", p.getId (),
			     p.getName (), p.getPhoneNum (), p.getDob (),
			     p.getEmail ());
	  i++;
	}
    }
    catch (Exception exp)
    {
      System.out.println ("Error caught! " + exp);
    }
  }				//End of method deleteInfo()




  //following method updates information of a person to the file
  public static void updateInfo ()
  {
    display ();


    System.out.print ("Please enter ID of person to update..");
    int id = reader.nextInt ();
    reader.nextLine ();


    int index = 0;
    for (index = 0; index < persons.size (); index++)
      {
	if (persons.get (index).getId () == id)
	  {
	    //update the object from the ArrayList
	    System.out.print ("Please enter updated name: ");
	    String name = reader.nextLine ();
	    persons.get (index).setName (name);


	    System.out.print ("Please enter updated phone number: ");
	    String phoneNum = reader.nextLine ();
	    persons.get (index).setPhoneNum (phoneNum);


	    System.out.print ("Please enter updated date of birth: ");
	    String dob = reader.nextLine ();
	    persons.get (index).setDob (dob);


	    System.out.print ("Please enter updated e-mail address: ");
	    String email = reader.nextLine ();
	    persons.get (index).setEmail (email);
	    break;
	  }


      }
    if (index == persons.size ())
      {
	System.out.println (id + " does not exists");
	return;
      }


    System.out.println (id + " deleted successfully......");


    //writing the resultant arrayList to file.
    try
    {
      //Writing the the ArrayList object to the file
      FileOutputStream file_o_stream = new FileOutputStream (fileName);
      ObjectOutputStream object_o_stream =
	new ObjectOutputStream (file_o_stream);
      object_o_stream.writeObject (persons);
      object_o_stream.close ();
      file_o_stream.close ();
    }
    catch (Exception exp)
    {
      System.out.println ("Error caught! " + exp);
    }


    try
    {
      System.out.println ("Contents of file after updation: ");


      System.out.printf ("%5s|%20s|%15s|%10s|%20s|\n", "ID", "Name",
			 "Phone Num", "DOB", "E mail");
      int i = 0;
    for (Person p:persons)
	{
	  System.out.printf ("%5d|%20s|%15s|%10s|%20s|\n", p.getId (),
			     p.getName (), p.getPhoneNum (), p.getDob (),
			     p.getEmail ());
	  i++;
	}
    }
    catch (Exception exp)
    {
      System.out.println ("Error caught! " + exp);
    }
  }				//End of method updateInfo()




  public static void main (String[]args)
  {
    char ch;			//stores the choice of the user


    do
      {
	System.out.println ("\n\n*******Menu**********");
	System.out.println ("1) Add Information into file");
	System.
	  out.println ("2) Retrieve Information from file and display it");
	System.out.println ("3) Delete Information from file");
	System.out.println ("4) Update Information to file");
	System.out.println ("5) Exit");
	System.out.print ("Please enter your choice:  ");
	ch = reader.next ().charAt (0);
	reader.nextLine ();	//consumes the next line character


	switch (ch)
	  {
	  case '1':
	    addInfo ();
	    break;


	  case '2':
	    display ();
	    break;


	  case '3':
	    deleteInfo ();
	    break;


	  case '4':
	    updateInfo ();
	    break;


	  case '5':
	    System.out.println ("Good Bye....");
	    break;


	  default:
	    System.out.println ("Invalid choice......");
	    break;


	  }			//End of switch statement
      }
    while (ch != '5');
  }				//End of main() method
}				//End of Main class