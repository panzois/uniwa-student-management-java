/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panzois
 */
public class Student // κλαση Student
{
    private String Name; 
    private String StID;
    private String StEmail;
    private String tel;
    private String Dept;
    private double avgGrade;
    
    public Student (String Name, String StID, String StEmail, String tel, String Dept, double avgGrade) // constructor της κλάσης Student
    {
        this.Name = Name;
        this.StID = StID;
        this.StEmail = StEmail;
        this.tel = tel;
        this.Dept = Dept;
        this.avgGrade = avgGrade;
    }
    
    public String getName () // getter για το όνομα του φοιτητή
    {
        return Name;
    }
    
    public void setName (String Name) // setter για το όνομα του φοιτητή
    {
        this.Name = Name;
    }
    
    public String getStID ()
    {
        return StID;
    }
    
    public void setStID (String StID)
    {
        this.StID = StID;
    }
    
    public String getStEmail ()
    {
        return StEmail;
    }
    
    public void setStEmail (String StEmail)
    {
        this.StEmail = StEmail;
    }
    
    public String gettel ()
    {
        return tel;
    }
    
    public void settel (String tel)
    {
        this.tel = tel;
    }
    
    public String getDept ()
    {
        return Dept;
    }
    
    public void setDept (String Dept)
    {
        this.Dept = Dept;
    }
    
    public double getavgGrade ()
    {
        return avgGrade;
    }

    public void setavgGrade (double avgGrade)
    {
        this.avgGrade = avgGrade;
    }
    
    public void fullPrint () // μέθοδος για την εκτύπωση όλων των στοιχείων του φοιτητή
    {
        System.out.println ("Όνομα Φοιτητή................: " + Name);
        System.out.println ("Αριθμός Μητρώου .............: " + StID);
        System.out.println ("Email........................: " + StEmail);
        System.out.println ("Τηλέφωνο.....................: " + tel);
        System.out.println ("Τμήμα........................: " + Dept);
        System.out.println ("Μέσος Όρος Βαθμολογίας.......: " + avgGrade);
    }
    
    
    @Override // μέθοδος για την αναπαράσταση της κλάσης Student ως String
    // χρησιμοποιείται για την εκτύπωση των στοιχείων του φοιτητή σε μορφή κειμένου
    public String toString() 
    {
        return "Όνομα: " + Name + ", ΑΜ: " + StID + ", Email: " + StEmail +
                ", Tηλ: " + tel + ", Τμήμα: " + Dept + ", Μέσος Όρος: " + avgGrade;
    }
}
