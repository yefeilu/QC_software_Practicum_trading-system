package com.springmysql.financial.service;

import com.springmysql.financial.model.Option;
import com.springmysql.financial.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class OptionService{

    @Autowired
    OptionRepository optionRepository;

    public void save(Option option) {
        optionRepository.save(option);
    }
}
