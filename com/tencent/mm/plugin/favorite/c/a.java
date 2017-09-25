package com.tencent.mm.plugin.favorite.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.m.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public final class a {

    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ cb lFP;

        public AnonymousClass1(cb cbVar) {
            this.lFP = cbVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                a.a(this.lFP);
            }
        }
    }

    private static class a implements Runnable {
        public j lFt;

        public a(j jVar) {
            this.lFt = jVar;
        }

        public final void run() {
            rm rmVar;
            String aV;
            Throwable e;
            InputStream inputStream;
            String mz;
            long ki;
            String a;
            Throwable th;
            List list = this.lFt.field_favProto.tzn;
            MediaMetadataRetriever mediaMetadataRetriever;
            if (list.size() > 0) {
                boolean z = false;
                int size = list.size();
                w.i("MicroMsg.AddFavService", "run addfavservice copyrunable info.field_type = %d", new Object[]{Integer.valueOf(this.lFt.field_type)});
                if (this.lFt.field_type == 18 && this.lFt.field_sourceType == 6) {
                    int i = 0;
                    while (i < size) {
                        boolean z2;
                        rmVar = (rm) list.get(i);
                        if (rmVar.txU && rmVar.txW) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        i++;
                        z = z2;
                    }
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        String h;
                        rmVar = (rm) list.get(i2);
                        if (bg.mA(rmVar.lKv)) {
                            rmVar.NY(x.aS(rmVar.toString(), this.lFt.field_type));
                        }
                        if (!(rmVar.txU && rmVar.txW)) {
                            z = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        String str = rmVar.txG;
                        if (FileOp.aO(str)) {
                            aV = g.aV(str);
                            String aW = g.aW(str);
                            rmVar.NW(aV);
                            rmVar.NX(aW);
                            rmVar.ej(new File(str).length());
                            aV = x.g(rmVar);
                            if (!str.equals(aV)) {
                                FileOp.p(str, aV);
                            }
                        } else {
                            w.i("MicroMsg.AddFavService", "copy file fail, type:%d, %s not exist!", new Object[]{Integer.valueOf(rmVar.aMw), str});
                        }
                        aV = rmVar.txI;
                        if (bg.mA(aV) && FileOp.aO(str) && this.lFt.field_type == 4 && this.lFt.field_favProto.tzl.fFq == 13) {
                            aV = x.g(rmVar) + "_tempthumb";
                            Bitmap LP = c.LP(str);
                            if (LP != null) {
                                try {
                                    w.i("MicroMsg.AddFavService", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                    e.a(LP, CompressFormat.JPEG, aV);
                                } catch (Throwable e2) {
                                    w.printErrStackTrace("MicroMsg.AddFavService", e2, "", new Object[0]);
                                }
                            }
                            rmVar.Oa(aV);
                            try {
                                w.i("MicroMsg.AddFavService", "add fav service: get video duration");
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(str);
                                    rmVar.ya(bg.ex((long) bg.getInt(mediaMetadataRetriever.extractMetadata(9), 0)));
                                    mediaMetadataRetriever.release();
                                } catch (Exception e3) {
                                    e2 = e3;
                                    try {
                                        w.printErrStackTrace("MicroMsg.AddFavService", e2, "get video duration error. path %s", new Object[]{str});
                                        if (mediaMetadataRetriever != null) {
                                            mediaMetadataRetriever.release();
                                        }
                                        if (FileOp.aO(aV)) {
                                            inputStream = null;
                                            try {
                                                inputStream = FileOp.openRead(aV);
                                                mz = bg.mz(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                                                ki = FileOp.ki(aV);
                                                a = g.a(inputStream, 0, 256);
                                                rmVar.Ob(mz);
                                                rmVar.Oc(a);
                                                rmVar.ek(ki);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e4) {
                                                    }
                                                }
                                            } catch (FileNotFoundException e5) {
                                                w.e("MicroMsg.AddFavService", "FileOp thumbpath error !");
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e6) {
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e7) {
                                                    }
                                                }
                                            }
                                            h = x.h(rmVar);
                                            if (aV.equals(h)) {
                                                FileOp.p(aV, h);
                                            }
                                        } else {
                                            w.i("MicroMsg.AddFavService", "copy thumb fail, %s not exist!", new Object[]{aV});
                                        }
                                        w.v("MicroMsg.AddFavService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.lFt.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                            } catch (Exception e8) {
                                e2 = e8;
                                mediaMetadataRetriever = null;
                                w.printErrStackTrace("MicroMsg.AddFavService", e2, "get video duration error. path %s", new Object[]{str});
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (FileOp.aO(aV)) {
                                    w.i("MicroMsg.AddFavService", "copy thumb fail, %s not exist!", new Object[]{aV});
                                } else {
                                    inputStream = null;
                                    inputStream = FileOp.openRead(aV);
                                    mz = bg.mz(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                                    ki = FileOp.ki(aV);
                                    a = g.a(inputStream, 0, 256);
                                    rmVar.Ob(mz);
                                    rmVar.Oc(a);
                                    rmVar.ek(ki);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    h = x.h(rmVar);
                                    if (aV.equals(h)) {
                                        FileOp.p(aV, h);
                                    }
                                }
                                w.v("MicroMsg.AddFavService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.lFt.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            } catch (Throwable th4) {
                                th = th4;
                                mediaMetadataRetriever = null;
                            }
                        }
                        if (FileOp.aO(aV)) {
                            inputStream = null;
                            inputStream = FileOp.openRead(aV);
                            mz = bg.mz(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                            ki = FileOp.ki(aV);
                            a = g.a(inputStream, 0, 256);
                            rmVar.Ob(mz);
                            rmVar.Oc(a);
                            rmVar.ek(ki);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            h = x.h(rmVar);
                            if (aV.equals(h)) {
                                FileOp.p(aV, h);
                            }
                        } else {
                            w.i("MicroMsg.AddFavService", "copy thumb fail, %s not exist!", new Object[]{aV});
                        }
                        w.v("MicroMsg.AddFavService", "klem cul md5 and copy file, favLocalId:%d  time:%d", new Object[]{Long.valueOf(this.lFt.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ a lFR;

                    public final void run() {
                        if (z) {
                            w.v("MicroMsg.AddFavService", "has data, check cdn now, type %d", new Object[]{Integer.valueOf(this.lFR.lFt.field_type)});
                            this.lFR.lFt.field_itemStatus = 1;
                            this.lFR.lFt.field_xml = j.b(this.lFR.lFt);
                            if (x.v(this.lFR.lFt)) {
                                h.ata().a(this.lFR.lFt, new String[0]);
                            } else {
                                h.ata().c(this.lFR.lFt);
                            }
                            h.asR().run();
                            return;
                        }
                        w.v("MicroMsg.AddFavService", "no data, send item now, type %d", new Object[]{Integer.valueOf(this.lFR.lFt.field_type)});
                        this.lFR.lFt.field_itemStatus = 9;
                        this.lFR.lFt.field_xml = j.b(this.lFR.lFt);
                        if (x.v(this.lFR.lFt)) {
                            h.ata().a(this.lFR.lFt, new String[0]);
                        } else {
                            h.ata().c(this.lFR.lFt);
                        }
                        h.asQ().run();
                    }
                });
                return;
            }
            return;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    public static int a(cb cbVar) {
        j vS;
        int i = 1;
        j jVar = new j();
        jVar.field_favProto = cbVar.fFA.fFC;
        jVar.field_sessionId = cbVar.fFA.fFF;
        rw rwVar = jVar.field_favProto.tzl;
        if (rwVar != null) {
            int i2;
            jVar.field_sourceId = rwVar.tzq;
            if (jVar.field_sourceId == null || jVar.field_sourceId.equals("")) {
                i2 = 0;
            } else {
                j vS2 = h.ata().vS(jVar.field_sourceId);
                if (vS2 != null && vS2.field_id > 0) {
                    int i3 = vS2.field_id;
                    if (i3 <= 0) {
                        w.e("MicroMsg.ModFavItemLogic", "modUpdateTime favId illegal:%d", new Object[]{Integer.valueOf(i3)});
                    } else {
                        LinkedList linkedList = new LinkedList();
                        amj com_tencent_mm_protocal_c_amj = new amj();
                        com_tencent_mm_protocal_c_amj.tRc = 1;
                        com_tencent_mm_protocal_c_amj.tRd = (int) (System.currentTimeMillis() / 1000);
                        linkedList.add(com_tencent_mm_protocal_c_amj);
                        ap.vd().a(new com.tencent.mm.plugin.favorite.b.af(i3, linkedList, null), 0);
                    }
                }
                i2 = vS2 != null ? 1 : 0;
            }
            if (i2 != 0) {
                w.w("MicroMsg.AddFavService", "handleEvent, msg already exist, do not insert");
                i = 0;
                if (i != 0) {
                    vS = h.ata().vS(jVar.field_sourceId);
                    if (vS != null) {
                        x.cg(vS.field_localId);
                    }
                } else {
                    jVar.field_flag = 0;
                    jVar.field_updateTime = System.currentTimeMillis();
                    jVar.field_localId = System.currentTimeMillis();
                    x.cg(jVar.field_localId);
                    jVar.field_type = cbVar.fFA.type;
                    if (cbVar.fFA.desc != null || cbVar.fFA.desc.length() < CdnLogic.MediaType_FAVORITE_FILE) {
                        jVar.field_favProto.OC(cbVar.fFA.desc);
                    } else {
                        w.w("MicroMsg.AddFavService", "length more than 10000, do cut desc");
                        jVar.field_favProto.OC(cbVar.fFA.desc.substring(0, CdnLogic.MediaType_FAVORITE_FILE));
                    }
                    jVar.field_xml = j.b(jVar);
                    x(jVar);
                    x.r(jVar);
                    jVar.vP("MicroMsg.AddFavService");
                }
                return 0;
            }
            jVar.field_fromUser = rwVar.fOu;
            jVar.field_toUser = rwVar.toUser;
            jVar.field_sourceType = rwVar.fFq;
            jVar.field_sourceId = rwVar.tzq;
            jVar.field_sourceCreateTime = rwVar.iam;
        }
        w.i("MicroMsg.AddFavService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", new Object[]{jVar.field_fromUser, jVar.field_toUser, jVar.field_sourceId, Integer.valueOf(jVar.field_sourceType)});
        if (i != 0) {
            jVar.field_flag = 0;
            jVar.field_updateTime = System.currentTimeMillis();
            jVar.field_localId = System.currentTimeMillis();
            x.cg(jVar.field_localId);
            jVar.field_type = cbVar.fFA.type;
            if (cbVar.fFA.desc != null) {
            }
            jVar.field_favProto.OC(cbVar.fFA.desc);
            jVar.field_xml = j.b(jVar);
            x(jVar);
            x.r(jVar);
            jVar.vP("MicroMsg.AddFavService");
        } else {
            vS = h.ata().vS(jVar.field_sourceId);
            if (vS != null) {
                x.cg(vS.field_localId);
            }
        }
        return 0;
    }

    public static void w(j jVar) {
        jVar.field_updateTime = System.currentTimeMillis();
        if (!x.v(jVar)) {
            jVar.field_localId = System.currentTimeMillis();
        }
        x(jVar);
        x.r(jVar);
    }

    private static void x(j jVar) {
        x.bX(jVar.field_localId);
        if (jVar.field_favProto.tzn.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new a(jVar), "AddFavService_copy");
            return;
        }
        jVar.field_itemStatus = 9;
        if (x.v(jVar)) {
            h.ata().a(jVar, new String[0]);
        } else {
            h.ata().c(jVar);
        }
        h.asQ().run();
    }
}
