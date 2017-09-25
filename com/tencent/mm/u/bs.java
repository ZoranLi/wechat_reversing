package com.tencent.mm.u;

import com.tencent.mm.ap.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class bs implements d {
    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null || buVar.tff == null) {
            w.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
        } else {
            w.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(n.a(buVar.tff).getBytes(ProtocolPackage.ServerEncoding))));
                parse.normalize();
                NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("updatepackage");
                if (elementsByTagName != null && elementsByTagName.getLength() == 1) {
                    NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        Node item = childNodes.item(i);
                        if (!(item == null || item.getNodeName() == null || !item.getNodeName().equals("pack"))) {
                            NamedNodeMap attributes = item.getAttributes();
                            if (attributes != null) {
                                item = attributes.getNamedItem(Columns.TYPE);
                                if (item != null) {
                                    h.vH().gXC.a(new k(bg.getInt(item.getNodeValue(), 0)), 0);
                                }
                            }
                        }
                    }
                }
                w.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
            } catch (Throwable e) {
                w.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", bg.g(e));
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
