package org.example.stocktracking.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockPriceDto {
    @JsonProperty("BAS_DD")
    private String basDd;
    @JsonProperty("ISU_CD")
    private String isuCd;
    @JsonProperty("ISU_NM")
    private String isuNm;
    @JsonProperty("MKT_NM")
    private String mktNm;
    @JsonProperty("SECT_TP_NM")
    private String sectTpNm;
    @JsonProperty("TDD_CLSPRC")
    private String tddClsprc;
    @JsonProperty("CMPPREVDD_PRC")
    private String cmpprevddPrc;
    @JsonProperty("FLUC_RT")
    private String flucRt;
    @JsonProperty("TDD_OPNPRC")
    private String tddOpnprc;
    @JsonProperty("TDD_HGPRC")
    private String tddHgprc;
    @JsonProperty("TDD_LWPRC")
    private String tddLwprc;
    @JsonProperty("ACC_TRDBOL")
    private Long accTrdvol;
    @JsonProperty("ACC_TRDVAL")
    private Long accTrdval;
    @JsonProperty("MKTCAP")
    private Long mktcap;
    @JsonProperty("LIST_SHRS")
    private Long listShrs;

    public String getBasDd() {
        return basDd;
    }

    public void setBasDd(String basDd) {
        this.basDd = basDd;
    }

    public String getIsuCd() {
        return isuCd;
    }

    public void setIsuCd(String isuCd) {
        this.isuCd = isuCd;
    }

    public String getIsuNm() {
        return isuNm;
    }

    public void setIsuNm(String isuNm) {
        this.isuNm = isuNm;
    }

    public String getMktNm() {
        return mktNm;
    }

    public void setMktNm(String mktNm) {
        this.mktNm = mktNm;
    }

    public String getSectTpNm() {
        return sectTpNm;
    }

    public void setSectTpNm(String sectTpNm) {
        this.sectTpNm = sectTpNm;
    }

    public String getTddClsprc() {
        return tddClsprc;
    }

    public void setTddClsprc(String tddClsprc) {
        this.tddClsprc = tddClsprc;
    }

    public String getCmpprevddPrc() {
        return cmpprevddPrc;
    }

    public void setCmpprevddPrc(String cmpprevddPrc) {
        this.cmpprevddPrc = cmpprevddPrc;
    }

    public String getFlucRt() {
        return flucRt;
    }

    public void setFlucRt(String flucRt) {
        this.flucRt = flucRt;
    }

    public String getTddOpnprc() {
        return tddOpnprc;
    }

    public void setTddOpnprc(String tddOpnprc) {
        this.tddOpnprc = tddOpnprc;
    }

    public String getTddHgprc() {
        return tddHgprc;
    }

    public void setTddHgprc(String tddHgprc) {
        this.tddHgprc = tddHgprc;
    }

    public String getTddLwprc() {
        return tddLwprc;
    }

    public void setTddLwprc(String tddLwprc) {
        this.tddLwprc = tddLwprc;
    }

    public Long getAccTrdvol() {
        return accTrdvol;
    }

    public void setAccTrdvol(Long accTrdvol) {
        this.accTrdvol = accTrdvol;
    }

    public Long getAccTrdval() {
        return accTrdval;
    }

    public void setAccTrdval(Long accTrdval) {
        this.accTrdval = accTrdval;
    }

    public Long getMktcap() {
        return mktcap;
    }

    public void setMktcap(Long mktcap) {
        this.mktcap = mktcap;
    }

    public Long getListShrs() {
        return listShrs;
    }

    public void setListShrs(Long listShrs) {
        this.listShrs = listShrs;
    }
}
