package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.b;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

public final class a extends c<jz> {
    public a() {
        this.usg = jz.class.getName().hashCode();
    }

    private static boolean a(jz jzVar) {
        if ((jzVar.fQn.field_status == 3 || jzVar.fQn.field_status == 2) && e.aO(jzVar.fQn.field_path) && jzVar.fQn.field_path.endsWith("..htm")) {
            com.tencent.mm.plugin.wenote.model.e.r(jzVar.fQn.field_favLocalId, jzVar.fQn.field_path);
        }
        b bVar = com.tencent.mm.plugin.wenote.model.a.bAZ().stz;
        if (bVar != null) {
            com.tencent.mm.plugin.wenote.model.c cVar = new com.tencent.mm.plugin.wenote.model.c();
            cVar.field_dataId = jzVar.fQn.field_dataId;
            cVar.field_favLocalId = jzVar.fQn.field_favLocalId;
            cVar.field_offset = jzVar.fQn.field_offset;
            cVar.field_totalLen = jzVar.fQn.field_totalLen;
            cVar.field_status = jzVar.fQn.field_status;
            cVar.field_path = jzVar.fQn.field_path;
            cVar.field_localId = jzVar.fQn.field_localId;
            boolean z = cVar.field_status == 3 || cVar.field_status == 2;
            if (z && e.aO(cVar.field_path)) {
                String str = (String) bVar.soC.get(cVar.field_dataId);
                if (!bg.mA(str)) {
                    w.d("MicroMsg.NotifyWNNoteCdnChangedListener", "on cdn status change,editorId[%s]", new Object[]{str});
                    if (!cVar.field_dataId.endsWith("_t") || bVar.stD.get(str) == null) {
                        r rVar;
                        if (str.equals("WeNoteHtmlFile")) {
                            w.d("MicroMsg.NotifyWNNoteCdnChangedListener", "WNNote:webview reload");
                            if (bVar.stA.fQF == -1) {
                                rVar = (r) bVar.stC.get(Long.toString(bVar.stA.fGM));
                            } else {
                                rVar = (r) bVar.stC.get(Long.toString(bVar.stA.fQF));
                            }
                            if (rVar != null) {
                                try {
                                    rVar.fQB = bg.convertStreamToString(new FileInputStream(new File(cVar.field_path)));
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bBv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
                                    str = rVar.fQB;
                                    if (!(bg.mA(str) || bBv.jnH == null)) {
                                        List Lu = com.tencent.mm.plugin.wenote.b.a.Lu(str);
                                        if (Lu != null && Lu.size() > 0) {
                                            synchronized (bBv) {
                                                try {
                                                    bBv.svl.l(g.a(bBv.jnH, Lu, false), true);
                                                } catch (Exception e) {
                                                    w.e("MicroMsg.WNNote.NoteDataManager", "updateDataByHtml exception,%s", new Object[]{e.toString()});
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.NotifyWNNoteCdnChangedListener", e2, "", new Object[0]);
                                }
                                if (!com.tencent.mm.pluginsdk.model.c.sCd) {
                                    com.tencent.mm.sdk.b.b kbVar = new kb();
                                    kbVar.fQz.fQD = bVar.bBb();
                                    kbVar.fQz.fQB = rVar.fQB;
                                    kbVar.fQz.type = 0;
                                    kbVar.fQz.context = ab.getContext();
                                    kbVar.fQz.fQF = cVar.field_favLocalId;
                                    kbVar.fQz.fQG = g.bP(bVar.stA.oOQ);
                                    com.tencent.mm.sdk.b.a.urY.m(kbVar);
                                }
                            }
                        } else if (bVar.soC.containsValue("WeNoteHtmlFile")) {
                            if (bVar.stA.fQF == -1) {
                                rVar = (r) bVar.stC.get(Long.toString(bVar.stA.fGM));
                            } else {
                                rVar = (r) bVar.stC.get(Long.toString(bVar.stA.fQF));
                            }
                            if (!(rVar == null || rVar.suR == null)) {
                                Iterator it = rVar.suR.iterator();
                                while (it.hasNext()) {
                                    com.tencent.mm.plugin.wenote.model.a.a aVar = (k) it.next();
                                    if (aVar.suI.equals(str)) {
                                        aVar.suJ = true;
                                        if (aVar.getType() != 2) {
                                            aVar.fQE = cVar.field_path;
                                        }
                                        if (aVar.type == 4) {
                                            int i;
                                            q qVar = (q) aVar;
                                            qVar.fQH = b.stI;
                                            rm Li = bVar.Li(cVar.field_dataId);
                                            if (Li == null) {
                                                w.e("MicroMsg.NotifyWNNoteCdnChangedListener", "favData is null");
                                                i = 0;
                                            } else {
                                                i = Li.duration;
                                            }
                                            qVar.length = (int) com.tencent.mm.plugin.wenote.model.e.aw((long) i);
                                            qVar.suP = com.tencent.mm.plugin.wenote.model.e.J(ab.getContext(), qVar.length);
                                        }
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(str, aVar);
                                    }
                                }
                            }
                        } else {
                            com.tencent.mm.sdk.b.b kbVar2 = new kb();
                            kbVar2.fQz.fQq = str;
                            kbVar2.fQz.fQE = cVar.field_path;
                            kbVar2.fQz.type = 1;
                            kbVar2.fQz.fQv = ((k) bVar.stD.get(str)).type;
                            if (com.tencent.mm.pluginsdk.model.c.sCd && kbVar2.fQz.fQv != 4) {
                                if (kbVar2.fQz.fQv != 2) {
                                    ((k) bVar.stD.get(str)).fQE = cVar.field_path;
                                }
                                ((k) bVar.stD.get(str)).suJ = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(str, (com.tencent.mm.plugin.wenote.model.a.a) bVar.stD.get(str));
                            }
                            if (5 != kbVar2.fQz.fQv) {
                                if (kbVar2.fQz.fQv == 4) {
                                    int i2;
                                    rm Li2 = bVar.Li(cVar.field_dataId);
                                    if (Li2 == null) {
                                        w.e("MicroMsg.NotifyWNNoteCdnChangedListener", "favData is null");
                                        i2 = 0;
                                    } else {
                                        i2 = Li2.duration;
                                    }
                                    kbVar2.fQz.fKx = i2;
                                    ((k) bVar.stD.get(str)).fQE = cVar.field_path;
                                    ((k) bVar.stD.get(str)).suJ = true;
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(str, (com.tencent.mm.plugin.wenote.model.a.a) bVar.stD.get(str));
                                }
                                w.i("MicroMsg.NotifyWNNoteCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[]{kbVar2.fQz.fQq, kbVar2.fQz.fQE});
                                if (!com.tencent.mm.pluginsdk.model.c.sCd) {
                                    com.tencent.mm.sdk.b.a.urY.m(kbVar2);
                                }
                            }
                        }
                        bVar.soC.remove(cVar.field_dataId);
                    } else {
                        if (((k) bVar.stD.get(str)).getType() == 2) {
                            ((k) bVar.stD.get(str)).fQE = cVar.field_path;
                        }
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(str, (com.tencent.mm.plugin.wenote.model.a.a) bVar.stD.get(str));
                        bVar.soC.remove(cVar.field_dataId);
                    }
                }
            }
        }
        return false;
    }
}
