package com.tll.wallet.service.impl;

import com.tll.wallet.ex.ServiceException;
import com.tll.wallet.mapper.WalletMapper;
import com.tll.wallet.pojo.dto.WalletDTO;
import com.tll.wallet.pojo.dto.WalletRefundDTO;
import com.tll.wallet.pojo.entity.Wallet;
import com.tll.wallet.pojo.vo.WalletMoneyVO;
import com.tll.wallet.pojo.vo.WalletStandardVO;
import com.tll.wallet.service.WalletService;
import com.tll.wallet.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletMapper walletMapper;


    @Override
    public WalletStandardVO getMoneyByUid(Long id) {
        log.debug("开始处理【根据用户id查询钱包余额详情】的业务");
        WalletStandardVO moneyByUid = walletMapper.getMoneyByUid(id);
        if (moneyByUid==null){
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,"您要查询的用户账号不存在");
        }
        return moneyByUid;
    }

    @Override
    public void updateMoneyById(Long id, WalletDTO walletDTO) {
        log.debug("开始处理【钱包余额消费】的业务");
        if (walletDTO.getMoney()<walletDTO.getReduceMoney()){
            throw new ServiceException(ServiceCode.ERR_UPDATE,"您的余额不足");
        }
           walletMapper.updateMoney(walletDTO.getMoney(), walletDTO.getReduceMoney(),id);

    }

    @Override
    public void updateRefund(Long id, WalletRefundDTO walletRefundDTO) {
        log.debug("开始处理【钱包余额退款】的业务");
        walletMapper.refundMoney(walletRefundDTO.getMoney(), walletRefundDTO.getRefundMoney(), id);
    }

    @Override
    public WalletMoneyVO getReduceAndRefund(Long id) {
        log.debug("开始处理【查询钱包明细】的业务");
        WalletMoneyVO reduceAndRefund = walletMapper.getReduceAndRefund(id);
        return reduceAndRefund;
    }
}
