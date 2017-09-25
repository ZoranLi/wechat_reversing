package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.plugin.af.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sight.encode.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.List;

public class MainSightForwardContainerView extends RelativeLayout implements OnItemClickListener, a {
    private boolean fAG;
    private int ls;
    private boolean mJX;
    public View ntw;
    public MainSightSelectContactView pwW;
    public SightCameraView pwX;
    public b pwY;
    public View pwZ;
    public View pxa;
    public View pxb;
    private Dialog pxc;
    private boolean pxd;
    public String pxe;
    private boolean pxf;
    public String pxg;
    public float pxh;
    private b pxi;
    private boolean pxj;
    public MMFragmentActivity pxk;
    private boolean pxl;
    private c pxm;
    private boolean pxn;
    private MediaPlayer pxo;

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pxc = null;
        this.mJX = false;
        this.pxd = true;
        this.pxe = "";
        this.pxf = false;
        this.pxg = "";
        this.ls = 1;
        this.pxh = 1.0f;
        this.fAG = false;
        this.pxi = new b();
        this.pxj = false;
        this.pxl = false;
        this.pxm = new c<ok>(this) {
            final /* synthetic */ MainSightForwardContainerView pxp;

            {
                this.pxp = r2;
                this.usg = ok.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                ok okVar = (ok) bVar;
                String str = "MicroMsg.MainSightContainerView";
                String str2 = "on sight send result back[%d], type %d, waitSend %B, isForSns %B";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(hashCode());
                objArr[1] = Integer.valueOf(okVar.fVy.type);
                objArr[2] = Boolean.valueOf(this.pxp.pxc != null);
                objArr[3] = Boolean.valueOf(this.pxp.pxn);
                w.i(str, str2, objArr);
                switch (okVar.fVy.type) {
                    case 0:
                        this.pxp.pxl = false;
                        if (!this.pxp.pxn) {
                            if (!okVar.fVy.fVA) {
                                this.pxp.postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass5 pxq;

                                    {
                                        this.pxq = r1;
                                    }

                                    public final void run() {
                                        this.pxq.pxp.bcM();
                                    }
                                }, 500);
                                break;
                            }
                            g.oUh.i(11443, new Object[]{Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(0)});
                            this.pxp.hi(true);
                            break;
                        }
                        if (okVar.fVy.fVA) {
                            g.oUh.i(11443, new Object[]{Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(0)});
                        }
                        this.pxp.amk();
                        break;
                }
                return false;
            }
        };
        this.pxn = false;
    }

    public MainSightForwardContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void amk() {
        a.urY.c(this.pxm);
    }

    public final void bcM() {
        boolean z = true;
        w.i("MicroMsg.MainSightContainerView", "toggle play video, path %s, mute %B, playing %B", new Object[]{this.pxg, Boolean.valueOf(this.pxd), Boolean.valueOf(this.mJX)});
        if (!this.pwX.isPlaying()) {
            this.pxd = true;
        }
        this.pwX.al(this.pxg, this.pxd);
        if (this.pxd) {
            hj(true);
        } else {
            hj(false);
        }
        this.mJX = true;
        if (this.pxd) {
            z = false;
        }
        this.pxd = z;
    }

    public final boolean tD() {
        return !this.pxd;
    }

    private void hh(boolean z) {
        if (this.pwX != null) {
            this.pwX.hh(z);
        }
    }

    public final void hi(boolean z) {
        if (!this.pxf) {
            this.pxf = true;
            bg.cX(this);
            this.mJX = false;
            this.pxd = true;
            w.d("MicroMsg.MainSightContainerView", "dismiss sight view");
            this.pxl = false;
            this.pwX.bcZ();
            if (this.pwY != null && z) {
                this.pwY.bcO();
            }
            if (this.pwW != null) {
                View view = this.pwW;
                view.pxf = true;
                bg.cX(view);
                view.pxK.bcS();
                view.pxU.clear();
                view.pxT.clear();
                view.Fg.setAdapter(null);
                view.Fg.clearAnimation();
                view.setVisibility(8);
            }
            aj(0.85f);
            bcN();
            hj(false);
            this.pxe = "";
            amk();
        }
    }

    public final void hj(boolean z) {
        if (this.pxj != z) {
            this.pxj = z;
            if (!z) {
                this.pxa.setVisibility(8);
                this.ntw.setVisibility(8);
            } else if (this.pxa.getVisibility() != 0) {
                this.pwX.postDelayed(new Runnable(this) {
                    final /* synthetic */ MainSightForwardContainerView pxp;

                    {
                        this.pxp = r1;
                    }

                    public final void run() {
                        if (!this.pxp.pxj || (this.pxp.pwW != null && this.pxp.pwW.pxK.bcQ())) {
                            this.pxp.pxj = false;
                            return;
                        }
                        this.pxp.pxa.setVisibility(0);
                        if (this.pxp.pwW != null && !this.pxp.pwW.bcY() && this.pxp.ntw.getVisibility() != 0) {
                            this.pxp.ntw.setVisibility(0);
                            this.pxp.ntw.startAnimation(AnimationUtils.loadAnimation(this.pxp.pxk, R.a.aQX));
                        }
                    }
                }, 100);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = i - 1;
        if (MainSightSelectContactView.sK(i2) && this.mJX) {
            bcM();
        } else if (c.Ev(this.pwW.fE(i2))) {
            this.pwW.pxK.bcR();
        } else if (!c.Eu(this.pwW.fE(i2))) {
            w.d("MicroMsg.MainSightContainerView", "on item click Item : %d", new Object[]{Integer.valueOf(i2)});
            MainSightSelectContactView mainSightSelectContactView = this.pwW;
            if (i2 >= 0 && i2 <= mainSightSelectContactView.pxM.getCount()) {
                com.tencent.mm.ui.contact.a.a BL = mainSightSelectContactView.pxM.BL(i2);
                if (BL != null) {
                    if (mainSightSelectContactView.pxU.contains(BL.jiL.field_username)) {
                        mainSightSelectContactView.pxU.remove(BL.jiL.field_username);
                    } else {
                        mainSightSelectContactView.pxU.add(BL.jiL.field_username);
                    }
                    c.pxu = mainSightSelectContactView.pxU.isEmpty();
                    c.pxv = !mainSightSelectContactView.pxU.isEmpty();
                }
            }
            mainSightSelectContactView = this.pwW;
            if (mainSightSelectContactView.pxM != null) {
                mainSightSelectContactView.pxM.notifyDataSetChanged();
            }
            if (!tD()) {
                bcM();
            } else if (this.pwW.bcY()) {
                if (this.ntw.getVisibility() == 0) {
                    this.ntw.setVisibility(8);
                    this.ntw.startAnimation(AnimationUtils.loadAnimation(this.pxk, R.a.aQY));
                }
            } else if (this.ntw.getVisibility() != 0) {
                this.ntw.setVisibility(0);
                this.ntw.startAnimation(AnimationUtils.loadAnimation(this.pxk, R.a.aQX));
            }
            if (this.pwW.pxK.bcQ()) {
                mainSightSelectContactView = this.pwW;
                boolean contains = mainSightSelectContactView.pxM.BL(i2) == null ? false : mainSightSelectContactView.pxM.BL(i2).jiL == null ? false : mainSightSelectContactView.pxU.contains(mainSightSelectContactView.pxM.BL(i2).jiL.field_username);
                if (contains) {
                    this.pwW.pxK.bcR();
                }
            }
        } else if (c.pxu) {
            this.pxl = true;
            this.pwX.bcZ();
            Context context = this.pxk;
            String Eo = d.Eo(this.pxg);
            String str = this.pxg;
            String str2 = this.pxe;
            w.i("MicroMsg.SightRecorderHelper", "share video path %s, thumb path %s", new Object[]{str, Eo});
            if (!e.aO(Eo)) {
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.J(str, 320, 240), 60, CompressFormat.JPEG, Eo, true);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    w.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            Intent intent = new Intent();
            intent.putExtra("KSightPath", str);
            intent.putExtra("KSightThumbPath", Eo);
            intent.putExtra("sight_md5", str2);
            intent.putExtra("KSightDraftEntrance", false);
            intent.putExtra("Ksnsupload_source", 0);
            intent.putExtra("KSnsPostManu", true);
            intent.putExtra("KTouchCameraTime", bg.Ny());
            com.tencent.mm.bb.d.b(context, "sns", ".ui.SightUploadUI", intent, 5985);
            if (this.pxn) {
                g.oUh.i(11442, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
            } else {
                g.oUh.i(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void aAh() {
        String str = "MicroMsg.MainSightContainerView";
        String str2 = "do send to friend, loadingDialog null %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.pxc == null);
        w.i(str, str2, objArr);
        if (!bg.mA(this.pxg) && !this.pwW.bcY()) {
            String str3;
            boolean z;
            final List<String> bcX = this.pwW.bcX();
            g.oUh.i(11443, new Object[]{Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(bcX.size())});
            b.a anonymousClass6 = new b.a(this) {
                final /* synthetic */ MainSightForwardContainerView pxp;

                public final void onError(int i) {
                    if (bcX.size() <= 1 || -1 == i) {
                        com.tencent.mm.ui.base.g.bl(this.pxp.getContext(), this.pxp.getContext().getString(R.l.eRk));
                    }
                }
            };
            if (bcX.size() == 1) {
                b bVar = this.pxi;
                String str4 = this.pxg;
                int i = this.ls;
                str3 = this.pxe;
                str2 = (String) bcX.get(0);
                if (bg.mA(str4)) {
                    w.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(anonymousClass6, -1);
                } else if (bg.mA(str2)) {
                    w.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser null");
                    b.a(anonymousClass6, -1);
                } else if (!e.aO(str4) || e.aN(str4) <= 0) {
                    w.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    com.tencent.mm.ui.base.g.bl(ab.getContext(), ab.getContext().getString(h.rar));
                } else {
                    w.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[]{str3, com.tencent.mm.a.g.aV(str4)});
                    if (bg.ap(str3, "").equals(com.tencent.mm.a.g.aV(str4))) {
                        com.tencent.mm.kernel.h.vJ();
                        if (com.tencent.mm.kernel.h.vL().D(new com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass3(bVar, str2, anonymousClass6, str4, i)) < 0) {
                            w.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(anonymousClass6, -1);
                        }
                    } else {
                        w.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(anonymousClass6, -1);
                    }
                }
            } else {
                b bVar2 = this.pxi;
                String str5 = this.pxg;
                int i2 = this.ls;
                String str6 = this.pxe;
                if (bg.mA(str5)) {
                    w.w("MicroMsg.SightRecorderHelper", "remux and send sight error: in path is null");
                    b.a(anonymousClass6, -1);
                } else if (bcX.isEmpty()) {
                    w.w("MicroMsg.SightRecorderHelper", "remux and send sight error: toUser list empty");
                    b.a(anonymousClass6, -1);
                } else if (!e.aO(str5) || e.aN(str5) <= 0) {
                    w.w("MicroMsg.SightRecorderHelper", "file not exist or file size error");
                    com.tencent.mm.ui.base.g.bl(ab.getContext(), ab.getContext().getString(h.rar));
                } else {
                    w.i("MicroMsg.SightRecorderHelper", "do share to friends, check md5 target[%s] current[%s]", new Object[]{str6, com.tencent.mm.a.g.aV(str5)});
                    if (bg.ap(str6, "").equals(com.tencent.mm.a.g.aV(str5))) {
                        com.tencent.mm.kernel.h.vJ();
                        if (com.tencent.mm.kernel.h.vL().D(new com.tencent.mm.plugin.sight.encode.a.b.AnonymousClass4(bVar2, str5, bcX, str6, anonymousClass6, i2)) < 0) {
                            w.e("MicroMsg.SightRecorderHelper", "post short video encoder error");
                            b.a(anonymousClass6, -1);
                        }
                    } else {
                        w.e("MicroMsg.SightRecorderHelper", "error md5, return");
                        b.a(anonymousClass6, -1);
                    }
                }
            }
            if (this.pwW.bcX().size() > 1 || this.pwY == null) {
                z = true;
            } else {
                this.pwY.Et((String) this.pwW.bcX().get(0));
                z = false;
            }
            if (this.pxk != null) {
                try {
                    AssetFileDescriptor openFd = this.pxk.getAssets().openFd("sight_send_song.wav");
                    this.pxo = new i();
                    this.pxo.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                    openFd.close();
                    this.pxo.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ MainSightForwardContainerView pxp;

                        {
                            this.pxp = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            if (mediaPlayer != null) {
                                mediaPlayer.release();
                            }
                        }
                    });
                    this.pxo.setLooping(false);
                    this.pxo.prepare();
                    this.pxo.start();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MainSightContainerView", e, "", new Object[0]);
                }
            }
            hi(z);
            for (String str32 : bcX) {
                if (str32.toLowerCase().endsWith("@chatroom")) {
                    g.oUh.i(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                } else {
                    g.oUh.i(11442, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                }
            }
        }
    }

    public final void onPause() {
        if (!this.pxl) {
            this.pwX.setVisibility(0);
            hj(false);
            this.pwX.bcZ();
            this.fAG = true;
        }
    }

    public final void onResume() {
        if (!this.pxf) {
            a.urY.c(this.pxm);
            a.urY.b(this.pxm);
        } else {
            amk();
        }
        if (this.fAG) {
            bcM();
            this.fAG = false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.pxf && this.pwW != null) {
            w.d("MicroMsg.MainSightContainerView", "change size l: %d, t: %d, r: %d, b: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            this.pwW.bcV();
        }
    }

    @TargetApi(11)
    public final void aj(float f) {
        float min = Math.min(1.0f, Math.max(0.0f, f));
        if (com.tencent.mm.compatible.util.d.eo(11)) {
            this.pwZ.setAlpha(min);
        } else {
            Animation alphaAnimation = new AlphaAnimation(min, min);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            this.pwZ.startAnimation(alphaAnimation);
        }
        w.d("MicroMsg.MainSightContainerView", "set alpha: %f", new Object[]{Float.valueOf(min)});
        if (min <= 0.0f) {
            this.pwZ.setVisibility(8);
            Animation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(500);
            this.pwZ.startAnimation(alphaAnimation2);
            return;
        }
        this.pwZ.setVisibility(0);
    }

    public final void bcN() {
        this.pxb.setVisibility(8);
    }

    public final void hg(boolean z) {
        if (z) {
            this.pxb.setVisibility(0);
            hh(true);
            return;
        }
        bcN();
        hh(tD());
    }

    public final void bcK() {
        this.pwX.setVisibility(0);
        hj(true);
    }

    public final void bcL() {
        this.pwX.setVisibility(4);
        hj(false);
    }

    public final int bcJ() {
        int height = getHeight();
        if (height <= 0) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return height;
    }
}
