package com.sp.base.promotion;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:46
 */
public class GroupbuyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("拼团优惠");
    }
}
