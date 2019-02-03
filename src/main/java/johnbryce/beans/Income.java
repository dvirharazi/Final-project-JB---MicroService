package johnbryce.beans;
import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Income")
public class Income {
	
	private long id;
	private int clientId;
	private String name;
	private IncomeType description;
	private double amount;
	private Date date;
	
	
	public Income() { }
	
	public Income (int clientId,String name, IncomeType description, double amount) {
		setClientId(clientId);
		setName(name);
		setDescription(description);
		setAmount(amount);
		
	}
	
	public Income (int clientId,String name , IncomeType description, double amount, Date date) {
		setClientId(clientId);
		setName(name);
		setDescription(description);
		setAmount(amount);
		setDate(date);
	}
	
	public Income(long id, int clientId, String name, IncomeType description, double amount, Date date) {
		this(clientId ,name , description, amount, date );
		setId(id);
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column (nullable = false)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column (nullable = false)
	public int getClientId() {
		return clientId;
	}
	
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	@Column (nullable = false)
	public IncomeType getDescription() {
		return description;
	}
	
	public void setDescription(IncomeType description) {
		this.description = description;
	}
	
	@Column (nullable = false)
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column (nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("ID: " + id + ", clientId: " + clientId + ", Description: " + description + ", Amount: " + amount + ", Date of Operation: " + date);
	}
	
	public String toString() {
		return "ID: " + id + ", clientId: " + clientId + ", Description: " + description + ", Amount: " + amount + ", Date of Operation: " + date;
	}
	
}