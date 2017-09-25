package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.am.a.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.u.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public final class b implements com.tencent.mm.plugin.record.ui.h.b {
    public ae handler;
    private c iOT = new c<jc>(this) {
        final /* synthetic */ b oPY;

        {
            this.oPY = r2;
            this.usg = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jc jcVar = (jc) bVar;
            if (jcVar instanceof jc) {
                switch (jcVar.fPc.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.oPY.handler.sendMessageAtFrontOfQueue(this.oPY.handler.obtainMessage(1));
                        break;
                }
            }
            return false;
        }
    };
    private int lMT = 0;
    private OnClickListener lNf = new OnClickListener(this) {
        final /* synthetic */ b oPY;

        {
            this.oPY = r1;
        }

        public final void onClick(View view) {
            if (f.rZ()) {
                com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                ro roVar = bVar.fKe.tyc.tyu;
                if (b.l(bVar.fKe)) {
                    w.i("MicroMsg.OtherViewWrapper", "same song, do release");
                    com.tencent.mm.am.b.HH();
                    if (!this.oPY.oPW) {
                        this.oPY.handler.sendMessageAtFrontOfQueue(this.oPY.handler.obtainMessage(1));
                        return;
                    }
                    return;
                }
                String absolutePath;
                this.oPY.oPW = true;
                File file = new File(m.f(bVar.fKe, bVar.fGM));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else if (bVar.fKe.fFs == null) {
                    absolutePath = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    file = new File(stringBuilder.append(com.tencent.mm.u.c.xp()).append("web/").append(g.n(bVar.fKe.fFs.getBytes())).toString());
                    absolutePath = file.exists() ? file.getAbsolutePath() : "";
                }
                rm rmVar = bVar.fKe;
                a aVar = (a) h.h(a.class);
                String str = rmVar.title;
                String str2 = rmVar.desc;
                String str3 = rmVar.txp;
                String str4 = rmVar.txt;
                String str5 = rmVar.txr;
                String str6 = rmVar.lKv;
                StringBuilder stringBuilder2 = new StringBuilder();
                ap.yY();
                com.tencent.mm.am.b.b(aVar.a(6, null, str, str2, str3, str4, str5, str6, stringBuilder2.append(com.tencent.mm.u.c.xp()).append("web/").toString(), absolutePath, "", roVar.appId));
                return;
            }
            s.eP(view.getContext());
        }
    };
    public boolean oPW = false;
    OnClickListener oPX = new OnClickListener(this) {
        final /* synthetic */ b oPY;

        {
            this.oPY = r1;
        }

        public final void onClick(View view) {
            String str = null;
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            Intent intent2;
            String str2;
            Intent intent3;
            Context context;
            Context context2;
            switch (bVar.fKe.aMw) {
                case 4:
                case 15:
                    Context context3 = view.getContext();
                    if (bg.mA(bVar.fKe.txi) || bVar.fKe.txD <= 0) {
                        w.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[]{bVar.fKe.txz, Long.valueOf(bVar.fKe.txD)});
                        str = bVar.fKe.txp;
                        if (bg.mA(str)) {
                            str = bVar.fKe.txt;
                        }
                        if (bg.mA(str)) {
                            w.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                            if (bVar.aMw == 1 && bVar.oOR.field_itemStatus != 10 && bVar.fKe.tyq == 0) {
                                intent = new Intent();
                                intent.putExtra("key_detail_info_id", bVar.oOR.field_localId);
                                intent.putExtra("key_detail_data_id", bVar.fKe.lKv);
                                if (d.c(bVar)) {
                                    b.a(intent, bVar, context3, d.a(bVar), d.b(bVar));
                                    return;
                                } else {
                                    com.tencent.mm.bb.d.b(context3, "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                                    return;
                                }
                            }
                            intent2 = new Intent();
                            str2 = "";
                            str = "";
                            if (bVar.aMw == 0) {
                                str = m.f(bVar.fKe, bVar.fGM);
                                if (bg.mA(str) || !e.aO(str)) {
                                    com.tencent.mm.ui.base.g.bl(context3, context3.getString(R.l.eji));
                                    return;
                                }
                                str2 = m.c(bVar.fKe, bVar.fGM);
                                if (bg.mA(str2) || !e.aO(str2)) {
                                    intent2.putExtra("key_detail_data_valid", false);
                                }
                            } else if (bVar.aMw == 1) {
                                str = d.b(bVar);
                                if (bg.mA(str) || !e.aO(str)) {
                                    com.tencent.mm.ui.base.g.bl(context3, context3.getString(R.l.eji));
                                    return;
                                }
                                str2 = d.a(bVar);
                                if (bg.mA(str2) || !e.aO(str2)) {
                                    intent2.putExtra("key_detail_data_valid", false);
                                }
                            }
                            b.a(intent2, bVar, context3, str2, str);
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        if (bVar.aMw == 1) {
                            intent3.putExtra("is_favorite_item", true);
                            intent3.putExtra("fav_local_id", bVar.oOR.field_localId);
                            intent3.putExtra("key_detail_can_delete", false);
                            intent3.putExtra("geta8key_scene", 14);
                            w.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.oOR.field_id), Long.valueOf(bVar.oOR.field_localId), bVar.fKe.lKv});
                        }
                        com.tencent.mm.bb.d.b(context3, "webview", ".ui.tools.WebViewUI", intent3);
                        return;
                    } else if (bVar.aMw == 0) {
                        intent = new Intent();
                        intent.putExtra("message_id", bVar.fGM);
                        intent.putExtra("record_xml", bVar.fTh);
                        intent.putExtra("record_data_id", bVar.fKe.lKv);
                        intent.putExtra("key_detail_fav_video_scene_from", 1);
                        if (m.d(bVar.fKe, bVar.fGM)) {
                            b.a(intent, bVar, context3, m.c(bVar.fKe, bVar.fGM), m.f(bVar.fKe, bVar.fGM));
                            return;
                        } else {
                            com.tencent.mm.bb.d.b(context3, "record", ".ui.RecordMsgFileUI", intent);
                            return;
                        }
                    } else if (bVar.aMw == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.oOR.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fKe.lKv);
                        if (d.c(bVar)) {
                            b.a(intent, bVar, context3, d.a(bVar), d.b(bVar));
                            return;
                        } else {
                            com.tencent.mm.bb.d.b(context3, "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                            return;
                        }
                    } else {
                        return;
                    }
                case 5:
                    context = view.getContext();
                    if (bVar.fKe.tyc == null) {
                        w.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                        com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ejh));
                        return;
                    }
                    rm rmVar = bVar.fKe;
                    if (rmVar != null) {
                        if (rmVar.tyn) {
                            str = rmVar.canvasPageXml;
                        } else if (!(rmVar.tyc == null || rmVar.tyc.tyy == null || !rmVar.tyc.tyy.tyn)) {
                            str = rmVar.tyc.tyy.canvasPageXml;
                        }
                    }
                    if (bg.mA(str)) {
                        ro roVar = bVar.fKe.tyc.tyu;
                        str = "";
                        if (bVar.fKe.tyc.tyy != null) {
                            str = bVar.fKe.tyc.tyy.tzN;
                        }
                        if (roVar != null && bg.mA(r1)) {
                            str = roVar.hSX;
                        }
                        if (bg.mA(str)) {
                            str = bVar.fKe.txp;
                        }
                        if (bg.mA(str)) {
                            w.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                            com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.ejh));
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str);
                        if (!(roVar == null || bg.mA(roVar.fCJ))) {
                            intent2.putExtra("srcDisplayname", n.eK(roVar.fCJ));
                        }
                        intent2.putExtra("mode", 1);
                        if (bVar.aMw == 1) {
                            intent2.putExtra("is_favorite_item", true);
                            intent2.putExtra("fav_local_id", bVar.oOR.field_localId);
                            intent2.putExtra("key_detail_can_delete", false);
                            intent2.putExtra("geta8key_scene", 14);
                            intent2.putExtra("from_scence", 4);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", bVar.fKe.fUY);
                        intent2.putExtra("jsapiargs", bundle);
                        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    }
                    Intent intent4 = new Intent();
                    intent4.putExtra("sns_landing_pages_xml", str);
                    intent4.putExtra("sns_landig_pages_from_source", 5);
                    intent4.putExtra("sns_landing_pages_share_thumb_url", bVar.fKe.hhy);
                    intent4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent4.putExtra("msg_id", bVar.fGM);
                    com.tencent.mm.bb.d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent4);
                    return;
                case 6:
                    Context context4 = view.getContext();
                    if (context4 != null) {
                        rs rsVar;
                        ro roVar2;
                        if (bVar.fKe.tyc != null) {
                            rsVar = bVar.fKe.tyc.tyw;
                            roVar2 = bVar.fKe.tyc.tyu;
                        } else {
                            roVar2 = null;
                            rsVar = null;
                        }
                        if (roVar2 != null) {
                            str = !bg.mA(roVar2.tyQ) ? n.eK(roVar2.tyQ) : n.eK(roVar2.fOu);
                        }
                        if (roVar2 == null && bVar.aMw == 1) {
                            str = n.eK(bVar.oOR.field_fromUser);
                        }
                        if (rsVar == null) {
                            w.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                            com.tencent.mm.ui.base.g.bl(context4, context4.getString(R.l.ejf));
                            return;
                        }
                        intent3 = new Intent();
                        intent3.putExtra("kwebmap_slat", rsVar.lat);
                        intent3.putExtra("kwebmap_lng", rsVar.lng);
                        intent3.putExtra("kPoiName", rsVar.fRX);
                        intent3.putExtra("Kwebmap_locaion", rsVar.label);
                        if (rsVar.fOd >= 0) {
                            intent3.putExtra("kwebmap_scale", rsVar.fOd);
                        }
                        intent3.putExtra("kisUsername", str);
                        intent3.putExtra("kwebmap_from_to", true);
                        if (bVar.aMw == 1) {
                            intent3.putExtra("KFavLocSigleView", true);
                            intent3.putExtra("map_view_type", 2);
                            intent3.putExtra("kFavInfoLocalId", bVar.oOR.field_localId);
                            intent3.putExtra("kFavCanDel", false);
                            intent3.putExtra("kFavCanRemark", false);
                        } else if (bVar.aMw == 0) {
                            intent3.putExtra("map_view_type", 1);
                        }
                        com.tencent.mm.bb.d.b(context4, "location", ".ui.RedirectUI", intent3, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                        return;
                    }
                    return;
                case 7:
                    context2 = view.getContext();
                    intent3 = new Intent();
                    if (bg.mA(bVar.fKe.txp)) {
                        w.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[]{bVar.fKe.lKv});
                        intent3.putExtra("rawUrl", bVar.fKe.txr);
                    } else {
                        intent3.putExtra("rawUrl", bVar.fKe.txp);
                    }
                    if (bVar.aMw == 1) {
                        intent3.putExtra("is_favorite_item", true);
                        intent3.putExtra("fav_local_id", bVar.oOR.field_localId);
                        intent3.putExtra("key_detail_can_delete", false);
                        w.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.oOR.field_id), Long.valueOf(bVar.oOR.field_localId), bVar.fKe.lKv});
                    }
                    com.tencent.mm.bb.d.b(context2, "webview", ".ui.tools.WebViewUI", intent3);
                    return;
                case 8:
                    boolean z;
                    context = view.getContext();
                    if (bVar.aMw == 0) {
                        if (m.d(bVar.fKe, bVar.fGM) && !com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, m.c(bVar.fKe, bVar.fGM), bVar.fKe.txx, 2)) {
                            z = false;
                        }
                        z = true;
                    } else {
                        if (bVar.aMw == 1 && d.c(bVar) && !com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, d.a(bVar), bVar.fKe.txx, 2)) {
                            z = false;
                        }
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                    if (bVar.aMw == 0) {
                        intent = new Intent(context, RecordMsgFileUI.class);
                        intent.putExtra("message_id", bVar.fGM);
                        intent.putExtra("record_xml", bVar.fTh);
                        intent.putExtra("record_data_id", bVar.fKe.lKv);
                        context.startActivity(intent);
                        return;
                    } else if (bVar.aMw != 1) {
                        return;
                    } else {
                        if (m.h(bVar.fKe, bVar.fGM)) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.oOR.field_localId);
                            com.tencent.mm.bb.d.b(context, "favorite", ".ui.detail.FavoriteImgDetailUI", intent);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.oOR.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fKe.lKv);
                        intent.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.bb.d.b(context, "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                        return;
                    }
                case 10:
                    context2 = view.getContext();
                    if (bVar.fKe.tyc == null || bVar.fKe.tyc.tyA == null) {
                        w.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                        com.tencent.mm.ui.base.g.bl(context2, context2.getString(R.l.eje));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_Product_xml", bVar.fKe.tyc.tyA.info);
                    if (bVar.aMw == 1) {
                        intent3.putExtra("key_is_favorite_item", true);
                        intent3.putExtra("key_favorite_local_id", bVar.oOR.field_localId);
                        intent3.putExtra("key_can_delete_favorite_item", false);
                        intent3.putExtra("key_ProductUI_getProductInfoScene", 3);
                    }
                    com.tencent.mm.bb.d.b(context2, "scanner", ".ui.ProductUI", intent3);
                    return;
                case 11:
                    context2 = view.getContext();
                    if (bVar.fKe.tyc == null || bVar.fKe.tyc.tyA == null) {
                        w.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                        com.tencent.mm.ui.base.g.bl(context2, context2.getString(R.l.eje));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_product_info", bVar.fKe.tyc.tyA.info);
                    if (bVar.aMw == 1) {
                        intent3.putExtra("key_product_scene", 4);
                    }
                    com.tencent.mm.bb.d.b(context2, "product", ".ui.MallProductUI", intent3);
                    return;
                case 14:
                    context2 = view.getContext();
                    if (bVar.fKe.tyc == null || bVar.fKe.tyc.tyC == null) {
                        w.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                        com.tencent.mm.ui.base.g.bl(context2, context2.getString(R.l.eje));
                        return;
                    }
                    intent3 = new Intent();
                    intent3.putExtra("key_TV_getProductInfoScene", 3);
                    intent3.putExtra("key_TV_xml", bVar.fKe.tyc.tyC.info);
                    if (bVar.aMw == 1) {
                        intent3.putExtra("key_is_favorite_item", true);
                        intent3.putExtra("key_favorite_local_id", bVar.oOR.field_localId);
                        intent3.putExtra("key_can_delete_favorite_item", false);
                    }
                    com.tencent.mm.bb.d.b(context2, "shake", ".ui.TVInfoUI", intent3);
                    return;
                case 16:
                    context2 = view.getContext();
                    if (bVar.fKe.tyc == null) {
                        w.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[]{bVar.fKe.lKv});
                        com.tencent.mm.ui.base.g.bl(context2, context2.getString(R.l.eje));
                        return;
                    }
                    str2 = bVar.fKe.desc;
                    ap.yY();
                    au.a Av = com.tencent.mm.u.c.wT().Av(str2);
                    if (Av == null) {
                        w.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[]{str2, bVar.fKe.lKv});
                        com.tencent.mm.ui.base.g.bl(context2, context2.getString(R.l.eje));
                        return;
                    }
                    Intent intent5 = new Intent();
                    intent5.putExtra("Contact_User", Av.rUK);
                    intent5.putExtra("Contact_Alias", Av.gtR);
                    intent5.putExtra("Contact_Nick", Av.fFa);
                    intent5.putExtra("Contact_QuanPin", Av.hCf);
                    intent5.putExtra("Contact_PyInitial", Av.hCe);
                    intent5.putExtra("Contact_Uin", Av.ovb);
                    intent5.putExtra("Contact_Mobile_MD5", Av.uJX);
                    intent5.putExtra("Contact_full_Mobile_MD5", Av.uJY);
                    intent5.putExtra("Contact_QQNick", Av.bMH());
                    intent5.putExtra("User_From_Fmessage", false);
                    intent5.putExtra("Contact_Scene", Av.scene);
                    intent5.putExtra("Contact_FMessageCard", true);
                    intent5.putExtra("Contact_RemarkName", Av.hCj);
                    intent5.putExtra("Contact_VUser_Info_Flag", Av.rWg);
                    intent5.putExtra("Contact_VUser_Info", Av.gkG);
                    intent5.putExtra("Contact_BrandIconURL", Av.osT);
                    intent5.putExtra("Contact_Province", Av.getProvince());
                    intent5.putExtra("Contact_City", Av.getCity());
                    intent5.putExtra("Contact_Sex", Av.gkr);
                    intent5.putExtra("Contact_Signature", Av.signature);
                    intent5.putExtra("Contact_ShowUserName", false);
                    intent5.putExtra("Contact_KSnsIFlag", 0);
                    com.tencent.mm.bb.d.b(context2, "profile", ".ui.ContactInfoUI", intent5);
                    com.tencent.mm.bc.a.xU(Av.scene);
                    return;
                case 17:
                    context2 = view.getContext();
                    if (context2 != null && bVar.aMw == 0 && bVar.fKe.tys != null) {
                        intent3 = new Intent(context2, RecordMsgDetailUI.class);
                        intent3.putExtra("message_id", bVar.fGM);
                        intent3.putExtra("record_xml", bVar.fKe.tys);
                        context2.startActivity(intent3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private com.tencent.mm.plugin.record.ui.h.a oPj;

    public b(com.tencent.mm.plugin.record.ui.h.a aVar, ae aeVar) {
        this.oPj = aVar;
        this.handler = aeVar;
    }

    public final View cJ(Context context) {
        View inflate = View.inflate(context, R.i.dmo, null);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(context, 75);
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
        return inflate;
    }

    private static String getAppName(Context context, String str) {
        com.tencent.mm.u.x.b bVar = x.a.hlQ;
        if (bVar != null) {
            return bVar.m(context, str);
        }
        return "";
    }

    public static boolean l(rm rmVar) {
        anf HL = com.tencent.mm.am.b.HL();
        return HL != null && HL.tRH == 6 && bg.ap(rmVar.lKv, "").equals(HL.tqY) && com.tencent.mm.am.b.HJ();
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(R.h.title);
        TextView textView2 = (TextView) view.findViewById(R.h.bHZ);
        TextView textView3 = (TextView) view.findViewById(R.h.cGa);
        MMImageView mMImageView = (MMImageView) view.findViewById(R.h.icon);
        mMImageView.setVisibility(0);
        ImageView imageView = (ImageView) view.findViewById(R.h.bWy);
        imageView.setVisibility(8);
        View findViewById = view.findViewById(R.h.cxe);
        findViewById.setVisibility(0);
        findViewById.setTag(bVar);
        findViewById.setOnClickListener(this.oPX);
        View findViewById2 = view.findViewById(R.h.cKL);
        findViewById2.setVisibility(8);
        com.tencent.mm.plugin.record.ui.h.a.a aVar = new com.tencent.mm.plugin.record.ui.h.a.a();
        if (bVar.aMw == 0) {
            aVar.oPl = bVar.fGM;
        } else if (bVar.aMw == 1) {
            aVar.oPl = bVar.oOR.field_localId;
        }
        aVar.fKf = mMImageView;
        aVar.fKe = bVar.fKe;
        aVar.height = this.lMT;
        aVar.width = this.lMT;
        rm rmVar;
        CharSequence string;
        rm rmVar2;
        switch (bVar.fKe.aMw) {
            case 4:
            case 15:
                rmVar = bVar.fKe;
                if (bg.mA(rmVar.title)) {
                    textView.setText(R.l.ejL);
                } else {
                    textView.setText(rmVar.title);
                }
                if (rmVar.duration <= 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    Context context = textView2.getContext();
                    int i2 = rmVar.duration;
                    if (i2 <= 0) {
                        string = context.getString(R.l.ejN, new Object[]{Integer.valueOf(0)});
                    } else {
                        int i3 = i2 / 60;
                        i2 %= 60;
                        string = i3 == 0 ? context.getString(R.l.ejN, new Object[]{Integer.valueOf(i2)}) : context.getString(R.l.ejM, new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
                    }
                    textView2.setText(string);
                }
                if (rmVar.tyc == null) {
                    w.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                    textView3.setVisibility(8);
                } else {
                    ro roVar = rmVar.tyc.tyu;
                    if (!bg.mA(roVar.appId)) {
                        string = getAppName(textView3.getContext(), roVar.appId);
                        if (bg.mA(string)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(string);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(R.g.bkX);
                aVar.fKg = R.k.dtr;
                this.oPj.a(aVar);
                break;
            case 5:
                rm rmVar3 = bVar.fKe;
                CharSequence charSequence = "";
                sf sfVar = null;
                if (!(rmVar3 == null || rmVar3.tyc == null)) {
                    sfVar = rmVar3.tyc.tyy;
                }
                if (sfVar != null) {
                    charSequence = sfVar.title;
                }
                if (bg.mA(charSequence) && rmVar3 != null) {
                    charSequence = rmVar3.title;
                }
                if (bg.mA(charSequence)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                string = "";
                if (sfVar != null) {
                    string = bg.PV(sfVar.tzN);
                }
                ro roVar2 = null;
                if (!(rmVar3 == null || rmVar3.tyc == null)) {
                    roVar2 = rmVar3.tyc.tyu;
                }
                if (roVar2 != null) {
                    if (!bg.mA(roVar2.appId)) {
                        string = bg.ap(getAppName(textView3.getContext(), roVar2.appId), "");
                    } else if (!bg.mA(roVar2.fCJ)) {
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(roVar2.fCJ);
                        if (Rc == null || !Rc.field_username.equals(roVar2.fCJ)) {
                            ag.a.hlS.a(roVar2.fCJ, "", null);
                        } else {
                            string = Rc.tL();
                        }
                    }
                    if (bg.mA(string) || string.equals(roVar2.fCJ)) {
                        string = bg.PV(roVar2.hSX);
                    }
                }
                if (bg.mA(string)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(string);
                    textView3.setVisibility(0);
                }
                aVar.fKg = R.g.bbY;
                this.oPj.a(aVar);
                break;
            case 6:
                rmVar2 = bVar.fKe;
                if (rmVar2.tyc == null) {
                    w.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", new Object[]{rmVar2.lKv});
                    textView.setText(R.l.eiF);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    rs rsVar = rmVar2.tyc.tyw;
                    if (bg.mA(rsVar.fRX)) {
                        textView.setText(rsVar.label);
                        textView2.setText(R.l.eiF);
                        textView3.setText("");
                    } else {
                        textView.setText(rsVar.fRX);
                        textView2.setText(rsVar.label);
                        textView3.setText(R.l.eiF);
                    }
                }
                mMImageView.setImageResource(R.k.dtf);
                break;
            case 7:
                textView.setText(bVar.fKe.title);
                textView2.setText(bVar.fKe.desc);
                imageView.setTag(bVar);
                imageView.setOnClickListener(this.lNf);
                imageView.setImageResource(R.g.bhp);
                imageView.setVisibility(0);
                if (l(bVar.fKe)) {
                    imageView.setImageResource(R.g.bho);
                }
                textView3.setVisibility(8);
                aVar.fKg = R.k.dtg;
                this.oPj.a(aVar);
                break;
            case 8:
                rmVar2 = bVar.fKe;
                textView.setText(rmVar2.title);
                textView2.setVisibility(0);
                textView2.setText(bg.U((float) rmVar2.txD));
                textView3.setVisibility(8);
                if (rmVar2.tyq == 2) {
                    textView2.setText(">25MB");
                }
                mMImageView.setImageResource(com.tencent.mm.pluginsdk.c.LC(bVar.fKe.txx));
                break;
            case 10:
                rmVar = bVar.fKe;
                if (rmVar.tyc == null) {
                    w.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ru ruVar = rmVar.tyc.tyA;
                    textView.setText(ruVar.title);
                    textView2.setText(ruVar.desc);
                    textView3.setText(bg.ap(getAppName(textView3.getContext(), rmVar.tyc.tyu.appId), textView3.getContext().getString(R.l.eiW)));
                }
                aVar.fKg = R.k.dto;
                this.oPj.a(aVar);
                break;
            case 11:
                rmVar = bVar.fKe;
                if (rmVar.tyc == null) {
                    w.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    ru ruVar2 = rmVar.tyc.tyA;
                    textView.setText(ruVar2.title);
                    textView2.setText(ruVar2.desc);
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                    textView3.setVisibility(8);
                }
                aVar.fKg = R.k.dto;
                aVar.fKe = null;
                this.oPj.a(aVar);
                break;
            case 14:
                rmVar = bVar.fKe;
                if (rmVar.tyc == null || rmVar.tyc.tyC == null) {
                    w.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", new Object[]{rmVar.lKv});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    rz rzVar = rmVar.tyc.tyC;
                    textView.setText(rzVar.title);
                    textView2.setText(rzVar.desc);
                    textView3.setText(bg.ap(getAppName(textView3.getContext(), rmVar.tyc.tyu.appId), textView3.getContext().getString(R.l.ejI)));
                }
                aVar.fKg = R.k.dto;
                aVar.fKe = null;
                this.oPj.a(aVar);
                break;
            case 16:
                rmVar2 = bVar.fKe;
                ap.yY();
                au.a Av = com.tencent.mm.u.c.wT().Av(rmVar2.desc);
                if (Av == null) {
                    w.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(textView.getContext(), Av != null ? Av.fFa : "", textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(R.l.eiu);
                textView3.setVisibility(0);
                String str = Av.rUK;
                if (!bg.mA(str)) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(mMImageView, str);
                    break;
                } else {
                    mMImageView.setImageResource(R.g.bes);
                    break;
                }
            case 17:
                rmVar2 = bVar.fKe;
                textView.setText(rmVar2.title);
                textView2.setVisibility(0);
                textView2.setText(rmVar2.desc);
                mMImageView.setVisibility(8);
                break;
            default:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                return;
        }
        textView3.setVisibility(8);
    }

    public final void destroy() {
        w.d("MicroMsg.OtherViewWrapper", "do destroy");
        this.oPj = null;
        this.handler = null;
        com.tencent.mm.sdk.b.a.urY.c(this.iOT);
        this.oPW = false;
    }

    public final void pause() {
    }

    static void a(Intent intent, com.tencent.mm.plugin.record.ui.a.b bVar, Context context, String str, String str2) {
        intent.putExtra("key_detail_fav_path", str);
        intent.putExtra("key_detail_fav_thumb_path", str2);
        intent.putExtra("key_detail_fav_video_duration", bVar.fKe.duration);
        intent.putExtra("key_detail_statExtStr", bVar.fKe.fUY);
        com.tencent.mm.bb.d.b(context, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
    }
}
