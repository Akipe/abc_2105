package poo.introduction;

public class Animal {
    private String specie;

    public Animal()
    {
        System.out.println("Constructeur de Animal.");

        this.specie = "Cheval";
    }

    public  String getSpecie()
    {
        return this.specie;
    }

    public void setSpecie(String _toto)
    {
        if  (_toto.length() > 2) {
            this.specie = _toto;
        }
    }
}
