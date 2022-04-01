package calorie_calculator;

import java.util.Scanner;

public class Main {
	
	public static void body_fat_table() // print after body fat %
	{
	    final Object[][] table = new String[6][];
	    table[0] = new String[] {"Description", "Women", "Men"};
	    table[1] = new String[] {"Essential Fat", "10-13%", "02-05%"};
	    table[2] = new String[] {"Athletes", "14-20%", "06-13%"};
	    table[3] = new String[] {"Fitness", "21-24%", "14-17%"};
	    table[4] = new String[] {"Average", "25-31%", "18-25%"};
	    table[5] = new String[] {"Obese", "32+%", "25+%"};

	    System.out.println();
	    for(final Object[] row : table)
	    {
	        System.out.format("%25s%15s%15s%n", row);
	    }
	}

	public static void bmi_table() // print BMI table
	{
		final Object[][] table = new String[9][];
	    table[0] = new String[] {"Category", "BMI Range - kg/m^2"};
	    table[1] = new String[] {"Severe Thinness", "<16"};
	    table[2] = new String[] {"Moderate Thinness", "16-17"};
	    table[3] = new String[] {"Mild Thinness", "17-18.5"};
	    table[4] = new String[] {"Normal", "18.5-25"};
	    table[5] = new String[] {"Overweight", "25-30"};
	    table[6] = new String[] {"Obese Class 1", "30-35"};
	    table[7] = new String[] {"Obese Class 2", "35-40"};
	    table[8] = new String[] {"Obese Class 3", ">40"};
	    
	    System.out.println();
	    for(final Object[] row : table)
	    {
	        System.out.format("%25s%15s%15s%n", row);
	    }
	}

	public static void main(String[] args) {
	 	 Scanner sc = new Scanner(System.in);
		 Body_Fat p = new Body_Fat();
		 Person s = new Person();
		 System.out.println("Enter Person Details"); //Getting Person Details
	     p.setPerson();
	     
	     char ch1,ch2;
	     while(true) // Making it Menu-Driven
	     {
	       	 System.out.println("\n\t Enter T to calculate Total Daily Energy Expenditure(Calories Burnt)");
	         System.out.println("\n\t Enter B to calculate Body Mass Index(BMI)");
	         System.out.println("\n\t Enter A to calculate Calories Burnt during a specific activity");
	         System.out.println("\n\t Enter C to calculate Calorie Intake Per Day");
	         System.out.println("\n\t Enter F to calculate Body Fat Percentage");
	         System.out.println("\n\t Enter E to exit main menu");
	         ch1 = sc.next().charAt(0);
	         switch(ch1) //Switch Case 
	          {
	            case 'T': s.setTotal_daily_energy_expenditure(); 
	                      break;
	            
	            case 'B': double bmi = s.setBody_mass_index();
	                      System.out.println("\n\tBody Mass Index(BMI) : " + bmi);
	                      bmi_table();
	                      break;
	            
	            case 'A': do // Using do while so that we can move back to main menu
	                       {
		            	        System.out.println("\n\t Enter W to calculate Calories Burnt during walking");
		            	        System.out.println("\n\t Enter J to calculate Calories Burnt during jogging");
		            	        System.out.println("\n\t Enter C to calculate Calories Burnt during cycling");
		            	        System.out.println("\n\t Enter S to calculate Calories Burnt during swimming");
		            	        System.out.println("\n\t Enter E to move back to main menu ");
		            	        ch2 = sc.next().charAt(0);
		            	        switch(ch2) // Nested Switch Case 
		            	        {
		            	          case 'W': s.setCb_walking();
		            	                    break;
		            	          case 'J': s.setCb_jogging();
		            	                    break;
		            	          case 'C': s.setCb_cycling();
		            	                    break;
		            	          case 'S': s.setCb_swimming();
		            	                    break;
		            	          default : System.out.println("\n\t Invalid Input, Please Re-Enter");
		            	        }
	            	        } while(ch2 != 'E');
	                      break;
	            
	            case 'C': s.getCalorie_intake();
	                      break;
	            
	            case 'F': p.setBody_fat();
	                      body_fat_table();
	                      break;
	                      
	            case 'E': System.exit(0);
	            
	            default : System.out.println("\n\t Invalid Input, Please Re-Enter");
	          }
	     }
	 }

}
