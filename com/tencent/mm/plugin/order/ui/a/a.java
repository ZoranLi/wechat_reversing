package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.order.model.a.a {
    public c oii;

    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        CharSequence string;
        com.tencent.mm.j.a Rc;
        f fVar2;
        List<Preference> arrayList = new ArrayList();
        Object obj = mallTransactionObject.fyT == 2 ? 1 : null;
        if (!(bg.mA(mallTransactionObject.ogc) || bg.mA(mallTransactionObject.iEP))) {
            d dVar = new d(context);
            dVar.lia = mallTransactionObject.iEP;
            dVar.mName = mallTransactionObject.ogc;
            dVar.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ a oik;

                public final void onClick(View view) {
                    if (!bg.mA(mallTransactionObject.ogb)) {
                        e.P(context, mallTransactionObject.ogb);
                    }
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.oiI = e.d(mallTransactionObject.kBc, mallTransactionObject.oga);
        if (obj != null) {
            string = context.getString(R.l.fgP);
        } else if (mallTransactionObject.ofL == 11) {
            string = context.getString(R.l.fhp);
        } else {
            string = context.getString(R.l.fgO);
        }
        iVar.setTitle(string);
        if (!bg.mA(mallTransactionObject.ofS)) {
            iVar.Cu(mallTransactionObject.ofS);
        }
        arrayList.add(iVar);
        boolean z = false;
        if (mallTransactionObject.kBc != mallTransactionObject.ogg) {
            h hVar = new h(context);
            hVar.oiF = false;
            hVar.oiG = true;
            arrayList.add(hVar);
            f fVar3 = new f(context);
            fVar3.setContent(e.d(mallTransactionObject.ogg, mallTransactionObject.oga));
            fVar3.setTitle(R.l.fhh);
            arrayList.add(fVar3);
            z = true;
        }
        if (!(mallTransactionObject.kBc == mallTransactionObject.ogg || bg.mA(mallTransactionObject.ogf))) {
            g gVar = new g(context);
            gVar.setTitle(R.l.fgW);
            gVar.jid = fVar;
            String[] split = mallTransactionObject.ogf.split("\n");
            if (split.length == 1) {
                gVar.oiy = split[0];
            } else {
                gVar.oiy = context.getString(R.l.fgX, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.ogg - mallTransactionObject.kBc, mallTransactionObject.oga)});
                gVar.a(split, TruncateAt.MIDDLE);
            }
            arrayList.add(gVar);
        }
        h hVar2 = new h(context);
        hVar2.oiF = z;
        hVar2.oiG = true;
        arrayList.add(hVar2);
        if (obj == null && !bg.mA(mallTransactionObject.ogp)) {
            ap.yY();
            Rc = com.tencent.mm.u.c.wR().Rc(mallTransactionObject.ogp);
            if (Rc != null && ((int) Rc.gTQ) > 0) {
                String tL = Rc.tL();
                f fVar4 = new f(context);
                fVar4.setTitle(R.l.cRh);
                fVar4.setContent(tL);
                arrayList.add(fVar4);
            }
        }
        if (!(mallTransactionObject.ofL != 31 || obj == null || bg.mA(mallTransactionObject.ogw))) {
            ap.yY();
            Rc = com.tencent.mm.u.c.wR().Rc(mallTransactionObject.ogw);
            if (Rc != null && ((int) Rc.gTQ) > 0) {
                tL = Rc.tL();
                fVar4 = new f(context);
                fVar4.setTitle(R.l.fhf);
                fVar4.setContent(tL);
                arrayList.add(fVar4);
            }
        }
        if (!bg.mA(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar2 = new f(context);
                if (mallTransactionObject.ofL == 32 || mallTransactionObject.ofL == 33 || mallTransactionObject.ofL == 31) {
                    fVar2.setTitle(R.l.fgT);
                } else {
                    fVar2.setTitle(R.l.fhf);
                }
                fVar2.setContent(mallTransactionObject.desc);
                arrayList.add(fVar2);
            } else {
                fVar2 = new f(context);
                if (mallTransactionObject.ofL == 31) {
                    fVar2.setTitle(R.l.fhl);
                } else {
                    fVar2.setTitle(R.l.cQP);
                }
                if (bg.mA(mallTransactionObject.ofQ)) {
                    fVar2.setContent(mallTransactionObject.desc);
                } else {
                    tL = context.getString(R.l.fgS);
                    fVar2.a(mallTransactionObject.desc + " " + tL, mallTransactionObject.desc.length() + 1, tL.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener(this) {
                        final /* synthetic */ a oik;

                        public final void onClick(View view) {
                            fVar2.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.ofQ);
                            fVar.notifyDataSetChanged();
                        }
                    });
                }
                arrayList.add(fVar2);
            }
        }
        if (!bg.mA(mallTransactionObject.ogA)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.cRp);
            fVar2.setContent(mallTransactionObject.ogA);
            arrayList.add(fVar2);
        }
        if (!bg.mA(mallTransactionObject.ogz)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fhA);
            fVar2.setContent(mallTransactionObject.ogz);
            arrayList.add(fVar2);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.ogr)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fgR);
            fVar2.setContent(mallTransactionObject.ogr);
            arrayList.add(fVar2);
        }
        if (!bg.mA(mallTransactionObject.ofP)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fhg);
            fVar2.setContent(mallTransactionObject.ofP);
            arrayList.add(fVar2);
        }
        if (!bg.mA(mallTransactionObject.ofU)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fhs);
            if (mallTransactionObject.ofL != 31 || m.xL().equals(mallTransactionObject.ogp) || mallTransactionObject.ogq <= 0 || bg.mA(mallTransactionObject.ogp) || bg.mA(mallTransactionObject.fTA)) {
                fVar2.setContent(mallTransactionObject.ofU);
                if (!bg.mA(mallTransactionObject.ofV)) {
                    fVar2.Ct(mallTransactionObject.ofV);
                }
            } else {
                tL = context.getString(R.l.eLu);
                fVar2.a(mallTransactionObject.ofU + " " + tL, mallTransactionObject.ofU.length() + 1, (tL.length() + mallTransactionObject.ofU.length()) + 1, new OnClickListener(this) {
                    final /* synthetic */ a oik;

                    public final void onClick(View view) {
                        g.a(context, context.getString(R.l.eKx), context.getString(R.l.dIs), context.getString(R.l.eLt), context.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 oim;

                            {
                                this.oim = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("transaction_id", mallTransactionObject.fTA);
                                intent.putExtra("receiver_name", mallTransactionObject.ogp);
                                intent.putExtra("resend_msg_from_flag", 1);
                                d.b(context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 oim;

                            {
                                this.oim = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                });
            }
            arrayList.add(fVar2);
        }
        fVar2 = new f(context);
        fVar2.setTitle(R.l.fgV);
        fVar2.setContent(e.CK(mallTransactionObject.hFf));
        arrayList.add(fVar2);
        if (!bg.mA(mallTransactionObject.ofY)) {
            fVar3 = new f(context);
            fVar3.setTitle(R.l.fhi);
            String str = mallTransactionObject.ofY;
            if (!bg.mA(mallTransactionObject.ofZ)) {
                str = str + "(" + mallTransactionObject.ofZ + ")";
            }
            fVar3.setContent(str);
            arrayList.add(fVar3);
        }
        if (!bg.mA(mallTransactionObject.fTA)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.cRn);
            fVar2.setContent(mallTransactionObject.fTA);
            arrayList.add(fVar2);
        }
        if (!bg.mA(mallTransactionObject.ofX)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fhq);
            if (mallTransactionObject.ofL == 8) {
                fVar2.setContent(context.getString(R.l.fhr));
                c cVar = new c(context);
                final Bitmap b = com.tencent.mm.bf.a.a.b(context, mallTransactionObject.ofX, 5, 0);
                cVar.oiq = e.UN(mallTransactionObject.ofX);
                cVar.hqW = b;
                cVar.mOnClickListener = new OnClickListener(this) {
                    final /* synthetic */ a oik;

                    public final void onClick(View view) {
                        if (this.oik.oii != null) {
                            a aVar = this.oik;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.ofX;
                            if (aVar.oii != null) {
                                aVar.oii.eZ(str, str);
                                aVar.oii.odN = bitmap;
                                aVar.oii.odO = bitmap;
                                aVar.oii.ccx();
                            }
                            this.oik.oii.t(view, true);
                        }
                    }
                };
                arrayList.add(fVar2);
                arrayList.add(cVar);
            } else {
                fVar2.setContent(mallTransactionObject.ofX);
                arrayList.add(fVar2);
            }
        }
        obj = mallTransactionObject.ofA.size() == 0 ? null : 1;
        if (obj != null || (bg.mA(mallTransactionObject.ogk) && bg.mA(mallTransactionObject.ogb) && bg.mA(mallTransactionObject.ofD))) {
            hVar = new h(context);
            hVar.oiF = true;
            hVar.jzz = false;
            arrayList.add(hVar);
        } else {
            hVar = new h(context);
            hVar.oiF = true;
            arrayList.add(hVar);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (obj != null) {
            j jVar = new j(context);
            if (mallTransactionObject.ofB == 1) {
                if (!(bg.mA(mallTransactionObject.ogk) && bg.mA(mallTransactionObject.ogb) && bg.mA(mallTransactionObject.ofD))) {
                    if (bg.mA(mallTransactionObject.ogl)) {
                        jVar.oiJ = context.getString(R.l.fhw);
                    } else {
                        jVar.oiJ = mallTransactionObject.ogl;
                    }
                    jVar.oiK = new OnClickListener(this) {
                        final /* synthetic */ a oik;

                        public final void onClick(View view) {
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!bg.mA(mallTransactionObject.ogb)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(R.l.fhu));
                            }
                            if (!bg.mA(mallTransactionObject.ofD)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(R.l.fhv));
                            }
                            if (!bg.mA(mallTransactionObject.ogk)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(R.l.fhx));
                            }
                            if (linkedList2.size() == 1) {
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                return;
                            }
                            g.a(context, null, linkedList, linkedList2, null, true, new g.d(this) {
                                final /* synthetic */ AnonymousClass5 oin;

                                {
                                    this.oin = r1;
                                }

                                public final void bN(int i, int i2) {
                                    com.tencent.mm.plugin.order.model.a.a(i2, context, mallTransactionObject);
                                }
                            });
                        }
                    };
                }
            } else if (!bg.mA(mallTransactionObject.ogl)) {
                jVar.oiJ = mallTransactionObject.ogl;
                jVar.oiK = new OnClickListener(this) {
                    final /* synthetic */ a oik;

                    public final void onClick(View view) {
                        a.a(context, mallTransactionObject.ogk, mallTransactionObject);
                    }
                };
            }
            jVar.ofA = mallTransactionObject.ofA;
            jVar.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ a oik;

                public final void onClick(View view) {
                    if (view.getTag() != null && (view.getTag() instanceof HelpCenter)) {
                        a.a(context, ((HelpCenter) view.getTag()).url, mallTransactionObject);
                    }
                }
            };
            hVar = new h(context);
            hVar.oiF = true;
            arrayList.add(hVar);
            arrayList.add(jVar);
        }
        return arrayList;
    }

    public static void a(Context context, String str, MallTransactionObject mallTransactionObject) {
        String ap;
        Intent intent = new Intent();
        Uri parse = Uri.parse(str);
        String str2 = mallTransactionObject.fTA;
        String deviceID = p.getDeviceID(context);
        String str3 = "bssid";
        String str4 = com.tencent.mm.protocal.d.DEVICE_TYPE;
        String str5 = Build.MODEL;
        String rP = p.rP();
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                ap = bg.ap(connectionInfo.getBSSID(), "");
                w.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", new Object[]{parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", ap).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", rP).build().toString()});
                intent.putExtra("rawUrl", ap);
                intent.putExtra("geta8key_username", m.xL());
                d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        }
        ap = str3;
        w.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", new Object[]{parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", ap).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", rP).build().toString()});
        intent.putExtra("rawUrl", ap);
        intent.putExtra("geta8key_username", m.xL());
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
