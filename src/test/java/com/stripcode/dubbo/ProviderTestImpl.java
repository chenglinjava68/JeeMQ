package com.stripcode.dubbo;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class ProviderTestImpl implements ProviderTest {
	public void test() {
		System.out.println("Dubbo SUCCESS");
	}
}
