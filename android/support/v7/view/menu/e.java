package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a.h;
import android.support.v7.app.a.a.AnonymousClass1;
import android.support.v7.app.a.a.AnonymousClass2;
import android.support.v7.app.a.a.AnonymousClass3;
import android.support.v7.app.a.a.AnonymousClass4;
import android.support.v7.app.b;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.util.ArrayList;

public final class e implements l, OnItemClickListener {
    public LayoutInflater Du;
    int PU;
    public ExpandedMenuView Qi;
    public int Qj;
    int Qk;
    public a Ql;
    public android.support.v7.view.menu.l.a dV;
    f dW;
    private int dX;
    Context mContext;

    private class a extends BaseAdapter {
        private int Qm = -1;
        final /* synthetic */ e Qn;

        public final /* synthetic */ Object getItem(int i) {
            return ax(i);
        }

        public a(e eVar) {
            this.Qn = eVar;
            dr();
        }

        public final int getCount() {
            int size = this.Qn.dW.dB().size() - this.Qn.Qj;
            return this.Qm < 0 ? size : size - 1;
        }

        public final h ax(int i) {
            ArrayList dB = this.Qn.dW.dB();
            int i2 = this.Qn.Qj + i;
            if (this.Qm >= 0 && i2 >= this.Qm) {
                i2++;
            }
            return (h) dB.get(i2);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.Qn.Du.inflate(this.Qn.PU, viewGroup, false);
            } else {
                inflate = view;
            }
            ((android.support.v7.view.menu.m.a) inflate).a(ax(i));
            return inflate;
        }

        private void dr() {
            h hVar = this.Qn.dW.QI;
            if (hVar != null) {
                ArrayList dB = this.Qn.dW.dB();
                int size = dB.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dB.get(i)) == hVar) {
                        this.Qm = i;
                        return;
                    }
                }
            }
            this.Qm = -1;
        }

        public final void notifyDataSetChanged() {
            dr();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i) {
        this(i);
        this.mContext = context;
        this.Du = LayoutInflater.from(this.mContext);
    }

    private e(int i) {
        this.PU = i;
        this.Qk = 0;
    }

    public final void a(Context context, f fVar) {
        if (this.Qk != 0) {
            this.mContext = new ContextThemeWrapper(context, this.Qk);
            this.Du = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.Du == null) {
                this.Du = LayoutInflater.from(this.mContext);
            }
        }
        this.dW = fVar;
        if (this.Ql != null) {
            this.Ql.notifyDataSetChanged();
        }
    }

    public final ListAdapter getAdapter() {
        if (this.Ql == null) {
            this.Ql = new a(this);
        }
        return this.Ql;
    }

    public final void f(boolean z) {
        if (this.Ql != null) {
            this.Ql.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        g gVar = new g(pVar);
        f fVar = gVar.dW;
        android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(fVar.mContext);
        gVar.QL = new e(aVar.Go.mContext, h.KJ);
        gVar.QL.dV = gVar;
        gVar.dW.a(gVar.QL);
        aVar.Go.FA = gVar.QL.getAdapter();
        aVar.Go.FY = gVar;
        View view = fVar.QB;
        if (view != null) {
            aVar.Go.Fz = view;
        } else {
            aVar.Go.jQ = fVar.QA;
            aVar.Go.uI = fVar.Qz;
        }
        aVar.Go.FW = gVar;
        b bVar = new b(aVar.Go.mContext, aVar.oH);
        android.support.v7.app.a.a aVar2 = aVar.Go;
        android.support.v7.app.a a = bVar.Gn;
        if (aVar2.Fz != null) {
            a.Fz = aVar2.Fz;
        } else {
            if (aVar2.uI != null) {
                a.setTitle(aVar2.uI);
            }
            if (aVar2.jQ != null) {
                Drawable drawable = aVar2.jQ;
                a.jQ = drawable;
                a.Fx = 0;
                if (a.kI != null) {
                    if (drawable != null) {
                        a.kI.setVisibility(0);
                        a.kI.setImageDrawable(drawable);
                    } else {
                        a.kI.setVisibility(8);
                    }
                }
            }
            if (aVar2.Fx != 0) {
                a.setIcon(aVar2.Fx);
            }
            if (aVar2.FN != 0) {
                int i = aVar2.FN;
                TypedValue typedValue = new TypedValue();
                a.mContext.getTheme().resolveAttribute(i, typedValue, true);
                a.setIcon(typedValue.resourceId);
            }
        }
        if (aVar2.Ff != null) {
            CharSequence charSequence = aVar2.Ff;
            a.Ff = charSequence;
            if (a.jq != null) {
                a.jq.setText(charSequence);
            }
        }
        if (aVar2.FO != null) {
            a.a(-1, aVar2.FO, aVar2.FP, null);
        }
        if (aVar2.FQ != null) {
            a.a(-2, aVar2.FQ, aVar2.FR, null);
        }
        if (aVar2.FS != null) {
            a.a(-3, aVar2.FS, aVar2.FT, null);
        }
        if (!(aVar2.FX == null && aVar2.Bo == null && aVar2.FA == null)) {
            ListAdapter cVar;
            ListView listView = (ListView) aVar2.Du.inflate(a.FE, null);
            Object simpleCursorAdapter;
            if (!aVar2.Ga) {
                int i2 = aVar2.Gb ? a.FG : a.FH;
                if (aVar2.Bo != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(aVar2.mContext, i2, aVar2.Bo, new String[]{aVar2.Gd}, new int[]{16908308});
                } else {
                    cVar = aVar2.FA != null ? aVar2.FA : new c(aVar2.mContext, i2, aVar2.FX);
                }
            } else if (aVar2.Bo == null) {
                cVar = new AnonymousClass1(aVar2, aVar2.mContext, a.FF, aVar2.FX, listView);
            } else {
                simpleCursorAdapter = new AnonymousClass2(aVar2, aVar2.mContext, aVar2.Bo, listView, a);
            }
            a.FA = cVar;
            a.FB = aVar2.FB;
            if (aVar2.FY != null) {
                listView.setOnItemClickListener(new AnonymousClass3(aVar2, a));
            } else if (aVar2.Gc != null) {
                listView.setOnItemClickListener(new AnonymousClass4(aVar2, listView, a));
            }
            if (aVar2.Gf != null) {
                listView.setOnItemSelectedListener(aVar2.Gf);
            }
            if (aVar2.Gb) {
                listView.setChoiceMode(1);
            } else if (aVar2.Ga) {
                listView.setChoiceMode(2);
            }
            a.Fg = listView;
        }
        if (aVar2.mView != null) {
            if (aVar2.Fm) {
                View view2 = aVar2.mView;
                int i3 = aVar2.Fi;
                int i4 = aVar2.Fj;
                int i5 = aVar2.Fk;
                int i6 = aVar2.Fl;
                a.mView = view2;
                a.Fh = 0;
                a.Fm = true;
                a.Fi = i3;
                a.Fj = i4;
                a.Fk = i5;
                a.Fl = i6;
            } else {
                a.mView = aVar2.mView;
                a.Fh = 0;
                a.Fm = false;
            }
        } else if (aVar2.Fh != 0) {
            i = aVar2.Fh;
            a.mView = null;
            a.Fh = i;
            a.Fm = false;
        }
        bVar.setCancelable(aVar.Go.oI);
        if (aVar.Go.oI) {
            bVar.setCanceledOnTouchOutside(true);
        }
        bVar.setOnCancelListener(aVar.Go.FU);
        bVar.setOnDismissListener(aVar.Go.FV);
        if (aVar.Go.FW != null) {
            bVar.setOnKeyListener(aVar.Go.FW);
        }
        gVar.QK = bVar;
        gVar.QK.setOnDismissListener(gVar);
        LayoutParams attributes = gVar.QK.getWindow().getAttributes();
        attributes.type = MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED;
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        gVar.QK.show();
        if (this.dV != null) {
            this.dV.d(pVar);
        }
        return true;
    }

    public final void a(f fVar, boolean z) {
        if (this.dV != null) {
            this.dV.a(fVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.dW.a(this.Ql.ax(i), (l) this, 0);
    }

    public final boolean B() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.dX;
    }

    public final Parcelable onSaveInstanceState() {
        if (this.Qi == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        if (this.Qi != null) {
            this.Qi.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.Qi.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
