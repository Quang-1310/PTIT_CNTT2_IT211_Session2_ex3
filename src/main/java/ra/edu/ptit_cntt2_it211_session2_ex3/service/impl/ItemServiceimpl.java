package ra.edu.ptit_cntt2_it211_session2_ex3.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.ptit_cntt2_it211_session2_ex3.model.entity.Item;
import ra.edu.ptit_cntt2_it211_session2_ex3.repository.ItemRepository;
import ra.edu.ptit_cntt2_it211_session2_ex3.service.ItemService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceimpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy item"));
    }

    @Override
    public Item insertItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item, Long id) {
        itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy item"));
        item.setId(id);
        return itemRepository.save(item);
    }

    @Override
    public boolean deleteItem(Long id) {
        itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy item"));
        itemRepository.deleteById(id);
        return true;
    }
}
