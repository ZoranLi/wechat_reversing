package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class c {
    public final WeakReference<Object> sqe;

    public abstract void m(Message message);

    public c() {
        this.sqe = null;
    }

    public c(Object obj) {
        this.sqe = new WeakReference(obj);
    }
}
