package ra.edu.ptit_cntt2_it211_session2_ex3.service;

import ra.edu.ptit_cntt2_it211_session2_ex3.model.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item insertItem(Item item);
    Item updateItem(Item item, Long id);
    boolean deleteItem(Long id);
}
