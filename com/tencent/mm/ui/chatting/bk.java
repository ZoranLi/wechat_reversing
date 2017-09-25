package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.b;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class bk extends ah {
    static int vDj = Color.parseColor("#888888");
    static int vDk = Color.parseColor("#888888");
    public String ivH;
    private OnClickListener llr;
    public p uWc;
    public c uWl;
    public a vCd;
    private OnClickListener vDe;
    private OnClickListener vDf;
    private OnClickListener vDg;
    private b vDh;
    public String vDi;
    public com.tencent.mm.sdk.b.c<kj> vxU;

    public bk() {
        super(40);
        c.a aVar = new c.a();
        aVar.hJa = R.g.bcY;
        this.uWl = aVar.Hg();
        this.vDe = new OnClickListener(this) {
            final /* synthetic */ bk vDl;

            {
                this.vDl = r1;
            }

            public final void onClick(final View view) {
                final au auVar = (au) view.getTag(R.h.cnz);
                if (auVar == null) {
                    w.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                    return;
                }
                Map q = bh.q(auVar.field_content, "msg");
                if (q != null && q.size() != 0) {
                    final String mz = bg.mz((String) q.get(".msg.fromusername"));
                    WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(mz);
                    final int n = bg.n(q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1);
                    final int n2 = bg.n(q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1);
                    e eVar = new e(view.getContext(), e.wuP, false);
                    final boolean z = og != null && (og.field_appOpt & 1) > 0;
                    if (z) {
                        eVar.d(view.getResources().getString(R.l.eFa), 3);
                    } else {
                        eVar.d(view.getResources().getString(R.l.eEN), 3);
                    }
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass1 vDn;

                        public final void a(l lVar) {
                            if (z) {
                                lVar.a(1, view.getResources().getColor(R.e.aUd), view.getResources().getString(R.l.eEZ));
                            } else {
                                lVar.a(0, view.getResources().getColor(R.e.aVE), view.getResources().getString(R.l.eEM));
                            }
                            lVar.add(0, 2, 0, view.getResources().getString(R.l.eER));
                        }
                    };
                    final View view2 = view;
                    eVar.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass1 vDn;

                        public final void c(MenuItem menuItem, int i) {
                            w.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i));
                            com.tencent.mm.sdk.b.b riVar;
                            LinkedList linkedList;
                            bek com_tencent_mm_protocal_c_bek;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    ((ea) view2.getTag(R.h.cnh)).vNw.setVisibility(0);
                                    riVar = new ri();
                                    riVar.fYq.fCJ = mz;
                                    riVar.fYq.action = 1;
                                    riVar.fYq.fYs = 1;
                                    com.tencent.mm.sdk.b.a.urY.m(riVar);
                                    linkedList = new LinkedList();
                                    com_tencent_mm_protocal_c_bek = new bek();
                                    com_tencent_mm_protocal_c_bek.ufl = mz;
                                    com_tencent_mm_protocal_c_bek.ufk = 0;
                                    com_tencent_mm_protocal_c_bek.jOc = 1;
                                    linkedList.add(com_tencent_mm_protocal_c_bek);
                                    bk.v(2, this.vDn.vDl.ivH, this.vDn.vDl.vDi);
                                    ap.vd().a(1176, new com.tencent.mm.y.e(this) {
                                        final /* synthetic */ AnonymousClass2 vDp;

                                        {
                                            this.vDp = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            ap.vd().b(1176, (com.tencent.mm.y.e) this);
                                            w.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true));
                                            if (auVar != view2.getTag(R.h.cnz)) {
                                                w.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(auVar.field_msgId));
                                            } else if (i != 0 || i2 != 0) {
                                                ((ea) view2.getTag(R.h.cnh)).vNw.setVisibility(8);
                                                s.makeText(view2.getContext(), R.l.eEW, 0).show();
                                                com.tencent.mm.sdk.b.b riVar = new ri();
                                                riVar.fYq.fCJ = mz;
                                                riVar.fYq.action = 2;
                                                riVar.fYq.fYs = 1;
                                                com.tencent.mm.sdk.b.a.urY.m(riVar);
                                                if (this.vDp.vDn.vDl.vCd != null) {
                                                    this.vDp.vDn.vDl.vCd.bSe();
                                                }
                                            }
                                        }
                                    });
                                    ap.vd().a(new j(linkedList), 0);
                                    if (this.vDn.vDl.vCd != null) {
                                        this.vDn.vDl.vCd.bSe();
                                        return;
                                    }
                                    return;
                                case 1:
                                    ((ea) view2.getTag(R.h.cnh)).vNw.setVisibility(8);
                                    riVar = new ri();
                                    riVar.fYq.fCJ = mz;
                                    riVar.fYq.action = 2;
                                    riVar.fYq.fYs = 1;
                                    com.tencent.mm.sdk.b.a.urY.m(riVar);
                                    linkedList = new LinkedList();
                                    com_tencent_mm_protocal_c_bek = new bek();
                                    com_tencent_mm_protocal_c_bek.ufl = mz;
                                    com_tencent_mm_protocal_c_bek.ufk = 1;
                                    com_tencent_mm_protocal_c_bek.jOc = 1;
                                    linkedList.add(com_tencent_mm_protocal_c_bek);
                                    bk.v(3, this.vDn.vDl.ivH, this.vDn.vDl.vDi);
                                    ap.vd().a(1176, new com.tencent.mm.y.e(this) {
                                        final /* synthetic */ AnonymousClass2 vDp;

                                        {
                                            this.vDp = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            ap.vd().b(1176, (com.tencent.mm.y.e) this);
                                            w.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                            if (auVar != view2.getTag(R.h.cnz)) {
                                                w.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(auVar.field_msgId));
                                            } else if (i != 0 || i2 != 0) {
                                                ((ea) view2.getTag(R.h.cnh)).vNw.setVisibility(0);
                                                s.makeText(view2.getContext(), R.l.eEW, 0).show();
                                                com.tencent.mm.sdk.b.b riVar = new ri();
                                                riVar.fYq.fCJ = mz;
                                                riVar.fYq.action = 1;
                                                riVar.fYq.fYs = 1;
                                                com.tencent.mm.sdk.b.a.urY.m(riVar);
                                                if (this.vDp.vDn.vDl.vCd != null) {
                                                    this.vDp.vDn.vDl.vCd.bSe();
                                                }
                                            }
                                        }
                                    });
                                    ap.vd().a(new j(linkedList), 0);
                                    if (this.vDn.vDl.vCd != null) {
                                        this.vDn.vDl.vCd.bSe();
                                        return;
                                    }
                                    return;
                                case 2:
                                    ap.vd().a(1198, new com.tencent.mm.y.e(this) {
                                        final /* synthetic */ AnonymousClass2 vDp;

                                        {
                                            this.vDp = r1;
                                        }

                                        public final void a(int i, int i2, String str, k kVar) {
                                            bqu com_tencent_mm_protocal_c_bqu = null;
                                            ap.vd().b(1198, (com.tencent.mm.y.e) this);
                                            w.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false));
                                            if (this.vDp.vDn.vDl.uWc != null) {
                                                this.vDp.vDn.vDl.uWc.dismiss();
                                                this.vDp.vDn.vDl.uWc = null;
                                            }
                                            if (i == 0 && i2 == 0) {
                                                com.tencent.mm.modelappbrand.n nVar = (com.tencent.mm.modelappbrand.n) kVar;
                                                if (nVar.hpV != null) {
                                                    com_tencent_mm_protocal_c_bqu = (bqu) nVar.hpV.hsk.hsr;
                                                }
                                                if (com_tencent_mm_protocal_c_bqu == null) {
                                                    s.makeText(view2.getContext(), R.l.eES, 0).show();
                                                    return;
                                                }
                                                final String str2 = com_tencent_mm_protocal_c_bqu.uoQ;
                                                w.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", mz);
                                                ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).a(mz, new com.tencent.mm.plugin.appbrand.i.b.a(this) {
                                                    final /* synthetic */ AnonymousClass3 vDq;

                                                    public final void c(WxaAttributes wxaAttributes) {
                                                        if (wxaAttributes == null) {
                                                            s.makeText(view2.getContext(), R.l.eEW, 0).show();
                                                            return;
                                                        }
                                                        if (TextUtils.isEmpty(wxaAttributes.field_appId) || TextUtils.isEmpty(str2)) {
                                                            w.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", r0, str2);
                                                            s.makeText(view2.getContext(), R.l.eEW, 0).show();
                                                            return;
                                                        }
                                                        try {
                                                            w.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), Integer.valueOf(1), Integer.valueOf(n), Integer.valueOf(n2)}));
                                                            Intent intent = new Intent();
                                                            intent.putExtra("rawUrl", r1);
                                                            com.tencent.mm.bb.d.b(this.vDq.vDp.vDn.vDl.vCd.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                                                        } catch (UnsupportedEncodingException e) {
                                                            w.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                                            s.makeText(view2.getContext(), R.l.eEW, 0).show();
                                                        }
                                                    }
                                                });
                                                return;
                                            }
                                            s.makeText(view2.getContext(), R.l.eES, 0).show();
                                        }
                                    });
                                    final k nVar = new com.tencent.mm.modelappbrand.n(auVar.field_content);
                                    bk bkVar = this.vDn.vDl;
                                    Context context = view2.getContext();
                                    view2.getResources().getString(R.l.dIO);
                                    bkVar.uWc = g.a(context, view2.getResources().getString(R.l.dJd), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass2 vDp;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            ap.vd().c(nVar);
                                        }
                                    });
                                    ap.vd().a(nVar, 0);
                                    bk.v(4, this.vDn.vDl.ivH, this.vDn.vDl.vDi);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    eVar.bzh();
                }
            }
        };
        this.vDf = new OnClickListener(this) {
            final /* synthetic */ bk vDl;

            {
                this.vDl = r1;
            }

            public final void onClick(View view) {
                dt dtVar = (dt) view.getTag();
                w.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", dtVar.userName);
                Map q = bh.q(dtVar.fTk.field_content, "msg");
                if (!(q == null || q.size() == 0)) {
                    bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                }
                bk bkVar = this.vDl;
                view.getContext();
                String str = dtVar.userName;
                WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
                if (og != null) {
                    bk.v(1, og.field_appId, bkVar.vDi);
                }
                Intent intent = new Intent();
                intent.putExtra("key_username", str);
                intent.putExtra("key_from_scene", 5);
                if (og != null) {
                    WxaExposedParams.a aVar = new WxaExposedParams.a();
                    aVar.appId = og.field_appId;
                    aVar.fFr = 6;
                    intent.putExtra("key_scene_exposed_params", aVar.RL());
                }
                com.tencent.mm.bb.d.b(bkVar.vCd.uSU.uTo, "appbrand", ".ui.AppBrandProfileUI", intent);
            }
        };
        this.vxU = new com.tencent.mm.sdk.b.c<kj>(this) {
            final /* synthetic */ bk vDl;

            {
                this.vDl = r2;
                this.usg = kj.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (this.vDl.vCd != null) {
                    this.vDl.vCd.uSU.uTo.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 vDz;

                        {
                            this.vDz = r1;
                        }

                        public final void run() {
                            this.vDz.vDl.vCd.bSe();
                        }
                    });
                }
                return true;
            }
        };
        this.vDh = new b(this) {
            final /* synthetic */ bk vDl;

            {
                this.vDl = r1;
            }

            public final void bUr() {
            }

            public final void bUs() {
            }

            public final void bUt() {
                w.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExit, then remove AppBrandTmplMsgReceivingSwitchListener.");
                com.tencent.mm.sdk.b.a.urY.c(this.vDl.vxU);
                if (this.vDl.vCd != null) {
                    this.vDl.vCd.b((b) this);
                }
            }
        };
        this.vDg = new OnClickListener(this) {
            final /* synthetic */ bk vDl;

            {
                this.vDl = r1;
            }

            public final void onClick(View view) {
                dt dtVar = (dt) view.getTag();
                w.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", dtVar.userName);
                com.tencent.mm.sdk.b.b prVar = new pr();
                prVar.fWB.userName = dtVar.userName;
                prVar.fWB.fWD = dtVar.vNd;
                Map q = bh.q(dtVar.fTk.field_content, "msg");
                String str = "";
                if (q != null && q.size() > 0) {
                    prVar.fWB.fWE = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                    str = bg.mz((String) q.get(".msg.appmsg.template_id"));
                }
                prVar.fWB.fWH = true;
                prVar.fWB.scene = 1014;
                prVar.fWB.fCN = dtVar.fTk.field_msgSvrId + ":" + dtVar.userName + ":" + this.vDl.vCd.bUg() + ":" + str;
                com.tencent.mm.sdk.b.a.urY.m(prVar);
                bk.v(9, this.vDl.ivH, this.vDl.vDi);
                com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, dtVar.userName, Integer.valueOf(0));
            }
        };
        this.llr = new OnClickListener(this) {
            final /* synthetic */ bk vDl;

            {
                this.vDl = r1;
            }

            public final void onClick(View view) {
                dt dtVar = (dt) view.getTag();
                Map q = bh.q(dtVar.fTk.field_content, "msg");
                if (q == null) {
                    w.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
                    return;
                }
                String str = (String) q.get(".msg.appmsg.mmreader.category.item.weapp_username");
                String str2 = (String) q.get(".msg.appmsg.mmreader.category.item.weapp_path");
                int i = bg.getInt((String) q.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
                int i2 = bg.getInt((String) q.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
                String mz = bg.mz((String) q.get(".msg.appmsg.template_id"));
                w.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", str);
                com.tencent.mm.sdk.b.b prVar = new pr();
                prVar.fWB.userName = str;
                prVar.fWB.fWD = str2;
                prVar.fWB.fWE = i2;
                prVar.fWB.fWF = i;
                prVar.fWB.fWH = true;
                prVar.fWB.scene = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(dtVar.userName) ? 1014 : 1043;
                prVar.fWB.fCN = dtVar.fTk.field_msgSvrId + ":" + dtVar.userName + ":" + this.vDl.vCd.bUg() + ":" + mz;
                com.tencent.mm.sdk.b.a.urY.m(prVar);
                bk.v(9, this.vDl.ivH, this.vDl.vDi);
                com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, dtVar.userName, Integer.valueOf(0));
            }
        };
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXC);
        dl dlVar = new dl(this.knu);
        dlVar.mfD = (CheckBox) view.findViewById(R.h.bAd);
        dlVar.nRW = view.findViewById(R.h.bAX);
        dlVar.piH = (TextView) view.findViewById(R.h.bBG);
        dlVar.ipv = (ImageView) view.findViewById(R.h.bzT);
        dlVar.kxi = (TextView) view.findViewById(R.h.bBA);
        dlVar.vzQ = (LinearLayout) view.findViewById(R.h.bAk);
        dlVar.vHY.oKs = view.findViewById(R.h.bAK);
        dlVar.vHY.vIa = view.findViewById(R.h.bVV);
        dlVar.vHY.iUO = (TextView) dlVar.vHY.oKs.findViewById(R.h.title);
        dlVar.vHY.mzk = (TextView) dlVar.vHY.oKs.findViewById(R.h.cIm);
        dlVar.vHY.vIb = (LinearLayout) dlVar.vHY.oKs.findViewById(R.h.bJw);
        dlVar.vHY.vzU = (TextView) dlVar.vzQ.findViewById(R.h.bIt);
        dlVar.vHY.vIc = dlVar.vzQ.findViewById(R.h.cCB);
        dlVar.vHZ.vNr = view.findViewById(R.h.bAJ);
        dlVar.vHZ.vNs = (ImageView) view.findViewById(R.h.cnx);
        dlVar.vHZ.vNt = view.findViewById(R.h.cnv);
        dlVar.vHZ.vNv = (TextView) view.findViewById(R.h.cnK);
        dlVar.vHZ.vNu = (ImageView) view.findViewById(R.h.cng);
        dlVar.vHZ.vNw = view.findViewById(R.h.cnh);
        dlVar.vHZ.vNx = view.findViewById(R.h.cnz);
        dlVar.vHZ.vNy = (TextView) view.findViewById(R.h.cnE);
        dlVar.vHZ.vNz = (TextView) view.findViewById(R.h.cnD);
        dlVar.vHZ.vNA = (TextView) view.findViewById(R.h.cnu);
        dlVar.vHZ.vNB = view.findViewById(R.h.cnw);
        dlVar.vHZ.vNC = (LinearLayout) view.findViewById(R.h.cnF);
        dlVar.vHZ.vND = (TextView) view.findViewById(R.h.cnH);
        dlVar.vHZ.vNF = (TextView) view.findViewById(R.h.cnI);
        dlVar.vHZ.vNE = (TextView) view.findViewById(R.h.cnJ);
        dlVar.vHZ.vNG = view.findViewById(R.h.cnG);
        dlVar.vHZ.vNH = (LinearLayout) view.findViewById(R.h.cny);
        dlVar.vHZ.vNL = view.findViewById(R.h.cnt);
        dlVar.vHZ.vNI = view.findViewById(R.h.buK);
        dlVar.vHZ.vNJ = (LinearLayout) view.findViewById(R.h.cnr);
        dlVar.vHZ.vNK = (LinearLayout) view.findViewById(R.h.bKD);
        dlVar.vHZ.vNM = (LinearLayout) view.findViewById(R.h.cni);
        dlVar.vHZ.vNP = (TextView) view.findViewById(R.h.cnk);
        dlVar.vHZ.vNR = (ImageView) view.findViewById(R.h.cnj);
        dlVar.vHZ.vNO = view.findViewById(R.h.cns);
        dlVar.vHZ.vNN = (LinearLayout) view.findViewById(R.h.cnl);
        dlVar.vHZ.vNQ = (TextView) view.findViewById(R.h.cnn);
        dlVar.vHZ.vNS = (ImageView) view.findViewById(R.h.cnm);
        dlVar.vHZ.vNT = (ImageView) view.findViewById(R.h.cnf);
        dlVar.vyV = (ImageView) view.findViewById(R.h.bAI);
        dlVar.vHZ.vNU = view.findViewById(R.h.cnA);
        dlVar.vHZ.vNV = (ImageView) view.findViewById(R.h.cnB);
        dlVar.vHZ.vNW = (TextView) view.findViewById(R.h.cnC);
        view.setTag(dlVar);
        return view;
    }

    protected final boolean bUp() {
        return false;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        aVar = (dl) aVar;
        Map q = bh.q(auVar.field_content, "msg");
        if (q == null || q.size() == 0) {
            w.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            aVar.vzQ.setVisibility(8);
            return;
        }
        aVar.vzQ.setVisibility(0);
        int i2 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.vDi = bg.mz((String) q.get(".msg.appmsg.template_id"));
        com.tencent.mm.sdk.b.a.urY.c(this.vxU);
        aVar2.b(this.vDh);
        String mz;
        String str2;
        String str3;
        dt dtVar;
        if (i2 != 0) {
            CharSequence charSequence;
            int paddingLeft;
            Object obj;
            boolean z;
            final ea eaVar;
            int d;
            int d2;
            String str4;
            aVar.vHY.oKs.setVisibility(8);
            ea eaVar2 = aVar.vHZ;
            if (bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                a(eaVar2, bg.mz((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bg.mz((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")));
            } else if (bg.getInt((String) q.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                a(eaVar2, bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.icon_url")), bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.display_name")));
            } else if ("notifymessage".equals(auVar.field_talker)) {
                mz = bg.mz((String) q.get(".msg.fromusername"));
                if (((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(mz)) {
                    WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(mz);
                    a(eaVar2.vNu, this.vCd, mz, auVar, og == null ? null : og.field_brandIconURL);
                    charSequence = og == null ? mz : og.field_nickname;
                } else {
                    a(eaVar2.vNu, this.vCd, mz, auVar, null);
                    charSequence = this.vCd.eK(mz);
                }
                eaVar2.vNv.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.vCd.uSU.uTo, charSequence, eaVar2.vNv.getTextSize()));
                if (((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(mz)) {
                    eaVar2.vNt.setTag(new dt(auVar, mz, 0));
                    eaVar2.vNt.setOnClickListener(this.vDf);
                } else {
                    eaVar2.vNt.setTag(new dt(mz, 1, this.vCd.vBH ? this.vCd.bUg() : null));
                    eaVar2.vNt.setOnClickListener(this.vCd.vBD.vEW);
                }
                eaVar2.vNt.setVisibility(0);
            } else {
                eaVar2.vNt.setVisibility(8);
            }
            if (bg.getInt((String) q.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                eaVar2.vNt.setBackgroundResource(R.g.bhc);
            } else {
                paddingLeft = eaVar2.vNt.getPaddingLeft();
                eaVar2.vNt.setBackgroundResource(R.g.bgh);
                eaVar2.vNt.setPadding(paddingLeft, 0, 0, 0);
            }
            int i3 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            if (i3 == 0) {
                eaVar2.vNy.setVisibility(0);
                charSequence = bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.title"));
                eaVar2.vNy.setTextColor(d(q, ".msg.appmsg.mmreader.template_header.title_color", WebView.NIGHT_MODE_COLOR));
                eaVar2.vNy.setText(charSequence);
                long j = bg.getLong(bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.pub_time")), 0);
                if (j > 0) {
                    eaVar2.vNz.setText(o.Z(this.vCd.getString(R.l.elr), j));
                    eaVar2.vNz.setVisibility(0);
                } else {
                    eaVar2.vNz.setVisibility(8);
                }
            } else {
                eaVar2.vNy.setVisibility(8);
                eaVar2.vNz.setVisibility(8);
            }
            charSequence = bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.first_data"));
            int d3 = d(q, ".msg.appmsg.mmreader.template_header.first_color", vDk);
            if (bg.mA(charSequence)) {
                eaVar2.vNA.setVisibility(8);
            } else {
                eaVar2.vNA.setTextColor(d3);
                eaVar2.vNA.setText(charSequence);
                eaVar2.vNA.setVisibility(0);
                if (i2 == 2) {
                    eaVar2.vNA.setPadding(0, this.vCd.getResources().getDimensionPixelOffset(R.f.aXt), 0, 0);
                } else {
                    eaVar2.vNA.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !bg.mA(charSequence)) {
                eaVar2.vNB.setVisibility(0);
            } else {
                eaVar2.vNB.setVisibility(8);
            }
            if ("notifymessage".equals(auVar.field_talker)) {
                mz = bg.mz((String) q.get(".msg.fromusername"));
                boolean em = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(mz);
                if (em) {
                    this.vCd.a(this.vDh);
                    com.tencent.mm.sdk.b.a.urY.b(this.vxU);
                    WxaAttributes og2 = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(mz);
                    if (og2 != null) {
                        obj = (og2.field_appOpt & 1) > 0 ? 1 : null;
                        this.ivH = og2.field_appId;
                        z = em;
                    } else {
                        w.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", mz);
                        eaVar = eaVar2;
                        ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).a(mz, new com.tencent.mm.plugin.appbrand.i.b.a(this) {
                            final /* synthetic */ bk vDl;

                            public final void c(WxaAttributes wxaAttributes) {
                                int i = 0;
                                if (wxaAttributes != null) {
                                    int i2;
                                    this.vDl.ivH = wxaAttributes.field_appId;
                                    if ((wxaAttributes.field_appOpt & 1) > 0) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    View view = eaVar.vNw;
                                    if (i2 == 0) {
                                        i = 8;
                                    }
                                    view.setVisibility(i);
                                }
                            }
                        });
                    }
                }
                obj = null;
                z = em;
            } else {
                z = false;
                obj = null;
            }
            eaVar2.vNw.setVisibility(obj != null ? 0 : 8);
            eaVar2.vNx.setVisibility(z ? 0 : 8);
            eaVar2.vNx.setTag(R.h.cnz, auVar);
            eaVar2.vNx.setTag(R.h.cnh, eaVar2);
            eaVar2.vNx.setOnClickListener(this.vDe);
            eaVar2.vNs.setVisibility(8);
            eaVar2.vNA.setText(bg.mz((String) q.get(".msg.appmsg.mmreader.template_header.first_data")));
            str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            str3 = (String) q.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            if (bg.mA(str3)) {
                eaVar2.vNC.setVisibility(8);
            } else {
                d = d(q, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", WebView.NIGHT_MODE_COLOR);
                d2 = d(q, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", WebView.NIGHT_MODE_COLOR);
                d3 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                eaVar2.vND.setTextColor(d);
                eaVar2.vNF.setTextColor(d2);
                eaVar2.vND.setText(str2);
                if (d3 <= 0 || d3 >= str3.length()) {
                    eaVar2.vNE.setVisibility(8);
                    eaVar2.vNF.setTypeface(Typeface.DEFAULT);
                    eaVar2.vNF.setText(str3);
                } else {
                    eaVar2.vNE.setVisibility(0);
                    eaVar2.vNE.setText(str3.substring(0, d3));
                    eaVar2.vNE.setTextColor(d2);
                    eaVar2.vNF.setTypeface(com.tencent.mm.wallet_core.ui.e.fm(this.vCd.uSU.uTo));
                    eaVar2.vNF.setText(str3.substring(d3));
                }
                eaVar2.vNC.setVisibility(0);
            }
            List arrayList = new ArrayList();
            d3 = 0;
            d2 = 0;
            while (d2 < 100) {
                mz = d2 == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + d2;
                str2 = (String) q.get(mz + ".value.word");
                str3 = (String) q.get(mz + ".key.word");
                if (bg.mA(str2) && bg.mA(str3)) {
                    w.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", Integer.valueOf(d2));
                    break;
                }
                du duVar = new du();
                duVar.vNg = str2;
                duVar.vNf = bg.mz(str3);
                duVar.vNh = d(q, mz + ".key.color", vDj);
                duVar.vNi = d(q, mz + ".value.color", WebView.NIGHT_MODE_COLOR);
                duVar.vNj = bg.getInt((String) q.get(new StringBuilder().append(mz).append(".key.hide").toString()), 0) != 0;
                paddingLeft = (Tp(duVar.vNf) + 1) / 2;
                if (paddingLeft <= d3) {
                    paddingLeft = d3;
                }
                arrayList.add(duVar);
                d2++;
                d3 = paddingLeft;
            }
            d = d3 > 8 ? 8 : d3;
            LinearLayout linearLayout = eaVar2.vNH;
            if (linearLayout.getChildCount() > arrayList.size()) {
                if (arrayList.size() == 0) {
                    linearLayout.removeAllViews();
                } else {
                    linearLayout.removeViews(arrayList.size(), linearLayout.getChildCount() - arrayList.size());
                }
            }
            int childCount = linearLayout.getChildCount();
            for (d2 = 0; d2 < arrayList.size(); d2++) {
                LinearLayout linearLayout2;
                du duVar2 = (du) arrayList.get(d2);
                if (d2 < childCount) {
                    linearLayout2 = (LinearLayout) linearLayout.getChildAt(d2);
                } else {
                    linearLayout2 = (LinearLayout) LayoutInflater.from(this.vCd.uSU.uTo).inflate(R.i.cXs, null, false);
                    dv dvVar = new dv();
                    dvVar.vNk = (TextView) linearLayout2.findViewById(R.h.cbm);
                    dvVar.vNl = (TextView) linearLayout2.findViewById(R.h.cbn);
                    linearLayout2.setTag(dvVar);
                    linearLayout.addView(linearLayout2);
                }
                dv dvVar2 = (dv) linearLayout2.getTag();
                if (duVar2.vNj) {
                    dvVar2.vNk.setVisibility(8);
                } else {
                    dvVar2.vNk.setVisibility(0);
                    dvVar2.vNk.setEms(d);
                    dvVar2.vNk.setTextColor(duVar2.vNh);
                    dvVar2.vNk.setText(duVar2.vNf);
                }
                dvVar2.vNl.setTextColor(duVar2.vNi);
                dvVar2.vNl.setText(duVar2.vNg);
            }
            if (linearLayout.getChildCount() == 0) {
                eaVar2.vNG.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                if (bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
                    eaVar2.vNG.setVisibility(8);
                } else {
                    eaVar2.vNG.setVisibility(0);
                }
                linearLayout.setVisibility(0);
            }
            if (bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                eaVar2.vNU.setVisibility(8);
                eaVar2.vNJ.setVisibility(8);
                eaVar2.vNL.setVisibility(8);
                eaVar2.vNK.setVisibility(0);
                a(eaVar2, auVar, q);
            } else {
                final String mz2;
                final String str5;
                final int i4;
                final String mz3;
                eaVar2.vNK.setVisibility(8);
                str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                String str6 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                if (bg.mA(str2)) {
                    eaVar2.vNM.setVisibility(8);
                } else {
                    eaVar2.vNP.setTextColor(d(q, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", WebView.NIGHT_MODE_COLOR));
                    eaVar2.vNP.setText(str2);
                    if (bg.mA(str6)) {
                        eaVar2.vNR.setVisibility(8);
                        eaVar2.vNP.setPadding(0, 0, 0, 0);
                    } else {
                        eaVar2.vNR.setVisibility(0);
                        f(eaVar2.vNR, str6);
                        eaVar2.vNP.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.vCd.uSU.uTo, 16), 0);
                    }
                    str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    mz2 = bg.mz((String) q.get(".msg.fromusername"));
                    i3 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    str5 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    dt dtVar2 = new dt(auVar, mz2, str2);
                    eaVar2.vNM.setTag(dtVar2);
                    eaVar2.vNU.setTag(dtVar2);
                    if (i3 != 1 || TextUtils.isEmpty(str5)) {
                        eaVar2.vNM.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ bk vDl;

                            public final void onClick(View view) {
                                if (!bg.mA(str2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str2);
                                    com.tencent.mm.bb.d.b(this.vDl.vCd.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, mz2, Integer.valueOf(1));
                                }
                            }
                        });
                        eaVar2.vNU.setOnClickListener(null);
                    } else {
                        mz = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                        i4 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                        d2 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                        mz3 = bg.mz((String) q.get(".msg.appmsg.template_id"));
                        OnClickListener anonymousClass13 = new OnClickListener(this) {
                            final /* synthetic */ bk vDl;

                            public final void onClick(View view) {
                                dt dtVar = (dt) view.getTag();
                                w.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str5);
                                com.tencent.mm.sdk.b.b prVar = new pr();
                                prVar.fWB.userName = str5;
                                prVar.fWB.fWD = mz;
                                prVar.fWB.fWE = d2;
                                prVar.fWB.fWF = i4;
                                prVar.fWB.fWH = true;
                                prVar.fWB.scene = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(mz2) ? 1014 : 1043;
                                prVar.fWB.fCN = dtVar.fTk.field_msgSvrId + ":" + dtVar.userName + ":" + this.vDl.vCd.bUg() + ":" + mz3;
                                com.tencent.mm.sdk.b.a.urY.m(prVar);
                                bk.v(9, this.vDl.ivH, this.vDl.vDi);
                                com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, mz2, Integer.valueOf(1));
                            }
                        };
                        eaVar2.vNM.setOnClickListener(anonymousClass13);
                        eaVar2.vNU.setOnClickListener(anonymousClass13);
                    }
                    eaVar2.vNM.setVisibility(0);
                }
                str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                str4 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bg.mA(str2)) {
                    eaVar2.vNN.setVisibility(8);
                } else {
                    eaVar2.vNQ.setTextColor(d(q, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", WebView.NIGHT_MODE_COLOR));
                    eaVar2.vNQ.setText(str2);
                    if (bg.mA(str4)) {
                        eaVar2.vNS.setVisibility(8);
                        eaVar2.vNQ.setPadding(0, 0, 0, 0);
                    } else {
                        eaVar2.vNS.setVisibility(0);
                        f(eaVar2.vNS, str4);
                        eaVar2.vNQ.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.vCd.uSU.uTo, 16), 0);
                    }
                    str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    mz2 = bg.mz((String) q.get(".msg.fromusername"));
                    i3 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    str5 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    eaVar2.vNN.setTag(new dt(auVar, mz2, str2));
                    if (i3 != 1 || TextUtils.isEmpty(str5)) {
                        eaVar2.vNN.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ bk vDl;

                            public final void onClick(View view) {
                                if (!bg.mA(str2)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str2);
                                    com.tencent.mm.bb.d.b(this.vDl.vCd.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, mz2, Integer.valueOf(2));
                                }
                            }
                        });
                    } else {
                        mz = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                        i4 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                        d2 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                        mz3 = bg.mz((String) q.get(".msg.appmsg.template_id"));
                        eaVar2.vNN.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ bk vDl;

                            public final void onClick(View view) {
                                dt dtVar = (dt) view.getTag();
                                w.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str5);
                                com.tencent.mm.sdk.b.b prVar = new pr();
                                prVar.fWB.userName = str5;
                                prVar.fWB.fWD = mz;
                                prVar.fWB.fWE = d2;
                                prVar.fWB.fWF = i4;
                                prVar.fWB.fWH = true;
                                prVar.fWB.scene = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(mz2) ? 1014 : 1043;
                                prVar.fWB.fCN = dtVar.fTk.field_msgSvrId + ":" + dtVar.userName + ":" + this.vDl.vCd.bUg() + ":" + mz3;
                                com.tencent.mm.sdk.b.a.urY.m(prVar);
                                bk.v(9, this.vDl.ivH, this.vDl.vDi);
                                com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, mz2, Integer.valueOf(2));
                            }
                        });
                    }
                    eaVar2.vNN.setVisibility(0);
                }
                eaVar2.vNT.setVisibility(8);
                if (eaVar2.vNM.getVisibility() == 8 && eaVar2.vNN.getVisibility() == 8) {
                    eaVar2.vNJ.setVisibility(8);
                    eaVar2.vNI.setVisibility(8);
                    eaVar2.vNL.setVisibility(8);
                } else {
                    eaVar2.vNL.setVisibility(0);
                    paddingLeft = this.vCd.getResources().getDimensionPixelOffset(R.f.aXt);
                    if (eaVar2.vNM.getVisibility() == 0 && eaVar2.vNN.getVisibility() == 0) {
                        eaVar2.vNM.setGravity(17);
                        eaVar2.vNN.setGravity(17);
                        eaVar2.vNM.setPadding(paddingLeft, 0, paddingLeft, 0);
                        eaVar2.vNN.setPadding(paddingLeft, 0, paddingLeft, 0);
                    } else if (eaVar2.vNM.getVisibility() == 0) {
                        if (bg.mA(str6)) {
                            eaVar2.vNM.setGravity(19);
                            eaVar2.vNM.setPadding(paddingLeft, 0, 0, 0);
                            eaVar2.vNT.setVisibility(0);
                        } else {
                            eaVar2.vNM.setGravity(17);
                            eaVar2.vNM.setPadding(paddingLeft, 0, paddingLeft, 0);
                        }
                    } else if (bg.mA(str4)) {
                        eaVar2.vNN.setGravity(19);
                        eaVar2.vNN.setPadding(this.vCd.getResources().getDimensionPixelOffset(R.f.aXt), 0, 0, 0);
                        eaVar2.vNT.setVisibility(0);
                    } else {
                        eaVar2.vNN.setGravity(17);
                        eaVar2.vNN.setPadding(paddingLeft, 0, paddingLeft, 0);
                    }
                    eaVar2.vNJ.setVisibility(0);
                    eaVar2.vNI.setVisibility(0);
                }
                if (eaVar2.vNM.getVisibility() == 0 && eaVar2.vNN.getVisibility() == 0) {
                    eaVar2.vNO.setVisibility(0);
                } else {
                    eaVar2.vNO.setVisibility(8);
                }
                str3 = bg.mz((String) q.get(".msg.fromusername"));
                d3 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                str2 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (!x.em(str3) && eaVar2.vNM.getVisibility() != 8 && eaVar2.vNN.getVisibility() == 8 && d3 == 1 && x.em(str2)) {
                    WxaAttributes og3 = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str2);
                    str5 = og3 == null ? null : og3.field_brandIconURL;
                    CharSequence charSequence2 = og3 == null ? str2 : og3.field_nickname;
                    com.tencent.mm.ah.n.GW().a(str5, eaVar2.vNV, this.uWl);
                    eaVar2.vNW.setText(charSequence2);
                    if (og3 == null) {
                        eaVar = eaVar2;
                        ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).a(str2, new com.tencent.mm.plugin.appbrand.i.b.a(this) {
                            final /* synthetic */ bk vDl;

                            public final void c(WxaAttributes wxaAttributes) {
                                if (wxaAttributes != null) {
                                    final String str = wxaAttributes.field_brandIconURL;
                                    final String str2 = wxaAttributes.field_nickname;
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass4 vDy;

                                        public final void run() {
                                            com.tencent.mm.ah.n.GW().a(str, eaVar.vNV, this.vDy.vDl.uWl);
                                            eaVar.vNW.setText(TextUtils.isEmpty(str2) ? str2 : str2);
                                        }
                                    });
                                }
                            }
                        });
                    }
                    eaVar2.vNU.setVisibility(0);
                    eaVar2.vNJ.setVisibility(8);
                } else {
                    eaVar2.vNU.setVisibility(8);
                }
            }
            String mz4 = bg.mz((String) q.get(".msg.fromusername"));
            str4 = null;
            if (!bg.mA(mz4)) {
                ap.yY();
                str4 = com.tencent.mm.u.c.wR().Rc(mz4).tK();
            }
            String str7 = (String) q.get(".msg.appmsg.mmreader.category.item.title");
            String str8 = (String) q.get(".msg.appmsg.mmreader.category.item.url");
            String str9 = (String) q.get(".msg.appmsg.mmreader.category.item.native_url");
            String str10 = (String) q.get(".msg.appmsg.template_id");
            i3 = bg.getInt((String) q.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            str2 = (String) q.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if (i3 == 1 && !TextUtils.isEmpty(str2)) {
                dtVar = new dt(auVar, mz4, str8);
                dtVar.position = i;
                eaVar2.vNr.setTag(dtVar);
                eaVar2.vNr.setOnClickListener(this.llr);
            } else if (i3 == -1 && ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(mz4)) {
                String str11 = (String) q.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                View view = eaVar2.vNr;
                dtVar = new dt(auVar, false, i, mz4, 6, false, this.vCd.bVS(), mz4, str4, str7);
                dtVar.fZF = str9;
                dtVar.vNd = str11;
                view.setTag(dtVar);
                eaVar2.vNr.setOnClickListener(this.vDg);
            } else {
                View view2 = eaVar2.vNr;
                dt dtVar3 = new dt(auVar, false, i, str8, 6, false, this.vCd.bVS(), mz4, str4, str7);
                dtVar3.fZF = str9;
                view2.setTag(dtVar3);
                eaVar2.vNr.setOnClickListener(this.vCd.vBD.vEW);
            }
            eaVar2.vNr.setOnLongClickListener(this.vCd.vBD.vEY);
            if (com.tencent.mm.i.g.sW().sI()) {
                aVar.vyV.setVisibility(0);
                ah.c(this.vCd, aVar.vyV, new el(str10, auVar, str4));
            }
            aVar.vHZ.vNr.setVisibility(0);
            return;
        }
        aVar.vHZ.vNr.setVisibility(8);
        mz = bg.mz((String) q.get(".msg.fromusername"));
        i2 = bg.getInt((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        w.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", Integer.valueOf(i2));
        if (i2 == 1) {
            str3 = bg.mz((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            ah.a(aVar, com.tencent.mm.pluginsdk.ui.d.h.b(this.vCd.uSU.uTo, bg.mz((String) q.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), aVar.piH.getTextSize()));
            aVar.ipv.setTag(null);
            aVar.ipv.setOnClickListener(null);
            com.tencent.mm.ah.n.GW().a(str3, aVar.ipv, this.uWl);
        } else {
            a(aVar, this.vCd, auVar, mz);
            a(aVar.ipv, this.vCd, mz, auVar, null);
        }
        w.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", auVar.field_talker);
        if ("notifymessage".equals(auVar.field_talker) || i2 == 1) {
            aVar.vHY.vIa.setVisibility(0);
            aVar.vHY.iUO.setTextSize(0, (float) com.tencent.mm.bg.a.T(aVar.vHY.iUO.getContext(), R.f.aXI));
        } else {
            aVar.vHY.vIa.setVisibility(8);
            aVar.vHY.iUO.setTextSize(0, (float) com.tencent.mm.bg.a.T(aVar.vHY.iUO.getContext(), R.f.aWy));
        }
        aVar.vHY.oKs.setVisibility(0);
        dk ai = dk.ai(q);
        if (bg.mA(ai.url)) {
            aVar.vHY.vIc.setVisibility(8);
            aVar.vHY.vzU.setVisibility(8);
        } else {
            aVar.vHY.vIc.setVisibility(0);
            aVar.vHY.vzU.setVisibility(0);
        }
        aVar.vHY.iUO.setText(ai.title);
        aVar.vHY.mzk.setText(o.Z(this.vCd.getString(R.l.elp), ai.time));
        bl.a(aVar.vHY.vIb, q);
        String str12 = null;
        if (!bg.mA(mz)) {
            ap.yY();
            str12 = com.tencent.mm.u.c.wR().Rc(mz).tK();
        }
        str2 = (String) q.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (bg.getInt((String) q.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0) != 1 || TextUtils.isEmpty(str2)) {
            view2 = aVar.vHY.oKs;
            dt dtVar4 = new dt(auVar, false, i, ai.url, 6, false, this.vCd.bVS(), mz, str12, ai.title);
            dtVar4.fZF = ai.fZF;
            view2.setTag(dtVar4);
            aVar.vHY.oKs.setOnClickListener(this.vCd.vBD.vEW);
        } else {
            dtVar = new dt(auVar, mz, ai.url);
            dtVar.position = i;
            aVar.vHY.oKs.setTag(dtVar);
            aVar.vHY.oKs.setOnClickListener(this.llr);
        }
        aVar.vHY.oKs.setOnLongClickListener(this.vCd.vBD.vEY);
        if (com.tencent.mm.i.g.sW().sI()) {
            aVar.vyV.setVisibility(0);
            ah.c(this.vCd, aVar.vyV, new el(ai.hir, auVar, str12));
        }
        aVar.vHY.oKs.setVisibility(0);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        dt dtVar = (dt) view.getTag();
        if (dtVar == null) {
            return false;
        }
        int i = dtVar.position;
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                Map q = bh.q(auVar.field_content, "msg");
                if (!(q == null || q.size() == 0)) {
                    if (((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(bg.mz((String) q.get(".msg.fromusername")))) {
                        v(7, this.ivH, this.vDi);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    protected final void a(ah.a aVar, a aVar2, au auVar, String str) {
        if (str != null && aVar.piH != null) {
            ah.a(aVar, com.tencent.mm.pluginsdk.ui.d.h.b(aVar2.uSU.uTo, aVar2.eK(str), aVar.piH.getTextSize()));
        }
    }

    private void a(ImageView imageView, a aVar, String str, au auVar, String str2) {
        if (imageView != null) {
            if (com.tencent.mm.u.o.fE(str)) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            if (((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).em(str)) {
                com.tencent.mm.ah.n.GW().a(str2, imageView, this.uWl);
                imageView.setTag(new dt(auVar, str, 1));
                imageView.setOnClickListener(this.vDf);
            } else {
                String bUg;
                Bitmap b = com.tencent.mm.modelbiz.l.b(str, null, 0);
                if (b != null) {
                    imageView.setImageBitmap(b);
                } else {
                    imageView.setImageResource(R.g.bcY);
                    ap.yY();
                    com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
                    if (Rc != null && ((int) Rc.gTQ) > 0) {
                        ag.a.hlS.J(Rc.field_username, "");
                        com.tencent.mm.x.b.he(Rc.field_username);
                    }
                }
                if (aVar.vBH) {
                    bUg = aVar.bUg();
                } else {
                    bUg = null;
                }
                imageView.setTag(new dt(str, 1, bUg));
                imageView.setOnClickListener(aVar.vBD.vEW);
            }
            imageView.setOnLongClickListener(aVar.vBD.vEY);
            imageView.setContentDescription(com.tencent.mm.u.n.eK(str) + aVar.uSU.uTo.getString(R.l.dJn));
        }
    }

    private void a(ea eaVar, String str, String str2) {
        eaVar.vNv.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.vCd.uSU.uTo, str2, eaVar.vNv.getTextSize()));
        com.tencent.mm.ah.n.GW().a(str, eaVar.vNu, this.uWl);
        eaVar.vNu.setTag(null);
        eaVar.vNu.setOnClickListener(null);
        eaVar.vNt.setTag(null);
        eaVar.vNt.setOnClickListener(null);
        eaVar.vNt.setVisibility(0);
    }

    private void a(ea eaVar, au auVar, Map<String, String> map) {
        LinearLayout linearLayout = eaVar.vNK;
        int childCount = linearLayout.getChildCount();
        int i = 0;
        while (i < 10) {
            String str = i == 0 ? ".msg.appmsg.mmreader.template_detail.opitems.opitem" : ".msg.appmsg.mmreader.template_detail.opitems.opitem" + i;
            String str2 = (String) map.get(str + ".word");
            if (bg.mA(str2)) {
                w.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", Integer.valueOf(i));
                int childCount2 = linearLayout.getChildCount();
                if (childCount2 <= i) {
                    return;
                }
                if (i == 0) {
                    linearLayout.removeAllViews();
                    return;
                } else {
                    linearLayout.removeViews(i, childCount2 - i);
                    return;
                }
            }
            LinearLayout linearLayout2;
            if (i < childCount) {
                linearLayout2 = (LinearLayout) linearLayout.getChildAt(i);
            } else {
                linearLayout2 = (LinearLayout) LayoutInflater.from(this.vCd.uSU.uTo).inflate(R.i.cXr, null, false);
                u uVar = new u();
                uVar.iUO = (TextView) linearLayout2.findViewById(R.h.cnq);
                uVar.jki = (ImageView) linearLayout2.findViewById(R.h.cnp);
                uVar.vzV = (LinearLayout) linearLayout2.findViewById(R.h.cno);
                linearLayout2.setTag(uVar);
                linearLayout.addView(linearLayout2);
            }
            u uVar2 = (u) linearLayout2.getTag();
            String str3 = (String) map.get(str + ".icon");
            uVar2.iUO.setTextColor(d(map, str + ".color", WebView.NIGHT_MODE_COLOR));
            uVar2.iUO.setText(str2);
            if (bg.mA(str3)) {
                uVar2.jki.setVisibility(8);
                uVar2.iUO.setPadding(0, 0, 0, 0);
            } else {
                uVar2.jki.setVisibility(0);
                f(uVar2.jki, str3);
                uVar2.iUO.setPadding(0, 0, com.tencent.mm.bg.a.fromDPToPix(this.vCd.uSU.uTo, 28), 0);
            }
            str2 = (String) map.get(str + ".url");
            final String mz = bg.mz((String) map.get(".msg.fromusername"));
            int i2 = bg.getInt((String) map.get(str + ".op_type"), 0);
            final String str4 = (String) map.get(str + ".weapp_username");
            uVar2.vzV.setTag(new dt(auVar, mz, str2));
            final int i3 = i + 1;
            if (i2 != 1 || TextUtils.isEmpty(str4)) {
                uVar2.vzV.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ bk vDl;

                    public final void onClick(View view) {
                        if (!bg.mA(str2)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str2);
                            com.tencent.mm.bb.d.b(this.vDl.vCd.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                            com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, mz, Integer.valueOf(i3));
                        }
                    }
                });
            } else {
                final String str5 = (String) map.get(str + ".weapp_path");
                final int i4 = bg.getInt((String) map.get(str + ".weapp_version"), 0);
                final int i5 = bg.getInt((String) map.get(str + ".weapp_state"), 0);
                final String mz2 = bg.mz((String) map.get(".msg.appmsg.template_id"));
                uVar2.vzV.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ bk vDl;

                    public final void onClick(View view) {
                        dt dtVar = (dt) view.getTag();
                        w.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str4);
                        com.tencent.mm.sdk.b.b prVar = new pr();
                        prVar.fWB.userName = str4;
                        prVar.fWB.fWD = str5;
                        prVar.fWB.fWE = i5;
                        prVar.fWB.fWF = i4;
                        prVar.fWB.fWH = true;
                        prVar.fWB.scene = com.tencent.mm.t.h.em(mz) ? 1014 : 1043;
                        prVar.fWB.fCN = dtVar.fTk.field_msgSvrId + ":" + dtVar.userName + ":" + this.vDl.vCd.bUg() + ":" + mz2;
                        com.tencent.mm.sdk.b.a.urY.m(prVar);
                        bk.v(9, this.vDl.ivH, this.vDl.vDi);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11608, this.vDl.vDi, mz, Integer.valueOf(i3));
                    }
                });
            }
            i++;
        }
    }

    private static void f(ImageView imageView, String str) {
        if (!bg.mA(str) && imageView != null) {
            c.a aVar = new c.a();
            ap.yY();
            aVar.hIO = com.tencent.mm.u.c.xc();
            aVar.hIL = true;
            aVar.hJh = true;
            com.tencent.mm.ah.n.GW().a(str, imageView, aVar.Hg());
        }
    }

    public static void v(int i, String str, String str2) {
        w.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", Integer.valueOf(13796), Integer.valueOf(i), str, str2);
        com.tencent.mm.plugin.report.service.g.oUh.i(13796, Integer.valueOf(i), str, str2, Integer.valueOf(0), Long.valueOf(bg.Ny()));
    }

    private static int d(Map<String, String> map, String str, int i) {
        if (!(map == null || bg.mA(str))) {
            try {
                i = Color.parseColor(bg.mz((String) map.get(str)));
            } catch (Exception e) {
            }
        }
        return i;
    }

    private static int Tp(String str) {
        int i = 0;
        if (bg.mA(str)) {
            return 0;
        }
        String str2 = "[Α-￥]";
        int i2 = 0;
        while (i < str.length()) {
            if (str.substring(i, i + 1).matches(str2)) {
                i2 += 2;
            } else {
                i2++;
            }
            i++;
        }
        return i2;
    }
}
