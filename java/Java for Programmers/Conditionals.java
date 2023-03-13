class Conditionals {
  public static void main(String[] args) {
    int a = 1;
    int b = 2;
    int c = 3;

    boolean statementA = !true;
    boolean statementB = a == c;
    boolean statementC = a + b >= b || c == b;
    boolean statementD = !(true && a == c - b);

    System.out.println(statementA);
    System.out.println(statementB);
    System.out.println(statementC);
    System.out.println(statementD);
  }
}