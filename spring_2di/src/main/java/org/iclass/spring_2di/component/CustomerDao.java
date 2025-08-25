package org.iclass.spring_2di.component;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerDao {
    private List<String> groups;

    public void setGroups() {
        this.groups = List.of("user", "admin", "manager");
        log.info("CostomerDao setter - groups : {}", groups.toString());
    }
}
