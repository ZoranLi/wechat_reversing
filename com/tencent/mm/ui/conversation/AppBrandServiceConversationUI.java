package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.a.a;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.conversation.d.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.l;
import java.math.BigInteger;
import java.util.HashMap;

@a
public final class AppBrandServiceConversationUI extends BaseConversationUI {
    private View ipu;

    @android.support.a.a
    public static class AppBrandServiceConversationFmUI extends b implements d {
        public String fJL = "";
        public int fromScene;
        private p irJ = null;
        String ivH;
        TextView jWk;
        public boolean jWp = false;
        public String jmd;
        public l kmS;
        public ae vWD;
        private com.tencent.mm.ui.d.a vxW;
        public ListView waU;
        public d waV;
        private String waW;

        private static class a extends d {
            private Paint jXK = new Paint();
            private String username;
            private c<kj> vxU;
            private HashMap<String, Boolean> waY;
            private HashMap<String, String> waZ;

            a(Context context, String str, com.tencent.mm.ui.k.a aVar) {
                super(context, aVar);
                this.username = str;
                this.waY = new HashMap();
                this.waZ = new HashMap();
                this.vxU = new c<kj>(this) {
                    final /* synthetic */ a wba;

                    {
                        this.wba = r2;
                        this.usg = kj.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        boolean z = false;
                        kj kjVar = (kj) bVar;
                        if (kjVar.fQM.fCJ != null) {
                            w.d("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId:%s,event.newValue:%d", kjVar.fQM.fCJ, Integer.valueOf(kjVar.fQM.fQN));
                            if ((kjVar.fQM.fQN & 2) > 0) {
                                z = true;
                            }
                            this.wba.waY.remove(kjVar.fQM.fCJ);
                            this.wba.waY.put(kjVar.fQM.fCJ, Boolean.valueOf(z));
                            this.wba.notifyDataSetChanged();
                        } else {
                            w.e("MicroMsg.ConversationAdapter", "OnWxaOptionsChangedEvent event.brandId is null");
                        }
                        return true;
                    }
                };
                com.tencent.mm.sdk.b.a.urY.b(this.vxU);
            }

            public final void OK() {
                ap.yY();
                setCursor(com.tencent.mm.u.c.wW().c(o.hlw, this.jBA, this.username));
                if (this.uSN != null) {
                    this.uSN.OH();
                }
                super.notifyDataSetChanged();
            }

            protected final void a(String str, g gVar) {
                boolean z;
                Boolean bool = (Boolean) this.waY.get(str);
                if (bool == null) {
                    WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
                    z = og != null && (og.field_appOpt & 2) > 0;
                    this.waY.put(str, bool);
                } else {
                    z = bool.booleanValue();
                }
                if (z) {
                    gVar.vvB.setVisibility(0);
                    gVar.vvB.setImageResource(R.k.dvw);
                } else {
                    gVar.vvB.setVisibility(8);
                }
                CharSequence charSequence = (String) this.waZ.get(str);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = com.tencent.mm.ui.d.b.ST(com.tencent.mm.ui.d.b.SS(str));
                    if (!TextUtils.isEmpty(charSequence)) {
                        this.waZ.put(str, charSequence);
                    }
                }
                LayoutParams layoutParams;
                if (TextUtils.isEmpty(charSequence)) {
                    layoutParams = (LayoutParams) gVar.vvy.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.weight = 0.0f;
                    gVar.vvy.setLayoutParams(layoutParams);
                } else {
                    int i;
                    int dimensionPixelOffset;
                    int dimensionPixelOffset2;
                    float f;
                    float f2;
                    float f3;
                    gVar.wcC.setVisibility(0);
                    gVar.wcC.setText(this.context.getString(R.l.dGg, new Object[]{charSequence}));
                    if (this.context.getResources().getDisplayMetrics() != null) {
                        i = this.context.getResources().getDisplayMetrics().widthPixels;
                    } else {
                        i = 0;
                    }
                    if (com.tencent.mm.bg.a.dM(this.context)) {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.aXC);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.aWP);
                    } else {
                        dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.f.aXD);
                        dimensionPixelOffset2 = this.context.getResources().getDimensionPixelOffset(R.f.aWQ);
                    }
                    int dimensionPixelOffset3 = this.context.getResources().getDimensionPixelOffset(R.f.aXt);
                    int dimensionPixelOffset4 = this.context.getResources().getDimensionPixelOffset(R.f.aXH);
                    d dVar = (d) this.vvu.get(str);
                    String charSequence2 = (dVar == null || dVar.nickName == null) ? "" : dVar.nickName.toString();
                    if (charSequence2 == null) {
                        f = 0.0f;
                    } else {
                        this.jXK.setTextSize(this.vvr);
                        f = this.jXK.measureText(charSequence2);
                    }
                    float f4 = 48.0f + f;
                    int dimensionPixelOffset5 = this.context.getResources().getDimensionPixelOffset(R.f.aWQ);
                    int dimensionPixelOffset6 = this.context.getResources().getDimensionPixelOffset(R.f.aXx);
                    w.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", Integer.valueOf(i), Integer.valueOf(dimensionPixelOffset), Integer.valueOf(dimensionPixelOffset2));
                    f = 0.0f;
                    if (i > 0) {
                        f = (float) ((((i - dimensionPixelOffset) - dimensionPixelOffset3) - dimensionPixelOffset4) - dimensionPixelOffset2);
                    }
                    if (f4 > f || f4 >= f || f <= 0.0f) {
                        f2 = 0.6f;
                        f3 = 0.4f;
                    } else {
                        f3 = Math.min(f4 / f, (((f - ((float) dimensionPixelOffset5)) - ((float) dimensionPixelOffset6)) - 48.0f) / f);
                        f2 = f3;
                        f3 = 1.0f - f3;
                    }
                    layoutParams = (LayoutParams) gVar.vvy.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f2;
                    gVar.vvy.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) gVar.wcC.getLayoutParams();
                    layoutParams.width = 0;
                    layoutParams.weight = f3;
                    gVar.wcC.setLayoutParams(layoutParams);
                }
                com.tencent.mm.pluginsdk.ui.a.b.m(gVar.ipv, str);
            }

            public final void detach() {
                this.waY = null;
                com.tencent.mm.sdk.b.a.urY.c(this.vxU);
            }
        }

        public final void onActivityCreated(Bundle bundle) {
            w.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
            super.onActivityCreated(bundle);
            this.waW = getStringExtra("Contact_User");
            if (TextUtils.isEmpty(this.waW)) {
                this.waW = "appbrandcustomerservicemsg";
            }
            this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
            w.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", Integer.valueOf(this.fromScene));
            ap.yY();
            this.jmd = System.currentTimeMillis() + new BigInteger(Integer.toBinaryString(com.tencent.mm.u.c.uH()), 2).toString();
            qP(getString(R.l.dDL));
            this.waU = (ListView) findViewById(R.h.cJi);
            this.jWk = (TextView) findViewById(R.h.bLU);
            this.jWk.setText(R.l.dDW);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.waX.finish();
                    return true;
                }
            });
            this.vxW = new com.tencent.mm.ui.d.a(bPj());
            this.waV = new a(bPj(), this.waW, new com.tencent.mm.ui.k.a(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final void OH() {
                    AppBrandServiceConversationFmUI appBrandServiceConversationFmUI = this.waX;
                    if (this.waX.waV.getCount() <= 0) {
                        appBrandServiceConversationFmUI.jWk.setVisibility(0);
                        appBrandServiceConversationFmUI.waU.setVisibility(8);
                        return;
                    }
                    appBrandServiceConversationFmUI.jWk.setVisibility(8);
                    appBrandServiceConversationFmUI.waU.setVisibility(0);
                }

                public final void OI() {
                }
            });
            this.waV.a(new MMSlideDelView.c(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final int cb(View view) {
                    return this.waX.waU.getPositionForView(view);
                }
            });
            this.waV.a(new f(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final void s(View view, int i) {
                    this.waX.waU.performItemClick(view, i, 0);
                }
            });
            this.waU.setAdapter(this.waV);
            this.kmS = new l(bPj());
            this.waU.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.waX.vWD = (ae) this.waX.waV.getItem(i);
                    aj ajVar = this.waX.vWD;
                    if (ajVar == null) {
                        w.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(this.waX.waV.getCount()));
                        this.waX.waV.notifyDataSetChanged();
                        return;
                    }
                    this.waX.fJL = ajVar.field_username;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("finish_direct", false);
                    bundle.putBoolean("key_need_send_video", false);
                    bundle.putString("key_scene_id", this.waX.jmd);
                    bundle.putInt("app_brand_chatting_from_scene", this.waX.fromScene);
                    this.waX.wbz.a(ajVar.field_username, bundle, true);
                    AppBrandServiceConversationFmUI appBrandServiceConversationFmUI = this.waX;
                    String str = ajVar.field_username;
                    int i2 = this.waX.fromScene;
                    ap.yY();
                    aj Rm = com.tencent.mm.u.c.wW().Rm(str);
                    if (Rm == null) {
                        w.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", str);
                        return;
                    }
                    int i3 = Rm.field_unReadCount;
                    String mz = bg.mz(appBrandServiceConversationFmUI.jmd);
                    w.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", Integer.valueOf(13799), appBrandServiceConversationFmUI.ivH, Integer.valueOf(i2), Integer.valueOf(i3), mz);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13799, appBrandServiceConversationFmUI.ivH, Integer.valueOf(i2), Integer.valueOf(i3), mz, Long.valueOf(bg.Ny()));
                }
            });
            this.waU.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.waX.vWD = (ae) this.waX.waV.getItem(i);
                    this.waX.fJL = this.waX.vWD.field_username;
                    this.waX.kmS.a(view, i, j, this.waX, this.waX);
                    return true;
                }
            });
            this.waV.a(new MMSlideDelView.c(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final int cb(View view) {
                    return this.waX.waU.getPositionForView(view);
                }
            });
            this.waV.a(new f(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final void s(View view, int i) {
                    this.waX.waU.performItemClick(view, i, 0);
                }
            });
            this.waV.a(new e(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final void aQ(Object obj) {
                    if (obj == null) {
                        w.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
                        return;
                    }
                    this.waX.TT(obj.toString());
                }
            });
            a(1, R.k.dtF, new OnMenuItemClickListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.waX.uSU.uTo, ServiceNotifySettingsUI.class);
                    intent.putExtra("mode", 1);
                    intent.putExtra("scene_id", this.waX.jmd);
                    this.waX.startActivity(intent);
                    return true;
                }
            });
            ap.yY();
            com.tencent.mm.u.c.wW().a(this.waV);
            com.tencent.mm.sdk.b.a.urY.m(new com.tencent.mm.e.a.p());
            bYr();
        }

        protected final int getLayoutId() {
            return R.i.dpe;
        }

        public final String getUserName() {
            return this.waW;
        }

        public final void onDestroy() {
            if (ap.zb()) {
                ap.yY();
                com.tencent.mm.u.c.wW().b(this.waV);
            }
            if (this.waV != null) {
                this.waV.onDestroy();
            }
            super.onDestroy();
        }

        public final void onResume() {
            w.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
            if (this.waV != null) {
                this.waV.onResume();
            }
            super.onResume();
        }

        public final void onPause() {
            w.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
            ap.yY();
            com.tencent.mm.u.c.wW().Ro(this.waW);
            if (this.waV != null) {
                this.waV.onPause();
            }
            super.onPause();
        }

        private void bYr() {
            String str = "";
            if (this.waV == null) {
                w.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
                return;
            }
            int i;
            Object obj;
            int i2;
            ap.yY();
            aj Rm = com.tencent.mm.u.c.wW().Rm("appbrandcustomerservicemsg");
            if (Rm == null || bg.mA(Rm.field_username)) {
                i = 0;
            } else {
                i = Rm.field_unReadCount;
            }
            ae aeVar = (ae) this.waV.getItem(0);
            if (aeVar == null || bg.mA(aeVar.field_username)) {
                String str2 = str;
            } else {
                String mz = bg.mz(aeVar.field_content);
                WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(aeVar.field_username);
                this.ivH = og == null ? null : og.field_appId;
                obj = mz;
            }
            if (i > 0) {
                int count = this.waV.getCount();
                int i3 = 0;
                i2 = 0;
                while (i3 < count) {
                    int i4;
                    aeVar = (ae) this.waV.getItem(i3);
                    if (aeVar.field_unReadMuteCount + aeVar.field_unReadCount > 0) {
                        i4 = i2 + 1;
                    } else {
                        i4 = i2;
                    }
                    i3++;
                    i2 = i4;
                }
            } else {
                i2 = 0;
            }
            w.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", Integer.valueOf(13797), this.jmd, Integer.valueOf(i), Integer.valueOf(i2), this.ivH, obj);
            com.tencent.mm.plugin.report.service.g.oUh.i(13797, this.jmd, Integer.valueOf(i), Integer.valueOf(i2), this.ivH, Long.valueOf(bg.Ny()), Integer.valueOf(0), obj);
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (!(this.fJL == null || this.fJL.isEmpty())) {
                this.fJL = "";
            }
            if (i2 == -1) {
            }
        }

        public final void TT(String str) {
            if (bg.mA(str)) {
                w.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            w.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", str);
            ap.yY();
            ce Ah = com.tencent.mm.u.c.wT().Ah(str);
            com.tencent.mm.bd.a nhVar = new nh();
            nhVar.ttp = new avx().OV(bg.mz(str));
            nhVar.tfk = Ah.field_msgSvrId;
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(8, nhVar));
            this.jWp = false;
            Context bPj = bPj();
            getString(R.l.dIO);
            final ProgressDialog a = com.tencent.mm.ui.base.g.a(bPj, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                {
                    this.waX = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.waX.jWp = true;
                }
            });
            w.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", Integer.valueOf(13798), Integer.valueOf(5), this.ivH, this.jmd);
            com.tencent.mm.plugin.report.service.g.oUh.i(13798, Integer.valueOf(5), this.ivH, Integer.valueOf(0), this.jmd, Long.valueOf(bg.Ny()));
            ay.a(str, new com.tencent.mm.u.ay.a(this) {
                final /* synthetic */ AppBrandServiceConversationFmUI waX;

                public final boolean zs() {
                    return this.waX.jWp;
                }

                public final void zr() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ap.yY();
            com.tencent.mm.u.c.wW().Rl(str);
        }

        public final void c(MenuItem menuItem, int i) {
            ap.yY();
            com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(this.fJL);
            if (Rc == null || ((int) Rc.gTQ) == 0) {
                w.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.fJL);
                return;
            }
            switch (menuItem.getItemId()) {
                case 1:
                    this.vxW.username = this.fJL;
                    this.vxW.scene = this.fromScene;
                    this.vxW.veO = this.jmd;
                    this.vxW.veP = true;
                    this.vxW.show(3);
                    return;
                case 2:
                    this.vxW.username = this.fJL;
                    this.vxW.scene = this.fromScene;
                    this.vxW.veO = this.jmd;
                    this.vxW.veP = true;
                    this.vxW.show(4);
                    return;
                case 3:
                    TT(this.fJL);
                    return;
                default:
                    return;
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(this.fJL);
            int i = (og == null || (og.field_appOpt & 2) <= 0) ? 0 : 1;
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dES);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.dET);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.ebv);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ipu = r.eC(this).inflate(R.i.cVP, null);
        setContentView(this.ipu);
        this.wbn = new AppBrandServiceConversationFmUI();
        aR().aV().a(R.h.ckn, this.wbn).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.ipu);
    }

    public final void finish() {
        super.finish();
    }

    protected final En_5b8fbb1e.a bYq() {
        return new AppBrandServiceChattingUI.a();
    }
}
