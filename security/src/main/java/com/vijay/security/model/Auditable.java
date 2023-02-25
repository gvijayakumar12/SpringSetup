package com.vijay.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(value = AuditingEntityListener.class)
public class Auditable {

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected int created_by;

    @LastModifiedBy
    protected int modified_by;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    protected Date created_at;

    @UpdateTimestamp
    protected Date modified_at;

}
