package com.stripcode.core.support.plugin;


public abstract class PagingStorage {
	private static ThreadLocal<PageParam> storage = new ThreadLocal<>();

	public static void savePageParam(PageParam pageParam) {
		storage.set(pageParam);
	}

	public static PageParam getPageParam() {
		return storage.get();
	}
}
