package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView;
import com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a;
import com.tencent.mm.sdk.platformtools.bg;

public final class i extends f {
    public LinearLayout szf;
    public LinearLayout szg;
    public NoteEditorVoiceBaseView szh;
    public ImageView szi;
    private TextView szj;

    public i(View view, k kVar) {
        super(view, kVar);
        this.szf = (LinearLayout) view.findViewById(R.h.coK);
        this.szg = (LinearLayout) view.findViewById(R.h.coJ);
        this.szi = (ImageView) view.findViewById(R.h.coL);
        this.szj = (TextView) view.findViewById(R.h.coN);
        this.szh = (NoteEditorVoiceBaseView) view.findViewById(R.h.coG);
        a bCg = a.bCg();
        NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.szh;
        if (noteEditorVoiceBaseView != null) {
            for (Object obj : bCg.gJv) {
                if (noteEditorVoiceBaseView == obj) {
                    break;
                }
            }
            bCg.gJv.add(noteEditorVoiceBaseView);
        }
        this.syR.setVisibility(0);
        this.szf.setVisibility(8);
        this.szg.setVisibility(0);
        this.fKf.setVisibility(8);
        this.syM.setVisibility(8);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.a.a aVar, int i, int i2) {
        h hVar = (h) aVar;
        if (hVar.suJ) {
            this.szg.setVisibility(0);
            this.szf.setVisibility(8);
            this.syR.setPadding(0, 0, 0, 0);
            if (aVar.suA) {
                this.szh.setBackgroundResource(R.g.bmf);
            } else {
                this.szh.setBackgroundResource(R.g.bme);
            }
            NoteEditorVoiceBaseView noteEditorVoiceBaseView = this.szh;
            String str = hVar.fQE;
            int i3 = hVar.fKw;
            CharSequence charSequence = hVar.suP;
            noteEditorVoiceBaseView.path = bg.ap(str, "");
            noteEditorVoiceBaseView.fKw = i3;
            noteEditorVoiceBaseView.setText(charSequence);
        } else {
            this.syR.setPadding(26, 7, 0, 7);
            this.szg.setVisibility(8);
            this.szf.setVisibility(0);
            ImageView imageView = this.szi;
            if (imageView.getAnimation() != null) {
                imageView.startAnimation(imageView.getAnimation());
            } else {
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setInterpolator(new LinearInterpolator());
                alphaAnimation.setRepeatCount(-1);
                alphaAnimation.setRepeatMode(2);
                imageView.startAnimation(alphaAnimation);
            }
            if (hVar.suE.booleanValue()) {
                this.szj.setText(R.l.ejT);
            } else {
                this.szj.setText(R.l.ejS);
            }
        }
        super.a(aVar, i, i2);
    }

    public final int bCe() {
        return 4;
    }
}
