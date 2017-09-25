package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.r;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a extends e<String, f> implements com.tencent.mm.sdk.e.m.b {
    public static final ColorStateList mZI = com.tencent.mm.bg.a.S(ab.getContext(), R.e.aVa);
    public static final ColorStateList mZJ = com.tencent.mm.bg.a.S(ab.getContext(), R.e.aUo);
    com.tencent.mm.ui.applet.b hBe = null;
    private String isw = "";
    protected List<String> jBA = null;
    protected MMSlideDelView.f jVY;
    protected c jVZ;
    protected d jWb = MMSlideDelView.bSo();
    private boolean kau = false;
    OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ a vVk;

        {
            this.vVk = r1;
        }

        public final void onClick(View view) {
            w.v("MicroMsg.AddressAdapter", "on delView clicked");
            this.vVk.jWb.aFi();
            if (this.vVk.nWW != null) {
                this.vVk.nWW.aQ(((ViewStub) this.vVk.vVg.get(view)).getTag());
            }
        }
    };
    protected MMSlideDelView.e nWW;
    StringBuilder sb = new StringBuilder(32);
    private int type;
    public HashMap<String, f> vUO = new HashMap();
    protected String vUP = null;
    protected String vUQ = null;
    private List<Object> vUR;
    private List<String> vUS;
    private int vUT = 0;
    protected int[] vUU;
    String[] vUV;
    protected com.tencent.mm.ui.contact.AddressUI.a vUW;
    private Set<Integer> vUX = new HashSet();
    private int vUY = 0;
    private boolean vUZ = true;
    a vVa;
    private boolean vVb = false;
    boolean vVc = false;
    private String vVd;
    LinkedList<View> vVe = new LinkedList();
    boolean vVf;
    HashMap<View, ViewStub> vVg = new HashMap();
    private SparseArray<String> vVh = new SparseArray();
    private SparseArray<Integer> vVi = new SparseArray();
    private HashSet<String> vVj = new HashSet();
    private String[] vvh = null;

    public interface a {
    }

    protected static class b {
        public TextView mTs;
        public TextView mTt;
        public AddressView mZN;
        public TextView vVl;
        public View vVm;
    }

    public final /* synthetic */ com.tencent.mm.bj.a.a bNP() {
        return new f();
    }

    public final /* synthetic */ void o(Object obj, int i) {
        cU((String) obj, i);
    }

    public final void cU(String str, int i) {
        if (i == 5) {
            this.vVj.add(str);
        }
        super.o(str, i);
    }

    public final void pause() {
        this.vVj.clear();
        super.pause();
    }

    public final void notifyDataSetChanged() {
        this.vVd = m.xL();
        if (this.vUU == null) {
            bXH();
        }
        if (getCount() != 0) {
            this.vUY = bON();
            w.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", Integer.valueOf(this.vUY));
            super.notifyDataSetChanged();
        }
    }

    public a(Context context, String str, String str2, int i) {
        super(context);
        this.context = context;
        this.vUP = str;
        this.vUQ = str2;
        this.type = i;
        this.vVb = true;
        this.vUR = new LinkedList();
        this.vUS = new LinkedList();
        this.vVd = m.xL();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    }

    public final void l(Fragment fragment) {
        this.vUW = (com.tencent.mm.ui.contact.AddressUI.a) fragment;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.jVY = fVar;
    }

    public final void a(MMSlideDelView.e eVar) {
        this.nWW = eVar;
    }

    public final void a(c cVar) {
        this.jVZ = cVar;
    }

    public final void cK(List<String> list) {
        if (this.type != 2) {
            list.add(m.xL());
        }
        ap.yY();
        ay AH = com.tencent.mm.u.c.wZ().AH("@t.qq.com");
        if (AH != null) {
            list.add(AH.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : o.yu()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.jBA = list;
    }

    public final int getPositionForSection(int i) {
        if (this.vUU != null && i >= 0 && i < this.vUU.length) {
            i = this.vUU[i];
        }
        return this.vUY + i;
    }

    private boolean bXG() {
        return this.vUP.equals("@micromsg.qq.com") || this.vUP.equals("@all.contact.without.chatroom");
    }

    protected final void bXH() {
        int count = getCount();
        if (count != 0) {
            int i;
            int i2;
            this.vUY = bON();
            if (this.vvh != null) {
                this.vUU = o.a(this.vUP, this.vUQ, this.jBA, this.vvh);
                this.vUV = o.a(this.vUP, this.vUQ, this.vvh, this.jBA);
            } else if (bNL()) {
                long currentTimeMillis = System.currentTimeMillis();
                HashSet hashSet = new HashSet();
                this.vUU = new int[30];
                this.vUV = new String[30];
                i = this.vUY;
                int i3 = 0;
                while (i < count) {
                    f fVar = (f) yQ(i);
                    if (fVar != null) {
                        String b = b(fVar, i);
                        if (hashSet.add(b)) {
                            this.vUU[i3] = i - this.vUY;
                            this.vUV[i3] = b;
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    } else {
                        w.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                        i2 = i3;
                    }
                    i++;
                    i3 = i2;
                }
                w.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.vUY);
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.vUU = o.a(this.vUP, this.vUQ, this.jBA, this.isw);
                this.vUV = o.a(this.vUP, this.vUQ, this.isw, this.jBA);
                w.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            this.vUX.clear();
            for (int i4 : this.vUU) {
                this.vUX.add(Integer.valueOf(i4 - 1));
            }
        }
    }

    public final void bXI() {
        this.jWb.aFi();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2 = -1;
        if (!this.vVf) {
            for (int i3 = 0; i3 < 8; i3++) {
                this.vVe.add(r.eC(this.context).inflate(R.i.cTH, null));
            }
            this.vVf = true;
        }
        f fVar = (f) yQ(i);
        if (view == null) {
            View view2;
            if (this.vVe.size() > 0) {
                View view3 = (View) this.vVe.getFirst();
                this.vVe.removeFirst();
                view2 = view3;
            } else {
                view2 = View.inflate(this.context, R.i.cTH, null);
            }
            bVar = new b();
            bVar.mTs = (TextView) view2.findViewById(R.h.bGk);
            bVar.mTt = (TextView) view2.findViewById(R.h.bGp);
            bVar.mZN = (AddressView) view2.findViewById(R.h.cmk);
            bVar.vVl = (TextView) view2.findViewById(R.h.bGh);
            bVar.vVm = view2.findViewById(R.h.bGo);
            LayoutParams layoutParams = bVar.vVm.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bg.a.U(this.context, R.f.aWM)) * com.tencent.mm.bg.a.dL(this.context));
            bVar.vVm.setLayoutParams(layoutParams);
            this.vUW.ktu.a(bVar.mZN);
            view2.setTag(bVar);
            view = view2;
        } else {
            bVar = (b) view.getTag();
        }
        if (fVar != null) {
            CharSequence b;
            String eZ;
            Context context;
            long longValue;
            String str;
            Object obj;
            f fVar2 = (f) yQ(i - 1);
            f fVar3 = (f) yQ(i + 1);
            int a = fVar2 == null ? -1 : a(fVar2, i - 1);
            int a2 = a(fVar, i);
            if (fVar3 != null) {
                i2 = a(fVar3, i + 1);
            }
            if (this.vUZ) {
                if (i == 0) {
                    b = b(fVar, i);
                    if (!u.mA(b)) {
                        bVar.mTs.setVisibility(0);
                        bVar.mTs.setText(b);
                        if (!this.vUZ || a2 == r3) {
                            bVar.vVm.setBackgroundResource(R.g.bgh);
                        }
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.mZN, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.mZN.setMaskBitmap(null);
                        } else if (com.tencent.mm.u.ag.a.hlU != null) {
                            eZ = com.tencent.mm.u.ag.a.hlU.eZ(fVar.field_verifyFlag);
                            if (eZ != null) {
                                bVar.mZN.setMaskBitmap(l.ik(eZ));
                            } else {
                                bVar.mZN.setMaskBitmap(null);
                            }
                        } else {
                            bVar.mZN.setMaskBitmap(null);
                        }
                        bVar.mZN.updateTextColors();
                        b = fVar.uyS;
                        if (b == null) {
                            try {
                                context = this.context;
                                if (fVar.field_conRemark != null || fVar.field_conRemark.trim().equals("")) {
                                    b = com.tencent.mm.j.a.dM(fVar.field_username);
                                    if (b == null) {
                                        if (fVar.field_nickname != null || fVar.field_nickname.length() <= 0) {
                                            b = fVar.field_alias;
                                            if (bg.mA(b)) {
                                                b = fVar.field_username;
                                                if (b != null) {
                                                    b = null;
                                                } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                                                    b = "@" + b.replace("@t.qq.com", "");
                                                } else if (b.toLowerCase().endsWith("@qqim")) {
                                                    b = b.replace("@qqim", "");
                                                    longValue = Long.valueOf(b).longValue();
                                                    if (longValue < 0) {
                                                        b = new com.tencent.mm.a.o(longValue).toString();
                                                    }
                                                }
                                                if (b == null || b.length() == 0) {
                                                    b = fVar.field_username;
                                                }
                                            }
                                        } else {
                                            b = fVar.field_nickname;
                                        }
                                    }
                                } else {
                                    b = fVar.field_conRemark;
                                }
                                str = fVar.field_username;
                                if (b == null || b.length() <= 0) {
                                    obj = str;
                                }
                                str = "";
                                if (str.length() > 0 && !str.equals(b)) {
                                    this.sb.append(b);
                                    this.sb.append("(");
                                    this.sb.append(str);
                                    this.sb.append(")");
                                    b = this.sb.toString();
                                    this.sb.delete(0, this.sb.length());
                                }
                                b = h.c(context, b, com.tencent.mm.bg.a.T(this.context, R.f.aXI));
                            } catch (Exception e) {
                                b = null;
                            }
                            if (b == null) {
                                b = "";
                            }
                            bVar.mZN.setName(b);
                        } else {
                            bVar.mZN.setName(b);
                        }
                        bVar.mZN.setDescription(u.mz(fVar.field_remarkDesc));
                    }
                } else if (i > 0 && a2 != a) {
                    b = b(fVar, i);
                    if (!u.mA(b)) {
                        bVar.mTs.setVisibility(0);
                        bVar.mTs.setText(b);
                        bVar.vVm.setBackgroundResource(R.g.bgh);
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.mZN, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.mZN.setMaskBitmap(null);
                        } else if (com.tencent.mm.u.ag.a.hlU != null) {
                            bVar.mZN.setMaskBitmap(null);
                        } else {
                            eZ = com.tencent.mm.u.ag.a.hlU.eZ(fVar.field_verifyFlag);
                            if (eZ != null) {
                                bVar.mZN.setMaskBitmap(null);
                            } else {
                                bVar.mZN.setMaskBitmap(l.ik(eZ));
                            }
                        }
                        bVar.mZN.updateTextColors();
                        b = fVar.uyS;
                        if (b == null) {
                            bVar.mZN.setName(b);
                        } else {
                            context = this.context;
                            if (fVar.field_conRemark != null) {
                            }
                            b = com.tencent.mm.j.a.dM(fVar.field_username);
                            if (b == null) {
                                if (fVar.field_nickname != null) {
                                }
                                b = fVar.field_alias;
                                if (bg.mA(b)) {
                                    b = fVar.field_username;
                                    if (b != null) {
                                        b = null;
                                    } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                                        b = "@" + b.replace("@t.qq.com", "");
                                    } else if (b.toLowerCase().endsWith("@qqim")) {
                                        b = b.replace("@qqim", "");
                                        longValue = Long.valueOf(b).longValue();
                                        if (longValue < 0) {
                                            b = new com.tencent.mm.a.o(longValue).toString();
                                        }
                                    }
                                    b = fVar.field_username;
                                }
                            }
                            str = fVar.field_username;
                            obj = str;
                            str = "";
                            this.sb.append(b);
                            this.sb.append("(");
                            this.sb.append(str);
                            this.sb.append(")");
                            b = this.sb.toString();
                            this.sb.delete(0, this.sb.length());
                            b = h.c(context, b, com.tencent.mm.bg.a.T(this.context, R.f.aXI));
                            if (b == null) {
                                b = "";
                            }
                            bVar.mZN.setName(b);
                        }
                        bVar.mZN.setDescription(u.mz(fVar.field_remarkDesc));
                    }
                }
            }
            bVar.mTs.setVisibility(8);
            bVar.vVm.setBackgroundResource(R.g.bgh);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.mZN, fVar.field_username);
            if (fVar.field_verifyFlag != 0) {
                bVar.mZN.setMaskBitmap(null);
            } else if (com.tencent.mm.u.ag.a.hlU != null) {
                eZ = com.tencent.mm.u.ag.a.hlU.eZ(fVar.field_verifyFlag);
                if (eZ != null) {
                    bVar.mZN.setMaskBitmap(l.ik(eZ));
                } else {
                    bVar.mZN.setMaskBitmap(null);
                }
            } else {
                bVar.mZN.setMaskBitmap(null);
            }
            bVar.mZN.updateTextColors();
            b = fVar.uyS;
            if (b == null) {
                context = this.context;
                if (fVar.field_conRemark != null) {
                }
                b = com.tencent.mm.j.a.dM(fVar.field_username);
                if (b == null) {
                    if (fVar.field_nickname != null) {
                    }
                    b = fVar.field_alias;
                    if (bg.mA(b)) {
                        b = fVar.field_username;
                        if (b != null) {
                            b = null;
                        } else if (!b.toLowerCase().endsWith("@t.qq.com")) {
                            b = "@" + b.replace("@t.qq.com", "");
                        } else if (b.toLowerCase().endsWith("@qqim")) {
                            b = b.replace("@qqim", "");
                            longValue = Long.valueOf(b).longValue();
                            if (longValue < 0) {
                                b = new com.tencent.mm.a.o(longValue).toString();
                            }
                        }
                        b = fVar.field_username;
                    }
                }
                str = fVar.field_username;
                obj = str;
                str = "";
                this.sb.append(b);
                this.sb.append("(");
                this.sb.append(str);
                this.sb.append(")");
                b = this.sb.toString();
                this.sb.delete(0, this.sb.length());
                b = h.c(context, b, com.tencent.mm.bg.a.T(this.context, R.f.aXI));
                if (b == null) {
                    b = "";
                }
                bVar.mZN.setName(b);
            } else {
                bVar.mZN.setName(b);
            }
            bVar.mZN.setDescription(u.mz(fVar.field_remarkDesc));
        }
        bVar.mZN.updatePositionFlag();
        bVar.mZN.setContentDescription(bVar.mZN.getNickName() == null ? "" : bVar.mZN.getNickName().toString());
        return view;
    }

    private int a(f fVar, int i) {
        if (i < this.vUY) {
            return 32;
        }
        if (fVar != null) {
            return fVar.field_showHead;
        }
        w.e("MicroMsg.AddressAdapter", "contact is null, position:%d", Integer.valueOf(i));
        return -1;
    }

    private String b(f fVar, int i) {
        if (i < this.vUY) {
            return getString(R.l.dCA);
        }
        if (fVar.field_showHead == 31) {
            return "";
        }
        if (fVar.field_showHead == 123) {
            return "#";
        }
        if (fVar.field_showHead == 33) {
            return getString(R.l.dCo);
        }
        if (fVar.field_showHead == 43) {
            return getString(R.l.eMB);
        }
        if (fVar.field_showHead == 32) {
            return getString(R.l.dCA);
        }
        String str = (String) this.vVh.get(fVar.field_showHead);
        if (str != null) {
            return str;
        }
        str = String.valueOf((char) fVar.field_showHead);
        this.vVh.put(fVar.field_showHead, str);
        return str;
    }

    public final int getCount() {
        return super.getCount();
    }

    private String getString(int i) {
        String str = (String) this.vVh.get(i);
        if (str != null) {
            return str;
        }
        str = this.context.getString(i);
        this.vVh.put(i, str);
        return str;
    }

    public final com.tencent.mm.bj.a.d<String> bOO() {
        long currentTimeMillis = System.currentTimeMillis();
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        ap.yY();
        Cursor a = com.tencent.mm.u.c.wR().a(this.vUP, this.vUQ, this.jBA, linkedList, bXG(), this.vVb);
        w.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        return (com.tencent.mm.bj.a.d) a;
    }

    public final ArrayList<f> ai(ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add((String) arrayList.get(i));
        }
        ArrayList<f> arrayList3 = new ArrayList(arrayList2.size());
        ap.yY();
        Cursor cd = com.tencent.mm.u.c.wR().cd(arrayList2);
        while (cd.moveToNext()) {
            f fVar = new f();
            fVar.b(cd);
            arrayList3.add(fVar);
        }
        cd.close();
        w.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList3;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.e.b<String, f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        SparseArray<String>[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        Cursor b = com.tencent.mm.u.c.wR().b(this.vUP, this.vUQ, this.jBA, linkedList, bXG(), this.vVb);
        int i;
        if (b instanceof com.tencent.mm.bj.a.e) {
            com.tencent.mm.bj.a.d[] dVarArr = ((com.tencent.mm.bj.a.e) b).uMz;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2].yR(Downloads.MIN_RETYR_AFTER);
                sparseArrayArr2[i2] = new SparseArray();
                i = 0;
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, dVarArr[i2].getString(0));
                    i++;
                }
            }
            this.vUY = dVarArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray();
            i = 0;
            while (b.moveToNext()) {
                sparseArrayArr2[0].put(i, b.getString(0));
                i++;
            }
        }
        b.close();
        w.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        return sparseArrayArr2;
    }

    public final void bXJ() {
        super.o(null, 1);
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        ap.yY();
        if (mVar != com.tencent.mm.u.c.wR()) {
            return;
        }
        if (o.eT((String) obj) || this.vVj.contains((String) obj)) {
            w.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            return;
        }
        super.o((String) obj, 2);
        if (this.vVc && this.vUW != null) {
            this.vUW.vVF = true;
            w.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
        }
    }
}
