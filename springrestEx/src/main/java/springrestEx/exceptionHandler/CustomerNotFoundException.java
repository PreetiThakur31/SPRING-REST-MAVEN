package springrestEx.exceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
	
	  private static final long serialVersionUID = 100L;
	  
	  
	
	  public CustomerNotFoundException(String exception) {
		  super(exception);
		}


	 

	
		
        
        
}
