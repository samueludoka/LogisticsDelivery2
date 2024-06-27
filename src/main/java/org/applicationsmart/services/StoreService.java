package org.applicationsmart.services;

import org.applicationsmart.dtos.response.ProductResponse;
import org.applicationsmart.exception.StoreNotFoundException;
import org.applicationsmart.models.Store;

import java.util.List;

public interface StoreService {
     Store viewStore(String storeId) throws StoreNotFoundException;
     List<ProductResponse>getProductsByVendorId(Long VendorId);
     List<StoreResponse> getDistinctStoresByVendorId(String storeId);

}
