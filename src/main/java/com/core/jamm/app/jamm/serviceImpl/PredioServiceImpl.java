package com.core.jamm.app.jamm.serviceImpl;

import com.core.jamm.app.jamm.model.Predio;
import com.core.jamm.app.jamm.repository.IPredioRepository;
import com.core.jamm.app.jamm.service.IPredioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PredioServiceImpl
 */
@Service
public class PredioServiceImpl implements IPredioService {
    @Autowired
    private IPredioRepository predioDao;

    @Override
    @Transactional(readOnly = true)
    public Predio findOne(Long idpredio) {
        return predioDao.findById(idpredio).orElse(null);
    }
    
}