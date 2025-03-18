package org.example.stocktracking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "STOCK_PRICE")
public class StockPrice {
    @EmbeddedId
    private StockPriceId id;

    @Column(name = "ISU_NM", nullable = false, length = 200)
    private String isuNm;

    @Column(name = "MKT_NM", length = 50)
    private String mktNm;

    @Column(name = "SECT_TP_NM", length = 50)
    private String sectTpNm;

    @Column(name = "TDD_CLSPRC", precision = 10, scale = 2)
    private BigDecimal tddClsprc;

    @Column(name = "CMPPREVDD_PRC", precision = 10, scale = 2)
    private BigDecimal cmpprevddPrc;

    @Column(name = "FLUC_RT", precision = 6, scale = 2)
    private BigDecimal flucRt;

    @Column(name = "TDD_OPNPRC", precision = 10, scale = 2)
    private BigDecimal tddOpnprc;

    @Column(name = "TDD_HGPRC", precision = 10, scale = 2)
    private BigDecimal tddHgprc;

    @Column(name = "TDD_LWPRC", precision = 10, scale = 2)
    private BigDecimal tddLwprc;

    @Column(name = "ACC_TRDVOL")
    private Long accTrdvol;

    @Column(name = "ACC_TRDVAL")
    private Long accTrdval;

    @Column(name = "MKTCAP")
    private Long mktcap;

    @Column(name = "LIST_SHRS")
    private Long listShrs;

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

    public Long getListShrs() {
        return listShrs;
    }

    public void setListShrs(Long listShrs) {
        this.listShrs = listShrs;
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

    public BigDecimal getTddLwprc() {
        return tddLwprc;
    }

    public void setTddLwprc(BigDecimal tddLwprc) {
        this.tddLwprc = tddLwprc;
    }

    public BigDecimal getTddHgprc() {
        return tddHgprc;
    }

    public void setTddHgprc(BigDecimal tddHgprc) {
        this.tddHgprc = tddHgprc;
    }

    public BigDecimal getTddOpnprc() {
        return tddOpnprc;
    }

    public void setTddOpnprc(BigDecimal tddOpnprc) {
        this.tddOpnprc = tddOpnprc;
    }

    public BigDecimal getFlucRt() {
        return flucRt;
    }

    public void setFlucRt(BigDecimal flucRt) {
        this.flucRt = flucRt;
    }

    public BigDecimal getCmpprevddPrc() {
        return cmpprevddPrc;
    }

    public void setCmpprevddPrc(BigDecimal cmpprevddPrc) {
        this.cmpprevddPrc = cmpprevddPrc;
    }

    public BigDecimal getTddClsprc() {
        return tddClsprc;
    }

    public void setTddClsprc(BigDecimal tddClsprc) {
        this.tddClsprc = tddClsprc;
    }

    public String getSectTpNm() {
        return sectTpNm;
    }

    public void setSectTpNm(String sectTpNm) {
        this.sectTpNm = sectTpNm;
    }

    public String getMktNm() {
        return mktNm;
    }

    public void setMktNm(String mktNm) {
        this.mktNm = mktNm;
    }

    public String getIsuNm() {
        return isuNm;
    }

    public void setIsuNm(String isuNm) {
        this.isuNm = isuNm;
    }

    public StockPriceId getId() {
        return id;
    }

    public void setId(StockPriceId id) {
        this.id = id;
    }
}
