package org.iclass.spring_2di.component;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @AllArgsConstructor
@Component
@Slf4j
public class ProductService {
    private ProductDao dao;

    // @Autowired 없이 자동으로 의존관계 ProductService 타입 bean 을 가져와서 대입(할당,주입)
    public ProductService(ProductDao dao) {
        this.dao = dao;
        log.info("ProductDao message : {}", dao.getMessage());
    }

}
