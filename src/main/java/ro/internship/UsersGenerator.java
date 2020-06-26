package ro.internship;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UsersGenerator {
	
	public static void generate() {
        Map<Integer, User> users = new HashMap<Integer, User>(generateUsers());
		
        for(int i = 0; i < 100; i++) {
            System.out.println(i + ": " + users.get(i).getData());	
        }
	}
	
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
    public static LocalDate randomBirthday() {
    	
    	GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1956, 2002);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        LocalDate birthday = LocalDate.of(gc.get(Calendar.YEAR), (gc.get(Calendar.MONTH) + 1), gc.get(Calendar.DAY_OF_MONTH));

        return birthday;
        
    }
    
	public static Map<Integer, User> generateUsers() {
	      Map<Integer, User> localUsers = new HashMap<Integer, User>();
	      
	      String[] firstName = {"Larry", "Sally", "Jack", "Rachel"};
	      String[] lastName = {"McDonald", "Marshall", "Lee", "Jackson", "Graham", "Davies"};
	      
	      for(int i = 0; i < 100; i++) {
	    	  localUsers.put(i, new User(firstName[randBetween(0, firstName.length - 1)], lastName[randBetween(0, lastName.length - 1)], randomBirthday()));
	      }
	      
	      return localUsers;   
	}
}


class User {
	
	// Fields necesare pentru un user: prenume, nume si data nasterii;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	
	// Constructor pentru clasa User;
	public User(String firstName, String lastName, LocalDate birthday) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
	}
	
	// Getters pentru prenume, nume si data nasterii;
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	// functie pentru a returna datele complete ale unui user
	public String getData() {
		return firstName + " " + lastName + " " + birthday.toString();
	}
	
	// Setters pentru prenume, nume si data nasterii;
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
