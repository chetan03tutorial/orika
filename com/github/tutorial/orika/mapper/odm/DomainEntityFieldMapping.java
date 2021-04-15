package com.lbg.epscw.mortgagesrvc.odm;

import lombok.Data;

import java.util.List;

@Data
public class FieldMapping {
    private String mapperName;
    private List<Field> mapping;
}
