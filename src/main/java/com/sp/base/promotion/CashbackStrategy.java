package com.sp.base.promotion;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:45
 */
public class CashbackStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("返现活动");
    }
}
