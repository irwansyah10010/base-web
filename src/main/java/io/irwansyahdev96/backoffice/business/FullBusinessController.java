package io.irwansyahdev96.backoffice.business;

import java.util.HashMap;
import java.util.Map;

import io.irwansyahdev96.backoffice.base.controller.BaseController;
import io.irwansyahdev96.backoffice.base.controller.pattern.SetUp;




public class FullBusinessController extends BaseController 
        implements Business{

    private Map<String,Object> attribute;

    private Map<String,Object> validateAndCreateMap(Map<String, Object> att){
        if(att == null)
            return new HashMap<>();
        
        return att;
    }

    @Override
    public Business addTemplate(String parameterName, String filename){
        attribute = validateAndCreateMap(attribute);

        attribute.put(parameterName, "/component".concat(filename));        

        return this;
    }

    @Override
    public Business addTemplates(String parameterName){
        

        return this;
    }

    @Override
    public Business addCollection(String parameterName, Object... colections) {
        attribute = validateAndCreateMap(attribute);

        attribute.put(parameterName, colections);

        return this;
    }

    @Override
    public Business addData(String parameterName, Object data) {
        attribute = validateAndCreateMap(attribute);

        attribute.put(parameterName, data);

        return this;
    }

    @Override
    public SetUp endBusiness() {
        this.attributeFullBusiness = attribute;
        
        return this;
    }

}
