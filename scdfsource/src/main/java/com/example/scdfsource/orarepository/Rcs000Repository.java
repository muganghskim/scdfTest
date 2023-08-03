//package com.example.scdfsource.orarepository;
//
//import com.example.scdfsource.oramodel.Rcs000Recovery;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//public interface Rcs000Repository extends JpaRepository<Rcs000Recovery, Long> {
//
//    Optional<Rcs000Recovery> findByRecoveryFlag(String recoveryFlag);
//    @Modifying
//    @Transactional
//    @Query("DELETE Rcs000Recovery WHERE id=:id")
//    int deleteRecovery(@Param("id") Long id);
//}
