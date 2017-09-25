package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.b.e;
import com.tencent.mm.plugin.facedetect.b.n;
import com.tencent.mm.plugin.facedetect.b.o;
import com.tencent.mm.plugin.facedetect.b.s;
import com.tencent.mm.plugin.facedetect.b.t;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.ui.a;
import com.tencent.mm.plugin.facedetect.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class c extends a {
    boolean kAU;
    private String lvv;
    private String lvw;
    private int lvx;

    c(Context context, e eVar, int i) {
        super(context, eVar, i);
        this.kAU = false;
        this.lvs = true;
        this.lvx = i;
    }

    public final k ars() {
        long arq = arq();
        String str = this.lvv;
        String str2 = this.lvw;
        switch (this.lvx) {
            case 0:
                return new n(arq, str, str2);
            case 1:
                return new s(arq, str, str2);
            case 3:
                return new o(arq, str, str2);
            case 4:
                return new t(arq, str, str2);
            default:
                return null;
        }
    }

    public final void onStart() {
        w.i("MicroMsg.FaceDetectLoginController", "alvinluo onStart and create report session");
        if (this.kAU) {
            FaceDetectReporter.arN().arO();
            FaceDetectReporter.arN().F(FaceDetectReporter.mj(this.lvx), this.kAU);
        }
    }

    public final void onRelease() {
        if (!FaceDetectReporter.arN().lwC) {
            FaceDetectReporter.arN().a(FaceDetectReporter.mj(this.lvx), this.kAU, 2, 1, 90006);
        }
    }

    public final void g(int i, int i2, String str) {
        w.v("MicroMsg.FaceDetectLoginController", "alvinluo onCollectEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    public final boolean d(int i, int i2, String str, Bundle bundle) {
        w.i("MicroMsg.FaceDetectLoginController", "alvinluo onUploadEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            FaceDetectReporter.arN().a(FaceDetectReporter.mj(this.lvx), this.kAU, 1, 2, 90012);
            a(i, i2, str, false, null);
            return true;
        } else if (bundle == null || bg.mA(bundle.getString("key_pic_cdn_id"))) {
            w.e("MicroMsg.FaceDetectLoginController", "hy: not return cdn id!");
            a(4, 6, "not return cdn id", false, null);
            return true;
        } else {
            this.lvv = bundle.getString("key_pic_cdn_id");
            this.lvw = bundle.getString("key_cdn_aes_key");
            w.v("MicroMsg.FaceDetectLoginController", "hy: start upload: picCdnId: %s, aes key: %s", new Object[]{this.lvv, this.lvw});
            return false;
        }
    }

    public final void g(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.FaceDetectLoginController", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof e) {
            String str2;
            e eVar = (e) kVar;
            Bundle bundle = new Bundle();
            switch (this.lvx) {
                case 0:
                case 3:
                    str2 = "faceregister_ticket";
                    break;
                case 1:
                case 4:
                    str2 = "faceverify_ticket";
                    break;
                default:
                    str2 = "verify_result";
                    break;
            }
            bundle.putString(str2, eVar.arn());
            FaceDetectReporter arN;
            int i3;
            boolean arm;
            int i4;
            if (i == 0 && i2 == 0) {
                arN = FaceDetectReporter.arN();
                i3 = this.lvp;
                arm = eVar.arm();
                if (this.lvr != null) {
                    i4 = this.lvr.luI;
                } else {
                    i4 = 0;
                }
                arN.a(i3, arm, 0, i, i2, i4);
                b mo = a.mo(d.lsH);
                mo.lyO = true;
                mo.lyV = ab.getResources().getString(h.luc);
                a(false, true, mo);
                final int i5 = i;
                final int i6 = i2;
                final String str3 = str;
                final Bundle bundle2 = bundle;
                af.f(new Runnable(this) {
                    final /* synthetic */ c lvz;

                    public final void run() {
                        this.lvz.b(i5, i6, str3, bundle2);
                    }
                }, 1500);
                return;
            }
            arN = FaceDetectReporter.arN();
            i3 = this.lvp;
            arm = eVar.arm();
            if (this.lvr != null) {
                i4 = this.lvr.luI;
            } else {
                i4 = 0;
            }
            arN.a(i3, arm, 1, i, i2, i4);
            a(i, i2, str, eVar.arm(), bundle);
        }
    }

    public final void h(int i, int i2, String str) {
        w.i("MicroMsg.FaceDetectLoginController", "alvinluo onError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!FaceDetectReporter.arN().lwC) {
            FaceDetectReporter.arN().a(FaceDetectReporter.mj(this.lvx), this.kAU, 3, i, i2);
        }
        b(i, i2, str, null);
    }

    public final void O(int i, String str) {
        w.i("MicroMsg.FaceDetectLoginController", "alvinluo onCancel, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        if (!FaceDetectReporter.arN().lwC) {
            FaceDetectReporter.arN().a(FaceDetectReporter.mj(this.lvx), this.kAU, 2, 1, i);
        }
        b(1, i, str, null);
    }

    public final Bundle art() {
        Bundle bundle = new Bundle();
        bundle.putLong("k_bio_id", arq());
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
        int i3 = d.lsu;
        String string2 = z ? context.getString(h.lub) : context.getString(h.lua);
        String string3 = z ? context.getString(h.dGs) : null;
        final boolean z2 = z;
        final int i4 = i;
        final int i5 = i2;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        AnonymousClass2 anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ c lvz;

            public final void onClick(View view) {
                if (z2) {
                    c cVar = this.lvz;
                    cVar.arp();
                    cVar.kAU = true;
                    return;
                }
                this.lvz.b(i4, i5, str2, bundle2);
            }
        };
        i4 = i;
        i5 = i2;
        str2 = str;
        bundle2 = bundle;
        a(true, false, a.a(i3, string, string2, null, string3, anonymousClass2, new OnClickListener(this) {
            final /* synthetic */ c lvz;

            public final void onClick(View view) {
                this.lvz.b(i4, i5, str2, bundle2);
            }
        }));
    }
}
