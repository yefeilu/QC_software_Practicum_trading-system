package com.springmysql.financial.controller;

import com.springmysql.financial.model.*;
import com.springmysql.financial.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    StockService stockService;
    @Autowired
    TradeService tradeService;
    @Autowired
    PortfolioService portfolioService;
    @Autowired
    BondService bondService;
    @Autowired
    OptionService optionService;
    @Autowired
    IndexService indexService;

    @RequestMapping(value = "user/home", method = RequestMethod.GET)
    public ModelAndView userHome() {

        ModelAndView modelAndView = new ModelAndView("user/home");

//        Trade newTrade = new Trade();
//        modelAndView.addObject("newTrade", newTrade);
//
//
//        List<Portfolio> portfolios = new ArrayList<>();
//        portfolioService.findAll().forEach(portfolios::add);
//        modelAndView.addObject("portfolios", portfolios);
//
//        List<Trade> trades = new ArrayList<>();
//        tradeService.findAll().forEach(trades::add);
//        modelAndView.addObject("trades", trades);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("currentUser", user);
        return modelAndView;
    }

    @RequestMapping(value = "user/market", method = RequestMethod.GET)
    public ModelAndView userMarket() {
        ModelAndView modelAndView = new ModelAndView("user/market");

        List<Stock> stocks = new ArrayList<>();
        stockService.findAll().forEach(stocks::add);
        modelAndView.addObject("stocks", stocks);

        List<Bond> bonds = new ArrayList<>();
        bondService.findAll().forEach(bonds::add);
        modelAndView.addObject("bonds", bonds);

        List<Option> options = new ArrayList<>();
        optionService.findAll().forEach(options::add);
        modelAndView.addObject("options", options);

        List<Index> indexes = new ArrayList<>();
        indexService.findAll().forEach(indexes::add);
        modelAndView.addObject("indexes", indexes);

        return modelAndView;
    }

    @RequestMapping(value = "user/market/getStockPrice", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getStockPrice(@RequestParam("stockName") String stockName){
        System.out.println("Stockname: " + stockName);
        Stock stock = stockService.findStockByStockName(stockName);
        return String.valueOf(stock.getPrice());
    }

    @RequestMapping(value = "user/market/calculateYield", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String calculateYield(@RequestParam("bondName") String bondName,
                                 @RequestParam("bondValue") String bondValue) {
        System.out.println(bondName + " " + bondValue);

        Bond currBond = bondService.findByBondName(bondName);








        return bondValue;
    }

    @RequestMapping(value = "user/portfolio", method = RequestMethod.GET)
    public ModelAndView userPortfolio() {
        ModelAndView modelAndView = new ModelAndView("user/portfolio");


        return modelAndView;
    }

    @RequestMapping(value = "user/history", method = RequestMethod.GET)
    public ModelAndView userHistory() {
        ModelAndView modelAndView = new ModelAndView("user/home");


        return modelAndView;
    }
}
