package com.example.OracleSink.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CRM_RCS000")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rcs000Calculate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "SND_DT")
    private String sndDt;
    @Column(name = "WRT_HH")
    private String wrtHh;
    @Column(name = "GRP_CD")
    private String grpCd;
    @Column(name = "MBR_ID")
    private String mbrId;
    @Column(name = "AUTH_SEQ")
    private String authSeq;
    @Column(name = "USR_CD")
    private String usrCd;
    @Column(name = "MNO_CD")
    private String mnoCd;
    @Column(name = "CLIENT_IP")
    private String clientIp;
    @Column(name = "CLIENT_PORT")
    private String clientPort;
    @Column(name = "REQ_PATH")
    private String reqPath;
    @Column(name = "CHATBOT_ID")
    private String chatbotId;
    @Column(name = "TEMPLATE_ID")
    private String templateId;
    @Column(name = "NAT_CD")
    private String natCd;
    @Column(name = "AGENCY_ID")
    private String agencyId;
    @Column(name = "GROUP_ID")
    private String groupId;
    @Column(name = "RSRVD_ID")
    private String rsrvdId;
    @Column(name = "MNO_CLIENT_ID")
    private String mnoClientId;
    @Column(name = "MNO_HOST")
    private String mnoHost;
    @Column(name = "MNO_PORT")
    private String mnoPort;
    @Column(name = "MNO_ROOT_PATH")
    private String mnoRootPath;
    @Column(name = "MNO_CODE")
    private String mnoCode;
    @Column(name = "RSLT_VAL")
    private String rsltVal;
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "UPT_DATE")
    private String uptDate;
    @Column(name = "SMS_CNT")
    private int smsCnt;
    @Builder
    public Rcs000Calculate(Long id, String sndDt, String wrtHh, String grpCd, String mbrId, String authSeq, String usrCd, String mnoCd, String clientIp, String clientPort, String reqPath, String chatbotId, String templateId, String natCd, String agencyId, String groupId, String rsrvdId, String mnoClientId, String mnoHost, String mnoPort, String mnoRootPath, String mnoCode, String rsltVal, String statusCode, String uptDate, int smsCnt) {
        this.id = id;
        this.sndDt = sndDt;
        this.wrtHh = wrtHh;
        this.grpCd = grpCd;
        this.mbrId = mbrId;
        this.authSeq = authSeq;
        this.usrCd = usrCd;
        this.mnoCd = mnoCd;
        this.clientIp = clientIp;
        this.clientPort = clientPort;
        this.reqPath = reqPath;
        this.chatbotId = chatbotId;
        this.templateId = templateId;
        this.natCd = natCd;
        this.agencyId = agencyId;
        this.groupId = groupId;
        this.rsrvdId = rsrvdId;
        this.mnoClientId = mnoClientId;
        this.mnoHost = mnoHost;
        this.mnoPort = mnoPort;
        this.mnoRootPath = mnoRootPath;
        this.mnoCode = mnoCode;
        this.rsltVal = rsltVal;
        this.statusCode = statusCode;
        this.uptDate = uptDate;
        this.smsCnt = smsCnt;
    }
}
