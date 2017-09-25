package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.co;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.model.g.a;
import com.tencent.mm.plugin.emoji.model.g.b;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2DesignerUI extends MMActivity implements OnScrollListener, OnItemClickListener, a, b, c, e, com.tencent.mm.y.e {
    private ListView Fg;
    private View QB;
    private int hPi;
    private long kMa;
    private String kMb;
    private String kMf;
    private String kNe;
    private int kOG = -1;
    private boolean kOH;
    private byte[] kOJ;
    protected final int kON = 131074;
    private final int kOO = 131075;
    private final int kOP = 131076;
    private final String kOQ = "product_id";
    private final String kOR = "progress";
    private final String kOS = DownloadInfo.STATUS;
    private com.tencent.mm.plugin.emoji.model.e kOV;
    private g kOW;
    private com.tencent.mm.sdk.b.c kOY = new com.tencent.mm.sdk.b.c<co>(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI kXc;

        {
            this.kXc = r2;
            this.usg = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.kXc;
            String str = coVar.fFZ.fGa;
            int i = coVar.fFZ.status;
            int i2 = coVar.fFZ.progress;
            w.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), coVar.fFZ.fGb});
            if (i == 6) {
                emojiStoreV2DesignerUI.aI(str, i2);
            } else {
                w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                emojiStoreV2DesignerUI.aH(str, i);
            }
            if (!(emojiStoreV2DesignerUI.kPg == null || emojiStoreV2DesignerUI.kPg.kIP == null)) {
                f tU = emojiStoreV2DesignerUI.kPg.kIP.tU(str);
                if (tU != null) {
                    tU.kJe = r4;
                }
            }
            return false;
        }
    };
    private com.tencent.mm.plugin.emoji.f.g kOZ;
    com.tencent.mm.plugin.emoji.a.f kPg;
    private BannerEmojiView kWA;
    private TextView kWB;
    private TextView kWC;
    private View kWD;
    private View kWE;
    private TextView kWF;
    private ImageView kWG;
    private TextView kWH;
    private TextView kWI;
    View kWJ;
    private List<ov> kWK = new ArrayList();
    private View kWL;
    PreViewListGridView kWM;
    private d kWN;
    View kWO;
    View kWP;
    View kWQ;
    TextView kWR;
    View kWS;
    private MMPullDownView kWT;
    private aad kWU;
    private i kWV;
    private p kWW;
    private ag.b.a kWX = new ag.b.a(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI kXc;

        {
            this.kXc = r1;
        }

        public final void p(String str, boolean z) {
            w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContactCallBack username:%s,succ:%b", new Object[]{str, Boolean.valueOf(z)});
            if (z) {
                EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.kXc;
                ap.yY();
                emojiStoreV2DesignerUI.kWy = com.tencent.mm.u.c.wR().Rc(str);
                this.kXc.aoB();
            }
        }
    };
    private final int kWY = CdnLogic.MediaType_FAVORITE_FILE;
    private final int kWZ = CdnLogic.MediaType_FAVORITE_VIDEO;
    private int kWv;
    private String kWw;
    private String kWx;
    private x kWy;
    private View kWz;
    private final int kXa = 10003;
    private com.tencent.mm.plugin.emoji.f.p kXb;
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI kXc;

        {
            this.kXc = r1;
        }

        public final void handleMessage(Message message) {
            String string;
            switch (message.what) {
                case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                    this.kXc.aoA();
                    return;
                case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                    this.kXc.updateData();
                    return;
                case 10003:
                    this.kXc.Oe();
                    return;
                case 131075:
                    if (this.kXc.kPg != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            this.kXc.kPg.aI(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (this.kXc.kPg != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            this.kXc.kPg.aH(string, message.getData().getInt(DownloadInfo.STATUS));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.kWv != 0) {
            Intent intent = new Intent();
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, emojiStoreV2DesignerUI.kWv);
            intent.setClass(emojiStoreV2DesignerUI.uSU.uTo, EmojiStoreV2SingleProductUI.class);
            emojiStoreV2DesignerUI.startActivity(intent);
        }
    }

    static /* synthetic */ void h(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.kWU != null && !bg.mA(emojiStoreV2DesignerUI.kWU.tiT)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", emojiStoreV2DesignerUI.kWU.tiT);
            d.b(emojiStoreV2DesignerUI.uSU.uTo, "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.plugin.report.service.g.oUh.i(12067, new Object[]{Integer.valueOf(3), "", "", "", ""});
        }
    }

    static /* synthetic */ void i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(emojiStoreV2DesignerUI.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(emojiStoreV2DesignerUI) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final void a(l lVar) {
                lVar.a(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.kXc.getString(R.l.fnw), R.k.duZ);
                lVar.a(1000, this.kXc.getString(R.l.fnv), R.k.duP);
            }
        };
        eVar.qJg = new n.d(emojiStoreV2DesignerUI) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        if (this.kXc.kWU != null) {
                            k.a(this.kXc.uSU.uTo, this.kXc.kWU.msj + this.kXc.getString(R.l.edh), this.kXc.kWU.msk, this.kXc.kWU.tvr, this.kXc.kWx, EmojiLogic.i(this.kXc.kWv, this.kXc.kMf, this.kXc.kWx), 10);
                            com.tencent.mm.plugin.report.service.g.oUh.i(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(1), "", Integer.valueOf(this.kXc.kWv)});
                            return;
                        }
                        return;
                    case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                        k.bQ(this.kXc.uSU.uTo);
                        this.kXc.uSU.uTo.overridePendingTransition(R.a.aRq, R.a.aQY);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(2), "", Integer.valueOf(this.kXc.kWv)});
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
        com.tencent.mm.plugin.report.service.g.oUh.i(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2DesignerUI.kWv)});
    }

    protected final int getLayoutId() {
        return R.i.daD;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.kNe = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.kWv = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.kMf = getIntent().getStringExtra("name");
        this.kWw = getIntent().getStringExtra("headurl");
        this.kWx = getIntent().getStringExtra("rediret_url");
        this.hPi = getIntent().getIntExtra("extra_scence", 0);
        this.kMa = getIntent().getLongExtra("searchID", 0);
        this.kMb = bg.ap(getIntent().getStringExtra("docID"), "");
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.kWv = EmojiLogic.uj(stringExtra);
            this.kMf = EmojiLogic.uk(stringExtra);
            this.kWx = EmojiLogic.un(stringExtra);
        }
        KC();
        if (!bg.mA(this.kNe)) {
            xk Sl = h.amc().kLg.Sl(this.kNe);
            if (Sl == null || Sl.tEc == null || Sl.tEc.tDV == 0 || bg.mA(Sl.tEc.msj)) {
                z = true;
                if (z) {
                    Oe();
                } else {
                    this.kWV = new i(this.kNe);
                    ap.vd().a(this.kWV, 0);
                    getString(R.l.dIO);
                    this.kWW = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ EmojiStoreV2DesignerUI kXc;

                        {
                            this.kXc = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.kXc.kWV != null) {
                                ap.vd().c(this.kXc.kWV);
                            }
                        }
                    });
                }
                ap.vd().a(af.CTRL_BYTE, this);
                ap.vd().a(720, this);
                com.tencent.mm.sdk.b.a.urY.b(this.kOY);
                com.tencent.mm.plugin.report.service.g.oUh.i(12067, new Object[]{Integer.valueOf(1), "", "", "", ""});
                com.tencent.mm.plugin.report.service.g.oUh.i(12740, new Object[]{Integer.valueOf(2), o.getString(this.kWv), "", "", Integer.valueOf(this.hPi)});
            }
            this.kWv = Sl.tEc.tDV;
            this.kMf = Sl.tEc.msj;
            w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[]{Integer.valueOf(this.kWv), this.kMf});
        }
        z = false;
        if (z) {
            this.kWV = new i(this.kNe);
            ap.vd().a(this.kWV, 0);
            getString(R.l.dIO);
            this.kWW = com.tencent.mm.ui.base.g.a(this, getString(R.l.dJd), true, /* anonymous class already generated */);
        } else {
            Oe();
        }
        ap.vd().a(af.CTRL_BYTE, this);
        ap.vd().a(720, this);
        com.tencent.mm.sdk.b.a.urY.b(this.kOY);
        com.tencent.mm.plugin.report.service.g.oUh.i(12067, new Object[]{Integer.valueOf(1), "", "", "", ""});
        com.tencent.mm.plugin.report.service.g.oUh.i(12740, new Object[]{Integer.valueOf(2), o.getString(this.kWv), "", "", Integer.valueOf(this.hPi)});
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(423, this);
    }

    protected void onPause() {
        super.onPause();
        ap.vd().b(423, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kXb != null) {
            ap.vd().c(this.kXb);
        }
        ap.vd().b(af.CTRL_BYTE, this);
        ap.vd().b(720, this);
        com.tencent.mm.sdk.b.a.urY.c(this.kOY);
    }

    protected final void KC() {
        if (!bg.mA(this.kMf)) {
            qP(this.kMf);
        }
        this.QB = r.eC(this.uSU.uTo).inflate(R.i.daC, null);
        this.kWz = this.QB.findViewById(R.h.bIh);
        this.kWA = (BannerEmojiView) this.kWz.findViewById(R.h.bKV);
        this.kWB = (TextView) this.QB.findViewById(R.h.bIj);
        this.kWC = (TextView) this.QB.findViewById(R.h.bIf);
        this.kWD = this.QB.findViewById(R.h.bIe);
        this.kWE = this.QB.findViewById(R.h.bId);
        this.kWF = (TextView) this.QB.findViewById(R.h.bIr);
        this.kWG = (ImageView) this.QB.findViewById(R.h.bIi);
        this.kWH = (TextView) this.QB.findViewById(R.h.bIg);
        this.kWI = (TextView) this.QB.findViewById(R.h.bIs);
        this.kWJ = this.QB.findViewById(R.h.bIk);
        this.kWL = this.QB.findViewById(R.h.bIn);
        this.kWL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final void onClick(View view) {
                EmojiStoreV2DesignerUI.e(this.kXc);
            }
        });
        this.kWM = (PreViewListGridView) this.QB.findViewById(R.h.bIm);
        this.kWN = new d(this.uSU.uTo);
        this.kWN.kZF = new a(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final void lk(int i) {
                if (this.kXc.kWM != null && this.kXc.kWN != null) {
                    ov lN = this.kXc.kWN.lN(i);
                    if (lN != null) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("extra_object", lN.toByteArray());
                            intent.setClass(this.kXc.uSU.uTo, EmojiStoreV2SingleProductDialogUI.class);
                            this.kXc.startActivity(intent);
                            this.kXc.overridePendingTransition(R.a.aRm, R.a.aRn);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        this.kWM.setAdapter(this.kWN);
        this.kWO = this.QB.findViewById(R.h.bIo);
        this.kWP = this.QB.findViewById(R.h.bIp);
        this.kWQ = this.QB.findViewById(R.h.bIn);
        this.kWR = (TextView) this.QB.findViewById(R.h.bIq);
        this.kWS = this.QB.findViewById(R.h.bIl);
        this.kWT = (MMPullDownView) findViewById(R.h.cbG);
        this.kWT.vlo = this;
        this.kWT.vlz = this;
        this.kWT.kQ(false);
        this.kWT.kP(false);
        this.Fg = (ListView) findViewById(16908298);
        this.Fg.setOnItemClickListener(this);
        this.Fg.setOnScrollListener(this);
        this.kWE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final void onClick(View view) {
                EmojiStoreV2DesignerUI.h(this.kXc);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kXc.finish();
                return false;
            }
        });
        a(0, R.k.dyx, new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            {
                this.kXc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "on shard click.");
                EmojiStoreV2DesignerUI.i(this.kXc);
                return true;
            }
        });
    }

    private void Oe() {
        qP(this.kMf);
        this.kPg = new com.tencent.mm.plugin.emoji.a.f(this.uSU.uTo);
        this.Fg.addHeaderView(this.QB);
        this.Fg.setAdapter(this.kPg);
        this.kPg.kIQ = this;
        this.kPg.kIl = com.tencent.mm.plugin.emoji.e.n.alN();
        this.kPg.kIm = false;
        this.kWB.setText(this.kMf);
        this.kWU = h.amc().kLd.Sq(String.valueOf(this.kWv));
        this.kOW = new g();
        this.kOW.kLX = this;
        this.kOW.kLV = this.kPg;
        this.kOW.kLZ = 6;
        this.kOW.kMc = this;
        this.kOW.kMf = this.kMf;
        this.kOW.kMa = this.kMa;
        this.kOW.kMb = this.kMb;
        if (this.kWU != null) {
            c(com.tencent.mm.plugin.emoji.f.p.a(this.kWU));
            List list = this.kWU.tiM;
            LinkedList linkedList = this.kWU.tEp;
            an(list);
        }
        updateData();
        af(this.kOJ);
    }

    private void updateData() {
        if (this.kWU == null) {
            w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
            return;
        }
        aoA();
        if (bg.mA(this.kWU.tiT)) {
            w.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.kWD.setVisibility(8);
            this.kWE.setVisibility(8);
        } else {
            w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[]{this.kWU.tiT});
            ap.yY();
            this.kWy = com.tencent.mm.u.c.wR().Rc(this.kWU.tiT);
        }
        if ((this.kWy == null || ((int) this.kWy.gTQ) == 0) && ag.a.hlS != null) {
            w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[]{this.kWU.tiT});
            ag.a.hlS.a(this.kWU.tiT, "", this.kWX);
        }
        this.kWH.setText(R.l.edZ);
        if (bg.mA(this.kWU.msk)) {
            this.kWC.setVisibility(8);
        } else {
            this.kWC.setText(this.kWU.msk);
            this.kWC.setVisibility(0);
        }
        aoB();
        if (this.kOV == null || this.kOV.kLM == null || this.kOV.kLM.isEmpty()) {
            this.kWI.setVisibility(8);
        } else {
            this.kWI.setVisibility(0);
        }
    }

    protected final void aoA() {
        if (this.kWU == null) {
            w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header faild. data is null.");
        } else if (this.kWA != null && !bg.mA(this.kWU.tGi)) {
            String str = this.kWU.tGi;
            com.tencent.mm.bg.a.getDensity(this);
            com.tencent.mm.storage.a.c a = EmojiLogic.a("Designer", 8, str, true);
            if (a == null) {
                com.tencent.mm.ah.n.GW().a(this.kWU.tGi, null, com.tencent.mm.plugin.emoji.e.f.b("Designer", this.kWU.tGi, "Designer", "BANNER"), new com.tencent.mm.ah.a.c.i(this) {
                    final /* synthetic */ EmojiStoreV2DesignerUI kXc;

                    {
                        this.kXc = r1;
                    }

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (this.kXc.mHandler != null) {
                            this.kXc.mHandler.sendEmptyMessage(CdnLogic.MediaType_FAVORITE_FILE);
                        }
                    }
                });
                return;
            }
            this.kWA.ct(a.eN(a.field_groupId, a.EP()), null);
        }
    }

    private void aoB() {
        if (this.kWy == null || ((int) this.kWy.gTQ) == 0) {
            this.kWE.setVisibility(8);
            this.kWD.setVisibility(8);
            return;
        }
        this.kWE.setVisibility(0);
        this.kWD.setVisibility(0);
        if (bg.mA(this.kWy.tK())) {
            this.kWF.setText(this.kWy.field_username);
        } else {
            this.kWF.setText(this.kWy.tK());
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(this.kWG, this.kWy.field_username);
        this.kWH.setEnabled(true);
    }

    private void af(byte[] bArr) {
        this.kOH = true;
        this.kXb = new com.tencent.mm.plugin.emoji.f.p(this.kWv, bArr);
        ap.vd().a(this.kXb, 0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        switch (kVar.getType()) {
            case af.CTRL_BYTE /*239*/:
                if (this.kWW != null && this.kWW.isShowing()) {
                    this.kWW.dismiss();
                }
                if (i2 == 0 && i == 0) {
                    xk amo = ((i) kVar).amo();
                    if (amo != null && amo.tEc != null) {
                        this.kWv = amo.tEc.tDV;
                        this.kMf = amo.tEc.msj;
                        this.kWw = amo.tEc.tvr;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(10003);
                            return;
                        }
                        return;
                    }
                    return;
                }
                af(0, false);
                com.tencent.mm.ui.base.g.b(this.uSU.uTo, getString(R.l.ecB), null, true);
                w.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                return;
            case 423:
                com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
                if (i == 0 && i2 == 0) {
                    aI(gVar.kMS, 0);
                    return;
                }
                final String str2 = gVar.kMS;
                final String str3 = gVar.kMU;
                final String str4 = gVar.kMT;
                com.tencent.mm.ui.base.g.a(this, getString(R.l.edj, new Object[]{str4}), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ EmojiStoreV2DesignerUI kXc;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kXc.F(str2, str3, str4);
                        this.kXc.amS();
                        w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "Retry doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        this.kXc.aI(str2, 0);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ EmojiStoreV2DesignerUI kXc;

                    {
                        this.kXc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                aH(gVar.kMS, -1);
                return;
            case 720:
                this.kOH = false;
                if (i == 0 || i == 4) {
                    com.tencent.mm.plugin.emoji.f.p pVar = (com.tencent.mm.plugin.emoji.f.p) kVar;
                    com.tencent.mm.plugin.emoji.model.e a = com.tencent.mm.plugin.emoji.f.p.a(pVar.amv());
                    if (i2 == 0) {
                        this.kWU = pVar.amv();
                        c(a);
                    } else if (i2 == 2) {
                        this.kWU = pVar.amv();
                        b(this.kOG, a);
                        this.kOG = 2;
                    } else if (i2 == 3) {
                        this.kWU = pVar.amv();
                        b(this.kOG, a);
                        this.kOG = 1;
                        w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[]{Integer.valueOf(i2)});
                    }
                    if (this.kOJ == null && this.kWU != null) {
                        h.amc().kLd.a(String.valueOf(this.kWv), pVar.amv());
                        this.kWK = this.kWU.tiM;
                        List list = this.kWK;
                        LinkedList linkedList = this.kWU.tEp;
                        an(list);
                    }
                    this.kOJ = pVar.kNk;
                    return;
                }
                w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                return;
            default:
                w.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                return;
        }
    }

    private void an(final List<ov> list) {
        int i = 1;
        String value = com.tencent.mm.i.g.sV().getValue("ShowDesignerEmoji");
        w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[]{value});
        if (bg.mA(value) || bg.PY(value) != 1) {
            i = 0;
        }
        if (list == null || list.size() <= 0 || r0 == 0) {
            this.kWJ.setVisibility(8);
            return;
        }
        this.kWJ.setVisibility(0);
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI kXc;

            public final void run() {
                int i;
                int i2 = 8;
                EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.kXc;
                if (list.size() > 3) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (emojiStoreV2DesignerUI.kWM != null) {
                    emojiStoreV2DesignerUI.kWM.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.kWP != null) {
                    emojiStoreV2DesignerUI.kWP.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.kWO != null) {
                    emojiStoreV2DesignerUI.kWO.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.kWQ != null) {
                    emojiStoreV2DesignerUI.kWQ.setVisibility(i != 0 ? 0 : 8);
                }
                if (emojiStoreV2DesignerUI.kWR != null) {
                    emojiStoreV2DesignerUI.kWR.setText(R.l.edv);
                }
                if (emojiStoreV2DesignerUI.kWS != null) {
                    View view = emojiStoreV2DesignerUI.kWS;
                    if (i != 0) {
                        i2 = 0;
                    }
                    view.setVisibility(i2);
                }
                if (emojiStoreV2DesignerUI.kWJ != null) {
                    emojiStoreV2DesignerUI.kWJ.setPadding(0, 0, 0, 0);
                }
            }
        });
        this.kWN.ao(list);
    }

    private void c(com.tencent.mm.plugin.emoji.model.e eVar) {
        b(this.kOG, eVar);
        this.kOG = 0;
    }

    private void b(int i, com.tencent.mm.plugin.emoji.model.e eVar) {
        Object obj = 1;
        switch (i) {
            case -1:
                this.kOV = eVar;
                break;
            case 0:
                this.kOV = eVar;
                break;
            case 1:
                this.kOV = eVar;
                break;
            case 2:
                if (this.kOV == null) {
                    this.kOV = new com.tencent.mm.plugin.emoji.model.e();
                }
                this.kOV.lp(eVar.kLL);
                this.kOV.al(eVar.kLM);
                break;
            default:
                obj = null;
                break;
        }
        if (this.kOV != null && r0 != null) {
            if (this.kPg != null) {
                this.kPg.b(this.kOV);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(CdnLogic.MediaType_FAVORITE_VIDEO);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.kOG == 0 || this.kOH) {
            w.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
            return;
        }
        af(this.kOJ);
        w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public final boolean akm() {
        return true;
    }

    public final boolean ako() {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kPg != null) {
            f lj = this.kPg.lj(i - this.Fg.getHeaderViewsCount());
            if (lj != null) {
                Intent intent = new Intent();
                intent.setClass(this, EmojiStoreDetailUI.class);
                pn pnVar = lj.kJb;
                if (pnVar == null) {
                    intent = null;
                } else {
                    intent.putExtra("extra_id", pnVar.tgW);
                    intent.putExtra("extra_name", pnVar.tuV);
                    intent.putExtra("extra_copyright", pnVar.tvf);
                    intent.putExtra("extra_coverurl", pnVar.tvd);
                    intent.putExtra("extra_description", pnVar.tuW);
                    intent.putExtra("extra_price", pnVar.tuY);
                    intent.putExtra("extra_type", pnVar.tuZ);
                    intent.putExtra("extra_flag", pnVar.tva);
                    intent.putExtra("preceding_scence", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                    intent.putExtra("download_entrance_scene", 6);
                    intent.putExtra("call_by", 1);
                    intent.putExtra("check_clickflag", false);
                    intent.putExtra("extra_status", lj.mStatus);
                    intent.putExtra("extra_progress", lj.sd);
                    intent.putExtra("searchID", this.kMa);
                    String stringExtra = getIntent().getStringExtra("to_talker_name");
                    if (!bg.mA(stringExtra)) {
                        intent.putExtra("to_talker_name", stringExtra);
                    }
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.EmojiStoreV2DesignerUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.alb();
        objArr[1] = TextUtils.isEmpty(aVar.ald()) ? "" : aVar.ald();
        objArr[2] = Integer.valueOf(aVar.alc());
        w.i(str, str2, objArr);
        aVar.alc();
        this.kOW.a(aVar);
    }

    public final void E(String str, String str2, String str3) {
        F(str, str2, str3);
        amS();
    }

    public final void alT() {
    }

    protected final com.tencent.mm.plugin.emoji.f.g F(String str, String str2, String str3) {
        this.kOZ = new com.tencent.mm.plugin.emoji.f.g(str, str2, str3);
        return this.kOZ;
    }

    protected final void amS() {
        ap.vd().a(this.kOZ, 0);
    }

    final void aI(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    final void aH(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt(DownloadInfo.STATUS, i);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.kOW.onActivityResult(i, i2, intent);
        if (i == MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (bg.mA(stringExtra) || this.kWU == null) {
                w.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
            } else {
                w.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", ".." + stringExtra);
                String str = this.kMf;
                String str2 = this.kWU.msk;
                int i3 = this.kWv;
                String str3 = this.kWx;
                String str4 = this.kMf;
                String str5 = this.kWU.tvr;
                String stringBuffer = new StringBuffer(getResources().getString(R.l.dGD)).append(str).toString();
                com.tencent.mm.pluginsdk.ui.applet.d.a aVar = new com.tencent.mm.pluginsdk.ui.applet.d.a(this);
                aVar.bs(stringExtra).MP(stringBuffer).xp(R.l.dIA);
                aVar.MQ(str5).bEV();
                aVar.MS(getString(R.l.dXj)).a(new com.tencent.mm.plugin.emoji.e.k.AnonymousClass2(stringExtra, str4, str2, i3, str3, str, str5, this)).oHT.show();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int Ol() {
        return 1;
    }
}
