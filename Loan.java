import java.util.*;
import java.io.*;
public class Loan implements Serializable {
 
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private Date loanDate;
 
	/**Costruct a loan*/ 
 	public Loan() {
		this(2.5, 1, 1000);
 	}
 
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) throws IllegalArgumentException 
	{
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Interest rate must be more than zero");
		if (numberOfYears <= 0) 
			throw new IllegalArgumentException("Number of years must be more than zero");
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan Amount must be more than zero");
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new Date();
   }
 
	public Loan(Loan1 loan){
		this.annualInterestRate = loan.getAnnualInterestRate();
		this.numberOfYears = (int)(loan.getNumberOfYears());
		this.loanAmount = loan.getLoanAmount();
		this.loanDate = loan.getLoanDate();
	}
 
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
 
	public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException {
 
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Interest rate must be more than zero");
 
		this.annualInterestRate = annualInterestRate;
	}
 
	public double getNumberOfYears() {
		return numberOfYears;
	}
 
	public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
 
		if (numberOfYears <= 0) 
			throw new IllegalArgumentException("Number of years must be more than zero");
 
		this.numberOfYears = numberOfYears;
   }
 
	public double getLoanAmount() {
		return loanAmount;
	}
 
	public void setLoanAmount(double loanAmount) throws IllegalArgumentException {
 
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan Amount must be more than zero");
 
		this.loanAmount = loanAmount;
   }
 
	//Methods
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
		(Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
		return monthlyPayment;
	}
 
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
   }
 
	public Date getLoanDate() {
 		return loanDate;
   }
   
 }
 
