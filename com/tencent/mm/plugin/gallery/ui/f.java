package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class f extends android.support.v7.widget.RecyclerView.a<a> implements OnClickListener {
    public Context mContext;
    private boolean mgJ;
    c mhV;
    private int mhW;
    public ArrayList<String> mhX = new ArrayList();
    public b mhY;
    public int mhZ = -1;
    private ArrayList<String> mhr;
    public int mia = -1;
    private int mib;
    public int mic;
    private Drawable mid;
    android.support.v7.widget.a.a mie = new android.support.v7.widget.a.a(new android.support.v7.widget.a.a.a(this) {
        int fXS = -1;
        final /* synthetic */ f mif;

        {
            this.mif = r2;
        }

        public final boolean a(t tVar, t tVar2) {
            int gf = tVar.gf();
            int gf2 = tVar2.gf();
            this.mif.Q(gf, gf2);
            if (this.mif.mhY != null) {
                this.mif.mhY.cd(gf, gf2);
            }
            this.mif.mia = gf2;
            return false;
        }

        public final void e(final t tVar, final int i) {
            super.e(tVar, i);
            if (tVar != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mif.mContext, R.a.aRi);
                loadAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass1 mii;

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (i == 2) {
                            f fVar = this.mii.mif;
                            f fVar2 = this.mii.mif;
                            int gf = tVar.gf();
                            fVar2.mia = gf;
                            fVar.mhZ = gf;
                            this.mii.fXS = this.mii.mif.mic;
                            w.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[]{Integer.valueOf(this.mii.fXS)});
                        }
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) tVar).mil.startAnimation(loadAnimation);
            }
        }

        public final void c(RecyclerView recyclerView, t tVar) {
            super.c(recyclerView, tVar);
            if (tVar != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.mif.mContext, R.a.aRh);
                loadAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass1 mii;

                    {
                        this.mii = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        com.tencent.mm.plugin.gallery.a.a.swap(this.mii.mif.mhX, this.mii.mif.mhZ, this.mii.mif.mia);
                        if (this.mii.mif.mhY == null) {
                            return;
                        }
                        if (this.mii.fXS > this.mii.mif.mhZ && this.mii.fXS <= this.mii.mif.mia) {
                            this.mii.mif.mhY.B(this.mii.mif.mhZ, this.mii.mif.mia, this.mii.fXS - 1);
                        } else if (this.mii.fXS < this.mii.mif.mhZ && this.mii.fXS >= this.mii.mif.mia) {
                            this.mii.mif.mhY.B(this.mii.mif.mhZ, this.mii.mif.mia, this.mii.fXS + 1);
                        } else if (this.mii.mif.mhZ == this.mii.fXS) {
                            this.mii.mif.mhY.B(this.mii.mif.mhZ, this.mii.mif.mia, this.mii.mif.mia);
                        } else {
                            this.mii.mif.mhY.B(this.mii.mif.mhZ, this.mii.mif.mia, this.mii.fXS);
                        }
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                ((a) tVar).mil.startAnimation(loadAnimation);
            }
        }

        public final void ho() {
        }

        public final float hn() {
            return 0.295858f;
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, t tVar, float f, float f2, int i, boolean z) {
            super.a(canvas, recyclerView, tVar, f / 1.3f, f2 / 1.3f, i, z);
        }

        public final int hh() {
            return 3342387;
        }

        public final boolean hj() {
            return true;
        }

        public final boolean hk() {
            return false;
        }
    });

    public static class a extends t {
        public RelativeLayout mfA;
        public TextView mfB;
        public ImageView mfF;
        public ImageView mfG;
        public ImageView mfH;
        public ImageView mfy;
        public ImageView mfz;
        public ImageView mik;
        public View mil;
        public int mim;

        public a(View view) {
            super(view);
            this.mil = view;
            this.mfG = (ImageView) view.findViewById(R.h.bVn);
            this.mfH = (ImageView) view.findViewById(R.h.bKL);
            this.mik = (ImageView) view.findViewById(R.h.bMt);
            this.mfy = (ImageView) view.findViewById(R.h.cjw);
            this.mfz = (ImageView) view.findViewById(R.h.cjz);
            this.mfA = (RelativeLayout) view.findViewById(R.h.cLU);
            this.mfB = (TextView) view.findViewById(R.h.cLV);
            this.mfF = (ImageView) view.findViewById(R.h.cju);
            this.mfF.setBackgroundResource(R.e.aUk);
            this.mfF.setVisibility(8);
        }
    }

    public interface b {
        void B(int i, int i2, int i3);

        void cd(int i, int i2);

        void no(int i);
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.i.dkO, viewGroup, false));
    }

    public final /* synthetic */ void a(t tVar, int i, List list) {
        a aVar = (a) tVar;
        if (list.isEmpty()) {
            a(aVar, i);
            return;
        }
        MediaItem a = a(i, aVar);
        if (a != null) {
            c(aVar.mfy, a.hTf, i);
        }
    }

    public final void ce(int i, int i2) {
        this.mic = i;
        this.mib = i2;
    }

    public f(Context context, ArrayList<String> arrayList, int i, boolean z) {
        this.mContext = context;
        this.mhr = arrayList;
        this.mhX.addAll(arrayList);
        this.mhW = i;
        this.mgJ = z;
        this.mid = context.getResources().getDrawable(R.g.divider);
    }

    private void a(final a aVar, int i) {
        MediaItem a = a(i, aVar);
        if (a == null) {
            w.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            return;
        }
        LayoutParams layoutParams = aVar.mil.getLayoutParams();
        int i2 = this.mhW;
        layoutParams.width = i2;
        layoutParams.height = i2;
        c(aVar.mfy, a.hTf, i);
        aVar.mil.setOnClickListener(this);
        if (this.mgJ) {
            aVar.mil.setTag(Integer.valueOf(aVar.mim));
        } else {
            aVar.mil.setTag(a.hTf);
        }
        if (a.getType() == 2) {
            aVar.mfA.setVisibility(0);
            int round = Math.round(((float) ((long) ((VideoMediaItem) a).hTi)) / 1000.0f);
            aVar.mfB.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        } else {
            aVar.mfA.setVisibility(8);
        }
        String ayB = a.ayB();
        String str = a.hTf;
        if (bg.mA(ayB) && bg.mA(str)) {
            w.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: " + i);
            return;
        }
        h.a(aVar.mfz, a.getType(), ayB, str, a.meG, this.mhW, new com.tencent.mm.plugin.gallery.ui.h.a(this) {
            final /* synthetic */ f mif;

            public final void ayR() {
                w.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[]{Integer.valueOf(aVar.mfz.getWidth()), Integer.valueOf(aVar.mfz.getHeight())});
            }
        });
        if ((c.ayk().ayM() == 3 || c.ayk().ayM() == 11) && a != null && a.mMimeType.equalsIgnoreCase("image/gif")) {
            aVar.mfG.setVisibility(0);
        } else {
            aVar.mfG.setVisibility(8);
        }
        if (a.mMimeType.equalsIgnoreCase("edit")) {
            aVar.mfH.setVisibility(0);
        } else {
            aVar.mfH.setVisibility(8);
        }
        aVar.mik.setVisibility(8);
    }

    private void c(ImageView imageView, String str, int i) {
        if (i == this.mic && this.mhr.contains(str)) {
            w.i("MicroMsg.PreviewSelectedImageAdapter", "show select box");
            imageView.setVisibility(0);
            imageView.setBackground(null);
            imageView.setImageDrawable(this.mid);
        } else if (i == this.mic && !this.mhr.contains(str)) {
            w.i("MicroMsg.PreviewSelectedImageAdapter", "no show select box");
            imageView.setVisibility(0);
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(this.mid);
        } else if (i != this.mic && this.mhr.contains(str)) {
            imageView.setVisibility(8);
            imageView.setBackground(null);
            imageView.setImageDrawable(null);
        } else if (!(i == this.mic || this.mhr.contains(str))) {
            imageView.setVisibility(0);
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(null);
        }
        if (this.mib != i) {
            return;
        }
        if (!bg.mA(this.mhV.hO(this.mib)) && this.mhV.hO(this.mib).equals(str)) {
            imageView.setVisibility(0);
        } else if (!bg.mA(this.mhV.hO(this.mib)) && !this.mhV.hO(this.mib).equals(str)) {
            imageView.setVisibility(8);
        }
    }

    public final int getItemCount() {
        return this.mhX.size();
    }

    public final void onClick(View view) {
        if (this.mhY == null) {
            return;
        }
        if (this.mgJ) {
            this.mhY.no(((Integer) view.getTag()).intValue());
        } else {
            this.mhY.no(this.mhX.indexOf(view.getTag()));
        }
    }

    private MediaItem a(int i, a aVar) {
        if (i < 0 || i >= this.mhX.size()) {
            w.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mhX.size())});
            return null;
        }
        String str = (String) this.mhX.get(i);
        MediaItem a;
        int indexOf;
        Iterator it;
        MediaItem mediaItem;
        if (this.mgJ) {
            if (this.mhV.mfl == null) {
                return null;
            }
            a = MediaItem.a(0, 0, str, str, "");
            indexOf = this.mhV.mfl.indexOf(a);
            if (indexOf >= 0) {
                aVar.mim = indexOf;
                return (MediaItem) this.mhV.mfl.get(indexOf);
            }
            it = c.ayp().iterator();
            while (it.hasNext()) {
                mediaItem = (MediaItem) it.next();
                if (mediaItem.equals(a)) {
                    w.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[]{mediaItem.hTf});
                    return mediaItem;
                }
            }
            return null;
        } else if (c.aym() != null) {
            a = MediaItem.a(0, 0, str, str, "");
            indexOf = c.aym().indexOf(a);
            if (indexOf >= 0) {
                return (MediaItem) c.aym().get(indexOf);
            }
            it = c.ayp().iterator();
            while (it.hasNext()) {
                mediaItem = (MediaItem) it.next();
                if (mediaItem.equals(a)) {
                    w.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[]{mediaItem.hTf});
                    return mediaItem;
                }
            }
            return null;
        } else {
            return MediaItem.a(1, 0, str, str, "");
        }
    }
}
