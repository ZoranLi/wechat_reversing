package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fn;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bt;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.r;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@a(19)
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int wqz = s.q(1, 2);
    private long fFx;
    private long fGM;
    private String fSs;
    private au fTk;
    private int fromScene = 0;
    private String imagePath = null;
    private int ipD;
    private List<String> jBA;
    private String keo = null;
    private int[] lMZ = new int[]{R.h.bBe, R.h.bBf, R.h.bBg, R.h.bBh, R.h.bBi};
    private int msgType;
    private int vCX = -1;
    private boolean vYw;
    private boolean vZu = false;
    private TextView vwD;
    private int wqA;
    private boolean wqB = false;
    private boolean wqC = false;
    private boolean wqD = false;
    private boolean wqE = false;
    private boolean wqF = false;
    private boolean wqG = false;
    private boolean wqH = false;
    private int wqI;
    private boolean wqJ = false;
    private String wqK;
    private String wqL;
    private Boolean wqM = Boolean.valueOf(false);
    private boolean wqN = false;
    private boolean wqO = false;
    private List<String> wqP = null;
    private ReportArgs wqQ;
    private String wqR;
    private String wqS = null;
    private OnMenuItemClickListener wqT = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectConversationUI wqV;

        {
            this.wqV = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.wqV.wqO = !this.wqV.wqO;
            this.wqV.bYb().ly(this.wqV.wqO);
            this.wqV.vYk.ly(this.wqV.wqO);
            this.wqV.Ok();
            this.wqV.vwD.setText(!this.wqV.wqO ? this.wqV.wqA : R.l.eQB);
            return true;
        }
    };
    private OnMenuItemClickListener wqU = new OnMenuItemClickListener(this) {
        final /* synthetic */ SelectConversationUI wqV;

        {
            this.wqV = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (this.wqV.lM(false)) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_User", u.c(this.wqV.wqP, ","));
            Intent intent2 = (Intent) this.wqV.getIntent().getParcelableExtra("Select_Conv_NextStep");
            if (intent2 != null) {
                this.wqV.a(intent, intent2);
            } else if (this.wqV.wqF) {
                this.wqV.d(-1, intent);
                this.wqV.finish();
            } else {
                SelectConversationUI.b(this.wqV, intent);
            }
            return true;
        }
    };

    static /* synthetic */ void b(SelectConversationUI selectConversationUI, final Intent intent) {
        if (s.ee(selectConversationUI.ipD, 256)) {
            selectConversationUI.d(-1, intent);
            selectConversationUI.finish();
            return;
        }
        d.a aVar = new d.a(selectConversationUI.uSU.uTo);
        aVar.bs(selectConversationUI.wqP);
        if (selectConversationUI.vZu) {
            selectConversationUI.a(aVar, selectConversationUI.wqK);
            a(intent, selectConversationUI.wqK, selectConversationUI.wqP);
        } else if (selectConversationUI.wqC) {
            if (selectConversationUI.fFx != -1) {
                b fnVar = new fn();
                fnVar.fKl.fFx = selectConversationUI.fFx;
                fnVar.fKl.fKm = aVar;
                fnVar.fKl.fDi = selectConversationUI.uSU.uTo;
                com.tencent.mm.sdk.b.a.urY.m(fnVar);
            } else if (selectConversationUI.msgType == 17 && selectConversationUI.wqI != 0) {
                aVar.MP(new StringBuffer(selectConversationUI.getResources().getString(R.l.dHF)).append(selectConversationUI.uSU.uTo.getString(R.l.eLI, new Object[]{Integer.valueOf(selectConversationUI.wqI)})).toString());
            }
        } else if (selectConversationUI.wqD) {
            HashMap hashMap = (HashMap) selectConversationUI.getIntent().getSerializableExtra("webview_params");
            aVar.MQ((String) hashMap.get("img_url")).bEV();
            String str = (String) hashMap.get("title");
            final String str2 = (String) hashMap.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            aVar.MP(new StringBuffer(selectConversationUI.getResources().getString(R.l.dIU)).append(str).toString());
            aVar.a(new h.a.a(selectConversationUI) {
                final /* synthetic */ SelectConversationUI wqV;

                public final void auI() {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        } else if (selectConversationUI.wqE) {
            selectConversationUI.a(aVar);
        } else {
            selectConversationUI.b(aVar);
            selectConversationUI.c(aVar);
        }
        aVar.c(Boolean.valueOf(true)).xp(R.l.dIA).a(new k.a(selectConversationUI) {
            final /* synthetic */ SelectConversationUI wqV;

            public final void a(boolean z, String str, int i) {
                this.wqV.aHf();
                if (z) {
                    intent.putExtra("custom_send_text", str);
                    this.wqV.d(-1, intent);
                    this.wqV.finish();
                }
            }
        }).oHT.show();
    }

    public void onCreate(Bundle bundle) {
        e.f(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        w.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!(u.mA(stringExtra) || u.mA(stringExtra2))) {
            new com.tencent.mm.plugin.base.stub.d(this, stringExtra, stringExtra2, new com.tencent.mm.plugin.base.stub.d.a(this) {
                final /* synthetic */ SelectConversationUI wqV;

                {
                    this.wqV = r1;
                }

                public final void cR(boolean z) {
                    boolean isFinishing = this.wqV.isFinishing();
                    w.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                    if (!z && !isFinishing) {
                        this.wqV.finish();
                    }
                }
            }).acH();
        }
        e.g(this);
    }

    protected final void Oe() {
        super.Oe();
        this.wqB = getIntent().getBooleanExtra("select_is_ret", false);
        this.fromScene = getIntent().getIntExtra("scene_from", 0);
        w.i("MicroMsg.SelectConversationUI", "from scene:%d", Integer.valueOf(this.fromScene));
        if (this.fromScene == 1) {
            this.wqC = true;
        } else if (this.fromScene == 2) {
            this.wqD = true;
        } else if (this.fromScene == 3) {
            this.wqE = true;
        } else if (this.fromScene == 6) {
            this.wqF = true;
        } else if (this.fromScene == 7) {
            this.wqG = true;
        }
        this.wqH = getIntent().getBooleanExtra("send_to_biz", false);
        this.vCX = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.fFx = getIntent().getLongExtra("select_fav_local_id", -1);
        this.wqI = getIntent().getIntExtra("select_fav_select_count", 0);
        this.wqN = getIntent().getBooleanExtra("mutil_select_is_ret", false);
        this.vZu = getIntent().getBooleanExtra("Select_Send_Card", false);
        this.wqJ = getIntent().getBooleanExtra("Retr_Big_File", false);
        if (this.vZu) {
            this.wqK = getIntent().getStringExtra("Select_Talker_Name");
        }
        this.ipD = getIntent().getIntExtra("Select_Conv_Type", wqz);
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.fGM = getIntent().getLongExtra("Retr_Msg_Id", -1);
        ap.yY();
        this.fTk = c.wT().cA(this.fGM);
        this.imagePath = getIntent().getStringExtra("image_path");
        this.wqS = getIntent().getStringExtra("ad_video_title");
        this.keo = getIntent().getStringExtra("desc_title");
        this.wqR = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.fSs = getIntent().getStringExtra("Retr_Msg_content");
        if (this.fSs == null && this.fTk != null) {
            this.fSs = this.fTk.field_content;
        }
        this.wqQ = (ReportArgs) getIntent().getParcelableExtra("Select_Report_Args");
        Collection hashSet = new HashSet();
        hashSet.addAll(s.bYl());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!u.mA(stringExtra)) {
            hashSet.addAll(u.f(stringExtra.split(",")));
        }
        if (s.ee(this.ipD, 2)) {
            Collection bYm = s.bYm();
            s.f(bYm);
            hashSet.addAll(bYm);
        }
        this.jBA = new ArrayList();
        this.jBA.addAll(hashSet);
        if (s.ee(this.ipD, 1)) {
            this.vYw = true;
        }
        if (this.wqN) {
            this.wqP = new LinkedList();
            if (this.wqN) {
                a(1, getString(R.l.dHH), this.wqT, l.b.uTY);
                Ok();
            }
        }
    }

    protected final o Oi() {
        return new t(this, this.jBA, this.vYw, this.wqO, this.wqH, this.ipD);
    }

    protected final m Oj() {
        return new q(this, this.jBA, this.wqO, this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.vwD == null) {
            if (this.vZu) {
                this.wqA = R.l.eQB;
            } else {
                this.wqA = R.l.eQs;
            }
            OnClickListener anonymousClass12 = new OnClickListener(this) {
                final /* synthetic */ SelectConversationUI wqV;

                {
                    this.wqV = r1;
                }

                public final void onClick(View view) {
                    if (this.wqV.wqO) {
                        this.wqV.caf();
                    } else if (this.wqV.vZu) {
                        this.wqV.cag();
                    } else {
                        this.wqV.cah();
                    }
                }
            };
            CharSequence string = getString(this.wqA);
            View inflate = r.eC(this).inflate(R.i.dfA, null);
            inflate.setOnClickListener(anonymousClass12);
            TextView textView = (TextView) inflate.findViewById(R.h.bGD);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.vwD = textView;
        }
        this.vwD.setVisibility(i);
    }

    protected final void aIP() {
        if (this.fromScene == 5) {
            g.a((Context) this, getString(R.l.eyj), null, getString(R.l.send), getString(R.l.cancel), true, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SelectConversationUI wqV;

                {
                    this.wqV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SelectConversationUI wqV;

                {
                    this.wqV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    super.aIP();
                    this.wqV.aHf();
                }
            });
        } else {
            super.aIP();
            aHf();
        }
        if (this.wqQ != null) {
            ReportUtil.a(this, this.wqQ);
        }
    }

    public void onBackPressed() {
        super.aIP();
    }

    public final void hf(int i) {
        int headerViewsCount;
        com.tencent.mm.ui.contact.a.a BL;
        if (this.wqO) {
            headerViewsCount = i - this.oCR.getHeaderViewsCount();
            if (headerViewsCount < 0) {
                w.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
                caf();
                return;
            }
            n bYb = bYb();
            BL = bYb.BL(headerViewsCount);
            if (BL != null && BL.jiL != null) {
                String str = BL.jiL.field_username;
                w.i("MicroMsg.SelectConversationUI", "ClickUser=%s", str);
                if (this.wqP.contains(str) || !lM(true)) {
                    bYh();
                    this.nyd.MF(str);
                    if (this.wqP.contains(str)) {
                        this.wqP.remove(str);
                    } else {
                        this.wqP.add(str);
                    }
                    Ok();
                    bYb.notifyDataSetChanged();
                    return;
                }
                bYh();
            }
        } else if (i < this.oCR.getHeaderViewsCount()) {
            w.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", Integer.valueOf(i));
            if (this.vZu) {
                cag();
            } else {
                cah();
            }
        } else {
            BL = (com.tencent.mm.ui.contact.a.a) this.oCR.getAdapter().getItem(i);
            if (BL == null) {
                return;
            }
            Intent intent;
            if ((BL instanceof com.tencent.mm.ui.contact.a.b) && ((com.tencent.mm.ui.contact.a.b) BL).aIO == getResources().getString(R.l.dCJ)) {
                w.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                intent = new Intent();
                intent.putExtra("list_attr", 16384);
                com.tencent.mm.bb.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.wqD = true;
            } else if (BL instanceof f) {
                f fVar = (f) BL;
                Intent intent2 = new Intent();
                intent2.putExtra("scene", this.scene);
                Serializable arrayList = new ArrayList();
                for (Object add : fVar.mai) {
                    arrayList.add(add);
                }
                intent2.putExtra("query_phrase_list", arrayList);
                com.tencent.mm.bb.d.a((Context) this, ".ui.transmit.MMCreateChatroomUI", intent2, 1);
            } else {
                af afVar = BL.jiL;
                if (afVar != null) {
                    String str2 = afVar.field_username;
                    w.i("MicroMsg.SelectConversationUI", "doClickUser=%s", str2);
                    Intent intent3 = new Intent();
                    intent3.putExtra("Select_Conv_User", str2);
                    intent = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                    if (intent != null) {
                        a(intent3, intent);
                    } else if (this.wqB || this.vZu || this.wqC || this.wqD || this.wqE) {
                        n(intent3, str2);
                    } else {
                        d(-1, intent3);
                        finish();
                    }
                    aHf();
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            w.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            w.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        String stringExtra;
        Intent intent2;
        if (i == 1) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                w.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    a(intent, intent2);
                } else if (this.wqB || this.vZu || this.wqC || this.wqD || this.wqE) {
                    n(intent, stringExtra);
                } else {
                    d(-1, intent);
                    finish();
                }
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    finish();
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        intent2 = new Intent(this, TaskRedirectUI.class);
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    }
                    return;
                case 0:
                    if (intent != null) {
                        this.wqQ = (ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3) {
            switch (i2) {
                case -1:
                    if (intent != null) {
                        r0 = intent.getStringExtra("received_card_name");
                        if (!bg.mA(r0)) {
                            d.a aVar = new d.a(this.uSU.uTo);
                            aVar.bs(r0);
                            a(aVar, this.wqK);
                            aVar.c(Boolean.valueOf(true)).xp(R.l.dIA).a(new k.a(this) {
                                final /* synthetic */ SelectConversationUI wqV;

                                public final void a(boolean z, String str, int i) {
                                    this.wqV.aHf();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (r0.endsWith("@chatroom")) {
                                            SelectConversationUI.b(intent, this.wqV.wqK, r0);
                                        } else {
                                            SelectConversationUI.a(intent, this.wqV.wqK, r0);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        this.wqV.d(-1, intent);
                                        this.wqV.finish();
                                    }
                                }
                            }).oHT.show();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 4) {
            if (i2 == -1) {
                n(intent, intent.getStringExtra("Select_Contact"));
            }
        } else if (i != 5) {
            w.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            for (String MG : this.wqP) {
                this.nyd.MG(MG);
            }
            if (u.mA(stringExtra)) {
                this.wqP.clear();
            } else {
                this.wqP = u.f(stringExtra.split(","));
            }
            for (String MG2 : this.wqP) {
                this.nyd.aK(MG2, false);
            }
            Ok();
            bYb().notifyDataSetChanged();
        }
    }

    private static void a(Intent intent, String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(str2);
        a(intent, str, linkedList);
    }

    private static void a(Intent intent, String str, List<String> list) {
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", u.c(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
    }

    private static void b(Intent intent, String str, String str2) {
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
    }

    private void a(d.a aVar, String str) {
        ap.yY();
        c.wR().Ra(str);
        String eK = com.tencent.mm.u.n.eK(str);
        if (!bg.mA(this.wqL)) {
            eK = this.wqL;
        }
        ap.yY();
        aVar.MP(new StringBuffer(com.tencent.mm.u.o.eW(c.wR().Ra(str).field_verifyFlag) ? getResources().getString(R.l.dHs) : getResources().getString(R.l.dHt)).append(eK).toString());
    }

    private void a(Intent intent, Intent intent2) {
        w.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=" + intent2);
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        com.tencent.mm.ui.base.b.A(this.uSU.uTo, intent2);
    }

    private void n(final Intent intent, String str) {
        if (s.ee(this.ipD, 256)) {
            d(-1, intent);
            finish();
        } else if (u.mA(str)) {
            w.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
        } else {
            if (com.tencent.mm.u.o.dH(str)) {
                int eC = j.eC(str);
                if (!this.wqJ || eC <= u.getInt(com.tencent.mm.i.g.sV().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)) {
                    getString(R.l.eQo, new Object[]{Integer.valueOf(eC)});
                } else {
                    w.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", Integer.valueOf(u.getInt(com.tencent.mm.i.g.sV().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)), Integer.valueOf(eC));
                    g.b(this, getString(R.l.eQq, new Object[]{Integer.valueOf(r1)}), "", true);
                    return;
                }
            }
            d.a aVar = new d.a(this.uSU.uTo);
            aVar.bs(str);
            if (this.vZu) {
                a(aVar, this.wqK);
                if (str.endsWith("@chatroom")) {
                    b(intent, this.wqK, str);
                } else {
                    a(intent, this.wqK, str);
                }
                aVar.c(Boolean.valueOf(true));
            } else if (this.wqC) {
                if (this.fFx != -1) {
                    c(aVar);
                    b fnVar = new fn();
                    fnVar.fKl.fFx = this.fFx;
                    fnVar.fKl.fKm = aVar;
                    fnVar.fKl.fDi = this.uSU.uTo;
                    com.tencent.mm.sdk.b.a.urY.m(fnVar);
                } else if (this.msgType == 17 && this.wqI != 0) {
                    aVar.MP(new StringBuffer(getResources().getString(R.l.dHF)).append(this.uSU.uTo.getString(R.l.eLI, new Object[]{Integer.valueOf(this.wqI)})).toString());
                }
                aVar.c(Boolean.valueOf(true));
            } else if (this.wqD) {
                HashMap hashMap = (HashMap) getIntent().getSerializableExtra("webview_params");
                String str2 = (String) hashMap.get("img_url");
                String str3 = (String) hashMap.get("title");
                r0 = (String) hashMap.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                aVar.MP(new StringBuffer(getResources().getString(R.l.dIU)).append(str3).toString());
                aVar.a(new h.a.a(this) {
                    final /* synthetic */ SelectConversationUI wqV;

                    public final void auI() {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", r0);
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
                aVar.MQ(str2).bEV();
                aVar.c(Boolean.valueOf(true));
            } else if (this.wqE) {
                a(aVar);
            } else if (this.wqG) {
                r0 = getResources().getString(R.l.dHv);
                if (this.keo != null) {
                    r0 = new StringBuffer(r0).append(this.keo).toString();
                }
                aVar.MP(r0);
                aVar.c(Boolean.valueOf(false));
            } else {
                b(aVar);
                c(aVar);
                aVar.c(Boolean.valueOf(true));
            }
            aVar.xp(R.l.dIA).a(new k.a(this) {
                final /* synthetic */ SelectConversationUI wqV;

                public final void a(boolean z, String str, int i) {
                    this.wqV.aHf();
                    boolean booleanExtra = intent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
                    if (booleanExtra) {
                        int i2 = z ? 1 : 0;
                        w.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", Integer.valueOf(13943), Integer.valueOf(i2));
                        com.tencent.mm.plugin.report.service.g.oUh.i(13943, Integer.valueOf(i2));
                    }
                    if (z) {
                        intent.putExtra("custom_send_text", str);
                        this.wqV.d(-1, intent);
                        this.wqV.finish();
                    } else if (booleanExtra) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        ap.yY();
                        c.wW().Rl(stringExtra);
                    }
                }
            }).oHT.show();
        }
    }

    private void a(d.a aVar) {
        HashMap hashMap = (HashMap) getIntent().getSerializableExtra("appbrand_params");
        int i = bt.getInt(hashMap.get(Columns.TYPE), 1);
        String b = bt.b(hashMap.get("title"), "");
        String b2 = bt.b(hashMap.get("img_url"), null);
        if (i == 2 || i == 3) {
            String b3 = bt.b(hashMap.get("app_id"), null);
            int i2 = bt.getInt(hashMap.get("pkg_type"), 0);
            int i3 = bt.getInt(hashMap.get("pkg_version"), 0);
            String b4 = bt.b(hashMap.get("cache_key"), null);
            String b5 = bt.b(hashMap.get("path"), null);
            String b6 = bt.b(hashMap.get("delay_load_img_path"), null);
            boolean ax = bt.ax(hashMap.get("is_dynamic"));
            final View aR = ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aR(this);
            final String aM = com.tencent.mm.plugin.appbrand.l.b.aM(this);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", b3);
            bundle.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            bundle.putInt("msg_pkg_type", i2);
            bundle.putInt("pkg_version", i3);
            bundle.putString("image_url", b2);
            bundle.putBoolean("is_dynamic_page", ax);
            bundle.putString("title", b);
            bundle.putString("cache_key", b4);
            bundle.putString("msg_path", b5);
            bundle.putString("delay_load_img_path", b6);
            ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(aM, aR, bundle);
            aVar.cR(aR);
            aVar.c(Boolean.valueOf(true));
            aVar.bEW();
            aVar.jrW = new OnDismissListener(this) {
                final /* synthetic */ SelectConversationUI wqV;

                public final void onDismiss(DialogInterface dialogInterface) {
                    ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(aM, aR);
                }
            };
            return;
        }
        aVar.MP(new StringBuffer(getResources().getString(R.l.dDP)).append(b).toString());
        aVar.MQ(b2).bEV();
        aVar.c(Boolean.valueOf(true));
    }

    private void b(d.a aVar) {
        String str;
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap bitmap;
                if (this.fTk == null) {
                    bitmap = null;
                } else {
                    str = this.fTk.field_imgPath;
                    com.tencent.mm.ah.f GS = com.tencent.mm.ah.n.GS();
                    bitmap = com.tencent.mm.sdk.platformtools.d.a(GS.jv(str), com.tencent.mm.bg.a.getDensity(ab.getContext()), 0);
                }
                if (bitmap == null && this.imagePath != null) {
                    bitmap = com.tencent.mm.sdk.platformtools.d.Pg(this.imagePath);
                }
                aVar.a(bitmap, 3);
                return;
            case 1:
                aVar.a(cae(), 2);
                return;
            case 2:
            case 10:
                com.tencent.mm.t.f.a B;
                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(this.fSs));
                if (this.fTk.bLX() && ek == null) {
                    B = com.tencent.mm.t.f.a.B(bg.PX(this.fSs), bg.PX(this.fSs));
                } else {
                    B = ek;
                }
                if (B != null) {
                    String string;
                    str = B.title;
                    if (ac.g(this.fTk, this.vCX)) {
                        string = getResources().getString(R.l.dDP);
                    } else if (B.type == 5) {
                        string = getResources().getString(R.l.dIU);
                        r2 = B.url;
                    } else if (B.type == 6) {
                        string = getResources().getString(R.l.dHn);
                    } else if (B.type == 24) {
                        r2 = getResources().getString(R.l.dHS);
                        b lzVar = new lz();
                        lzVar.fTf.type = 0;
                        lzVar.fTf.fTh = B.hhQ;
                        com.tencent.mm.sdk.b.a.urY.m(lzVar);
                        str = bg.ap(lzVar.fTg.fTp.desc, B.description).replaceAll("\n", " ");
                        string = r2;
                    } else if (B.type == 19) {
                        string = getResources().getString(R.l.dIr);
                    } else if (B.type == 3) {
                        string = getResources().getString(R.l.dHI);
                    } else if (B.type == 4) {
                        string = getResources().getString(R.l.dIX);
                    } else if (B.type == 8) {
                        string = getResources().getString(R.l.dGN);
                    } else if (B.type != 33 && B.type != 36) {
                        string = getResources().getString(R.l.dDm);
                    } else if (B.hjO == 2 || B.hjO == 3 || B.type == 36) {
                        final View aR = ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).aR(this);
                        aVar.cR(aR);
                        aVar.c(Boolean.valueOf(true));
                        aVar.bEW();
                        str = com.tencent.mm.ah.n.GS().jv(this.fTk.field_imgPath);
                        final String aM = com.tencent.mm.plugin.appbrand.l.b.aM(this);
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", B.hjN);
                        bundle.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(B.hjT), Integer.valueOf(B.hjQ)}));
                        bundle.putInt("msg_pkg_type", B.hjT);
                        bundle.putInt("pkg_version", B.hjQ);
                        if (!bg.mA(str)) {
                            bundle.putString("image_url", "file://" + str);
                        }
                        com.tencent.mm.t.a aVar2 = (com.tencent.mm.t.a) B.n(com.tencent.mm.t.a.class);
                        if (aVar2 != null) {
                            bundle.putBoolean("is_dynamic_page", aVar2.hhi);
                            bundle.putString("cache_key", aVar2.hhj);
                        }
                        bundle.putString("title", B.title);
                        bundle.putString("msg_path", B.hjL);
                        ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(aM, aR, bundle);
                        aVar.jrW = new OnDismissListener(this) {
                            final /* synthetic */ SelectConversationUI wqV;

                            public final void onDismiss(DialogInterface dialogInterface) {
                                ((com.tencent.mm.modelappbrand.h) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.h.class)).a(aM, aR);
                            }
                        };
                        return;
                    } else {
                        string = getResources().getString(R.l.dDP);
                    }
                    if (str == null) {
                        str = "";
                    }
                    aVar.MP(new StringBuffer(string).append(str).toString());
                    if (B.thumburl != null) {
                        aVar.MQ(B.thumburl).bEV();
                        return;
                    }
                    return;
                } else if (this.wqS != null) {
                    str = getResources().getString(R.l.dIX);
                    aVar.MP(new StringBuffer(str).append(this.wqS).toString());
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.keo != null) {
                    aVar.MP(new StringBuffer(getResources().getString(R.l.dHn)).append(this.keo).toString());
                    return;
                }
                return;
            case 4:
                aVar.MP(this.fSs);
                aVar.bEU();
                return;
            case 5:
                if (!bg.mA(this.wqR)) {
                    aVar.MR(this.wqR);
                    return;
                } else if (bg.mA(this.fTk.field_imgPath)) {
                    aVar.MR(this.imagePath);
                    return;
                } else {
                    aVar.MR(this.fTk.field_imgPath);
                    return;
                }
            case 8:
                ap.yY();
                au.a Av = c.wT().Av(this.fSs);
                this.wqK = Av.rUK;
                this.wqL = Av.fFa;
                this.wqM = Boolean.valueOf(com.tencent.mm.u.o.eW(Av.rWg));
                a(aVar, this.wqK);
                return;
            case 9:
                ap.yY();
                au.b Aw = c.wT().Aw(this.fSs);
                str = "";
                if (Aw != null) {
                    str = Aw.label;
                }
                aVar.MP(this.uSU.uTo.getString(R.l.dHB) + str);
                return;
            case 11:
                aVar.a(cae(), 2);
                return;
            case 12:
                int size;
                lz eS = com.tencent.mm.ui.chatting.ab.eS(this.uSU.uTo);
                if (eS.fTf.fTl != null) {
                    size = eS.fTf.fTl.size();
                } else {
                    size = 0;
                }
                aVar.MP(new StringBuffer(getResources().getString(R.l.dHF)).append(this.uSU.uTo.getString(R.l.eLI, new Object[]{Integer.valueOf(size)})).toString());
                return;
            case 13:
                aVar.MP(new StringBuffer(getResources().getString(R.l.dHG)).append(u.ap(com.tencent.mm.ui.chatting.ab.eS(this.uSU.uTo).fTg.fTo.title, "")).toString());
                return;
            default:
                return;
        }
    }

    private void c(d.a aVar) {
        switch (this.msgType) {
            case 0:
            case 1:
            case 11:
            case 16:
                aVar.a(new h.a.a(this) {
                    final /* synthetic */ SelectConversationUI wqV;

                    {
                        this.wqV = r1;
                    }

                    public final void auI() {
                        Intent intent = new Intent(this.wqV.uSU.uTo, ImageGalleryUI.class);
                        intent.putExtra("img_gallery_msg_id", this.wqV.fGM);
                        intent.putExtra("img_gallery_msg_svr_id", this.wqV.fTk.field_msgSvrId);
                        intent.putExtra("img_gallery_talker", this.wqV.fTk.field_talker);
                        intent.putExtra("img_gallery_chatroom_name", this.wqV.fTk.field_talker);
                        intent.putExtra("img_preview_only", true);
                        this.wqV.startActivity(intent);
                        com.tencent.mm.ui.base.b.eM(this.wqV.uSU.uTo);
                    }
                });
                return;
            case 2:
            case 10:
                final com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(this.fSs));
                if (ek == null) {
                    return;
                }
                if (ek.type == 5 && !ac.g(this.fTk, this.vCX)) {
                    final String str = ek.url;
                    aVar.a(new h.a.a(this) {
                        final /* synthetic */ SelectConversationUI wqV;

                        public final void auI() {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", false);
                            com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    });
                    return;
                } else if (ek.type == 6) {
                    aVar.a(new h.a.a(this) {
                        final /* synthetic */ SelectConversationUI wqV;

                        {
                            this.wqV = r1;
                        }

                        public final void auI() {
                            Intent intent = new Intent();
                            intent.setClassName(this.wqV.uSU.uTo, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                            intent.putExtra("app_msg_id", this.wqV.fGM);
                            intent.putExtra("app_show_share", false);
                            this.wqV.startActivity(intent);
                        }
                    });
                    return;
                } else if (ek.type == 24) {
                    aVar.a(new h.a.a(this) {
                        final /* synthetic */ SelectConversationUI wqV;

                        public final void auI() {
                            b kqVar = new kq();
                            kqVar.fRi.context = this.wqV.uSU.uTo;
                            kqVar.fRi.fGM = this.wqV.fGM;
                            kqVar.fRi.fRj = ek.hhQ;
                            kqVar.fRi.fQy = false;
                            com.tencent.mm.sdk.b.a.urY.m(kqVar);
                        }
                    });
                    return;
                } else if (ek.type == 19) {
                    aVar.a(new h.a.a(this) {
                        final /* synthetic */ SelectConversationUI wqV;

                        public final void auI() {
                            Intent intent = new Intent();
                            intent.putExtra("message_id", this.wqV.fGM);
                            intent.putExtra("record_xml", ek.hhQ);
                            intent.putExtra("record_show_share", false);
                            com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "record", ".ui.RecordMsgDetailUI", intent);
                        }
                    });
                    return;
                } else if (ek.type == 3) {
                    aVar.a(new h.a.a(this) {
                        final /* synthetic */ SelectConversationUI wqV;

                        public final void auI() {
                            String s = p.s(ek.url, "message");
                            String s2 = p.s(ek.hhp, "message");
                            if (am.isMobile(this.wqV.uSU.uTo) ? s2 != null && s2.length() > 0 : s == null || s.length() <= 0) {
                                s = s2;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", s);
                            intent.putExtra("showShare", false);
                            com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                        }
                    });
                    return;
                } else if (ek.type == 4) {
                    aVar.a(new h.a.a(this) {
                        final /* synthetic */ SelectConversationUI wqV;

                        {
                            this.wqV = r1;
                        }

                        public final void auI() {
                        }
                    });
                    return;
                } else {
                    return;
                }
            case 3:
                aVar.a(new h.a.a(this) {
                    final /* synthetic */ SelectConversationUI wqV;

                    {
                        this.wqV = r1;
                    }

                    public final void auI() {
                        Intent intent = new Intent();
                        intent.setClassName(this.wqV.uSU.uTo, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent.putExtra("app_msg_id", this.wqV.fGM);
                        intent.putExtra("app_show_share", false);
                        this.wqV.startActivity(intent);
                    }
                });
                return;
            case 4:
                aVar.a(new h.a.a(this) {
                    final /* synthetic */ SelectConversationUI wqV;

                    {
                        this.wqV = r1;
                    }

                    public final void auI() {
                        Intent intent = new Intent(this.wqV.uSU.uTo, RetransmitPreviewUI.class);
                        intent.putExtra("Retr_Msg_content", this.wqV.fSs);
                        this.wqV.startActivity(intent);
                        com.tencent.mm.ui.base.b.eM(this.wqV.uSU.uTo);
                    }
                });
                return;
            case 9:
                ap.yY();
                final au.b Aw = c.wT().Aw(this.fSs);
                final String str2 = Aw.label;
                aVar.a(new h.a.a(this) {
                    final /* synthetic */ SelectConversationUI wqV;

                    public final void auI() {
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", Aw.naO);
                        intent.putExtra("kwebmap_lng", Aw.naP);
                        intent.putExtra("Kwebmap_locaion", str2);
                        intent.putExtra("kShowshare", false);
                        com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "location", ".ui.RedirectUI", intent);
                    }
                });
                return;
            case 12:
                com.tencent.mm.ui.chatting.ab.eS(this.uSU.uTo);
                return;
            case 13:
                aVar.a(new h.a.a(this) {
                    final /* synthetic */ SelectConversationUI wqV;

                    {
                        this.wqV = r1;
                    }

                    public final void auI() {
                        lz eS = com.tencent.mm.ui.chatting.ab.eS(this.wqV.uSU.uTo);
                        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(com.tencent.mm.plugin.record.a.m.b(eS.fTg.fTo.title, eS.fTg.fTo.desc, eS.fTg.fSJ.fFA.fFC.tzn, eS.fTf.fTm)));
                        if (ek != null) {
                            Intent intent = new Intent();
                            intent.putExtra("message_id", this.wqV.fGM);
                            intent.putExtra("record_xml", ek.hhQ);
                            intent.putExtra("record_show_share", false);
                            com.tencent.mm.bb.d.b(this.wqV.uSU.uTo, "record", ".ui.RecordMsgDetailUI", intent);
                        }
                    }
                });
                return;
            default:
                return;
        }
    }

    private Bitmap cae() {
        com.tencent.mm.modelvideo.o.KV();
        String lw = com.tencent.mm.modelvideo.s.lw(this.fTk.field_imgPath);
        if (lw == null) {
            lw = this.imagePath;
        }
        return com.tencent.mm.sdk.platformtools.d.Pg(lw);
    }

    private void caf() {
        w.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(R.l.dCT));
        intent.putExtra("list_attr", s.vYT);
        intent.putExtra("already_select_contact", u.c(this.wqP, ","));
        intent.putExtra("max_limit_num", 9);
        this.uSU.uTo.startActivityForResult(intent, 5);
    }

    private void cag() {
        w.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.vYQ);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.wqK);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(R.l.dCT));
        this.uSU.uTo.startActivityForResult(intent, 3);
    }

    private void cah() {
        w.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(R.l.dCT));
        if ((this.fromScene == 4 || this.fromScene == 9) && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", s.q(32, 16, 1, 2, 4, 16384));
        } else {
            intent.putExtra("list_attr", s.vYS);
        }
        this.uSU.uTo.startActivityForResult(intent, 1);
    }

    protected final boolean Og() {
        return false;
    }

    protected final String Oh() {
        String stringExtra = getIntent().getStringExtra("Select_Conv_ui_title");
        return (stringExtra == null || stringExtra.length() <= 0) ? getString(R.l.eQv) : stringExtra;
    }

    protected final boolean Of() {
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.vYg || aVar.jiL == null) {
            return false;
        }
        return this.wqP.contains(aVar.jiL.field_username);
    }

    public final void mK(String str) {
        this.wqP.remove(str);
        bYb().notifyDataSetChanged();
        Ok();
    }

    private void Ok() {
        if (!this.wqN) {
            return;
        }
        if (this.wqP != null && this.wqP.size() > 0) {
            aB(1, getString(R.l.dIA) + "(" + this.wqP.size() + ")");
            a(this.wqU);
            ae(1, true);
        } else if (this.wqO) {
            aB(1, getString(R.l.dII));
            a(this.wqT);
            ae(1, true);
        } else {
            aB(1, getString(R.l.dHH));
            a(this.wqT);
            ae(1, true);
        }
    }

    private boolean lM(boolean z) {
        if (!z ? this.wqP.size() > 9 : this.wqP.size() >= 9) {
            return false;
        }
        g.a(this.uSU.uTo, getString(R.l.eQr, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), getString(R.l.dIs), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ SelectConversationUI wqV;

            {
                this.wqV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    protected final boolean bYf() {
        return true;
    }

    public final int[] aIO() {
        int[] intArrayExtra = getIntent().getIntArrayExtra("search_range");
        if (this.fromScene != 4) {
            return intArrayExtra == null ? super.aIO() : intArrayExtra;
        } else {
            return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        }
    }

    private void d(int i, Intent intent) {
        if (this.msgType == 5) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("emoji_thumb_path", this.wqR);
            intent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
        }
        super.setResult(-1, intent);
    }
}
