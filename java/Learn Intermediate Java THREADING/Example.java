import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {

  public static void main(String[] args) {
    String[] strings = {"CCQQ", "QQCC", "CQQ", "QUACK", "CCQ", "CQC", "CQQQ", "CCCQQ"};
    Pattern pattern = Pattern.compile("C+Q{2}");
  
    for(String s: strings){
      Matcher matcher = pattern.matcher(s);
      System.out.println(matcher.matches());
    }
  }
}