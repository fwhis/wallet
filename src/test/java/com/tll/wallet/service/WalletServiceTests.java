package com.tll.wallet.service;

import com.tll.wallet.pojo.vo.WalletStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WalletServiceTests {
    @Autowired
    WalletService walletService;

    @Test
    void select(){
        WalletStandardVO moneyByUid = walletService.getMoneyByUid(1L);
        System.out.println(moneyByUid);
    }

}
