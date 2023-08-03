package com.example.scdfsource.repository;

import com.example.scdfsource.model.RcsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface RcsDataRepository extends JpaRepository<RcsData, Long> {

    // 이력 원천 프로세스
    @Query(value = "SELECT ouid, timestamp, service_stage, account_gid, account_uid, account_sid, priority, pnx_code, client_ip, client_port, req_path, chatbot_id, " +
            "client_msg_id, receiver, template_id, template_param, country_code, agency_id, header, footer, copy_allowed, expiry_option, group_id, " +
            "request_date_time, rsrvd_id, mno_client_id, mno_host, mno_port, mno_root_path, mno_code, result_code, result_message, status_code, " +
            "mno_result_code, mno_result_message, mno_status_code, mno_msg_status_timestamp, ingress_req_date_from_client, ingress_res_date_to_client, " +
            "egress_req_date_to_mno, egress_res_date_from_mno, ingress_req_date_from_mno, ingress_res_date_to_mno, egress_req_date_to_client, " +
            "egress_res_date_from_client, created_on, updated_on, copy_flag " +
            "FROM rcs_cmp_h " +
            "WHERE request_date_time BETWEEN ?1 AND ?2 AND copy_flag = 'Y' LIMIT ?3", nativeQuery = true)
    List<RcsData> findDataToProcess(Date startDate, Date endDate, Integer LIMIT);

//    // 복구 프로세스
//    @Query(value = "SELECT ouid, timestamp, service_stage, account_gid, account_uid, account_sid, priority, pnx_code, client_ip, client_port, req_path, chatbot_id, " +
//            "client_msg_id, receiver, template_id, template_param, country_code, agency_id, header, footer, copy_allowed, expiry_option, group_id, " +
//            "request_date_time, rsrvd_id, mno_client_id, mno_host, mno_port, mno_root_path, mno_code, result_code, result_message, status_code, " +
//            "mno_result_code, mno_result_message, mno_status_code, mno_msg_status_timestamp, ingress_req_date_from_client, ingress_res_date_to_client, " +
//            "egress_req_date_to_mno, egress_res_date_from_mno, ingress_req_date_from_mno, ingress_res_date_to_mno, egress_req_date_to_client, " +
//            "egress_res_date_from_client, created_on, updated_on, copy_flag " +
//            "FROM rcs_cmp_h " +
//            "WHERE request_date_time BETWEEN ?1 AND ?2 LIMIT ?3", nativeQuery = true)
//    List<RcsData> findRecoveryToProcess(Date startDate, Date endDate, Integer LIMIT);

//    @Modifying
//    @Transactional
//    @Query("UPDATE RcsData SET COPY_FLAG='N' WHERE ouid=:ouid AND result_code ='99'")
//    int updateSubmitAck(@Param("ouid") String ouid);

    @Modifying
    @Transactional
    @Query("UPDATE RcsData SET COPY_FLAG='N' WHERE ouid=:ouid")
    int updateReport(@Param("ouid") String ouid);
}
