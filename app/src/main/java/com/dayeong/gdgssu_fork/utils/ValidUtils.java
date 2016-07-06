package com.dayeong.gdgssu_fork.utils;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class ValidUtils {

    public boolean checkId(String id) {
        if (id.length() < 6)
            return false;
        return true;
    }

    public boolean checkPw(String pw) {
        if (pw.length() < 6)
            return false;
        return true;
    }

    public boolean checkConfirm(String pw, String confirm) {
        if (pw.equals(confirm))
            return true;
        return false;
    }

    public boolean checkEmail(String email) {
        if (!email.contains("@") || !email.contains("."))
            return false;
        return true;
    }
}
