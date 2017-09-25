package com.tencent.mm.pluginsdk.model;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.snackbar.b.b;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public static boolean sCd = true;
    private static y<String, Bitmap> sCe = new y(20);
    private static Map<String, Integer> suf;

    static {
        suf = new HashMap();
        Map hashMap = new HashMap();
        suf = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.dtr));
        suf.put("m4v", Integer.valueOf(R.k.dtr));
        suf.put("vob", Integer.valueOf(R.k.dtr));
        suf.put("mpeg", Integer.valueOf(R.k.dtr));
        suf.put("mpe", Integer.valueOf(R.k.dtr));
        suf.put("asx", Integer.valueOf(R.k.dtr));
        suf.put("asf", Integer.valueOf(R.k.dtr));
        suf.put("f4v", Integer.valueOf(R.k.dtr));
        suf.put("flv", Integer.valueOf(R.k.dtr));
        suf.put("mkv", Integer.valueOf(R.k.dtr));
        suf.put("wmv", Integer.valueOf(R.k.dtr));
        suf.put("wm", Integer.valueOf(R.k.dtr));
        suf.put("3gp", Integer.valueOf(R.k.dtr));
        suf.put("mp4", Integer.valueOf(R.k.dtr));
        suf.put("rmvb", Integer.valueOf(R.k.dtr));
        suf.put("rm", Integer.valueOf(R.k.dtr));
        suf.put("ra", Integer.valueOf(R.k.dtr));
        suf.put("ram", Integer.valueOf(R.k.dtr));
        suf.put("mp3pro", Integer.valueOf(R.k.dtg));
        suf.put("vqf", Integer.valueOf(R.k.dtg));
        suf.put("cd", Integer.valueOf(R.k.dtg));
        suf.put("md", Integer.valueOf(R.k.dtg));
        suf.put("mod", Integer.valueOf(R.k.dtg));
        suf.put("vorbis", Integer.valueOf(R.k.dtg));
        suf.put("au", Integer.valueOf(R.k.dtg));
        suf.put("amr", Integer.valueOf(R.k.dtg));
        suf.put("silk", Integer.valueOf(R.k.dtg));
        suf.put("wma", Integer.valueOf(R.k.dtg));
        suf.put("mmf", Integer.valueOf(R.k.dtg));
        suf.put("mid", Integer.valueOf(R.k.dtg));
        suf.put("midi", Integer.valueOf(R.k.dtg));
        suf.put("mp3", Integer.valueOf(R.k.dtg));
        suf.put("aac", Integer.valueOf(R.k.dtg));
        suf.put("ape", Integer.valueOf(R.k.dtg));
        suf.put("aiff", Integer.valueOf(R.k.dtg));
        suf.put("aif", Integer.valueOf(R.k.dtg));
        suf.put("jfif", Integer.valueOf(R.g.bbY));
        suf.put("tiff", Integer.valueOf(R.g.bbY));
        suf.put("tif", Integer.valueOf(R.g.bbY));
        suf.put("jpe", Integer.valueOf(R.g.bbY));
        suf.put("dib", Integer.valueOf(R.g.bbY));
        suf.put("jpeg", Integer.valueOf(R.g.bbY));
        suf.put("jpg", Integer.valueOf(R.g.bbY));
        suf.put("png", Integer.valueOf(R.g.bbY));
        suf.put("bmp", Integer.valueOf(R.g.bbY));
        suf.put("gif", Integer.valueOf(R.g.bbY));
        suf.put("rar", Integer.valueOf(R.k.dwV));
        suf.put("zip", Integer.valueOf(R.k.dwV));
        suf.put("7z", Integer.valueOf(R.k.dwV));
        suf.put("iso", Integer.valueOf(R.k.dwV));
        suf.put("cab", Integer.valueOf(R.k.dwV));
        suf.put("doc", Integer.valueOf(R.k.dwT));
        suf.put("docx", Integer.valueOf(R.k.dwT));
        suf.put("ppt", Integer.valueOf(R.k.dwO));
        suf.put("pptx", Integer.valueOf(R.k.dwO));
        suf.put("xls", Integer.valueOf(R.k.dwU));
        suf.put("xlsx", Integer.valueOf(R.k.dwU));
        suf.put("txt", Integer.valueOf(R.k.dwQ));
        suf.put("rtf", Integer.valueOf(R.k.dwQ));
        suf.put("pdf", Integer.valueOf(R.k.dwN));
        suf.put("unknown", Integer.valueOf(R.k.dwR));
    }

    public static rr a(int i, rv rvVar, sd sdVar) {
        if (rvVar == null) {
            w.w("MicroMsg.FavExportLogic", "proto item is null");
            return null;
        }
        rr rrVar = new rr();
        rw rwVar = rvVar.tzl;
        if (rwVar != null) {
            rrVar.fOu = rwVar.fOu;
            rrVar.tzb = rwVar.tyQ;
            rrVar.appId = rwVar.appId;
            rrVar.fCJ = rwVar.fCJ;
        }
        if (sdVar != null) {
            if (sdVar.tzw != null) {
                rrVar.tzc.addAll(sdVar.tzw);
            }
            if (sdVar.tzx != null) {
                rrVar.tzc.addAll(sdVar.tzx);
            }
        }
        rrVar.fTi = rvVar;
        rrVar.type = i;
        switch (i) {
            case 1:
                rrVar.title = "";
                rrVar.desc = rvVar.desc;
                return rrVar;
            case 2:
                if (rvVar.tzn != null && rvVar.tzn.size() > 0) {
                    rrVar.title = ((rm) rvVar.tzn.get(0)).title;
                }
                return rrVar;
            case 4:
                if (!(rvVar.tzn == null || rvVar.tzn.isEmpty())) {
                    rrVar.title = ((rm) rvVar.tzn.get(0)).title;
                }
                return rrVar;
            case 5:
                if (rvVar.tyy != null) {
                    rrVar.title = rvVar.tyy.title;
                    rrVar.desc = rvVar.tyy.tzN;
                }
                if (!(!bg.mA(rrVar.title) || rvVar.tzn == null || rvVar.tzn.isEmpty())) {
                    rrVar.title = ((rm) rvVar.tzn.get(0)).title;
                }
                if (bg.mA(rrVar.desc) && rwVar != null) {
                    rrVar.desc = rwVar.hSX;
                }
                return rrVar;
            case 6:
                rrVar.title = rvVar.iBi;
                if (bg.mA(rrVar.title)) {
                    if (rvVar.tyw != null) {
                        rrVar.title = rvVar.tyw.fRX;
                        rrVar.desc = rvVar.tyw.label;
                    }
                } else if (rvVar.tyw != null) {
                    rrVar.desc = rvVar.tyw.fRX;
                }
                return rrVar;
            case 7:
                if (!(rvVar.tzn == null || rvVar.tzn.isEmpty())) {
                    rrVar.title = ((rm) rvVar.tzn.get(0)).title;
                    rrVar.desc = ((rm) rvVar.tzn.get(0)).desc;
                }
                return rrVar;
            case 8:
                rrVar.title = rvVar.title;
                if (!(!bg.mA(rrVar.title) || rvVar.tzn == null || rvVar.tzn.isEmpty())) {
                    rrVar.title = ((rm) rvVar.tzn.get(0)).title;
                }
                return rrVar;
            case 10:
            case 11:
                if (rvVar.tyA != null) {
                    rrVar.title = rvVar.tyA.title;
                    rrVar.desc = rvVar.tyA.desc;
                }
                return rrVar;
            case 12:
            case 15:
                if (rvVar.tyC != null) {
                    rrVar.title = rvVar.tyC.title;
                    rrVar.desc = rvVar.tyC.desc;
                }
                return rrVar;
            case 14:
            case 18:
                List<rm> list = rvVar.tzn;
                if (list == null) {
                    return null;
                }
                for (rm rmVar : list) {
                    if (1 == rmVar.aMw) {
                        rrVar.title = rmVar.desc;
                        return rrVar;
                    }
                }
                return rrVar;
            default:
                w.w("MicroMsg.FavExportLogic", "unknown type %d", Integer.valueOf(i));
                return rrVar;
        }
    }

    public static String p(rm rmVar) {
        rn rnVar = rmVar.tyc;
        String str = "";
        switch (rmVar.aMw) {
            case 1:
                return eh(str, rmVar.desc);
            case 4:
                if (rnVar.tyC != null) {
                    return eh(str, rnVar.tyC.title);
                }
                return str;
            case 5:
                if (rnVar.tyy != null) {
                    return eh(str, rnVar.tyy.title);
                }
                return str;
            case 6:
                str = eh(str, rnVar.iBi);
                if (rnVar.tyw != null) {
                    return eh(eh(str, rnVar.tyw.fRX), rnVar.tyw.label);
                }
                return str;
            case 8:
                return eh(str, rnVar.title);
            case 10:
            case 11:
                if (rnVar.tyA != null) {
                    return eh(eh(str, rnVar.tyA.title), rnVar.tyA.desc);
                }
                return str;
            default:
                return eh(eh(str, rnVar.title), rnVar.desc);
        }
    }

    private static String eh(String str, String str2) {
        if (bg.mA(str)) {
            return str2;
        }
        if (bg.mA(str2)) {
            return str;
        }
        return str + "​" + str2;
    }

    public static void a(int i, int i2, Activity activity, b bVar) {
        a(-1, i, i2, activity, null, null, null, bVar);
    }

    public static void a(int i, int i2, int i3, Activity activity, Fragment fragment, com.tencent.mm.ui.snackbar.b.c cVar, OnClickListener onClickListener, b bVar) {
        if (activity == null && fragment == null) {
            w.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            return;
        }
        b anonymousClass1;
        if (bVar == null) {
            anonymousClass1 = new b() {
                public final void aAt() {
                    com.tencent.mm.sdk.b.b fpVar = new fp();
                    fpVar.fKp.type = 35;
                    a.urY.m(fpVar);
                }
            };
        } else {
            anonymousClass1 = bVar;
        }
        if (i2 != 0) {
            Context aG;
            if (activity == null) {
                aG = fragment.aG();
            } else {
                aG = activity;
            }
            String str;
            final OnClickListener onClickListener2;
            switch (i2) {
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                case -4:
                    String string;
                    str = "";
                    Context aG2 = fragment == null ? aG : fragment.aG();
                    if (i2 == -4) {
                        switch (i) {
                            case 2:
                                string = aG2.getString(R.l.ehY);
                                break;
                            case 4:
                            case 16:
                                string = aG2.getString(R.l.ehZ);
                                break;
                            case 8:
                                string = aG2.getString(R.l.ehX);
                                break;
                            case 14:
                                string = aG2.getString(R.l.eim);
                                break;
                            default:
                                string = str;
                                break;
                        }
                    } else if (i2 == -5) {
                        string = i != 14 ? aG2.getString(R.l.ehA) : aG2.getString(R.l.eil);
                    } else if (i2 == -6) {
                        string = aG2.getString(R.l.eim);
                    } else if (i2 == -7) {
                        string = aG2.getString(R.l.eil);
                    } else if (i2 == -8) {
                        string = aG2.getString(R.l.ein);
                    } else if (i2 != -9) {
                        string = aG2.getString(R.l.eib);
                    } else if (fragment != null) {
                        com.tencent.mm.ui.snackbar.a.a(0, fragment, aG2.getString(R.l.eiO), aG2.getString(R.l.ehz), anonymousClass1, cVar);
                        return;
                    } else {
                        com.tencent.mm.ui.snackbar.a.a(0, (Activity) aG, aG2.getString(R.l.eiO), aG2.getString(R.l.ehz), anonymousClass1, cVar);
                        return;
                    }
                    final OnClickListener onClickListener3 = onClickListener;
                    final Fragment fragment2 = fragment;
                    final com.tencent.mm.ui.snackbar.b.c cVar2 = cVar;
                    final Context context = aG;
                    onClickListener2 = onClickListener;
                    g.a(aG2, string, "", aG2.getString(R.l.eGa), aG2.getString(R.l.dXi), (OnClickListener) new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener3 != null) {
                                onClickListener3.onClick(dialogInterface, -2);
                            }
                            if (fragment2 != null) {
                                com.tencent.mm.ui.snackbar.a.a(0, fragment2, fragment2.aG().getString(R.l.eiO), fragment2.aG().getString(R.l.ehz), anonymousClass1, cVar2);
                            } else {
                                com.tencent.mm.ui.snackbar.a.a(0, context, context.getString(R.l.eiO), context.getString(R.l.ehz), anonymousClass1, cVar2);
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    }, R.e.aWu);
                    return;
                case -2:
                    str = aG.getString(R.l.eid);
                    String string2 = aG.getString(R.l.eie);
                    String string3 = aG.getString(R.l.eig);
                    String string4 = aG.getString(R.l.dXi);
                    onClickListener2 = onClickListener;
                    OnClickListener anonymousClass3 = new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("key_enter_fav_cleanui_from", 3);
                            d.b(aG, "favorite", ".ui.FavCleanUI", intent);
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -2);
                            }
                        }
                    };
                    onClickListener2 = onClickListener;
                    g.a(aG, str, string2, string3, string4, anonymousClass3, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    }, R.e.aWu);
                    return;
                default:
                    onClickListener2 = onClickListener;
                    g.a(aG, i2, 0, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    });
                    return;
            }
        } else if (fragment != null) {
            com.tencent.mm.ui.snackbar.a.a(i3, fragment, fragment.getString(R.l.eiO), fragment.getString(R.l.ehz), anonymousClass1, cVar);
        } else if (activity != null) {
            com.tencent.mm.ui.snackbar.a.a(i3, activity, activity.getString(R.l.eiO), activity.getString(R.l.ehz), anonymousClass1, cVar);
        }
    }

    public static int a(au auVar, cb cbVar, boolean z) {
        String str = "";
        w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", Integer.valueOf(auVar.field_type));
        if (z || cbVar.fFA.fFG <= 0) {
            boolean z2;
            if (cbVar.fFA.type == 4 || cbVar.fFA.type == 8 || cbVar.fFA.type == 16 || cbVar.fFA.type == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (cbVar.fFA.type == 14 && cbVar.fFA.fFC.tzn.size() > 0) {
                rm rmVar = (rm) cbVar.fFA.fFC.tzn.getLast();
                if (rmVar.aMw == 4 || rmVar.aMw == 8 || rmVar.aMw == 15 || rmVar.aMw == 2) {
                    z2 = false;
                }
            }
            w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", Boolean.valueOf(z2));
            if (z2) {
                return a(cbVar, 0);
            }
            if (cbVar.fFA.fFC == null) {
                return a(cbVar, -1);
            }
            if (cbVar.fFA.fFC.tzn == null) {
                return a(cbVar, -1);
            }
            String str2;
            if (System.currentTimeMillis() - auVar.field_createTime > 259200000) {
                z2 = true;
            } else {
                z2 = false;
            }
            w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", Boolean.valueOf(z2));
            if (1 <= cbVar.fFA.fFC.tzn.size()) {
                str2 = ((rm) cbVar.fFA.fFC.tzn.getLast()).txG;
            } else {
                str2 = str;
            }
            if (z2) {
                String str3;
                if (bg.mA(str2) || !e.aO(str2)) {
                    if (auVar != null && (auVar.field_type == 43 || auVar.field_type == 44 || auVar.field_type == 62)) {
                        r lH = t.lH(auVar.field_imgPath);
                        if (lH != null && lH.iaw == -1) {
                            str2 = lH.Lg();
                            if (e.aO(str2)) {
                                str3 = str2;
                                if (bg.mA(str3)) {
                                    return a(cbVar, -4);
                                }
                                ((rm) cbVar.fFA.fFC.tzn.getLast()).NZ(str3);
                            }
                        }
                    }
                    str3 = null;
                    if (bg.mA(str3)) {
                        return a(cbVar, -4);
                    }
                    ((rm) cbVar.fFA.fFC.tzn.getLast()).NZ(str3);
                } else {
                    str3 = str2;
                }
                if (a(auVar, cbVar, str3, true)) {
                    return a(cbVar, -5);
                }
                w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            } else if (a(auVar, cbVar, str2, false)) {
                return a(cbVar, -5);
            }
            w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
            return a(cbVar, 0);
        }
        w.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
        return a(cbVar, cbVar.fFA.fFG);
    }

    private static int a(cb cbVar, int i) {
        int i2 = 1;
        int i3 = 0;
        if (cbVar.fFA.fFC.tzn != null && cbVar.fFA.fFC.tzn.size() > 0) {
            rm rmVar = (rm) cbVar.fFA.fFC.tzn.getLast();
            if (i <= 0) {
                switch (i) {
                    case -5:
                        rmVar.yd(2);
                        rmVar.NZ(null);
                        break;
                    case -4:
                        rmVar.yd(1);
                        rmVar.NZ(null);
                        break;
                    default:
                        rmVar.yd(0);
                        break;
                }
            }
        }
        if (cbVar.fFA.fFC.tzn == null || cbVar.fFA.fFC.tzn.size() == 0) {
            cbVar.fFA.fFG = i;
        } else if (cbVar.fFA.fFG != -9) {
            if (i <= 0 && cbVar.fFA.fFG <= 0) {
                i2 = 0;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < cbVar.fFA.fFC.tzn.size()) {
                int i7;
                switch (((rm) cbVar.fFA.fFC.tzn.get(i3)).tyq) {
                    case 0:
                        i7 = i4;
                        i4 = i5;
                        i5 = i6 + 1;
                        break;
                    case 1:
                        i7 = i4 + 1;
                        i4 = i5;
                        i5 = i6;
                        break;
                    case 2:
                        i7 = i4;
                        i4 = i5 + 1;
                        i5 = i6;
                        break;
                    default:
                        i7 = i4;
                        i4 = i5;
                        i5 = i6;
                        break;
                }
                i3++;
                i6 = i5;
                i5 = i4;
                i4 = i7;
            }
            if (i2 > 0) {
                if (i5 > 0 || i4 > 0) {
                    cbVar.fFA.fFG = -9;
                } else {
                    cbVar.fFA.fFG = i;
                }
            } else if (i5 > 0) {
                if (i4 > 0) {
                    cbVar.fFA.fFG = -8;
                } else if (i6 == 0) {
                    cbVar.fFA.fFG = -5;
                } else if (i6 > 0) {
                    cbVar.fFA.fFG = -7;
                }
            } else if (i4 > 0) {
                if (i6 == 0) {
                    cbVar.fFA.fFG = -4;
                } else if (i6 > 0) {
                    cbVar.fFA.fFG = -6;
                }
            }
        }
        return i;
    }

    private static boolean a(au auVar, cb cbVar, String str, boolean z) {
        f.a B;
        if (!bg.mA(str)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.length() > ((long) com.tencent.mm.i.b.sD())) {
                    w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    return true;
                }
                w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                ((rm) cbVar.fFA.fFC.tzn.getLast()).NZ(null);
            }
        }
        String str2 = auVar.field_content;
        if (str2 != null) {
            B = f.a.B(str2, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B != null) {
            if (B.hhu != 0 || B.hhq > com.tencent.mm.i.b.sD()) {
                w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                return true;
            } else if (!(bg.mA(str) || !e.aO(str) || z)) {
                if (((long) B.hhq) > ((long) e.aN(str))) {
                    w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    ((rm) cbVar.fFA.fFC.tzn.getLast()).NZ(null);
                }
            }
        }
        if (str2 == null || B == null) {
            w.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        return false;
    }

    public static Bitmap aI(String str, boolean z) {
        int i = 960;
        boolean z2 = true;
        if (bg.mA(str)) {
            return null;
        }
        Bitmap bitmap = (Bitmap) sCe.get(str);
        if (bitmap != null) {
            w.d("MicroMsg.FavExportLogic", "get bm from cache %s", str);
            return bitmap;
        } else if (z) {
            return null;
        } else {
            if (!e.aO(str)) {
                return null;
            }
            int i2;
            w.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                w.i("MicroMsg.FavExportLogic", "bitmap recycle %s", bitmap);
                bitmap.recycle();
            }
            boolean z3 = com.tencent.mm.sdk.platformtools.d.bh(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!com.tencent.mm.sdk.platformtools.d.bg(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || r5) {
                i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                w.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                i2 = 960;
            }
            int Pc = ExifHelper.Pc(str);
            if (Pc == 90 || Pc == 270) {
                int i3 = i;
                i = i2;
                i2 = i3;
            }
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.FavExportLogic";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                w.i(str2, str3, objArr);
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.d.d(str, i2, i, false);
            }
            if (bitmap == null) {
                w.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = com.tencent.mm.sdk.platformtools.d.b(bitmap, (float) Pc);
            sCe.put(str, bitmap);
            return bitmap;
        }
    }

    public static int LO(String str) {
        Integer num = (Integer) suf.get(str);
        if (num == null) {
            return ((Integer) suf.get("unknown")).intValue();
        }
        return num.intValue();
    }

    @TargetApi(8)
    public static Bitmap LP(String str) {
        if (com.tencent.mm.compatible.util.d.eo(8)) {
            return ThumbnailUtils.createVideoThumbnail(str, 1);
        }
        return null;
    }

    public static void bCC() {
    }
}
