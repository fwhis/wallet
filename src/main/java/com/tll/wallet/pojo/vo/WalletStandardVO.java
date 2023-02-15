package com.tll.wallet.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class WalletStandardVO implements Serializable {
    private Long id;
    private Double money;
}
