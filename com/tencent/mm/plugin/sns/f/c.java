package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.e.a.jy;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.ui.aa;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c implements e, com.tencent.mm.y.e {
    public static final Pattern pZV = Pattern.compile("\\{richtext:([\\s\\S]*?)\\}");
    public static final Pattern pZW = Pattern.compile("\\{sex:([\\s\\S]*?):([\\s\\S]*?):([\\s\\S]*?)\\}");
    private com.tencent.mm.plugin.sns.g.c pUs;
    public final int pZN = 500;
    private List<d> pZO;
    public ListView pZP;
    public au pZQ;
    public Map<Long, Integer> pZR = new HashMap();
    public HashSet<Long> pZS = new HashSet();
    public HashSet<Long> pZT = new HashSet();
    private HashMap<Long, a> pZU = new HashMap();
    private com.tencent.mm.pluginsdk.ui.d.m.a pZX = new com.tencent.mm.pluginsdk.ui.d.m.a(this) {
        final /* synthetic */ c qac;

        {
            this.qac = r1;
        }

        public final void bk(Object obj) {
        }
    };
    public final int pZj = 14;

    static class a {
        long mEndTime = -1;
        long mStartTime = -1;
        long pUf;
        d qah;
        int qai = 0;
        int qaj = 0;
        String qak = "";
        String qal = "";
        String qam;

        public a(long j, long j2, String str, d dVar) {
            this.qah = dVar;
            this.mStartTime = j;
            this.pUf = j2;
            this.qam = str;
        }

        public final void cT(int i, int i2) {
            this.qai = i;
            this.qaj = i2;
        }

        public final void o(int i, int i2, int i3, int i4) {
            if (i != -1 && i2 != -1) {
                String str = i + ":" + i2 + ":" + i3 + ":" + i4;
                String str2 = i + ":" + i2;
                if (!str.equals(this.qak)) {
                    if (!this.qak.startsWith(str2) || i3 != 0 || i4 != 0) {
                        this.qak = str;
                        str = i + ":" + i2 + ":" + i3 + ":" + i4;
                        if (!bg.mA(this.qal)) {
                            this.qal += "|";
                        }
                        this.qal += str;
                    }
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.SnSABTestMgr", "onSceneend " + i + " errCode " + i2);
        com.tencent.mm.sdk.b.a.urY.m(new jx());
    }

    public final void init() {
        List arrayList = new ArrayList();
        for (com.tencent.mm.storage.c cVar : com.tencent.mm.u.c.c.Az().QD("10001").values()) {
            d dVar = new d();
            if (cVar == null) {
                w.i("MicroMsg.SnsABTestStrategy", "abtest is null");
            } else if (cVar.isValid()) {
                Map bKK = cVar.bKK();
                if (bKK != null) {
                    w.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar.field_expId + " " + cVar.field_layerId + " " + cVar.field_startTime + " " + cVar.field_endTime);
                    dVar.e(cVar.field_layerId, cVar.field_expId, bKK);
                    int i = (!dVar.fGu || dVar.qao == null || dVar.qao.size() <= 0) ? 0 : 1;
                    if (i != 0) {
                        arrayList.add(dVar);
                    }
                }
            } else {
                w.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            }
        }
        this.pZO = arrayList;
        this.pZR.clear();
        this.pZS.clear();
        this.pZU.clear();
        this.pUs = null;
        if (this.pZO != null && this.pZO.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            String stringBuilder2 = stringBuilder.append(h.vI().cachePath).append("ws_1100004").toString();
            w.i("MicroMsg.SnSABTestMgr", "filepath to list  " + stringBuilder2);
            byte[] c = FileOp.c(stringBuilder2, 0, -1);
            if (c != null) {
                try {
                    this.pUs = (com.tencent.mm.plugin.sns.g.c) new com.tencent.mm.plugin.sns.g.c().aD(c);
                    w.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.pUs == null) {
                        w.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                    } else {
                        w.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + this.pUs.qaF.size());
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
        }
    }

    private void dx(long j) {
        if (this.pUs == null) {
            this.pUs = new com.tencent.mm.plugin.sns.g.c();
        }
        if (this.pUs.qaF.size() > 500) {
            this.pUs.qaF.remove(0);
        }
        this.pUs.qaF.add(Long.valueOf(j));
    }

    public final void clean() {
        this.pZP = null;
        this.pZQ = null;
        if (this.pZS != null) {
            Iterator it = this.pZS.iterator();
            while (it.hasNext()) {
                Long l = (Long) it.next();
                k qVar = new q(l.longValue(), 0, 0, null);
                h.vJ();
                h.vH().gXC.a(qVar, 0);
                w.i("MicroMsg.SnSABTestMgr", "report id " + l);
            }
        }
        if (this.pZU != null) {
            for (a a : this.pZU.values()) {
                a(a);
            }
            this.pZU.clear();
        }
        if (this.pZO.size() != 0 && this.pUs != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            h.vJ();
            String stringBuilder2 = stringBuilder.append(h.vI().cachePath).append("ws_1100004").toString();
            w.i("MicroMsg.SnSABTestMgr", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = this.pUs.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                w.i("MicroMsg.SnSABTestMgr", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + this.pUs.qaF.size());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public static void c(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        cVar.qMB = false;
        cVar.qMA = (ViewStub) view.findViewById(f.pFE);
        cVar.qMA.setVisibility(8);
        cVar.qMF = (ViewStub) view.findViewById(f.pET);
        cVar.qMF.setVisibility(8);
    }

    public final void a(Context context, bbk com_tencent_mm_protocal_c_bbk, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (!v.bIK()) {
            b(cVar);
        } else if (this.pZO == null || this.pZO.size() == 0) {
            b(cVar);
        } else if (this.pZT.contains(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))) {
            b(cVar);
            cVar.qMT.setVisibility(8);
            cVar.ipv.setVisibility(8);
            cVar.mil.setVisibility(8);
        } else if (com_tencent_mm_protocal_c_bbk.tgG == null || com_tencent_mm_protocal_c_bbk.tgG.equals(ae.ber())) {
            b(cVar);
        } else if (this.pUs == null || !this.pUs.qaF.contains(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))) {
            int i;
            if (com_tencent_mm_protocal_c_bbk != null) {
                try {
                    byte[] a = n.a(com_tencent_mm_protocal_c_bbk.ucA);
                    if (bg.bm(a)) {
                        i = 0;
                    } else {
                        i = ((bbs) new bbs().aD(a)).ucL;
                    }
                } catch (Exception e) {
                    i = 0;
                }
            } else {
                i = 0;
            }
            int i2 = 0;
            if (this.pZR.containsKey(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))) {
                i2 = ((Integer) this.pZR.get(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))).intValue();
                if (i2 == -1) {
                    b(cVar);
                    return;
                }
            }
            int i3 = i2;
            d dVar = null;
            for (d dVar2 : this.pZO) {
                if (dVar2 != null) {
                    if (dVar2.qan == i) {
                        dVar = dVar2;
                        break;
                    }
                }
                b(cVar);
                return;
            }
            if (dVar == null) {
                b(cVar);
            } else if (i3 >= dVar.qao.size()) {
                b(cVar);
            } else {
                final b bVar = (b) dVar.qao.get(i3);
                int i4 = bVar.showType;
                b(cVar);
                if (i > 0) {
                    if (this.pZU.containsKey(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))) {
                        ((a) this.pZU.get(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))).cT(i4, bVar.qat.size());
                    } else {
                        a aVar = new a(System.currentTimeMillis(), com_tencent_mm_protocal_c_bbk.tmx, i.df(com_tencent_mm_protocal_c_bbk.tmx), dVar);
                        aVar.cT(i4, bVar.qat.size());
                        this.pZU.put(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), aVar);
                    }
                    if (i4 == 1) {
                        CharSequence charSequence = bVar.title;
                        if (!cVar.qMB) {
                            cVar.qMC = cVar.qMA.inflate();
                            cVar.qMB = true;
                            cVar.qME = (TextView) cVar.qMC.findViewById(f.pDs);
                            cVar.qMD = (LinearLayout) cVar.qMC.findViewById(f.pAB);
                        }
                        cVar.qMC.setVisibility(0);
                        cVar.qME.setText(charSequence);
                        List list = bVar.qat;
                        if (list.size() != cVar.qMD.getChildCount()) {
                            cVar.qMD.removeAllViews();
                            for (i = 0; i < list.size(); i++) {
                                a aVar2 = (a) list.get(i);
                                View textView = new TextView(cVar.qMD.getContext());
                                textView.setText(aVar2.qap);
                                textView.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(context, 10), 0);
                                textView.setVisibility(0);
                                textView.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(context));
                                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.aVS));
                                cVar.qMD.addView(textView);
                            }
                        }
                        for (i2 = 0; i2 < list.size(); i2++) {
                            final a aVar3 = (a) list.get(i2);
                            TextView textView2 = (TextView) cVar.qMD.getChildAt(i2);
                            textView2.setText(a(context, textView2, a(f.a(aVar3), com_tencent_mm_protocal_c_bbk), com_tencent_mm_protocal_c_bbk, cVar, aVar3, bVar, dVar));
                            textView2.setTag(com_tencent_mm_protocal_c_bbk);
                            final Context context2 = context;
                            final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
                            final d dVar3 = dVar;
                            textView2.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ c qac;

                                public final void onClick(View view) {
                                    this.qac.a(context2, view, aVar3, bVar, cVar2, dVar3);
                                }
                            });
                        }
                        return;
                    } else if (i4 == 4) {
                        a(context, com_tencent_mm_protocal_c_bbk, cVar, bVar, dVar);
                        return;
                    } else if (i4 == 2) {
                        if (!b(context, com_tencent_mm_protocal_c_bbk, cVar, bVar, dVar)) {
                            return;
                        }
                        return;
                    }
                }
                b(cVar);
            }
        } else {
            b(cVar);
        }
    }

    private boolean a(Context context, bbk com_tencent_mm_protocal_c_bbk, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        cVar.mil.setBackgroundDrawable(null);
        int i = cVar.position - 1;
        if (this.pZQ != null) {
            WeakReference weakReference = (WeakReference) this.pZQ.qHy.get(Integer.valueOf(i));
            if (!(weakReference == null || weakReference.get() == null)) {
                ((View) weakReference.get()).setBackgroundDrawable(null);
            }
        }
        if (!cVar.qMG) {
            cVar.qMH = cVar.qMF.inflate();
            cVar.qMG = true;
            cVar.qMI = (LinearLayout) cVar.qMH.findViewById(f.pDR);
        }
        cVar.qMH.setVisibility(0);
        cVar.qMT.setVisibility(8);
        cVar.ipv.setVisibility(8);
        List list = bVar.qat;
        if (list.size() != cVar.qMI.getChildCount()) {
            cVar.qMI.removeAllViews();
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(context, 10);
            for (i = 0; i < list.size(); i++) {
                View textView = new TextView(context);
                textView.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.pzt);
                textView.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bg.a.dI(context));
                textView.setTextColor(context.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                cVar.qMI.addView(textView);
            }
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            final a aVar = (a) list.get(i2);
            TextView textView2 = (TextView) cVar.qMI.getChildAt(i2);
            textView2.setText(aVar.qap);
            textView2.setTag(com_tencent_mm_protocal_c_bbk);
            String a = a(f.a(aVar), com_tencent_mm_protocal_c_bbk);
            final Context context2 = context;
            final b bVar2 = bVar;
            final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
            final d dVar2 = dVar;
            textView2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c qac;

                public final void onClick(View view) {
                    this.qac.a(context2, view, aVar, bVar2, cVar2, dVar2);
                }
            });
            textView2.setText(a(context, textView2, a, com_tencent_mm_protocal_c_bbk, cVar, aVar, bVar, dVar), BufferType.SPANNABLE);
            if (aVar.actionType != 5) {
                textView2.setCompoundDrawablePadding(com.tencent.mm.bg.a.fromDPToPix(context, 5));
                textView2.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(com.tencent.mm.plugin.sns.i.i.pIK), null, null, null);
            }
        }
        return true;
    }

    private boolean b(Context context, bbk com_tencent_mm_protocal_c_bbk, com.tencent.mm.plugin.sns.ui.a.a.c cVar, b bVar, d dVar) {
        if (bVar.qat.size() != 2) {
            return false;
        }
        final a aVar = (a) bVar.qat.get(0);
        a aVar2 = (a) bVar.qat.get(1);
        String a = a(f.a(aVar), com_tencent_mm_protocal_c_bbk);
        String a2 = a(f.a(aVar2), com_tencent_mm_protocal_c_bbk);
        String a3 = a(bVar.title, com_tencent_mm_protocal_c_bbk);
        String string = context.getString(j.dIO);
        final Context context2 = context;
        final bbk com_tencent_mm_protocal_c_bbk2 = com_tencent_mm_protocal_c_bbk;
        final b bVar2 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
        final d dVar2 = dVar;
        AnonymousClass3 anonymousClass3 = new DialogInterface.OnClickListener(this) {
            final /* synthetic */ c qac;

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.SnSABTestMgr", "onClick alert1");
                this.qac.a(context2, com_tencent_mm_protocal_c_bbk2, aVar, bVar2, cVar2, dVar2);
            }
        };
        final Context context3 = context;
        final bbk com_tencent_mm_protocal_c_bbk3 = com_tencent_mm_protocal_c_bbk;
        final a aVar3 = aVar2;
        final b bVar3 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar3 = cVar;
        final d dVar3 = dVar;
        g.a(context, a3, string, a, a2, anonymousClass3, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ c qac;

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.SnSABTestMgr", "onClick alert2");
                this.qac.a(context3, com_tencent_mm_protocal_c_bbk3, aVar3, bVar3, cVar3, dVar3);
            }
        });
        return true;
    }

    private void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            Context context = cVar.mil.getContext();
            if (context != null) {
                if (cVar.mil.getBackground() == null) {
                    cVar.mil.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.beo);
                    cVar.mil.setPadding(com.tencent.mm.bg.a.fromDPToPix(context, 12), com.tencent.mm.bg.a.fromDPToPix(context, 12), com.tencent.mm.bg.a.fromDPToPix(context, 12), com.tencent.mm.bg.a.fromDPToPix(context, 8));
                }
                int i = cVar.position - 1;
                if (this.pZQ != null) {
                    WeakReference weakReference = (WeakReference) this.pZQ.qHy.get(Integer.valueOf(i));
                    if (weakReference != null && weakReference.get() != null) {
                        ((View) weakReference.get()).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.beo);
                        ((View) weakReference.get()).setPadding(com.tencent.mm.bg.a.fromDPToPix(context, 12), com.tencent.mm.bg.a.fromDPToPix(context, 12), com.tencent.mm.bg.a.fromDPToPix(context, 12), com.tencent.mm.bg.a.fromDPToPix(context, 8));
                    }
                }
            }
        }
    }

    public final void a(Context context, View view, a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d dVar) {
        w.i("MicroMsg.SnSABTestMgr", "processButtonClick");
        if (view.getTag() instanceof bbk) {
            a(context, (bbk) view.getTag(), aVar, bVar, cVar, dVar);
        }
    }

    public final void a(Context context, bbk com_tencent_mm_protocal_c_bbk, a aVar, b bVar, com.tencent.mm.plugin.sns.ui.a.a.c cVar, d dVar) {
        w.i("MicroMsg.SnSABTestMgr", "processButtonClick snsobj " + com_tencent_mm_protocal_c_bbk.tgG + " " + com_tencent_mm_protocal_c_bbk.tmx);
        int i = aVar.qar - 1;
        a aVar2 = (a) this.pZU.get(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx));
        if (aVar2 != null) {
            aVar2.o(bVar.showType, bVar.qat.size(), aVar.index, aVar.actionType);
            aVar2.qai = -1;
            aVar2.qaj = -1;
        }
        if (aVar.actionType == 3) {
            this.pZS.add(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx));
            this.pZR.put(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(i));
        } else if (aVar.actionType == 1) {
            this.pZR.put(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(i));
            dx(com_tencent_mm_protocal_c_bbk.tmx);
            b(cVar);
        } else if (aVar.actionType == 5) {
            if (this.pZS.contains(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))) {
                this.pZS.remove(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx));
                dx(com_tencent_mm_protocal_c_bbk.tmx);
                b(cVar);
                if (this.pZU.containsKey(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx))) {
                    a((a) this.pZU.remove(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx)));
                }
            }
            this.pZR.put(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx), Integer.valueOf(-1));
            a(cVar);
            return;
        } else if (aVar.actionType == 7) {
            if (i < dVar.qao.size()) {
                b bVar2 = (b) dVar.qao.get(i);
                if (bVar2.showType == 2) {
                    b(context, com_tencent_mm_protocal_c_bbk, cVar, bVar2, dVar);
                    return;
                } else if (bVar2.showType == 5) {
                    s.makeText(context, bg.ap(bVar2.title, ""), 0).show();
                    dx(com_tencent_mm_protocal_c_bbk.tmx);
                    b(cVar);
                    return;
                }
            }
        } else if (aVar.actionType == 6) {
            s.makeText(context, bg.ap(context.getString(j.pKc), ""), 0).show();
            this.pZT.add(Long.valueOf(com_tencent_mm_protocal_c_bbk.tmx));
            b(cVar);
            com.tencent.mm.sdk.b.a.urY.m(new jy());
            a(cVar);
            return;
        } else if (aVar.actionType == 2) {
            r0 = aVar.jumpUrl;
            w.i("MicroMsg.SnSABTestMgr", "jump url " + r0);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r0);
            intent.putExtra("useJs", true);
            com.tencent.mm.plugin.sns.c.a.imv.j(intent, context);
            dx(com_tencent_mm_protocal_c_bbk.tmx);
            b(cVar);
            a(cVar);
            return;
        } else if (aVar.actionType == 8) {
            return;
        } else {
            if (aVar.actionType == 4) {
                r0 = com_tencent_mm_protocal_c_bbk.tgG;
                List linkedList = new LinkedList();
                linkedList.add(r0);
                k vVar = new com.tencent.mm.plugin.sns.model.v(1, 5, "", linkedList.size(), linkedList, 0);
                h.vJ();
                h.vH().gXC.a(vVar, 0);
            }
        }
        if (i == 4 || i == 1) {
            a(context, com_tencent_mm_protocal_c_bbk, cVar);
        }
    }

    private static void b(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar != null) {
            if (cVar.qMA != null) {
                cVar.qMA.setVisibility(8);
            }
            if (cVar.qMC != null) {
                cVar.qMC.setVisibility(8);
            }
            if (cVar.qMF != null) {
                cVar.qMF.setVisibility(8);
            }
            if (cVar.qMH != null) {
                cVar.qMH.setVisibility(8);
            }
            if (cVar.qMT.getVisibility() == 8) {
                cVar.qMT.setVisibility(0);
            }
            if (cVar.ipv.getVisibility() == 8) {
                cVar.ipv.setVisibility(0);
            }
            if (cVar.mil.getVisibility() == 8) {
                cVar.mil.setVisibility(0);
            }
        }
    }

    private static String a(String str, bbk com_tencent_mm_protocal_c_bbk) {
        String str2;
        Throwable e;
        try {
            if (bg.mA(str)) {
                return "";
            }
            int i;
            String str3 = com_tencent_mm_protocal_c_bbk.tgG;
            h.vJ();
            af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str3);
            if (str.contains("{username}")) {
                str = str.replace("{username}", Rc.tL());
            }
            if (Rc.gkr == 1) {
                i = 0;
                str2 = str;
            } else if (Rc.gkr == 2) {
                i = 1;
                str2 = str;
            } else {
                i = 2;
                str2 = str;
            }
            while (true) {
                Matcher matcher = pZW.matcher(str2);
                if (!matcher.find() || matcher.groupCount() != 3) {
                    return str2;
                }
                CharSequence group;
                CharSequence group2 = matcher.group();
                if (i == 0) {
                    group = matcher.group(1);
                } else if (i == 1) {
                    try {
                        group = matcher.group(2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    group = matcher.group(3);
                }
                str2 = str2.replace(group2, group);
            }
        } catch (Throwable e3) {
            e = e3;
            str2 = str;
            w.printErrStackTrace("MicroMsg.SnSABTestMgr", e, "settext error ", new Object[0]);
            return str2;
        }
    }

    private SpannableString a(Context context, TextView textView, String str, bbk com_tencent_mm_protocal_c_bbk, com.tencent.mm.plugin.sns.ui.a.a.c cVar, a aVar, b bVar, d dVar) {
        Matcher matcher = pZV.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            return com.tencent.mm.pluginsdk.ui.d.h.a(context, str);
        }
        CharSequence group = matcher.group();
        Object group2 = matcher.group(1);
        int indexOf = str.indexOf(group);
        CharSequence replace = str.replace(group, group2);
        textView.setOnClickListener(null);
        textView.setClickable(true);
        SpannableString spannableString = new SpannableString(replace);
        textView.setOnTouchListener(new aa());
        final Context context2 = context;
        final bbk com_tencent_mm_protocal_c_bbk2 = com_tencent_mm_protocal_c_bbk;
        final a aVar2 = aVar;
        final b bVar2 = bVar;
        final com.tencent.mm.plugin.sns.ui.a.a.c cVar2 = cVar;
        final d dVar2 = dVar;
        spannableString.setSpan(new m(com_tencent_mm_protocal_c_bbk.tgG, new com.tencent.mm.pluginsdk.ui.d.m.a(this) {
            final /* synthetic */ c qac;

            public final void bk(Object obj) {
                this.qac.a(context2, com_tencent_mm_protocal_c_bbk2, aVar2, bVar2, cVar2, dVar2);
            }
        }), indexOf, group2.length() + indexOf, 33);
        return spannableString;
    }

    public final void a(int i, String str, long j, String str2, bfc com_tencent_mm_protocal_c_bfc, boolean z, be beVar) {
    }

    public final void a(int i, String str, long j, String str2, bfc com_tencent_mm_protocal_c_bfc, boolean z) {
        if (this.pZU.containsKey(Long.valueOf(j))) {
            a aVar = (a) this.pZU.get(Long.valueOf(j));
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            aVar.o(aVar.qai, aVar.qaj, 0, 0);
        }
    }

    private static void a(a aVar) {
        d dVar = aVar.qah;
        if (dVar != null) {
            String str = dVar.pZM;
            String str2 = dVar.pZL;
            String str3 = aVar.qam;
            aVar.o(aVar.qai, aVar.qaj, 0, 0);
            String str4 = aVar.qal;
            if (bg.mA(str4)) {
                str4 = aVar.qai + ":" + aVar.qaj + ":0:0";
            }
            String str5 = "";
            long j = aVar.mStartTime / 1000;
            if (aVar.mEndTime == -1) {
                aVar.mEndTime = System.currentTimeMillis();
            }
            long j2 = aVar.mEndTime / 1000;
            if (aVar != null) {
                w.i("MicroMsg.SnSABTestMgr", "report layerId: " + str + " expid " + str2 + " acton " + str4 + " starttime " + j + " timelineId: " + str3);
                com.tencent.mm.plugin.report.service.g.oUh.i(11917, new Object[]{str, str2, str5, str5, Integer.valueOf(1), str3, str4, Long.valueOf(j), Long.valueOf(j2)});
            }
        }
    }
}
