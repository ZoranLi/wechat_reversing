package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class VoicePrintVolumeMeter extends View {
    static int nfU = 20;
    private static int rdP = Color.rgb(240, 250, 235);
    private static int rdQ = Color.rgb(h.CTRL_INDEX, 240, m.CTRL_INDEX);
    private static int rdR = 100;
    private static float rdY = DownloadHelper.SAVE_FATOR;
    private static float rdZ = 2.0f;
    private static float rea = 0.1f;
    private static float reb = 0.05f;
    private Paint fu;
    private Context mContext;
    boolean mJX = false;
    View nfI;
    private int rdL = -1;
    private int rdM = -1;
    af rdN = null;
    aj rdO = null;
    private float rdS = 0.0f;
    private float rdT = 0.0f;
    private float rdU = 0.0f;
    private float rdV = 0.0f;
    private float rdW = 0.0f;
    private float rdX = 0.0f;
    float rec = -1.0f;
    boolean red = true;

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        if (voicePrintVolumeMeter.mJX) {
            if (voicePrintVolumeMeter.red) {
                voicePrintVolumeMeter.rdW *= rea + 1.0f;
                voicePrintVolumeMeter.rdX = voicePrintVolumeMeter.rdW * rdY;
            } else {
                voicePrintVolumeMeter.rdW *= 1.0f - reb;
                voicePrintVolumeMeter.rdX = voicePrintVolumeMeter.rdW * rdY;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fu = new Paint();
        this.rdN = new af("VoicePrintVolumeMeter");
        this.rdO = new aj(this.rdN.nJF.getLooper(), new a(this) {
            final /* synthetic */ VoicePrintVolumeMeter ree;

            {
                this.ree = r1;
            }

            public final boolean oQ() {
                VoicePrintVolumeMeter.a(this.ree);
                return this.ree.mJX;
            }
        }, true);
    }

    final void boN() {
        if (this.nfI != null && this.nfI.getVisibility() != 8) {
            int[] iArr = new int[2];
            this.nfI.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                w.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
                return;
            }
            int width = this.nfI.getWidth();
            int height = this.nfI.getHeight();
            if (height == 0 || width == 0) {
                w.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
                return;
            }
            this.rdL = iArr[0] + (width / 2);
            this.rdM = (iArr[1] + (height / 2)) - com.tencent.mm.bg.a.fromDPToPix(this.mContext, 25);
            w.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[]{Integer.valueOf(this.rdL), Integer.valueOf(this.rdM)});
            this.rdS = ((float) width) / 2.0f;
            this.rdT = this.rdS * rdY;
            this.rdU = this.rdS * rdZ;
            this.rdV = this.rdT * rdZ;
            this.rdX = this.rdT;
            this.rdW = this.rdS;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mJX) {
            if (this.rdL == -1 || this.rdM == -1) {
                boN();
            }
            this.fu.setAlpha(rdR);
            if (this.rdX > this.rdV) {
                this.rdX = this.rdV;
            }
            if (this.rdX < this.rdT) {
                this.rdX = this.rdT;
            }
            this.fu.setColor(rdP);
            canvas.drawCircle((float) this.rdL, (float) this.rdM, this.rdX, this.fu);
            if (this.rdW > this.rdU) {
                this.rdW = this.rdU;
            }
            if (this.rdW < this.rdS) {
                this.rdW = this.rdS;
            }
            this.fu.setColor(rdQ);
            canvas.drawCircle((float) this.rdL, (float) this.rdM, this.rdW, this.fu);
        }
    }

    public final void stop() {
        reset();
        this.mJX = false;
        this.rdO.KH();
        postInvalidate();
    }

    public final void reset() {
        this.red = false;
        this.rec = -1.0f;
        this.mJX = false;
        this.rdW = 0.0f;
        this.rdX = 0.0f;
        postInvalidate();
    }
}
