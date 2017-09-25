package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ap extends com.tencent.mm.ui.base.AnimatedExpandableListView.a {
    public static int[] qCJ = new int[]{j.pLC, j.pLA, j.pLw, j.pLp};
    public static int[] qDf = new int[]{j.pLD, j.pLB, j.pLx, j.pLq};
    private LayoutInflater Du;
    private Context mContext;
    ArrayList<String> qDg;
    public int qDh = 0;
    public boolean qDi = false;
    public ArrayList<String> qDj = new ArrayList();
    public ArrayList<String> qDk = new ArrayList();
    public ArrayList<String> qDl = new ArrayList();
    public ArrayList<String> qDm = new ArrayList();
    public int style;

    private class a {
        TextView nhP;
        ImageView nvU;
        TextView qDn;
        TextView qDo;
        final /* synthetic */ ap qDp;
        TextView titleView;

        public a(ap apVar) {
            this.qDp = apVar;
        }
    }

    public ap(Context context) {
        this.mContext = context;
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final Object getChild(int i, int i2) {
        return this.qDg.get(i2);
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    public final void S(ArrayList<String> arrayList) {
        List<String> bkD = bkD();
        Object arrayList2 = new ArrayList();
        if (!(bkD == null || arrayList == null)) {
            for (String str : bkD) {
                if (i(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            String str2 = bg.c(arrayList2, ",");
            h.vJ();
            h.vI().vr().set(335875, str2);
        }
        this.qDg = arrayList;
    }

    private static List<String> bkD() {
        h.vJ();
        String str = (String) h.vI().vr().get(335875, null);
        w.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[]{str});
        if (bg.mA(str)) {
            return null;
        }
        return bg.f(str.split(","));
    }

    public static void GS(String str) {
        w.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[]{str});
        if (bkD() != null) {
            List arrayList = new ArrayList(bkD());
            if (!i(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                String c = bg.c(arrayList, ",");
                h.vJ();
                h.vI().vr().set(335875, c);
                return;
            }
            return;
        }
        h.vJ();
        h.vI().vr().set(335875, str);
    }

    private CharSequence GT(String str) {
        List<String> zh = com.tencent.mm.plugin.label.a.a.aFG().zh(com.tencent.mm.plugin.label.a.a.aFG().ze(str));
        if (zh == null || zh.size() == 0) {
            return "";
        }
        List arrayList = new ArrayList(zh.size());
        for (String eK : zh) {
            arrayList.add(((com.tencent.mm.plugin.messenger.a.a) h.h(com.tencent.mm.plugin.messenger.a.a.class)).eK(eK));
        }
        return com.tencent.mm.pluginsdk.ui.d.h.a(this.mContext, bg.c(arrayList, ","));
    }

    private static boolean i(List<String> list, String str) {
        for (String equals : list) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean aq(int i, String str) {
        if (i == 1) {
            return i(this.qDj, str);
        }
        return i(this.qDk, str);
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.Du.inflate(g.pHI, null);
            } else {
                inflate = this.Du.inflate(g.pHH, null);
            }
            a aVar2 = new a(this);
            aVar2.titleView = (TextView) inflate.findViewById(f.pFa);
            aVar2.nvU = (ImageView) inflate.findViewById(f.pEW);
            aVar2.nhP = (TextView) inflate.findViewById(f.pEZ);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(qCJ[i]);
        aVar.nhP.setText(qDf[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.qDh == i) {
                    aVar.nvU.setImageResource(i.dze);
                    aVar.nvU.setContentDescription(this.mContext.getString(j.pJV));
                    break;
                }
                aVar.nvU.setImageResource(i.dzd);
                break;
            case 2:
                if (this.qDh == i) {
                    aVar.nvU.setImageResource(i.dze);
                    aVar.nvU.setContentDescription(this.mContext.getString(j.pJV));
                    break;
                }
                aVar.nvU.setImageResource(i.dzd);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.qDh == i) {
                        aVar.nvU.setImageResource(i.pJb);
                        aVar.nvU.setContentDescription(this.mContext.getString(j.pJV));
                        break;
                    }
                    aVar.nvU.setImageResource(i.dzd);
                    break;
                } else if (this.qDh == i) {
                    aVar.nvU.setImageResource(i.pJc);
                    aVar.nvU.setContentDescription(this.mContext.getString(j.pJV));
                    break;
                } else {
                    aVar.nvU.setImageResource(i.dzd);
                    break;
                }
        }
        if (!this.qDi || i != 1) {
            return view;
        }
        view = new View(this.mContext);
        view.setVisibility(8);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private static List<String> ae(List<String> list) {
        List<String> linkedList = new LinkedList();
        h.vJ();
        if (!h.vG().uV()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            h.vJ();
            com.tencent.mm.j.a Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(obj2);
            if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                obj2 = Rc.tL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final View a(int i, int i2, View view) {
        a aVar;
        if (view == null) {
            View inflate;
            if (this.style == 1) {
                inflate = this.Du.inflate(g.pHG, null);
            } else {
                inflate = this.Du.inflate(g.pHF, null);
            }
            a aVar2 = new a(this);
            aVar2.titleView = (TextView) inflate.findViewById(f.pFa);
            aVar2.nhP = (TextView) inflate.findViewById(f.pEZ);
            aVar2.qDn = (TextView) inflate.findViewById(f.pEY);
            aVar2.qDo = (TextView) inflate.findViewById(f.pEX);
            aVar2.nvU = (ImageView) inflate.findViewById(f.pEW);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (i2 == this.qDg.size()) {
            aVar.titleView.setVisibility(8);
            aVar.nhP.setVisibility(8);
            aVar.nvU.setVisibility(8);
            aVar.qDn.setVisibility(0);
            aVar.qDo.setVisibility(0);
            if (i == 3) {
                if (this.qDm.size() > 0) {
                    aVar.qDo.setText("√" + bg.c(ae(this.qDm), ","));
                    aVar.qDo.setVisibility(0);
                    aVar.qDo.setTextColor(this.mContext.getResources().getColor(c.pze));
                } else {
                    aVar.qDo.setText("");
                    aVar.qDo.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.qDl.size() > 0) {
                    aVar.qDo.setText("√" + bg.c(ae(this.qDl), ","));
                    aVar.qDo.setVisibility(0);
                    aVar.qDo.setTextColor(this.mContext.getResources().getColor(c.pzd));
                } else {
                    aVar.qDo.setText("");
                    aVar.qDo.setVisibility(8);
                }
            }
        } else {
            aVar.titleView.setVisibility(0);
            aVar.nhP.setVisibility(0);
            aVar.nvU.setVisibility(0);
            aVar.qDn.setVisibility(8);
            aVar.qDo.setVisibility(8);
            String str = (String) this.qDg.get(i2);
            aVar.titleView.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this.mContext, str));
            aVar.nhP.setText(GT(str));
            aVar.nvU.setVisibility(0);
            if (this.style == 1) {
                if (i == 2) {
                    if (aq(1, str)) {
                        aVar.nvU.setImageResource(i.dzC);
                    } else {
                        aVar.nvU.setImageResource(i.dzD);
                    }
                } else if (i == 3) {
                    if (this.qDh != i) {
                        aVar.nvU.setImageResource(i.pJk);
                    } else {
                        aVar.nvU.setImageResource(i.pJj);
                    }
                    if (aq(2, str)) {
                        aVar.nvU.setImageResource(i.pJj);
                    } else {
                        aVar.nvU.setImageResource(i.pJk);
                    }
                }
            } else if (i == 2) {
                if (aq(1, str)) {
                    aVar.nvU.setImageResource(i.dvN);
                } else {
                    aVar.nvU.setImageResource(i.dvO);
                }
            } else if (i == 3) {
                if (aq(2, str)) {
                    aVar.nvU.setImageResource(i.pIQ);
                } else {
                    aVar.nvU.setImageResource(i.dvO);
                }
            }
        }
        return view;
    }

    public final int ua(int i) {
        if (i <= 1 || this.qDg == null) {
            return 0;
        }
        return this.qDg.size() + 1;
    }
}
