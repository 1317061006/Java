package com.Test.JavaConfig.Test;

import com.Test.entity.User;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import java.io.Serializable;

/**
 * Created by han on 2016/12/18.
 */
public class UserPermissionEvaluator implements PermissionEvaluator {
    private static final GrantedAuthority ADMIN_AUTHORITY = new GrantedAuthorityImpl("ROLE_ADMIN");

    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        if(target instanceof User) {
            User user = (User) target;
            String username=user.getName();

            if ("delete".equals(permission)) {
                return isAdmin(authentication) || username.equals(authentication.getName());
            }
        }

       throw  new  UnsupportedOperationException(
               "hasPermission not supported for object <"+target
               +"> and permission <"+permission+">"
       );
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException();
    }


    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }

}
