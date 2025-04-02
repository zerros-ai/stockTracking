package org.example.stocktracking.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class KospiInfoDto {
    @JsonProperty("BAS_DD")
    private String basDd;
    @JsonProperty("IDX_CLSS")
    private String idxClss;
    @JsonProperty("IDX_NM")
    private String idxNm;
    @JsonProperty("CLSPRC_IDX")
    private String clsprcIdx;
    @JsonProperty("CMPPREVDD_IDX")
    private String cmpprevddIdx;
    @JsonProperty("FLUC_RT")
    private String flucRt;
    @JsonProperty("OPNPRC_IDX")
    private String opnprcIdx;
    @JsonProperty("HGPRC_IDX")
    private String hgprcIdx;
    @JsonProperty("LWPRC_IDX")
    private String lwprcIdx;
    @JsonProperty("ACC_TRDVOL")
    private Long accTrdvol;
    @JsonProperty("ACC_TRDVAL")
    private Long accTrdval;
    @JsonProperty("MKTCAP")
    private Long mktcap;

    private BigDecimal parseDecimal(String str) {
        if (str == null || str.trim().isEmpty() || str.equals("-")) {
            return null;
        }
        return new BigDecimal(str.replace(",", ""));
    }

    public String getBasDd() {
        return basDd;
    }

    public void setBasDd(String basDd) {
        this.basDd = basDd;
    }

    public String getIdxClss() {
        return idxClss;
    }

    public void setIdxClss(String idxClss) {
        this.idxClss = idxClss;
    }

    public String getIdxNm() {
        return idxNm;
    }

    public void setIdxNm(String idxNm) {
        this.idxNm = idxNm;
    }

    public BigDecimal getClsprcIdx() {
        return parseDecimal(clsprcIdx);
    }

    public BigDecimal getCmpprevddIdx() {
        return parseDecimal(cmpprevddIdx);
    }

    public BigDecimal getFlucRt() {
        return parseDecimal(flucRt);
    }

    public BigDecimal getOpnprcIdx() {
        return parseDecimal(opnprcIdx);
    }

    public BigDecimal getHgprcIdx() {
        return parseDecimal(hgprcIdx);
    }

    public BigDecimal getLwprcIdx() {
        return parseDecimal(lwprcIdx);
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
}
