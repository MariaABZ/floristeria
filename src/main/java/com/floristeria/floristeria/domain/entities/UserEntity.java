package com.floristeria.floristeria.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.GenerationType;

@Entity(name = "User")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private String name;
    private String email;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
        mappedBy = "user",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<FloresEntity> flores;
}
