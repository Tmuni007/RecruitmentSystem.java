import javax.swing.*; //for GUI components
import java.awt.*;    //for layout
import java.awt.event.*; //for button click actions
import java.util.ArrayList; //to store list of staff objects

//RecruitmentSystem is the main GUI class
public class RecruitmentSystem extends JFrame implements ActionListener{
    //ArrayList to hold both full-time and part-time staff
    private ArrayList<StaffHire> staffList = new ArrayList<>();
    
    //GUI input fields
    private JTextField vacancyField,designationField,jobTypeField, 
    nameField,dateField,qualificationField,appointedByField,salaryField,
    weeklyHoursField,workHrField,wageField,shiftField,terminateField,displayField;
    
    //GUI buttons
    private JButton addFullBtn,addPartBtn,salaryBtn,shiftBtn,terminateBtn,
    displayBtn,clearBtn;
    
    //Constructor- sets up entire GUI layout
    public RecruitmentSystem(){
        setTitle("Recruitment System");
        setSize(600,750);   //GUI window size
        setLayout(new GridLayout(18,1,5,5));  //grid layout(rows,colms)
        setDefaultCloseOperation(EXIT_ON_CLOSE);  //CLOSES APP ON EXIT
        
        //creating input box for all fields
        vacancyField = new JTextField();
        designationField = new JTextField();
        jobTypeField = new JTextField();
        nameField = new JTextField();
        dateField = new JTextField();
        qualificationField = new JTextField();
        appointedByField = new JTextField();
        salaryField = new JTextField();
        weeklyHoursField = new JTextField();
        workHrField = new JTextField();
        wageField = new JTextField();
        shiftField = new JTextField();
        terminateField = new JTextField();
        displayField = new JTextField();
        
        //Set general input field sizes
        Dimension inputSize = new Dimension(200,25);  //width, height
        designationField.setPreferredSize(inputSize);
        jobTypeField.setPreferredSize(inputSize);
        nameField.setPreferredSize(inputSize);
        dateField.setPreferredSize(inputSize);
        qualificationField.setPreferredSize(inputSize);
        appointedByField.setPreferredSize(inputSize);
        salaryField.setPreferredSize(inputSize);
        shiftField.setPreferredSize(inputSize);
        
        //individually increase height for fields thhat look too short
        vacancyField.setPreferredSize(new Dimension(200, 35));
        weeklyHoursField.setPreferredSize(new Dimension(200, 35));
        wageField.setPreferredSize(new Dimension(200, 35));
        terminateField.setPreferredSize(new Dimension(200, 35));
        workHrField.setPreferredSize(new Dimension(200, 35));
        displayField.setPreferredSize(new Dimension(200, 35));
        
        //creating all the buttons
        addFullBtn = new JButton("Add Full-Time");
        addPartBtn = new JButton("Add Part-Time");
        salaryBtn = new JButton("Set Salary");
        shiftBtn = new JButton("Set Shifts");
        terminateBtn = new JButton("Terminate");
        displayBtn = new JButton("Display Staff");
        clearBtn = new JButton("Clear");
        
        //adding labels + fields to GUI
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(new JLabel("Vacancy Number:")); row1.add(vacancyField);
        add(row1);
        
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.add(new JLabel("Designation:"));row2.add(designationField);
        add(row2);
        
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3.add(new JLabel("Job Type:")); row3.add(jobTypeField);
        add(row3);
        
        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row4.add(new JLabel("Staff Name:")); row4.add(nameField);
        add(row4);
        
        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row5.add(new JLabel("JoiningDate:")); row5.add(dateField);
        add(row5);
        
        JPanel row6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row6.add(new JLabel("Qualification:")); row6.add(qualificationField);
        add(row6);
        
        JPanel row7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row7.add(new JLabel("Appointed By:")); row7.add(appointedByField);
        add(row7);
        
        JPanel row8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row8.add(new JLabel("Salary:")); row8.add(salaryField);
        add(row8);
        
        JPanel row9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row9.add(new JLabel("Weekly Hours:"));row9.add(weeklyHoursField);
        add(row9);
        
        JPanel row10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row10.add(new JLabel("Working Hours:")); row10.add(workHrField);
        add(row10);
        
        JPanel row11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row11.add(new JLabel("Wages Per Hour:")); row11.add(wageField);
        add(row11);
        
        JPanel row12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row12.add(new JLabel("Shifts:")); row12.add(shiftField);
        add(row12);
        
        JPanel row13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row13.add(new JLabel("Terminate Vacancy #:")); row13.add(terminateField);
        add(row13);
        
        JPanel row14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row14.add(new JLabel("Display Index:")); row14.add(displayField);
        add(row14);
        
        
        //add all buttons into layout
        add(addFullBtn); add(addPartBtn);
        add(salaryBtn); add(shiftBtn);
        add(terminateBtn); add(displayBtn);
        add(clearBtn);
        
        //connect buttons to action listener
        addFullBtn.addActionListener(this);
        addPartBtn.addActionListener(this);
        salaryBtn.addActionListener(this);
        shiftBtn.addActionListener(this);
        terminateBtn.addActionListener(this);
        displayBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        
        setVisible(true);   //make the window visible
    }
    
    //when any button is clicked this runs
    public void actionPerformed(ActionEvent e){
        //Add Full-time staff
        if (e.getSource() == addFullBtn) {
            try{
                //get raw text input from GUI
                int vacNum = Integer.parseInt(vacancyField.getText());
                String desig = designationField.getText();
                String job = jobTypeField.getText();
                String name = nameField.getText();
                String date = dateField.getText();
                String qual = qualificationField.getText();
                String appBy = appointedByField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                int weeklyHours =Integer.parseInt(weeklyHoursField.getText());
                //determine if staff has joined based on name field
                boolean joined = !name.equals("");
                
                //create and add full time staff object to list
                FullTimeStaffHire full = new FullTimeStaffHire(vacNum,
                desig,job,name,date,qual,appBy,joined,salary,weeklyHours);
                staffList.add(full);
                JOptionPane.showMessageDialog(this, "Full-time staff added.");
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(this,"Check your full-time input fields.");
                    
                }
            }
            
            //Add Part-Time Staff
            else if (e.getSource() == addPartBtn){
                try{
                int vacNum = Integer.parseInt(vacancyField.getText());
                String desig = designationField.getText();
                String job = jobTypeField.getText();
                String name = nameField.getText();
                String date = dateField.getText();
                String qual = qualificationField.getText();
                String appBy = appointedByField.getText();
                int workHr= Integer.parseInt(workHrField.getText());
                double wage = Double.parseDouble(wageField.getText());
                String shift = shiftField.getText();
                boolean joined = !name.equals("");
                //Create and add PartTimeStaffHire object to list
                PartTimeStaffHire part = new PartTimeStaffHire(vacNum,
                desig,job,name,date,qual,appBy,joined,workHr,wage,
                shift);
                staffList.add(part);
                JOptionPane.showMessageDialog(this,"Part-time staff added.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,"Check your part-time input field.");
                }
            }
            
            //Set Salary
            else if (e.getSource() == salaryBtn){
                try{
                    int vacNum = Integer.parseInt(vacancyField.getText());
                    double newSal =  Double.parseDouble(salaryField.getText());
                    for(StaffHire s : staffList){
                        if(s instanceof FullTimeStaffHire && 
                        s.getVacancyNumber() == vacNum){
                            ((FullTimeStaffHire) s).setSalary(newSal);
                            JOptionPane.showMessageDialog(this,"Salary updated.");
                            return;
                        }
                }
                JOptionPane.showMessageDialog(this,"Full-time staff not found.");
            } catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Check vacancy numberand salary input.");
            }
        }
        //set shifts
        else if (e.getSource() == shiftBtn){
            try{
                int vacNum = Integer.parseInt(vacancyField.getText());
                String newShift =shiftField.getText();
                for(StaffHire s :staffList){
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber()
                    == vacNum){
                        ((PartTimeStaffHire) s).setShifts(newShift);
                        JOptionPane.showMessageDialog(this,"Shifts updated");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Part-time staff not found.");
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Error updating shifts.");
            }    
                
        }
        //Terminate Part-Time Staff 
        else if (e.getSource() == terminateBtn){
            try{
                int vacNum = Integer.parseInt(terminateField.getText());
                for(StaffHire s :staffList){
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber()
                    == vacNum){
                        ((PartTimeStaffHire) s).terminate();
                        JOptionPane.showMessageDialog(this,"Staff terminated.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Part-time staff not found.");
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Error in termination input.");
            }
        }
        //Display Staff Info
        else if (e.getSource() == displayBtn){
            try{
                int index = Integer.parseInt(displayField.getText());
                if(index >= 0 && index <staffList.size()){
                    staffList.get(index).display(); //print in terminal
            } else {
                JOptionPane.showMessageDialog(this, "Index out of range.");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Please enter a number in Display Index.");
        }
    }
    //Clear all fields
    else if (e.getSource() == clearBtn){
        vacancyField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        nameField.setText("");
        dateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        salaryField.setText("");
        weeklyHoursField.setText("");
        workHrField.setText("");
        wageField.setText("");
        shiftField.setText("");
        terminateField.setText("");
        displayField.setText("");
    }
} 
//Launch the GUI
public static void main(String[] args){
    new RecruitmentSystem();
   }
}