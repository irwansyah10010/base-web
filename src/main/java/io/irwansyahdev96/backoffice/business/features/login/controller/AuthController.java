package io.irwansyahdev96.backoffice.business.features.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.irwansyahdev96.backoffice.base.controller.BaseController;
import io.irwansyahdev96.backoffice.business.constant.UriFeatures;




@Controller
public class AuthController extends BaseController{
    
    @PreAuthorize("!isAuthenticated()")
    @RequestMapping(value = UriFeatures.LOGIN, method = RequestMethod.GET)
    public String login(){

        return file("login")
                    .endSetUp().render();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            new SecurityContextLogoutHandler().logout(request, response, auth);
        
        return file("login").
            endSetUp().redirect();
    }
}
