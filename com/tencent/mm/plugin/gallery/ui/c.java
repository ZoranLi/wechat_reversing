package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c extends t {
    private Bitmap fvM = null;
    public Context mContext;
    ArrayList<MediaItem> mfl = new ArrayList();
    ArrayList<String> mgI = new ArrayList();
    boolean mgJ;
    HashSet<String> mgK = new HashSet();
    int mgL = -1;
    View mgM = null;
    boolean mgN = false;
    private HashMap<String, WeakReference<b>> mgO = new HashMap();
    public e mgP = new e(this);
    public d mgQ = new d(this);

    class a implements OnClickListener {
        private String filePath;
        final /* synthetic */ c mgR;

        public a(c cVar, String str) {
            this.mgR = cVar;
            this.filePath = str;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.filePath)), "video/*");
            try {
                this.mgR.mContext.startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    static class b {
        ImageView lNl;
        MultiTouchImageView mgS;
        TextView mgT;

        b() {
        }
    }

    public final /* synthetic */ Object d(int i, View view) {
        b bVar;
        String str;
        MediaItem mediaItem;
        String str2;
        long NA = bg.NA();
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dfJ, null);
            b bVar2 = new b();
            bVar2.mgS = (MultiTouchImageView) view.findViewById(R.h.Kd);
            bVar2.lNl = (ImageView) view.findViewById(R.h.cLU);
            bVar2.mgT = (TextView) view.findViewById(R.h.cLS);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str3;
        if (this.mgJ) {
            MediaItem mediaItem2 = (MediaItem) this.mfl.get(i);
            str3 = mediaItem2.hTf;
            str = mediaItem2.lAL;
            mediaItem = mediaItem2;
            str2 = str3;
        } else {
            str3 = (String) this.mgI.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aym() != null) {
                int indexOf = com.tencent.mm.plugin.gallery.model.c.aym().indexOf(MediaItem.a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aym().get(indexOf);
                    str = null;
                    str2 = str3;
                }
            }
            mediaItem = null;
            str = null;
            str2 = str3;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.mgT.setText(this.mContext.getString(R.l.enw, new Object[]{bg.ay(new File(str2).length())}));
                bVar.mgT.setVisibility(0);
            } else {
                bVar.mgT.setVisibility(8);
            }
            bVar.lNl.setVisibility(8);
            bVar.lNl.setOnClickListener(null);
        } else {
            bVar.mgT.setVisibility(8);
            bVar.lNl.setVisibility(0);
            bVar.lNl.setOnClickListener(new a(this, str2));
            if (com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 4) {
                Runnable mVar = new m(mediaItem.hTf, i, (VideoMediaItem) mediaItem, null);
                if (e.T(mVar)) {
                    w.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", new Object[]{Integer.valueOf(16842794)});
                } else {
                    e.post(mVar, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView;
        MultiTouchImageView multiTouchImageView2;
        if (com.tencent.mm.plugin.gallery.model.c.ayk().ayM() != 3 || (!(mediaItem == null && o.Pj(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            com.tencent.mm.plugin.gallery.model.c.ayl().ayA();
            if (this.mgQ.mhf.aV(str2)) {
                bitmap = (Bitmap) this.mgQ.mhf.get(str2);
                if (!bitmap.isRecycled()) {
                    a(bVar.mgS, bitmap);
                }
            }
            bitmap = com.tencent.mm.plugin.gallery.model.c.ayj().xk(bg.mA(str) ? str2 : str);
            if (bitmap == null) {
                multiTouchImageView = bVar.mgS;
                if (this.fvM == null || this.fvM.isRecycled()) {
                    this.fvM = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.bir);
                }
                a(multiTouchImageView, this.fvM);
            } else {
                a(bVar.mgS, bitmap);
            }
            if (!this.mgK.contains(str2)) {
                this.mgK.add(str2);
                d dVar = this.mgQ;
                multiTouchImageView2 = bVar.mgS;
                if (!dVar.ta.contains(str2)) {
                    int hashCode = multiTouchImageView2.hashCode();
                    dVar.nm(hashCode);
                    dVar.mhc.put(str2, Integer.valueOf(hashCode));
                    dVar.mhd.put(hashCode, str2);
                    dVar.mhb.put(hashCode, new WeakReference(multiTouchImageView2));
                    dVar.ta.add(str2);
                    dVar.ayY();
                }
            }
        } else {
            multiTouchImageView = bVar.mgS;
            multiTouchImageView.vos = true;
            try {
                multiTouchImageView.vot = com.tencent.mm.ui.f.b.a.eW(str2, str2);
                multiTouchImageView.setImageDrawable(multiTouchImageView.vot);
                multiTouchImageView.dZ(multiTouchImageView.vot.getIntrinsicWidth(), multiTouchImageView.vot.getIntrinsicHeight());
            } catch (Exception e) {
                multiTouchImageView.vos = false;
            }
            multiTouchImageView2 = bVar.mgS;
            if (multiTouchImageView2.vos && multiTouchImageView2.vot != null) {
                ((com.tencent.mm.ui.f.b.b) multiTouchImageView2.vot).stop();
                ((com.tencent.mm.ui.f.b.b) multiTouchImageView2.vot).start();
            }
            bVar.mgS.at(1.0f);
            bVar.mgS.qBZ = false;
            if (VERSION.SDK_INT == 20) {
                bVar.mgS.setLayerType(1, null);
            } else {
                k.i(bVar.mgS, bVar.mgS.getWidth(), bVar.mgS.getHeight());
            }
            bVar.mgS.requestLayout();
            bVar.mgS.bSM();
        }
        w.v("MicroMsg.ImageAdapter", "test getview: %d position:%d", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(i)});
        return view;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final void E(ArrayList<String> arrayList) {
        this.mgI.clear();
        this.mgI = new ArrayList();
        this.mgI.addAll(arrayList);
        reset();
        notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.mgJ) {
            return super.b(viewGroup, i);
        }
        w.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mgL)});
        if (i != this.mgL || !this.mgN) {
            return super.b(viewGroup, i);
        }
        w.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.vnL.put(this.mgM, Integer.valueOf(this.mgL));
        this.vnM.put(this.mgL, this.mgM);
        this.mgL = -1;
        this.mgN = false;
        return this.mgM;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.mgJ) {
            super.a(viewGroup, i, obj);
        } else if (obj == null) {
            w.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[]{Integer.valueOf(i)});
        } else {
            if (this.mgM != null) {
                w.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.mgM.hashCode())});
            }
            if (obj == this.mgM && this.mgN) {
                w.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
                return;
            }
            super.a(viewGroup, i, obj);
            viewGroup.removeView((View) obj);
        }
    }

    public final int getCount() {
        if (this.mgJ) {
            return this.mfl.size();
        }
        return this.mgI.size();
    }

    public final MultiTouchImageView nk(int i) {
        View Al = super.Al(i);
        if (Al == null) {
            w.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        } else if (Al == null || Al.getVisibility() == 8) {
            return null;
        } else {
            Al = Al.findViewById(R.h.Kd);
            if (Al == null) {
                return null;
            }
            return (MultiTouchImageView) Al;
        }
    }

    public final String hO(int i) {
        if (this.mgJ) {
            if (i >= 0 && i < this.mfl.size()) {
                return ((MediaItem) this.mfl.get(i)).hTf;
            }
            w.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mfl.size())});
            return "";
        } else if (i >= 0 && i < this.mgI.size()) {
            return (String) this.mgI.get(i);
        } else {
            w.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mgI.size())});
            return "";
        }
    }

    public final MediaItem nl(int i) {
        if (this.mgJ) {
            if (i >= 0 && i < this.mfl.size()) {
                return (MediaItem) this.mfl.get(i);
            }
            w.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mfl.size())});
            return null;
        } else if (i < 0 || i >= this.mgI.size()) {
            w.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mgI.size())});
            return null;
        } else {
            String str = (String) this.mgI.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aym() == null) {
                return null;
            }
            int indexOf = com.tencent.mm.plugin.gallery.model.c.aym().indexOf(MediaItem.a(0, 0, str, str, ""));
            if (indexOf >= 0) {
                return (MediaItem) com.tencent.mm.plugin.gallery.model.c.aym().get(indexOf);
            }
            return null;
        }
    }

    @TargetApi(11)
    static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        multiTouchImageView.at(4.5f);
        multiTouchImageView.qBZ = false;
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            k.i(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.dZ(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
    }

    public final void release() {
        detach();
        this.mgO.clear();
        this.mgK.clear();
    }

    public final void detach() {
        super.detach();
        d dVar = this.mgQ;
        dVar.mhh = null;
        dVar.mhb.clear();
        dVar.mhe.clear();
        dVar.mhd.clear();
        dVar.mhc.clear();
        dVar.ayW();
    }
}
