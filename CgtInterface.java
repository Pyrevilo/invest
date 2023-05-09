import java.lang.ref.Cleaner;
import java.util.*;

public class CgtInterface
{
    public void run()
    {
        Scanner console = new Scanner (System.in);
        User user;
        
        user = new User();

        // Set and get name of user
        String name;
        System.out.print("Name: ");
        name = console.nextLine();
        user.setName(name);
        
        //set and get annual salary
        double annualSalary;
        System.out.print("Annual Salary: ");
        annualSalary = console.nextDouble();
        //checks salaray is non zero
        while (annualSalary <= 0)
        {
            System.out.println("Invalid Number, please re-input: ");
            annualSalary = console.nextDouble();
        }
        user.setAnnualSalary(annualSalary);

        //get and set resident status
        boolean inputResident = true;
        String residentStatus;
        String yes = "yes";
        String no = "no";
        System.out.print("Are you a resident? ");
        residentStatus = console.next();

        //sets resident boolean and checks for yes or no
        while (!residentStatus.equalsIgnoreCase(no) && !residentStatus.equalsIgnoreCase(yes))
        {
            System.out.print("Please answer with yes or no: ");
            residentStatus = console.next();
        }
        if (residentStatus.equalsIgnoreCase(yes))
        {
            inputResident = true;
        }
        else if (residentStatus.equalsIgnoreCase(no))
        {
            inputResident = false;
        }

        user.setResident(inputResident);

        //get and set buying price
        double inputBuyPrice;
        System.out.print("What is the buying price? ");
        inputBuyPrice = console.nextDouble();
        //makes sure buy price is non zero
        while (inputBuyPrice <= 0)
        {
            System.out.print("Invalid Number, please re-input: ");
            inputBuyPrice = console.nextDouble();
        }
        user.setBuyingPrice(inputBuyPrice);

        //get and set selling price
        double inputSellPrice;
        System.out.print("What is the selling price? ");
        inputSellPrice = console.nextDouble();
        //checks sell price is higher than buy price and non zero
        while (inputSellPrice <= 0 || inputSellPrice <= inputBuyPrice)
        {
            System.out.print("Invalid number, please re-input: ");
            inputSellPrice = console.nextDouble();
        }
        user.setSellingPrice(inputSellPrice);

        //get and set number of years
        int inputYears;
        System.out.print("How many years? ");
        inputYears = console.nextInt();
        //check is non zero
        while (inputYears <= 0)
        {
            System.out.print("Invalid number, please re-input: ");
            inputYears = console.nextInt();
        }
        user.setYears(inputYears);


        //prints out user details
        System.out.println(" ");
        System.out.println("User Details:");
        System.out.println("Name = " + user.getName());
        System.out.println("Annual Salary: $"+ user.getAnnualSalary());
        System.out.println("Resident: " + user.getResident());

        //prints gap
        System.out.println(" ");

        //confirmation for coin selection
        System.out.println("Buying price: $" + user.getBuyingPrice());
        System.out.println("Selling price: $" + user.getSellingPrice());
        System.out.println("Years "+ user.getYears());

        //print gap
        System.out.println(" ");

        //Print Capital gains tax
        System.out.println("Capital Gains Tax: ");
        if (user.resident == true)
        {
            user.setTaxResident(annualSalary);
        }
        else
        {
            user.setTaxNonResident(annualSalary);
        }
        System.out.println("Tax Rate: "+ user.getTaxRate());
        System.out.println("CGT: $" + user.calcCGT());
        System.out.println("Profit: $" + user.getOverallProfit());

        //print gap
        System.out.println(" ");


        //***************************Code for investment starts here********************* */
        //prompt if user wants to invest in crypto

    
        String answer;
        System.out.print("Would you like to Invest? ");
        answer = console.next();
        //Ensures yes/no response. If no terminates program
        while (!answer.equalsIgnoreCase(no) && !answer.equalsIgnoreCase(yes))
        {
            System.out.print("Invalid repsonse. Please type yes or no. ");
            answer = console.next();
        }
        if (answer.equalsIgnoreCase(no))
        {
            return;
        }
        

        //prompt for investments over 3 years
        double inputYear1;
        double investmentBarrier = user.getOverallProfit();
        System.out.print("Initial Investment amount (Cannot be more than "+ investmentBarrier+"): $");
        inputYear1 = console.nextDouble();
        //makes sure investment value is positive and less than or equal to profit
        while (inputYear1 <= 0 || inputYear1 > investmentBarrier)
        {
            System.out.print("Invalid amount. Please input a valid number: $");
            inputYear1 = console.nextDouble();
        }
        user.setYear1Deposit(inputYear1);
        

        double inputYear2;
        System.out.print("Investment amount after first year: $");
        inputYear2 = console.nextDouble();
        //makes sure value is zero or greater
        while (inputYear2 < 0)
        {
            System.out.print("Invalid amount. Input must be Greater than or equal to zero: $");
            inputYear2 = console.nextDouble();
        }
        user.setYear2Deposit(inputYear2);

        double inputYear3;
        System.out.print("Investment amount after second year: $");
        inputYear3 = console.nextDouble();
        //makes sure value is zero or greater
        while (inputYear3 < 0)
        {
            System.out.print("Invalid amount. Input must be Greater than or equal to zero: $");
            inputYear3 = console.nextDouble();
        }
        user.setYear3Deposit(inputYear3);

        //prints interface
        System.out.println("Please choose a Cryptocurrency to invest in:");
        System.out.println("1: Best coin");
        System.out.println("2: Simple coin");
        System.out.println("3: Fast coin");

        //get and set coin choice of user
        int inputSelection;
        System.out.print("Enter Coin Selection: ");
        inputSelection = console.nextInt();
        //makes sure there is a valid selection of coins
        while (inputSelection > 3 || inputSelection <1)
        {
            System.out.print("Invalid selection, please choose a coin from 1 to 3: ");
            inputSelection = console.nextInt();
        }
        user.setInvestCoinSelection(inputSelection);

        user.getPredictedProfit();
        
        double year1 = user.getYear1Profit();
        double year2 = user.getYear2Profit();
        double year3 = user.getYear3Profit();
        String coinName = user.getCoinName();

        //prints interface
        System.out.println(" ");
        System.out.println("Predicted Profit for Investment in " + coinName);
        System.out.println("Years       Annual Profit        Total Profit");
        System.out.println("---------------------------------------------");
        System.out.println("1              $"+ year1 +"            $"+ year1);
        System.out.println("2              $"+ year2 +"            $"+ (year1 + year2));
        System.out.println("3              $"+ year3 +"            $"+ (year1 + year2 + year3));

    }

    public static void main(String[] args)
    {
        CgtInterface calc = new CgtInterface();
        calc.run();
    }
  

}
