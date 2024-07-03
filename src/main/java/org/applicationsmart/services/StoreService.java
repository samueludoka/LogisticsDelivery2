package org.applicationsmart.services;

import org.applicationsmart.dtos.response.AddToStoreResponse;
import org.applicationsmart.dtos.response.ProductResponse;
import org.applicationsmart.dtos.response.StoreResponse;
import org.applicationsmart.exception.ProductAlreadyAddedToStoreException;
import org.applicationsmart.exception.ProductNotFoundException;
import org.applicationsmart.exception.StoreNotFoundException;
import org.applicationsmart.exception.VendorNotFoundException;
import org.applicationsmart.models.Store;

import java.util.List;

public interface StoreService {
     Store viewStore(Long storeId) throws StoreNotFoundException;
     List<ProductResponse>getProductsByVendorId(Long VendorId);
     List<StoreResponse> getDistinctStoresByStoreId(String storeId);
     List<StoreResponse> getDistinctStoresByVendorId(String vendorId);
     List<StoreResponse> getUniqueStores();
     AddToStoreResponse addProductToStore(Long productId, Long VendorId) throws VendorNotFoundException, ProductNotFoundException, ProductAlreadyAddedToStoreException;
     void removeProductFromStore(Long productId, Long vendorId);

}
