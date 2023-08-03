package com.example.scdfprocessor.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rcs000Calculate {

    private String sndDt;
    private String wrtHh;
    private String grpCd;
    private String mbrId;
    private String authSeq;
    private String usrCd;
    private String mnoCd;
    private String clientIp;
    private String clientPort;
    private String reqPath;
    private String chatbotId;
    private String templateId;
    private String natCd;
    private String agencyId;
    private String groupId;
    private String rsrvdId;
    private String mnoClientId;
    private String mnoHost;
    private String mnoPort;
    private String mnoRootPath;
    private String mnoCode;
    private String rsltVal;
    private String statusCode;
    private String uptDate;
    private int smsCnt;
    @Builder
    public Rcs000Calculate(String sndDt, String wrtHh, String grpCd, String mbrId, String authSeq, String usrCd, String mnoCd, String clientIp, String clientPort, String reqPath, String chatbotId, String templateId, String natCd, String agencyId, String groupId, String rsrvdId, String mnoClientId, String mnoHost, String mnoPort, String mnoRootPath, String mnoCode, String rsltVal, String statusCode, String uptDate, int smsCnt) {
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
