package com.tencent.mm.plugin.remittance.c;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.HashSet;

public final class m {
    public static String TAG = "MicroMsg.RemittanceLocalMsgMgr";
    public Object lock;
    public HashSet<String> oQX;
    public HashMap<String, String> oQY;

    public m() {
        this.oQX = null;
        this.oQY = new HashMap();
        this.oQX = new HashSet();
        this.lock = new Object();
    }

    public final boolean Du(String str) {
        boolean contains;
        synchronized (this.lock) {
            contains = this.oQX.contains(str);
        }
        return contains;
    }

    private synchronized boolean Dv(String str) {
        boolean z;
        if (this.oQX.contains(str)) {
            w.i(TAG, "it is a duplicate msg");
            z = false;
        } else {
            z = this.oQX.add(str);
        }
        return z;
    }

    public final boolean di(String str, String str2) {
        String str3 = (String) this.oQY.get(str);
        if (!bg.mA(str3)) {
            return K(str, str3, str2);
        }
        w.w(TAG, "empty transid: %s", new Object[]{str});
        return false;
    }

    public final boolean K(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            w.e(TAG, "msgxml or toUserName or antiRepeatid is null");
            return false;
        } else if (!Dv(str)) {
            return false;
        } else {
            ce auVar = new au();
            auVar.setContent(str2);
            auVar.dv(2);
            auVar.cH(str3);
            auVar.z(ay.gk(str3));
            auVar.dw(1);
            auVar.setType(419430449);
            ap.yY();
            long L = c.wT().L(auVar);
            if (L < 0) {
                w.e(TAG, g.sd() + "insert msg failed :" + L);
                this.oQX.remove(str);
                return false;
            }
            boolean b;
            auVar.x(L);
            if (auVar.axO()) {
                b.hUp.a(auVar, com.tencent.mm.t.g.g(auVar));
            } else {
                b.hUp.f(auVar);
            }
            com.tencent.mm.sdk.e.c fVar = new f();
            fVar.field_xml = auVar.field_content;
            String PX = bg.PX(str2);
            a aVar = null;
            if (PX != null) {
                aVar = a.B(PX, auVar.field_reserved);
                if (aVar != null) {
                    fVar.field_title = aVar.title;
                    fVar.field_description = aVar.description;
                }
            }
            fVar.field_type = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
            fVar.field_msgId = L;
            f ec = an.bDk().ec(L);
            if (ec == null || ec.field_msgId != L) {
                b = an.bDk().b(fVar);
                if (!b) {
                    w.e(TAG, "SubCorePluginBase.getAppMsgStg().insert msg failed id:" + L);
                    this.oQX.remove(str);
                }
            } else {
                b = an.bDk().c(fVar, new String[0]);
            }
            if (aVar != null) {
                com.tencent.mm.plugin.remittance.b.c cVar = new com.tencent.mm.plugin.remittance.b.c();
                cVar.field_locaMsgId = auVar.field_msgId;
                cVar.field_transferId = aVar.hiv;
                cVar.field_receiveStatus = -1;
                cVar.field_isSend = true;
                com.tencent.mm.plugin.remittance.a.b.aWZ();
                com.tencent.mm.plugin.remittance.a.b.aXb().a(cVar);
            }
            return b;
        }
    }
}
