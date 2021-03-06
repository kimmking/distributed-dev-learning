package com.prayerlaputa.hmily.account.controller;


import com.prayerlaputa.hmily.account.service.TccAccountService;
import com.prayerlaputa.hmily.common.dto.TccAccountReduceBalanceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenglong.yu
 * created on 2020/12/10
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class TccAccountController {

    @Autowired
    private TccAccountService tccAccountService;

    @GetMapping("/balance")
    public Integer getBalance(Long userId) {
        return tccAccountService.getBalance(userId);
    }

    @PostMapping("/reduce-balance")
    public Boolean reduceBalance(@RequestBody TccAccountReduceBalanceDTO accountReduceBalanceDTO) throws Exception {
        log.info("[reduceBalance] 收到减少余额请求, 用户:{}, 金额:{}", accountReduceBalanceDTO.getUserId(),
                accountReduceBalanceDTO.getPrice());
        tccAccountService.reduceBalance(accountReduceBalanceDTO);
        // 正常扣除余额，返回 true
        return true;
    }
}
