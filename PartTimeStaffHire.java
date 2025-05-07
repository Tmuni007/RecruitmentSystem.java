//Subclass for part-time staff, extends StaffHire
public class PartTimeStaffHire extends StaffHire{
    //Fields specific to part time staff members
    private int workHr;   //number of hours worked per day
    private double wagesPerHour;    //hourly rate of wages
    private String shifts;    //type of shift(ie. morning/day/evening)
    private boolean terminated;  ///true if staff member has been let go

    //Constructor to initailise all values when object is created 
    public PartTimeStaffHire(int vacancyNumber, String designation,
    String jobType, String staffName, String joiningDate,
    String qualification, String appointedBy, boolean joined, int workHr,
    double wagesPerHour, String shifts) {
        
        //Call constructor from parent class to set shared fields
        super(vacancyNumber, designation, jobType, staffName, joiningDate,
        qualification, appointedBy, joined);
        
        //set fields that are specific to part time staff
        this.workHr = workHr;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;   //by default staff is not terminated
    }
    
    //Get number of working hours
    public int getWorkHour(){
        return workHr;
    }
    
    //Set or update working hours
    public void setWorkHour(int workHr){
        this.workHr = workHr;
    }
    
    //Get wages per hour
    public double getWagesPerHour(){
        return wagesPerHour;
    }
    
    //Set or update wages per hour
    public void setWagesPerHour(double wagesPerHour){
        this.wagesPerHour = wagesPerHour;
    }
    
    //Get current shifts
    public String getShifts(){
        return shifts;
    }
    
    //Update shift type but only if staff has joined
    public void setShifts(String newShifts){
        if (isJoined()){
            this.shifts = newShifts;
        } else{
            System.out.println("Shift update failed. Staff has not joined yet.");
        }
    }
    
    //check if the staff has been terminated 
    public boolean isTerminated(){
        return terminated;
    }
    
    //Terminate staff member
    public void terminate(){
        if (terminated) {
            System.out.println("Staff has already been terminated.");
        } else {
            //Clear persoanl info
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
            System.out.println("Staff has been terminated successfully.");
        } 
    }
    
    //Display all details of part time staff 
    public void display() {
        super.display();  //display basic details from StaffHire
        
        System.out.println("WorkHour:" + workHr);
        System.out.println("Wages Per Hour:" + wagesPerHour);
        System.out.println("Shifts:" + shifts);
        System.out.println("Terminated:" + terminated);
        
        //Calculate income per day = working hours * hourly rate
        double incomePerDay = workHr * wagesPerHour;
        System.out.println("Income Per Day:" + incomePerDay);
    }
}   