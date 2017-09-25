package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.e.a.iw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class a implements e {
    private String chatroomName = "";
    private Context context;
    private p irJ;
    private LinkedList<String> oGI;
    private LinkedList<Integer> oGJ;
    public String osP = "";
    private a sLN;
    public b sLO;
    private LinkedList<String> sLP;
    public String sLQ;
    public String sLR = "";
    public String sLS;
    public String sLT;
    public boolean sLU = true;
    public boolean sLV = true;
    public String sLW = "";
    public boolean sLX = false;

    public interface a {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public interface b {
        boolean aFo();
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.sLN = aVar;
        this.oGI = new LinkedList();
        this.sLP = new LinkedList();
        this.irJ = null;
    }

    public final void b(String str, String str2, LinkedList<Integer> linkedList) {
        this.chatroomName = str2;
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void c(String str, LinkedList<Integer> linkedList) {
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void a(String str, LinkedList<Integer> linkedList, String str2) {
        a(str, (LinkedList) linkedList, false, str2);
    }

    public final void MK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.sLP.add(str);
        }
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        a(str, (LinkedList) linkedList, z, "");
    }

    private void a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        if (linkedList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.sLU = z;
        h.vH().gXC.a(30, (e) this);
        if (this.sLV) {
            Context context = this.context;
            this.context.getString(g.dIO);
            this.irJ = com.tencent.mm.ui.base.g.a(context, this.context.getString(g.kEf), true, new OnCancelListener(this) {
                final /* synthetic */ a sLY;

                {
                    this.sLY = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.sLY.c(false, false, this.sLY.sLR, this.sLY.sLW);
                }
            });
        }
        this.oGJ = linkedList;
        this.oGI.add(str);
        this.sLR = str;
        k nVar = new n(1, this.oGI, linkedList, this.sLP, "", this.osP, null, this.chatroomName, str2);
        if (!bg.mA(this.sLS)) {
            nVar.ei(this.sLS, this.sLT);
        }
        h.vH().gXC.a(nVar, 0);
    }

    public final void c(boolean z, boolean z2, String str, String str2) {
        if (this.sLN != null) {
            this.sLN.a(z, z2, str, str2);
        }
        if (z) {
            com.tencent.mm.sdk.b.b iwVar = new iw();
            iwVar.fOH.username = str;
            com.tencent.mm.sdk.b.a.urY.m(iwVar);
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        w.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (kVar.getType() != 30) {
            w.w("MicroMsg.AddContact", "not expected scene,  type = " + kVar.getType());
            return;
        }
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        h.vH().gXC.b(30, (e) this);
        if (i == 0 && i2 == 0) {
            this.sLR = ((n) kVar).bCI();
            c(true, false, this.sLR, this.sLW);
        } else if (i2 == -44) {
            String str2 = this.sLW;
            if (this.sLO != null) {
                this.sLO.aFo();
                c(false, false, this.sLR, str2);
                return;
            }
            m mVar = new m(this.context, new com.tencent.mm.pluginsdk.ui.applet.m.a(this) {
                final /* synthetic */ a sLY;

                {
                    this.sLY = r1;
                }

                public final void dl(boolean z) {
                    this.sLY.c(false, z, this.sLY.sLR, this.sLY.sLW);
                }
            });
            if (this.sLQ != null) {
                mVar.sLQ = this.sLQ;
            }
            if (this.sLU) {
                List list = this.oGI;
                List list2 = this.oGJ;
                mVar.sNu = false;
                mVar.onStart();
                h.vH().gXC.a(new n(2, list, list2, "", ""), 0);
                return;
            }
            mVar.g(this.oGI, this.oGJ);
        } else if (i2 == -87) {
            com.tencent.mm.ui.base.g.b(this.context, this.context.getString(g.dXI), "", true);
        } else if (i2 == -101 && !bg.mA(str)) {
            w.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i2), str);
            com.tencent.mm.ui.base.g.a(this.context, str, "", false, new OnClickListener(this) {
                final /* synthetic */ a sLY;

                {
                    this.sLY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sLY.c(false, false, this.sLY.sLR, this.sLY.sLW);
                }
            });
        } else if (i2 == -302) {
            w.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(((n) kVar).fJK));
            if (((n) kVar).fJK == 3) {
                com.tencent.mm.ui.base.g.a(this.context, this.context.getString(g.eao), this.context.getString(g.dIO), this.context.getString(g.dDj), this.context.getString(g.dGs), new OnClickListener(this) {
                    final /* synthetic */ a sLY;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.d("MicroMsg.AddContact", "dealwith verify relation out of date");
                        n nVar = (n) kVar;
                        LinkedList linkedList = (nVar.gUA == null || nVar.gUA.BG() == null) ? null : ((bje) nVar.gUA.hsj.hsr).uiS;
                        List list = ((n) kVar).sCv;
                        if (list != null && list.size() > 0) {
                            this.sLY.c((String) list.get(0), linkedList);
                        }
                    }
                }, null);
            }
        } else if (i2 != -2) {
            r(i, i2, str);
        } else if (bg.mA(str)) {
            r(i, i2, null);
        } else {
            com.tencent.mm.ui.base.g.a(this.context, str, this.context.getString(g.dIO), this.context.getString(g.dHT), null);
        }
    }

    private void r(int i, int i2, String str) {
        if (this.sLX && !bg.mA(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(g.dCh), 1).show();
        } else if (i == 4 && i2 == -24 && !bg.mA(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(g.dCg), 1).show();
        }
        c(false, false, this.sLR, this.sLW);
    }
}
