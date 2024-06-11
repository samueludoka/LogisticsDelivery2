package org.applicationsmart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductUpdateRepository extends MongoRepository<ProductUpdateClass, String> {
    ProductUpdateClass findProductUpdateClassBy(String name);
}
