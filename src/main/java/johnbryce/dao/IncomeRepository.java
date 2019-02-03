package johnbryce.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import johnbryce.beans.Income;

public interface IncomeRepository extends CrudRepository<Income, Integer> {

	@Query("select i from Income i where i.clientId= ?1 and i.description!=0")
	ArrayList<Income> findIncomeByCompanyID(int companyID);
	
	@Query("select i from Income i where i.clientId= ?1 and i.description=0")
	ArrayList<Income> findIncomeByCustomerID(int customerID);
}
