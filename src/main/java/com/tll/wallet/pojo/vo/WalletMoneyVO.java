package com.tll.wallet.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WalletMoneyVO implements Serializable {
    private Long id;
    /**
     * 余额
     */
    private Double money;
    /**
     * 支出
     */
    private Double reduceMoney;
    /**
     * 收入
     */
    private Double refundMoney;
}
