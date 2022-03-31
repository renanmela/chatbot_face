package com.example.chatbottest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private Matcher matcher;
    private String idade = "(?i)sua idade|(?i)(voc[eê] tem).*idade|(?i)idade.*(voc[eê] tem)|(?i)(voc[eê] tem).*anos|(?i)anos.*(tem voc[eê])|(?i)anos.*(voc[eê] tem)";
    private String nome = "(?i)seu nome|(?i)voc[eê]\\sse\\schama|(?i)nome\\s(tem\\s)voc[eê]|(?i)nome\\svoc[eê]\\stem";
    private String oi = "(?i)oi|(?i)ol[aá]|(?i)esta ai?";
    private String clima = "(?i)clima [em|na|de|no]{2} (cidade de |munic[ií]pio de )*([A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+)?";


    public boolean findMatcher(String message, String regex) {
        this.matcher = Pattern.compile(regex).matcher(message);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public String getAll() { return ".+"; }

    public String getIdade() { return idade; }

    public String getNome() {
        return nome;
    }

    public String getOi() {
        return oi;
    }

    public String getClima() { return clima; }
}
