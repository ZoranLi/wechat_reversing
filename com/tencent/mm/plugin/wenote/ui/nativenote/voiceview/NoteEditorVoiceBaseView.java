package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

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
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;

public class NoteEditorVoiceBaseView extends TextView implements a {
    private boolean aJi = false;
    private Context context;
    private int duration = -1;
    public int fKw;
    private AlphaAnimation oPI;
    private AnimationDrawable oPJ;
    public String path = "";

    static /* synthetic */ void c(NoteEditorVoiceBaseView noteEditorVoiceBaseView) {
        w.d("MicroMsg.NoteEditorVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{noteEditorVoiceBaseView.path, Integer.valueOf(noteEditorVoiceBaseView.fKw)});
        if (!a.bCg().aQ(noteEditorVoiceBaseView.path, noteEditorVoiceBaseView.fKw)) {
            Toast.makeText(noteEditorVoiceBaseView.getContext(), R.l.ejO, 1).show();
        } else if (!noteEditorVoiceBaseView.aJi) {
            noteEditorVoiceBaseView.aJi = true;
            noteEditorVoiceBaseView.setCompoundDrawablesWithIntrinsicBounds(noteEditorVoiceBaseView.oPJ, null, null, null);
            noteEditorVoiceBaseView.oPJ.stop();
            noteEditorVoiceBaseView.oPJ.start();
        }
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aWW();
    }

    public NoteEditorVoiceBaseView(Context context, AttributeSet attributeSet, int i) {
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

    public final void aWX() {
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
            final /* synthetic */ NoteEditorVoiceBaseView szk;

            {
                this.szk = r1;
            }

            public final void onClick(View view) {
                String str = "MicroMsg.NoteEditorVoiceBaseView";
                String str2 = "clicked path:%s, player isPlay:%s, path:%s";
                Object[] objArr = new Object[3];
                objArr[0] = this.szk.path;
                objArr[1] = a.bCg().atu() ? "true" : "false";
                objArr[2] = a.bCg().path;
                w.i(str, str2, objArr);
                if (!a.aJ(this.szk.context) && !a.aH(this.szk.context)) {
                    if (!f.rZ() && !bg.mA(this.szk.path)) {
                        s.eP(view.getContext());
                    } else if (!j.bBf().jYO) {
                        if (bg.ap(this.szk.path, "").equals(a.bCg().path) && a.bCg().atu()) {
                            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.szk;
                            w.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
                            noteEditorVoiceBaseView.aWX();
                            a.bCg().adL();
                            return;
                        }
                        NoteEditorVoiceBaseView.c(this.szk);
                    }
                }
            }
        });
    }

    public final void Lz(String str) {
        w.d("MicroMsg.NoteEditorVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (!bg.ap(str, "").equals(this.path)) {
            aWX();
        }
    }

    public final void bCf() {
        aWX();
    }
}
