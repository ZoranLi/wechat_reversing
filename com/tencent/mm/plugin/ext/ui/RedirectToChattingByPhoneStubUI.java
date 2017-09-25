package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class RedirectToChattingByPhoneStubUI extends Activity implements e {
    private p lrn = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getString(R.l.dJd);
        this.lrn = g.a(this, "", false, null);
        af.f(new Runnable(this) {
            final /* synthetic */ RedirectToChattingByPhoneStubUI lro;

            {
                this.lro = r1;
            }

            public final void run() {
                this.lro.are();
            }
        }, 500);
        ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
        if (this.lrn != null) {
            this.lrn.dismiss();
            this.lrn = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        finish();
    }

    public final boolean are() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            w.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", new Object[]{e});
            hideSoftInputFromWindow = false;
        }
        w.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", new Object[]{Boolean.valueOf(hideSoftInputFromWindow)});
        return hideSoftInputFromWindow;
    }
}
