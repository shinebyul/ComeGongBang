package com.synergy.backend.orders.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.product.model.entity.ProductMajorOptions;
import com.synergy.backend.product.model.entity.ProductSubOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "option_in_cart")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionInCart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "cart_idx")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "major_option_idx")
    private ProductMajorOptions majorOption;

    @ManyToOne
    @JoinColumn(name = "sub_option_idx")
    private ProductSubOptions subOption;
}