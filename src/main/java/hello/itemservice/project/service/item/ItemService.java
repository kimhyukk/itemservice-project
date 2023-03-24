package hello.itemservice.project.service.item;

import hello.itemservice.project.domain.item.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    Item save(Item item);

    void update(Long itemId, UpdateDAO updateDAO);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond cond);




}
