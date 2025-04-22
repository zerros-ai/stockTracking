package org.example.stocktracking.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.stocktracking.Entity.StockPrice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StockPriceMapper {
    List<StockPrice> findByIsuCdAndDate(@Param("isuCd") String isuCd, @Param("basDd") String basDd);
}
