package InformationSystems;


public class Student {
	
   private String name;
   private String address;
   
   public Student()
   {
	   this.name = "";
	   this.address = "";
	     }
   
public Student(String name, String address) {
	this.name = name;
	this.address = address;
}

//getters and setters
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

//toString representation of the student names and addresses
public String toString() {
	return  name + "," +  " " + address ;
}

}
