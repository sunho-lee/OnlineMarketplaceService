package com.project.onlinemarketplaceservice.service;

import com.project.onlinemarketplaceservice.dto.Category;
import com.project.onlinemarketplaceservice.mapper.CategoryMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper categoryMapper;

    List<Category> categories = new ArrayList<>();

    @EventListener(ApplicationReadyEvent.class)
    public void selectAllCategory() {
        categories.addAll(categoryMapper.selectAllCategory());
    }

    public String getCategoryName(Integer id) {
        return categories.get(id).getName();
    }
}
