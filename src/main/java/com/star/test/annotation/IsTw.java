package com.star.test.annotation;

import com.star.test.annationimpl.IsTwConstraint;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Constraint(validatedBy = {IsTwConstraint.class})
public @interface IsTw {

    boolean required() default  true;
    String message() default "TW入参格式错误";


}
