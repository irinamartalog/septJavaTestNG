public class Actor {
    String name;
    String lastname;
    int age;
    public Actor() {
        System.out.println("CONSTRUCTOR CALLED");}

    public Actor(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }



    void play(){
        System.out.println("It is playing!");
    };

    void act (){
        System.out.println("It is acting!");
    };

    void retire(){
        System.out.println("It is retired!");
    };


}
