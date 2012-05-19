package com.company.travel.filter;

import com.company.travel.entity.Resource;
import com.company.travel.service.ResourceService;
import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import java.util.*;

/**
 * 资源与权限对应关系
 */
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final Logger log = Logger.getLogger(MySecurityMetadataSource.class);

    //由spring调用  
    public MySecurityMetadataSource() {
    }

    @javax.annotation.Resource
    private ResourceService resourceService;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();//这个方法作用不明??...
    }

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return true;
    }

    //加载所有资源与权限的关系
    private void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<Resource> resources = this.resourceService.getAll();
            for (Resource resource : resources) {
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                //以权限名封装为Spring的security Object
                ConfigAttribute configAttribute = new SecurityConfig(resource.getValue());
                configAttributes.add(configAttribute);
                resourceMap.put(resource.getName(), configAttributes);
            }
        }
    }

    //返回所请求资源所需要的权限  
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        log.info("requestUrl is " + requestUrl);
        if (resourceMap == null) {
            loadResourceDefine();
        }
        return resourceMap.get(requestUrl);
    }
}
