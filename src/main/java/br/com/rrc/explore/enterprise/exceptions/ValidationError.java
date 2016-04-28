package br.com.rrc.explore.enterprise.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError {
	
	public ValidationError() {
		super();
	}

	public ValidationError(List<FieldError> fieldErrors) {
		super();
		this.fieldErrors = fieldErrors;
	}

	private List<FieldError> fieldErrors = new ArrayList<FieldError>();

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
	
	public void addFieldError(FieldError fieldError) {
		if (this.fieldErrors == null){
			this.fieldErrors = new ArrayList<FieldError>();
		}
		this.fieldErrors.add(fieldError);
	}
	
	public void addFieldError(String campo, String mensagem) {
		if (this.fieldErrors == null){
			this.fieldErrors = new ArrayList<FieldError>();
		}
		this.fieldErrors.add(new FieldError(campo, mensagem));
	}
}
