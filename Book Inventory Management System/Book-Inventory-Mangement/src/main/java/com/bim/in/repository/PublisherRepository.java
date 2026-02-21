//package  com.bim.in.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.bim.in.entity.Publisher;
//import com.bim.in.entity.State;
//
//@Repository
//
//public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
//
//
//
//    @Query(value="select * from Publisher where City=:City",nativeQuery=true)
//
//    List<Publisher> findByCity(String City);
//
//    @Query(value="select * from Publisher where Name=:Name",nativeQuery=true)
//    List<Publisher> findByName(String Name);
//    @Query(value="select * from Publisher where state_code=:state_code",nativeQuery=true)
//    List<Publisher> findBystate_code(String state_code);
//}
