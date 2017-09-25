package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.oa;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class o implements OnClickListener, t, e {
    public a fyo;
    public ProgressDialog isv;

    public o(a aVar) {
        this.fyo = aVar;
    }

    public final void onClick(View view) {
        boolean z = true;
        boolean z2 = false;
        if (view.getTag() == null) {
            w.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
        } else if (view.getTag() instanceof dt) {
            dt dtVar = (dt) view.getTag();
            if (dtVar == null) {
                w.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
                return;
            }
            r1 = dtVar.fSU.appId;
            if (bg.mA(r1)) {
                w.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
            } else if (g.aJ(r1, false) == null) {
                w.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = " + r1);
            } else {
                z2 = true;
            }
            if (z2) {
                int i;
                String gi;
                an.aBG().a(2, (t) this);
                if (this.fyo.vBH) {
                    i = 2;
                } else {
                    i = 1;
                }
                r1 = this.fyo.bUg();
                if (com.tencent.mm.u.o.dH(r1)) {
                    gi = ay.gi(dtVar.fTk.field_content);
                } else {
                    gi = r1;
                }
                final f.a aVar = dtVar.fSU;
                com.tencent.mm.ui.base.g.a(this.fyo.bPj(), this.fyo.getString(R.l.dHD), this.fyo.getString(R.l.dHE), this.fyo.getString(R.l.dBF), this.fyo.getString(R.l.eIV), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ o vzv;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vzv.g(new x(2, new aj(aVar.appId, 0, "1")));
                        k kVar = l.a.sBw;
                        if (kVar != null) {
                            this.vzv.fyo.bPj();
                            kVar.a(gi, aVar.appId, aVar.type, i, aVar.mediaTagName, 1);
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ o vzv;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vzv.g(new x(2, new aj(aVar.appId, 0, "0")));
                        k kVar = l.a.sBw;
                        if (kVar != null) {
                            this.vzv.fyo.bPj();
                            kVar.a(gi, aVar.appId, aVar.type, i, aVar.mediaTagName, 2);
                        }
                    }
                });
            }
        } else if (view.getTag() instanceof el) {
            final el elVar = (el) view.getTag();
            if (elVar == null) {
                w.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            } else if (elVar == null || bg.mA(elVar.hir) || elVar.fTk == null) {
                String str = "MicroMsg.AppSpamClickListener";
                r1 = "wrong args, tag is null ? ";
                Object[] objArr = new Object[1];
                if (elVar != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                w.e(str, r1, objArr);
            } else {
                String[] strArr = new String[]{this.fyo.bPj().getString(R.l.eYc), this.fyo.bPj().getString(R.l.eYd), this.fyo.bPj().getString(R.l.dGs)};
                com.tencent.mm.ui.base.g.a(this.fyo.bPj(), null, strArr, null, true, new c(this) {
                    final /* synthetic */ o vzv;

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                Intent intent = new Intent();
                                try {
                                    intent.putExtra("rawUrl", String.format("http://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(elVar.rUK, "UTF-8"), URLEncoder.encode(elVar.hir, "UTF-8"), Long.valueOf(elVar.fTk.field_msgSvrId), Integer.valueOf((int) (elVar.fTk.field_createTime / 1000)), Integer.valueOf(42)}));
                                    intent.putExtra("show_bottom", false);
                                    intent.putExtra("showShare", false);
                                    d.b(this.vzv.fyo.bPj(), "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                } catch (UnsupportedEncodingException e) {
                                    w.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", e.getMessage());
                                    return;
                                }
                            case 1:
                                w.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", elVar.rUK, elVar.hir);
                                ap.vd().a(1030, this.vzv);
                                aki com_tencent_mm_protocal_c_aki = new aki();
                                com_tencent_mm_protocal_c_aki.teT = 1;
                                com_tencent_mm_protocal_c_aki.tOb = elVar.hir;
                                com_tencent_mm_protocal_c_aki.fDC = "";
                                LinkedList linkedList = new LinkedList();
                                linkedList.add(com_tencent_mm_protocal_c_aki);
                                b oaVar = new oa();
                                oaVar.fVh.fTJ = elVar.rUK;
                                oaVar.fVh.fVi = linkedList;
                                if (com.tencent.mm.sdk.b.a.urY.m(oaVar)) {
                                    o oVar = this.vzv;
                                    Context bPj = this.vzv.fyo.bPj();
                                    this.vzv.fyo.getString(R.l.dIO);
                                    oVar.isv = com.tencent.mm.ui.base.g.a(bPj, this.vzv.fyo.getString(R.l.dJd), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass1 vzw;

                                        {
                                            this.vzw = r1;
                                        }

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ap.vd().b(1030, this.vzw.vzv);
                                        }
                                    });
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    public final void g(final com.tencent.mm.y.k kVar) {
        ap.vd().a(kVar, 0);
        Context bPj = this.fyo.bPj();
        this.fyo.getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(bPj, this.fyo.getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ o vzv;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(kVar);
                an.aBG().b(2, this.vzv);
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.pluginsdk.model.app.w wVar) {
        w.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + i + ", errCode = " + i2);
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        an.aBG().b(2, this);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.ui.base.g.bl(this.fyo.bPj(), this.fyo.getString(R.l.epr));
        } else if (!p.a.a(this.fyo.bPj(), i, i2, str, 4)) {
            Toast.makeText(this.fyo.bPj(), this.fyo.getString(R.l.eoP, Integer.valueOf(i), Integer.valueOf(i2)), 0).show();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        ap.vd().b(1030, (e) this);
        if (i == 0 && i2 == 0) {
            com.tencent.mm.ui.base.g.bl(this.fyo.bPj(), this.fyo.getString(R.l.epr));
            return;
        }
        Toast.makeText(this.fyo.bPj(), this.fyo.getString(R.l.eYe, Integer.valueOf(i), Integer.valueOf(i2)), 0).show();
    }
}
