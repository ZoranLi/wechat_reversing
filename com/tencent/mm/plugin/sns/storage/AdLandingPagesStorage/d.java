package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class d {

    public interface a {
        void FW(String str);

        void bgn();

        void bgo();
    }

    public interface b {
        void FY(String str);

        void FZ(String str);
    }

    public static String dA(String str, String str2) {
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_img_" + aa.Pq(str2);
    }

    public static String dB(String str, String str2) {
        FileOp.kl(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + aa.Pq(str2);
    }

    public static Bitmap dC(String str, String str2) {
        Bitmap bitmap = null;
        if (!(bg.mA(str2) || bg.mA(str))) {
            try {
                String dA = dA(str, str2);
                if (!TextUtils.isEmpty(dA) && new File(dA).exists()) {
                    bitmap = MMBitmapFactory.decodeFile(dA);
                }
            } catch (Throwable e) {
                w.e("AdLandingPagesDownloadResourceHelper", "%s", new Object[]{bg.g(e)});
            }
        }
        return bitmap;
    }

    public static void a(String str, int i, a aVar) {
        a("adId", str, false, i, 0, aVar);
    }

    public static void a(final String str, final String str2, boolean z, int i, int i2, final a aVar) {
        if (bg.mA(str2) || bg.mA(str)) {
            aVar.bgo();
            return;
        }
        w.i("AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        final String dA = dA(str, str2);
        new b(dA, z, i, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a() {
            public final void bgn() {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qmx;

                    {
                        this.qmx = r1;
                    }

                    public final void run() {
                        aVar.bgn();
                    }
                });
            }

            public final void bgo() {
                w.e("AdLandingPagesDownloadResourceHelper", " download error img for " + str2 + " for adid:" + str);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qmx;

                    {
                        this.qmx = r1;
                    }

                    public final void run() {
                        aVar.bgo();
                    }
                });
            }

            public final void bgV() {
                w.i("AdLandingPagesDownloadResourceHelper", " download success img for " + str2 + " for adid:" + str);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qmx;

                    {
                        this.qmx = r1;
                    }

                    public final void run() {
                        aVar.FW(dA);
                    }
                });
            }
        }).execute(new String[]{str2});
    }

    public static void a(final String str, final String str2, boolean z, int i, final a aVar) {
        FileOp.kl(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        aa.Pq(str2);
        final String dB = dB(str, str2);
        if (FileOp.aO(dB)) {
            af.v(new Runnable() {
                public final void run() {
                    aVar.FW(dB);
                }
            });
            return;
        }
        w.i("AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        new b(dB, z, i, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a() {
            public final void bgn() {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 qmy;

                    {
                        this.qmy = r1;
                    }

                    public final void run() {
                        aVar.bgn();
                    }
                });
            }

            public final void bgo() {
                w.e("AdLandingPagesDownloadResourceHelper", " download error sight for " + str2 + " for adid:" + str);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 qmy;

                    {
                        this.qmy = r1;
                    }

                    public final void run() {
                        aVar.bgo();
                    }
                });
            }

            public final void bgV() {
                w.i("AdLandingPagesDownloadResourceHelper", " download success sight for " + str2 + " for adid:" + str);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 qmy;

                    {
                        this.qmy = r1;
                    }

                    public final void run() {
                        aVar.FW(dB);
                    }
                });
            }
        }).execute(new String[]{str2});
    }

    public static void a(final String str, final String str2, boolean z, int i, final b bVar) {
        if (bg.mA(str2) || bg.mA(str)) {
            bVar.FY("the res or adId is null");
            return;
        }
        dA(str, str2);
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str4 = str + "_stream_" + aa.Pq(str2);
        w.i("AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
        new ac(str3, str4, z, i, 0, new ae(Looper.getMainLooper()), new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.a() {
            public final void bL(final String str, final int i) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qmA;

                    public final void run() {
                    }
                });
            }

            public final void FY(final String str) {
                w.e("AdLandingPagesDownloadResourceHelper", " download error video for " + str2 + " for adid:" + str);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qmA;

                    public final void run() {
                        bVar.FY(str);
                    }
                });
            }

            public final void FZ(final String str) {
                w.i("AdLandingPagesDownloadResourceHelper", " download success video for " + str2 + " for adid:" + str);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qmA;

                    public final void run() {
                        bVar.FZ(str);
                    }
                });
            }
        }).execute(new String[]{str2});
    }
}
