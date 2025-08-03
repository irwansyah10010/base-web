package io.irwansyahdev96.backoffice.business.features.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.irwansyahdev96.backoffice.base.controller.BaseController;
import io.irwansyahdev96.backoffice.business.constant.*;


@Controller
@RequestMapping(UriFeatures.HOME)
public class HomeController extends BaseController{
    
    @GetMapping("")
    public String index(ModelMap model){

        // opt att
        // Map<String, Object> inject = new HashMap<>();

        return modelMap(model)
                .content(PathFeatures.HOME).endSetUp()
                .render();
    }
}
