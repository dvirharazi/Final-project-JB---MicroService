package johnbryce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import johnbryce.beans.Error;
import johnbryce.beans.Income;
import johnbryce.dao.IncomeServiceDBDAO;

@RestController
@RequestMapping("income")
public class IncomesController {

	@Autowired
	private IncomeServiceDBDAO serviceDBDAO;

	@GetMapping
	public ResponseEntity<?> viewAllIncome() {
		try {
			return new ResponseEntity<>(serviceDBDAO.viewAllIncomes(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Error.getServerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getAllCustomerIncome(@PathVariable("id") int customerID) {
		try {
			return new ResponseEntity<> (serviceDBDAO.viewCustomerIncome(customerID), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(Error.getServerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getAllCompanyIncome(@PathVariable("id") int companyID) {
		try {
			return new ResponseEntity<> (serviceDBDAO.viewCompanyIncome(companyID), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(Error.getServerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> storeIncome(@RequestBody Income income) {
		try {
			serviceDBDAO.storeIncome(income);
			return new ResponseEntity<>(HttpStatus.CREATED);
			} catch (Exception e) {
			return new ResponseEntity<>(Error.getServerError(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
