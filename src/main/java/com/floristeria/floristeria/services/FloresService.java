package com.floristeria.floristeria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.floristeria.floristeria.domain.entities.FloresEntity;
import com.floristeria.floristeria.domain.repositories.FloresRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FloresService {
    
    @Autowired
    private FloresRepository objFloresRepository;

    public List<FloresEntity> getAllByUserId(int user_id) {
        return objFloresRepository.findAllByUserId(user_id);
    }

    public FloresEntity getOneByUserId(int user_id) {
        return objFloresRepository.findOneByUserId(user_id);
    }
    // public List<FloresEntity> getAllById(List<Long> ids) {
    //     return this.objFloresRepository.findAllById(ids);
    // }

    public Page<FloresEntity> findPaginated(int page, int size) {
        if(page < 0) {
            page = 1;
        }

        Pageable pageable = PageRequest.of(page, size);
        return this.objFloresRepository.findAll(pageable);
    }

    public FloresEntity findById(Long id) {
        try {
            return this.objFloresRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public FloresEntity insert(FloresEntity flores) {
        return this.objFloresRepository.save(flores);
    }

    public FloresEntity update(Long id, FloresEntity flores) {
        FloresEntity objFloresEntity = this.findById(id);   
        if (objFloresEntity == null) {
            return null;
        }
        objFloresEntity = flores;
        return this.objFloresRepository.save(objFloresEntity);
    }

    public void delete(Long id) {
        this.objFloresRepository.deleteById(id);
    }
}
