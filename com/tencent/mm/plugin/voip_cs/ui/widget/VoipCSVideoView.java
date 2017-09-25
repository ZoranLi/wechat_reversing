package com.tencent.mm.plugin.voip_cs.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class VoipCSVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] nSc = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private int nMp;
    private int nMq;
    private SurfaceTexture nSd;
    private Paint nSe;
    private int rtm = a.rtp;
    private String username;

    public enum a {
        ;

        static {
            rtn = 1;
            rto = 2;
            rtp = 3;
            rtq = new int[]{rtn, rto, rtp};
        }
    }

    public VoipCSVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public VoipCSVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        this.nSe = new Paint();
        this.nSe.setColor(WebView.NIGHT_MODE_COLOR);
        this.nSe.setFilterBitmap(true);
        this.nSe.setTextSize(40.0f);
        setSurfaceTextureListener(this);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.cs.VoipCSVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        w.i(str, str2, objArr);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.cs.VoipCSVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        w.i(str, str2, objArr);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        String str = "MicroMsg.cs.VoipCSVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        this.nSd = null;
        this.nMq = 0;
        this.nMp = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        String str = "MicroMsg.cs.VoipCSVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        w.v(str, str2, objArr);
    }
}
