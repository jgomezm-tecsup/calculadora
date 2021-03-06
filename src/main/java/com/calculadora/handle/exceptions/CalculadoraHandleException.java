package com.calculadora.handle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.calculadora.dtos.MensajeError;
import com.calculadora.exceptions.NumeroFueraDeRangoException;
import com.calculadora.exceptions.OperationNotSupportException;

@ControllerAdvice
public class CalculadoraHandleException {

	@ExceptionHandler(OperationNotSupportException.class)
	public ResponseEntity<MensajeError> operationNotSupportException(OperationNotSupportException e) {
		
		MensajeError error = new MensajeError();
	
		error.setMensaje(e.getMessage());
		
		return new ResponseEntity<MensajeError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<MensajeError> numberFormatException(NumberFormatException e) {
		
		MensajeError error = new MensajeError();
	
		error.setMensaje("Los operadores deben ser numericos");
		
		return new ResponseEntity<MensajeError>(error,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NumeroFueraDeRangoException.class)
	public ResponseEntity<MensajeError> numeroFueraDeRangoException(NumeroFueraDeRangoException e) {
		
		MensajeError error = new MensajeError();
	
		error.setMensaje(e.getMessage());
		
		return new ResponseEntity<MensajeError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
}
