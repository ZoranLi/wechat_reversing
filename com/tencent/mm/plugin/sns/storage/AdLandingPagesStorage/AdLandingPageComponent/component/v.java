package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Looper;
import android.support.v4.content.d;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class v extends a {
    public static int qka = 999;
    private Context context;
    private ae hgN;
    int lon = 0;
    public View nRW;
    private long nUp = 0;
    public int pPu = 0;
    public int pPv = 0;
    public int pPw = 0;
    public int qjA;
    private ImageView qjB;
    public boolean qjC = true;
    public boolean qjD;
    private TextView qjE;
    private int qjF = 0;
    private int qjG = 0;
    public int qjH = 0;
    public int qjI = 0;
    private int qjJ = 0;
    public boolean qjK = false;
    ImageView qjL;
    int qjM = 0;
    boolean qjN = true;
    int qjO = 0;
    public int qjP = 0;
    public boolean qjQ = true;
    public boolean qjR = false;
    private boolean qjS = false;
    private boolean qjT = true;
    private boolean qjU = false;
    boolean qjV = true;
    boolean qjW = true;
    public String qjX;
    public boolean qjY;
    public boolean qjZ = false;
    aa qjw = null;
    public OfflineVideoView qjx;
    VideoPlayerSeekBar qjy;
    private ProgressBar qjz;
    public boolean qkb = false;

    public v(final Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
        this.context = context;
        this.hgN = new ae(Looper.getMainLooper());
        this.qjw = new aa(this) {
            final /* synthetic */ v qkc;

            public final void hE(boolean z) {
                Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                intent.putExtra("show", z ? 1 : 0);
                d.k(context).b(intent);
            }
        };
    }

    public final n bgz() {
        return (n) this.qib;
    }

    protected final int aTQ() {
        return g.pHe;
    }

    public final View bgf() {
        LayoutParams layoutParams;
        ViewParent parent;
        boolean z = true;
        if (!e.aO(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dA("adId", ((n) this.qib).qfA))) {
            this.qjV = false;
        }
        if (!e.aO(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + aa.Pq(((n) this.qib).qfz))) {
            this.qjW = false;
        }
        View findViewById = this.ipu.findViewById(f.pEl);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.pEe);
        this.qjx = new OfflineVideoView(this.context);
        viewGroup.addView(this.qjx, 0, new LinearLayout.LayoutParams(-1, -1));
        LayoutParams layoutParams2;
        if (((n) this.qib).qfF != 1) {
            layoutParams2 = new RelativeLayout.LayoutParams((int) ((n) this.qib).width, (int) ((n) this.qib).height);
            findViewById.setPadding((int) ((n) this.qib).qfM, (int) ((n) this.qib).qfK, (int) ((n) this.qib).qfN, (int) ((n) this.qib).qfL);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
        } else if (((int) ((n) this.qib).width) > 0) {
            layoutParams2 = new RelativeLayout.LayoutParams(this.jYp, (this.jYp * ((int) ((n) this.qib).height)) / ((int) ((n) this.qib).width));
            findViewById.setPadding((int) ((n) this.qib).qfM, (int) ((n) this.qib).qfK, (int) ((n) this.qib).qfN, (int) ((n) this.qib).qfL);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.jYp, this.jYq));
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.jYp, this.jYq));
            findViewById.setMinimumHeight(this.jYq);
        }
        String dA = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dA("adId", ((n) this.qib).qfA);
        if (FileOp.aO(dA)) {
            this.qjx.GN(dA);
        } else {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a("adId", ((n) this.qib).qfA, false, 1000000001, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                final /* synthetic */ v qkc;

                {
                    this.qkc = r1;
                }

                public final void bgn() {
                }

                public final void bgo() {
                }

                public final void FW(String str) {
                    this.qkc.qjx.GN(str);
                }
            });
        }
        this.qjE = (TextView) findViewById.findViewById(f.pCv);
        this.qjE.setText(this.context.getString(j.ebM));
        this.nRW = findViewById.findViewById(f.pEp);
        if (this.nRW != null) {
            layoutParams = new RelativeLayout.LayoutParams(this.jYp, this.jYq);
            parent = this.nRW.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.nRW);
            }
            ((ViewGroup) findViewById).addView(this.nRW, layoutParams);
        }
        layoutParams = new RelativeLayout.LayoutParams(this.jYp - com.tencent.mm.bg.a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = b.a(this.context, this.context.getResources().getDimension(i.d.pzk));
        this.qjy = new VideoPlayerSeekBar(this.context);
        this.qjy.setVisibility(4);
        if (this.qjw != null) {
            this.qjw.hE(this.qjy.getVisibility() == 0);
        }
        this.qjy.puM = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void Uh() {
                if (this.qkc.qjx != null) {
                    this.qkc.qjx.bjj();
                }
            }

            public final void hR(int i) {
                w.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "onSeek time " + i);
                if (this.qkc.qjN) {
                    this.qkc.bfN();
                } else {
                    this.qkc.bfR();
                }
                this.qkc.qjx.R(i, this.qkc.qjy.fKD);
            }
        };
        this.qjy.d(new OnClickListener(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "btn onclick view [%b] bar[%b]", new Object[]{Boolean.valueOf(this.qkc.qjx.isPlaying()), Boolean.valueOf(this.qkc.qjy.fKD)});
                this.qkc.qjC = true;
                if (this.qkc.qjy.fKD) {
                    this.qkc.bgC();
                    this.qkc.qjP = 4;
                } else {
                    if (this.qkc.qjN) {
                        this.qkc.bfN();
                    } else {
                        this.qkc.bfR();
                        this.qkc.qkb = true;
                    }
                    this.qkc.ake();
                    this.qkc.qjP = 3;
                    if (this.qkc.qeV) {
                        this.qkc.bfS();
                    }
                }
                v vVar = this.qkc;
                vVar.qjI++;
            }
        });
        this.qjy.bX(this.qjx.isPlaying());
        this.qjy.seek(0);
        ((ViewGroup) findViewById).addView(this.qjy, layoutParams);
        this.qjL = (ImageView) findViewById.findViewById(f.pEq);
        this.qjL.setVisibility(0);
        this.qjL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void onClick(View view) {
                v vVar = this.qkc;
                vVar.qjM++;
                if (this.qkc.qjN) {
                    this.qkc.bfS();
                    this.qkc.bfR();
                    this.qkc.qkb = true;
                } else {
                    this.qkc.bfN();
                }
                this.qkc.qjK = true;
            }
        });
        this.qjL.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.context, 8), com.tencent.mm.bg.a.fromDPToPix(this.context, 13));
        parent = this.qjL.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.qjL);
        }
        ((ViewGroup) findViewById).addView(this.qjL);
        this.qjB = (ImageView) findViewById.findViewById(f.cGq);
        this.qjB.setImageDrawable(com.tencent.mm.bg.a.a(this.context, i.i.dzz));
        this.qjB.setVisibility(8);
        this.qjB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void onClick(View view) {
                this.qkc.qjC = true;
                this.qkc.ake();
                this.qkc.qjQ = false;
                if (!this.qkc.qjK) {
                    this.qkc.bfR();
                    this.qkc.qkb = true;
                    this.qkc.qjK = true;
                } else if (this.qkc.qjN) {
                    this.qkc.bfN();
                } else {
                    this.qkc.bfR();
                    this.qkc.qkb = true;
                }
                this.qkc.qjP = 3;
                this.qkc.qjy.setVisibility(4);
                this.qkc.qjL.setVisibility(0);
                this.qkc.nRW.setVisibility(0);
                if (this.qkc.qjw != null) {
                    this.qkc.qjw.hE(true);
                }
                af.f(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 qkd;

                    {
                        this.qkd = r1;
                    }

                    public final void run() {
                        if (!this.qkd.qkc.qjR) {
                            if (this.qkd.qkc.qjw != null) {
                                this.qkd.qkc.qjw.hE(false);
                            }
                            this.qkd.qkc.qjy.setVisibility(4);
                            this.qkd.qkc.qjL.setVisibility(8);
                            this.qkd.qkc.nRW.setVisibility(4);
                        }
                    }
                }, 10000);
            }
        });
        this.qjx.qvo = new OfflineVideoView.a(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final boolean a(PString pString) {
                String str = "adId";
                String str2 = this.qkc.bgz().qfz;
                String dB = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dB(str, str2);
                if (FileOp.aO(dB)) {
                    pString.value = dB;
                    this.qkc.qjY = true;
                    return true;
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(str, str2, false, 62, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                    final /* synthetic */ AnonymousClass10 qke;

                    {
                        this.qke = r1;
                    }

                    public final void bgn() {
                    }

                    public final void bgo() {
                        w.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video download fail");
                        this.qke.qkc.qjZ = true;
                    }

                    public final void FW(String str) {
                        w.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "video view height " + this.qke.qkc.ipu.getHeight() + ", player height " + this.qke.qkc.qjx.getHeight());
                        this.qke.qkc.qjZ = false;
                        this.qke.qkc.qjX = str;
                        if (this.qke.qkc.qjy.fKD) {
                            this.qke.qkc.qjx.wq(str);
                            this.qke.qkc.qjY = true;
                        }
                    }
                });
                return false;
            }

            public final void oW() {
                v vVar = this.qkc;
                vVar.qjH++;
                vVar = this.qkc;
                vVar.qjy.seek(0);
                vVar.bgB();
            }

            public final void onStart(int i) {
                boolean z = true;
                this.qkc.qjD = true;
                this.qkc.qjA = i;
                if (this.qkc.qjy.puT != i) {
                    this.qkc.qjy.sH(this.qkc.qjA);
                }
                this.qkc.qjy.setVisibility(4);
                this.qkc.qjL.setVisibility(0);
                if (this.qkc.qjw != null) {
                    aa aaVar = this.qkc.qjw;
                    if (this.qkc.qjy.getVisibility() != 0) {
                        z = false;
                    }
                    aaVar.hE(z);
                }
                this.qkc.bgB();
            }

            public final void tt(final int i) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 qke;

                    public final void run() {
                        w.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + i + " video time " + this.qke.qkc.qjA);
                        if (this.qke.qkc.qjy.puT != this.qke.qkc.qjA) {
                            this.qke.qkc.qjy.sH(this.qke.qkc.qjA);
                        }
                        this.qke.qkc.qjy.seek(i);
                        this.qke.qkc.qjy.bX(this.qke.qkc.qjx.isPlaying());
                        if (this.qke.qkc.qjx.isPlaying()) {
                            this.qke.qkc.qjD = true;
                        }
                    }
                });
            }
        };
        this.qjy.setVisibility(4);
        this.qjL.setVisibility(8);
        this.nRW.setVisibility(4);
        if (this.qjw != null) {
            this.qjw.hE(this.qjy.getVisibility() == 0);
        }
        this.qjx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                if (this.qkc.qjD) {
                    this.qkc.qjR = true;
                    if (this.qkc.qjy.getVisibility() == 0) {
                        this.qkc.qjy.setVisibility(4);
                        this.qkc.qjL.setVisibility(8);
                        this.qkc.nRW.setVisibility(4);
                    } else {
                        this.qkc.qjy.setVisibility(4);
                        this.qkc.qjL.setVisibility(0);
                        this.qkc.nRW.setVisibility(0);
                    }
                    if (this.qkc.qjw != null) {
                        aa aaVar = this.qkc.qjw;
                        if (this.qkc.qjy.getVisibility() != 0) {
                            z = false;
                        }
                        aaVar.hE(z);
                    }
                }
            }
        });
        this.qjz = (ProgressBar) findViewById.findViewById(f.cts);
        this.qjz.setVisibility(8);
        n nVar = (n) this.qib;
        if (nVar.fEC != 1 || nVar.qfC.length() <= 0 || nVar.qfB.length() <= 0) {
            z = false;
        }
        if (z) {
            View findViewById2 = this.ipu.findViewById(f.pEf);
            findViewById2.setVisibility(0);
            Button button = (Button) findViewById2.findViewById(f.pEg);
            button.setTextColor(((n) this.qib).qfD);
            button.setText(((n) this.qib).qfC);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ v qkc;

                {
                    this.qkc = r1;
                }

                public final void onClick(View view) {
                    this.qkc.bgA();
                }
            });
            findViewById2.findViewById(f.pEh).setBackgroundColor(((n) this.qib).qfE);
        }
        return this.ipu;
    }

    public final void bgA() {
        n nVar = (n) this.qib;
        if (bg.mA(nVar.qfB)) {
            w.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
        } else if (this.context instanceof Activity) {
            w.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[]{nVar.qfB});
            Intent intent = new Intent();
            intent.setClass(this.context, VideoAdPlayerUI.class);
            intent.putExtra("IsAd", true);
            intent.putExtra("KMediaId", aa.Pq(nVar.qfB));
            intent.putExtra("KThumUrl", nVar.qfA);
            intent.putExtra("KStremVideoUrl", nVar.qfB);
            intent.putExtra("ForceLandscape", true);
            intent.putExtra("ShareBtnHidden", 1);
            intent.putExtra("KComponentCid", bgq());
            ((Activity) this.context).startActivityForResult(intent, qka);
            this.qjJ++;
        } else {
            w.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
        }
    }

    public final void ake() {
        if (this.qjZ) {
            w.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
            this.qjx.bji();
            return;
        }
        w.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
        if (!(this.qjY || TextUtils.isEmpty(this.qjX))) {
            this.qjx.wq(this.qjX);
            this.qjY = true;
        }
        this.qjB.setVisibility(8);
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void run() {
                this.qkc.qjy.bX(true);
                this.qkc.qjx.bjk();
            }
        });
        this.nUp = System.currentTimeMillis();
        this.qjG++;
    }

    public final void bgB() {
        if (this.qjx != null && this.qjy != null && Math.abs(this.qjx.getCurrentPosition() - this.qjy.kC) > 1) {
            this.qjx.K(this.qjy.kC, true);
        }
    }

    public final void bgC() {
        w.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
        if (!this.qjC) {
            this.qjB.setVisibility(0);
        }
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ v qkc;

            {
                this.qkc = r1;
            }

            public final void run() {
                this.qkc.qjx.bjj();
                this.qkc.qjy.bX(false);
            }
        });
        if (this.nUp != 0) {
            this.qjF = (int) (((long) this.qjF) + (System.currentTimeMillis() - this.nUp));
            this.nUp = 0;
        }
    }

    public final void bfN() {
        super.bfN();
        this.qjL.setImageDrawable(com.tencent.mm.bg.a.a(this.context, i.e.pzH));
        this.qjx.bQ(true);
        this.qjN = true;
    }

    public final void bfR() {
        super.bfR();
        this.qjL.setImageDrawable(com.tencent.mm.bg.a.a(this.context, i.e.pzI));
        this.qjx.bQ(false);
        this.qjN = false;
    }

    public final void bfP() {
        super.bfP();
    }

    public final void bfQ() {
        super.bfQ();
        bgC();
        this.qkb = false;
        if (this.qjS || this.qjT) {
            this.qjT = false;
            this.qjS = false;
            if (this.qjP == 1) {
                this.qjP = 2;
            }
        }
    }

    public final void bfO() {
        super.bfO();
        this.qjx.onDestroy();
    }

    public final void N(int i, int i2, int i3) {
        super.N(i, i2, i3);
        w.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "height " + i2);
        if (i != 0 && i2 != 0) {
            this.qjO = i;
            this.lon = i2;
            if (i < 0) {
                return;
            }
            if (((float) i) < 0.5f * ((float) i2)) {
                this.qkb = false;
                this.qjT = false;
                this.qjS = false;
                bgC();
                if (this.qjP == 1) {
                    this.qjP = 2;
                }
            } else if (!this.qjS || this.qjT) {
                this.qkb = false;
                this.qjT = false;
                this.qjS = true;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (!this.qjQ || (this.qjQ && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                    if (this.qjw != null) {
                        this.qjw.hE(true);
                    }
                    if (this.qjy.puT > 0) {
                        this.qjy.setVisibility(4);
                        this.qjL.setVisibility(0);
                        this.nRW.setVisibility(0);
                    }
                    af.f(new Runnable(this) {
                        final /* synthetic */ v qkc;

                        {
                            this.qkc = r1;
                        }

                        public final void run() {
                            if (!this.qkc.qjR) {
                                if (this.qkc.qjw != null) {
                                    this.qkc.qjw.hE(false);
                                }
                                this.qkc.qjy.setVisibility(4);
                                this.qkc.qjL.setVisibility(8);
                                this.qkc.nRW.setVisibility(4);
                            }
                        }
                    }, 3000);
                }
                if (this.qjQ) {
                    if (activeNetworkInfo == null) {
                        this.qjB.setVisibility(0);
                        this.qjC = false;
                        this.qjU = false;
                    } else {
                        this.qjU = true;
                        this.qjQ = false;
                    }
                }
                if (this.qjP == 0) {
                    if (activeNetworkInfo != null) {
                        if (this.qjN) {
                            bfN();
                        } else {
                            bfR();
                            this.qkb = true;
                        }
                        this.qjP = 1;
                    } else {
                        return;
                    }
                } else if (this.qjP == 2) {
                    if (this.qjN) {
                        bfN();
                    } else {
                        bfR();
                        this.qkb = true;
                    }
                    ake();
                    this.qjP = 1;
                    return;
                } else if (this.qjP != 3) {
                    return;
                } else {
                    if (this.qjN) {
                        bfN();
                    } else {
                        bfR();
                        this.qkb = true;
                    }
                }
                ake();
            }
        }
    }

    public final boolean J(JSONObject jSONObject) {
        if (!super.J(jSONObject)) {
            return false;
        }
        try {
            String Pq;
            JSONObject jSONObject2;
            jSONObject.put("sightDuration", this.qjA * 1000);
            jSONObject.put("playTimeInterval", this.qjF);
            jSONObject.put("playCount", this.qjG);
            jSONObject.put("playCompletedCount", this.qjH);
            jSONObject.put("clickVoiceControlCount", this.qjM);
            jSONObject.put("isAutoPlay", this.qjU ? "1" : "0");
            if (!this.qjW) {
                Pq = aa.Pq(((n) this.qib).qfz);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Pq);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("sightUrlInfo", jSONObject2);
            }
            if (!this.qjV) {
                Pq = aa.Pq(((n) this.qib).qfA);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Pq);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            jSONObject.put("streamVideoEnterCount", this.qjJ);
            jSONObject.put("streamVideoPlayCount", this.pPu);
            jSONObject.put("streamVideoPlayCompleteCount", this.pPv);
            jSONObject.put("streamVideoTotalPlayTimeInMs", this.pPw);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected final void bgl() {
        w.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    }
}
