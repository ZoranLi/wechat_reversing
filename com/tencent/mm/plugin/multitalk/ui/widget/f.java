package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.x.n;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f implements OnClickListener, com.tencent.mm.plugin.voip.video.f, com.tencent.mm.x.d.a {
    h ivv = null;
    public TextView kxi;
    private FrameLayout nRE;
    public View nRF;
    private View nRG;
    private View nRH;
    public MMCheckBox nRI;
    public MMCheckBox nRJ;
    public MMCheckBox nRK;
    private int nRL;
    private int nRM;
    public ArrayList<RelativeLayout> nRN = new ArrayList(9);
    private com.tencent.mm.plugin.voip.video.a nRO;
    private j nRP;
    private ObservableTextureView nRQ;
    private int nRR;
    public long nRS;
    c nRT = new c(this);
    private MultiTalkMainUI nRi;
    private ImageButton nRo;

    public static class a {
        public MultiTalkVideoView nRV;
        View nRW;
        public ImageView nRX;
        public ImageView nRY;
        public TextView nRZ;
        ImageView nSa;
    }

    private class b implements Runnable {
        final /* synthetic */ f nRU;
        a nSb;

        public b(f fVar, a aVar) {
            this.nRU = fVar;
            this.nSb = aVar;
        }

        public final void run() {
            this.nSb.nRZ.setVisibility(8);
        }
    }

    private class c {
        public int h;
        public int[] nQb;
        final /* synthetic */ f nRU;
        public int w;

        public c(f fVar) {
            this.nRU = fVar;
        }
    }

    public f(MultiTalkMainUI multiTalkMainUI) {
        this.nRi = multiTalkMainUI;
        this.kxi = (TextView) multiTalkMainUI.findViewById(R.h.cIo);
        this.nRF = multiTalkMainUI.findViewById(R.h.cHx);
        this.nRo = (ImageButton) multiTalkMainUI.findViewById(R.h.cHw);
        this.nRE = (FrameLayout) multiTalkMainUI.findViewById(R.h.cHy);
        this.nRG = multiTalkMainUI.findViewById(R.h.clK);
        this.nRH = multiTalkMainUI.findViewById(R.h.clD);
        this.nRI = (MMCheckBox) multiTalkMainUI.findViewById(R.h.clT);
        this.nRJ = (MMCheckBox) multiTalkMainUI.findViewById(R.h.clL);
        this.nRK = (MMCheckBox) multiTalkMainUI.findViewById(R.h.clH);
        this.nRJ.setChecked(o.aNn().kmK);
        this.nRK.setChecked(o.aNn().nPg);
        this.nRI.setChecked(o.aNn().aMK());
        this.nRL = com.tencent.mm.bg.a.dO(multiTalkMainUI.uSU.uTo);
        this.nRM = b.cC(multiTalkMainUI.uSU.uTo);
        w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[]{Integer.valueOf(this.nRM)});
        this.nRo.setOnClickListener(this);
        this.nRG.setOnClickListener(this);
        this.nRI.setOnClickListener(this);
        this.nRJ.setOnClickListener(this);
        this.nRK.setOnClickListener(this);
        this.nRH.setOnClickListener(this);
        n.Bl().a(this);
        for (int i = 8; i >= 0; i--) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.dhI, null);
            a aVar = new a();
            aVar.nRV = (MultiTalkVideoView) relativeLayout.findViewById(R.h.cHz);
            aVar.nRV.index = i;
            aVar.nRV.setOnClickListener(this);
            aVar.nRW = relativeLayout.findViewById(R.h.ciS);
            aVar.nRX = (ImageView) relativeLayout.findViewById(R.h.cMO);
            aVar.nRY = (ImageView) relativeLayout.findViewById(R.h.clU);
            aVar.nRZ = (TextView) relativeLayout.findViewById(R.h.cGT);
            aVar.nSa = (ImageView) relativeLayout.findViewById(R.h.cbM);
            relativeLayout.setTag(aVar);
            relativeLayout.setVisibility(8);
            this.nRN.add(relativeLayout);
            this.nRE.addView(relativeLayout);
        }
    }

    public final void o(MultiTalkGroup multiTalkGroup) {
        this.nRF.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.wPj) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Y(linkedList);
    }

    private void Y(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        int i4;
        float[] fArr;
        this.nRR = linkedList.size();
        LayoutParams layoutParams = this.nRE.getLayoutParams();
        if (this.nRR <= 4) {
            i = this.nRL / 2;
            i2 = this.nRM / 2 > i ? i : this.nRM / 2;
            layoutParams.height = i2 * 2;
            i3 = i2;
            i4 = i;
        } else if (this.nRR <= 9) {
            i = this.nRL / 3;
            i2 = this.nRM / 3 > i ? i : this.nRM / 3;
            layoutParams.height = i2 * 3;
            i3 = i2;
            i4 = i;
        } else {
            w.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", new Object[]{Integer.valueOf(this.nRR)});
            return;
        }
        this.nRE.setLayoutParams(layoutParams);
        w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(this.nRR)});
        Object obj = (am.is2G(this.nRi) || am.is3G(this.nRi)) ? 1 : null;
        HashSet hashSet = new HashSet();
        hashSet.addAll(o.aNn().nPj);
        if (o.aNn().aMK()) {
            hashSet.add(m.xL());
        }
        if (this.nRR <= 4) {
            fArr = i.nPQ[this.nRR];
        } else {
            fArr = i.nPQ[5];
        }
        if (fArr != null) {
            for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                MultiTalkGroupMember multiTalkGroupMember = this.nRR > i5 / 2 ? (MultiTalkGroupMember) linkedList.get(i5 / 2) : null;
                i2 = (int) (fArr[i5] * ((float) i4));
                int i6 = (int) (fArr[i5 + 1] * ((float) i3));
                if (this.nRR == 2 && i2 == 0) {
                    i2 = 1;
                }
                if (this.nRR == 4 && i2 == 0) {
                    i = 1;
                } else {
                    i = i2;
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.nRN.get(i5 / 2);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.width = i4;
                layoutParams2.height = i3;
                layoutParams2.leftMargin = i;
                layoutParams2.topMargin = i6;
                relativeLayout.setLayoutParams(layoutParams2);
                a aVar = (a) relativeLayout.getTag();
                if (multiTalkGroupMember != null) {
                    w.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[]{aVar.nRV.username, multiTalkGroupMember.wPk});
                    r3.username = r11;
                    aVar.nRV.position = aVar.nRV.index;
                    if (multiTalkGroupMember.status != 10) {
                        aVar.nRW.setVisibility(0);
                        if (aVar.nSa.getBackground() != null) {
                            aVar.nSa.setVisibility(0);
                            ((AnimationDrawable) aVar.nSa.getBackground()).stop();
                            ((AnimationDrawable) aVar.nSa.getBackground()).start();
                        }
                    } else {
                        aVar.nRW.setVisibility(8);
                        a(aVar);
                    }
                    if (hashSet.contains(multiTalkGroupMember.wPk) && obj == null) {
                        aVar.nRV.aNx();
                    } else {
                        aVar.nRV.aNw();
                    }
                } else {
                    aVar.nRW.setVisibility(8);
                    a(aVar);
                    MultiTalkVideoView multiTalkVideoView = aVar.nRV;
                    w.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[]{multiTalkVideoView.username, multiTalkVideoView.nSf.name()});
                    multiTalkVideoView.nSf = com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView.a.None;
                    multiTalkVideoView.username = null;
                    multiTalkVideoView.aNy();
                }
                relativeLayout.setVisibility(0);
            }
        }
        if (this.nRR <= 4) {
            for (i = this.nRR; i < 9; i++) {
                ((RelativeLayout) this.nRN.get(i)).setVisibility(8);
            }
        }
        if (o.aNn().aMN() && this.nRI != null && !this.nRI.isChecked()) {
            o.aNn().pS(1);
        }
    }

    public final RelativeLayout Bo(String str) {
        Iterator it = this.nRN.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((a) relativeLayout.getTag()).nRV.username)) {
                return relativeLayout;
            }
        }
        return null;
    }

    public final void onClick(View view) {
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            if (m.xL().equals(multiTalkVideoView.username) && multiTalkVideoView.aNA() && this.nRO != null) {
                this.nRO.bro();
            }
        } else if (view.getId() == R.h.cHw) {
            o.aNn().c(true, false, false);
        } else if (view.getId() == R.h.clK) {
            d.nPa++;
            o.aNn().fS(true);
        } else if (view.getId() == R.h.clH) {
            d.nPc++;
            o.aNn().fT(this.nRK.isChecked());
        } else if (view.getId() == R.h.clL) {
            d.nPb++;
            e aNn = o.aNn();
            boolean isChecked = this.nRJ.isChecked();
            o.aNm().nOT.lY(isChecked);
            aNn.fN(isChecked);
        } else if (view.getId() == R.h.clT) {
            d.nPd++;
            if (!com.tencent.mm.compatible.e.b.rV()) {
                com.tencent.mm.al.a.a(this.nRi, R.l.fcp, null);
                this.nRI.setChecked(false);
            } else if (!o.aNn().aMN()) {
                this.nRI.setChecked(false);
            } else if (am.is2G(this.nRi) || am.is3G(this.nRi)) {
                com.tencent.mm.plugin.multitalk.a.h aNl = o.aNl();
                com.tencent.mm.al.a.a(this.nRi, R.l.eCh, null);
                aNl.nPO = true;
                this.nRI.setChecked(false);
            } else if (am.isNetworkConnected(this.nRi)) {
                if (this.nRI.isChecked()) {
                    a(null, false);
                } else {
                    b(null, false);
                    o.aNn().pS(1);
                }
                this.nRI.setChecked(o.aNn().aMK());
            } else {
                com.tencent.mm.al.a.a(this.nRi, R.l.fco, null);
                this.nRI.setChecked(false);
            }
        } else if (view.getId() == R.h.clD) {
            d.nPe++;
            Context context = this.nRi;
            context.nQM = true;
            Intent intent = new Intent(context, MultiTalkAddMembersUI.class);
            List arrayList = new ArrayList();
            for (MultiTalkGroupMember multiTalkGroupMember : o.aNn().nPl.wPj) {
                if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                    arrayList.add(multiTalkGroupMember.wPk);
                }
            }
            intent.putExtra("titile", context.getString(R.l.eBG));
            intent.putExtra("chatroomName", o.aNn().nPl.wPh);
            intent.putExtra("always_select_contact", bg.c(arrayList, ","));
            intent.putExtra("key_need_gallery", false);
            context.startActivityForResult(intent, 1);
        }
    }

    public final void b(HashSet<String> hashSet) {
        Iterator it = this.nRN.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!m.xL().equals(aVar.nRV.username)) {
                if (hashSet.contains(aVar.nRV.username)) {
                    if (!aVar.nRV.aNA()) {
                        aVar.nRV.aNx();
                    }
                } else if (aVar.nRV.aNA()) {
                    aVar.nRV.aNw();
                }
            }
        }
    }

    public final void aNt() {
        Iterator it = this.nRN.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!m.xL().equals(aVar.nRV.username) && aVar.nRV.aNA()) {
                aVar.nRV.aNw();
            }
        }
    }

    public final void a(RelativeLayout relativeLayout, boolean z) {
        if (!z) {
            this.nRS = System.currentTimeMillis();
        }
        w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        RelativeLayout Bo = Bo(m.xL());
        if (Bo != null) {
            if (this.nRQ == null) {
                w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.nRQ = new ObservableTextureView(this.nRi);
                this.nRQ.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                Bo.addView(this.nRQ);
                this.nRQ.setVisibility(0);
            }
            if (this.nRO == null) {
                w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.nRO = new com.tencent.mm.plugin.voip.video.a(320, 240);
                this.nRO.a(this, true);
                this.nRO.a(this.nRQ);
                this.nRO.brp();
                if (!o.aNn().nPi) {
                    this.nRO.bro();
                }
                w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(this.nRO.brs()), Boolean.valueOf(this.nRO.brt())});
            }
            if (this.nRP == null) {
                this.nRP = new j(this.nRi);
                com.tencent.mm.sdk.f.e.d(new Runnable(this.nRP) {
                    final /* synthetic */ j nPY;

                    {
                        this.nPY = r1;
                    }

                    public final void run() {
                        Looper.prepare();
                        w.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
                        this.nPY.nPW = new ae();
                        Looper.loop();
                    }
                }, "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
            }
        }
    }

    public final void b(RelativeLayout relativeLayout, boolean z) {
        if (!z && this.nRS != 0 && System.currentTimeMillis() - this.nRS > 0 && o.aNn().aMO()) {
            d.m(System.currentTimeMillis() - this.nRS, i.aNd());
            this.nRS = 0;
        }
        w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
        if (relativeLayout == null) {
            relativeLayout = Bo(m.xL());
        }
        if (relativeLayout != null) {
            if (this.nRQ != null) {
                relativeLayout.removeView(this.nRQ);
                this.nRQ = null;
            }
            if (this.nRO != null) {
                this.nRO.brq();
                com.tencent.mm.plugin.voip.video.a.brr();
                this.nRO = null;
            }
            if (this.nRP != null) {
                j jVar = this.nRP;
                jVar.nPt = null;
                jVar.nPX.lre = false;
                jVar.nPX.nQb = null;
                if (jVar.nPW != null) {
                    jVar.nPW.removeCallbacksAndMessages(null);
                    jVar.nPW.getLooper().quit();
                    jVar.nPW = null;
                }
                this.nRP = null;
            }
        }
    }

    public final void fV(boolean z) {
        w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onFinish");
        this.nRR = 0;
        if (!z) {
            af.v(new Runnable(this) {
                final /* synthetic */ f nRU;

                {
                    this.nRU = r1;
                }

                public final void run() {
                    this.nRU.kxi.setText(R.l.eBI);
                }
            });
        }
        b(null, false);
        Iterator it = this.nRN.iterator();
        while (it.hasNext()) {
            ((a) ((RelativeLayout) it.next()).getTag()).nRV.setSurfaceTextureListener(null);
        }
        n.Bl().b(this);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3) {
        if (o.aNn().aMN()) {
            if (this.nRT.nQb == null) {
                this.nRT.w = i;
                this.nRT.h = i2;
                this.nRT.nQb = new int[(this.nRT.w * this.nRT.h)];
            }
            if (!(o.aNn().aMK() || i.aNf())) {
                o.aNn().pS(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            o.aNn().nPi = this.nRO.brs();
            int i4 = this.nRO.brs() ? OpenGlRender.rpK : 0;
            int i5 = this.nRO.brt() ? OpenGlRender.rpJ : OpenGlRender.rpI;
            g b = o.aNm().nOT.b(bArr, (int) j, this.nRT.w, this.nRT.h, i3 & 31, this.nRT.nQb);
            if (b.ret < 0 || this.nRT.nQb == null || b.wPs == 0 || b.wPt == 0) {
                w.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[]{Integer.valueOf(b.ret)});
                return;
            }
            int i6;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i7 = i4 == OpenGlRender.rpK ? 258 : 2;
            if (o.aNn().nPj.size() >= 4) {
                i6 = i4 == OpenGlRender.rpK ? 257 : 1;
            } else {
                i6 = i7;
            }
            i7 = o.aNm().nOT.a(bArr, (short) ((int) j), i, i2, i3, i6);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                w.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[]{Integer.valueOf(b.wPs), Integer.valueOf(b.wPt), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            }
            if (i7 <= 0) {
                w.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[]{Integer.valueOf(i7)});
            }
            if (this.nRP != null && this.nRT.nQb != null) {
                j jVar = this.nRP;
                int[] iArr = this.nRT.nQb;
                i7 = b.wPs;
                int i8 = b.wPt;
                if (iArr == null) {
                    w.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    return;
                } else if (jVar.nPX.lre) {
                    w.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    return;
                } else {
                    if (jVar.nPX.nQb == null) {
                        jVar.nPX.nQb = new int[iArr.length];
                    }
                    jVar.nPX.w = i7;
                    jVar.nPX.h = i8;
                    jVar.nPX.nPZ = i3;
                    jVar.nPX.nQa = i4;
                    jVar.nPX.angle = i5;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i6 = jVar.nPX.h;
                    if (jVar.nPX.h > jVar.nPX.w) {
                        i6 = jVar.nPX.w;
                    }
                    if (jVar.nPX.mhk == null) {
                        jVar.nPX.mhk = Bitmap.createBitmap(i6, i6, Config.RGB_565);
                    }
                    if (jVar.nPX.mhk != null) {
                        jVar.nPX.mhk.setPixels(iArr, jVar.nPX.w - jVar.nPX.h, jVar.nPX.w, 0, 0, i6, i6);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        w.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                    }
                    if (jVar.nPW != null) {
                        jVar.nPW.post(new com.tencent.mm.plugin.multitalk.a.j.b(jVar));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        b(null, false);
    }

    public final synchronized void a(String str, int[] iArr, int i, int i2, int i3, int i4) {
        RelativeLayout Bo = Bo(str);
        if (Bo != null) {
            ((a) Bo.getTag()).nRV.a(iArr, i, i2, 0, i4);
        }
    }

    public final synchronized void a(String str, Bitmap bitmap, int i, int i2) {
        RelativeLayout Bo = Bo(str);
        if (Bo != null) {
            ((a) Bo.getTag()).nRV.a(bitmap, i2, i);
        }
    }

    public final void aNu() {
        w.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.ivv == null) {
            this.ivv = com.tencent.mm.al.a.a(this.nRi, R.l.fcp, new Runnable(this) {
                final /* synthetic */ f nRU;

                {
                    this.nRU = r1;
                }

                public final void run() {
                    this.nRU.b(null, false);
                }
            });
        }
        if (!this.ivv.isShowing()) {
            this.ivv.show();
        }
        o.aNn().pS(1);
    }

    public final void ho(String str) {
        w.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[]{str});
        RelativeLayout Bo = Bo(str);
        if (Bo != null) {
            ((a) Bo.getTag()).nRV.aNv();
        }
    }

    private static void a(a aVar) {
        if (aVar.nSa.getBackground() != null) {
            ((AnimationDrawable) aVar.nSa.getBackground()).stop();
        }
        aVar.nSa.setVisibility(8);
    }
}
