package com.proiectfacultate.proiectfacultate.items.services;

import com.proiectfacultate.proiectfacultate.common.requestModel.ItemRequestModel;
import com.proiectfacultate.proiectfacultate.items.model.Item;
import com.proiectfacultate.proiectfacultate.items.repositories.ItemRepositoryJPA;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    ItemRepositoryJPA itemRepositoryJPA;

    public ItemServiceImpl(ItemRepositoryJPA itemRepositoryJPA) {
        this.itemRepositoryJPA = itemRepositoryJPA;
    }


    @Override
    public Item addItem(ItemRequestModel itemModel) {
        Item item = new Item();
        item.setItemName(itemModel.getItemName());
        item.setDescription(itemModel.getDescription());
        item.setPrice(itemModel.getPrice());

        itemRepositoryJPA.save(item);
        return item;
    }

    @Override
    public Boolean deleteItem(String token, Long itemId) {
        verifyUser(token);
        Item item = itemRepositoryJPA.findByItemId(itemId);

        if(item!=null){
            itemRepositoryJPA.delete(item);
            return true;
        }

        return false;
    }

    @Override
    public Item changeName(String token, Long itemId, String newName) {
        Item item = itemRepositoryJPA.findByItemId(itemId);
        item.setItemName(newName);
        itemRepositoryJPA.save(item);
        return item;
    }

    @Override
    public Item changePrice(String token, Long itemId, int newPrice) {
        Item item = itemRepositoryJPA.findByItemId(itemId);
        item.setPrice(newPrice);
        itemRepositoryJPA.save(item);
        return item;
    }

    @Override
    public Item changeDescription(String token, Long itemId, String newDescription) {
        Item item = itemRepositoryJPA.findByItemId(itemId);
        item.setDescription(newDescription);
        itemRepositoryJPA.save(item);
        return item;
    }

    @Override
    public Item getItemById(String token, Long itemId) {
        Item item = itemRepositoryJPA.findByItemId(itemId);
        return item;
    }

    private static void verifyUser(String token) {
        if (token == null || Strings.isBlank(token)){
            throw new RuntimeException("User not logged in");
        }
    }
}
