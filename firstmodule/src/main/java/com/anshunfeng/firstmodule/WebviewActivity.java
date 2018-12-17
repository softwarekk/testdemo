package com.anshunfeng.firstmodule;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.anshunfeng.commom.base.ARouterPath;
import com.anshunfeng.commom.base.TLog;
import com.anshunfeng.commom.base.base.BaseActivity;
import com.anshunfeng.young.firstmoudle.R;
import com.anshunfeng.young.librarymodule.X5WebView;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Created by ${Young} on 2018/12/17.
 */
@Route(path = ARouterPath.WebViewAct)
public class WebviewActivity extends BaseActivity {

    private TextView wbcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initX5WebView();
        setContentView(R.layout.webview_layout);
        initview();
        initHardwareAccelerate();

    }

    private void initview() {
        wbcode = findViewById(R.id.webcodetv);
       X5WebView webview= findViewById(R.id.webview);
        webview.setWebViewClient(new MyWebViewClien());
        webview.addJavascriptInterface( new InJavaScriptLocalObj(), "local_obj");
        webview.loadUrl("https://www.baidu.com/sf/vsearch?pd=video&tn=vsearch&lid=a72bab2500031325&ie=utf-8&wd=%E6%9F%A5%E6%B0%B4%E8%A1%A8&rsv_spt=7&rsv_bp=1&f=8&oq=%E6%9F%A5%E6%B0%B4%E8%A1%A8&rsv_pq=a72bab2500031325&rsv_t=71097yuZOzE9o%2FwuRzD%2BjFgUT%2FH2sEoA%2FdbGXJMx2rMRd%2FENOZfaa2o%2F8vgdvgACuLDI");
    }
    class MyWebViewClien extends WebViewClient{
        @Override
        public void onPageFinished(WebView webView, String s) {
            webView.loadUrl("javascript:window.local_obj.showSource('<head>'+" +
                      "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
            super.onPageFinished(webView, s);
        }
    }
    class InJavaScriptLocalObj {
        @JavascriptInterface
        public void showSource(final String html2) {
            TLog.log("jscde",html2);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    wbcode.setText(html2);
                    wbcode.setVisibility(View.VISIBLE);
                }
            });
        }
    }
    private void initX5WebView() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }
    /**
     * 启用硬件加速
     */
    private void initHardwareAccelerate() {
        try {
            if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 11) {
                getWindow()
                          .setFlags(
                                    android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                                    android.view.WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        } catch (Exception e) {
        }
    }
}
