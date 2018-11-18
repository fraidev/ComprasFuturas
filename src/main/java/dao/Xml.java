/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Felipe Cardozo
 */
public class Xml {

    private static final String caminho = "C:\\tmp\\";

    public static void gravaXml(String nomeArquivo, Object objeto) throws Exception {
        XStream xstream = new XStream();
        String xml = xstream.toXML(objeto);

        File arquivo = new File(caminho + nomeArquivo);
        FileWriter fw = new FileWriter(arquivo);
        fw.write(xml);
        fw.close();
    }

    public static Object leXml(String nomeArquivo) throws Exception {
        String xml = "";
        BufferedReader br = new BufferedReader(new FileReader(caminho + nomeArquivo));
        while (br.ready()) {
            xml += br.readLine() + "\n";
        }
        br.close();

        XStream xstream = new XStream();
        return xstream.fromXML(xml);
    }
}
