package org.example.stocktracking.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "stock.api")
public class StockApiProperties {
    private Map<String,String> authKeys;

    public Map<String, String> getAuthKeys() {
        return authKeys;
    }

    public void setAuthKeys(Map<String, String> authKeys) {
        this.authKeys = authKeys;
    }

    public String getAuthKey(String key) {
        return authKeys.get(key);
    }
}
