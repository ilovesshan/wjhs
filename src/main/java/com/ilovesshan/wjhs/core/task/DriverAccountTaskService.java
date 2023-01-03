package com.ilovesshan.wjhs.core.task;

import com.ilovesshan.wjhs.service.AccountService;
import io.github.ljwlgl.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/1/1
 * @description:
 */

@Component
@Slf4j
public class DriverAccountTaskService {
    private static final double ACCOUNT_DEDUCT_MONEY = 200.00;

    @Autowired
    private AccountService accountService;

    // 每月5号 平台端会扣取骑手费用。
    @Scheduled(cron = "0 0 0 15 1-12 ? ")
    public void task() {
        String currentDateString = DateUtil.dateToString(DateUtil.getCurrentDate(), DateUtil.YYYYMMDDHHMMSS);
        log.info("{}-平台端开始扣取骑手费用...", currentDateString);
        accountService.decrementAccountWithDriver(ACCOUNT_DEDUCT_MONEY, "平台端每月手续费扣取");
        log.info("{}-平台端扣取骑手费用结束...", currentDateString);
    }
}
