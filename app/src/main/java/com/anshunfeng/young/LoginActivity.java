package com.anshunfeng.young;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.BaseActivity;

/**
 * Created by ${Young} on 2018/11/28.
 */
@Route(path = ARouterPath.LoginAct)
public class LoginActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().build(ARouterPath.LaunchAct).navigation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
    }
}
