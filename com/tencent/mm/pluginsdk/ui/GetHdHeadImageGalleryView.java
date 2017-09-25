package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    public String piV;
    public o sIE;
    private Bitmap sIF;
    private Bitmap sIG;
    private a sIH;
    public String username;

    private class a extends BaseAdapter {
        final /* synthetic */ GetHdHeadImageGalleryView sII;

        class a {
            ImageView fMY;
            ProgressBar mAY;
            View sIJ;
            final /* synthetic */ a sIK;

            a(a aVar) {
                this.sIK = aVar;
            }
        }

        private a(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
            this.sII = getHdHeadImageGalleryView;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.sII.getContext(), R.i.dpx, null);
                aVar2.mAY = (ProgressBar) view.findViewById(R.h.bVQ);
                aVar2.fMY = (ImageView) view.findViewById(R.h.bVP);
                aVar2.sIJ = view.findViewById(R.h.bVR);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            if (this.sII.sIG != null) {
                aVar.mAY.setVisibility(8);
                aVar.fMY.setVisibility(8);
                aVar.sIJ.setVisibility(8);
                view = new MultiTouchImageView(this.sII.getContext(), this.sII.sIG.getWidth(), this.sII.sIG.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(this.sII.sIG);
                view.at(2.0f);
                view.vol = true;
                return view;
            }
            aVar.mAY.setVisibility(0);
            aVar.sIJ.setVisibility(0);
            if (this.sII.sIF != null) {
                aVar.fMY.setVisibility(0);
                aVar.fMY.setImageBitmap(this.sII.sIF);
                return view;
            }
            aVar.fMY.setVisibility(8);
            return view;
        }
    }

    private class b implements com.tencent.mm.ui.tools.MMGestureGallery.c {
        final /* synthetic */ GetHdHeadImageGalleryView sII;

        public b(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
            this.sII = getHdHeadImageGalleryView;
        }

        public final void auf() {
            if (this.sII.piV != null && this.sII.username != null) {
                g.a(this.sII.getContext(), null, this.sII.getContext().getResources().getStringArray(R.c.aSb), "", new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ b sIL;

                    {
                        this.sIL = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                String str = e.gSz + "hdImg_" + com.tencent.mm.a.g.n(this.sIL.sII.username.getBytes()) + System.currentTimeMillis() + ".jpg";
                                FileOp.deleteFile(str);
                                FileOp.p(this.sIL.sII.piV, str);
                                d.b(str, this.sIL.sII.getContext());
                                Toast.makeText(this.sIL.sII.getContext(), this.sIL.sII.getContext().getString(R.l.eqA, new Object[]{e.gSz}), 1).show();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    private class c implements f {
        final /* synthetic */ GetHdHeadImageGalleryView sII;

        public c(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
            this.sII = getHdHeadImageGalleryView;
        }

        public final void ahA() {
            if (this.sII.sIE != null) {
                this.sII.sIE.dismiss();
            }
        }
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.sIH = new a();
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.sIH);
        setSelection(0);
        this.wmR = new c(this);
        this.wmS = new b(this);
    }

    public final void setThumbImage(Bitmap bitmap) {
        this.sIF = bitmap;
        this.sIH.notifyDataSetChanged();
    }

    public final void H(Bitmap bitmap) {
        this.sIG = bitmap;
        this.sIH.notifyDataSetChanged();
    }
}
