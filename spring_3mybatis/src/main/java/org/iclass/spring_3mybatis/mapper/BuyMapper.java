package org.iclass.spring_3mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.iclass.spring_3mybatis.dto.CustomerBuyDto;


public interface BuyMapper {
    // 사용자 구매내역 조회(n개)
    List<String> selectByCustomer(String customerId);

    // 상품 구매 내역 조회(n개)
    List<String> selectByPcode(String pcode);
    
    // 년도 구매 내역 조회(n개)
    List<String> selectByYear(String year);

    // 상품의 구매 수량 합계 조회(1개)
    int selectSumByPcode(String quantity);

    // join
    List<CustomerBuyDto>selectSaleByCustomer(String customerId);

    // count 집계함수
    Map<String,Integer>selectCountByYear(String yeaString);

    List<Map<String,Object>> selectAllCountByYear();

}







