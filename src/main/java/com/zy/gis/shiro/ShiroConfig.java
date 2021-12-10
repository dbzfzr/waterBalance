package com.zy.gis.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 权限管理，配置主要是Realm的管理认证
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("loginRealm") Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        shiroFilterFactoryBean.setUnauthorizedUrl("test");
        Map<String, String> filterMap = new LinkedHashMap<String, String>();

        // 登出
        filterMap.put("/logout", "logout");
        // swagger
        // 对所有用户认证

        //对以下资源不进行拦截
        filterMap.put("/loginPage", "anon");
        filterMap.put("/yuwuloginPage", "anon");
        filterMap.put("/youshuiloginPage", "anon");
        filterMap.put("/error", "anon");
        filterMap.put("/js/**", "anon");//  /static的静态资源
        filterMap.put("/fonts/**", "anon");//  /static的静态资源
        filterMap.put("/css/**", "anon");//  /static的静态资源
        filterMap.put("/image/**", "anon");//  /static的静态资源
        filterMap.put("/test/**", "anon");//
        filterMap.put("/checkLogin", "anon");
        filterMap.put("/webjars/**", "anon");//    js资源
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setLoginUrl("/loginPage"); //index
        filterMap.put("/**", "authc");  //对所有用户认证

        // 错误页面，认证不通过跳转
        Map<String, Filter> filers = new HashMap<>();
        filers.put("authc", new ShiroFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filers);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    /**
     * loginRealm 实例化交给Spring
     * */
    @Bean(name = "loginRealm")
    public Realm getRealm() {
        LoginRealm loginRealm = new LoginRealm();
//         loginRealm.setCredentialsMatcher(credentialsMatcher);
        // 告诉realm,使用credentialsMatcher加密算法类来验证密文
        loginRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        loginRealm.setCachingEnabled(false);
        return loginRealm;
    }

    /**
     * 加密配置
     * */
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(2);
        // storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    /**
     *
     *  开启shiro aop注解支持. 利用注解配置权限：
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    /**
     * Shiro生命周期处理器 * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * *
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * *
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * * @return
     */

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
