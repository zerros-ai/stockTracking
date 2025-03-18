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
public class StockPriceId implements java.io.Serializable {
    private static final long serialVersionUID = -2101093240113305454L;
    @Column(name = "BAS_DD", nullable = false)
    private LocalDate basDd;

    @Column(name = "ISU_CD", nullable = false, length = 12)
    private String isuCd;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StockPriceId entity = (StockPriceId) o;
        return Objects.equals(this.isuCd, entity.isuCd) &&
                Objects.equals(this.basDd, entity.basDd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isuCd, basDd);
    }

}