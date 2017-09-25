package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11013));
        arrayList.add(Integer.valueOf(11014));
        arrayList.add(Integer.valueOf(11015));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11013:
                a.urY.m(new kd());
                break;
            case 11014:
                List aKd = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().aKd();
                if (aKd.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                    if (VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    w.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    d.a(ab.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                }
                String str = ((au) aKd.get(0)).field_talker;
                Intent intent2 = new Intent();
                intent2.putExtra("Main_User", str);
                intent2.putExtra("From_fail_notify", true);
                intent2.addFlags(67108864);
                intent2.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                if (VERSION.SDK_INT < 16) {
                    intent2.putExtra("resend_fail_messages", true);
                }
                w.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", new Object[]{str});
                d.a(ab.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                break;
            case 11015:
                a.urY.m(new mt());
                break;
        }
        return null;
    }
}
