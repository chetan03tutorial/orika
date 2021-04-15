package com.lbg.epscw.mortgagesrvc.odm;

import com.lbg.epscw.mortgagesrvc.exception.InvalidMappingDefinition;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class FieldMappingValidator {

    private static final String INVALID_MAPPER_NAME = "Mapper Name cannot be null";
    private static final String INVALID_SOURCE_TARGET = "Invalid Source/Target Definition";

    public void validateMapping(FieldMapping fieldMapping){

        Predicate<Field> sourcePredicate = f -> f.getSource() == null ? Boolean.TRUE: Boolean.FALSE;
        Predicate<Field> targetPredicate = f -> f.getTarget() == null ? Boolean.TRUE: Boolean.FALSE;
        boolean invalidSourceTarget = fieldMapping.getMapping().stream().anyMatch(sourcePredicate.or(targetPredicate));
        if(invalidSourceTarget){
            throw new InvalidMappingDefinition(INVALID_SOURCE_TARGET);
        }
        if(StringUtils.isEmpty(fieldMapping.getMapperName())){
            throw new InvalidMappingDefinition(INVALID_MAPPER_NAME);
        }
    }
}
