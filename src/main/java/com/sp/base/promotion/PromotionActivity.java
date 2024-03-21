package com.sp.base.promotion;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:56
 */
public class PromotionActivity {

    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute(){
        promotionStrategy.doPromotion();
    }
}
