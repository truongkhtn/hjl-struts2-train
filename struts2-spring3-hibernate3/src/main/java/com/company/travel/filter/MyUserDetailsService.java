package com.company.travel.filter;

import com.company.travel.entity.Resource;
import com.company.travel.entity.Role;
import com.company.travel.entity.User;
import com.company.travel.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    @javax.annotation.Resource
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User user = this.userService.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
//        Set<GrantedAuthority> grantedAuthorities = obtionGrantedAuthorities(user);
        user.setAuthorities(getGrantedAuthorities(user));
        return user;
    }

    //取得用户已分配的权限
    private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        Set<Role> roles = user.getRoleSet();
        for(Role role : roles) {
            Set<Resource> resources = role.getResourceSet();
            for(Resource res : resources) {
                authSet.add(new  SimpleGrantedAuthority(res.getName()));
           }
        }
        return authSet;
    }

    // 取得用户已分配的角色
    private Set<GrantedAuthority> getGrantedAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoleSet()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getValue()));
        }
        return grantedAuthorities;
    }

}
