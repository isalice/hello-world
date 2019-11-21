package ch.css.testip;

import ch.css.testip.domain.*;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {
    public static void main(String[] args){
        Perso perso = new Perso();
        perso.setAgefordertElementBeschreibung("der Haushaltversicherung der CSS");
        perso.setAlteTemplateName("shv_notifikation");
        perso.setAngefordertElement("eine SHV-Offerte");
        perso.setKampagne("\"Bonus\"");
        perso.setOpportunitaetName("eine SHV Opportunität");
        MetaData metaData = new MetaData();
        PumaAnzeige pumaAnzeige = new PumaAnzeige();
        Attachment attachment = null;

        Kontext kontext = new Kontext(metaData, perso, pumaAnzeige, attachment);

        jaxbObjectToXML(kontext);

        Anzeige anzeige = new PumaAnzeige();
        anzeige = new Anzeige();
        attachment = new Attachment();
        kontext = new Kontext(metaData, perso, anzeige, attachment);

        jaxbObjectToXML(kontext);

        RtEvent rtEvent = new RtEvent();
        rtEvent.setKontext(kontext);

        jaxbObjectToXML(rtEvent);
    }

    private static void jaxbObjectToXML(Kontext kontext)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(Kontext.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(kontext, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void jaxbObjectToXML(RtEvent rtEvent)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(RtEvent.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(rtEvent, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
