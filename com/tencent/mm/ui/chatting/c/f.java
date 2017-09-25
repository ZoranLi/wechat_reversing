package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.l;
import java.util.Date;
import java.util.LinkedList;

public final class f extends b {
    private int kUZ = 0;
    public int vTW = -1;
    public int vUn = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean vTX = true;
        final /* synthetic */ f vUD;

        AnonymousClass1(f fVar, boolean z) {
            this.vUD = fVar;
        }

        public final void run() {
            q fV;
            LinkedList linkedList = new LinkedList();
            ap.yY();
            Cursor bf = c.wT().bf(this.vUD.kwJ, this.vUD.vTW);
            if (o.dH(this.vUD.kwJ)) {
                ap.yY();
                fV = c.xa().fV(this.vUD.kwJ);
            } else {
                fV = null;
            }
            long j = 0;
            while (bf.moveToNext()) {
                try {
                    ce auVar = new au();
                    auVar.b(bf);
                    String str = auVar.field_content;
                    if (str != null) {
                        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
                        if ((3 == ek.type ? 1 : null) != null) {
                            long a = com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(auVar.field_createTime));
                            if (j != a) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                                f fVar = this.vUD;
                                fVar.vUn++;
                            }
                            String f = b.f(auVar, o.dH(this.vUD.kwJ));
                            af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(f);
                            String str2 = "";
                            if (fV != null) {
                                str2 = fV.eK(f);
                            }
                            int LO = com.tencent.mm.pluginsdk.model.c.LO(ek.hhr);
                            String appName = com.tencent.mm.plugin.favorite.c.getAppName(this.vUD.mContext, ek.fUR);
                            ap.yY();
                            af Rc2 = c.wR().Rc(ek.fUR);
                            if (Rc2 == null || !Rc2.field_username.equals(ek.fUR)) {
                                com.tencent.mm.u.ag.a.hlS.a(ek.fUR, "", null);
                            } else {
                                appName = Rc2.tL();
                            }
                            a aVar = new a(this.vUD, auVar.field_createTime, ek.type, ek.title, auVar.field_msgId, Rc.field_username, Rc.tK(), Rc.field_conRemark, str2);
                            aVar.aJE = bg.mA(appName) ? ek.description : appName;
                            aVar.appId = ek.appId;
                            aVar.imagePath = auVar.field_imgPath;
                            aVar.iconRes = LO;
                            linkedList.add(aVar);
                            j = a;
                        }
                    }
                } finally {
                    bf.close();
                }
            }
            this.vUD.jnH.addAll(linkedList);
            this.vUD.vUf = this.vUD.jnH;
            linkedList.clear();
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 vUE;

                {
                    this.vUE = r1;
                }

                public final void run() {
                    if (this.vUE.vUD.vUc != null) {
                        this.vUE.vUD.vUc.s(this.vUE.vTX, this.vUE.vUD.jnH.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String aJE;
        public String appId;
        public int iconRes;
        public String imagePath;
        final /* synthetic */ f vUD;

        public a(f fVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.vUD = fVar;
            super(j, i, str, j2, str2, str3, str4, str5);
        }

        public final boolean TG(String str) {
            if (str == null) {
                return false;
            }
            Object toLowerCase = str.toLowerCase();
            if (com.tencent.mm.ui.chatting.a.b.b.TH(toLowerCase)) {
                if (!bg.mA(this.aJE) && this.aJE.toLowerCase().contains(toLowerCase)) {
                    return true;
                }
            } else if (!bg.mA(this.aJE) && eU(toLowerCase, this.aJE.toLowerCase())) {
                return true;
            }
            return super.TG(toLowerCase);
        }

        public final int getType() {
            return 3;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ipx;
        ImageView jbU;
        TextView lMU;
        ImageView lNh;
        final /* synthetic */ f vUD;

        public b(f fVar, View view) {
            this.vUD = fVar;
            super(view);
            this.jbU = (ImageView) view.findViewById(R.h.bOx);
            this.ipx = (TextView) view.findViewById(R.h.bOj);
            this.ipx.setVisibility(8);
            this.lMU = (TextView) view.findViewById(R.h.bOP);
            this.lNh = (ImageView) view.findViewById(R.h.bOz);
            this.lNh.setImageResource(R.g.bhp);
            this.lNh.setVisibility(0);
        }
    }

    public f(Context context) {
        super(context);
    }

    public final void bWD() {
        this.vUc.bWH();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new AnonymousClass1(this, true));
    }

    public final String Oh() {
        return this.mContext.getString(R.l.dCY);
    }

    public final String bWG() {
        return this.mContext.getString(R.l.dCY);
    }

    public final e bWE() {
        return new e(this) {
            final /* synthetic */ f vUD;

            {
                this.vUD = r1;
            }

            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                ap.yY();
                ce cA = c.wT().cA(bVar.fGM);
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
                String s = p.s(ek.url, "message");
                String s2 = p.s(ek.hhp, "message");
                PackageInfo az = f.az(this.vUD.mContext, ek.appId);
                this.vUD.a(s, s2, az == null ? null : az.versionName, az == null ? 0 : az.versionCode, ek.appId, cA.field_msgId, cA.field_msgSvrId, cA);
            }

            public final void a(View view, int i, final com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.MusicHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
                new l(view.getContext()).b(view, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ AnonymousClass2 vUF;

                    {
                        this.vUF = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eLL));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dTs));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dUp));
                    }
                }, new d(this) {
                    final /* synthetic */ AnonymousClass2 vUF;

                    public final void c(MenuItem menuItem, int i) {
                        ap.yY();
                        this.vUF.vUD.e(i, c.wT().cA(bVar.fGM));
                    }
                });
            }
        };
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dpq, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) Bg(i);
        bVar.kxi.setText(u.e(this.mContext, aVar2.timestamp));
        Bitmap a = n.GS().a(aVar2.imagePath, com.tencent.mm.bg.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = g.b(aVar2.appId, 1, com.tencent.mm.bg.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                bVar.jbU.setImageResource(R.k.dtu);
                bVar.lMU.setText(bg.ap(aVar2.aJE, ""));
                com.tencent.mm.ui.chatting.a.b.a.d(bVar.lMU, this.vUd.vPK);
            }
        }
        bVar.jbU.setImageBitmap(a);
        bVar.lMU.setText(bg.ap(aVar2.aJE, ""));
        com.tencent.mm.ui.chatting.a.b.a.d(bVar.lMU, this.vUd.vPK);
    }

    protected final void a(String str, String str2, String str3, int i, String str4, long j, long j2, au auVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            w.e("MicroMsg.MusicHistoryListPresenter", "url, lowUrl both are empty");
            return;
        }
        if (am.isMobile(this.mContext) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", true);
        intent.putExtra("geta8key_username", this.kwJ);
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        String f = b.f(auVar, o.dH(this.kwJ));
        intent.putExtra("pre_username", f);
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (auVar != null) {
            intent.putExtra("preUsername", f);
        }
        intent.putExtra("preChatName", this.kwJ);
        intent.putExtra("preChatTYPE", com.tencent.mm.u.p.G(f, this.kwJ));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static PackageInfo az(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(str, true);
            if (aJ == null) {
                Object obj = packageInfo;
            } else {
                str2 = aJ.field_packageName;
            }
        }
        if (str2 != null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MusicHistoryListPresenter", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
