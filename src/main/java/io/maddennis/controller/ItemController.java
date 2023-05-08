package io.maddennis.controller;

import io.maddennis.entity.Item;
import io.maddennis.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return  new ResponseEntity<>(itemService.createItem(item), HttpStatus.CREATED);
    }

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<Optional<List<Item>>> getAllItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/id", produces = "application/json")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.FOUND);
    }

    @GetMapping(path = "/{id}/name", produces = "application/json")
    public ResponseEntity<Optional<Item>> getItemByName(@PathVariable String name) {
        return new ResponseEntity<>(itemService.getItemByName(name), HttpStatus.FOUND);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Item> updateItemById(@PathVariable Long id, @RequestBody Item item) {
        return new ResponseEntity<>(itemService.updateItemById(id,item), HttpStatus.CREATED);
    }
}
