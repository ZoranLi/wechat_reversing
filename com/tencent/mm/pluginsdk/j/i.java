package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class i extends b {
    public i(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        w.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        w.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        w.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        w.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }
}
