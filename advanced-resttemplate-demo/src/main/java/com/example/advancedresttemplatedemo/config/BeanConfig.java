package com.example.advancedresttemplatedemo.config;

import com.example.advancedresttemplatedemo.support.CustomConnectionKeepAliveStrategy;
import lombok.Value;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyStore;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @Description resttemplate 高级设置 自定义配置一些属性
 * @Author RLY
 * @Date 2019/5/21 14:51
 * @Version 1.0
 **/
@Configuration
public class BeanConfig {

//    @Value("${security.key-store}")
//    private Resource keyStore;
//    @Value("${security.key-pass}")
//    private String keyPass;

    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory() {
        // 设置连接管理
        PoolingHttpClientConnectionManager connectionManager =
                new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);

        // 设置SSL
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContextBuilder.create()
//                    // 会校验证书
//                    //.loadTrustMaterial(keyStore.getURL(), keyPass.toCharArray())
//                    // 放过所有证书校验
//					.loadTrustMaterial(null, (certificate, authType) -> true)
//                    .build();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .evictIdleConnections(30, TimeUnit.SECONDS)
                .disableAutomaticRetries()
                // 有 Keep-Alive 认里面的值，没有的话永久有效
                //.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                // 换成自定义的
                .setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy())
                //.setSSLContext(sslContext)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);

        return requestFactory;
    }

    /**
     * 配置http2
     *
     * @return
     */
     /*@Bean
    public ClientHttpRequestFactory requestFactory() {
        OkHttpClient okHttpClient = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(this.keyStore.getInputStream(), keyPass.toCharArray());
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);

            okHttpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) tmf.getTrustManagers()[0])
                    .hostnameVerifier((hostname, session) -> true)
                    .build();
        } catch (Exception e) {
            log.error("Exception occurred!", e);
        }
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }*/
    @Bean
    public RestTemplate setRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        //return new RestTemplate();
        return restTemplateBuilder
                .setConnectTimeout(Duration.ofMillis(100))
                .setReadTimeout(Duration.ofMillis(500))
                //.requestFactory(this::requestFactory)
                .requestFactory(() -> this.requestFactory())
                .build();
    }
}
