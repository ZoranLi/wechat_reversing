package com.tencent.mm.pluginsdk.l.b.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public final class a {
    public static boolean b(String str, Context context, boolean z) {
        o.KV();
        return c(s.lv(str), context, z);
    }

    public static boolean c(String str, Context context, boolean z) {
        if (bg.mA(str) || context == null) {
            return false;
        }
        Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        addFlags.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 3);
        Uri fromFile = Uri.fromFile(new File(str));
        if (z) {
            addFlags.setDataAndType(fromFile, "video/quicktime");
        } else {
            addFlags.setDataAndType(fromFile, "video/*");
        }
        if (!bg.j(context, addFlags)) {
            return false;
        }
        context.startActivity(addFlags);
        return true;
    }
}
