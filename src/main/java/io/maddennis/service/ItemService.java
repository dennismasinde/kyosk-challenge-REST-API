package io.maddennis.service;

import io.maddennis.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item createItem(Item item);
    Optional<List<Item>> getAllItems();
    Item getItemById(Long id);
    Optional<Item> getItemByName(String name);
    Item updateItemById(Long id, Item item);

    String deleteItem(Long id);

    //Item updateItemByName(String name, Item item);
}
