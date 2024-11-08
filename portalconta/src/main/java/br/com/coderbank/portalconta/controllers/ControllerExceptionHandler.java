package br.com.coderbank.portalconta.controllers;

import br.com.coderbank.portalconta.exceptions.ContaJaExisteException;
import br.com.coderbank.portalconta.responses.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler({ContaJaExisteException.class})
    public ErrorResponseDTO conflict(final Throwable exception) {

        final var exceptionMessage = exception.getMessage();

        return new ErrorResponseDTO(exceptionMessage, System.currentTimeMillis());

    }
}
