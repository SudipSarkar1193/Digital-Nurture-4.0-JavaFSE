package com.sudip;

import com.external.ExternalApi;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        try {
            String data = externalApi.getData();
            if (data == null) {
                return "No data available";
            }
            return data;
        } catch (RuntimeException e) {
            throw e ;
        }
    }
}