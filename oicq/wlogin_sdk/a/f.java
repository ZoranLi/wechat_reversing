package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;

public final class f extends a {
    int xog;

    public f() {
        this.xog = 0;
        this.xnn = GameJsApiLaunchApplication.CTRL_BYTE;
    }

    public final byte[] bM(byte[] bArr) {
        this.xog = bArr.length;
        Object obj = new byte[this.xog];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.Ep(this.xnn);
        super.H(obj, this.xog);
        super.cip();
        return super.cil();
    }
}
