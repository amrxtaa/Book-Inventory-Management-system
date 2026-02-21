//package com.bim.in.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import com.bim.in.entity.Publisher;
//import com.bim.in.entity.State;
//@Repository
//public interface StateRepository extends JpaRepository<State, String>{
//
//    @Query(value="select * from State where state_code=:state_code",nativeQuery=true)
//    List<State> findBystate_code(String state_code);
//    @Query(value="select * from State where state_name=:state_name",nativeQuery=true)
//    List<State> findByStateName(String state_name);
//}