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

    //종목명 및 종목 코드 로 like 찾기
    List<StockInfo> findByIsuAbbrvContainingOrIsuCdContaining(String abbrv, String code);

    //종목명 및 종목 코드 로 찾기
    List<StockInfo> findByIsuAbbrvOrIsuCd(String abbrv, String code);
    //종목코드로 찾기
    List<StockInfo> findByIsuSrtCd(String isuSrt);

}
