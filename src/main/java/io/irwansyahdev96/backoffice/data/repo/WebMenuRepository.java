

package io.irwansyahdev96.backoffice.data.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import io.irwansyahdev96.backoffice.data.model.WebMenu;

public interface WebMenuRepository extends JpaRepository<WebMenu,Long> {
    // public WebMenu findByModule(String module);

    // @Query(value = "SELECT m FROM WebMenu m WHERE MODULE LIKE CONCAT(:module,'%') ORDER BY MODULE ASC ")
    // public List<WebMenu> findAllByModuleContainingOrderByModuleAsc(@Param("module") String module);
    // @Query(value = "select m  from WebMenu m where module like concat('%',:module,'%') order by module asc")
    // public List<WebMenu> findAllByModuleLike(@Param("module") String module);
}
