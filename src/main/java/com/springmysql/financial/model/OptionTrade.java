package com.springmysql.financial.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "option_trade")
public class OptionTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trade_id")
    private int id;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "option_name", nullable = false)
    private String optionName;

    @Column(name = "underlying", nullable = false)
    private String underlying;

    @Column(name = "strike_price", nullable = false)
    private double strikePrice;

    @Column(name = "option_value")
    private double optionValue;

    @Column(name = "datetime", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;

    @Column(name = "expire", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expire;

    @Column(name = "putCall")
    private String putCall;

    @Column(name = "ameEur")
    private String ameEur;

}
