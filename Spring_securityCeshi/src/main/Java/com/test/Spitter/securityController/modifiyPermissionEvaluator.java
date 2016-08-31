package com.test.Spitter.securityController;

import com.test.Spitter.entity.user;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * Created by han on 2016/8/7.
 */
public class modifiyPermissionEvaluator implements PermissionEvaluator {
    public boolean hasPermission(Authentication authentication, Object traget, Object permission) {
        if(traget instanceof user) {
            user user = (user) traget;
            if("delete".equals(permission)){
            }
        }
        return false;
    }

    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
