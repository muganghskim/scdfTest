//package com.example.scdfsource.orarepository2;
//
//import com.example.scdfsource.oramodel.Rcs111Recovery;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//public interface Rcs111Repository extends JpaRepository<Rcs111Recovery, Long> {
//
//    Optional<Rcs111Recovery> findByRecoveryFlag2(String recoveryFlag);
//    @Modifying
//    @Transactional
//    @Query("DELETE Rcs111Recovery WHERE id=:id")
//    int deleteRecovery2(@Param("id") Long id);
//}
