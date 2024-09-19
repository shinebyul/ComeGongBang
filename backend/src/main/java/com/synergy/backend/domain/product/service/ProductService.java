package com.synergy.backend.domain.product.service;

import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.domain.product.model.entity.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<ProductListRes> search(Long categoryIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.search(categoryIdx, pageable);

        List<ProductListRes> response = new ArrayList<>();

        for (Product product : result) {
            response.add(ProductListRes.builder()
                    .idx(product.getIdx())
                    .name(product.getName())
                    .price(product.getPrice())
                    .averageScore(product.getAverageScore())
//                    .atelier_name(product.getAtelier().getName())
                    .category_name(product.getCategory().getCategoryName())
                    .thumbnailUrl(product.getThumbnailUrl())
                    .build());
        }

        return response;
    }

    public List<ProductListRes> searchHashTag(Long hashtagIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.searchHashTag(hashtagIdx, pageable);

        List<ProductListRes> response = new ArrayList<>();

        for (Product product : result) {
            response.add(ProductListRes.builder()
                    .idx(product.getIdx())
                    .name(product.getName())
                    .price(product.getPrice())
                    .averageScore(product.getAverageScore())
//                    .atelier_name(product.getAtelier().getName())
                    .category_name(product.getCategory().getCategoryName())
                    .thumbnailUrl(product.getThumbnailUrl())
                    .build());
        }
        return response;
    }
}
