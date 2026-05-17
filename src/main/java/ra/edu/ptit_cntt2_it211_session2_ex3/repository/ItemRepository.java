package ra.edu.ptit_cntt2_it211_session2_ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.ptit_cntt2_it211_session2_ex3.model.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
