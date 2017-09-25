package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem {
    private android.webkit.WebHistoryItem wWA = null;
    private IX5WebHistoryItem wWz = null;

    private WebHistoryItem() {
    }

    static WebHistoryItem a(android.webkit.WebHistoryItem webHistoryItem) {
        if (webHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem2 = new WebHistoryItem();
        webHistoryItem2.wWA = webHistoryItem;
        return webHistoryItem2;
    }

    static WebHistoryItem a(IX5WebHistoryItem iX5WebHistoryItem) {
        if (iX5WebHistoryItem == null) {
            return null;
        }
        WebHistoryItem webHistoryItem = new WebHistoryItem();
        webHistoryItem.wWz = iX5WebHistoryItem;
        return webHistoryItem;
    }

    public Bitmap getFavicon() {
        return this.wWz != null ? this.wWz.getFavicon() : this.wWA.getFavicon();
    }

    public String getOriginalUrl() {
        return this.wWz != null ? this.wWz.getOriginalUrl() : this.wWA.getOriginalUrl();
    }

    public String getTitle() {
        return this.wWz != null ? this.wWz.getTitle() : this.wWA.getTitle();
    }

    public String getUrl() {
        return this.wWz != null ? this.wWz.getUrl() : this.wWA.getUrl();
    }
}
