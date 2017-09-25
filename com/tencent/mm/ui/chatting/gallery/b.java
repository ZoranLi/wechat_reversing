package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.chatting.gallery.j.AnonymousClass5;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b extends t {
    public static long kbc = -1;
    public static boolean sMK = false;
    public ImageGalleryUI vPV;
    protected a vPW;
    private String vPX;
    boolean vPY = true;
    public boolean vPZ = false;
    public d vQa;
    public i vQb;
    public h vQc;
    public c vQd;
    boolean vQe;
    protected boolean vQf = true;
    private ArrayList<au> vQg = new ArrayList();

    public static class a {
        private String fJL;
        public int hOI;
        public ae handler = new ae();
        private int rOT;
        private List<au> vQl;
        public int vQm;
        protected boolean vQn = false;
        protected int vQo;
        protected int vQp;
        protected int vQq;
        protected long vQr;
        private b vQs;
        public HashMap<Long, d> vQt = new HashMap();
        public HashMap<Long, d> vQu = new HashMap();

        public a(long j, String str, final b bVar, Boolean bool) {
            this.fJL = str;
            this.vQl = new LinkedList();
            this.vQs = bVar;
            ap.yY();
            ce cA = com.tencent.mm.u.c.wT().cA(j);
            if (cA.field_msgId == 0) {
                Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + j + ", stack = " + bg.bJZ(), false);
                return;
            }
            this.vQl.add(cA);
            final long j2 = j;
            final Boolean bool2 = bool;
            final b bVar2 = bVar;
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a vQy;

                public final void run() {
                    this.vQy.eQ(j2);
                    if (bool2.booleanValue()) {
                        this.vQy.handler.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 vQz;

                            {
                                this.vQz = r1;
                            }

                            public final void run() {
                                this.vQz.vQy.bWN();
                                if (bVar2.vQd != null) {
                                    bVar2.vQd.Uc();
                                }
                            }
                        }, 0);
                    }
                }
            });
            bVar.vPV.vSl = new com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.a(this) {
                final /* synthetic */ a vQy;

                public final void i(Boolean bool) {
                    w.i("MicroMsg.AutoList", "isPlaying : " + bool);
                    if (!bool.booleanValue()) {
                        this.vQy.bWN();
                        if (bVar.vQd != null) {
                            bVar.vQd.Uc();
                        }
                    }
                }
            };
        }

        public final void eQ(long j) {
            long currentTimeMillis = System.currentTimeMillis();
            w.i("MicroMsg.AutoList", "isBizChat = " + b.sMK);
            if (b.sMK) {
                ap.yY();
                this.vQo = com.tencent.mm.u.c.wU().ai(this.fJL, b.kbc);
            } else {
                ap.yY();
                this.vQo = com.tencent.mm.u.c.wT().AA(this.fJL);
            }
            w.i("MicroMsg.AutoList", "<init>, totalCount = " + this.vQo);
            w.i("MicroMsg.AutoList", "totalCount spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            if (b.sMK) {
                ap.yY();
                this.vQp = com.tencent.mm.u.c.wU().m(this.fJL, b.kbc, j);
            } else {
                ap.yY();
                this.vQp = com.tencent.mm.u.c.wT().G(this.fJL, j);
            }
            w.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            if (System.currentTimeMillis() - currentTimeMillis2 > 1000) {
                ap.yY();
                String H = com.tencent.mm.u.c.wT().H(this.fJL, j);
                w.w("MicroMsg.AutoList", "explain : %s", H);
            }
            this.vQq = this.vQp;
            this.vQr = j;
        }

        public final void bWN() {
            this.vQn = true;
            this.hOI = this.vQo;
            this.rOT = this.vQp;
            this.vQm = this.vQq;
            w.i("MicroMsg.AutoList", "totalCount %s min %s start %s", Integer.valueOf(this.hOI), Integer.valueOf(this.rOT), Integer.valueOf(this.vQm));
            long currentTimeMillis = System.currentTimeMillis();
            w.i("MicroMsg.AutoList", "min spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            o(this.vQr, true);
            w.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            o(this.vQr, false);
            w.i("MicroMsg.AutoList", "loadMsgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            this.vQs.notifyDataSetChanged();
            if (!this.vQs.vPV.isFinishing()) {
                this.vQs.c(99999, (View) this.vQs.vnM.get(99999));
            }
        }

        private void cC(List<au> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (b.aR((au) list.get(i))) {
                    arrayList.add(Long.valueOf(((au) list.get(i)).field_msgSvrId));
                    if (((au) list.get(i)).field_isSend == 1) {
                        arrayList2.add(Long.valueOf(((au) list.get(i)).field_msgId));
                    }
                }
            }
            this.vQt.putAll(n.GS().a((Long[]) arrayList.toArray(new Long[0])));
            this.vQu.putAll(n.GS().b((Long[]) arrayList2.toArray(new Long[0])));
        }

        public final int Bw(int i) {
            return (i - 100000) + this.vQm;
        }

        public final au Bx(int i) {
            int Bw = Bw(i);
            int size = (this.rOT + this.vQl.size()) - 1;
            if (Bw < this.rOT || Bw > size) {
                w.e("MicroMsg.AutoList", "get, invalid pos " + Bw + ", min = " + this.rOT + ", max = " + size);
                return null;
            }
            w.d("MicroMsg.AutoList", "get, pos = " + Bw);
            au auVar;
            if (Bw == this.rOT) {
                auVar = (au) this.vQl.get(0);
                if (!this.vQn) {
                    return auVar;
                }
                o(auVar.field_msgId, false);
                return auVar;
            } else if (Bw != size || size >= this.hOI - 1) {
                return (au) this.vQl.get(Bw - this.rOT);
            } else {
                auVar = (au) this.vQl.get(this.vQl.size() - 1);
                if (!this.vQn) {
                    return auVar;
                }
                o(auVar.field_msgId, true);
                return auVar;
            }
        }

        public final void lr(boolean z) {
            this.vQn = false;
        }

        private void o(long j, boolean z) {
            List b;
            w.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + j + ", forward = " + z);
            if (b.sMK) {
                ap.yY();
                b = com.tencent.mm.u.c.wU().b(this.fJL, b.kbc, j, z);
            } else {
                ap.yY();
                b = com.tencent.mm.u.c.wT().c(this.fJL, j, z);
            }
            if (b == null || b.size() == 0) {
                w.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = " + z);
                return;
            }
            w.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + b.size() + ", forward = " + z);
            long currentTimeMillis = System.currentTimeMillis();
            cC(b);
            w.i("MicroMsg.AutoList", "loadImgInfo spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (z) {
                this.vQl.addAll(b);
                return;
            }
            this.vQl.addAll(0, b);
            this.rOT -= b.size();
            if (this.rOT < 0) {
                w.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.rOT);
                return;
            }
            w.i("MicroMsg.AutoList", "min from " + (b.size() + this.rOT) + " to " + this.rOT);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AutoList, Size = " + this.vQl.size());
            stringBuilder.append("; Content = {");
            for (au auVar : this.vQl) {
                stringBuilder.append(auVar.field_msgId);
                stringBuilder.append(",");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public enum b {
        unkown,
        vQB,
        vQC,
        sight,
        appimage
    }

    public interface c {
        void Uc();
    }

    public final /* synthetic */ Object d(int i, View view) {
        return c(i, view);
    }

    public b(ImageGalleryUI imageGalleryUI, long j, String str, boolean z, long j2, boolean z2, String str2, Boolean bool) {
        String str3 = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + imageGalleryUI + ", currentMsgId = " + j + ", talker = " + str + ", stack = " + bg.bJZ();
        boolean z3 = imageGalleryUI != null && j > 0 && str != null && str.length() > 0;
        Assert.assertTrue(str3, z3);
        this.vPV = imageGalleryUI;
        sMK = z;
        kbc = j2;
        this.vPW = new a(j, str, this, bool);
        this.vPZ = z2;
        this.vPX = str2;
        this.vQa = new d(this);
        this.vQb = new i(this);
        this.vQc = new h(this);
    }

    public final void V(int i) {
        if (this.vQa != null && aR(Bm(i))) {
            this.vQa.vRo.V(i);
        }
    }

    public final int getCount() {
        a aVar = this.vPW;
        return ((aVar.hOI - aVar.vQm) + 100000) + 1;
    }

    public final int ano() {
        return this.vPW.hOI;
    }

    public final au Bm(int i) {
        return this.vPW.Bx(i);
    }

    public final void bWI() {
        this.vPW.lr(false);
    }

    public final d e(au auVar, boolean z) {
        return this.vQa.e(auVar, z);
    }

    public static boolean aR(au auVar) {
        if (auVar == null) {
            return false;
        }
        if (auVar.field_type == 3 || auVar.field_type == 39 || auVar.field_type == 13) {
            return true;
        }
        return false;
    }

    public static boolean aS(au auVar) {
        if (auVar == null || aY(auVar)) {
            return false;
        }
        if (auVar.field_type == 43 || auVar.field_type == 44 || auVar.field_type == 62) {
            return true;
        }
        return false;
    }

    public static boolean aT(au auVar) {
        if (auVar != null && auVar.field_type == 62) {
            return true;
        }
        return false;
    }

    public static boolean aU(au auVar) {
        if (auVar != null && auVar.field_type == 49) {
            return true;
        }
        return false;
    }

    public static boolean aV(au auVar) {
        if (auVar != null && auVar.field_type == 268435505) {
            return true;
        }
        return false;
    }

    public final boolean aW(au auVar) {
        if (auVar == null) {
            return false;
        }
        d e = e(auVar, false);
        if (e == null) {
            r bl = i.bl(auVar);
            if (bl == null || bl == null) {
                return false;
            }
            int i = bl.status;
            boolean z = (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122) && com.tencent.mm.modelvideo.t.f(bl) < 100;
            w.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(r2));
            return z;
        } else if (auVar == null || e == null) {
            return false;
        } else {
            if (n.GT().a(e.hEY, auVar.field_msgId, 0) || a(auVar, e)) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(au auVar, d dVar) {
        if (auVar == null || dVar == null) {
            return false;
        }
        return n.GT().a(dVar.hEY, auVar.field_msgId, 1);
    }

    public final void Bn(int i) {
        ce Bm = Bm(i);
        switch (aX(Bm)) {
            case vQC:
            case sight:
                aZ(Bm);
                return;
            case appimage:
                String bb = bb(Bm);
                Intent intent = new Intent(this.vPV, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", bb);
                intent.putExtra("Retr_Msg_Id", Bm.field_msgId);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_content", Bm.field_content);
                intent.putExtra("Retr_Compress_Type", 0);
                this.vPV.startActivity(intent);
                return;
            default:
                ba(Bm);
                return;
        }
    }

    public final void Bo(int i) {
        ce Bm = Bm(i);
        switch (aX(Bm)) {
            case vQC:
            case sight:
            case vQB:
                Intent intent = new Intent(this.vPV, ChattingSendDataToDeviceUI.class);
                intent.putExtra("Retr_Msg_Id", Bm.field_msgId);
                this.vPV.startActivity(intent);
                return;
            default:
                return;
        }
    }

    public static b aX(au auVar) {
        b bVar = b.unkown;
        if (auVar == null) {
            bVar = b.unkown;
        }
        if (aV(auVar)) {
            return b.appimage;
        }
        if (aR(auVar)) {
            return b.vQB;
        }
        if (aY(auVar)) {
            return b.sight;
        }
        if (aS(auVar)) {
            return b.vQC;
        }
        if (aT(auVar)) {
            return b.vQC;
        }
        return b.unkown;
    }

    private static boolean aY(au auVar) {
        if (auVar != null) {
            r lH = com.tencent.mm.modelvideo.t.lH(auVar.field_imgPath);
            if (!(lH == null || lH.iay == null || (bg.mA(lH.iay.hjD) && lH.iay.tyZ <= 0 && bg.mA(lH.iay.hjG) && bg.mA(lH.iay.hjH) && bg.mA(lH.iay.hjF) && bg.mA(lH.iay.hjI) && bg.mA(lH.iay.hjJ) && bg.mA(lH.iay.hjK)))) {
                return true;
            }
        }
        return false;
    }

    public final void aZ(au auVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            r lH = com.tencent.mm.modelvideo.t.lH(auVar.field_imgPath);
            if (lH == null) {
                w.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
                return;
            }
            Intent intent = new Intent(this.vPV, MsgRetransmitUI.class);
            intent.putExtra("Retr_length", lH.iap);
            intent.putExtra("Retr_File_Name", auVar.field_imgPath);
            intent.putExtra("Retr_video_isexport", lH.iat);
            intent.putExtra("Retr_Msg_Type", aT(auVar) ? 11 : 1);
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_From", "gallery");
            this.vPV.startActivity(intent);
            return;
        }
        s.eP(this.vPV);
    }

    public final void ba(au auVar) {
        d bg = d.bg(auVar);
        if (auVar == null || auVar.field_msgId == 0 || bg == null || bg.hEY == 0) {
            Object obj;
            String str = "MicroMsg.ImageGalleryAdapter";
            StringBuilder stringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
            if (auVar == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(auVar.field_msgId);
            }
            stringBuilder = stringBuilder.append(obj).append(", imgLocalId = ");
            if (bg == null) {
                obj = "null";
            } else {
                obj = Long.valueOf(bg.hEY);
            }
            w.e(str, stringBuilder.append(obj).toString());
            return;
        }
        String a = d.a(auVar, bg, false);
        if (a == null || a.length() == 0) {
            w.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + auVar.field_msgId + ", imgLocalId = " + bg.hEY);
        } else if (bg.mA(this.vPX)) {
            w.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
            Intent intent = new Intent(this.vPV, MsgRetransmitUI.class);
            intent.putExtra("Retr_File_Name", a);
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_Compress_Type", b(auVar, bg));
            this.vPV.startActivity(intent);
        } else {
            int i;
            w.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", this.vPX);
            if (auVar.field_isSend == 1) {
                if (bg.GB()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (bg.GB()) {
                if (e.aO(n.GS().m(com.tencent.mm.ah.e.a(bg).hEZ, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            String xL = m.xL();
            String m = n.GS().m(com.tencent.mm.ah.e.c(bg), "", "");
            if (!bg.mA(m)) {
                w.i("MicroMsg.ImageGalleryAdapter", "connector click[img]: to[%s] fileName[%s]", bg, m);
                ap.vd().a(new k(xL, this.vPX, m, i), 0);
                bm.zN().c(bm.hnW, null);
            }
            if (this.vPY) {
                Intent intent2 = new Intent(this.vPV, En_5b8fbb1e.class);
                intent2.addFlags(67108864);
                intent2.putExtra("Chat_User", this.vPX);
                this.vPV.startActivity(intent2);
            } else {
                g.bl(this.vPV, this.vPV.getString(R.l.dIy));
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(10424, Integer.valueOf(3), Integer.valueOf(4), this.vPX);
        }
    }

    public static boolean c(Context context, List<au> list) {
        if (context == null || list == null || list.size() <= 0) {
            return false;
        }
        boolean z = list.size() <= 1;
        boolean z2 = false;
        for (au auVar : list) {
            boolean a;
            if (aS(auVar)) {
                a = a(context, auVar, z);
            } else {
                a = b(context, auVar, z);
            }
            if (z2 || !r0) {
                a = z2;
            } else {
                a = true;
            }
            z2 = a;
        }
        if (!z2 && !z) {
            Toast.makeText(context, context.getString(R.l.eOj), 1).show();
            return true;
        } else if (!z2 || z) {
            return true;
        } else {
            Toast.makeText(context, context.getString(R.l.egO, new Object[]{com.tencent.mm.compatible.util.e.gSz}), 1).show();
            return true;
        }
    }

    public static boolean a(Context context, au auVar, boolean z) {
        if (auVar == null) {
            return false;
        }
        boolean z2;
        r ls = o.KV().ls(auVar.field_imgPath);
        if (ls != null) {
            int eC;
            if (com.tencent.mm.u.o.dH(ls.Le())) {
                eC = j.eC(ls.Le());
            } else {
                eC = 0;
            }
            boolean Lk = ls.Lk();
            com.tencent.mm.plugin.report.service.g.oUh.a(106, 216, 1, false);
            com.tencent.mm.plugin.report.service.g.oUh.i(12084, Integer.valueOf(ls.hrs), Integer.valueOf(ls.iap * 1000), Integer.valueOf(0), Integer.valueOf(2), ls.Le(), Integer.valueOf(eC), r.lr(ls.Lh()), Long.valueOf(ls.iam));
            z2 = Lk;
        } else {
            z2 = false;
        }
        if (z2) {
            o.KV();
            String lI = com.tencent.mm.modelvideo.t.lI(com.tencent.mm.modelvideo.s.lv(auVar.field_imgPath));
            if (!bg.mA(lI)) {
                if (z) {
                    Toast.makeText(context, context.getString(R.l.fam, new Object[]{lI}), 1).show();
                }
                com.tencent.mm.pluginsdk.ui.tools.k.b(lI, context);
                return true;
            } else if (!z) {
                return false;
            } else {
                Toast.makeText(context, context.getString(R.l.fal), 1).show();
                return false;
            }
        }
        w.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
        if (!z) {
            return false;
        }
        Toast.makeText(context, context.getString(R.l.fal), 1).show();
        return false;
    }

    public static boolean b(Context context, au auVar, boolean z) {
        String bb;
        if (aV(auVar)) {
            bb = bb(auVar);
        } else if (auVar == null || auVar.field_msgId == 0) {
            w.e("MicroMsg.ImageGalleryAdapter", "msg is null");
            if (z) {
                Toast.makeText(context, context.getString(R.l.eOi), 1).show();
            }
            return false;
        } else {
            d bg = d.bg(auVar);
            if (bg == null || bg.hEY == 0) {
                w.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, msgLocalId = " + (auVar == null ? "null" : Long.valueOf(auVar.field_msgId)) + ", imgLocalId = " + (bg == null ? "null" : Long.valueOf(bg.hEY)));
                if (z) {
                    Toast.makeText(context, context.getString(R.l.eOi), 1).show();
                }
                return false;
            }
            bb = d.a(auVar, bg, false);
        }
        if (bb == null || bb.length() == 0) {
            w.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + auVar.field_msgId);
            if (z) {
                Toast.makeText(context, context.getString(R.l.eOi), 1).show();
            }
            return false;
        } else if (com.tencent.mm.platformtools.d.a(bb, context, z, R.l.eaX)) {
            return true;
        } else {
            if (z) {
                Toast.makeText(context, context.getString(R.l.eOi), 1).show();
            }
            return false;
        }
    }

    public final void Bp(int i) {
        au Bm = Bm(i);
        cb cbVar = new cb();
        com.tencent.mm.pluginsdk.model.e.a(cbVar, Bm);
        cbVar.fFA.activity = this.vPV;
        cbVar.fFA.fFH = 44;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        if (cbVar.fFB.ret == 0) {
            if (Bm.bMm()) {
                com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Full, Bm, 0);
            }
            com.tencent.mm.modelstat.b.hUp.t(Bm);
        }
    }

    public final View c(int i, View view) {
        j jVar;
        final au Bm = Bm(i);
        if (view == null) {
            view = View.inflate(this.vPV, R.i.dfH, null);
            jVar = new j(this, view);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        b aX = aX(Bm);
        jVar.kC = i;
        jVar.vTa = aX;
        j.M(jVar.mil, 0);
        switch (AnonymousClass5.vQk[aX.ordinal()]) {
            case 1:
                j.M(jVar.vTi, 8);
                j.M(jVar.vTc, 8);
                break;
            case 2:
                jVar.bXx();
                j.M(jVar.vTi, 0);
                j.M(jVar.vTc, 8);
                if (jVar.vTc != null) {
                    j.M(jVar.vTe, 8);
                    break;
                }
                break;
            case 3:
                jVar.bXw();
                j.M(jVar.vTi, 8);
                j.M(jVar.vTc, 0);
                break;
            case 4:
                j.M(jVar.mil, 8);
                j.M(jVar.vTi, 8);
                j.M(jVar.vTc, 8);
                break;
        }
        j.M(jVar.vTx, 8);
        j.M(jVar.vTo, 8);
        j.M(jVar.vTu, 8);
        j.M(jVar.vTt, 8);
        w.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", Integer.valueOf(i), aX);
        switch (aX) {
            case vQC:
                this.vQb.a(jVar, Bm, i);
                break;
            case sight:
                this.vQc.a(jVar, Bm, i);
                break;
            case appimage:
                Bitmap mu;
                j.M(jVar.vTx, 0);
                j.M(jVar.vTo, 8);
                j.M(jVar.vTt, 8);
                j.M(jVar.vTu, 8);
                j.M(jVar.vTm, 8);
                final String bb = bb(Bm);
                try {
                    mu = com.tencent.mm.platformtools.j.mu(bb);
                } catch (OutOfMemoryError e) {
                    w.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", bb);
                    Runtime.getRuntime().gc();
                    Runtime.getRuntime().runFinalization();
                    mu = com.tencent.mm.platformtools.j.mt(bb);
                }
                if (mu == null) {
                    mu = com.tencent.mm.platformtools.j.mt(n.GS().v(Bm.field_imgPath, true));
                    j.M(jVar.vTt, 0);
                    new ae().post(new Runnable(this) {
                        final /* synthetic */ b vQi;

                        public final void run() {
                            l.a(Bm, new com.tencent.mm.pluginsdk.model.app.l.a(this) {
                                final /* synthetic */ AnonymousClass1 vQj;

                                {
                                    this.vQj = r1;
                                }

                                public final void dD(int i, int i2) {
                                    if (i == i2) {
                                        Bitmap mu;
                                        w.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", Long.valueOf(Bm.field_msgId));
                                        j.M(jVar.vTt, 8);
                                        try {
                                            mu = com.tencent.mm.platformtools.j.mu(bb);
                                        } catch (OutOfMemoryError e) {
                                            w.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", bb);
                                            Runtime.getRuntime().gc();
                                            Runtime.getRuntime().runFinalization();
                                            mu = com.tencent.mm.platformtools.j.mt(bb);
                                        }
                                        if (mu != null) {
                                            jVar.vTx.qBZ = false;
                                            com.tencent.mm.sdk.platformtools.k.i(jVar.vTx, mu.getWidth(), mu.getHeight());
                                            jVar.vTx.dZ(mu.getWidth(), mu.getHeight());
                                            jVar.vTx.setImageBitmap(mu);
                                            jVar.vTx.invalidate();
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
                if (mu != null) {
                    jVar.vTx.qBZ = false;
                    com.tencent.mm.sdk.platformtools.k.i(jVar.vTx, mu.getWidth(), mu.getHeight());
                    jVar.vTx.dZ(mu.getWidth(), mu.getHeight());
                    jVar.vTx.setImageBitmap(mu);
                    jVar.vTx.invalidate();
                    break;
                }
                w.w("MicroMsg.ImageGalleryAdapter", "get image fail");
                jVar.vTx.setVisibility(8);
                jVar.bXv().vTu.setVisibility(0);
                jVar.bXv().vTw.setImageResource(R.k.dxt);
                jVar.bXv().vTv.setText(this.vPV.getString(R.l.esv));
                break;
            case vQB:
                this.vQa.a(jVar, Bm, i);
                break;
        }
        this.vQf = false;
        return view;
    }

    public static String bb(au auVar) {
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
        if (ek == null || ek.fCW == null || ek.fCW.length() <= 0) {
            return null;
        }
        com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
        if (LW != null) {
            return LW.field_fileFullPath;
        }
        return null;
    }

    public final void detach() {
        this.vQa.detach();
        this.vQb.detach();
        this.vQc.detach();
        super.detach();
    }

    public static int b(au auVar, d dVar) {
        d a;
        if (auVar.field_isSend == 1) {
            if (dVar.GB()) {
                a = com.tencent.mm.ah.e.a(dVar);
                if (a != null && a.hEY > 0 && a.GA() && e.aO(n.GS().m(a.hEZ, "", ""))) {
                    return 1;
                }
            }
            return 0;
        } else if (!dVar.GA()) {
            return 0;
        } else {
            if (dVar.GB()) {
                a = com.tencent.mm.ah.e.a(dVar);
                if (a != null && a.hEY > 0 && a.GA() && e.aO(n.GS().m(a.hEZ, "", ""))) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public final boolean bWJ() {
        return this.vPW.vQn;
    }

    public final int bSD() {
        return 100000 - this.vPW.vQm;
    }

    public final int bSE() {
        return ((100000 - this.vPW.vQm) + this.vPW.hOI) - 1;
    }

    public final void al(int i, boolean z) {
        this.vQa.al(i, z);
    }

    public final MultiTouchImageView nk(int i) {
        View Al = super.Al(i);
        if (Al == null) {
            w.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", Integer.valueOf(i));
            return null;
        }
        Al = Al.findViewById(R.h.Kd);
        if (Al == null || Al.getVisibility() == 8) {
            return null;
        }
        return (MultiTouchImageView) Al;
    }

    public final View Bq(int i) {
        View Al = super.Al(i);
        if (Al == null) {
            w.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", Integer.valueOf(i));
            return null;
        }
        View findViewById = Al.findViewById(R.h.cLH);
        if (findViewById == null) {
            findViewById = Al.findViewById(R.h.cLG);
        }
        if (findViewById == null || findViewById.getVisibility() == 8) {
            return null;
        }
        return findViewById;
    }

    public final void Br(int i) {
        this.vQb.i(Bm(i), i);
    }

    public final void Bs(int i) {
        this.vQb.j(Bm(i), i);
    }

    public final au bWK() {
        return Bm(this.vPV.bXf());
    }

    public final j bWL() {
        j Bk = this.vQa.Bk(this.vPV.bXf());
        if (Bk == null) {
            Bk = this.vQb.Bk(this.vPV.bXf());
        }
        if (Bk == null) {
            return this.vQc.Bk(this.vPV.bXf());
        }
        return Bk;
    }

    public final void Bt(int i) {
        this.vQb.Bl(i);
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void bWM() {
        this.vQb.onResume();
    }

    public final void Bu(int i) {
        ce Bm = Bm(i);
        if (Bm != null && aR(Bm)) {
            com.tencent.mm.ah.c.a aVar = this.vQa;
            d bg = d.bg(Bm);
            if (bg != null && Bm != null) {
                if (k.bXy().eU(Bm.field_msgId)) {
                    aVar = k.bXy();
                    aVar.vTF.remove(Long.valueOf(Bm.field_msgId));
                    n.GT().a(bg.hEY, Bm.field_msgId, aVar);
                    n.GT().e(bg.hEY, Bm.field_msgId);
                    return;
                }
                n.GT().a(bg.hEY, Bm.field_msgId, aVar);
                n.GT().e(bg.hEY, Bm.field_msgId);
            }
        }
    }

    public final void Bv(int i) {
        this.vQc.BB(i);
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        super.a(viewGroup, i, obj);
    }
}
