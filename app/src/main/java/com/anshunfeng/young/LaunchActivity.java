package com.anshunfeng.young;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.BaseActivity;
import com.anshunfeng.commom.base.TLog;

@Route(path = ARouterPath.LaunchAct)
public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TLog.log("testmodule","1111");
        setContentView(R.layout.activity_main);
        ARouter.getInstance().build( ARouterPath.TestAct ).navigation();
//        SpannableStringBuilder textSpan = new SpannableStringBuilder("qwer1234");
//        textSpan.setSpan(new ForegroundColorSpan(Color.BLACK), 1,8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        TextView hello=(TextView) findViewById(R.id.hello);
//        hello.setText(textSpan);
    }
}
