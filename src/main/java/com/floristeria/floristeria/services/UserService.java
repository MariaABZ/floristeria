package com.floristeria.floristeria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.floristeria.floristeria.domain.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import com.floristeria.floristeria.domain.entities.UserEntity;
import org.springframework.data.domain.Page;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository objUserRepository;

    // @Autowired
    // private final FloresRepository objFloresRepository;
    

    public List<UserEntity> findAll() {
        return this.objUserRepository.findAll();
    }

    public Page<UserEntity> findPaginated(int page, int size) {
        if(page < 0) {
            page = 1;
        }

        Pageable pageable = PageRequest.of(page, size);
        return this.objUserRepository.findAll(pageable);
    }

    public UserEntity findById(Long id) {
        try {
            return this.objUserRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public UserEntity insert(UserEntity user) {
        return this.objUserRepository.save(user);
    }

    public UserEntity update(Long id, UserEntity user) {
        UserEntity objUserEntity = this.findById(id);   
        if (objUserEntity == null) {
            return null;
        }
        objUserEntity = user;
        return this.objUserRepository.save(objUserEntity);
    }

    public void delete(Long id) {
        this.objUserRepository.deleteById(id);
    }
}
