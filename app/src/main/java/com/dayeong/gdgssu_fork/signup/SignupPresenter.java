package com.dayeong.gdgssu_fork.signup;

import com.dayeong.gdgssu_fork.Global;
import com.dayeong.gdgssu_fork.ValidUtils;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class SignupPresenter implements SignupContract.UserActionListener {

    private SignupContract.View listener;

    public SignupPresenter(SignupContract.View listener) {
        this.listener = listener;
    }

    @Override
    public int signup(String id, String pw, String confirm, String email) {
        ValidUtils validUtils = new ValidUtils();

        if (id.isEmpty())
            return Global.ERR_EMPTY_ID;
        if (!validUtils.checkId(id))
            return Global.ERR_INVALID_ID;
        if (pw.isEmpty())
            return Global.ERR_EMPTY_PW;
        if (!validUtils.checkPw(pw))
            return Global.ERR_INVALID_PW;
        if (confirm.isEmpty())
            return Global.ERR_EMPTY_CONFIRM;
        if (!validUtils.checkConfirm(pw, confirm))
            return Global.ERR_INVALID_CONFIRM;
        if (email.isEmpty())
            return Global.ERR_EMPTY_EMAIL;
        if (!validUtils.checkEmail(email))
            return Global.ERR_INVALID_EMAIL;

        return Global.SUCCESS;
    }
}
