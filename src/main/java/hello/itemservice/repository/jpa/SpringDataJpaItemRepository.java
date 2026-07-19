package hello.itemservice.repository.jpa;
import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

// JpaRepository<관리할 Entity, 관리할 Entity의 PK 타입> 의 형태로 extends 함 -> JpaRepository<Item, Long>
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long>
{
    List<Item> findByItemNameLike(String itemName);

    List<Item> findByPriceLessThanEqual(Integer price);

    //쿼리 메서드 (아래 메서드와 같은 기능 수행)
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);

    //쿼리 직접 실행 -> @Query가 있으면, 이게 우선권을 가지고 없으면, 메소드의 명에 있는 규칙에 따라 SQL 생성
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price); // 쿼리를 직접 @Query로 사용할 때는 @Param으로 지정하는 것이 필요함

    // 모든 것을 조회하는 findAll()의 경우, JpaRepository<Item, Long>에 이미 포함되어 있기 때문에 또 만들 필요가 없음
}