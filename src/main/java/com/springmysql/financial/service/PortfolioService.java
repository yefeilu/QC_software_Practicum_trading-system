package com.springmysql.financial.service;


import com.springmysql.financial.model.Portfolio;
import com.springmysql.financial.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    public Portfolio findByUserIdAndStockName(int userId, String stockName) {
        return portfolioRepository.findByUserIdAndStockName(userId, stockName);
    }

    public void save(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }
}