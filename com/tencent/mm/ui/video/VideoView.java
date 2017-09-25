package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public class VideoView extends SurfaceView {
    private int gRD;
    private int gRE;
    public OnCompletionListener ibJ;
    public OnErrorListener ibK;
    private int ls;
    private Context mContext;
    public MediaPlayer pyq;
    private SurfaceHolder qWB;
    public String sXg;
    public boolean sXh;
    public boolean sXi;
    OnVideoSizeChangedListener sXj;
    OnPreparedListener sXk;
    private OnCompletionListener sXl;
    private OnErrorListener sXm;
    Callback sXn;
    private int wrJ;
    private int wrK;
    public OnPreparedListener wrL;
    private int wrM;
    public int wrN;
    private OnBufferingUpdateListener wrO;

    public final void cao() {
        if (this.gRE != 0 && this.gRD != 0) {
            int i;
            int i2 = this.gRD;
            int i3 = this.gRE;
            w.v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
            w.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
            int width = getWidth();
            int height = getHeight();
            if (width <= 0) {
                i = i2;
            } else {
                i = width;
            }
            if (height <= 0) {
                width = i3;
            } else {
                width = height;
            }
            float f = (((float) i) * 1.0f) / ((float) i2);
            float f2 = (((float) width) * 1.0f) / ((float) i3);
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i2) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i;
                layoutParams.height = (int) (((float) i3) * f);
            }
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
            invalidate();
            w.v("MicroMsg.VideoView", "video size after:" + this.pyq.getVideoWidth() + "   " + this.pyq.getVideoHeight());
            w.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        cap();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qWB = null;
        this.pyq = null;
        this.sXj = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoView wrP;

            {
                this.wrP = r1;
            }

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                this.wrP.gRD = mediaPlayer.getVideoWidth();
                this.wrP.gRE = mediaPlayer.getVideoHeight();
                w.v("MicroMsg.VideoView", "on size change size:( " + this.wrP.gRD + " , " + this.wrP.gRE + " )");
                this.wrP.cao();
            }
        };
        this.sXk = new OnPreparedListener(this) {
            final /* synthetic */ VideoView wrP;

            {
                this.wrP = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onPrepared(android.media.MediaPlayer r3) {
                /*
                r2 = this;
                r0 = r2.wrP;
                r0.sXh = true;
                r0 = r2.wrP;
                r0 = r0.wrL;
                if (r0 == 0) goto L_0x001c;
            L_0x000d:
                r0 = r2.wrP;
                r0 = r0.wrL;
                r1 = r2.wrP;
                r1 = r1.pyq;
                r0.onPrepared(r1);
            L_0x001c:
                r0 = r2.wrP;
                r1 = r3.getVideoWidth();
                r0.gRD = r1;
                r0 = r2.wrP;
                r1 = r3.getVideoHeight();
                r0.gRE = r1;
                r0 = r2.wrP;
                r0.cao();
                r0 = r2.wrP;
                r0 = r0.gRD;
                if (r0 == 0) goto L_0x00c7;
            L_0x003b:
                r0 = r2.wrP;
                r0 = r0.gRE;
                if (r0 == 0) goto L_0x00c7;
            L_0x0043:
                r0 = r2.wrP;
                r0 = r0.sXi;
                if (r0 == 0) goto L_0x0059;
            L_0x004b:
                r0 = r2.wrP;
                r0 = r0.pyq;
                r0.start();
                r0 = r2.wrP;
                r0.sXi = false;
            L_0x0059:
                r0 = r2.wrP;
                r0 = r0.wrJ;
                r1 = r2.wrP;
                r1 = r1.gRD;
                if (r0 != r1) goto L_0x00bb;
            L_0x0067:
                r0 = r2.wrP;
                r0 = r0.wrK;
                r1 = r2.wrP;
                r1 = r1.gRE;
                if (r0 != r1) goto L_0x00bb;
            L_0x0075:
                r0 = r2.wrP;
                r0 = r0.wrN;
                if (r0 == 0) goto L_0x0091;
            L_0x007d:
                r0 = r2.wrP;
                r0 = r0.pyq;
                r1 = r2.wrP;
                r1 = r1.wrN;
                r0.seekTo(r1);
                r0 = r2.wrP;
                r0.wrN = 0;
            L_0x0091:
                r0 = r2.wrP;
                r0 = r0.sXi;
                if (r0 != 0) goto L_0x00bb;
            L_0x0099:
                r0 = r2.wrP;
                r0 = r0.isPlaying();
                if (r0 != 0) goto L_0x00bb;
            L_0x00a1:
                r0 = r2.wrP;
                r0 = r0.wrN;
                if (r0 != 0) goto L_0x00bb;
            L_0x00a9:
                r0 = r2.wrP;
                r1 = r0.pyq;
                if (r1 == 0) goto L_0x00c5;
            L_0x00af:
                r1 = r0.sXh;
                if (r1 == 0) goto L_0x00c5;
            L_0x00b3:
                r0 = r0.pyq;
                r0 = r0.getCurrentPosition();
            L_0x00b9:
                if (r0 <= 0) goto L_0x00bb;
            L_0x00bb:
                r0 = r2.wrP;
                r0 = r0.pyq;
                r0.isPlaying();
                return;
            L_0x00c5:
                r0 = 0;
                goto L_0x00b9;
            L_0x00c7:
                r0 = r2.wrP;
                r0 = r0.wrN;
                if (r0 == 0) goto L_0x00e3;
            L_0x00cf:
                r0 = r2.wrP;
                r0 = r0.pyq;
                r1 = r2.wrP;
                r1 = r1.wrN;
                r0.seekTo(r1);
                r0 = r2.wrP;
                r0.wrN = 0;
            L_0x00e3:
                r0 = r2.wrP;
                r0 = r0.sXi;
                if (r0 == 0) goto L_0x00bb;
            L_0x00eb:
                r0 = r2.wrP;
                r0 = r0.pyq;
                r0.start();
                r0 = r2.wrP;
                r0.sXi = false;
                goto L_0x00bb;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.video.VideoView.2.onPrepared(android.media.MediaPlayer):void");
            }
        };
        this.sXl = new OnCompletionListener(this) {
            final /* synthetic */ VideoView wrP;

            {
                this.wrP = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.wrP.ibJ != null) {
                    this.wrP.ibJ.onCompletion(this.wrP.pyq);
                }
            }
        };
        this.sXm = new OnErrorListener(this) {
            final /* synthetic */ VideoView wrP;

            {
                this.wrP = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.d("MicroMsg.VideoView", "Error: " + i + "," + i2);
                if (this.wrP.ibK == null || !this.wrP.ibK.onError(this.wrP.pyq, i, i2)) {
                    this.wrP.getWindowToken();
                }
                return true;
            }
        };
        this.wrO = new OnBufferingUpdateListener(this) {
            final /* synthetic */ VideoView wrP;

            {
                this.wrP = r1;
            }

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                this.wrP.wrM = i;
            }
        };
        this.sXn = new Callback(this) {
            final /* synthetic */ VideoView wrP;

            {
                this.wrP = r1;
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                this.wrP.wrJ = i2;
                this.wrP.wrK = i3;
                if (this.wrP.pyq != null && this.wrP.sXh && this.wrP.gRD == i2 && this.wrP.gRE == i3) {
                    if (this.wrP.wrN != 0) {
                        this.wrP.pyq.seekTo(this.wrP.wrN);
                        this.wrP.wrN = 0;
                    }
                    this.wrP.pyq.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                this.wrP.qWB = surfaceHolder;
                this.wrP.auE();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                this.wrP.qWB = null;
                if (this.wrP.pyq != null) {
                    this.wrP.pyq.reset();
                    this.wrP.pyq.release();
                    this.wrP.pyq = null;
                }
            }
        };
        this.mContext = context;
        cap();
    }

    private void cap() {
        this.gRD = 0;
        this.gRE = 0;
        getHolder().addCallback(this.sXn);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void stopPlayback() {
        if (this.pyq != null) {
            this.pyq.stop();
            this.pyq.release();
            this.pyq = null;
        }
    }

    public final void auE() {
        if (this.sXg != null && this.qWB != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.mContext.sendBroadcast(intent);
            if (this.pyq != null) {
                this.pyq.reset();
                this.pyq.release();
                this.pyq = null;
            }
            try {
                this.pyq = new i();
                this.pyq.setOnPreparedListener(this.sXk);
                this.pyq.setOnVideoSizeChangedListener(this.sXj);
                this.sXh = false;
                w.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
                this.ls = -1;
                this.pyq.setOnCompletionListener(this.sXl);
                this.pyq.setOnErrorListener(this.sXm);
                this.pyq.setOnBufferingUpdateListener(this.wrO);
                this.wrM = 0;
                this.pyq.setDataSource(this.sXg);
                this.pyq.setDisplay(this.qWB);
                this.pyq.setAudioStreamType(3);
                this.pyq.setScreenOnWhilePlaying(true);
                this.pyq.prepareAsync();
                this.gRE = this.pyq.getVideoHeight();
                this.gRD = this.pyq.getVideoWidth();
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    public final boolean isPlaying() {
        if (this.pyq == null || !this.sXh) {
            return false;
        }
        return this.pyq.isPlaying();
    }
}
