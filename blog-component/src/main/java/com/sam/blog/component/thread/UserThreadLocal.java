package com.sam.blog.component.thread;

import com.sam.blog.component.dto.SUserDto;

/**
 * 设置本地线程用户
 */
public class UserThreadLocal {
    /**
     * 当前用户线程变量
     */
    private static ThreadLocal<SUserDto> userHolder = new ThreadLocal<SUserDto>();

    public static void setUser(SUserDto user) {
        userHolder.set(user);
    }

    /**
     * 获取当前用户
     *
     * @Title: getUser
     * @return IBaseUser
     */
    public static SUserDto getUser() {
        if (userHolder != null) {
            return userHolder.get();
        }
        return null;
    }

    /**
     * 移除当前线程变量
     *
     * @Title: removeUser
     */
    public static void removeUser() {
        if (userHolder != null) {
            userHolder.remove();
        }
    }
}
