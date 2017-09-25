package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.record.a.r;
import com.tencent.mm.plugin.record.a.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;

public class RecordVoiceBaseView extends TextView implements a {
    private boolean aJi = false;
    private Context context;
    public int duration = -1;
    public int fKw;
    private AlphaAnimation oPI;
    private AnimationDrawable oPJ;
    public r oPK;
    public String path = "";

    static /* synthetic */ void d(RecordVoiceBaseView recordVoiceBaseView) {
        w.d("MicroMsg.RecordVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{recordVoiceBaseView.path, Integer.valueOf(recordVoiceBaseView.fKw)});
        if (!recordVoiceBaseView.oPK.aQ(recordVoiceBaseView.path, recordVoiceBaseView.fKw)) {
            Toast.makeText(recordVoiceBaseView.getContext(), R.l.ejO, 1).show();
        } else if (!recordVoiceBaseView.aJi) {
            recordVoiceBaseView.aJi = true;
            recordVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(recordVoiceBaseView.oPJ, null, null, null);
            recordVoiceBaseView.oPJ.stop();
            recordVoiceBaseView.oPJ.start();
        }
    }

    static /* synthetic */ boolean e(RecordVoiceBaseView recordVoiceBaseView) {
        w.i("MicroMsg.RecordVoiceBaseView", "resume play");
        r rVar = recordVoiceBaseView.oPK;
        w.i("MicroMsg.RecordVoiceHelper", "resume play");
        ad.Pt("keep_app_silent");
        if (rVar.lEZ != null) {
            return rVar.lEZ.oR();
        }
        w.w("MicroMsg.RecordVoiceHelper", "resum play error, player is null");
        return false;
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aWW();
    }

    public RecordVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        aWW();
    }

    private void aWW() {
        this.oPI = new AlphaAnimation(0.1f, 1.0f);
        this.oPI.setDuration(1000);
        this.oPI.setRepeatCount(-1);
        this.oPI.setRepeatMode(2);
        this.oPJ = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.k.dvA);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.oPJ.addFrame(drawable, e.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.dvB);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.oPJ.addFrame(drawable, e.CTRL_INDEX);
        drawable = getResources().getDrawable(R.k.dvC);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.oPJ.addFrame(drawable, e.CTRL_INDEX);
        this.oPJ.setOneShot(false);
        this.oPJ.setVisible(true, true);
    }

    private void aWX() {
        if (this.oPI != null && this.oPI.isInitialized()) {
            setAnimation(null);
        }
        this.aJi = false;
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.k.dvz), null, null, null);
        this.oPJ.stop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RecordVoiceBaseView oPL;

            {
                this.oPL = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[]{this.oPL.path, Boolean.valueOf(this.oPL.oPK.atu())});
                if (!com.tencent.mm.n.a.aJ(this.oPL.context) && !com.tencent.mm.n.a.aH(this.oPL.context)) {
                    if (!f.rZ() && !bg.mA(this.oPL.path)) {
                        s.eP(view.getContext());
                    } else if (!bg.ap(this.oPL.path, "").equals(this.oPL.oPK.path)) {
                        RecordVoiceBaseView.d(this.oPL);
                    } else if (this.oPL.oPK.atu()) {
                        this.oPL.adL();
                    } else if (!RecordVoiceBaseView.e(this.oPL)) {
                        RecordVoiceBaseView.d(this.oPL);
                    }
                }
            }
        });
    }

    public final void adL() {
        w.d("MicroMsg.RecordVoiceBaseView", "stop play");
        aWX();
        this.oPK.adL();
    }

    public final void Dq(String str) {
        w.d("MicroMsg.RecordVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!bg.ap(str, "").equals(this.path)) {
            aWX();
        }
    }

    public final void onFinish() {
        adL();
    }
}
