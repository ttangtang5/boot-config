package com.example.jpacomplexdemo.dao;

import com.example.jpacomplexdemo.pojo.CoffeeOrder;

import java.util.List;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/24 11:35
 * @Version 1.0
 **/
public interface CoffeeOrderDao extends BaseEntityDao<CoffeeOrder, Long> {

    /**
     * select coffeeorde0_.id as id1_2_,coffeeorde0_.create_time as create_t2_2_,coffeeorde0_.update_time as update_t3_2_,
     * coffeeorde0_.customer as customer4_2_,coffeeorde0_.state as state5_2_
     * from t_order coffeeorde0_
     * order by
     * coffeeorde0_.update_time desc,
     * coffeeorde0_.id asc limit ?
     *
     * @return
     */
    List<CoffeeOrder> findTop3ByOrderByUpdateTimeDescIdAsc();

    List<CoffeeOrder> findByCustomer(String customer);

    /**
     * 先判断 userAddressZip （根据 POJO 规范，首字母变为小写，下同）是否为 该对应实体类的一个属性，如果是，则表示根据该属性进行查询；如果没有该属性，继续第二步；
     * 从右往左截取第一个大写字母开头的字符串（此处为 Zip），然后检查剩下的字符串是否为 AccountInfo 的一个属性，如果是，则表示根据该属性进行查询；如果没有该属性，
     * 则重复第二步，继续从右往左截取；最后假设 user 为 AccountInfo 的一个属性；
     * 接着处理剩下部分（ AddressZip ），先判断 user 所对应的类型是否有 addressZip 属性，如果有，则表示该方法最终是根据 "AccountInfo.user.addressZip" 的取值进行查询；
     * 否则继续按照步骤 2 的规则从右往左截取，最终表示根据 "AccountInfo.user.address.zip" 的值进行查询。
     * 处理：可能会存在一种特殊情况，比如 AccountInfo 包含一个 user 的属性，也有一个 userAddress 属性，此时会存在混淆。读者可以明确在属性之间加上 "_" 以显式表达意图，
     * 比如 "findByUser_AddressZip()" 或者 "findByUserAddress_Zip()"。（强烈建议：无论是否存在混淆，都要在不同类层级之间加上"_" ，增加代码可读性）
     *
     * @param name
     * @return
     */
    List<CoffeeOrder> findByItems_Name(String name);
}
