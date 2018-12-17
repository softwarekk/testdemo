package com.anshunfeng.firstmodule.helper;

import android.webkit.JavascriptInterface;

import com.anshunfeng.commom.base.TLog;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by ${Young} on 2018/12/17.
 */

  class InJavaScriptLocalObj {
    @JavascriptInterface
    public void showSource(String html2) {
        TLog.log("jscde",html2);
    }
}
