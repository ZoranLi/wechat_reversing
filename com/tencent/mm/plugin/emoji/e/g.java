package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.b;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.k.a.b.m;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.t;
import com.tencent.mm.storage.a.u;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g implements d {
    public final c ub(String str) {
        return h.amc().kLa.Si(str);
    }

    public final c c(c cVar) {
        if (cVar.field_catalog != a.uKR || cVar.field_type != c.uKZ || cVar.pM().length() <= 0 || !c.yI(bg.getInt(cVar.pM(), 0))) {
            return cVar;
        }
        Cursor yM = h.amc().kLa.yM(bg.getInt(cVar.pM(), 0));
        int dM = bg.dM(yM.getCount() - 1, 0);
        cVar = new c();
        yM.moveToPosition(dM);
        cVar.b(yM);
        yM.close();
        return cVar;
    }

    public final boolean a(Context context, c cVar, int i, String str) {
        if (context == null) {
            w.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            return false;
        } else if (cVar == null) {
            w.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", cVar.EP());
            intent.putExtra("extra_scence", i);
            intent.addFlags(65536);
            intent.putExtra("extra_username", str);
            context.startActivity(intent);
            return true;
        }
    }

    public final void a(Context context, au auVar) {
        if (context == null || auVar == null) {
            w.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            return;
        }
        aj RD = aj.RD(auVar.field_content);
        f.a ek = f.a.ek(auVar.field_content);
        if (ek == null) {
            ek = new f.a();
            ek.hhs = RD.fFW;
        }
        c Si = h.amc().kLa.Si(ek.hhs);
        long j;
        if (auVar.field_isSend == 1) {
            if (Si == null || !Si.bNr()) {
                j = auVar.field_msgId;
                c(ek);
                return;
            }
            a(context, ek.hhs, ek.appId, ek.appName, auVar.field_msgSvrId, auVar.field_talker, auVar.field_content);
        } else if (Si == null || !Si.bNr()) {
            j = auVar.field_msgId;
            c(ek);
        } else {
            a(context, Si.EP(), ek.appId, ek.appName, auVar.field_msgSvrId, auVar.field_talker, auVar.field_content);
        }
    }

    public final boolean l(Context context, String str, String str2) {
        if (context == null) {
            w.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            return false;
        } else if (bg.mA(str) || bg.mA(str2)) {
            w.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            return false;
        } else {
            c Si = h.amc().kLa.Si(str2);
            if (Si == null) {
                w.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[]{str2});
                return false;
            }
            if (Si.field_type == c.uLc || Si.field_type == c.uLd) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xi()).append(Si.EP()).toString();
                if (e.aO(stringBuilder2 + "_thumb")) {
                    wXMediaMessage.thumbData = e.c(stringBuilder2 + "_thumb", 0, e.aN(stringBuilder2 + "_thumb"));
                } else {
                    wXMediaMessage.setThumbImage(Si.ew(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                l.a(wXMediaMessage, Si.field_app_id, null, str, 0, Si.EP());
            } else {
                c cVar;
                if (Si.field_type == c.uKZ) {
                    Cursor yM = c.yI(Si.field_catalog) ? h.amc().kLa.yM(Si.field_catalog) : (Si.field_catalog == c.uKU && Si.pM().length() > 0 && c.yI(bg.getInt(Si.pM(), 0))) ? h.amc().kLa.yM(bg.getInt(Si.pM(), 0)) : null;
                    if (yM != null) {
                        int dM = bg.dM(yM.getCount() - 1, 0);
                        cVar = new c();
                        yM.moveToPosition(dM);
                        cVar.b(yM);
                        yM.close();
                        h.alW().a(str, cVar, null);
                    }
                }
                cVar = Si;
                h.alW().a(str, cVar, null);
            }
            return true;
        }
    }

    public final void a(String str, c cVar, au auVar) {
        if (cVar != null || auVar != null) {
            if (cVar == null) {
                cVar = h.amc().kLa.Si(auVar.field_imgPath);
            }
            h.alW().a(str, cVar, auVar);
        }
    }

    private static void a(Context context, String str, String str2, String str3, long j, String str4, String str5) {
        if (str.equals("-1")) {
            w.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        c Si = h.amc().kLa.Si(str);
        if (Si == null) {
            w.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", Si.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j);
        intent.putExtra("msg_content", str5);
        if (o.dH(str4)) {
            str4 = ay.gi(str5);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
    }

    private static void c(f.a aVar) {
        h.amf();
        if (aVar == null) {
            w.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            return;
        }
        String str = aVar.hhs;
        if (bg.mA(str)) {
            w.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            return;
        }
        c cVar = new c();
        cVar.field_md5 = str;
        cVar.field_app_id = aVar.appId;
        cVar.field_catalog = c.uKT;
        cVar.field_size = aVar.hhq;
        cVar.field_temp = 1;
        cVar.field_state = c.uLi;
        h.amc().kLa.s(cVar);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        ap.vd().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
        b.aK(str, 0);
        w.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", new Object[]{str});
    }

    public final al bO(String str, String str2) {
        Map q = bh.q(str, "msg");
        if (q == null) {
            w.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            return null;
        }
        al a = al.a(q, str2, str, "");
        if (a != null) {
            return a;
        }
        w.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error " + str);
        return null;
    }

    public final void d(c cVar) {
        h.amc().kLa.t(cVar);
    }

    public final String uc(String str) {
        return EmojiLogic.uc(str);
    }

    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        return EmojiLogic.b(context, wXMediaMessage, str);
    }

    public final boolean a(String str, String str2, long j, String str3, com.tencent.mm.y.d.a aVar) {
        com.tencent.mm.plugin.emoji.model.c alW = h.alW();
        w.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml " + str2);
        al a = al.a(bh.q(str2, "msg"), str, str2, str3);
        if (a == null) {
            w.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            a.fTQ = j;
            w.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[]{Long.valueOf(j), bg.bJZ()});
            alW.uv(a == null ? null : a.fGa);
            alW.a(a, aVar, !EmojiLogic.uu(com.tencent.mm.i.g.sV().getValue("C2CEmojiNotAutoDownloadTimeRange")));
        }
        return true;
    }

    public final List<c> ud(String str) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            return (ArrayList) h.amc().kLa.ud(str);
        }
        return new ArrayList();
    }

    public final String ue(String str) {
        a alX = h.alX();
        if (alX.kJp != null && alX.kJp.containsKey(str)) {
            return (String) alX.kJp.get(str);
        }
        com.tencent.mm.storage.a.e eVar = h.amc().kLc;
        String str2 = null;
        String format = String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "md5_lang"});
        Cursor a = eVar.gUz.a(format, new String[]{str + v.bIN().toLowerCase()}, 2);
        if (a.moveToFirst()) {
            str2 = a.getString(a.getColumnIndex("desc"));
        }
        a.close();
        if (!bg.mA(str2)) {
            return str2;
        }
        Cursor a2 = eVar.gUz.a(format, new String[]{str + "default"}, 2);
        if (a2.moveToFirst()) {
            str2 = a2.getString(a2.getColumnIndex("desc"));
        }
        a2.close();
        return str2;
    }

    public final boolean uf(String str) {
        return h.amc().kLb.Sc(str);
    }

    public final ArrayList<String> ug(String str) {
        a alX = h.alX();
        if (!alX.kJl) {
            alX.alv();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int Un = com.tencent.mm.ui.tools.h.Un(str);
        if (Un < alX.kJn || Un > alX.kJo) {
            w.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            return null;
        }
        if (!(bg.mA(str) || alX.kJs == null)) {
            String toLowerCase = str.toLowerCase();
            ArrayList arrayList3 = new ArrayList();
            if (alX.kJr.containsKey(toLowerCase)) {
                arrayList3.addAll((Collection) alX.kJq.get(alX.kJr.get(toLowerCase)));
            } else {
                arrayList3.add(toLowerCase);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) alX.kJs.get((String) it.next());
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    arrayList.addAll(arrayList4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, alX.kJt);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((a) arrayList.get(i)).fFW);
            }
        }
        w.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList2;
    }

    public final String uh(String str) {
        return EmojiLogic.uh(str);
    }

    public final String ui(String str) {
        return EmojiLogic.ui(str);
    }

    public final int uj(String str) {
        return EmojiLogic.uj(str);
    }

    public final String uk(String str) {
        return EmojiLogic.uk(str);
    }

    public final int e(c cVar) {
        if (cVar != null) {
            if (cVar.field_catalog == c.uKW || String.valueOf(c.uKW).equals(cVar.field_groupId)) {
                return R.g.bfY;
            }
            if (cVar.field_catalog == c.uKX || String.valueOf(c.uKX).equals(cVar.field_groupId)) {
                return R.g.bey;
            }
        }
        return 0;
    }

    public final int[] f(c cVar) {
        if (cVar != null) {
            if (cVar.field_catalog == c.uKW) {
                return new int[]{R.g.bga, R.g.bgb, R.g.bfZ};
            } else if (cVar.field_catalog == c.uKX) {
                return new int[]{R.g.bez, R.g.beA, R.g.beB, R.g.beC};
            }
        }
        return null;
    }

    public final byte[] g(c cVar) {
        return e.alz().a(cVar);
    }

    public final boolean alC() {
        return (com.tencent.mm.i.g.sV().getInt("EmotionRewardOption", 0) & 4) == 4;
    }

    public final ArrayList<s> alD() {
        return h.amc().kLi.alD();
    }

    public final ArrayList<String> alE() {
        return h.amc().kLi.alE();
    }

    public final ArrayList<u> alF() {
        return h.amc().kLj.alF();
    }

    public final boolean s(ArrayList<s> arrayList) {
        t tVar = h.amc().kLi;
        if (arrayList.size() <= 0) {
            w.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
        } else {
            long cs;
            com.tencent.mm.bj.g gVar;
            if (tVar.gUz instanceof com.tencent.mm.bj.g) {
                com.tencent.mm.bj.g gVar2 = (com.tencent.mm.bj.g) tVar.gUz;
                cs = gVar2.cs(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                cs = -1;
                gVar = null;
            }
            tVar.gUz.delete("SmileyInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tVar.b((s) it.next());
            }
            int i = -1;
            if (gVar != null) {
                i = gVar.aD(cs);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean t(ArrayList<u> arrayList) {
        com.tencent.mm.storage.a.v vVar = h.amc().kLj;
        if (arrayList.size() <= 0) {
            w.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long cs;
            com.tencent.mm.bj.g gVar;
            if (vVar.gUz instanceof com.tencent.mm.bj.g) {
                com.tencent.mm.bj.g gVar2 = (com.tencent.mm.bj.g) vVar.gUz;
                cs = gVar2.cs(Thread.currentThread().getId());
                gVar = gVar2;
            } else {
                cs = -1;
                gVar = null;
            }
            vVar.gUz.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                vVar.b((u) it.next());
            }
            int i = -1;
            if (gVar != null) {
                i = gVar.aD(cs);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final String bP(String str, String str2) {
        ap.yY();
        return EmojiLogic.D(com.tencent.mm.u.c.xi(), str, str2);
    }

    public final com.tencent.mm.ap.f alG() {
        return i.alH().alG();
    }

    public final void ul(String str) {
        Throwable th;
        Cursor cursor = null;
        if (bg.mA(str)) {
            w.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
        }
        if ("sync".equalsIgnoreCase(str)) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzG, Boolean.valueOf(true));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzL, Boolean.valueOf(true));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzO, Long.valueOf(0));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzF, Long.valueOf(0));
            ap.vd().a(new com.tencent.mm.plugin.emoji.f.e(), 0);
            ap.vd().a(new n(8, null, 15, true), 0);
        } else if ("rcheart".equalsIgnoreCase(str)) {
            h.amc().kLb.bNq();
        } else if ("recover".equalsIgnoreCase(str)) {
            w.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
            h.amc().kLa.eu(ab.getContext());
            h.amc().kLb.eu(ab.getContext());
            w.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        } else if ("clean".equalsIgnoreCase(str)) {
            w.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            d aly = d.aly();
            ap.yY();
            aly.ua(com.tencent.mm.u.c.xi());
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzL, Boolean.valueOf(true));
            w.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        } else if ("dump".equalsIgnoreCase(str)) {
            w.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            ArrayList arrayList = (ArrayList) h.amc().kLb.bNb();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    a aVar = (a) arrayList.get(i);
                    w.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[]{Integer.valueOf(i), aVar.toString()});
                }
            }
            Cursor Kk;
            try {
                Kk = h.amc().kLa.Kk();
                if (Kk != null) {
                    try {
                        if (Kk.moveToFirst()) {
                            do {
                                new c().b(Kk);
                                w.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[]{r1.toString()});
                            } while (Kk.moveToNext());
                        }
                    } catch (Exception e) {
                        if (Kk != null) {
                            Kk.close();
                        }
                        w.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                    } catch (Throwable th2) {
                        cursor = Kk;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (Kk != null) {
                    Kk.close();
                }
            } catch (Exception e2) {
                Kk = null;
                if (Kk != null) {
                    Kk.close();
                }
                w.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            w.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
        } else if ("config".equalsIgnoreCase(str)) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzV, Integer.valueOf(0));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzW, Integer.valueOf(0));
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzY, Integer.valueOf(0));
            ap.vd().a(new m(37), 0);
        } else if ("tuzki".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.emoji.f.a.amh();
            com.tencent.mm.plugin.emoji.f.a.ami();
        }
    }
}
