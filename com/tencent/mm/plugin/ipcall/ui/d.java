package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.x.b;
import com.tencent.mm.x.n;
import java.lang.ref.WeakReference;

public final class d {
    public Context context;
    private ae hgN = new ae(Looper.getMainLooper());
    ar mSs = new ar(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    public y<String, WeakReference<Bitmap>> mSt = new y(50);

    class AnonymousClass2 implements a {
        final /* synthetic */ String gTs;
        final /* synthetic */ String hqR;
        final /* synthetic */ ImageView iST;
        final /* synthetic */ d mSv;

        AnonymousClass2(d dVar, String str, ImageView imageView, String str2) {
            this.mSv = dVar;
            this.hqR = str;
            this.iST = imageView;
            this.gTs = str2;
        }

        public final boolean Bn() {
            Bitmap a = b.a(this.hqR, false, -1);
            if (a == null) {
                n.Bl();
                a = com.tencent.mm.x.d.hk(this.hqR);
            }
            this.mSv.a(this.iST, this.gTs, a);
            return true;
        }

        public final boolean Bo() {
            return false;
        }
    }

    public d(Context context) {
        this.context = context;
    }

    public final void a(String str, String str2, ImageView imageView) {
        if (!bg.mA(str) && !bg.mA(str2) && imageView != null) {
            final String cz = cz(str, str2);
            imageView.setTag(cz);
            if (!d(cz(str, str2), imageView)) {
                final String str3 = str;
                final ImageView imageView2 = imageView;
                final String str4 = str2;
                this.mSs.c(new a(this) {
                    private boolean gZZ = false;
                    final /* synthetic */ d mSv;

                    public final boolean Bn() {
                        Bitmap al = com.tencent.mm.plugin.ipcall.b.a.al(this.mSv.context, str3);
                        if (al != null) {
                            this.mSv.mSt.put(cz, new WeakReference(al));
                            this.gZZ = true;
                            this.mSv.a(imageView2, cz, al);
                        }
                        return true;
                    }

                    public final boolean Bo() {
                        if (!this.gZZ) {
                            d dVar = this.mSv;
                            String str = str3;
                            String str2 = str4;
                            dVar.mSs.c(new AnonymousClass2(dVar, str2, imageView2, d.cz(str, str2)));
                        }
                        return true;
                    }
                });
            }
        }
    }

    public final void b(final String str, final ImageView imageView) {
        if (!bg.mA(str) && imageView != null) {
            final String yG = yG(str);
            imageView.setTag(yG);
            if (!d(yG(str), imageView)) {
                this.mSs.c(new a(this) {
                    final /* synthetic */ d mSv;

                    public final boolean Bn() {
                        this.mSv.a(imageView, yG, com.tencent.mm.plugin.ipcall.b.a.al(this.mSv.context, str));
                        return true;
                    }

                    public final boolean Bo() {
                        return true;
                    }
                });
            }
        }
    }

    public final void c(final String str, final ImageView imageView) {
        if (!bg.mA(str) && imageView != null) {
            final String yF = yF(str);
            imageView.setTag(yF);
            if (!d(yF(str), imageView)) {
                this.mSs.c(new a(this) {
                    final /* synthetic */ d mSv;

                    public final boolean Bn() {
                        Bitmap a = b.a(str, false, -1);
                        if (a == null) {
                            n.Bl();
                            a = com.tencent.mm.x.d.hk(str);
                        }
                        this.mSv.a(imageView, yF, a);
                        return true;
                    }

                    public final boolean Bo() {
                        return false;
                    }
                });
            }
        }
    }

    public final void a(final ImageView imageView, final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            this.mSt.put(str, new WeakReference(bitmap));
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ d mSv;

                public final void run() {
                    if (imageView.getTag() != null && imageView.getTag().equals(str) && bitmap != null && !bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    private boolean d(String str, ImageView imageView) {
        WeakReference weakReference = (WeakReference) this.mSt.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                return true;
            }
        }
        return false;
    }

    private static String yF(String str) {
        return str + "@username";
    }

    private static String yG(String str) {
        return str + "@contactId";
    }

    public static String cz(String str, String str2) {
        return str + "@" + str2 + "@contactId@username";
    }
}
