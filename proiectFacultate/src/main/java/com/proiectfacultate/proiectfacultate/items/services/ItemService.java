package com.proiectfacultate.proiectfacultate.items.services;

import com.proiectfacultate.proiectfacultate.common.requestModel.ItemRequestModel;
import com.proiectfacultate.proiectfacultate.items.model.Item;

public interface ItemService {
    Item addItem(ItemRequestModel itemModel);
    Boolean deleteItem(String token, Long itemId);
    Item changeName(String token, Long itemId, String newName);
    Item changePrice(String token, Long itemId, int newPrice);
    Item changeDescription(String token, Long itemId, String newDescription);

    Item getItemById(String token, Long itemId);

}
