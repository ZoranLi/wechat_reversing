package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n.a.a.b;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFurtherInfoUI extends MMPreference {
    protected f jid;
    private MMPageControlView oYV;
    private com.tencent.mm.plugin.scanner.util.n.a.a oYW;
    private String oYX;
    private ViewPager xF;

    class a extends u implements com.tencent.mm.platformtools.j.a {
        private Context mContext;
        final /* synthetic */ ProductFurtherInfoUI oYY;
        List<String> oZa = new ArrayList();
        private Map<String, ImageView> oZb = new HashMap();
        private int oZc;

        public a(ProductFurtherInfoUI productFurtherInfoUI, Context context) {
            this.oYY = productFurtherInfoUI;
            this.mContext = context;
            j.a(this);
            this.oZc = this.mContext.getResources().getColor(R.e.aUp);
        }

        private ImageView DI(String str) {
            if (this.oZb.containsKey(str)) {
                return (ImageView) this.oZb.get(str);
            }
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            this.oZb.put(str, imageView);
            return imageView;
        }

        public final Object b(ViewGroup viewGroup, int i) {
            String str = (String) this.oZa.get(i);
            View DI = DI(str);
            Bitmap a = j.a(new o(str));
            if (a == null || a.isRecycled()) {
                DI.setImageBitmap(null);
                DI.setBackgroundColor(this.oZc);
            } else {
                DI.setImageBitmap(a);
                DI.setBackgroundColor(0);
            }
            try {
                viewGroup.addView(DI);
            } catch (Exception e) {
                w.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
            }
            return DI;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((ImageView) obj);
            String str = (String) this.oZa.get(i);
            if (this.oZb.containsKey(str)) {
                this.oZb.remove(str);
            }
        }

        public final int getCount() {
            return this.oZa.size();
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void k(String str, final Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled() && !bg.mA(str)) {
                final ImageView DI = DI(str);
                if (DI != null) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ a oZd;

                        public final void run() {
                            DI.setImageBitmap(bitmap);
                            DI.setBackgroundColor(0);
                        }
                    });
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.scanner.util.n.a bA = i.bA(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bA == null || bA.pes == null) {
            w.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            return;
        }
        this.oYW = bA.pes;
        this.oYX = bA.field_feedbackurl;
        KC();
    }

    protected final void KC() {
        int i = 0;
        qP(getIntent().getStringExtra("key_title"));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductFurtherInfoUI oYY;

            {
                this.oYY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oYY.finish();
                return false;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductFurtherInfoUI oYY;

            {
                this.oYY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(this.oYY.getString(R.l.ePf));
                linkedList2.add(Integer.valueOf(0));
                g.a(this.oYY.uSU.uTo, "", linkedList, linkedList2, "", false, new d(this) {
                    final /* synthetic */ AnonymousClass2 oYZ;

                    {
                        this.oYZ = r1;
                    }

                    public final void bN(int i, int i2) {
                        switch (i2) {
                            case 0:
                                if (!bg.mA(this.oYZ.oYY.oYX)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", this.oYZ.oYY.oYX);
                                    com.tencent.mm.bb.d.b(this.oYZ.oYY.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.jid = this.vrv;
        List arrayList = new ArrayList();
        Iterator it = this.oYW.pet.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.mm.plugin.scanner.util.n.a.a.a) it.next()).hSX);
        }
        this.xF = (ViewPager) findViewById(R.h.cqE);
        this.oYV = (MMPageControlView) findViewById(R.h.bXz);
        this.oYV.vlf = R.i.dkr;
        this.oYV.setVisibility(0);
        this.xF.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ProductFurtherInfoUI oYY;

            {
                this.oYY = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!(view == null || view.getParent() == null)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        this.xF.zb = new e(this) {
            final /* synthetic */ ProductFurtherInfoUI oYY;

            {
                this.oYY = r1;
            }

            public final void a(int i, float f, int i2) {
            }

            public final void V(int i) {
                if (this.oYY.xF.getParent() != null) {
                    this.oYY.xF.getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.oYY.oYV.tu(i);
            }

            public final void W(int i) {
            }
        };
        u aVar = new a(this, this);
        this.xF.a(aVar);
        if (arrayList.size() > 0) {
            aVar.oZa = arrayList;
            aVar.oYY.oYV.dY(arrayList.size(), 0);
            aVar.notifyDataSetChanged();
            this.xF.setVisibility(0);
        }
        while (i < this.oYW.peu.size()) {
            b bVar = (b) this.oYW.peu.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(R.i.djG);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.jid.a(preference);
            i++;
        }
        this.jid.notifyDataSetChanged();
    }

    public final int ON() {
        return R.o.dkT;
    }

    protected final int getLayoutId() {
        return R.i.dkT;
    }

    public final int aeq() {
        return R.i.dkU;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
