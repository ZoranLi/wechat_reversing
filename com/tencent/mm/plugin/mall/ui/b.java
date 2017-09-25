package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater Du;
    private Context mContext;
    private final int nvA = 3;
    private final int nvB = 9;
    List<ArrayList<c>> nvC = new ArrayList();
    d nvD;
    private boolean nvE = true;
    int nvF = 0;
    int nvG = 0;
    boolean nvH = false;
    private boolean nvI = false;
    SparseArray<String> nvj = null;
    int nvk;

    class a {
        final /* synthetic */ b nvJ;
        public View nvM = null;
        public ImageView nvN = null;
        public ImageView nvO = null;
        public TextView nvP = null;
        public TextView nvQ = null;
        public String nvR = null;
        public String nvS = null;
        public ImageView nvT = null;
        public ImageView nvU = null;
        public ImageView nvV = null;
        public ImageView nvW = null;

        a(b bVar) {
            this.nvJ = bVar;
        }
    }

    class b {
        final /* synthetic */ b nvJ;
        LinearLayout nvX;
        TextView nvY;
        View nvZ;
        ImageView nwa;
        TextView nwb;
        View nwc = null;

        b(b bVar) {
            this.nvJ = bVar;
        }
    }

    class c {
        final /* synthetic */ b nvJ;
        MallFunction nwd;
        int nwe;

        c(b bVar) {
            this.nvJ = bVar;
        }
    }

    public interface d {
        void a(int i, MallFunction mallFunction);
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.nvk = i;
        this.Du = LayoutInflater.from(this.mContext);
    }

    public final int getCount() {
        return this.nvC.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        Object obj;
        b bVar;
        b bVar2;
        List list;
        int i3;
        int i4;
        Object obj2;
        CharSequence charSequence;
        Object obj3;
        ViewGroup viewGroup2;
        a aVar;
        View inflate;
        a aVar2;
        if (this.nvF > 9) {
            int i5 = 0;
            for (i2 = 0; i2 <= i; i2++) {
                i5 += ((ArrayList) this.nvC.get(i2)).size();
            }
            if (i <= this.nvG) {
                if (i5 > 9 && this.nvE) {
                    obj = 1;
                    if (view == null) {
                        bVar = (b) view.getTag();
                    } else {
                        bVar2 = new b(this);
                        view = this.Du.inflate(R.i.dhK, viewGroup, false);
                        bVar2.nvX = (LinearLayout) view.findViewById(R.h.chd);
                        bVar2.nvY = (TextView) view.findViewById(R.h.chc);
                        bVar2.nvZ = view.findViewById(R.h.ciH);
                        bVar2.nwb = (TextView) view.findViewById(R.h.ciI);
                        bVar2.nwa = (ImageView) view.findViewById(R.h.ciG);
                        bVar2.nwc = view.findViewById(R.h.clk);
                        bVar2.nvZ.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ b nvJ;

                            {
                                this.nvJ = r1;
                            }

                            public final void onClick(View view) {
                                this.nvJ.nvE = !this.nvJ.nvE;
                                this.nvJ.nvI = true;
                                this.nvJ.notifyDataSetChanged();
                            }
                        });
                        view.setTag(bVar2);
                        bVar = bVar2;
                    }
                    if (obj == null) {
                    }
                    bVar.nvX.setVisibility(0);
                    list = (List) this.nvC.get(i);
                    i3 = ((c) list.get(0)).nwd.type;
                    if (list.size() > 0) {
                        bVar.nvY.setVisibility(8);
                    } else {
                        i4 = ((c) list.get(0)).nwd.type;
                        if (this.nvj == null) {
                            obj2 = (String) this.nvj.get(i4);
                        } else {
                            charSequence = null;
                        }
                        if (!bg.mA(charSequence)) {
                            obj3 = i != 0 ? 1 : 1;
                            if (obj3 == null) {
                                bVar.nvY.setText(charSequence);
                                bVar.nvY.setVisibility(0);
                            } else {
                                bVar.nvY.setVisibility(8);
                            }
                        }
                        obj3 = null;
                        if (obj3 == null) {
                            bVar.nvY.setVisibility(8);
                        } else {
                            bVar.nvY.setText(charSequence);
                            bVar.nvY.setVisibility(0);
                        }
                    }
                    viewGroup2 = bVar.nvX;
                    viewGroup2.setFocusable(true);
                    i2 = 0;
                    while (i2 < 3) {
                        if (i2 < viewGroup2.getChildCount()) {
                        }
                        aVar = new a(this);
                        inflate = this.Du.inflate(R.i.dhM, viewGroup2, false);
                        aVar.nvM = inflate.findViewById(R.h.chh);
                        aVar.nvN = (ImageView) inflate.findViewById(R.h.chg);
                        aVar.nvP = (TextView) inflate.findViewById(R.h.chj);
                        aVar.nvQ = (TextView) inflate.findViewById(R.h.chf);
                        aVar.nvO = (ImageView) inflate.findViewById(R.h.cnQ);
                        aVar.nvT = (ImageView) inflate.findViewById(R.h.bJS);
                        aVar.nvU = (ImageView) inflate.findViewById(R.h.bJQ);
                        aVar.nvV = (ImageView) inflate.findViewById(R.h.bJJ);
                        aVar.nvW = (ImageView) inflate.findViewById(R.h.bJM);
                        inflate.setTag(aVar);
                        if (i2 < list.size()) {
                            inflate.setFocusable(true);
                            aVar2 = (a) inflate.getTag();
                            aVar2.nvM.setVisibility(8);
                            inflate.setOnClickListener(null);
                            inflate.setEnabled(false);
                            inflate.setClickable(false);
                            a(aVar2);
                        } else {
                            a(inflate, (c) list.get(i2));
                        }
                        viewGroup2.addView(inflate, new LayoutParams(-2, a.aIR(), 1.0f));
                        i2++;
                    }
                    if (obj != null) {
                        bVar.nvZ.setVisibility(8);
                    } else {
                        bVar.nvY.setVisibility(8);
                        bVar.nvZ.setVisibility(0);
                        bVar.nwa.setImageResource(R.k.dAD);
                        if (this.nvE) {
                            bVar.nwb.setText(this.mContext.getString(R.l.ezw));
                        } else {
                            bVar.nwb.setText(this.mContext.getString(R.l.ezx));
                        }
                    }
                    bVar.nwc.setVisibility(8);
                    return view;
                } else if (i == this.nvG && !this.nvE) {
                    int i6 = 1;
                    if (view == null) {
                        bVar2 = new b(this);
                        view = this.Du.inflate(R.i.dhK, viewGroup, false);
                        bVar2.nvX = (LinearLayout) view.findViewById(R.h.chd);
                        bVar2.nvY = (TextView) view.findViewById(R.h.chc);
                        bVar2.nvZ = view.findViewById(R.h.ciH);
                        bVar2.nwb = (TextView) view.findViewById(R.h.ciI);
                        bVar2.nwa = (ImageView) view.findViewById(R.h.ciG);
                        bVar2.nwc = view.findViewById(R.h.clk);
                        bVar2.nvZ.setOnClickListener(/* anonymous class already generated */);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    if (obj == null && this.nvE) {
                        bVar.nvY.setVisibility(8);
                        bVar.nvZ.setVisibility(0);
                        bVar.nwa.setImageResource(R.k.dAC);
                        bVar.nwb.setText(this.mContext.getString(R.l.ezx));
                        bVar.nvX.setVisibility(8);
                        if (!this.nvH || this.nvI) {
                            bVar.nwc.setVisibility(8);
                        } else {
                            bVar.nwc.setVisibility(0);
                        }
                    } else {
                        bVar.nvX.setVisibility(0);
                        list = (List) this.nvC.get(i);
                        i3 = ((c) list.get(0)).nwd.type;
                        if (list.size() > 0) {
                            i4 = ((c) list.get(0)).nwd.type;
                            if (this.nvj == null) {
                                charSequence = null;
                            } else {
                                obj2 = (String) this.nvj.get(i4);
                            }
                            if (bg.mA(charSequence)) {
                                if (i != 0) {
                                    if (((ArrayList) this.nvC.get(i - 1)).size() > 0 && i4 != ((c) ((ArrayList) this.nvC.get(i - 1)).get(0)).nwd.type) {
                                    }
                                }
                                if (obj3 == null) {
                                    bVar.nvY.setText(charSequence);
                                    bVar.nvY.setVisibility(0);
                                } else {
                                    bVar.nvY.setVisibility(8);
                                }
                            }
                            obj3 = null;
                            if (obj3 == null) {
                                bVar.nvY.setVisibility(8);
                            } else {
                                bVar.nvY.setText(charSequence);
                                bVar.nvY.setVisibility(0);
                            }
                        } else {
                            bVar.nvY.setVisibility(8);
                        }
                        viewGroup2 = bVar.nvX;
                        viewGroup2.setFocusable(true);
                        i2 = 0;
                        while (i2 < 3) {
                            if (i2 < viewGroup2.getChildCount() || viewGroup2.getChildAt(i2) == null) {
                                aVar = new a(this);
                                inflate = this.Du.inflate(R.i.dhM, viewGroup2, false);
                                aVar.nvM = inflate.findViewById(R.h.chh);
                                aVar.nvN = (ImageView) inflate.findViewById(R.h.chg);
                                aVar.nvP = (TextView) inflate.findViewById(R.h.chj);
                                aVar.nvQ = (TextView) inflate.findViewById(R.h.chf);
                                aVar.nvO = (ImageView) inflate.findViewById(R.h.cnQ);
                                aVar.nvT = (ImageView) inflate.findViewById(R.h.bJS);
                                aVar.nvU = (ImageView) inflate.findViewById(R.h.bJQ);
                                aVar.nvV = (ImageView) inflate.findViewById(R.h.bJJ);
                                aVar.nvW = (ImageView) inflate.findViewById(R.h.bJM);
                                inflate.setTag(aVar);
                                if (i2 < list.size()) {
                                    a(inflate, (c) list.get(i2));
                                } else {
                                    inflate.setFocusable(true);
                                    aVar2 = (a) inflate.getTag();
                                    aVar2.nvM.setVisibility(8);
                                    inflate.setOnClickListener(null);
                                    inflate.setEnabled(false);
                                    inflate.setClickable(false);
                                    a(aVar2);
                                }
                                viewGroup2.addView(inflate, new LayoutParams(-2, a.aIR(), 1.0f));
                            } else {
                                View childAt = viewGroup2.getChildAt(i2);
                                childAt.setVisibility(0);
                                if (i2 < list.size()) {
                                    a(childAt, (c) list.get(i2));
                                } else {
                                    viewGroup2.getChildAt(i2).setFocusable(true);
                                    viewGroup2.getChildAt(i2).setOnClickListener(null);
                                    aVar2 = (a) viewGroup2.getChildAt(i2).getTag();
                                    aVar2.nvM.setVisibility(8);
                                    childAt.setEnabled(false);
                                    childAt.setClickable(false);
                                    a(aVar2);
                                }
                            }
                            i2++;
                        }
                        if (obj != null) {
                            bVar.nvY.setVisibility(8);
                            bVar.nvZ.setVisibility(0);
                            bVar.nwa.setImageResource(R.k.dAD);
                            if (this.nvE) {
                                bVar.nwb.setText(this.mContext.getString(R.l.ezx));
                            } else {
                                bVar.nwb.setText(this.mContext.getString(R.l.ezw));
                            }
                        } else {
                            bVar.nvZ.setVisibility(8);
                        }
                        bVar.nwc.setVisibility(8);
                    }
                    return view;
                }
            }
        }
        obj = null;
        if (view == null) {
            bVar2 = new b(this);
            view = this.Du.inflate(R.i.dhK, viewGroup, false);
            bVar2.nvX = (LinearLayout) view.findViewById(R.h.chd);
            bVar2.nvY = (TextView) view.findViewById(R.h.chc);
            bVar2.nvZ = view.findViewById(R.h.ciH);
            bVar2.nwb = (TextView) view.findViewById(R.h.ciI);
            bVar2.nwa = (ImageView) view.findViewById(R.h.ciG);
            bVar2.nwc = view.findViewById(R.h.clk);
            bVar2.nvZ.setOnClickListener(/* anonymous class already generated */);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (obj == null) {
        }
        bVar.nvX.setVisibility(0);
        list = (List) this.nvC.get(i);
        i3 = ((c) list.get(0)).nwd.type;
        if (list.size() > 0) {
            i4 = ((c) list.get(0)).nwd.type;
            if (this.nvj == null) {
                charSequence = null;
            } else {
                obj2 = (String) this.nvj.get(i4);
            }
            if (bg.mA(charSequence)) {
                if (i != 0) {
                }
                if (obj3 == null) {
                    bVar.nvY.setText(charSequence);
                    bVar.nvY.setVisibility(0);
                } else {
                    bVar.nvY.setVisibility(8);
                }
            }
            obj3 = null;
            if (obj3 == null) {
                bVar.nvY.setVisibility(8);
            } else {
                bVar.nvY.setText(charSequence);
                bVar.nvY.setVisibility(0);
            }
        } else {
            bVar.nvY.setVisibility(8);
        }
        viewGroup2 = bVar.nvX;
        viewGroup2.setFocusable(true);
        i2 = 0;
        while (i2 < 3) {
            if (i2 < viewGroup2.getChildCount()) {
            }
            aVar = new a(this);
            inflate = this.Du.inflate(R.i.dhM, viewGroup2, false);
            aVar.nvM = inflate.findViewById(R.h.chh);
            aVar.nvN = (ImageView) inflate.findViewById(R.h.chg);
            aVar.nvP = (TextView) inflate.findViewById(R.h.chj);
            aVar.nvQ = (TextView) inflate.findViewById(R.h.chf);
            aVar.nvO = (ImageView) inflate.findViewById(R.h.cnQ);
            aVar.nvT = (ImageView) inflate.findViewById(R.h.bJS);
            aVar.nvU = (ImageView) inflate.findViewById(R.h.bJQ);
            aVar.nvV = (ImageView) inflate.findViewById(R.h.bJJ);
            aVar.nvW = (ImageView) inflate.findViewById(R.h.bJM);
            inflate.setTag(aVar);
            if (i2 < list.size()) {
                a(inflate, (c) list.get(i2));
            } else {
                inflate.setFocusable(true);
                aVar2 = (a) inflate.getTag();
                aVar2.nvM.setVisibility(8);
                inflate.setOnClickListener(null);
                inflate.setEnabled(false);
                inflate.setClickable(false);
                a(aVar2);
            }
            viewGroup2.addView(inflate, new LayoutParams(-2, a.aIR(), 1.0f));
            i2++;
        }
        if (obj != null) {
            bVar.nvY.setVisibility(8);
            bVar.nvZ.setVisibility(0);
            bVar.nwa.setImageResource(R.k.dAD);
            if (this.nvE) {
                bVar.nwb.setText(this.mContext.getString(R.l.ezx));
            } else {
                bVar.nwb.setText(this.mContext.getString(R.l.ezw));
            }
        } else {
            bVar.nvZ.setVisibility(8);
        }
        bVar.nwc.setVisibility(8);
        return view;
    }

    private static void a(a aVar) {
        aVar.nvU.setVisibility(4);
    }

    final boolean aIU() {
        if (this.nvC.size() > 3) {
            ArrayList arrayList = (ArrayList) this.nvC.get(3);
            if (arrayList != null && arrayList.size() > 0) {
                int i = ((c) arrayList.get(0)).nwd.type;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.nwd.type != i) {
                        break;
                    } else if (a(cVar.nwd)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(MallFunction mallFunction) {
        if (mallFunction.rID == null || bg.mA(mallFunction.rID.rIL) || !b(mallFunction) || com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Id(mallFunction.oKW) == null) {
            return false;
        }
        return true;
    }

    private void a(View view, c cVar) {
        if (view != null) {
            a aVar = (a) view.getTag();
            final MallFunction mallFunction = cVar.nwd;
            final int i = cVar.nwe;
            aVar.nvS = mallFunction.nvS;
            aVar.nvR = mallFunction.nvR;
            com.tencent.mm.plugin.mall.b.a.f(aVar.nvN, aVar.nvR, R.k.dxB);
            aVar.nvP.setText(mallFunction.fXa);
            aVar.nvO.setVisibility(8);
            if (mallFunction.rID == null || bg.mA(mallFunction.rID.rIL) || !b(mallFunction)) {
                if (mallFunction.rID == null || mallFunction.rID.rIQ != 1) {
                    aVar.nvQ.setText("");
                    aVar.nvQ.setVisibility(4);
                } else {
                    aVar.nvQ.setText(mallFunction.rID.rIL);
                    aVar.nvQ.setVisibility(0);
                }
                aVar.nvO.setImageBitmap(null);
                aVar.nvO.setVisibility(8);
            } else {
                if (com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Id(mallFunction.oKW) != null) {
                    w.w("MicroMsg.FunctionListAdapter", "show the news : " + com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Id(mallFunction.oKW).rIL);
                    aVar.nvQ.setText(mallFunction.rID.rIL);
                    aVar.nvQ.setVisibility(0);
                } else {
                    aVar.nvQ.setVisibility(4);
                }
                com.tencent.mm.plugin.mall.b.a.i(aVar.nvO, aVar.nvS);
                aVar.nvO.setVisibility(0);
                String str = mallFunction.oKW;
            }
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b nvJ;

                public final void onClick(View view) {
                    w.v("MicroMsg.FunctionListAdapter", "on Click");
                    if (this.nvJ.nvD != null) {
                        this.nvJ.nvD.a(i, mallFunction);
                    }
                }
            });
            aVar.nvM.setVisibility(0);
            view.setEnabled(true);
            view.setClickable(true);
            aVar.nvU.setVisibility(0);
            aVar.nvV.setVisibility(0);
        }
    }

    private static boolean b(MallFunction mallFunction) {
        MallNews Id = com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Id(mallFunction.oKW);
        if (Id == null || bg.mA(Id.qSx) || !Id.qSx.equals(mallFunction.rID.qSx)) {
            w.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[]{mallFunction.rID.qSx, mallFunction.fXa});
            com.tencent.mm.plugin.wallet_core.model.mall.d buG = com.tencent.mm.plugin.wallet_core.model.mall.d.buG();
            Id = mallFunction.rID;
            if (Id == null) {
                w.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            } else {
                Id.rIR = "<sysmsg><mallactivitynew><functionid>" + Id.rIK + "</functionid><activityid>" + Id.qSx + "</activityid><type>" + Id.type + "</type><showflag>" + Id.rII + "</showflag><newsTipFlag>" + Id.rIJ + "</newsTipFlag></mallactivitynew></sysmsg>;";
                buG.rIU.put(Id.rIK, Id);
                buG.aTl();
            }
            return true;
        } else if (Id == null) {
            return false;
        } else {
            if ("0".equals(Id.rII)) {
                w.d("MicroMsg.FunctionListAdapter", "still old news and should show");
                return true;
            }
            w.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            return false;
        }
    }
}
