package com.tencent.mm.ab;

import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import java.util.LinkedList;

public final class g extends ab {
    public final boolean eX(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        if (i != 0 && i < 604307701) {
            ap.yY();
            au[] bn = c.wT().bn("fmessage", 20);
            if (bn == null) {
                w.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                return;
            }
            l.Ky();
            w.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + bn.length);
            for (ce ceVar : bn) {
                if (ceVar != null && ceVar.field_msgId != 0) {
                    w.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + ceVar.field_type);
                    String str = ceVar.field_content;
                    if (str != null && str.length() != 0) {
                        f fVar;
                        switch (ceVar.field_type) {
                            case JsApiGetLocation.CTRL_INDEX /*37*/:
                                w.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + ceVar.field_content);
                                d RI = d.RI(ceVar.field_content);
                                if (!u.mA(RI.rUK) && (RI.scene == 18 || ay.fc(RI.scene))) {
                                    w.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + RI.scene);
                                    break;
                                }
                                fVar = new f();
                                fVar.field_createTime = ceVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = ceVar.field_content;
                                fVar.field_svrId = ceVar.field_msgSvrId;
                                fVar.field_talker = RI.rUK;
                                switch (RI.fJK) {
                                    case 2:
                                        fVar.field_type = 1;
                                        break;
                                    case 5:
                                        fVar.field_type = 2;
                                        break;
                                    case 6:
                                        fVar.field_type = 3;
                                        break;
                                    default:
                                        fVar.field_type = 1;
                                        break;
                                }
                                l.Kx().a(fVar);
                                break;
                                break;
                            case 40:
                                w.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + ceVar.field_content);
                                a RF = a.RF(ceVar.field_content);
                                fVar = new f();
                                fVar.field_createTime = ceVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = ceVar.field_content;
                                fVar.field_svrId = ceVar.field_msgSvrId;
                                fVar.field_talker = RF.rUK;
                                fVar.field_type = 0;
                                l.Kx().a(fVar);
                                break;
                            default:
                                w.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + ceVar.field_type);
                                break;
                        }
                    }
                    w.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + ceVar.field_msgId);
                } else {
                    w.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            ap.yY();
            c.vr().set(143618, Integer.valueOf(0));
            l.Ky().Kl();
            w.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            ap.yY();
            c.wR().Ri("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            ap.yY();
            c.wW().aw(linkedList);
        }
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
