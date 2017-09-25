package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.ag;
import android.support.v4.app.y;
import android.support.v4.app.y.g;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.e.a.v;
import com.tencent.mm.e.b.af;
import com.tencent.mm.i.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import java.util.List;

public final class a {
    c jAR = new c<v>(this) {
        final /* synthetic */ a jAS;

        {
            this.jAS = r2;
            this.usg = v.class.getName().hashCode();
        }

        private static boolean a(v vVar) {
            if (vVar instanceof v) {
                try {
                    g gVar;
                    com.tencent.mm.e.a.v.a aVar = vVar.fDc;
                    String str = vVar.fDc.username;
                    String str2 = vVar.fDc.title;
                    w.i("MicroMsg.auto.AutoLogic", "isConnectedUSB %b", new Object[]{Boolean.valueOf(ab.getContext().registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE")).getExtras().getBoolean("connected"))});
                    if (ab.getContext().registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE")).getExtras().getBoolean("connected") && a.ZU()) {
                        PendingIntent broadcast = PendingIntent.getBroadcast(ab.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str), 134217728);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(ab.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str), 134217728);
                        android.support.v4.app.ag.a aVar2 = new android.support.v4.app.ag.a("key_voice_reply_text");
                        aVar2.tc = ab.getContext().getString(R.l.dIt);
                        ag agVar = new ag(aVar2.tb, aVar2.tc, aVar2.td, aVar2.te, aVar2.mExtras);
                        android.support.v4.app.y.f.a.a aVar3 = new android.support.v4.app.y.f.a.a(str2);
                        aVar3.su = broadcast;
                        aVar3.ss = agVar;
                        aVar3.st = broadcast2;
                        int dF = f.dF(str);
                        if (dF > 10) {
                            dF = 10;
                        }
                        ap.yY();
                        List bd = com.tencent.mm.u.c.wT().bd(str, dF);
                        for (int size = bd.size() - 1; size >= 0; size--) {
                            int gh;
                            String trim;
                            Object obj;
                            Object string;
                            au auVar = (au) bd.get(size);
                            if (o.dH(auVar.field_talker)) {
                                String str3 = auVar.field_talker;
                                gh = ay.gh(auVar.field_content);
                                if (gh != -1) {
                                    trim = auVar.field_content.substring(0, gh).trim();
                                    if (trim != null && trim.length() > 0) {
                                        str3 = trim;
                                    }
                                }
                                ap.yY();
                                af Rc = com.tencent.mm.u.c.wR().Rc(str3);
                                trim = n.a(Rc, str3);
                                if (o.dH(str3) && (Rc.field_username.equals(trim) || bg.mA(trim))) {
                                    trim = ab.getContext().getString(R.l.dVr);
                                }
                                obj = trim;
                            } else {
                                obj = null;
                            }
                            if (auVar.bMh()) {
                                string = ab.getContext().getString(R.l.eEm);
                            } else if (auVar.bMk()) {
                                if (!o.dH(auVar.field_talker) || auVar.field_isSend == 1) {
                                    string = auVar.field_content;
                                } else {
                                    gh = ay.gh(auVar.field_content);
                                    string = gh != -1 ? auVar.field_content.substring(gh + 1).trim() : auVar.field_content;
                                }
                            } else if (auVar.bLZ()) {
                                string = ab.getContext().getString(R.l.eEI);
                            } else if (auVar.bMl()) {
                                string = ab.getContext().getString(R.l.eEH);
                            } else if (auVar.bMm()) {
                                string = ab.getContext().getString(R.l.eEE);
                            } else {
                                if (auVar.axO()) {
                                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
                                    if (ek != null) {
                                        switch (ek.type) {
                                            case 2:
                                                string = String.format(ab.getContext().getString(R.l.eEm), new Object[0]);
                                                break;
                                            case 3:
                                                string = String.format(ab.getContext().getString(R.l.eEa), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 4:
                                                string = String.format(ab.getContext().getString(R.l.eEe), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 5:
                                                string = String.format(ab.getContext().getString(R.l.eDX), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 6:
                                                string = String.format(ab.getContext().getString(R.l.eDW), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 8:
                                                string = String.format(ab.getContext().getString(R.l.eEi), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 10:
                                                string = String.format(ab.getContext().getString(R.l.eEb), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 13:
                                                string = String.format(ab.getContext().getString(R.l.eDZ), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 15:
                                                string = String.format(ab.getContext().getString(R.l.eDV), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 16:
                                                string = String.format(ab.getContext().getString(R.l.eEh), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 19:
                                                string = String.format(ab.getContext().getString(R.l.eEc), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 20:
                                                string = String.format(ab.getContext().getString(R.l.eEd), new Object[]{bg.ap(ek.title, "")});
                                                break;
                                            case 24:
                                                string = ab.getContext().getString(R.l.ejR);
                                                break;
                                        }
                                    }
                                } else if (auVar.bMn()) {
                                    String string2 = ab.getContext().getString(R.l.eEj);
                                    d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                                    if (emojiMgr != null) {
                                        com.tencent.mm.storage.a.c ub = emojiMgr.ub(auVar.field_imgPath);
                                        string = bg.mA(emojiMgr.ue(ub.EP())) ? ab.getContext().getString(R.l.eEj) : "[" + emojiMgr.ue(ub.EP()) + "]";
                                    } else {
                                        trim = string2;
                                    }
                                } else if (auVar.bMj()) {
                                    string = ab.getContext().getString(R.l.eEn);
                                } else if (auVar.bMd() || auVar.bMe()) {
                                    if (!auVar.field_content.equals(au.uJQ)) {
                                        trim = auVar.field_content;
                                        b rrVar = new rr();
                                        rrVar.fYI.fJK = 1;
                                        rrVar.fYI.content = trim;
                                        com.tencent.mm.sdk.b.a.urY.m(rrVar);
                                        if ((rrVar.fYJ.type == 3 ? 1 : null) == null) {
                                            string = ab.getContext().getString(R.l.eEJ);
                                        }
                                    }
                                    string = ab.getContext().getString(R.l.eEK);
                                } else if (auVar.bMi()) {
                                    ap.yY();
                                    com.tencent.mm.storage.au.a Av = com.tencent.mm.u.c.wT().Av(auVar.field_content);
                                    string = String.format(ab.getContext().getString(R.l.eEh), new Object[]{Av.getDisplayName()});
                                } else if (auVar.field_type == -1879048186) {
                                    string = ab.getContext().getString(R.l.eDY);
                                }
                                trim = null;
                            }
                            if (string == null) {
                                string = ab.getContext().getString(R.l.eEF);
                            }
                            if (obj != null) {
                                string = String.format("%s: %s", new Object[]{obj, string});
                            }
                            aVar3.sy.add(string);
                            if (size == 0) {
                                aVar3.sw = auVar.field_createTime;
                            }
                        }
                        y.f fVar = new y.f();
                        fVar.sq = new android.support.v4.app.y.f.a((String[]) aVar3.sy.toArray(new String[aVar3.sy.size()]), aVar3.ss, aVar3.st, aVar3.su, new String[]{aVar3.sz}, aVar3.sw);
                        Object obj2 = fVar;
                    } else {
                        gVar = null;
                    }
                    aVar.fDd = gVar;
                } catch (Throwable th) {
                    w.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
                }
            }
            return false;
        }
    };

    static boolean ZU() {
        boolean z;
        try {
            ab.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        w.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
