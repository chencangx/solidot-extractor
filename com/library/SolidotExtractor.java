package com.library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class SolidotExtractor {
  public static void main(String[] args) throws InterruptedException, IOException {
    BufferedWriter bw =
        new BufferedWriter(new FileWriter("C:/Users/Administrator/Desktop/3.html", true));
    int i = 8000;
    for (; i < 8200; i++) {
      URL url = new URL("https://www.solidot.org/story/story_pn/" + Integer.toString(i));
      String s = IOUtils.toString(url.openStream());
      s = s.replace("document.write(\"«&nbsp;", "");
      s = s.replace("\");document.write(\" | \");document.write(\"", "");
      s = s.replace("&nbsp;»\");", "");
      s = s.replace("</a>", "<br/>");
      s = s.replace("/story", "https://www.solidot.org/story");
      bw.write(s);
      System.out.println(i);
      // System.out.print("\r");
      // System.out.println(s);
    }
    StringBuilder sb = new StringBuilder("1233");
    bw.close();
  }
}
