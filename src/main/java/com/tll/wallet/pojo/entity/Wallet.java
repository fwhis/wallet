package com.tll.wallet.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Wallet implements Serializable {
    private Long id;
    private Integer fromuid;
    private Double refundMoney;
    private String username;
    private Double money;
    private Double reduceMoney;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
