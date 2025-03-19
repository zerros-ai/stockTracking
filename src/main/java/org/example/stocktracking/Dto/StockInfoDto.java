package org.example.stocktracking.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import java.util.Objects;


public class StockInfoDto {
    @JsonProperty("ISU_CD")
    private String isuCd;  // 표준코드

    @JsonProperty("ISU_SRT_CD")
    private String isuSrtCd;  // 단축코드

    @JsonProperty("ISU_NM")
    private String isuNm;  // 종목명(한)

    @JsonProperty("ISU_ABBRV")
    private String isuAbbrv; //상장일

    @JsonProperty("ISU_ENG_NM")
    private String isuEngNm; //종목명(영)

    @JsonProperty("LIST_DD")
    private String listDd;  // 상장일

    @JsonProperty("MKT_TP_NM")
    private String mktTpNm;  // 시장구분

    @JsonProperty("SECUGRP_NM")
    private String secugrpNm; //증권구분

    @JsonProperty("SECT_TP_NM")
    private String sectTpNm; //소속부

    @JsonProperty("KIND_STKCERT_TP_NM")
    private String kindStkcertTpNm; //주식종류

    @JsonProperty("PARVAL")
    private String parval;  //액면가

    @JsonProperty("LIST_SHRS")
    private Long listShr;  // 상장 주식 수

    public String getIsuCd() {
        return isuCd;
    }

    public void setIsuCd(String isuCd) {
        this.isuCd = isuCd;
    }

    public String getIsuSrtCd() {
        return isuSrtCd;
    }

    public void setIsuSrtCd(String isuSrtCd) {
        this.isuSrtCd = isuSrtCd;
    }

    public String getIsuNm() {
        return isuNm;
    }

    public void setIsuNm(String isuNm) {
        this.isuNm = isuNm;
    }

    public String getIsuAbbrv() {
        return isuAbbrv;
    }

    public void setIsuAbbrv(String isuAbbrv) {
        this.isuAbbrv = isuAbbrv;
    }

    public String getIsuEngNm() {
        return isuEngNm;
    }

    public void setIsuEngNm(String isuEngNm) {
        this.isuEngNm = isuEngNm;
    }

    public String getListDd() {
        return listDd;
    }

    public void setListDd(String listDd) {
        this.listDd = listDd;
    }

    public String getMktTpNm() {
        return mktTpNm;
    }

    public void setMktTpNm(String mktTpNm) {
        this.mktTpNm = mktTpNm;
    }

    public String getSecugrpNm() {
        return secugrpNm;
    }

    public void setSecugrpNm(String secugrpNm) {
        this.secugrpNm = secugrpNm;
    }

    public String getSectTpNm() {
        return sectTpNm;
    }

    public void setSectTpNm(String sectTpNm) {
        this.sectTpNm = sectTpNm;
    }

    public String getKindStkcertTpNm() {
        return kindStkcertTpNm;
    }

    public void setKindStkcertTpNm(String kindStkcertTpNm) {
        this.kindStkcertTpNm = kindStkcertTpNm;
    }

    public String getParval() {
        if(Objects.equals(parval, "무액면")){
            return "0";
        }
        return parval;
    }

    public void setParval(String parval) {
        this.parval = parval;
    }

    public Long getListShr() {
        return listShr;
    }

    public void setListShr(Long listShr) {
        this.listShr = listShr;
    }
}
