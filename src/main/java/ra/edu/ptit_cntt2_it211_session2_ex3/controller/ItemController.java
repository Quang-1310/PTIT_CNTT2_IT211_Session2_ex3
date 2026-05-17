package ra.edu.ptit_cntt2_it211_session2_ex3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ptit_cntt2_it211_session2_ex3.model.dto.response.ApiDataResponse;
import ra.edu.ptit_cntt2_it211_session2_ex3.model.entity.Item;
import ra.edu.ptit_cntt2_it211_session2_ex3.service.ItemService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Item>>> getAllItems() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách mặt hàng thành công",
                itemService.getAllItems(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> getItemById(@PathVariable Long id) {
        try {
            Item item = itemService.getItemById(id);
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Lấy chi tiết mặt hàng thành công",
                    item,
                    HttpStatus.OK
            ), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    false,
                    e.getMessage(),
                    null,
                    HttpStatus.NOT_FOUND
            ), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Item>> insertItem(@RequestBody Item item) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới mặt hàng thành công",
                itemService.insertItem(item),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Item>> updateItem(@RequestBody Item item, @PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật mặt hàng thành công",
                itemService.updateItem(item, id),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Boolean>> deleteItem(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Xoá mặt hàng thành công",
                itemService.deleteItem(id),
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }

}
