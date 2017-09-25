package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.radar.a.e;
import com.tencent.mm.plugin.radar.a.e.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.all;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class RadarViewController extends RelativeLayout implements com.tencent.mm.plugin.radar.a.c.b, com.tencent.mm.plugin.radar.a.e.c {
    private Context mContext;
    RadarWaveView oIT = null;
    RadarMemberView oIU = null;
    RadarSpecialGridView oIV = null;
    RadarTipsView oIW = null;
    private Button oIX = null;
    TextView oIY = null;
    ProgressBar oIZ = null;
    Button oJa = null;
    View oJb = null;
    e oJc = null;
    com.tencent.mm.plugin.radar.a.c oJd = null;
    b oJe = null;
    d oJf = d.SEARCHING;
    private boolean oJg = false;
    private OnClickListener oJh = new OnClickListener(this) {
        final /* synthetic */ RadarViewController oJm;

        {
            this.oJm = r1;
        }

        public final void onClick(View view) {
        }
    };
    OnClickListener oJi = new OnClickListener(this) {
        final /* synthetic */ RadarViewController oJm;

        {
            this.oJm = r1;
        }

        public final void onClick(View view) {
            if (this.oJm.oJf == d.SEARCHING || this.oJm.oJf == d.SEARCH_RETRUN) {
                ((Activity) this.oJm.getContext()).finish();
                return;
            }
            LinkedList linkedList;
            RadarViewController radarViewController = this.oJm;
            b b = this.oJm.oJe;
            if (b.oJu == null) {
                linkedList = null;
            } else {
                linkedList = new LinkedList();
                for (Object obj : b.oJu) {
                    if (obj != null) {
                        linkedList.add(obj);
                    }
                }
            }
            if (radarViewController.ab(linkedList)) {
                if (this.oJm.oIT != null) {
                    this.oJm.oIT.aVW();
                    this.oJm.oIT.setVisibility(0);
                }
                this.oJm.oJc.aVB();
                this.oJm.a(d.SEARCH_RETRUN);
            } else {
                this.oJm.a(d.SEARCHING);
            }
            if (this.oJm.oJe != null) {
                this.oJm.oJe.aVJ();
            }
        }
    };
    private final int oJj = 33554432;
    private final int oJk = 33554433;
    private final int oJl = 33554434;

    private class a {
        final /* synthetic */ RadarViewController oJm;
        private int oJq = 0;
        public boolean oJr;
        ae oJs;

        public a(RadarViewController radarViewController) {
            boolean z = false;
            this.oJm = radarViewController;
            if (this.oJm.getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
                z = true;
            }
            this.oJr = z;
            this.oJs = new ae(this) {
                final /* synthetic */ a oJt;

                {
                    this.oJt = r1;
                }

                public final void handleMessage(Message message) {
                    if (message.obj instanceof View) {
                        View view = (View) message.obj;
                        view.setVisibility(0);
                        view.clearAnimation();
                        if (!this.oJt.oJr) {
                            Object tag = view.getTag(33554434);
                            Animation animation = tag instanceof Animation ? (Animation) tag : null;
                            if (animation == null) {
                                animation = this.oJt.getInAnimation();
                            }
                            view.startAnimation(animation);
                        }
                    }
                }
            };
        }

        public final Animation getInAnimation() {
            return AnimationUtils.loadAnimation(this.oJm.getContext(), R.a.aRz);
        }

        public final void f(int i, View view) {
            Message obtainMessage = this.oJs.obtainMessage();
            obtainMessage.what = ck(view);
            obtainMessage.obj = view;
            view.setVisibility(4);
            this.oJs.sendMessageDelayed(obtainMessage, (long) ((i + 1) * 500));
        }

        public final int aVV() {
            int i = this.oJq + 1;
            this.oJq = i;
            return i;
        }

        static int ck(View view) {
            Object tag = view.getTag(33554433);
            if (tag instanceof Integer) {
                return ((Integer) tag).intValue();
            }
            return -1;
        }
    }

    public class c {
        public ati oHo;
        final /* synthetic */ RadarViewController oJm;

        public c(RadarViewController radarViewController, ati com_tencent_mm_protocal_c_ati) {
            this.oJm = radarViewController;
            this.oHo = com_tencent_mm_protocal_c_ati;
        }
    }

    public class b extends a {
        private Context context;
        private boolean oJA = false;
        final /* synthetic */ RadarViewController oJm;
        public ati[] oJu = new ati[12];
        public HashMap<String, all> oJv = new HashMap();
        public HashMap<String, Integer> oJw = new HashMap();
        a oJx;
        private int oJy = 0;
        public HashMap<String, View> oJz = new HashMap();

        public class a {
            TextView oJB;
            ImageView oJC;
            ImageView oJD;
            RadarStateView oJE;
            RadarStateChooseView oJF;
            final /* synthetic */ b oJG;

            public a(b bVar, TextView textView, ImageView imageView, RadarStateView radarStateView, RadarStateChooseView radarStateChooseView, ImageView imageView2) {
                this.oJG = bVar;
                this.oJB = textView;
                this.oJC = imageView;
                this.oJE = radarStateView;
                this.oJD = imageView2;
                this.oJF = radarStateChooseView;
            }
        }

        public final /* bridge */ /* synthetic */ void aVJ() {
            super.aVJ();
        }

        public b(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
            this.oJm = radarViewController;
            super(radarSpecialGridView, context);
            this.context = context;
            this.oJx = new a(radarViewController);
        }

        protected static boolean d(ati com_tencent_mm_protocal_c_ati) {
            if (com_tencent_mm_protocal_c_ati == null || (bg.mz(com_tencent_mm_protocal_c_ati.jNj).equals("") && bg.mz(com_tencent_mm_protocal_c_ati.twU).equals(""))) {
                return true;
            }
            return false;
        }

        public final void ac(LinkedList<ati> linkedList) {
            if (linkedList.size() != 0) {
                int i;
                ati com_tencent_mm_protocal_c_ati;
                for (ati c : this.oJu) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        com_tencent_mm_protocal_c_ati = (ati) it.next();
                        if (c.c(com_tencent_mm_protocal_c_ati).equals(c.c(c))) {
                            linkedList.remove(com_tencent_mm_protocal_c_ati);
                            break;
                        }
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    com_tencent_mm_protocal_c_ati = (ati) it2.next();
                    int abs = Math.abs(((int) System.currentTimeMillis()) % 6);
                    for (i = 0; i < this.oJu.length; i++) {
                        int i2 = (i + abs) % 12;
                        if (i2 != 4 && i2 != 7 && d(this.oJu[i2])) {
                            this.oJu[i2] = com_tencent_mm_protocal_c_ati;
                            this.oJw.put(c.b(com_tencent_mm_protocal_c_ati), Integer.valueOf(0));
                            break;
                        }
                    }
                }
                if (linkedList.size() > 0) {
                    super.aVJ();
                    com.tencent.mm.plugin.radar.a.d dVar = com.tencent.mm.plugin.radar.a.d.oGP;
                    i = linkedList.size();
                    if (dVar.fOw == 0 && i > 0) {
                        float aVA = (((float) (com.tencent.mm.plugin.radar.a.d.aVA() - dVar.oGT)) * 1.0f) / 1000.0f;
                        w.d("MicroMsg.RadarKvStatReport", "FoundFirstFriendTimeSpent %s", new Object[]{Float.valueOf(aVA)});
                        g.oUh.A(10682, String.format("%s", new Object[]{Float.valueOf(aVA)}));
                    }
                    dVar.fOw += i;
                    dVar.oGU = i + dVar.oGU;
                }
            }
        }

        public final int getCount() {
            if (this.oJA) {
                return 0;
            }
            return this.oJu.length;
        }

        public final View A(View view, int i) {
            w.d("MicroMsg.Radar.RadarViewController", "getview RadarStatus%s", new Object[]{this.oJm.oJf});
            ati com_tencent_mm_protocal_c_ati = this.oJu[i];
            if (d(com_tencent_mm_protocal_c_ati)) {
                return B(view, i);
            }
            View view2;
            String b = c.b(com_tencent_mm_protocal_c_ati);
            d a = this.oJm.oJf;
            if (view == null) {
                View inflate = View.inflate(this.context, R.i.dlF, null);
                inflate.setTag(33554433, Integer.valueOf(this.oJx.aVV()));
                inflate.setTag(33554434, this.oJx.getInAnimation());
                view2 = inflate;
            } else {
                view2 = view;
            }
            ImageView imageView = (ImageView) view2.findViewById(R.h.cuS);
            RadarStateView radarStateView = (RadarStateView) view2.findViewById(R.h.cuM);
            TextView textView = (TextView) view2.findViewById(R.h.cuU);
            ImageView imageView2 = (ImageView) view2.findViewById(R.h.cuT);
            RadarStateChooseView radarStateChooseView = (RadarStateChooseView) view2.findViewById(R.h.cuL);
            imageView.setVisibility(0);
            radarStateView.setVisibility(0);
            textView.setVisibility(0);
            imageView2.setVisibility(0);
            if (a == d.SEARCHING || a == d.SEARCH_RETRUN) {
                radarStateView.setVisibility(0);
                radarStateChooseView.setVisibility(8);
            } else {
                radarStateView.setVisibility(8);
                radarStateChooseView.setVisibility(0);
            }
            view2.setTag(new a(this, textView, imageView, radarStateView, radarStateChooseView, imageView2));
            if (i == 7 || i % 3 == 1) {
                view2.findViewById(R.h.buM).setVisibility(0);
                view2.findViewById(R.h.cJt).setVisibility(8);
            } else {
                view2.findViewById(R.h.cJt).setVisibility(0);
                view2.findViewById(R.h.buM).setVisibility(8);
            }
            if (view == null || view2 != view) {
                this.oJz.put(b, view2);
            }
            a aVar = (a) view2.getTag();
            aVar.oJB.setText(h.b(this.oJm.getContext(), com_tencent_mm_protocal_c_ati.jOp, aVar.oJB.getTextSize()));
            com.tencent.mm.plugin.radar.ui.b.a.a(aVar.oJC, b);
            view2.findViewById(R.h.cuC).setTag(new c(this.oJm, com_tencent_mm_protocal_c_ati));
            RadarStateView radarStateView2;
            RadarStateChooseView radarStateChooseView2;
            if (this.oJm.oJf == d.SEARCHING || this.oJm.oJf == d.SEARCH_RETRUN) {
                aVar.oJD.setBackgroundResource(R.g.bjs);
                radarStateView2 = aVar.oJE;
                radarStateView2.oIs = true;
                radarStateView2.aVO();
                radarStateChooseView2 = aVar.oJF;
                radarStateChooseView2.oIo = false;
                radarStateChooseView2.setVisibility(8);
                com.tencent.mm.plugin.radar.a.c.d a2 = this.oJm.oJc.a(com_tencent_mm_protocal_c_ati, false);
                if (a2 == null) {
                    a2 = this.oJm.oJd.Df(b);
                    e d = this.oJm.oJc;
                    d.b(com_tencent_mm_protocal_c_ati.jNj, a2);
                    d.b(com_tencent_mm_protocal_c_ati.twU, a2);
                }
                com.tencent.mm.plugin.radar.a.c.d a3 = this.oJm.oJc.a(com_tencent_mm_protocal_c_ati, true);
                RadarStateView radarStateView3 = aVar.oJE;
                if (a3 == null) {
                    a3 = com.tencent.mm.plugin.radar.a.c.d.Stranger;
                }
                radarStateView3.init();
                radarStateView3.oIt.removeMessages(0);
                radarStateView3.clearAnimation();
                radarStateView3.oHp = a3;
                radarStateView3.oIl = false;
                radarStateView3.aVO();
                radarStateView3 = aVar.oJE;
                radarStateView3.init();
                w.d("MicroMsg.RadarStateView", " turnToState : " + a2);
                boolean z = false;
                if (radarStateView3.oHp == a2) {
                    radarStateView3.aVO();
                } else {
                    if ((radarStateView3.getVisibility() == 0 ? 1 : null) != null) {
                        radarStateView3.aVQ();
                        z = true;
                    }
                    w.d("MicroMsg.RadarStateView", " delay : " + z);
                    radarStateView3.oHp = a2;
                    if (radarStateView3.oHp != com.tencent.mm.plugin.radar.a.c.d.Stranger) {
                        if (z) {
                            radarStateView3.oIt.sendEmptyMessageDelayed(0, 320);
                        } else {
                            radarStateView3.oIt.sendEmptyMessage(0);
                        }
                    }
                }
                e d2 = this.oJm.oJc;
                d2.a(com_tencent_mm_protocal_c_ati.jNj, null);
                d2.a(com_tencent_mm_protocal_c_ati.twU, null);
                if (i == 0) {
                    this.oJy = this.oJw.size();
                }
                if (this.oJw.remove(b) == null) {
                    return view2;
                }
                this.oJx.f(this.oJy - this.oJw.size(), view2);
                return view2;
            } else if (bg.mA((String) this.oJm.oJc.aVE().get(c.c(com_tencent_mm_protocal_c_ati)))) {
                return B(view, i);
            } else {
                com.tencent.mm.plugin.radar.a.e.a aVar2;
                RadarStateChooseView radarStateChooseView3;
                radarStateView2 = aVar.oJE;
                radarStateView2.oIs = false;
                radarStateView2.setVisibility(8);
                radarStateChooseView2 = aVar.oJF;
                radarStateChooseView2.oIo = true;
                radarStateChooseView2.aVO();
                e d3 = this.oJm.oJc;
                if (!(d3.aVI() == null || com_tencent_mm_protocal_c_ati == null)) {
                    String b2 = c.b(com_tencent_mm_protocal_c_ati);
                    if (d3.aVI().containsKey(b2)) {
                        aVar2 = (com.tencent.mm.plugin.radar.a.e.a) d3.aVI().get(b2);
                        if (aVar2 != com.tencent.mm.plugin.radar.a.e.a.UnSelected) {
                            aVar.oJD.setBackgroundResource(R.k.dyW);
                        } else {
                            aVar.oJD.setBackgroundDrawable(null);
                        }
                        radarStateChooseView3 = aVar.oJF;
                        if (radarStateChooseView3.oIp != aVar2) {
                            radarStateChooseView3.oIp = aVar2;
                            if (radarStateChooseView3.oIp != com.tencent.mm.plugin.radar.a.e.a.Selected) {
                                if (radarStateChooseView3.oIo) {
                                    radarStateChooseView3.init();
                                    radarStateChooseView3.aVO();
                                    radarStateChooseView3.oIl = true;
                                    radarStateChooseView3.startAnimation(radarStateChooseView3.oIm);
                                }
                            } else if (radarStateChooseView3.oIo) {
                                radarStateChooseView3.init();
                                radarStateChooseView3.aVO();
                                radarStateChooseView3.startAnimation(radarStateChooseView3.oIn);
                            }
                        }
                        if (i == 0) {
                            this.oJy = this.oJw.size();
                        }
                        if (this.oJw.remove(c.c(com_tencent_mm_protocal_c_ati)) != null) {
                            return view2;
                        }
                        this.oJx.f(this.oJy - this.oJw.size(), view2);
                        return view2;
                    }
                }
                aVar2 = com.tencent.mm.plugin.radar.a.e.a.UnSelected;
                if (aVar2 != com.tencent.mm.plugin.radar.a.e.a.UnSelected) {
                    aVar.oJD.setBackgroundDrawable(null);
                } else {
                    aVar.oJD.setBackgroundResource(R.k.dyW);
                }
                radarStateChooseView3 = aVar.oJF;
                if (radarStateChooseView3.oIp != aVar2) {
                    radarStateChooseView3.oIp = aVar2;
                    if (radarStateChooseView3.oIp != com.tencent.mm.plugin.radar.a.e.a.Selected) {
                        if (radarStateChooseView3.oIo) {
                            radarStateChooseView3.init();
                            radarStateChooseView3.aVO();
                            radarStateChooseView3.startAnimation(radarStateChooseView3.oIn);
                        }
                    } else if (radarStateChooseView3.oIo) {
                        radarStateChooseView3.init();
                        radarStateChooseView3.aVO();
                        radarStateChooseView3.oIl = true;
                        radarStateChooseView3.startAnimation(radarStateChooseView3.oIm);
                    }
                }
                if (i == 0) {
                    this.oJy = this.oJw.size();
                }
                if (this.oJw.remove(c.c(com_tencent_mm_protocal_c_ati)) != null) {
                    return view2;
                }
                this.oJx.f(this.oJy - this.oJw.size(), view2);
                return view2;
            }
        }

        private View B(View view, int i) {
            if (view == null) {
                view = View.inflate(this.context, R.i.dlF, null);
                view.setTag(33554433, Integer.valueOf(this.oJx.aVV()));
                view.setTag(33554434, this.oJx.getInAnimation());
            }
            view.findViewById(R.h.cuS).setVisibility(8);
            view.findViewById(R.h.cuT).setVisibility(8);
            view.findViewById(R.h.cuU).setVisibility(4);
            view.findViewById(R.h.cuM).setVisibility(4);
            view.findViewById(R.h.cuL).setVisibility(4);
            if (i == 7 || i % 3 == 1) {
                view.findViewById(R.h.buM).setVisibility(0);
                view.findViewById(R.h.cJt).setVisibility(8);
            } else {
                view.findViewById(R.h.cJt).setVisibility(0);
                view.findViewById(R.h.buM).setVisibility(8);
            }
            return view;
        }

        public final void e(ati com_tencent_mm_protocal_c_ati) {
            if (!d(com_tencent_mm_protocal_c_ati)) {
                String b = c.b(com_tencent_mm_protocal_c_ati);
                if (this.oJm.oJc.aVE().containsKey(b)) {
                    b = (String) this.oJm.oJc.aVE().get(b);
                }
                all com_tencent_mm_protocal_c_all = new all();
                com_tencent_mm_protocal_c_all.ttv = n.mw(b);
                this.oJv.put(b, com_tencent_mm_protocal_c_all);
            }
        }

        public final void f(ati com_tencent_mm_protocal_c_ati) {
            if (!d(com_tencent_mm_protocal_c_ati)) {
                Object b = c.b(com_tencent_mm_protocal_c_ati);
                if (this.oJm.oJc.aVE().containsKey(b)) {
                    b = (String) this.oJm.oJc.aVE().get(b);
                }
                this.oJv.remove(b);
            }
        }
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oJc = new e(this, context.getApplicationContext());
        this.oJd = new com.tencent.mm.plugin.radar.a.c(this, context);
        this.mContext = context;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.oIU.isShowing()) {
            return false;
        }
        this.oIU.dismiss();
        return true;
    }

    private void d(String str, com.tencent.mm.plugin.radar.a.c.d dVar) {
        com.tencent.mm.plugin.radar.a.c.d ag = this.oJc.ag(str, false);
        if (ag != null && ag != dVar) {
            this.oJc.b(str, dVar);
            this.oJe.aVJ();
        }
    }

    public final void a(boolean z, boolean z2, String str, String str2, long j) {
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.a.c.d.Added);
        } else if (z2) {
            d(str2, com.tencent.mm.plugin.radar.a.c.d.Verifying);
        } else {
            this.oIW.Dg(str);
            com.tencent.mm.plugin.radar.a.e.b bVar = (com.tencent.mm.plugin.radar.a.e.b) this.oJc.aVF().get(Long.valueOf(j));
            if (bVar != null) {
                d(c.b(bVar.oHo), bVar.oHp);
                d(c.c(bVar.oHo), bVar.oHp);
            }
        }
        this.oJc.aVF().remove(Long.valueOf(j));
    }

    public final void a(boolean z, String str, String str2, long j) {
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.a.c.d.Added);
        } else {
            this.oIW.Dg(str);
            com.tencent.mm.plugin.radar.a.e.b bVar = (com.tencent.mm.plugin.radar.a.e.b) this.oJc.aVF().get(Long.valueOf(j));
            if (bVar != null) {
                d(c.b(bVar.oHo), bVar.oHp);
            }
        }
        this.oJc.aVF().remove(Long.valueOf(j));
    }

    public final void J(x xVar) {
        if (this.oJc.ag(xVar.field_username, false) == null && this.oJc.ag(xVar.field_encryptUsername, false) == null) {
            LinkedList linkedList = new LinkedList();
            String str = xVar.field_username;
            String str2 = xVar.field_encryptUsername;
            String str3 = xVar.field_nickname;
            ati com_tencent_mm_protocal_c_ati = new ati();
            com_tencent_mm_protocal_c_ati.tVi = 100;
            com_tencent_mm_protocal_c_ati.jNj = str;
            com_tencent_mm_protocal_c_ati.jOp = str3;
            com_tencent_mm_protocal_c_ati.tuS = "";
            com_tencent_mm_protocal_c_ati.twU = str2;
            linkedList.add(com_tencent_mm_protocal_c_ati);
            aa(linkedList);
        }
        if (this.oIU.isShowing()) {
            this.oIU.c(xVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.NeedVerify);
        }
        d(xVar.field_username, com.tencent.mm.plugin.radar.a.c.d.NeedVerify);
        d(xVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.NeedVerify);
    }

    public final void I(x xVar) {
        if (this.oIU.isShowing()) {
            this.oIU.c(xVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.Added);
        }
        d(xVar.field_username, com.tencent.mm.plugin.radar.a.c.d.Added);
        d(xVar.field_encryptUsername, com.tencent.mm.plugin.radar.a.c.d.Added);
    }

    public final void gv(boolean z) {
    }

    public final void a(int i, int i2, LinkedList<ati> linkedList) {
        if (i == 0 && i2 == 0) {
            aa(linkedList);
            return;
        }
        w.e("MicroMsg.Radar.RadarViewController", "radar member return error : %s, type : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        if (2 == i) {
            this.oIW.Dg(getContext().getString(R.l.elv));
        } else {
            this.oIW.Dg(getContext().getString(R.l.eHM));
        }
    }

    public final void b(int i, int i2, LinkedList<atf> linkedList) {
        int i3 = 0;
        if (i == 0 && i2 == 0 && linkedList != null) {
            a(d.RALATIONCHAIN_RETRUN);
            if (this.oJe != null) {
                b bVar = this.oJe;
                bVar.oJm.oJc.aVI().clear();
                bVar.oJm.oJc.aVE().clear();
                bVar.oJv.clear();
                bVar.oJw.clear();
                LinkedList linkedList2 = null;
                if (linkedList != null && linkedList.size() > 0) {
                    int i4;
                    LinkedList linkedList3 = new LinkedList();
                    int size = linkedList.size();
                    for (i4 = 0; i4 < size; i4++) {
                        atf com_tencent_mm_protocal_c_atf = (atf) linkedList.get(i4);
                        atg com_tencent_mm_protocal_c_atg = new atg();
                        com_tencent_mm_protocal_c_atg.tXo = com_tencent_mm_protocal_c_atf.jNj;
                        linkedList3.add(com_tencent_mm_protocal_c_atg);
                        bVar.oJm.oJc.aVE().put(com_tencent_mm_protocal_c_atf.twU, com_tencent_mm_protocal_c_atf.jNj);
                        HashMap hashMap = bVar.oJw;
                        Object obj = com_tencent_mm_protocal_c_atf == null ? "" : com_tencent_mm_protocal_c_atf.twU != null ? com_tencent_mm_protocal_c_atf.twU : com_tencent_mm_protocal_c_atf.jNj;
                        hashMap.put(obj, Integer.valueOf(0));
                    }
                    if (bVar.oJm.oJe != null) {
                        i4 = bVar.oJu.length;
                        while (i3 < i4) {
                            ati com_tencent_mm_protocal_c_ati = bVar.oJu[i3];
                            if (!bg.mA((String) bVar.oJm.oJc.aVE().get(c.c(com_tencent_mm_protocal_c_ati)))) {
                                bVar.oJm.oJe.e(com_tencent_mm_protocal_c_ati);
                                bVar.oJm.oJc.a(com_tencent_mm_protocal_c_ati);
                            }
                            i3++;
                        }
                    }
                    linkedList2 = linkedList3;
                }
                bVar.oJm.oJc.oHb = linkedList2;
                this.oJe.aVJ();
                aVU();
                return;
            }
            return;
        }
        a(d.SEARCHING);
        this.oIW.Dg(getContext().getString(R.l.eHM));
    }

    private void aa(LinkedList<ati> linkedList) {
        if (linkedList.size() == 0 && this.oJe.getCount() == 0) {
            this.oIW.gx(true);
        } else {
            this.oIW.gx(false);
        }
        w.d("MicroMsg.Radar.RadarViewController", "members got, size : " + linkedList.size());
        w.d("MicroMsg.Radar.RadarViewController", "has friend:%s", new Object[]{String.valueOf(ab(linkedList))});
        this.oJe.ac(linkedList);
        if (this.oJg && r0) {
            a(d.SEARCH_RETRUN);
        }
    }

    private boolean ab(LinkedList<ati> linkedList) {
        Iterator it = linkedList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.tencent.mm.plugin.radar.a.c.d Df;
            boolean z2;
            ati com_tencent_mm_protocal_c_ati = (ati) it.next();
            com.tencent.mm.plugin.radar.a.c.d a = this.oJc.a(com_tencent_mm_protocal_c_ati, false);
            if (a == null) {
                String b = c.b(com_tencent_mm_protocal_c_ati);
                Df = this.oJd.Df(b);
                this.oJc.b(b, Df);
            } else {
                Df = a;
            }
            if (Df == com.tencent.mm.plugin.radar.a.c.d.Added) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    private void aVU() {
        boolean z = false;
        if (this.oIX != null) {
            b bVar = this.oJe;
            int size = bVar.oJv == null ? 0 : bVar.oJv.size();
            if (size == 0) {
                this.oIX.setText(R.l.dHT);
            } else {
                this.oIX.setText(String.format(getContext().getString(R.l.eHI), new Object[]{Integer.valueOf(size)}));
            }
            Button button = this.oIX;
            if (size > 1) {
                z = true;
            }
            button.setEnabled(z);
            this.oIX.setTextColor(size > 1 ? getResources().getColorStateList(R.e.aWx) : getResources().getColorStateList(R.e.aVv));
            this.oIX.setBackgroundResource(R.g.bda);
        }
    }

    private void a(d dVar) {
        this.oJf = dVar;
        switch (dVar) {
            case SEARCHING:
                this.oJb.setVisibility(8);
                if (this.oJa != null) {
                    this.oJa.setText(R.l.eHJ);
                }
                if (this.oIX != null) {
                    this.oIX.setVisibility(4);
                    this.oIX.setBackgroundResource(R.g.bda);
                    this.oIX.setEnabled(false);
                }
                if (!(this.oIY == null || this.oIZ == null)) {
                    this.oIZ.setVisibility(8);
                    this.oIY.setText("");
                }
                if (this.oIT != null) {
                    this.oIT.aVW();
                    this.oIT.setVisibility(0);
                }
                this.oJc.aVB();
                return;
            case SEARCH_RETRUN:
                this.oJb.setVisibility(8);
                if (this.oIX != null) {
                    this.oIX.setText(R.l.eHD);
                    this.oIX.setMinWidth(com.tencent.mm.bg.a.T(getContext(), R.f.aZp));
                    this.oIX.setTextColor(getResources().getColorStateList(R.e.aWx));
                    this.oIX.setBackgroundResource(R.g.bda);
                    this.oIX.setEnabled(true);
                    gy(false);
                }
                if (this.oIY != null && this.oIZ != null) {
                    this.oIZ.setVisibility(8);
                    this.oIY.setText("");
                    return;
                }
                return;
            case RALATIONCHAIN_RETRUN:
                this.oJb.setVisibility(0);
                if (this.oJc != null) {
                    this.oJc.aVC();
                }
                if (!(this.oIY == null || this.oIZ == null)) {
                    this.oIZ.setVisibility(8);
                    this.oIY.setText(R.l.eHB);
                }
                if (this.oIV != null) {
                    this.oIV.setVisibility(0);
                }
                gy(true);
                if (this.oIX != null) {
                    this.oIX.setVisibility(0);
                    this.oIX.setMinWidth(com.tencent.mm.bg.a.T(getContext(), R.f.baK));
                }
                aVU();
                return;
            case RALATIONCHAIN:
                if (!(this.oJb == null || this.oJb.getVisibility() == 0)) {
                    this.oJb.setAnimation(AnimationUtils.loadAnimation(getContext(), R.a.aRs));
                    this.oJb.setVisibility(0);
                }
                if (this.oJa != null) {
                    this.oJa.setText(R.l.dGs);
                }
                if (this.oJc != null) {
                    this.oJc.aVC();
                }
                if (!(this.oIY == null || this.oIZ == null)) {
                    this.oIZ.setVisibility(0);
                    this.oIY.setText(R.l.eHK);
                }
                if (this.oIT != null) {
                    this.oIT.aVX();
                    this.oIT.setVisibility(4);
                }
                if (this.oIV != null) {
                    this.oIV.setVisibility(4);
                }
                if (this.oJe != null) {
                    b bVar = this.oJe;
                    bVar.oJw.clear();
                    bVar.oJz.clear();
                    for (String str : bVar.oJz.keySet()) {
                        a aVar = bVar.oJx;
                        View view = (View) bVar.oJz.get(str);
                        int ck = a.ck(view);
                        if (ck > 0) {
                            aVar.oJs.removeMessages(ck);
                        }
                        view.clearAnimation();
                    }
                    bVar.aVJ();
                    return;
                }
                return;
            case CREATING_CHAT:
                this.oJb.setVisibility(8);
                if (this.oJc != null) {
                    this.oJc.aVC();
                }
                if (!(this.oIY == null || this.oIZ == null)) {
                    this.oIZ.setVisibility(0);
                    this.oIY.setText(R.l.eHC);
                }
                if (this.oIX != null) {
                    this.oIX.setVisibility(4);
                    return;
                }
                return;
            default:
                w.d("MicroMsg.Radar.RadarViewController", "swithcRadarUI");
                return;
        }
    }

    private void gy(boolean z) {
        if (this.oIX == null) {
            return;
        }
        if (this.oIX.getVisibility() != 0 || z) {
            this.oIX.startAnimation(AnimationUtils.loadAnimation(getContext(), R.a.aRs));
            this.oIX.setVisibility(0);
        }
    }
}
