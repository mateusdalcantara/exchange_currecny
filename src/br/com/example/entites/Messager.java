package br.com.example.entites;

public class Messager {
    public String menuOptions(){
        String menu = """
                
                1 - Exchange BRL to USD.
                2 - Exchange USD to BRL.
                3 - Exchange BRL to JPY.
                4 - Exchange JPY to BRL.
                5 - Exchange BRL to EUR.
                6 - Exchange EUR to BRL.
                7 - Exchange BRL to GBP.
                8 - Exchange GBP to BRL.
                9 - Exit.
                
                """;
        return menu;
    }
}
