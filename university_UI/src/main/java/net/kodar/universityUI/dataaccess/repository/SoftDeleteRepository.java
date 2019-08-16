package net.kodar.universityUI.dataaccess.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface SoftDeleteRepository<ENT, ID> extends CrudRepository<ENT, ID> {

    @Override
    @Modifying
    @Query(value = "update #{#entityName} e set e.is_deleted=true where e.id=?1", nativeQuery = true)
    void deleteById(ID id);

    @Override
    @Query("select e from #{#entityName} e where e.isDeleted=false")
    List<ENT> findAll();

    @Query("select e from #{#entityName} e where e.isDeleted=true")
    List<ENT> recycleBin();
}
