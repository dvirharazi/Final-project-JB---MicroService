package johnbryce.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import johnbryce.beans.Income;

@Repository
public class IncomeServiceDBDAO {
	
	@Autowired
	private IncomeRepository incomeRepository;

	public void storeIncome(Income income) {
		income.setId(0);
		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue()-1;
		int year = Year.now().getValue()-1900;
		income.setDate(new Date (year, month, day));
		incomeRepository.save(income);
	}
	
	public ArrayList<Income> viewAllIncomes() {
		return (ArrayList<Income>) incomeRepository.findAll();
	}

	public ArrayList<Income> viewCustomerIncome(int customerID) {
		return incomeRepository.findIncomeByCustomerID(customerID);
	}
	
	public ArrayList<Income> viewCompanyIncome(int companyID) {
		return incomeRepository.findIncomeByCompanyID(companyID);
	}
}
