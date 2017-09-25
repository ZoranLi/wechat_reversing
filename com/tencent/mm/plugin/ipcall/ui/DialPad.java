package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] mRl = new String[]{"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    private static final String[] mRm = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    boolean mRk = false;
    Map<Integer, DialNumberButton> mRn = new HashMap();
    private Map<String, DialNumberButton> mRo = new HashMap();
    Map<Integer, View> mRp = new HashMap();
    a mRq;

    public interface a {
        void yy(String str);

        void yz(String str);
    }

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.i.bJl, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.f.baf);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(R.f.bah);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(R.f.bag);
        a(R.h.bJd, mRl[0], mRm[0], dimensionPixelSize);
        a(R.h.bJj, mRl[1], mRm[1], dimensionPixelSize);
        a(R.h.bJi, mRl[2], mRm[2], dimensionPixelSize);
        a(R.h.bJb, mRl[3], mRm[3], dimensionPixelSize);
        a(R.h.bJa, mRl[4], mRm[4], dimensionPixelSize);
        a(R.h.bJg, mRl[5], mRm[5], dimensionPixelSize);
        a(R.h.bJe, mRl[6], mRm[6], dimensionPixelSize);
        a(R.h.bIZ, mRl[7], mRm[7], dimensionPixelSize);
        a(R.h.bJc, mRl[8], mRm[8], dimensionPixelSize);
        a(R.h.bJh, mRl[9], mRm[9], dimensionPixelSize3);
        a(R.h.bJk, mRl[10], mRm[10], dimensionPixelSize);
        a(R.h.bJf, mRl[11], mRm[11], dimensionPixelSize2);
        this.mRp.put(Integer.valueOf(R.h.bJO), findViewById(R.h.bJO));
        this.mRp.put(Integer.valueOf(R.h.bJT), findViewById(R.h.bJT));
        this.mRp.put(Integer.valueOf(R.h.bJR), findViewById(R.h.bJR));
        this.mRp.put(Integer.valueOf(R.h.bJL), findViewById(R.h.bJL));
        this.mRp.put(Integer.valueOf(R.h.bJK), findViewById(R.h.bJK));
        for (View view : this.mRp.values()) {
            if (this.mRk) {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.aVZ));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.aTy));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void a(int i, String str, String str2, float f) {
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        if (!bg.mA(str) && str.length() == 1) {
            dialNumberButton.mRi.setText(str);
        }
        if (!bg.mA(str2) || "1".equals(str)) {
            dialNumberButton.mRj.setText(str2);
            dialNumberButton.mRj.setVisibility(0);
        } else {
            dialNumberButton.mRj.setVisibility(8);
        }
        dialNumberButton.mRi.setTextSize(0, f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.fc(this.mRk);
        this.mRn.put(Integer.valueOf(i), dialNumberButton);
        this.mRo.put(str, dialNumberButton);
    }

    public void onClick(View view) {
        if (this.mRn.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.mRn.get(Integer.valueOf(view.getId()));
            String aES = dialNumberButton.aES();
            String aET = dialNumberButton.aET();
            d aEs = i.aEs();
            int HH = d.HH(aES);
            if (HH != -1 && d.brw()) {
                AudioManager audioManager = ap.yZ().gNq;
                if (audioManager == null) {
                    audioManager = (AudioManager) d.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (aEs.roQ) {
                        if (aEs.roR == null) {
                        } else {
                            aEs.roR.startTone(HH, 250);
                        }
                    }
                }
            }
            if (this.mRq != null) {
                String str;
                a aVar = this.mRq;
                if (bg.mA(aES)) {
                    str = aET;
                } else {
                    str = aES;
                }
                aVar.yy(str);
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!this.mRn.containsKey(Integer.valueOf(view.getId()))) {
            return false;
        }
        DialNumberButton dialNumberButton = (DialNumberButton) this.mRn.get(Integer.valueOf(view.getId()));
        String aES = dialNumberButton.aES();
        String aET = dialNumberButton.aET();
        if (this.mRq != null) {
            a aVar = this.mRq;
            if (!bg.mA(aES)) {
                aET = aES;
            }
            aVar.yz(aET);
        }
        return true;
    }

    public void onViewAdded(View view) {
        w.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[]{view.getClass().getSimpleName()});
    }

    public void onViewRemoved(View view) {
        w.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[]{view.getClass().getSimpleName()});
    }
}
