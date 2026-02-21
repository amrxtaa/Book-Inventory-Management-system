package com.bim.in.repository;
import com.bim.in.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{
    @Query(value="select * from category where catid=:catid",nativeQuery=true)
    List<Category> findBycatid(int catid);
}