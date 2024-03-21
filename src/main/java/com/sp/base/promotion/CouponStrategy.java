package com.sp.base.promotion;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:44
 */
public class CouponStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("优惠券");
    }
}
