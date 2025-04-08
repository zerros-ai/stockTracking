package org.example.stocktracking.repository.jpa;

import org.example.stocktracking.Entity.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo,String> {
    Optional<StockInfo> findByIsuCd(String isuCd);

    List<StockInfo> findAllBy();

    //종목명으로 찾기
    List<StockInfo> findByIsuNmContaining(String isuNm);
    //종목코드로 찾기
    List<StockInfo> findByIsuSrtCd(String isuSrt);

}
