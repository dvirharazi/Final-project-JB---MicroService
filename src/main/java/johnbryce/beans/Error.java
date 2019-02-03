package johnbryce.beans;

import org.springframework.http.HttpStatus;

public class Error {
	private String message;
	private int status;

	public Error() {}

	public Error(String message, int status) {
		setMessage(message);
		setStatus(status);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public static Error getServerError(Exception ex) {
		return new Error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
