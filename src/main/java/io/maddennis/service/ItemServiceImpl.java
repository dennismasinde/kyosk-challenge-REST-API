package io.maddennis.service;

import io.maddennis.entity.Item;
import io.maddennis.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
       return itemRepository.save(item);
    }

    @Override
    public Optional<List<Item>> getAllItems() {
        return Optional.of(itemRepository.findAll());
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public Optional<Item> getItemByName(String name) {
        return itemRepository.existsByName(name);
    }

    @Override
    public Item updateItemById(Long id, Item item) {
        Item itemDB = getItemById(id);

        itemDB.setName(item.getName());
        itemDB.setDescription(item.getDescription());
        itemDB.setCategory(item.getCategory());
        itemDB.setPrice(item.getPrice());
        itemDB.setDiscount(item.getDiscount());
        itemDB.setModifiedAt(LocalDateTime.now());

        return itemRepository.save(itemDB);
    }

    @Override
    public String deleteItem(Long id) {
        itemRepository.deleteById(id);
        return "success";
    }

}
