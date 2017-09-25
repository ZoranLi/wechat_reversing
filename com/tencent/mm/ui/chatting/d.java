package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.io.ByteArrayOutputStream;
import java.io.File;

final class d {
    static boolean a(Context context, a aVar) {
        if (aVar == null || context == null) {
            return false;
        }
        if (aVar.type == 3) {
            return g.m(context, 16);
        }
        if (aVar.type == 4) {
            return g.m(context, 8);
        }
        if (aVar.type == 5) {
            return g.m(context, 32);
        }
        if (aVar.type != 6) {
            return false;
        }
        Long LB = b.a.LB(aVar.hhr);
        if (LB != null) {
            return g.m(context, LB.longValue());
        }
        return false;
    }

    static void a(final En_5b8fbb1e.a aVar, final au auVar, String str) {
        String cQ = aVar.cQ(auVar.field_content, auVar.field_isSend);
        final Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", cQ);
        intent.putExtra("Retr_MsgFromScene", 2);
        a ek = a.ek(cQ);
        if (ek != null && 19 == ek.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (ek != null && 24 == ek.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (ek == null || 16 != ek.type) {
            intent.putExtra("Retr_Msg_Type", 2);
            cQ = auVar.field_talker;
            String fQ = q.fQ(auVar.field_msgSvrId);
            intent.putExtra("reportSessionId", fQ);
            q.b n = q.yC().n(fQ, true);
            n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
            n.l("preUsername", str);
            n.l("preChatName", cQ);
            if (ek != null && 33 == ek.type) {
                if (aVar.vBH) {
                    n.l("fromScene", Integer.valueOf(2));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                } else {
                    n.l("fromScene", Integer.valueOf(1));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                }
                intent.putExtra("Retr_MsgFromUserName", str);
                intent.putExtra("Retr_MsgTalker", auVar.field_talker);
            }
            n.l("sendAppMsgScene", Integer.valueOf(1));
            ((h) com.tencent.mm.kernel.h.h(h.class)).a("adExtStr", n, auVar);
        } else {
            intent.putExtra("Retr_Msg_Type", 14);
        }
        intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
        if (ek == null || ek.type != 6) {
            aVar.startActivity(intent);
            return;
        }
        boolean z = ek.hhu != 0 || ek.hhq > 26214400;
        intent.putExtra("Retr_Big_File", z);
        final com.tencent.mm.pluginsdk.model.app.b Mh = l.Mh(ek.fCW);
        if (Mh != null) {
            File file = new File(Mh.field_fileFullPath);
            if (file.exists() && file.length() == Mh.field_totalLen) {
                aVar.startActivity(intent);
                return;
            } else if (Mh.field_offset > 0 && Mh.field_totalLen > Mh.field_offset) {
                a(aVar, intent, auVar, Mh.field_fileFullPath);
                return;
            }
        }
        w.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", Integer.valueOf(ek.hhq), ek.hhx, bg.Qj(ek.hhE));
        if (z) {
            intent.putExtra("Retr_Big_File", z);
            com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
            hVar.hze = new com.tencent.mm.modelcdntran.h.a() {
                public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                    String str2 = "MicroMsg.AppMessageUtil";
                    String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
                    Object[] objArr = new Object[7];
                    objArr[0] = str;
                    objArr[1] = Integer.valueOf(i);
                    objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
                    objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
                    objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo != null);
                    objArr[5] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult != null);
                    objArr[6] = Boolean.valueOf(z);
                    w.i(str2, str3, objArr);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck) {
                            aVar.startActivity(intent);
                        } else if (auVar.bMt() || (Mh != null && d.c(auVar, Mh.field_fileFullPath))) {
                            w.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                            com.tencent.mm.ui.base.g.a(aVar.uSU.uTo, aVar.uSU.uTo.getString(R.l.ejY), aVar.uSU.uTo.getString(R.l.dIO), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass1 vyh;

                                {
                                    this.vyh = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            com.tencent.mm.ui.base.g.b(aVar.uSU.uTo, aVar.getString(R.l.eaJ), "", true);
                        }
                    }
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] i(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            hVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bg.Nz(), str, auVar.field_msgId);
            hVar.field_fileId = ek.hhx;
            hVar.field_aesKey = ek.hhE;
            hVar.field_filemd5 = ek.filemd5;
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxN;
            hVar.field_talker = str;
            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
            hVar.field_svr_signature = "";
            hVar.field_onlycheckexist = true;
            w.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", Boolean.valueOf(com.tencent.mm.modelcdntran.g.El().b(hVar)), hVar.field_fileId, hVar.field_mediaId, bg.Qj(hVar.field_aesKey));
            if (!com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                a(aVar, intent, auVar, null);
                return;
            }
            return;
        }
        a(aVar, intent, auVar, null);
    }

    private static void a(En_5b8fbb1e.a aVar, Intent intent, au auVar, String str) {
        if (auVar.bMt() || c(auVar, str)) {
            w.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
            com.tencent.mm.ui.base.g.a(aVar.uSU.uTo, aVar.uSU.uTo.getString(R.l.ejY), aVar.uSU.uTo.getString(R.l.dIO), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return;
        }
        aVar.startActivity(intent);
    }

    public static boolean c(au auVar, String str) {
        if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bg.mA(str) && e.aO(str))) {
            return false;
        }
        return true;
    }
}
