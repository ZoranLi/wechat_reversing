package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import junit.framework.Assert;

public final class m implements e {
    public Context context;
    p irJ;
    public EditText oBT;
    LinkedList<Integer> oGJ;
    public h oHT = null;
    public View oHU;
    public TextView oHV;
    String sLQ;
    public a sNs;
    LinkedList<String> sNt;
    boolean sNu = true;

    public interface a {
        void dl(boolean z);
    }

    public m(Context context, a aVar) {
        this.context = context;
        this.sNs = aVar;
    }

    final void onStart() {
        com.tencent.mm.kernel.h.vH().gXC.a(30, (e) this);
    }

    public final void onStop() {
        com.tencent.mm.kernel.h.vH().gXC.b(30, (e) this);
        if (this.oHT != null) {
            this.oHT.dismiss();
            this.oHT = null;
        }
    }

    public final void g(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        boolean z;
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.sNt = linkedList;
        this.oGJ = linkedList2;
        this.oHU = View.inflate(this.context, com.tencent.mm.plugin.comm.a.e.dnR, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.sLQ == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.sLQ == null ? 0 : this.sLQ.length());
        objArr[2] = this.sLQ;
        w.i(str, str2, objArr);
        if (!bg.mA(this.sLQ)) {
            ((TextView) this.oHU.findViewById(d.cCA)).setText(this.sLQ);
        }
        this.oBT = (EditText) this.oHU.findViewById(d.cCz);
        this.oHV = (TextView) this.oHU.findViewById(d.cTh);
        this.oHV.setVisibility(0);
        this.oBT.setText(null);
        this.oHV.setText("50");
        this.oBT.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.sWw);
        this.oBT.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ m sNv;

            {
                this.sNv = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (this.sNv.oHV != null) {
                    this.sNv.oHV.setText(String.valueOf(length));
                }
            }
        });
        this.oHT = g.a(this.context, this.context.getString(com.tencent.mm.plugin.comm.a.g.eRn), this.oHU, new OnClickListener(this) {
            final /* synthetic */ m sNv;

            {
                this.sNv = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.sNv.oHT != null) {
                    this.sNv.oHT.dismiss();
                    this.sNv.oHT = null;
                }
                new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                    final /* synthetic */ AnonymousClass2 sNw;

                    {
                        this.sNw = r1;
                    }

                    public final boolean oQ() {
                        if (this.sNw.sNv.oHU != null) {
                            m mVar = this.sNw.sNv;
                            String trim = this.sNw.sNv.oBT.getText().toString().trim();
                            Context context = mVar.context;
                            mVar.context.getString(com.tencent.mm.plugin.comm.a.g.dIO);
                            mVar.irJ = g.a(context, mVar.context.getString(com.tencent.mm.plugin.comm.a.g.eRm), true, new OnCancelListener(mVar) {
                                final /* synthetic */ m sNv;

                                {
                                    this.sNv = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.sNv.onStop();
                                    if (this.sNv.sNs != null) {
                                        this.sNv.sNs.dl(false);
                                    }
                                }
                            });
                            com.tencent.mm.kernel.h.vH().gXC.a(new n(2, mVar.sNt, mVar.oGJ, trim, ""), 0);
                        }
                        return false;
                    }
                }, false).v(500, 500);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ m sNv;

            {
                this.sNv = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.sNv.oHT != null) {
                    this.sNv.oHT.dismiss();
                    this.sNv.oHT = null;
                }
                this.sNv.onStop();
                if (this.sNv.sNs != null) {
                    this.sNv.sNs.dl(false);
                }
            }
        });
        if (this.oHT == null) {
            onStop();
        }
        this.oBT.post(new Runnable(this) {
            final /* synthetic */ m sNv;

            {
                this.sNv = r1;
            }

            public final void run() {
                if (this.sNv.context instanceof MMActivity) {
                    ((MMActivity) this.sNv.context).aHj();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 30) {
            w.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + kVar.getType());
            return;
        }
        w.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        onStop();
        if (i == 0 && i2 == 0) {
            if (this.sNu) {
                g.bl(this.context, this.context.getString(com.tencent.mm.plugin.comm.a.g.eRl));
            }
            this.sNs.dl(true);
            return;
        }
        if (i == 4 && i2 == -34) {
            str = this.context.getString(com.tencent.mm.plugin.comm.a.g.eld);
        } else if (i == 4 && i2 == -94) {
            str = this.context.getString(com.tencent.mm.plugin.comm.a.g.ele);
        } else if (!(i == 4 && i2 == -24 && !bg.mA(str)) && (i != 4 || bg.mA(str))) {
            str = this.context.getString(com.tencent.mm.plugin.comm.a.g.eRk);
        }
        if (this.sNu) {
            Toast.makeText(this.context, str, 1).show();
        }
        this.sNs.dl(false);
    }
}
