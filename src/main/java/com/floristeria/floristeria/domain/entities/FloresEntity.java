package com.floristeria.floristeria.domain.entities;

import com.floristeria.floristeria.Util.Enum.Color;
import com.floristeria.floristeria.Util.Enum.TipoFlor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity(name = "Flores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FloresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cant_flores;
    private Double precio_compra;
    private Double precio_venta;
    @Column(nullable = false)
    private String variedad;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private TipoFlor tipo_flor;    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id"
    )
    private UserEntity user;

    
}
