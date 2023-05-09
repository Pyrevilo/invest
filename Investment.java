
public class Investment
{
    private double year1Deposit;
    private double year2Deposit;
    private double year3Deposit;
    int coinSelection;
 
    public void setCoinSelection(int inputSelection)
    {
        coinSelection = inputSelection;
    }
    public int getCoinSelection()
    {
        return(coinSelection);
    }

    public void setYear1Deposit(double inputYear1)
    {
        year1Deposit = inputYear1;
    }

    public void setYear2Deposit(double inputYear2)
    {
        year2Deposit = inputYear2;
    }

    public void setYear3Deposit(double inputYear3)
    {
        year3Deposit = inputYear3;
    }
 
    //names coins based on coin selection
    private double investProfit1, investProfit2, investProfit3, coinRate;
    String coinName;

    public String getCoinName()
    {
        if (coinSelection == 1)
        {
            coinName = "BestCoin";
        }
        else if (coinSelection == 2)
        {
            coinName = "SimpleCoin";
        }
        else if (coinSelection == 3)
        {
            coinName = "FastCoin";
        }
        return coinName;
    }

    //calculates investment rates of crypto
    public void calcInvestment()
    {
        if (coinSelection == 1)
        {
            coinRate = 0.18;
        }
        else if (coinSelection == 2)
        {
            coinRate = 0.12;
        }
        else if (coinSelection == 3)
        {
            coinRate = 0.15;
        }
        investProfit1 = year1Deposit*coinRate;
        investProfit2 = (year1Deposit + year2Deposit)*coinRate;
        investProfit3 = (year1Deposit + year2Deposit + year3Deposit)*coinRate;
    }

    //returns profits across 3 years
    public double getYear1Profit()
    {
        return investProfit1;
    }

    public double getYear2Profit()
    {
        return investProfit2;
    }

    public double getYear3Profit()
    {
        return investProfit3;
    }
}
