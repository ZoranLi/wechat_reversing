package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.le;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r {

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fxL;
        final /* synthetic */ rm lEs;
        final /* synthetic */ Runnable lcs;
        final /* synthetic */ Context val$context;

        public AnonymousClass3(rm rmVar, Context context, String str, Runnable runnable) {
            this.lEs = rmVar;
            this.val$context = context;
            this.fxL = str;
            this.lcs = runnable;
        }

        public final void run() {
            if (this.lEs.aMw == 15) {
                r.a(this.val$context, this.fxL, this.lEs);
            } else {
                r.b(this.val$context, this.fxL, this.lEs);
            }
            af.v(this.lcs);
        }

        public final String toString() {
            return super.toString() + "|sendFavVideo";
        }
    }

    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ String fxL;
        final /* synthetic */ String hGd;
        final /* synthetic */ int iVb;
        final /* synthetic */ String lEt;
        final /* synthetic */ String lEu;
        final /* synthetic */ Runnable lcs;
        final /* synthetic */ Context val$context;

        public AnonymousClass5(Context context, String str, String str2, String str3, int i, String str4, Runnable runnable) {
            this.val$context = context;
            this.fxL = str;
            this.lEt = str2;
            this.hGd = str3;
            this.iVb = i;
            this.lEu = str4;
            this.lcs = runnable;
        }

        public final void run() {
            Context context = this.val$context;
            String str = this.fxL;
            String str2 = this.lEt;
            String str3 = this.hGd;
            int i = this.iVb;
            String str4 = this.lEu;
            File file = new File(str2);
            if (file.exists()) {
                File file2 = new File(str3);
                w.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
                d.aJW().a(context, str, file.getAbsolutePath(), str3, 1, i, str4);
            }
            af.v(this.lcs);
        }

        public final String toString() {
            return super.toString() + "|sendFavVideo";
        }
    }

    public static class a {
        public String desc;
        public String fKz;
        public String lEv;
        public String title;

        private static boolean vT(String str) {
            return new File(str).exists();
        }

        public static a a(Context context, j jVar) {
            int i;
            String str;
            String h;
            if (jVar.field_type == 18) {
                a aVar = new a();
                SparseIntArray sparseIntArray = new SparseIntArray();
                if (jVar.field_type == 18) {
                    aVar.title = jVar.field_favProto.title;
                }
                List<String> linkedList = new LinkedList();
                i = 0;
                int i2 = 0;
                for (rm rmVar : jVar.field_favProto.tzn) {
                    if (jVar.field_type != 18 || bg.mA(rmVar.txx) || !rmVar.txx.equals(".htm")) {
                        sparseIntArray.put(rmVar.aMw, sparseIntArray.get(rmVar.aMw) + 1);
                        switch (rmVar.aMw) {
                            case 1:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                str = rmVar.desc;
                                if (!bg.mA(str)) {
                                    linkedList.add(str.replaceAll("&lt;", "<").replaceAll("&gt;", ">") + "\n");
                                    break;
                                }
                                break;
                            case 2:
                                linkedList.size();
                                if (i != 0) {
                                    break;
                                }
                                h = x.h(rmVar);
                                if (!vT(h)) {
                                    aVar.fKz = x.g(rmVar);
                                    i = 1;
                                    break;
                                }
                                aVar.fKz = h;
                                i = 1;
                                break;
                            case 3:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                int ca = (int) x.ca((long) rmVar.duration);
                                linkedList.add(context.getString(R.l.dIY) + context.getString(R.l.ema, new Object[]{Integer.valueOf(ca)}) + "\n");
                                break;
                            case 4:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.l.dIX) + "\n");
                                break;
                            case 6:
                                if (linkedList.size() < 4) {
                                    rs rsVar = rmVar.tyc.tyw;
                                    StringBuilder append = new StringBuilder().append(context.getString(R.l.dHB));
                                    str = (bg.mA(rsVar.fRX) || rsVar.fRX.equals(context.getString(R.l.ewy))) ? rsVar.label : rsVar.fRX;
                                    linkedList.add(append.append(str).append("\n").toString());
                                }
                                if (i2 != 0) {
                                    break;
                                }
                                i2 = 1;
                                break;
                                break;
                            case 8:
                                if (linkedList.size() < 4) {
                                    linkedList.add(context.getString(R.l.dHn) + rmVar.title + "\n");
                                }
                                if (i2 != 0) {
                                    break;
                                }
                                i2 = 1;
                                break;
                            case 17:
                                if (linkedList.size() >= 4) {
                                    break;
                                }
                                linkedList.add(context.getString(R.l.dIr) + "\n");
                                break;
                            default:
                                break;
                        }
                    }
                }
                aVar.desc = "";
                h = "";
                for (String str2 : linkedList) {
                    h = h + str2;
                }
                str2 = h.trim();
                if (linkedList.size() >= 4) {
                    str2 = str2 + "...";
                }
                aVar.desc = str2;
                aVar.title = ab.getContext().getString(R.l.ejP);
                return aVar;
            }
            a aVar2 = new a();
            SparseIntArray sparseIntArray2 = new SparseIntArray();
            if (jVar.field_type == 14) {
                aVar2.title = jVar.field_favProto.title;
            }
            List<String> linkedList2 = new LinkedList();
            i = 0;
            for (rm rmVar2 : jVar.field_favProto.tzn) {
                sparseIntArray2.put(rmVar2.aMw, sparseIntArray2.get(rmVar2.aMw) + 1);
                switch (rmVar2.aMw) {
                    case 1:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(rmVar2.tye + ":" + rmVar2.desc + "\n");
                        break;
                    case 2:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIi) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        str2 = x.h(rmVar2);
                        if (vT(str2)) {
                            aVar2.fKz = str2;
                            ca = 1;
                        } else {
                            ca = i;
                        }
                        i = ca;
                        break;
                    case 3:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        int aw = (int) x.aw((long) rmVar2.duration);
                        linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIY) + context.getString(R.l.ema, new Object[]{Integer.valueOf(aw)}) + "\n");
                        break;
                    case 4:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIX) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        str2 = x.h(rmVar2);
                        if (vT(str2)) {
                            aVar2.fKz = str2;
                            ca = 1;
                        } else {
                            ca = i;
                        }
                        i = ca;
                        break;
                    case 5:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIU) + rmVar2.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        h = x.h(rmVar2);
                        if (vT(h)) {
                            aVar2.fKz = h;
                        } else {
                            sf sfVar = rmVar2.tyc.tyy;
                            h = sfVar == null ? "" : sfVar.thumbUrl;
                            if (bg.mA(h)) {
                                h = bg.ap(rmVar2.fFs, "");
                            }
                            a(aVar2, h);
                        }
                        i = 1;
                        break;
                    case 6:
                        if (linkedList2.size() < 4) {
                            rs rsVar2 = rmVar2.tyc.tyw;
                            append = new StringBuilder().append(rmVar2.tye).append(":").append(context.getString(R.l.dHB));
                            str2 = (bg.mA(rsVar2.fRX) || rsVar2.fRX.equals(context.getString(R.l.ewy))) ? rsVar2.label : rsVar2.fRX;
                            linkedList2.add(append.append(str2).append("\n").toString());
                        }
                        if (i != 0) {
                            break;
                        }
                        i = 1;
                        break;
                        break;
                    case 7:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dHI) + rmVar2.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        a(aVar2, rmVar2.fFs);
                        i = 1;
                        break;
                    case 8:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dHn) + rmVar2.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        i = 1;
                        break;
                    case 10:
                    case 11:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIk) + rmVar2.tyc.tyA.title + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        ru ruVar = rmVar2.tyc.tyA;
                        if (ruVar != null) {
                            a(aVar2, ruVar.thumbUrl);
                        }
                        i = 1;
                        break;
                    case 14:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dDm) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        rz rzVar = rmVar2.tyc.tyC;
                        if (rzVar != null) {
                            a(aVar2, rzVar.thumbUrl);
                        }
                        i = 1;
                        break;
                    case 15:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIH) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        str2 = x.h(rmVar2);
                        if (vT(str2)) {
                            aVar2.fKz = str2;
                            ca = 1;
                        } else {
                            ca = i;
                        }
                        i = ca;
                        break;
                    case 16:
                        if (linkedList2.size() < 4) {
                            linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dHr) + "\n");
                        }
                        if (i != 0) {
                            break;
                        }
                        ap.yY();
                        aVar2.lEv = c.wT().Av(rmVar2.desc).rUK;
                        i = 1;
                        break;
                    case 17:
                        if (linkedList2.size() >= 4) {
                            break;
                        }
                        linkedList2.add(rmVar2.tye + ":" + context.getString(R.l.dIr) + "\n");
                        break;
                    default:
                        break;
                }
            }
            aVar2.desc = "";
            h = "";
            for (String str22 : linkedList2) {
                h = h + str22;
            }
            str22 = h.trim();
            if (linkedList2.size() >= 4) {
                str22 = str22 + "...";
            }
            aVar2.desc = str22;
            return aVar2;
        }

        private static void a(a aVar, String str) {
            String str2 = x.aty() + g.n(bg.ap(str, "").getBytes());
            if (vT(str2)) {
                aVar.fKz = str2;
            }
        }
    }

    static class AnonymousClass2 implements com.tencent.mm.plugin.favorite.b.ag.a {
        final /* synthetic */ j lEr;
        final /* synthetic */ Runnable lcs;
        final /* synthetic */ Context val$context;

        public AnonymousClass2(j jVar, Context context, Runnable runnable) {
            this.lEr = jVar;
            this.val$context = context;
            this.lcs = runnable;
        }

        public final void a(SparseArray<String> sparseArray) {
            String str = (String) sparseArray.get(this.lEr.field_id);
            w.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", new Object[]{Integer.valueOf(this.lEr.field_id), str});
            if (!bg.mA(str)) {
                if (4 == this.lEr.field_type) {
                    rm n = x.n(this.lEr);
                    String ap = bg.ap(n.title, this.val$context.getString(R.l.ejL));
                    Intent intent = new Intent();
                    intent.putExtra("Ksnsupload_link", str);
                    intent.putExtra("Ksnsupload_title", ap);
                    intent.putExtra("Ksnsupload_imgbuf", e.d(x.h(n), 0, -1));
                    com.tencent.mm.plugin.favorite.c.imv.m(intent, this.val$context);
                    str = "fav_" + m.xL() + "_" + this.lEr.field_id;
                    String fQ = q.fQ(str);
                    q.yC().n(fQ, true).l("prePublishId", str);
                    intent.putExtra("reportSessionId", fQ);
                    com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0)});
                } else {
                    w.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", new Object[]{Integer.valueOf(this.lEr.field_type), Integer.valueOf(this.lEr.field_id)});
                }
            }
            if (this.lcs != null) {
                af.v(this.lcs);
            }
        }
    }

    public static void a(Context context, String str, String str2, j jVar, Runnable runnable) {
        List linkedList = new LinkedList();
        linkedList.add(jVar);
        a(context, str, str2, linkedList, runnable);
    }

    public static void a(Context context, String str, String str2, List<j> list, Runnable runnable) {
        if (context == null) {
            w.w("MicroMsg.FavSendLogic", "want to send fav msg, but context is null");
            af.v(runnable);
        } else if (bg.mA(str)) {
            w.w("MicroMsg.FavSendLogic", "want to send fav msg, but to user is null");
            af.v(runnable);
        } else if (list.isEmpty()) {
            w.w("MicroMsg.FavSendLogic", "want to send fav msg, but info is null");
            af.v(runnable);
        } else {
            final String str3 = str;
            final List<j> list2 = list;
            final Context context2 = context;
            final String str4 = str2;
            final Runnable runnable2 = runnable;
            ap.vL().D(new Runnable() {
                public final void run() {
                    for (String str : bg.f(str3.split(","))) {
                        for (j jVar : list2) {
                            if (jVar != null) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(10925, new Object[]{Integer.valueOf(jVar.field_type), Integer.valueOf(jVar.field_id)});
                                byte[] readFromFile;
                                String fQ;
                                Context context;
                                ru ruVar;
                                b leVar;
                                byte[] readFromFile2;
                                switch (jVar.field_type) {
                                    case 1:
                                        d.aJW().A(str, jVar.field_favProto.desc, o.fG(str));
                                        break;
                                    case 2:
                                        Iterator it = jVar.field_favProto.tzn.iterator();
                                        while (it.hasNext()) {
                                            d.aJW().b(context2, str, x.g((rm) it.next()), 0, "", "");
                                        }
                                        break;
                                    case 4:
                                        r.b(context2, str, x.n(jVar));
                                        break;
                                    case 5:
                                        if (jVar != null) {
                                            String str2;
                                            rm n = x.n(jVar);
                                            sf sfVar = jVar.field_favProto.tyy;
                                            rw rwVar = jVar.field_favProto.tzl;
                                            com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
                                            if (sfVar != null) {
                                                aVar.title = sfVar.title;
                                                str2 = sfVar.thumbUrl;
                                                if (bg.mA(str2)) {
                                                    str2 = bg.ap(n.fFs, "");
                                                }
                                                aVar.thumburl = str2;
                                            }
                                            if (bg.mA(aVar.title) && n != null) {
                                                aVar.title = n.title;
                                            }
                                            if (sfVar != null) {
                                                aVar.description = sfVar.desc;
                                            }
                                            if (bg.mA(aVar.description) && n != null) {
                                                aVar.description = n.desc;
                                            }
                                            if (jVar.field_favProto.tyy != null) {
                                                aVar.url = jVar.field_favProto.tyy.tzN;
                                            }
                                            if (rwVar != null && bg.mA(aVar.url)) {
                                                aVar.url = rwVar.hSX;
                                            }
                                            if (!(n == null || bg.mA(n.canvasPageXml))) {
                                                aVar.canvasPageXml = n.canvasPageXml;
                                            }
                                            aVar.action = "view";
                                            aVar.type = 5;
                                            aVar.fUY = n.fUY;
                                            readFromFile = bg.readFromFile(x.h(n));
                                            if (readFromFile == null) {
                                                str2 = sfVar == null ? null : sfVar.thumbUrl;
                                                if (bg.mA(str2)) {
                                                    str2 = bg.ap(n.fFs, "");
                                                }
                                                readFromFile = bg.readFromFile(x.aty() + g.n(str2.getBytes()));
                                            }
                                            String str3 = "fav_" + m.xL() + "_" + jVar.field_id;
                                            fQ = q.fQ(str3);
                                            q.b n2 = q.yC().n(fQ, true);
                                            n2.l("prePublishId", str3);
                                            n2.l("preUsername", jVar.field_fromUser);
                                            n2.l("sendAppMsgScene", Integer.valueOf(1));
                                            n2.l("adExtStr", n.fUY);
                                            d.aJW().a(str, readFromFile, com.tencent.mm.t.f.a.a(aVar, null, null), fQ);
                                            break;
                                        }
                                        w.w("MicroMsg.FavSendLogic", "item info is null, send fav url fail, return");
                                        break;
                                    case 6:
                                        rs rsVar = jVar.field_favProto.tyw;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("<msg>");
                                        stringBuilder.append("<location ");
                                        stringBuilder.append("x=\"").append(rsVar.lat).append("\" ");
                                        stringBuilder.append("y=\"").append(rsVar.lng).append("\" ");
                                        stringBuilder.append("scale=\"").append(rsVar.fOd).append("\" ");
                                        stringBuilder.append("label=\"").append(bg.ap(rsVar.label, "")).append("\" ");
                                        stringBuilder.append("maptype=\"0\" ");
                                        stringBuilder.append("poiname=\"").append(bg.ap(rsVar.fRX, "")).append("\" ");
                                        stringBuilder.append("/>");
                                        stringBuilder.append("</msg>");
                                        d.aJW().A(str, stringBuilder.toString(), 48);
                                        break;
                                    case 7:
                                        Context context2 = context2;
                                        rm n3 = x.n(jVar);
                                        IMediaObject wXMusicObject = new WXMusicObject();
                                        wXMusicObject.musicUrl = n3.txp;
                                        wXMusicObject.musicDataUrl = n3.txr;
                                        wXMusicObject.musicLowBandUrl = n3.txt;
                                        wXMusicObject.musicLowBandDataUrl = n3.txt;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                        wXMediaMessage.mediaObject = wXMusicObject;
                                        wXMediaMessage.title = n3.title;
                                        wXMediaMessage.description = n3.desc;
                                        readFromFile = bg.readFromFile(x.h(n3));
                                        if (readFromFile == null) {
                                            readFromFile = bg.readFromFile(x.aty() + g.n(bg.ap(n3.fFs, "").getBytes()));
                                        }
                                        wXMediaMessage.thumbData = readFromFile;
                                        fQ = jVar.field_favProto.tzl.appId;
                                        l.a(wXMediaMessage, fQ, com.tencent.mm.u.x.a.hlQ.m(context2, fQ), str, 3, null);
                                        break;
                                    case 8:
                                        r.a(str, jVar, x.n(jVar));
                                        break;
                                    case 10:
                                        context = context2;
                                        ruVar = jVar.field_favProto.tyA;
                                        leVar = new le();
                                        leVar.fRQ.opType = 0;
                                        leVar.fRQ.fRS = ruVar.info;
                                        leVar.fRQ.context = context;
                                        com.tencent.mm.sdk.b.a.urY.m(leVar);
                                        if (!leVar.fRR.fFj) {
                                            break;
                                        }
                                        readFromFile2 = bg.readFromFile(x.aty() + g.n(bg.ap(ruVar.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bg.readFromFile(leVar.fRR.fKz);
                                        }
                                        d.aJW().a(str, readFromFile2, leVar.fRR.fRT, null);
                                        break;
                                    case 11:
                                        context = context2;
                                        ruVar = jVar.field_favProto.tyA;
                                        leVar = new le();
                                        leVar.fRQ.opType = 1;
                                        leVar.fRQ.fRS = ruVar.info;
                                        leVar.fRQ.context = context;
                                        com.tencent.mm.sdk.b.a.urY.m(leVar);
                                        if (!leVar.fRR.fFj) {
                                            break;
                                        }
                                        readFromFile2 = bg.readFromFile(x.aty() + g.n(bg.ap(ruVar.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bg.readFromFile(leVar.fRR.fKz);
                                        }
                                        d.aJW().a(str, readFromFile2, leVar.fRR.fRT, null);
                                        break;
                                    case 14:
                                    case 18:
                                        w.i("MicroMsg.FavSendLogic", "want send record, fav id %d", new Object[]{Integer.valueOf(jVar.field_id)});
                                        if (jVar.field_id <= 0 && !com.tencent.mm.pluginsdk.model.c.sCd) {
                                            break;
                                        }
                                        a a = a.a(context2, jVar);
                                        rv rvVar = new rv();
                                        try {
                                            w.d("MicroMsg.FavSendLogic", "do clone fav proto item");
                                            rvVar.aD(jVar.field_favProto.toByteArray());
                                        } catch (Throwable e) {
                                            w.printErrStackTrace("MicroMsg.FavSendLogic", e, "", new Object[0]);
                                            w.e("MicroMsg.FavSendLogic", "clone fav proto item error: %s", new Object[]{e.getMessage()});
                                        }
                                        b lzVar = new lz();
                                        lzVar.fTf.type = 2;
                                        lzVar.fTf.toUser = str;
                                        lzVar.fTf.fTi = rvVar;
                                        lzVar.fTf.title = a.title;
                                        lzVar.fTf.desc = a.desc;
                                        lzVar.fTf.fKz = a.fKz;
                                        lzVar.fTf.fTn = a.lEv;
                                        com.tencent.mm.sdk.b.a.urY.m(lzVar);
                                        break;
                                        break;
                                    case 15:
                                        context = context2;
                                        rz rzVar = jVar.field_favProto.tyC;
                                        leVar = new qi();
                                        leVar.fXp.opType = 0;
                                        leVar.fXp.fXr = rzVar.info;
                                        leVar.fXp.context = context;
                                        com.tencent.mm.sdk.b.a.urY.m(leVar);
                                        w.d("MicroMsg.FavSendLogic", "sendFavTV ret = [%s], thumbUrl = [%s]", new Object[]{Boolean.valueOf(leVar.fXq.fFj), rzVar.thumbUrl});
                                        if (!leVar.fXq.fFj) {
                                            break;
                                        }
                                        readFromFile2 = bg.readFromFile(x.aty() + g.n(bg.ap(rzVar.thumbUrl, "").getBytes()));
                                        if (readFromFile2 == null) {
                                            readFromFile2 = bg.readFromFile(leVar.fXq.fKz);
                                        }
                                        d.aJW().a(str, readFromFile2, leVar.fXq.fRT, null);
                                        break;
                                    case 16:
                                        r.a(context2, str, x.n(jVar));
                                        break;
                                    case 17:
                                        d.aJW().A(str, x.n(jVar).desc, 42);
                                        break;
                                    default:
                                        break;
                                }
                            }
                            w.e("MicroMsg.FavSendLogic", "in run workerThread,want to send fav msg, but info is null,infos.size = %d", new Object[]{Integer.valueOf(list2.size())});
                        }
                        if (!bg.mA(str4)) {
                            d.aJW().A(str, str4, o.fG(str));
                        }
                    }
                    af.v(runnable2);
                }

                public final String toString() {
                    return super.toString() + "|sendFavMsg";
                }
            });
        }
    }

    public static void a(Context context, final String str, final j jVar, final rm rmVar, final Runnable runnable) {
        if (context == null) {
            w.w("MicroMsg.FavSendLogic", "want to send fav file, but context is null");
        } else if (bg.mA(str)) {
            w.w("MicroMsg.FavSendLogic", "want to send fav file, but to user is null");
        } else {
            if (jVar == null) {
                w.w("MicroMsg.FavSendLogic", "want to send fav file, but info is null");
            }
            if (rmVar == null) {
                w.w("MicroMsg.FavSendLogic", "want to send fav file, but dataItem is null");
            } else {
                ap.vL().D(new Runnable() {
                    public final void run() {
                        r.a(str, jVar, rmVar);
                        af.v(runnable);
                    }

                    public final String toString() {
                        return super.toString() + "|sendFavFile";
                    }
                });
            }
        }
    }

    public static void a(Context context, String str, rm rmVar) {
        File file = new File(x.g(rmVar));
        if (file.exists()) {
            String c = c(rmVar);
            w.d("MicroMsg.FavSendLogic", "send fav short Video::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), c});
            bdu com_tencent_mm_protocal_c_bdu = null;
            rp rpVar = rmVar.tyi;
            if (rpVar != null) {
                com_tencent_mm_protocal_c_bdu = new bdu();
                com_tencent_mm_protocal_c_bdu.hjI = rpVar.hjI;
                com_tencent_mm_protocal_c_bdu.hjF = rpVar.hjF;
                com_tencent_mm_protocal_c_bdu.tyZ = rpVar.tyZ;
                com_tencent_mm_protocal_c_bdu.hjD = rpVar.hjD;
                com_tencent_mm_protocal_c_bdu.hjG = rpVar.hjG;
                com_tencent_mm_protocal_c_bdu.hjJ = rpVar.hjJ;
                com_tencent_mm_protocal_c_bdu.hjK = rpVar.hjK;
                com_tencent_mm_protocal_c_bdu.hjH = rpVar.hjH;
            }
            if (com_tencent_mm_protocal_c_bdu != null) {
                d.aJW().a(context, str, file.getAbsolutePath(), c, 62, rmVar.duration, com_tencent_mm_protocal_c_bdu, false, false, rmVar.fUY);
                return;
            }
            d.aJW().a(context, str, file.getAbsolutePath(), c, 62, rmVar.duration, rmVar.fUY);
            return;
        }
        w.w("MicroMsg.FavSendLogic", "sendShortVideo, error! data not existed");
    }

    public static String c(rm rmVar) {
        File file = new File(x.h(rmVar));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return x.aty() + g.n(bg.ap(rmVar.fFs, "").getBytes());
    }

    public static void b(Context context, String str, rm rmVar) {
        File file = new File(x.g(rmVar));
        if (file.exists()) {
            String absolutePath;
            File file2 = new File(x.h(rmVar));
            if (file2.exists()) {
                absolutePath = file2.getAbsolutePath();
            } else {
                absolutePath = x.aty() + g.n(bg.ap(rmVar.fFs, "").getBytes());
            }
            w.d("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", new Object[]{file.getAbsolutePath(), absolutePath});
            bdu com_tencent_mm_protocal_c_bdu = null;
            rp rpVar = rmVar.tyi;
            if (rpVar != null) {
                com_tencent_mm_protocal_c_bdu = new bdu();
                com_tencent_mm_protocal_c_bdu.hjI = rpVar.hjI;
                com_tencent_mm_protocal_c_bdu.hjF = rpVar.hjF;
                com_tencent_mm_protocal_c_bdu.tyZ = rpVar.tyZ;
                com_tencent_mm_protocal_c_bdu.hjD = rpVar.hjD;
                com_tencent_mm_protocal_c_bdu.hjG = rpVar.hjG;
                com_tencent_mm_protocal_c_bdu.hjJ = rpVar.hjJ;
                com_tencent_mm_protocal_c_bdu.hjK = rpVar.hjK;
            }
            if (com_tencent_mm_protocal_c_bdu != null) {
                d.aJW().a(context, str, file.getAbsolutePath(), absolutePath, 1, rmVar.duration, com_tencent_mm_protocal_c_bdu, false, false, rmVar.fUY);
                return;
            }
            d.aJW().a(context, str, file.getAbsolutePath(), absolutePath, 1, rmVar.duration, rmVar.fUY);
            return;
        }
        String str2 = rmVar.txp;
        if (!bg.mA(str2)) {
            IMediaObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = str2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            String ap = bg.ap(rmVar.title, context.getResources().getString(R.l.ejL));
            wXMediaMessage.mediaObject = wXVideoObject;
            wXMediaMessage.title = ap;
            wXMediaMessage.description = rmVar.desc;
            wXMediaMessage.thumbData = bg.readFromFile(x.h(rmVar));
            if (wXMediaMessage.thumbData == null) {
                wXMediaMessage.thumbData = bg.readFromFile(x.aty() + g.n(bg.ap(rmVar.fFs, "").getBytes()));
            }
            com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
            aVar.hht = 3;
            rp rpVar2 = rmVar.tyi;
            if (rpVar2 != null) {
                aVar.hjI = rpVar2.hjI;
                aVar.hjF = rpVar2.hjF;
                aVar.hjE = rpVar2.tyZ;
                aVar.hjD = rpVar2.hjD;
                aVar.hjG = rpVar2.hjG;
                aVar.hjJ = rpVar2.hjJ;
                aVar.hjK = rpVar2.hjK;
            }
            l.a(aVar, wXMediaMessage, str);
        }
    }

    public static void a(String str, j jVar, rm rmVar) {
        String g = x.g(rmVar);
        IMediaObject wXFileObject = new WXFileObject();
        wXFileObject.setFilePath(g);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.title = rmVar.title;
        if (bg.mA(wXMediaMessage.title)) {
            wXMediaMessage.title = jVar.field_favProto.title;
        }
        wXMediaMessage.description = rmVar.desc;
        wXMediaMessage.thumbData = bg.readFromFile(x.h(rmVar));
        l.a(wXMediaMessage, "", "", str, 3, null);
    }
}
