package io.irwansyahdev96.backoffice.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.irwansyahdev96.backoffice.data.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    // Role findByName(String name);
    // Role findById(long id);
    // Long deleteById(long id);
    // List<RoleIdName> getAllByOrderByIdAsc();
    // List<Role> findAllByOrderByNameAsc();
}
