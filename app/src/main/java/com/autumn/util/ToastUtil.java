package com.autumn.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * @Author:autumn_leaf
 * @Date:2019/04/13
 */
public class ToastUtil {
    public static Toast mToast;
    public static void showMsg(Context context, String msg) {
        if(mToast == null){
            mToast = Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
}
