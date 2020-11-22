package com.redeggplant.demo.config;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

import com.redeggplant.demo.domain.MemberDetailService1;

@Configuration
@EnableAuthorizationServer
public class AuthServerCenterConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.jdbc()
        super.configure(clients);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置token信息 增强token的内容
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(new ArrayList<>());

        // token的存储
        endpoints.tokenStore(new JwkTokenStore("")) // token存储
                .tokenEnhancer(tokenEnhancerChain) // token增强
                .userDetailsService(new MemberDetailService1()) // 用户认证
                .authenticationManager(new OAuth2AuthenticationManager()); //

    }

    @Bean
    public TokenStore tokenStore() {
        return new TokenStore() {
            @Override
            public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
                return null;
            }

            @Override
            public OAuth2Authentication readAuthentication(String token) {
                return null;
            }

            @Override
            public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {

            }

            @Override
            public OAuth2AccessToken readAccessToken(String tokenValue) {
                return null;
            }

            @Override
            public void removeAccessToken(OAuth2AccessToken token) {

            }

            @Override
            public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {

            }

            @Override
            public OAuth2RefreshToken readRefreshToken(String tokenValue) {
                return null;
            }

            @Override
            public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
                return null;
            }

            @Override
            public void removeRefreshToken(OAuth2RefreshToken token) {

            }

            @Override
            public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {

            }

            @Override
            public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
                return null;
            }

            @Override
            public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
                return null;
            }

            @Override
            public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
                return null;
            }
        };
    }

    @Bean
    public DataSource getDataSource() {
        return new DataSource() {
            @Override
            public PrintWriter getLogWriter() throws SQLException {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) throws SQLException {

            }

            @Override
            public void setLoginTimeout(int seconds) throws SQLException {

            }

            @Override
            public int getLoginTimeout() throws SQLException {
                return 0;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) throws SQLException {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) throws SQLException {
                return false;
            }

            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public Connection getConnection(String username, String password) throws SQLException {
                return null;
            }
        };
    }
}
