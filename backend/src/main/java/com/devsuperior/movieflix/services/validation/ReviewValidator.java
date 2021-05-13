package com.devsuperior.movieflix.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.resources.exceptions.FieldMessage;

public class ReviewValidator implements ConstraintValidator<ReviewValid, ReviewDTO> {

	@Override
	public boolean isValid(ReviewDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
		
		return list.isEmpty();
	}

}
