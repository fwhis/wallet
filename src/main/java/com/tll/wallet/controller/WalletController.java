package com.tll.wallet.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.tll.wallet.pojo.dto.WalletDTO;
import com.tll.wallet.pojo.dto.WalletRefundDTO;
import com.tll.wallet.pojo.vo.WalletMoneyVO;
import com.tll.wallet.pojo.vo.WalletStandardVO;
import com.tll.wallet.service.WalletService;
import com.tll.wallet.web.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户钱包模块")
@Slf4j
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @ApiOperation("根据id查询钱包余额")
    @GetMapping("/{id:[0-9]+}")
    public JsonResult<WalletStandardVO> getStandardById(@PathVariable Long id) {
        log.debug("开始处理【根据id查询钱包余额】的请求：id={}", id);
        WalletStandardVO moneyByUid = walletService.getMoneyByUid(id);
        return JsonResult.ok(moneyByUid);
    }

    @ApiOperation("用户消费")
    @PostMapping("/{id:[0-9]+}/reduce")
    public JsonResult<Void> updateMoney(@PathVariable Long id, WalletDTO walletDTO){
        walletService.updateMoneyById(id, walletDTO);
        return JsonResult.ok();
    }

    @ApiOperation("用户退款")
    @PostMapping("/{id:[0-9]+}/refund")
    public JsonResult<Void> refundMoney(@PathVariable Long id, WalletRefundDTO walletRefundDTO){
       walletService.updateRefund(id,walletRefundDTO);
        return JsonResult.ok();
    }

    @ApiOperation("查询用户钱包明细")
    @GetMapping("/{id:[0-9]+}/particulars")
    public JsonResult<WalletMoneyVO> getReduceAndRefund(@PathVariable Long id){
        WalletMoneyVO reduceAndRefund = walletService.getReduceAndRefund(id);
        return JsonResult.ok(reduceAndRefund);
    }


}
