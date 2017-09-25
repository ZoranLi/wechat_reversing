package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.luckymoney.b.aa;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@a(3)
public class LuckyMoneyBusiDetailUI extends LuckyMoneyBaseUI {
    private View QB;
    private TextView kBi;
    private TextView kCp;
    private boolean kOH = false;
    private View kPJ;
    private ImageView nqi;
    private TextView nqk;
    private String nqq;
    private String nqr;
    private ListView nra;
    private TextView nrb;
    private View nrc;
    private TextView nrd;
    private LuckyMoneyWishFooter nre;
    private View nrf;
    private ImageView nrg;
    private View nrh;
    private ImageView nri;
    private boolean nrj = true;
    private int nrk;
    private String nrl;
    private String nrm;
    private int nrn = 0;
    private List<m> nro = new LinkedList();
    private Map<String, Integer> nrp = new HashMap();
    private i nrq;
    private String nrr = "";
    private boolean nrs = false;
    OnScrollListener nrt = new OnScrollListener(this) {
        private boolean nru = false;
        private boolean nrv;
        final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

        {
            this.nrw = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                            if (!this.nrw.nqY.aHU()) {
                                this.nrw.kOH = false;
                            }
                            if (this.nrw.nrj && !this.nrw.kOH) {
                                this.nrw.aIt();
                            }
                        }
                        this.nru = false;
                        return;
                    case 1:
                        this.nru = true;
                        return;
                    default:
                        return;
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 0 && this.nru) {
                if (i <= 0) {
                    int top;
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null) {
                        top = 0 - childAt.getTop();
                    } else {
                        top = 0;
                    }
                    if (top <= 100) {
                        z = false;
                    }
                }
                if (this.nrv != z) {
                    if (z) {
                        this.nrw.r(this.nrw.getResources().getDrawable(R.g.bgs));
                    } else {
                        this.nrw.r(null);
                    }
                    this.nrv = z;
                }
            }
        }
    };
    private int wa = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nra = (ListView) findViewById(R.h.bvx);
        this.nrq = new i(this.uSU.uTo);
        this.QB = LayoutInflater.from(this).inflate(R.i.dha, null);
        this.nra.addHeaderView(this.QB);
        this.nra.setAdapter(this.nrq);
        this.QB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void onClick(View view) {
                this.nrw.aIu();
            }
        });
        this.nra.setOnScrollListener(this.nrt);
        this.nra.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.nrw.aIu();
            }
        });
        this.kPJ = LayoutInflater.from(this).inflate(R.i.dgZ, null);
        this.nqi = (ImageView) this.QB.findViewById(R.h.bvg);
        this.nrb = (TextView) this.QB.findViewById(R.h.bvA);
        this.nqk = (TextView) this.QB.findViewById(R.h.bvC);
        this.nrc = this.QB.findViewById(R.h.bvf);
        this.nrd = (TextView) this.QB.findViewById(R.h.bve);
        this.nrf = this.QB.findViewById(R.h.bvn);
        this.kCp = (TextView) this.QB.findViewById(R.h.bvz);
        this.nrg = (ImageView) this.QB.findViewById(R.h.bvo);
        this.kBi = (TextView) this.QB.findViewById(R.h.bvj);
        this.nrh = this.QB.findViewById(R.h.bvv);
        this.nri = (ImageView) this.QB.findViewById(R.h.bvd);
        ImageView imageView = (ImageView) findViewById(R.h.bvi);
        this.nre = (LuckyMoneyWishFooter) findViewById(R.h.bvB);
        this.nre.a(new MMEditText.a(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void aIv() {
                if (this.nrw.nre.getVisibility() == 0) {
                    this.nrw.nre.setVisibility(8);
                } else {
                    this.nrw.uSU.uTo.finish();
                }
            }
        });
        this.nre.a(new LuckyMoneyWishFooter.a(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void zO(String str) {
                if (!bg.mA(str) && !bg.mA(this.nrw.nrl)) {
                    this.nrw.k(new aa(this.nrw.nqq, str, this.nrw.nrl, "v1.0"));
                    this.nrw.aIu();
                }
            }
        });
        this.nre.post(new Runnable(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void run() {
                j.f(this.nrw);
            }
        });
        this.nre.uRI = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void nx(int i) {
                if (i == -2 && this.nrw.nre.nuS) {
                    this.nrw.nre.nuS = false;
                }
            }
        };
        this.nrq.nux = new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void onClick(View view) {
                this.nrw.nre.setVisibility(0);
            }
        };
        i iVar = this.nrq;
        iVar.nuz = new a(iVar);
        this.nre.aIK();
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

            {
                this.nrw = r1;
            }

            public final void onClick(View view) {
                this.nrw.finish();
            }
        });
        View findViewById = findViewById(R.h.bvh);
        if (findViewById != null) {
            Drawable background = findViewById.getBackground();
            if (background != null && (background instanceof BitmapDrawable)) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) background;
                bitmapDrawable.mutate();
                bitmapDrawable.setTileModeX(TileMode.REPEAT);
            }
        }
        this.nqq = getIntent().getStringExtra("key_sendid");
        this.nqr = getIntent().getStringExtra("key_native_url");
        this.nrk = getIntent().getIntExtra("key_jump_from", 2);
        this.nrn = getIntent().getIntExtra("key_static_from_scene", 0);
        w.i("MicroMsg.LuckyMoneyDetailUI", "initData: sendid=%s , nativeurl=%s, jumpFrom=%d", new Object[]{this.nqq, this.nqr, Integer.valueOf(this.nrk)});
        if (this.nrk == 2) {
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_detail_info");
                if (byteArrayExtra != null) {
                    e eVar = (e) new e().aD(byteArrayExtra);
                    if (eVar != null) {
                        a(eVar);
                        if (getIntent().getBooleanExtra("play_sound", false)) {
                            k.B(this, R.l.exe);
                        }
                    }
                }
            } catch (Exception e) {
                w.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bg.mA(this.nqq) && !bg.mA(this.nqr)) {
            try {
                this.nqq = Uri.parse(this.nqr).getQueryParameter("sendid");
            } catch (Exception e2) {
                w.w("MicroMsg.LuckyMoneyDetailUI", "initData: parse uri exp:" + e2.getLocalizedMessage());
            }
        }
        if (bg.mA(this.nqq)) {
            w.w("MicroMsg.LuckyMoneyDetailUI", "sendid null or nil, finish");
        } else {
            aIt();
        }
        if (getIntent().getBooleanExtra("play_sound", false)) {
            k.B(this, R.l.exe);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.nre.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.nre.setVisibility(8);
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof u) {
            if (i == 0 && i2 == 0) {
                u uVar = (u) kVar;
                e eVar = uVar.nnk;
                this.nrr = uVar.nnw;
                a(eVar);
                return true;
            }
            g.bl(this, str);
            return true;
        } else if (kVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                g.bl(this, getString(R.l.esl));
                this.nrq.nuw = false;
                aIu();
                aa aaVar = (aa) kVar;
                if (this.nro != null) {
                    for (int i3 = 0; i3 < this.nro.size(); i3++) {
                        m mVar = (m) this.nro.get(i3);
                        if (mVar.nmp.equalsIgnoreCase(aaVar.nmp)) {
                            mVar.nmZ = aaVar.nmh;
                            this.nrq.notifyDataSetChanged();
                            break;
                        }
                    }
                }
                return true;
            }
            g.bl(this, str);
            return true;
        } else if (!(kVar instanceof af)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                g.bl(this, getString(R.l.esl));
                return true;
            }
            g.bl(this, str);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bg.mA(stringExtra)) {
                        if (this.nrm != null && this.nrm.startsWith("wxpay://c2cbizmessagehandler/hongbao/festivalhongbao")) {
                            w.i("MicroMsg.LuckyMoneyDetailUI", "Not expected branch since 2015 fesitval");
                            break;
                        } else {
                            k(new af(stringExtra.replaceAll(",", "|"), this.nqq, "v1.0"));
                            break;
                        }
                    }
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void finish() {
        if (getIntent().hasExtra("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) getIntent().getParcelableExtra("key_realname_guide_helper");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyBusiDetailUI");
            boolean a = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyBusiDetailUI nrw;

                {
                    this.nrw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                }
            });
            getIntent().removeExtra("key_realname_guide_helper");
            if (!a) {
                super.finish();
                return;
            }
            return;
        }
        super.finish();
    }

    protected final int getLayoutId() {
        return R.i.dhb;
    }

    private void aIt() {
        this.kOH = true;
        if (this.wa <= 0 || this.nro.size() <= 0 || this.nro.get(this.nro.size() - 1) == null) {
            this.nrr = "";
            k(new u(this.nqq, 11, this.wa, this.nqr, "v1.0", this.nrr));
            return;
        }
        k(new u(this.nqq, this.wa, this.nqr, bg.getLong(((m) this.nro.get(this.nro.size() - 1)).nmL, 0), "v1.0", this.nrr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.tencent.mm.plugin.luckymoney.b.e r13) {
        /*
        r12 = this;
        if (r13 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r13.nms;
        r1 = 1;
        if (r0 != r1) goto L_0x0339;
    L_0x0008:
        r0 = 1;
    L_0x0009:
        r12.nrj = r0;
        r0 = r12.wa;
        if (r0 != 0) goto L_0x023d;
    L_0x000f:
        r0 = r13.nmp;
        r12.nrl = r0;
        r0 = r12.nrq;
        r1 = r12.nrl;
        r0.nuv = r1;
        r0 = r12.nrq;
        r1 = r13.nmA;
        r0.nuy = r1;
        if (r13 == 0) goto L_0x00eb;
    L_0x0021:
        r0 = r12.uSU;
        r0 = r0.uTo;
        r1 = r13.nmA;
        r2 = 2;
        if (r1 != r2) goto L_0x0344;
    L_0x002a:
        r1 = r12.nqi;
        r2 = com.tencent.mm.R.g.bgw;
        r1.setImageResource(r2);
        r1 = r13.resourceId;
        if (r1 == 0) goto L_0x033c;
    L_0x0035:
        r1 = "MicroMsg.LuckyMoneyDetailUI";
        r2 = new java.lang.StringBuilder;
        r3 = "busi logo load from file:";
        r2.<init>(r3);
        r3 = r13.resourceId;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);
        r1 = new com.tencent.mm.e.a.ha;
        r1.<init>();
        r2 = r1.fMr;
        r3 = r13.resourceId;
        r2.fMt = r3;
        r2 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$3;
        r2.<init>(r12, r1, r13);
        r1.nFq = r2;
        r2 = com.tencent.mm.sdk.b.a.urY;
        r3 = android.os.Looper.myLooper();
        r2.a(r1, r3);
    L_0x0068:
        r1 = r12.nrb;
        r2 = r13.nmi;
        com.tencent.mm.plugin.luckymoney.b.n.a(r0, r1, r2);
        r1 = r12.nqk;
        r2 = r13.nmh;
        com.tencent.mm.plugin.luckymoney.b.n.a(r0, r1, r2);
        r0 = r13.fZH;
        r1 = 2;
        if (r0 != r1) goto L_0x0356;
    L_0x007b:
        r0 = r12.nrk;
        r1 = 3;
        if (r0 == r1) goto L_0x0356;
    L_0x0080:
        r0 = r12.nrd;
        r2 = r13.fZT;
        r2 = (double) r2;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 / r4;
        r1 = com.tencent.mm.wallet_core.ui.e.n(r2);
        r0.setText(r1);
        r0 = r13.nmq;
        r1 = 1;
        if (r0 == r1) goto L_0x034f;
    L_0x0094:
        r0 = r12.nrq;
        r1 = 1;
        r0.nuw = r1;
    L_0x0099:
        r0 = r12.nrc;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x009f:
        r0 = r13.njC;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0382;
    L_0x00a7:
        r0 = r12.nrf;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r12.kCp;
        r1 = r13.njC;
        r0.setText(r1);
        r0 = r13.njA;
        r1 = 1;
        if (r0 != r1) goto L_0x0368;
    L_0x00b9:
        r0 = r13.njB;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x035f;
    L_0x00c1:
        r0 = r13.njB;
        r1 = "weixin://wxpay";
        r0 = r0.startsWith(r1);
        if (r0 != 0) goto L_0x035f;
    L_0x00cc:
        r0 = r12.nrg;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x00d2:
        r0 = r12.kCp;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$4;
        r1.<init>(r12, r13);
        r0.setOnClickListener(r1);
    L_0x00dc:
        r0 = r13.nmt;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0394;
    L_0x00e4:
        r0 = r12.kBi;
        r1 = r13.nmt;
        r0.setText(r1);
    L_0x00eb:
        if (r13 == 0) goto L_0x0206;
    L_0x00ed:
        r4 = r13.nmw;
        if (r4 == 0) goto L_0x01da;
    L_0x00f1:
        r0 = r4.size();
        if (r0 <= 0) goto L_0x01da;
    L_0x00f7:
        r0 = r12.QB;
        r1 = com.tencent.mm.R.h.bvs;
        r5 = r0.findViewById(r1);
        r0 = r12.QB;
        r1 = com.tencent.mm.R.h.bvt;
        r6 = r0.findViewById(r1);
        r0 = r12.QB;
        r1 = com.tencent.mm.R.h.bvu;
        r7 = r0.findViewById(r1);
        r0 = r12.QB;
        r1 = com.tencent.mm.R.h.bvp;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = r12.QB;
        r2 = com.tencent.mm.R.h.bvq;
        r1 = r1.findViewById(r2);
        r1 = (android.view.ViewGroup) r1;
        r2 = r12.QB;
        r3 = com.tencent.mm.R.h.bvr;
        r2 = r2.findViewById(r3);
        r2 = (android.view.ViewGroup) r2;
        r3 = r12.QB;
        r8 = com.tencent.mm.R.h.bvk;
        r8 = r3.findViewById(r8);
        r3 = r12.QB;
        r9 = com.tencent.mm.R.h.bvl;
        r9 = r3.findViewById(r9);
        r10 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r10.<init>();
        r3 = r12.getResources();
        r11 = com.tencent.mm.R.e.aUK;
        r3 = r3.getColor(r11);
        r10.textColor = r3;
        r3 = 1;
        r10.ntV = r3;
        r3 = r13.resourceId;
        r10.resourceId = r3;
        r3 = r12.nrn;
        r10.ntW = r3;
        r3 = r4.size();
        if (r3 <= 0) goto L_0x016d;
    L_0x015f:
        r3 = 0;
        r3 = r4.get(r3);
        r3 = (com.tencent.mm.plugin.luckymoney.b.ag) r3;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r3, r10);
        r0 = 0;
        r5.setVisibility(r0);
    L_0x016d:
        r0 = r4.size();
        r3 = 1;
        if (r0 <= r3) goto L_0x0182;
    L_0x0174:
        r0 = 1;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.b.ag) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r1, r0, r10);
        r0 = 0;
        r6.setVisibility(r0);
    L_0x0182:
        r0 = r4.size();
        r1 = 2;
        if (r0 <= r1) goto L_0x0197;
    L_0x0189:
        r0 = 2;
        r0 = r4.get(r0);
        r0 = (com.tencent.mm.plugin.luckymoney.b.ag) r0;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r2, r0, r10);
        r0 = 0;
        r7.setVisibility(r0);
    L_0x0197:
        r0 = r5.getVisibility();
        if (r0 != 0) goto L_0x01ad;
    L_0x019d:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01a9;
    L_0x01a3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01ad;
    L_0x01a9:
        r0 = 0;
        r8.setVisibility(r0);
    L_0x01ad:
        r0 = r6.getVisibility();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b3:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b9:
        r0 = 0;
        r9.setVisibility(r0);
    L_0x01bd:
        r0 = r5.getVisibility();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c3:
        r0 = r6.getVisibility();
        if (r0 == 0) goto L_0x01cf;
    L_0x01c9:
        r0 = r7.getVisibility();
        if (r0 != 0) goto L_0x01da;
    L_0x01cf:
        r0 = r12.nrh;
        r0.requestLayout();
        r0 = r12.nrh;
        r1 = 0;
        r0.setVisibility(r1);
    L_0x01da:
        r0 = r12.kPJ;
        r1 = com.tencent.mm.R.h.bvm;
        r0 = r0.findViewById(r1);
        r0 = (android.view.ViewGroup) r0;
        r1 = new com.tencent.mm.plugin.luckymoney.ui.g$c;
        r1.<init>();
        r2 = r12.getResources();
        r3 = com.tencent.mm.R.e.aUK;
        r2 = r2.getColor(r3);
        r1.textColor = r2;
        r2 = r12.getResources();
        r3 = com.tencent.mm.R.f.aXU;
        r2 = r2.getDimensionPixelSize(r3);
        r1.textSize = r2;
        r2 = r13.nmx;
        com.tencent.mm.plugin.luckymoney.ui.g.a(r12, r0, r2, r1);
    L_0x0206:
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.nmA;
        r4 = oV(r4);
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = 0;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.i(r1, r2);
    L_0x023d:
        if (r13 == 0) goto L_0x0304;
    L_0x023f:
        r0 = r13.fZG;
        r1 = 3;
        if (r0 == r1) goto L_0x0249;
    L_0x0244:
        r0 = r13.fZG;
        r1 = 2;
        if (r0 != r1) goto L_0x039c;
    L_0x0249:
        r0 = r13.nmr;
        r1 = 1;
        if (r0 != r1) goto L_0x039c;
    L_0x024e:
        r0 = r12.nrj;
        if (r0 != 0) goto L_0x039c;
    L_0x0252:
        r0 = r13.nmu;
        r1 = 1;
        if (r0 != r1) goto L_0x039c;
    L_0x0257:
        r0 = 1;
        r1 = r0;
    L_0x0259:
        r0 = r13.nmv;
        if (r0 == 0) goto L_0x03a0;
    L_0x025d:
        r0 = r13.nmv;
        r0 = r0.gPD;
        r2 = 1;
        if (r0 != r2) goto L_0x03a0;
    L_0x0264:
        r0 = r13.nmv;
        r0 = r0.nlP;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x03a0;
    L_0x026e:
        r0 = 1;
        r2 = r0;
    L_0x0270:
        r0 = r12.kPJ;
        r3 = com.tencent.mm.R.h.bvy;
        r0 = r0.findViewById(r3);
        r0 = (android.widget.TextView) r0;
        if (r1 != 0) goto L_0x027e;
    L_0x027c:
        if (r2 == 0) goto L_0x03a4;
    L_0x027e:
        r1 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$5;
        r1.<init>(r12, r13);
        r0.setOnClickListener(r1);
        if (r2 == 0) goto L_0x0295;
    L_0x0288:
        r1 = r13.nmv;
        r1 = r1.nlP;
        r12.nrm = r1;
        r1 = r13.nmv;
        r1 = r1.nlQ;
        r0.setText(r1);
    L_0x0295:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 11701; // 0x2db5 float:1.6397E-41 double:5.781E-320;
        r3 = 5;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r13.nmA;
        r5 = oV(r5);
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 3;
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = 2;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r1.i(r2, r3);
        r1 = 0;
        r0.setVisibility(r1);
    L_0x02d0:
        r1 = r12.kPJ;
        r2 = com.tencent.mm.R.h.bvw;
        r1 = r1.findViewById(r2);
        r1 = (android.widget.TextView) r1;
        r2 = r12.nrk;
        r3 = 1;
        if (r2 == r3) goto L_0x03ab;
    L_0x02df:
        r2 = r12.nrk;
        r3 = 3;
        if (r2 == r3) goto L_0x03ab;
    L_0x02e4:
        r0 = r0.getVisibility();
        if (r0 == 0) goto L_0x03ab;
    L_0x02ea:
        r0 = new com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI$6;
        r0.<init>(r12, r13);
        r1.setOnClickListener(r0);
        r0 = 0;
        r1.setVisibility(r0);
    L_0x02f6:
        r0 = r12.nrs;
        if (r0 != 0) goto L_0x0304;
    L_0x02fa:
        r0 = r12.nra;
        r1 = r12.kPJ;
        r0.addFooterView(r1);
        r0 = 1;
        r12.nrs = r0;
    L_0x0304:
        r2 = r13.nmB;
        if (r2 == 0) goto L_0x03c5;
    L_0x0308:
        r0 = 0;
        r1 = r0;
    L_0x030a:
        r0 = r2.size();
        if (r1 >= r0) goto L_0x03b2;
    L_0x0310:
        r0 = r2.get(r1);
        r0 = (com.tencent.mm.plugin.luckymoney.b.m) r0;
        r3 = r12.nrp;
        r4 = r0.nmp;
        r3 = r3.containsKey(r4);
        if (r3 != 0) goto L_0x0335;
    L_0x0320:
        r3 = r12.nro;
        r4 = r2.get(r1);
        r3.add(r4);
        r3 = r12.nrp;
        r0 = r0.nmp;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r0, r4);
    L_0x0335:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x030a;
    L_0x0339:
        r0 = 0;
        goto L_0x0009;
    L_0x033c:
        r1 = r13.nmj;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 != 0) goto L_0x0068;
    L_0x0344:
        r1 = r12.nqi;
        r2 = r13.nmj;
        r3 = r13.nmD;
        com.tencent.mm.plugin.luckymoney.b.n.a(r1, r2, r3);
        goto L_0x0068;
    L_0x034f:
        r0 = r12.nrq;
        r1 = 0;
        r0.nuw = r1;
        goto L_0x0099;
    L_0x0356:
        r0 = r12.nrc;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x009f;
    L_0x035f:
        r0 = r12.nrg;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00d2;
    L_0x0368:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.jumpChange is false";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r12.kCp;
        r1 = r12.getResources();
        r2 = com.tencent.mm.R.e.aUQ;
        r1 = r1.getColor(r2);
        r0.setTextColor(r1);
        goto L_0x00dc;
    L_0x0382:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "detail.changeWording is empty";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r12.nrf;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00dc;
    L_0x0394:
        r0 = r12.kBi;
        r1 = 0;
        r0.setText(r1);
        goto L_0x00eb;
    L_0x039c:
        r0 = 0;
        r1 = r0;
        goto L_0x0259;
    L_0x03a0:
        r0 = 0;
        r2 = r0;
        goto L_0x0270;
    L_0x03a4:
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x02d0;
    L_0x03ab:
        r0 = 8;
        r1.setVisibility(r0);
        goto L_0x02f6;
    L_0x03b2:
        r0 = r12.wa;
        r1 = r2.size();
        r0 = r0 + r1;
        r12.wa = r0;
        r0 = 0;
        r12.kOH = r0;
        r0 = r12.nrq;
        r1 = r12.nro;
        r0.aP(r1);
    L_0x03c5:
        r0 = r13.nmz;
        r1 = r13.nmC;
        r2 = r12.nri;
        r3 = com.tencent.mm.R.g.bgv;
        r2.setImageResource(r3);
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r2 == 0) goto L_0x043a;
    L_0x03d6:
        r0 = "MicroMsg.LuckyMoneyDetailUI";
        r1 = "renderAdImage: no adImage";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r12.nri;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x03e6:
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 13051; // 0x32fb float:1.8288E-41 double:6.448E-320;
        r2 = 10;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r12.nrn;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r13.nmz;
        r2[r3] = r4;
        r3 = 3;
        r4 = r13.nmw;
        r4 = com.tencent.mm.plugin.luckymoney.b.n.aO(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = "";
        r2[r3] = r4;
        r3 = 5;
        r4 = "";
        r2[r3] = r4;
        r3 = 6;
        r4 = "";
        r2[r3] = r4;
        r3 = 7;
        r4 = "";
        r2[r3] = r4;
        r3 = 8;
        r4 = r13.nmi;
        r2[r3] = r4;
        r3 = 9;
        r4 = r13.resourceId;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.i(r1, r2);
        goto L_0x0002;
    L_0x043a:
        r2 = new android.util.DisplayMetrics;
        r2.<init>();
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r2 = r2.getResources();
        r2 = r2.getDisplayMetrics();
        if (r2 == 0) goto L_0x047b;
    L_0x044d:
        r2 = r2.widthPixels;
        r3 = r12.getResources();
        r4 = com.tencent.mm.R.f.bao;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r3 = r12.getResources();
        r4 = com.tencent.mm.R.f.ban;
        r3 = r3.getDimensionPixelSize(r4);
        r3 = r3 * 2;
        r2 = r2 - r3;
        r2 = (float) r2;
        r3 = 1061158912; // 0x3f400000 float:0.75 double:5.24282163E-315;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r12.nri;
        r3 = r3.getLayoutParams();
        r3.height = r2;
        r2 = r12.nri;
        r2.setLayoutParams(r3);
    L_0x047b:
        r2 = r12.nri;
        r3 = 0;
        com.tencent.mm.plugin.luckymoney.b.n.a(r2, r0, r1, r3);
        r0 = r12.nri;
        r1 = 0;
        r0.setVisibility(r1);
        goto L_0x03e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.a(com.tencent.mm.plugin.luckymoney.b.e):void");
    }

    private void aIu() {
        if (this.nre != null && this.nre.getVisibility() != 8) {
            this.nre.setVisibility(8);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nre != null) {
            this.nre.aIL();
        }
    }

    private static int oV(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
