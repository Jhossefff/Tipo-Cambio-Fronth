package com.empresa.pfdesarrollo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;

@Service
public class TipoCambioService {

    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    public TipoCambioService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public String obtenerTipoCambio() {
        String soapRequest = """
                <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
                    <soap:Body>
                        <TipoCambioDiaString xmlns="http://www.banguat.gob.gt/variables/ws/" />
                    </soap:Body>
                </soap:Envelope>
                """;

        StreamSource request = new StreamSource(new StringReader(soapRequest));
        DOMSource response = (DOMSource) webServiceTemplate.sendSourceAndReceive("https://www.banguat.gob.gt/variables/ws/TipoCambio.asmx", request, null);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(response.getNode().getTextContent())));

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            String tipoCambio = (String) xpath.evaluate("//TipoCambioDiaStringResult", doc, XPathConstants.STRING);

            return tipoCambio;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
