package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewImageView extends LinearLayout implements v {
    private final Context context;
    private List<String> fRK = new ArrayList();
    private final int qwA = 4;
    private HashMap<String, Bitmap> qwB = new HashMap();
    private com.tencent.mm.plugin.sns.ui.v.a qwC;
    private boolean qwD = true;
    private boolean qwE = false;
    private TableLayout qwx;
    private final Map<Integer, View> qwy = new HashMap();
    private final Map<Integer, TableRow> qwz = new HashMap();

    class a extends h<String, Integer, Boolean> {
        private ImageView fMY;
        private Bitmap hqW;
        private String path;
        final /* synthetic */ PreviewImageView qwF;

        public final /* synthetic */ Object bed() {
            if (this.qwF.qwE) {
                return Boolean.valueOf(false);
            }
            this.hqW = d.d(this.path, ae.beS(), ae.beS(), true);
            w.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", new Object[]{this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree())});
            this.hqW = d.b(this.hqW, (float) r0);
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (!this.qwF.qwE && i.k(this.hqW)) {
                this.qwF.qwB.put(this.path, this.hqW);
                if (this.fMY.getTag() != null && (this.fMY.getTag() instanceof String) && this.fMY.getTag().equals(this.path)) {
                    this.fMY.setImageBitmap(this.hqW);
                }
            }
        }

        public a(PreviewImageView previewImageView, ImageView imageView, String str) {
            this.qwF = previewImageView;
            this.fMY = imageView;
            this.path = str;
        }

        public final com.tencent.mm.sdk.platformtools.ae bec() {
            return ae.bew();
        }
    }

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PreviewImageView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public final void biV() {
        this.qwD = false;
    }

    public final View getView() {
        return this;
    }

    public final void a(com.tencent.mm.plugin.sns.ui.v.a aVar) {
        this.qwC = aVar;
    }

    private void init() {
        this.qwx = (TableLayout) LayoutInflater.from(this.context).inflate(g.pHU, this, true).findViewById(f.content);
    }

    public final void clean() {
        this.qwE = true;
        for (Bitmap bitmap : this.qwB.values()) {
            if (i.k(bitmap)) {
                bitmap.recycle();
            }
        }
    }

    public final void bz(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            this.fRK = list;
            int i = 0;
            this.qwx.removeAllViews();
            int size = list.size() + 1;
            int i2 = 0;
            while (i < size) {
                View view;
                int i3;
                View view2 = (TableRow) this.qwz.get(Integer.valueOf(i2));
                if (view2 == null) {
                    view2 = new TableRow(this.context);
                    this.qwz.put(Integer.valueOf(i2), view2);
                    view = view2;
                } else {
                    view = view2;
                }
                view.removeAllViews();
                for (int i4 = 0; i4 < 4 && i < size; i4++) {
                    if (i >= 9) {
                        i3 = i + 1;
                        break;
                    }
                    String str;
                    view2 = (View) this.qwy.get(Integer.valueOf(i));
                    if (view2 == null) {
                        view2 = View.inflate(this.context, g.pHV, null);
                        this.qwy.put(Integer.valueOf(i), view2);
                    }
                    View view3 = view2;
                    if (i == size - 1) {
                        str = "";
                    } else {
                        str = (String) list.get(i);
                    }
                    ImageView imageView = (ImageView) view3.findViewById(f.pCV);
                    if (i != size - 1) {
                        imageView.setBackgroundDrawable(null);
                        imageView.setTag(str);
                        imageView.setContentDescription(getContext().getString(j.pLn));
                        Bitmap bitmap = (Bitmap) this.qwB.get(str);
                        if (i.k(bitmap)) {
                            imageView.setImageBitmap(bitmap);
                        } else {
                            w.d("MicroMsg.PreviewImageView", "bm is null");
                            new a(this, imageView, str).l("");
                        }
                    } else if (this.qwD) {
                        imageView.setBackgroundResource(e.pAj);
                        imageView.setContentDescription(getContext().getString(j.pKq));
                        imageView.setImageDrawable(null);
                    } else {
                        i++;
                    }
                    if (this.qwC != null) {
                        if (i == size - 1) {
                            view3.setTag(Integer.valueOf(-1));
                            view3.setOnClickListener(this.qwC.que);
                            view3.setClickable(true);
                        } else {
                            view3.setTag(Integer.valueOf(i));
                            view3.setOnClickListener(this.qwC.que);
                            view3.setClickable(true);
                        }
                    }
                    view3.setLayoutParams(new LayoutParams(-2, -2));
                    view.addView(view3);
                    i++;
                }
                i3 = i;
                if (view.getChildCount() > 0) {
                    this.qwx.addView(view);
                }
                w.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
                i2++;
                i = i3;
            }
        }
    }
}
