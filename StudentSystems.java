package InformationSystems;

import java.awt.BorderLayout;
import java.awt.GridLayout; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.util.ArrayList;


public class StudentSystems extends JFrame{
    //declaration and creation of student array-list
	private ArrayList<Student> stu = new ArrayList<Student>();
	
	//panels
	private JFrame frame = new JFrame();
	private JPanel panelNewStudent = new JPanel();
	private JPanel panelAddStudent = new JPanel();
	private JPanel panelButtons = new JPanel();
	private JPanel panelShowStudent = new JPanel();
	private JPanel panelModules = new JPanel(new GridLayout(2, 1));  //panelModules layout is GridLayout of one column and two rows
	private JPanel panelCheckBoxes = new JPanel(new GridLayout(0, 1)); //panelCheckBoxes layout is GridLayout with one column and zero row
	//labels
	private JLabel nameLabel = new JLabel("Name: ");
	private JLabel addressLabel = new JLabel("Address: ");
	private JLabel studentListLabel = new JLabel();
	//text-fields
	private JTextField nameTextField = new JTextField("Peter Smith");
	private JTextField addressTextField = new JTextField("35 Liffey Street, Dublin 2.");
	//text areas
	private JTextArea showStudentTextArea = new JTextArea();
	private JTextArea modulesTextArea = new JTextArea();
	//buttons
	private JButton submitButton = new JButton("Submit");
	private JButton clearButton = new JButton("Clear");
	private JButton finishButton = new JButton("Finish");
	private JButton clearAllButton = new JButton("Clear All");
	
	//check-boxes
	private JCheckBox databasesCheckBox = new JCheckBox("Databases", false);
	private JCheckBox javaCheckBox = new JCheckBox("Java", false);
	private JCheckBox accountancyCheckBox = new JCheckBox("Accountancy", false);


  public StudentSystems()
  {
	  super("Student Information System");
	  
	  frame.setLayout(new BorderLayout());              //1.JFrame is organized into a border layout
	  frame.add(panelNewStudent, BorderLayout.CENTER);  //2.Two panels are added to the frame
	  frame.add(panelButtons, BorderLayout.SOUTH);
	  
	  //adds panel to the frame
	  add(panelNewStudent, BorderLayout.CENTER);
	  add(panelButtons, BorderLayout.SOUTH); 
	  
	  panelNewStudent.setBorder(new TitledBorder("New Student"));    //3.panelNewStudent has a TitledBorder 
	  
	  //adds 3 panels to the panelNewStudent
	  panelNewStudent.setLayout(new BorderLayout());              //4. panelNewStudent layout is a BorderLayout.
	  panelNewStudent.add(panelAddStudent, BorderLayout.NORTH);   //It holds three panels– panelAddStudent, panelShowStudent, panelModules 
	  panelNewStudent.add(panelShowStudent, BorderLayout.CENTER); 
	  panelNewStudent.add(panelModules, BorderLayout.EAST); 
	  
	  //7.panelModules hold panelCheckBoxes and a text area.
	  panelModules.add(panelCheckBoxes); 
	  panelModules.add(modulesTextArea); 
	  
	  //5.adds components to the panelAddStudent
	  panelAddStudent.add(nameLabel);
	  panelAddStudent.add(nameTextField);
	  panelAddStudent.add(addressLabel);
	  panelAddStudent.add(addressTextField);
	  panelAddStudent.add(submitButton);
	  panelAddStudent.add(clearButton);

      //adds buttons to the button panel
	  panelButtons.add(finishButton);
	  panelButtons.add(clearAllButton);
	  
	  //6.panelShowStudents has a borderLayout
	  //It has a label StudentList in the north of the border, and textArea ShowStudent in the center.
	  panelShowStudent.setLayout(new BorderLayout()); 
	  panelShowStudent.add(studentListLabel, BorderLayout.NORTH);
	  panelShowStudent.add(showStudentTextArea, BorderLayout.CENTER);
	  
	  //8.panelCheckBoxes holds three check-boxes for different modules.
	  panelCheckBoxes.add(databasesCheckBox);
	  panelCheckBoxes.add(javaCheckBox);  
	  panelCheckBoxes.add(accountancyCheckBox);

	
	//action listener for submit button, name and address should be added to the list called “stu” and the list should be printed in the text area
	  submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() != null)
				{
				// Read the data from the text fields
				String name = nameTextField.getText();
				String address = addressTextField.getText();
		
				// Create a student object using the data
				Student student = new Student(name, address);
				stu.add(student);      //adds new student details to the list 
				showStudentTextArea.append(student.toString() + "\n");   //shows a string of the student details in the showStudentTextArea
				
			}
			}
		});
	  
      
	  //action listener for cancel button should clear the student name and student address fields.
	  clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() != null)
				{
				nameTextField.setText("");
				addressTextField.setText("");
			}
			}
		});
	  
	  
	  //action listener for finish button
	  //9.Finish button should close the window.
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	 //action listener for clear all button
	 //10.Clear All button should clear all the selections (the text fields, the text area and the check boxes).
		clearAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				addressTextField.setText("");  
				showStudentTextArea.setText(null);
				modulesTextArea.setText(null);
				databasesCheckBox.setSelected(false);
				javaCheckBox.setSelected(false);
				accountancyCheckBox.setSelected(false);
			}
		});
	  
     //item listener for databases check box
	  databasesCheckBox.addItemListener(new ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
	    	  if(databasesCheckBox.isSelected()){
	    		  modulesTextArea.append(" \n ");
				  modulesTextArea.append("Databases");
				}
	        }
	   });
	  
	//item listener for java check box
	  javaCheckBox.addItemListener(new ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
	    	  if(javaCheckBox.isSelected()){
	    		  modulesTextArea.append(" \n ");
	    		  modulesTextArea.append("Java");
				}
	        }
	   });
	 
	//item listener for accountancy check box
	  accountancyCheckBox.addItemListener(new ItemListener() {
	      public void itemStateChanged(ItemEvent e) {
	    	  if(accountancyCheckBox.isSelected()){
	    		  modulesTextArea.append(" \n ");
	    		  modulesTextArea.append("Accountancy");
				}
	        }
	   });
	  
	  
	  setSize(500, 400);
	  setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  	  
  }
	
  //main method
  public static void main(String[]args)
  {
	new StudentSystems();
  }
	
	

	



	


}
