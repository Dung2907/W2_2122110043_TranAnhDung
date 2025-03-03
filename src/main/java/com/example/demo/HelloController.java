package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/messages")
public class HelloController {

    private Map<Integer, String> messages = new HashMap<>();
    private int currentId = 1;

    //  (GET)
    @GetMapping
    public Map<Integer, String> getMessages() {
        return messages;
    }

    //  (POST)
    @PostMapping
    public String addMessage(@RequestParam String message) {
        messages.put(currentId, message);
        return "Thêm thành công với ID: " + (currentId++);
    }

    // (PUT)
    @PutMapping("/{id}")
    public String updateMessage(@PathVariable int id, @RequestParam String message) {
        if (messages.containsKey(id)) {
            messages.put(id, message);
            return "Cập nhật thành công!";
        } else {
            return "Không tìm thấy ID " + id;
        }
    }

//(DELETE)
    @DeleteMapping("/{id}")
    public String deleteMessage(@PathVariable int id) {
        if (messages.containsKey(id)) {
            messages.remove(id);
            return "Xóa thành công!";
        } else {
            return "Không tìm thấy ID " + id;
        }
    }
}
