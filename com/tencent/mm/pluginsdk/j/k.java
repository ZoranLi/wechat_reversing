package com.tencent.mm.pluginsdk.j;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.w;

public final class k extends b {
    public k(Activity activity) {
        super(activity);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
    }

    public final boolean b(p pVar) {
        w.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean c(p pVar) {
        w.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean d(p pVar) {
        w.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }

    public final boolean e(p pVar) {
        w.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, pVar.content, 0).show();
        return true;
    }
}
