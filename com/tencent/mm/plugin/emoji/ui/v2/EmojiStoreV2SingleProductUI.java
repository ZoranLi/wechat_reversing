package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.protocal.c.ow;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreV2SingleProductUI extends MMActivity implements OnScrollListener, e {
    private View QB;
    private String gLD;
    private int hPi;
    private ProgressDialog kIa;
    private long kMa;
    private String kNc;
    private String kNe;
    private MMPullDownView kWT;
    private i kWV;
    private int kWv = 0;
    private PreViewListGridView kYA;
    private d kYB;
    private View kYC;
    private TextView kYD;
    private View kYE;
    private boolean kYF = true;
    private xi kYG;
    private byte[] kYH;
    private int kYI = -1;
    private String kYJ;
    private LabelContainerView kYK;
    private TextView kYL;
    private MMTagPanel kYM;
    private HashMap<String, Integer> kYN = new HashMap();
    private ArrayList<String> kYO;
    private boolean kYP = false;
    private c kYQ = new c<cm>(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

        {
            this.kYT = r2;
            this.usg = cm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(this.kYT.kYB == null || this.kYT.mHandler == null)) {
                this.kYT.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 kYU;

                    {
                        this.kYU = r1;
                    }

                    public final void run() {
                        this.kYU.kYT.kYB.notifyDataSetInvalidated();
                    }
                });
            }
            return false;
        }
    };
    private MMPullDownView.e kYR = new MMPullDownView.e(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

        {
            this.kYT = r1;
        }

        public final boolean akm() {
            w.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "onBottom");
            this.kYT.dE(true);
            return true;
        }
    };
    private MMPullDownView.c kYS = new MMPullDownView.c(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

        {
            this.kYT = r1;
        }

        public final boolean ako() {
            return false;
        }
    };
    private int kYr;
    private String kYs;
    private int kYt = -1;
    private String kYu;
    private String kYv;
    private String kYw;
    private String kYx;
    private String kYy;
    private int kYz = 0;
    private boolean kxr = false;
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

        {
            this.kYT = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    if (this.kYT.kYE != null) {
                        this.kYT.kYE.setVisibility(8);
                        return;
                    }
                    return;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    if (this.kYT.kYE != null) {
                        this.kYT.kYE.setVisibility(0);
                    }
                    sendEmptyMessage(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED);
                    return;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    this.kYT.Oe();
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        emojiStoreV2SingleProductUI.zi(R.l.edw);
        emojiStoreV2SingleProductUI.af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, emojiStoreV2SingleProductUI.kYF);
        if (emojiStoreV2SingleProductUI.kYN == null || !emojiStoreV2SingleProductUI.kYN.containsKey(str)) {
            emojiStoreV2SingleProductUI.kYH = null;
            emojiStoreV2SingleProductUI.kYI = -1;
            emojiStoreV2SingleProductUI.kYJ = emojiStoreV2SingleProductUI.getString(R.l.edM);
            emojiStoreV2SingleProductUI.kYz = 1;
            emojiStoreV2SingleProductUI.kYr = 0;
            emojiStoreV2SingleProductUI.ag(emojiStoreV2SingleProductUI.kYH);
            emojiStoreV2SingleProductUI.uL("");
        } else {
            emojiStoreV2SingleProductUI.kYI = -1;
            emojiStoreV2SingleProductUI.kYJ = str;
            emojiStoreV2SingleProductUI.kYz = 4;
            emojiStoreV2SingleProductUI.kYr = ((Integer) emojiStoreV2SingleProductUI.kYN.get(emojiStoreV2SingleProductUI.kYJ)).intValue();
            emojiStoreV2SingleProductUI.ag(null);
            emojiStoreV2SingleProductUI.uL(str);
        }
        if (emojiStoreV2SingleProductUI.kYK != null) {
            emojiStoreV2SingleProductUI.kYK.setVisibility(8);
        }
    }

    static /* synthetic */ void o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(emojiStoreV2SingleProductUI.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(emojiStoreV2SingleProductUI) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final void a(l lVar) {
                lVar.a(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kYT.getString(R.l.fnw), R.k.duZ);
                lVar.a(1000, this.kYT.getString(R.l.fnv), R.k.duP);
            }
        };
        eVar.qJg = new d(emojiStoreV2SingleProductUI) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        Context context = this.kYT.uSU.uTo;
                        String r = this.kYT.kYu;
                        String s = this.kYT.kYw;
                        String t = this.kYT.kYv;
                        h.alY();
                        k.a(context, r, s, t, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(this.kYT.kYt, this.kYT.kYu, this.kYT.kYw, this.kYT.kYv, this.kYT.kYx, this.kYT.kYz), 12);
                        g.oUh.i(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(1), "", Integer.valueOf(this.kYT.kYt)});
                        return;
                    case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                        k.bQ(this.kYT.uSU.uTo);
                        this.kYT.uSU.uTo.overridePendingTransition(R.a.aRq, R.a.aQY);
                        g.oUh.i(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(2), "", Integer.valueOf(this.kYT.kYt)});
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
        g.oUh.i(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2SingleProductUI.kYt)});
    }

    protected final int getLayoutId() {
        return R.i.daS;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
        r9 = this;
        r8 = 4;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r10);
        r0 = r9.getIntent();
        r3 = "uin";
        r0 = r0.getIntExtra(r3, r2);
        r9.kWv = r0;
        r0 = r9.getIntent();
        r3 = "Select_Conv_User";
        r0 = r0.getStringExtra(r3);
        r9.gLD = r0;
        r0 = r9.getIntent();
        r3 = "searchID";
        r4 = 0;
        r4 = r0.getLongExtra(r3, r4);
        r9.kMa = r4;
        r0 = r9.getIntent();
        r3 = "id";
        r0 = r0.getStringExtra(r3);
        r9.kNe = r0;
        r0 = r9.getIntent();
        r3 = "tag_id";
        r0 = r0.getStringExtra(r3);
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r3 != 0) goto L_0x0059;
    L_0x004f:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x01a3 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01a3 }
        r9.kYr = r0;	 Catch:{ Exception -> 0x01a3 }
    L_0x0059:
        r0 = r9.getIntent();
        r3 = "tag_desc";
        r0 = r0.getStringExtra(r3);
        r9.kYs = r0;
        r0 = r9.getIntent();
        r3 = "keyword";
        r0 = r0.getStringExtra(r3);
        r9.kNc = r0;
        r0 = r9.getIntent();
        r3 = "set_id";
        r0 = r0.getIntExtra(r3, r2);
        r9.kYt = r0;
        r0 = r9.getIntent();
        r3 = "set_title";
        r0 = r0.getStringExtra(r3);
        r9.kYu = r0;
        r0 = r9.getIntent();
        r3 = "set_iconURL";
        r0 = r0.getStringExtra(r3);
        r9.kYv = r0;
        r0 = r9.getIntent();
        r3 = "set_desc";
        r0 = r0.getStringExtra(r3);
        r9.kYw = r0;
        r0 = r9.getIntent();
        r3 = "headurl";
        r0 = r0.getStringExtra(r3);
        r9.kYx = r0;
        r0 = r9.getIntent();
        r3 = "sns_object_data";
        r0 = r0.getStringExtra(r3);
        r9.kYy = r0;
        r0 = r9.getIntent();
        r3 = "pageType";
        r0 = r0.getIntExtra(r3, r2);
        r9.kYz = r0;
        r0 = r9.kYy;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0106;
    L_0x00d6:
        r0 = r9.kYy;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.uo(r0);
        r9.kYt = r0;
        r0 = r9.kYy;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.up(r0);
        r9.kYu = r0;
        r0 = r9.kYy;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.ur(r0);
        r9.kYv = r0;
        r0 = r9.kYy;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.uq(r0);
        r9.kYw = r0;
        r0 = r9.kYy;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.us(r0);
        r9.kYx = r0;
        r0 = r9.kYy;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.ut(r0);
        r9.kYz = r0;
    L_0x0106:
        r0 = r9.kYz;
        switch(r0) {
            case 0: goto L_0x01b0;
            case 1: goto L_0x01f4;
            case 2: goto L_0x01f8;
            case 3: goto L_0x0202;
            case 4: goto L_0x0208;
            case 5: goto L_0x020e;
            case 6: goto L_0x0218;
            default: goto L_0x010b;
        };
    L_0x010b:
        r9.kYP = r1;
    L_0x010d:
        r0 = r9.kYP;
        if (r0 == 0) goto L_0x0134;
    L_0x0111:
        r0 = new android.content.Intent;
        r0.<init>();
        r3 = "rawUrl";
        com.tencent.mm.plugin.emoji.model.h.alY();
        r4 = "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
        r0.putExtra(r3, r4);
        r3 = "showShare";
        r0.putExtra(r3, r2);
        r3 = "webview";
        r4 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
        com.tencent.mm.bb.d.b(r9, r3, r4, r0);
        r9.finish();
    L_0x0134:
        r9.KC();
        r0 = r9.kWv;
        if (r0 != 0) goto L_0x017a;
    L_0x013b:
        r0 = r9.kYz;
        if (r0 != r6) goto L_0x017a;
    L_0x013f:
        r0 = com.tencent.mm.plugin.emoji.model.h.amc();
        r0 = r0.kLg;
        r3 = r9.kNe;
        r0 = r0.Sl(r3);
        if (r0 == 0) goto L_0x021e;
    L_0x014d:
        r3 = r0.tEc;
        if (r3 == 0) goto L_0x021e;
    L_0x0151:
        r3 = r0.tEc;
        r3 = r3.tDV;
        if (r3 == 0) goto L_0x021e;
    L_0x0157:
        r3 = r0.tEc;
        r3 = r3.msj;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 != 0) goto L_0x021e;
    L_0x0161:
        r0 = r0.tEc;
        r0 = r0.tDV;
        r9.kWv = r0;
        r0 = "MicroMsg.emoji.EmojiStoreV2SingleProductUI";
        r3 = "uin:%s ";
        r1 = new java.lang.Object[r1];
        r4 = r9.kWv;
        r4 = java.lang.Integer.valueOf(r4);
        r1[r2] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r1);
    L_0x017a:
        r0 = r2;
    L_0x017b:
        if (r0 != 0) goto L_0x0221;
    L_0x017d:
        r9.Oe();
    L_0x0180:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.vr();
        r1 = com.tencent.mm.storage.w.a.uzN;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.a(r1, r2);
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 821; // 0x335 float:1.15E-42 double:4.056E-321;
        r0.a(r1, r9);
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 239; // 0xef float:3.35E-43 double:1.18E-321;
        r0.a(r1, r9);
        return;
    L_0x01a3:
        r0 = move-exception;
        r3 = "MicroMsg.emoji.EmojiStoreV2SingleProductUI";
        r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
        com.tencent.mm.sdk.platformtools.w.e(r3, r0);
        goto L_0x0059;
    L_0x01b0:
        r0 = r9.kNc;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01c1;
    L_0x01b8:
        r0 = 5;
        r9.kYz = r0;
        r9.kYF = r2;
        r9.hPi = r6;
        goto L_0x010d;
    L_0x01c1:
        r0 = r9.kNe;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01cf;
    L_0x01c9:
        r9.kYz = r6;
        r9.hPi = r1;
        goto L_0x010d;
    L_0x01cf:
        r0 = r9.kWv;
        if (r0 == 0) goto L_0x01d9;
    L_0x01d3:
        r9.kYz = r7;
        r9.hPi = r1;
        goto L_0x010d;
    L_0x01d9:
        r0 = r9.kYr;
        if (r0 == 0) goto L_0x01e3;
    L_0x01dd:
        r9.hPi = r7;
        r9.kYz = r8;
        goto L_0x010d;
    L_0x01e3:
        r0 = r9.kYt;
        if (r0 <= 0) goto L_0x01ee;
    L_0x01e7:
        r0 = 6;
        r9.kYz = r0;
        r9.hPi = r8;
        goto L_0x010d;
    L_0x01ee:
        r9.kYz = r1;
        r9.hPi = r2;
        goto L_0x010d;
    L_0x01f4:
        r9.hPi = r2;
        goto L_0x010d;
    L_0x01f8:
        r0 = r9.kNe;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x010d;
    L_0x0200:
        goto L_0x010b;
    L_0x0202:
        r0 = r9.kWv;
        if (r0 != 0) goto L_0x010d;
    L_0x0206:
        goto L_0x010b;
    L_0x0208:
        r0 = r9.kYr;
        if (r0 != 0) goto L_0x010d;
    L_0x020c:
        goto L_0x010b;
    L_0x020e:
        r0 = r9.kNc;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x010d;
    L_0x0216:
        goto L_0x010b;
    L_0x0218:
        r0 = r9.kYt;
        if (r0 != 0) goto L_0x010d;
    L_0x021c:
        goto L_0x010b;
    L_0x021e:
        r0 = r1;
        goto L_0x017b;
    L_0x0221:
        r0 = r9.kNe;
        r1 = new com.tencent.mm.plugin.emoji.f.i;
        r1.<init>(r0);
        r9.kWV = r1;
        r0 = com.tencent.mm.u.ap.vd();
        r1 = r9.kWV;
        r0.a(r1, r2);
        r0 = com.tencent.mm.R.l.dJd;
        r0 = r9.getString(r0);
        r9.uE(r0);
        goto L_0x0180;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.onCreate(android.os.Bundle):void");
    }

    protected void onResume() {
        super.onResume();
        a.urY.b(this.kYQ);
    }

    protected void onPause() {
        super.onPause();
        a.urY.c(this.kYQ);
    }

    protected void onDestroy() {
        ap.vd().b(af.CTRL_BYTE, this);
        ap.vd().b(821, this);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bg.mA(stringExtra)) {
                        w.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", ".." + stringExtra);
                        int i3 = this.kYt;
                        String str = this.kYu;
                        String str2 = this.kYw;
                        String str3 = this.kYv;
                        String str4 = this.kYx;
                        int i4 = this.kYz;
                        h.alY();
                        k.a(this, stringExtra, 27, i3, str, str2, str3, str4, i4, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
                        break;
                    }
                }
                break;
            case 5001:
                if (i2 == -1) {
                    com.tencent.mm.ui.snackbar.a.e(this, this.uSU.uTo.getString(R.l.ekV));
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void KC() {
        if (this.kYz != 6 || bg.mA(this.kYu)) {
            zi(R.l.edw);
        } else {
            qP(this.kYu);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.kYT.kYK == null || this.kYT.kYK.getVisibility() != 0) {
                    this.kYT.finish();
                } else {
                    this.kYT.kYK.setVisibility(8);
                    this.kYT.af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kYT.kYF);
                    this.kYT.zi(R.l.edw);
                }
                return false;
            }
        });
        this.kYB = new d(this.uSU.uTo);
        this.kYB.kZF = new a(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final void lk(int i) {
                if (this.kYT.kYA != null && this.kYT.kYB != null) {
                    ov lN = this.kYT.kYB.lN(i);
                    if (lN != null) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_User", this.kYT.gLD);
                            intent.putExtra("extra_object", lN.toByteArray());
                            intent.putExtra("scene", this.kYT.hPi);
                            intent.putExtra("searchID", this.kYT.kMa);
                            intent.setClass(this.kYT.uSU.uTo, EmojiStoreV2SingleProductDialogUI.class);
                            this.kYT.startActivityForResult(intent, 5001);
                            this.kYT.overridePendingTransition(R.a.aRm, R.a.aRn);
                            g.oUh.i(12787, new Object[]{Integer.valueOf(this.kYT.hPi), Integer.valueOf(0), lN.tup, Long.valueOf(this.kYT.kMa)});
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        this.kYA = (PreViewListGridView) findViewById(R.h.list);
        this.QB = r.eC(this.uSU.uTo).inflate(R.i.daI, null);
        this.kYC = this.QB.findViewById(R.h.bLm);
        this.kYD = (TextView) this.QB.findViewById(R.h.bLF);
        this.kYA.addHeaderView(this.QB);
        this.kYE = r.eC(this.uSU.uTo).inflate(R.i.daz, null);
        this.kYA.addFooterView(this.kYE);
        this.kYE.setVisibility(8);
        this.kYA.setAdapter(this.kYB);
        this.kYA.setOnScrollListener(this);
        this.kWT = (MMPullDownView) findViewById(R.h.cbH);
        this.kWT.kR(false);
        this.kWT.vlo = this.kYR;
        this.kWT.vlz = this.kYS;
        this.kWT.kQ(false);
        this.kWT.kP(false);
        this.kWT.vlK = true;
        this.kYK = (LabelContainerView) findViewById(R.h.cBM);
        this.kYL = (TextView) this.kYK.findViewById(16908310);
        this.kYL.setText(R.l.evG);
        this.kYM = (MMTagPanel) this.kYK.findViewById(R.h.bFU);
        this.kYM.mUH = R.g.bkr;
        this.kYM.mUI = R.e.aWu;
        this.kYJ = getString(R.l.edM);
        this.kYK.vYd = new LabelContainerView.a(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final void aoG() {
                if (this.kYT.kYK != null) {
                    this.kYT.kYK.clearFocus();
                }
                this.kYT.kYK.requestFocus();
                this.kYT.kYK.setVisibility(8);
                this.kYT.af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kYT.kYF);
                this.kYT.zi(R.l.edw);
            }

            public final void aoH() {
                this.kYT.aHf();
            }
        };
        this.kYM.vmJ = new MMTagPanel.a(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final void uM(String str) {
                if (!bg.mA(this.kYT.kYJ) && !bg.mA(str) && str.equals(this.kYT.kYJ)) {
                    this.kYT.kYM.aU(this.kYT.kYJ, true);
                }
            }

            public final void uN(String str) {
                EmojiStoreV2SingleProductUI.a(this.kYT, str);
            }

            public final void uO(String str) {
            }

            public final void h(boolean z, int i) {
            }

            public final void aoI() {
            }

            public final void uP(String str) {
            }

            public final void uQ(String str) {
            }
        };
        a(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, R.g.bbD, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.kYT.kYK != null) {
                    this.kYT.kYK.setVisibility(0);
                    Collection arrayList = new ArrayList();
                    arrayList.add(this.kYT.kYJ);
                    this.kYT.kYM.a(arrayList, this.kYT.kYO);
                    this.kYT.zi(R.l.edI);
                    this.kYT.af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
                    g.oUh.A(12788, "1");
                }
                return false;
            }
        });
        a(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, R.k.dyx, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "on shard click.");
                EmojiStoreV2SingleProductUI.o(this.kYT);
                return true;
            }
        });
        af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
        af(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, false);
    }

    public void onBackPressed() {
        if (this.kYK == null || this.kYK.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        this.kYK.setVisibility(8);
        af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kYF);
        zi(R.l.edw);
    }

    private void Oe() {
        if (this.kYP) {
            w.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            return;
        }
        this.kYH = null;
        switch (this.kYz) {
            case 1:
                this.kYG = h.amc().kLg.Sm("0");
                if (this.kYG == null || this.kYG.tEa == null || this.kYB == null) {
                    uE(getString(R.l.dJd));
                } else {
                    a(this.kYG);
                    this.kYB.ao(this.kYG.tEa);
                }
                this.kYF = true;
                g.oUh.i(12875, new Object[]{Integer.valueOf(0), ""});
                break;
            case 2:
            case 3:
                af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
                this.kYF = false;
                g.oUh.i(12875, new Object[]{Integer.valueOf(1), this.kNe});
                break;
            case 4:
                af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
                this.kYJ = this.kYs;
                uL(this.kYJ);
                this.kYF = false;
                g.oUh.i(12875, new Object[]{Integer.valueOf(1), ""});
                break;
            case 5:
                this.kYJ = "";
                uL(this.kNc);
                this.kYF = false;
                g.oUh.i(12875, new Object[]{Integer.valueOf(2), ""});
                break;
            case 6:
                this.kYJ = "";
                af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
                af(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, true);
                g.oUh.i(12875, new Object[]{Integer.valueOf(3), ""});
                break;
        }
        ag(this.kYH);
    }

    private void uE(String str) {
        if (isFinishing()) {
            w.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.dIO);
        this.kIa = com.tencent.mm.ui.base.g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI kYT;

            {
                this.kYT = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.kYT.kWV != null) {
                    ap.vd().c(this.kYT.kWV);
                }
            }
        });
    }

    private void amV() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }

    private void ag(byte[] bArr) {
        this.kYH = null;
        switch (this.kYz) {
            case 1:
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.h(1, this.kWv, this.kYr, this.kNc, this.kYt, bArr), 0);
                return;
            case 2:
            case 3:
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.h(2, this.kWv, this.kYr, this.kNc, this.kYt, bArr), 0);
                return;
            case 4:
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.h(3, this.kWv, this.kYr, this.kNc, this.kYt, bArr), 0);
                return;
            case 5:
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.h(4, this.kWv, this.kYr, this.kNc, this.kYt, bArr), 0);
                return;
            case 6:
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.h(5, this.kWv, this.kYr, this.kNc, this.kYt, bArr), 0);
                return;
            default:
                return;
        }
    }

    private void a(xi xiVar) {
        boolean z = false;
        if (xiVar == null || xiVar.tEb == null || xiVar.tEb.size() <= 0) {
            af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
            return;
        }
        if (this.kYF) {
            z = true;
        }
        af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, z);
        if (this.kYM != null) {
            if (this.kYO == null) {
                this.kYO = new ArrayList();
            } else {
                this.kYO.clear();
            }
            if (this.kYN == null) {
                this.kYN = new HashMap();
            }
            this.kYN.clear();
            this.kYO.add(getString(R.l.edM));
            Iterator it = xiVar.tEb.iterator();
            while (it.hasNext()) {
                ow owVar = (ow) it.next();
                if (!(owVar == null || bg.mA(owVar.tux))) {
                    this.kYO.add(owVar.tux);
                    this.kYN.put(owVar.tux, Integer.valueOf(owVar.tuw));
                }
            }
            Collection arrayList = new ArrayList();
            arrayList.add(this.kYJ);
            this.kYM.a(arrayList, this.kYO);
        }
    }

    private void uL(String str) {
        if (this.kYC != null && this.kYD != null) {
            switch (this.kYz) {
                case 4:
                    if (!bg.mA(str)) {
                        this.kYD.setText(getString(R.l.edN, new Object[]{str}));
                        this.kYD.setVisibility(0);
                        this.kYC.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!bg.mA(str)) {
                        this.kYD.setText(getString(R.l.edJ, new Object[]{str}));
                        this.kYD.setVisibility(0);
                        this.kYC.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (bg.mA(str)) {
                this.kYD.setText("");
                this.kYD.setVisibility(8);
                this.kYC.setVisibility(8);
            }
        }
    }

    private void dE(boolean z) {
        if (!this.kxr) {
            ag(this.kYH);
            this.kxr = true;
            this.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, 200);
        }
    }

    private void J(LinkedList<ov> linkedList) {
        if (this.kYB != null && linkedList != null) {
            if (this.kYI == -1) {
                this.kYB.ao(linkedList);
                return;
            }
            d dVar = this.kYB;
            if (dVar.kIf == null) {
                dVar.kIf = new ArrayList();
            }
            dVar.kIf.addAll(linkedList);
            dVar.notifyDataSetChanged();
        }
    }

    private void aoF() {
        Toast.makeText(this.uSU.uTo, getString(R.l.eeo), 0).show();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        int type = kVar.getType();
        if (type == 821) {
            amV();
            com.tencent.mm.plugin.emoji.f.h hVar = (com.tencent.mm.plugin.emoji.f.h) kVar;
            xi amn = hVar.amn();
            this.kxr = false;
            if (this.kYE != null) {
                this.kYE.setVisibility(8);
                this.mHandler.removeMessages(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                this.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, 200);
            }
            int i3 = hVar.hEc;
            if (((i == 0 && i2 == 0) || (i == 4 && (i2 == 2 || i2 == 3))) && ((this.kYH == null || this.kYH.length <= 0) && i3 != 3)) {
                a(amn);
            }
            if (i == 0 || i == 4) {
                this.kYH = hVar.kNa;
                if (i2 == 0) {
                    J(amn.tEa);
                    this.kYI = 0;
                    return;
                } else if (i2 == 2) {
                    J(amn.tEa);
                    this.kYI = 2;
                    return;
                } else if (i2 == 3) {
                    this.kYI = -1;
                    J(amn.tEa);
                    return;
                } else {
                    aoF();
                    return;
                }
            }
            aoF();
        } else if (type == af.CTRL_BYTE) {
            amV();
            if (i2 == 0 && i == 0) {
                xk amo = ((i) kVar).amo();
                if (amo != null && amo.tEc != null) {
                    this.kWv = amo.tEc.tDV;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED);
                        return;
                    }
                    return;
                }
                return;
            }
            af(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, false);
            com.tencent.mm.ui.base.g.b(this.uSU.uTo, getString(R.l.ecB), null, true);
            w.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.kYI == 2 && !this.kxr) {
            w.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            dE(true);
            w.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (i != 0 && this.kYA != null) {
            this.kYA.aoJ();
        }
    }

    protected final int Ol() {
        return 1;
    }
}
