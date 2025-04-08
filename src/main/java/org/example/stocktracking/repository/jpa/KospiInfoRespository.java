package org.example.stocktracking.repository.jpa;

import org.example.stocktracking.Entity.KospiInfo;
import org.example.stocktracking.Entity.KospiInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KospiInfoRespository extends JpaRepository<KospiInfo, String> {
    Optional<KospiInfo> findById(KospiInfoId kospiId);
}
