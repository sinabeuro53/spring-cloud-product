package com.example.springcloudproduct.core.common.domain;

import java.time.LocalDateTime;

public interface Auditable {

    LocalDateTime getCreateDt();
    LocalDateTime getUpdateDt();
    Long getCreateNo();
    Long getUpdateNo();

    void setCreateDt(LocalDateTime createDt);
    void setUpdateDt(LocalDateTime updateDt);
    void setCreateNo(Long createNo);
    void setUpdateNo(Long updateNo);
}
