package org.example.stocktracking.Entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name= "STOCK_INFO")
public class StockInfo {

    @Id
    @Column(name = "ISU_CD", nullable = false, length = 12)
    private String isuCd;

    @Column(name = "ISU_SRT_CD", nullable = false, length = 6)
    private String isuSrtCd;

    @Column(name = "ISU_NM", nullable = false, length = 200)
    private String isuNm;

    @Column(name = "ISU_ABBRV", length = 100)
    private String isuAbbrv;

    @Column(name = "ISU_ENG_NM", length = 200)
    private String isuEngNm;

    @Column(name = "LIST_DD", nullable = false)
    private LocalDate listDd;

    @Column(name = "MKT_TP_NM", nullable = false, length = 50)
    private String mktTpNm;

    @Column(name = "SECUGRP_NM", length = 10)
    private String secugrpNm;

    @Column(name = "SECT_TP_NM", length = 50)
    private String sectTpNm;

    @Column(name = "KIND_STKCERT_TP_NM", length = 50)
    private String kindStkcertTpNm;

    @Column(name = "PARVAL", precision = 10, scale = 2)
    private String parval;

    @Column(name = "LIST_SHRS", nullable = false)
    private Long listShrs;


    @Column(name = "INS_DT", updatable = false)
    private LocalDateTime  insDt;


    @Column(name = "UPD_DT")
    private LocalDateTime  updDt;

    @PrePersist
    protected void onCreate() {
        this.insDt = LocalDateTime.now(ZoneId.of("Asia/Seoul")); // ✅ KST 적용
        this.updDt = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    @PreUpdate
    protected void onUpdate() {
        this.updDt = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    public LocalDateTime getUpdDt() {
        return updDt;
    }

    public void setUpdDt(LocalDateTime updDt) {
        this.updDt = updDt;
    }

    public LocalDateTime getInsDt() {
        return insDt;
    }

    public void setInsDt(LocalDateTime insDt) {
        this.insDt = insDt;
    }

    public Long getListShrs() {
        return listShrs;
    }

    public void setListShrs(Long listShrs) {
        this.listShrs = listShrs;
    }

    public String getParval() {
        return parval;
    }

    public void setParval(String parval) {
        this.parval = parval;
    }

    public String getKindStkcertTpNm() {
        return kindStkcertTpNm;
    }

    public void setKindStkcertTpNm(String kindStkcertTpNm) {
        this.kindStkcertTpNm = kindStkcertTpNm;
    }

    public String getSectTpNm() {
        return sectTpNm;
    }

    public void setSectTpNm(String sectTpNm) {
        this.sectTpNm = sectTpNm;
    }

    public String getSecugrpNm() {
        return secugrpNm;
    }

    public void setSecugrpNm(String secugrpNm) {
        this.secugrpNm = secugrpNm;
    }

    public String getMktTpNm() {
        return mktTpNm;
    }

    public void setMktTpNm(String mktTpNm) {
        this.mktTpNm = mktTpNm;
    }

    public LocalDate getListDd() {
        return listDd;
    }

    public void setListDd(LocalDate listDd) {
        this.listDd = listDd;
    }

    public String getIsuEngNm() {
        return isuEngNm;
    }

    public void setIsuEngNm(String isuEngNm) {
        this.isuEngNm = isuEngNm;
    }

    public String getIsuAbbrv() {
        return isuAbbrv;
    }

    public void setIsuAbbrv(String isuAbbrv) {
        this.isuAbbrv = isuAbbrv;
    }

    public String getIsuNm() {
        return isuNm;
    }

    public void setIsuNm(String isuNm) {
        this.isuNm = isuNm;
    }

    public String getIsuSrtCd() {
        return isuSrtCd;
    }

    public void setIsuSrtCd(String isuSrtCd) {
        this.isuSrtCd = isuSrtCd;
    }

    public String getIsuCd() {
        return isuCd;
    }

    public void setIsuCd(String isuCd) {
        this.isuCd = isuCd;
    }
}
