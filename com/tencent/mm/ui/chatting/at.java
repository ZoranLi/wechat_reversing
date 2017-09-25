package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.wcdb.FileUtils;

final class at extends b {
    private a vCd;
    private final long vCr = 259200000;

    public at() {
        super(20);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof i) && ((i) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cXJ);
        view.setTag(new i(this.knu).di(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        i iVar = (i) aVar;
        this.vCd = aVar2;
        aVar2.aI(auVar);
        f.a aVar3 = null;
        String str2 = auVar.field_content;
        if (aVar2.vBH) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = auVar.field_content.substring(indexOf + 1);
            }
        }
        if (str2 != null) {
            aVar3 = f.a.B(str2, auVar.field_reserved);
        }
        if (aVar3 != null) {
            com.tencent.mm.pluginsdk.model.app.f cv = g.cv(aVar3.appId, aVar3.fWF);
            if (cv != null && cv.bCU()) {
                ah.b(aVar2, aVar3, auVar);
            }
            str2 = (cv == null || cv.field_appName == null || cv.field_appName.trim().length() <= 0) ? aVar3.appName : cv.field_appName;
            if (aVar3.appId == null || aVar3.appId.length() <= 0 || !g.bn(str2)) {
                iVar.lMU.setVisibility(8);
            } else {
                iVar.lMU.setText(g.a(aVar2.uSU.uTo, cv, str2));
                iVar.lMU.setVisibility(0);
                if (cv == null || !cv.bCU()) {
                    ah.a(aVar2, iVar.lMU, aVar3.appId);
                } else {
                    ah.a(aVar2, iVar.lMU, auVar, aVar3, cv.field_packageName, auVar.field_msgSvrId);
                }
                ah.a(aVar2, iVar.lMU, aVar3.appId);
            }
            if (aVar3.gxD == null || aVar3.gxD.length() == 0) {
                iVar.vyE.setVisibility(8);
            } else {
                iVar.vyE.setVisibility(0);
                ah.b(aVar2, iVar.vyE, (Object) dt.TF(aVar3.gxD));
            }
            switch (aVar3.type) {
                case 2:
                    iVar.mfz.setVisibility(0);
                    com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(aVar3.fCW);
                    String str3 = auVar.field_imgPath;
                    Boolean valueOf = Boolean.valueOf(false);
                    if (LW != null) {
                        str3 = LW.field_fileFullPath;
                        valueOf = Boolean.valueOf(true);
                    }
                    if (!n.GS().a(iVar.mfz, str3, valueOf.booleanValue(), com.tencent.mm.bg.a.getDensity(aVar2.uSU.uTo), aVar3.hhB, aVar3.hhA, true, R.g.bdH, iVar.mfF, R.g.bdI, 1, true, null)) {
                        if (this.sXW) {
                            iVar.mfz.setImageResource(R.k.dvx);
                        } else {
                            iVar.mfz.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bhS));
                        }
                        final i iVar2 = iVar;
                        iVar.mfz.post(new Runnable(this) {
                            final /* synthetic */ at vCt;

                            public final void run() {
                                iVar2.mfz.setLayoutParams(new LayoutParams(-2, -2));
                                iVar2.mfF.setLayoutParams(new LayoutParams(iVar2.mfz.getWidth(), iVar2.mfz.getHeight()));
                            }
                        });
                        break;
                    }
                    break;
            }
            if (aVar2.vxp) {
                iVar.vyF.setVisibility(8);
            } else if (g.g(cv)) {
                iVar.vyF.setVisibility(0);
                iVar.vyE.setVisibility(8);
                ah.c(aVar2, iVar.vyF, dt.a(aVar3, auVar));
            } else {
                iVar.vyF.setVisibility(8);
            }
        }
        iVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        iVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        if (this.sXW) {
            iVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
            iVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        if (!(view == null || auVar == null)) {
            int i = ((dt) view.getTag()).position;
            l.Mg(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
            if (g.h(g.aJ(f.a.ek(this.vCd.cQ(auVar.field_content, auVar.field_isSend)).appId, false))) {
                contextMenu.add(i, 111, 0, this.vCd.getString(R.l.eLH));
            }
            if (d.Jt("favorite")) {
                contextMenu.add(i, 116, 0, this.vCd.getString(R.l.eGa));
            }
            com.tencent.mm.sdk.b.b ddVar = new dd();
            ddVar.fGW.fGM = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            boolean m = g.m(this.vCd.uSU.uTo, 2);
            if (ddVar.fGX.fGu || m) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dUu));
            }
            if (d.Jt("photoedit") && auVar.field_status != 5) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dTN));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            if (!this.vCd.bVJ()) {
                contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, final au auVar) {
        f.a ek;
        String str = null;
        String str2 = auVar.field_content;
        if (str2 != null) {
            ek = f.a.ek(str2);
        } else {
            ek = null;
        }
        switch (menuItem.getItemId()) {
            case 100:
                if (ek != null) {
                    l.ed(auVar.field_msgId);
                }
                ay.L(auVar.field_msgId);
                com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(ek.appId, false);
                if (aJ != null && aJ.bCU()) {
                    ah.a(aVar, ek, auVar, aJ);
                    break;
                }
            case 111:
                if (!(ek == null || ek.fCW == null || ek.fCW.length() <= 0)) {
                    com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(ek.fCW);
                    if (LW != null) {
                        str = LW.field_fileFullPath;
                    }
                }
                if (!auVar.bMt()) {
                    boolean z;
                    if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bg.mA(str) && e.aO(str))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        new ae().post(new Runnable(this) {
                            final /* synthetic */ at vCt;

                            public final void run() {
                                l.a(auVar, null);
                            }
                        });
                        Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                        intent.putExtra("Retr_File_Name", str);
                        intent.putExtra("Retr_Msg_content", aVar.cQ(auVar.field_content, auVar.field_isSend));
                        intent.putExtra("Retr_Msg_Type", 16);
                        intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                        aVar.startActivity(intent);
                        break;
                    }
                }
                w.i("MicroMsg.ChattingItemAppMsgFromImg", "img is expired or clean!!!");
                com.tencent.mm.ui.base.g.a(aVar.uSU.uTo, aVar.uSU.uTo.getString(R.l.esv), aVar.uSU.uTo.getString(R.l.dIO), new OnClickListener(this) {
                    final /* synthetic */ at vCt;

                    {
                        this.vCt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            f.a aVar2 = null;
            String cQ = aVar.cQ(auVar.field_content, auVar.field_isSend);
            if (cQ != null) {
                aVar2 = f.a.ek(cQ);
            }
            if (aVar2 == null) {
                w.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
                return true;
            }
            int height;
            int i;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                height = view.getHeight();
                i = width;
            } else {
                height = 0;
                i = 0;
            }
            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(aVar2.appId, true);
            if (aJ != null && aJ.bCU()) {
                ah.a(aVar, aVar2, ah.c(aVar, auVar), aJ, auVar.field_msgSvrId);
            }
            String str;
            if (aVar2.fCW != null && aVar2.fCW.length() > 0) {
                com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(aVar2.fCW);
                long j;
                if (LW != null && LW.azf()) {
                    cQ = LW.field_fileFullPath;
                    if (!e.aO(cQ)) {
                        w.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", cQ, Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                        Intent intent = new Intent();
                        intent.setClassName(aVar.uSU.uTo, "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                        intent.putExtra("clean_view_type", 1);
                        aVar.startActivity(intent);
                        return true;
                    } else if (cQ == null || cQ.equals("") || !e.aO(cQ)) {
                        w.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                    } else {
                        String str2;
                        int i2;
                        Bundle bundle;
                        j = auVar.field_msgId;
                        long j2 = auVar.field_msgSvrId;
                        str = auVar.field_talker;
                        Intent intent2 = new Intent(this.vCd.uSU.uTo, ImageGalleryUI.class);
                        intent2.putExtra("img_gallery_msg_id", j);
                        intent2.putExtra("img_gallery_talker", str);
                        intent2.putExtra("img_gallery_left", iArr[0]);
                        intent2.putExtra("img_gallery_top", iArr[1]);
                        intent2.putExtra("img_gallery_width", i);
                        intent2.putExtra("img_gallery_height", height);
                        String bUg = this.vCd.bUg();
                        String a = a(this.vCd, auVar);
                        Bundle bundle2 = new Bundle();
                        if (this.vCd.vBH) {
                            str2 = "stat_scene";
                            i2 = 2;
                            bundle = bundle2;
                        } else {
                            str2 = "stat_scene";
                            if (o.eV(bUg)) {
                                i2 = 7;
                                bundle = bundle2;
                            } else {
                                i2 = 1;
                                bundle = bundle2;
                            }
                        }
                        bundle.putInt(str2, i2);
                        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                        bundle2.putString("stat_chat_talker_username", bUg);
                        bundle2.putString("stat_send_msg_user", a);
                        intent2.putExtra("_stat_obj", bundle2);
                        this.vCd.startActivity(intent2);
                    }
                } else if (auVar.field_isSend == 0) {
                    j = auVar.field_msgId;
                    Intent intent3 = new Intent();
                    intent3.setClassName(this.vCd.uSU.uTo, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                    intent3.putExtra("app_msg_id", j);
                    this.vCd.startActivity(intent3);
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str = p.s(aVar2.url, "message");
                PackageInfo az = ah.az(aVar.uSU.uTo, aVar2.appId);
                a(aVar, str, str, az == null ? null : az.versionName, az == null ? 0 : az.versionCode, aVar2.appId, false, auVar.field_msgId, auVar.field_msgSvrId, auVar);
            }
            return true;
        }
        s.eP(aVar.uSU.uTo);
        return true;
    }
}
