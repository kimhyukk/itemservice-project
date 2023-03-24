package hello.itemservice.project.service.item;

import hello.itemservice.project.domain.item.Item;
import hello.itemservice.project.repository.item.SpringDataJpaItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceV1 implements ItemService{

    private final SpringDataJpaItemRepository repository;

    @Override
    public Item save(Item item) {
        return repository.save(item);
    }

    @Override
    public void update(Long itemId, UpdateDAO updateDAO) {

        Item findItem = repository.findById(itemId).orElseThrow();
        findItem.setItemName(updateDAO.getItemName());
        findItem.setPrice(updateDAO.getPrice());
        findItem.setQuantity(updateDAO.getQuantity());

    }

    @Override
    public Optional<Item> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Item> findAll(ItemSearchCond cond) {
        return repository.findAll();

    }
}
