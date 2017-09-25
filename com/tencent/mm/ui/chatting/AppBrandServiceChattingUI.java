package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.kd;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.e.a.mt;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.q;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class AppBrandServiceChattingUI extends MMFragmentActivity {
    public q vxO;
    public ae vxP = new ae();

    @SuppressLint({"ValidFragment"})
    public static class a extends com.tencent.mm.ui.chatting.En_5b8fbb1e.a {
        public String appId;
        public int fromScene;
        private String iRW;
        private String iRX;
        private String iRY;
        private boolean iRZ;
        private int iSa;
        public WxaExposedParams jjq;
        public String jmd;
        public OnCreateContextMenuListener oKJ;
        public boolean vxS;
        private String vxT = "";
        private c<kj> vxU;
        private com.tencent.mm.ui.d.c vxV;
        public com.tencent.mm.ui.d.a vxW;

        public a(byte b) {
            super(true);
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            String str = "app_brand_chatting_expose_params";
            Parcelable parcelable = null;
            if (this.uPP && bPj() != null) {
                parcelable = bPj().getIntent().getParcelableExtra(str);
            }
            if (parcelable == null && this.oW != null) {
                parcelable = this.oW.getParcelable(str);
            }
            this.jjq = (WxaExposedParams) parcelable;
            this.jmd = bg.mz(getStringExtra("key_scene_id"));
            this.iRW = getStringExtra("sendMessageTitle");
            this.iRX = getStringExtra("sendMessagePath");
            this.iRY = getStringExtra("sendMessageImg");
            this.iRZ = aS("showMessageCard", false).booleanValue();
            this.iSa = getIntExtra("isBitmapFrom", 1);
            w.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", Integer.valueOf(this.fromScene));
            w.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", this.jjq);
            w.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, isBitmapFrom:%d", this.jmd, this.iRW, this.iRX, this.iRY, Boolean.valueOf(this.iRZ), Integer.valueOf(this.iSa));
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            if (this.fromScene == 2) {
                ap.vd().a(new k(bUg(), 19, getStringExtra("key_temp_session_from")), 0);
                w.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            this.vxU = new c<kj>(this) {
                final /* synthetic */ a vxX;

                {
                    this.vxX = r2;
                    this.usg = kj.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    boolean z = false;
                    kj kjVar = (kj) bVar;
                    if (kjVar.fQM == null || kjVar.fQM.fCJ == null) {
                        w.e("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent event is empty");
                        return false;
                    }
                    w.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent username:%s,event.brandId:%s,event.newValue:%d", this.vxX.fOK.field_username, kjVar.fQM.fCJ, Integer.valueOf(kjVar.fQM.fQN));
                    if (!kjVar.fQM.fCJ.equals(this.vxX.fOK.field_username)) {
                        return true;
                    }
                    a aVar = this.vxX;
                    if ((kjVar.fQM.fQN & 2) > 0) {
                        z = true;
                    }
                    aVar.vxS = z;
                    this.vxX.uSU.uTo.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 vxY;

                        {
                            this.vxY = r1;
                        }

                        public final void run() {
                            if (this.vxY.vxX.vxS) {
                                w.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.Visible", Boolean.valueOf(this.vxY.vxX.vxS));
                                this.vxY.vxX.AX(0);
                                return;
                            }
                            w.d("MicroMsg.AppBrandServiceChattingUI", "OnWxaOptionsChangedEvent refuse:%b, setRejectIcon View.GONE", Boolean.valueOf(this.vxY.vxX.vxS));
                            this.vxY.vxX.AX(8);
                        }
                    });
                    return true;
                }
            };
            com.tencent.mm.sdk.b.a.urY.b(this.vxU);
        }

        public final void bTD() {
            boolean z;
            super.bTD();
            this.nxh.bFo();
            this.nxh.bFw();
            this.nxh.bFI();
            this.nxh.bFL();
            this.nxh.bFB();
            this.nxh.bFx();
            this.nxh.bFz();
            this.nxh.bFA();
            this.nxh.bFy();
            this.nxh.bFB();
            this.nxh.bFx();
            this.nxh.bFK();
            this.nxh.anO();
            this.nxh.bFC();
            this.nxh.bFD();
            this.nxh.jD(true);
            this.nxh.jE(true);
            this.nxh.bFE();
            this.nxh.bFF();
            this.nxh.bFG();
            this.nxh.bFA();
            this.nxh.bFH();
            this.nxh.jC(d.bGP());
            WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(this.fOK.field_username);
            if (og == null || (og.field_appOpt & 2) <= 0) {
                z = false;
            } else {
                z = true;
            }
            this.vxS = z;
            this.appId = og == null ? null : og.field_appId;
            if (this.vxS) {
                AX(0);
            } else {
                AX(8);
            }
            if (this.fromScene == 2) {
                String str = this.appId;
                String str2 = this.fOK.field_username;
                int i = this.fromScene;
                ap.yY();
                aj Rm = com.tencent.mm.u.c.wW().Rm(str2);
                if (Rm == null) {
                    w.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", str2);
                } else {
                    int i2 = Rm.field_unReadCount;
                    String mz = bg.mz(this.jmd);
                    w.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), str, Integer.valueOf(i), Integer.valueOf(i2), mz);
                    g.oUh.i(13799, str, Integer.valueOf(i), Integer.valueOf(i2), mz, Long.valueOf(bg.Ny()));
                }
            }
            this.vxW = new com.tencent.mm.ui.d.a(this.uSU.uTo);
        }

        protected final void bTE() {
            super.bTE();
            zj(R.l.dFZ);
            if (TextUtils.isEmpty(this.vxT)) {
                this.vxT = com.tencent.mm.ui.d.b.ST(com.tencent.mm.ui.d.b.SS(this.fOK.field_username));
            }
            if (TextUtils.isEmpty(this.vxT)) {
                zj(R.l.dFZ);
            } else {
                SE(getResources().getString(R.l.dFZ) + "-" + this.vxT);
            }
        }

        protected final void bTF() {
            qP(this.fOK.field_nickname);
            if (this.vxS) {
                AX(0);
            } else {
                AX(8);
            }
        }

        protected final void bTG() {
            a(0, R.l.dEX, R.g.bhb, new o(this) {
                final /* synthetic */ a vxX;

                {
                    this.vxX = r1;
                }

                public final void bsU() {
                    int i;
                    boolean are = this.vxX.are();
                    Runnable anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 vxZ;

                        {
                            this.vxZ = r1;
                        }

                        public final void run() {
                            String str;
                            String SS = com.tencent.mm.ui.d.b.SS(this.vxZ.vxX.fOK.field_username);
                            if (TextUtils.isEmpty(SS)) {
                                SS = this.vxZ.vxX.fOK.field_username;
                                str = this.vxZ.vxX.fOK.field_nickname;
                            } else {
                                str = com.tencent.mm.ui.d.b.ST(SS);
                            }
                            this.vxZ.vxX.vxW.username = this.vxZ.vxX.fOK.field_username;
                            this.vxZ.vxX.vxW.veP = false;
                            this.vxZ.vxX.vxW.scene = this.vxZ.vxX.fromScene;
                            this.vxZ.vxX.vxW.veO = this.vxZ.vxX.jmd;
                            if (this.vxZ.vxX.fromScene == 2) {
                                this.vxZ.vxX.vxW.jjq = this.vxZ.vxX.jjq;
                                if (this.vxZ.vxX.vxS) {
                                    this.vxZ.vxX.vxW.show(1);
                                    return;
                                } else {
                                    this.vxZ.vxX.vxW.show(2);
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                            aVar.appId = this.vxZ.vxX.appId;
                            aVar.fFr = 4;
                            aVar.username = SS;
                            aVar.fFa = str;
                            this.vxZ.vxX.vxW.jjq = aVar.RL();
                            this.vxZ.vxX.vxW.appId = this.vxZ.vxX.appId;
                            if (this.vxZ.vxX.vxS) {
                                this.vxZ.vxX.vxW.show(5);
                            } else {
                                this.vxZ.vxX.vxW.show(6);
                            }
                        }
                    };
                    if (are) {
                        i = 100;
                    } else {
                        i = 0;
                    }
                    af.f(anonymousClass1, (long) i);
                }
            });
            ks(true);
        }

        protected final void bTH() {
            super.bTH();
            this.oKJ = new OnCreateContextMenuListener(this) {
                final /* synthetic */ a vxX;

                {
                    this.vxX = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    w.d("MicroMsg.AppBrandServiceChattingUI", "menuListener onCreateCotextMenuListener");
                    if (view != null) {
                        dt dtVar = (dt) view.getTag();
                        if (dtVar != null) {
                            int i = dtVar.position;
                            au auVar = (au) this.vxX.vBD.getItem(i);
                            if (auVar == null) {
                                w.e("MicroMsg.AppBrandServiceChattingUI", "msg is null!");
                                return;
                            }
                            if (auVar.bMk()) {
                                contextMenu.add(i, 102, 0, this.vxX.zt(R.l.dTn));
                                contextMenu.add(i, 108, 0, view.getContext().getString(R.l.eLH));
                                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                                if (com.tencent.mm.pluginsdk.model.app.g.L(this.vxX.uSU.uTo, auVar.field_type)) {
                                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
                                }
                            }
                            if (auVar.bMh()) {
                                ap.yY();
                                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                                    contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, view.getContext().getString(R.l.eLH));
                                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                                    b ddVar = new dd();
                                    ddVar.fGW.fGM = auVar.field_msgId;
                                    com.tencent.mm.sdk.b.a.urY.m(ddVar);
                                    if (ddVar.fGX.fGu || com.tencent.mm.pluginsdk.model.app.g.L(this.vxX.uSU.uTo, auVar.field_type)) {
                                        contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
                                    }
                                    com.tencent.mm.ah.d dVar = null;
                                    if (auVar.field_msgId > 0) {
                                        dVar = n.GS().aj(auVar.field_msgId);
                                    }
                                    if (d.Jt("photoedit") && r1.status != -1) {
                                        int width;
                                        int height;
                                        MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dTN));
                                        int[] iArr = new int[2];
                                        if (view != null) {
                                            width = view.getWidth();
                                            height = view.getHeight();
                                            view.getLocationInWindow(iArr);
                                        } else {
                                            height = 0;
                                            width = 0;
                                        }
                                        Intent intent = new Intent();
                                        intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                                        add.setIntent(intent);
                                    }
                                }
                            }
                            if (auVar.axO()) {
                                contextMenu.add(i, 111, 0, this.vxX.zt(R.l.eLH));
                                String str = auVar.field_content;
                                if (str != null) {
                                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
                                    if (ek == null) {
                                        return;
                                    }
                                    if (ek.type == 5) {
                                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eGa));
                                    }
                                } else {
                                    return;
                                }
                            }
                            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
                            contextMenu.add(i, 122, 0, this.vxX.zt(R.l.dUs));
                        }
                    }
                }
            };
            this.vBD.vEW = new cx(this, this, bUg()) {
                final /* synthetic */ a vxX;

                public final void onClick(View view) {
                    w.d("MicroMsg.AppBrandServiceChattingUI", "clickListener ChattingListClickListener onClick");
                    dt dtVar = (dt) view.getTag();
                    switch (dtVar.knu) {
                        case 6:
                            super.onClick(view);
                            return;
                        default:
                            ce ceVar = dtVar.fTk;
                            if (ceVar != null) {
                                if (ceVar.bMh()) {
                                    super.onClick(view);
                                    return;
                                } else if (dtVar.knu == 0 && ceVar.axO()) {
                                    String str = ceVar.field_content;
                                    if (str != null) {
                                        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
                                        if (ek == null) {
                                            return;
                                        }
                                        if (this.vxX.fromScene == 2 && ek.type == 33 && this.vxX.jjq.appId.equals(ek.hjN)) {
                                            Intent intent = new Intent();
                                            intent.putExtra("keyOutPagePath", ek.hjL);
                                            this.vxX.bPj().setResult(-1, intent);
                                            this.vxX.finish();
                                            return;
                                        }
                                        super.onClick(view);
                                        return;
                                    }
                                    return;
                                } else if (dtVar.knu == 5 && ceVar.field_isSend == 1) {
                                    super.onClick(view);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                    }
                }
            };
            this.vBD.vEY = new cz(this, this.vBD.oKJ, this) {
                public int kaQ;
                public int kaR;
                final /* synthetic */ a vxX;
                public View vya;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean onLongClick(android.view.View r8) {
                    /*
                    r7 = this;
                    r6 = 1;
                    r0 = "MicroMsg.AppBrandServiceChattingUI";
                    r1 = "longClickListener ChattingListClickListener onLongClick";
                    com.tencent.mm.sdk.platformtools.w.d(r0, r1);
                    r0 = r8.getTag();
                    r0 = r0 instanceof com.tencent.mm.ui.chatting.dt;
                    if (r0 == 0) goto L_0x0023;
                L_0x0012:
                    r0 = r8.getTag();
                    r0 = (com.tencent.mm.ui.chatting.dt) r0;
                    r1 = r0.knu;
                    if (r1 != r6) goto L_0x001d;
                L_0x001c:
                    return r6;
                L_0x001d:
                    r0 = r0.knu;
                    r1 = 9;
                    if (r0 == r1) goto L_0x001c;
                L_0x0023:
                    r0 = com.tencent.mm.R.h.cJw;
                    r0 = r8.getTag(r0);
                    r0 = r0 instanceof int[];
                    if (r0 == 0) goto L_0x0055;
                L_0x002d:
                    r0 = com.tencent.mm.R.h.cJw;
                    r0 = r8.getTag(r0);
                    r0 = (int[]) r0;
                    r1 = r0;
                    r1 = (int[]) r1;
                    r0 = new com.tencent.mm.ui.widget.g;
                    r2 = r7.vxX;
                    r2 = r2.uSU;
                    r2 = r2.uTo;
                    r0.<init>(r2);
                    r2 = r7.vxX;
                    r2 = r2.oKJ;
                    r3 = r7.vxX;
                    r3 = r3.nxN;
                    r4 = 0;
                    r4 = r1[r4];
                    r5 = r1[r6];
                    r1 = r8;
                    r0.a(r1, r2, r3, r4, r5);
                    goto L_0x001c;
                L_0x0055:
                    r0 = r7.kaQ;
                    if (r0 != 0) goto L_0x005d;
                L_0x0059:
                    r0 = r7.kaR;
                    if (r0 == 0) goto L_0x0065;
                L_0x005d:
                    r0 = r7.vya;
                    r0 = r0.equals(r8);
                    if (r0 != 0) goto L_0x006e;
                L_0x0065:
                    r0 = new com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$a$5$1;
                    r0.<init>(r7);
                    r8.setOnTouchListener(r0);
                    goto L_0x001c;
                L_0x006e:
                    r0 = new com.tencent.mm.ui.widget.g;
                    r1 = r7.vxX;
                    r1 = r1.uSU;
                    r1 = r1.uTo;
                    r0.<init>(r1);
                    r1 = r7.vxX;
                    r2 = r1.oKJ;
                    r1 = r7.vxX;
                    r3 = r1.nxN;
                    r4 = r7.kaQ;
                    r5 = r7.kaR;
                    r1 = r8;
                    r0.a(r1, r2, r3, r4, r5);
                    goto L_0x001c;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a.5.onLongClick(android.view.View):boolean");
                }
            };
        }

        protected final boolean bTI() {
            b qVar;
            if (this.fromScene == 2) {
                ap.yY();
                com.tencent.mm.storage.ae Rm = com.tencent.mm.u.c.wW().Rm("appbrandcustomerservicemsg");
                if (Rm == null || bg.mA(Rm.field_username)) {
                    w.e("MicroMsg.AppBrandServiceChattingUI", "update Unread: can not find SPUSER_APP_BRAND_SERVICE cvs");
                } else {
                    int i = Rm.field_unReadCount;
                    b nVar = new com.tencent.mm.e.a.n();
                    nVar.fCH.fCJ = this.fOK.field_username;
                    com.tencent.mm.sdk.b.a.urY.m(nVar);
                    w.i("MicroMsg.AppBrandServiceChattingUI", "parUnReadCount:%d, unReadCount:%d", Integer.valueOf(i), Integer.valueOf(nVar.fCI.fCK));
                    Rm.dt(Math.max(0, i - r2));
                    ap.yY();
                    if (com.tencent.mm.u.c.wW().a(Rm, Rm.field_username) == -1) {
                        w.e("MicroMsg.AppBrandServiceChattingUI", "update SPUSER_APP_BRAND_SERVICE cvs unread failed");
                    } else {
                        qVar = new com.tencent.mm.e.a.q();
                        qVar.fCT.fCJ = this.fOK.field_username;
                        qVar.fCT.fCK = 0;
                        com.tencent.mm.sdk.b.a.urY.m(qVar);
                    }
                }
            } else {
                w.i("MicroMsg.AppBrandServiceChattingUI", "writeOpLogAndMarkRead clear AppBrandKvData username:%s", this.fOK.field_username);
                qVar = new com.tencent.mm.e.a.q();
                qVar.fCT.fCJ = this.fOK.field_username;
                qVar.fCT.fCK = 0;
                com.tencent.mm.sdk.b.a.urY.m(qVar);
            }
            return super.bTI();
        }

        public final void onViewAttachedToWindow(View view) {
            super.onViewAttachedToWindow(view);
            if (this.fromScene == 2 && this.iRZ) {
                if (this.vxV == null) {
                    this.vxV = new com.tencent.mm.ui.d.c(aG(), this.nxh.getRootView(), this.nxh, !bg.mA(this.nxh.bFu()));
                    this.vxV.sQr = false;
                }
                if (!bg.mA(this.iRY)) {
                    int xI = (int) xI(75);
                    int xI2 = (int) xI(60);
                    if (!(this.iSa == 4 || this.iRY.startsWith("file://"))) {
                        this.iRY = "file://" + this.iRY;
                    }
                    com.tencent.mm.modelappbrand.a.b.AY().a(this.vxV, this.iRY, null, ((com.tencent.mm.modelappbrand.h) h.h(com.tencent.mm.modelappbrand.h.class)).aL(xI, xI2));
                }
                this.vxV.veY = new com.tencent.mm.ui.d.c.a(this) {
                    final /* synthetic */ a vxX;

                    {
                        this.vxX = r1;
                    }

                    public final void bRy() {
                        this.vxX.are();
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 vyc;

                            {
                                this.vyc = r1;
                            }

                            public final void run() {
                                this.vyc.vxX.bTJ();
                            }
                        });
                    }
                };
                com.tencent.mm.ui.d.c cVar = this.vxV;
                w.d("MicroMsg.AppBrandServiceImageBubble", "show");
                ap.vL().D(new Runnable(cVar) {
                    final /* synthetic */ c vfa;

                    {
                        this.vfa = r1;
                    }

                    public final void run() {
                        this.vfa.veZ.sendEmptyMessage(0);
                    }

                    public final String toString() {
                        return super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
                    }
                });
            }
        }

        public final void bTJ() {
            Bitmap gN;
            com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
            aVar.title = this.iRW;
            aVar.type = 33;
            aVar.hjM = this.jjq.username;
            aVar.hjL = bg.mA(this.iRX) ? this.jjq.iGe : this.iRX;
            aVar.hjN = this.jjq.appId;
            aVar.hjT = this.jjq.izV;
            aVar.hjU = this.jjq.izW;
            aVar.hjP = this.jjq.iGd;
            aVar.hjO = 2;
            aVar.url = this.jjq.iGf;
            aVar.hjV = this.jjq.iconUrl;
            aVar.fUX = "wxapp_" + this.jjq.appId + this.jjq.iGe;
            aVar.fUR = this.jjq.username;
            aVar.fUS = this.jjq.fFa;
            byte[] bArr = new byte[0];
            if (this.iSa == 4) {
                gN = com.tencent.mm.modelappbrand.a.b.AY().gN(this.iRY);
            } else if (bg.mA(this.iRY)) {
                gN = null;
            } else {
                gN = com.tencent.mm.modelappbrand.a.b.AY().gN(this.iRY);
                if (gN == null || gN.isRecycled()) {
                    gN = com.tencent.mm.sdk.platformtools.d.Pg(this.iRY);
                    if (this.iSa != 2) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.iRY);
                        w.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", this.iRY, Boolean.valueOf(deleteFile));
                    }
                }
            }
            if (gN == null || gN.isRecycled()) {
                w.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
            } else {
                w.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gN.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            l.a(aVar, this.appId, this.iRW, this.fOK.field_username, null, bArr);
        }

        private float xI(int i) {
            return TypedValue.applyDimension(1, (float) i, this.uSU.uTo.getResources().getDisplayMetrics());
        }

        public final void onDestroy() {
            super.onDestroy();
            com.tencent.mm.sdk.b.a.urY.c(this.vxU);
        }
    }

    protected void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.R(this);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        if (getIntent().getStringExtra("Chat_User") == null) {
            finish();
            w.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
            return;
        }
        setContentView(R.i.cYO);
        this.vxO = new a((byte) 0);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
        this.vxO.setArguments(extras);
        aR().aV().a(R.h.ckn, this.vxO).commit();
        cO().cP().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            af.f(new Runnable(this) {
                final /* synthetic */ AppBrandServiceChattingUI vxQ;

                {
                    this.vxQ = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.base.g.a(this.vxQ, this.vxQ.getString(R.l.eEr), "", this.vxQ.getString(R.l.eEs), this.vxQ.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 vxR;

                        {
                            this.vxR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.urY.m(new mt());
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 vxR;

                        {
                            this.vxR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.urY.m(new kd());
                        }
                    });
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.permission.a.Nh().Ni();
        bQn();
        this.vxP.post(new Runnable(this) {
            final /* synthetic */ AppBrandServiceChattingUI vxQ;

            {
                this.vxQ = r1;
            }

            public final void run() {
                if (this.vxQ.vxO != null) {
                    e.a(this.vxQ, this.vxQ.vxO.uSU.uTa);
                }
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        w.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", keyEvent);
        if (this.vxO == null || !this.vxO.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }
}
