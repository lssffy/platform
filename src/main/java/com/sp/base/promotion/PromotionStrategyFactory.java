package com.sp.base.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/21 17:48
 */
public class PromotionStrategyFactory {

    private static Map<String,PromotionStrategy> STRATEGY_MAP = new HashMap<String,PromotionStrategy>();
    static {
        STRATEGY_MAP.put(PromotionKey.COUPON,new CouponStrategy());
        STRATEGY_MAP.put(PromotionKey.CASHBACK,new CashbackStrategy());
        STRATEGY_MAP.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }

    private static final PromotionStrategy NON = new EmptyStrategy();

    private PromotionStrategyFactory() {
    }

    public static PromotionStrategy getPromotionStrategy(String key){
        PromotionStrategy promotionStrategy = STRATEGY_MAP.get(key);
        return promotionStrategy==null?NON:promotionStrategy;
    }

    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }
}
