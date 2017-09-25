package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.s;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMGallery;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameGestureGalleryUI extends MMActivity implements OnTouchListener, com.tencent.mm.platformtools.j.a {
    private a mAM;
    private MMGallery mAN;
    private MMGestureGallery mAO;
    float mAP = 0.0f;
    float mAQ = 0.0f;
    boolean mAR = false;
    float mAS = 1.0f;
    private s mAT;
    private List<String> mAU = new ArrayList();
    private int mAV = -1;
    private OnItemSelectedListener mAW = new OnItemSelectedListener(this) {
        final /* synthetic */ GameGestureGalleryUI mAX;

        {
            this.mAX = r1;
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.mAX.mAV = i;
            this.mAX.qP((this.mAX.mAV + 1) + " / " + this.mAX.mAU.size());
            w.d("MicroMsg.GameGestureGalleryUI", "pos:" + i);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    private String thumbUrl;

    class a extends BaseAdapter {
        final /* synthetic */ GameGestureGalleryUI mAX;

        class a {
            ImageView fMY;
            ProgressBar mAY;
            final /* synthetic */ a mAZ;

            a(a aVar) {
                this.mAZ = aVar;
            }
        }

        public a(GameGestureGalleryUI gameGestureGalleryUI) {
            this.mAX = gameGestureGalleryUI;
        }

        public final int getCount() {
            w.d("MicroMsg.GameGestureGalleryUI", "lstpicurl:" + this.mAX.mAU.size());
            return this.mAX.mAU.size();
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
                aVar = new a(this);
                view = View.inflate(this.mAX, R.i.dfK, null);
                aVar.mAY = (ProgressBar) view.findViewById(R.h.cts);
                aVar.fMY = (ImageView) view.findViewById(R.h.Kd);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            aVar.mAY.setVisibility(8);
            Bitmap a = j.a(new ak((String) this.mAX.mAU.get(i)));
            if (a == null || a.isRecycled()) {
                aVar.mAY.setVisibility(0);
                if (!bg.mA(this.mAX.thumbUrl)) {
                    a = j.a(new ak(this.mAX.thumbUrl));
                }
                if (a == null || a.isRecycled()) {
                    aVar.fMY.setVisibility(8);
                    return view;
                }
                aVar.fMY.setImageBitmap(a);
                aVar.fMY.setVisibility(0);
                return view;
            } else if (f.bnc()) {
                aVar.fMY.setVisibility(8);
                view = new MultiTouchImageView(this.mAX, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                return view;
            } else {
                aVar.fMY.setImageBitmap(a);
                aVar.fMY.setVisibility(0);
                aVar.fMY.setScaleType(ScaleType.MATRIX);
                return view;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAT = new s(false);
        j.a(this);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mAT.yE();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dlV;
    }

    protected final void KC() {
        this.thumbUrl = getIntent().getStringExtra("thumbUrl");
        String mz = bg.mz(getIntent().getStringExtra("nowUrl"));
        this.uSU.bQg();
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            this.mAU = new ArrayList();
            this.mAU.add(mz);
        } else {
            this.mAU = Arrays.asList(stringArrayExtra);
        }
        for (int i = 0; i < this.mAU.size(); i++) {
            if (mz.equals(this.mAU.get(i))) {
                this.mAV = i;
                break;
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameGestureGalleryUI mAX;

            {
                this.mAX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mAX.finish();
                return true;
            }
        });
        this.mAM = new a(this);
        if (f.bnc()) {
            this.mAO = (MMGestureGallery) findViewById(R.h.bSr);
            this.mAO.setVisibility(0);
            this.mAO.setVerticalFadingEdgeEnabled(false);
            this.mAO.setHorizontalFadingEdgeEnabled(false);
            this.mAO.setAdapter(this.mAM);
            this.mAO.setSelection(this.mAV);
            this.mAO.setOnItemSelectedListener(this.mAW);
            return;
        }
        this.mAN = (MMGallery) findViewById(R.h.bSs);
        this.mAN.setVisibility(0);
        this.mAN.setAdapter(this.mAM);
        this.mAN.setSelection(this.mAV);
        this.mAN.setOnItemSelectedListener(this.mAW);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        w.d("MicroMsg.GameGestureGalleryUI", "Main onTouch event.getAction():" + motionEvent.getAction());
        switch (motionEvent.getAction() & 255) {
            case 2:
                if (this.mAR) {
                    this.mAQ = f.E(motionEvent);
                    if (this.mAQ >= 5.0f) {
                        float f = this.mAQ - this.mAP;
                        if (f != 0.0f) {
                            if (Math.abs(f) <= 5.0f) {
                                return true;
                            }
                            float f2 = f / 854.0f;
                            Animation scaleAnimation = new ScaleAnimation(this.mAS, this.mAS + f2, this.mAS, this.mAS + f2, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(100);
                            scaleAnimation.setFillAfter(true);
                            scaleAnimation.setFillEnabled(true);
                            this.mAS += f2;
                            this.mAN.getSelectedView().setLayoutParams(new LayoutParams((int) (480.0f * this.mAS), (int) (this.mAS * 854.0f)));
                            this.mAP = this.mAQ;
                            return true;
                        }
                    }
                }
                break;
            case 5:
                this.mAP = f.E(motionEvent);
                if (this.mAP > 5.0f) {
                    this.mAR = true;
                    break;
                }
                break;
            case 6:
                this.mAR = false;
                break;
        }
        return false;
    }

    public final void k(String str, Bitmap bitmap) {
        if (this.mAU != null && this.mAU.size() != 0) {
            if ((((String) this.mAU.get(0)).hashCode()).equals(str) && this.mAM != null) {
                this.mAM.notifyDataSetChanged();
            }
        }
    }
}
