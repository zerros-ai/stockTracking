package org.example.stocktracking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class KospiInfoId implements java.io.Serializable {
    private static final long serialVersionUID = -8586582106776796104L;
    @Column(name = "BAS_DD", nullable = false)
    private String basDd;

    @Column(name = "IDX_CLSS", nullable = false, length = 12)
    private String idxClss;

    @Column(name = "IDX_NM", nullable = false, length = 200)
    private String idxNm;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        KospiInfoId entity = (KospiInfoId) o;
        return Objects.equals(this.basDd, entity.basDd) &&
                Objects.equals(this.idxClss, entity.idxClss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basDd, idxClss);
    }

    public String getIdxNm() {
        return idxNm;
    }

    public void setIdxNm(String idxNm) {
        this.idxNm = idxNm;
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
}