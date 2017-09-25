package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.p;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectPrepareUI extends MMFragmentActivity implements android.support.v4.app.a.a, e {
    private String gLD;
    private boolean htv = false;
    private d luA = null;
    private int luz;
    private long lvO;
    private com.tencent.mm.plugin.facedetect.c.a lzj = null;
    private a lzk = null;
    private b lzl = null;
    private boolean lzm;
    private byte[] lzn;
    private boolean lzo = false;
    private boolean lzp = false;
    private b lzq;
    private boolean lzr = false;
    private boolean lzs = false;
    private long lzt = -1;
    private Messenger lzu = null;
    private a lzv = null;
    private int lzw = -1;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.facedetect.ui.a.b lyM;
        final /* synthetic */ FaceDetectPrepareUI lzx;
        final /* synthetic */ boolean lzy = true;

        AnonymousClass3(FaceDetectPrepareUI faceDetectPrepareUI, boolean z, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
            this.lzx = faceDetectPrepareUI;
            this.lyM = bVar;
        }

        public final void run() {
            this.lzx.a(true, this.lzy, this.lyM);
        }
    }

    private static class a extends Handler {
        private WeakReference<FaceDetectPrepareUI> lyI;

        private a(FaceDetectPrepareUI faceDetectPrepareUI) {
            this.lyI = null;
            this.lyI = new WeakReference(faceDetectPrepareUI);
        }

        public final void handleMessage(Message message) {
            w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", new Object[]{Integer.valueOf(message.what)});
            if (this.lyI != null && this.lyI.get() != null) {
                switch (message.what) {
                    case 0:
                        FaceDetectPrepareUI.a((FaceDetectPrepareUI) this.lyI.get(), message);
                        return;
                    case 1:
                        FaceDetectPrepareUI.b((FaceDetectPrepareUI) this.lyI.get(), message);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private class b {
        int errCode;
        int errType;
        String fPf;
        final /* synthetic */ FaceDetectPrepareUI lzx;

        public b(FaceDetectPrepareUI faceDetectPrepareUI) {
            this.lzx = faceDetectPrepareUI;
        }
    }

    private interface c {
        void j(int i, int i2, String str);
    }

    static /* synthetic */ void a(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onInitDone result: %d", new Object[]{Integer.valueOf(message.arg1)});
        if (message.arg1 != 0) {
            faceDetectPrepareUI.asq();
            return;
        }
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo start FaceDetectUI");
        faceDetectPrepareUI.lzw = 2;
        Intent intent = new Intent(faceDetectPrepareUI, FaceDetectUI.class);
        intent.putExtra("k_user_name", faceDetectPrepareUI.gLD);
        intent.putExtra("k_server_scene", faceDetectPrepareUI.luz);
        intent.putExtra("k_need_signature", faceDetectPrepareUI.lzm);
        intent.putExtra("k_bio_id", faceDetectPrepareUI.lvO);
        intent.putExtra("k_bio_config", faceDetectPrepareUI.lzn);
        w.v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", new Object[]{Long.valueOf(FaceDetectReporter.arN().lwh)});
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.arN());
        intent.putExtra("key_reporter_bundle", bundle);
        if (faceDetectPrepareUI.lzk != null) {
            a aVar = faceDetectPrepareUI.lzk;
            if (a.lyJ != null) {
                a.lyJ.cancel();
            }
            aVar.lyE.setVisibility(4);
            aVar.lyA.setVisibility(4);
            aVar.lyF.setVisibility(4);
            aVar.lyD.setVisibility(4);
            aVar.lyC.setVisibility(4);
        }
        faceDetectPrepareUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ boolean a(FaceDetectPrepareUI faceDetectPrepareUI, long j, byte[] bArr) {
        FaceContextData.arw().lvO = j;
        Bundle bundle = new Bundle();
        bundle.putString("k_bio_id", String.valueOf(j));
        bundle.putByteArray("k_bio_config", bArr);
        bundle.putInt("k_server_scene", faceDetectPrepareUI.luz);
        bundle.putParcelable("k_ontext_data", FaceContextData.arw());
        faceDetectPrepareUI.h(0, bundle);
        return true;
    }

    static /* synthetic */ void b(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        Bundle data = message.getData();
        if (data == null) {
            faceDetectPrepareUI.asp();
        } else if (data.getInt("key_face_result_code", -1) != 0) {
            faceDetectPrepareUI.asp();
        } else {
            faceDetectPrepareUI.lzw = 3;
            final String string = data.getString("key_face_result_file_path");
            if (string != null) {
                com.tencent.mm.sdk.f.e.post(new Runnable(faceDetectPrepareUI) {
                    final /* synthetic */ FaceDetectPrepareUI lzx;

                    public final void run() {
                        try {
                            this.lzx.lzj.vG(string);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
                        }
                    }
                }, "face_upload");
            }
        }
    }

    static /* synthetic */ int mp(int i) {
        if (i == 1 || i == 2) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        return i != 0 ? 4 : i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.lty);
        getWindow().addFlags(2097280);
        this.gLD = getIntent().getStringExtra("k_user_name");
        this.luz = getIntent().getIntExtra("k_server_scene", -1);
        this.lzm = getIntent().getBooleanExtra("k_need_signature", false);
        boolean z = com.tencent.mm.plugin.facedetect.model.e.ary() || getIntent().getBooleanExtra("key_is_need_video", false);
        this.lzr = z;
        this.lzv = new a();
        this.lzu = new Messenger(this.lzv);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("k_messenger", this.lzu);
        startService(intent);
        FaceContextData.a(new FaceContextData());
        o.w(this);
        int i = com.tencent.mm.plugin.facedetect.c.b.lvt;
        this.lzj = com.tencent.mm.plugin.facedetect.c.b.a(this, this, this.luz, getIntent().getExtras());
        if (this.lzj == null) {
            asq();
        } else {
            this.lzj.a(new com.tencent.mm.plugin.facedetect.b.c(this) {
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r1;
                }

                public final void e(long j, byte[] bArr) {
                    w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", new Object[]{Long.valueOf(j), Boolean.valueOf(this.lzx.htv)});
                    if (!this.lzx.htv) {
                        this.lzx.lvO = j;
                        this.lzx.lzn = bArr;
                        FaceDetectPrepareUI.a(this.lzx, j, bArr);
                    }
                }

                public final void N(int i, String str) {
                    w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(90015), str});
                    this.lzx.b(FaceDetectPrepareUI.mp(i), 90015, str, this.lzx.getString(h.ltN));
                }
            });
            this.luA = new d(this) {
                private double lzB = 0.0d;
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r3;
                }

                public final void f(double d) {
                    w.i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", new Object[]{Double.valueOf(d)});
                    this.lzB = 100.0d * d;
                }

                public final void a(int i, int i2, int i3, String str) {
                    w.i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
                    this.lzx.b(i2, i3, str, this.lzx.getString(h.lup));
                }

                public final void a(int i, int i2, String str, Bundle bundle) {
                    w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
                    int mp = FaceDetectPrepareUI.mp(0);
                    if (mp != 0) {
                        this.lzx.i(mp, 0, str);
                    }
                    if (this.lzx.lzj != null) {
                        this.lzx.lzj.c(mp, 0, str, bundle);
                    }
                }

                public final void g(int i, int i2, String str, k kVar) {
                    w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
                    int mp = FaceDetectPrepareUI.mp(i);
                    if (!(mp == 0 && i2 == 0)) {
                        this.lzx.i(mp, i2, str);
                    }
                    if (this.lzx.lzj != null) {
                        this.lzx.lzj.g(mp, i2, str, kVar);
                    }
                }
            };
            this.lzj.a(this.luA);
        }
        if (this.luz == 2 || this.luz == 5) {
            if (com.tencent.mm.kernel.h.vI().vr().c(com.tencent.mm.storage.w.a.uGg, false)) {
                z = false;
            }
            z = true;
        } else {
            if (this.luz != 3 && this.luz == 4) {
                z = false;
            }
            z = true;
        }
        if (z) {
            w.i("MicroMsg.FaceDetectPrepareUI", "hy: need tutorial. show tutorial first");
            this.lzl = new b();
            this.lzw = 0;
            b bVar = this.lzl;
            if (this == null) {
                throw new InvalidParameterException("hy: tutorial context is null");
            }
            bVar.kHP = findViewById(com.tencent.mm.plugin.facedetect.a.e.lth);
            bVar.lyE = (Button) bVar.kHP.findViewById(com.tencent.mm.plugin.facedetect.a.e.caZ);
            bVar.xF = (ViewPager) bVar.kHP.findViewById(com.tencent.mm.plugin.facedetect.a.e.cqE);
            bVar.lAo = new b(bVar, aR());
            bVar.xF.a(bVar.lAo);
            bVar.lyE.setOnClickListener(new OnClickListener(bVar) {
                final /* synthetic */ b lAq;

                {
                    this.lAq = r1;
                }

                public final void onClick(View view) {
                    if (this.lAq.lAp != null) {
                        this.lAq.lAp.onCancel();
                    }
                    this.lAq.dismiss();
                }
            });
            ViewPager viewPager = bVar.xF;
            com.tencent.mm.plugin.facedetect.ui.b.AnonymousClass2 anonymousClass2 = new ViewPager.e(bVar) {
                final /* synthetic */ b lAq;

                {
                    this.lAq = r1;
                }

                public final void a(int i, float f, int i2) {
                }

                public final void V(int i) {
                    if (this.lAq.xF.getParent() != null) {
                        this.lAq.xF.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                public final void W(int i) {
                }
            };
            if (viewPager.za == null) {
                viewPager.za = new ArrayList();
            }
            viewPager.za.add(anonymousClass2);
            this.lzl.lAp = new a(this) {
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r1;
                }

                public final void onCancel() {
                    w.i("MicroMsg.FaceDetectPrepareUI", "hy: user cancel in tutorial");
                    this.lzx.Q(90002, "user cancel in tutorial");
                }

                public final void ast() {
                    w.i("MicroMsg.FaceDetectPrepareUI", "hy: tutorial confirmed. start");
                    this.lzx.aso();
                }
            };
            com.tencent.mm.kernel.h.vG();
            if (com.tencent.mm.kernel.a.uU()) {
                com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.uGg, Boolean.valueOf(true));
            }
            this.lzl.kHP.setVisibility(0);
            return;
        }
        View findViewById = findViewById(com.tencent.mm.plugin.facedetect.a.e.lth);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        aso();
    }

    private void aso() {
        this.lzw = 1;
        this.lzk = new a(this);
        a aVar = this.lzk;
        synchronized (((FaceDetectPrepareUI) aVar.lyI.get())) {
            if (aVar.lyI.get() != null) {
                aVar.lyz = (RelativeLayout) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.ltm);
                aVar.lyA = (Button) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.cnY);
                aVar.lyB = (ImageView) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.ltp);
                aVar.lyC = (TextView) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.cIS);
                aVar.lyG = AnimationUtils.loadAnimation((Context) aVar.lyI.get(), com.tencent.mm.plugin.facedetect.a.a.aQJ);
                aVar.lyH = AnimationUtils.loadAnimation((Context) aVar.lyI.get(), com.tencent.mm.plugin.facedetect.a.a.aQK);
                aVar.lyE = (Button) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.ltl);
                aVar.lyF = (Button) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.lto);
                aVar.lyD = (TextView) ((FaceDetectPrepareUI) aVar.lyI.get()).findViewById(com.tencent.mm.plugin.facedetect.a.e.ltq);
                aVar.lyG.setDuration(500);
                aVar.lyH.setDuration(500);
            }
        }
        if (o.v(this)) {
            w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
            ass();
        } else {
            w.i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
        }
        if (this.lzr) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_is_need_video", this.lzr);
            h(4, bundle);
        }
        asr();
    }

    private void h(int i, Bundle bundle) {
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "hy: sending msg: cmd: %d, data: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bundle != null ? bundle.toString() : "null";
        w.i(str, str2, objArr);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("k_cmd", i);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtras(bundle);
        startService(intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.lzs) {
            stopService(new Intent(this, FaceDetectProcessService.class));
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
        finish();
    }

    public void finish() {
        if (this.lzk != null && this.lzk.asn()) {
            this.lzk.dismiss();
        }
        if (this.lzl != null) {
            this.lzl.dismiss();
        }
        w.v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
        if (this.lzj != null) {
            this.lzj.arr();
        }
        super.finish();
    }

    private void asp() {
        b(4, 90011, "get image failed", getString(h.ltI));
    }

    private void asq() {
        b(4, 90013, "init lib failed", getString(h.ltN));
    }

    private void b(int i, int i2, String str, String str2) {
        w.i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        i(i, i2, str);
        this.lzp = true;
        a(i, i2, str, str2, false, new c(this) {
            final /* synthetic */ FaceDetectPrepareUI lzx;

            {
                this.lzx = r1;
            }

            public final void j(int i, int i2, String str) {
                if (this.lzx.lzj != null) {
                    this.lzx.lzj.h(i, i2, str);
                }
            }
        });
    }

    public void onBackPressed() {
        if (this.lzo) {
            if (this.lzj != null) {
                this.lzj.h(this.lzq.errType, this.lzq.errCode, this.lzq.fPf);
            }
        } else if (this.lzw == 1) {
            Q(90003, "user cancel in init");
        } else if (this.lzw == 3) {
            Q(90005, "user cancel in uploading");
        } else if (this.lzw == 0) {
            Q(90002, "user cancel in tutorial");
        } else {
            Q(90050, "user cancel unknown");
        }
    }

    private void Q(int i, String str) {
        if (this.lzj != null) {
            this.lzj.O(i, str);
        }
        this.htv = true;
        finish();
    }

    private void i(int i, int i2, String str) {
        if (this.lzq == null) {
            this.lzq = new b(this);
        }
        this.lzo = true;
        b bVar = this.lzq;
        bVar.errType = i;
        bVar.errCode = i2;
        bVar.fPf = str;
    }

    private void asr() {
        w.i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", new Object[]{Boolean.valueOf(true)});
        this.lzt = bg.NA();
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ FaceDetectPrepareUI lzx;

            {
                this.lzx = r1;
            }

            public final void run() {
                final Bitmap vH = o.vH(this.lzx.gLD);
                final OnClickListener anonymousClass1 = new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass11 lzD;

                    {
                        this.lzD = r1;
                    }

                    public final void onClick(View view) {
                        this.lzD.lzx.Q(90003, "user cancel in init");
                    }
                };
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 lzD;

                    public final void run() {
                        com.tencent.mm.plugin.facedetect.ui.a.b a = a.a(this.lzD.lzx, anonymousClass1);
                        a.lyU = vH;
                        this.lzD.lzx.a(false, false, a);
                    }
                });
            }
        }, "face_prepareInit");
    }

    private void a(final int i, final int i2, final String str, String str2, boolean z, c cVar) {
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", new Object[]{str2});
        final boolean z2 = z;
        final c cVar2 = cVar;
        final int i3 = i;
        final int i4 = i2;
        final String str3 = str;
        af.v(new AnonymousClass3(this, true, a.a(com.tencent.mm.plugin.facedetect.a.d.lsu, str2, z ? getResources().getString(h.lub) : getString(h.lua), z ? getResources().getString(h.dGs) : null, new OnClickListener(this) {
            final /* synthetic */ FaceDetectPrepareUI lzx;

            public final void onClick(View view) {
                if (!z2) {
                    if (cVar2 != null) {
                        cVar2.j(i3, i4, str3);
                    }
                    this.lzx.b(i3, i4, str3, null);
                } else if (this.lzx.lzj != null) {
                    this.lzx.lzj.arp();
                }
            }
        }, new OnClickListener(this) {
            final /* synthetic */ FaceDetectPrepareUI lzx;

            public final void onClick(View view) {
                this.lzx.b(i, i2, str, null);
            }
        })));
    }

    private void ass() {
        if (this.lzj != null) {
            this.lzj.arp();
        }
    }

    public final void arp() {
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
        if (this.lzj != null) {
            String string = getIntent().getExtras().getString("k_ticket");
            if (!bg.mA(string)) {
                w.i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
                p.vF(string);
            }
        }
        if (this.lzq != null) {
            b bVar = this.lzq;
            bVar.errType = -1;
            bVar.errCode = -1;
            bVar.fPf = "";
        }
        this.lzo = false;
        asr();
        if (this.lzj != null) {
            this.lzj.aro();
        }
    }

    public final void arr() {
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (z2) {
            w.i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r1;
                }

                public final void run() {
                    final Bitmap vH = o.vH(this.lzx.gLD);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 lzA;

                        public final void run() {
                            this.lzA.lzx.lzk.r(vH);
                        }
                    });
                }
            }, "face_refresh_background");
        }
        this.lzk.a(bVar);
    }

    public final void b(int i, int i2, String str, Bundle bundle) {
        w.i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", com.tencent.mm.plugin.facedetect.model.k.mk(i2));
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        setResult(-1, intent);
        if (this.lzr) {
            this.lzs = true;
            h(5, this.lzj.art());
        }
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 90008;
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
        if (iArr != null && iArr.length > 0) {
            switch (i) {
                case 23:
                    int i3;
                    String str = "";
                    String str2 = "";
                    if (iArr.length != 1) {
                        if (iArr.length == 2) {
                            if (iArr[0] == 0 && iArr[1] == 0) {
                                i3 = 1;
                            } else {
                                if (iArr[0] != 0) {
                                    str = "camera permission not granted";
                                    str2 = getString(h.eFG);
                                } else {
                                    i2 = -1;
                                }
                                if (iArr[1] != 0) {
                                    str = "audio permission not granted";
                                    str2 = getString(h.eFJ);
                                    i2 = 90009;
                                }
                                if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                    i2 = 90010;
                                    str = "both camera and audio permission not granted";
                                    str2 = getString(h.eFG);
                                }
                                b(1, i2, str, str2);
                                i3 = 0;
                            }
                        }
                        i2 = -1;
                        b(1, i2, str, str2);
                        i3 = 0;
                    } else if (iArr[0] == 0) {
                        i3 = 1;
                    } else {
                        if (strArr[0].equals("android.permission.CAMERA")) {
                            str = "camera permission not granted";
                            str2 = getString(h.eFG);
                        } else {
                            if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                                str = "audio permission not granted";
                                str2 = getString(h.eFJ);
                                i2 = 90009;
                            }
                            i2 = -1;
                        }
                        b(1, i2, str, str2);
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        ass();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.lzw = 1;
        if (intent == null) {
            w.e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
            a(4, 90018, "system error", getString(h.ltQ), false, new c(this) {
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r1;
                }

                public final void j(int i, int i2, String str) {
                    if (this.lzx.lzj != null) {
                        this.lzx.lzj.h(i, i2, str);
                    }
                }
            });
            return;
        }
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.arN().a(faceDetectReporter);
        }
        int intExtra = intent.getIntExtra("err_type", -1);
        int intExtra2 = intent.getIntExtra("err_code", -1);
        String stringExtra = intent.getStringExtra("err_msg");
        if (this.lzj != null) {
            com.tencent.mm.plugin.facedetect.c.a aVar = this.lzj;
            intent.getExtras();
            aVar.g(intExtra, intExtra2, stringExtra);
        }
        w.i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra});
        if (intExtra == 0 && intExtra2 == 0) {
            String string = getString(h.ltP);
            com.tencent.mm.plugin.facedetect.ui.a.b a = a.a(com.tencent.mm.plugin.facedetect.a.d.lst, string, null, null, getString(h.dGs), null, new OnClickListener(this) {
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r1;
                }

                public final void onClick(View view) {
                    this.lzx.Q(90005, "user cancel in uploading");
                }
            });
            a.lyS = true;
            a.lyT = string.length() - 3;
            a(false, true, a);
            h(1, null);
        } else if (intExtra != 1) {
            String stringExtra2 = intent.getStringExtra("show_err_msg");
            if (intExtra2 == 90013) {
                stringExtra2 = getString(h.ltN);
            } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                stringExtra2 = getString(h.eFG);
            } else if (intExtra2 == 90009) {
                stringExtra2 = getString(h.eFJ);
            } else if (bg.mA(stringExtra2)) {
                stringExtra2 = getString(h.lup);
            }
            i(intExtra, intExtra2, stringExtra);
            a(intExtra, intExtra2, stringExtra, stringExtra2, intExtra2 == 90023, new c(this) {
                final /* synthetic */ FaceDetectPrepareUI lzx;

                {
                    this.lzx = r1;
                }

                public final void j(int i, int i2, String str) {
                    if (this.lzx.lzj != null) {
                        this.lzx.lzj.h(i, i2, str);
                    }
                }
            });
        } else if (intExtra2 == 90004 || intExtra2 == 90025) {
            Q(intExtra2, stringExtra);
        }
    }
}
