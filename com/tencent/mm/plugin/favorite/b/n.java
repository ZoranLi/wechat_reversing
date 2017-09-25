package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class n {
    static void a(String str, rv rvVar) {
        rvVar.tzn.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map q;
                        Node item = childNodes.item(i);
                        String b = bh.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bh.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            q = bh.q(b, "dataitem");
                        } else {
                            q = null;
                        }
                        if (q != null) {
                            rm rmVar = new rm();
                            String str3 = ".dataitem";
                            rmVar.yb(bg.getInt((String) q.get(str3 + ".$datatype"), 0));
                            rmVar.Od((String) q.get(str3 + ".$datasourceid"));
                            rmVar.yc(bg.getInt((String) q.get(str3 + ".$datastatus"), 0));
                            rmVar.NV((String) q.get(str3 + ".datafmt"));
                            rmVar.NL((String) q.get(str3 + ".datatitle"));
                            rmVar.NM((String) q.get(str3 + ".datadesc"));
                            rmVar.NN((String) q.get(str3 + ".cdn_thumburl"));
                            rmVar.NO((String) q.get(str3 + ".cdn_thumbkey"));
                            rmVar.xY(bg.getInt((String) q.get(str3 + ".thumb_width"), 0));
                            rmVar.xZ(bg.getInt((String) q.get(str3 + ".thumb_height"), 0));
                            rmVar.NP((String) q.get(str3 + ".cdn_dataurl"));
                            rmVar.NQ((String) q.get(str3 + ".cdn_datakey"));
                            String str4 = (String) q.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                rmVar.ya(bg.getInt(str4, 0));
                            }
                            rmVar.NS((String) q.get(str3 + ".stream_dataurl"));
                            rmVar.NT((String) q.get(str3 + ".stream_lowbandurl"));
                            rmVar.NR((String) q.get(str3 + ".stream_weburl"));
                            rmVar.Ok((String) q.get(str3 + ".canvasPageXml"));
                            rmVar.NW((String) q.get(str3 + ".fullmd5"));
                            rmVar.NX((String) q.get(str3 + ".head256md5"));
                            str4 = (String) q.get(str3 + ".fullsize");
                            if (!bg.mA(str4)) {
                                rmVar.ej((long) bg.getInt(str4, 0));
                            }
                            rmVar.NU((String) q.get(str3 + ".dataext"));
                            rmVar.Ob((String) q.get(str3 + ".thumbfullmd5"));
                            rmVar.Oc((String) q.get(str3 + ".thumbhead256md5"));
                            str4 = (String) q.get(str3 + ".thumbfullsize");
                            if (!bg.mA(str4)) {
                                rmVar.ek((long) bg.getInt(str4, 0));
                            }
                            rmVar.Oe((String) q.get(str3 + ".stream_videoid"));
                            str4 = (String) q.get(str3 + ".$dataid");
                            if (bg.mA(str4) || str4.length() < 32) {
                                str4 = x.aS(rmVar.toString(), rmVar.aMw);
                            }
                            rmVar.NY(str4);
                            rmVar.Of((String) q.get(str3 + ".datasrctitle"));
                            rmVar.Og((String) q.get(str3 + ".datasrcname"));
                            rmVar.Oh((String) q.get(str3 + ".datasrctime"));
                            rmVar.Oj((String) q.get(str3 + ".statextstr"));
                            rmVar.Oi((String) q.get(str3 + ".$htmlid"));
                            rmVar.yd(bg.getInt((String) q.get(str3 + ".$dataillegaltype"), 0));
                            if (str2 != null) {
                                rmVar.Ol(str2);
                            }
                            rp rpVar = new rp();
                            rpVar.hjD = bg.ap((String) q.get(str3 + ".streamvideo.streamvideourl"), "");
                            rpVar.tyZ = bg.PY((String) q.get(str3 + ".streamvideo.streamvideototaltime"));
                            rpVar.hjF = bg.ap((String) q.get(str3 + ".streamvideo.streamvideotitle"), "");
                            rpVar.hjG = bg.ap((String) q.get(str3 + ".streamvideo.streamvideowording"), "");
                            rpVar.hjH = bg.ap((String) q.get(str3 + ".streamvideo.streamvideoweburl"), "");
                            rpVar.hjJ = bg.ap((String) q.get(str3 + ".streamvideo.streamvideoaduxinfo"), "");
                            rpVar.hjK = bg.ap((String) q.get(str3 + ".streamvideo.streamvideopublishid"), "");
                            rmVar.a(rpVar);
                            rn rnVar = new rn();
                            String str5 = str3 + ".dataitemsource";
                            if (q.containsKey(str5)) {
                                ro roVar = new ro();
                                roVar.ye(bg.getInt((String) q.get(str5 + ".$sourcetype"), 0));
                                roVar.Oo((String) q.get(str5 + ".$sourceid"));
                                roVar.Om((String) q.get(str5 + ".fromusr"));
                                roVar.On((String) q.get(str5 + ".tousr"));
                                roVar.Op((String) q.get(str5 + ".realchatname"));
                                roVar.em(bg.getLong((String) q.get(str5 + ".createtime"), 0));
                                roVar.Oq((String) q.get(str5 + ".msgid"));
                                roVar.fXj = (String) q.get(str5 + ".eventid");
                                roVar.tyT = true;
                                roVar.Or((String) q.get(str5 + ".appid"));
                                roVar.Os((String) q.get(str5 + ".link"));
                                roVar.Ot((String) q.get(str5 + ".brandid"));
                                rnVar.c(roVar);
                            } else {
                                w.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".locitem";
                            if (q.containsKey(str5)) {
                                rs rsVar = new rs();
                                if (!bg.mA((String) q.get(str5 + ".label"))) {
                                    rsVar.Ou((String) q.get(str5 + ".label"));
                                }
                                if (!bg.mA((String) q.get(str5 + ".poiname"))) {
                                    rsVar.Ov((String) q.get(str5 + ".poiname"));
                                }
                                str4 = (String) q.get(str5 + ".lng");
                                if (!bg.mA(str4)) {
                                    rsVar.l(bg.getDouble(str4, 0.0d));
                                }
                                str4 = (String) q.get(str5 + ".lat");
                                if (!bg.mA(str4)) {
                                    rsVar.m(bg.getDouble(str4, 0.0d));
                                }
                                str4 = (String) q.get(str5 + ".scale");
                                if (!bg.mA(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        rsVar.yf(bg.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        rsVar.yf(bg.getInt(str4, -1));
                                    }
                                }
                                rnVar.a(rsVar);
                            } else {
                                w.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".weburlitem";
                            if (q.containsKey(str5)) {
                                sf sfVar = new sf();
                                sfVar.OS((String) q.get(str5 + ".clean_url"));
                                sfVar.OR((String) q.get(str5 + ".pagedesc"));
                                sfVar.OT((String) q.get(str5 + ".pagethumb_url"));
                                sfVar.OQ((String) q.get(str5 + ".pagetitle"));
                                sfVar.yk(bg.getInt((String) q.get(str5 + ".opencache"), 0));
                                sfVar.yl(bg.getInt((String) q.get(str5 + ".contentattr"), 0));
                                sfVar.OU((String) q.get(str5 + ".canvasPageXml"));
                                rnVar.a(sfVar);
                            } else {
                                w.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".productitem";
                            if (q.containsKey(str5)) {
                                ru ruVar = new ru();
                                ruVar.Ow((String) q.get(str5 + ".producttitle"));
                                ruVar.Ox((String) q.get(str5 + ".productdesc"));
                                ruVar.Oy((String) q.get(str5 + ".productthumb_url"));
                                ruVar.Oz((String) q.get(str5 + ".productinfo"));
                                ruVar.yg(bg.getInt((String) q.get(str5 + ".$type"), 0));
                                rnVar.a(ruVar);
                            } else {
                                w.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str3 = str3 + ".tvitem";
                            if (q.containsKey(str3)) {
                                rz rzVar = new rz();
                                rzVar.OM((String) q.get(str3 + ".tvtitle"));
                                rzVar.ON((String) q.get(str3 + ".tvdesc"));
                                rzVar.OO((String) q.get(str3 + ".tvthumb_url"));
                                rzVar.OP((String) q.get(str3 + ".tvinfo"));
                                rnVar.a(rzVar);
                            } else {
                                w.v("MicroMsg.FavDataItemParser", "cur fav not contains %s", new Object[]{str3});
                            }
                            rmVar.a(rnVar);
                            rvVar.tzn.add(rmVar);
                        }
                    }
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.FavProtoItemParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
        }
    }
}
