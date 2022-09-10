package com.example.springcloudproduct.core.common.listener;

import com.example.springcloudproduct.core.common.domain.Auditable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BaseEntityListener {

    @PrePersist
    public void prePersist(Object o) {
        if(o instanceof Auditable) {
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            ((Auditable) o).setCreateDt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object o) {
        if(o instanceof Auditable) {
            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            ((Auditable) o).setUpdateDt(LocalDateTime.now());
        }
    }



}
