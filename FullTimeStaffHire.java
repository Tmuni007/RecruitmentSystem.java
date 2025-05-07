//Subclass that extends StaffHire for full-time staff
public class FullTimeStaffHire extends StaffHire {
    //stores the pay for the staff
    private double salary;
    //stores number of weekly hours
    private int weeklyFractionalHours;
    //constructor with all fields
    public FullTimeStaffHire(int vacNum, String desig, String job,
    String name, String date, String qual, String appBy, boolean joined,
    double sal, int weeklyHrs) {
        //calls constructor of parent class
        super(vacNum,desig,job,name,date,qual,appBy,joined);
        //sets this class's specifc fields
        this.salary = sal;
        this.weeklyFractionalHours = weeklyHrs;
    }
    
    //getter for salary
    public double getSalary(){
        return salary;
    }
    
    //Method to change salary (if staff has already joined)
    public void setSalary(double newSal){
        if(isJoined()) {
            this.salary = newSal;  //update salary
        } else {
            //staff hasn't joined so display a warning
            System.out.println("Staff not yet joined. Salary update failed.");
        }
    }
    
    //getter for weekly hours
    public int getWeeklyFractionallHours(){
        return weeklyFractionalHours;
    }
    
    //Method to change the weekly working hours
    public void setWeeklyFractionalHours(int hrs){
        this.weeklyFractionalHours = hrs;
    }
    
    //Display all full-time staff details
    public void display(){
        super.display();   //display basic info from StaffHire class
        System.out.println("Salary:" + salary);  //show pay
        System.out.println("Weekly Fractional Hours:" + weeklyFractionalHours); 
        //above shows working hours
    }
}