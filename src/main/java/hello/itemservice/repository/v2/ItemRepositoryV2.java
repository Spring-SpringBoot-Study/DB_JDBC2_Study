package hello.itemservice.repository.v2;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// 일반적인 Query는 Spring Data JPA 사용
public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {
}