package com.example.OracleSink.repository;

import com.example.OracleSink.model.RcsDataCalculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataSinkRepository extends JpaRepository<RcsDataCalculate, Long> {

    Optional<RcsDataCalculate> findByRcsGbAndGrpCdAndUsrCdAndTelDivAndSndDt(String rcsGb, String grpCd, String usrCd, String telDiv, String sndDt);
}
