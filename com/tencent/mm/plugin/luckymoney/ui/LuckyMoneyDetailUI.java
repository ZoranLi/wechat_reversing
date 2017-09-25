package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.ha;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.aa;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.u;
import com.tencent.mm.plugin.luckymoney.particles.a.a;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.x.h;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private View QB;
    private long jXw = 0;
    private TextView kBi;
    private TextView kCp;
    private boolean kOH = false;
    private View kPJ;
    private ImageView llY;
    private SoundPool njl;
    private b nkI = new b(this) {
        final /* synthetic */ LuckyMoneyDetailUI nsp;

        {
            this.nsp = r1;
        }

        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            switch (random.nextInt(8)) {
                case 0:
                    if (this.nsp.nsk == null) {
                        this.nsp.nsk = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgD), 28, 28, false);
                    }
                    return new a(this.nsp.nsk);
                case 1:
                    if (this.nsp.nsl == null) {
                        this.nsp.nsl = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgE), 28, 28, false);
                    }
                    return new a(this.nsp.nsl);
                case 2:
                    if (this.nsp.nsm == null) {
                        this.nsp.nsm = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgF), 28, 28, false);
                    }
                    return new a(this.nsp.nsm);
                case 3:
                    if (this.nsp.nsf == null) {
                        this.nsp.nsf = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgy), 28, 28, false);
                    }
                    return new a(this.nsp.nsf);
                case 4:
                    if (this.nsp.nsg == null) {
                        this.nsp.nsg = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgz), 28, 28, false);
                    }
                    return new a(this.nsp.nsg);
                case 5:
                    if (this.nsp.nsh == null) {
                        this.nsp.nsh = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgA), 28, 28, false);
                    }
                    return new a(this.nsp.nsh);
                case 6:
                    if (this.nsp.nsi == null) {
                        this.nsp.nsi = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgB), 28, 28, false);
                    }
                    return new a(this.nsp.nsi);
                case 7:
                    if (this.nsp.nsj == null) {
                        this.nsp.nsj = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.nsp.getResources(), R.g.bgC), 28, 28, false);
                    }
                    return new a(this.nsp.nsj);
                default:
                    return null;
            }
        }
    };
    private ImageView nqi;
    private TextView nqk;
    private String nqq;
    private String nqr;
    private ImageView nrW;
    private ImageView nrX;
    private View nrY;
    private ImageView nrZ;
    private ListView nra;
    private TextView nrb;
    private View nrc;
    private TextView nrd;
    private LuckyMoneyWishFooter nre;
    private View nrf;
    private ImageView nrg;
    private View nrh;
    private boolean nrj = true;
    private int nrk;
    private String nrl;
    private String nrm;
    private List<m> nro = new LinkedList();
    private Map<String, Integer> nrp = new HashMap();
    private i nrq;
    private String nrr = "";
    private boolean nrs = false;
    OnScrollListener nrt = new OnScrollListener(this) {
        private boolean nru = false;
        private boolean nrv;
        final /* synthetic */ LuckyMoneyDetailUI nsp;

        {
            this.nsp = r2;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                            if (!this.nsp.nqY.aHU()) {
                                this.nsp.kOH = false;
                            }
                            if (this.nsp.nrj && !this.nsp.kOH) {
                                this.nsp.aIt();
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
                        this.nsp.r(this.nsp.getResources().getDrawable(R.g.bgs));
                    } else {
                        this.nsp.r(null);
                    }
                    this.nrv = z;
                }
            }
        }
    };
    private TextView nsa;
    private View nsb;
    private RelativeLayout nsc;
    private int[] nsd;
    private ViewGroup nse;
    private Bitmap nsf;
    private Bitmap nsg;
    private Bitmap nsh;
    private Bitmap nsi;
    private Bitmap nsj;
    private Bitmap nsk;
    private Bitmap nsl;
    private Bitmap nsm;
    private final int nsn = 750;
    private final int nso = 240;
    private int wa = 0;

    static /* synthetic */ void v(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics = luckyMoneyDetailUI.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            w.i("MicroMsg.LuckyMoneyDetailUI", "hy: screen  width: %d, scale : %f, fixedHeight: %d", new Object[]{Integer.valueOf(displayMetrics.widthPixels), Double.valueOf(((double) displayMetrics.widthPixels) / 750.0d), Integer.valueOf((int) (240.0d * (((double) displayMetrics.widthPixels) / 750.0d)))});
            luckyMoneyDetailUI.nsc.setLayoutParams(new LayoutParams(luckyMoneyDetailUI.nsc.getLayoutParams().width, r1));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        this.nqq = getIntent().getStringExtra("key_sendid");
        this.nqr = getIntent().getStringExtra("key_native_url");
        this.nrk = getIntent().getIntExtra("key_jump_from", 2);
        w.i("MicroMsg.LuckyMoneyDetailUI", "sendid=" + bg.mz(this.nqq) + ", nativeurl=" + bg.mz(this.nqr) + ", jumpFrom=" + this.nrk);
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
                w.w("MicroMsg.LuckyMoneyDetailUI", "Parse LuckyMoneyDetail fail!" + e.getLocalizedMessage());
            }
        }
        if (bg.mA(this.nqq) && !bg.mA(this.nqr)) {
            try {
                this.nqq = Uri.parse(this.nqr).getQueryParameter("sendid");
            } catch (Exception e2) {
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

    protected void onResume() {
        super.onResume();
        this.jXw = bg.Ny();
    }

    protected void onPause() {
        super.onPause();
        d.d("LuckyMoneyDetailUI", this.jXw, bg.Ny());
    }

    protected final void KC() {
        zi(R.l.exn);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nsp.finish();
                return true;
            }
        });
        this.nra = (ListView) findViewById(R.h.cef);
        this.nrq = new i(this.uSU.uTo);
        this.QB = LayoutInflater.from(this).inflate(R.i.dhe, null);
        this.nra.addHeaderView(this.QB);
        this.nra.setAdapter(this.nrq);
        this.QB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void onClick(View view) {
                this.nsp.aIu();
            }
        });
        this.nra.setOnScrollListener(this.nrt);
        this.nra.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.nsp.aIu();
            }
        });
        this.kPJ = LayoutInflater.from(this).inflate(R.i.dhd, null);
        this.nqi = (ImageView) this.QB.findViewById(R.h.ceh);
        this.nrb = (TextView) this.QB.findViewById(R.h.cek);
        this.nrW = (ImageView) this.QB.findViewById(R.h.cdS);
        this.nqk = (TextView) this.QB.findViewById(R.h.cem);
        this.nrc = this.QB.findViewById(R.h.cdL);
        this.nrd = (TextView) this.QB.findViewById(R.h.cdK);
        this.nrf = this.QB.findViewById(R.h.cdU);
        this.kCp = (TextView) this.QB.findViewById(R.h.cei);
        this.nrg = (ImageView) this.QB.findViewById(R.h.cdT);
        this.kBi = (TextView) this.QB.findViewById(R.h.cdO);
        this.nrX = (ImageView) this.QB.findViewById(R.h.cej);
        this.nrh = this.QB.findViewById(R.h.ced);
        this.nrY = this.QB.findViewById(R.h.cdN);
        this.nrZ = (ImageView) this.QB.findViewById(R.h.cdM);
        this.nsa = (TextView) this.QB.findViewById(R.h.cdV);
        this.nsb = findViewById(R.h.cdW);
        this.nsc = (RelativeLayout) this.QB.findViewById(R.h.cdN);
        this.llY = (ImageView) this.QB.findViewById(R.h.cdM);
        this.nre = (LuckyMoneyWishFooter) findViewById(R.h.cel);
        this.nse = (ViewGroup) findViewById(R.h.ceq);
        this.nre.a(new MMEditText.a(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void aIv() {
                if (this.nsp.nre.getVisibility() == 0) {
                    this.nsp.nre.setVisibility(8);
                } else {
                    this.nsp.uSU.uTo.finish();
                }
            }
        });
        this.nre.a(new LuckyMoneyWishFooter.a(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void zO(String str) {
                if (!bg.mA(str) && !bg.mA(this.nsp.nrl)) {
                    this.nsp.k(new aa(this.nsp.nqq, str, this.nsp.nrl, "v1.0"));
                    this.nsp.aIu();
                }
            }
        });
        this.nre.post(new Runnable(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void run() {
                j.f(this.nsp);
            }
        });
        this.nre.uRI = new KeyboardLinearLayout.a(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void nx(int i) {
                if (i == -2 && this.nsp.nre.nuS) {
                    this.nsp.nre.nuS = false;
                }
            }
        };
        this.nrq.nux = new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void onClick(View view) {
                this.nsp.nre.setVisibility(0);
            }
        };
        this.nre.aIK();
        this.nsa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyDetailUI nsp;

            {
                this.nsp = r1;
            }

            public final void onClick(View view) {
                this.nsp.nre.setVisibility(0);
            }
        });
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
                    if (this.nsa.getVisibility() == 0) {
                        this.nsa.setVisibility(8);
                        this.kBi.setVisibility(0);
                        this.nsb.setVisibility(8);
                        this.nrq.aP(this.nro);
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
                com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.esl));
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
            bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyDetailUI");
            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
            boolean a = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyDetailUI nsp;

                {
                    this.nsp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.LuckyMoneyDetailUI", "RealnameGuideHelper dialog click cancel");
                    super.finish();
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
        return R.i.dhf;
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

    private void a(final e eVar) {
        if (eVar != null) {
            this.nrj = eVar.nms == 1;
            if (this.wa == 0) {
                this.nrl = eVar.nmp;
                Object obj = (eVar == null || eVar.nme != 0 || eVar.nmB == null || eVar.nmB.size() <= 0 || !((m) eVar.nmB.get(0)).nmp.equals(this.nrl) || eVar.nmq == 1) ? null : 1;
                if (obj != null) {
                    this.nrq.nuw = false;
                    this.nsa.setVisibility(0);
                    this.nsb.setVisibility(0);
                    this.kBi.setVisibility(8);
                } else {
                    this.kBi.setVisibility(0);
                    this.nrq.nuv = this.nrl;
                }
                this.nrq.nuy = eVar.nmA;
                if (eVar != null) {
                    Context context = this.uSU.uTo;
                    if (eVar.nmA == 2) {
                        this.nqi.setImageResource(R.g.bgw);
                        if (eVar.resourceId != 0) {
                            w.i("MicroMsg.LuckyMoneyDetailUI", "busi logo load from file:" + eVar.resourceId);
                            final com.tencent.mm.sdk.b.b haVar = new ha();
                            haVar.fMr.fMt = eVar.resourceId;
                            haVar.nFq = new Runnable(this) {
                                final /* synthetic */ LuckyMoneyDetailUI nsp;

                                public final void run() {
                                    if (haVar.fMs.fMu) {
                                        w.i("MicroMsg.LuckyMoneyDetailUI", "Get res Ok, path=" + haVar.fMs.fMv);
                                        n.e(this.nsp.nqi, haVar.fMs.fMv, R.g.bgw);
                                        return;
                                    }
                                    w.i("MicroMsg.LuckyMoneyDetailUI", "Get res fail & load from url.");
                                    n.a(this.nsp.nqi, eVar.nmj, eVar.nmD);
                                }
                            };
                            com.tencent.mm.sdk.b.a.urY.a(haVar, Looper.myLooper());
                        } else {
                            n.a(this.nqi, eVar.nmj, eVar.nmD);
                        }
                    } else {
                        n.a(this.nqi, eVar.nmj, eVar.nmD);
                    }
                    n.a(context, this.nrb, eVar.nmi);
                    n.a(context, this.nqk, eVar.nmh);
                    if (eVar.nme == 1) {
                        this.nrW.setVisibility(0);
                        this.nrW.setImageResource(R.g.bgI);
                    } else if (eVar.nme == 2) {
                        if (!o.eU(eVar.nmD)) {
                            h hVar = new h();
                            hVar.username = eVar.nmD;
                            com.tencent.mm.x.n.Bm().a(hVar);
                        }
                        this.nrW.setVisibility(0);
                        this.nrW.setImageResource(R.g.bgG);
                    } else {
                        this.nrW.setVisibility(8);
                    }
                    if (!bg.mA(eVar.nmy)) {
                        n.d(this.nrX, eVar.nmy, R.g.bgK);
                        this.nrX.setScaleType(ScaleType.FIT_XY);
                    }
                    if (bg.mA(eVar.nmz)) {
                        w.i("MicroMsg.LuckyMoneyDetailUI", "hy: no bg. set bg area to gone");
                        this.nsc.setVisibility(8);
                    } else {
                        w.i("MicroMsg.LuckyMoneyDetailUI", "hy: has url : %s", new Object[]{eVar.nmz});
                        this.nsc.setVisibility(4);
                        n.f(this.llY, eVar.nmz);
                        com.tencent.mm.sdk.platformtools.af.f(new Runnable(this) {
                            final /* synthetic */ LuckyMoneyDetailUI nsp;

                            {
                                this.nsp = r1;
                            }

                            public final void run() {
                                LuckyMoneyDetailUI.v(this.nsp);
                                this.nsp.nsc.setVisibility(0);
                            }
                        }, 500);
                    }
                    if (eVar.fZH != 2 || this.nrk == 3) {
                        this.nrc.setVisibility(8);
                    } else {
                        this.nrd.setText(com.tencent.mm.wallet_core.ui.e.n(((double) eVar.fZT) / 100.0d));
                        if (eVar.nmq != 1) {
                            this.nrq.nuw = true;
                        } else {
                            this.nrq.nuw = false;
                        }
                        this.nrc.setVisibility(0);
                    }
                    if (bg.mA(eVar.njC)) {
                        w.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeWording is empty");
                        this.nrf.setVisibility(8);
                    } else {
                        this.nrf.setVisibility(0);
                        this.kCp.setText(eVar.njC);
                        if (eVar.njA == 1) {
                            if (TextUtils.isEmpty(eVar.njB) || eVar.njB.startsWith("weixin://wxpay")) {
                                this.nrg.setVisibility(8);
                            } else {
                                this.nrg.setVisibility(0);
                            }
                            this.kCp.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ LuckyMoneyDetailUI nsp;

                                public final void onClick(View view) {
                                    if (TextUtils.isEmpty(eVar.njB)) {
                                        com.tencent.mm.wallet_core.ui.e.CM(12);
                                        com.tencent.mm.pluginsdk.wallet.e.R(this.nsp.uSU.uTo, 1);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13184, new Object[]{Integer.valueOf(0), ""});
                                        w.e("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl is empty");
                                        return;
                                    }
                                    w.i("MicroMsg.LuckyMoneyDetailUI", "detail.changeUrl:" + eVar.njB);
                                    if (eVar.njB.startsWith("weixin://wxpay")) {
                                        com.tencent.mm.wallet_core.ui.e.CM(12);
                                        com.tencent.mm.pluginsdk.wallet.e.R(this.nsp.uSU.uTo, 1);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13184, new Object[]{Integer.valueOf(0), eVar.njB});
                                        return;
                                    }
                                    com.tencent.mm.wallet_core.ui.e.CM(7);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", eVar.njB);
                                    com.tencent.mm.bb.d.b(this.nsp.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13184, new Object[]{Integer.valueOf(1), eVar.njB});
                                }
                            });
                        } else {
                            w.e("MicroMsg.LuckyMoneyDetailUI", "detail.jumpChange is false");
                            this.kCp.setTextColor(getResources().getColor(R.e.aUQ));
                        }
                    }
                    if (bg.mA(eVar.nmt)) {
                        this.kBi.setText(null);
                    } else {
                        this.kBi.setText(eVar.nmt);
                    }
                }
                if (eVar != null) {
                    ViewGroup viewGroup;
                    List list = eVar.nmw;
                    if (list != null && list.size() > 0) {
                        View findViewById = this.QB.findViewById(R.h.cea);
                        View findViewById2 = this.QB.findViewById(R.h.ceb);
                        View findViewById3 = this.QB.findViewById(R.h.cec);
                        viewGroup = (ViewGroup) this.QB.findViewById(R.h.cdX);
                        ViewGroup viewGroup2 = (ViewGroup) this.QB.findViewById(R.h.cdY);
                        ViewGroup viewGroup3 = (ViewGroup) this.QB.findViewById(R.h.cdZ);
                        View findViewById4 = this.QB.findViewById(R.h.cdP);
                        View findViewById5 = this.QB.findViewById(R.h.cdQ);
                        c cVar = new c();
                        cVar.textColor = getResources().getColor(R.e.aUM);
                        if (list.size() > 0) {
                            g.a(this, viewGroup, (ag) list.get(0), cVar);
                            findViewById.setVisibility(0);
                        }
                        if (list.size() > 1) {
                            g.a(this, viewGroup2, (ag) list.get(1), cVar);
                            findViewById2.setVisibility(0);
                        }
                        if (list.size() > 2) {
                            g.a(this, viewGroup3, (ag) list.get(2), cVar);
                            findViewById3.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 && (findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0)) {
                            findViewById4.setVisibility(0);
                        }
                        if (findViewById2.getVisibility() == 0 && findViewById3.getVisibility() == 0) {
                            findViewById5.setVisibility(0);
                        }
                        if (findViewById.getVisibility() == 0 || findViewById2.getVisibility() == 0 || findViewById3.getVisibility() == 0) {
                            this.nrh.requestLayout();
                            this.nrh.setVisibility(0);
                        }
                    }
                    viewGroup = (ViewGroup) this.kPJ.findViewById(R.h.cdR);
                    c cVar2 = new c();
                    cVar2.textColor = getResources().getColor(R.e.aUM);
                    cVar2.textSize = getResources().getDimensionPixelSize(R.f.aXU);
                    g.a(this, viewGroup, eVar.nmx, cVar2);
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(oV(eVar.nmA)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
            }
            if (eVar != null) {
                Object obj2 = ((eVar.fZG == 3 || eVar.fZG == 2) && eVar.nmr == 1 && !this.nrj && eVar.nmu == 1) ? 1 : null;
                Object obj3 = (eVar.nmv == null || eVar.nmv.gPD != 1 || bg.mA(eVar.nmv.nlP)) ? null : 1;
                TextView textView = (TextView) this.kPJ.findViewById(R.h.ceg);
                if (obj2 == null && obj3 == null) {
                    textView.setVisibility(8);
                } else {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyDetailUI nsp;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.oV(eVar.nmA)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                            n.a(this.nsp, 1, false);
                        }
                    });
                    if (obj3 != null) {
                        this.nrm = eVar.nmv.nlP;
                        textView.setText(eVar.nmv.nlQ);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(oV(eVar.nmA)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                    textView.setVisibility(0);
                }
                textView = (TextView) this.kPJ.findViewById(R.h.cee);
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyDetailUI nsp;

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.oV(eVar.nmA)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
                        Intent intent = new Intent();
                        intent.setClass(this.nsp.uSU.uTo, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 2);
                        this.nsp.startActivity(intent);
                    }
                });
                textView.setVisibility(0);
                if (!this.nrs) {
                    this.nra.addFooterView(this.kPJ);
                    this.nrs = true;
                }
            }
            List list2 = eVar.nmB;
            if (list2 != null) {
                for (int i = 0; i < list2.size(); i++) {
                    m mVar = (m) list2.get(i);
                    if (!this.nrp.containsKey(mVar.nmp)) {
                        this.nro.add(list2.get(i));
                        this.nrp.put(mVar.nmp, Integer.valueOf(1));
                    }
                }
                this.wa += list2.size();
                this.kOH = false;
                if (this.nsa.getVisibility() != 0) {
                    this.kBi.setVisibility(0);
                    this.nrq.aP(this.nro);
                }
            }
            if (eVar.nme == 2 && !bg.mA(eVar.nmg)) {
                this.njl = new SoundPool(2, 3, 0);
                this.nsd = new int[2];
                try {
                    this.nsd[0] = this.njl.load(getResources().getAssets().openFd("most_lucky.m4a"), 0);
                    this.nsd[1] = this.njl.load(getResources().getAssets().openFd("whistle.m4a"), 0);
                } catch (IOException e) {
                    w.e("MicroMsg.LuckyMoneyDetailUI", "load lucky money voice fail " + e.getMessage());
                }
                this.njl.setOnLoadCompleteListener(new OnLoadCompleteListener(this) {
                    final /* synthetic */ LuckyMoneyDetailUI nsp;

                    public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                        if (i2 != 0) {
                            return;
                        }
                        if (i == this.nsp.nsd[0]) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        } else if (i == this.nsp.nsd[1] && eVar.fZT >= 19000) {
                            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                    }
                });
                this.QB.postDelayed(new Runnable(this) {
                    final /* synthetic */ LuckyMoneyDetailUI nsp;

                    {
                        this.nsp = r1;
                    }

                    public final void run() {
                        ViewGroup s = this.nsp.nse;
                        b t = this.nsp.nkI;
                        com.tencent.mm.plugin.luckymoney.particles.a aVar = new com.tencent.mm.plugin.luckymoney.particles.a(s);
                        com.tencent.mm.plugin.luckymoney.particles.c X = new com.tencent.mm.plugin.luckymoney.particles.c(s.getContext(), t, new com.tencent.mm.plugin.luckymoney.particles.d(-100, s.getHeight() / 2), s).t(600.0f, 150.0f).u(-1000.0f, 250.0f).W(-200.0f).X(1500.0f);
                        X.noU = 600.0f;
                        X.noV = 300.0f;
                        X = X.aIb();
                        X.nox = com.tencent.mm.plugin.luckymoney.particles.e.aIf();
                        aVar.nol = X.aIc().aId();
                        aVar.w(100, 400);
                        s = this.nsp.nse;
                        t = this.nsp.nkI;
                        aVar = new com.tencent.mm.plugin.luckymoney.particles.a(s);
                        X = new com.tencent.mm.plugin.luckymoney.particles.c(s.getContext(), t, new com.tencent.mm.plugin.luckymoney.particles.d(s.getWidth() + 100, s.getHeight() / 2), s).t(-600.0f, 150.0f).u(-1000.0f, 250.0f).W(200.0f).X(1500.0f);
                        X.noU = 600.0f;
                        X.noV = 300.0f;
                        X = X.aIb();
                        X.nox = com.tencent.mm.plugin.luckymoney.particles.e.aIf();
                        aVar.nol = X.aIc().aId();
                        aVar.w(100, 400);
                    }
                }, 300);
            }
            com.tencent.mm.plugin.wallet_core.model.w wVar = new com.tencent.mm.plugin.wallet_core.model.w();
            wVar.field_mNativeUrl = this.nqr;
            wVar.field_hbType = eVar.nme;
            wVar.field_receiveAmount = eVar.fZT;
            wVar.field_receiveTime = System.currentTimeMillis();
            wVar.field_hbStatus = eVar.fZG;
            wVar.field_receiveStatus = eVar.fZH;
            if (wVar.field_receiveAmount > 0) {
                com.tencent.mm.plugin.wallet_core.model.m.btP().a(wVar);
            }
        }
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
        if (this.njl != null) {
            this.njl.release();
            for (int unload : this.nsd) {
                this.njl.unload(unload);
            }
        }
    }

    private static int oV(int i) {
        if (i == 2) {
            return 13;
        }
        return 7;
    }
}
