package com.tencent.mm.plugin.emoji.g;

import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class b {
    public static ArrayList<ov> ux(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("EmojiMd5");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<ov> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                Node item = elementsByTagName.item(i);
                ov ovVar = new ov();
                String toLowerCase = item.getTextContent().toLowerCase();
                NamedNodeMap attributes = item.getAttributes();
                Node namedItem = attributes.getNamedItem("thumburl");
                if (namedItem != null) {
                    ovVar.ohq = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("cdnurl");
                if (namedItem != null) {
                    ovVar.msN = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("productid");
                if (namedItem != null) {
                    ovVar.tgW = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("designerid");
                if (namedItem != null) {
                    ovVar.tuq = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("aeskey");
                if (namedItem != null) {
                    ovVar.tus = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem("encrypturl");
                if (namedItem != null) {
                    ovVar.tur = namedItem.getNodeValue();
                }
                item = attributes.getNamedItem("activityid");
                if (item != null) {
                    ovVar.tuv = item.getNodeValue();
                }
                ovVar.tup = toLowerCase;
                arrayList.add(ovVar);
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static ArrayList<String> uy(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.emoji.EmojiBackupXMLParser", "[backup emotion parser] parse xml faild. xml is null.");
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("ProductID");
            if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList();
            int length = elementsByTagName.getLength();
            for (int i = 0; i < length; i++) {
                arrayList.add(elementsByTagName.item(i).getTextContent());
            }
            return arrayList;
        } catch (Exception e) {
            w.e("MicroMsg.emoji.EmojiBackupXMLParser", "[parser] parseXML exception:%s", new Object[]{e.toString()});
            return null;
        }
    }
}
