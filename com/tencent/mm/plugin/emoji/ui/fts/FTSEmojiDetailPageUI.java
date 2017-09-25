package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FTSEmojiDetailPageUI extends MMActivity implements e {
    private String designerName;
    private int fFq;
    private String fGa;
    private String fJX;
    private String fQE;
    private String hPt;
    private int hkz;
    private l iYI;
    private c jFO;
    private ProgressBar jFc;
    private a kLT = new a(this) {
        final /* synthetic */ FTSEmojiDetailPageUI kTd;

        {
            this.kTd = r1;
        }

        public final void i(c cVar) {
            if (cVar == null || this.kTd.jFO == null || !this.kTd.jFO.EP().equals(cVar.EP())) {
                w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                return;
            }
            w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[]{this.kTd.jFO.EP()});
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass9 kTf;

                {
                    this.kTf = r1;
                }

                public final void run() {
                    this.kTf.kTd.dy(false);
                }
            });
        }
    };
    private String kMb;
    private MMGIFImageView kSM;
    private Button kSN;
    private Button kSO;
    private TextView kSP;
    private ImageView kSQ;
    private View kSR;
    private boolean kSS;
    private boolean kST;
    private String kSU;
    private String kSV;
    private String kSW;
    private String kSX;
    private String kSY;
    private String kSZ;
    private com.tencent.mm.sdk.b.c kTa = new com.tencent.mm.sdk.b.c<cm>(this) {
        final /* synthetic */ FTSEmojiDetailPageUI kTd;

        {
            this.kTd = r2;
            this.usg = cm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cm cmVar = (cm) bVar;
            if (this.kTd.jFO != null && cmVar.fFV.fFW.equals(this.kTd.jFO.EP())) {
                w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", new Object[]{this.kTd.jFO.EP()});
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 kTe;

                    {
                        this.kTe = r1;
                    }

                    public final void run() {
                        this.kTe.kTd.dy(false);
                    }
                });
            }
            return false;
        }
    };
    private i kTb = new i(this) {
        final /* synthetic */ FTSEmojiDetailPageUI kTd;

        {
            this.kTd = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
            if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(this.kTd.jFO.field_encrypturl)) {
                File file = new File(objArr[0].toString());
                if (file.exists()) {
                    this.kTd.jFO.field_md5 = g.f(file);
                    FTSEmojiDetailPageUI fTSEmojiDetailPageUI = this.kTd;
                    ap.yY();
                    fTSEmojiDetailPageUI.fQE = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", this.kTd.jFO.field_md5);
                    FileOp.p(file.getAbsolutePath(), this.kTd.fQE);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 kTg;

                        {
                            this.kTg = r1;
                        }

                        public final void run() {
                            this.kTg.kTd.dy(false);
                        }
                    });
                }
            }
        }
    };
    private d kTc = new d(this) {
        final /* synthetic */ FTSEmojiDetailPageUI kTd;

        {
            this.kTd = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    FTSEmojiDetailPageUI.h(this.kTd);
                    return;
                case 2:
                    FTSEmojiDetailPageUI.g(this.kTd);
                    return;
                default:
                    return;
            }
        }
    };
    private int scene;
    private int type;

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2) {
        com.tencent.mm.as.i.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.hPt, fTSEmojiDetailPageUI.kMb, 2, 0);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("emoji_activity_id", str2);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
        com.tencent.mm.bb.d.a(fTSEmojiDetailPageUI, ".ui.transmit.SelectConversationUI", intent, 0);
        fTSEmojiDetailPageUI.overridePendingTransition(R.a.aRq, R.a.aQY);
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        com.tencent.mm.as.i.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.hPt, fTSEmojiDetailPageUI.kMb, 1, 0);
        c Si = h.amc().kLa.Si(str);
        ap.yY();
        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", str);
        if (Si == null && com.tencent.mm.a.e.aO(D)) {
            int i = o.Pj(D) ? c.uLa : c.uKZ;
            c cVar = new c();
            cVar.field_md5 = str;
            cVar.field_catalog = c.uKT;
            cVar.field_type = i;
            cVar.field_size = com.tencent.mm.a.e.aN(D);
            cVar.field_temp = 1;
            cVar.field_designerID = str2;
            cVar.field_thumbUrl = str3;
            cVar.field_activityid = str4;
            h.amc().kLa.r(cVar);
            Si = cVar;
        }
        if (Si != null) {
            boolean a = h.alY().a(fTSEmojiDetailPageUI, Si, 18, m.xL());
            w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", new Object[]{Boolean.valueOf(a)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI r9) {
        /*
        r8 = 27;
        r3 = 3;
        r1 = 1;
        r2 = 0;
        r4 = r9.scene;
        r5 = r9.hPt;
        r6 = r9.kMb;
        r0 = r9.type;
        switch(r0) {
            case 2: goto L_0x00a8;
            case 3: goto L_0x00b3;
            case 4: goto L_0x00be;
            default: goto L_0x0010;
        };
    L_0x0010:
        r0 = r2;
    L_0x0011:
        r7 = r9.anK();
        if (r7 == 0) goto L_0x0018;
    L_0x0017:
        r0 = 4;
    L_0x0018:
        com.tencent.mm.as.i.a(r4, r5, r6, r3, r0);
        r0 = r9.anK();
        if (r0 == 0) goto L_0x00c9;
    L_0x0021:
        r0 = new android.os.Bundle;
        r0.<init>();
        r2 = "stat_scene";
        r3 = 8;
        r0.putInt(r2, r3);
        r2 = "stat_search_id";
        r3 = r9.hPt;
        r0.putString(r2, r3);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.hPt;
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.kMb;
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.scene;
        r3 = java.lang.String.valueOf(r3);
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.type;
        r3 = java.lang.String.valueOf(r3);
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = "key_username";
        r5 = r9.kSZ;
        r3.putExtra(r4, r5);
        r4 = "key_can_swipe_back";
        r3.putExtra(r4, r1);
        r1 = "key_from_scene";
        r4 = 6;
        r3.putExtra(r1, r4);
        r1 = "key_scene_note";
        r3.putExtra(r1, r2);
        r1 = "_stat_obj";
        r3.putExtra(r1, r0);
        r0 = r9.uSU;
        r0 = r0.uTo;
        r1 = "appbrand";
        r2 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bb.d.b(r0, r1, r2, r3);
    L_0x00a7:
        return;
    L_0x00a8:
        r0 = r9.fGa;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00b0:
        r0 = r1;
        goto L_0x0011;
    L_0x00b3:
        r0 = r9.fJX;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00bb:
        r0 = 2;
        goto L_0x0011;
    L_0x00be:
        r0 = r9.kSW;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00c6:
        r0 = r3;
        goto L_0x0011;
    L_0x00c9:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "preceding_scence";
        r3 = r9.getIntent();
        r4 = "preceding_scence";
        r2 = r3.getIntExtra(r4, r2);
        r0.putExtra(r1, r2);
        r1 = "download_entrance_scene";
        r0.putExtra(r1, r8);
        r1 = "searchID";
        r2 = r9.hPt;
        r4 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bg.getLong(r2, r4);
        r0.putExtra(r1, r2);
        r1 = "docID";
        r2 = r9.kMb;
        r0.putExtra(r1, r2);
        r1 = r9.type;
        switch(r1) {
            case 2: goto L_0x0101;
            case 3: goto L_0x0127;
            case 4: goto L_0x014b;
            default: goto L_0x0100;
        };
    L_0x0100:
        goto L_0x00a7;
    L_0x0101:
        r1 = com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.class;
        r0.setClass(r9, r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);
        r1 = "extra_scence";
        r2 = r9.scene;
        r0.putExtra(r1, r2);
        r1 = "extra_type";
        r2 = r9.type;
        r0.putExtra(r1, r2);
        r1 = "extra_id";
        r2 = r9.fGa;
        r0.putExtra(r1, r2);
    L_0x0123:
        r9.startActivity(r0);
        goto L_0x00a7;
    L_0x0127:
        r1 = com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.class;
        r0.setClass(r9, r1);
        r1 = "extra_scence";
        r0.putExtra(r1, r8);
        r1 = "id";
        r2 = r9.fJX;
        r0.putExtra(r1, r2);
        r1 = "name";
        r2 = r9.designerName;
        r0.putExtra(r1, r2);
        r1 = "headurl";
        r2 = r9.kSY;
        r0.putExtra(r1, r2);
        goto L_0x0123;
    L_0x014b:
        r1 = r9.kSW;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x00a7;
    L_0x0153:
        r1 = "rawUrl";
        r2 = r9.kSW;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r2 = "webview";
        r3 = ".ui.tools.WebViewUI";
        com.tencent.mm.bb.d.b(r1, r2, r3, r0);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI):void");
    }

    static /* synthetic */ void c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.kST) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.eOm));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.ede));
        if (fTSEmojiDetailPageUI.iYI == null) {
            fTSEmojiDetailPageUI.iYI = new l(fTSEmojiDetailPageUI.uSU.uTo);
        }
        fTSEmojiDetailPageUI.iYI.qJf = new n.c(fTSEmojiDetailPageUI) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.setHeaderTitle("");
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.e(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                }
            }
        };
        fTSEmojiDetailPageUI.iYI.qJg = fTSEmojiDetailPageUI.kTc;
        fTSEmojiDetailPageUI.iYI.e(new OnCancelListener(fTSEmojiDetailPageUI) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            {
                this.kTd = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.kTd.iYI = null;
            }
        });
        com.tencent.mm.ui.base.g.a(fTSEmojiDetailPageUI.uSU.uTo, fTSEmojiDetailPageUI.iYI.blb());
    }

    static /* synthetic */ void g(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        w.d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + v.bIN());
        String str = fTSEmojiDetailPageUI.getString(R.l.emY) + v.bIN();
        Intent intent = new Intent();
        intent.putExtra("title", fTSEmojiDetailPageUI.getString(R.l.ede));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bb.d.b(fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        if (FileOp.aO(fTSEmojiDetailPageUI.fQE)) {
            k.h(fTSEmojiDetailPageUI.fQE, fTSEmojiDetailPageUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kSN = (Button) findViewById(R.h.bKU);
        this.kSO = (Button) findViewById(R.h.bLq);
        this.kSM = (MMGIFImageView) findViewById(R.h.bLj);
        this.jFc = (ProgressBar) findViewById(R.h.cbP);
        this.kSP = (TextView) findViewById(R.h.bLt);
        this.kSQ = (ImageView) findViewById(R.h.bLs);
        this.kSR = findViewById(R.h.bottom_bar);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            {
                this.kTd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kTd.finish();
                return false;
            }
        });
        this.kSN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            {
                this.kTd = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.a(this.kTd, this.kTd.jFO.EP(), this.kTd.jFO.field_designerID, this.kTd.jFO.field_thumbUrl, this.kTd.jFO.field_activityid);
            }
        });
        this.kSO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            {
                this.kTd = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.a(this.kTd, this.kTd.jFO.EP(), this.kTd.jFO.field_activityid);
            }
        });
        this.kSR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            {
                this.kTd = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.b(this.kTd);
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI kTd;

            {
                this.kTd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                FTSEmojiDetailPageUI.c(this.kTd);
                return true;
            }
        });
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.jFO = new c();
        this.jFO.field_designerID = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.jFO.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.jFO.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.jFO.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.jFO.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.jFO.field_md5 = getIntent().getStringExtra("extra_md5");
        this.jFO.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.fGa = this.jFO.field_groupId;
        this.kSV = getIntent().getStringExtra("extra_product_name");
        this.kSU = getIntent().getStringExtra("productUrl");
        this.kSW = getIntent().getStringExtra("extra_article_url");
        this.kSX = getIntent().getStringExtra("extra_article_name");
        this.fJX = this.jFO.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.kSY = getIntent().getStringExtra("headurl");
        this.kSZ = getIntent().getStringExtra("weapp_user_name");
        this.hkz = getIntent().getIntExtra("weapp_version", 0);
        this.fFq = getIntent().getIntExtra("source_type", 0);
        this.hPt = getIntent().getStringExtra("searchID");
        this.kMb = getIntent().getStringExtra("docID");
        this.kSS = getIntent().getBooleanExtra("disableAddSticker", false);
        this.kST = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!bg.mA(stringExtra)) {
            this.jFO.field_activityid = stringExtra;
        }
        com.tencent.mm.sdk.b.a.urY.b(this.kTa);
        h.alW().kLG = this.kLT;
        com.tencent.mm.as.i.g(this.scene, this.hPt, this.kMb);
        dy(true);
        w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[]{this.fQE});
        com.tencent.mm.as.i.g(this.scene, this.hPt, this.kMb);
    }

    protected void onResume() {
        super.onResume();
        anJ();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            c cVar;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            c Si = h.amc().kLa.Si(this.jFO.EP());
            if (Si == null) {
                ap.yY();
                String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", this.jFO.EP());
                if (com.tencent.mm.a.e.aO(D)) {
                    int i3 = o.Pj(D) ? c.uLa : c.uKZ;
                    c cVar2 = new c();
                    cVar2.field_md5 = this.jFO.EP();
                    cVar2.field_catalog = c.uKT;
                    cVar2.field_type = i3;
                    cVar2.field_size = com.tencent.mm.a.e.aN(D);
                    cVar2.field_temp = 1;
                    if (!bg.mA(this.jFO.field_activityid)) {
                        cVar2.field_activityid = this.jFO.field_activityid;
                    }
                    cVar2.field_designerID = this.jFO.field_designerID;
                    cVar2.field_thumbUrl = this.jFO.field_thumbUrl;
                    Si = h.amc().kLa.r(cVar2);
                }
                cVar = Si;
            } else {
                Si.field_designerID = this.jFO.field_designerID;
                Si.field_thumbUrl = this.jFO.field_thumbUrl;
                cVar = Si;
            }
            for (String str : bg.f(bg.ap(stringExtra, "").split(","))) {
                if (cVar != null) {
                    h.alY().a(str, cVar, null);
                }
            }
            com.tencent.mm.ui.snackbar.a.e(this, this.uSU.uTo.getString(R.l.ekV));
        }
    }

    private void dy(boolean z) {
        if (z) {
            qP(this.jFO.getName());
        }
        switch (this.type) {
            case 2:
                com.tencent.mm.ah.n.GW().a(this.kSU, this.kSQ);
                this.kSP.setText(this.kSV);
                this.fQE = this.jFO.eN(this.fGa, this.jFO.field_md5);
                break;
            case 3:
                com.tencent.mm.ah.n.GW().a(this.kSY, this.kSQ);
                this.kSP.setText(this.designerName);
                this.fQE = this.jFO.eN(this.fGa, this.jFO.field_md5);
                break;
            case 4:
                this.kSQ.setVisibility(8);
                if (!bg.mA(this.kSX)) {
                    this.kSP.setText(this.kSX);
                    break;
                } else {
                    this.kSP.setText(R.l.ePT);
                    break;
                }
        }
        if (FileOp.aO(this.fQE)) {
            this.jFc.setVisibility(8);
            this.kSM.setVisibility(0);
            c Si = h.amc().kLa.Si(this.jFO.EP());
            if (Si == null || (Si.field_reserved4 & c.uLn) != c.uLn) {
                w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.kSM.ct(this.fQE, null);
            } else {
                w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.kSM.h(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(Si), "");
            }
            anJ();
            c Si2 = h.amc().kLa.Si(this.jFO.EP());
            if (Si2 == null) {
                Si = this.jFO;
            } else {
                Si = Si2;
            }
            if (Si.field_catalog == c.uKY || bg.mA(Si.field_groupId) || ((!bg.mA(Si.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(Si.field_groupId)) || this.type == 4)) {
                this.kSO.setEnabled(true);
            } else {
                String str = this.jFO.field_groupId;
                ap.vd().a(423, this);
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.g(str, (byte) 0), 0);
            }
        } else if (z) {
            if (this.type == 4) {
                File file = new File(getCacheDir(), g.n(this.jFO.field_encrypturl.getBytes()));
                if (file.exists()) {
                    this.jFO.field_md5 = g.f(file);
                    ap.yY();
                    String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", this.jFO.field_md5);
                    if (!FileOp.aO(D)) {
                        FileOp.p(file.getAbsolutePath(), D);
                    }
                    this.fQE = D;
                    dy(false);
                } else {
                    com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                    aVar.hIL = true;
                    aVar.hIN = file.getAbsolutePath();
                    aVar.hJm = new Object[]{file.getAbsolutePath()};
                    h.alV().a(this.jFO.field_encrypturl, null, aVar.Hg(), this.kTb);
                }
            } else {
                this.kSM.setVisibility(8);
                this.jFc.setVisibility(0);
                this.kSN.setText(R.l.eda);
                this.kSO.setText(R.l.eLL);
                this.kSN.setEnabled(false);
                this.kSO.setEnabled(false);
                h.alW().h(this.jFO);
            }
        }
        if (this.kSS) {
            this.kSN.setVisibility(8);
        }
    }

    private void anJ() {
        c Si = h.amc().kLa.Si(this.jFO.EP());
        if (Si == null) {
            Si = this.jFO;
        }
        if (Si == null || Si.field_catalog != com.tencent.mm.storage.a.a.uKS) {
            this.kSN.setText(R.l.eda);
            if (com.tencent.mm.a.e.aO(this.fQE)) {
                this.kSN.setEnabled(true);
                return;
            } else {
                this.kSN.setEnabled(false);
                return;
            }
        }
        this.kSN.setEnabled(false);
        this.kSN.setText(R.l.dDk);
    }

    private boolean anK() {
        if (bg.mA(this.kSZ) || this.fFq != 1) {
            return false;
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.ddI;
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.kTa);
        h.alW().kLG = null;
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.emoji.f.g) {
            ap.vd().b(423, this);
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
            if (gVar == null || bg.mA(gVar.kMS) || this.jFO == null || bg.mA(this.jFO.field_groupId) || !this.jFO.field_groupId.equalsIgnoreCase(gVar.kMS)) {
                w.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                this.kSO.setEnabled(true);
            } else {
                this.kSO.setEnabled(false);
            }
        }
    }
}
