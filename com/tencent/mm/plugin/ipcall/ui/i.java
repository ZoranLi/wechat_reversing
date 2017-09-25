package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i extends AlertDialog implements e {
    private TextView Fy;
    private MMDotView kSg;
    private View khv;
    private Context mContext;
    private b mXt;
    private IPCallShareViewPager mXu;
    private OnClickListener mXv;
    private LinkedList<Integer> mXw;
    private CharSequence uI;

    public static class a extends BaseAdapter {
        private Context mContext;
        OnClickListener mXx;
        List<Integer> mzj = null;

        public class a {
            int id;
            TextView mXA;
            ImageView mXB;
            final /* synthetic */ a mXy;
            RelativeLayout mXz;

            public a(a aVar) {
                this.mXy = aVar;
            }
        }

        public a(Context context) {
            Assert.assertTrue(context != null);
            this.mContext = context;
        }

        public final int getCount() {
            return this.mzj == null ? 0 : this.mzj.size();
        }

        public final Object getItem(int i) {
            if (this.mzj != null) {
                return this.mzj.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.dgx, viewGroup, false);
                aVar = new a(this);
                aVar.mXz = (RelativeLayout) view.findViewById(R.h.layout);
                aVar.mXA = (TextView) view.findViewById(R.h.bYZ);
                aVar.mXB = (ImageView) view.findViewById(R.h.bYY);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            Object item = getItem(i);
            if (item != null) {
                aVar.id = ((Integer) item).intValue();
                IPCallShareCouponCardUI.a(this.mContext, aVar.id, aVar.mXA, aVar.mXB);
                aVar.mXz.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a mXy;

                    {
                        this.mXy = r1;
                    }

                    public final void onClick(View view) {
                        if (this.mXy.mXx != null) {
                            this.mXy.mXx.onClick(view);
                        }
                    }
                });
            }
            return view;
        }
    }

    public class b extends u {
        int mCount = 0;
        LinkedList<Integer> mXC;
        ArrayList<View> mXD = new ArrayList();
        final /* synthetic */ i mXE;
        OnClickListener mXx;

        public b(i iVar) {
            this.mXE = iVar;
        }

        public final int getCount() {
            return this.mCount;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            w.v("MicroMsg.IPCallShareDialog", "destroy item: %d", new Object[]{Integer.valueOf(i)});
            viewGroup.removeView((View) obj);
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view;
            if (this.mXD.get(i) != null) {
                view = (View) this.mXD.get(i);
            } else {
                view = null;
            }
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (viewGroup != null) {
                    viewGroup.addView(view, 0);
                }
            }
            return view;
        }

        public final int j(Object obj) {
            return super.j(obj);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.khv);
    }

    public final void V(int i) {
        if (this.mXt.getCount() <= 1) {
            this.kSg.setVisibility(4);
            return;
        }
        this.kSg.setVisibility(0);
        this.kSg.Ad(this.mXt.getCount());
        this.kSg.Ae(i);
    }

    public final void W(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uI = charSequence;
        } else {
            this.uI = null;
        }
    }

    public final void show() {
        if (this.mXw != null && this.mXw.size() != 0) {
            this.mXu.b(this);
            b bVar = new b(this);
            bVar.mXx = this.mXv;
            bVar.mXC = this.mXw;
            if (bVar.mXC.size() > 0) {
                bVar.mCount = ((bVar.mXC.size() - 1) / 9) + 1;
            } else {
                bVar.mCount = 0;
            }
            int i = 0;
            while (i < bVar.mCount) {
                View inflate = ((LayoutInflater) bVar.mXE.mContext.getSystemService("layout_inflater")).inflate(R.i.dgw, null);
                GridView gridView = (GridView) inflate.findViewById(R.h.bZa);
                List arrayList = new ArrayList();
                int i2 = i * 9;
                while (i2 < bVar.mXC.size() && i2 < (i * 9) + 9) {
                    arrayList.add(bVar.mXC.get(i2));
                    i2++;
                }
                ListAdapter aVar = new a(bVar.mXE.getContext());
                aVar.mXx = bVar.mXx;
                aVar.mzj = arrayList;
                gridView.setAdapter(aVar);
                bVar.mXD.add(inflate);
                i++;
            }
            this.mXt = bVar;
            this.mXu.a(this.mXt);
            this.Fy.setText(this.uI);
            super.show();
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
