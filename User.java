public class User
{
    private String name;                     
    private Investment userInvestment;
    double annualSalary;
    double buyingPrice;
    double sellingPrice;
    int years;
    boolean resident;
    double taxRate;

    //gets user data to calculate tax bracket and CGT later
    public User()
    {
        userInvestment = new Investment(); 
    }
    public void setName(String inputName)
    {
        name = inputName;
    }
    public String getName()
    {
        return (name);
    }
    public void setAnnualSalary(double inputSalary)
    {
        annualSalary = inputSalary;
    }
    public double getAnnualSalary()
    {
        return (annualSalary);
    }
    public void setBuyingPrice(double inputBuyPrice)
    {
        buyingPrice = inputBuyPrice;
    }
    public double getBuyingPrice()
    {
        return buyingPrice;
    }
    public void setSellingPrice(double inputSellPrice)
    {
        sellingPrice = inputSellPrice;
    }
    public double getSellingPrice()
    {
        return sellingPrice;
    }
    public void setYears(int inputYears)
    {
        years = inputYears;
    }
    public int getYears()
    {
        return years;
    }
    public void setResident(boolean inputResident)
    {
        resident = inputResident;
    }
    public boolean getResident()
    {
        return resident;
    }

    //finds tax brackets for residents
    public void setTaxResident(double totalIncome)
    {
        if (totalIncome > 180000)
        {
            taxRate = 0.45;
        }
        else if (120000 < totalIncome)
        {
            taxRate = 0.37;
        }
        else if (45000 < totalIncome)
        {
            taxRate = 0.325;
        }
        else if (18000 < totalIncome)
        {
            taxRate = 0.19;
        }
        else taxRate = 0;
    }

    //tax brackets for non-residents
    public void setTaxNonResident(double totalIncome)
    {
        if (totalIncome > 180000)
        {
            taxRate = 0.45;
        }
        else if (120000 < totalIncome)
        {
            taxRate = 0.37;
        }
        else taxRate = 0.325;
    }
    public double getTaxRate()
    {
        return taxRate;
    }

    //calculates CGT privately
    private double profit, profitCGT, totalIncome, taxBracket, capitalGains;

    public double calcCGT()
    {
        profit = sellingPrice - buyingPrice;
        profitCGT = profit / years;
        totalIncome = annualSalary + profitCGT;
        if (resident == true)
        {
            setTaxResident(totalIncome);
        }
        else{
            setTaxNonResident(totalIncome);
        }
        taxBracket = getTaxRate();
        capitalGains = taxBracket*profitCGT;
        return capitalGains;
    }

    //get capital gains tax amount
    public double getCGT()
    {
        return calcCGT();
    }

    //get profit after tax
    public double getOverallProfit()
    {
        return (profitCGT - capitalGains);
    }
    
    //investment class access from here
    public void setInvestCoinSelection(int inputCoin)
    {
        userInvestment.setCoinSelection(inputCoin); 
    }
    public int getInvestCoinSelection()
    {
        return userInvestment.getCoinSelection(); 
    }

    //set yearly deposits
    public void setYear1Deposit(double inputDeposit1)
    {
        userInvestment.setYear1Deposit(inputDeposit1);
    }
    public void setYear2Deposit(double inputDeposit2)
    {
        userInvestment.setYear2Deposit(inputDeposit2);
    }
    public void setYear3Deposit(double inputDeposit3)
    {
        userInvestment.setYear3Deposit(inputDeposit3);
    }


    public void getPredictedProfit()
    {
        userInvestment.calcInvestment();
    }

    //get coin name
    public String getCoinName()
    {
        return(userInvestment.getCoinName());
    }

    //get profit for each year
 
    public double getYear1Profit()
    {
        return(userInvestment.getYear1Profit());
    }
    public double getYear2Profit()
    {
        return(userInvestment.getYear2Profit());
    }
    public double getYear3Profit()
    {
        return(userInvestment.getYear3Profit());
    }

}
