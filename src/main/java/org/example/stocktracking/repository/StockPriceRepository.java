package org.example.stocktracking.repository;

import org.example.stocktracking.Entity.StockPrice;
import org.example.stocktracking.Entity.StockPriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice,String> {
    Optional<StockPrice> findById(StockPriceId stockPriceId);
}
