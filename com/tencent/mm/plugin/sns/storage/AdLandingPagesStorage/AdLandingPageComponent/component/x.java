package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class x extends w {
    private Context context;
    public ae hgN;
    int lon = 0;
    public View nRW;
    public long nUp = 0;
    public int qjA;
    private ImageView qjB;
    public boolean qjC = true;
    public boolean qjD;
    private TextView qjE;
    public int qjF = 0;
    private int qjG = 0;
    public int qjH = 0;
    public int qjI = 0;
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

    public x(final Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
        this.context = context;
        this.hgN = new ae(Looper.getMainLooper());
        this.qjw = new aa(this) {
            final /* synthetic */ x qkf;

            public final void hE(boolean z) {
                Intent intent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
                intent.putExtra("show", z ? 1 : 0);
                d.k(context).b(intent);
            }
        };
    }

    public final int bgD() {
        if (this.qjy.getVisibility() != 0) {
            return -1;
        }
        int[] iArr = new int[2];
        this.qjy.getLocationOnScreen(iArr);
        return (this.jYq - iArr[1]) - (this.qjy.getHeight() >>> 1);
    }

    public final t bgE() {
        return (t) this.qib;
    }

    protected final int aTQ() {
        return g.pHe;
    }

    public final View bgf() {
        LayoutParams layoutParams;
        ViewParent parent;
        boolean z = true;
        if (!e.aO(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dA("adId", ((t) this.qib).qgg))) {
            this.qjV = false;
        }
        if (!e.aO(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + aa.Pq(((t) this.qib).qfB))) {
            this.qjW = false;
        }
        View findViewById = this.ipu.findViewById(f.pEl);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.pEe);
        this.qjx = new OfflineVideoView(this.context);
        viewGroup.addView(this.qjx, 0, new LinearLayout.LayoutParams(-1, -1));
        int i;
        LayoutParams layoutParams2;
        if (((t) this.qib).qgh != 1) {
            i = this.jYq;
            layoutParams2 = new RelativeLayout.LayoutParams(this.jYp, i);
            findViewById.setPadding((int) ((t) this.qib).qfM, (int) ((t) this.qib).qfK, (int) ((t) this.qib).qfN, (int) ((t) this.qib).qfL);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
            findViewById.setMinimumHeight(i);
        } else if (((int) ((t) this.qib).width) > 0) {
            i = (this.jYp * ((int) ((t) this.qib).height)) / ((int) ((t) this.qib).width);
            layoutParams2 = new RelativeLayout.LayoutParams(this.jYp, i);
            findViewById.setPadding((int) ((t) this.qib).qfM, (int) ((t) this.qib).qfK, (int) ((t) this.qib).qfN, (int) ((t) this.qib).qfL);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
            findViewById.setMinimumHeight(i);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.jYp, this.jYq));
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.jYp, this.jYq));
            findViewById.setMinimumHeight(this.jYq);
        }
        String dA = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dA("adId", ((t) this.qib).qgg);
        if (FileOp.aO(dA)) {
            this.qjx.GN(dA);
        } else {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a("adId", ((t) this.qib).qgg, false, 1000000001, 0, new a(this) {
                final /* synthetic */ x qkf;

                {
                    this.qkf = r1;
                }

                public final void bgn() {
                }

                public final void bgo() {
                }

                public final void FW(String str) {
                    this.qkf.qjx.GN(str);
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
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void Uh() {
                if (this.qkf.qjx != null) {
                    this.qkf.qjx.bjj();
                }
            }

            public final void hR(int i) {
                w.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "onSeek time " + i);
                if (this.qkf.qjN) {
                    this.qkf.bfN();
                } else {
                    this.qkf.bfR();
                }
                this.qkf.qjx.R(i, this.qkf.qjy.fKD);
            }
        };
        this.qjy.d(new OnClickListener(this) {
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "btn onclick view [%b] bar[%b]", new Object[]{Boolean.valueOf(this.qkf.qjx.isPlaying()), Boolean.valueOf(this.qkf.qjy.fKD)});
                this.qkf.qjC = true;
                if (this.qkf.qjy.fKD) {
                    this.qkf.bgC();
                    this.qkf.qjP = 4;
                } else {
                    if (this.qkf.qjN) {
                        this.qkf.bfN();
                    } else {
                        this.qkf.bfR();
                        this.qkf.qkb = true;
                    }
                    this.qkf.ake();
                    this.qkf.qjP = 3;
                    if (this.qkf.qeV) {
                        this.qkf.bfS();
                    }
                }
                if (this.qkf.qeX) {
                    x xVar = this.qkf;
                    xVar.qjI++;
                }
            }
        });
        this.qjy.bX(this.qjx.isPlaying());
        this.qjy.seek(0);
        ((ViewGroup) findViewById).addView(this.qjy, layoutParams);
        this.qjL = (ImageView) findViewById.findViewById(f.pEq);
        this.qjL.setVisibility(0);
        this.qjL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void onClick(View view) {
                x xVar = this.qkf;
                xVar.qjM++;
                if (this.qkf.qjN) {
                    this.qkf.bfS();
                    this.qkf.bfR();
                    this.qkf.qkb = true;
                } else {
                    this.qkf.bfN();
                }
                this.qkf.qjK = true;
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
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void onClick(View view) {
                this.qkf.qjC = true;
                this.qkf.ake();
                this.qkf.qjQ = false;
                if (!this.qkf.qjK) {
                    this.qkf.bfR();
                    this.qkf.qkb = true;
                    this.qkf.qjK = true;
                } else if (this.qkf.qjN) {
                    this.qkf.bfN();
                } else {
                    this.qkf.bfR();
                    this.qkf.qkb = true;
                }
                this.qkf.qjP = 3;
                this.qkf.qjy.setVisibility(0);
                this.qkf.qjL.setVisibility(0);
                this.qkf.nRW.setVisibility(0);
                if (this.qkf.qjw != null) {
                    this.qkf.qjw.hE(true);
                }
                af.f(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 qkg;

                    {
                        this.qkg = r1;
                    }

                    public final void run() {
                        if (!this.qkg.qkf.qjR) {
                            if (this.qkg.qkf.qjw != null) {
                                this.qkg.qkf.qjw.hE(false);
                            }
                            this.qkg.qkf.qjy.setVisibility(4);
                            this.qkg.qkf.qjL.setVisibility(8);
                            this.qkg.qkf.nRW.setVisibility(4);
                        }
                    }
                }, 10000);
            }
        });
        this.qjx.qvo = new OfflineVideoView.a(this) {
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final boolean a(PString pString) {
                String str = "adId";
                String str2 = this.qkf.bgE().qfB;
                String dB = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dB(str, str2);
                if (FileOp.aO(dB)) {
                    pString.value = dB;
                    this.qkf.qjY = true;
                    return true;
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(str, str2, false, 62, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b(this) {
                    final /* synthetic */ AnonymousClass9 qkh;

                    {
                        this.qkh = r1;
                    }

                    public final void FY(String str) {
                        w.e("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video download fail %s", new Object[]{str});
                        this.qkh.qkf.qjZ = true;
                    }

                    public final void FZ(String str) {
                        w.v("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "video view height " + this.qkh.qkf.ipu.getHeight() + ", player height " + this.qkh.qkf.qjx.getHeight());
                        this.qkh.qkf.qjZ = false;
                        this.qkh.qkf.qjX = str;
                        if (this.qkh.qkf.qjy.fKD) {
                            this.qkh.qkf.qjx.wq(str);
                            this.qkh.qkf.qjY = true;
                        }
                    }
                });
                return false;
            }

            public final void oW() {
                boolean z = false;
                x xVar = this.qkf;
                xVar.qjH++;
                this.qkf.qjy.setVisibility(0);
                this.qkf.qjL.setVisibility(0);
                this.qkf.nRW.setVisibility(0);
                if (this.qkf.qjw != null) {
                    aa aaVar = this.qkf.qjw;
                    if (this.qkf.qjy.getVisibility() == 0) {
                        z = true;
                    }
                    aaVar.hE(z);
                }
                this.qkf.hgN.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 qkh;

                    {
                        this.qkh = r1;
                    }

                    public final void run() {
                        this.qkh.qkf.qjx.K(0, false);
                        this.qkh.qkf.qjy.bX(false);
                        this.qkh.qkf.qjy.seek(0);
                    }
                });
                if (this.qkf.nUp != 0) {
                    this.qkf.qjF = (int) (((long) this.qkf.qjF) + (System.currentTimeMillis() - this.qkf.nUp));
                    this.qkf.nUp = 0;
                }
                this.qkf.qjP = 5;
            }

            public final void onStart(int i) {
                boolean z = false;
                this.qkf.qjD = true;
                this.qkf.qjA = i;
                if (this.qkf.qjy.puT != i) {
                    this.qkf.qjy.sH(this.qkf.qjA);
                }
                this.qkf.qjy.setVisibility(0);
                this.qkf.qjL.setVisibility(0);
                if (this.qkf.qjw != null) {
                    aa aaVar = this.qkf.qjw;
                    if (this.qkf.qjy.getVisibility() == 0) {
                        z = true;
                    }
                    aaVar.hE(z);
                }
                x xVar = this.qkf;
                if (xVar.qjx != null && xVar.qjy != null && Math.abs(xVar.qjx.getCurrentPosition() - xVar.qjy.kC) > 1) {
                    xVar.qjx.K(xVar.qjy.kC, true);
                }
            }

            public final void tt(final int i) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 qkh;

                    public final void run() {
                        w.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "play time " + i + " video time " + this.qkh.qkf.qjA);
                        if (this.qkh.qkf.qjy.puT != this.qkh.qkf.qjA) {
                            this.qkh.qkf.qjy.sH(this.qkh.qkf.qjA);
                        }
                        this.qkh.qkf.qjy.seek(i);
                        this.qkh.qkf.qjy.bX(this.qkh.qkf.qjx.isPlaying());
                        if (this.qkh.qkf.qjx.isPlaying()) {
                            this.qkh.qkf.qjD = true;
                        }
                    }
                });
            }
        };
        this.qjy.setVisibility(4);
        this.qjL.setVisibility(8);
        this.nRW.setVisibility(4);
        if (this.qjw != null) {
            aa aaVar = this.qjw;
            if (this.qjy.getVisibility() != 0) {
                z = false;
            }
            aaVar.hE(z);
        }
        this.qjx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                if (this.qkf.qjD) {
                    this.qkf.qjR = true;
                    if (this.qkf.qjy.getVisibility() == 0) {
                        this.qkf.qjy.setVisibility(4);
                        this.qkf.qjL.setVisibility(8);
                        this.qkf.nRW.setVisibility(4);
                    } else {
                        this.qkf.qjy.setVisibility(0);
                        this.qkf.qjL.setVisibility(0);
                        this.qkf.nRW.setVisibility(0);
                    }
                    if (this.qkf.qjw != null) {
                        aa aaVar = this.qkf.qjw;
                        if (this.qkf.qjy.getVisibility() != 0) {
                            z = false;
                        }
                        aaVar.hE(z);
                    }
                }
            }
        });
        this.qjz = (ProgressBar) findViewById.findViewById(f.cts);
        this.qjz.setVisibility(8);
        return this.ipu;
    }

    public final void ake() {
        if (this.qjZ) {
            w.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "last download fail ,try again");
            this.qjx.bji();
            return;
        }
        w.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "starting play");
        if (!(this.qjY || TextUtils.isEmpty(this.qjX))) {
            this.qjx.wq(this.qjX);
            this.qjY = true;
        }
        this.qjB.setVisibility(8);
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void run() {
                boolean z;
                OfflineVideoView offlineVideoView = this.qkf.qjx;
                if (offlineVideoView.kmM instanceof VideoPlayerTextureView) {
                    VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) offlineVideoView.kmM;
                    z = videoPlayerTextureView.nIX == null ? false : !videoPlayerTextureView.sWU;
                    z = z && offlineVideoView.isPlaying();
                } else {
                    z = offlineVideoView.isPlaying();
                }
                if (z) {
                    this.qkf.qjx.WZ();
                    return;
                }
                this.qkf.qjy.bX(true);
                this.qkf.qjx.bjk();
            }
        });
        this.nUp = System.currentTimeMillis();
        this.qjG++;
    }

    public final void bgC() {
        w.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "pause play");
        if (!this.qjC) {
            this.qjB.setVisibility(0);
        }
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ x qkf;

            {
                this.qkf = r1;
            }

            public final void run() {
                this.qkf.qjx.bjj();
                this.qkf.qjy.bX(false);
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
        w.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "height " + i2);
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
                        this.qjy.setVisibility(0);
                        this.qjL.setVisibility(0);
                        this.nRW.setVisibility(0);
                    }
                    af.f(new Runnable(this) {
                        final /* synthetic */ x qkf;

                        {
                            this.qkf = r1;
                        }

                        public final void run() {
                            if (!this.qkf.qjR) {
                                if (this.qkf.qjw != null) {
                                    this.qkf.qjw.hE(false);
                                }
                                this.qkf.qjy.setVisibility(4);
                                this.qkf.qjL.setVisibility(8);
                                this.qkf.nRW.setVisibility(4);
                            }
                        }
                    }, 3000);
                }
                if (this.qjQ) {
                    if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                        this.qjB.setVisibility(0);
                        this.qjC = false;
                        this.qjU = false;
                    } else {
                        this.qjU = true;
                        this.qjQ = false;
                    }
                }
                if (this.qjP == 0) {
                    if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
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
            jSONObject.put("streamVideoDuraion", this.qjA * 1000);
            jSONObject.put("playTimeInterval", this.qjF);
            jSONObject.put("playCount", this.qjG);
            jSONObject.put("playCompletedCount", this.qjH);
            jSONObject.put("clickPlayControlCount", this.qjI);
            jSONObject.put("clickVoiceControlCount", this.qjM);
            jSONObject.put("isAutoPlay", this.qjU ? "1" : "0");
            if (!this.qjV) {
                Pq = aa.Pq(((t) this.qib).qgg);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Pq);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            if (!this.qjW) {
                Pq = aa.Pq(((t) this.qib).qfB);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Pq);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("streamVideoUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", e, "", new Object[0]);
            return false;
        }
    }

    protected final void bgl() {
        w.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", getClass().getName() + "not support update now");
    }
}
