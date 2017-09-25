package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, com.tencent.mm.plugin.gallery.model.g.a {
    boolean To = false;
    a mgU = null;
    FrameLayout mgV;
    private View mgW;
    private ListView mgX;
    private b mgY;
    boolean mgZ = false;

    public interface a {
        void b(AlbumItem albumItem);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.mgV = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.mgV.setVisibility(8);
        addView(this.mgV, layoutParams);
        this.mgW = new View(getContext());
        this.mgW.setBackgroundColor(-872415232);
        this.mgW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImageFolderMgrView mha;

            {
                this.mha = r1;
            }

            public final void onClick(View view) {
                this.mha.eu(false);
            }
        });
        this.mgV.addView(this.mgW, new FrameLayout.LayoutParams(-1, -1));
        this.mgX = new ListView(getContext());
        this.mgX.setCacheColorHint(0);
        this.mgX.setBackgroundResource(R.e.aVj);
        this.mgX.setSelector(R.g.bhc);
        this.mgX.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aXH);
        this.mgX.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.aWS);
        layoutParams.gravity = 80;
        this.mgV.addView(this.mgX, layoutParams);
        this.mgY = new b(getContext(), c.ayk().ayN());
        this.mgX.setAdapter(this.mgY);
    }

    public final void ayV() {
        eu(!this.To);
    }

    private void eu(boolean z) {
        if (this.To == z) {
            w.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[]{Boolean.valueOf(this.To)});
        } else if (this.mgZ) {
            w.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[]{Boolean.valueOf(z)});
        } else if (this.To) {
            this.mgZ = true;
            r0 = AnimationUtils.loadAnimation(getContext(), R.a.aRo);
            r0.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageFolderMgrView mha;

                {
                    this.mha = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.mha.mgV.setVisibility(8);
                    this.mha.To = false;
                    this.mha.mgZ = false;
                }
            });
            this.mgX.startAnimation(r0);
            this.mgW.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.aQY));
        } else {
            this.mgZ = true;
            this.mgV.setVisibility(0);
            this.mgW.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.aQX));
            r0 = AnimationUtils.loadAnimation(getContext(), R.a.aRq);
            r0.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageFolderMgrView mha;

                {
                    this.mha = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.mha.To = true;
                    this.mha.mgZ = false;
                }
            });
            this.mgX.startAnimation(r0);
        }
    }

    public final void A(ArrayList<AlbumItem> arrayList) {
        b bVar = this.mgY;
        bVar.mgB = arrayList;
        if (!(bVar.mgB == null || bVar.mgB.isEmpty() || ((AlbumItem) bVar.mgB.get(0)).meD == null)) {
            Iterator it = bVar.mgB.iterator();
            AlbumItem albumItem = null;
            while (it.hasNext()) {
                AlbumItem albumItem2 = (AlbumItem) it.next();
                if (albumItem == null) {
                    albumItem = albumItem2;
                } else {
                    if (albumItem.meD.meH >= albumItem2.meD.meH) {
                        albumItem2 = albumItem;
                    }
                    albumItem = albumItem2;
                }
            }
            if (albumItem != null) {
                bVar.mgC.meD = albumItem.meD;
            }
        }
        c.ayl().v(new Runnable(this) {
            final /* synthetic */ ImageFolderMgrView mha;

            {
                this.mha = r1;
            }

            public final void run() {
                this.mha.mgY.notifyDataSetChanged();
            }

            public final String toString() {
                return super.toString() + "|onQueryAlbumFinished";
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlbumItem nj = this.mgY.nj(i);
        if (nj == null) {
            w.d("MicroMsg.ImageFolderMgrView", "get folder failed:" + i);
            return;
        }
        if (this.mgU != null) {
            this.mgU.b(nj);
        }
        this.mgY.mgD = bg.ap(nj.meC, "");
        this.mgX.setSelection(0);
        this.mgY.notifyDataSetChanged();
        this.mgW.performClick();
    }
}
