package io.irwansyahdev96.backoffice.business.features.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.irwansyahdev96.backoffice.business.FullBusinessController;
import io.irwansyahdev96.backoffice.business.constant.*;
import io.irwansyahdev96.backoffice.business.features.user.dto.UserListDto;
import io.irwansyahdev96.backoffice.business.features.user.service.UserService;
import io.irwansyahdev96.backoffice.business.pojo.PagePojoResponse;
import io.irwansyahdev96.backoffice.business.pojo.PageRequestPojo;

@Controller
@RequestMapping(UriFeatures.USER)
public class UserController extends FullBusinessController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String index(ModelMap modelMap){
        List<UserListDto> data = new ArrayList<>();
        String[] headerDatatables ={"#","Username","Full Name","Status","Is Login?","Created Date","Last Login Date","Action"};

        return addTemplate("filter","/filter/user")
                .addTemplate("datatable","/datatable")
                .addCollection("headerDatatables", headerDatatables)
                .addData("datatables", data).endBusiness()
                .modelMap(modelMap)
                .content(PathFeatures.USER).endSetUp()
                .render();
    }
    
    @ResponseBody
    @PostMapping("/datatable")
    public ResponseEntity<PagePojoResponse> datatable(@RequestBody PageRequestPojo request){
        request.setDraw(1);
        return new ResponseEntity<>(userService.getAll(request), HttpStatus.OK);
    }
}
