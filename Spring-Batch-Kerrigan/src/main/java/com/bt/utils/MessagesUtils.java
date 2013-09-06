package com.bt.utils;

import java.util.Locale;

import com.bt.common.ApplicationContextProvider;

public class MessagesUtils {
	public static String getMessage(final String key) {
		return ApplicationContextProvider.getApplicationContext().getMessage(key, null, Locale.TAIWAN);
	}

	public static String getMessage(final String key, String... args) {
		return ApplicationContextProvider.getApplicationContext().getMessage(key, args, Locale.TAIWAN);
	}

	public static String getMessage(final String key, final String[] args, final Locale locale) {
		return ApplicationContextProvider.getApplicationContext().getMessage(key, args, locale);
	}
}
