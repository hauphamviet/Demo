package com.shophandmade.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Builder.Default
    @JsonIgnore
    @Column(name = "ngayTao")
    private LocalDateTime ngayTao = LocalDateTime.now();

    @LastModifiedDate
    @Builder.Default
    @JsonIgnore
    @Column(name = "ngayCapNhat")
    private LocalDateTime ngayCapNhat = LocalDateTime.now();

    @Builder.Default
    @JsonIgnore
    @Version
    private int version = -1;

}
