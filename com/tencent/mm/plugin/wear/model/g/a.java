package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.e.a.sm;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private PowerManager rTI = ((PowerManager) ab.getContext().getSystemService("power"));
    private KeyguardManager rTJ = ((KeyguardManager) ab.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, a> rUJ = new LinkedHashMap();

    private class a {
        String content;
        String rUK;
        final /* synthetic */ a rUL;

        public a(a aVar, String str, String str2) {
            this.rUL = aVar;
            this.rUK = str;
            this.content = str2;
        }
    }

    public static sm IJ(String str) {
        b smVar = new sm();
        smVar.gae.fEG = 1;
        smVar.gae.username = str;
        com.tencent.mm.sdk.b.a.urY.m(smVar);
        return smVar;
    }

    public final void bvZ() {
        if (IJ(null).gaf.gag != 0) {
            w.i("MicroMsg.wear.WearYoLogic", "current show yo");
            return;
        }
        synchronized (this.rUJ) {
            a aVar;
            Iterator it = this.rUJ.entrySet().iterator();
            if (it.hasNext()) {
                aVar = (a) ((Entry) it.next()).getValue();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                this.rUJ.remove(aVar.rUK);
            }
        }
        if (aVar != null) {
            int i;
            String str = aVar.content;
            bou com_tencent_mm_protocal_c_bou = new bou();
            Map q = bh.q(str, "msg");
            if (q == null) {
                com_tencent_mm_protocal_c_bou.jOc = 0;
            } else {
                com_tencent_mm_protocal_c_bou.jOc = bg.getInt((String) q.get(".msg.yo.$type"), 0);
                com_tencent_mm_protocal_c_bou.jNd = bg.getInt((String) q.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", aVar.rUK);
            try {
                intent.putExtra("key_data", com_tencent_mm_protocal_c_bou.toByteArray());
            } catch (IOException e) {
            }
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (this.rTJ.inKeyguardRestrictedInputMode() || !this.rTI.isScreenOn()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                intent.setClass(ab.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(ab.getContext(), WearYoNoLockUI.class);
            }
            ab.getContext().startActivity(intent);
        }
    }
}
