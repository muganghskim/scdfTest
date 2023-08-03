package com.example.OracleSink.repository;

import com.example.OracleSink.model.Rcs000Calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Data000Repository extends JpaRepository<Rcs000Calculate, Long> {
//    @Query("SELECT r FROM Rcs000Calculate r WHERE r.grpCd = :grpCd AND r.usrCd = :usrCd AND r.sndDt = :sndDt AND r.wrtHh = :wrtHh " +
//            "AND r.mbrId = :mbrId AND r.authSeq = :authSeq AND r.mnoCd = :mnoCd " +
//            "AND r.clientIp = :clientIp AND r.clientPort = :clientPort " +
//            "AND r.reqPath = :reqPath AND r.chatbotId = :chatbotId AND r.templateId = :templateId AND r.natCd = :natCd AND r.agencyId = :agencyId " +
//            "AND r.groupId = :groupId AND r.rsrvdId = :rsrvdId AND r.mnoClientId = :mnoClientId"
//            "AND r.mnoHost = :mnoHost AND r.mnoPort = :mnoPort " +
//            "AND r.mnoRootPath = :mnoRootPath AND r.mnoCode = :mnoCode AND r.rsltVal = :rsltVal AND r.statusCode = :statusCode AND r.uptDate = :uptDate"
//               )
    @Query("SELECT r FROM Rcs000Calculate r WHERE " +
            "(:grpCd IS NULL OR r.grpCd = :grpCd) AND " +
            "(:usrCd IS NULL OR r.usrCd = :usrCd) AND " +
            "(:sndDt IS NULL OR r.sndDt = :sndDt) AND " +
            "(:wrtHh IS NULL OR r.wrtHh = :wrtHh) AND " +
            "(:mbrId IS NULL OR r.mbrId = :mbrId) AND " +
            "(:authSeq IS NULL OR r.authSeq = :authSeq) AND " +
            "(:mnoCd IS NULL OR r.mnoCd = :mnoCd) AND " +
            "(:clientIp IS NULL OR r.clientIp = :clientIp) AND " +
            "(:clientPort IS NULL OR r.clientPort = :clientPort) AND " +
            "(:reqPath IS NULL OR r.reqPath = :reqPath) AND " +
            "(:chatbotId IS NULL OR r.chatbotId = :chatbotId) AND " +
            "(:templateId IS NULL OR r.templateId = :templateId) AND " +
            "(:natCd IS NULL OR r.natCd = :natCd) AND " +
            "(:agencyId IS NULL OR r.agencyId = :agencyId) AND " +
            "(:groupId IS NULL OR r.groupId = :groupId) AND " +
            "(:rsrvdId IS NULL OR r.rsrvdId = :rsrvdId) AND " +
            "(:mnoClientId IS NULL OR r.mnoClientId = :mnoClientId) AND " +
            "(:mnoHost IS NULL OR r.mnoHost = :mnoHost) AND " +
            "(:mnoPort IS NULL OR r.mnoPort = :mnoPort) AND " +
            "(:mnoRootPath IS NULL OR r.mnoRootPath = :mnoRootPath) AND " +
            "(:mnoCode IS NULL OR r.mnoCode = :mnoCode) AND " +
            "(:rsltVal IS NULL OR r.rsltVal = :rsltVal) AND " +
            "(:statusCode IS NULL OR r.statusCode = :statusCode)")
    Optional<Rcs000Calculate> findByselect(
            @Param("grpCd") String grpCd,
            @Param("usrCd") String usrCd,
            @Param("sndDt") String sndDt,
            @Param("wrtHh") String wrtHh,
            @Param("mbrId") String mbrId,
            @Param("authSeq") String authSeq,
            @Param("mnoCd") String mnoCd,
            @Param("clientIp") String clientIp,
            @Param("clientPort") String clientPort,
            @Param("reqPath") String reqPath,
            @Param("chatbotId") String chatbotId,
            @Param("templateId") String templateId,
            @Param("natCd") String natCd,
            @Param("agencyId") String agencyId,
            @Param("groupId") String groupId,
            @Param("rsrvdId") String rsrvdId,
            @Param("mnoClientId") String mnoClientId,
            @Param("mnoHost") String mnoHost,
            @Param("mnoPort") String mnoPort,
            @Param("mnoRootPath") String mnoRootPath,
            @Param("mnoCode") String mnoCode,
            @Param("rsltVal") String rsltVal,
            @Param("statusCode") String statusCode
            );
//    Optional<Rcs000Calculate> findByGrpCdAndUsrCdAndSndDtAndWrtHhAndMbrIdAndAuthSeqAndMnoCdAndClientIpAndClientPortAndReqPathAndChatbotIdAndTemplateIdAndNatCdAndAgencyIdAndGroupIdAndRsrvdIdAndMnoClientIdAndMnoHostAndMnoPortAndMnoRootPathAndMnoCodeAndRsltValAndStatusCode(
//            String grpCd,String usrCd, String sndDt, String wrtHh, String mbrId, String authSeq,
//            String mnoCd, String clientIp, String clientPort, String reqPath, String chatbotId, String templateId,
//            String natCd, String agencyId, String groupId, String rsrvdId, String mnoClientId, String mnoHost, String mnoPort,
//            String mnoRootPath, String mnoCode, String rsltVal, String statusCode);
}
