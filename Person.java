package calorie_calculator;

import java.util.Scanner;

public class Person {
    Scanner sc = new Scanner(System.in);
    float height, weight, activity_factor; //activity factor is a multiplier that helps in calculation of calories burnt
    int age, activity;
    boolean lose = true;
    char sex;
    double calorie_intake_mild_gain, calorie_intake_moderate_gain, calorie_intake_mild, calorie_intake_moderate, total_daily_energy_expenditure, basal_metabolic_rate, body_mass_index; // calories burnt in a day
    float cb_cycling, cb_walking, cb_jogging, cb_swimming; //cb = calories burnt during specific exercise

    public void setPerson()
    {
        System.out.print("\n\tEnter your height (in cms) : ");
        height = sc.nextFloat(); // getting height
        System.out.print("\tWeight (in kgs) : ");
        weight = sc.nextFloat(); // getting weight
        System.out.print("\tSex (M/F) : ");
        sex = sc.next().charAt(0); // charAt(0) gets zeroth index value
        System.out.print("\tAge : ");
        age = sc.nextByte(); // getting age
        System.out.print("""

                \tExercise: 15-30 minutes of elevated heart rate activity.
                \tIntense exercise: 45-120 minutes of elevated heart rate activity.
                \tVery intense exercise: 2+ hours of elevated heart rate activity.""");  // telling the user what Intense and Very Intense mean
        System.out.print("\n\n\t1. Sedentary" + // 1.2
                "\n\t2. Mild Activity(1-3 time a week)" + // 1.325
                "\n\t3. Moderate Activity(4-5 time a week)" + // 1.45
                "\n\t4. Active Activity(6-7 time a week)" + // 1.575
                "\n\t5. Intense Activity(6-7 intense workout days)" + // 1.7
                "\n\t6. Very Intense Activity(Intense daily activity)" + // 1.925
                "\n\tEnter choice : "); // getting their value
        activity = sc.nextByte();
        while(activity < 1 || activity > 6) // input validity
        {
            System.out.print("\tInput invalid" +
                    "\n\tEnter from 1 to 6 : ");
            activity = sc.nextByte();
        }
        switch (activity) {
            case 1 -> activity_factor = (float) 1.2;
            case 2 -> activity_factor = (float) 1.325;
            case 3 -> activity_factor = (float) 1.45;
            case 4 -> activity_factor = (float) 1.575;
            case 5 -> activity_factor = (float) 1.7;
            case 6 -> activity_factor = (float) 1.925; // assigning value for activity factor based on activity
        }
        System.out.print("\tGain or Lose (G/L) : ");
        char gol = sc.next().charAt(0);
        while(gol != 'G' && gol != 'g' && gol != 'L' && gol != 'l') // input validity
        {
            System.out.println("\tInput invalid" +
                    "\n\tEnter 'G' / 'g' / 'L' / 'l' : ");
            gol = sc.next().charAt(0);
        }
        if (gol == 'G' || gol == 'g')
            lose = false;
    }

    //BMR calculator
    public double setBasal_metabolic_rate() // function to calculate BMR
    {
        if(sex == 'm' || sex == 'M') // calculating BMR
            basal_metabolic_rate = 10 * weight + 6.25 * height - 5 * age + 5;
        else
            basal_metabolic_rate = 10 * weight + 6.25 * height - 5 * age - 161;
        return basal_metabolic_rate;
    }

    public void setTotal_daily_energy_expenditure() // function to calculate tdee which is the same as calories burnt
    {
        total_daily_energy_expenditure = setBasal_metabolic_rate() * activity_factor; // calculating tdee
        System.out.println("\n\tAverage Calorie Burnt per Day : " + total_daily_energy_expenditure);
    }

    public double setBody_mass_index()  // function to calculate body mass index
    {
        body_mass_index = (weight * 100 * 100) / (height * height); // calculating BMI
        return body_mass_index;
    }

    public void BMI_analytics() // analysing and printing BMI result
    {
        double bmi = setBody_mass_index();
        if(bmi < 16)
            System.out.println("\n\t" + bmi + " - Severe Thinness");
        else if(bmi < 17)
            System.out.println("\n\t" + bmi + " - Moderate Thinness");
        else if(bmi < 18.5)
            System.out.println("\n\t" + bmi + " - Mild Thinness");
        else if(bmi < 25)
            System.out.println("\n\t" + bmi + " - Normal");
        else if(bmi < 30)
            System.out.println("\n\t" + bmi + " - Overweight");
        else if(bmi < 35)
            System.out.println("\n\t" + bmi + " - Obese Class I");
        else if(bmi < 40)
            System.out.println("\n\t" + bmi + " - Obese Class II");
        else
            System.out.println("\n\t" + bmi + " - Obese Class III"); // analysis of bmi
    }
    public void setCb_cycling() // function to calculate calories spent while cycling
    {
        System.out.print("\n\tEnter duration (in hrs) : ");
        float duration = sc.nextFloat();
        cb_cycling = (float) (weight * 2.2 * 1.92 * 2 * duration);  //2.2 for lbs to kgs, 1.92 * 2 for calories used per hour
        System.out.println("Energy Spent from cycling for " + duration + " hrs is: " + cb_cycling);
    }

    public void setCb_walking() // function to calculate calories spent while walking
    {
        System.out.print("\n\tEnter duration of walk(in hrs) : ");
        float duration = sc.nextFloat();
        cb_walking = (float) (weight * 2.2 * 1.72 * duration); // 2.2 for lbs to kgs, 1.72 for calories per hour
        System.out.println("Energy Spent from walking for " + duration + " hrs is: " + cb_walking);
    }

    public void setCb_swimming() // function to calculate calories spent while swimming
    {
        System.out.print("\n\tEnter duration of swim(in hrs) : ");
        float duration = sc.nextFloat();
        cb_swimming = (float) (weight * 2.2 * 2.76 * duration); // 2.2 for lbs to kgs, 2.76 calories per hour
        System.out.println("Energy Spent from swimming for " + duration + " hrs is: " + cb_swimming);
    }

    public void setCb_jogging() // function to calculate calories spent while jogging
    {
        System.out.print("\n\tEnter duration of jog(in hrs) : ");
        float duration = sc.nextFloat();
        cb_jogging = (float) (weight * 2.2 * 5.7 * duration); // 2.2 for kgs to pounds, 5.7 for calories per hour
        System.out.println("Energy Spent from jogging for " + duration + " hrs is: " + cb_jogging);
    }

    public void setCalorie_intake() // function to calculating calorie intake for gaining or losing weight
    {
        if(lose) // calculating for losing weight
        {
            calorie_intake_mild = total_daily_energy_expenditure * 0.91; // 0.91 is the factor to reduce 0.25 kg per week
            calorie_intake_moderate = total_daily_energy_expenditure * 0.82; // 0.82 is the factor to reduce 0.5 kg per week
        }
        else  // calculating for gaining weight
        {
            calorie_intake_mild_gain = total_daily_energy_expenditure * 1.15; // 1.15 is the factor to increase 0.25 kg per week
            calorie_intake_moderate_gain = total_daily_energy_expenditure * 1.20; // 1.20 is the factor to increase 0.5 kg per week
        }
    }

    public void getCalorie_intake() // function to printing calorie intake for gaining or losing weight
    {
        if(lose) // printing for losing weight
        {
            System.out.println("\n\tFor mild weight loss     : " + calorie_intake_mild + " (-9%)");
            System.out.println("\n\tFor moderate weight loss : " + calorie_intake_moderate + " (-18%)");
        }
        else  // printing for gaining weight
        {
            System.out.println("\n\tFor mild weight gain     : " + calorie_intake_mild_gain + " (+15%)");
            System.out.println("\n\tFor moderate weight gain : " + calorie_intake_moderate_gain + " (+20%)");
        }
    }
}

class Body_Fat extends Person // Body fat class inherits class Person
{
    public double body_fat;
    public void setBody_fat() // function to calculate body fat
    {
        float neck_size, waist_size, hip_size;
        System.out.print("\n\tNeck (in cm) : ");
        neck_size = sc.nextFloat(); // getting neck size
        System.out.print("\n\tWaist (in cm) : ");
        waist_size = sc.nextFloat(); // getting waist size
        if(sex == 'm' || sex == 'M') // computing body fat for men
            body_fat = (495/(1.0324 - 0.19077 * Math.log10(waist_size - neck_size) + 0.15456 * Math.log10(height))) - 450;
        else // computing body fat for women
        {
            System.out.print("\n\tHip (in cm) : ");
            hip_size = sc.nextFloat(); // getting hip size (only for women)
            body_fat = (495/(1.29579 - 0.35004 * Math.log10(waist_size + hip_size - neck_size) + 0.22100 * Math.log10(height))) - 450;
        }
        System.out.println("\n\tBody fat % : " + body_fat); // printing body fat percentage
    }
}

