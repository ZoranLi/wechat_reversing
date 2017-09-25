package com.tencent.mm.pluginsdk.ui.b;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

public abstract class b implements a {
    public WeakReference<Context> sNB = null;
    public View view = null;

    public abstract void destroy();

    public abstract int getLayoutId();

    public b(Context context) {
        this.sNB = new WeakReference(context);
        if (getLayoutId() > 0) {
            this.view = View.inflate((Context) this.sNB.get(), getLayoutId(), null);
        }
    }

    public void setVisibility(int i) {
        if (getView() != null) {
            getView().setVisibility(i);
        }
    }

    public View getView() {
        return this.view;
    }

    public boolean Xj() {
        return this.view != null && this.view.getVisibility() == 0;
    }

    public void release() {
    }

    public int getOrder() {
        return 0;
    }
}
