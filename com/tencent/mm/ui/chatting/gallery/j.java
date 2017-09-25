package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.gallery.b.b;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.File;
import java.util.HashMap;

public final class j {
    public String fOu = "";
    public String fOx;
    public long iam;
    public int kC;
    public TextView lKS;
    public View mil;
    public int qjA = 0;
    public b vQs;
    public b vTa;
    public HashMap<String, Boolean> vTb = new HashMap();
    public RelativeLayout vTc;
    public f vTd;
    public ImageView vTe;
    public ImageView vTf;
    public MMPinProgressBtn vTg;
    public View vTh;
    public RelativeLayout vTi;
    public ImageView vTj;
    public ImageView vTk;
    public f vTl;
    public MMPinProgressBtn vTm;
    public TextView vTn;
    public LinearLayout vTo;
    public TextView vTp;
    public TextView vTq;
    public ImageView vTr;
    public ProgressBar vTs;
    public ProgressBar vTt;
    public LinearLayout vTu;
    public TextView vTv;
    public ImageView vTw;
    public MultiTouchImageView vTx;
    public int vTy = 0;
    public int vTz = 0;

    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] vQk = new int[b.values().length];

        static {
            try {
                vQk[b.vQB.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vQk[b.vQC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vQk[b.sight.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                vQk[b.unkown.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @TargetApi(11)
    public j(b bVar, View view) {
        this.mil = view;
        this.vQs = bVar;
        this.vTx = (MultiTouchImageView) view.findViewById(R.h.Kd);
        this.vTt = (ProgressBar) view.findViewById(R.h.bWM);
        if (d.eo(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public static void M(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public final j bXu() {
        if (this.vTo == null) {
            this.vTo = (LinearLayout) ((ViewStub) this.mil.findViewById(R.h.bWP)).inflate();
            this.vTs = (ProgressBar) this.vTo.findViewById(R.h.bKx);
            this.vTp = (TextView) this.vTo.findViewById(R.h.bKy);
            this.vTq = (TextView) this.vTo.findViewById(R.h.bKw);
            this.vTr = (ImageView) this.vTo.findViewById(R.h.bKz);
        }
        return this;
    }

    public final j bXv() {
        if (this.vTu == null) {
            this.vTu = (LinearLayout) ((ViewStub) this.mil.findViewById(R.h.bWN)).inflate();
            this.vTw = (ImageView) this.vTu.findViewById(R.h.bKd);
            this.vTv = (TextView) this.vTu.findViewById(R.h.bKe);
        }
        return this;
    }

    public final j bXw() {
        if (this.vTc == null) {
            this.vTc = (RelativeLayout) ((ViewStub) this.mil.findViewById(R.h.cFr)).inflate();
            this.vTd = n.dG(this.mil.getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.vTc.addView((View) this.vTd, layoutParams);
            ((View) this.vTd).setVisibility(8);
            this.vTh = this.vTc.findViewById(R.h.cIS);
            this.vTh.setVisibility(8);
            this.lKS = (TextView) this.vTc.findViewById(R.h.cFd);
            this.vTg = (MMPinProgressBtn) this.vTc.findViewById(R.h.cFo);
            this.vTg.setVisibility(8);
            this.vTe = (ImageView) this.vTc.findViewById(R.h.cFp);
            this.vTf = (ImageView) this.vTc.findViewById(R.h.cMq);
            this.vTd.a(new a(this) {
                final /* synthetic */ j vTA;

                {
                    this.vTA = r1;
                }

                public final void Uc() {
                }

                public final void onError(int i, int i2) {
                    this.vTA.vTd.stop();
                    final String str = (String) ((View) this.vTA.vTd).getTag();
                    com.tencent.mm.sdk.a.b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bbQ() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bg.ap(str, "")).getBytes(), 2), "FullScreenPlaySight");
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 vTB;

                        public final void run() {
                            if (bg.mA(str)) {
                                g.h(this.vTB.vTA.vQs.vPV, R.l.fak, R.l.dVf);
                                return;
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(new File(str)), "video/*");
                            try {
                                this.vTB.vTA.vQs.vPV.startActivity(Intent.createChooser(intent, this.vTB.vTA.vQs.vPV.uSU.uTo.getString(R.l.ejL)));
                            } catch (Exception e) {
                                w.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
                                g.h(this.vTB.vTA.vQs.vPV, R.l.eiL, R.l.eiM);
                            }
                        }
                    });
                    this.vTA.vTb.put(str, Boolean.valueOf(true));
                }

                public final void oW() {
                    this.vTA.vTd.start();
                    this.vTA.vTh.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 vTB;

                        {
                            this.vTB = r1;
                        }

                        public final void run() {
                            if (this.vTB.vTA.vTh != null && this.vTB.vTA.vTh.getVisibility() != 0) {
                                if (this.vTB.vTA.vTh.getTag() != null && (this.vTB.vTA.vTh.getTag() instanceof r)) {
                                    r rVar = (r) this.vTB.vTA.vTh.getTag();
                                    if (rVar.iay != null && !bg.mA(rVar.iay.hjD)) {
                                        this.vTB.vTA.vTh.setVisibility(8);
                                        return;
                                    } else if (!(rVar.iay == null || bg.mA(rVar.iay.hjG) || bg.mA(rVar.iay.hjH))) {
                                        this.vTB.vTA.vTh.setVisibility(8);
                                        return;
                                    }
                                }
                                this.vTB.vTA.vTh.setVisibility(0);
                                this.vTB.vTA.vTh.startAnimation(AnimationUtils.loadAnimation(this.vTB.vTA.vTh.getContext(), R.a.aQX));
                            }
                        }
                    });
                }

                public final int bI(int i, int i2) {
                    return 0;
                }

                public final void bp(int i, int i2) {
                }
            });
            this.lKS.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j vTA;

                {
                    this.vTA = r1;
                }

                public final void onClick(View view) {
                    if (view.getTag() != null && (view.getTag() instanceof au)) {
                        au auVar = (au) view.getTag();
                        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, auVar);
                        r lH = t.lH(auVar.field_imgPath);
                        bdu com_tencent_mm_protocal_c_bdu = lH.iay;
                        if (com_tencent_mm_protocal_c_bdu != null && !u.mA(com_tencent_mm_protocal_c_bdu.hjD)) {
                            int i;
                            o.KV();
                            String lw = s.lw(auVar.field_imgPath);
                            Intent intent = new Intent();
                            intent.putExtra("IsAd", false);
                            intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_bdu.hjD);
                            intent.putExtra("KThumUrl", com_tencent_mm_protocal_c_bdu.hjI);
                            intent.putExtra("KThumbPath", lw);
                            intent.putExtra("KMediaId", "fakeid_" + auVar.field_msgId);
                            intent.putExtra("KMediaVideoTime", com_tencent_mm_protocal_c_bdu.tyZ);
                            intent.putExtra("KMediaTitle", com_tencent_mm_protocal_c_bdu.hjF);
                            intent.putExtra("StreamWording", com_tencent_mm_protocal_c_bdu.hjG);
                            intent.putExtra("StremWebUrl", com_tencent_mm_protocal_c_bdu.hjH);
                            String str = auVar.field_talker;
                            boolean endsWith = str.endsWith("@chatroom");
                            lw = endsWith ? ay.gi(auVar.field_content) : str;
                            intent.putExtra("KSta_StremVideoAduxInfo", com_tencent_mm_protocal_c_bdu.hjJ);
                            intent.putExtra("KSta_StremVideoPublishId", com_tencent_mm_protocal_c_bdu.hjK);
                            intent.putExtra("KSta_SourceType", 1);
                            String str2 = "KSta_Scene";
                            if (endsWith) {
                                i = com.tencent.mm.ui.chatting.a.b.TalkChat.value;
                            } else {
                                i = com.tencent.mm.ui.chatting.a.b.Chat.value;
                            }
                            intent.putExtra(str2, i);
                            intent.putExtra("KSta_FromUserName", lw);
                            intent.putExtra("KSta_ChatName", str);
                            intent.putExtra("KSta_MsgId", auVar.field_msgSvrId);
                            intent.putExtra("KSta_SnsStatExtStr", lH.fUY);
                            if (endsWith) {
                                intent.putExtra("KSta_ChatroomMembercount", com.tencent.mm.u.j.eC(str));
                            }
                            com.tencent.mm.bb.d.b(this.vTA.vQs.vPV.uSU.uTo, "sns", ".ui.VideoAdPlayerUI", intent);
                        } else if (com_tencent_mm_protocal_c_bdu != null && !bg.mA(com_tencent_mm_protocal_c_bdu.hjG) && !bg.mA(com_tencent_mm_protocal_c_bdu.hjH)) {
                            w.i("MicroMsg.ImageGalleryViewHolder", "moreBtn click,opening " + com_tencent_mm_protocal_c_bdu.hjH);
                            final Intent intent2 = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", lH.fUY);
                            intent2.putExtra("jsapiargs", bundle);
                            intent2.putExtra("rawUrl", com_tencent_mm_protocal_c_bdu.hjH);
                            intent2.putExtra("useJs", true);
                            ap.vd().a(new c("", 18, 5, "", 2), 0);
                            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 vTC;

                                public final void run() {
                                    com.tencent.mm.bb.d.b(this.vTC.vTA.vQs.vPV.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
                                }
                            });
                        }
                    }
                }
            });
        }
        return this;
    }

    public final j bXx() {
        if (this.vTi == null) {
            this.vTi = (RelativeLayout) ((ViewStub) this.mil.findViewById(R.h.cMi)).inflate();
            this.vTj = (ImageView) this.vTi.findViewById(R.h.cLR);
            this.vTk = (ImageView) this.vTi.findViewById(R.h.cMp);
            this.vTk.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ j vTA;

                {
                    this.vTA = r1;
                }

                public final void onClick(View view) {
                    if (this.vTA.vQs != null) {
                        w.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", Integer.valueOf(this.vTA.hashCode()), Integer.valueOf(this.vTA.kC));
                        this.vTA.vQs.Br(this.vTA.kC);
                    }
                }
            });
            com.tencent.mm.modelcontrol.d.Eu();
            if (com.tencent.mm.modelcontrol.d.EB()) {
                this.vTl = new VideoPlayerTextureView(this.mil.getContext());
                com.tencent.mm.plugin.report.service.g.oUh.a(354, 150, 1, false);
            } else {
                this.vTl = new VideoTextureView(this.mil.getContext());
                com.tencent.mm.plugin.report.service.g.oUh.a(354, 151, 1, false);
            }
            this.vTn = (TextView) this.mil.findViewById(R.h.bHN);
            this.vTl.he(true);
            this.vTi.addView((View) this.vTl, 2, new RelativeLayout.LayoutParams(-1, -1));
            this.vTm = (MMPinProgressBtn) this.vTi.findViewById(R.h.cLM);
            this.vTm.setVisibility(8);
            ((View) this.vTl).setVisibility(8);
            this.vTl.a(new a(this) {
                final /* synthetic */ j vTA;

                {
                    this.vTA = r1;
                }

                public final void Uc() {
                    if (this.vTA.vQs != null) {
                        this.vTA.vQs.vQb.bXr();
                    }
                }

                public final void onError(int i, int i2) {
                    w.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + i + " extra: " + i2);
                    if (this.vTA.vQs != null) {
                        this.vTA.vQs.vQb.ec(i, i2);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(12084, Integer.valueOf(this.vTA.vTy), Integer.valueOf(this.vTA.qjA * 1000), Integer.valueOf(0), Integer.valueOf(4), this.vTA.fOu, Integer.valueOf(this.vTA.vTz), this.vTA.fOx, Long.valueOf(this.vTA.iam));
                }

                public final void oW() {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 vTD;

                        {
                            this.vTD = r1;
                        }

                        public final void run() {
                            this.vTD.vTA.vQs.vPV.lu(true);
                            b bVar = this.vTD.vTA.vQs;
                            bVar.vQb.BH(this.vTD.vTA.kC);
                            this.vTD.vTA.vQs.vQb.bXs();
                        }
                    });
                }

                public final int bI(final int i, final int i2) {
                    w.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", Integer.valueOf(i), Integer.valueOf(this.vTA.qjA), Integer.valueOf(i2), Integer.valueOf(this.vTA.vTy), Integer.valueOf(this.vTA.vTz), this.vTA.fOu);
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 vTD;

                        public final void run() {
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(this.vTD.vTA.vTy);
                            objArr[1] = Integer.valueOf(i2 <= 0 ? this.vTD.vTA.qjA * 1000 : i2);
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = this.vTD.vTA.fOu;
                            objArr[5] = Integer.valueOf(this.vTD.vTA.vTz);
                            objArr[6] = this.vTD.vTA.fOx;
                            objArr[7] = Long.valueOf(this.vTD.vTA.iam);
                            gVar.i(12084, objArr);
                        }
                    });
                    return 0;
                }

                public final void bp(int i, int i2) {
                }
            });
        }
        return this;
    }

    public final void a(boolean z, float f) {
        w.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f));
        if (z) {
            View view = (View) bXx().vTl;
            view.setAlpha(f);
            M(view, 0);
            if (((double) f) >= 1.0d) {
                M(bXx().vTj, 8);
                M(bXx().vTk, 8);
                return;
            }
            return;
        }
        M((View) bXx().vTl, 8);
        M(bXx().vTj, 0);
        M(bXx().vTk, 0);
    }
}
