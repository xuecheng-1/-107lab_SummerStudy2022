package com.alibaba.taobao.customer.duotai;

import com.alibaba.taobao.customer.duotai.system.CustomerService;
import com.alibaba.taobao.customer.duotai.system.Language;

public class customer {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Language language = customerService.contact(86);
        language.voice();
        Language language1 = customerService.contact(33);
        language1.voice();
    }
}
