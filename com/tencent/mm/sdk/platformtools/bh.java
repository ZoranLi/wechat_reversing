package com.tencent.mm.sdk.platformtools;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class bh {
    public static ThreadLocal<XmlPullParser> uwn = new ThreadLocal();

    private static class a {
        private XmlPullParser uwo;
        private String uwp;
        private StringBuilder uwq = new StringBuilder();
        private Map<String, String> uwr;
        private Map<Integer, Integer> uws;

        public a(String str, String str2) {
            this.uwp = str2;
            XmlPullParser xmlPullParser = (XmlPullParser) bh.uwn.get();
            this.uwo = xmlPullParser;
            if (xmlPullParser == null) {
                ThreadLocal threadLocal = bh.uwn;
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                this.uwo = newPullParser;
                threadLocal.set(newPullParser);
            }
            this.uwo.setInput(new StringReader(str));
            this.uws = new HashMap();
            this.uwr = new HashMap();
        }

        public final Map<String, String> bKg() {
            int eventType = this.uwo.getEventType();
            while (eventType != 1) {
                int next = this.uwo.next();
                String str;
                if (next == 2) {
                    this.uwq.append('.').append(this.uwo.getName());
                    String stringBuilder = this.uwq.toString();
                    int hashCode = stringBuilder.hashCode();
                    Integer num = (Integer) this.uws.get(Integer.valueOf(hashCode));
                    if (num != null) {
                        num = Integer.valueOf(num.intValue() + 1);
                        this.uwq.append(num);
                        this.uws.put(Integer.valueOf(hashCode), num);
                        str = stringBuilder + num;
                    } else {
                        this.uws.put(Integer.valueOf(hashCode), Integer.valueOf(0));
                        str = stringBuilder;
                    }
                    this.uwr.put(str, "");
                    for (int i = 0; i < this.uwo.getAttributeCount(); i++) {
                        this.uwr.put(str + ".$" + this.uwo.getAttributeName(i), this.uwo.getAttributeValue(i));
                    }
                    eventType = next;
                } else if (next == 4) {
                    str = this.uwo.getText();
                    if (str != null) {
                        this.uwr.put(this.uwq.toString(), str);
                    }
                    eventType = next;
                } else {
                    if (next == 3) {
                        this.uwq = this.uwq.delete(this.uwq.lastIndexOf("."), this.uwq.length());
                        if (this.uwq.length() == 0) {
                            break;
                        }
                    }
                    eventType = next;
                }
            }
            return this.uwr;
        }
    }

    public static Map<String, String> q(String str, String str2) {
        Map<String, String> map = null;
        int indexOf = str == null ? -1 : str.indexOf("<" + str2);
        if (indexOf < 0) {
            w.e("MicroMsg.SDK.XmlParser", "can not find the tag <%s>", str2);
        } else {
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            try {
                map = new a(str, str2).bKg();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SDK.XmlParser", e, "[ %s ]", str);
            }
        }
        return map;
    }

    public static String b(Node node) {
        Writer stringWriter = new StringWriter();
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.transform(new DOMSource(node), new StreamResult(stringWriter));
        } catch (TransformerException e) {
            w.e("MicroMsg.SDK.XmlParser", "nodeToString: %s", e.getMessage());
        }
        return stringWriter.toString();
    }
}
