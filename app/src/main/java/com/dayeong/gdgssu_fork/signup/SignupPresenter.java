package com.dayeong.gdgssu_fork.signup;

import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.utils.ValidUtils;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class SignupPresenter implements SignupContract.UserActionListener {

    private static final String TAG = "SignupPresenter";
    private SignupContract.View listener;

    public SignupPresenter(SignupContract.View listener) {
        this.listener = listener;
    }

    @Override
    public void signUp(String id, String pw, String confirm, String email) {
        ValidUtils validUtils = new ValidUtils();

        if (id.isEmpty())
            listener.signUpValid(Global.ERR_EMPTY_ID);
        else if (!validUtils.checkId(id))
            listener.signUpValid(Global.ERR_INVALID_ID);
        else if (pw.isEmpty())
            listener.signUpValid(Global.ERR_EMPTY_PW);
        else if (!validUtils.checkPw(pw))
            listener.signUpValid(Global.ERR_INVALID_PW);
        else if (confirm.isEmpty())
            listener.signUpValid(Global.ERR_EMPTY_CONFIRM);
        else if (!validUtils.checkConfirm(pw, confirm))
            listener.signUpValid(Global.ERR_INVALID_CONFIRM);
        else if (email.isEmpty())
            listener.signUpValid(Global.ERR_EMPTY_EMAIL);
        else if (!validUtils.checkEmail(email))
            listener.signUpValid(Global.ERR_INVALID_EMAIL);
        else
            listener.signUp(new User(id, pw, email));
    }


}
