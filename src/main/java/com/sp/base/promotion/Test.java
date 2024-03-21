package com.sp.base.promotion;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:55
 */
public class Test {

    public static void main(String[] args) {
        String key = "CASHBACK";
        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(key));
        promotionActivity.execute();
    }

}
