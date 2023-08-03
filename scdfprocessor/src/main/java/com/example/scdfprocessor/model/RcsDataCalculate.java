package com.example.scdfprocessor.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RcsDataCalculate {
    private String sndDt;
    private String uptDate;
    private String grpCd;
    private String usrCd;
    private String rcsGb;
    private String telDiv;
    private int totCnt;
    private int okCnt;
    private int failCnt;

    @Builder
    public RcsDataCalculate(String sndDt, String uptDate, String grpCd, String usrCd, String rcsGb, String telDiv, int totCnt, int okCnt, int failCnt) {
        this.sndDt = sndDt;
        this.uptDate = uptDate;
        this.grpCd = grpCd;
        this.usrCd = usrCd;
        this.rcsGb = rcsGb;
        this.telDiv = telDiv;
        this.totCnt = totCnt;
        this.okCnt = okCnt;
        this.failCnt = failCnt;
    }

}
