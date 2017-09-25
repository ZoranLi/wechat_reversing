package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.pb.common.c.i;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b implements SurfaceTextureListener, OnClickListener, com.tencent.mm.plugin.voip.model.k.a, f {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] rlG = new int[]{-1, R.l.fbI, R.l.fbN, R.l.fbM};
    public boolean fKF = false;
    public ae hgN;
    public TextView jWd;
    public TextView kxi;
    private Timer lPE;
    private View nRF;
    public com.tencent.mm.plugin.voip.video.a nRO;
    public ObservableTextureView nRQ;
    public ImageButton nRo;
    public boolean rmO = false;
    private OpenGlView rma;
    public OpenGlView rmb;
    public OpenGlRender rmc;
    public OpenGlRender rmd;
    public VoipBigIconButton rmx;
    private OnClickListener rng = new OnClickListener(this) {
        final /* synthetic */ b rsY;

        {
            this.rsY = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
            this.rsY.rmx.setEnabled(false);
            if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst > 1) {
                this.rsY.bsa();
            }
            this.rsY.rmx.setEnabled(true);
            if (this.rsY.nRO != null) {
                this.rsY.nRO.bro();
            }
        }
    };
    public VoipCSMainUI rsA;
    public RelativeLayout rsB;
    public TextView rsC;
    public TextView rsD;
    public TextView rsE;
    private TextView rsF;
    public ImageView rsG;
    public ae rsH;
    private boolean rsI = false;
    protected long rsJ = -1;
    private boolean rsK = false;
    private boolean rsL = false;
    public int rsM = 60000;
    public int rsN = Downloads.MIN_RETYR_AFTER;
    public com.tencent.mm.plugin.voip_cs.c.a rsO = new com.tencent.mm.plugin.voip_cs.c.a();
    public String rsP = "";
    public String rsQ = "";
    public aj rsR = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b rsY;

        {
            this.rsY = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
            com.tencent.mm.plugin.voip_cs.b.b.brP().aMw = 1;
            this.rsY.vq(6);
            return true;
        }
    }, false);
    public aj rsS = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b rsY;

        {
            this.rsY = r1;
        }

        public final boolean oQ() {
            this.rsY.rsD.setText(ab.getContext().getString(R.l.fbP));
            this.rsY.rsE.setVisibility(0);
            com.tencent.mm.plugin.voip_cs.c.a aVar = this.rsY.rsO;
            TextView textView = this.rsY.rsE;
            int[] iArr = b.rlG;
            if (iArr == null || textView == null) {
                w.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            } else {
                aVar.bqW();
                aVar.rlR = 0;
                aVar.rlP = iArr;
                aVar.kH = textView;
                aVar.rlQ = 500;
                if (aVar.irQ != null) {
                    long j = (long) aVar.rlQ;
                    aVar.irQ.v(j, j);
                }
                w.h("MicroMsg.DynamicTextWrap", "start textview:" + textView, new Object[0]);
            }
            return true;
        }
    }, false);
    a rsT = new a(this);
    c rsU;
    b rsV;
    String rsW = "";
    Drawable rsX = null;

    private class a {
        public int h;
        public int[] nQb;
        final /* synthetic */ b rsY;
        public int w;

        public a(b bVar) {
            this.rsY = bVar;
        }
    }

    class b implements Runnable {
        final /* synthetic */ b rsY;

        b(b bVar) {
            this.rsY = bVar;
        }

        public final void run() {
            this.rsY.rsX = b.HK(this.rsY.rsW);
            Message message = new Message();
            message.what = 12;
            this.rsY.rsH.sendMessage(message);
            e.remove(this.rsY.rsV);
        }
    }

    class c implements Runnable {
        boolean rgC = false;
        final /* synthetic */ b rsY;

        c(b bVar) {
            this.rsY = bVar;
        }

        public final void run() {
            while (!this.rgC && !this.rsY.fKF) {
                if (com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.videoDecode(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rkD) == 1) {
                    int i = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_remoteImgWidth;
                    int i2 = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_remoteImgHeight;
                    if (OpenGlRender.rpX == 1) {
                        if (this.rsY.rmO) {
                            this.rsY.rmd.a(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rkD, i, i2, OpenGlRender.rpC + OpenGlRender.rpI);
                        } else {
                            this.rsY.rmc.a(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rkD, i, i2, OpenGlRender.rpC + OpenGlRender.rpI);
                        }
                    } else if (this.rsY.rmO) {
                        this.rsY.rmd.a(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rkD, i, i2, OpenGlRender.rpF + OpenGlRender.rpI);
                    } else {
                        this.rsY.rmc.a(com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rkD, i, i2, OpenGlRender.rpF + OpenGlRender.rpI);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
                }
            }
        }
    }

    public b(VoipCSMainUI voipCSMainUI) {
        this.rsA = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(R.h.czb)).setPadding(0, 0, 0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(voipCSMainUI.uSU.uTo, 40.0f));
        }
        this.rmb = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.rmb).dn(width, height);
        this.rmb.setVisibility(8);
        this.rmc = new OpenGlRender(this.rmb, OpenGlRender.rpM);
        this.rmb.a(this.rmc);
        this.rmb.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.rmb.setZOrderOnTop(true);
        } else {
            this.rmb.setZOrderMediaOverlay(true);
        }
        this.kxi = (TextView) voipCSMainUI.findViewById(R.h.cIo);
        this.kxi.setVisibility(0);
        this.lPE = new Timer("voip_cs_talking_time");
        this.rsC = (TextView) voipCSMainUI.findViewById(R.h.cNV);
        this.rsC.setVisibility(0);
        this.rsD = (TextView) voipCSMainUI.findViewById(R.h.cOa);
        this.rsD.setVisibility(0);
        this.jWd = (TextView) voipCSMainUI.findViewById(R.h.cOc);
        this.jWd.setVisibility(0);
        this.rsG = (ImageView) voipCSMainUI.findViewById(R.h.cNW);
        this.rsG.setVisibility(0);
        this.rsF = (TextView) voipCSMainUI.findViewById(R.h.cNZ);
        this.rsE = (TextView) voipCSMainUI.findViewById(R.h.cOb);
        this.rmx = (VoipBigIconButton) voipCSMainUI.findViewById(R.h.cNX);
        if (voipCSMainUI.rtg == null || !voipCSMainUI.rtg.equals("1")) {
            this.rmx.setVisibility(8);
        } else {
            this.rmx.setVisibility(0);
            this.rmx.setOnClickListener(this.rng);
        }
        this.hgN = new ae();
        this.rsH = new ae(this) {
            final /* synthetic */ b rsY;

            {
                this.rsY = r1;
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 12:
                        if (this.rsY.rsX != null) {
                            this.rsY.rsG.setImageDrawable(this.rsY.rsX);
                            return;
                        } else {
                            this.rsY.rsG.setImageResource(R.g.bes);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        this.nRF = voipCSMainUI.findViewById(R.h.cNT);
        this.nRo = (ImageButton) voipCSMainUI.findViewById(R.h.cNY);
        this.rsB = (RelativeLayout) voipCSMainUI.findViewById(R.h.cNT);
        mScreenWidth = com.tencent.mm.bg.a.dO(voipCSMainUI.uSU.uTo);
        mScreenHeight = com.tencent.mm.plugin.voip_cs.c.b.cZ(voipCSMainUI.uSU.uTo);
        this.rma = (OpenGlView) voipCSMainUI.findViewById(R.h.cNU);
        this.rma.do(mScreenWidth, mScreenHeight);
        this.rmd = new OpenGlRender(this.rma, OpenGlRender.rpL);
        this.rma.a(this.rmd);
        this.rma.setRenderMode(0);
        this.rma.setVisibility(0);
        w.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[]{Integer.valueOf(mScreenHeight)});
        this.nRo.setOnClickListener(this);
        this.rsB.addView(this.rmb);
        this.rmb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b rsY;

            {
                this.rsY = r1;
            }

            public final void onClick(View view) {
                this.rsY.rmO = !this.rsY.rmO;
                Point il = this.rsY.il(this.rsY.rmO);
                this.rsY.rmb.dp(il.x, il.y);
            }
        });
        this.rmc.rps = true;
        this.rmd.rps = true;
        if (!d.cU(ab.getContext())) {
            d.cV(ab.getContext());
        }
        SharedPreferences bIY = ab.bIY();
        this.rsP = bIY.getString(brX(), "");
        if (this.rsA.iMn != null && !this.rsA.iMn.equals("")) {
            HJ(this.rsA.iMn);
        } else if (!i.isNullOrEmpty(this.rsP)) {
            HJ(this.rsP);
        }
        this.rsQ = bIY.getString(brY(), "");
        if (!i.isNullOrEmpty(this.rsQ)) {
            HI(this.rsQ);
        }
        com.tencent.mm.y.e brO = com.tencent.mm.plugin.voip_cs.b.b.brO();
        String str = this.rsA.rsu;
        w.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:" + str);
        ap.vd().a(455, brO);
        ap.vd().a(new j(str), 0);
    }

    public final void HI(String str) {
        this.jWd.setText(str);
    }

    public final void HJ(String str) {
        if (!i.isNullOrEmpty(str)) {
            this.rsV = new b(this);
            if (this.rsA.iMn == null || this.rsA.iMn.equals("")) {
                this.rsW = str;
            } else {
                this.rsW = this.rsA.iMn;
            }
            e.b(this.rsV, "VOIPCS_netPic", 10);
        }
    }

    public final String brX() {
        return "voip_cs_headImageUrl_" + this.rsA.rsu;
    }

    public final String brY() {
        return "voip_cs_nickname_" + this.rsA.rsu;
    }

    public final Point il(boolean z) {
        int height = ((WindowManager) this.rsA.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        return new Point((int) (ii(!z) * ((float) height)), height);
    }

    private static float ii(boolean z) {
        byte[] bArr;
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.field_capInfo;
            } catch (Exception e) {
                w.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.rjN;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > 65535) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f2 = ((float) wrap.getInt()) / 100.0f;
            if (f2 != 0.0f) {
                f = f2;
            }
            w.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
        }
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getId() == R.h.cNY) {
            if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst < 2) {
                com.tencent.mm.plugin.voip_cs.b.b.brP().aMw = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.b.b.brP().aMw = 4;
            }
            com.tencent.mm.plugin.voip_cs.b.c brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
            brP.rrv = 1;
            brP.rrT = 1;
            brP.rrw = (int) (System.currentTimeMillis() / 1000);
            brP = com.tencent.mm.plugin.voip_cs.b.b.brP();
            w.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (brP.rrQ == 0) {
                brP.rrL = 3;
                if (brP.rrU == 0 && brP.rsg != 0) {
                    brP.rrU = (long) (((int) (System.currentTimeMillis() / 1000)) - brP.rsg);
                }
            }
            com.tencent.mm.plugin.voip_cs.b.b.brP().brQ();
            w.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            vq(0);
            return;
        }
        int i = this.nRo.getVisibility() == 0 ? 8 : 0;
        this.nRo.setVisibility(i);
        this.kxi.setVisibility(i);
        this.rsC.setVisibility(i);
        vp(i);
        if (i == 0) {
            z = true;
        }
        ik(z);
    }

    public final void vp(int i) {
        if (this.rsA.rtg == null || !this.rsA.rtg.equals("1")) {
            this.rmx.setVisibility(8);
        } else {
            this.rmx.setVisibility(i);
        }
    }

    public final void brZ() {
        w.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.nRQ != null) {
            this.rsB.removeView(this.nRQ);
            this.nRQ = null;
        }
        if (this.nRO != null) {
            this.nRO.brq();
            com.tencent.mm.plugin.voip.video.a.brr();
            this.nRO = null;
        }
    }

    public final void bsa() {
        w.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.hgN.postDelayed(new Runnable(this) {
            final /* synthetic */ b rsY;

            {
                this.rsY = r1;
            }

            public final void run() {
                w.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
                if (!this.rsY.rsA.isFinishing()) {
                    this.rsY.nRo.setVisibility(8);
                    this.rsY.kxi.setVisibility(8);
                    this.rsY.rsC.setVisibility(8);
                    this.rsY.vp(8);
                    this.rsY.ik(false);
                }
            }
        }, 10000);
    }

    public final void ik(boolean z) {
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            w.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
        } else if (z) {
            this.rsA.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            this.rsA.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    public final void aDE() {
        this.rsR.KH();
        this.rsS.KH();
        this.rsO.bqW();
        this.rsE.setVisibility(8);
        this.rsD.setText(R.l.fbL);
        this.rsC.setText(R.l.fbD);
        vp(0);
        this.nRF.setOnClickListener(this);
        if (this.rsA.rth != null && this.rsA.rth.equals("1")) {
            this.rmb.setVisibility(0);
            this.rmO = true;
            Point il = il(this.rmO);
            ((MovableVideoView) this.rmb).dn(il.x, il.y);
            bsb();
        }
        bsa();
        this.rsK = true;
        if (this.lPE == null) {
            this.lPE = new Timer("voip_cs_talking_time");
        }
        if (!this.rsI) {
            if (this.rsJ == -1) {
                this.rsJ = bg.Ny();
            }
            this.rsI = true;
            this.lPE.schedule(new TimerTask(this) {
                final /* synthetic */ b rsY;

                {
                    this.rsY = r1;
                }

                public final void run() {
                    this.rsY.hgN.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 rsZ;

                        {
                            this.rsZ = r1;
                        }

                        public final void run() {
                            this.rsZ.rsY.kxi.setText(b.aq(bg.az(this.rsZ.rsY.rsJ)));
                        }
                    });
                }
            }, 1000, 1000);
            k.bpZ().bqa();
            k.bpZ().rit = this;
        }
    }

    public static Drawable HK(String str) {
        try {
            return Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
        } catch (Exception e) {
            w.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            return null;
        }
    }

    protected static String aq(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void vq(int i) {
        w.i("MicroMsg.voipcs.VoipCSViewManager", "onFinish for action:" + i);
        if (this.lPE != null) {
            this.lPE.cancel();
            this.lPE = null;
        }
        if (!this.rsR.bJq()) {
            this.rsR.KH();
        }
        if (!this.rsS.bJq()) {
            this.rsS.KH();
        }
        this.rsO.bqW();
        this.rsI = false;
        this.rsF.setVisibility(0);
        this.rsF.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.rsF.setBackgroundResource(R.g.bly);
        this.rsF.setCompoundDrawables(null, null, null, null);
        this.rsF.setCompoundDrawablePadding(0);
        this.rsF.setText(vr(i));
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst == 2) {
            e.post(new Runnable(this) {
                final /* synthetic */ b rsY;

                {
                    this.rsY = r1;
                }

                public final void run() {
                    a brV = a.brV();
                    if (brV.riY != null) {
                        brV.riY.d(R.k.dyR, false, 0);
                    }
                }
            }, "VoipCS_play_end_sound");
        }
        this.hgN.postDelayed(new Runnable(this) {
            final /* synthetic */ b rsY;

            {
                this.rsY = r1;
            }

            public final void run() {
                this.rsY.rsA.finish();
            }
        }, 2000);
    }

    private static int vr(int i) {
        if (i == 1) {
            return R.l.fbz;
        }
        if (i == 0) {
            return R.l.fbB;
        }
        if (i == -1 || i == 5) {
            return R.l.fbG;
        }
        if (i == 403 || i == TencentLocation.ERROR_UNKNOWN) {
            return R.l.fbO;
        }
        if (i == 6) {
            return R.l.fbJ;
        }
        if (i == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED) {
            return R.l.fbF;
        }
        if (i == 10) {
            return R.l.fbA;
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.brO().rst < 2) {
            return R.l.fby;
        }
        return R.l.fbB;
    }

    public final void aDF() {
        this.rsF.setVisibility(0);
        this.rsF.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.rsF.setBackgroundResource(R.g.bly);
        this.rsF.setCompoundDrawables(null, null, null, null);
        this.rsF.setCompoundDrawablePadding(0);
        this.rsF.setText(vr(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED));
    }

    public final void aDG() {
        this.rsF.setVisibility(8);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3) {
        w.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.fKF);
        if (!this.fKF) {
            if (this.rsT.nQb == null) {
                this.rsT.w = i;
                this.rsT.h = i2;
                this.rsT.nQb = new int[(this.rsT.w * this.rsT.h)];
            }
            int i4 = this.nRO.brs() ? OpenGlRender.rpK : 0;
            int i5 = this.nRO.brt() ? OpenGlRender.rpJ : OpenGlRender.rpI;
            if (this.rsK) {
                w.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = " + com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.videoEncodeToSend(bArr, bArr.length, i, i2, i3));
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.brN().mOV;
                com_tencent_mm_plugin_voip_model_v2protocal.rkW++;
            }
            com.tencent.mm.plugin.voip_cs.b.b.brN().mOV.videoEncodeToLocal(bArr, (int) j, i, i2, i3, 75, this.rsT.nQb);
            if (OpenGlRender.rpX == 1) {
                if (this.rmO) {
                    this.rmc.a(this.rsT.nQb, i, i2, (OpenGlRender.rpD + i4) + i5);
                } else {
                    this.rmd.a(this.rsT.nQb, i, i2, (OpenGlRender.rpD + i4) + i5);
                }
            } else if (OpenGlRender.rpX != 2) {
            } else {
                if (this.rmO) {
                    this.rmc.b(bArr, i, i2, (OpenGlRender.rpH + i4) + i5);
                } else {
                    this.rmd.b(bArr, i, i2, (OpenGlRender.rpH + i4) + i5);
                }
            }
        }
    }

    public final void aNu() {
        w.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    }

    public final void bsb() {
        bsc();
        this.rsU = new c(this);
        e.b(this.rsU, "VOIPCS_VideoDecode", 10);
        w.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    }

    public final void bsc() {
        if (this.rsU != null) {
            w.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.rsU.rgC = true;
            e.remove(this.rsU);
            this.rsU = null;
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
