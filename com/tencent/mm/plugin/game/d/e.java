package com.tencent.mm.plugin.game.d;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.lang.ref.WeakReference;

public class e {
    private static final String mGo = (com.tencent.mm.loader.stub.a.hgu + "Game/Image/");
    private static e mGp;
    public f<String, Bitmap> mCP = new f(15);
    private ColorDrawable mGq = new ColorDrawable(android.support.v4.content.a.b(ab.getContext(), R.e.aTT));
    private Bitmap mGr;
    private Bitmap mGs;
    public f<String, Bitmap> mwv = new f(6);

    public static class a {
        public final boolean hIJ;
        public final boolean hIL;
        final boolean hJi;
        final boolean mGA;
        public final boolean mGB;
        final int mGC;
        final boolean mGz;

        public static class a {
            public boolean hIJ = true;
            public boolean hIL = true;
            public boolean hJi = false;
            public boolean mGA = true;
            public boolean mGB = false;
            public int mGC = 0;
            public boolean mGz = false;

            public final a aCj() {
                return new a(this);
            }
        }

        public a(a aVar) {
            this.hIJ = aVar.hIJ;
            this.hIL = aVar.hIL;
            this.hJi = aVar.hJi;
            this.mGz = aVar.mGz;
            this.mGA = aVar.mGA;
            this.mGB = aVar.mGB;
            this.mGC = aVar.mGC;
        }
    }

    public static abstract class b {
        public abstract void s(Bitmap bitmap);
    }

    public static e aCi() {
        if (mGp == null) {
            synchronized (e.class) {
                if (mGp == null) {
                    mGp = new e();
                }
            }
        }
        return mGp;
    }

    private e() {
        try {
            this.mGr = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
            if (!(this.mGr == null || this.mGr.isRecycled())) {
                this.mGs = d.a(this.mGr, false, 0.5f * ((float) this.mGr.getWidth()));
            }
        } catch (Exception e) {
            w.i("MicroMsg.GameImageUtil", e.getMessage());
        }
        an.aRr().c(new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ e mGt;

            {
                this.mGt = r1;
            }

            public final void a(String str, l lVar) {
                if (this.mGt.mwv.aV(str)) {
                    this.mGt.mwv.k(str, g.b(str, 1, com.tencent.mm.bg.a.getDensity(null)));
                }
            }
        });
    }

    public final void f(ImageView imageView, String str) {
        a(imageView, str, null, null);
    }

    public final void a(ImageView imageView, String str, a aVar) {
        a(imageView, str, aVar, null);
    }

    public final void a(final ImageView imageView, String str, a aVar, final b bVar) {
        if (!bg.mA(str)) {
            int i;
            boolean z;
            if (aVar == null) {
                aVar = new a().aCj();
            }
            if (!aVar.hIJ || aVar.mGB) {
                i = false;
            } else {
                if (this.mCP.aV(str)) {
                    Bitmap bitmap = (Bitmap) this.mCP.get(str);
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        if (imageView != null) {
                            imageView.setImageBitmap(bitmap);
                        }
                        if (bVar != null) {
                            bVar.s(bitmap);
                        }
                        i = 1;
                    }
                }
                z = false;
            }
            if (i == 0) {
                com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
                if (aVar.mGB) {
                    z = false;
                } else {
                    z = true;
                }
                aVar2.hIJ = z;
                File file = new File(mGo);
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        File parentFile = file.getParentFile();
                        File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                        if (file2.mkdir()) {
                            file2.renameTo(parentFile);
                        } else {
                            w.e("MicroMsg.GameImageUtil", "mkdir error, %s", new Object[]{parentFile.getAbsolutePath()});
                        }
                    }
                    if (!(file.mkdir() && file.isDirectory())) {
                        w.e("MicroMsg.GameImageUtil", "mkdir error. %s", new Object[]{r0});
                    }
                }
                String str2 = mGo + com.tencent.mm.a.g.n(str.getBytes());
                aVar2.hIL = aVar.hIL;
                if (aVar.mGB) {
                    aVar2.hIL = false;
                    com.tencent.mm.pluginsdk.k.a.e.a.My(str2);
                } else {
                    aVar2.hIN = str2;
                }
                aVar2.hJi = aVar.hJi;
                aVar2.hJh = false;
                if (imageView != null && aVar.mGA) {
                    if (aVar.mGC == 0) {
                        imageView.setImageDrawable(this.mGq);
                    } else {
                        imageView.setImageResource(aVar.mGC);
                    }
                }
                n.GW().a(str, null, aVar2.Hg(), new com.tencent.mm.ah.a.c.g(this) {
                    final /* synthetic */ e mGt;

                    public final void jK(String str) {
                    }

                    public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                        if (bVar != null && bVar.bitmap != null) {
                            Bitmap bitmap = bVar.bitmap;
                            if (aVar.mGz) {
                                bitmap = e.t(bitmap);
                            }
                            if (aVar.hIJ) {
                                this.mGt.mCP.k(str, bitmap);
                            }
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 mGx;

                                public final void run() {
                                    if (imageView != null) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                }
                            });
                            if (bVar != null) {
                                bVar.s(bitmap);
                            }
                        }
                    }
                });
            }
        }
    }

    public static Bitmap t(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        return d.a(bitmap, width, width, false);
    }

    public final Bitmap g(ImageView imageView, String str) {
        Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            if (this.mGr == null || this.mGr.isRecycled()) {
                try {
                    this.mGr = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
                } catch (Exception e) {
                }
            }
            if (!(this.mGr == null || this.mGr.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.mGr);
            }
            return this.mGr;
        } else if (imageView == null) {
            return a;
        } else {
            imageView.setImageBitmap(a);
            return a;
        }
    }

    public final Bitmap h(ImageView imageView, String str) {
        Bitmap a = com.tencent.mm.x.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            a = this.mGs;
        } else {
            a = d.a(a, false, 0.5f * ((float) a.getWidth()));
        }
        if (!(a == null || a.isRecycled() || imageView == null)) {
            imageView.setImageBitmap(a);
        }
        return a;
    }

    public final void a(ImageView imageView, final String str, final float f) {
        if (imageView != null && !bg.mA(str)) {
            Bitmap bitmap;
            if (this.mwv.aV(str)) {
                bitmap = (Bitmap) this.mwv.get(str);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                    return;
                }
            }
            bitmap = g.b(str, 1, f);
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setImageResource(R.g.bfs);
                final WeakReference weakReference = new WeakReference(imageView);
                an.aRr().c(new com.tencent.mm.sdk.e.j.a(this) {
                    final /* synthetic */ e mGt;

                    public final void a(String str, l lVar) {
                        if (str.equals(str)) {
                            Bitmap b = g.b(str, 1, f);
                            if (b != null) {
                                if (!(weakReference == null || weakReference.get() == null)) {
                                    ((ImageView) weakReference.get()).setImageBitmap(b);
                                }
                                this.mGt.mwv.put(str, b);
                                an.aRr().f(this);
                            }
                        }
                    }
                });
                return;
            }
            imageView.setImageBitmap(bitmap);
            this.mwv.put(str, bitmap);
        }
    }
}
