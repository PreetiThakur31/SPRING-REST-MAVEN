package springrestEx.config;

/**
 * 
 * @author preeti
 * This class will provide response to cliente payment request.
 */
public class PaymentResponse {

	
	private String status;
	private Integer code;
	private long finalPrice;
	 
	public String getStatus() {
	  return status;
	 }
	
	public void setStatus(String status) {
	  this.status = status;
	 }
	
	public Integer getCode() {
	  return code;
	 }
	
	public void setCode(Integer code) {
	  this.code = code;
	 }
	
	public long getFinalPrice() {
		  return finalPrice;
	}
		
	public void setFinalPrice(long finalPrice) {
		  this.finalPrice = finalPrice;
	}
		
}
