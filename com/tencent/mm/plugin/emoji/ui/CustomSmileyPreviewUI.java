package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.co;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.f.j;
import com.tencent.mm.plugin.emoji.model.g.a;
import com.tencent.mm.plugin.emoji.model.g.b;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, a, b, e {
    private ListView Fg;
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String fGa;
    private c jFO;
    protected final int kON = 131074;
    private final int kOO = 131075;
    private final int kOP = 131076;
    private final String kOQ = "product_id";
    private final String kOR = "progress";
    private final String kOS = DownloadInfo.STATUS;
    private com.tencent.mm.sdk.b.c kOY = new com.tencent.mm.sdk.b.c<co>(this) {
        final /* synthetic */ CustomSmileyPreviewUI kPu;

        {
            this.kPu = r2;
            this.usg = co.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            co coVar = (co) bVar;
            if (!(coVar == null || bg.mA(this.kPu.fGa) || !this.kPu.fGa.equals(coVar.fFZ.fGa))) {
                CustomSmileyPreviewUI customSmileyPreviewUI = this.kPu;
                String str = coVar.fFZ.fGa;
                int i = coVar.fFZ.status;
                int i2 = coVar.fFZ.progress;
                w.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), coVar.fFZ.fGb});
                if (i == 6) {
                    Message obtain = Message.obtain();
                    obtain.getData().putString("product_id", str);
                    obtain.getData().putInt("progress", i2);
                    obtain.what = 131075;
                    if (customSmileyPreviewUI.mHandler != null) {
                        customSmileyPreviewUI.mHandler.sendMessage(obtain);
                    }
                } else {
                    w.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", new Object[]{Integer.valueOf(i)});
                    Message obtain2 = Message.obtain();
                    obtain2.getData().putString("product_id", str);
                    obtain2.getData().putInt(DownloadInfo.STATUS, i);
                    obtain2.what = 131076;
                    if (customSmileyPreviewUI.mHandler != null) {
                        customSmileyPreviewUI.mHandler.sendMessage(obtain2);
                    }
                }
                if (!(customSmileyPreviewUI.kPg == null || customSmileyPreviewUI.kPg.kIP == null)) {
                    f tU = customSmileyPreviewUI.kPg.kIP.tU(str);
                    if (tU != null) {
                        tU.kJe = r4;
                    }
                }
            }
            return false;
        }
    };
    private g kOZ;
    com.tencent.mm.plugin.emoji.a.f kPg;
    private View kPh;
    private ImageView kPi;
    private TextView kPj;
    private TextView kPk;
    private xk kPl;
    private pj kPm = new pj();
    private String kPn;
    private com.tencent.mm.plugin.emoji.model.g kPo;
    private xq kPp;
    private long kPq;
    String kPr;
    private String kPs;
    private com.tencent.mm.sdk.b.c kPt = new com.tencent.mm.sdk.b.c<nd>(this) {
        final /* synthetic */ CustomSmileyPreviewUI kPu;

        {
            this.kPu = r2;
            this.usg = nd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nd ndVar = (nd) bVar;
            if (this.kPu.kPq != 0 && ndVar.fUm.fUp == this.kPu.kPq) {
                w.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                com.tencent.mm.ui.base.g.a(this.kPu.uSU.uTo, ndVar.fUm.fUn, "", this.kPu.getString(R.l.dVn), false, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 kPv;

                    {
                        this.kPv = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        this.kPv.kPu.finish();
                    }
                });
            }
            return false;
        }
    };
    ae mHandler = new ae(this) {
        final /* synthetic */ CustomSmileyPreviewUI kPu;

        {
            this.kPu = r1;
        }

        public final void handleMessage(Message message) {
            int i;
            String string;
            switch (message.what) {
                case 2:
                    this.kPu.a(this.kPu.fGa, this.kPu.jFO);
                    return;
                case 131075:
                    i = message.getData().getInt("progress");
                    string = message.getData().getString("product_id");
                    if (bg.mA(string)) {
                        w.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                        return;
                    } else if (this.kPu.kPg != null && this.kPu.kPg.kIP != null) {
                        this.kPu.kPg.aI(string, i);
                        this.kPu.kPg.aiQ();
                        return;
                    } else {
                        return;
                    }
                case 131076:
                    i = message.getData().getInt(DownloadInfo.STATUS);
                    string = message.getData().getString("product_id");
                    if (bg.mA(string)) {
                        w.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                        return;
                    } else if (this.kPu.kPg != null && this.kPu.kPg.kIP != null) {
                        this.kPu.kPg.aH(string, i);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(CustomSmileyPreviewUI customSmileyPreviewUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.oUh.i(12789, new Object[]{Integer.valueOf(4), customSmileyPreviewUI.jFO.EP(), Integer.valueOf(1), customSmileyPreviewUI.jFO.field_designerID, customSmileyPreviewUI.jFO.field_groupId, "", "", "", "", customSmileyPreviewUI.jFO.field_activityid});
    }

    static /* synthetic */ void e(CustomSmileyPreviewUI customSmileyPreviewUI) {
        customSmileyPreviewUI.jFO = h.amc().kLa.Si(customSmileyPreviewUI.jFO.EP());
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(customSmileyPreviewUI, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(customSmileyPreviewUI) {
            final /* synthetic */ CustomSmileyPreviewUI kPu;

            {
                this.kPu = r1;
            }

            public final void a(l lVar) {
                if (!(this.kPu.jFO.field_catalog == c.uKY || this.kPu.jFO.bNt())) {
                    lVar.dX(0, R.l.dCd);
                }
                if (this.kPu.jFO.field_catalog == c.uKY || bg.mA(this.kPu.jFO.field_groupId) || (!bg.mA(this.kPu.jFO.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(this.kPu.jFO.field_groupId))) {
                    lVar.dX(1, R.l.eLL);
                }
                lVar.dX(2, R.l.ecD);
            }
        };
        eVar.qJg = new n.d(customSmileyPreviewUI) {
            final /* synthetic */ CustomSmileyPreviewUI kPu;

            {
                this.kPu = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        Context context = this.kPu;
                        c Si = h.amc().kLa.Si(context.getIntent().getStringExtra("custom_smiley_preview_md5"));
                        if (Si == null) {
                            w.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                            return;
                        } else if (Si.field_catalog == c.uKU) {
                            return;
                        } else {
                            if (Si.field_catalog == c.uKY) {
                                com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.dDk));
                                return;
                            } else {
                                h.alY().a(context.uSU.uTo, Si, 4, context.kPr);
                                return;
                            }
                        }
                    case 1:
                        CustomSmileyPreviewUI.m(this.kPu);
                        return;
                    case 2:
                        CustomSmileyPreviewUI.n(this.kPu);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
    }

    static /* synthetic */ void m(CustomSmileyPreviewUI customSmileyPreviewUI) {
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.b.imv.l(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.g.oUh.i(12789, new Object[]{Integer.valueOf(1), customSmileyPreviewUI.jFO.EP(), Integer.valueOf(1), customSmileyPreviewUI.jFO.field_designerID, customSmileyPreviewUI.jFO.field_groupId, customSmileyPreviewUI.kPr, "", "", "", customSmileyPreviewUI.jFO.field_activityid});
    }

    static /* synthetic */ void n(CustomSmileyPreviewUI customSmileyPreviewUI) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.kPs);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        intent.putExtra("k_username", customSmileyPreviewUI.kPr);
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.kPq);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int getLayoutId() {
        return R.i.cZZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(412, this);
        ap.vd().a(521, this);
        ap.vd().a(411, this);
        ap.vd().a(af.CTRL_BYTE, this);
        ap.vd().a(368, this);
        com.tencent.mm.sdk.b.a.urY.b(this.kOY);
        com.tencent.mm.sdk.b.a.urY.b(this.kPt);
        KC();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        ap.vd().b(412, this);
        ap.vd().b(521, this);
        ap.vd().b(411, this);
        ap.vd().b(af.CTRL_BYTE, this);
        ap.vd().b(368, this);
        com.tencent.mm.sdk.b.a.urY.c(this.kOY);
        com.tencent.mm.sdk.b.a.urY.c(this.kPt);
        super.onDestroy();
    }

    protected final void KC() {
        qP("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.kPq = getIntent().getLongExtra("msg_id", 0);
        this.kPr = getIntent().getStringExtra("msg_sender");
        this.kPs = getIntent().getStringExtra("msg_content");
        w.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[]{stringExtra});
        Object mz = bg.mz(stringExtra);
        if (TextUtils.isEmpty(mz)) {
            w.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        MMEmojiView mMEmojiView = (MMEmojiView) findViewById(R.h.bHz);
        if (mMEmojiView == null) {
            w.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail emojiView is null.");
            finish();
            return;
        }
        String str;
        String str2;
        Object[] objArr;
        boolean z;
        com.tencent.mm.plugin.report.service.g gVar;
        this.jFO = h.amc().kLa.Si(mz);
        if (this.jFO.bNt()) {
            InputStream bc = c.bc(this, this.jFO.getName());
            if (bc != null) {
                mMEmojiView.a(bc, this.jFO.getName());
            } else {
                str = "MicroMsg.emoji.CustomSmileyPreviewUI";
                str2 = "input stream is null. emoji name is:%s";
                objArr = new Object[1];
                objArr[0] = this.jFO == null ? "null" : this.jFO.getName();
                w.e(str, str2, objArr);
            }
        } else {
            mMEmojiView.a(this.jFO, "");
            if (!(this.jFO == null || this.jFO.bNx())) {
                com.tencent.mm.plugin.emoji.e.c.alw();
                com.tencent.mm.plugin.emoji.e.c.a(this.jFO, true);
            }
        }
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        str = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(R.h.bqk);
        com.tencent.mm.pluginsdk.model.app.f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(stringExtra2, true);
        str2 = (aJ == null || aJ.field_appName == null || aJ.field_appName.trim().length() <= 0) ? str : aJ.field_appName;
        if (stringExtra2 != null && stringExtra2.length() > 0) {
            if (str2 == null || str2.trim().length() == 0 || str2.equals("weixinfile") || str2.equals("invalid_appname")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                textView.setText(getString(R.l.dVF, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.uSU.uTo, aJ, str2)}));
                textView.setVisibility(0);
                k.b bVar = new k.b();
                bVar.appId = stringExtra2;
                bVar.fTm = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new k(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(stringExtra2, 2, com.tencent.mm.bg.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.bhT));
                } else {
                    a(this, textView, b);
                }
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ CustomSmileyPreviewUI kPu;

                    {
                        this.kPu = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.kPu.finish();
                        return true;
                    }
                });
                if (this.jFO.field_catalog != c.uKY || this.jFO.bNt()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.jFO.field_catalog == c.uKY || bg.mA(this.jFO.field_groupId) || (!bg.mA(this.jFO.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(this.jFO.field_groupId))) {
                    z = true;
                }
                a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ CustomSmileyPreviewUI kPu;

                    {
                        this.kPu = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        CustomSmileyPreviewUI.e(this.kPu);
                        return true;
                    }
                });
                ks(z);
                this.kPh = findViewById(R.h.bId);
                this.kPi = (ImageView) this.kPh.findViewById(R.h.bIi);
                this.kPj = (TextView) this.kPh.findViewById(R.h.bIr);
                this.kPk = (TextView) this.kPh.findViewById(R.h.bIg);
                this.kPh.setVisibility(8);
                if (!(this.jFO == null || bg.mA(this.jFO.field_designerID))) {
                    this.kPl = h.amc().kLg.Sl(this.jFO.field_designerID);
                    ap.vd().a(new i(this.jFO.field_designerID), 0);
                }
                if (!(this.jFO == null || bg.mA(this.jFO.field_activityid))) {
                    this.kPp = h.amc().kLd.Sr(this.jFO.field_activityid);
                    stringExtra = this.jFO.field_activityid;
                    str = this.jFO.field_md5;
                    if (this.kPp == null && (this.kPp == null || this.kPp.tEg == null || ((long) this.kPp.tEg.tuI) >= System.currentTimeMillis() / 1000)) {
                        w.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
                    } else {
                        ap.vd().a(new j(stringExtra, str), 0);
                    }
                }
                ana();
                this.kPh.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ CustomSmileyPreviewUI kPu;

                    {
                        this.kPu = r1;
                    }

                    public final void onClick(View view) {
                        if (this.kPu.kPl == null || this.kPu.kPl.tEc == null) {
                            w.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.kPu.uSU.uTo, EmojiStoreV2DesignerUI.class);
                        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, this.kPu.kPl.tEc.tDV);
                        intent.putExtra("name", this.kPu.kPl.tEc.msj);
                        intent.putExtra("headurl", this.kPu.kPl.tEc.tvr);
                        intent.putExtra("extra_scence", 9);
                        this.kPu.uSU.uTo.startActivity(intent);
                    }
                });
                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = this.fGa;
                objArr[2] = mz;
                if (this.jFO != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.jFO.field_designerID;
                }
                objArr[3] = stringExtra;
                if (this.jFO != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.jFO.field_activityid;
                }
                objArr[4] = stringExtra;
                gVar.i(12067, objArr);
            }
        }
        textView.setVisibility(8);
        this.fGa = this.jFO.field_groupId;
        ap.vd().a(new com.tencent.mm.plugin.emoji.f.k(this.fGa), 0);
        this.Fg = (ListView) findViewById(16908298);
        this.kPg = new com.tencent.mm.plugin.emoji.a.f(this.uSU.uTo);
        this.kPg.kIQ = this;
        this.kPg.kIj = true;
        this.kPg.kIm = false;
        this.Fg.setOnItemClickListener(this);
        this.Fg.setAdapter(this.kPg);
        this.kPg.kIO = this.Fg;
        if (!bg.mA(this.fGa)) {
            com.tencent.mm.storage.a.k Sn = h.amc().kLe.Sn(this.fGa);
            if (!(Sn == null || Sn.field_content == null)) {
                xu xuVar = new xu();
                try {
                    xuVar.aD(Sn.field_content);
                    this.kPm = xuVar.tEk;
                    this.kPn = Sn.field_lan;
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[]{bg.g(e)});
                }
            }
            if (this.kPm == null || bg.mA(this.kPn) || !this.kPn.equalsIgnoreCase(v.ea(this.uSU.uTo))) {
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.l(this.fGa, 1), 0);
            } else {
                com.tencent.mm.plugin.emoji.a.a.c anb = anb();
                if (this.kPg != null) {
                    this.kPg.a(anb);
                }
                ap.vd().a(new com.tencent.mm.plugin.emoji.f.l(this.fGa, 1, this.kPm.jOb), 0);
            }
        }
        this.kPo = new com.tencent.mm.plugin.emoji.model.g();
        this.kPo.kLX = this;
        this.kPo.kLV = this.kPg;
        this.kPo.kLZ = 9;
        this.kPo.kMc = this;
        a(this.fGa, this.jFO);
        b(/* anonymous class already generated */);
        if (this.jFO.field_catalog != c.uKY) {
        }
        z = false;
        z = true;
        a(0, R.g.bhb, /* anonymous class already generated */);
        ks(z);
        this.kPh = findViewById(R.h.bId);
        this.kPi = (ImageView) this.kPh.findViewById(R.h.bIi);
        this.kPj = (TextView) this.kPh.findViewById(R.h.bIr);
        this.kPk = (TextView) this.kPh.findViewById(R.h.bIg);
        this.kPh.setVisibility(8);
        this.kPl = h.amc().kLg.Sl(this.jFO.field_designerID);
        ap.vd().a(new i(this.jFO.field_designerID), 0);
        this.kPp = h.amc().kLd.Sr(this.jFO.field_activityid);
        stringExtra = this.jFO.field_activityid;
        str = this.jFO.field_md5;
        if (this.kPp == null) {
        }
        ap.vd().a(new j(stringExtra, str), 0);
        ana();
        this.kPh.setOnClickListener(/* anonymous class already generated */);
        gVar = com.tencent.mm.plugin.report.service.g.oUh;
        objArr = new Object[5];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.fGa;
        objArr[2] = mz;
        if (this.jFO != null) {
            stringExtra = this.jFO.field_designerID;
        } else {
            stringExtra = "";
        }
        objArr[3] = stringExtra;
        if (this.jFO != null) {
            stringExtra = this.jFO.field_activityid;
        } else {
            stringExtra = "";
        }
        objArr[4] = stringExtra;
        gVar.i(12067, objArr);
    }

    private void ana() {
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ CustomSmileyPreviewUI kPu;

            {
                this.kPu = r1;
            }

            public final void run() {
                if (this.kPu.kPp != null && this.kPu.kPp.tEg != null) {
                    this.kPu.kPh.setVisibility(0);
                    this.kPu.kPj.setText(this.kPu.kPp.tEg.msj);
                    if (bg.mA(this.kPu.kPp.tEg.muU)) {
                        this.kPu.kPi.setVisibility(8);
                    } else {
                        this.kPu.kPi.setVisibility(0);
                        com.tencent.mm.ah.n.GW().a(this.kPu.kPp.tEg.muU, this.kPu.kPi, com.tencent.mm.plugin.emoji.e.f.bN(this.kPu.jFO.field_groupId, this.kPu.kPp.tEg.muU));
                    }
                    this.kPu.kPk.setText(R.l.ech);
                    this.kPu.kPh.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 kPw;

                        {
                            this.kPw = r1;
                        }

                        public final void onClick(View view) {
                            CustomSmileyPreviewUI.a(this.kPw.kPu, this.kPw.kPu.kPp.tEg.tuH);
                        }
                    });
                    this.kPu.Fg.setVisibility(8);
                } else if (this.kPu.kPl == null || this.kPu.kPl.tEc == null) {
                    this.kPu.kPh.setVisibility(8);
                } else {
                    this.kPu.kPh.setVisibility(0);
                    this.kPu.kPj.setText(this.kPu.kPl.tEc.msj);
                    com.tencent.mm.ah.n.GW().a(this.kPu.kPl.tEc.tvr, this.kPu.kPi, com.tencent.mm.plugin.emoji.e.f.bM(this.kPu.jFO.field_groupId, this.kPu.kPl.tEc.tvr));
                    this.kPu.Fg.setVisibility(8);
                }
            }
        });
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(R.f.aXs);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        switch (kVar.getType()) {
            case af.CTRL_BYTE /*239*/:
                this.kPl = ((i) kVar).amo();
                ana();
                return;
            case 368:
                if (i2 == 0) {
                    j jVar = (j) kVar;
                    xq xqVar = (xq) jVar.gUA.hsk.hsr;
                    if (!(xqVar == null || xqVar.tEg == null)) {
                        xqVar.tEg.tuI = ((int) (System.currentTimeMillis() / 1000)) + xqVar.tEg.tuI;
                        h.amc().kLd.a(jVar.kNf, xqVar);
                    }
                    this.kPp = xqVar;
                    ana();
                    return;
                }
                w.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
                return;
            case 411:
                h.amc().kLd.a(12, ((com.tencent.mm.plugin.emoji.f.n) kVar).ams());
                return;
            case 412:
                com.tencent.mm.plugin.emoji.f.l lVar = (com.tencent.mm.plugin.emoji.f.l) kVar;
                String str2;
                String str3;
                Object[] objArr;
                com.tencent.mm.plugin.emoji.a.a.c anb;
                if (i == 0) {
                    if (i2 == 0) {
                        this.kPm = lVar.amq();
                        if (this.kPm == null || TextUtils.isEmpty(this.fGa) || !this.fGa.equals(this.kPm.tgW)) {
                            str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                            str3 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
                            objArr = new Object[2];
                            objArr[0] = this.fGa;
                            objArr[1] = this.kPm == null ? "" : this.kPm.tgW;
                            w.i(str2, str3, objArr);
                            return;
                        }
                        anb = anb();
                        if (this.kPg != null) {
                            this.kPg.a(anb);
                        }
                        this.mHandler.sendEmptyMessage(0);
                        w.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.kPm.tgW);
                        return;
                    } else if (i2 != 1) {
                        return;
                    } else {
                        return;
                    }
                } else if (i2 != 5) {
                    return;
                } else {
                    if (this.kPm == null || lVar.amq() == null || TextUtils.isEmpty(this.fGa) || !this.fGa.equals(this.kPm.tgW) || this.kPm.tva == lVar.amq().tva) {
                        str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                        str3 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
                        objArr = new Object[2];
                        objArr[0] = this.fGa;
                        objArr[1] = this.kPm == null ? "" : this.kPm.tgW;
                        w.i(str2, str3, objArr);
                        return;
                    }
                    this.kPm.tva = lVar.amq().tva;
                    anb = anb();
                    if (this.kPg != null) {
                        this.kPg.a(anb);
                    }
                    this.mHandler.sendEmptyMessage(0);
                    w.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.kPm.tgW);
                    return;
                }
            case 521:
                if (i2 == 0) {
                    this.mHandler.sendEmptyMessage(2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private com.tencent.mm.plugin.emoji.a.a.c anb() {
        List arrayList = new ArrayList();
        pn pnVar = new pn();
        pnVar.tvd = this.kPm.tvd;
        pnVar.muU = this.kPm.muU;
        pnVar.tuV = this.kPm.tuV;
        pnVar.tva = this.kPm.tva;
        pnVar.tuW = this.kPm.tuW;
        pnVar.tve = this.kPm.tve;
        pnVar.tuZ = this.kPm.tuZ;
        pnVar.tuY = this.kPm.tuY;
        pnVar.tvg = this.kPm.tvg;
        pnVar.tvh = this.kPm.tvh;
        pnVar.tgW = this.kPm.tgW;
        arrayList.add(new f(pnVar));
        return new com.tencent.mm.plugin.emoji.a.a.c(arrayList);
    }

    private void a(String str, c cVar) {
        if (!bg.mA(str) && cVar != null) {
            if (!bg.mA(str) && cVar.field_catalog != com.tencent.mm.storage.a.a.uKR && cVar.field_catalog != com.tencent.mm.storage.a.a.uKQ && ((cVar.field_type != c.uLc || cVar.field_type != c.uLd) && h.amc().kLc.Sf(str))) {
                if (this.Fg != null) {
                    this.Fg.setVisibility(0);
                }
                if (this.kPg == null) {
                    return;
                }
                if (h.amc().kLc.Sg(str)) {
                    this.kPg.kIk = true;
                } else {
                    this.kPg.kIk = false;
                }
            } else if (this.Fg != null) {
                this.Fg.setVisibility(8);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.alb();
        objArr[1] = TextUtils.isEmpty(aVar.ald()) ? "" : aVar.ald();
        objArr[2] = Integer.valueOf(aVar.alc());
        w.i(str, str2, objArr);
        this.kPo.a(aVar);
    }

    public final void E(String str, String str2, String str3) {
        this.kOZ = new g(str, str2, str3);
        ap.vd().a(this.kOZ, 0);
    }

    public final void alT() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.kPg != null && i >= 0 && i < this.kPg.getCount()) {
            f lj = this.kPg.lj(i);
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
                intent.putExtra("preceding_scence", 4);
                intent.putExtra("call_by", 1);
                intent.putExtra("download_entrance_scene", 9);
                intent.putExtra("check_clickflag", true);
                intent.putExtra("extra_status", lj.mStatus);
                intent.putExtra("extra_progress", lj.sd);
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (!bg.mA(stringExtra)) {
                    intent.putExtra("to_talker_name", stringExtra);
                }
            }
            startActivity(intent);
        }
    }
}
