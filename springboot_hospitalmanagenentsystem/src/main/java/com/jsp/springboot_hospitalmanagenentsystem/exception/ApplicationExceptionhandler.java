package com.jsp.springboot_hospitalmanagenentsystem.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.springboot_hospitalmanagenentsystem.util.Responsestructure;

@ControllerAdvice
public class ApplicationExceptionhandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Responsestructure<String>> idnotfoundexception(IdNotFoundException exception) {
		Responsestructure<String> responseStructure=new Responsestructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("id not found");
		return new ResponseEntity<Responsestructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Responsestructure<String>> nosuchelementexception(NoSuchElementException exception){
		Responsestructure<String> responseStructure=new Responsestructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("no element found");
		return new ResponseEntity<Responsestructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<String, String>();
		for(ObjectError er:errors){
			String fieldName=((FieldError)er).getField();
			String message=((FieldError)er).getDefaultMessage();
			
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Responsestructure<String>> handleConstraintViolationException(ConstraintViolationException exception) {
		Responsestructure<String> responseStructure=new Responsestructure<>();
		responseStructure.setMessage(exception.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("this filed should not be null or blank");
		return new ResponseEntity<Responsestructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
		
		
	}
		
	}

