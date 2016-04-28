package br.com.rrc.explore.enterprise.exceptions;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rrc.explore.enterprise.utils.MessageByLocaleService;

@ControllerAdvice
public class ErrorHandler {

	@Inject
	MessageByLocaleService messageByLocaleService;
	
	private final Log LOG = LogFactory.getLog(this.getClass());

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String handleException(Exception ex){
		LOG.error(ex.getMessage(), ex);
		return ex.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BindException.class)
	@ResponseBody
	public ValidationError handleException(BindException ex){
		BindingResult result = ex.getBindingResult();
		LOG.error(ex.getMessage(), ex);
		List<FieldError> fieldErrors = result.getFieldErrors();
		return processFieldErrors(fieldErrors);
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationError processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		LOG.error(ex.getMessage(), ex);
		List<FieldError> fieldErrors = result.getFieldErrors();
		return processFieldErrors(fieldErrors);
	}

	public ValidationError processFieldErrors(List<FieldError> fieldErrors) {
		
		ValidationError dto = new ValidationError();

		for (FieldError fieldError: fieldErrors) {
			dto.addFieldError(fieldError.getField(), messageByLocaleService.getMessage(fieldError.getDefaultMessage()));
		}

		return dto;
	}
}
