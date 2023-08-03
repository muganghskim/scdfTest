package com.example.scdfprocessor.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class RcsData {
    private String ouid;
    private String timestamp;
    private String service_stage;
    private String account_gid;
    private String account_uid;
    private String account_sid;
    private String priority;
    private String pnx_code;
    private String client_ip;
    private String client_port;
    private String req_path;
    private String chatbot_id;
    private String client_msg_id;
    private String receiver;
    private String template_id;
    private String template_param;
    private String country_code;
    private String agency_id;
    private String header;
    private String footer;
    private String copy_allowed;
    private String expiry_option;
    private String group_id;
    private String request_date_time;
    private String rsrvd_id;
    private String mno_client_id;
    private String mno_host;
    private String mno_port;
    private String mno_root_path;
    private String mno_code;
    private String result_code;
    private String result_message;
    private String status_code;
    private String mno_result_code;
    private String mno_result_message;
    private String mno_status_code;
    private String mno_msg_status_timestamp;
    private String ingress_req_date_from_client;
    private String ingress_res_date_to_client;
    private String egress_req_date_to_mno;
    private String egress_res_date_from_mno;
    private String ingress_req_date_from_mno;
    private String ingress_res_date_to_mno;
    private String egress_req_date_to_client;
    private String egress_res_date_from_client;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private String created_on;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private String updated_on;
    private String copy_flag;

    @Builder
    public RcsData(String ouid, String timestamp, String service_stage, String account_gid, String account_uid, String account_sid,
                   String priority, String pnx_code, String client_ip, String client_port, String req_path, String chatbot_id,
                   String client_msg_id, String receiver, String template_id, String template_param, String country_code, String agency_id,
                   String header, String footer, String copy_allowed, String expiry_option, String group_id, String request_date_time,
                   String rsrvd_id, String mno_client_id, String mno_host, String mno_port, String mno_root_path, String mno_code,
                   String result_code, String result_message, String status_code, String mno_result_code, String mno_result_message, String mno_status_code,
                   String mno_msg_status_timestamp, String ingress_req_date_from_client, String ingress_res_date_to_client,
                   String egress_req_date_to_mno, String egress_res_date_from_mno, String ingress_req_date_from_mno,
                   String ingress_res_date_to_mno, String egress_req_date_to_client, String egress_res_date_from_client,
                   String created_on, String updated_on, String copy_flag) {

        this.ouid = ouid;
        this.timestamp = timestamp;
        this.service_stage = service_stage;
        this.account_gid = account_gid;
        this.account_uid = account_uid;
        this.account_sid = account_sid;
        this.priority = priority;
        this.pnx_code = pnx_code;
        this.client_ip = client_ip;
        this.client_port = client_port;
        this.req_path = req_path;
        this.chatbot_id = chatbot_id;
        this.client_msg_id = client_msg_id;
        this.receiver = receiver;
        this.template_id = template_id;
        this.template_param = template_param;
        this.country_code = country_code;
        this.agency_id = agency_id;
        this.header = header;
        this.footer = footer;
        this.copy_allowed = copy_allowed;
        this.expiry_option = expiry_option;
        this.group_id = group_id;
        this.request_date_time = request_date_time;
        this.rsrvd_id = rsrvd_id;
        this.mno_client_id = mno_client_id;
        this.mno_host = mno_host;
        this.mno_port = mno_port;
        this.mno_root_path = mno_root_path;
        this.mno_code = mno_code;
        this.result_code = result_code;
        this.result_message = result_message;
        this.status_code = status_code;
        this.mno_result_code = mno_result_code;
        this.mno_result_message = mno_result_message;
        this.mno_status_code = mno_status_code;
        this.mno_msg_status_timestamp = mno_msg_status_timestamp;
        this.ingress_req_date_from_client = ingress_req_date_from_client;
        this.ingress_res_date_to_client = ingress_res_date_to_client;
        this.egress_req_date_to_mno = egress_req_date_to_mno;
        this.egress_res_date_from_mno = egress_res_date_from_mno;
        this.ingress_req_date_from_mno = ingress_req_date_from_mno;
        this.ingress_res_date_to_mno = ingress_res_date_to_mno;
        this.egress_req_date_to_client = egress_req_date_to_client;
        this.egress_res_date_from_client = egress_res_date_from_client;
        this.created_on = created_on;
        this.updated_on = updated_on;
        this.copy_flag = copy_flag;

    }
}
