package com.example.mongorepositorydemo.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * @Description
 * @Author RLY
 * @Date 2019/4/29 14:19
 * @Version 1.0
 **/
public class MoneyTypeConverter implements Converter<Document, Money> {

    @Nullable
    @Override
    public Money convert(Document document) {
        Document money = (Document) document.get("money");
        Double amount = Double.valueOf(money.getString("amount"));
        Document currency = (Document) money.get("currency");
        String code = currency.getString("code");
        return Money.of(CurrencyUnit.of(code), amount);
    }
}
