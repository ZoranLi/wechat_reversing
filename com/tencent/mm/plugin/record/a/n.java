package com.tencent.mm.plugin.record.a;

import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import java.util.List;

public final class n {
    public static String ar(List<rm> list) {
        if (list == null || list.size() == 0) {
            w.w("MicroMsg.RecordMsgParser", "klem toXml data list empty");
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            rm rmVar = (rm) list.get(i);
            stringBuffer.append("<dataitem ");
            if (rmVar.txw) {
                stringBuffer.append("datatype='").append(rmVar.aMw).append("'");
            }
            if (rmVar.txZ) {
                stringBuffer.append(" datastatus='").append(rmVar.txY).append("'");
            }
            if (rmVar.txF) {
                stringBuffer.append(" dataid='").append(rmVar.lKv).append("'");
            }
            if (rmVar.tyl) {
                stringBuffer.append(" htmlid='").append(rmVar.tyk).append("'");
            }
            if (rmVar.tyr) {
                stringBuffer.append(" dataillegaltype='").append(rmVar.tyq).append("'");
            }
            if (rmVar.txR) {
                stringBuffer.append(" datasourceid='").append(rmVar.txQ).append("'");
            }
            stringBuffer.append(">");
            if (rmVar.txy) {
                stringBuffer.append("<datafmt>").append(rmVar.txx).append("</datafmt>");
            }
            if (rmVar.txb) {
                stringBuffer.append("<datatitle>").append(bg.PW(rmVar.title)).append("</datatitle>");
            }
            if (rmVar.txc) {
                stringBuffer.append("<datadesc>").append(bg.PW(rmVar.desc)).append("</datadesc>");
            }
            if (rmVar.txd) {
                stringBuffer.append("<cdnthumburl>").append(bg.PW(rmVar.hhy)).append("</cdnthumburl>");
            }
            if (rmVar.txg) {
                stringBuffer.append("<thumbwidth>").append(rmVar.hhD).append("</thumbwidth>");
            }
            if (rmVar.txh) {
                stringBuffer.append("<thumbheight>").append(rmVar.hhC).append("</thumbheight>");
            }
            if (rmVar.txj) {
                stringBuffer.append("<cdndataurl>").append(bg.PW(rmVar.txi)).append("</cdndataurl>");
            }
            if (rmVar.txf) {
                stringBuffer.append("<cdnthumbkey>").append(bg.PW(rmVar.txe)).append("</cdnthumbkey>");
            }
            if (rmVar.txl) {
                stringBuffer.append("<cdndatakey>").append(bg.PW(rmVar.txk)).append("</cdndatakey>");
            }
            if (rmVar.txn) {
                stringBuffer.append("<cdnencryver>").append(rmVar.txm).append("</cdnencryver>");
            }
            if (rmVar.txo) {
                stringBuffer.append("<duration>").append(rmVar.duration).append("</duration>");
            }
            if (rmVar.txq) {
                stringBuffer.append("<streamweburl>").append(bg.PW(rmVar.txp)).append("</streamweburl>");
            }
            if (rmVar.txs) {
                stringBuffer.append("<streamdataurl>").append(bg.PW(rmVar.txr)).append("</streamdataurl>");
            }
            if (rmVar.txu) {
                stringBuffer.append("<streamlowbandurl>").append(bg.PW(rmVar.txt)).append("</streamlowbandurl>");
            }
            if (rmVar.txv) {
                stringBuffer.append("<dataext>").append(bg.PW(rmVar.fFs)).append("</dataext>");
            }
            if (rmVar.txA) {
                stringBuffer.append("<fullmd5>").append(rmVar.txz).append("</fullmd5>");
            }
            if (rmVar.txC) {
                stringBuffer.append("<head256md5>").append(rmVar.txB).append("</head256md5>");
            }
            if (rmVar.txE) {
                stringBuffer.append("<datasize>").append(rmVar.txD).append("</datasize>");
            }
            if (rmVar.txL) {
                stringBuffer.append("<thumbfullmd5>").append(rmVar.txK).append("</thumbfullmd5>");
            }
            if (rmVar.txN) {
                stringBuffer.append("<thumbhead256md5>").append(rmVar.txM).append("</thumbhead256md5>");
            }
            if (rmVar.txP) {
                stringBuffer.append("<thumbsize>").append(rmVar.txO).append("</thumbsize>");
            }
            if (rmVar.txT) {
                stringBuffer.append("<streamvideoid>").append(bg.PW(rmVar.txS)).append("</streamvideoid>");
            }
            if (rmVar.tyb) {
                stringBuffer.append("<sourcetitle>").append(bg.PW(rmVar.tya)).append("</sourcetitle>");
            }
            if (rmVar.tyf) {
                stringBuffer.append("<sourcename>").append(bg.PW(rmVar.tye)).append("</sourcename>");
            }
            if (rmVar.tyh) {
                stringBuffer.append("<sourcetime>").append(bg.PW(rmVar.tyg)).append("</sourcetime>");
            }
            if (rmVar.tym) {
                stringBuffer.append("<statextstr>").append(bg.PW(rmVar.fUY)).append("</statextstr>");
            }
            if (rmVar.tyt) {
                stringBuffer.append("<recordxml>").append(rmVar.tys).append("</recordxml>");
            }
            rn rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyu == null || rnVar.tyu.aUk() == 0) {
                w.w("MicroMsg.RecordMsgParser", "klem toXml, data source item empty");
            } else {
                ro roVar = rnVar.tyu;
                if (roVar.tyU) {
                    stringBuffer.append("<appid>").append(roVar.appId).append("</appid>");
                }
                if (roVar.tyV) {
                    stringBuffer.append("<link>").append(bg.PW(roVar.hSX)).append("</link>");
                }
                if (roVar.tyY) {
                    stringBuffer.append("<brandid>").append(bg.PW(roVar.fCJ)).append("</brandid>");
                }
                if (roVar.tyM && roVar.tyR) {
                    if (roVar.fOu.equals(roVar.tyQ)) {
                        stringBuffer.append("<dataitemsource><fromusr>").append(bg.PW(roVar.fOu)).append("</fromusr></dataitemsource>");
                    } else if (o.dH(roVar.fOu) || e.ir(roVar.tyQ)) {
                        stringBuffer.append("<dataitemsource><realchatname>").append(bg.PW(roVar.tyQ)).append("</realchatname></dataitemsource>");
                    }
                } else if (roVar.tyM) {
                    stringBuffer.append("<dataitemsource><fromusr>").append(bg.PW(roVar.fOu)).append("</fromusr></dataitemsource>");
                } else if (roVar.tyR) {
                    stringBuffer.append("<dataitemsource><realchatname>").append(bg.PW(roVar.tyQ)).append("</realchatname></dataitemsource>");
                }
            }
            rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyw == null || rnVar.tyw.aUk() == 0) {
                w.w("MicroMsg.RecordMsgParser", "klem toXml, loc item empty");
            } else {
                rs rsVar = rnVar.tyw;
                stringBuffer.append("<locitem>");
                if (rsVar.tzg) {
                    stringBuffer.append("<label>").append(bg.PW(rsVar.label)).append("</label>");
                }
                if (rsVar.tze) {
                    stringBuffer.append("<lat>").append(rsVar.lat).append("</lat>");
                }
                if (rsVar.tzd) {
                    stringBuffer.append("<lng>").append(rsVar.lng).append("</lng>");
                }
                if (rsVar.tzf) {
                    stringBuffer.append("<scale>").append(rsVar.fOd).append("</scale>");
                }
                if (rsVar.tzh) {
                    stringBuffer.append("<poiname>").append(rsVar.fRX).append("</poiname>");
                }
                stringBuffer.append("</locitem>");
            }
            rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyy == null || rnVar.tyy.aUk() == 0) {
                w.w("MicroMsg.RecordMsgParser", "klem toXml, url item empty");
            } else {
                sf sfVar = rnVar.tyy;
                stringBuffer.append("<weburlitem>");
                if (sfVar.tzO) {
                    stringBuffer.append("<link>").append(bg.PW(sfVar.tzN)).append("</link>");
                }
                if (sfVar.txc) {
                    stringBuffer.append("<desc>").append(bg.PW(sfVar.desc)).append("</desc>");
                }
                if (sfVar.tzi) {
                    stringBuffer.append("<thumburl>").append(bg.PW(sfVar.thumbUrl)).append("</thumburl>");
                }
                if (sfVar.txb) {
                    stringBuffer.append("<title>").append(bg.PW(sfVar.title)).append("</title>");
                }
                if (sfVar.tzQ) {
                    stringBuffer.append("<opencache>").append(sfVar.tzP).append("</opencache>");
                }
                if (sfVar.tzR) {
                    stringBuffer.append("<contentattr>").append(sfVar.hhv).append("</contentattr>");
                }
                stringBuffer.append("</weburlitem>");
            }
            rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyA == null || rnVar.tyA.aUk() == 0) {
                w.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                ru ruVar = rnVar.tyA;
                stringBuffer.append("<productitem");
                if (ruVar.tzk) {
                    stringBuffer.append(" type='").append(ruVar.type).append("'");
                }
                stringBuffer.append(">");
                if (ruVar.txb) {
                    stringBuffer.append("<title>").append(bg.PW(ruVar.title)).append("</title>");
                }
                if (ruVar.txc) {
                    stringBuffer.append("<desc>").append(bg.PW(ruVar.desc)).append("</desc>");
                }
                if (ruVar.tzi) {
                    stringBuffer.append("<thumburl>").append(bg.PW(ruVar.thumbUrl)).append("</thumburl>");
                }
                if (ruVar.tzj) {
                    stringBuffer.append("<productinfo>").append(bg.PW(ruVar.info)).append("</productinfo>");
                }
                stringBuffer.append("</productitem>");
            }
            rn rnVar2 = rmVar.tyc;
            if (rnVar2 == null || rnVar2.tyC == null || rnVar2.tyC.aUk() == 0) {
                w.w("MicroMsg.RecordMsgParser", "klem toXml, product item empty");
            } else {
                rz rzVar = rnVar2.tyC;
                stringBuffer.append("<tvitem>");
                if (rzVar.txb) {
                    stringBuffer.append("<title>").append(bg.PW(rzVar.title)).append("</title>");
                }
                if (rzVar.txc) {
                    stringBuffer.append("<desc>").append(bg.PW(rzVar.desc)).append("</desc>");
                }
                if (rzVar.tzi) {
                    stringBuffer.append("<thumburl>").append(bg.PW(rzVar.thumbUrl)).append("</thumburl>");
                }
                if (rzVar.tzj) {
                    stringBuffer.append("<tvinfo>").append(bg.PW(rzVar.info)).append("</tvinfo>");
                }
                stringBuffer.append("</tvitem>");
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
