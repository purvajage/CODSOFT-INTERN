import java.text.DecimalFormat;

public class Validation    
{	
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");


	public void setAccountNumber(final int account_number)
	{   
		this.account_number = account_number;
	}
	public int getAccountNumber() 
	{
		return account_number;
	}

    
	public void setPinNumber(final short pin_number)
	{
		this.pin_number = pin_number;
	}
	public int getPinNumber() 
	{
		return pin_number;
	}

 
	public double getCurrentBalance() 
	{
		return initial_current_balance;
	}


	public double getSavingBalance() 
	{
		return initial_savings_balance;
	}

	public double CurrentBalanceWithdrawal(final double amount)
	{
		initial_current_balance = (initial_current_balance - amount);
		return initial_current_balance;
	}
    public double SavingsBalanceWithdrawal(final double amount)        
	{
		initial_savings_balance = (initial_savings_balance - amount);
		return initial_savings_balance;
	}


    public double CurrentBalanceDeposit(final double amount)            
	{
		initial_current_balance = (initial_current_balance + amount);
		return initial_current_balance;
	}  
    public double SavingsBalanceDeposit(final double amount)            
	{
		initial_savings_balance = (initial_savings_balance + amount);
		return initial_savings_balance;
	}

  public void CurrentWithdrawFunds()  throws InterruptedException
	{   
		System.out.println("Your Current Account balance is : " + moneyFormat.format(initial_current_balance));
		System.out.print("Enter your amount to withdraw : ");
        double amount = Atm.input.nextDouble();
        
		if((initial_current_balance - amount) > 0) 
		{
			CurrentBalanceWithdrawal(amount);
			System.out.println("\nYour updated Current Account balance : " + moneyFormat.format(initial_current_balance));
			Thread.sleep(600);
			System.out.println("\nThank u , Returned to Account Type");
		}
		else if((initial_current_balance - amount) == 0)
			System.out.println("\007"+"\n\t\tYou Cannot Withdraw Zero");
		else
		    System.out.println("\007"+"\n**INSUFFICIENT BALANCE :(");
	}


	public void SavingsWithdrawFunds()  throws InterruptedException
	{   
		System.out.println("Your Saving Account balance is : " + moneyFormat.format(initial_savings_balance));
		System.out.print("Enter your amount to withdraw : ");
        double amount = Atm.input.nextDouble();
        
		if((initial_savings_balance - amount) > 0) 
		{
			SavingsBalanceWithdrawal(amount);
			System.out.println("Your updated Savings Account balance : " + moneyFormat.format(initial_savings_balance));
			Thread.sleep(600);
			System.out.println("\nThank u , Returned to Account Type");
		} 
		else if((initial_savings_balance - amount) == 0) 
			System.out.println("\007"+"\n\t\tYou Cannot Withdraw Zero");
		else
		    System.out.println("\007"+"\n**INSUFFICIENT BALANCE :(");
	}

  public void CurrentDepositFunds() throws InterruptedException
	{
		System.out.println("Your Current Account balance is : " + moneyFormat.format(initial_current_balance));
		System.out.print("Enter your amount to deposit : "); Atm.delay();
        double amount = Atm.input.nextDouble();
        
		if((initial_current_balance + amount) > 0) 
		{
			CurrentBalanceDeposit(amount);
			System.out.println("   [Amount is successfully deposited in your current account]   "); 
			Thread.sleep(600); 
			System.out.println("\nYour updated Current Account balance : " + moneyFormat.format(initial_current_balance));
		} 
		else 
		{
			System.out.println("\007"+"\nYour entered amount is lower or equals Zero(0)");
        }       
	}


	public void SavingsDepositFunds() throws InterruptedException
	{
		System.out.println("Your Savings Account balance is : " + moneyFormat.format(initial_savings_balance));
		System.out.print("Enter your amount to deposit : "); Atm.delay();
        double amount = Atm.input.nextDouble();
        
		if((initial_current_balance + amount) > 0) 
		{
			SavingsBalanceDeposit(amount);
			System.out.println("   [Amount is successfully deposited in your savings account]   "); 
			Thread.sleep(600);
			System.out.println("\nYour updated Savings Account balance : " + moneyFormat.format(initial_savings_balance));
		} 
		else 
		{
			System.out.println("\007"+"\nYour balance is lower or equals Zero(0)");
        }       
	}	
	
   
	private int account_number;
	private short pin_number;
	private double initial_current_balance = 0;
	private double initial_savings_balance = 0;
}
