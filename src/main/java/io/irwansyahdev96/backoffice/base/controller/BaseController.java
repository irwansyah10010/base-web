package io.irwansyahdev96.backoffice.base.controller;

import java.util.Map;
import org.springframework.ui.ModelMap;

import io.irwansyahdev96.backoffice.base.controller.pattern.Execution;
import io.irwansyahdev96.backoffice.base.controller.pattern.SetUp;
import io.irwansyahdev96.backoffice.business.constant.PathFeatures;





public class BaseController implements 
                            SetUp, Execution{
    
    private ModelMap modelMap;
    private String file;
    private Map<String, Object> attribute;
    private PathFeatures pathFeatures;

    // full datatablebusiness
    protected Map<String, Object> attributeFullBusiness;

    /**
     * set up file, location dan inject parameter to template engine
     */
    @Override
    public SetUp modelMap(ModelMap model) {
        this.modelMap = model;
        
        return this;
    }

    @Override
    public SetUp modelMap(ModelMap model, Map<String, Object> attribute) {
        this.modelMap = model;
        this.attribute = attribute;
        
        return this;
    }

    @Override
    public SetUp injectAttribute(Map<String, Object> attribute){
        this.attribute = attribute;

        return this;
    }

    @Override
    public SetUp file(String file) {
        this.file = file;
        
        return this;
    }

    @Override
    public SetUp content(PathFeatures pathFeatures) {
        this.pathFeatures = pathFeatures;

        return this;
    }

    @Override
    public Execution endSetUp() {
        return this;
    }

    @Override
    public String render() {

        // added require attribute 
        if(pathFeatures != null){
            String relativePath = pathFeatures.getPath().substring(1);

            modelMap.put("title", pathFeatures.getTitle());
            modelMap.put("content", pathFeatures.getIndexPath());
            modelMap.put("hierarchyModule", relativePath.replace("-", " ").split("/"));
        }

        // added inject attribute
        if(attribute != null)
            modelMap.putAll(attribute);
        
        // other attribute (opt)
        if(attributeFullBusiness != null)
            modelMap.putAll(attributeFullBusiness);

        if(file == null)
            return "baseboard";

        return file;
    }

    @Override
    public String redirect(){
        if(file == null)
            return "redirect:/";

        return "redirect:/"+file;
    }

    /**
     * getter
     */
    public ModelMap getModelMap() {
        return modelMap;
    }

    public String getFile() {
        return file;
    }

    public Map<String, Object> getAttribute() {
        return attribute;
    }

    public PathFeatures getPathFeatures() {
        return pathFeatures;
    }
    
}
