package org.example.stocktracking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDateTime;

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
    private String tddClsprc;

    @Column(name = "CMPPREVDD_PRC", precision = 10, scale = 2)
    private String cmpprevddPrc;

    @Column(name = "FLUC_RT", precision = 6, scale = 2)
    private String flucRt;

    @Column(name = "TDD_OPNPRC", precision = 10, scale = 2)
    private String tddOpnprc;

    @Column(name = "TDD_HGPRC", precision = 10, scale = 2)
    private String tddHgprc;

    @Column(name = "TDD_LWPRC", precision = 10, scale = 2)
    private String tddLwprc;

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
    private LocalDateTime insDt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "UPD_DT")
    private LocalDateTime updDt;

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

    public String getTddLwprc() {
        return tddLwprc;
    }

    public void setTddLwprc(String tddLwprc) {
        this.tddLwprc = tddLwprc;
    }

    public String getTddHgprc() {
        return tddHgprc;
    }

    public void setTddHgprc(String tddHgprc) {
        this.tddHgprc = tddHgprc;
    }

    public String getTddOpnprc() {
        return tddOpnprc;
    }

    public void setTddOpnprc(String tddOpnprc) {
        this.tddOpnprc = tddOpnprc;
    }

    public String getFlucRt() {
        return flucRt;
    }

    public void setFlucRt(String flucRt) {
        this.flucRt = flucRt;
    }

    public String getCmpprevddPrc() {
        return cmpprevddPrc;
    }

    public void setCmpprevddPrc(String cmpprevddPrc) {
        this.cmpprevddPrc = cmpprevddPrc;
    }

    public String getTddClsprc() {
        return tddClsprc;
    }

    public void setTddClsprc(String tddClsprc) {
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
