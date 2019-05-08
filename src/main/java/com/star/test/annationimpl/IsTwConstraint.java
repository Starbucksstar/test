package com.star.test.annationimpl;

import com.star.test.annotation.IsTw;
import com.star.test.model.InputDTO;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsTwConstraint implements ConstraintValidator<IsTw, InputDTO> {
    boolean requeired = false;

    @Override
    public void initialize(IsTw constraintAnnotation) {
        requeired = constraintAnnotation.required();

    }

    @Override
    public boolean isValid(InputDTO inputDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (requeired) {
            if (StringUtils.isEmpty(inputDTO.getName()) || StringUtils.isEmpty(inputDTO.getPwd()) || inputDTO.getId() == 0L) {
                return false;
            }
        }
        return true;

    }
}
