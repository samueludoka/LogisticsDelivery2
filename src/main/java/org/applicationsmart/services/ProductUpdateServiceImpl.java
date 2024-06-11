package org.applicationsmart.services;

import org.applicationsmart.dtos.request.AddProductRequest;
import org.applicationsmart.dtos.request.UpdateProductRequest;
import org.applicationsmart.dtos.response.AddProductResponse;
import org.applicationsmart.dtos.response.ProductResponse;
import org.applicationsmart.dtos.response.UpdateProductResponse;
import org.applicationsmart.models.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductUpdateServiceImpl implements ProductUpdateService{
    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        return null;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductResponse getProductBy(Long id) {
        return null;
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
        return null;
    }
}
