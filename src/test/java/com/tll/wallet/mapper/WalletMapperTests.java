package com.tll.wallet.mapper;

import com.tll.wallet.pojo.entity.Wallet;
import com.tll.wallet.pojo.vo.WalletMoneyVO;
import com.tll.wallet.pojo.vo.WalletStandardVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WalletMapperTests {
    @Autowired
    WalletMapper mapper;

    @Test
    void select(){
        WalletStandardVO moneyByUid = mapper.getMoneyByUid(1L);
        System.out.println(moneyByUid);
    }

    @Test
    void select1(){
        WalletMoneyVO reduceAndRefund = mapper.getReduceAndRefund(1L);
        System.out.println(reduceAndRefund);
    }

}
