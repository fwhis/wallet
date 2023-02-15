package com.tll.wallet.mapper;

import com.tll.wallet.pojo.entity.Wallet;
import com.tll.wallet.pojo.vo.WalletMoneyVO;
import com.tll.wallet.pojo.vo.WalletStandardVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletMapper {
    /***
     *  查询用户钱包余额
     */
    WalletStandardVO getMoneyByUid(Long id);

    /**
     * 用户钱包余额消费
     */
    int updateMoney(@Param("money") Double money,@Param("reduceMoney") Double reduceMoney,@Param("id") Long id);

    /**
     * 用户钱包余额退款
     */
    int refundMoney(@Param("money") Double money,@Param("refundMoney") Double refundMoney,@Param("id") Long id);

    /**
     * 查询用户明细(支出和收入)
     */
    WalletMoneyVO getReduceAndRefund(Long id);
}
