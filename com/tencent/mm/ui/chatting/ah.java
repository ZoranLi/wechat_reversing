package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.ci;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.modelbiz.f;
import com.tencent.mm.modelbiz.h;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.c.bpl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import java.util.LinkedList;

public abstract class ah {
    protected final int knu;
    protected boolean sXW;
    private final long vBW = 120000;
    public boolean vxp;

    public static class a {
        public ImageView ipv;
        public TextView kxi;
        public CheckBox mfD;
        public View mil;
        public View nRW;
        public ProgressBar oDJ;
        public TextView piH;
        public int type;
        public ViewStub vBX;
        public View vBY;
        public View vBZ;
        public int vCa;
        public long vCb;
        public ImageView vyK;

        public a(int i) {
            this(i, (byte) 0);
        }

        private a(int i, byte b) {
            this.type = i;
            this.vCb = 0;
        }

        public final void dn(View view) {
            this.mil = view;
            this.kxi = (TextView) view.findViewById(R.h.bBA);
            this.ipv = (ImageView) view.findViewById(R.h.bzT);
            this.vBY = view.findViewById(R.h.bAH);
            this.vBZ = view.findViewById(R.h.bAe);
            this.vyK = (ImageView) view.findViewById(R.h.bBw);
            this.vBX = (ViewStub) view.findViewById(R.h.bBs);
        }

        public final void lh(boolean z) {
            int i = z ? 0 : 8;
            if (!(this.mfD == null || this.mfD.getVisibility() == i)) {
                this.mfD.setVisibility(i);
            }
            if (this.nRW != null && this.nRW.getVisibility() != i) {
                this.nRW.setVisibility(i);
            }
        }

        public static void I(View view, int i) {
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.width = i;
                view.setLayoutParams(layoutParams);
                view.requestLayout();
            }
        }
    }

    public static abstract class b extends ah {
        public b(int i) {
            super(i);
        }
    }

    public static abstract class c extends ah {
        public c(int i) {
            super(i);
        }

        protected final boolean a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar) {
            return false;
        }

        protected final String a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
            return aVar.vBD.hrM;
        }
    }

    private static class d implements com.tencent.mm.modelbiz.g.a {
        private String smL;
        public cw vBD;

        protected d(cw cwVar, String str) {
            this.smL = str;
            this.vBD = cwVar;
        }

        public final void c(LinkedList<bpl> linkedList) {
            int i = 0;
            w.DI().b((com.tencent.mm.modelbiz.g.a) this);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
            if (linkedList != null && linkedList.size() > 0) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", Integer.valueOf(linkedList.size()), this.smL);
                if (this.vBD != null) {
                    if (linkedList != null && linkedList.size() != 0) {
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            bpl com_tencent_mm_protocal_c_bpl = (bpl) linkedList.get(i2);
                            if (!(com_tencent_mm_protocal_c_bpl == null || bg.mA(com_tencent_mm_protocal_c_bpl.unQ) || !com_tencent_mm_protocal_c_bpl.unQ.equals(this.smL))) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                                if (!bg.mA(com_tencent_mm_protocal_c_bpl.tNz)) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChattingItem", "needCallback: true");
                                    i = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (i != 0) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ d vCc;

                            {
                                this.vCc = r1;
                            }

                            public final void run() {
                                this.vCc.vBD.notifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        }

        public final String Dz() {
            return this.smL;
        }
    }

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str);

    public abstract boolean a(ContextMenu contextMenu, View view, au auVar);

    public abstract boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar);

    public abstract boolean a(View view, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar);

    public ah(int i) {
        this.knu = i;
    }

    public final int bUo() {
        return this.knu;
    }

    public static void o(ImageView imageView, String str) {
        if (bg.mA(str)) {
            imageView.setImageResource(R.g.bes);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        }
    }

    public static int eT(Context context) {
        float dI = com.tencent.mm.bg.a.dI(context);
        if (dI == 0.875f) {
            return com.tencent.mm.bg.a.U(context, R.f.aZi);
        }
        if (dI == 1.125f) {
            return com.tencent.mm.bg.a.U(context, R.f.aZe);
        }
        if (dI == 1.25f) {
            return com.tencent.mm.bg.a.U(context, R.f.aZj);
        }
        if (dI == 1.375f) {
            return com.tencent.mm.bg.a.U(context, R.f.aZc);
        }
        if (dI == 1.625f || dI == 1.875f || dI == 2.025f) {
            return com.tencent.mm.bg.a.U(context, R.f.aZd);
        }
        return com.tencent.mm.bg.a.U(context, R.f.aZh);
    }

    public static int eU(Context context) {
        float dI = com.tencent.mm.bg.a.dI(context);
        if (!(dI == 0.875f || dI == 1.125f)) {
            if (dI == 1.25f) {
                return com.tencent.mm.bg.a.U(context, R.f.aZb);
            }
            if (dI == 1.375f) {
                return com.tencent.mm.bg.a.U(context, R.f.aYZ);
            }
            if (dI == 1.625f || dI == 1.875f || dI == 2.025f) {
                return com.tencent.mm.bg.a.U(context, R.f.aZd);
            }
        }
        return com.tencent.mm.bg.a.U(context, R.f.aZa);
    }

    public static void p(ImageView imageView, String str) {
        if (bg.mA(str)) {
            imageView.setImageResource(R.g.bcY);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str);
        }
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, boolean z) {
        this.sXW = z;
        String str = null;
        if (bUp()) {
            str = a(aVar2, auVar);
            a(aVar, aVar2, auVar, str);
            a(aVar, aVar2, str, auVar);
        }
        a(aVar, i, aVar2, auVar, str);
    }

    protected boolean bUp() {
        return true;
    }

    protected void a(a aVar, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str) {
        if (str != null && aVar.piH != null && auVar != null) {
            CharSequence charSequence = null;
            if (auVar.field_isSend == 0 && !bg.mA(auVar.gxN)) {
                f ig = w.DG().ig(auVar.gxN);
                Object obj = 1;
                if (ig == null || bg.mA(ig.field_openId) || bg.mA(ig.field_nickname)) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                } else {
                    charSequence = ig.field_nickname;
                    obj = null;
                }
                if (obj != null || h.a(ig)) {
                    w.DI().a(new d(aVar2.vBD, auVar.gxN));
                    w.DI().U(aVar2.vBD.fJL, auVar.gxN);
                }
            } else if (a(aVar2) && aVar2.vJi) {
                charSequence = aVar2.vJa ? com.tencent.mm.pluginsdk.ui.d.h.b(aVar2.uSU.uTo, aVar2.eK(auVar.field_bizChatUserId), aVar.piH.getTextSize()) : com.tencent.mm.pluginsdk.ui.d.h.b(aVar2.uSU.uTo, aVar2.eK(str), aVar.piH.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a r4, com.tencent.mm.storage.au r5) {
        /*
        r3 = this;
        r0 = r4.vBD;
        r1 = r0.fJL;
        r0 = r3.a(r4);
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r4.vBH;
        if (r0 == 0) goto L_0x0021;
    L_0x000f:
        r0 = r5.field_content;
        r0 = com.tencent.mm.u.ay.gi(r0);
        if (r1 == 0) goto L_0x0026;
    L_0x0017:
        if (r0 == 0) goto L_0x0026;
    L_0x0019:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0026;
    L_0x001f:
        r1 = r0;
        goto L_0x000a;
    L_0x0021:
        if (r5 == 0) goto L_0x0026;
    L_0x0023:
        r0 = r5.field_bizChatUserId;
        goto L_0x001f;
    L_0x0026:
        r0 = r1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ah.a(com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.storage.au):java.lang.String");
    }

    protected static String b(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        String str = auVar.field_talker;
        if (!aVar.sMK || aVar.vve == null) {
            return str;
        }
        return aVar.vve.field_bizChatServId;
    }

    public static String a(au auVar, boolean z, boolean z2) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            return m.xL();
        }
        if (z) {
            str = ay.gi(auVar.field_content);
        } else if (z2) {
            str = auVar.field_bizChatUserId;
        }
        if (bg.mA(str)) {
            return auVar.field_talker;
        }
        return str;
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.piH != null) {
            if (charSequence == null) {
                aVar.piH.setVisibility(8);
                return;
            }
            aVar.piH.setText(charSequence);
            aVar.piH.setVisibility(0);
        }
    }

    protected static void a(a aVar, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, String str, au auVar) {
        String str2 = null;
        if (aVar.ipv != null) {
            if (!o.fE(str) || str.equals(o.hly[0])) {
                Object obj;
                dt dtVar;
                if (auVar != null && !bg.mA(auVar.gxN)) {
                    if (aVar2.vBH) {
                        str2 = aVar2.bUg();
                    }
                    dtVar = new dt(str, 9, str2);
                    dtVar.vNb = auVar.gxN;
                    com.tencent.mm.pluginsdk.ui.a.b.g(aVar.ipv, auVar.gxN, R.g.bcB);
                    obj = dtVar;
                } else if (auVar == null || !aVar2.sMK) {
                    if (aVar2.vBH) {
                        str2 = aVar2.bUg();
                    }
                    dtVar = new dt(str, 1, str2);
                    o(aVar.ipv, str);
                    r0 = dtVar;
                } else {
                    dtVar = new dt(auVar.field_bizChatUserId, 1, null);
                    n.GW().a(aVar2.iu(auVar.field_bizChatUserId), aVar.ipv, aVar2.vBD.kwq);
                    r0 = dtVar;
                }
                aVar.ipv.setVisibility(0);
                aVar.ipv.setTag(obj);
                be.do(aVar.ipv);
                aVar.ipv.setOnClickListener(aVar2.vBD.vEW);
                aVar.ipv.setOnLongClickListener(aVar2.vBD.vEY);
                aVar.ipv.setContentDescription(com.tencent.mm.u.n.eK(str) + aVar2.uSU.uTo.getString(R.l.dJn));
                if (aVar.vBX == null) {
                    return;
                }
                if (auVar.gxF == null || !auVar.gxF.contains("watch_msg_source_type")) {
                    aVar.vBX.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) bh.q(auVar.gxF, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    aVar.vBX.setVisibility(8);
                    return;
                } else {
                    aVar.vBX.setVisibility(0);
                    return;
                }
            }
            aVar.ipv.setVisibility(8);
        }
    }

    protected boolean a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar) {
        return aVar.vBH || aVar.sMK;
    }

    protected static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, View view, String str) {
        if (g.LY(str)) {
            Object bVar = new com.tencent.mm.pluginsdk.ui.chat.k.b();
            bVar.appId = str;
            bVar.fTm = "message";
            a(aVar, view, bVar);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.k.b());
    }

    protected static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, View view, au auVar, com.tencent.mm.t.f.a aVar2, String str, long j) {
        if (g.LY(aVar2.appId)) {
            int i = aVar.vxp ? 2 : 1;
            Object aVar3 = new com.tencent.mm.pluginsdk.ui.chat.k.a();
            aVar3.appId = aVar2.appId;
            aVar3.fTm = "message";
            aVar3.fwP = str;
            aVar3.fTJ = c(aVar, auVar);
            aVar3.sQw = aVar2.type;
            aVar3.scene = i;
            aVar3.sQx = aVar2.mediaTagName;
            aVar3.fTQ = j;
            a(aVar, view, aVar3);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.k.b());
    }

    private static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.vBD.vFe);
    }

    protected static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, ImageView imageView, String str) {
        Bitmap b = g.b(str, 2, com.tencent.mm.bg.a.getDensity(aVar.uSU.uTo));
        if (b == null || b.isRecycled()) {
            a(aVar, imageView, BitmapFactory.decodeResource(aVar.getResources(), R.g.bhT));
        } else {
            a(aVar, imageView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, ImageView imageView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(R.f.aXW);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    protected static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, TextView textView, String str) {
        Bitmap b = g.b(str, 2, com.tencent.mm.bg.a.getDensity(aVar.uSU.uTo));
        if (b == null || b.isRecycled()) {
            a(aVar, textView, BitmapFactory.decodeResource(aVar.getResources(), R.g.bhT));
        } else {
            a(aVar, textView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.getResources().getDimension(R.f.aXW);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected static void b(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.vBD.vEW);
    }

    protected static void c(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(aVar.vBD.vFi);
    }

    public final boolean a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, com.tencent.mm.t.f.a aVar2, au auVar) {
        if (bg.mA(aVar2.hjD)) {
            return false;
        }
        a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, auVar, aVar2.hjK, aVar2.hjJ);
        String str = auVar.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", aVar2.hjD);
        intent.putExtra("KThumUrl", aVar2.hjI);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", aVar2.hjJ);
        intent.putExtra("KSta_StremVideoPublishId", aVar2.hjK);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", aVar.vBH ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
        intent.putExtra("KSta_FromUserName", a(aVar, auVar));
        intent.putExtra("KSta_ChatName", aVar.bUg());
        intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", aVar2.fUY);
        if (aVar.vBH) {
            intent.putExtra("KSta_ChatroomMembercount", j.eC(aVar.bUg()));
        }
        intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
        intent.putExtra("KMediaVideoTime", aVar2.hjE);
        intent.putExtra("StremWebUrl", aVar2.hjH);
        intent.putExtra("StreamWording", aVar2.hjG);
        intent.putExtra("KMediaTitle", aVar2.title);
        com.tencent.mm.bb.d.b(aVar.uSU.uTo, "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    protected final void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, au auVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (am.isMobile(aVar.uSU.uTo) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", aVar.bUg());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", a(aVar, auVar));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (auVar != null) {
            intent.putExtra("preUsername", a(aVar, auVar));
        }
        intent.putExtra("preChatName", aVar.bUg());
        intent.putExtra("preChatTYPE", p.G(a(aVar, auVar), aVar.bUg()));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bb.d.b(aVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
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
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.ChattingItem", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    protected static void a(int i, a aVar, au auVar, String str, boolean z, cx cxVar) {
        if (auVar.field_isSend == 1) {
            int i2;
            aVar.vyK.setTag(new dt(auVar, z, i, str, 5, (byte) 0));
            aVar.vyK.setOnClickListener(cxVar);
            switch (auVar.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.g.bkk;
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                aVar.vyK.setImageResource(i2);
                aVar.vyK.setVisibility(0);
                aVar.vyK.setContentDescription(ab.getContext().getString(R.l.eBv));
                if (aVar.oDJ != null) {
                    aVar.oDJ.setVisibility(8);
                    return;
                }
                return;
            }
            aVar.vyK.setVisibility(8);
        }
    }

    protected static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, com.tencent.mm.t.f.a aVar2, String str, com.tencent.mm.pluginsdk.model.app.f fVar, long j) {
        int i = aVar.vxp ? 2 : 1;
        int i2 = (fVar == null || !com.tencent.mm.pluginsdk.model.app.p.n(aVar.uSU.uTo, fVar.field_packageName)) ? 6 : 3;
        if (aVar2.type == 2) {
            i2 = 4;
        } else if (aVar2.type == 5) {
            i2 = 1;
        }
        com.tencent.mm.sdk.b.b mnVar = new mn();
        mnVar.fTN.context = aVar.uSU.uTo;
        mnVar.fTN.scene = i;
        mnVar.fTN.fTO = aVar2.appId;
        mnVar.fTN.packageName = fVar == null ? null : fVar.field_packageName;
        mnVar.fTN.msgType = aVar2.type;
        mnVar.fTN.fOu = str;
        mnVar.fTN.fTP = i2;
        mnVar.fTN.mediaTagName = aVar2.mediaTagName;
        mnVar.fTN.fTQ = j;
        mnVar.fTN.fTR = "";
        com.tencent.mm.sdk.b.a.urY.m(mnVar);
    }

    protected static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, com.tencent.mm.t.f.a aVar2, au auVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
        if (kVar != null) {
            int i = aVar.vBH ? 2 : 1;
            kVar.a(aVar.uSU.uTo, aVar2.appId, fVar == null ? null : fVar.field_packageName, c(aVar, auVar), aVar2.type, aVar2.mediaTagName, i);
        }
    }

    protected static void b(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, com.tencent.mm.t.f.a aVar2, au auVar) {
        k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
        if (kVar != null) {
            int i = aVar.vBH ? 2 : 1;
            String c = c(aVar, auVar);
            ActionBarActivity actionBarActivity = aVar.uSU.uTo;
            kVar.a(aVar2.appId, c, aVar2.type, i, aVar2.mediaTagName, auVar.field_msgSvrId);
        }
    }

    protected static boolean a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
        if (g.a(aVar.uSU.uTo, fVar) || kVar == null) {
            return false;
        }
        if (!bg.mA(fVar.gfi)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", fVar.gfi, Boolean.valueOf(q.aS(aVar.uSU.uTo, fVar.gfi)));
            if (q.aS(aVar.uSU.uTo, fVar.gfi)) {
                return true;
            }
        }
        int i = aVar.vxp ? 2 : 1;
        com.tencent.mm.sdk.b.b ghVar = new gh();
        ghVar.fLB.actionCode = 2;
        ghVar.fLB.scene = i;
        ghVar.fLB.appId = fVar.field_appId;
        ghVar.fLB.context = aVar.uSU.uTo;
        com.tencent.mm.sdk.b.a.urY.m(ghVar);
        ActionBarActivity actionBarActivity = aVar.uSU.uTo;
        kVar.B(fVar.field_appId, i, i);
        return true;
    }

    protected static String c(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        String bUg = aVar.bUg();
        if (o.dH(bUg)) {
            return ay.gi(auVar.field_content);
        }
        return bUg;
    }

    public static void v(com.tencent.mm.storage.a.c cVar) {
        com.tencent.mm.sdk.b.b ciVar = new ci();
        ciVar.fFN.fFO = cVar;
        ciVar.fFN.scene = 0;
        com.tencent.mm.sdk.b.a.urY.m(ciVar);
    }

    protected static boolean ao(au auVar) {
        if (System.currentTimeMillis() - auVar.field_createTime > 120000) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(com.tencent.mm.i.g.sV().getInt("ShowRevokeMsgEntry", 1)));
        if (1 == com.tencent.mm.i.g.sV().getInt("ShowRevokeMsgEntry", 1)) {
            return true;
        }
        return false;
    }

    protected static boolean Tn(String str) {
        return !(o.fh(str) || o.fx(str) || o.eV(str) || o.fF(str)) || o.dH(str);
    }

    protected static boolean bUq() {
        String value = com.tencent.mm.i.g.sV().getValue("ShowSendOK");
        if (1 == (bg.mA(value) ? 0 : bg.PY(value))) {
            return true;
        }
        return false;
    }

    protected static boolean a(cw cwVar, long j) {
        if (j > 0) {
            if (cwVar.vFy == -1) {
                cwVar.vFy = 0;
                Cursor cursor = cwVar.getCursor();
                int position = cursor.getPosition();
                int count = cursor.getCount();
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ChattingListAdapter", "curPos %d, curCount %d", Integer.valueOf(position), Integer.valueOf(count));
                if (cursor.moveToLast()) {
                    do {
                        cwVar.vFD = null;
                        cwVar.vFD = cw.a(cwVar.vFD, cursor);
                        if (cwVar.vFD.field_isSend == 1) {
                            if ((cwVar.vFD.gxE & 4) != 4) {
                                cwVar.vFy = cwVar.vFD.field_msgId;
                            }
                        }
                    } while (cursor.moveToPrevious());
                }
                if (count < 0) {
                    if (count > 0) {
                        cursor.moveToPosition(0);
                    }
                } else if (position < count) {
                    cursor.moveToPosition(position);
                } else if (count > 0) {
                    cursor.moveToPosition(count - 1);
                }
            }
            if (cwVar.vFy == j) {
                return true;
            }
        }
        return false;
    }
}
