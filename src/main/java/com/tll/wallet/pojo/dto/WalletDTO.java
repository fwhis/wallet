package com.tll.wallet.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class WalletDTO implements Serializable {
    private Double money;
    private Double reduceMoney;
}
