import java.util.ArrayList; // Εισαγωγή της κλάσης ArrayList για δυναμική λίστα
import java.util.Scanner; // Εισαγωγή της κλάσης Scanner για είσοδο από το πληκτρολόγιο

public class MainP // Κύρια κλάση για τη διαχείριση φοιτητών
{
    ArrayList<Student> allStudent; // Λίστα για αποθήκευση όλων των φοιτητών
    Scanner Keyb; // Scanner για είσοδο από το πληκτρολόγιο
    
    

    public MainP() //εισαγωγή αρχικών δεδομένων
    {
        Student tmp;
        allStudent = new ArrayList<>();
        tmp = new Student("Παναγιώτης Ζώης", "16345", "zoispanag@gmail.com", "6971853743", "Μηχανικών Πληροφορικής", 8.86);
        allStudent.add(tmp);
        tmp = new Student ("Εμμανουήλ Βενέτης", "16344", "venetis@gmail.com", "6999999990", "Διοίκησης Επιχειρήσεων", 5.01);
        allStudent.add(tmp);
        tmp = new Student ("Γιώργος Θεοφύλακτος", "16343", "teo@gmail.com", "6999999991", "Αυτοματισμού", 7.31);
        allStudent.add(tmp);
        tmp = new Student ("Φαίδωνας Γκιζιώτης", "16342", "dp@gmail.com", "6999999992", "Ηλεκτρονικής", 6.61);
        allStudent.add(tmp);
        Keyb = new Scanner (System.in);
    }
    
    
    public void Menu () // Κύρια μέθοδος για την εμφάνιση του μενού και την επιλογή λειτουργιών
    {
        int menuchoice;
        do
        {
        System.out.println ("               M E N O Y");
        System.out.println ("==========================================");
        System.out.println ("[1]...Προβολή όλων των διαθέσιμων φοιτητών");
        System.out.println ("[2]...Προσθήκη νέου φοιτητή");
        System.out.println ("[3]...Αναζήτηση φοιτητή βάσει ονόματος");
        System.out.println ("[4]...Αναζήτηση φοιτητή βάσει τηλεφώνου"); 
        System.out.println ("[5]...Επεξεργασία φοιτητή βάσει ονόματος");
        System.out.println ("[6]...Διαγραφή φοιτητή βάσει ονόματος");
        System.out.println ("[7]...Έξοδος από την εφαρμογή");
        System.out.print ("\nΕπιλογή : ");
        menuchoice = Keyb.nextInt();
        Keyb.nextLine(); // Καθαρισμός του buffer μετά την είσοδο αριθμού
        switch (menuchoice)
        {
            case 1:
                DoShowStudents();
                break;
            case 2:
                DoInsert();
                break;
            case 3:
                SearchByName();
                break;
            case 4:
                SearchByPhone();
                break;
            case 5:
                EditStudentByName();
                break;
            case 6:
                DeleteStudentByName();
                break;
            case 7:
                System.out.println ("Έξοδος...Καλή συνέχεια!");
                break;
            default:
                System.out.println ("Μη έγκυρη επιλογή. Προσπάθησε ξανά.");    
        }
    }while (menuchoice != 7);
        
        
    }
    
    public void showallStudents() // για επιλογή 1 
    {
        int i=0;
        for (i=0; i<allStudent.size(); i++)
            {
            Student s = allStudent.get(i);
            System.out.println(s);   // χρησιμοποιεί την toString() από την κλάση Students 
        }
    }
    
    public void DoShowStudents () // για επιλογή 1
    {
        System.out.println ("       Παρουσίαση Αρχείου");
        System.out.println ("       ------------------\n");
        showallStudents ();
        Pause ();
    }
 
    public void Pause () // για το τέλος κάθε μεθόδου, περιμενώντας την είσοδο του χρήστη
    {
        System.out.print ("\n\nΠίεσε <Enter> για συνέχεια....");
        Keyb.nextLine();
        System.out.println ("\n");
    }

    public void DoInsert () // για επιλογή 2, προσθήκη νέου φοιτητή
    {
        String onoma;
        String am;
        String mail;
        String tele;
        String tmima;
        double mo;
        Student tmp;
        
        System.out.println ("Προσθήκη Νέου Φοιτητή");
        System.out.println ("---------------------");
        System.out.print ("Εισάγετε όνομα: ");
        onoma= Keyb.nextLine();
        System.out.print ("Εισάγετε αριθμό μητρώου: ");
        am = Keyb.nextLine();
        System.out.print ("Εισάγετε Email : ");
        mail = Keyb.nextLine();
        System.out.print ("Εισάγετε Τηλέφωνο : ");
        tele = Keyb.nextLine();
        System.out.print ("Εισάγετε Τμήμα : ");
        tmima = Keyb.nextLine();
        System.out.print ("Εισάγετε Μέσος Όρος Βαθμολογίας : ");
        String moStr = Keyb.nextLine().replace(",", ".").trim(); // Αντικαθιστά το κόμμα με τελεία για σωστή μετατροπή σε double
        mo = Double.parseDouble(moStr); // Μετατροπή της συμβολοσειράς σε double
        tmp =new Student (onoma, am, mail, tele, tmima, mo); // Δημιουργία νέου αντικειμένου Student με τα δεδομένα που εισήχθησαν
        allStudent.add (tmp); // Προσθήκη του νέου φοιτητή στη λίστα
        System.out.println ("Η εισαγωγή ολοκληρώθηκε");     
        Pause ();
        
    }

    public void SearchByName () // για επιλογή 3
    {
        System.out.print("Εισάγετε το όνομα του φοιτητή για αναζήτηση: ");
        String tmpName = Keyb.nextLine().toLowerCase().trim(); // tolowercase για Μετατροπή σε πεζά και trim για αφαίρεση κενών χαρακτήρων
        boolean exists = false;
      
        int i;
        
        for (i=0; i<allStudent.size(); i++)
        {
            
            Student s= allStudent.get(i);
            
            if (s.getName().toLowerCase().contains(tmpName)) 
            {
                System.out.println("\n== Βρέθηκε Φοιτητής ==\n");
                s.fullPrint();
                exists = true;
            } 
        }
        if (exists == false)
        {
            System.out.println("\nΔεν βρέθηκε φοιτητής με αυτό το όνομα....");
        }
        Pause();
    }
    
    public void SearchByPhone() // για επιλογή 4
    {
    System.out.print("Εισάγετε τον αριθμό τηλεφώνου του φοιτητή: ");
    String findtel = Keyb.nextLine().trim();
    boolean exists = false;
    
    int i;

    for (i=0; i<allStudent.size(); i++) 
    {
        Student s =allStudent.get(i);
        if (s.gettel().contains(findtel)) 
        {
            System.out.println("\n== Βρέθηκε Φοιτητής ==\n");
            s.fullPrint();
            exists = true;
        }
    }

    if (exists == false) 
    {
        System.out.println("\nΔεν βρέθηκε φοιτητής με αυτόν τον αριθμό τηλεφώνου.");
    }

    Pause();
    }
    
    public void EditStudentByName() // για επιλογή 5
    {
        System.out.print("Εισάγετε το όνομα του φοιτητή που θέλετε να επεξεργαστείτε: ");
        String tmpName = Keyb.nextLine().toLowerCase().trim();
        boolean exists = false;
        
        int i;
        for (i=0; i<allStudent.size(); i++)
        {
            Student s= allStudent.get(i);
            if (s.getName().toLowerCase().contains(tmpName))
            {
                System.out.println("\n== Βρέθηκε Φοιτητής ==\n");
                s.fullPrint(); 
                
                System.out.print("\nΕπεξεργασία καρτέλα φοιτητή (ναι/όχι); ");
                String newName = Keyb.nextLine();
                if (newName.equals("όχι") || newName.equals("no") || newName.equals("οχι")|| newName.equals("oxi")) // Έλεγχος για ακύρωση της επεξεργασίας
                {
                    System.out.println("\nΗ Επεξεργασία ακυρώθηκε.");
                }
                else 
                {
                    System.out.print("Εισάγετε νέο όνομα: ");
                    String newOnoma = Keyb.nextLine();
                    System.out.print("Εισάγετε νέο αριθμό μητρώου: ");
                    String newAm = Keyb.nextLine();
                    System.out.print("Εισάγετε νέο Email: ");
                    String newMail = Keyb.nextLine();
                    System.out.print("Εισάγετε νέο Τηλέφωνο: ");
                    String newTele = Keyb.nextLine();
                    System.out.print("Εισάγετε νέο Τμήμα: ");
                    String newTmima = Keyb.nextLine();
                    System.out.print("Εισάγετε νέο Μέσο Όρο Βαθμολογίας: ");
                    String moInput = Keyb.nextLine().replace(",", ".");
                    double newMo = Double.parseDouble(moInput);

                    // Ενημέρωση των πεδίων του φοιτητή
                    s.setName(newOnoma);
                    s.setStID(newAm);
                    s.setStEmail(newMail);
                    s.settel(newTele);
                    s.setDept(newTmima);
                    s.setavgGrade(newMo);
                    // Εμφάνιση των ενημερωμένων στοιχείων
                    System.out.println("\n== Ενημερωμένα Στοιχεία Φοιτητή ==\n");
                    s.fullPrint();
                    allStudent.set(i, s); // Ενημέρωση της λίστας με το ενημερωμένο αντικείμενο Student
                    // Εμφάνιση μηνύματος ολοκλήρωσης της επεξεργασίας  
                    System.out.println("\nΗ επεξεργασία ολοκληρώθηκε.");

                }

                exists = true;
            }    
        }
        if (exists == false)
        {
            System.out.println("\n Δεν βρέθηκε φοιτητής με αυτό το όνομα.");
        }
        Pause();
    }
    
    public void DeleteStudentByName() // για επιλογή 6
    {
    System.out.print("Εισάγετε το όνομα του φοιτητή που θέλετε να διαγράψετε: ");
    String tmpName = Keyb.nextLine().toLowerCase().trim();
    boolean exists = false;

    for (int i = 0; i < allStudent.size(); i++) 
    {
        Student s = allStudent.get(i);
        if (s.getName().toLowerCase().contains(tmpName)) 
        {
            System.out.println("\n== Βρέθηκε Φοιτητής ==\n");
            s.fullPrint();

            System.out.print("\nΕίστε σίγουρος ότι θέλετε να διαγράψετε αυτόν τον φοιτητή; (ναι/οχι): ");
            String answer = Keyb.nextLine().toLowerCase();

            if (answer.equals("ναι") || answer.equals("yes")) 
            {
                allStudent.remove(i);
                System.out.println("Ο φοιτητής διαγράφηκε επιτυχώς.");
            } 
            else 
            {
                System.out.println("Η διαγραφή ακυρώθηκε.");
            }

            exists = true;
        }
    }

    if (exists == false) 
    {
        System.out.println("\nΔεν βρέθηκε φοιτητής με αυτό το όνομα.");
    }

    Pause();
}
       
public static void main(String[] args) // Κύρια μέθοδος εκκίνησης της εφαρμογής
    {
        MainP mp = new MainP(); 
        mp.Menu(); // Εκκίνηση του μενού
    }   
}