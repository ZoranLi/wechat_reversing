package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.m;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class d extends a {
    private String appId;
    private String fQC;
    boolean kAU;
    private String lvv;
    private String lvw;

    d(Context context, e eVar, int i, Bundle bundle) {
        super(context, eVar, i);
        this.kAU = false;
        this.lvs = true;
        this.appId = bundle.getString("k_app_id", null);
        this.fQC = bundle.getString("request_verify_pre_info", null);
    }

    public final k ars() {
        return new m(arq(), this.appId, this.fQC, this.lvv, this.lvw);
    }

    public final void onStart() {
        w.i("MicroMsg.FaceDetectMpController", "alvinluo onStart and create report session");
        if (this.kAU) {
            FaceDetectReporter.arN().arO();
        }
        FaceDetectReporter.arN().F(this.lvp, this.kAU);
        FaceDetectReporter arN = FaceDetectReporter.arN();
        arN.lwI++;
        w.v("MicroMsg.FaceDetectReporter", "alvinluo addFaceDetectCount: %d", new Object[]{Integer.valueOf(arN.lwI)});
    }

    public final void onRelease() {
        if (!FaceDetectReporter.arN().lwC) {
            FaceDetectReporter.arN().a(this.lvp, this.kAU, 2, 1, 90006);
        }
    }

    public final void g(int i, int i2, String str) {
        w.v("MicroMsg.FaceDetectMpController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public final boolean d(int i, int i2, String str, Bundle bundle) {
        w.i("MicroMsg.FaceDetectMpController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            FaceDetectReporter.arN().a(this.lvp, this.kAU, 1, 2, 90012);
            a(i, i2, str, false, null);
            return true;
        } else if (bundle == null || bg.mA(bundle.getString("key_pic_cdn_id"))) {
            w.e("MicroMsg.FaceDetectMpController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.lvv = bundle.getString("key_pic_cdn_id");
            this.lvw = bundle.getString("key_cdn_aes_key");
            w.v("MicroMsg.FaceDetectMpController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[]{this.lvv, this.lvw});
            return false;
        }
    }

    public final void g(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.FaceDetectMpController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof m) {
            Bundle bundle = new Bundle();
            bundle.putString("verify_result", ((m) kVar).lvb);
            if (i == 0 && i2 == 0) {
                FaceDetectReporter.arN().a(this.lvp, this.kAU, 0, i, i2, this.lvr != null ? this.lvr.luI : 0);
                FaceDetectReporter.arN().lwJ = true;
                b mo = a.mo(com.tencent.mm.plugin.facedetect.a.d.lsH);
                mo.lyO = true;
                mo.lyV = ab.getResources().getString(h.luc);
                a(false, true, mo);
                final int i3 = i;
                final int i4 = i2;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                af.f(new Runnable(this) {
                    final /* synthetic */ d lvC;

                    public final void run() {
                        this.lvC.b(i3, i4, str2, bundle2);
                    }
                }, 1500);
                return;
            }
            int i5;
            FaceDetectReporter arN = FaceDetectReporter.arN();
            int i6 = this.lvp;
            boolean z = this.kAU;
            if (this.lvr != null) {
                i5 = this.lvr.luI;
            } else {
                i5 = 0;
            }
            arN.a(i6, z, 1, i, i2, i5);
            a(i, i2, str, ((m) kVar).lvc, bundle);
        }
    }

    public final void h(int i, int i2, String str) {
        w.i("MicroMsg.FaceDetectMpController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!FaceDetectReporter.arN().lwC) {
            FaceDetectReporter.arN().a(this.lvp, this.kAU, 3, i, i2);
        }
        b(i, i2, str, null);
    }

    public final void O(int i, String str) {
        w.i("MicroMsg.FaceDetectMpController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (!FaceDetectReporter.arN().lwC) {
            FaceDetectReporter.arN().a(this.lvp, this.kAU, 2, 1, i);
        }
        b(1, i, str, null);
    }

    public final Bundle art() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", arq());
        bundle.putString("key_app_id", this.appId);
        return bundle;
    }

    private void a(int i, int i2, String str, boolean z, Bundle bundle) {
        String string;
        Context context = ab.getContext();
        if (str == null) {
            string = context.getString(h.ltE);
        } else {
            string = str;
        }
        int i3 = com.tencent.mm.plugin.facedetect.a.d.lsu;
        String string2 = z ? context.getString(h.lub) : context.getString(h.lua);
        String string3 = z ? context.getString(h.dGs) : null;
        final boolean z2 = z;
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        AnonymousClass2 anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ d lvC;

            public final void onClick(View view) {
                if (z2) {
                    d dVar = this.lvC;
                    dVar.arp();
                    dVar.kAU = true;
                    return;
                }
                this.lvC.b(i4, i5, str2, bundle2);
            }
        };
        i4 = i;
        i5 = i2;
        str2 = str;
        bundle2 = bundle;
        a(true, false, a.a(i3, string, string2, null, string3, anonymousClass2, new OnClickListener(this) {
            final /* synthetic */ d lvC;

            public final void onClick(View view) {
                this.lvC.b(i4, i5, str2, bundle2);
            }
        }));
    }
}
