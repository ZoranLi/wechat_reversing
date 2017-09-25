package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.lb;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UnfamiliarContactDetailUI extends MMActivity implements com.tencent.mm.y.e {
    public static final String kxq = new String(Character.toChars(123));
    private p iLz = null;
    private ArrayList<b> iUM = new ArrayList();
    private View oEP;
    private boolean phP;
    private boolean phQ;
    private boolean phR;
    private RecyclerView pmE;
    private TextView pmF;
    private View pmG;
    private View pmH;
    private View pmI;
    private TextView pmJ;
    private a pmK;
    private RealAlphabetScrollBar pmL;
    HashMap<String, Integer> pmM = new HashMap();
    private HashMap<Integer, String> pmN = new HashMap();
    private HashSet<Integer> pmO = new HashSet();
    private d pmP;
    private int pmQ = -1;
    private HashSet<String> pmR = new HashSet();
    private com.tencent.mm.plugin.setting.b.a pmS;
    private boolean pmT;

    class a extends android.support.v7.widget.RecyclerView.a {
        final /* synthetic */ UnfamiliarContactDetailUI pmU;

        a(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
            this.pmU = unfamiliarContactDetailUI;
        }

        public final t a(ViewGroup viewGroup, int i) {
            return new c(this.pmU, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dpo, viewGroup, false));
        }

        public final void a(t tVar, int i) {
            if (tVar instanceof c) {
                int i2;
                c cVar = (c) tVar;
                cVar.pnf.setTag(Integer.valueOf(i));
                cVar.abf.setTag(Integer.valueOf(i));
                b bVar = (b) this.pmU.iUM.get(i);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) cVar.kwV.view, bVar.jiL.field_username);
                cVar.pnb.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.pmU.uSU.uTo, bVar.gMX, cVar.pnb.getTextSize()));
                cVar.pne.setVisibility(bVar.jiL.tF() ? 0 : 8);
                ImageView imageView = cVar.pnd;
                String str = bVar.jiL.field_username;
                if (m.pQD != null && this.pmU.pmR.size() == 0) {
                    this.pmU.pmR.addAll(m.pQD.dd(5));
                }
                if (this.pmU.pmR.contains(str)) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                if (this.pmU.pmN.containsKey(Integer.valueOf(i))) {
                    cVar.pnc.setVisibility(0);
                    cVar.pnc.setText((CharSequence) this.pmU.pmN.get(Integer.valueOf(i)));
                } else {
                    cVar.pnc.setVisibility(8);
                }
                if (this.pmU.pmT) {
                    cVar.png.setPadding(cVar.png.getPaddingLeft(), cVar.png.getPaddingTop(), 0, cVar.png.getPaddingBottom());
                    if (this.pmU.pmO.contains(Integer.valueOf(i))) {
                        cVar.mfD.setChecked(true);
                    } else {
                        cVar.mfD.setChecked(false);
                    }
                    cVar.pnf.setVisibility(0);
                    return;
                }
                cVar.png.setPadding(cVar.png.getPaddingLeft(), cVar.png.getPaddingTop(), (int) this.pmU.getResources().getDimension(R.f.aXw), cVar.png.getPaddingBottom());
                cVar.pnf.setVisibility(8);
            }
        }

        public final int getItemCount() {
            return this.pmU.iUM.size();
        }

        public final b su(int i) {
            if (this.pmU.iUM.size() > i) {
                return (b) this.pmU.iUM.get(i);
            }
            return new b(this.pmU, new x());
        }
    }

    class b {
        String gMX;
        x jiL;
        final /* synthetic */ UnfamiliarContactDetailUI pmU;
        String pna;

        public b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, x xVar) {
            this.pmU = unfamiliarContactDetailUI;
            this.jiL = xVar;
        }
    }

    class c extends t {
        View abf;
        MaskLayout kwV;
        CheckBox mfD;
        final /* synthetic */ UnfamiliarContactDetailUI pmU;
        TextView pnb;
        TextView pnc;
        ImageView pnd;
        ImageView pne;
        LinearLayout pnf;
        LinearLayout png;

        public c(final UnfamiliarContactDetailUI unfamiliarContactDetailUI, View view) {
            this.pmU = unfamiliarContactDetailUI;
            super(view);
            this.abf = view;
            this.kwV = (MaskLayout) view.findViewById(R.h.bEN);
            this.pnb = (TextView) view.findViewById(R.h.bFW);
            this.pnc = (TextView) view.findViewById(R.h.bEM);
            this.pnd = (ImageView) view.findViewById(R.h.bGd);
            this.pne = (ImageView) view.findViewById(R.h.bGe);
            this.pnf = (LinearLayout) view.findViewById(R.h.bCj);
            this.mfD = (CheckBox) view.findViewById(R.h.checkbox);
            this.png = (LinearLayout) view.findViewById(R.h.bZf);
            this.pnf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c pni;

                public final void onClick(View view) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    this.pni.mfD.setChecked(!this.pni.mfD.isChecked());
                    if (this.pni.mfD.isChecked()) {
                        this.pni.pmU.pmO.add(Integer.valueOf(intValue));
                    } else {
                        this.pni.pmU.pmO.remove(Integer.valueOf(intValue));
                    }
                    if (this.pni.pmU.pmO.size() == 0) {
                        this.pni.pmU.pmH.setEnabled(false);
                        this.pni.pmU.pmG.setEnabled(false);
                        return;
                    }
                    this.pni.pmU.pmH.setEnabled(true);
                    this.pni.pmU.pmG.setEnabled(true);
                }
            });
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c pni;

                public final void onClick(View view) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    b su = this.pni.pmU.pmK.su(intValue);
                    w.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[]{Integer.valueOf(intValue), su.gMX});
                    c cVar = this.pni;
                    if (su != null) {
                        if (cVar.pmU.pmT) {
                            f.pnt++;
                        } else {
                            f.pnu++;
                        }
                        String str = su.gMX;
                        String str2 = su.jiL.field_username;
                        String str3 = su.jiL.field_nickname;
                        if (bg.mA(str)) {
                            ap.yY();
                            bb AI = com.tencent.mm.u.c.wS().AI(str2);
                            if (!(AI == null || bg.mA(AI.field_encryptUsername))) {
                                str = AI.field_conRemark;
                            }
                        }
                        if (!bg.mA(str2)) {
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str2);
                            intent.putExtra("Contact_RemarkName", str);
                            intent.putExtra("Contact_Nick", str3);
                            com.tencent.mm.plugin.setting.a.imv.d(intent, cVar.pmU);
                            cVar.pmU.pmQ = intValue;
                        }
                    }
                }
            });
        }
    }

    class d implements Runnable {
        final /* synthetic */ UnfamiliarContactDetailUI pmU;
        g pnj;
        Collection<Integer> pnk;

        d(UnfamiliarContactDetailUI unfamiliarContactDetailUI, Collection<Integer> collection, g gVar) {
            this.pmU = unfamiliarContactDetailUI;
            this.pnk = collection;
            this.pnj = gVar;
        }

        public final void run() {
            LinkedList linkedList = new LinkedList();
            for (Integer intValue : this.pnk) {
                int intValue2 = intValue.intValue();
                if (this.pmU.pmK != null) {
                    af afVar = this.pmU.pmK.su(intValue2).jiL;
                    afVar.td();
                    ap.yY();
                    com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.c(afVar.field_username));
                    ay.a(afVar.field_username, null);
                    ap.yY();
                    com.tencent.mm.u.c.wR().a(afVar.field_username, afVar);
                    ap.yY();
                    com.tencent.mm.u.c.wW().Rl(afVar.field_username);
                }
                linkedList.add(this.pmU.pmK.su(intValue2));
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.pmU.iUM.remove((b) it.next());
            }
            this.pmU.bm(this.pmU.iUM);
            this.pmU.runOnUiThread(new Runnable(this) {
                final /* synthetic */ d pnl;

                {
                    this.pnl = r1;
                }

                public final void run() {
                    if (this.pnl.pnj != null) {
                        this.pnl.pnj.st(this.pnl.pmU.pmO.size());
                        this.pnl.pmU.pmO.clear();
                    }
                }
            });
        }
    }

    public enum e {
        OVER_ONE_MIN,
        NORMAL
    }

    static class f {
        static int pnp;
        static int pnq;
        static int pnr;
        static int pns;
        static int pnt;
        static int pnu;
    }

    interface g {
        void baA();

        void st(int i);
    }

    public interface h {
        void a(e eVar);

        void d(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, HashSet hashSet) {
        unfamiliarContactDetailUI.iUM.clear();
        Object linkedList = new LinkedList();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedList.add((String) it.next());
            i++;
            if (i % com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX == 0 || i == hashSet.size()) {
                Cursor cc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().cc(linkedList);
                if (cc != null) {
                    cc.moveToFirst();
                    while (!cc.isAfterLast()) {
                        af xVar = new x();
                        xVar.b(cc);
                        if (com.tencent.mm.j.a.ez(xVar.field_type)) {
                            String str;
                            b bVar = new b(unfamiliarContactDetailUI, xVar);
                            af afVar = bVar.jiL;
                            if (afVar == null) {
                                str = null;
                            } else {
                                str = afVar.field_nickname;
                                if (!bg.mA(afVar.field_conRemark)) {
                                    str = afVar.field_conRemark;
                                } else if (bg.mA(str)) {
                                    str = afVar.tK();
                                }
                            }
                            String str2 = "";
                            if (TextUtils.isEmpty(str)) {
                                w.w("MicroMsg.UnfamiliarContactUI", "[%s:%s]", new Object[]{xVar.field_username, xVar.field_nickname});
                            } else {
                                str2 = SpellMap.d(str.charAt(0));
                            }
                            str2 = bg.mA(str2) ? kxq : !str2.matches("[a-zA-Z]+$") ? kxq : str2.toLowerCase().substring(0, 1);
                            bVar.pna = str2;
                            bVar.gMX = str;
                            unfamiliarContactDetailUI.iUM.add(bVar);
                            cc.moveToNext();
                        } else {
                            w.d("MicroMsg.UnfamiliarContactUI", "contact:%s username:%s", new Object[]{xVar.field_nickname, xVar.field_username});
                            cc.moveToNext();
                        }
                    }
                    cc.close();
                }
                linkedList.clear();
            }
        }
        Collections.sort(unfamiliarContactDetailUI.iUM, new Comparator<b>(unfamiliarContactDetailUI) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((b) obj).pna.compareTo(((b) obj2).pna);
            }
        });
        unfamiliarContactDetailUI.bm(unfamiliarContactDetailUI.iUM);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i) {
        unfamiliarContactDetailUI.da(true);
        if (i == 0) {
            f.pns += hashSet.size();
        } else if (i == 1) {
            f.pnr += hashSet.size();
        }
        com.tencent.mm.sdk.f.e.post(new Runnable(unfamiliarContactDetailUI) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            public final void run() {
                List linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b su = this.pmU.pmK.su(((Integer) it.next()).intValue());
                    w.i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", new Object[]{su.jiL.field_username, Integer.valueOf(i)});
                    com.tencent.mm.sdk.b.b pdVar;
                    if (i == 0) {
                        pdVar = new pd();
                        pdVar.fWa.fWc = false;
                        pdVar.fWa.fWb = true;
                        pdVar.fWa.username = su.jiL.field_username;
                        com.tencent.mm.sdk.b.a.urY.m(pdVar);
                        linkedList.add(su.jiL.field_username);
                    } else if (i == 1) {
                        su.jiL.tr();
                        pdVar = new pd();
                        pdVar.fWa.fWc = true;
                        pdVar.fWa.fWb = false;
                        pdVar.fWa.username = su.jiL.field_username;
                        com.tencent.mm.sdk.b.a.urY.m(pdVar);
                        o.j(su.jiL);
                    }
                }
                if (linkedList.size() > 0) {
                    com.tencent.mm.sdk.b.b lbVar = new lb();
                    lbVar.fRI.fRK = linkedList;
                    lbVar.fRI.fJA = 1;
                    lbVar.fRI.fRJ = 5;
                    com.tencent.mm.sdk.b.a.urY.m(lbVar);
                    return;
                }
                this.pmU.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 pmW;

                    {
                        this.pmW = r1;
                    }

                    public final void run() {
                        this.pmW.pmU.pmK.aab.notifyChanged();
                        this.pmW.pmU.da(false);
                    }
                });
            }
        }, "handleSnsSetting");
    }

    static /* synthetic */ void b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.a.aRq);
            loadAnimation.setAnimationListener(new AnimationListener(unfamiliarContactDetailUI) {
                final /* synthetic */ UnfamiliarContactDetailUI pmU;

                {
                    this.pmU = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.pmU.oEP.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.oEP.startAnimation(loadAnimation);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.a.aRo);
            loadAnimation.setAnimationListener(new AnimationListener(unfamiliarContactDetailUI) {
                final /* synthetic */ UnfamiliarContactDetailUI pmU;

                {
                    this.pmU = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.pmU.oEP.setVisibility(8);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.oEP.startAnimation(loadAnimation);
        }
        unfamiliarContactDetailUI.pmT = z;
        if (unfamiliarContactDetailUI.pmT) {
            unfamiliarContactDetailUI.aB(1, unfamiliarContactDetailUI.getString(R.l.eYH));
            return;
        }
        unfamiliarContactDetailUI.aB(1, unfamiliarContactDetailUI.getString(R.l.eYK));
        ((CheckBox) unfamiliarContactDetailUI.pmI.findViewById(R.h.checkbox)).setChecked(false);
    }

    protected final int getLayoutId() {
        return R.i.doj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(291, this);
        this.phP = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.phQ = getIntent().getBooleanExtra("half_year_not_response", false);
        this.phR = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        KC();
        this.pmS = new com.tencent.mm.plugin.setting.b.a(this.phP, this.phQ, this.phR, new h(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;
            long start = System.currentTimeMillis();

            {
                this.pmU = r3;
            }

            public final void onSuccess() {
                w.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[]{Integer.valueOf(this.pmU.iUM.size()), Long.valueOf(System.currentTimeMillis() - this.start)});
                this.pmU.pmF.setText(this.pmU.getString(R.l.eYJ) + "(" + this.pmU.iUM.size() + ")");
                if (this.pmU.iUM.size() == 0) {
                    this.pmU.findViewById(R.h.cIE).setVisibility(0);
                    this.pmU.findViewById(R.h.ctp).setVisibility(8);
                    this.pmU.findViewById(R.h.cbs).setVisibility(8);
                    this.pmU.pmJ.setText(this.pmU.getString(R.l.ewm));
                    return;
                }
                this.pmU.findViewById(R.h.cIE).setVisibility(8);
                this.pmU.findViewById(R.h.cbs).setVisibility(0);
                if (this.pmU.pmK != null) {
                    this.pmU.pmK.aab.notifyChanged();
                }
            }

            public final void onError() {
                w.e("MicroMsg.UnfamiliarContactUI", "[onError]");
                this.pmU.findViewById(R.h.cIE).setVisibility(0);
                this.pmU.findViewById(R.h.ctp).setVisibility(8);
                this.pmU.pmJ.setText(this.pmU.getString(R.l.eYN));
            }

            public final void a(e eVar) {
                w.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[]{eVar.name()});
                this.pmU.findViewById(R.h.cIE).setVisibility(0);
                this.pmU.findViewById(R.h.ctp).setVisibility(0);
                if (eVar == e.NORMAL) {
                    this.pmU.pmJ.setText(this.pmU.getString(R.l.cbS));
                } else if (eVar == e.OVER_ONE_MIN) {
                    this.pmU.pmJ.setText(this.pmU.getString(R.l.eYO));
                }
            }

            public final void d(HashSet hashSet) {
                String str = "MicroMsg.UnfamiliarContactUI";
                String str2 = "[onResult] size:%s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
                w.i(str, str2, objArr);
                if (hashSet != null) {
                    UnfamiliarContactDetailUI.a(this.pmU, hashSet);
                }
            }
        });
        com.tencent.mm.plugin.setting.b.a aVar = this.pmS;
        aVar.phZ = System.currentTimeMillis();
        aVar.phY.a(e.NORMAL);
        aVar.gYK.D(new Runnable(aVar) {
            final /* synthetic */ a pia;

            {
                this.pia = r1;
            }

            public final void run() {
                a aVar = this.pia;
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList linkedList = new LinkedList();
                ar wR = ((h) com.tencent.mm.kernel.h.h(h.class)).wR();
                String str = "@all.contact.without.chatroom";
                List arrayList = new ArrayList();
                arrayList.add("tmessage");
                arrayList.add("officialaccounts");
                arrayList.add("filehelper");
                arrayList.add("helper_entry");
                arrayList.add(com.tencent.mm.u.m.xL());
                com.tencent.mm.storage.ay AH = ((h) com.tencent.mm.kernel.h.h(h.class)).wZ().AH("@t.qq.com");
                if (AH != null) {
                    arrayList.add(AH.name);
                }
                arrayList.add("blogapp");
                Cursor a = wR.a(str, null, arrayList, null, false, false);
                if (a != null) {
                    a.moveToFirst();
                    while (!a.isAfterLast()) {
                        af xVar = new x();
                        xVar.b(a);
                        linkedList.add(xVar.field_username);
                        a.moveToNext();
                    }
                    a.close();
                }
                w.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList.size())});
                aVar.ad(linkedList);
            }
        });
    }

    protected void onResume() {
        super.onResume();
        if (-1 != this.pmQ) {
            Object obj;
            if (-1 == this.pmQ) {
                obj = null;
            } else {
                b bVar = (b) this.iUM.get(this.pmQ);
                af afVar = bVar.jiL;
                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(afVar.field_username);
                if (com.tencent.mm.j.a.ez(Rc.field_type) || !com.tencent.mm.j.a.ez(afVar.field_type)) {
                    bVar.jiL = Rc;
                    obj = null;
                } else {
                    this.iUM.remove(this.pmQ);
                    obj = 1;
                }
            }
            if (obj != null) {
                f.pnq++;
            }
            this.pmQ = -1;
        }
        this.pmR.clear();
        if (this.pmK != null) {
            this.pmK.aab.notifyChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        int i = (this.phQ ? 4 : 0) | ((this.phR ? 2 : 0) | (this.phP ? 1 : 0));
        com.tencent.mm.plugin.report.service.g.oUh.i(14434, new Object[]{Integer.valueOf(i), Integer.valueOf(f.pnq), Integer.valueOf(f.pnp), Integer.valueOf(f.pnu), Integer.valueOf(f.pnr), Integer.valueOf(f.pnt), Integer.valueOf(f.pns)});
        w.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(f.pnq), Integer.valueOf(f.pnp), Integer.valueOf(f.pnu), Integer.valueOf(f.pnr), Integer.valueOf(f.pnt), Integer.valueOf(f.pns)});
        f.pnp = 0;
        f.pnq = 0;
        f.pnr = 0;
        f.pns = 0;
        f.pnt = 0;
        f.pnu = 0;
        ap.vd().b(291, this);
        com.tencent.mm.plugin.setting.b.a aVar = this.pmS;
        w.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[]{Boolean.valueOf(aVar.phQ), Boolean.valueOf(aVar.phP), Boolean.valueOf(aVar.phR)});
        if (aVar.phX != null) {
            ap.vd().b(292, aVar.phX);
        }
        aVar.gYK.nJF.quit();
        com.tencent.mm.sdk.f.e.O(aVar.lw);
    }

    protected final void KC() {
        int i;
        int i2 = 0;
        super.KC();
        zi(R.l.eUJ);
        a(1, getString(R.l.eYK), new OnMenuItemClickListener(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pmU.pmT = !this.pmU.pmT;
                this.pmU.pmO.clear();
                UnfamiliarContactDetailUI.b(this.pmU, this.pmU.pmT);
                if (this.pmU.pmT) {
                    this.pmU.pmG.setEnabled(false);
                    this.pmU.pmH.setEnabled(false);
                    this.pmU.aB(1, this.pmU.getString(R.l.eYH));
                } else {
                    this.pmU.aB(1, this.pmU.getString(R.l.eYK));
                }
                if (this.pmU.pmK != null) {
                    this.pmU.pmK.aab.notifyChanged();
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pmU.finish();
                return true;
            }
        });
        findViewById(R.h.cDl).setVisibility(this.phP ? 0 : 8);
        View findViewById = findViewById(R.h.cDn);
        if (this.phR) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(R.h.cDm);
        if (!this.phQ) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        this.pmE = (RecyclerView) findViewById(R.h.cKF);
        this.oEP = findViewById(R.h.bottom_bar);
        this.pmF = (TextView) findViewById(R.h.cjC);
        this.pmP = new d(this, this.pmO, new g(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final void st(int i) {
                f.pnp += i;
                this.pmU.da(false);
                this.pmU.pmF.setText(this.pmU.getString(R.l.eYJ) + "(" + this.pmU.iUM.size() + ")");
                if (this.pmU.pmK != null) {
                    this.pmU.pmK.aab.notifyChanged();
                }
            }

            public final void baA() {
                this.pmU.da(true);
            }
        });
        this.pmG = findViewById(R.h.cKC);
        this.pmG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.g.a(this.pmU.uSU.uTo, true, this.pmU.uSU.uTo.getString(R.l.eYM), this.pmU.uSU.uTo.getString(R.l.bFb), this.pmU.uSU.uTo.getString(R.l.dGB), this.pmU.uSU.uTo.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass7 pmX;

                    {
                        this.pmX = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (this.pmX.pmU.pmP != null) {
                            Runnable h = this.pmX.pmU.pmP;
                            com.tencent.mm.sdk.f.e.remove(h);
                            if (h.pnj != null) {
                                h.pnj.baA();
                            }
                            com.tencent.mm.sdk.f.e.post(h, "delete_contact_task");
                        }
                        UnfamiliarContactDetailUI.b(this.pmX.pmU, false);
                    }
                }, null, R.e.aSJ);
            }
        });
        this.pmH = findViewById(R.h.cKD);
        this.pmH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.pmU, com.tencent.mm.ui.widget.e.wuP, false);
                eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ AnonymousClass8 pmY;

                    {
                        this.pmY = r1;
                    }

                    public final void a(l lVar) {
                        lVar.a(0, this.pmY.pmU.getString(R.l.eDN), this.pmY.pmU.getString(R.l.eRu), this.pmY.pmU.getResources().getDrawable(R.k.dvP), false);
                        lVar.a(1, this.pmY.pmU.getString(R.l.eDO), this.pmY.pmU.getString(R.l.eRu), this.pmY.pmU.getResources().getDrawable(R.k.dvQ), false);
                    }
                };
                eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                    final /* synthetic */ AnonymousClass8 pmY;

                    {
                        this.pmY = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        UnfamiliarContactDetailUI.a(this.pmY.pmU, this.pmY.pmU.pmO, i);
                        UnfamiliarContactDetailUI.b(this.pmY.pmU, false);
                        if (this.pmY.pmU.pmK != null) {
                            this.pmY.pmU.pmK.aab.notifyChanged();
                        }
                    }
                };
                eVar.bzh();
            }
        });
        this.pmI = findViewById(R.h.cKE);
        this.pmI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final void onClick(View view) {
                boolean z;
                CheckBox checkBox = (CheckBox) this.pmU.pmI.findViewById(R.h.checkbox);
                if (checkBox.isChecked()) {
                    z = false;
                } else {
                    z = true;
                }
                checkBox.setChecked(z);
                if (checkBox.isChecked()) {
                    for (int i = 0; i < this.pmU.iUM.size(); i++) {
                        this.pmU.pmO.add(Integer.valueOf(i));
                    }
                } else {
                    this.pmU.pmO.clear();
                }
                if (this.pmU.pmO.size() > 0) {
                    this.pmU.pmH.setEnabled(true);
                    this.pmU.pmG.setEnabled(true);
                } else {
                    this.pmU.pmH.setEnabled(false);
                    this.pmU.pmG.setEnabled(false);
                }
                this.pmU.pmE.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 pmZ;

                    {
                        this.pmZ = r1;
                    }

                    public final void run() {
                        this.pmZ.pmU.pmK.aab.notifyChanged();
                    }
                });
            }
        });
        this.pmJ = (TextView) findViewById(R.h.cIJ);
        this.pmE.a(new LinearLayoutManager());
        this.pmK = new a(this);
        this.pmE.a(this.pmK);
        this.pmL = (RealAlphabetScrollBar) findViewById(R.h.cKG);
        this.pmL.vpW = new com.tencent.mm.ui.base.VerticalScrollBar.a(this) {
            final /* synthetic */ UnfamiliarContactDetailUI pmU;

            {
                this.pmU = r1;
            }

            public final void sd(String str) {
                UnfamiliarContactDetailUI unfamiliarContactDetailUI = this.pmU;
                int intValue = (unfamiliarContactDetailUI.pmM == null || !unfamiliarContactDetailUI.pmM.containsKey(str)) ? -1 : ((Integer) unfamiliarContactDetailUI.pmM.get(str)).intValue();
                w.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[]{str, Integer.valueOf(intValue)});
                if (intValue != -1) {
                    this.pmU.pmE.aX(intValue);
                }
            }
        };
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this, getString(R.l.eYL), 1).show();
        }
        if (kVar.getType() == 291) {
            da(false);
            this.pmR.clear();
            this.pmK.aab.notifyChanged();
        }
    }

    private void bm(List<b> list) {
        this.pmM.clear();
        this.pmN.clear();
        int i = 0;
        String str = null;
        for (b bVar : list) {
            if (kxq.equalsIgnoreCase(bVar.pna)) {
                bVar.pna = "#";
            }
            String str2 = bVar.pna;
            if (!str2.equalsIgnoreCase(str)) {
                this.pmM.put(str2.toUpperCase(), Integer.valueOf(i));
                this.pmN.put(Integer.valueOf(i), str2.toUpperCase());
            }
            i++;
            str = str2;
        }
    }

    private void da(boolean z) {
        w.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.iLz = p.b(this, getString(R.l.eYI), true, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }
}
