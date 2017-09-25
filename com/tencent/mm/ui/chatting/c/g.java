package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.ew;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

public final class g extends b {
    public int vTW = -1;
    HashSet<Integer> vUG = new HashSet();
    public int vUn = 0;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean vTX = true;
        final /* synthetic */ g vUH;

        AnonymousClass1(g gVar, boolean z) {
            this.vUH = gVar;
        }

        public final void run() {
            q fV;
            LinkedList linkedList = new LinkedList();
            ap.yY();
            Cursor bf = c.wT().bf(this.vUH.kwJ, this.vUH.vTW);
            if (o.dH(this.vUH.kwJ)) {
                ap.yY();
                fV = c.xa().fV(this.vUH.kwJ);
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
                        g gVar = this.vUH;
                        int i = ek.type;
                        gVar.vUG.add(Integer.valueOf(5));
                        gVar.vUG.add(Integer.valueOf(7));
                        gVar.vUG.add(Integer.valueOf(27));
                        gVar.vUG.add(Integer.valueOf(26));
                        gVar.vUG.add(Integer.valueOf(15));
                        if (gVar.vUG.contains(Integer.valueOf(i))) {
                            long a = com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(auVar.field_createTime));
                            if (j != a) {
                                linkedList.add(new com.tencent.mm.ui.chatting.a.b.c(auVar.field_createTime));
                                g gVar2 = this.vUH;
                                gVar2.vUn++;
                            }
                            String f = b.f(auVar, o.dH(this.vUH.kwJ));
                            af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(f);
                            String str2 = "";
                            if (fV != null) {
                                str2 = fV.eK(f);
                            }
                            int LO = com.tencent.mm.pluginsdk.model.c.LO(ek.hhr);
                            String appName = com.tencent.mm.plugin.favorite.c.getAppName(this.vUH.mContext, ek.fUR);
                            ap.yY();
                            af Rc2 = c.wR().Rc(ek.fUR);
                            if (Rc2 == null || !Rc2.field_username.equals(ek.fUR)) {
                                com.tencent.mm.u.ag.a.hlS.a(ek.fUR, "", null);
                            } else {
                                appName = Rc2.tL();
                            }
                            a aVar = new a(this.vUH, auVar.field_createTime, ek.type, ek.title, auVar.field_msgId, Rc.field_username, Rc.tK(), Rc.field_conRemark, str2);
                            aVar.aJE = bg.mA(appName) ? ek.description : appName;
                            aVar.appId = ek.appId;
                            if (bg.mA(auVar.field_imgPath)) {
                                aVar.imagePath = ek.thumburl;
                            } else {
                                aVar.imagePath = auVar.field_imgPath;
                            }
                            aVar.iconRes = LO;
                            linkedList.add(aVar);
                            j = a;
                        }
                    }
                } finally {
                    bf.close();
                }
            }
            this.vUH.jnH.addAll(linkedList);
            this.vUH.vUf = this.vUH.jnH;
            linkedList.clear();
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 vUI;

                {
                    this.vUI = r1;
                }

                public final void run() {
                    if (this.vUI.vUH.vUc != null) {
                        this.vUI.vUH.vUc.s(this.vUI.vTX, this.vUI.vUH.jnH.size());
                    }
                }
            });
        }
    }

    class a extends com.tencent.mm.ui.chatting.a.b.b {
        public String aJE;
        public String appId;
        public String desc;
        public int iconRes;
        public String imagePath;
        final /* synthetic */ g vUH;

        public a(g gVar, long j, int i, String str, long j2, String str2, String str3, String str4, String str5) {
            this.vUH = gVar;
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
    }

    class b extends com.tencent.mm.ui.chatting.a.b.a {
        TextView ipx;
        ImageView jbU;
        TextView lMU;
        final /* synthetic */ g vUH;

        public b(g gVar, View view) {
            this.vUH = gVar;
            super(view);
            this.jbU = (ImageView) view.findViewById(R.h.bOx);
            this.ipx = (TextView) view.findViewById(R.h.bOj);
            this.lMU = (TextView) view.findViewById(R.h.bOP);
            this.lMU.setVisibility(0);
        }
    }

    public g(Context context) {
        super(context);
    }

    public final void bWD() {
        this.vUc.bWH();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vL().D(new AnonymousClass1(this, true));
    }

    public final String Oh() {
        return this.mContext.getString(R.l.dCZ);
    }

    public final String bWG() {
        return this.mContext.getString(R.l.dCZ);
    }

    public final e bWE() {
        return new e(this) {
            final /* synthetic */ g vUH;

            {
                this.vUH = r1;
            }

            public final void a(int i, com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
                if (bVar == null) {
                    w.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[]{Integer.valueOf(i)});
                    return;
                }
                a aVar = (a) bVar;
                if (aVar.getType() == 5) {
                    this.vUH.a(aVar);
                } else if (aVar.getType() == 7) {
                    this.vUH.b(aVar);
                } else if (aVar.getType() == 15) {
                    this.vUH.c(aVar);
                } else if (aVar.getType() == 26) {
                    this.vUH.d(aVar);
                } else if (aVar.getType() == 27) {
                    this.vUH.e(aVar);
                } else {
                    w.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[]{Integer.valueOf(aVar.getType())});
                }
            }

            public final void a(View view, int i, final com.tencent.mm.ui.chatting.a.b.b bVar) {
                w.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
                new l(view.getContext()).b(view, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ AnonymousClass2 vUJ;

                    {
                        this.vUJ = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 0, 0, view.getContext().getString(R.l.eLL));
                        contextMenu.add(0, 1, 0, view.getContext().getString(R.l.dTs));
                        contextMenu.add(0, 2, 0, view.getContext().getString(R.l.dUp));
                    }
                }, new d(this) {
                    final /* synthetic */ AnonymousClass2 vUJ;

                    public final void c(MenuItem menuItem, int i) {
                        ap.yY();
                        this.vUJ.vUH.e(i, c.wT().cA(bVar.fGM));
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
        if (bg.mA(aVar2.desc) || !bg.mA(aVar2.aJE)) {
            bVar.ipx.setVisibility(8);
        } else {
            bVar.ipx.setVisibility(0);
            bVar.ipx.setText(bg.ap(aVar2.desc, ""));
        }
        Bitmap a = n.GS().a(aVar2.imagePath, com.tencent.mm.bg.a.getDensity(this.mContext), false);
        if (a == null || a.isRecycled()) {
            a = com.tencent.mm.pluginsdk.model.app.g.b(aVar2.appId, 1, com.tencent.mm.bg.a.getDensity(this.mContext));
            if (a == null || a.isRecycled()) {
                a = j.a(new s(aVar2.imagePath, aVar2.type, "@S", false));
                if (a == null) {
                    bVar.jbU.setImageResource(R.k.dtu);
                    bVar.lMU.setText(bg.ap(aVar2.aJE, ""));
                    com.tencent.mm.ui.chatting.a.b.a.d(bVar.lMU, this.vUd.vPK);
                }
            }
        }
        bVar.jbU.setImageBitmap(a);
        bVar.lMU.setText(bg.ap(aVar2.aJE, ""));
        com.tencent.mm.ui.chatting.a.b.a.d(bVar.lMU, this.vUd.vPK);
    }

    public final void a(a aVar) {
        ap.yY();
        ce cA = c.wT().cA(aVar.fGM);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
        if (ek.url != null && !ek.url.equals("")) {
            String s = p.s(ek.url, this.kwJ.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            String str = ek.url;
            PackageInfo az = az(this.mContext, ek.appId);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", s);
            intent.putExtra("webpageTitle", ek.title);
            if (ek.appId != null && ("wx751a1acca5688ba3".equals(ek.appId) || "wxfbc915ff7c30e335".equals(ek.appId) || "wx482a4001c37e2b74".equals(ek.appId))) {
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", ek.appId);
                intent.putExtra("jsapiargs", bundle);
            }
            if (bg.mA(str)) {
                intent.putExtra("shortUrl", ek.url);
            } else {
                intent.putExtra("shortUrl", str);
            }
            intent.putExtra("version_name", az == null ? null : az.versionName);
            intent.putExtra("version_code", az == null ? 0 : az.versionCode);
            if (!bg.mA(ek.fUR)) {
                intent.putExtra("srcUsername", ek.fUR);
                intent.putExtra("srcDisplayname", ek.fUS);
            }
            intent.putExtra("msg_id", cA.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(cA.field_msgSvrId));
            intent.putExtra("KAppId", ek.appId);
            intent.putExtra("geta8key_username", this.kwJ);
            s = b.f(cA, o.dH(this.kwJ));
            intent.putExtra("pre_username", s);
            intent.putExtra("prePublishId", "msg_" + Long.toString(cA.field_msgSvrId));
            intent.putExtra("preUsername", s);
            intent.putExtra("preChatName", this.kwJ);
            intent.putExtra("preChatTYPE", com.tencent.mm.u.p.G(s, this.kwJ));
            intent.putExtra("preMsgIndex", 0);
            com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void b(a aVar) {
        ap.yY();
        au cA = c.wT().cA(aVar.fGM);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
        com.tencent.mm.e.b.n aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(ek.appId, false);
        if (aJ != null && aJ.bCU()) {
            Object obj;
            Intent intent;
            String str = this.kwJ;
            if (o.dH(str)) {
                str = ay.gi(cA.field_content);
            }
            long j = cA.field_msgSvrId;
            int i = (aJ == null || !p.n(this.mContext, aJ.field_packageName)) ? 6 : 3;
            if (ek.type == 2) {
                i = 4;
            } else if (ek.type == 5) {
                i = 1;
            }
            com.tencent.mm.sdk.b.b mnVar = new mn();
            mnVar.fTN.context = this.mContext;
            mnVar.fTN.scene = 1;
            mnVar.fTN.fTO = ek.appId;
            mnVar.fTN.packageName = aJ == null ? null : aJ.field_packageName;
            mnVar.fTN.msgType = ek.type;
            mnVar.fTN.fOu = str;
            mnVar.fTN.fTP = i;
            mnVar.fTN.mediaTagName = ek.mediaTagName;
            mnVar.fTN.fTQ = j;
            mnVar.fTN.fTR = "";
            com.tencent.mm.sdk.b.a.urY.m(mnVar);
            k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
            if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, aJ) || kVar == null) {
                obj = null;
            } else {
                if (!bg.mA(aJ.gfi)) {
                    w.i("MicroMsg.UrlHistoryListPresenter", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[]{aJ.gfi, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.aS(this.mContext, aJ.gfi))});
                    if (com.tencent.mm.pluginsdk.model.app.q.aS(this.mContext, aJ.gfi)) {
                        obj = 1;
                    }
                }
                com.tencent.mm.sdk.b.b ghVar = new gh();
                ghVar.fLB.actionCode = 2;
                ghVar.fLB.scene = 1;
                ghVar.fLB.appId = aJ.field_appId;
                ghVar.fLB.context = this.mContext;
                com.tencent.mm.sdk.b.a.urY.m(ghVar);
                intent = new Intent();
                kVar.B(aJ.field_appId, 1, 1);
                obj = 1;
            }
            if (obj != null) {
                return;
            }
            if (ek.fCW == null || ek.fCW.length() == 0) {
                str = cA.field_content;
                if (cA.field_isSend == 0) {
                    i = cA.field_isSend;
                    if (o.dH(this.kwJ) && str != null && i == 0) {
                        str = ay.gj(str);
                    }
                }
                com.tencent.mm.t.f.a ek2 = com.tencent.mm.t.f.a.ek(str);
                f aJ2 = com.tencent.mm.pluginsdk.model.app.g.aJ(ek2.appId, true);
                if (aJ2 == null || !p.n(this.mContext, aJ2.field_packageName)) {
                    str = p.t(this.mContext, ek2.appId, "message");
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                } else if (aJ2.field_status == 3) {
                    w.e("MicroMsg.UrlHistoryListPresenter", "requestAppShow fail, app is in blacklist, packageName = " + aJ2.field_packageName);
                } else if (!p.b(this.mContext, aJ2)) {
                    w.e("MicroMsg.UrlHistoryListPresenter", "The app %s signature is incorrect.", new Object[]{aJ2.field_appName});
                    Toast.makeText(this.mContext, this.mContext.getString(R.l.eoN, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, aJ2, null)}), 1).show();
                } else if (!a(cA, aJ2)) {
                    IMediaObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = ek2.extInfo;
                    if (ek2.fCW != null && ek2.fCW.length() > 0) {
                        com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek2.fCW);
                        wXAppExtendObject.filePath = LW == null ? null : LW.field_fileFullPath;
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.sdkVer = 620757000;
                    wXMediaMessage.mediaObject = wXAppExtendObject;
                    wXMediaMessage.title = ek2.title;
                    wXMediaMessage.description = ek2.description;
                    wXMediaMessage.messageAction = ek2.messageAction;
                    wXMediaMessage.messageExt = ek2.messageExt;
                    wXMediaMessage.thumbData = com.tencent.mm.a.e.c(n.GS().ju(cA.field_imgPath), 0, -1);
                    new ew(this.mContext).a(aJ2.field_packageName, wXMediaMessage, aJ2.field_appId, aJ2.field_openId);
                }
            } else if (AZ()) {
                Intent intent2 = new Intent();
                intent2.setClassName(this.mContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                intent2.putExtra("app_msg_id", cA.field_msgId);
                this.mContext.startActivity(intent2);
            } else {
                com.tencent.mm.ui.base.s.eP(this.mContext);
            }
        }
    }

    public final void c(a aVar) {
        ap.yY();
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(c.wT().cA(aVar.fGM).field_content);
        Object obj = ek.hhT;
        if (TextUtils.isEmpty(obj)) {
            obj = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uh(ek.url);
        }
        if (TextUtils.isEmpty(obj)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", m.xL());
            intent.putExtra("rawUrl", ek.url);
            com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        w.d("MicroMsg.UrlHistoryListPresenter", "start emoji detail from brandcontact");
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", obj);
        intent2.putExtra("preceding_scence", 123);
        intent2.putExtra("download_entrance_scene", 23);
        com.tencent.mm.bb.d.b(this.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        com.tencent.mm.plugin.report.service.g.oUh.i(10993, new Object[]{Integer.valueOf(2), obj});
    }

    public final void d(a aVar) {
        ap.yY();
        ce cA = c.wT().cA(aVar.fGM);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
        int i = ek.tid;
        String str = ek.hjB;
        String str2 = ek.desc;
        String str3 = ek.iconUrl;
        String str4 = ek.secondUrl;
        int i2 = ek.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", b.f(cA, o.dH(this.kwJ)));
            intent.putExtra("rawUrl", ek.gxD);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 23);
            com.tencent.mm.bb.d.b(this.mContext, "emoji", ".ui.EmojiStoreTopicUI", intent);
            return;
        }
        w.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
    }

    public final void e(a aVar) {
        ap.yY();
        ce cA = c.wT().cA(aVar.fGM);
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
        int i = ek.tid;
        String str = ek.hjB;
        String str2 = ek.desc;
        String str3 = ek.iconUrl;
        String str4 = ek.secondUrl;
        int i2 = ek.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", b.f(cA, o.dH(this.kwJ)));
            intent.putExtra("rawUrl", ek.gxD);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            com.tencent.mm.bb.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            return;
        }
        w.i("MicroMsg.UrlHistoryListPresenter", "topic id is zero.");
    }

    private boolean a(au auVar, f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        w.d("MicroMsg.UrlHistoryListPresenter", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", at(this.mContext, "com.tencent.mobileqq"));
        intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        ap.yY();
        Object obj = c.vr().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
            }
        }
        try {
            this.mContext.startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String at(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
        }
        return null;
    }

    private static PackageInfo az(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(str, true);
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
                w.printErrStackTrace("MicroMsg.UrlHistoryListPresenter", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
