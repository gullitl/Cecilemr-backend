package com.cecilemrbackend.util;

import com.cecilemrbackend.enumeration.NominatimCountryCodes;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.ResourceBundle;

@NoArgsConstructor
@Getter
public class I18nFactory {

    private Locale locale;
    private ResourceBundle resourceBundle;
    private static final String RESOURCE_BUNDLE_BASE_NAME = "strings";

    private static I18nFactory uniqueInstance;

    public static synchronized I18nFactory getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new I18nFactory();
        }
        return uniqueInstance;
    }

    public void setSystemLanguage(NominatimCountryCodes nominatimCountryCodes) {
        setLocale(nominatimCountryCodes.getLanguageCode(), nominatimCountryCodes.getCountryCode());
        setResourceBundle();
    }

    private void setLocale(String language, String country) {
        locale = new Locale(language, country);
    }

    private void setResourceBundle() {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME, locale);
    }
}
