package org.iclass.spring_3mybatis.dto;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuyDto {
    public Integer buy_seq;
    public String customerId;
    public String pcode;
    public Integer quantity;
    public Timestamp buy_date; // 날짜 + 시간, Date : 시간만 나옴

    @Override
    public String toString() {
        return "\n" + buy_seq + "\t" + customerId + "\t" + pcode + "\t"
                + quantity + "\t" + buy_date + "\n";
    }
}
