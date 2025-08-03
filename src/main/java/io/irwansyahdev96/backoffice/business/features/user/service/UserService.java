package io.irwansyahdev96.backoffice.business.features.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.irwansyahdev96.backoffice.business.pojo.PagePojoResponse;
import io.irwansyahdev96.backoffice.business.pojo.PageRequestPojo;
import io.irwansyahdev96.backoffice.data.model.User;
import io.irwansyahdev96.backoffice.data.repo.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PagePojoResponse getAll(PageRequestPojo pageRequest) {
        // Sort.Direction direction = Sort.Direction.fromString(pageRequest.getSortDir());
        // Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), Sort.by(direction, pageRequest.getSortBy()));
        Pageable pageableReq = PageRequest.of(pageRequest.getPage(),
                                                pageRequest.getSize());

        String keyword = pageRequest.getSearch();

        Page<User> user  = null;
        
        if (keyword != null && !keyword.isEmpty()) 
            user = userRepository.findAll(pageableReq);
        else
            user = userRepository.findAll(pageableReq);

        PagePojoResponse pagePojoResponse = new PagePojoResponse();

        pagePojoResponse.setData(user.getContent());
        pagePojoResponse.setRecordsFiltered((int) user.getTotalElements());
        pagePojoResponse.setRecordsTotal((int) userRepository.count()); // note size of of list

        return pagePojoResponse;
    }
}
