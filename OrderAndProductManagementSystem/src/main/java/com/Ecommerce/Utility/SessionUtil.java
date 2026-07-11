package com.Ecommerce.Utility;

import com.Ecommerce.Entity.User;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {

    public static boolean isAdmin(HttpSession session){

        User user =
                (User) session.getAttribute("loggedInUser");

        return user != null &&
               "ADMIN".equalsIgnoreCase(user.getRole());

    }

    public static boolean isUser(HttpSession session){

        User user =
                (User) session.getAttribute("loggedInUser");

        return user != null &&
               "USER".equalsIgnoreCase(user.getRole());

    }

}
