package com.dayeong.gdgssu_fork;

import android.app.Fragment;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public abstract class BaseFragment extends Fragment {

    private MaterialDialog dialog;

    public abstract void init(View view);

    public void showProgress(int max) {
        dialog = new MaterialDialog.Builder(getActivity())
                .progress(true, max)
                .show();
    }


    public void showDialog(String title, String content) {
        dialog = new MaterialDialog.Builder(getActivity())
                .title(title)
                .content(content)
                .progress(true, 0)
                .show();
    }


    public void dismissDialog() {
        if (dialog != null)
            dialog.dismiss();
        dialog = null;
    }
}
