package com.tencent.mm.u;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ao extends c {
    public static ao hlW = new ao(c.hgw);

    private ao(c cVar) {
        super(cVar.hgx);
    }

    public final void L(String str, String str2) {
        w.d("MicroMsg.LastLoginInfo", "save key : %s value : %s", str, str2);
        this.hgx.edit().putString(str, str2).commit();
        if (str.equals("login_weixin_username")) {
            ab.getContext().getSharedPreferences("notify_key_pref_no_account", 4).edit().putString("login_weixin_username", str2).commit();
        }
    }

    public final void c(String str, int i, String str2) {
        int i2 = 0;
        if (i != 0) {
            i2 = 1;
            L("last_login_bind_qq", String.valueOf(i));
        }
        if (!bg.mA(str2)) {
            i2 |= 2;
            L("last_login_bind_email", String.valueOf(str2));
        }
        if (!bg.mA(str)) {
            i2 |= 4;
            L("last_login_bind_mobile", str);
        }
        L("last_bind_info", String.valueOf(i2));
    }

    public final void gf(String str) {
        w.i("MicroMsg.LastLoginInfo", "Save last avatar: " + str);
        String str2 = str + ".bm";
        String str3 = e.hgq + "last_avatar";
        String str4 = str3 + ".bm";
        boolean deleteFile = FileOp.deleteFile(str3) | FileOp.deleteFile(str4);
        w.i("MicroMsg.LastLoginInfo", "delete old avatar path[%s], ret[%b]", str4, Boolean.valueOf(deleteFile));
        if (FileOp.p(str, str3) <= 0) {
            FileOp.p(str2, str4);
        }
        L("last_avatar_path", str3);
    }
}
