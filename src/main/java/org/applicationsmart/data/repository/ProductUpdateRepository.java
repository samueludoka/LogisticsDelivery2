package org.applicationsmart.data.repository;

import org.applicationsmart.data.models.ProductUpdateClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductUpdateRepository extends MongoRepository<ProductUpdateClass, String> {
    ProductUpdateClass findProductUpdateClassBy(String name);
}
