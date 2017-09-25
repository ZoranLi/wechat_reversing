package com.tencent.mm.ui.bindqq;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.ai;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b implements e {
    public Context context;
    h oHT = null;
    private View oHU = null;
    public SecurityImage uUx = null;
    public p uYL = null;
    public String uYS = "";
    private String uYU = "";
    private String uYV;
    private byte[] uYW = null;
    private a vuM;

    public interface a {
        void bTl();

        boolean t(int i, int i2, String str);
    }

    class b extends com.tencent.mm.ui.applet.SecurityImage.b {
        final /* synthetic */ b vuO;

        b(b bVar) {
            this.vuO = bVar;
        }

        public final void bQI() {
            this.vuO.wC();
            ap.vd().a(new ai(5, this.vuO.uYS, this.vuO.uUx.uYU, this.vuO.uUx.bRz(), this.vuO.uUx.uYV, true, 1), 0);
        }
    }

    public b(Context context, a aVar) {
        this.context = context;
        this.vuM = aVar;
    }

    public final void wC() {
        ap.vd().a(384, (e) this);
    }

    public final void onDetach() {
        ap.vd().b(384, (e) this);
        if (this.vuM != null) {
            this.vuM.bTl();
        }
    }

    public final void bTm() {
        this.oHU = View.inflate(this.context, R.i.dnQ, null);
        final EditText editText = (EditText) this.oHU.findViewById(R.h.cCy);
        editText.setHint(R.l.dUO);
        this.oHT = g.a(this.context, this.context.getString(R.l.dUP), this.oHU, new OnClickListener(this) {
            final /* synthetic */ b vuO;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.vuO.oHT = null;
                b bVar = this.vuO;
                String trim = editText.getText().toString().trim();
                bVar.wC();
                bVar.uYS = trim;
                Context context = bVar.context;
                bVar.context.getString(R.l.dIO);
                bVar.uYL = g.a(context, bVar.context.getString(R.l.eRm), true, new OnCancelListener(bVar) {
                    final /* synthetic */ b vuO;

                    {
                        this.vuO = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.vuO.onDetach();
                    }
                });
                ap.vd().a(new ai(5, bVar.uYS, "", "", "", false, 1), 0);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ b vuO;

            {
                this.vuO = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.vuO.oHT = null;
                this.vuO.onDetach();
            }
        });
    }

    @TargetApi(17)
    public final void a(int i, int i2, String str, k kVar) {
        onDetach();
        if (kVar != null && kVar.getType() == 384) {
            byte[] a;
            if (this.uYL != null) {
                this.uYL.dismiss();
                this.uYL = null;
            }
            this.uYU = n.a(((bja) ((ai) kVar).gUA.hsk.hsr).tIn);
            ai aiVar = (ai) kVar;
            if (((bja) aiVar.gUA.hsk.hsr).thh == null || ((bja) aiVar.gUA.hsk.hsr).thh.tZn <= 0) {
                a = n.a(((bja) aiVar.gUA.hsk.hsr).tfh);
            } else {
                a = com.tencent.mm.kernel.h.vG().gXc.R(aiVar.hud);
            }
            this.uYW = a;
            if (this.vuM == null || !this.vuM.t(i, i2, str)) {
                if (this.context instanceof Activity) {
                    Activity activity = (Activity) this.context;
                    if (!activity.isFinishing()) {
                        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                            return;
                        }
                    }
                    return;
                }
                com.tencent.mm.f.a dn;
                if (i == 4) {
                    switch (i2) {
                        case -311:
                        case -310:
                        case -6:
                            if (!ap.zb()) {
                                return;
                            }
                            if (this.uUx == null) {
                                this.uUx = com.tencent.mm.ui.applet.SecurityImage.a.a(this.context, R.l.eKg, 0, this.uYW, this.uYU, this.uYV, new OnClickListener(this) {
                                    final /* synthetic */ b vuO;

                                    {
                                        this.vuO = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final k aiVar = new ai(5, this.vuO.uYS, this.vuO.uUx.uYU, this.vuO.uUx.bRz(), this.vuO.uUx.uYV, true, 1);
                                        this.vuO.wC();
                                        ap.vd().a(aiVar, 0);
                                        b bVar = this.vuO;
                                        Context context = this.vuO.context;
                                        this.vuO.context.getString(R.l.dIO);
                                        bVar.uYL = g.a(context, this.vuO.context.getString(R.l.ewX), true, new OnCancelListener(this) {
                                            final /* synthetic */ AnonymousClass5 vuP;

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                this.vuP.vuO.onDetach();
                                                ap.vd().c(aiVar);
                                            }
                                        });
                                    }
                                }, null, new OnDismissListener(this) {
                                    final /* synthetic */ b vuO;

                                    {
                                        this.vuO = r1;
                                    }

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        this.vuO.uUx = null;
                                    }
                                }, new b(this));
                                return;
                            } else {
                                this.uUx.a(0, this.uYW, this.uYU, this.uYV);
                                return;
                            }
                        case -72:
                            this.oHT = g.h(this.context, R.l.dUQ, R.l.dIO);
                            return;
                        case -34:
                            this.oHT = g.b(this.context, this.context.getString(R.l.dOz), this.context.getString(R.l.dIO), true);
                            return;
                        case -3:
                            this.oHT = g.a(this.context, this.context.getString(R.l.dTr), this.context.getString(R.l.dIO), new OnClickListener(this) {
                                final /* synthetic */ b vuO;

                                {
                                    this.vuO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.vuO.oHT = null;
                                    this.vuO.onDetach();
                                    this.vuO.bTm();
                                }
                            }, null);
                            return;
                        default:
                            dn = com.tencent.mm.f.a.dn(str);
                            if (dn != null) {
                                dn.a(this.context, null, null);
                                return;
                            }
                            return;
                    }
                }
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this.context, null, null);
                }
            }
        }
    }
}
