package com.example.OracleSink.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CRM_RCS111")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RcsDataCalculate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "SND_DT")
    private String sndDt;
    @Column(name = "UPT_DATE")
    private String uptDate;
    @Column(name = "GRP_CD")
    private String grpCd;
    @Column(name = "USR_CD")
    private String usrCd;
    @Column(name = "RSC_GB")
    private String rcsGb;
    @Column(name = "TEL_DIV")
    private String telDiv;
    @Column(name = "TOT_CNT")
    private int totCnt;
    @Column(name = "OK_CNT")
    private int okCnt;
    @Column(name = "FAIL_CNT")
    private int failCnt;



    @Builder
    public RcsDataCalculate(Long id, String sndDt, String uptDate, String grpCd, String usrCd, String rcsGb, String telDiv, int totCnt, int okCnt, int failCnt) {
        this.id = id;
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
