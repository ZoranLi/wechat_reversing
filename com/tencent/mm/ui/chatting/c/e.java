package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.a.a.c;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.dz;
import com.tencent.mm.ui.chatting.gallery.d;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.gallery.i;
import com.tencent.mm.ui.chatting.z;
import com.tencent.mm.y.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class e implements a, s.a, com.tencent.mm.ui.chatting.b.a.a, b {
    static int count = 0;
    public ArrayList<c> jnH = null;
    public int kUZ = 0;
    public String kwJ;
    public Context mContext;
    public ae mHandler = new ae(Looper.getMainLooper());
    private com.tencent.mm.sdk.b.c vJU = new com.tencent.mm.sdk.b.c<gg>(this) {
        final /* synthetic */ e vUx;

        {
            this.vUx = r2;
            this.usg = gg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gg ggVar = (gg) bVar;
            long j = ggVar.fLx.fGM;
            e eVar = this.vUx;
            int i = -1;
            for (c cVar : eVar.vUs.jkZ) {
                i++;
                if (cVar.fTk != null && cVar.fTk.field_msgId == j) {
                    break;
                }
            }
            i = -1;
            GridLayoutManager gridLayoutManager = (GridLayoutManager) eVar.eW(eVar.mContext);
            int fa = gridLayoutManager.fa();
            w.i("MicroMsg.MediaHistoryGalleryPresenter", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(fa), Integer.valueOf(gridLayoutManager.fb()));
            if (i >= fa && i <= r0) {
                View childAt = eVar.vUr.getChildAt(i - fa);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    ggVar.fLy.fEb = iArr[0];
                    ggVar.fLy.fEc = iArr[1];
                    ggVar.fLy.fEd = childAt.getWidth();
                    ggVar.fLy.fEe = childAt.getHeight();
                }
            }
            return false;
        }
    };
    public long vPu;
    public int vUn = 0;
    public com.tencent.mm.ui.chatting.b.a.b vUr;
    com.tencent.mm.ui.chatting.a.a vUs;
    private GridLayoutManager vUt;
    boolean vUu = false;
    public int vUv = 0;
    public boolean vUw = false;

    class AnonymousClass3 implements l.a {
        final /* synthetic */ au hUu;
        final /* synthetic */ e vUx;

        AnonymousClass3(e eVar, au auVar) {
            this.vUx = eVar;
            this.hUu = auVar;
        }

        public final void dD(int i, int i2) {
            if (i == i2) {
                w.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", Long.valueOf(this.hUu.field_msgId));
                e eVar = this.vUx;
                eVar.vUv--;
                if (!com.tencent.mm.ui.chatting.gallery.b.b(this.vUx.mContext, this.hUu, false)) {
                    this.vUx.vUw = true;
                }
                if (!this.vUx.bXD()) {
                    return;
                }
                if (this.vUx.vUw) {
                    this.vUx.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 vUz;

                        {
                            this.vUz = r1;
                        }

                        public final void run() {
                            if (this.vUz.vUx.vUr != null) {
                                this.vUz.vUx.vUr.Bj(R.l.eob);
                            }
                        }
                    });
                } else {
                    this.vUx.mHandler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 vUz;

                        {
                            this.vUz = r1;
                        }

                        public final void run() {
                            if (this.vUz.vUx.vUr != null) {
                                this.vUz.vUx.vUr.bWz();
                            }
                        }
                    });
                }
            }
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.ui.chatting.e.a aVar) {
        this.vUr = (com.tencent.mm.ui.chatting.b.a.b) aVar;
        this.vUr.a(this);
        this.vJU.bIy();
        a.vRJ.a(this);
    }

    public final /* bridge */ /* synthetic */ RecyclerView.a bWs() {
        return this.vUs;
    }

    public e(Context context) {
        this.mContext = context;
        this.jnH = new ArrayList();
    }

    public final void onDetach() {
        this.vJU.dead();
        this.vUr.a(null);
        this.vUr = null;
        n.GT().a((a) this);
        o.KV().a((s.a) this);
        a.vRJ.detach();
    }

    public final <T extends h> T eW(Context context) {
        if (this.vUt == null) {
            this.vUt = new GridLayoutManager(context, 4);
            this.vUt.WL = new GridLayoutManager.b(this) {
                final /* synthetic */ e vUx;

                {
                    this.vUx = r1;
                }

                public final int aT(int i) {
                    if (((c) this.vUx.jnH.get(i)).type == Integer.MAX_VALUE) {
                        return 4;
                    }
                    return 1;
                }
            };
        }
        return this.vUt;
    }

    public final g eX(final Context context) {
        return new g(this) {
            final /* synthetic */ e vUx;

            public final void a(Rect rect, View view, RecyclerView recyclerView) {
                int dimension = (int) context.getResources().getDimension(R.f.aXJ);
                rect.bottom = dimension;
                rect.top = dimension;
                rect.left = dimension;
                rect.right = dimension;
            }
        };
    }

    public final RecyclerView.a ak(String str, long j) {
        this.kwJ = str;
        this.vPu = j;
        if (j == -1) {
            this.vUs = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jnH, str);
        } else {
            this.vUs = new com.tencent.mm.ui.chatting.a.a(this.mContext, this.jnH, str, j);
        }
        this.vUs.vPw = new com.tencent.mm.ui.chatting.a.a.b(this) {
            final /* synthetic */ e vUx;

            {
                this.vUx = r1;
            }

            public final void a(boolean z, c cVar, int i) {
                w.i("MicroMsg.MediaHistoryGalleryPresenter", "[onCheck] isChecked :%s pos:%s", Boolean.valueOf(z), Integer.valueOf(i));
                if (!z || a.vRJ.vQg.size() < 9) {
                    if (z) {
                        a.vRJ.bh(cVar.fTk);
                    } else {
                        a.vRJ.bi(cVar.fTk);
                    }
                    this.vUx.vUr.Bi(a.vRJ.vQg.size());
                    return;
                }
                Toast.makeText(this.vUx.mContext, this.vUx.mContext.getResources().getString(R.l.enW, new Object[]{Integer.valueOf(9)}), 1).show();
                this.vUx.vUs.bc(i);
            }
        };
        return this.vUs;
    }

    public final String Oh() {
        return this.mContext.getString(R.l.dDb);
    }

    public final void Bh(int i) {
        w.i("MicroMsg.MediaHistoryGalleryPresenter", "[handleSelectedItem] type:%s", Integer.valueOf(i));
        final List<au> list = a.vRJ.vQg;
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.oUh.a(219, 19, 1, true);
                ab.a(this.mContext, list, this.kwJ.toLowerCase().endsWith("@chatroom"), this.kwJ, new dz(this) {
                    final /* synthetic */ e vUx;

                    {
                        this.vUx = r1;
                    }

                    public final void bUE() {
                    }

                    public final void a(dz.a aVar) {
                    }

                    public final void b(dz.a aVar) {
                    }

                    public final boolean bUF() {
                        return true;
                    }
                });
                this.vUr.bWv();
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.oUh.a(219, 18, 1, true);
                final cb cbVar = new cb();
                if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, cbVar, this.kwJ, list, false)) {
                    b(cbVar);
                    cJ(list);
                } else if (list.size() > 1) {
                    com.tencent.mm.ui.base.g.a(this.mContext, cbVar.fFA.fFG >= 0 ? this.mContext.getString(R.l.eio) : this.mContext.getString(R.l.ein), "", cbVar.fFA.fFG >= 0 ? this.mContext.getString(R.l.dXk) : this.mContext.getString(R.l.eGa), this.mContext.getString(R.l.dXi), new OnClickListener(this) {
                        final /* synthetic */ e vUx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (cbVar.fFA.type != 14 || cbVar.fFA.fFC.tzn.size() != 0) {
                                this.vUx.b(cbVar);
                                e.cJ(list);
                            }
                        }
                    }, null);
                } else {
                    com.tencent.mm.ui.base.g.h(this.mContext, cbVar.fFA.fFG, 0);
                }
                this.vUr.bWv();
                return;
            case 2:
                cI(list);
                return;
            case 3:
                this.vUr.bWy();
                final List arrayList = new ArrayList();
                for (au auVar : list) {
                    if (!(com.tencent.mm.ui.chatting.gallery.b.aT(auVar) || com.tencent.mm.ui.chatting.gallery.b.aU(auVar))) {
                        arrayList.add(auVar);
                    }
                }
                if (arrayList.size() != list.size()) {
                    com.tencent.mm.ui.base.g.a(this.mContext, R.l.enS, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ e vUx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vUx.cF(arrayList);
                        }
                    }, null);
                    return;
                } else {
                    cF(arrayList);
                    return;
                }
            default:
                return;
        }
    }

    public final int bWt() {
        return a.vRJ.vQg.size();
    }

    public final void bWu() {
        this.vUs.vPx = true;
        a.vRJ.vRH = true;
        GridLayoutManager gridLayoutManager = (GridLayoutManager) eW(this.mContext);
        int fa = gridLayoutManager.fa();
        this.vUs.b(fa, (gridLayoutManager.fb() - fa) + 1, Integer.valueOf(0));
    }

    public final void bWv() {
        this.vUs.vPx = false;
        a.vRJ.clear();
        a.vRJ.vRH = false;
        this.vUs.aab.notifyChanged();
    }

    public final boolean bWw() {
        return a.vRJ.vRH;
    }

    public final void onResume() {
        if (this.vUu && a.vRJ.vRH) {
            this.vUr.Bi(a.vRJ.vQg.size());
            this.vUs.aab.notifyChanged();
        }
    }

    public final void bWQ() {
        this.vUu = true;
    }

    public final void clear() {
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
        w.d("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskProgress] offset:%s totalLen:%s", Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        w.i("MicroMsg.MediaHistoryGalleryPresenter", "[onImgTaskEnd] mNeedDownloadCount:%s imgLocalId:%s msgLocalId:%s err[%s:%s:%s]", Integer.valueOf(this.vUv), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.vUr.bWA()) {
            this.vUv--;
            ap.yY();
            if (!com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, com.tencent.mm.u.c.wT().cA(j2), false)) {
                this.vUw = true;
            }
            if (!bXD()) {
                return;
            }
            if (this.vUw) {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e vUx;

                    {
                        this.vUx = r1;
                    }

                    public final void run() {
                        if (this.vUx.vUr != null) {
                            this.vUx.vUr.Bj(R.l.eob);
                        }
                    }
                });
            } else {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e vUx;

                    {
                        this.vUx = r1;
                    }

                    public final void run() {
                        if (this.vUx.vUr != null) {
                            this.vUx.vUr.bWz();
                        }
                    }
                });
            }
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
    }

    public final void bWx() {
        n.GT().a((a) this);
        o.KV().a((s.a) this);
        this.vUr.bWx();
    }

    public final void a(s.a.a aVar) {
        if (this.vUr.bWA()) {
            r lH = t.lH(aVar.fyF);
            w.d("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] mNeedDownloadCount:%s statusType:%s %s", Integer.valueOf(this.vUv), aVar.iaG, aVar.fyF);
            if (lH == null) {
                w.e("MicroMsg.MediaHistoryGalleryPresenter", "[notifyChanged] videoInfo is null!");
                bWx();
                this.vUr.Bj(0);
            } else if (lH.Lk()) {
                this.vUv--;
                ap.yY();
                com.tencent.mm.ui.chatting.gallery.b.a(this.mContext, com.tencent.mm.u.c.wT().cA((long) lH.iaq), false);
            }
            if (!bXD()) {
                return;
            }
            if (this.vUw) {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e vUx;

                    {
                        this.vUx = r1;
                    }

                    public final void run() {
                        if (this.vUx.vUr != null) {
                            this.vUx.vUr.Bj(R.l.eob);
                        }
                    }
                });
            } else {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e vUx;

                    {
                        this.vUx = r1;
                    }

                    public final void run() {
                        if (this.vUx.vUr != null) {
                            this.vUx.vUr.bWz();
                        }
                    }
                });
            }
        }
    }

    public final void cF(final List<au> list) {
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ e vUx;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r14 = this;
                r3 = r3;
                if (r3 != 0) goto L_0x001a;
            L_0x0004:
                r1 = 0;
            L_0x0005:
                r0 = r3;
                r0 = r0.size();
                if (r0 != r1) goto L_0x0130;
            L_0x000d:
                r0 = r14.vUx;
                r0 = r0.mHandler;
                r1 = new com.tencent.mm.ui.chatting.c.e$2$1;
                r1.<init>(r14);
                r0.post(r1);
            L_0x0019:
                return;
            L_0x001a:
                r0 = 0;
                r4 = r3.iterator();
                r1 = r0;
            L_0x0020:
                r0 = r4.hasNext();
                if (r0 == 0) goto L_0x0110;
            L_0x0026:
                r0 = r4.next();
                r0 = (com.tencent.mm.storage.au) r0;
                r2 = r0.bMt();
                if (r2 == 0) goto L_0x0036;
            L_0x0032:
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x0020;
            L_0x0036:
                r2 = com.tencent.mm.ui.chatting.gallery.b.aS(r0);
                if (r2 == 0) goto L_0x006e;
            L_0x003c:
                r5 = com.tencent.mm.ui.chatting.gallery.i.bl(r0);
                r2 = 0;
                if (r5 == 0) goto L_0x02ae;
            L_0x0043:
                r2 = "MicroMsg.MediaHistoryGalleryPresenter";
                r6 = "[checkLegal] getStatus:%s";
                r7 = 1;
                r7 = new java.lang.Object[r7];
                r8 = 0;
                r9 = r5.status;
                r9 = java.lang.Integer.valueOf(r9);
                r7[r8] = r9;
                com.tencent.mm.sdk.platformtools.w.i(r2, r6, r7);
                r0 = com.tencent.mm.ui.chatting.c.e.c(r0, r5);
            L_0x005c:
                if (r5 == 0) goto L_0x006a;
            L_0x005e:
                r2 = r5.status;
                r5 = 198; // 0xc6 float:2.77E-43 double:9.8E-322;
                if (r2 == r5) goto L_0x006a;
            L_0x0064:
                r0 = com.tencent.mm.modelsfs.FileOp.aO(r0);
                if (r0 != 0) goto L_0x02ab;
            L_0x006a:
                r0 = r1 + 1;
            L_0x006c:
                r1 = r0;
                goto L_0x0020;
            L_0x006e:
                r2 = com.tencent.mm.ui.chatting.gallery.d.bg(r0);
                if (r2 == 0) goto L_0x0089;
            L_0x0074:
                r5 = "MicroMsg.MediaHistoryGalleryPresenter";
                r6 = "[checkLegal] getStatus:%s";
                r7 = 1;
                r7 = new java.lang.Object[r7];
                r8 = 0;
                r9 = r2.status;
                r9 = java.lang.Integer.valueOf(r9);
                r7[r8] = r9;
                com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
            L_0x0089:
                r5 = r0.field_type;
                r6 = 268435505; // 0x10000031 float:2.5243696E-29 double:1.32624761E-315;
                if (r5 != r6) goto L_0x00ce;
            L_0x0090:
                r0 = com.tencent.mm.ui.chatting.gallery.b.bb(r0);
                r2 = "MicroMsg.MediaHistoryGalleryPresenter";
                r5 = "[checkLegal] is appmsg! null?%s,exists:%s";
                r6 = 2;
                r6 = new java.lang.Object[r6];
                r7 = 0;
                r8 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                r8 = java.lang.Boolean.valueOf(r8);
                r6[r7] = r8;
                r7 = 1;
                r8 = new java.io.File;
                r9 = "";
                r9 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r9);
                r8.<init>(r9);
                r8 = r8.exists();
                r8 = java.lang.Boolean.valueOf(r8);
                r6[r7] = r8;
                com.tencent.mm.sdk.platformtools.w.i(r2, r5, r6);
                r0 = com.tencent.mm.modelsfs.FileOp.aO(r0);
                if (r0 != 0) goto L_0x010e;
            L_0x00c8:
                r1 = r1 + 1;
                r0 = r1;
            L_0x00cb:
                r1 = r0;
                goto L_0x0020;
            L_0x00ce:
                r5 = 0;
                r0 = com.tencent.mm.ui.chatting.gallery.d.a(r0, r2, r5);
                r5 = "MicroMsg.MediaHistoryGalleryPresenter";
                r6 = "[checkLegal] null?%s,exists:%s";
                r7 = 2;
                r7 = new java.lang.Object[r7];
                r8 = 0;
                r9 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                r9 = java.lang.Boolean.valueOf(r9);
                r7[r8] = r9;
                r8 = 1;
                r9 = new java.io.File;
                r10 = "";
                r10 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r10);
                r9.<init>(r10);
                r9 = r9.exists();
                r9 = java.lang.Boolean.valueOf(r9);
                r7[r8] = r9;
                com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
                if (r2 == 0) goto L_0x00c8;
            L_0x0103:
                r2 = r2.status;
                r5 = -1;
                if (r2 == r5) goto L_0x00c8;
            L_0x0108:
                r0 = com.tencent.mm.modelsfs.FileOp.aO(r0);
                if (r0 == 0) goto L_0x00c8;
            L_0x010e:
                r0 = r1;
                goto L_0x00cb;
            L_0x0110:
                r0 = "MicroMsg.MediaHistoryGalleryPresenter";
                r2 = "[checkLegal] count:%s size:%s";
                r4 = 2;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = java.lang.Integer.valueOf(r1);
                r4[r5] = r6;
                r5 = 1;
                r3 = r3.size();
                r3 = java.lang.Integer.valueOf(r3);
                r4[r5] = r3;
                com.tencent.mm.sdk.platformtools.w.i(r0, r2, r4);
                goto L_0x0005;
            L_0x0130:
                r2 = r14.vUx;
                if (r1 <= 0) goto L_0x019a;
            L_0x0134:
                r0 = 1;
            L_0x0135:
                r2.vUw = r0;
                r0 = r14.vUx;
                r1 = r3;
                r0 = r0.cG(r1);
                r1 = r14.vUx;
                r2 = r3;
                r11 = r1.cH(r2);
                r1 = "MicroMsg.MediaHistoryGalleryPresenter";
                r2 = "[innerHandleSave] needDownloadImageList size:%s needDownloadVideoList:%s";
                r3 = 2;
                r3 = new java.lang.Object[r3];
                r4 = 0;
                r5 = r0.size();
                r5 = java.lang.Integer.valueOf(r5);
                r3[r4] = r5;
                r4 = 1;
                r5 = r11.size();
                r5 = java.lang.Integer.valueOf(r5);
                r3[r4] = r5;
                com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
                r1 = r14.vUx;
                r2 = r0.size();
                r3 = r11.size();
                r2 = r2 + r3;
                r1.vUv = r2;
                r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
                r1 = com.tencent.mm.sdk.platformtools.am.isWifi(r1);
                if (r1 != 0) goto L_0x019c;
            L_0x0180:
                r1 = r14.vUx;
                r1 = r1.vUv;
                r2 = r3;
                r2 = r2.size();
                if (r1 != r2) goto L_0x019c;
            L_0x018c:
                r0 = r14.vUx;
                r0 = r0.mHandler;
                r1 = new com.tencent.mm.ui.chatting.c.e$2$2;
                r1.<init>(r14);
                r0.post(r1);
                goto L_0x0019;
            L_0x019a:
                r0 = 0;
                goto L_0x0135;
            L_0x019c:
                r12 = r0.iterator();
            L_0x01a0:
                r0 = r12.hasNext();
                if (r0 == 0) goto L_0x021f;
            L_0x01a6:
                r0 = r12.next();
                r0 = (com.tencent.mm.storage.au) r0;
                r9 = r14.vUx;
                r13 = com.tencent.mm.ui.chatting.gallery.d.bg(r0);
                r2 = "MicroMsg.MediaHistoryGalleryPresenter";
                r3 = "[downloadImg] %s %s ";
                r1 = 2;
                r4 = new java.lang.Object[r1];
                r5 = 0;
                if (r0 != 0) goto L_0x01e4;
            L_0x01be:
                r1 = 1;
            L_0x01bf:
                r1 = java.lang.Boolean.valueOf(r1);
                r4[r5] = r1;
                r5 = 1;
                if (r13 != 0) goto L_0x01e6;
            L_0x01c8:
                r1 = 1;
            L_0x01c9:
                r1 = java.lang.Boolean.valueOf(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                if (r0 == 0) goto L_0x01a0;
            L_0x01d4:
                r1 = r0.field_type;
                r2 = 268435505; // 0x10000031 float:2.5243696E-29 double:1.32624761E-315;
                if (r1 != r2) goto L_0x01e8;
            L_0x01db:
                r1 = new com.tencent.mm.ui.chatting.c.e$3;
                r1.<init>(r9, r0);
                com.tencent.mm.pluginsdk.model.app.l.a(r0, r1);
                goto L_0x01a0;
            L_0x01e4:
                r1 = 0;
                goto L_0x01bf;
            L_0x01e6:
                r1 = 0;
                goto L_0x01c9;
            L_0x01e8:
                if (r13 == 0) goto L_0x01a0;
            L_0x01ea:
                r1 = com.tencent.mm.ah.n.GT();
                r2 = r13.hEY;
                r4 = r0.field_msgId;
                r6 = 0;
                r7 = -1;
                r7 = java.lang.Integer.valueOf(r7);
                r8 = -1;
                r10 = 0;
                r1 = r1.a(r2, r4, r6, r7, r8, r9, r10);
                r2 = -2;
                if (r1 != r2) goto L_0x01a0;
            L_0x0201:
                r1 = "MicroMsg.MediaHistoryGalleryPresenter";
                r2 = "[downloadImg] this img has download! %s";
                r3 = 1;
                r3 = new java.lang.Object[r3];
                r4 = 0;
                r5 = r13.hEZ;
                r3[r4] = r5;
                com.tencent.mm.sdk.platformtools.w.w(r1, r2, r3);
                r1 = r9.vUv;
                r1 = r1 + -1;
                r9.vUv = r1;
                r1 = r9.mContext;
                r2 = 0;
                com.tencent.mm.ui.chatting.gallery.b.b(r1, r0, r2);
                goto L_0x01a0;
            L_0x021f:
                r1 = r11.iterator();
            L_0x0223:
                r0 = r1.hasNext();
                if (r0 == 0) goto L_0x0277;
            L_0x0229:
                r0 = r1.next();
                r0 = (com.tencent.mm.storage.au) r0;
                r2 = r14.vUx;
                r3 = com.tencent.mm.ui.chatting.gallery.i.bl(r0);
                if (r3 != 0) goto L_0x0241;
            L_0x0237:
                r0 = "MicroMsg.MediaHistoryGalleryPresenter";
                r2 = "[saveVideo] info == null";
                com.tencent.mm.sdk.platformtools.w.e(r0, r2);
                goto L_0x0223;
            L_0x0241:
                r4 = com.tencent.mm.modelvideo.o.KV();
                r5 = android.os.Looper.getMainLooper();
                r4.a(r2, r5);
                r2 = r3.Lj();
                if (r2 == 0) goto L_0x0261;
            L_0x0252:
                r2 = "MicroMsg.MediaHistoryGalleryPresenter";
                r3 = "start complete online video";
                com.tencent.mm.sdk.platformtools.w.i(r2, r3);
                r0 = r0.field_imgPath;
                com.tencent.mm.modelvideo.t.lL(r0);
                goto L_0x0223;
            L_0x0261:
                r2 = "MicroMsg.MediaHistoryGalleryPresenter";
                r3 = "start complete offline video";
                com.tencent.mm.sdk.platformtools.w.i(r2, r3);
                r2 = r0.field_imgPath;
                r3 = 10;
                com.tencent.mm.modelvideo.t.J(r2, r3);
                r0 = r0.field_imgPath;
                com.tencent.mm.modelvideo.t.lD(r0);
                goto L_0x0223;
            L_0x0277:
                r0 = r14.vUx;
                r0 = r0.vUw;
                if (r0 == 0) goto L_0x028f;
            L_0x027d:
                r0 = r14.vUx;
                r0 = r0.vUv;
                if (r0 != 0) goto L_0x028f;
            L_0x0283:
                r0 = r14.vUx;
                r0 = r0.mHandler;
                r1 = new com.tencent.mm.ui.chatting.c.e$2$3;
                r1.<init>(r14);
                r0.post(r1);
            L_0x028f:
                r0 = r14.vUx;
                r0 = r0.bXD();
                if (r0 == 0) goto L_0x0019;
            L_0x0297:
                r0 = r14.vUx;
                r0 = r0.vUw;
                if (r0 != 0) goto L_0x0019;
            L_0x029d:
                r0 = r14.vUx;
                r0 = r0.mHandler;
                r1 = new com.tencent.mm.ui.chatting.c.e$2$4;
                r1.<init>(r14);
                r0.post(r1);
                goto L_0x0019;
            L_0x02ab:
                r0 = r1;
                goto L_0x006c;
            L_0x02ae:
                r0 = r2;
                goto L_0x005c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.c.e.2.run():void");
            }
        }, "handleSave");
    }

    public final boolean bXD() {
        return this.vUv == 0;
    }

    public final LinkedList<au> cG(List<au> list) {
        LinkedList<au> linkedList = new LinkedList();
        for (au auVar : list) {
            if (com.tencent.mm.ui.chatting.gallery.b.aR(auVar)) {
                if (d.bg(auVar).GA()) {
                    this.vUv--;
                    com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, auVar, false);
                } else {
                    linkedList.add(auVar);
                }
            } else if (auVar.field_type == 268435505) {
                if (bg.mA(com.tencent.mm.ui.chatting.gallery.b.bb(auVar)) || !new File(com.tencent.mm.ui.chatting.gallery.b.bb(auVar)).exists()) {
                    linkedList.add(auVar);
                } else {
                    this.vUv--;
                    com.tencent.mm.ui.chatting.gallery.b.b(this.mContext, auVar, false);
                }
            }
        }
        return linkedList;
    }

    public final LinkedList<au> cH(List<au> list) {
        LinkedList<au> linkedList = new LinkedList();
        for (au auVar : list) {
            if (com.tencent.mm.ui.chatting.gallery.b.aS(auVar)) {
                if (i.bl(auVar).Lk()) {
                    this.vUv--;
                    com.tencent.mm.ui.chatting.gallery.b.a(this.mContext, auVar, false);
                } else {
                    linkedList.add(auVar);
                }
            }
        }
        return linkedList;
    }

    static String c(au auVar, r rVar) {
        String Lg;
        if (rVar.iaw == -1) {
            Lg = rVar.Lg();
            if (com.tencent.mm.a.e.aO(Lg)) {
                return Lg;
            }
            o.KV();
            return s.lv(auVar.field_imgPath);
        }
        o.KV();
        Lg = s.lv(auVar.field_imgPath);
        if (auVar.field_isSend != 1 || rVar.iaz == null || !rVar.iaz.tOs) {
            return Lg;
        }
        try {
            String kk = FileOp.kk(Lg);
            if (!kk.endsWith("/")) {
                kk = kk + "/";
            }
            kk = kk + com.tencent.mm.a.e.aR(Lg) + "_hd.mp4";
            w.i("MicroMsg.MediaHistoryGalleryPresenter", "local capture video, hdFilePath: %s, exist: %s", kk, Boolean.valueOf(FileOp.aO(kk)));
            if (!FileOp.aO(kk)) {
                kk = Lg;
            }
            return kk;
        } catch (Exception e) {
            w.e("MicroMsg.MediaHistoryGalleryPresenter", "try to get hd filePath error: %s", e.getMessage());
            return Lg;
        }
    }

    private void cI(final List<au> list) {
        com.tencent.mm.plugin.report.service.g.oUh.i(11627, Integer.valueOf(5));
        final Set treeSet = new TreeSet();
        for (au auVar : list) {
            treeSet.add(Long.valueOf(auVar.field_msgId));
        }
        com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(R.l.dXd), "", this.mContext.getString(R.l.ebv), this.mContext.getString(R.l.dGs), new OnClickListener(this) {
            final /* synthetic */ e vUx;

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.MediaHistoryGalleryPresenter", "delete message");
                z.a(this.vUx.mContext, treeSet, new dz(this) {
                    final /* synthetic */ AnonymousClass5 vUA;

                    {
                        this.vUA = r1;
                    }

                    public final void bUE() {
                    }

                    public final void a(dz.a aVar) {
                        if (aVar == dz.a.del) {
                            this.vUA.vUx.jnH.removeAll(list);
                        }
                    }

                    public final void b(dz.a aVar) {
                        w.i("MicroMsg.MediaHistoryGalleryPresenter", "[requestExitSelectedMode] %s del size:%s job:%s", Thread.currentThread(), Integer.valueOf(list.size()), aVar);
                        if (aVar == dz.a.del) {
                            this.vUA.vUx.vUr.bWv();
                        }
                    }

                    public final boolean bUF() {
                        return true;
                    }
                });
            }
        }, null);
    }

    public static void cJ(List<au> list) {
        for (au a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
        }
    }

    public final void b(cb cbVar) {
        cbVar.fFA.fFH = 45;
        cbVar.fFA.activity = (Activity) this.mContext;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        if (cbVar.fFB.ret != -2 && cbVar.fFB.ret <= 0 && cbVar.fFB.ret <= 0) {
            if (14 != cbVar.fFA.type) {
                w.d("MicroMsg.MediaHistoryGalleryPresenter", "not record type, do not report");
            } else if (cbVar.fFA.fFD == null) {
                w.e("MicroMsg.MediaHistoryGalleryPresenter", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.i(11142, Integer.valueOf(cbVar.fFA.fFD.tzy), Integer.valueOf(cbVar.fFA.fFD.tzz), Integer.valueOf(cbVar.fFA.fFD.tzA), Integer.valueOf(cbVar.fFA.fFD.tzB), Integer.valueOf(cbVar.fFA.fFD.tzC), Integer.valueOf(cbVar.fFA.fFD.tzD), Integer.valueOf(cbVar.fFA.fFD.tzE), Integer.valueOf(cbVar.fFA.fFD.tzF), Integer.valueOf(cbVar.fFA.fFD.tzG), Integer.valueOf(cbVar.fFA.fFD.tzH), Integer.valueOf(cbVar.fFA.fFD.tzI), Integer.valueOf(cbVar.fFA.fFD.tzJ), Integer.valueOf(cbVar.fFA.fFD.tzK), Integer.valueOf(cbVar.fFA.fFD.tzL), Integer.valueOf(cbVar.fFA.fFD.tzM));
            }
        }
    }

    public final void r(final boolean z, final int i) {
        if (z || this.kUZ + this.vUn != this.jnH.size()) {
            this.vUs.vPv = true;
            this.vUr.lq(z);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
                final /* synthetic */ e vUx;

                public final void run() {
                    Cursor E;
                    if (z) {
                        e eVar;
                        if (this.vUx.vPu == -1) {
                            eVar = this.vUx;
                            ap.yY();
                            eVar.kUZ = com.tencent.mm.u.c.wT().AA(this.vUx.kwJ);
                        } else {
                            eVar = this.vUx;
                            ap.yY();
                            eVar.kUZ = com.tencent.mm.u.c.wU().ai(this.vUx.kwJ, this.vUx.vPu);
                        }
                    }
                    int i = (i < 0 || this.vUx.kUZ - i <= m.CTRL_INDEX) ? m.CTRL_INDEX : this.vUx.kUZ - i;
                    w.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", Integer.valueOf(i), Integer.valueOf(i));
                    LinkedList linkedList = new LinkedList();
                    if (this.vUx.vPu == -1) {
                        ap.yY();
                        E = com.tencent.mm.u.c.wT().E(this.vUx.kwJ, this.vUx.jnH.size() - this.vUx.vUn, i);
                    } else {
                        ap.yY();
                        E = com.tencent.mm.u.c.wU().b(this.vUx.kwJ, this.vUx.vPu, this.vUx.jnH.size() - this.vUx.vUn, i);
                    }
                    long j = 0;
                    while (E.moveToNext()) {
                        try {
                            au auVar = new au();
                            auVar.b(E);
                            long a = com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(auVar.field_createTime));
                            if (j != a) {
                                linkedList.add(new c(auVar.field_createTime));
                                e eVar2 = this.vUx;
                                eVar2.vUn++;
                            }
                            linkedList.add(new c(auVar));
                            j = a;
                        } finally {
                            E.close();
                        }
                    }
                    LinkedList linkedList2 = new LinkedList();
                    if (linkedList.size() - this.vUx.vUn == i) {
                        long j2 = ((c) linkedList.get(0)).hTv;
                        com.tencent.mm.ui.gridviewheaders.a.bZj();
                        j = com.tencent.mm.ui.gridviewheaders.a.eX(j2);
                        w.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(j2));
                        if (this.vUx.vPu == -1) {
                            ap.yY();
                            E = com.tencent.mm.u.c.wT().e(this.vUx.kwJ, j, j2);
                        } else {
                            ap.yY();
                            E = com.tencent.mm.u.c.wU().a(this.vUx.kwJ, this.vUx.vPu, j, j2);
                        }
                        Date date = new Date(j2);
                        j2 = com.tencent.mm.ui.gridviewheaders.a.bZj().a(date);
                        while (E.moveToNext()) {
                            au auVar2 = new au();
                            auVar2.b(E);
                            j = com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(auVar2.field_createTime));
                            if (j2 == j || com.tencent.mm.ui.gridviewheaders.a.bZj().a(date) == j) {
                                try {
                                    if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                        linkedList2.add(0, linkedList.remove(0));
                                    }
                                    j = j2;
                                } finally {
                                    E.close();
                                }
                            } else {
                                linkedList2.add(new c(auVar2.field_createTime));
                                e eVar3 = this.vUx;
                                eVar3.vUn++;
                            }
                            linkedList2.add(new c(auVar2));
                            j2 = j;
                        }
                    }
                    final int size = linkedList.size() + linkedList2.size();
                    this.vUx.jnH.addAll(0, linkedList2);
                    this.vUx.jnH.addAll(linkedList2.size(), linkedList);
                    linkedList.clear();
                    linkedList2.clear();
                    this.vUx.vUn = 0;
                    w.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", Integer.valueOf(this.vUx.jnH.size()));
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 vUC;

                        public final void run() {
                            this.vUC.vUx.vUs.vPv = false;
                            if (this.vUC.vUx.vUr != null) {
                                this.vUC.vUx.vUr.s(z, size);
                            }
                        }
                    });
                }
            });
            return;
        }
        w.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] that's all msg :%s offset:%s", Integer.valueOf(this.kUZ), Integer.valueOf(i));
    }
}
