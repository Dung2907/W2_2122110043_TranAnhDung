package com.trananhdung.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.trananhdung.demo.entity.Category;
import com.trananhdung.demo.entity.Gallery;
import com.trananhdung.demo.entity.Tag;

@SuppressWarnings("unused")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private UUID id;
    private String productName;
    private String SKU;
    private String productNote;
    private int quantity;
    private Boolean published;
    private BigDecimal regularPrice;
    private BigDecimal discountPrice;
    private BigDecimal productWeight;
    private String productDescription;
    private String shortDescription;
    private Set<Category> categories = new HashSet<>();
    private Set<Tag> tags = new HashSet<>();
    private Set<Gallery> galleries = new HashSet<>();
}
