package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class h extends b {
    public h(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        w.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        w.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        w.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        w.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }
}
