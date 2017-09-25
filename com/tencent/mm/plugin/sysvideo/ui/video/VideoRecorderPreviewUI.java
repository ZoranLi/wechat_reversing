package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.video.VideoView;
import com.tencent.mm.ui.x;

public class VideoRecorderPreviewUI extends MMActivity {
    private long duration = -1;
    private VideoView qWv;
    private String qWw = null;
    private final int qWx = 3000;
    private ae qWy = new ae(this) {
        final /* synthetic */ VideoRecorderPreviewUI qWz;

        {
            this.qWz = r1;
        }

        public final void handleMessage(Message message) {
            this.qWz.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.qWz.uSU.bQg();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.uSU.bQg();
        this.qWw = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        zi(R.l.faq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI qWz;

            {
                this.qWz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qWz.finish();
                this.qWz.overridePendingTransition(0, 0);
                return true;
            }
        });
        KC();
    }

    public void onStart() {
        super.onStart();
    }

    protected final void KC() {
        this.qWv = (VideoView) findViewById(R.h.cMc);
        this.qWv.ibK = new OnErrorListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI qWz;

            {
                this.qWz = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                this.qWz.qWv.stopPlayback();
                g.h(this.qWz, R.l.fap, R.l.fan);
                return false;
            }
        };
        this.qWv.wrL = new OnPreparedListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI qWz;

            {
                this.qWz = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                w.d("MicroMsg.VideoRecorderPreviewUI", com.tencent.mm.compatible.util.g.sc() + " onPrepared");
                w.d("MicroMsg.VideoRecorderPreviewUI", com.tencent.mm.compatible.util.g.sc() + " onPrepared");
                VideoView a = this.qWz.qWv;
                if (a.pyq == null || !a.sXh) {
                    a.sXi = true;
                } else {
                    a.pyq.start();
                    a.sXi = false;
                }
                this.qWz.qWy.sendEmptyMessageDelayed(0, 3000);
            }
        };
        findViewById(R.h.cMb).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI qWz;

            {
                this.qWz = r1;
            }

            public final void onClick(View view) {
                this.qWz.qWy.removeMessages(0);
                if (this.qWz.bPX()) {
                    this.qWz.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    this.qWz.uSU.bQg();
                    return;
                }
                this.qWz.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.qWz.bPW();
                this.qWz.qWy.removeMessages(0);
                this.qWz.qWy.sendEmptyMessageDelayed(0, 3000);
            }
        });
        this.qWv.ibJ = new OnCompletionListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI qWz;

            {
                this.qWz = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.qWz.finish();
                this.qWz.overridePendingTransition(0, 0);
            }
        };
        if (this.qWw != null) {
            this.qWv.stopPlayback();
            VideoView videoView = this.qWv;
            videoView.sXg = this.qWw;
            videoView.sXi = false;
            videoView.wrN = 0;
            videoView.auE();
            videoView.requestLayout();
            videoView.invalidate();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.qWv.isPlaying()) {
            VideoView videoView = this.qWv;
            if (videoView.pyq != null && videoView.sXh && videoView.pyq.isPlaying()) {
                videoView.pyq.pause();
            }
            videoView.sXi = false;
        }
        finish();
        overridePendingTransition(0, 0);
        this.qWy.removeMessages(0);
    }

    protected final void bE(View view) {
        x.d(x.a(getWindow(), null), this.uSU.uTa);
        ((ViewGroup) this.uSU.uTa.getParent()).removeView(this.uSU.uTa);
        ((ViewGroup) getWindow().getDecorView()).addView(this.uSU.uTa, 0);
    }

    protected final int getLayoutId() {
        return R.i.dpv;
    }
}
