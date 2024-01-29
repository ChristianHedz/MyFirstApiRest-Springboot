package org.chris.myfirstapirest.api.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName){
        super(String.format("No se encontraron %s en el sistema",resourceName));
        this.resourceName = resourceName;
    }
    public ResourceNotFoundException(String resourceName,String fieldName, Long fieldValue){
        super(String.format("%s no fue encontrado en el sistema con %s=%s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName =fieldName;
        this.fieldValue = fieldValue;
    }


}
