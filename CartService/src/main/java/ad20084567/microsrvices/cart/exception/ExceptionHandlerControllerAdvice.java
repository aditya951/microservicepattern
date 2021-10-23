package ad20084567.microsrvices.cart.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice // this class going to control all exception which happen in controller flow
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	ExceptionResponse handleResourceNotfoundexception(CustomException ex, HttpServletRequest re) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorMessage(ex.getMessage());
		exceptionResponse.setRequestURI(re.getRequestURI());

		return exceptionResponse;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	ExceptionResponse handleResourceNotfoundexception(Exception ex, HttpServletRequest re) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorMessage(ex.getMessage());
		exceptionResponse.setRequestURI(re.getRequestURI());

		return exceptionResponse;
	}

}