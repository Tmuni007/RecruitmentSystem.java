//This class stores basic details for any kind of staff hire
public class StaffHire {
    //Fields for storing job and staff details
    private int vacancyNumber;       //Vacancy number
    private String designation;      // job title
    private String jobType;          // type of job ie. permanent, temp
    private String staffName;        // name of hired staff
    private String joiningDate;      //  when they joined
    private String qualification;   //qualification or degrees
    private String appointedBy;     //who hired them
    private boolean joined;    // true if person has been hired
    
    //Constructor setas all values when object is made
    public StaffHire(int vacNum, String desig, String job, String name,
    String date, String qual, String appBy, boolean joined) {
        this.vacancyNumber = vacNum;  //set vacany number
        this.designation = desig;  //set job title
        this.jobType = job;    // set type of job
        this.staffName = name;   //set staff name
        this.joiningDate = date;   //set join date
        this.qualification = qual;  //set qualification
        this.appointedBy = appBy;    //who hired them
        this.joined = joined;     //has staff joined or not
    }
    
  //Getter for vacancy number
  public int getVacancyNumber() {
     return vacancyNumber;
    }
  //set a new vacancy number
  public void setVacancyNumber(int vacNum) {
      this.vacancyNumber = vacNum;
    }
  //get job designation
  public String getDesignation() {
     return designation;
    }
  //change job designation
  public void setDesignation(String d) {
      designation = d;
    }
  //get job type
  public String getJobType() {
     return jobType;
    }
  //change job type
  public void setJobType(String jType) {
     this.jobType = jType;
    }
  //get staff name 
   public String getStaffName() {
    return staffName;
  }
  //Sets staff name (used to clear name when terminating)
  public void setStaffName(String name){
      this.staffName = name;
  }
 //get joining date
  public String getJoiningDate() {
   return joiningDate;
 } 
 //set new joining date
public void setJoiningDate(String date) {
 joiningDate = date;
}
//get qualification
 public String getQualification() {
  return qualification;
}
//set new qualification
public void setQualification(String q) {
  qualification = q;
}
//get name of person who appointed staff
public String getAppointedBy() {
  return appointedBy;
}
//set new value for who appointed them
public void setAppointedBy(String by) {
    appointedBy = by;
}
//return true or false based on whether staff has joined 
public boolean isJoined() {
    return joined;
}
//update joined status
public void setJoined(boolean j) {
    joined = j;
}
//method to display all details
public void display() {
    System.out.println("Vacancy Num:" + vacancyNumber);    //show vacNum
    System.out.println("Designation:" + designation);      //show d
    System.out.println("Job Type:" + jobType);             //show jType
    System.out.println("Staff Name:" + staffName);         //show staffName
    System.out.println("Join Date:" + joiningDate);        // show joining date
    System.out.println("Qualification:" + qualification); //show qualifictaion
    System.out.println("Appointed By:" + appointedBy);    //who hired by
    System.out.println("Joined:" + joined); //true/false if they joined
  }
}
    
