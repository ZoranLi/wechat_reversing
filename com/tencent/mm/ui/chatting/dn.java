package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.mm.R;
import com.tencent.mm.ap.d;
import com.tencent.mm.ap.e;
import com.tencent.mm.ap.f;
import com.tencent.mm.bi.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.k.a.b.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.Iterator;
import java.util.List;

public final class dn {
    public List<au> kdw;
    ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ dn vIf;

        public final void handleMessage(Message message) {
            if (this.vIf.kdw != null && ap.zb()) {
                w.d("MicroMsg.EggMgr", "post start egg");
                this.vIf.a(this.vIf.vIe, this.vIf.kdw);
            }
        }
    };
    ChattingAnimFrame vId = null;
    public Activity vIe;

    public final void a(Activity activity, List<au> list) {
        if (list != null) {
            for (au auVar : list) {
                Object obj;
                ap.yY();
                if (u.az(u.d((Long) c.vr().get(68108, null))) * 1000 > 21600000) {
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ dn vIf;

                        {
                            this.vIf = r1;
                        }

                        public final void run() {
                            if (ap.zb()) {
                                ap.vd().a(new m(37), 0);
                                ap.yY();
                                c.vr().set(68108, Long.valueOf(u.Ny()));
                            }
                        }
                    }, 10000);
                }
                f alG = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().alG();
                if (alG == null) {
                    w.d("MicroMsg.EggMgr", "eggList is null");
                    obj = null;
                    continue;
                } else {
                    int Ny = (int) bg.Ny();
                    w.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", Integer.valueOf(Ny), Integer.valueOf(alG.hOe.size()));
                    Iterator it = alG.hOe.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        String str = dVar.hNY;
                        Object obj2 = null;
                        if (u.mA(str)) {
                            obj2 = 1;
                        } else {
                            for (String equals : str.split(",")) {
                                if (equals.equals(v.bIN())) {
                                    obj2 = 1;
                                    break;
                                }
                            }
                        }
                        if (obj2 != null) {
                            Iterator it2 = dVar.hNT.iterator();
                            while (it2.hasNext()) {
                                e eVar = (e) it2.next();
                                String str2 = eVar.hOd;
                                if (u.mA(str2)) {
                                    w.e("MicroMsg.EggMgr", "error egg keyWord");
                                } else {
                                    str = auVar.field_content;
                                    if (o.dH(auVar.field_talker)) {
                                        int gh = ay.gh(str);
                                        if (gh != -1) {
                                            str = str.substring(gh + 1).trim();
                                        }
                                    }
                                    if (ad(str, str2, eVar.lang)) {
                                        if (this.vId == null) {
                                            ViewStub viewStub = (ViewStub) activity.findViewById(R.h.cMB);
                                            if (viewStub != null) {
                                                viewStub.inflate();
                                            }
                                            this.vId = (ChattingAnimFrame) activity.findViewById(R.h.bzm);
                                        }
                                        if (this.vId == null) {
                                            w.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                                        } else if (dVar.hNW <= Ny && ((long) Ny) <= ((long) dVar.hNX) + 86400) {
                                            this.vId.a(dVar);
                                            aj(dVar.hNV, auVar.field_isSend == 1);
                                            w.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", str2, Integer.valueOf(dVar.hNW), Integer.valueOf(dVar.hNX));
                                            obj = 1;
                                            continue;
                                        } else if (dVar.hNW == dVar.hNX && dVar.hNW == 0) {
                                            this.vId.a(dVar);
                                            aj(dVar.hNV, auVar.field_isSend == 1);
                                            w.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", str2);
                                            obj = 1;
                                            continue;
                                        } else {
                                            w.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", str2, Integer.valueOf(dVar.hNW), Integer.valueOf(dVar.hNX));
                                            obj = null;
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    w.d("MicroMsg.EggMgr", "no match");
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    return;
                }
            }
        }
    }

    private static boolean ad(String str, String str2, String str3) {
        if (u.mA(str) || u.mA(str2) || ab.getContext() == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || u.mA(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        w.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            g.bKH();
                            a Qz = com.tencent.mm.bi.f.bKE().Qz(substring);
                            substring = Qz != null ? Qz.text : null;
                            if (!u.mA(substring) && substring.length() + indexOf == i) {
                                w.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                w.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    w.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    w.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length()));
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Throwable e) {
                w.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", e.getMessage());
                w.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
                return false;
            }
        } while (indexOf != -1);
        return false;
    }

    private static void aj(int i, boolean z) {
        try {
            com.tencent.mm.ap.h hVar;
            com.tencent.mm.ap.g gVar;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            ap.yY();
            byte[] d = com.tencent.mm.a.e.d(stringBuilder2.append(c.xu()).append("eggresult.rep").toString(), 0, -1);
            if (d != null) {
                w.d("MicroMsg.EggMgr", "data not null, parse it");
                hVar = (com.tencent.mm.ap.h) new com.tencent.mm.ap.h().aD(d);
            } else {
                w.d("MicroMsg.EggMgr", "data is null, new one");
                hVar = new com.tencent.mm.ap.h();
            }
            Iterator it = hVar.hOi.iterator();
            while (it.hasNext()) {
                gVar = (com.tencent.mm.ap.g) it.next();
                if (gVar.hNV == i) {
                    if (z) {
                        gVar.hOg++;
                    } else {
                        gVar.hOh++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        gVar = new com.tencent.mm.ap.g();
                        gVar.hNV = i;
                        if (z) {
                            gVar.hOh = 1;
                        } else {
                            gVar.hOg = 1;
                        }
                        hVar.hOi.add(gVar);
                    }
                    d = hVar.toByteArray();
                    w.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
                    stringBuilder = new StringBuilder();
                    ap.yY();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.xu()).append("eggresult.rep").toString(), d, d.length);
                }
            }
            i2 = 0;
            if (i2 == 0) {
                gVar = new com.tencent.mm.ap.g();
                gVar.hNV = i;
                if (z) {
                    gVar.hOh = 1;
                } else {
                    gVar.hOg = 1;
                }
                hVar.hOi.add(gVar);
            }
            d = hVar.toByteArray();
            w.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
            stringBuilder = new StringBuilder();
            ap.yY();
            com.tencent.mm.a.e.b(stringBuilder.append(c.xu()).append("eggresult.rep").toString(), d, d.length);
        } catch (Throwable e) {
            w.w("MicroMsg.EggMgr", "statistics crash : %s", e.getLocalizedMessage());
            w.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
        }
    }
}
