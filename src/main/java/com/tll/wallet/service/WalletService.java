package com.tll.wallet.service;

import com.tll.wallet.pojo.dto.WalletDTO;
import com.tll.wallet.pojo.dto.WalletRefundDTO;
import com.tll.wallet.pojo.entity.Wallet;
import com.tll.wallet.pojo.vo.WalletMoneyVO;
import com.tll.wallet.pojo.vo.WalletStandardVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 处理用户钱包的业务接口
 *
 * @author java@fwh
 * @version 0.0.1
 */
@Transactional
public interface WalletService {
    /***
     *  查询用户钱包余额
     */
    WalletStandardVO getMoneyByUid(Long id);
    /**
     * 用户钱包余额消费
     */

    void updateMoneyById(Long id, WalletDTO walletDTO);
    /**
     * 用户钱包余额退款
     */

    void updateRefund(Long id, WalletRefundDTO walletRefundDTO);
    /**
     * 查询用户明细(支出和收入)
     */

    WalletMoneyVO getReduceAndRefund(Long id);
}
