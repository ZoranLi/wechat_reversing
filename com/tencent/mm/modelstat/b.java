package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class b {
    public static b hUp = new b();
    public log_13835 hUo;
    private c hUq = new c<ny>(this) {
        final /* synthetic */ b hUt;

        {
            this.hUt = r2;
            this.usg = ny.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ny nyVar = (ny) bVar;
            if (nyVar instanceof ny) {
                this.hUt.f(nyVar.fVe.fCZ);
            }
            return false;
        }
    };
    private int hUr = 1;
    private int hUs = 1;
    private boolean hasInit = false;
    public Object lock = new Object();

    public enum a {
        OP_Chatting(1),
        OP_Msg(2);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
        UnKnownType(0),
        expourse(1),
        click(2),
        send(3),
        fav(4),
        revoke(5),
        delete(6),
        voiceToText(7),
        translate(8),
        translateHidden(9),
        doubleClickText(10),
        imageSaveToLocal(11),
        playMusic(12),
        stopMusic(13);
        
        public int value;

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    private b() {
        com.tencent.mm.sdk.b.a.urY.a(this.hUq);
    }

    public final boolean ba(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.ChattingOperationUitl", "check error:%s", bg.bJZ().toString());
            com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_13913 = new log_13913();
            com_tencent_mm_plugin_report_kvdata_log_13913.scene_ = 1;
            com_tencent_mm_plugin_report_kvdata_log_13913.error_ = r2;
            g.oUh.b(13913, com_tencent_mm_plugin_report_kvdata_log_13913);
            return false;
        }
        if (!(this.hUo == null || this.hUo.currChatName_.equals(str))) {
            qg();
        }
        if (this.hUo == null) {
            this.hUo = new log_13835();
            this.hUo.currChatName_ = str;
        }
        return true;
    }

    public final void qg() {
        if (JT()) {
            int i;
            synchronized (this.lock) {
                i = (this.hUo == null || this.hUo.oplist_.isEmpty()) ? 0 : 1;
            }
            if (i != 0) {
                if (this.hUs != 0) {
                    w.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                    g.oUh.b(13835, this.hUo);
                }
                if (this.hUr != 0) {
                    w.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", JS());
                    g.oUh.A(13748, r0);
                }
            }
            this.hUo = null;
        }
    }

    public final void A(String str, boolean z) {
        int i = 1;
        if (JT()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeUnread = i;
            qg();
            if (ba(str)) {
                synchronized (this.lock) {
                    this.hUo.oplist_.add(iMBehavior);
                }
                qg();
            }
        }
    }

    public final void b(boolean z, String str, boolean z2) {
        int i = 1;
        if (JT()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z2) {
                i = 2;
            }
            iMBehaviorChattingOP.changeTop = i;
            if (z) {
                qg();
            }
            if (ba(str)) {
                synchronized (this.lock) {
                    this.hUo.oplist_.add(iMBehavior);
                }
                if (z) {
                    qg();
                }
            }
        }
    }

    public final void B(String str, boolean z) {
        int i = 1;
        if (JT() && ba(str)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeSaveAddress = i;
            synchronized (this.lock) {
                this.hUo.oplist_.add(iMBehavior);
            }
        }
    }

    public final void a(au auVar, b bVar, int i) {
        if (ba(auVar.field_talker)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 2;
            iMBehavior.msgOp = new IMBehaviorMsgOP();
            iMBehavior.msgOp.msgType = auVar.field_type & 65535;
            if (auVar.axO()) {
                iMBehavior.msgOp.appMsgInnerType = i;
            }
            iMBehavior.msgOp.msgOpType = bVar.value;
            iMBehavior.msgOp.count = 1;
            synchronized (this.lock) {
                if (iMBehavior.opType == a.OP_Chatting.value) {
                    this.hUo.oplist_.add(iMBehavior);
                    return;
                }
                Iterator it = this.hUo.oplist_.iterator();
                while (it.hasNext()) {
                    IMBehavior iMBehavior2 = (IMBehavior) it.next();
                    if (iMBehavior2.opType == a.OP_Msg.value) {
                        IMBehaviorMsgOP iMBehaviorMsgOP = iMBehavior2.msgOp;
                        IMBehaviorMsgOP iMBehaviorMsgOP2 = iMBehavior.msgOp;
                        int i2 = (iMBehaviorMsgOP.msgOpType == iMBehaviorMsgOP2.msgOpType && iMBehaviorMsgOP.msgType == iMBehaviorMsgOP2.msgType && iMBehaviorMsgOP.appMsgInnerType == iMBehaviorMsgOP2.appMsgInnerType) ? 1 : 0;
                        if (i2 != 0) {
                            IMBehaviorMsgOP iMBehaviorMsgOP3 = iMBehavior2.msgOp;
                            iMBehaviorMsgOP3.count++;
                            return;
                        }
                    }
                }
                this.hUo.oplist_.add(iMBehavior);
            }
        }
    }

    public final void a(final au auVar, final int i) {
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ b hUt;

            public final void run() {
                this.hUt.b(auVar, i);
            }
        });
    }

    public final void f(final au auVar) {
        new ae(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ b hUt;

            public final void run() {
                this.hUt.b(auVar, 0);
            }
        });
    }

    public final void b(au auVar, int i) {
        if (JT()) {
            a(auVar, b.send, i);
        }
    }

    public final void c(au auVar, int i) {
        if (JT()) {
            a(auVar, b.fav, i);
        }
    }

    public final void t(au auVar) {
        if (JT()) {
            a(auVar, b.fav, 0);
        }
    }

    public final void d(au auVar, int i) {
        if (JT()) {
            a(auVar, b.delete, i);
        }
    }

    public final void u(au auVar) {
        if (JT()) {
            a(auVar, b.delete, 0);
        }
    }

    public final void e(au auVar, int i) {
        if (JT()) {
            a(auVar, b.click, i);
        }
    }

    public final void v(au auVar) {
        if (JT()) {
            a(auVar, b.click, 0);
        }
    }

    public final void w(au auVar) {
        if (JT()) {
            a(auVar, b.voiceToText, 0);
        }
    }

    public final void a(au auVar, boolean z) {
        if (JT() && auVar.bMk()) {
            a(auVar, z ? b.translate : b.translateHidden, 0);
        }
    }

    public final void x(au auVar) {
        if (JT() && auVar.bMk()) {
            a(auVar, b.doubleClickText, 0);
        }
    }

    public final void y(au auVar) {
        if (JT()) {
            a(auVar, b.imageSaveToLocal, 0);
        }
    }

    private String JS() {
        if (this.hUo == null) {
            return "";
        }
        String str = ",";
        LinkedList linkedList = new LinkedList();
        synchronized (this.lock) {
            linkedList.addAll(this.hUo.oplist_);
        }
        Iterator it = linkedList.iterator();
        int i = 1;
        while (it.hasNext()) {
            StringBuilder append;
            String str2;
            IMBehavior iMBehavior = (IMBehavior) it.next();
            if (i == 0) {
                str = str + "|";
            }
            str = str + iMBehavior.opType + "#";
            if (iMBehavior.opType == 1) {
                append = new StringBuilder().append(str);
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                str2 = "";
                if (iMBehaviorChattingOP.changeUnread != 0) {
                    str2 = str2 + "changeUnread=" + iMBehaviorChattingOP.changeUnread;
                }
                if (iMBehaviorChattingOP.changeTop != 0) {
                    str2 = str2 + "changeTop=" + iMBehaviorChattingOP.changeTop;
                }
                if (iMBehaviorChattingOP.changeNotifyStatus != 0) {
                    str2 = str2 + "changeNotifyStatus=" + iMBehaviorChattingOP.changeNotifyStatus;
                }
                if (iMBehaviorChattingOP.changeSaveAddress != 0) {
                    str2 = str2 + "changeSaveAddress=" + iMBehaviorChattingOP.changeSaveAddress;
                }
                if (iMBehaviorChattingOP.expose != 0) {
                    str2 = str2 + "expose=" + iMBehaviorChattingOP.expose;
                }
            } else {
                append = new StringBuilder().append(str);
                if (iMBehavior.msgOp.msgType == 49) {
                    str2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.appMsgInnerType), Integer.valueOf(iMBehavior.msgOp.count)});
                } else {
                    str2 = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.count)});
                }
            }
            str = append.append(str2).toString();
            i = 0;
        }
        return str + "," + this.hUo.currChatName_;
    }

    public final boolean JT() {
        if (!this.hasInit) {
            this.hasInit = true;
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100148");
            if (dX.isValid()) {
                this.hUr = bg.getInt((String) dX.bKK().get("needUploadData"), 1);
            }
            dX = com.tencent.mm.u.c.c.Az().dX("100149");
            if (dX.isValid()) {
                this.hUs = bg.getInt((String) dX.bKK().get("needUploadData"), 1);
            }
        }
        return (this.hUr == 0 && this.hUs == 0) ? false : true;
    }
}
