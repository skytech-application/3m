package fr.skytech.application.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public abstract class MangaNetworkController {

	@Autowired
	private ApplicationContext applicationContext;

	public String getProperty(final Locale locale, final String key) {
		return this.applicationContext.getMessage(key, new Object[] {}, locale);
	}

}
