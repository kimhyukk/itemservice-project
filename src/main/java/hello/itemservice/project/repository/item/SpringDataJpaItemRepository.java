package hello.itemservice.project.repository.item;

import hello.itemservice.project.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SpringDataJpaItemRepository extends JpaRepository<Item ,Long> {
}
