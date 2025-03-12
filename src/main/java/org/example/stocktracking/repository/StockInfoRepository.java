package org.example.stocktracking.repository;

import org.example.stocktracking.Entity.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo,String> {
    Optional<StockInfo> findByIsuCd(String isuCd);
}
