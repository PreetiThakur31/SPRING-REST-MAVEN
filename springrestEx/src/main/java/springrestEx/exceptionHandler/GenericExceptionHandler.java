package springrestEx.exceptionHandler;

import java.util.Date;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	  public final @ResponseBody CustomerErrorInformation handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
		
		CustomerErrorInformation errorDetails = new CustomerErrorInformation(new Date(), ex.getMessage(),
	        request.getDescription(false));
		
	    return errorDetails;
	  }
	
	@ExceptionHandler(value = CustomerNotSavedException.class)
	  public final @ResponseBody CustomerErrorInformation handleCustomerrNotSavedException(CustomerNotSavedException ex, WebRequest request) {
	
		CustomerErrorInformation errorDetails = new CustomerErrorInformation(new Date(), ex.getMessage(),
	        request.getDescription(false));
		
	    return errorDetails;
	  }
    
    
    
	@ExceptionHandler(value = NullPointerException.class)
	public final @ResponseBody CustomerErrorInformation handleAllExceptions(Exception ex, WebRequest request) {
		System.out.println(" 333333333   "+ex.getMessage());
		CustomerErrorInformation errorDetails = new CustomerErrorInformation(new Date(), ex.getMessage(),
	      request.getDescription(false));
		System.out.println("44444444   "+ex.getMessage());
		return errorDetails;
	  //return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
  
}
