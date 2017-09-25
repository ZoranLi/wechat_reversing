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
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.c;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.wcdb.FileUtils;

final class bb extends c {
    public a vCd;

    public bb() {
        super(21);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof i) && ((i) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYo);
        view.setTag(new i(this.knu).di(view));
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        aVar = (i) aVar;
        this.vCd = aVar2;
        aVar2.aI(auVar);
        f.a aVar3 = null;
        String str2 = auVar.field_content;
        if (str2 != null) {
            aVar3 = f.a.B(str2, auVar.field_reserved);
        }
        if (aVar3 != null) {
            com.tencent.mm.pluginsdk.model.app.f cv = g.cv(aVar3.appId, aVar3.fWF);
            String str3 = (cv == null || cv.field_appName == null || cv.field_appName.trim().length() <= 0) ? aVar3.appName : cv.field_appName;
            if (aVar3.appId == null || aVar3.appId.length() <= 0 || !g.bn(str3)) {
                aVar.lMU.setVisibility(8);
            } else {
                aVar.lMU.setText(g.a(aVar2.uSU.uTo, cv, str3));
                aVar.lMU.setVisibility(0);
                if (cv == null || !cv.bCU()) {
                    ah.a(aVar2, aVar.lMU, aVar3.appId);
                } else {
                    ah.a(aVar2, aVar.lMU, auVar, aVar3, cv.field_packageName, auVar.field_msgSvrId);
                }
                ah.a(aVar2, aVar.lMU, aVar3.appId);
            }
            switch (aVar3.type) {
                case 2:
                    aVar.mfz.setVisibility(0);
                    b LW = an.abL().LW(aVar3.fCW);
                    String str4 = auVar.field_imgPath;
                    Boolean valueOf = Boolean.valueOf(false);
                    if (LW != null) {
                        str4 = LW.field_fileFullPath;
                        valueOf = Boolean.valueOf(true);
                    }
                    if (!n.GS().a(aVar.mfz, str4, valueOf.booleanValue(), com.tencent.mm.bg.a.getDensity(aVar2.uSU.uTo), aVar3.hhD, aVar3.hhC, true, R.g.bdJ, aVar.mfF, R.g.bdK, 0, true, null)) {
                        if (this.sXW) {
                            aVar.mfz.setImageResource(R.k.dvy);
                        } else {
                            aVar.mfz.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bhS));
                        }
                        final ah.a aVar4 = aVar;
                        aVar.mfz.post(new Runnable(this) {
                            final /* synthetic */ bb vCB;

                            public final void run() {
                                aVar4.mfz.setLayoutParams(new LayoutParams(-2, -2));
                                aVar4.mfF.setLayoutParams(new LayoutParams(aVar4.mfz.getWidth(), aVar4.mfz.getHeight()));
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        aVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        if (this.sXW) {
            aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
            aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        }
        int Mg = l.Mg(str2);
        if (Mg == -1 || Mg >= 100 || aVar3.hhq <= 0 || auVar.field_status == 5) {
            aVar.lKQ.setVisibility(8);
            aVar.mfz.setAlpha(255);
            aVar.mfz.setBackgroundDrawable(null);
        } else {
            aVar.lKQ.setVisibility(0);
            aVar.vyD.setText(Mg + "%");
            aVar.mfz.setAlpha(64);
            aVar.mfz.setBackgroundResource(R.g.bjw);
        }
        ah.a(i, aVar, auVar, aVar2.vBD.hrM, aVar2.vxp, aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        f.a ek = f.a.ek(this.vCd.cQ(auVar.field_content, auVar.field_isSend));
        if (ek != null && g.h(g.aJ(ek.appId, false))) {
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
        if (!auVar.bLX() && auVar.bMp() && ((auVar.field_status == 2 || auVar.gxJ == 1) && ah.ao(auVar) && ah.Tn(auVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dUx));
        }
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, this.vCd.getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
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
                    b LW = an.abL().LW(ek.fCW);
                    if (LW != null) {
                        str = LW.field_fileFullPath;
                    }
                }
                Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", auVar.field_content);
                intent.putExtra("Retr_File_Name", str);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        ap.yY();
        if (!com.tencent.mm.u.c.isSDCardAvailable()) {
            s.eP(aVar.uSU.uTo);
            return true;
        } else if (((dt) view.getTag()).knu == 5 && auVar.field_isSend == 1) {
            if (auVar != null) {
                final au auVar2 = auVar;
                com.tencent.mm.ui.base.g.a(this.vCd.uSU.uTo, this.vCd.getString(R.l.dVl), "", this.vCd.getString(R.l.dIv), this.vCd.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ bb vCB;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.V(auVar2);
                        ay.L(auVar2.field_msgId);
                        this.vCB.vCd.bVF();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ bb vCB;

                    {
                        this.vCB = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            return true;
        } else {
            f.a aVar2 = null;
            String str = auVar.field_content;
            if (str != null) {
                aVar2 = f.a.ek(str);
            }
            if (aVar2 == null) {
                w.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
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
            com.tencent.mm.pluginsdk.model.app.f aJ = g.aJ(aVar2.appId, false);
            if (aJ != null && aJ.bCU()) {
                ah.a(aVar, aVar2, m.xL(), aJ, auVar.field_msgSvrId);
            }
            String str2;
            if (aVar2.fCW != null && aVar2.fCW.length() > 0) {
                b LW = an.abL().LW(aVar2.fCW);
                if (LW != null) {
                    ap.yY();
                    if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                        s.eP(aVar.uSU.uTo);
                    } else if (auVar.field_isSend == 1) {
                        str = LW.field_fileFullPath;
                        if (!e.aO(str)) {
                            w.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                            Intent intent = new Intent();
                            intent.setClassName(aVar.uSU.uTo, "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                            intent.putExtra("clean_view_type", 1);
                            aVar.startActivity(intent);
                            return true;
                        } else if (str == null || str.equals("") || !e.aO(str)) {
                            w.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                        } else {
                            String str3;
                            int i2;
                            Bundle bundle;
                            long j = auVar.field_msgId;
                            long j2 = auVar.field_msgSvrId;
                            str2 = auVar.field_talker;
                            Intent intent2 = new Intent(this.vCd.uSU.uTo, ImageGalleryUI.class);
                            intent2.putExtra("img_gallery_msg_id", j);
                            intent2.putExtra("img_gallery_talker", str2);
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", i);
                            intent2.putExtra("img_gallery_height", height);
                            String bUg = this.vCd.bUg();
                            String a = a(this.vCd, auVar);
                            Bundle bundle2 = new Bundle();
                            if (this.vCd.vBH) {
                                str3 = "stat_scene";
                                i2 = 2;
                                bundle = bundle2;
                            } else {
                                str3 = "stat_scene";
                                if (o.eV(bUg)) {
                                    i2 = 7;
                                    bundle = bundle2;
                                } else {
                                    i2 = 1;
                                    bundle = bundle2;
                                }
                            }
                            bundle.putInt(str3, i2);
                            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                            bundle2.putString("stat_chat_talker_username", bUg);
                            bundle2.putString("stat_send_msg_user", a);
                            intent2.putExtra("_stat_obj", bundle2);
                            this.vCd.startActivity(intent2);
                        }
                    }
                    return true;
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str2 = p.s(aVar2.url, "message");
                PackageInfo az = ah.az(aVar.uSU.uTo, aVar2.appId);
                a(aVar, str2, str2, az == null ? null : az.versionName, az == null ? 0 : az.versionCode, aVar2.appId, false, auVar.field_msgId, auVar.field_msgSvrId, auVar);
            }
            return false;
        }
    }
}
