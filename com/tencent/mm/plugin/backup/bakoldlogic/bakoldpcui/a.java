package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.e.a.ks;
import com.tencent.mm.plugin.backup.bakoldlogic.a.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b implements d {
    public static String TAG = "MicroMsg.BakChatBanner";
    private static boolean jMq = false;
    private ae handler = new ae(Looper.getMainLooper());
    private View jIM = null;
    public int jLS = c.jJh;
    public int jMr = 0;
    private com.tencent.mm.sdk.b.c jMs;

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.jIM = this.view.findViewById(R.h.brA);
            this.jIM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a jMt;

                {
                    this.jMt = r1;
                }

                public final void onClick(View view) {
                    this.jMt.jLS = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS;
                    a aVar;
                    Intent intent;
                    if (c.jJk == this.jMt.jLS || c.jJl == this.jMt.jLS || c.jJn == this.jMt.jLS || c.jJo == this.jMt.jLS) {
                        w.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS), Integer.valueOf(this.jMt.jMr)});
                        aVar = this.jMt;
                        intent = new Intent((Context) aVar.sNB.get(), BakOperatingUI.class);
                        intent.putExtra("from_bak_banner", true);
                        MMWizardActivity.z((Context) aVar.sNB.get(), intent);
                    } else if (c.jJm == this.jMt.jLS) {
                        w.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS), Integer.valueOf(this.jMt.jMr)});
                        aVar = this.jMt;
                        intent = new Intent((Context) aVar.sNB.get(), BakFinishUI.class);
                        intent.putExtra("cmd", 1);
                        MMWizardActivity.z((Context) aVar.sNB.get(), intent);
                    }
                }
            });
        }
        Xj();
        this.jMs = new com.tencent.mm.sdk.b.c<ks>(this) {
            final /* synthetic */ a jMt;

            {
                this.jMt = r2;
                this.usg = ks.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                this.jMt.getView().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jMu;

                    {
                        this.jMu = r1;
                    }

                    public final void run() {
                        a aVar = this.jMu.jMt;
                        aVar.jMr = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().acq();
                        w.d(a.TAG, "refreshForBakpc PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS), Integer.valueOf(aVar.jMr)});
                        if (aVar.cP(false)) {
                            com.tencent.mm.sdk.b.a.urY.m(new ir());
                        }
                    }
                });
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(this.jMs);
    }

    public final int getLayoutId() {
        return R.i.brA;
    }

    boolean cP(boolean z) {
        this.jLS = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS;
        w.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", new Object[]{Integer.valueOf(this.jLS), Boolean.valueOf(z)});
        if (this.jLS < c.jJk || this.jLS > c.jJo) {
            this.jIM.setVisibility(8);
            return false;
        }
        this.jIM.setVisibility(0);
        if (z && !com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().acn()) {
            com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().a((d) this);
        }
        if (c.jJk == this.jLS) {
            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dvG);
            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLQ, new Object[]{Integer.valueOf(this.jMr)}));
        } else if (c.jJl == this.jLS) {
            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dvG);
            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLT, new Object[]{Integer.valueOf(this.jMr)}));
        } else if (c.jJm == this.jLS) {
            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLS));
            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dvF);
        } else if (c.jJn == this.jLS) {
            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dvG);
            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLP, new Object[]{Integer.valueOf(this.jMr)}));
        } else if (c.jJo == this.jLS) {
            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLR));
            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dvF);
        }
        return true;
    }

    public final boolean Xj() {
        this.jMr = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().acq();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().a((d) this);
        return cP(true);
    }

    public final void release() {
        this.jLS = c.jJh;
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().aco();
    }

    public final void onError(int i) {
    }

    public final void jC(int i) {
        w.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS), Integer.valueOf(i)});
        this.jMr = i;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a jMt;

            {
                this.jMt = r1;
            }

            public final void run() {
                this.jMt.Xj();
            }
        });
    }

    public final void jD(int i) {
        w.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS), Integer.valueOf(i)});
    }

    public final void abW() {
        w.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS)});
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach();
        e.jx(17);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a jMt;

            {
                this.jMt = r1;
            }

            public final void run() {
                this.jMt.Xj();
            }
        });
    }

    public final void aac() {
    }

    public final void act() {
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.jMs);
    }

    public final void jB(int i) {
        w.d(TAG, "onPrepare PCBannerStatus:%d, percent:%d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg().ach().jLS), Integer.valueOf(i)});
        this.jMr = i;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ a jMt;

            {
                this.jMt = r1;
            }

            public final void run() {
                this.jMt.Xj();
            }
        });
    }

    public final int getOrder() {
        return 3;
    }
}
