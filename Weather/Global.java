import main.Main;
public class Global {
    public Global() {
        Main main = new Main(this.getClass());
    }
    public static void main(String[] args) {
        new Global();
    }
}
