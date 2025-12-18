package interviewPractice;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class RestAssuredCustomization {

    @Test
    public void configHttpclient() {
        int connectionTimeout = 5000;
        int socketTimeOut = 5000;

        RequestConfig rcconfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeOut)
                .build();

        HttpClientConfig httpClientConfig = HttpClientConfig.httpClientConfig()
                .httpClientFactory(() ->
                        HttpClientBuilder.create()
                                .setDefaultRequestConfig(rcconfig)
                                .build()
                );

        RestAssuredConfig rcf = RestAssured.config().httpClient(httpClientConfig);
        RestAssured.config = rcf;
    }
}
