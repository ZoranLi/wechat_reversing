package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.am.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.d;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b extends d implements com.tencent.mm.plugin.music.a.d.a {
    int count;
    ae nSw = new ae(Looper.getMainLooper());
    public boolean nTN;
    public final int nUO = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 26);
    public final int nUP = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), GameJsApiLaunchApplication.CTRL_BYTE);
    public HashMap<Integer, View> nUQ = new HashMap();
    public com.tencent.mm.plugin.music.a.d nUR = new com.tencent.mm.plugin.music.a.d();
    public int nUS;
    public int scene;

    public class a {
        com.tencent.mm.am.a fPd;
        private int mode = 1;
        final /* synthetic */ b nUU;
        MusicItemLayout nUV;
        View nUW;
        View nUX;
        View nUY;
        CdnImageView nUZ;
        TextView nVa;
        TextView nVb;
        LyricView nVc;
        public boolean nVd;
        private AnimationListener nVe = new AnimationListener(this) {
            final /* synthetic */ a nVg;

            {
                this.nVg = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.nVg.nVd = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };

        class AnonymousClass1 extends ShaderFactory {
            final /* synthetic */ int nVf;
            final /* synthetic */ a nVg;

            AnonymousClass1(a aVar, int i) {
                this.nVg = aVar;
                this.nVf = i;
            }

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, this.nVf}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        }

        class AnonymousClass2 extends ShaderFactory {
            final /* synthetic */ a nVg;
            final /* synthetic */ int nVh;

            AnonymousClass2(a aVar, int i) {
                this.nVg = aVar;
                this.nVh = i;
            }

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{this.nVh, 0}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        }

        public class a extends Animation {
            final int lKi;
            final /* synthetic */ a nVg;
            final int nVi;
            View view;

            public a(a aVar, View view, int i) {
                this.nVg = aVar;
                this.view = view;
                this.lKi = i;
                this.nVi = view.getHeight();
            }

            protected final void applyTransformation(float f, Transformation transformation) {
                this.view.getLayoutParams().height = (int) (((float) this.nVi) + (((float) (this.lKi - this.nVi)) * f));
                this.view.requestLayout();
            }

            public final void initialize(int i, int i2, int i3, int i4) {
                super.initialize(i, i2, i3, i4);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        }

        public a(b bVar) {
            this.nUU = bVar;
        }

        public final void h(com.tencent.mm.am.a aVar, boolean z) {
            if (aVar != null) {
                w.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[]{aVar.field_songName});
                this.fPd = aVar;
                if (bg.mA(aVar.field_songHAlbumUrl)) {
                    f aNS = i.aNS();
                    boolean z2 = this.nUU.nTN;
                    if (aVar != null) {
                        if (aNS.nSY != null) {
                            ap.vd().c(aNS.nSY);
                            aNS.nSY = null;
                        }
                        if (aVar.field_songId <= 0) {
                            w.e("MicroMsg.Music.MusicPlayerManager", "can't get songId ");
                            g.oUh.A(10911, "1");
                        } else {
                            aNS.nSY = new com.tencent.mm.plugin.music.a.c.b(aVar, z2);
                            ap.vd().a(aNS.nSY, 0);
                        }
                    }
                }
                this.nUV.setTag(this);
                if ((!h.e(aVar) || this.nUU.scene == 3) && !bg.mA(aVar.field_songSinger)) {
                    this.nVb.setText(aVar.field_songSinger);
                    this.nVb.setVisibility(0);
                } else {
                    this.nVb.setVisibility(8);
                }
                this.nVa.setText(aVar.field_songName);
                this.nVa.setTag(aVar.field_songName);
                LyricView lyricView = this.nVc;
                com.tencent.mm.plugin.music.a.f.a aNT = i.aNT();
                lyricView.nUx = aNT.nUw.get(aVar.field_musicId) != null ? (com.tencent.mm.plugin.music.a.a) aNT.nUw.get(aVar.field_musicId) : aNT.g(aVar, this.nUU.nTN);
                lyricView.invalidate();
                if (!h.e(aVar) || this.nUU.nTN) {
                    this.nVc.cI(1);
                }
                aOs();
                com.tencent.mm.plugin.music.a.d dVar = this.nUU.nUR;
                View view = this.nUZ;
                Context context = this.nUU.context;
                boolean z3 = this.nUU.nTN;
                if (z) {
                    dVar.gKW.remove(aVar.field_musicId);
                }
                Bitmap bitmap = (Bitmap) dVar.gKW.get(aVar.field_musicId);
                int[] m;
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                    w.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[]{aVar.field_musicId, aVar.field_songHAlbumUrl, aVar.field_songAlbumUrl, aVar.field_songAlbumLocalPath});
                    view.setTag(aVar);
                    com.tencent.mm.ah.a.a.c.a aVar2;
                    if (aVar.HF()) {
                        aVar2 = new com.tencent.mm.ah.a.a.c.a();
                        aVar2.hIN = h.f(aVar, true);
                        aVar2.hIL = true;
                        aVar2.hIJ = true;
                        aVar2.hJa = R.g.beu;
                        if (z3) {
                            aVar2.hIV = true;
                            aVar2.hIW = 10;
                        }
                        n.GW().a(aVar.field_songHAlbumUrl, view, aVar2.Hg(), dVar.nSv);
                    } else {
                        switch (aVar.field_musicType) {
                            case 0:
                            case 5:
                            case 7:
                            case 10:
                            case 11:
                                break;
                            case 1:
                            case 8:
                            case 9:
                                alh com_tencent_mm_protocal_c_alh = new alh();
                                com_tencent_mm_protocal_c_alh.mQY = aVar.field_songMediaId;
                                com_tencent_mm_protocal_c_alh.tPi = aVar.field_songAlbumUrl;
                                com_tencent_mm_protocal_c_alh.tPj = aVar.field_songAlbumType;
                                com_tencent_mm_protocal_c_alh.msN = com_tencent_mm_protocal_c_alh.tPi;
                                if (m.pQA != null) {
                                    bitmap = m.pQA.b(com_tencent_mm_protocal_c_alh);
                                    if (bitmap == null) {
                                        view.setImageResource(R.g.beu);
                                        if (!(aVar.HE() || dVar.nSu == null)) {
                                            dVar.nSu.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                                        }
                                        m.pQA.cn(view);
                                        m.pQA.a(com_tencent_mm_protocal_c_alh, view, context.hashCode(), an.uJM);
                                        dVar.nSw.removeCallbacksAndMessages(null);
                                        dVar.nSw.postDelayed(new b(dVar, aVar), 1000);
                                        break;
                                    }
                                    bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                                    break;
                                }
                                break;
                            case 4:
                                aVar2 = new com.tencent.mm.ah.a.a.c.a();
                                aVar2.hIN = h.f(aVar, false);
                                aVar2.hIL = true;
                                aVar2.hIJ = true;
                                if (z3) {
                                    aVar2.hIV = true;
                                    aVar2.hIW = 10;
                                }
                                n.GW().a(aVar.field_songAlbumUrl, view, aVar2.Hg(), dVar.nSv);
                                break;
                            case 6:
                                bitmap = n.GS().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bg.a.getDensity(context));
                                break;
                            default:
                                break;
                        }
                        if (bitmap == null) {
                            bitmap = n.GS().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bg.a.getDensity(context), false);
                        }
                        if (bitmap != null) {
                            bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                        } else {
                            view.setImageResource(R.g.beu);
                            if (!(aVar.HE() || dVar.nSu == null)) {
                                dVar.nSu.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                            }
                            w.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[]{aVar.field_songAlbumUrl});
                            if (!TextUtils.isEmpty(aVar.field_songAlbumUrl)) {
                                aVar2 = new com.tencent.mm.ah.a.a.c.a();
                                aVar2.hIN = h.f(aVar, true);
                                aVar2.hIL = true;
                                aVar2.hIJ = true;
                                if (z3) {
                                    aVar2.hIV = true;
                                    aVar2.hIW = 10;
                                }
                                n.GW().a(aVar.field_songAlbumUrl, view, aVar2.Hg(), dVar.nSv);
                            }
                        }
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        dVar.a(aVar, bitmap);
                        view.setImageBitmap(bitmap);
                        m = c.m(bitmap);
                        if (!aVar.f(m)) {
                            aVar = i.aNT().F(aVar.field_musicId, m[0], m[1]);
                        }
                        if (dVar.nSu != null) {
                            dVar.nSu.a(aVar, m);
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[]{aVar.field_musicId});
                view.setImageBitmap(bitmap);
                m = aVar.HE() ? new int[]{aVar.field_songBgColor, aVar.field_songLyricColor} : c.m(bitmap);
                if (dVar.nSu != null) {
                    dVar.nSu.a(aVar, m);
                }
            }
        }

        public final boolean aOr() {
            return this.mode == 2;
        }

        public final void aOs() {
            if (!this.nVd && this.mode != 1) {
                com.tencent.mm.plugin.music.a.g.cv(3, this.nUU.scene);
                if (this.nUU.nUS == 0) {
                    this.nUU.nUS = this.nUW.getMeasuredHeight();
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.nUU.nUS);
                    layoutParams.weight = 0.0f;
                    this.nUW.setLayoutParams(layoutParams);
                }
                com.tencent.mm.plugin.music.a.g.nTe = true;
                com.tencent.mm.plugin.music.a.g.aNQ();
                this.mode = 1;
                this.nVd = true;
                Animation aVar = new a(this, this.nVc, this.nUU.nUO);
                aVar.setDuration(500);
                aVar.setAnimationListener(this.nVe);
                this.nVc.startAnimation(aVar);
            }
        }

        public final void aOt() {
            if (!this.nVd && this.mode != 2) {
                com.tencent.mm.plugin.music.a.g.cv(2, this.nUU.scene);
                if (this.nUU.nUS == 0) {
                    this.nUU.nUS = this.nUW.getMeasuredHeight();
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.nUU.nUS);
                    layoutParams.weight = 0.0f;
                    this.nUW.setLayoutParams(layoutParams);
                }
                com.tencent.mm.plugin.music.a.g.nTe = true;
                com.tencent.mm.plugin.music.a.g.aNQ();
                this.mode = 2;
                this.nVd = true;
                Animation aVar = new a(this, this.nVc, this.nUU.nUP);
                aVar.setDuration(500);
                aVar.setAnimationListener(this.nVe);
                this.nVc.startAnimation(aVar);
            }
        }

        public final void aOu() {
            com.tencent.mm.plugin.music.a.g.nTe = true;
            com.tencent.mm.plugin.music.a.g.aNQ();
            if (this.mode == 1) {
                aOt();
            } else {
                aOs();
            }
        }
    }

    public b(Context context, int i, boolean z) {
        super(context);
        this.scene = i;
        this.nTN = z;
    }

    public final int getCount() {
        return this.count;
    }

    public final View a(View view, ViewGroup viewGroup, int i) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.djL, viewGroup, false);
            aVar = new a(this);
            aVar.nUV = (MusicItemLayout) view.findViewById(R.h.clX);
            aVar.nVa = (TextView) view.findViewById(R.h.clY);
            aVar.nVc = (LyricView) view.findViewById(R.h.cgB);
            aVar.nUW = view.findViewById(R.h.bof);
            aVar.nUX = view.findViewById(R.h.bog);
            aVar.nUY = view.findViewById(R.h.boh);
            aVar.nUZ = (CdnImageView) view.findViewById(R.h.boe);
            aVar.nVb = (TextView) view.findViewById(R.h.cma);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List list = i.aNS().nSU;
        int size = (i - 100000) % list.size();
        if (size < 0) {
            size += list.size();
        }
        w.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.am.a BE = i.aNT().BE((String) list.get(size));
        this.nUQ.put(Integer.valueOf(i), view);
        aVar.h(BE, false);
        return view;
    }

    public final void qn(int i) {
        this.nUQ.remove(Integer.valueOf(i));
    }

    public final int aOq() {
        return i.aNS().nSU.size();
    }

    public final void z(final int i, final long j) {
        af.v(new Runnable(this) {
            final /* synthetic */ b nUU;

            public final void run() {
                View view = (View) this.nUU.nUQ.get(Integer.valueOf(i));
                if (view != null) {
                    ((a) view.getTag()).nVc.cI(j);
                }
            }
        });
    }

    public final void a(com.tencent.mm.am.a aVar, int[] iArr) {
        for (Entry value : this.nUQ.entrySet()) {
            a aVar2 = (a) ((View) value.getValue()).getTag();
            if (aVar2.fPd.field_musicId.equals(aVar.field_musicId)) {
                w.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[]{aVar2.fPd.field_songName});
                int i = iArr[0];
                int i2 = iArr[1];
                aVar2.nUV.setBackgroundColor(i);
                LyricView lyricView = aVar2.nVc;
                lyricView.nUy.setColor(i2);
                lyricView.nUy.setAlpha(255);
                lyricView.nUz.setColor(i2);
                lyricView.nUz.setAlpha(127);
                aVar2.nUZ.setBackgroundColor(i);
                ShaderFactory anonymousClass1 = new AnonymousClass1(aVar2, i);
                Drawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(anonymousClass1);
                aVar2.nUX.setBackgroundDrawable(paintDrawable);
                anonymousClass1 = new AnonymousClass2(aVar2, (i & 16777215) | 1426063360);
                Drawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(anonymousClass1);
                aVar2.nUY.setBackgroundDrawable(paintDrawable2);
                aVar2.nVa.setTextColor(i2);
                aVar2.nVb.setTextColor(i2);
                ((MusicMainUI) this.context).h(aVar);
            }
        }
    }
}
