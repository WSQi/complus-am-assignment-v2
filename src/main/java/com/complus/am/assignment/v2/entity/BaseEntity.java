package com.complus.am.assignment.v2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected Long id;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime updatedDate;

    @LastModifiedBy
    private String updatedBy;

    @Version
    private Long version;

}
