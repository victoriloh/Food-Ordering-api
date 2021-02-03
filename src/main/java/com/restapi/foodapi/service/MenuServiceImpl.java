package com.restapi.foodapi.service;

import com.restapi.foodapi.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public List<Menu> findAll() {
        return null;
    }

    @Override
    public Optional<Menu> findById(Long theId) {
        return Optional.empty();
    }

    @Override
    public void save(Menu menu) {
    }

    @Override
    public void deleteById(Long theId) {

    }
}
