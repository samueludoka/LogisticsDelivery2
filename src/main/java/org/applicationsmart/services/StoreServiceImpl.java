package org.applicationsmart.services;

import lombok.AllArgsConstructor;
import org.applicationsmart.dtos.response.AddToStoreResponse;
import org.applicationsmart.dtos.response.ProductResponse;
import org.applicationsmart.dtos.response.StoreResponse;
import org.applicationsmart.exception.ProductAlreadyAddedToStoreException;
import org.applicationsmart.exception.ProductNotFoundException;
import org.applicationsmart.exception.StoreNotFoundException;
import org.applicationsmart.exception.VendorNotFoundException;
import org.applicationsmart.models.Store;
import org.applicationsmart.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreRepository storeRepository;


    @Override
    public Store viewStore(Long storeId) throws StoreNotFoundException {
        Optional<Store> store = storeRepository.findById(storeId);
        if(store.isPresent()){
            return store.get();
        }else{
            throw new StoreNotFoundException("Store with storeId "+storeRepository.findById(storeId)+ "does not exist");
        }

    }

    @Override
    public List<ProductResponse> getProductsByVendorId(Long VendorId) {
        return null;
    }

    @Override
    public List<StoreResponse> getDistinctStoresByStoreId(String storeId) {
        return null;
    }

    @Override
    public List<StoreResponse> getDistinctStoresByVendorId(String vendorId) {
        return null;
    }

    @Override
    public List<StoreResponse> getUniqueStores() {
        return null;
    }

    @Override
    public AddToStoreResponse addProductToStore(Long productId, Long VendorId) throws VendorNotFoundException, ProductNotFoundException, ProductAlreadyAddedToStoreException {
        return null;
    }

    @Override
    public void removeProductFromStore(Long productId, Long vendorId) {

    }
}
