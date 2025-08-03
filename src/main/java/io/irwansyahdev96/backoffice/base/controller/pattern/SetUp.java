package io.irwansyahdev96.backoffice.base.controller.pattern;

import java.util.Map;

import org.springframework.ui.ModelMap;

import io.irwansyahdev96.backoffice.business.constant.PathFeatures;



public interface SetUp{
    SetUp modelMap(ModelMap model);
    SetUp modelMap(ModelMap model, Map<String, Object> attribute);
    SetUp injectAttribute(Map<String, Object> attribute);
    SetUp file(String file);
    SetUp content(PathFeatures pathFeatures);

    Execution endSetUp();
}
