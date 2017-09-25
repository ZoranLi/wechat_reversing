package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class ei {

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ x oGE;
        final /* synthetic */ List vOw;
        final /* synthetic */ boolean vOx;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context, x xVar, List list, boolean z) {
            this.val$context = context;
            this.oGE = xVar;
            this.vOw = list;
            this.vOx = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ei.a(this.val$context, this.oGE, this.vOw, this.vOx);
        }
    }

    public static void a(Context context, x xVar, List<au> list, boolean z) {
        BaseMessage a;
        IWWAPI hM = WWAPIFactory.hM(context);
        if (list.size() != 1 || ((au) list.get(0)).field_type == 48) {
            a = a(xVar, list, z);
        } else {
            a = c((au) list.get(0), z);
        }
        hM.a(a);
    }

    private static WWMediaObject c(au auVar, boolean z) {
        int i = auVar.field_type;
        if (i == 1) {
            return new WWMediaText(aa.q(auVar.field_content, auVar.field_isSend, z));
        }
        String m;
        WWMediaObject wWMediaImage;
        if (i == 3) {
            d aj;
            if (auVar.field_msgId > 0) {
                aj = n.GS().aj(auVar.field_msgId);
            } else {
                aj = null;
            }
            if ((aj == null || aj.hEY <= 0) && auVar.field_msgSvrId > 0) {
                aj = n.GS().ai(auVar.field_msgSvrId);
            }
            if (aj == null) {
                return null;
            }
            m = n.GS().m(e.c(aj), "", "");
            wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = m;
            w.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
            return wWMediaImage;
        } else if (i == 43) {
            wWMediaImage = new WWMediaVideo();
            r lH = t.lH(auVar.field_imgPath);
            o.KV();
            wWMediaImage.filePath = s.lv(lH.getFileName());
            w.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", wWMediaImage.filePath);
            return wWMediaImage;
        } else if (i == 48) {
            wWMediaImage = new WWMediaLocation();
            m = aa.q(auVar.field_content, auVar.field_isSend, z);
            ap.yY();
            b Aw = c.wT().Aw(m);
            wWMediaImage.title = Aw.ndv;
            wWMediaImage.hCE = Aw.label;
            wWMediaImage.longitude = Aw.naP;
            wWMediaImage.latitude = Aw.naO;
            wWMediaImage.xmc = (double) Aw.fOd;
            return wWMediaImage;
        } else if (i == 49 || i == 268435505) {
            return d(auVar, z);
        } else {
            w.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(i));
            return null;
        }
    }

    private static WWMediaObject a(x xVar, List<au> list, boolean z) {
        WWMediaObject wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = xVar.field_username;
        Context context = ab.getContext();
        if (z) {
            str = context.getString(R.l.eIF);
        } else {
            str = m.xN().equals(com.tencent.mm.u.n.eJ(str)) ? context.getString(R.l.ejc, new Object[]{m.xN()}) : context.getString(R.l.ejb, new Object[]{m.xN(), com.tencent.mm.u.n.eJ(str)});
        }
        wWMediaMergedConvs.title = str;
        for (au auVar : list) {
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String xL = auVar.field_isSend == 1 ? m.xL() : !z ? auVar.field_talker : ay.gi(auVar.field_content);
            wWMediaConversation.name = com.tencent.mm.u.n.eJ(xL);
            try {
                Bitmap a = com.tencent.mm.x.b.a(xL, false, -1);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                wWMediaConversation.xma = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            wWMediaConversation.date = auVar.field_createTime;
            wWMediaConversation.xmb = c(auVar, z);
            if (wWMediaConversation.checkArgs()) {
                wWMediaMergedConvs.xmd.add(wWMediaConversation);
            }
        }
        return wWMediaMergedConvs;
    }

    private static WWMediaObject d(au auVar, boolean z) {
        a B;
        String str = auVar.field_content;
        if (z) {
            int indexOf = auVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = auVar.field_content.substring(indexOf + 1);
            }
        }
        if (str != null) {
            B = a.B(str, auVar.field_reserved);
        } else {
            B = null;
        }
        if (B == null) {
            return null;
        }
        switch (B.type) {
            case 2:
                if (B.fCW == null || B.fCW.length() <= 0) {
                    return null;
                }
                com.tencent.mm.pluginsdk.model.app.b LW = an.abL().LW(B.fCW);
                if (LW == null || !LW.azf()) {
                    return null;
                }
                str = LW.field_fileFullPath;
                if (com.tencent.mm.a.e.aO(str)) {
                    WWMediaObject wWMediaImage = new WWMediaImage();
                    wWMediaImage.filePath = str;
                    w.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
                    return wWMediaImage;
                }
                w.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId));
                return null;
            case 5:
                OutputStream byteArrayOutputStream;
                WWMediaMessage wWMediaLink = new WWMediaLink();
                wWMediaLink.webpageUrl = B.url;
                wWMediaLink.title = B.title;
                wWMediaLink.description = B.description;
                Bitmap a = n.GS().a(auVar.field_imgPath, com.tencent.mm.bg.a.getDensity(null), false);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    a = n.GS().a(auVar.field_imgPath, com.tencent.mm.bg.a.getDensity(null), false);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                return wWMediaLink;
            case 6:
                com.tencent.mm.pluginsdk.model.app.b Mh = l.Mh(B.fCW);
                if (Mh == null) {
                    Mh = an.abL().eb(auVar.field_msgId);
                }
                WWMediaObject wWMediaFile = new WWMediaFile();
                wWMediaFile.fyF = B.title;
                wWMediaFile.filePath = Mh.field_fileFullPath;
                return wWMediaFile;
            default:
                return null;
        }
    }
}
