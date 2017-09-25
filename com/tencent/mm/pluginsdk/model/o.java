package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.x.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class o implements e {
    private Context context;
    private ProgressDialog koS;
    private String path;
    private Runnable sCy = null;
    private Runnable sCz = null;

    public o(Context context, String str) {
        this.context = context;
        this.path = str;
        this.koS = null;
        ap.vd().a(157, (e) this);
    }

    public final boolean b(int i, Runnable runnable) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.sCy = runnable;
        Context context = this.context;
        this.context.getString(R.l.dIO);
        this.koS = g.a(context, this.context.getString(R.l.eUM), true, null);
        ap.vd().a(new l(i, this.path), 0);
        String str = "MicroMsg.ProcessUploadHDHeadImg";
        String str2 = "post is null ? %B";
        Object[] objArr = new Object[1];
        if (runnable == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        return true;
    }

    public final boolean a(Runnable runnable, Runnable runnable2) {
        boolean z = (this.context == null || this.path == null || this.path.length() <= 0) ? false : true;
        Assert.assertTrue(z);
        this.sCy = runnable;
        this.sCz = runnable2;
        ap.vd().a(new l(1, this.path), 0);
        w.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", Boolean.valueOf(false));
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        ap.vd().b(157, (e) this);
        if (this.koS != null && this.koS.isShowing() && (this.context instanceof Activity) && !((Activity) this.context).isFinishing()) {
            try {
                this.koS.dismiss();
            } catch (IllegalArgumentException e) {
                w.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + e.getMessage());
            }
        }
        if (i == 0 && i2 == 0) {
            Toast.makeText(this.context, R.l.eUL, 0).show();
            if (this.sCy != null) {
                new ae(Looper.getMainLooper()).post(this.sCy);
                return;
            }
            return;
        }
        if (this.sCz != null) {
            new ae(Looper.getMainLooper()).post(this.sCz);
        }
        if (str != null && str.length() > 0) {
            a dn = a.dn(str);
            if (dn != null) {
                dn.a(this.context, null, null);
                return;
            }
        }
        if (i == 4 && i2 == -4) {
            Toast.makeText(this.context, R.l.dYV, 0).show();
        } else {
            Toast.makeText(this.context, R.l.eUK, 0).show();
        }
    }
}
