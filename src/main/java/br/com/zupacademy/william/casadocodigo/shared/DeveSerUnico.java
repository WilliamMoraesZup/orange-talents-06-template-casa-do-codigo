package br.com.zupacademy.william.casadocodigo.shared;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CampoUnicoNoSistemaValidator.class)
public @interface DeveSerUnico {

    String campo();
    Class entidade();
    String message() default "Já existe esse registro no banco";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value() default "";
}