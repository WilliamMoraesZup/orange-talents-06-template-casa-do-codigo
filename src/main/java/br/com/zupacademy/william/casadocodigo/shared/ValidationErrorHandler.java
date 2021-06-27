package br.com.zupacademy.william.casadocodigo.shared;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

@Autowired
    private MessageSource messageSource;

@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorsOutputDto handleValidationError(MethodArgumentNotValidException exception){
 List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
 List<FieldError> fieldErrorList= exception.getBindingResult().getFieldErrors();

return buildValidationErrors(globalErrors, fieldErrorList);
}

    private ValidationErrorsOutputDto buildValidationErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrorList) {
   ValidationErrorsOutputDto validationErrors = new ValidationErrorsOutputDto();
   globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));

   fieldErrorList.forEach(error -> {
       String errorMessage = getErrorMessage(error);
       validationErrors.addFieldError(error.getField(), errorMessage);
   });
   return validationErrors;
    }

private String getErrorMessage(ObjectError error){
    return messageSource.getMessage(error, LocaleContextHolder.getLocale());
}
}
