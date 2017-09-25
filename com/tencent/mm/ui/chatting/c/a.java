package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.t;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.l;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends b {
    private c vCn;
    public int vTW = -1;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean vTX = true;
        final /* synthetic */ a vTY;

        AnonymousClass1(a aVar, boolean z) {
            this.vTY = aVar;
        }

        public final void run() {
            q fV;
            LinkedList linkedList = new LinkedList();
            ap.yY();
            Cursor bg = com.tencent.mm.u.c.wT().bg(this.vTY.kwJ, this.vTY.vTW);
            if (o.dH(this.vTY.kwJ)) {
                ap.yY();
                fV = com.tencent.mm.u.c.xa().fV(this.vTY.kwJ);
            } else {
                fV = null;
            }
            while (bg.moveToNext()) {
                ce auVar = new au();
                auVar.b(bg);
                String str = auVar.field_content;
                if (str != null) {
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
                    int i = ek.type;
                    Object obj = (33 == i || 36 == i) ? 1 : null;
                    if (obj != null) {
                        Object obj2;
                        String f = b.f(auVar, o.dH(this.vTY.kwJ));
                        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(f);
                        String str2 = "";
                        if (fV != null) {
                            str2 = fV.eK(f);
                        }
                        a aVar = new a(this.vTY, auVar.field_createTime, ek.type, ek.title, auVar.field_msgId, Rc.field_username, Rc.tK(), Rc.field_conRemark, str2, bg.ap(ek.hjN, ek.appId), ek, auVar.field_msgSvrId);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            if (bg.eB(aVar.hjN, ((a) ((com.tencent.mm.ui.chatting.a.b.b) it.next())).hjN)) {
                                obj2 = 1;
                                break;
                            }
                        }
                        obj2 = null;
                        if (obj2 == null) {
                            aVar.desc = ek.title;
                            WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(aVar.fSU.hjM);
                            if (og != null) {
                                f = og.field_nickname;
                            } else {
                                try {
                                    f = aVar.fSU.fUS;
                                } catch (Throwable th) {
                                    bg.close();
                                }
                            }
                            aVar.title = f;
                            aVar.imagePath = og != null ? og.field_brandIconURL : aVar.fSU.hjV;
                            linkedList.add(aVar);
                        }
                        if (linkedList.size() >= 10) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            bg.close();
            this.vTY.jnH.addAll(linkedList);
            this.vTY.vUf = this.vTY.jnH;
            linkedList.clear();
            w.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] data:%s", new Object[]{Integer.valueOf(this.vTY.jnH.size())});
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 vTZ;

                {
                    this.vTZ = r1;
                }

                public final void run() {
                    if (this.vTZ.vTY.vUc != null) {
                        this.vTZ.vTY.vUc.s(this.vTZ.vTX, this.vTZ.vTY.jnH.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String desc;
        public com.tencent.mm.t.f.a fSU;
        public long fTQ;
        public String hjN;
        public String imagePath;
        final /* synthetic */ a vTY;

        public a(a aVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5, String str6, com.tencent.mm.t.f.a aVar2, long j3) {
            this.vTY = aVar;
            super(j, i, str, j2, str2, str3, str4, str5);
            this.hjN = str6;
            this.fSU = aVar2;
            this.fTQ = j3;
        }

        public final boolean TG(String str) {
            return false;
        }

        public final int getType() {
            return 33;
        }
    }

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ipx;
        final /* synthetic */ a vTY;

        public b(a aVar, View view) {
            this.vTY = aVar;
            super(view);
            this.ipx = (TextView) view.findViewById(R.h.bOm);
        }
    }

    public a(Context context) {
        super(context);
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hJa = R.k.dtz;
        aVar.aO(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 50), com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 50)).hIJ = true;
        this.vCn = aVar.Hg();
    }

    public final void bWD() {
        w.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[]{Boolean.valueOf(true)});
        this.vUc.bWH();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new AnonymousClass1(this, true));
    }

    public final String Oh() {
        return "";
    }

    public final String bWG() {
        return "";
    }

    public final e bWE() {
        return new e(this) {
            final /* synthetic */ a vTY;

            {
                this.vTY = r1;
            }

            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
                this.vTY.a((a) bVar);
            }

            public final void a(View view, int i, final com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
                new l(view.getContext()).b(view, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ AnonymousClass2 vUa;

                    {
                        this.vUa = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    }
                }, new d(this) {
                    final /* synthetic */ AnonymousClass2 vUa;

                    public final void c(MenuItem menuItem, int i) {
                        ap.yY();
                        this.vUa.vTY.e(menuItem.getItemId(), com.tencent.mm.u.c.wT().cA(bVar.fGM));
                    }
                });
            }
        };
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.cUK, viewGroup, false));
    }

    public final void a(com.tencent.mm.ui.chatting.a.b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) Bg(i);
        if (bg.mA(aVar2.desc)) {
            bVar.ipx.setVisibility(8);
        } else {
            bVar.ipx.setVisibility(0);
            bVar.ipx.setText(bg.ap(aVar2.desc, ""));
        }
        n.GW().a(aVar2.imagePath, bVar.ipv, this.vCn);
    }

    public final void a(a aVar) {
        boolean z;
        boolean dH = o.dH(this.kwJ);
        w.i("MicroMsg.AppBrandHistoryListPresenter", "username: %s , appid %s ,pkgType : %s", new Object[]{aVar.fSU.hjM, aVar.hjN, Integer.valueOf(aVar.fSU.hjT)});
        String str = this.kwJ;
        String str2 = aVar.username;
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 9);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(aVar.fTQ));
        bundle.putString("stat_chat_talker_username", str);
        bundle.putString("stat_send_msg_user", str2);
        switch (aVar.fSU.hjO) {
            case 1:
                Intent intent = new Intent();
                intent.putExtra("key_username", aVar.fSU.hjM);
                if (dH) {
                    intent.putExtra("key_from_scene", 1);
                    intent.putExtra("key_scene_note", str + ":" + str2);
                } else {
                    intent.putExtra("key_from_scene", 2);
                    intent.putExtra("key_scene_note", str);
                }
                intent.putExtra("_stat_obj", bundle);
                com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar2 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                aVar2.appId = aVar.hjN;
                aVar2.fFr = 6;
                aVar2.izV = aVar.fSU.hjT;
                aVar2.izW = aVar.fSU.hjQ;
                intent.putExtra("key_scene_exposed_params", aVar2.RL());
                com.tencent.mm.bb.d.b(this.mContext, "appbrand", ".ui.AppBrandProfileUI", intent);
                z = false;
                break;
            case 2:
                com.tencent.mm.modelappbrand.a.c(str, str2, dH, aVar.fSU, bundle);
                z = false;
                break;
            case 3:
                com.tencent.mm.modelappbrand.a.d(str, str2, dH, aVar.fSU, bundle);
                z = false;
                break;
            default:
                z = true;
                break;
        }
        if (z && aVar.fSU.type == 36) {
            com.tencent.mm.modelappbrand.a.a(this.kwJ, aVar.username, true, aVar.fSU, bundle);
            z = false;
        }
        w.i("MicroMsg.AppBrandHistoryListPresenter", "goDefaultClickAction %b", new Object[]{Boolean.valueOf(z)});
        if (z && aVar.fSU.url != null && !aVar.fSU.url.equals("")) {
            str = p.s(aVar.fSU.url, dH ? "groupmessage" : "singlemessage");
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("webpageTitle", aVar.fSU.title);
            PackageInfo az = az(this.mContext, aVar.fSU.appId);
            intent2.putExtra("version_name", az == null ? null : az.versionName);
            intent2.putExtra("version_code", az == null ? 0 : az.versionCode);
            intent2.putExtra("shortUrl", aVar.fSU.url);
            if (!bg.mA(aVar.fSU.fUR)) {
                intent2.putExtra("srcUsername", aVar.fSU.fUR);
                intent2.putExtra("srcDisplayname", aVar.fSU.fUS);
            }
            intent2.putExtra("msg_id", aVar.fGM);
            intent2.putExtra("KPublisherId", "msg_" + Long.toString(aVar.fTQ));
            intent2.putExtra("KAppId", aVar.fSU.appId);
            intent2.putExtra("geta8key_username", this.kwJ);
            intent2.putExtra("pre_username", aVar.username);
            intent2.putExtra("from_scence", 2);
            intent2.putExtra("prePublishId", "msg_" + Long.toString(aVar.fTQ));
            intent2.putExtra("preUsername", aVar.username);
            intent2.putExtra("preChatName", this.kwJ);
            intent2.putExtra("preChatTYPE", 2);
            intent2.putExtra("preMsgIndex", 0);
            intent2.putExtra("share_report_pre_msg_url", aVar.fSU.url);
            intent2.putExtra("share_report_pre_msg_title", aVar.fSU.title);
            intent2.putExtra("share_report_pre_msg_desc", aVar.fSU.description);
            intent2.putExtra("share_report_pre_msg_icon_url", aVar.fSU.thumburl);
            intent2.putExtra("share_report_pre_msg_appid", aVar.fSU.appId);
            intent2.putExtra("share_report_from_scene", 2);
            com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
        }
    }

    private static PackageInfo az(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aJ = g.aJ(str, true);
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
                w.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
