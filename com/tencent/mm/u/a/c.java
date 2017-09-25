package com.tencent.mm.u.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class c {
    b hoA = null;
    b hoz = null;

    final void gv(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.abtest.AbTestManager", "[Abtest] parse xml faild. xml is null.");
            return;
        }
        w.i("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML content:%s", str);
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("testcase");
            if (elementsByTagName != null) {
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    b bVar = new b();
                    NodeList childNodes = elementsByTagName.item(i).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i2 = 0; i2 < length; i2++) {
                        Node item = childNodes.item(i2);
                        if (item != null && item.getNodeName() != null && item.getNodeName().equals("testpoint")) {
                            NamedNodeMap attributes = item.getAttributes();
                            e eVar = new e();
                            if (attributes != null) {
                                Node namedItem = attributes.getNamedItem(SlookAirButtonFrequentContactAdapter.ID);
                                if (namedItem != null) {
                                    w.d("MicroMsg.abtest.AbTestManager", "[Abtest] idValue:%s", namedItem.getNodeValue());
                                    eVar.id = r9;
                                }
                                Node namedItem2 = attributes.getNamedItem("reportid");
                                if (namedItem2 != null) {
                                    w.d("MicroMsg.abtest.AbTestManager", "[Abtest] reportIdValue:%s", namedItem2.getNodeValue());
                                    eVar.hoB = r7;
                                }
                            }
                            w.d("MicroMsg.abtest.AbTestManager", "[Abtest] casePointContent:%s", item.getTextContent());
                            eVar.value = r6;
                            bVar.hoy.put(eVar.id, eVar);
                        } else if (item == null || item.getNodeName() == null || !item.getNodeName().equals("verifymd5")) {
                            if (item != null) {
                                if (item.getNodeName() != null && item.getNodeName().equals("testcaseid")) {
                                    w.d("MicroMsg.abtest.AbTestManager", "[Abtest] testcaseidContent:%s", item.getTextContent());
                                    bVar.hov = r6;
                                }
                            }
                            if (item != null && item.getNodeName() != null && item.getNodeName().equals("starttime")) {
                                w.d("MicroMsg.abtest.AbTestManager", "[Abtest] starttimeContent:%s", item.getTextContent());
                                bVar.how = r6;
                            } else if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("endtime"))) {
                                w.d("MicroMsg.abtest.AbTestManager", "[Abtest] endtimeContent:%s", item.getTextContent());
                                bVar.hox = r6;
                            }
                        } else {
                            w.d("MicroMsg.abtest.AbTestManager", "[Abtest] verifymd5Content:%s", item.getTextContent());
                            bVar.hou = r6;
                        }
                    }
                    if (bg.mA(bVar.hov) || !"0".equals(bVar.hov)) {
                        this.hoz = bVar;
                    } else {
                        this.hoA = bVar;
                    }
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.abtest.AbTestManager", "[Abtest] parseXML exception:%s", e.toString());
        }
    }

    public final boolean Ac() {
        if (this.hoz == null) {
            return false;
        }
        return true;
    }

    public final e gu(String str) {
        e eVar = null;
        if (this.hoz != null) {
            eVar = this.hoz.gu(str);
        }
        if (eVar != null || this.hoA == null) {
            return eVar;
        }
        return this.hoA.gu(str);
    }
}
