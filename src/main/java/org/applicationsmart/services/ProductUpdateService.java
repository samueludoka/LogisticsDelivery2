package org.applicationsmart.services;

import org.applicationsmart.dtos.request.AddProductRequest;
import org.applicationsmart.dtos.request.UpdateProductRequest;
import org.applicationsmart.dtos.response.AddProductResponse;
import org.applicationsmart.dtos.response.ProductResponse;
import org.applicationsmart.dtos.response.UpdateProductResponse;
import org.applicationsmart.models.Product;

import java.util.Optional;


public interface ProductUpdateService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);
    Optional<Product> findProductById(Long id);
    ProductResponse getProductBy(Long id);
    UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest);


}
