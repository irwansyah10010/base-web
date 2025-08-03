package io.irwansyahdev96.backoffice.business.features.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import io.irwansyahdev96.backoffice.business.features.user.dto.RoleListDto;
import io.irwansyahdev96.backoffice.business.features.user.service.RoleService;
import io.irwansyahdev96.backoffice.business.pojo.PagePojoResponse;
import io.irwansyahdev96.backoffice.business.pojo.PageRequestPojo;

@Controller
@RequestMapping(UriFeatures.ROLE)
public class RoleController extends FullBusinessController{
    
    private final RoleService roleService;
    
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public String index(ModelMap modelMap){
        
        List<RoleListDto> data = new ArrayList<>();
        String[] headerDatatables ={"#","Role Name","Created Date","Action"};

        return addTemplate("filter","/filter/role")
                .addTemplate("datatable","/datatable")
                .addCollection("headerDatatables", headerDatatables)
                .addData("datatables", data).endBusiness()
                .modelMap(modelMap)
                .content(PathFeatures.ROLE).endSetUp()
                .render();
    }

    @ResponseBody
    @PostMapping("/datatable")
    public ResponseEntity<PagePojoResponse> datatable(@RequestBody PageRequestPojo request){
        request.setDraw(1);
        return new ResponseEntity<>(roleService.getAll(request), HttpStatus.OK);
    }
}
