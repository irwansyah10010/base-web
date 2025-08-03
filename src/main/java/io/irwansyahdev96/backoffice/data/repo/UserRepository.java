

package io.irwansyahdev96.backoffice.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import io.irwansyahdev96.backoffice.data.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    // User findByUsername(String username);
    // User findByNip(String nip);
    // User findByPhoneNumber(String phone);
    // User findById(long id);
    // User findByEmail(String email);
    // Long deleteById(long id);
    // List<User> getAllByOrderByEnabledDescLastLoginWebDesc();
    // List<User> getAllByBranch(String branch);
    
    // User findByUsernameAndEmailAndFullNameAndNipAndDepartmentAndDivisionAndBranchAndPhoneNumber(String username, String email, String fullName, String nip, String departement, String division, String branch, String phoneNumber);

    // @Query(value = "SELECT * FROM web_user WHERE phone_number like '%:phoneNumber%'",nativeQuery = true)
    // List<User> findLikeByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    // @Query(value = "SELECT * FROM web_user u JOIN web_user_role a ON u.id =a.user_id WHERE a.role_id =:roleId ORDER BY u.username",nativeQuery = true)
    // List<User> findAllByRoleIdAsc(@Param("roleId") long roleId);

}
