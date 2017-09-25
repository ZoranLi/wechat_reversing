package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.chatting.a.b.f;
import com.tencent.mm.ui.chatting.ab;
import com.tencent.mm.ui.chatting.b.b.a;
import com.tencent.mm.ui.chatting.dz;
import com.tencent.mm.ui.chatting.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b implements f, a {
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> jnH = null;
    protected String kwJ;
    protected Context mContext;
    private boolean sXW = false;
    private long vFJ = 0;
    protected com.tencent.mm.ui.chatting.b.b.b vUc;
    com.tencent.mm.ui.chatting.a.b vUd;
    private LinearLayoutManager vUe;
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> vUf = null;

    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.chatting.e.a aVar) {
        com.tencent.mm.ui.chatting.b.b.b bVar = (com.tencent.mm.ui.chatting.b.b.b) aVar;
        this.vUc = bVar;
        bVar.a(this);
    }

    public final /* synthetic */ h eW(Context context) {
        if (this.vUe == null) {
            this.vUe = new LinearLayoutManager();
        }
        return this.vUe;
    }

    public b(Context context) {
        this.mContext = context;
        this.jnH = new ArrayList();
    }

    public final void onDetach() {
        this.vUc.a(null);
        this.vUc = null;
        if (this.vUd != null) {
            com.tencent.mm.ui.chatting.a.b.vPI = null;
            com.tencent.mm.ui.chatting.a.b.vPJ = null;
        }
    }

    public final g bWC() {
        return new g(this) {
            int hP = ((int) this.vUi.mContext.getResources().getDimension(R.f.aWA));
            int vUg = this.vUi.mContext.getResources().getColor(R.e.aTO);
            ColorDrawable vUh = new ColorDrawable(this.vUg);
            final /* synthetic */ b vUi;

            {
                this.vUi = r3;
            }

            public final void a(Canvas canvas, RecyclerView recyclerView) {
                int paddingLeft = recyclerView.getPaddingLeft();
                int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                int childCount = recyclerView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (childAt.getTag() != null) {
                        com.tencent.mm.ui.chatting.a.b.b Bg = this.vUi.Bg(((Integer) childAt.getTag()).intValue() + 1);
                        if (Bg == null || Bg.getType() != Integer.MAX_VALUE) {
                            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                            int bottom = layoutParams.bottomMargin + childAt.getBottom();
                            this.vUh.setBounds(paddingLeft, bottom, width, this.hP + bottom);
                            this.vUh.draw(canvas);
                        }
                    }
                }
            }
        };
    }

    public final com.tencent.mm.ui.chatting.a.b.b Bg(int i) {
        if (this.jnH == null || this.jnH.size() <= i) {
            return null;
        }
        return (com.tencent.mm.ui.chatting.a.b.b) this.jnH.get(i);
    }

    public final RecyclerView.a TI(String str) {
        this.kwJ = str;
        this.vUd = new com.tencent.mm.ui.chatting.a.b(this.mContext, this);
        com.tencent.mm.ui.chatting.a.b.vPI = bWE();
        return this.vUd;
    }

    public final int getCount() {
        if (this.jnH == null) {
            return 0;
        }
        return this.jnH.size();
    }

    public final p.a bWF() {
        return new p.a(this) {
            private aj kxo = new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
                final /* synthetic */ AnonymousClass2 vUj;

                {
                    this.vUj = r1;
                }

                public final boolean oQ() {
                    String str = "MicroMsg.BaseHistoryListPresenter";
                    String str2 = "[onTimerExpired]  mDataListCache is null?:%s mSearchText is null?:%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(this.vUj.vUi.vUf == null);
                    objArr[1] = Boolean.valueOf(bg.mA(this.vUj.vPK));
                    w.i(str, str2, objArr);
                    if (bg.mA(this.vUj.vPK)) {
                        this.vUj.vUi.vUd.vPK = this.vUj.vPK;
                        if (this.vUj.vUi.vUf == null) {
                            this.vUj.vUi.bWD();
                        } else {
                            this.vUj.vUi.jnH = this.vUj.vUi.vUf;
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 vUk;

                                {
                                    this.vUk = r1;
                                }

                                public final void run() {
                                    this.vUk.vUj.vUi.vUc.aY(this.vUk.vUj.vPK, false);
                                    this.vUk.vUj.vUi.vUd.aab.notifyChanged();
                                }
                            });
                        }
                    } else {
                        this.vUj.vUi.jnH = this.vUj.vUi.vUf;
                        ArrayList arrayList = new ArrayList();
                        Iterator it = this.vUj.vUi.jnH.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.ui.chatting.a.b.b bVar = (com.tencent.mm.ui.chatting.a.b.b) it.next();
                            if (bVar.TG(this.vUj.vPK)) {
                                arrayList.add(bVar);
                            }
                        }
                        this.vUj.vUi.jnH = arrayList;
                        this.vUj.vUi.vUd.vPK = this.vUj.vPK;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 vUk;

                            {
                                this.vUk = r1;
                            }

                            public final void run() {
                                this.vUk.vUj.vUi.vUd.aab.notifyChanged();
                                this.vUk.vUj.vUi.vUc.aY(this.vUk.vUj.vPK, this.vUk.vUj.vUi.jnH.isEmpty());
                            }
                        });
                    }
                    return false;
                }
            }, false);
            String vPK = "";
            final /* synthetic */ b vUi;

            {
                this.vUi = r5;
            }

            public final void aej() {
            }

            public final void aek() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
            }

            public final void OE() {
            }

            public final void OD() {
                w.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
                if (this.vUi.vUc != null) {
                    this.vUi.vUc.onFinish();
                }
            }

            public final void mR(String str) {
                if (!this.vPK.equals(str)) {
                    this.vPK = str;
                    this.kxo.KH();
                    this.kxo.v(500, 500);
                }
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void OF() {
            }

            public final void OG() {
                w.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
            }
        };
    }

    protected static String f(au auVar, boolean z) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        if (auVar.field_isSend == 1) {
            return m.xL();
        }
        if (z) {
            str = ay.gi(auVar.field_content);
        }
        if (bg.mA(str)) {
            return auVar.field_talker;
        }
        return str;
    }

    public final void e(int i, final au auVar) {
        w.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.oUh.a(219, 19, 1, true);
                boolean endsWith = this.kwJ.toLowerCase().endsWith("@chatroom");
                List arrayList = new ArrayList(1);
                arrayList.add(auVar);
                ab.a(this.mContext, arrayList, endsWith, this.kwJ, new dz(this) {
                    final /* synthetic */ b vUi;

                    {
                        this.vUi = r1;
                    }

                    public final void bUE() {
                    }

                    public final void a(dz.a aVar) {
                    }

                    public final void b(dz.a aVar) {
                    }

                    public final boolean bUF() {
                        return true;
                    }
                });
                return;
            case 1:
                com.tencent.mm.sdk.b.b cbVar = new cb();
                List arrayList2 = new ArrayList(1);
                arrayList2.add(auVar);
                if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, cbVar, this.kwJ, arrayList2, false)) {
                    cbVar.fFA.fFH = 45;
                    cbVar.fFA.activity = (Activity) this.mContext;
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    if (cbVar.fFB.ret != -2 && cbVar.fFB.ret <= 0 && cbVar.fFB.ret <= 0) {
                        if (14 != cbVar.fFA.type) {
                            w.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
                            return;
                        } else if (cbVar.fFA.fFD == null) {
                            w.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11142, new Object[]{Integer.valueOf(cbVar.fFA.fFD.tzy), Integer.valueOf(cbVar.fFA.fFD.tzz), Integer.valueOf(cbVar.fFA.fFD.tzA), Integer.valueOf(cbVar.fFA.fFD.tzB), Integer.valueOf(cbVar.fFA.fFD.tzC), Integer.valueOf(cbVar.fFA.fFD.tzD), Integer.valueOf(cbVar.fFA.fFD.tzE), Integer.valueOf(cbVar.fFA.fFD.tzF), Integer.valueOf(cbVar.fFA.fFD.tzG), Integer.valueOf(cbVar.fFA.fFD.tzH), Integer.valueOf(cbVar.fFA.fFD.tzI), Integer.valueOf(cbVar.fFA.fFD.tzJ), Integer.valueOf(cbVar.fFA.fFD.tzK), Integer.valueOf(cbVar.fFA.fFD.tzL), Integer.valueOf(cbVar.fFA.fFD.tzM)});
                            return;
                        }
                    }
                    return;
                }
                w.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
                return;
            case 2:
                com.tencent.mm.plugin.report.service.g.oUh.i(11627, new Object[]{Integer.valueOf(5)});
                final Set treeSet = new TreeSet();
                treeSet.add(Long.valueOf(auVar.field_msgId));
                com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(R.l.dXd), "", this.mContext.getString(R.l.ebv), this.mContext.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ b vUi;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.BaseHistoryListPresenter", "delete message");
                        z.a(this.vUi.mContext, treeSet, new dz(this) {
                            final /* synthetic */ AnonymousClass4 vUl;

                            {
                                this.vUl = r1;
                            }

                            public final void bUE() {
                            }

                            public final void a(dz.a aVar) {
                                if (aVar == dz.a.vNn) {
                                    com.tencent.mm.ui.chatting.a.b.b anonymousClass1 = new com.tencent.mm.ui.chatting.a.b.b(this) {
                                        final /* synthetic */ AnonymousClass1 vUm;

                                        {
                                            this.vUm = r1;
                                        }

                                        public final int getType() {
                                            return -1;
                                        }
                                    };
                                    anonymousClass1.fGM = auVar.field_msgId;
                                    this.vUl.vUi.jnH.remove(anonymousClass1);
                                    this.vUl.vUi.vUf.remove(anonymousClass1);
                                }
                            }

                            public final void b(dz.a aVar) {
                                w.i("MicroMsg.BaseHistoryListPresenter", "[requestExitSelectedMode] %s del ", new Object[]{Thread.currentThread(), aVar});
                                if (aVar == dz.a.vNn) {
                                    this.vUl.vUi.vUd.aab.notifyChanged();
                                }
                            }

                            public final boolean bUF() {
                                return true;
                            }
                        });
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    protected final boolean AZ() {
        long j = this.vFJ + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.vFJ = currentTimeMillis;
        if (j < currentTimeMillis) {
            ap.yY();
            this.sXW = c.isSDCardAvailable();
        }
        return this.sXW;
    }
}
