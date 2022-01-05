package com.project.onlinemarketplaceservice.service;

import com.project.onlinemarketplaceservice.dto.StoreDto;
import java.util.List;


public interface StoreService {

  void createStore(StoreDto store);

  List<StoreDto> selectStoreList(String sessionLoginId);

  int countStores(String ownerId);

  StoreDto selectStore(String ownerId, String storeId);

  void updateStore(StoreDto store);

  void deleteStore(String ownerId, String storeId);
}
