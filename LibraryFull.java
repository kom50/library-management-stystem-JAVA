import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
public class LibraryFull extends JFrame implements ActionListener{
	//connection database
	Connection con = null;
	Statement smt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Label errorMessage;
	//Main panel components
	//Panel loginPanel;
	JLabel userLabel, passLabel;
	TextField userText;
	TextField passText;
	JButton login;
	//main page panel components
	//Panel mainPage;
	JButton bookPageOpen, studentPageOpen, bookIssuePageOpen, bookReturnPageOpen, exitButton;
	//for all page
	JPanel centerPanel,  leftSidePanel,  rightSidePanel, rightSideComponentPanel;
	//For book management page
	JButton addButton, showButton, deleteButton, searchButton, updateButton, backButton;
    //
	Font f1;
	// For change color of button
	JButton prev = new JButton(); // color 
	//Issue book Components 
	JButton addIssueBookButton,  showIssueBookButton;
	//For reset button
    int pageNo = 0; 
	//issue book form componenets
	JButton submitIssuedButton;
	JLabel issuedDateLabel;
	JTextField issuedDateField;
	//Return book form componenets
	JLabel returnDateLabel;
	JTextField returnDateField;
	JButton submitReturnButton;
	
	//Student management page componenets
	JButton addSButton; 
	JButton showSButton;
	JButton deleteSButton;
	JButton searchSButton;
	JButton updateSButton;
	
	//student page components
	JLabel sRollNoLabel;
	JLabel sNameLabel;
	JLabel sClassLabel;
    JLabel sGenderLabel;
	JLabel sAddressLabel; 
	JLabel sMobileNoLabel;
	
	JTextField sRollNoField;
	JTextField sNameField;
    JTextField	sClassField;
	JTextField sGenderField;
	JTextField sAddressField;
	JTextField	sMobileNoField;	
    JButton submitSButtonAdd;
	JRadioButton ml, fml;
	ButtonGroup bg;
	
	private void issueBookDetails() {
        //left side components
		leftSidePanel = new JPanel();
		leftSidePanel.setVisible(true);
		leftSidePanel.setLayout(new GridBagLayout());
		leftSidePanel.setBackground(Color.gray);
	    gb = new GridBagConstraints();
	    gb.insets = new Insets(10, 10, 10, 10);
	   
		pageMessageName("ISSUE BOOK"); // Page Message
		rightSidePanel = new JPanel();
		rightSidePanel.setVisible(true);
		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.setBackground(Color.gray);
		
		centerPanel.add(leftSidePanel, BorderLayout.WEST);
		centerPanel.add(rightSidePanel, BorderLayout.CENTER);
		
		addIssueBookButton  = new JButton("Issue Book Details");
		showIssueBookButton  = new JButton("Show All Issue Books Details");
		backButton  = new JButton("Back");
		
		leftSidePanel.setPreferredSize(new Dimension(400, 100));
		addIssueBookButton.setPreferredSize(new Dimension(320, 35));
		showIssueBookButton.setPreferredSize(new Dimension(320, 35));
		backButton.setPreferredSize(new Dimension(320, 35));
		
		addIssueBookButton.setBackground(Color.white); showIssueBookButton.setBackground(Color.white);
		backButton.setBackground(Color.white);
        
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 2; gb.gridx = 0; leftSidePanel.add(new JSeparator(), gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 3; gb.gridx = 0; leftSidePanel.add(addIssueBookButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 4; gb.gridx = 0;  leftSidePanel.add(showIssueBookButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 5; gb.gridx = 0;  leftSidePanel.add(backButton, gb);
		
		addIssueBookButton.setFont(f1); showIssueBookButton.setFont(f1); backButton.setFont(f1);
		leftSidePanel.setFont(f1);
		addIssueBookButton.addActionListener(this);showIssueBookButton.addActionListener(this);
		backButton.addActionListener(this);	
	}
	
	private void addIssueBookDetailsForm() {
		 pageNo = 10;
		 rightSideComponentPanel = new JPanel();
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 
		 rightSideComponentPanel.setBackground(Color.gray);
		 sRollNoLabel = new JLabel("Student Roll No.* : ");  sNameLabel = new JLabel("Student Name : ");
		 bookIdLabel = new JLabel("Book Id* : "); bookTitleLabel = new JLabel("Book Title : ");
		 issuedDateLabel = new JLabel("Issue Date* : ");
		 
		 headerText("Add Issued Book Details");
		 message("Enter following student and book details for issue book : ");
		 errorMessage(" ");
		 sRollNoField = new JTextField();  sNameField = new JTextField();
		 bookIdField = new JTextField();  bookTitleField = new JTextField();
		 issuedDateField = new JTextField();		  resetButton = new JButton("Reset");
		 submitIssuedButton = new JButton("Add Record");
		 sNameField.setEnabled(false);		  bookTitleField.setEnabled(false);
		 issuedDateField.setToolTipText("Ex. : 01-Jan-2020");
		 JLabel dateStyle  = new JLabel("Ex. : 01-Jan-2020");
		 
		 resetButton.setBackground(Color.white); submitIssuedButton.setBackground(Color.white);
		 
		 sRollNoLabel.setFont(f1);  sNameLabel.setFont(f1);  bookIdLabel.setFont(f1);
		 bookTitleLabel.setFont(f1);  issuedDateLabel.setFont(f1);
		 sRollNoField.setFont(f1); sNameField.setFont(f1); 	 bookIdField.setFont(f1);
		 bookTitleField.setFont(f1);  issuedDateField.setFont(f1);  dateStyle.setFont(f1);
		 
		 sRollNoField.setPreferredSize(new Dimension(200, 25));
		 resetButton.setFont(f1);
		 submitIssuedButton.setFont(f1);
		 
		 sRollNoLabel.setForeground(Color.white); sNameLabel.setForeground(Color.white);
		 bookIdLabel.setForeground(Color.white);  bookTitleLabel.setForeground(Color.white);
		 issuedDateLabel.setForeground(Color.white);  dateStyle.setForeground(Color.white);
		
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx = 0; rightSideComponentPanel.add(bookIdLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx = 0; rightSideComponentPanel.add(bookTitleLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx = 0; rightSideComponentPanel.add(sRollNoLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx = 0; rightSideComponentPanel.add(sNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx = 0; rightSideComponentPanel.add(issuedDateLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		// gb.gridy = 4; gb.gridx = 2; rightSideComponentPanel.add(dateStyle, gb);
		 
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx = 1; rightSideComponentPanel.add(bookIdField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx = 1; rightSideComponentPanel.add(bookTitleField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx = 1; rightSideComponentPanel.add(sRollNoField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx = 1; rightSideComponentPanel.add(sNameField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx = 1; rightSideComponentPanel.add(issuedDateField, gb);
		  gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 5; gb.gridx = 0; gb.gridwidth = 2; rightSideComponentPanel.add(new JSeparator(), gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 6; gb.gridx = 0; gb.gridwidth = 1;  rightSideComponentPanel.add(resetButton, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 6; gb.gridx = 1; rightSideComponentPanel.add(submitIssuedButton, gb);
		 
         resetButton.addActionListener(this); submitIssuedButton.addActionListener(this);
		 sRollNoField.addKeyListener(new CheckNumber()); bookIdField.addKeyListener(new CheckNumber());
	}
	// show issue book details of issuebook table
	private void showIssueBookDetailsForm(){
    	 rightSideComponentPanel = new JPanel();
    	 rightSideComponentPanel.setVisible(true);
    	 rightSideComponentPanel.setLayout(new GridLayout(1, 1));
    	 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("All issue book Details");
         message("All issue book details: ");
		 	String data[][] = new String[50][7];	
			try{
			String q1 = "select *from "+studentTableName+", "+bookTableName+", "+issueTableName+" where "+issueTableName+".bookid = "+bookTableName+".bookid and "+issueTableName+".rollno = "+studentTableName+".rollno"; 
			ResultSet rs = smt.executeQuery(q1); 
			if (rs.next()) 
			 {   
			  int i = 0;
			  do{   
				 data[i][0] = Integer.toString(rs.getInt("rollno"));
				 data[i][1] = rs.getString("Name");
				 data[i][2] = rs.getString("mobileno");
                 data[i][3] = rs.getString("bookid");
				 data[i][4] = rs.getString("booktitle");
				 data[i][5] = rs.getString("issuedate").substring(0, 10);
				 data[i][6] = String.valueOf(rs.getInt("totalbook"));
				 i++;
				}while(rs.next());	
			   errorMessage( "Total Number of issued books : "+i );
			}
			else
			{ 
		        errorMessage("Data is not available");
			}
			}
			catch(Exception e2){
			  System.out.println("Show time error : "+e2);
			}
		JTable table1;
		String heading[] = {"Roll No.","Student Name", "Mobile No.","Book Id","Book Title", "issued Date",  "Total Books"};
	 	table1 = new JTable(data, heading);
		table1.setFont(f1);
		table1.setRowHeight(25);
		table1.setEnabled(false); //
		//table1.setBackground(Color.RED);
		JScrollPane s = new JScrollPane(table1);
		rightSideComponentPanel.add(s); // add table on showBookFrom panel
   		rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
    }
	void gridBagConstraints(){
		
	}
	//Panel bookDetails;
	//RETURN book Components 
	JButton addReturnBookButton;
	JButton showReturnBookButton;
	private void returnBookDetails() {
        //left side components
		leftSidePanel = new JPanel();
		leftSidePanel.setVisible(true);
		leftSidePanel.setLayout(new GridBagLayout());
		gb = new GridBagConstraints();
		gb.insets = new Insets(10, 10, 10, 10); 
		leftSidePanel.setBackground(Color.gray);
		pageMessageName("Return Book "); // page name
		addReturnBookButton  = new JButton("Return Book Details");
		showReturnBookButton  = new JButton("Show All Returned Books Details");
		backButton  = new JButton("Back");
		rightSidePanel = new JPanel();
		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.setVisible(true);
		rightSidePanel.setBackground(Color.gray);
		leftSidePanel.setFont(f1);
		
		centerPanel.add(leftSidePanel, BorderLayout.WEST);
		centerPanel.add(rightSidePanel, BorderLayout.CENTER);
		addReturnBookButton.setBackground(Color.white); showReturnBookButton.setBackground(Color.white);
		backButton.setBackground(Color.white);
		
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 1; gb.gridx = 0;	leftSidePanel.add(new JSeparator(), gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 2; gb.gridx = 0;	leftSidePanel.add(addReturnBookButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 3; gb.gridx = 0; leftSidePanel.add(showReturnBookButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 4; gb.gridx = 0; leftSidePanel.add(backButton, gb);
		
		addReturnBookButton.setFont(f1); showReturnBookButton.setFont(f1); backButton.setFont(f1);
		leftSidePanel.setPreferredSize(new Dimension(400, 100));
		addReturnBookButton.setPreferredSize(new Dimension(350, 35));
		addReturnBookButton.addActionListener(this);showReturnBookButton.addActionListener(this);
		backButton.addActionListener(this);	
	}
	
	private void addReturnBookDetailsForm() {
		 pageNo = 11;
		 rightSideComponentPanel = new JPanel(); 
		 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 rightSideComponentPanel.setBackground(Color.gray);
		 
		 sRollNoLabel = new JLabel("Student Roll No.* : "); sNameLabel = new JLabel("Student Name* : ");
		 bookIdLabel = new JLabel("Book Id* : ");  bookTitleLabel = new JLabel("Book Title* : ");
		 returnDateLabel = new JLabel("Return Date* : "); issuedDateLabel = new JLabel("Issue Date* : ");
		 
		 headerText("Add Return Book Details");
		 message("Enter following student and book details for return book : ");
		 errorMessage(" ");
		 sRollNoField = new JTextField(); sNameField = new JTextField();
		 bookIdField = new JTextField();  bookTitleField = new JTextField();
		 returnDateField = new JTextField(); issuedDateField = new JTextField();
		 resetButton = new JButton("Reset");
		 submitReturnButton = new JButton("Add Record");
		 
		 sNameField.setEnabled(false);  bookTitleField.setEnabled(false);
		 sRollNoField.setEnabled(false); issuedDateField.setEnabled(false);
		 JLabel dateStyle  = new JLabel("Ex. : 01-Jan-2020");
		 
		 sRollNoLabel.setFont(f1);  sNameLabel.setFont(f1);  bookIdLabel.setFont(f1);
		 bookTitleLabel.setFont(f1);  returnDateLabel.setFont(f1); issuedDateLabel.setFont(f1);
		 dateStyle.setFont(f1);
		 sRollNoField.setFont(f1);  sNameField.setFont(f1);  bookIdField.setFont(f1);
		 bookTitleField.setFont(f1);  returnDateField.setFont(f1);  issuedDateField.setFont(f1);
	     resetButton.setFont(f1);  submitReturnButton.setFont(f1);
		 
		 sRollNoLabel.setForeground(Color.white);  sNameLabel.setForeground(Color.white);
		 bookIdLabel.setForeground(Color.white);  bookTitleLabel.setForeground(Color.white);
		 returnDateLabel.setForeground(Color.white); issuedDateLabel.setForeground(Color.white);
		 dateStyle.setForeground(Color.white);  submitReturnButton.setBackground(Color.white);
		 resetButton.setBackground(Color.white);
		 
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx = 0; rightSideComponentPanel.add(bookIdLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx = 0; rightSideComponentPanel.add(bookTitleLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx = 0; rightSideComponentPanel.add(sRollNoLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx = 0; rightSideComponentPanel.add(sNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx = 0; rightSideComponentPanel.add(issuedDateLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 5; gb.gridx = 0; rightSideComponentPanel.add(returnDateLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 5; gb.gridx = 2; rightSideComponentPanel.add(dateStyle, gb);
		 
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx = 1; rightSideComponentPanel.add(bookIdField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx = 1; rightSideComponentPanel.add(bookTitleField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx = 1; rightSideComponentPanel.add(sRollNoField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx = 1; rightSideComponentPanel.add(sNameField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx = 1; rightSideComponentPanel.add(issuedDateField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 5; gb.gridx = 1; rightSideComponentPanel.add(returnDateField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 6; gb.gridx = 0; gb.gridwidth = 2; rightSideComponentPanel.add(new JSeparator(), gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 7; gb.gridx = 0; gb.gridwidth = 1;  rightSideComponentPanel.add(resetButton, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 7; gb.gridx = 1; rightSideComponentPanel.add(submitReturnButton, gb);
         
         resetButton.addActionListener(this);  submitReturnButton.addActionListener(this);
	     bookIdField.addKeyListener(new CheckNumber());
	}
	// show issue book details of issuebook table
	private void showReturnBookDetailsForm(){
    	 rightSideComponentPanel = new JPanel();
    	 rightSideComponentPanel.setVisible(true);
    	 rightSideComponentPanel.setLayout(new GridLayout(1, 1));
    	 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("All return book Details");
         message("All return book details: ");
		 String data[][] = new String[50][6];	
		 try{
		 String q1 = "select *from "+returnTableName; 
		 ResultSet rs = smt.executeQuery(q1); 
		 if (rs.next()) 
		  {   
			int i = 0;
			do{   
				 data[i][0] = Integer.toString(rs.getInt("bookid"));
				 data[i][1] = rs.getString("bookname");
				 data[i][2] = Integer.toString(rs.getInt("rollno")); //rs.getString("rollno");
                 data[i][3] = rs.getString("name");
				 data[i][4] = rs.getString("issuedate").substring(0, 10);
				 data[i][5] = rs.getString("returndate").substring(0, 10);
				 i++;
			  }while(rs.next());	
			  errorMessage("Total Number of returned books : "+i );
			}
		else
		 { 
		    errorMessage("Data is not available");
		 }
		}
		catch(Exception e2){
		  System.out.println("Show time error : "+e2);
		}
		JTable table1;
		String heading[] = {"Book Id", "Book Title", "Roll No.","Student Name", "issued Date",  "Return date"};
	 	table1 = new JTable(data, heading);
		table1.setFont(f1);
		table1.setRowHeight(25);
		JScrollPane s = new JScrollPane(table1);
		rightSideComponentPanel.add(s); // add table on showBookFrom panel
   		rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
    }
	
	
	private void studentManagementDetails() {
        //left side components
		leftSidePanel = new JPanel();
		rightSidePanel = new JPanel();
		
		leftSidePanel.setVisible(true);
		leftSidePanel.setLayout(new GridBagLayout());
		gb = new GridBagConstraints();
		gb.insets = new Insets(10, 10, 10, 10);
		
		leftSidePanel.setBackground(Color.gray);
		pageMessageName("Student Management"); //Page name
		addSButton  = new JButton("Add Student Details");
		showSButton  = new JButton("Show All Student Details");
		deleteSButton  = new JButton("Delete Student Details");
		searchSButton  = new JButton("Search Student Details");
		updateSButton  = new JButton("Update Student Details");
		backButton  = new JButton("Back");
		
		centerPanel.add(leftSidePanel, BorderLayout.WEST);
		centerPanel.add(rightSidePanel, BorderLayout.CENTER);
		
		addSButton.setBackground(Color.white); showSButton.setBackground(Color.white);
		deleteSButton.setBackground(Color.white); searchSButton.setBackground(Color.white);
		updateSButton.setBackground(Color.white); backButton.setBackground(Color.white);
		
		rightSidePanel.setVisible(true);
		rightSidePanel.setLayout(new BorderLayout());
		rightSidePanel.setBackground(Color.gray);
		
		leftSidePanel.setFont(f1); addSButton.setFont(f1); showSButton.setFont(f1);
		deleteSButton.setFont(f1); searchSButton.setFont(f1); updateSButton.setFont(f1);
		backButton.setFont(f1);
		
	    gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 1; gb.gridx =  0; leftSidePanel.add(new JSeparator(), gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 2; gb.gridx =  0; leftSidePanel.add(addSButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 4; gb.gridx =  0; leftSidePanel.add(deleteSButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 3; gb.gridx =  0; leftSidePanel.add(showSButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 5; gb.gridx =  0; leftSidePanel.add(searchSButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 6; gb.gridx =  0; leftSidePanel.add(updateSButton, gb);
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 7; gb.gridx =  0; leftSidePanel.add(backButton, gb);
		
	    leftSidePanel.setPreferredSize(new Dimension(400, 100));
		addSButton.setPreferredSize(new Dimension(300, 35));
		
		addSButton.addActionListener(this); showSButton.addActionListener(this);
		deleteSButton.addActionListener(this); searchSButton.addActionListener(this);
		updateSButton.addActionListener(this); backButton.addActionListener(this);	
	}
    
	private void addStudentDetailsForm() {
		 pageNo = 6;
		 rightSideComponentPanel = new JPanel();
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints(); 
		 gb.insets = new Insets(10, 10, 10, 10);
		 rightSideComponentPanel.setBackground(Color.gray);
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 
		 sRollNoLabel = new JLabel("Roll No.* : "); sNameLabel = new JLabel("Name* : ");
		 sClassLabel = new JLabel("Class : ");  sGenderLabel = new JLabel("Gender* : ");
		 sAddressLabel = new JLabel("Address* : ");  sMobileNoLabel = new JLabel("Mobile No.* : ");
		 
		 bg = new ButtonGroup();
		 ml = new JRadioButton("A) Male", true);  fml = new JRadioButton("B) Female", false);
		 bg.add(ml); bg.add(fml);
		 JPanel genderPanel = new JPanel();
		 genderPanel.add(ml);  genderPanel.add(fml);
		 
		 headerText("Add Student Details");
		 message("Enter following student details to add a student : ");
		 errorMessage(" ");
		 sRollNoField = new JTextField();  sNameField = new JTextField();  sClassField = new JTextField();
		 sGenderField = new JTextField();  sAddressField = new JTextField();
		 sMobileNoField = new JTextField();
		 resetButton = new JButton("Reset"); submitSButtonAdd = new JButton("Add Record");
		 sClassField.setText(semesterName);
		 //disable class field
		 sClassField.setEnabled(false);
		// set Font style
		 sRollNoLabel.setFont(f1);  sNameLabel.setFont(f1);  sClassLabel.setFont(f1);
		 sGenderLabel.setFont(f1); sAddressLabel.setFont(f1);  sMobileNoLabel.setFont(f1);
		 sRollNoField.setFont(f1); sNameField.setFont(f1);  sClassField.setFont(f1);
		 ml.setFont(f1);  fml.setFont(f1);  sAddressField.setFont(f1);  sMobileNoField.setFont(f1);
		 resetButton.setFont(f1);  submitSButtonAdd.setFont(f1);
		 
		 sRollNoLabel.setForeground(Color.white);  sNameLabel.setForeground(Color.white);
		 sClassLabel.setForeground(Color.white);  sGenderLabel.setForeground(Color.white);
		 sAddressLabel.setForeground(Color.white);  sMobileNoLabel.setForeground(Color.white);
		 resetButton.setBackground(Color.white);  submitSButtonAdd.setBackground(Color.white);
		
		 sRollNoLabel.setPreferredSize(new Dimension(200, 30));
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 0; rightSideComponentPanel.add(sRollNoLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 1; gb.gridx = 0; rightSideComponentPanel.add(sNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 2; gb.gridx = 0; rightSideComponentPanel.add(sClassLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 3; gb.gridx = 0; rightSideComponentPanel.add(sGenderLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 4; gb.gridx = 0; rightSideComponentPanel.add(sAddressLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 5; gb.gridx = 0; rightSideComponentPanel.add(sMobileNoLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 1; rightSideComponentPanel.add(sRollNoField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 1; gb.gridx = 1; rightSideComponentPanel.add(sNameField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 2; gb.gridx = 1; rightSideComponentPanel.add(sClassField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 3; gb.gridx = 1; rightSideComponentPanel.add(genderPanel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 4; gb.gridx = 1; rightSideComponentPanel.add(sAddressField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 5; gb.gridx = 1;  rightSideComponentPanel.add(sMobileNoField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 6;gb.gridx = 0;gb.gridwidth = 2;rightSideComponentPanel.add(new JSeparator(), gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 7; gb.gridx = 0; gb.gridwidth = 1; rightSideComponentPanel.add(resetButton, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 7; gb.gridx = 1; rightSideComponentPanel.add(submitSButtonAdd, gb);
         
         resetButton.addActionListener(this); submitSButtonAdd.addActionListener(this);
		 sRollNoField.addKeyListener(new CheckNumber()); sMobileNoField.addKeyListener(new CheckNumber());
	}
	boolean flagK; // for check a entered data is number or not
    boolean flagR; //
    int totalBooks; 	// holds total number of books
	class CheckNumber extends KeyAdapter {
		public void keyReleased(KeyEvent ke){
			flagK = true;
			String text;
			Object keyObj = ke.getSource();
			if(keyObj == sRollNoField){
				text = sRollNoField.getText().trim();
				System.out.println("Hello JAVA");
				flagK = true;
				for(int i = 0 ; i < text.length(); i++){
				   if(text.codePointAt(i) < 48 || text.codePointAt(i) > 57){
					   errormsgLabel.setText(errormsgLabel.getText()+ " Invalid Roll No.");
                       flagK = false;				  
				  }
				}
				if(text.equals("")){ 
					 sNameField.setText(" ");
					 errormsgLabel.setText(" ");
				 }
				if(flagK == true) {
					errormsgLabel.setText(" ");
					if(pageNo == 10){
					  System.out.println("Page number : 10");
					  try{
					    ResultSet rs = smt.executeQuery("select name, totalbook from "+studentTableName +" where rollno = "+text);
						if(rs.next()){
						    sNameField.setText(rs.getString("name"));
							totalBooks = rs.getInt("totalbook");
							System.out.println(" IS found  "+rs.getString("name")+" Total books issue "+rs.getInt("totalbook"));
							if(totalBooks >= 3){
							   System.out.println("Already issued three books.");
							   errormsgLabel.setText("Already issued three books.");  
							}
						}
						else{
							System.out.println("Roll No. Is not Found");
							sNameField.setText(" ");
						    errormsgLabel.setText("Roll No. is not found.");
						  }
						}
					   catch(Exception e){
					   
					   }
				    }
			     }
			}
			// Book id check for issue book 
			if(pageNo == 10){
			 if(keyObj == bookIdField){
			   System.out.println("Page number : 10");
			   text = bookIdField.getText().trim().toUpperCase();
			   try{
				   if(text.equals("")){ 
					 bookTitleField.setText(" ");
				     errormsgLabel.setText(" ");
				   }
			      System.out.println("Book id is "+text);
				  ResultSet rs = smt.executeQuery("select booktitle , bookissue from "+bookTableName+" where bookid = "+text);
				  if(rs.next()){
					System.out.println("Book iS found  "+rs.getString("booktitle")+"  "+rs.getString("bookissue"));
				    bookTitleField.setText(rs.getString("booktitle"));
					errormsgLabel.setText(" ");
					if((rs.getString("bookissue")).equals("YES")) {
						 flagR = false;
						 errormsgLabel.setText("Book is issued");
					}
					else
						flagR = true;
				  }
				  else{
					 System.out.println("Book Is not Found");
					 bookTitleField.setText(" ");
					 errormsgLabel.setText("Book id is not found.");
				   }
				 }
				 catch(Exception e){		   }
			  } 
			}
			// Book id check for return book  completed
			if(pageNo == 11){
			 if(keyObj == bookIdField){
			   System.out.println("Return book Page number : 11");
			   text = bookIdField.getText().trim().toUpperCase();
			   try{
				   if(text.equals("")){ 
					 bookTitleField.setText(" ");
				     errormsgLabel.setText(" ");
				   }
			      System.out.println("Book id is "+text);
				  ResultSet rs = smt.executeQuery("select rollno, issuedate from "+issueTableName+" where bookid = "+text);
				  if(rs.next()){
					  sRollNoField.setText(rs.getString("rollno"));
					  String roll = rs.getString("rollno");
					  issuedDateField.setText(rs.getDate("issuedate").toString());
					  rs = smt.executeQuery("select booktitle from "+bookTableName+" where bookid = "+text);
					  if(rs.next())
					    bookTitleField.setText(rs.getString("booktitle"));
					    rs = smt.executeQuery("select name from "+studentTableName+" where rollno = "+roll);
					  if(rs.next())
					    sNameField.setText(rs.getString(1));
					 errormsgLabel.setText(" ");
					
				  }
				  else{
					 System.out.println("Book Is not Found");
					 bookTitleField.setText(" ");
					 sRollNoField.setText(" ");
					 issuedDateField.setText(" ");
					 sNameField.setText(" ");
					 errormsgLabel.setText("Book id is not found.");
				   }
				 }
				 catch(Exception e){
					System.out.println(e);
				}
			  } 
			}
			// check a given mobile number is valid or not 
			if(keyObj == sMobileNoField){
				text = sMobileNoField.getText().trim();
				flagK = true;
				for(int i = 0 ; i < text.length(); i++){
				   if(text.codePointAt(i) < 48 || text.codePointAt(i) > 57){
					     errormsgLabel.setText(errormsgLabel.getText()+ "  Invalid Mobile No.");
					     flagK = false;
				   }
				}
				if(flagK == true){
					if(text.length() == 10)
					  errormsgLabel.setText(" ");
				  else
					  errormsgLabel.setText("Invalid Mobile No.");
				}
			}
		}
	}
    private void showStudentDetailsForm(){
    	 rightSideComponentPanel = new JPanel();
    	 rightSideComponentPanel.setVisible(true);
    	 rightSideComponentPanel.setLayout(new GridLayout(1, 1));
    	 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("All Student Details");
         message("All Student details: ");
			String data[][] = new String[50][7];	
			try{
			String q1 = "select * from "+studentTableName+" ORDER BY rollno ASC"; 
			//String total="SELECT COUNT(*) FROM student ORDER BY rollno ASC"; // for count rows in table
			ResultSet rs = smt.executeQuery(q1); 
			if (rs.next()) 
			{   
			 int i = 0;
			 do{ 
				//System.out.println( rs.getString(2)+"\t\t" + rs.getInt("rollno")+"\t"+ rs.getString(3));  
				 data[i][0] = Integer.toString(rs.getInt("rollno"));
				 data[i][1] = rs.getString("Name");
				 data[i][2] = rs.getString("clas");
                 data[i][3] = rs.getString("gender");
				 data[i][4] = rs.getString("address");
				 data[i][5] = rs.getString("mobileno");
				 data[i][6] = String.valueOf(rs.getInt("totalbook"));
				 i++;
				}while(rs.next());	
			errorMessage("Total Number of students : "+i);
			System.out.println("Total number of student details = "+i+" - "+smt.getMaxRows()); 
			}
			else
			{ 
		        errorMessage("Data is not available");
				System.out.println("No such user id is already registered"); 
			}
			}
			catch(Exception e2){
			  System.out.println("Show time error : "+e2);
			}
			JTable table1;
			String heading[] = {"Roll No.","Name", "Class","Gender","Address",  "Mobile No.",  "Total Books"};
			table1 = new JTable(data, heading);
			//table1.setBounds(10, 30, 200, 150);
			table1.setFont(f1);
			table1.setRowHeight(25);
			JScrollPane s = new JScrollPane(table1);
		  
			rightSideComponentPanel.add(s); // add table on showBookFrom panel
   		    rightSidePanel.add(rightSideComponentPanel);
    }
    
	JButton submitSButtonDelete;
    private void deleteStudentDetailsForm() {
		 pageNo = 7;
		 rightSideComponentPanel = new JPanel();
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 rightSideComponentPanel.setBackground(Color.gray);
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 
		 headerText("Delete Student Details");
		 message("Enter following details to delete student details : ");
		 errorMessage(" ");
		 sRollNoLabel = new JLabel("Roll No. * : ");
		 sNameLabel = new JLabel("Name* : ");
		 sRollNoField = new JTextField();
		 sNameField = new JTextField();
		 submitSButtonDelete = new JButton("Delete Record");
		 sRollNoField.setPreferredSize(new Dimension(200, 25));
		 
		 sRollNoLabel.setFont(f1); sNameLabel.setFont(f1);  sRollNoField.setFont(f1);
		 sNameField.setFont(f1);submitSButtonDelete.setFont(f1);
		 
		 sRollNoLabel.setForeground(Color.white);  sNameLabel.setForeground(Color.white);
		 submitSButtonDelete.setBackground(Color.white);
		  
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 0; rightSideComponentPanel.add(sRollNoLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 1; gb.gridx = 0;  rightSideComponentPanel.add(sNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 1;  rightSideComponentPanel.add(sRollNoField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 1; gb.gridx = 1;  rightSideComponentPanel.add(sNameField, gb); 
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 2; gb.gridx = 0; gb.gridwidth= 2; rightSideComponentPanel.add(new JSeparator(), gb); 
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 3; gb.gridx = 0;  rightSideComponentPanel.add(submitSButtonDelete, gb);
        
         submitSButtonDelete.addActionListener(this);
         sRollNoField.addKeyListener(new CheckNumber());		 
    }
   // Panel rightSideComponentPanel;  
    JButton submitSButtonSearch;
    private void searchStudentDetailsForm() {
		 pageNo = 8;
    	 rightSideComponentPanel = new JPanel();
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new BorderLayout(5, 5));
		 JPanel right1 = new JPanel();
         rightSideComponentPanel.add(right1, BorderLayout.NORTH);
		 right1.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 right1.setBackground(Color.gray);
		 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("Search Student Details");
		 message("Enter Roll No., Name or address to search student details :");
		 errorMessage(" ");
		 sRollNoLabel = new JLabel("Roll No. : ");
		 sNameLabel = new JLabel("S. Name : ");
		 sAddressLabel = new JLabel("Address : ");
		 
		 sAddressField = new JTextField(); sRollNoField = new JTextField(); sNameField = new JTextField();
		 submitSButtonSearch= new JButton("Search Record");
		 sRollNoField.setPreferredSize(new Dimension(200, 25)); 
		 sRollNoLabel.setFont(f1); sNameLabel.setFont(f1); 
		 sAddressLabel.setFont(f1); sAddressField.setFont(f1);
		 sRollNoField.setFont(f1);sNameField.setFont(f1); submitSButtonSearch.setFont(f1);
		 sRollNoLabel.setForeground(Color.white); sNameLabel.setForeground(Color.white);
		 sAddressLabel.setForeground(Color.white);
		 submitSButtonSearch.setBackground(Color.white);
		 
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =0 ; gb.gridx = 0; right1.add(sRollNoLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =1 ; gb.gridx = 0; right1.add(sNameLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =0 ; gb.gridx = 1; right1.add(sRollNoField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =2 ; gb.gridx = 0; right1.add(sAddressLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =1 ; gb.gridx = 1;  right1.add(sNameField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =2 ; gb.gridx = 1; right1.add(sAddressField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =3 ; gb.gridx = 0; gb.gridwidth = 2; right1.add(new JSeparator(), gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
	     gb.gridy =4 ; gb.gridx = 0;  right1.add(submitSButtonSearch, gb);
         submitSButtonSearch.addActionListener(this);
    }
    JButton submitSButtonUpdate;
    int updateCheckbox;
    private void updateStudentDetailsForm(){
		 pageNo = 9;
		 updateCheckbox = 2;
    	 rightSideComponentPanel = new JPanel();
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
    	 rightSideComponentPanel.setBounds(56, 30, 790, 550);
    	 rightSideComponentPanel.setVisible(true);
    	 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
    	 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("Update Student Details");
		 message("Enter the Roll No. of the student to be modified");
		 errorMessage(" ");
		 sRollNoLabel = new JLabel("Roll No. : ");
		 sRollNoField = new JTextField();
		 cBox1 = new JCheckBox("S. Name"); //new Checkbox("Name", null, true);
		 cBox2 = new JCheckBox("Address"); 
		 cBox3  = new JCheckBox("Mobile No.");
		 JPanel box = new JPanel();
		 box.add(cBox1);  box.add(cBox2); box.add(cBox3);
		 submitSButtonUpdate= new JButton("Update Record");			
		 
		 JLabel l1 = new JLabel("Select for update : ");
		 sNameLabel = new JLabel("S Name* : ");
		 sAddressLabel = new JLabel("Address* : ");
		 sMobileNoLabel = new JLabel("Mobile* : ");
		 sNameField = new JTextField();sAddressField = new JTextField();sMobileNoField = new JTextField();
		 //set Font style on all components
		 sRollNoLabel.setFont(f1); sRollNoField.setFont(f1);submitSButtonUpdate.setFont(f1);
		 l1.setFont(f1); cBox1.setFont(f1);  cBox2.setFont(f1);  cBox3.setFont(f1);
		 sNameLabel.setFont(f1);  sAddressLabel.setFont(f1); sMobileNoLabel.setFont(f1);
		 sNameField.setFont(f1); sAddressField.setFont(f1);  sMobileNoField.setFont(f1);
		 //Disbled
		 sNameField.setEnabled(false); sAddressField.setEnabled(false);  sMobileNoField.setEnabled(false);
		 
		 sRollNoLabel.setForeground(Color.white); l1.setForeground(Color.white);		 
		 submitSButtonUpdate.setBackground(Color.white);
		 sNameLabel.setForeground(Color.white);  sAddressLabel.setForeground(Color.white);
		 sMobileNoLabel.setForeground(Color.white);

		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx =0; rightSideComponentPanel.add(sRollNoLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx =1; rightSideComponentPanel.add(sRollNoField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx =1; rightSideComponentPanel.add(l1, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx =2; rightSideComponentPanel.add(box, gb);
		 
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx =1; rightSideComponentPanel.add(sNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx =1;rightSideComponentPanel.add(sAddressLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx =1;rightSideComponentPanel.add(sMobileNoLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx =2;rightSideComponentPanel.add(sNameField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx =2;rightSideComponentPanel.add(sAddressField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx =2;rightSideComponentPanel.add(sMobileNoField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 5; gb.gridx =1; gb.gridwidth=2; rightSideComponentPanel.add(new JSeparator(), gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 6; gb.gridx =1;rightSideComponentPanel.add(submitSButtonUpdate, gb);
		 
		 submitSButtonUpdate.addActionListener(this);
		 cBox1.addItemListener(new ItemEvent1());
		 cBox2.addItemListener(new ItemEvent1());
		 cBox3.addItemListener(new ItemEvent1());
		 
		 sMobileNoField.addKeyListener(new CheckNumber());
		 sRollNoField.addKeyListener(new KeyAdapter(){
		 public void keyReleased(KeyEvent ke){
			flagUpdate = false;
			String rollno = sRollNoField.getText();
			char ch[] = rollno.toCharArray();
			boolean ok = false ;
			for(int i = 0; i < ch.length; i++){
			  if(ch[i] < 48 || ch[i] > 57){
				errormsgLabel.setText("Enter valid number.");
				System.out.println("Not a number "+rollno.codePointAt(i));
			   }
			  }
		    if(rollno.equals(""))
 				errormsgLabel.setText(" ");
	        try{
			  ResultSet rs = smt.executeQuery("select rollno from "+studentTableName+" where rollno = "+rollno);
			  while(rs.next()){
				 flagUpdate = true;
				 System.out.println(rs.getInt("rollno"));
 			   }
               if(flagUpdate == true){
				 errormsgLabel.setText("Given roll no. is found.");
				 System.out.println("Given id is found");
			   }
			   else{
				 errormsgLabel.setText("Given roll no. is not found.");
				 System.out.println("Given id is not found");
			   }
			 }
			 catch(Exception e){
			    
			  }
			}			
		 });
    }
	private void connectDatabase(String user, String pass) {
		try {
			  //DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
			  Class.forName("oracle.jdbc.driver.OracleDriver"); 
			  con = DriverManager.getConnection(url,user,pass); 
			  smt = con.createStatement(); 
			 // if( con == null) 
			//	  System.out.println("Connected to database");
			// else
			//	  System.out.println("Connection is fail");
         } 
		catch(Exception ex) { 
			System.out.println("connction : "+ex); 
		} 
      }
    private void pageMessageName(String msg){
  	     JLabel pageLabelName = new JLabel(msg);
	     pageLabelName.setForeground(Color.WHITE);
    	 Font f2 = new Font("Century", Font.BOLD, 28);
		 pageLabelName.setFont(f2);
		 pageLabelName.setForeground(Color.WHITE);
		 leftSidePanel.add(pageLabelName);
	}
	GridBagConstraints gb;
	private void bookManagementDetails() {
		leftSidePanel = new JPanel();
		rightSidePanel = new JPanel();
		centerPanel.add(rightSidePanel, BorderLayout.CENTER);
		centerPanel.add(leftSidePanel, BorderLayout.WEST);
		leftSidePanel.setVisible(true);   rightSidePanel.setVisible(true);
		leftSidePanel.setBackground(Color.gray); rightSidePanel.setBackground(Color.gray);
		rightSidePanel.setLayout(new BorderLayout());
		
		pageMessageName("Book management");
		addButton  = new JButton("Add Book Details");
		showButton  = new JButton("Show All Book Details");
		deleteButton  = new JButton("Delete Book Details");
		searchButton  = new JButton("Search Book Details");
		updateButton  = new JButton("Update Book Details");
		backButton  = new JButton("Back");
		leftSidePanel.setLayout(new GridBagLayout());
		gb = new GridBagConstraints();
		gb.insets = new Insets(10, 0, 0, 0);
		
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.gridy = 1; gb.gridx =  0; leftSidePanel.add(new JSeparator(), gb);
		gb.fill =GridBagConstraints.HORIZONTAL;
		gb.gridy = 2; gb.gridx = 0; leftSidePanel.add(addButton, gb);
		gb.fill =GridBagConstraints.HORIZONTAL;
		gb.gridy = 4; gb.gridx = 0; leftSidePanel.add(deleteButton, gb);
		gb.fill =GridBagConstraints.HORIZONTAL;
		gb.gridy = 3; gb.gridx = 0; leftSidePanel.add(showButton, gb);
		gb.fill =GridBagConstraints.HORIZONTAL;
		gb.gridy = 5; gb.gridx = 0; leftSidePanel.add(searchButton, gb);
		gb.fill =GridBagConstraints.HORIZONTAL;
		gb.gridy = 6; gb.gridx = 0; leftSidePanel.add(updateButton, gb);
		gb.fill =GridBagConstraints.HORIZONTAL;
		gb.gridy = 7; gb.gridx = 0; leftSidePanel.add(backButton, gb);
		//Add Background Color
		addButton.setBackground(Color.white); showButton.setBackground(Color.white);
		deleteButton.setBackground(Color.white); searchButton.setBackground(Color.white);
		updateButton.setBackground(Color.white); backButton.setBackground(Color.white);
		//Add Font style
		addButton.setFont(f1); showButton.setFont(f1); deleteButton.setFont(f1);
		searchButton.setFont(f1); updateButton.setFont(f1); backButton.setFont(f1);
		leftSidePanel.setFont(f1);
		
		leftSidePanel.setPreferredSize(new Dimension(400, 100));
		//rightSidePanel.setPreferredSize(new Dimension(900, 100));
		addButton.setPreferredSize(new Dimension(300, 35));
		showButton.setPreferredSize(new Dimension(300, 35));
		deleteButton.setPreferredSize(new Dimension(300, 35));
		searchButton.setPreferredSize(new Dimension(300, 35));
		updateButton.setPreferredSize(new Dimension(300, 35));
		backButton.setPreferredSize(new Dimension(300, 35));
		//Add event on buttons
		addButton.addActionListener(this); showButton.addActionListener(this);
		deleteButton.addActionListener(this); searchButton.addActionListener(this);
		updateButton.addActionListener(this); backButton.addActionListener(this);	
	}
	//Panel addBookForm;
	JLabel bookIdLabel, bookNameLabel, bookTitleLabel, bookAuthorLabel;
	JTextField bookIdField, bookNameField, bookTitleField, bookAuthorField;
    JButton  resetButton, submitButtonAdd;
    JLabel header;
	JPanel headerPanel;
    private void headerText(String str) {
		 headerPanel = new JPanel(new GridLayout(2, 1));
		 headerPanel.setBackground(Color.BLUE);
    	 header = new JLabel(str, JLabel.CENTER);
		 rightSidePanel.add(headerPanel, BorderLayout.NORTH);
		 
		 header.setFont(new Font("Century", Font.BOLD, 26));
		 header.setForeground(Color.WHITE);
		 headerPanel.add(header);
		 header.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    Label msgLabel;
    private void message(String msgString) {
    	 msgLabel = new Label(msgString);
    	 msgLabel.setBackground(Color.WHITE);
		 headerPanel.add(msgLabel); 
		 msgLabel.setFont(f1);
    }
    JLabel errormsgLabel;
	JPanel errorPanel;
    private void errorMessage(String errorMsg) {
		errorPanel = new JPanel();
		errorPanel.setPreferredSize(new Dimension(100, 30));
		errorPanel.setLayout(new GridLayout(1, 1));
    	errormsgLabel = new JLabel(errorMsg, JLabel.CENTER);
		errorPanel.add(errormsgLabel);
		rightSidePanel.add(errorPanel, BorderLayout.SOUTH);
		//errormsgLabel.setBorder(new CompoundBorder(new LineBorder(Color.WHITE), new EmptyBorder(5, 10, 5, 10)));
        errormsgLabel.setFont(f1);
		errorPanel.setBackground(Color.WHITE);
		errormsgLabel.setForeground(Color.RED);
		errormsgLabel.setToolTipText("Show error message");
		errormsgLabel.setBorder(new LineBorder(Color.CYAN, 2, true));
    }
    private void addBookDetailsForm() {
		 pageNo = 2;
		 rightSideComponentPanel = new JPanel();
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 
		 rightSideComponentPanel.setBackground(Color.gray);
		 bookIdLabel = new JLabel("Book Id* : ");
		 bookNameLabel = new JLabel("Book Name* : ");
		 bookTitleLabel = new JLabel("Book Title* : ");
		 bookAuthorLabel = new JLabel("Book Author* : ");
		 
		 bookIdField = new JTextField();
		 bookNameField = new JTextField();
		 bookTitleField = new JTextField();	
		 bookAuthorField = new JTextField();
		 resetButton = new JButton("Reset");
		 submitButtonAdd = new JButton("Add Record");
		 
		 headerText("Add Book Details");
		 message("Enter following book details to add a book : ");
		 errorMessage(" ");
		 
		 bookIdLabel.setFont(f1);  bookNameLabel.setFont(f1);
		 bookTitleLabel.setFont(f1); bookAuthorLabel.setFont(f1);
		 bookIdField.setFont(f1); bookNameField.setFont(f1);  bookTitleField.setFont(f1);
		 bookAuthorField.setFont(f1);  resetButton.setFont(f1); submitButtonAdd.setFont(f1);
		 
		 bookIdLabel.setForeground(Color.white);  bookNameLabel.setForeground(Color.white);
		 bookTitleLabel.setForeground(Color.white);  bookAuthorLabel.setForeground(Color.white);
		 
		 resetButton.setBackground(Color.WHITE); submitButtonAdd.setBackground(Color.WHITE);
		 
		 bookIdField.setPreferredSize(new Dimension(150, 25));
		 bookNameField.setPreferredSize(new Dimension(150, 25));
		 bookTitleField.setPreferredSize(new Dimension(150, 25));
		 bookAuthorField.setPreferredSize(new Dimension(150, 25));
		 
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 0; rightSideComponentPanel.add(bookIdLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 1; gb.gridx = 0; rightSideComponentPanel.add(bookNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 2; gb.gridx = 0; rightSideComponentPanel.add(bookTitleLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 3; gb.gridx = 0; rightSideComponentPanel.add(bookAuthorLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 1; rightSideComponentPanel.add(bookIdField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 1; gb.gridx = 1; rightSideComponentPanel.add(bookNameField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 2; gb.gridx = 1; rightSideComponentPanel.add(bookTitleField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 3; gb.gridx = 1; rightSideComponentPanel.add(bookAuthorField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 4; gb.gridx = 0; gb.gridwidth = 2; rightSideComponentPanel.add(new JSeparator(), gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
		 gb.gridwidth = 1;
         gb.gridy = 5; gb.gridx = 0; rightSideComponentPanel.add(resetButton, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 5; gb.gridx = 1; rightSideComponentPanel.add(submitButtonAdd, gb);
         
         resetButton.addActionListener(this); submitButtonAdd.addActionListener(this);
	}
   // Panel  showBookForm;
    Label totalBook;
    private void showBookDetailsForm(){
    	 rightSideComponentPanel = new JPanel();
    	 rightSideComponentPanel.setVisible(true);
    	 rightSideComponentPanel.setLayout(new GridLayout(1, 1));
    	 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("All Books Details");
         message("All Books details: ");
			String data[][] = new String[50][5];	
			try{
			String q1 = "select * from "+bookTableName; 
			ResultSet rs = smt.executeQuery(q1); 
			if (rs.next()) 
			{   
			 int i = 0;
			 int ttlbooks = 0;
			 do{  
				 data[i][0] = Integer.toString(rs.getInt("bookid"));
				 data[i][1] = rs.getString("bookName");
				 data[i][2] = rs.getString("booktitle");
				 data[i][3] = rs.getString("bookauthor");
				 data[i][4] = rs.getString("bookIssue");
				 if( data[i][4].equals("YES")){ // if( data[i][4] == "YES") return false
					 ttlbooks++;
				 }
				 i++;
				}while(rs.next());	
			errorMessage("Total Number of books : "+i+", Total Number of issued books : "+ttlbooks);
			System.out.println("Total number of student details = "+i+" - "+smt.getMaxRows()); 
			}
			else
			{ 
		        errorMessage("Data is not available");
				System.out.println("No such user id is already registered"); 
			}
			}
			catch(Exception e2){
			  System.out.println("Show time error : "+e2);
			}
			JTable table1;
			String heading[] = {"Book Id","Book Name", "Book Title","Book Author Name","Book Issue"};
			table1 = new JTable(data, heading);
			
			table1.setFont(new Font("Century", Font.BOLD, 14));
			table1.setRowHeight(25);
			JScrollPane s = new JScrollPane(table1);
			rightSideComponentPanel.add(s); // add table on showBookFrom panel
   		    rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
    }    
	JButton submitButtonDelete;
    private void deleteBookDetailsForm() {
		 pageNo = 3;
		 rightSideComponentPanel = new JPanel();
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 rightSideComponentPanel.setBackground(Color.gray);
		 
		 headerText("Delete Book Details");
		 message("Enter following details to delete book : ");
		 errorMessage(" ");
		 bookIdLabel = new JLabel("Book Id* : ");
		 bookNameLabel = new JLabel("Book Name* : ");
		 
		 bookIdField = new JTextField();
		 bookNameField = new JTextField();
		 submitButtonDelete = new JButton("Delete Record");
		 
		 bookIdField.setPreferredSize(new Dimension(150, 25));
		 bookNameField.setPreferredSize(new Dimension(150, 25));
		 submitButtonDelete.setBackground(Color.WHITE);
		 
		 bookIdLabel.setFont(f1);  bookNameLabel.setFont(f1); bookIdField.setFont(f1);
		 bookNameField.setFont(f1);  submitButtonDelete.setFont(f1);
		 bookIdLabel.setForeground(Color.white);
		 bookNameLabel.setForeground(Color.white);
		 
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =0; gb.gridx = 0; rightSideComponentPanel.add(bookIdLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =1; gb.gridx = 0; rightSideComponentPanel.add(bookNameLabel, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy = 0; gb.gridx = 1; rightSideComponentPanel.add(bookIdField, gb);
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =1; gb.gridx = 1;rightSideComponentPanel.add(bookNameField, gb); 
         gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =2; gb.gridx = 0; gb.gridwidth = 2; rightSideComponentPanel.add(new JSeparator(), gb); 
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =3; gb.gridx = 0;rightSideComponentPanel.add(submitButtonDelete, gb);        
         submitButtonDelete.addActionListener(this);
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);		 
    }
    JButton submitButtonSearch;
    private void searchBookDetailsForm() {
		 pageNo = 4;
    	 rightSideComponentPanel = new JPanel();
		 rightSideComponentPanel.setVisible(true);
		 rightSideComponentPanel.setLayout(new BorderLayout());
		 JPanel right1 = new JPanel();
         rightSideComponentPanel.add(right1, BorderLayout.NORTH);
		 right1.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 
		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 rightSideComponentPanel.setBackground(Color.gray);	
		 right1.setBackground(Color.gray
		 );	
		 
		 headerText("Search Book Details");
		 message("Enter Book id or Author or Name to search a book : ");
		 errorMessage(" ");
		 bookIdLabel = new JLabel("Book Id : ");
		 bookNameLabel = new JLabel("Name : ");
		 bookAuthorLabel = new JLabel("Author : ");
		 bookIdField = new JTextField();
		 bookNameField = new JTextField();
		 bookAuthorField = new JTextField();
		 submitButtonSearch= new JButton("Search Record");
		 resetButton = new JButton("Reset");
		 
		 bookIdLabel.setFont(f1);  bookNameLabel.setFont(f1);   bookIdField.setFont(f1);
		 bookNameField.setFont(f1);  bookAuthorField.setFont(f1); 	 bookAuthorLabel.setFont(f1);
		 submitButtonSearch.setFont(f1);  resetButton.setFont(f1);
		
  		 bookIdLabel.setForeground(Color.white);  bookNameLabel.setForeground(Color.white);
		 bookAuthorLabel.setForeground(Color.white);  submitButtonSearch.setBackground(Color.WHITE);
		 resetButton.setBackground(Color.WHITE);

		 bookIdField.setPreferredSize(new Dimension(150, 25));
		 bookAuthorLabel.setPreferredSize(new Dimension(150, 25));
		 bookNameField.setPreferredSize(new Dimension(150, 25));
		 
	     gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =0; gb.gridx = 0;  right1.add(bookIdLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =1; gb.gridx = 0;  right1.add(bookNameLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =0; gb.gridx = 1; right1.add(bookIdField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =1; gb.gridx = 1;  right1.add(bookNameField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =2; gb.gridx = 0; right1.add(bookAuthorLabel, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =2; gb.gridx = 1;  right1.add(bookAuthorField, gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =3; gb.gridx = 0; gb.gridwidth= 2; right1.add(new JSeparator(), gb);
		 gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =4; gb.gridx = 0; gb.gridwidth= 1; right1.add(resetButton, gb);
		// gb.fill = GridBagConstraints.HORIZONTAL;
         gb.gridy =4; gb.gridx = 1;  right1.add(submitButtonSearch, gb);
		 
		 submitButtonSearch.addActionListener(this);
		 resetButton.addActionListener(this);
		  
    }
    JButton submitButtonUpdate;
    JCheckBox cBox1, cBox2, cBox3;
	boolean flagUpdate = false;
	JCheckBox ok;
    private void updateBookDetailsForm(){
		 pageNo = 5; 
		 updateCheckbox = 1;
    	 rightSideComponentPanel = new JPanel();
    	 rightSideComponentPanel.setVisible(true);
    	 rightSideComponentPanel.setLayout(new GridBagLayout());
		 gb = new GridBagConstraints();
		 gb.insets = new Insets(10, 10, 10, 10);
		 
    	 rightSideComponentPanel.setBackground(Color.gray);		 
		 headerText("Update Book Details");
		 message("Enter the ID of the book to be modified");
		 errorMessage(" ");
		 bookIdLabel = new JLabel("Book Id* : ");
		 bookIdField = new JTextField();
		 cBox1 = new JCheckBox("Name"); //new Checkbox("Name", null, true);
		 cBox2 = new JCheckBox("Title");
		 cBox3  = new JCheckBox("Author");
		 
		 submitButtonUpdate= new JButton("Update Record");		 
		 resetButton= new JButton("Reset");		 
		 submitButtonUpdate.setBackground(Color.white);
		 resetButton.setBackground(Color.white);
		 
		 JLabel l1 = new JLabel("Select for update : ");
	     JPanel boxPanel = new JPanel();
         boxPanel.add(cBox1); boxPanel.add(cBox2);	boxPanel.add(cBox3);	
		 
		 l1.setFont(f1); bookIdLabel.setFont(f1);  bookIdField.setFont(f1);
		 submitButtonUpdate.setFont(f1); resetButton.setFont(f1);
		 cBox1.setFont(f1);  cBox2.setFont(f1);  cBox3.setFont(f1);
		 
		 bookIdLabel.setForeground(Color.white);	 l1.setForeground(Color.white);		 
		 
		 bookNameLabel = new JLabel("Book Name* : ");
		 bookTitleLabel = new JLabel("Book Title* : ");
		 bookAuthorLabel = new JLabel("Book Author* : ");
		 bookNameField = new JTextField();
		 bookTitleField = new JTextField();
		 bookAuthorField = new JTextField();
		 		 
		 bookIdField.setPreferredSize(new Dimension( 200, 25));
		 bookTitleField.setPreferredSize(new Dimension( 200, 25));
		 bookNameField.setPreferredSize(new Dimension( 200, 25));
		 bookAuthorField.setPreferredSize(new Dimension( 200, 25));
		 
		 bookNameLabel.setFont(f1);  bookTitleLabel.setFont(f1);  bookAuthorLabel.setFont(f1);
		 bookNameField.setFont(f1);  bookTitleField.setFont(f1);  bookAuthorField.setFont(f1);
		 
		 //Disbled
		 bookNameField.setEnabled(false);  bookTitleField.setEnabled(false);
		 bookAuthorField.setEnabled(false);
		 
		 bookNameLabel.setForeground(Color.white);  bookTitleLabel.setForeground(Color.white);
		 bookAuthorLabel.setForeground(Color.white);
	      
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx = 0; rightSideComponentPanel.add(bookIdLabel, gb);
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 0; gb.gridx = 1;  rightSideComponentPanel.add(bookIdField, gb);
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx = 1;  rightSideComponentPanel.add(l1, gb);
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 1; gb.gridx = 2;  rightSideComponentPanel.add(boxPanel, gb);
 
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 2; gb.gridx = 1;  rightSideComponentPanel.add(bookNameLabel, gb );
         gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx = 1;  rightSideComponentPanel.add(bookTitleLabel, gb);
         gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx = 1;   rightSideComponentPanel.add(bookAuthorLabel, gb);
         gb.fill  = GridBagConstraints.HORIZONTAL;
		 
		 gb.gridy = 2; gb.gridx = 2;   rightSideComponentPanel.add(bookNameField, gb);
         gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 3; gb.gridx = 2;   rightSideComponentPanel.add(bookTitleField, gb);
         gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 4; gb.gridx = 2;   rightSideComponentPanel.add(bookAuthorField, gb);
		  gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 5; gb.gridx = 1;  gb.gridwidth = 2; rightSideComponentPanel.add(new JSeparator(), gb);
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 6; gb.gridx = 1;   gb.gridwidth = 1; rightSideComponentPanel.add(resetButton, gb);
		 gb.fill  = GridBagConstraints.HORIZONTAL;
		 gb.gridy = 6; gb.gridx = 2;   rightSideComponentPanel.add(submitButtonUpdate, gb);
 		 rightSidePanel.add(rightSideComponentPanel, BorderLayout.CENTER);
		 
		 submitButtonUpdate.addActionListener(this);  resetButton.addActionListener(this);
		 cBox1.addItemListener(new ItemEvent1());
		 cBox2.addItemListener(new ItemEvent1());
		 cBox3.addItemListener(new ItemEvent1());
		 
		 bookIdField.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent ke){
			 flagUpdate = false;
			 String id = bookIdField.getText();
			 char ch[] = id.toCharArray();
			 boolean ok = false ;
			 for(int i = 0; i < ch.length; i++){
				if(ch[i] >= 48 && ch[i] <= 57){
				    System.out.println("A number "+id.codePointAt(i));
				}else{
					errormsgLabel.setText("Enter valid number.");
				    System.out.println("Not a number "+id.codePointAt(i));
			    }
			  }
			  if(id.equals(""))
				   errormsgLabel.setText(" ");
			  try{
				   System.out.println(" id : "+id);
				  ResultSet rs = smt.executeQuery("select bookid from "+bookTableName+" where bookid = "+id);
				  while(rs.next()){
					 flagUpdate = true;
					 System.out.println(rs.getInt("bookid"));
				  }
                   if(flagUpdate == true){
					 errormsgLabel.setText("Given book id is found.");
					 System.out.println("Given id is found");
				   }
				 else{
					 errormsgLabel.setText("Given book id is not found.");
					 System.out.println("Given id is not found");
				 }
			   }
			   catch(Exception e){
			   
			   }
			}			
		 });
    }
	public LibraryFull() {		
	    super("Library Management System");
		setBounds(-8, -4, 1500, 735); // main Frame
		setVisible(true);
		//borderLayout = new BorderLayout(10, 5);
		setLayout( new BorderLayout(10, 5));
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1, 1));
		top.setPreferredSize(new Dimension(1400, 80));
		add(top, BorderLayout.NORTH);
		top.setBackground(Color.RED);
		
		f1 = new Font("Algerian", Font.BOLD, 32);
		JLabel logo = new JLabel("Library Management System".toUpperCase(), 0);
		logo.setForeground(Color.WHITE);
		logo.setFont(f1);
		top.add(logo);
		
		JPanel bottom = new JPanel();
		bottom.setPreferredSize(new Dimension(200, 40));
		bottom.setLayout(new GridLayout(1, 1));
		add(bottom, BorderLayout.SOUTH);
		bottom.setBackground(Color.YELLOW);
		JLabel footerLabel = new JLabel("DEVELOPED BY: OM PRAKASH KUMAR", JLabel.CENTER);
		footerLabel.setFont(new Font("Century", Font.BOLD, 18));
		footerLabel.setForeground(Color.RED);
	    bottom.add(footerLabel);
		 
		JPanel left = new JPanel();
		left.setLayout(new GridBagLayout());
	  	add(left, BorderLayout.EAST);
		
		JPanel right = new JPanel();
		right.setLayout(new GridBagLayout());
	    add(right, BorderLayout.WEST);/* 
	    left.setBackground(Color.RED);
		right.setBackground(Color.RED); */
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout(10, 15));
		//centerPanel.setPreferredSize(new Dimension(1400, 600));
		add(centerPanel, BorderLayout.CENTER);
		addWindowListener(new WindowClose());
		f1 = new Font("Century", Font.BOLD, 18);
		//connectDatabase("system" , "12345");
	 	//bookManagementDetails();
		loginPage();
	  	//openMainPage();
		//classPage();
	}//
	JPanel leftPanel ;
	private void loginPage() {
		pageNo = 1;
		leftPanel = new JPanel();
		centerPanel.add(leftPanel, BorderLayout.CENTER);
		leftPanel.setPreferredSize(new Dimension(200, 200));
		leftPanel.setVisible(true);
		leftPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		leftPanel.setBackground(Color.cyan);
		userLabel = new JLabel("Enter User Name : ");
		passLabel = new JLabel("Enter Password : ");
		userText = new TextField();
		passText = new TextField();
		login = new JButton("Login");
		
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0; gbc.gridx = 0; leftPanel.add(userLabel, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;		
		gbc.gridy = 0; gbc.gridx = 1; leftPanel.add(userText, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 1; gbc.gridx = 0; leftPanel.add(passLabel, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 1; gbc.gridx = 1; leftPanel.add(passText, gbc);
		JSeparator sp = new JSeparator();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 2; gbc.gridx = 0; gbc.gridwidth = 2; leftPanel.add(sp, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 3; gbc.gridx = 0;  gbc.gridwidth = 2; leftPanel.add(login, gbc);
		
		//Create password field
		passText.setEchoChar('*');
		leftPanel.setBorder(new LineBorder(Color.BLUE));
		login.setBackground(Color.WHITE);
		passText.setPreferredSize(new Dimension(150, 25));
		userText.setPreferredSize(new Dimension(150, 25));
		login.setPreferredSize(new Dimension(50, 35));
		login.setFont(new Font("Algerian", Font.BOLD, 16));
		Font font1 = new Font("Arno Pro Smbd Display", Font.BOLD, 18);
		
		userLabel.setFont(font1); passLabel.setFont(font1);
		passText.setFont(font1); userText.setFont(font1);
		userLabel.setForeground(Color.BLACK); passLabel.setForeground(Color.BLACK);
		userText.setForeground(Color.black); login.setForeground(Color.red);
		login.addActionListener(this);
	}
	JButton sem1, sem2, sem3, sem4, sem5, sem6;
   	public void classPage() {
		leftPanel = new JPanel();
		leftPanel.setVisible(true);
		centerPanel.add(leftPanel, BorderLayout.CENTER);
		leftPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(10, 10, 10, 10);
		leftPanel.setBackground(Color.gray);
		sem1 = new JButton("Semester 1");
		sem2 = new JButton("Semester 2");
		sem3 = new JButton("Semester 3");
		sem4 = new JButton("Semester 4");
		sem5 = new JButton("Semester 5");
		sem6 = new JButton("Semester 6");
		exitButton = new JButton("Exit");
		
		sem1.setBackground(Color.white); sem2.setBackground(Color.white);
		sem3.setBackground(Color.white); sem4.setBackground(Color.white);
		sem5.setBackground(Color.white);
		sem6.setBackground(Color.white);
		exitButton.setBackground(Color.white);
		
		leftPanel.setFont(f1); 
		sem1.setFont(f1); exitButton.setFont(f1);
		sem2.setFont(f1); sem3.setFont(f1); sem4.setFont(f1);
		sem5.setFont(f1); sem6.setFont(f1);
				
		sem1.setPreferredSize(new Dimension(300, 40));
		sem2.setPreferredSize(new Dimension(300, 40));
		sem3.setPreferredSize(new Dimension(300, 40));
		sem4.setPreferredSize(new Dimension(300, 40));
		sem5.setPreferredSize(new Dimension(300, 40));
		sem6.setPreferredSize(new Dimension(300, 40));
		exitButton.setPreferredSize(new Dimension(300, 40));
		//arrange all componenets 
		gbc1.fill = GridBagConstraints.VERTICAL;		
		gbc1.gridy = 0; gbc1.gridx =0; leftPanel.add(sem1, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 1; gbc1.gridx =0;  leftPanel.add(sem2, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 2; gbc1.gridx =0;  leftPanel.add(sem3, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 3; gbc1.gridx =0;  leftPanel.add(sem4, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 4; gbc1.gridx =0;  leftPanel.add(sem5, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 5; gbc1.gridx =0;  leftPanel.add(sem6, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 6; gbc1.gridx =0;  leftPanel.add(exitButton, gbc1);
		sem3.addActionListener(this); sem1.addActionListener(this);
		sem4.addActionListener(this); sem2.addActionListener(this);
		sem5.addActionListener(this); sem6.addActionListener(this);
		exitButton.addActionListener(this);	
	}
	Panel mainPanel;
	public void openMainPage() {
		pageNo = 0;
		leftPanel = new JPanel();
		leftPanel.setVisible(true);
		centerPanel.add(leftPanel, BorderLayout.CENTER);
		leftPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.insets = new Insets(10, 10, 10, 10);
		leftPanel.setBackground(Color.gray);
		bookPageOpen = new JButton("Book Management");
		studentPageOpen = new JButton("Student Management");
		bookIssuePageOpen = new JButton("Issue  Book");
		bookReturnPageOpen = new JButton("Return Book");
		backButton = new JButton("Back");
		
		bookPageOpen.setBackground(Color.white); studentPageOpen.setBackground(Color.white);
		bookIssuePageOpen.setBackground(Color.white); bookReturnPageOpen.setBackground(Color.white);
		backButton.setBackground(Color.white);
		
		leftPanel.setFont(f1); 
		bookReturnPageOpen.setFont(f1); backButton.setFont(f1);
		bookPageOpen.setFont(f1); studentPageOpen.setFont(f1); bookIssuePageOpen.setFont(f1);
				
		bookPageOpen.setPreferredSize(new Dimension(300, 40));
		studentPageOpen.setPreferredSize(new Dimension(300, 40));
		bookIssuePageOpen.setPreferredSize(new Dimension(300, 40));
		bookReturnPageOpen.setPreferredSize(new Dimension(300, 40));
		backButton.setPreferredSize(new Dimension(300, 40));
		JPanel sem = new JPanel();
		header = new JLabel(semesterName.toUpperCase(), JLabel.CENTER);
		header.setFont(new Font("CEntury", Font.BOLD, 40));
		sem.setBackground(Color.gray);
		header.setForeground(Color.white);
		sem.add(header);
		sem.setPreferredSize(new Dimension(300, 80));
		
		gbc1.fill = GridBagConstraints.VERTICAL;		
		gbc1.gridy = 0; gbc1.gridx =0; leftPanel.add(sem, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;		
		gbc1.gridy = 1; gbc1.gridx =0; leftPanel.add(new JSeparator(), gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;		
		gbc1.gridy = 3; gbc1.gridx =0; leftPanel.add(bookPageOpen, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 4; gbc1.gridx =0;  leftPanel.add(studentPageOpen, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 5; gbc1.gridx =0;  leftPanel.add(bookIssuePageOpen, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 6; gbc1.gridx =0;  leftPanel.add(bookReturnPageOpen, gbc1);
		gbc1.fill = GridBagConstraints.VERTICAL;	
		gbc1.gridy = 7; gbc1.gridx =0;  leftPanel.add(backButton, gbc1);
		
		bookPageOpen.addActionListener(this); studentPageOpen.addActionListener(this);
		bookIssuePageOpen.addActionListener(this); bookReturnPageOpen.addActionListener(this);
		backButton.addActionListener(this);	
	}
	void colorClickedButton(JButton clickedButton) {
		prev.setBackground(Color.white);
		prev.setForeground(Color.black);
		//prev.setBorder(new LineBorder(Color.blue, 2, true));
		prev = clickedButton;
        prev.setBackground(Color.blue);
        prev.setForeground(Color.white);
		//prev.setBorder(new LineBorder(Color.WHITE, 2, true));
	}
	String bookTableName, studentTableName, issueTableName, returnTableName, semesterName;
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == login) {
			String user = userText.getText().trim();
			String pass = passText.getText().trim();
			if(user.equals("system") == true && pass.equals("12345") == true) {
			    connectDatabase(user, pass); // connect database
				System.out.println("UserName : "+userText.getText()+"\nPassword : "+pass);
				centerPanel.remove(leftPanel);
			    classPage();
			  ///  remove(centerPanel);
			}
			else if(user.equals("") && pass.equals("")){
			   JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			else if(user.equals("")){
			   JOptionPane.showMessageDialog(this, "Please fill user name fields.", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			else if(pass.equals("")){
			   JOptionPane.showMessageDialog(this, "Please fill password fields.", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			else if(user.equals("system") != true && pass.equals("12345") != true){
			   JOptionPane.showMessageDialog(this, "Wrong user name and password.", "Error message", JOptionPane.ERROR_MESSAGE);
			}
			else if(user.equals("system") != true){
				JOptionPane.showMessageDialog(this, "Wrong User name.", "Error message", JOptionPane.ERROR_MESSAGE);
				 //System.out.println("Wrong password and user name");   
			}
			else{
			    JOptionPane.showMessageDialog(this, "Wrong password.", "Error message", JOptionPane.ERROR_MESSAGE);
			}
		}
		//semester 1 all tables name
		if(obj == sem1){
			 centerPanel.remove(leftPanel);
			 bookTableName = "sem1BookTable";
			 studentTableName = "sem1StudentTable";
			 issueTableName = "sem1IssuebookTable";
			 returnTableName = "sem1ReturnbookTable";
			 semesterName = "Semester 1";
			 openMainPage();
		}
		if(obj == sem2){
			 centerPanel.remove(leftPanel);
			 bookTableName = "sem2BookTable";
			 studentTableName = "sem2StudentTable";
			 issueTableName = "sem2IssuebookTable";
			 returnTableName = "sem2ReturnbookTable";
			 semesterName = "Semester 2";
			 openMainPage();
		}
		if(obj == sem3){
			 centerPanel.remove(leftPanel);
			 bookTableName = "sem3BookTable";
			 studentTableName = "sem3StudentTable";
			 issueTableName = "sem3IssuebookTable";
			 returnTableName = "sem3ReturnbookTable";
			 semesterName = "Semester 3";
			 openMainPage();
		}
		if(obj == sem4){
			 centerPanel.remove(leftPanel);
			 bookTableName = "sem4BookTable";
			 studentTableName = "sem4StudentTable";
			 issueTableName = "sem3IssuebookTable";
			 returnTableName = "sem4ReturnbookTable";
			 semesterName = "Semester 4";
			 openMainPage();
		}
		if(obj == sem5){
			 centerPanel.remove(leftPanel);
			 bookTableName = "sem5BookTable";
			 studentTableName = "sem5StudentTable";
			 issueTableName = "sem5IssuebookTable";
			 returnTableName = "sem5ReturnbookTable";
			 semesterName = "Semester 5";
			 openMainPage();
		}
		if(obj == sem6){
			 centerPanel.remove(leftPanel);
			 bookTableName = "sem6BookTable";
			 studentTableName = "sem6StudentTable";
			 issueTableName = "sem6IssuebookTable";
			 returnTableName = "sem6ReturnbookTable";
			 semesterName = "Semester 6";
			 openMainPage();
		}
		
		//book management page open
		if(obj ==  bookPageOpen) {
			pageNo = -1;
			  //leftPanel.removeAll();
			 bookManagementDetails();
			 centerPanel.remove(leftPanel);
		}
		// student page open  
		if( obj ==  studentPageOpen){
			pageNo = -1;
			 centerPanel.remove(leftPanel);
			 studentManagementDetails();
			//remove(mainPanel);
		}
		// Issue book page open  
		if( obj == bookIssuePageOpen){	
		    pageNo = -1;
			centerPanel.remove(leftPanel);
			issueBookDetails();
			//remove(mainPanel);
		}
		// Return book page open  
		if( obj == bookReturnPageOpen){
			pageNo = -1;
			returnBookDetails();
			centerPanel.remove(leftPanel);
			//remove(mainPanel);
		}
		//book page buttons
		if(obj == addButton) {
			colorClickedButton(addButton);
			rightSidePanel.removeAll();
			addBookDetailsForm();
		}
		if(obj == submitButtonAdd){
		   String id = bookIdField.getText().trim();
		   String bname = bookNameField.getText().toUpperCase().trim();
		   String bauthor = bookAuthorField.getText().toUpperCase().trim();
		   String btitle = bookTitleField.getText().toUpperCase().trim();
		   String q3 = "insert into "+bookTableName+" values("+id+",'"+bname+"','"+btitle+"'"+",'"+bauthor+"', 'NO')";
           System.out.println("insert values is : " +q3);		   
           if(id.equals("") || bname.equals("") || bauthor.equals("") || btitle.equals("")){
		      errormsgLabel.setText("Please fill all fields.");
		   }
		   else{
		      int op = JOptionPane.showConfirmDialog(this, "Are You Sure?", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			  if(op == JOptionPane.YES_OPTION){
				try{ 
		          int m = smt.executeUpdate(q3); 
			      if (m == 1) {
				     errormsgLabel.setText("Data is inserted");
  				     System.out.println("inserted successfully : ");
			      }				
			      else{
				 	 errormsgLabel.setText("Data is not inserted");
				     System.out.println("insertion failed");    				 
			      }
		        }
			   catch(Exception e1){
				   errormsgLabel.setText("Given book id is already inserted");
			   }	
			 }
		   }
		}
		//show all book details
		if(obj == showButton) {
			colorClickedButton(showButton);
			rightSidePanel.removeAll();
			showBookDetailsForm();
		}
		//book delete button for book delete form
		if(obj == deleteButton) {
			colorClickedButton(deleteButton);
			System.out.println("Delete button clicked ");
			rightSidePanel.removeAll();//(rightSideComponentPanel);
			deleteBookDetailsForm();				
		}
		if(obj == submitButtonDelete){
			String id = bookIdField.getText().trim();
            if(id.equals("")){
			    errormsgLabel.setText("Please fill field.");
			}else{
			   try
				 { 
					String q1 = "delete from "+bookTableName+" where bookid = "+id;
					int m = smt.executeUpdate(q1); 
					if (m == 1) 
					{
						errormsgLabel.setText("Data is deleted");
						System.out.println("deletion successfully : "); 
					}
					else{
						System.out.println("deletion failed");
						errormsgLabel.setText("Data is not found");
					}					
				 }
				 catch(Exception e1){
					 //errorMessage(rightSideComponentPanel, "error", 0);
					System.out.println(e1);
				}
			}
		}
		//Search book details
		if(obj == searchButton) {
			colorClickedButton(searchButton);
			System.out.println("Search button clicked ");
			rightSidePanel.removeAll();
			searchBookDetailsForm();
		}
		if(obj == submitButtonSearch){
			JTable table1;
			boolean flag = false;
            String id = bookIdField.getText().trim();
            String name = bookNameField.getText().toUpperCase().trim();
			String author = bookAuthorField.getText().toUpperCase().trim();
			String q1 = "select *from "+bookTableName+" where ";
			if( !id.equals("") && !name.equals("") && ! author.equals("")){
				 q1 = q1 + " bookid = "+id+"  and bookname = '"+name+"' and bookauthor =  '"+author+"'";
			 flag = true;
		    } 
			else if( !id.equals("") && !name.equals("")){
				 q1 = q1 + " bookid = "+id+"  and bookname = '"+name+"'";
				 flag = true;
			}
			else if( !id.equals("") && !author.equals("")){
				 q1 = q1 + " bookid = "+id+" and bookauthor =  '"+author+"'";
				 flag = true;
			}
			else if( !name.equals("") && !author.equals("")){
			    q1 = q1 + " bookname = '"+name+"' and bookauthor =  '"+author+"'";
				flag = true;
			}
		    else if( !id.equals("")){
				q1 = q1 + " bookid = "+id;
				flag = true;
		    }
		    else if( !name.equals("")){
				q1 = q1 + "bookName = '"+name+"'";
				flag = true;
		    }
		    else if( !author.equals("")){
				q1 = q1 + "bookauthor = '"+author+"'";
				flag = true;
			}
		    else {
				errormsgLabel.setText("Please fill at least one field");
				System.out.println("Enter at least one data");
				flag = false;
			}
			if(flag == true){
				int i = 0;	
				String data[][] = new String[50][5];	
			try{ 
				ResultSet rs = smt.executeQuery(q1); 
				if (rs.next()) 
				{   
					do{ 
					    
						data[i][0] = Integer.toString(rs.getInt("bookid"));
						data[i][1] = rs.getString("bookName");
						data[i][2] = rs.getString("booktitle");
						data[i][3] = rs.getString("bookauthor");
						data[i][4] = rs.getString("bookissue");
						System.out.println(rs.getInt(1)+ "  "+rs.getString(2));
						i++;
					}while(rs.next());	
					System.out.println("Total number of student details = " + i);
					errormsgLabel.setText("Total number of books : "+ i);				
				}
				else
				{ 
			        errormsgLabel.setText("Data is not found");
					System.out.println("data is not found"); 
				}
			}
			catch(Exception e2){
			   System.out.println(e2);
			}
			String heading[] = {"Book Id","Book Name", "Book Title","Book Author Name","Book Issue"};
			table1 = new JTable(data, heading);
			table1.setFont(f1);
			table1.setRowHeight(25);
			JScrollPane s = new JScrollPane(table1);
			rightSideComponentPanel.add(s, BorderLayout.CENTER);
		  }		 
		}
		if(obj == updateButton) {
			colorClickedButton(updateButton);
			System.out.println("Update button clicked ");
			rightSidePanel.removeAll();//(addBookForm);
			updateBookDetailsForm();
		}
		if(obj == submitButtonUpdate){
			System.out.println("submit Update button clicked ");
			String id = bookIdField.getText().trim();
			if(id.equals(""))
			     errormsgLabel.setText("PLease enter the book id.");
			 else{
			  if( flagUpdate == true){
				boolean flag = false;
				String name = bookNameField.getText().toUpperCase().trim();
				String title = bookTitleField.getText().toUpperCase().trim();
				String author = bookAuthorField.getText().toUpperCase().trim();
				String q1 = "update "+bookTableName+" set ";
				if( !name.equals("") && !title.equals("") && ! author.equals("")){
					 q1 = q1 + " bookname = '"+name+"' , booktitle = '"+title+"' , bookauthor =  '"+author+"'";
					flag = true;
				 } 
				 else if( !title.equals("") && !name.equals("")){
					 q1 = q1 + " booktitle = '"+title+"' , bookname = '"+name+"'";
					 flag = true;
				 }
				 else if( !title.equals("") && !author.equals("")){
					 q1 = q1 + " booktitle = '"+title+"' , bookauthor =  '"+author+"'";
					 flag = true;
				 }
				 else if( !name.equals("") && !author.equals("")){
					q1 = q1 + " bookname = '"+name+"' , bookauthor =  '"+author+"'";
					flag = true;
				 }
			     else if( !title.equals("")){
					q1 = q1 + " booktitle = '"+title+"'";
					flag = true;
			     }
			     else if( !name.equals("")){
					q1 = q1 + "bookName = '"+name+"'";
					flag = true;
			     }
			     else if( !author.equals("")){
					q1 = q1 + "bookauthor = '"+author+"'";
					flag = true;
				 }
				 else {
					errormsgLabel.setText("Fill at least one field");
					System.out.println("Enter at least one data");
					flag = false;
				}
			 	if(flag == true){
				   q1 = q1 + " where bookid = "+id;
    			   System.out.println("update  query : "+q1);
				   try{
					   int m = smt.executeUpdate(q1);
					   if(m == 1)
					   {
						    errormsgLabel.setText("Data is updated");
						    System.out.println("Data is updated");
					   }
						else{
							errormsgLabel.setText("Data is not updated");
							System.out.println("Data is not updated");
						}
				}
				catch(Exception e2){
			      System.out.println("Update error : "+e2);
			   }
			 }
			}
		  }
		}
		//This button on bookManagement page
		if(obj == backButton) { 
			colorClickedButton(backButton);
			centerPanel.removeAll();
			if(pageNo == 0){
				classPage();
			}
			else{
				openMainPage();
			    System.out.println("Hello main page");
			}
		}
	    //BookForm details reset 
		if(obj == resetButton) {
			 System.out.println("Hello  resetButton call");
			 switch(pageNo){
				case 1: // Login page
						userText.setText(" ");
						passText.setText(" ");
						break;
				case 2: // book add form
						bookIdField.setText(" ");
						bookNameField.setText(" ");
						bookTitleField.setText(" ");
						bookAuthorField.setText(" ");
			            break;
				case 3: // delete book form
						bookIdField.setText(" ");
						bookNameField.setText(" ");
						break;
				case 4: // search book form
						bookIdField.setText(" ");
						bookNameField.setText(" ");
						bookAuthorField.setText(" ");
				        break;
				case 5: // Update book form
				        bookIdField.setText(" ");
						bookNameField.setText(" ");
						bookTitleField.setText(" ");
						bookAuthorField.setText(" ");
						break;
				case 6: // add Student details form
				        sRollNoField.setText(" ");
						sNameField.setText(" ");
						//sClassField.setText(" ");
						sAddressField.setText(" ");
						sMobileNoField.setText(" ");
						break;
				case 7: //delete student details form
						sRollNoField.setText(" ");
						sNameField.setText(" ");
						break;
				case 8: //Search student details
						sRollNoField.setText(" ");
						sNameField.setText(" ");
						break;
				case 9: // Update student details
						sRollNoField.setText(" ");
						sNameField.setText(" ");
						sAddressField.setText(" ");
						sMobileNoField.setText(" ");
						break;
				case 11: // add returned book details
						sRollNoField.setText(" ");
						sNameField.setText(" ");
					    bookIdField.setText(" ");
						bookTitleField.setText(" ");
						returnDateField.setText(" ");
						issuedDateField.setText(" ");
						break;
				case 10: // add issue book details
						sRollNoField.setText(" ");
						sNameField.setText(" ");
					    bookIdField.setText(" ");
						bookTitleField.setText(" ");
						issuedDateField.setText(" ");
						break;
			 }
		}
		//Student Management
		if(obj == addSButton) {
			colorClickedButton(addSButton);
			rightSidePanel.removeAll();
			addStudentDetailsForm();
		}
		if(obj == submitSButtonAdd){
		    if(flagK == true){
               String rollno = sRollNoField.getText().trim();
			   String name = sNameField.getText().toUpperCase().trim();
			   String gender;
			   if( ml.isSelected() == true)
				   gender = "Male";
			   else
				   gender = "Female";
			   String address = sAddressField.getText().toUpperCase().trim();
			   String mobileno = sMobileNoField.getText().toUpperCase().trim();
			   String q3 = "insert into "+studentTableName+" values("+rollno+",'"+name+"', '"+semesterName+"','"+gender+"', '"+address+"', '"+mobileno+"', 0)";
			   System.out.println("insert values is : " +q3);		   
			   if(rollno.equals("") || name.equals("") || address.equals("") || mobileno.equals("")) {
				   errormsgLabel.setText("Please fill all fields.");
			   }
			   else{
				   try
				    { 
					  int m = smt.executeUpdate(q3); 
					  if (m == 1) {
						  errormsgLabel.setText("Data is inserted");
						  System.out.println("inserted successfully : ");
					}				
					else{
					   System.out.println("insertion failed");    				 
					  }
					}
					catch(Exception e1){
						errormsgLabel.setText("Given id is already inserted");
						System.out.println(e1);
					}
			   }
		    }				
		}
		//Delete Student details
		if(obj == submitSButtonDelete){
			String rollno = sRollNoField.getText().trim();
			String name = sNameField.getText().toUpperCase().trim();
			if(!rollno.equals("") && !name.equals("")){
              try
				{ 
				 String q1 = "delete from "+studentTableName+" where rollno = "+rollno+" and name = '"+name+"'";			
			  	 int m = smt.executeUpdate(q1); 
				 if (m == 1) 
				  {
					errormsgLabel.setText("Data is deleted");
			   	  }
			      else{
					 errormsgLabel.setText("Data is not found");
				 }					
			   }
			   catch(Exception e1){
				 System.out.println(e1);
			  } 
			}
			else
				errormsgLabel.setText("Please fill all fields!");
		}
		
		if(obj == submitSButtonSearch){
			boolean flag = false;
            String rollno = sRollNoField.getText().trim();
            String name = sNameField.getText().toUpperCase().trim();
			String address = sAddressField.getText().toUpperCase().trim();
			String q1 = "select *from "+studentTableName+" where ";
			if( !rollno.equals("") && !name.equals("") && !address.equals("")){
				 q1 = q1 + " rollno = "+rollno+"  and name = '"+name+"' and address = '"+address+"'";
				 flag = true;
		     } 
	   	    else if( !rollno.equals("") && !name.equals("")){
				q1 = q1 + " rollno = "+rollno+"  and name = '"+name+"'";
				flag = true;
		    }
			else if( !rollno.equals("") && !address.equals("")){
				q1 = q1 + " rollno = "+rollno+"  and address = '"+address+"'";
				flag = true;
		    }
		    else if( !name.equals("") && !address.equals("")){
				q1 = q1 + " Name = '"+name+"' and address = '"+address+"'";
				flag = true;
		    }
			else if( !name.equals("") ){
				q1 = q1 + " Name = '"+name+"'";
				flag = true;
		    }
			else if( !rollno.equals("") ){
				q1 = q1 + " rollno = "+rollno;
				flag = true;
		    }
			else if( !address.equals("") ){
				q1 = q1 + " address = '"+address+"'";
				flag = true;
		    }
		 	else {
				errormsgLabel.setText("Fill at least one field");
				flag = false;
			}
			String data[][] = new String[20][7];	
			if(flag == true){
			  int i = 0;
			  try{
				ResultSet rs = smt.executeQuery(q1); 
				if (rs.next()) 
				 {   
					i = 0;
					do{  
						data[i][0] = Integer.toString(rs.getInt("rollno"));
						data[i][1] = rs.getString("Name");
						data[i][2] = rs.getString("clas");
						data[i][3] = rs.getString("gender");
						data[i][4] = rs.getString("address");
						data[i][5] = rs.getString("mobileno");
						data[i][6] = String.valueOf(rs.getInt("totalbook"));
						i++;
					}while(rs.next());	
					errormsgLabel.setText("Total number of students : "+ i);	
				 }
			    else 
				  errormsgLabel.setText("Data is not found.");	 
			 }
			 catch(Exception e2){
			    System.out.println("Show time error : "+e2);
			  }
			JTable table1;
			String heading[] = {"Roll No.","Name", "Class","Gender","Address",  "Mobile No.",  "Total Books"};
			table1 = new JTable(data, heading);
			table1.setFont(f1);
			table1.setRowHeight(25);
			JScrollPane s = new JScrollPane(table1);
			rightSideComponentPanel.add(s);	 
			}
		}
		if(obj == submitSButtonUpdate){
			String rollno = sRollNoField.getText().trim();
			if(rollno.equals(""))
			  errormsgLabel.setText("Please enter roll no.");
		    else{
			  if( flagUpdate == true){
				boolean flag = false;
				String name = sNameField.getText().toUpperCase().trim();
				String address = sAddressField.getText().toUpperCase().trim();
				String mobileno = sMobileNoField.getText().toUpperCase().trim();
				String q1 = "update "+studentTableName+" set ";
				if( !name.equals("") && !address.equals("") && ! mobileno.equals("")){
					 q1 = q1 + " name = '"+name+"' , address = '"+address+"' , mobileno =  '"+mobileno+"'";
					flag = true;
				 } 
				 else if( !address.equals("") && !name.equals("")){
					 q1 = q1 + " address = '"+address+"' , name = '"+name+"'";
					 flag = true;
				 }
				 else if( !address.equals("") && !mobileno.equals("")){
					 q1 = q1 + " address = '"+address+"' , mobileno =  '"+mobileno+"'";
					 flag = true;
				 }
				 else if( !name.equals("") && !mobileno.equals("")){
					q1 = q1 + " name = '"+name+"' , mobileno =  '"+mobileno+"'";
					flag = true;
				 }
			     else if( !name.equals("")){
					q1 = q1 + " name = '"+name+"'";
					flag = true;
			     }
			     else if( !address.equals("")){
					q1 = q1 + "address = '"+address+"'";
					flag = true;
			     }
			     else if( !mobileno.equals("")){
					q1 = q1 + "mobileno = '"+mobileno+"'";
					flag = true;
				 }
				 else {
					errormsgLabel.setText("Fill at least one field");
					flag = false;
				}
			 	if(flag == true){
				   q1 = q1 + " where rollno = "+rollno;
				   try{
					   int m = smt.executeUpdate(q1);
					   if(m == 1)
					   {
						    errormsgLabel.setText("Data is updated");
					   }
						else{
							errormsgLabel.setText("Data is not updated");
						}
				}
				catch(Exception e2){
			      System.out.println("Update error : "+e2);
			   }
			 }
		    }	
		  }
		}
  	  //show all student details
		if(obj == showSButton) {
			colorClickedButton(showSButton);
			rightSidePanel.removeAll();
			showStudentDetailsForm();
		}
		//student delete button for student	delete form
		if(obj == deleteSButton) {
			colorClickedButton(deleteSButton);
			rightSidePanel.removeAll();
			deleteStudentDetailsForm();				
		}
		if(obj == searchSButton) {
			colorClickedButton(searchSButton);
			rightSidePanel.removeAll();
			searchStudentDetailsForm();				
		}
		if(obj == updateSButton) {
			colorClickedButton(updateSButton);
			rightSidePanel.removeAll();
			updateStudentDetailsForm();				
		}
		// issueBookDetails
		//open issued book form
		if(obj == addIssueBookButton) {
			colorClickedButton(addIssueBookButton);
			rightSidePanel.removeAll();
			addIssueBookDetailsForm();
		}
		if(obj == submitIssuedButton){
			if( totalBooks >= 3){
				 errormsgLabel.setText("Already issued three books.");
			}
			String rollno = sRollNoField.getText().trim();
			String bookid = bookIdField.getText().toUpperCase().trim();
			String date = issuedDateField.getText().trim();
			if(rollno.equals("") || bookid.equals("") || date.equals(""))
				errormsgLabel.setText("Please fill all fields.");	
		    else{
		        if(flagK == true && flagR == true && totalBooks < 3){
				   String q3 = "insert into "+issueTableName+" values("+bookid+", "+rollno+", '"+date+"')";
				   try
					{ 
					  int m = smt.executeUpdate(q3); 
					  smt.executeUpdate("update "+bookTableName+" set bookissue = 'YES' where bookid = "+bookid);
					  smt.executeUpdate("update "+studentTableName+" set totalbook = totalbook + 1 where rollno = "+rollno);
					  if (m == 1) {
						  errormsgLabel.setText("Data is inserted");
						  ResultSet rs = smt.executeQuery("select totalbook from "+studentTableName+" where rollno = "+rollno);
						  if(rs.next())
							totalBooks = rs.getInt("totalBook");
					}				
					else{
						errormsgLabel.setText("Data is not inserted");		 
					  }
					}
					catch(Exception e1){
						System.out.println(e1);
					}
			    }
				else{
					 if(flagR == false)
					   errormsgLabel.setText("Book is issued");
				}
		    }
		} 
		// issueBookDetails
		//show all book details
		if(obj == showIssueBookButton) {
			colorClickedButton(showIssueBookButton);
			rightSidePanel.removeAll();
			showIssueBookDetailsForm();
		}
		//open return book form
		if(obj == addReturnBookButton) {
			colorClickedButton(addReturnBookButton);
			rightSidePanel.removeAll();
			addReturnBookDetailsForm();
		}
		//Add record in returnbook table
		if(obj == submitReturnButton){
		  String bookid = bookIdField.getText().trim();
		  String booktitle = bookTitleField.getText().toUpperCase().trim();
		  String name = sNameField.getText().toUpperCase().trim();
          String rollno = sRollNoField.getText().trim();
		  String dateis = issuedDateField.getText().trim();
		  String date = returnDateField.getText().trim();
		  if(bookid.equals("") || date.equals(""))
			  errormsgLabel.setText("Please fill all fields.");	
		  else{
			   String day = dateis.substring(8);
			   int m1 = Integer.parseInt(dateis.substring(5, 7));
			   String year = dateis.substring(0, 4);
			   String month = " ";
			   String monthStr[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
			   month = monthStr[m1 - 1];
			   dateis = String.join("-", day, month, year);
			   String q3 = "insert into "+returnTableName+" values("+bookid+", '"+booktitle+"', "+rollno+", '"+name+"', '"+dateis+"', '"+date+"')";	   
			   try
				{ 
				  int m = smt.executeUpdate(q3); 
				  smt.executeUpdate("update "+bookTableName+" set bookissue = 'NO' where bookid = "+bookid);
				  smt.executeUpdate("update "+studentTableName+" set totalbook = totalbook - 1 where rollno = "+rollno);
				  smt.executeUpdate("delete from "+ issueTableName+" where bookid = "+bookid);
				  if (m == 1) {
					  errormsgLabel.setText("Data is inserted");
					}				
					else{
						errormsgLabel.setText("Data is not inserted");			 
					  }
					}
					catch(Exception e1){
						System.out.println(e1);
					}
			   }
		} 
		//Show returned book details
		 if(obj == showReturnBookButton){
			colorClickedButton(showReturnBookButton);
			rightSidePanel.removeAll();
			showReturnBookDetailsForm();
		 }
		//for Exit
		if(obj == exitButton) {
			int exit = JOptionPane.showConfirmDialog(this, "Do you want to Exit?", "Exit Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(exit == 0)	
			{
				 System.exit(0);			 
			}			 
		}
	}
	//For checkbox 
	class ItemEvent1 implements ItemListener {
		public void itemStateChanged(ItemEvent me) {
			Object objm = me.getSource();
			if(objm == cBox1) {
				if(me.getStateChange() == 1 ){
					if(updateCheckbox == 1)
						bookNameField.setEnabled(true);
					else
						sNameField.setEnabled(true);
				}
				else{
					if(updateCheckbox == 1)
						bookNameField.setEnabled(false);
					else
						sNameField.setEnabled(false);
				}
			}
			if(objm == cBox2) {
				if(me.getStateChange() == 1){
					if(updateCheckbox == 1)
						bookTitleField.setEnabled(true);
					else
						sAddressField.setEnabled(true);
				}
				else{
					if(updateCheckbox == 1)
						bookTitleField.setEnabled(false);
					else
						sAddressField.setEnabled(false);
				   }
			}
			if(objm == cBox3) {
				if(me.getStateChange() == 1)
				  {
					if(updateCheckbox == 1)
						bookAuthorField.setEnabled(true);
					else
						sMobileNoField.setEnabled(true);
				   }
				else{
					if(updateCheckbox == 1)
						bookAuthorField.setEnabled(false);
					else
						sMobileNoField.setEnabled(false);
				   }
			}
		}
	}
	Window obj1 ;
	class WindowClose extends WindowAdapter{
		public void windowClosing(WindowEvent we) {
			obj1 = (Window)we.getSource();
			/* int exit = JOptionPane.showConfirmDialog(LibraryNew.this, "Do you want to Exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(exit == 0)	
			{
			   obj1.dispose();
			}
			*/
			System.exit(0);
		}
	}
	public static void main(String []args) {
		new LibraryFull();
	}
} 