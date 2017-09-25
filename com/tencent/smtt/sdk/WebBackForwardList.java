package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList {
    private IX5WebBackForwardList wWx = null;
    private android.webkit.WebBackForwardList wWy = null;

    static WebBackForwardList a(android.webkit.WebBackForwardList webBackForwardList) {
        if (webBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList2 = new WebBackForwardList();
        webBackForwardList2.wWy = webBackForwardList;
        return webBackForwardList2;
    }

    static WebBackForwardList a(IX5WebBackForwardList iX5WebBackForwardList) {
        if (iX5WebBackForwardList == null) {
            return null;
        }
        WebBackForwardList webBackForwardList = new WebBackForwardList();
        webBackForwardList.wWx = iX5WebBackForwardList;
        return webBackForwardList;
    }

    public int getCurrentIndex() {
        return this.wWx != null ? this.wWx.getCurrentIndex() : this.wWy.getCurrentIndex();
    }

    public WebHistoryItem getCurrentItem() {
        return this.wWx != null ? WebHistoryItem.a(this.wWx.getCurrentItem()) : WebHistoryItem.a(this.wWy.getCurrentItem());
    }

    public WebHistoryItem getItemAtIndex(int i) {
        return this.wWx != null ? WebHistoryItem.a(this.wWx.getItemAtIndex(i)) : WebHistoryItem.a(this.wWy.getItemAtIndex(i));
    }

    public int getSize() {
        return this.wWx != null ? this.wWx.getSize() : this.wWy.getSize();
    }
}
