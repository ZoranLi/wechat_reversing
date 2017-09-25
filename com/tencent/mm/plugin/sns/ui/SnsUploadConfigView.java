package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.fk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.j.a.b;
import com.tencent.mm.ui.j.a.c;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SnsUploadConfigView extends LinearLayout implements a, b, e {
    private static String fwP = "com.tencent.mm";
    private Context context;
    private ProgressDialog mWt = null;
    boolean qFL = false;
    ImageView qJU;
    ImageView qJV;
    ImageView qJW;
    private boolean qJX = false;
    boolean qJY = false;
    boolean qJZ = false;
    private boolean qKa = false;
    private boolean qKb = true;
    private boolean qKc = false;
    ajq qKd = new ajq();
    com.tencent.mm.ui.j.a qKe = new com.tencent.mm.ui.j.a();

    static /* synthetic */ void k(SnsUploadConfigView snsUploadConfigView) {
        w.e("MicroMsg.SnsUploadConfigView", "dealWithRefreshTokenFail");
        if (snsUploadConfigView.qJY) {
            String string = snsUploadConfigView.getContext().getString(j.dIO);
            g.a(snsUploadConfigView.getContext(), snsUploadConfigView.getContext().getString(j.ehf), string, new OnClickListener(snsUploadConfigView) {
                final /* synthetic */ SnsUploadConfigView qKf;

                {
                    this.qKf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("is_force_unbind", true);
                    intent.putExtra("shake_music", true);
                    d.a(this.qKf.getContext(), ".ui.account.FacebookAuthUI", intent, 8);
                }
            }, null);
        }
        snsUploadConfigView.qJY = false;
        snsUploadConfigView.hM(false);
    }

    public SnsUploadConfigView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.context = context;
        View inflate = r.eC(context).inflate(i.g.pIu, this, true);
        this.qJU = (ImageView) inflate.findViewById(f.pFK);
        this.qJV = (ImageView) inflate.findViewById(f.pFM);
        this.qJW = (ImageView) inflate.findViewById(f.pFL);
        if (!com.tencent.mm.ai.b.Hn()) {
            this.qJW.setVisibility(8);
        }
        if (!com.tencent.mm.ai.b.Hp()) {
            this.qJV.setVisibility(8);
        }
        if (!m.yk()) {
            this.qJU.setVisibility(8);
        }
        this.qJW.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView qKf;

            public final void onClick(View view) {
                if (this.qKf.qKa || !this.qKf.qFL) {
                    this.qKf.qKa = !this.qKf.qKa;
                    this.qKf.ble();
                    return;
                }
                g.h(context, j.pMy, j.dIO);
            }
        });
        this.qJU.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView qKf;

            {
                this.qKf = r1;
            }

            public final void onClick(View view) {
                this.qKf.qJY = !this.qKf.qJY;
                if (this.qKf.qJY) {
                    this.qKf.qFL = false;
                }
                this.qKf.hM(false);
            }
        });
        this.qJV.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView qKf;

            {
                this.qKf = r1;
            }

            public final void onClick(View view) {
                this.qKf.qJZ = !this.qKf.qJZ;
                if (this.qKf.qJZ) {
                    this.qKf.qFL = false;
                }
                this.qKf.blf();
            }
        });
    }

    public final void bld() {
        this.qJX = false;
        this.qJY = false;
        this.qJZ = false;
        this.qKa = false;
        this.qJW.setImageResource(i.i.pJv);
        this.qJU.setImageResource(i.i.pJp);
        this.qJV.setImageResource(i.i.pJz);
    }

    final void ble() {
        if (this.qKa) {
            boolean z;
            h.vJ();
            int f = bg.f((Integer) h.vI().vr().get(9, null));
            if (f == 0) {
                g.a(getContext(), j.eUS, j.dIO, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView qKf;

                    {
                        this.qKf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.sns.c.a.imv.h(new Intent(), this.qKf.context);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView qKf;

                    {
                        this.qKf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (f != 0) {
                z = true;
                if (z) {
                    this.qKa = false;
                    return;
                } else {
                    this.qJW.setImageResource(i.i.pJw);
                    return;
                }
            }
            z = false;
            if (z) {
                this.qJW.setImageResource(i.i.pJw);
                return;
            } else {
                this.qKa = false;
                return;
            }
        }
        this.qJW.setImageResource(i.i.pJv);
    }

    final void hM(boolean z) {
        if (this.qJY) {
            boolean z2;
            if (m.ym()) {
                z2 = true;
            } else {
                g.a(getContext(), j.eSx, j.dIO, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView qKf;

                    {
                        this.qKf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.a(this.qKf.getContext(), ".ui.account.FacebookAuthUI", new Intent().putExtra("shake_music", true));
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView qKf;

                    {
                        this.qKf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z2 = false;
            }
            if (z2) {
                if (!(z || this.qKc || !m.ym())) {
                    final com.tencent.mm.sdk.b.b fkVar = new fk();
                    fkVar.nFq = new Runnable(this) {
                        final /* synthetic */ SnsUploadConfigView qKf;

                        public final void run() {
                            if (!fkVar.fKa.fFj) {
                                SnsUploadConfigView.k(this.qKf);
                            }
                        }
                    };
                    com.tencent.mm.sdk.b.a.urY.a(fkVar, Looper.myLooper());
                }
                this.qJU.setImageResource(i.i.pJq);
                return;
            }
            this.qJY = false;
            return;
        }
        this.qJU.setImageResource(i.i.pJp);
    }

    final void blf() {
        if (this.qJZ) {
            boolean z;
            if (this.qKe.cam()) {
                z = true;
            } else {
                g.a(getContext(), j.eUC, j.dIO, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView qKf;

                    {
                        this.qKf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SnsUploadConfigView snsUploadConfigView = this.qKf;
                        Context context = this.qKf.getContext();
                        this.qKf.getContext().getString(j.dIO);
                        snsUploadConfigView.mWt = g.a(context, this.qKf.getContext().getString(j.eYA), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass13 qKh;

                            {
                                this.qKh = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        this.qKf.qKe.a(this.qKf, this.qKf.getContext());
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SnsUploadConfigView qKf;

                    {
                        this.qKf = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                z = false;
            }
            if (z) {
                this.qJV.setImageResource(i.i.pJA);
                return;
            } else {
                this.qJZ = false;
                return;
            }
        }
        this.qJV.setImageResource(i.i.pJz);
    }

    public final int blg() {
        if (this.qFL) {
            return 1;
        }
        return 0;
    }

    public final void hN(boolean z) {
        this.qFL = z;
        if (z) {
            bld();
        }
    }

    public final int blh() {
        int i = 0;
        if (this.qJX) {
            i = 1;
        }
        if (this.qJY) {
            i |= 2;
        }
        if (this.qJZ) {
            i |= 8;
        }
        if (this.qKa) {
            return i | 4;
        }
        return i;
    }

    private void ow(int i) {
        g.a(getContext(), i, j.dIO, new OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView qKf;

            {
                this.qKf = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener(this) {
            final /* synthetic */ SnsUploadConfigView qKf;

            {
                this.qKf = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || kVar == null) {
        }
    }

    public final void a(c cVar) {
        if (this.mWt != null) {
            this.mWt.cancel();
        }
        switch (cVar) {
            case Finished:
                this.qJZ = true;
                ow(j.eYC);
                break;
            case Canceled:
                this.qJZ = false;
                break;
            case Failed:
                this.qJZ = false;
                ow(j.eYB);
                break;
        }
        blf();
    }

    public final void b(c cVar) {
        switch (cVar) {
            case Failed:
                this.qJZ = false;
                break;
        }
        blf();
    }
}
