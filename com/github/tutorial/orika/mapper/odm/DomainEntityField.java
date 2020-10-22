package orika.github.tutorial.orika.odm;

import lombok.Data;

@Data
public class DomainEntityField {
    private String source;
    private String target;
    private String nullable;
    private String exclude;
    private String converter;
}
