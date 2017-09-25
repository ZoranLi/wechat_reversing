package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;

public final class eg extends c<nd> {
    public Activity activity = null;
    private a vOg = null;

    public enum a {
        CHATTING_ITEM_VIDEO,
        IMAGE_GALLERY_UI,
        VIDEO_GALLERY
    }

    public eg(a aVar, Activity activity) {
        super(0);
        this.vOg = aVar;
        this.activity = activity;
        this.usg = nd.class.getName().hashCode();
    }

    private boolean a(nd ndVar) {
        int i = 1;
        if (!(this.vOg == null || ndVar == null || !(ndVar instanceof nd))) {
            ce ceVar;
            long j = ndVar.fUm.fGM;
            String str = ndVar.fUm.fUn;
            ce ceVar2 = ndVar.fUm.fUo;
            if (ceVar2 == null || ceVar2.field_msgId <= 0) {
                ceVar = ndVar.fUm.fUo;
            } else {
                ceVar = ceVar2;
            }
            if (ceVar != null) {
                switch (ceVar.field_type) {
                    case 3:
                        switch (this.vOg) {
                            case IMAGE_GALLERY_UI:
                                if (ceVar != null && ceVar.field_msgId > 0) {
                                    try {
                                        g.El().iP(d.a("downimg", ceVar.field_createTime, ceVar.field_talker, ceVar.field_msgId));
                                        w.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", Boolean.valueOf(true));
                                        ap.vd().cancel(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                                        n.GT().e(com.tencent.mm.ui.chatting.gallery.d.bg(ceVar).hEY, j);
                                    } catch (Throwable e) {
                                        w.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", e.getMessage());
                                    }
                                }
                                if (this.activity != null && (this.activity instanceof ImageGalleryUI)) {
                                    w.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", Long.valueOf(j), Long.valueOf(((ImageGalleryUI) this.activity).fGM));
                                    if (j == ((ImageGalleryUI) this.activity).fGM) {
                                        com.tencent.mm.ui.base.g.a(this.activity, str, "", false, new OnClickListener(this) {
                                            final /* synthetic */ eg vOh;

                                            {
                                                this.vOh = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                this.vOh.activity.finish();
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    case 43:
                    case 62:
                        String str2 = "MicroMsg.RevokeMsgListener";
                        String str3 = "ashutest::revoke msg, type %s, isWorkerThread %B";
                        Object[] objArr = new Object[2];
                        objArr[0] = this.vOg;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == ap.vL().nJF.getLooper());
                        w.v(str2, str3, objArr);
                        switch (this.vOg) {
                            case VIDEO_GALLERY:
                                aQ(ceVar);
                                if (this.activity instanceof ImageGalleryUI) {
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) this.activity;
                                    if (!(imageGalleryUI.vPU != null && b.aS(ceVar) && ceVar.field_msgId == imageGalleryUI.vPU.bWK().field_msgId)) {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        imageGalleryUI.BE(imageGalleryUI.bXf());
                                        com.tencent.mm.ui.base.g.a(this.activity, str, "", false, new OnClickListener(this) {
                                            final /* synthetic */ eg vOh;

                                            {
                                                this.vOh = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                this.vOh.activity.finish();
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            case CHATTING_ITEM_VIDEO:
                                aQ(ceVar);
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
            w.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        }
        return false;
    }

    private static void aQ(au auVar) {
        r lH = t.lH(auVar.field_imgPath);
        if (lH != null) {
            try {
                g.El().iP(d.a("downvideo", lH.iam, lH.Le(), lH.getFileName()));
                w.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", Boolean.valueOf(true));
                com.tencent.mm.modelvideo.x.a La = o.La();
                h.vd().c(La.iaZ);
                La.pr();
                o.KV().lt(lH.getFileName());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e.getMessage());
            }
        }
    }
}
