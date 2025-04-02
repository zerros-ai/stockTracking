package org.example.stocktracking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "KOSPI_INFO")
public class KospiInfo {
    @EmbeddedId
    private KospiInfoId id;

    @Column(name = "CLSPRC_IDX", precision = 15, scale = 2)
    private BigDecimal clsprcIdx;

    @Column(name = "CMPPREVDD_IDX", precision = 15, scale = 2)
    private BigDecimal cmpprevddIdx;

    @Column(name = "FLUC_RT", precision = 6, scale = 2)
    private BigDecimal flucRt;

    @Column(name = "OPNPRC_IDX", precision = 15, scale = 2)
    private BigDecimal opnprcIdx;

    @Column(name = "HGPRC_IDX", precision = 15, scale = 2)
    private BigDecimal hgprcIdx;

    @Column(name = "LWPRC_IDX", precision = 15, scale = 2)
    private BigDecimal lwprcIdx;

    @Column(name = "ACC_TRDVOL")
    private Long accTrdvol;

    @Column(name = "ACC_TRDVAL")
    private Long accTrdval;

    @Column(name = "MKTCAP")
    private Long mktcap;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "INS_DT")
    private Instant insDt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "UPD_DT")
    private Instant updDt;

    public Instant getUpdDt() {
        return updDt;
    }

    public void setUpdDt(Instant updDt) {
        this.updDt = updDt;
    }

    public Instant getInsDt() {
        return insDt;
    }

    public void setInsDt(Instant insDt) {
        this.insDt = insDt;
    }

    public Long getMktcap() {
        return mktcap;
    }

    public void setMktcap(Long mktcap) {
        this.mktcap = mktcap;
    }

    public Long getAccTrdval() {
        return accTrdval;
    }

    public void setAccTrdval(Long accTrdval) {
        this.accTrdval = accTrdval;
    }

    public Long getAccTrdvol() {
        return accTrdvol;
    }

    public void setAccTrdvol(Long accTrdvol) {
        this.accTrdvol = accTrdvol;
    }

    public BigDecimal getLwprcIdx() {
        return lwprcIdx;
    }

    public void setLwprcIdx(BigDecimal lwprcIdx) {
        this.lwprcIdx = lwprcIdx;
    }

    public BigDecimal getHgprcIdx() {
        return hgprcIdx;
    }

    public void setHgprcIdx(BigDecimal hgprcIdx) {
        this.hgprcIdx = hgprcIdx;
    }

    public BigDecimal getOpnprcIdx() {
        return opnprcIdx;
    }

    public void setOpnprcIdx(BigDecimal opnprcIdx) {
        this.opnprcIdx = opnprcIdx;
    }

    public BigDecimal getFlucRt() {
        return flucRt;
    }

    public void setFlucRt(BigDecimal flucRt) {
        this.flucRt = flucRt;
    }

    public BigDecimal getCmpprevddIdx() {
        return cmpprevddIdx;
    }

    public void setCmpprevddIdx(BigDecimal cmpprevddIdx) {
        this.cmpprevddIdx = cmpprevddIdx;
    }

    public BigDecimal getClsprcIdx() {
        return clsprcIdx;
    }

    public void setClsprcIdx(BigDecimal clsprcIdx) {
        this.clsprcIdx = clsprcIdx;
    }

    public KospiInfoId getId() {
        return id;
    }

    public void setId(KospiInfoId id) {
        this.id = id;
    }
}
