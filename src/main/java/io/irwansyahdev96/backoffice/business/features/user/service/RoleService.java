package io.irwansyahdev96.backoffice.business.features.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.irwansyahdev96.backoffice.business.pojo.PagePojoResponse;
import io.irwansyahdev96.backoffice.business.pojo.PageRequestPojo;
import io.irwansyahdev96.backoffice.data.model.Role;
import io.irwansyahdev96.backoffice.data.repo.RoleRepository;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public PagePojoResponse getAll(PageRequestPojo pageRequest) {
        // Sort.Direction direction = Sort.Direction.fromString(pageRequest.getSortDir());
        // Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), Sort.by(direction, pageRequest.getSortBy()));
        Pageable pageableReq = PageRequest.of(pageRequest.getPage(),
                                                pageRequest.getSize());

        String keyword = pageRequest.getSearch();

        Page<Role> role  = null;
        
        if (keyword != null && !keyword.isEmpty()) 
            role = roleRepository.findAll(pageableReq);
        else
            role = roleRepository.findAll(pageableReq);

        PagePojoResponse pagePojoResponse = new PagePojoResponse();

        pagePojoResponse.setData(role.getContent());
        pagePojoResponse.setRecordsFiltered((int) role.getTotalElements());
        pagePojoResponse.setRecordsTotal((int) roleRepository.count()); // note size of of list

        return pagePojoResponse;
    }
}
