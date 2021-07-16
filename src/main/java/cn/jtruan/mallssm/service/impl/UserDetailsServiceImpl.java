package cn.jtruan.mallssm.service.impl;

import cn.jtruan.mallssm.mbg.model.UmsAdmin;
import cn.jtruan.mallssm.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin admin = umsAdminService.getAdminByUsername(username);
        if(admin != null) {
            List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
            authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            return new User(admin.getUsername(), admin.getPassword(), authorityList);
        }
        throw new UsernameNotFoundException("User " + username + " Not Found!");
    }
}
