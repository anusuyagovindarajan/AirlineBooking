package com.company.utility;


import com.company.utility.Future;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;


public class LocalDateFutureValidator implements ConstraintValidator<Future,LocalDate> {


    @Override
    public void initialize(final Future constraintAnnotation) {

    }

    @Override
    public boolean isValid(final LocalDate localDate, final ConstraintValidatorContext context) {
        LocalDate today = LocalDate.now();
        return localDate.isEqual(today) || localDate.isAfter(today);
    }
}
