package com.tencent.mm.plugin.favorite.ui.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.am.a.a;
import com.tencent.mm.am.b;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteTextDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVideoPlayUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVoiceDetailUI;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e {
    private static int[] lMZ = new int[]{R.h.bBe, R.h.bBf, R.h.bBg, R.h.bBh, R.h.bBi};

    public static void b(Context context, j jVar) {
        if (context == null) {
            w.w("MicroMsg.FavItemLogic", "Context is null");
        } else if (jVar == null) {
            w.w("MicroMsg.FavItemLogic", "Fav item is null");
        } else {
            w.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[]{Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_type)});
            Intent intent;
            long j;
            String str;
            Intent intent2;
            switch (jVar.field_type) {
                case -2:
                    Toast.makeText(context, R.l.ejJ, 0).show();
                    return;
                case 1:
                    Intent intent3 = new Intent(context, FavoriteTextDetailUI.class);
                    intent3.putExtra("key_detail_text", jVar.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", jVar.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", jVar.atg());
                    intent3.putExtra("key_detail_time", jVar.field_updateTime);
                    intent3.putExtra("key_detail_create_time", jVar.field_sourceCreateTime <= 0 ? jVar.field_updateTime : jVar.field_sourceCreateTime);
                    context.startActivity(intent3);
                    return;
                case 2:
                    e(context, jVar);
                    return;
                case 3:
                    intent = new Intent(context, FavoriteVoiceDetailUI.class);
                    intent.putExtra("key_detail_info_id", jVar.field_localId);
                    intent.putExtra("key_detail_create_time", jVar.field_favProto.tzl.iam);
                    context.startActivity(intent);
                    return;
                case 4:
                    d(context, jVar);
                    return;
                case 5:
                    d(context, jVar, true);
                    return;
                case 6:
                    rs rsVar = jVar.field_favProto.tyw;
                    String str2 = jVar.field_favProto.iBi;
                    rw rwVar = jVar.field_favProto.tzl;
                    String eK = (rwVar == null || bg.mA(rwVar.tyQ)) ? n.eK(jVar.field_fromUser) : n.eK(rwVar.tyQ);
                    ArrayList arrayList = new ArrayList();
                    if (jVar.field_tagProto.tzx != null) {
                        arrayList.addAll(jVar.field_tagProto.tzx);
                    }
                    c.a(jVar.field_localId, rsVar, eK, str2, arrayList, context);
                    return;
                case 7:
                    String absolutePath;
                    rw rwVar2 = jVar.field_favProto.tzl;
                    rm n = x.n(jVar);
                    File file = new File(x.h(n));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (n.fFs == null) {
                        absolutePath = "";
                    } else {
                        file = new File(x.aty() + g.n(n.fFs.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(((a) h.h(a.class)).a(6, null, n.title, n.desc, n.txp, n.txt, n.txr, n.lKv, x.atA(), absolutePath, "", rwVar2.appId));
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    d.b(context, "music", ".ui.MusicMainUI", intent);
                    return;
                case 8:
                    c(context, jVar, true);
                    return;
                case 10:
                    w.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                    j = jVar.field_localId;
                    str = jVar.field_favProto.tyA.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    d.b(context, "scanner", ".ui.ProductUI", intent2);
                    return;
                case 11:
                    w.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", jVar.field_favProto.tyA.info);
                    d.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                case 15:
                    w.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                    j = jVar.field_localId;
                    str = jVar.field_favProto.tyC.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", str);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    d.b(context, "shake", ".ui.TVInfoUI", intent2);
                    return;
                case 14:
                    a(context, jVar, true);
                    return;
                case 16:
                    rm n2 = x.n(jVar);
                    if (n2 == null || n2.tyi == null || (bg.mA(n2.tyi.hjD) && bg.mA(n2.tyi.hjH))) {
                        d(context, jVar);
                        return;
                    }
                    w.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    c(context, jVar);
                    return;
                case 17:
                    String str3 = x.n(jVar).desc;
                    ap.yY();
                    au.a Av = com.tencent.mm.u.c.wT().Av(str3);
                    if (Av != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("Contact_User", Av.rUK);
                        intent4.putExtra("Contact_Alias", Av.gtR);
                        intent4.putExtra("Contact_Nick", Av.fFa);
                        intent4.putExtra("Contact_QuanPin", Av.hCf);
                        intent4.putExtra("Contact_PyInitial", Av.hCe);
                        intent4.putExtra("Contact_Uin", Av.ovb);
                        intent4.putExtra("Contact_Mobile_MD5", Av.uJX);
                        intent4.putExtra("Contact_full_Mobile_MD5", Av.uJY);
                        intent4.putExtra("Contact_QQNick", Av.bMH());
                        intent4.putExtra("User_From_Fmessage", false);
                        intent4.putExtra("Contact_Scene", Av.scene);
                        intent4.putExtra("Contact_FMessageCard", true);
                        intent4.putExtra("Contact_RemarkName", Av.hCj);
                        intent4.putExtra("Contact_VUser_Info_Flag", Av.rWg);
                        intent4.putExtra("Contact_VUser_Info", Av.gkG);
                        intent4.putExtra("Contact_BrandIconURL", Av.osT);
                        intent4.putExtra("Contact_Province", Av.getProvince());
                        intent4.putExtra("Contact_City", Av.getCity());
                        intent4.putExtra("Contact_Sex", Av.gkr);
                        intent4.putExtra("Contact_Signature", Av.signature);
                        intent4.putExtra("Contact_ShowUserName", false);
                        intent4.putExtra("Contact_KSnsIFlag", 0);
                        d.b(context, "profile", ".ui.ContactInfoUI", intent4);
                        com.tencent.mm.bc.a.xU(Av.scene);
                        return;
                    }
                    return;
                case 18:
                    b(context, jVar, true);
                    return;
                default:
                    w.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[]{Integer.valueOf(jVar.field_type)});
                    return;
            }
        }
    }

    public static void a(Context context, j jVar, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("key_detail_info_id", jVar.field_localId);
        intent.putExtra("show_share", z);
        d.b(context, "record", ".ui.FavRecordDetailUI", intent);
    }

    public static boolean l(rm rmVar) {
        anf HL = b.HL();
        return HL != null && HL.tRH == 6 && bg.ap(rmVar.lKv, "").equals(HL.tqY) && b.HJ();
    }

    public static void b(Context context, j jVar, boolean z) {
        w.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
        com.tencent.mm.sdk.b.b kbVar = new kb();
        kbVar.fQz.type = 3;
        kbVar.fQz.fQv = 2;
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
        kbVar = new ka();
        kbVar.fQo.field_localId = jVar.field_localId;
        kbVar.fQo.fQq = jVar.field_xml;
        kbVar.fQo.context = context;
        kbVar.fQo.type = 2;
        kbVar.fQo.fQy = z;
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }

    public static void c(Context context, j jVar, boolean z) {
        rm n = x.n(jVar);
        if (x.d(n)) {
            if (x.e(n)) {
                e(context, jVar);
                return;
            } else if (!com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) context, x.g(n), n.txx, 2)) {
                return;
            }
        }
        Intent intent = new Intent(context, FavoriteFileDetailUI.class);
        intent.putExtra("key_detail_info_id", jVar.field_localId);
        intent.putExtra("show_share", z);
        context.startActivity(intent);
    }

    private static String A(j jVar) {
        if (jVar.field_favProto == null) {
            return null;
        }
        if (jVar.field_favProto.tyy != null && !bg.mA(jVar.field_favProto.tyy.canvasPageXml)) {
            return jVar.field_favProto.tyy.thumbUrl;
        }
        List list = jVar.field_favProto.tzn;
        if (list == null || list.size() != 1) {
            return null;
        }
        return ((rm) list.get(0)).hhy;
    }

    public static void d(Context context, j jVar, boolean z) {
        String str;
        rw rwVar;
        String str2;
        String str3;
        sf sfVar;
        rm n;
        Intent intent;
        String str4;
        Bundle bundle;
        Bundle bundle2;
        String str5;
        String str6;
        Intent intent2;
        if (jVar.field_favProto != null) {
            if (jVar.field_favProto.tyy == null || bg.mA(jVar.field_favProto.tyy.canvasPageXml)) {
                List list = jVar.field_favProto.tzn;
                if (list != null && list.size() == 1) {
                    str = ((rm) list.get(0)).canvasPageXml;
                    if (bg.mA(str)) {
                        rwVar = jVar.field_favProto.tzl;
                        str = "";
                        str2 = "";
                        str3 = "";
                        if (jVar.field_favProto.tyy != null) {
                            sfVar = jVar.field_favProto.tyy;
                            str = sfVar.tzN;
                            str2 = sfVar.title;
                            str3 = sfVar.desc;
                        }
                        if (rwVar != null && bg.mA(r0)) {
                            str = rwVar.hSX;
                        }
                        if (bg.mA(str)) {
                            n = x.n(jVar);
                            if (n != null) {
                                if (bg.mA(str2)) {
                                    str2 = n.title;
                                }
                                if (bg.mA(str3)) {
                                    str3 = str2;
                                    str2 = n.desc;
                                    w.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", str);
                                    intent.putExtra("showShare", z);
                                    intent.putExtra("is_favorite_item", true);
                                    intent.putExtra("fav_local_id", jVar.field_localId);
                                    str4 = "favorite_control_argument";
                                    bundle = new Bundle();
                                    bundle.putBoolean("key_ctrl_flag_open_chat", jVar.atg());
                                    bundle.putBoolean("key_ctrl_flag_open_sns", jVar.ath());
                                    bundle.putBoolean("key_ctrl_flag_open_weibo", (jVar.field_favProto.tyH & 4) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_cplink", (jVar.field_favProto.tyH & 8) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_browser", (jVar.field_favProto.tyH & 16) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (jVar.field_favProto.tyH & 32) == 0);
                                    bundle.putBoolean("key_ctrl_flag_open_facebook", (jVar.field_favProto.tyH & 64) == 0);
                                    w.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                                    intent.putExtra(str4, bundle);
                                    intent.putExtra("sentUsername", jVar.field_fromUser);
                                    if (!(rwVar == null || bg.mA(rwVar.fCJ))) {
                                        intent.putExtra("srcDisplayname", n.eK(rwVar.fCJ));
                                    }
                                    intent.putExtra("mode", 1);
                                    intent.putExtra("geta8key_scene", 14);
                                    bundle2 = new Bundle();
                                    bundle2.putString("key_snsad_statextstr", x.n(jVar).fUY);
                                    intent.putExtra("jsapiargs", bundle2);
                                    intent.putExtra("from_scence", 4);
                                    str5 = "fav_" + m.xL() + "_" + jVar.field_id;
                                    intent.putExtra("KPublisherId", str5);
                                    intent.putExtra("pre_username", jVar.field_fromUser);
                                    intent.putExtra("prePublishId", str5);
                                    intent.putExtra("preUsername", jVar.field_fromUser);
                                    intent.putExtra("share_report_pre_msg_url", str);
                                    intent.putExtra("share_report_pre_msg_title", str3);
                                    intent.putExtra("share_report_pre_msg_desc", str2);
                                    intent.putExtra("share_report_pre_msg_icon_url", A(jVar));
                                    intent.putExtra("share_report_pre_msg_appid", "");
                                    intent.putExtra("share_report_from_scene", 4);
                                    c.j(intent, context);
                                }
                            }
                            str6 = str3;
                            str3 = str2;
                            str2 = str6;
                            w.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                            intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", jVar.field_localId);
                            str4 = "favorite_control_argument";
                            bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", jVar.atg());
                            bundle.putBoolean("key_ctrl_flag_open_sns", jVar.ath());
                            if ((jVar.field_favProto.tyH & 4) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (jVar.field_favProto.tyH & 4) == 0);
                            if ((jVar.field_favProto.tyH & 8) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (jVar.field_favProto.tyH & 8) == 0);
                            if ((jVar.field_favProto.tyH & 16) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_browser", (jVar.field_favProto.tyH & 16) == 0);
                            if ((jVar.field_favProto.tyH & 32) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (jVar.field_favProto.tyH & 32) == 0);
                            if ((jVar.field_favProto.tyH & 64) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (jVar.field_favProto.tyH & 64) == 0);
                            w.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", jVar.field_fromUser);
                            intent.putExtra("srcDisplayname", n.eK(rwVar.fCJ));
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", x.n(jVar).fUY);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            str5 = "fav_" + m.xL() + "_" + jVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", jVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", jVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str3);
                            intent.putExtra("share_report_pre_msg_desc", str2);
                            intent.putExtra("share_report_pre_msg_icon_url", A(jVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            c.j(intent, context);
                        }
                    }
                    intent2 = new Intent();
                    intent2.putExtra("sns_landing_pages_xml", str);
                    intent2.putExtra("sns_landig_pages_from_source", 7);
                    intent2.putExtra("sns_landing_pages_share_thumb_url", A(jVar));
                    intent2.putExtra("sns_landing_favid", m.xL() + "_" + jVar.field_id);
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                    return;
                }
            }
            str = jVar.field_favProto.tyy.canvasPageXml;
            if (bg.mA(str)) {
                rwVar = jVar.field_favProto.tzl;
                str = "";
                str2 = "";
                str3 = "";
                if (jVar.field_favProto.tyy != null) {
                    sfVar = jVar.field_favProto.tyy;
                    str = sfVar.tzN;
                    str2 = sfVar.title;
                    str3 = sfVar.desc;
                }
                str = rwVar.hSX;
                if (bg.mA(str)) {
                    n = x.n(jVar);
                    if (n != null) {
                        if (bg.mA(str2)) {
                            str2 = n.title;
                        }
                        if (bg.mA(str3)) {
                            str3 = str2;
                            str2 = n.desc;
                            w.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                            intent = new Intent();
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("showShare", z);
                            intent.putExtra("is_favorite_item", true);
                            intent.putExtra("fav_local_id", jVar.field_localId);
                            str4 = "favorite_control_argument";
                            bundle = new Bundle();
                            bundle.putBoolean("key_ctrl_flag_open_chat", jVar.atg());
                            bundle.putBoolean("key_ctrl_flag_open_sns", jVar.ath());
                            if ((jVar.field_favProto.tyH & 4) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weibo", (jVar.field_favProto.tyH & 4) == 0);
                            if ((jVar.field_favProto.tyH & 8) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_cplink", (jVar.field_favProto.tyH & 8) == 0);
                            if ((jVar.field_favProto.tyH & 16) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_browser", (jVar.field_favProto.tyH & 16) == 0);
                            if ((jVar.field_favProto.tyH & 32) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_weiyun", (jVar.field_favProto.tyH & 32) == 0);
                            if ((jVar.field_favProto.tyH & 64) == 0) {
                            }
                            bundle.putBoolean("key_ctrl_flag_open_facebook", (jVar.field_favProto.tyH & 64) == 0);
                            w.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                            intent.putExtra(str4, bundle);
                            intent.putExtra("sentUsername", jVar.field_fromUser);
                            intent.putExtra("srcDisplayname", n.eK(rwVar.fCJ));
                            intent.putExtra("mode", 1);
                            intent.putExtra("geta8key_scene", 14);
                            bundle2 = new Bundle();
                            bundle2.putString("key_snsad_statextstr", x.n(jVar).fUY);
                            intent.putExtra("jsapiargs", bundle2);
                            intent.putExtra("from_scence", 4);
                            str5 = "fav_" + m.xL() + "_" + jVar.field_id;
                            intent.putExtra("KPublisherId", str5);
                            intent.putExtra("pre_username", jVar.field_fromUser);
                            intent.putExtra("prePublishId", str5);
                            intent.putExtra("preUsername", jVar.field_fromUser);
                            intent.putExtra("share_report_pre_msg_url", str);
                            intent.putExtra("share_report_pre_msg_title", str3);
                            intent.putExtra("share_report_pre_msg_desc", str2);
                            intent.putExtra("share_report_pre_msg_icon_url", A(jVar));
                            intent.putExtra("share_report_pre_msg_appid", "");
                            intent.putExtra("share_report_from_scene", 4);
                            c.j(intent, context);
                        }
                    }
                    str6 = str3;
                    str3 = str2;
                    str2 = str6;
                    w.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", z);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", jVar.field_localId);
                    str4 = "favorite_control_argument";
                    bundle = new Bundle();
                    bundle.putBoolean("key_ctrl_flag_open_chat", jVar.atg());
                    bundle.putBoolean("key_ctrl_flag_open_sns", jVar.ath());
                    if ((jVar.field_favProto.tyH & 4) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weibo", (jVar.field_favProto.tyH & 4) == 0);
                    if ((jVar.field_favProto.tyH & 8) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_cplink", (jVar.field_favProto.tyH & 8) == 0);
                    if ((jVar.field_favProto.tyH & 16) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_browser", (jVar.field_favProto.tyH & 16) == 0);
                    if ((jVar.field_favProto.tyH & 32) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (jVar.field_favProto.tyH & 32) == 0);
                    if ((jVar.field_favProto.tyH & 64) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_facebook", (jVar.field_favProto.tyH & 64) == 0);
                    w.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                    intent.putExtra(str4, bundle);
                    intent.putExtra("sentUsername", jVar.field_fromUser);
                    intent.putExtra("srcDisplayname", n.eK(rwVar.fCJ));
                    intent.putExtra("mode", 1);
                    intent.putExtra("geta8key_scene", 14);
                    bundle2 = new Bundle();
                    bundle2.putString("key_snsad_statextstr", x.n(jVar).fUY);
                    intent.putExtra("jsapiargs", bundle2);
                    intent.putExtra("from_scence", 4);
                    str5 = "fav_" + m.xL() + "_" + jVar.field_id;
                    intent.putExtra("KPublisherId", str5);
                    intent.putExtra("pre_username", jVar.field_fromUser);
                    intent.putExtra("prePublishId", str5);
                    intent.putExtra("preUsername", jVar.field_fromUser);
                    intent.putExtra("share_report_pre_msg_url", str);
                    intent.putExtra("share_report_pre_msg_title", str3);
                    intent.putExtra("share_report_pre_msg_desc", str2);
                    intent.putExtra("share_report_pre_msg_icon_url", A(jVar));
                    intent.putExtra("share_report_pre_msg_appid", "");
                    intent.putExtra("share_report_from_scene", 4);
                    c.j(intent, context);
                }
            }
            intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_xml", str);
            intent2.putExtra("sns_landig_pages_from_source", 7);
            intent2.putExtra("sns_landing_pages_share_thumb_url", A(jVar));
            intent2.putExtra("sns_landing_favid", m.xL() + "_" + jVar.field_id);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
            return;
        }
        str = null;
        if (bg.mA(str)) {
            intent2 = new Intent();
            intent2.putExtra("sns_landing_pages_xml", str);
            intent2.putExtra("sns_landig_pages_from_source", 7);
            intent2.putExtra("sns_landing_pages_share_thumb_url", A(jVar));
            intent2.putExtra("sns_landing_favid", m.xL() + "_" + jVar.field_id);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
            return;
        }
        rwVar = jVar.field_favProto.tzl;
        str = "";
        str2 = "";
        str3 = "";
        if (jVar.field_favProto.tyy != null) {
            sfVar = jVar.field_favProto.tyy;
            str = sfVar.tzN;
            str2 = sfVar.title;
            str3 = sfVar.desc;
        }
        str = rwVar.hSX;
        if (bg.mA(str)) {
            n = x.n(jVar);
            if (n != null) {
                if (bg.mA(str2)) {
                    str2 = n.title;
                }
                if (bg.mA(str3)) {
                    str3 = str2;
                    str2 = n.desc;
                    w.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", z);
                    intent.putExtra("is_favorite_item", true);
                    intent.putExtra("fav_local_id", jVar.field_localId);
                    str4 = "favorite_control_argument";
                    bundle = new Bundle();
                    bundle.putBoolean("key_ctrl_flag_open_chat", jVar.atg());
                    bundle.putBoolean("key_ctrl_flag_open_sns", jVar.ath());
                    if ((jVar.field_favProto.tyH & 4) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weibo", (jVar.field_favProto.tyH & 4) == 0);
                    if ((jVar.field_favProto.tyH & 8) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_cplink", (jVar.field_favProto.tyH & 8) == 0);
                    if ((jVar.field_favProto.tyH & 16) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_browser", (jVar.field_favProto.tyH & 16) == 0);
                    if ((jVar.field_favProto.tyH & 32) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_weiyun", (jVar.field_favProto.tyH & 32) == 0);
                    if ((jVar.field_favProto.tyH & 64) == 0) {
                    }
                    bundle.putBoolean("key_ctrl_flag_open_facebook", (jVar.field_favProto.tyH & 64) == 0);
                    w.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                    intent.putExtra(str4, bundle);
                    intent.putExtra("sentUsername", jVar.field_fromUser);
                    intent.putExtra("srcDisplayname", n.eK(rwVar.fCJ));
                    intent.putExtra("mode", 1);
                    intent.putExtra("geta8key_scene", 14);
                    bundle2 = new Bundle();
                    bundle2.putString("key_snsad_statextstr", x.n(jVar).fUY);
                    intent.putExtra("jsapiargs", bundle2);
                    intent.putExtra("from_scence", 4);
                    str5 = "fav_" + m.xL() + "_" + jVar.field_id;
                    intent.putExtra("KPublisherId", str5);
                    intent.putExtra("pre_username", jVar.field_fromUser);
                    intent.putExtra("prePublishId", str5);
                    intent.putExtra("preUsername", jVar.field_fromUser);
                    intent.putExtra("share_report_pre_msg_url", str);
                    intent.putExtra("share_report_pre_msg_title", str3);
                    intent.putExtra("share_report_pre_msg_desc", str2);
                    intent.putExtra("share_report_pre_msg_icon_url", A(jVar));
                    intent.putExtra("share_report_pre_msg_appid", "");
                    intent.putExtra("share_report_from_scene", 4);
                    c.j(intent, context);
                }
            }
            str6 = str3;
            str3 = str2;
            str2 = str6;
            w.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", z);
            intent.putExtra("is_favorite_item", true);
            intent.putExtra("fav_local_id", jVar.field_localId);
            str4 = "favorite_control_argument";
            bundle = new Bundle();
            bundle.putBoolean("key_ctrl_flag_open_chat", jVar.atg());
            bundle.putBoolean("key_ctrl_flag_open_sns", jVar.ath());
            if ((jVar.field_favProto.tyH & 4) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_weibo", (jVar.field_favProto.tyH & 4) == 0);
            if ((jVar.field_favProto.tyH & 8) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_cplink", (jVar.field_favProto.tyH & 8) == 0);
            if ((jVar.field_favProto.tyH & 16) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_browser", (jVar.field_favProto.tyH & 16) == 0);
            if ((jVar.field_favProto.tyH & 32) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_weiyun", (jVar.field_favProto.tyH & 32) == 0);
            if ((jVar.field_favProto.tyH & 64) == 0) {
            }
            bundle.putBoolean("key_ctrl_flag_open_facebook", (jVar.field_favProto.tyH & 64) == 0);
            w.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
            intent.putExtra(str4, bundle);
            intent.putExtra("sentUsername", jVar.field_fromUser);
            intent.putExtra("srcDisplayname", n.eK(rwVar.fCJ));
            intent.putExtra("mode", 1);
            intent.putExtra("geta8key_scene", 14);
            bundle2 = new Bundle();
            bundle2.putString("key_snsad_statextstr", x.n(jVar).fUY);
            intent.putExtra("jsapiargs", bundle2);
            intent.putExtra("from_scence", 4);
            str5 = "fav_" + m.xL() + "_" + jVar.field_id;
            intent.putExtra("KPublisherId", str5);
            intent.putExtra("pre_username", jVar.field_fromUser);
            intent.putExtra("prePublishId", str5);
            intent.putExtra("preUsername", jVar.field_fromUser);
            intent.putExtra("share_report_pre_msg_url", str);
            intent.putExtra("share_report_pre_msg_title", str3);
            intent.putExtra("share_report_pre_msg_desc", str2);
            intent.putExtra("share_report_pre_msg_icon_url", A(jVar));
            intent.putExtra("share_report_pre_msg_appid", "");
            intent.putExtra("share_report_from_scene", 4);
            c.j(intent, context);
        }
    }

    private static void c(Context context, j jVar) {
        v.a(v.a.PlayIcon, jVar);
        Intent intent = new Intent(context, FavoriteSightDetailUI.class);
        intent.putExtra("key_detail_info_id", jVar.field_localId);
        context.startActivity(intent);
    }

    private static void d(Context context, j jVar) {
        boolean z;
        rm n = x.n(jVar);
        rp rpVar = n.tyi;
        if (rpVar == null || bg.mA(rpVar.hjD)) {
            z = false;
        } else {
            v.a(v.a.EnterCompleteVideo, jVar);
            String h = x.h(n);
            Intent intent = new Intent();
            intent.putExtra("IsAd", false);
            intent.putExtra("KStremVideoUrl", rpVar.hjD);
            intent.putExtra("StreamWording", rpVar.hjG);
            intent.putExtra("StremWebUrl", rpVar.hjH);
            intent.putExtra("KThumUrl", rpVar.hjI);
            intent.putExtra("KSta_StremVideoAduxInfo", rpVar.hjJ);
            intent.putExtra("KSta_StremVideoPublishId", rpVar.hjK);
            intent.putExtra("KSta_SourceType", 2);
            intent.putExtra("KSta_Scene", v.b.Fav.value);
            intent.putExtra("KSta_FromUserName", jVar.field_fromUser);
            intent.putExtra("KSta_FavID", jVar.field_id);
            intent.putExtra("KSta_SnsStatExtStr", n.fUY);
            intent.putExtra("KBlockFav", true);
            intent.putExtra("KMediaId", "fakeid_" + jVar.field_id);
            intent.putExtra("KThumbPath", h);
            intent.putExtra("KMediaVideoTime", rpVar.tyZ);
            intent.putExtra("KMediaTitle", rpVar.hjF);
            d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
            z = true;
        }
        if (!z) {
            if (bg.mA(n.txz) || n.txD <= 0) {
                w.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[]{n.txz, Long.valueOf(n.txD)});
                String str = x.n(jVar).txp;
                if (bg.mA(str)) {
                    str = x.n(jVar).txt;
                }
                if (bg.mA(str)) {
                    w.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                    c(context, jVar);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("is_favorite_item", true);
                intent2.putExtra("fav_local_id", jVar.field_localId);
                intent2.putExtra("geta8key_scene", 14);
                w.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId)});
                c.j(intent2, context);
                return;
            }
            Intent intent3 = new Intent(context, FavoriteSightDetailUI.class);
            intent3.putExtra("key_detail_info_id", jVar.field_localId);
            context.startActivity(intent3);
        }
    }

    public static void e(Context context, j jVar) {
        Intent intent = new Intent(context, FavoriteImgDetailUI.class);
        intent.putExtra("key_detail_info_id", jVar.field_localId);
        context.startActivity(intent);
    }

    public static String[] a(final j jVar, ae aeVar) {
        String str = null;
        if (jVar == null) {
            w.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            return null;
        }
        final rm n = x.n(jVar);
        String[] strArr = new String[2];
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                x.b(jVar, n, true);
            }
        };
        ru ruVar;
        switch (jVar.field_type) {
            case 5:
                sf sfVar = jVar.field_favProto.tyy;
                if (n == null) {
                    if (sfVar != null) {
                        strArr[1] = sfVar.thumbUrl;
                        break;
                    }
                }
                String str2 = sfVar == null ? null : sfVar.thumbUrl;
                if (bg.mA(str2)) {
                    str2 = n.fFs;
                }
                strArr[0] = x.h(n);
                strArr[1] = str2;
                aeVar.post(anonymousClass1);
                break;
                break;
            case 10:
                ruVar = jVar.field_favProto.tyA;
                if (ruVar != null) {
                    strArr[1] = ruVar.thumbUrl;
                    break;
                }
                break;
            case 11:
                ruVar = jVar.field_favProto.tyA;
                if (ruVar != null) {
                    strArr[1] = ruVar.thumbUrl;
                    break;
                }
                break;
            case 14:
            case 18:
                if (jVar.field_favProto.tzn != null) {
                    Iterator it = jVar.field_favProto.tzn.iterator();
                    while (it.hasNext()) {
                        rm rmVar = (rm) it.next();
                        if (rmVar.aMw == 2) {
                            str = x.g(rmVar);
                            aeVar.post(anonymousClass1);
                        } else if (rmVar.aMw == 15) {
                            str = x.h(rmVar);
                            aeVar.post(anonymousClass1);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = n.fFs;
                break;
            case 15:
                rz rzVar = jVar.field_favProto.tyC;
                if (rzVar != null) {
                    strArr[1] = rzVar.thumbUrl;
                    break;
                }
                break;
            default:
                if (n != null) {
                    strArr[0] = x.h(n);
                    strArr[1] = n.fFs;
                    aeVar.post(anonymousClass1);
                    break;
                }
                break;
        }
        w.d("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[]{strArr[0], strArr[1], Integer.valueOf(jVar.field_type)});
        return strArr;
    }

    public static void a(com.tencent.mm.pluginsdk.ui.applet.d.a aVar, final Context context, final j jVar) {
        String str = null;
        if (jVar == null || context == null) {
            w.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        String absolutePath;
        sf sfVar;
        rm n = x.n(jVar);
        if (jVar == null) {
            w.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
        } else {
            rm n2 = x.n(jVar);
            File file;
            if (5 == jVar.field_type) {
                file = new File(x.h(n2));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else {
                    sf sfVar2 = jVar.field_favProto.tyy;
                    absolutePath = sfVar2 == null ? null : sfVar2.thumbUrl;
                    if (bg.mA(absolutePath)) {
                        absolutePath = n2.fFs;
                    }
                    absolutePath = x.vX(absolutePath);
                    if (bg.mA(absolutePath)) {
                        absolutePath = Integer.valueOf(R.k.dtu);
                    }
                }
            } else {
                if (11 == jVar.field_type || 10 == jVar.field_type) {
                    ru ruVar = jVar.field_favProto.tyA;
                    if (ruVar != null) {
                        absolutePath = x.vX(ruVar.thumbUrl);
                        if (bg.mA(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.dto);
                        }
                    }
                }
                if (15 == jVar.field_type || 12 == jVar.field_type) {
                    rz rzVar = jVar.field_favProto.tyC;
                    if (rzVar != null) {
                        absolutePath = x.vX(rzVar.thumbUrl);
                        if (bg.mA(absolutePath)) {
                            absolutePath = Integer.valueOf(R.k.dto);
                        }
                    }
                }
                if (2 == jVar.field_type || 7 == jVar.field_type || 16 == jVar.field_type || 4 == jVar.field_type) {
                    file = new File(x.h(n2));
                    if (!file.exists()) {
                        absolutePath = x.vX(n2.fFs);
                        if (bg.mA(absolutePath)) {
                            x.b(jVar, n2, true);
                            absolutePath = x.h(n2);
                        }
                        if (bg.mA(absolutePath)) {
                            switch (jVar.field_type) {
                                case 2:
                                    absolutePath = Integer.valueOf(R.g.bbY);
                                    break;
                                case 7:
                                    absolutePath = Integer.valueOf(R.k.dtg);
                                    break;
                                default:
                                    absolutePath = Integer.valueOf(R.k.dtr);
                                    break;
                            }
                        }
                    }
                    absolutePath = file.getAbsolutePath();
                } else if (!(3 == jVar.field_type || 6 == jVar.field_type)) {
                    if (8 == jVar.field_type) {
                        absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.LC(n2.txx));
                    } else if (17 == jVar.field_type) {
                        ap.yY();
                        r2 = com.tencent.mm.u.c.wT().Av(n2.desc);
                        absolutePath = (r2.rUK == null || r2.rUK.length() == 0) ? Integer.valueOf(R.g.bes) : new SpannableString(r2.rUK);
                    } else if (14 == jVar.field_type && jVar.field_favProto.tzn != null) {
                        Iterator it = jVar.field_favProto.tzn.iterator();
                        while (it.hasNext()) {
                            rm rmVar = (rm) it.next();
                            if (rmVar.aMw != 1) {
                                if (rmVar.aMw == 3) {
                                    absolutePath = Integer.valueOf(R.k.dtt);
                                    break;
                                } else if (rmVar.aMw == 6) {
                                    absolutePath = Integer.valueOf(R.k.dtf);
                                    break;
                                } else if (rmVar.aMw == 8) {
                                    absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.LC(rmVar.txx));
                                    break;
                                } else if (rmVar.aMw == 2 || rmVar.aMw == 7 || rmVar.aMw == 15 || rmVar.aMw == 4) {
                                    file = new File(x.h(rmVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        r2 = x.vX(rmVar.fFs);
                                        if (bg.mA(r2)) {
                                            switch (rmVar.aMw) {
                                                case 2:
                                                    absolutePath = Integer.valueOf(R.g.bbY);
                                                    break;
                                                case 7:
                                                    absolutePath = Integer.valueOf(R.k.dtg);
                                                    break;
                                                default:
                                                    absolutePath = Integer.valueOf(R.k.dtr);
                                                    break;
                                            }
                                        }
                                        absolutePath = r2;
                                    }
                                } else if (rmVar.aMw == 5) {
                                    file = new File(x.h(rmVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        sfVar = rmVar.tyc.tyy;
                                        r2 = sfVar == null ? null : sfVar.thumbUrl;
                                        if (bg.mA(r2)) {
                                            r2 = rmVar.fFs;
                                        }
                                        absolutePath = x.vX(r2);
                                        if (bg.mA(absolutePath)) {
                                            absolutePath = Integer.valueOf(R.k.dtu);
                                        }
                                    }
                                } else {
                                    if (rmVar.aMw == 10 || rmVar.aMw == 11) {
                                        ru ruVar2 = rmVar.tyc.tyA;
                                        if (ruVar2 != null) {
                                            absolutePath = x.vX(ruVar2.thumbUrl);
                                            if (bg.mA(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.dto);
                                            }
                                        }
                                    }
                                    if (rmVar.aMw == 12 || rmVar.aMw == 14) {
                                        rz rzVar2 = rmVar.tyc.tyC;
                                        if (rzVar2 != null) {
                                            absolutePath = x.vX(rzVar2.thumbUrl);
                                            if (bg.mA(absolutePath)) {
                                                absolutePath = Integer.valueOf(R.k.dto);
                                            }
                                        }
                                    }
                                    if (rmVar.aMw == 16) {
                                        ap.yY();
                                        r2 = com.tencent.mm.u.c.wT().Av(rmVar.desc);
                                        absolutePath = (r2.rUK == null || r2.rUK.length() == 0) ? Integer.valueOf(R.g.bes) : new SpannableString(r2.rUK);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (absolutePath instanceof String) {
                if (absolutePath instanceof Integer) {
                    ((Integer) absolutePath).intValue();
                }
                absolutePath = null;
            } else {
                absolutePath = absolutePath;
            }
            sfVar = jVar.field_favProto.tyy;
            switch (jVar.field_type) {
                case 1:
                    aVar.MP(jVar.field_favProto.desc);
                    aVar.bEU();
                    aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                        public final void auI() {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", jVar.field_favProto.desc);
                            d.a(context, ".ui.transmit.RetransmitPreviewUI", intent);
                            com.tencent.mm.ui.base.b.eM(context);
                        }
                    });
                    return;
                case 2:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.Pg(absolutePath), 3);
                    return;
                case 4:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.Pg(absolutePath), 2);
                    return;
                case 5:
                    if (sfVar != null || bg.mA(sfVar.title)) {
                        absolutePath = null;
                    } else {
                        absolutePath = sfVar.title;
                        str = sfVar.desc;
                    }
                    if (bg.mA(absolutePath)) {
                        absolutePath = n.title;
                    }
                    if (bg.mA(str)) {
                        str = n.desc;
                    }
                    aVar.MP(new StringBuffer(context.getResources().getString(R.l.dIU)).append(absolutePath).toString());
                    return;
                case 6:
                    aVar.MP(context.getString(R.l.dHB) + jVar.field_favProto.tyw.label);
                    return;
                case 7:
                    if (!(sfVar == null || bg.mA(sfVar.title))) {
                        str = sfVar.title;
                    }
                    if (bg.mA(str)) {
                        str = n.title;
                    }
                    aVar.MP(new StringBuffer(context.getResources().getString(R.l.dHI)).append(str).toString());
                    return;
                case 8:
                    absolutePath = jVar.field_favProto.title;
                    if (bg.mA(absolutePath)) {
                        absolutePath = n.title;
                    }
                    aVar.MP(new StringBuffer(context.getResources().getString(R.l.dHn)).append(absolutePath).toString());
                    return;
                case 14:
                    aVar.MP(new StringBuffer(context.getResources().getString(R.l.dIr)).append(r.a.a(context, jVar).title).toString());
                    return;
                case 16:
                    aVar.a(com.tencent.mm.sdk.platformtools.d.Pg(absolutePath), 2);
                    return;
                case 18:
                    aVar.MP(new StringBuffer(context.getResources().getString(R.l.dHS)).append(r.a.a(context, jVar).desc.replaceAll("\n", " ")).toString());
                    return;
                default:
                    if (!(sfVar == null || bg.mA(sfVar.title))) {
                        str = sfVar.title;
                    }
                    if (bg.mA(str)) {
                        str = n.title;
                    }
                    aVar.MP(new StringBuffer(context.getResources().getString(R.l.dDm)).append(str).toString());
                    return;
            }
        }
        absolutePath = null;
        if (absolutePath instanceof String) {
            if (absolutePath instanceof Integer) {
                ((Integer) absolutePath).intValue();
            }
            absolutePath = null;
        } else {
            absolutePath = absolutePath;
        }
        sfVar = jVar.field_favProto.tyy;
        switch (jVar.field_type) {
            case 1:
                aVar.MP(jVar.field_favProto.desc);
                aVar.bEU();
                aVar.a(/* anonymous class already generated */);
                return;
            case 2:
                aVar.a(com.tencent.mm.sdk.platformtools.d.Pg(absolutePath), 3);
                return;
            case 4:
                aVar.a(com.tencent.mm.sdk.platformtools.d.Pg(absolutePath), 2);
                return;
            case 5:
                if (sfVar != null) {
                    break;
                }
                absolutePath = null;
                if (bg.mA(absolutePath)) {
                    absolutePath = n.title;
                }
                if (bg.mA(str)) {
                    str = n.desc;
                }
                aVar.MP(new StringBuffer(context.getResources().getString(R.l.dIU)).append(absolutePath).toString());
                return;
            case 6:
                aVar.MP(context.getString(R.l.dHB) + jVar.field_favProto.tyw.label);
                return;
            case 7:
                str = sfVar.title;
                if (bg.mA(str)) {
                    str = n.title;
                }
                aVar.MP(new StringBuffer(context.getResources().getString(R.l.dHI)).append(str).toString());
                return;
            case 8:
                absolutePath = jVar.field_favProto.title;
                if (bg.mA(absolutePath)) {
                    absolutePath = n.title;
                }
                aVar.MP(new StringBuffer(context.getResources().getString(R.l.dHn)).append(absolutePath).toString());
                return;
            case 14:
                aVar.MP(new StringBuffer(context.getResources().getString(R.l.dIr)).append(r.a.a(context, jVar).title).toString());
                return;
            case 16:
                aVar.a(com.tencent.mm.sdk.platformtools.d.Pg(absolutePath), 2);
                return;
            case 18:
                aVar.MP(new StringBuffer(context.getResources().getString(R.l.dHS)).append(r.a.a(context, jVar).desc.replaceAll("\n", " ")).toString());
                return;
            default:
                str = sfVar.title;
                if (bg.mA(str)) {
                    str = n.title;
                }
                aVar.MP(new StringBuffer(context.getResources().getString(R.l.dDm)).append(str).toString());
                return;
        }
    }

    public static void b(com.tencent.mm.pluginsdk.ui.applet.d.a aVar, final Context context, final j jVar) {
        if (jVar == null || context == null) {
            w.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        final rm n = x.n(jVar);
        switch (jVar.field_type) {
            case 1:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", jVar.field_favProto.desc);
                        d.a(context, ".ui.transmit.RetransmitPreviewUI", intent);
                        com.tencent.mm.ui.base.b.eM(context);
                    }
                });
                return;
            case 2:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        Intent intent = new Intent(context, FavImgGalleryUI.class);
                        intent.putExtra("key_detail_info_id", jVar.field_localId);
                        intent.putExtra("key_detail_data_id", n.lKv);
                        intent.putExtra("show_share", false);
                        context.startActivity(intent);
                    }
                });
                return;
            case 4:
            case 16:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        rm n = x.n(jVar);
                        if (n == null) {
                            w.e("MicroMsg.FavItemLogic", "goPlayView, but dataitem is null , exit");
                        } else if (n.tyi == null || (bg.mA(n.tyi.hjD) && bg.mA(n.tyi.hjH))) {
                            r1 = new Intent(context, FavoriteVideoPlayUI.class);
                            r1.putExtra("key_detail_fav_path", x.g(n));
                            r1.putExtra("key_detail_fav_thumb_path", x.h(n));
                            r1.putExtra("key_detail_fav_video_duration", n.duration);
                            r1.putExtra("key_detail_statExtStr", n.fUY);
                            r1.putExtra("show_share", false);
                            context.startActivity(r1);
                        } else {
                            w.i("MicroMsg.FavItemLogic", "it is ad sight.use sight play");
                            r1 = new Intent(context, FavoriteFileDetailUI.class);
                            r1.putExtra("key_detail_info_id", jVar.field_localId);
                            r1.putExtra("key_detail_data_id", n.lKv);
                            r1.putExtra("key_detail_can_delete", false);
                            context.startActivity(r1);
                        }
                    }
                });
                return;
            case 5:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        e.d(context, jVar, false);
                    }
                });
                return;
            case 6:
                final rs rsVar = jVar.field_favProto.tyw;
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        Intent intent = new Intent();
                        intent.putExtra("map_view_type", 1);
                        intent.putExtra("kwebmap_slat", rsVar.lat);
                        intent.putExtra("kwebmap_lng", rsVar.lng);
                        intent.putExtra("Kwebmap_locaion", rsVar.label);
                        intent.putExtra("kShowshare", false);
                        d.b(context, "location", ".ui.RedirectUI", intent);
                    }
                });
                return;
            case 8:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        e.c(context, jVar, false);
                    }
                });
                return;
            case 14:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        e.a(context, jVar, false);
                    }
                });
                return;
            case 18:
                aVar.a(new com.tencent.mm.ui.base.h.a.a() {
                    public final void auI() {
                        e.b(context, jVar, false);
                    }
                });
                return;
            default:
                return;
        }
    }
}
