package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.dz;
import com.tencent.mm.ui.chatting.ew;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.z;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, dz, b {
    private boolean fAG = true;
    private String fJL;
    protected ae handler;
    public long kbc;
    private TextView mfO;
    private Animation pvS;
    public boolean sMK;
    private boolean sXW = false;
    private long vFJ = 0;
    private c vJU = new c<gg>(this) {
        final /* synthetic */ ImageGalleryGridUI vRg;

        {
            this.vRg = r2;
            this.usg = gg.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gg ggVar = (gg) bVar;
            ImageGalleryGridUI.a(this.vRg, ggVar.fLx.fLA, ggVar);
            return false;
        }
    };
    public int vQO;
    private GridView vQP;
    c vQQ;
    private WeakReference<a> vQR;
    private Boolean vQS;
    private Boolean vQT;
    private TextView vQU;
    private Runnable vQV = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI vRg;

        {
            this.vRg = r1;
        }

        public final void run() {
            if (this.vRg.vQP != null && this.vRg.vQP.getVisibility() != 4) {
                this.vRg.vQP.setVisibility(4);
            }
        }
    };
    private Runnable vQW = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI vRg;

        {
            this.vRg = r1;
        }

        public final void run() {
            if (this.vRg.vQP != null && this.vRg.vQP.getVisibility() != 0) {
                this.vRg.vQP.setVisibility(0);
            }
        }
    };
    private boolean vQX = false;
    Runnable vQY = new Runnable(this) {
        final /* synthetic */ ImageGalleryGridUI vRg;

        {
            this.vRg = r1;
        }

        @TargetApi(12)
        public final void run() {
            if (this.vRg.vQZ != null) {
                this.vRg.vQZ.setVisibility(8);
                this.vRg.vQZ = null;
            }
        }
    };
    public View vQZ = null;
    private View vRa;
    private int vRb = -1;
    private View vRc;
    private View vRd;
    private View vRe;
    private View vRf;

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i, gg ggVar) {
        if (imageGalleryGridUI.vQP != null) {
            int firstVisiblePosition = imageGalleryGridUI.vQP.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.vQP.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.vQP.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    ggVar.fLy.fEb = iArr[0];
                    ggVar.fLy.fEc = iArr[1];
                    ggVar.fLy.fEd = childAt.getWidth();
                    ggVar.fLy.fEe = childAt.getHeight();
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.bWQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vQX = true;
        this.handler = new ae();
        By(0);
        com.tencent.mm.sdk.b.a.urY.b(this.vJU);
    }

    protected final boolean bPO() {
        return true;
    }

    protected void onDestroy() {
        this.handler.removeCallbacks(this.vQW);
        this.handler = null;
        n.GW().bi(0);
        com.tencent.mm.sdk.b.a.urY.c(this.vJU);
        super.onDestroy();
    }

    protected void onResume() {
        a.vRJ.a(this);
        this.fAG = false;
        if (this.vQX) {
            if (a.vRJ.vRH) {
                bWu();
            } else {
                bWv();
            }
        }
        this.handler.postDelayed(this.vQW, 300);
        super.onResume();
        if (this.vQQ != null) {
            this.vQQ.vQH = true;
            c cVar = this.vQQ;
            if (cVar.vQH) {
                cVar.notifyDataSetChanged();
            }
            if (a.vRJ.vRH) {
                qP(getString(R.l.eoc, new Object[]{Integer.valueOf(a.vRJ.vQg.size())}));
            }
        }
        this.vQX = false;
        bWP();
    }

    protected void onPause() {
        g gVar = a.vRJ;
        if (this != null) {
            gVar.vRI.remove(this);
        }
        this.fAG = true;
        super.onPause();
    }

    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        By(1);
    }

    public void onBackPressed() {
        if (a.vRJ.vRH) {
            bWv();
        } else if (this.vQS.booleanValue()) {
            super.onBackPressed();
        } else {
            if (this.vQO >= 0) {
                K(null, this.vQO);
            }
            finish();
        }
    }

    @TargetApi(11)
    private void By(int i) {
        Intent intent = getIntent();
        this.vQS = Boolean.valueOf(intent.getIntExtra("kintent_intent_source", 0) == 1);
        this.fJL = intent.getStringExtra("kintent_talker");
        this.vQO = intent.getIntExtra("kintent_image_index", 0);
        this.sMK = intent.getBooleanExtra("key_is_biz_chat", false);
        this.kbc = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.vQT = Boolean.valueOf(true);
        qP(getString(R.l.dDa));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ImageGalleryGridUI vRg;

            {
                this.vRg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vRg.onBackPressed();
                return true;
            }
        });
        this.vRa = findViewById(R.h.clg);
        View findViewById = findViewById(R.h.bNZ);
        this.vRc = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.cJD);
        this.vRd = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.czB);
        this.vRe = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.bev);
        this.vRf = findViewById;
        findViewById.setOnClickListener(this);
        this.mfO = (TextView) findViewById(R.h.bom);
        this.vQU = (TextView) findViewById(R.h.bok);
        if (i == 0) {
            this.vQP = (GridView) findViewById(R.h.bWQ);
            this.vQP.setOnItemClickListener(this);
            this.vQP.setNumColumns(3);
            au auVar = new au();
            if (this.sMK) {
                auVar.A(this.kbc);
            }
            this.vQQ = new c(this, auVar, this.fJL);
            if (this.vQQ.getCount() == 0) {
                this.vQU.setVisibility(0);
                return;
            }
            this.vQU.setVisibility(8);
            this.vQP.setAdapter(this.vQQ);
            bWO();
        } else if (this.vQQ != null) {
            this.vQQ.notifyDataSetChanged();
            bWO();
        }
        this.vQP.setOnScrollListener(new OnScrollListener(this) {
            private Runnable mgt = new Runnable(this) {
                final /* synthetic */ AnonymousClass6 vRi;

                {
                    this.vRi = r1;
                }

                public final void run() {
                    this.vRi.vRg.mfO.startAnimation(AnimationUtils.loadAnimation(this.vRi.vRg.uSU.uTo, R.a.aQY));
                    this.vRi.vRg.mfO.setVisibility(8);
                }
            };
            final /* synthetic */ ImageGalleryGridUI vRg;

            {
                this.vRg = r2;
            }

            private void et(boolean z) {
                if (z) {
                    this.vRg.mfO.removeCallbacks(this.mgt);
                    if (this.vRg.mfO.getVisibility() != 0) {
                        this.vRg.mfO.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.vRg.uSU.uTo, R.a.aQX);
                        this.vRg.mfO.setVisibility(0);
                        this.vRg.mfO.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                this.vRg.mfO.removeCallbacks(this.mgt);
                this.vRg.mfO.postDelayed(this.mgt, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    et(true);
                } else if (i == 0) {
                    et(false);
                }
                n.GW().bi(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CharSequence charSequence;
                Context context = this.vRg;
                au auVar = (au) context.vQQ.getItem(i);
                if (auVar == null) {
                    charSequence = null;
                } else {
                    charSequence = com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(auVar.field_createTime), context);
                }
                this.vRg.mfO.setText(charSequence);
            }
        });
    }

    private void bWO() {
        int firstVisiblePosition = this.vQP.getFirstVisiblePosition();
        int lastVisiblePosition = this.vQP.getLastVisiblePosition();
        int i = this.vQO;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.vQP.setSelection(i);
        }
    }

    public void finish() {
        super.finish();
        a.vRJ.detach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f.a B;
        au auVar = (au) this.vQQ.getItem(i);
        String str = auVar.field_content;
        if (str != null) {
            B = f.a.B(str, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null && B.type == 6) {
            be(auVar);
        } else if (B != null && B.type == 3) {
            str = p.s(B.url, "message");
            r3 = p.s(B.hhp, "message");
            PackageInfo az = az(this.uSU.uTo, B.appId);
            r4 = az == null ? null : az.versionName;
            r1 = az == null ? 0 : az.versionCode;
            String str2 = B.appId;
            r6 = auVar.field_msgId;
            long j2 = auVar.field_msgSvrId;
            if ((str == null || str.length() == 0) && (r3 == null || r3.length() == 0)) {
                w.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                return;
            }
            if (am.isMobile(this.uSU.uTo) ? r3 != null && r3.length() > 0 : str == null || str.length() <= 0) {
                str = r3;
            }
            Intent intent = new Intent();
            intent.putExtra("msg_id", r6);
            intent.putExtra("rawUrl", str);
            intent.putExtra("version_name", r4);
            intent.putExtra("version_code", r1);
            intent.putExtra("usePlugin", true);
            intent.putExtra("geta8key_username", this.fJL);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
            intent.putExtra("KAppId", str2);
            r1 = bd(auVar);
            intent.putExtra("pre_username", r1);
            intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
            if (auVar != null) {
                intent.putExtra("preUsername", r1);
            }
            intent.putExtra("preChatName", this.fJL);
            intent.putExtra("preChatTYPE", com.tencent.mm.u.p.G(r1, this.fJL));
            intent.putExtra("preMsgIndex", 0);
            d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
        } else if (B == null || B.type != 5) {
            Intent intent2;
            if (B != null && B.type == 19) {
                intent2 = new Intent();
                intent2.putExtra("message_id", auVar.field_msgId);
                intent2.putExtra("record_xml", B.hhQ);
                d.b(this.uSU.uTo, "record", ".ui.RecordMsgDetailUI", intent2);
            } else if (B != null && B.type == 24) {
                com.tencent.mm.sdk.b.b kqVar = new kq();
                kqVar.fRi.context = this.uSU.uTo;
                kqVar.fRi.fGM = auVar.field_msgId;
                kqVar.fRi.fRj = B.hhQ;
                com.tencent.mm.sdk.b.a.urY.m(kqVar);
            } else if (B != null && B.type == 7) {
                com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(B.appId, false);
                if (aJ != null && aJ.bCU()) {
                    Object obj;
                    r1 = this.fJL;
                    if (o.dH(r1)) {
                        r1 = ay.gi(auVar.field_content);
                    }
                    r6 = auVar.field_msgSvrId;
                    int i2 = (aJ == null || !p.n(this.uSU.uTo, aJ.field_packageName)) ? 6 : 3;
                    if (B.type == 2) {
                        i2 = 4;
                    } else if (B.type == 5) {
                        i2 = 1;
                    }
                    com.tencent.mm.sdk.b.b mnVar = new mn();
                    mnVar.fTN.context = this.uSU.uTo;
                    mnVar.fTN.scene = 1;
                    mnVar.fTN.fTO = B.appId;
                    mnVar.fTN.packageName = aJ == null ? null : aJ.field_packageName;
                    mnVar.fTN.msgType = B.type;
                    mnVar.fTN.fOu = r1;
                    mnVar.fTN.fTP = i2;
                    mnVar.fTN.mediaTagName = B.mediaTagName;
                    mnVar.fTN.fTQ = r6;
                    mnVar.fTN.fTR = "";
                    com.tencent.mm.sdk.b.a.urY.m(mnVar);
                    k kVar = l.a.sBw;
                    if (g.a(this.uSU.uTo, aJ) || kVar == null) {
                        obj = null;
                    } else {
                        if (!bg.mA(aJ.gfi)) {
                            w.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", aJ.gfi, Boolean.valueOf(q.aS(this.uSU.uTo, aJ.gfi)));
                            if (q.aS(this.uSU.uTo, aJ.gfi)) {
                                obj = 1;
                            }
                        }
                        com.tencent.mm.sdk.b.b ghVar = new gh();
                        ghVar.fLB.actionCode = 2;
                        ghVar.fLB.scene = 1;
                        ghVar.fLB.appId = aJ.field_appId;
                        ghVar.fLB.context = this.uSU.uTo;
                        com.tencent.mm.sdk.b.a.urY.m(ghVar);
                        Intent intent3 = new Intent();
                        kVar.B(aJ.field_appId, 1, 1);
                        obj = 1;
                    }
                    if (obj != null) {
                        return;
                    }
                    if (B.fCW == null || B.fCW.length() == 0) {
                        r1 = auVar.field_content;
                        if (auVar.field_isSend == 0) {
                            i2 = auVar.field_isSend;
                            if (!this.sMK && o.dH(this.fJL) && r1 != null && i2 == 0) {
                                r1 = ay.gj(r1);
                            }
                        }
                        f.a ek = f.a.ek(r1);
                        com.tencent.mm.pluginsdk.model.app.f aJ2 = g.aJ(ek.appId, true);
                        if (aJ2 == null || !p.n(this.uSU.uTo, aJ2.field_packageName)) {
                            r0 = p.t(this.uSU.uTo, ek.appId, "message");
                            intent2 = new Intent();
                            intent2.putExtra("rawUrl", r0);
                            d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
                        } else if (aJ2.field_status == 3) {
                            w.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + aJ2.field_packageName);
                        } else if (!p.b(this.uSU.uTo, aJ2)) {
                            w.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", aJ2.field_appName);
                            Toast.makeText(this.uSU.uTo, getString(R.l.eoN, new Object[]{g.a(this.uSU.uTo, aJ2, null)}), 1).show();
                        } else if (!a(auVar, aJ2)) {
                            IMediaObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = ek.extInfo;
                            if (ek.fCW != null && ek.fCW.length() > 0) {
                                com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
                                wXAppExtendObject.filePath = LW == null ? null : LW.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = 620757000;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = ek.title;
                            wXMediaMessage.description = ek.description;
                            wXMediaMessage.messageAction = ek.messageAction;
                            wXMediaMessage.messageExt = ek.messageExt;
                            wXMediaMessage.thumbData = e.c(n.GS().ju(auVar.field_imgPath), 0, -1);
                            new ew(this).a(aJ2.field_packageName, wXMediaMessage, aJ2.field_appId, aJ2.field_openId);
                        }
                    } else if (this.sXW) {
                        intent2 = new Intent();
                        intent2.setClassName(this.uSU.uTo, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent2.putExtra("app_msg_id", auVar.field_msgId);
                        startActivityForResult(intent2, h.CTRL_INDEX);
                    } else {
                        s.eP(this.uSU.uTo);
                    }
                }
            } else if (auVar.bMl() || auVar.bMh() || auVar.bMm() || auVar.bMp()) {
                if (B == null || bg.mA(B.hjD)) {
                    r0 = null;
                } else {
                    r1 = auVar.field_imgPath;
                    r4 = new Intent();
                    r4.putExtra("IsAd", false);
                    r4.putExtra("KStremVideoUrl", B.hjD);
                    r4.putExtra("KThumUrl", B.hjI);
                    r4.putExtra("KThumbPath", r1);
                    r4.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
                    r4.putExtra("KMediaVideoTime", B.hjE);
                    r4.putExtra("StremWebUrl", B.hjH);
                    r4.putExtra("StreamWording", B.hjG);
                    r4.putExtra("KMediaTitle", B.title);
                    str = auVar.field_talker;
                    boolean endsWith = str.endsWith("@chatroom");
                    r1 = endsWith ? ay.gi(auVar.field_content) : str;
                    r4.putExtra("KSta_StremVideoAduxInfo", B.hjJ);
                    r4.putExtra("KSta_StremVideoPublishId", B.hjK);
                    r4.putExtra("KSta_SourceType", 1);
                    r4.putExtra("KSta_Scene", endsWith ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
                    r4.putExtra("KSta_FromUserName", r1);
                    r4.putExtra("KSta_ChatName", str);
                    r4.putExtra("KSta_MsgId", auVar.field_msgSvrId);
                    r4.putExtra("KSta_SnsStatExtStr", B.fUY);
                    if (endsWith) {
                        r4.putExtra("KSta_ChatroomMembercount", j.eC(str));
                    }
                    d.b(this.uSU.uTo, "sns", ".ui.VideoAdPlayerUI", r4);
                    r0 = 1;
                }
                if (r0 == null) {
                    K(view, i);
                }
            } else if (B != null && B.type == 15) {
                r0 = B.hhT;
                if (TextUtils.isEmpty(r0)) {
                    r0 = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uh(B.url);
                }
                if (TextUtils.isEmpty(r0)) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("geta8key_username", m.xL());
                    intent4.putExtra("rawUrl", B.url);
                    d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent4);
                    return;
                }
                w.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                intent2 = new Intent();
                intent2.putExtra("extra_id", r0);
                intent2.putExtra("preceding_scence", 123);
                intent2.putExtra("download_entrance_scene", 23);
                d.b(this.uSU.uTo, "emoji", ".ui.EmojiStoreDetailUI", intent2);
                com.tencent.mm.plugin.report.service.g.oUh.i(10993, Integer.valueOf(2), r0);
            } else if (B != null && B.type == 26) {
                r1 = B.tid;
                str = B.hjB;
                r3 = B.desc;
                r4 = B.iconUrl;
                r6 = B.secondUrl;
                r7 = B.pageType;
                if (r1 != 0) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("geta8key_username", bd(auVar));
                    intent5.putExtra("rawUrl", B.gxD);
                    intent5.putExtra("topic_id", r1);
                    intent5.putExtra("topic_name", str);
                    intent5.putExtra("topic_desc", r3);
                    intent5.putExtra("topic_icon_url", r4);
                    intent5.putExtra("topic_ad_url", r6);
                    intent5.putExtra("extra_scence", 23);
                    d.b(this.uSU.uTo, "emoji", ".ui.EmojiStoreTopicUI", intent5);
                    return;
                }
                w.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            } else if (B == null || B.type != 27) {
                w.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", auVar.field_talker, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_type), auVar.field_content);
                if (B.url != null && !B.url.equals("") && B.url != null && !B.url.equals("")) {
                    r1 = p.s(B.url, o.dH(this.fJL) ? "groupmessage" : "singlemessage");
                    str = B.url;
                    r3 = az(this.uSU.uTo, B.appId);
                    r4 = new Intent();
                    r4.putExtra("rawUrl", r1);
                    r4.putExtra("webpageTitle", B.title);
                    if (B.appId != null && ("wx751a1acca5688ba3".equals(B.appId) || "wxfbc915ff7c30e335".equals(B.appId) || "wx482a4001c37e2b74".equals(B.appId))) {
                        r1 = new Bundle();
                        r1.putString("jsapi_args_appid", B.appId);
                        r4.putExtra("jsapiargs", r1);
                    }
                    if (bg.mA(str)) {
                        r4.putExtra("shortUrl", B.url);
                    } else {
                        r4.putExtra("shortUrl", str);
                    }
                    r4.putExtra("version_name", r3 == null ? null : r3.versionName);
                    r4.putExtra("version_code", r3 == null ? 0 : r3.versionCode);
                    if (!bg.mA(B.fUR)) {
                        r4.putExtra("srcUsername", B.fUR);
                        r4.putExtra("srcDisplayname", B.fUS);
                    }
                    r4.putExtra("msg_id", auVar.field_msgId);
                    r4.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    r4.putExtra("KAppId", B.appId);
                    r4.putExtra("geta8key_username", m.xL());
                    r4.putExtra("pre_username", bd(auVar));
                    r4.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
                    r0 = bd(auVar);
                    r1 = m.xL();
                    r4.putExtra("preUsername", r0);
                    r4.putExtra("preChatName", r1);
                    r4.putExtra("preChatTYPE", com.tencent.mm.u.p.G(r0, r1));
                    r4.putExtra("preMsgIndex", 0);
                    d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", r4);
                }
            } else {
                r1 = B.tid;
                str = B.hjB;
                r3 = B.desc;
                r4 = B.iconUrl;
                r6 = B.secondUrl;
                r7 = B.pageType;
                if (r1 != 0) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("geta8key_username", bd(auVar));
                    intent6.putExtra("rawUrl", B.gxD);
                    intent6.putExtra("set_id", r1);
                    intent6.putExtra("set_title", str);
                    intent6.putExtra("set_iconURL", r4);
                    intent6.putExtra("set_desc", r3);
                    intent6.putExtra("headurl", r6);
                    intent6.putExtra("pageType", r7);
                    d.b(this.uSU.uTo, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent6);
                    return;
                }
                w.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            }
        } else if (B.url != null && !B.url.equals("")) {
            r1 = p.s(B.url, this.fJL.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            str = B.url;
            r3 = az(this.uSU.uTo, B.appId);
            r4 = new Intent();
            r4.putExtra("rawUrl", r1);
            r4.putExtra("webpageTitle", B.title);
            if (B.appId != null && ("wx751a1acca5688ba3".equals(B.appId) || "wxfbc915ff7c30e335".equals(B.appId) || "wx482a4001c37e2b74".equals(B.appId))) {
                r1 = new Bundle();
                r1.putString("jsapi_args_appid", B.appId);
                r4.putExtra("jsapiargs", r1);
            }
            if (bg.mA(str)) {
                r4.putExtra("shortUrl", B.url);
            } else {
                r4.putExtra("shortUrl", str);
            }
            r4.putExtra("version_name", r3 == null ? null : r3.versionName);
            r4.putExtra("version_code", r3 == null ? 0 : r3.versionCode);
            if (!bg.mA(B.fUR)) {
                r4.putExtra("srcUsername", B.fUR);
                r4.putExtra("srcDisplayname", B.fUS);
            }
            r4.putExtra("msg_id", auVar.field_msgId);
            r4.putExtra("KPublisherId", "msg_" + Long.toString(auVar.field_msgSvrId));
            r4.putExtra("KAppId", B.appId);
            r4.putExtra("geta8key_username", this.fJL);
            r1 = bd(auVar);
            r4.putExtra("pre_username", r1);
            r4.putExtra("prePublishId", "msg_" + Long.toString(auVar.field_msgSvrId));
            r4.putExtra("preUsername", r1);
            r4.putExtra("preChatName", this.fJL);
            r4.putExtra("preChatTYPE", com.tencent.mm.u.p.G(r1, this.fJL));
            r4.putExtra("preMsgIndex", 0);
            d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", r4);
        }
    }

    private boolean a(au auVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        if (!auVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        w.d("MicroMsg.GalleryGridUI", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName("com.tencent.mobileqq", at(this.uSU.uTo, "com.tencent.mobileqq"));
        intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(9, null);
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
                w.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            }
        }
        try {
            startActivity(intent);
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
            w.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String bd(com.tencent.mm.storage.au r4) {
        /*
        r3 = this;
        r1 = r3.fJL;
        r0 = r3.fJL;
        r2 = "@chatroom";
        r0 = r0.endsWith(r2);
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        if (r0 == 0) goto L_0x0022;
    L_0x0010:
        r0 = r4.field_content;
        r0 = com.tencent.mm.u.ay.gi(r0);
        if (r1 == 0) goto L_0x0022;
    L_0x0018:
        if (r0 == 0) goto L_0x0022;
    L_0x001a:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0022;
    L_0x0020:
        r1 = r0;
        goto L_0x000d;
    L_0x0022:
        r0 = r1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.bd(com.tencent.mm.storage.au):java.lang.String");
    }

    private static PackageInfo az(Context context, String str) {
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
                w.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    private void be(au auVar) {
        long j = this.vFJ + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.vFJ = currentTimeMillis;
        if (j < currentTimeMillis) {
            ap.yY();
            this.sXW = com.tencent.mm.u.c.isSDCardAvailable();
        }
        if (this.sXW) {
            Intent intent = new Intent();
            intent.setClassName(this.uSU.uTo, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", auVar.field_msgId);
            startActivity(intent);
            return;
        }
        s.eP(this.uSU.uTo);
    }

    private void K(View view, int i) {
        if (this.vQQ != null) {
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_biz_chat_id", this.kbc);
            intent.putExtra("key_is_biz_chat", this.sMK);
            intent.putExtra("intent.key.with.footer", true);
            au auVar = (au) this.vQQ.getItem(i);
            if (auVar != null) {
                int width;
                int height;
                int i2 = getResources().getConfiguration().orientation;
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.putExtra("img_gallery_msg_id", auVar.field_msgId).putExtra("img_gallery_msg_svr_id", auVar.field_msgSvrId).putExtra("img_gallery_talker", auVar.field_talker).putExtra("img_gallery_chatroom_name", auVar.field_talker).putExtra("img_gallery_orientation", i2);
                if (view != null) {
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                } else {
                    intent.putExtra("img_gallery_back_from_grid", true);
                }
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }
    }

    public boolean onPreDraw() {
        a aVar = (a) this.vQR.get();
        if (aVar != null) {
            ViewTreeObserver viewTreeObserver = aVar.pqE.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = aVar.pqE.getMeasuredWidth();
                int measuredHeight = aVar.pqE.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = (LayoutParams) aVar.vPE.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.vPE.setLayoutParams(layoutParams);
                    final View view = aVar.vPE;
                    final TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.vQZ = view;
                        this.handler.postDelayed(new Runnable(this) {
                            final /* synthetic */ ImageGalleryGridUI vRg;

                            public final void run() {
                                if (VERSION.SDK_INT >= 16) {
                                    view.animate().setDuration(500).alpha(0.0f).withEndAction(this.vRg.vQY).withLayer().setInterpolator(decelerateInterpolator);
                                } else if (this.vRg.handler != null) {
                                    view.animate().setDuration(500).alpha(0.0f).setInterpolator(decelerateInterpolator);
                                    this.vRg.handler.postDelayed(this.vRg.vQY, 500);
                                }
                            }
                        }, 700);
                    }
                }
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(getString(R.l.eny))) {
            a.vRJ.clear();
            bWu();
        } else {
            bWv();
        }
        return false;
    }

    private void bWu() {
        qP(getString(R.l.eoc, new Object[]{Integer.valueOf(a.vRJ.vQg.size())}));
        a.vRJ.vRH = true;
        if (this.vQQ != null) {
            if (this.pvS == null) {
                this.pvS = AnimationUtils.loadAnimation(this, R.a.aRq);
            }
            c cVar = this.vQQ;
            cVar.hQa = false;
            cVar.notifyDataSetChanged();
            this.vRa.setVisibility(0);
            this.vRa.startAnimation(this.pvS);
            this.vRc.setEnabled(false);
            this.vRd.setEnabled(false);
            this.vRe.setEnabled(false);
            this.vRf.setEnabled(false);
            this.vRb = this.vQP.getPaddingBottom();
            this.vQP.setPadding(this.vQP.getPaddingLeft(), this.vQP.getPaddingTop(), this.vQP.getPaddingRight(), com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXQ));
            com.tencent.mm.plugin.report.service.g.oUh.i(11627, Integer.valueOf(2));
            zn(0);
            a(0, getString(R.l.enx), (OnMenuItemClickListener) this);
        }
    }

    private void bWP() {
        boolean z = !a.vRJ.vQg.isEmpty() && a.vRJ.vRH;
        if (z) {
            this.vRc.setEnabled(true);
            this.vRd.setEnabled(true);
            this.vRe.setEnabled(true);
            this.vRf.setEnabled(true);
            return;
        }
        this.vRc.setEnabled(false);
        this.vRd.setEnabled(false);
        this.vRe.setEnabled(false);
        this.vRf.setEnabled(false);
    }

    public final void bWv() {
        a.vRJ.vRH = false;
        qP(getString(R.l.dDa));
        if (this.vQQ != null) {
            this.vQQ.notifyDataSetChanged();
            if (this.vRb >= 0) {
                this.vQP.setPadding(this.vQP.getPaddingLeft(), this.vQP.getPaddingTop(), this.vQP.getPaddingRight(), this.vRb);
            }
            this.vRa.setVisibility(8);
            zn(0);
            a(0, getString(R.l.eny), (OnMenuItemClickListener) this);
        }
    }

    public void onClick(View view) {
        if (!a.vRJ.vQg.isEmpty()) {
            boolean endsWith = this.fJL.toLowerCase().endsWith("@chatroom");
            final List<au> list = a.vRJ.vQg;
            if (list != null && !list.isEmpty()) {
                au auVar;
                if (view.getId() == R.h.bev) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11627, Integer.valueOf(5));
                    final Set treeSet = new TreeSet();
                    for (au auVar2 : list) {
                        treeSet.add(Long.valueOf(auVar2.field_msgId));
                    }
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.dXd), "", getString(R.l.ebv), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ImageGalleryGridUI vRg;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            w.i("MicroMsg.GalleryGridUI", "delete message");
                            z.a(this.vRg, treeSet, this.vRg);
                            this.vRg.bWv();
                        }
                    }, null);
                } else if (view.getId() == R.h.bNZ) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(219, 18, 1, true);
                    final cb cbVar = new cb();
                    if (com.tencent.mm.pluginsdk.model.g.a(this.uSU.uTo, cbVar, this.fJL, list, false)) {
                        b(cbVar);
                        cz(list);
                    } else if (list.size() > 1) {
                        String string;
                        Context context = this.uSU.uTo;
                        String string2 = cbVar.fFA.fFG >= 0 ? this.uSU.uTo.getString(R.l.eio) : this.uSU.uTo.getString(R.l.ein);
                        r2 = "";
                        if (cbVar.fFA.fFG >= 0) {
                            string = this.uSU.uTo.getString(R.l.dXk);
                        } else {
                            string = this.uSU.uTo.getString(R.l.eGa);
                        }
                        com.tencent.mm.ui.base.g.a(context, string2, r2, string, this.uSU.uTo.getString(R.l.dXi), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ ImageGalleryGridUI vRg;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (cbVar.fFA.type == 14 && cbVar.fFA.fFC.tzn.size() == 0) {
                                    this.vRg.bWv();
                                    return;
                                }
                                this.vRg.b(cbVar);
                                ImageGalleryGridUI.cz(list);
                            }
                        }, null);
                    } else {
                        com.tencent.mm.ui.base.g.h(this.uSU.uTo, cbVar.fFA.fFG, 0);
                    }
                } else if (view.getId() == R.h.cJD) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(219, 19, 1, true);
                    ab.a(this, list, endsWith, this.fJL, this);
                    bWv();
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11627, Integer.valueOf(3));
                    final List cD = cD(list);
                    if (cD.size() != list.size()) {
                        com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.enS, R.l.dIO, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ ImageGalleryGridUI vRg;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.c(this.vRg.uSU.uTo, cD);
                                this.vRg.bWv();
                            }
                        }, null);
                        return;
                    }
                    auVar2 = (au) cD.get(0);
                    if (list.size() == 1 && auVar2 != null && auVar2.axO()) {
                        r2 = auVar2.field_content;
                        f.a aVar = null;
                        if (r2 != null) {
                            aVar = f.a.B(r2, auVar2.field_reserved);
                        }
                        if (aVar != null && aVar.type == 6) {
                            be(auVar2);
                            return;
                        }
                        return;
                    }
                    b.c((Context) this, (List) list);
                    bWv();
                }
            }
        }
    }

    private static void cz(List<au> list) {
        for (au a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, a, 0);
        }
    }

    private static List<au> cD(List<au> list) {
        List<au> arrayList = new ArrayList();
        for (au auVar : list) {
            if (!(b.aT(auVar) || b.aU(auVar))) {
                arrayList.add(auVar);
            }
        }
        return arrayList;
    }

    private void b(cb cbVar) {
        cbVar.fFA.activity = this;
        cbVar.fFA.fFH = 45;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
        if (cbVar.fFB.ret != -2 && cbVar.fFB.ret <= 0 && cbVar.fFB.ret <= 0) {
            bWv();
            if (14 != cbVar.fFA.type) {
                w.d("MicroMsg.GalleryGridUI", "not record type, do not report");
            } else if (cbVar.fFA.fFD == null) {
                w.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.i(11142, Integer.valueOf(cbVar.fFA.fFD.tzy), Integer.valueOf(cbVar.fFA.fFD.tzz), Integer.valueOf(cbVar.fFA.fFD.tzA), Integer.valueOf(cbVar.fFA.fFD.tzB), Integer.valueOf(cbVar.fFA.fFD.tzC), Integer.valueOf(cbVar.fFA.fFD.tzD), Integer.valueOf(cbVar.fFA.fFD.tzE), Integer.valueOf(cbVar.fFA.fFD.tzF), Integer.valueOf(cbVar.fFA.fFD.tzG), Integer.valueOf(cbVar.fFA.fFD.tzH), Integer.valueOf(cbVar.fFA.fFD.tzI), Integer.valueOf(cbVar.fFA.fFD.tzJ), Integer.valueOf(cbVar.fFA.fFD.tzK), Integer.valueOf(cbVar.fFA.fFD.tzL), Integer.valueOf(cbVar.fFA.fFD.tzM));
            }
        }
    }

    public final void bWQ() {
        if (this.vQQ != null && this.fAG) {
            this.vQQ.vQH = true;
        }
        qP(getString(R.l.eoc, new Object[]{Integer.valueOf(a.vRJ.vQg.size())}));
        bWP();
    }

    public final void clear() {
        if (this.vQQ != null && this.fAG) {
            this.vQQ.vQH = true;
        }
        bWP();
    }

    public final void bUE() {
    }

    public final void a(dz.a aVar) {
    }

    public final boolean bUF() {
        return true;
    }

    public final void b(dz.a aVar) {
        if (aVar == dz.a.del) {
            this.vQQ.OK();
            this.vQQ.notifyDataSetChanged();
        }
        bWv();
    }
}
